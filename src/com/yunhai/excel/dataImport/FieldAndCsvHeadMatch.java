package com.yunhai.excel.dataImport;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import com.itheima.user.orm.YunhaiUser;
import com.yunhai.excel.orm.CsvHeader;
import com.yunhai.excel.orm.DataTypeDimension;
import com.yunhai.excel.orm.FieldAndCsvHeardName;

/**
 * Servlet implementation class FieldAndCsvHeadMatch
 */
@WebServlet("/fieldAndCsvHeadMatch")
public class FieldAndCsvHeadMatch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		List<FieldAndCsvHeardName> fieldAndCsvHeardList = new ArrayList<FieldAndCsvHeardName>();
		fieldAndCsvHeardList
				.add(new FieldAndCsvHeardName("fieldRecord01", "字段1", "fieldName1", "datType1", "申请单号"));
		fieldAndCsvHeardList
				.add(new FieldAndCsvHeardName("fieldRecord02", "字段2", "fieldName2", "datType2", "创建人员"));
		fieldAndCsvHeardList
				.add(new FieldAndCsvHeardName("fieldRecord03", "字段3", "fieldName3", "datType4", "序号"));
		fieldAndCsvHeardList
				.add(new FieldAndCsvHeardName("fieldRecord04", "字段4", "fieldName4", "datType3", "审批人"));
		List<DataTypeDimension> dataTypeDimList = new ArrayList<DataTypeDimension>();
		dataTypeDimList.add(new DataTypeDimension(
				"datType1","字符串","String","VARCHAR2",0,"可变长字符串"
				));
		dataTypeDimList.add(new DataTypeDimension(
				"datType2","字符串","String","NVARCHAR2",1,"支持中文的可变长字符串"
				));
		dataTypeDimList.add(new DataTypeDimension(
				"datType3","整数","Integer","VARCHAR2",2,"整数"
				));
		dataTypeDimList.add(new DataTypeDimension(
				"datType4","浮点数","Double","NUMBER",3,"浮点数"
				));
		dataTypeDimList.add(new DataTypeDimension(
				"datType5","布尔型","Boolean","NUMBER",4,"布尔型"
				));
		dataTypeDimList.add(new DataTypeDimension(
				"datType6","日期","java.util.Date","DATE",5,"日期"
				));
		dataTypeDimList.add(new DataTypeDimension(
				"datType7","时间戳","java.sql.Timestamp","TIMESTAMP",6,"时间戳"
				)); 
		String filePathStr = getServletContext().getRealPath("/userFile/excel")+"/2020年报废数据.csv";
		//String filePathStr= "D:/2020年报废数据.csv";
		request.setAttribute("fieldList", fieldAndCsvHeardList);
		request.setAttribute("dataTypeList", dataTypeDimList);
		request.setAttribute("CsvHeaderList", getCSVHeader(filePathStr));
	    
		// 转发
		request.getRequestDispatcher("/dataImport/fieldAndCsvHeadMatch.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	public List<CsvHeader>  getCSVHeader(String filePathStr) throws IOException {
		File csv = new File(filePathStr);

		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		//System.out.println("filePathStr=" + filePathStr);
		Iterable<CSVRecord> records;
		/*
		 * CSVFormat.RFC4180.parse(in)方法读取csv文件中包括表头的所有数据。
		 * CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in);方法则是将第一行视为表头不读取。
		 */
		records = CSVFormat.RFC4180.parse(in);
		int recordI = 1;
		/**
		 * 正面的部分读取csv文件的表头部分。
		 */
		Iterator<CSVRecord> iterator = records.iterator();
		CSVRecord record = iterator.next();

		List<CsvHeader> csvHeaderList =new ArrayList<CsvHeader>();
		for (int vI = 0; vI < record.size(); vI++) {
			System.out.println(vI + ":" + record.get(vI));
			CsvHeader csvHeader=new CsvHeader();
			csvHeader.setCsvHeaderValue(record.get(vI));
			csvHeader.setIndexof(vI);
			csvHeader.setCsvHeaderName(record.get(vI));
			csvHeaderList.add(csvHeader);
		}
		/**
		 * 下面的部分读取csv文件的表头部分。下面是旧方法。
		 */
		/*
		 * for (CSVRecord record : records) { if (recordI == 1) {
		 * 
		 * System.out.println("1:" + record.toString());// 打印整行内容 for (int vI = 0; vI <
		 * record.size(); vI++) { System.out.println(vI + ":" + record.get(vI)); }
		 * System.out.println("2:" + record.size());// 打印本行有多少个值 System.out.println("3:"
		 * + record.getRecordNumber());// 打印本行行数 System.out.println("4:" +
		 * record.get(0));// 按索引返回对应值 System.out.println("recordI:" + recordI);//
		 * 按索引返回对应值 // System.out.println(record.get("id"));//按名称返回对应值 recordI++; break;
		 * } }
		 */
		/*
		 * 正面的部分读取csv文件中的非表头部分的数据
		 */
		/*
		 * Iterator<CSVRecord> iterator = records.iterator(); while (iterator.hasNext())
		 * { CSVRecord csvRecord = iterator.next();
		 * 
		 * System.out.println(csvRecord.get(0)); }
		 */
		// 关闭输入流
		in.close();
		return csvHeaderList;
	}
}
