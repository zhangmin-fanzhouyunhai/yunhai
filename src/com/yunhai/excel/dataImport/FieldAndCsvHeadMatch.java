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
				.add(new FieldAndCsvHeardName("fieldRecord01", "�ֶ�1", "fieldName1", "datType1", "���뵥��"));
		fieldAndCsvHeardList
				.add(new FieldAndCsvHeardName("fieldRecord02", "�ֶ�2", "fieldName2", "datType2", "������Ա"));
		fieldAndCsvHeardList
				.add(new FieldAndCsvHeardName("fieldRecord03", "�ֶ�3", "fieldName3", "datType4", "���"));
		fieldAndCsvHeardList
				.add(new FieldAndCsvHeardName("fieldRecord04", "�ֶ�4", "fieldName4", "datType3", "������"));
		List<DataTypeDimension> dataTypeDimList = new ArrayList<DataTypeDimension>();
		dataTypeDimList.add(new DataTypeDimension(
				"datType1","�ַ���","String","VARCHAR2",0,"�ɱ䳤�ַ���"
				));
		dataTypeDimList.add(new DataTypeDimension(
				"datType2","�ַ���","String","NVARCHAR2",1,"֧�����ĵĿɱ䳤�ַ���"
				));
		dataTypeDimList.add(new DataTypeDimension(
				"datType3","����","Integer","VARCHAR2",2,"����"
				));
		dataTypeDimList.add(new DataTypeDimension(
				"datType4","������","Double","NUMBER",3,"������"
				));
		dataTypeDimList.add(new DataTypeDimension(
				"datType5","������","Boolean","NUMBER",4,"������"
				));
		dataTypeDimList.add(new DataTypeDimension(
				"datType6","����","java.util.Date","DATE",5,"����"
				));
		dataTypeDimList.add(new DataTypeDimension(
				"datType7","ʱ���","java.sql.Timestamp","TIMESTAMP",6,"ʱ���"
				)); 
		String filePathStr = getServletContext().getRealPath("/userFile/excel")+"/2020�걨������.csv";
		//String filePathStr= "D:/2020�걨������.csv";
		request.setAttribute("fieldList", fieldAndCsvHeardList);
		request.setAttribute("dataTypeList", dataTypeDimList);
		request.setAttribute("CsvHeaderList", getCSVHeader(filePathStr));
	    
		// ת��
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
		 * CSVFormat.RFC4180.parse(in)������ȡcsv�ļ��а�����ͷ���������ݡ�
		 * CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in);�������ǽ���һ����Ϊ��ͷ����ȡ��
		 */
		records = CSVFormat.RFC4180.parse(in);
		int recordI = 1;
		/**
		 * ����Ĳ��ֶ�ȡcsv�ļ��ı�ͷ���֡�
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
		 * ����Ĳ��ֶ�ȡcsv�ļ��ı�ͷ���֡������Ǿɷ�����
		 */
		/*
		 * for (CSVRecord record : records) { if (recordI == 1) {
		 * 
		 * System.out.println("1:" + record.toString());// ��ӡ�������� for (int vI = 0; vI <
		 * record.size(); vI++) { System.out.println(vI + ":" + record.get(vI)); }
		 * System.out.println("2:" + record.size());// ��ӡ�����ж��ٸ�ֵ System.out.println("3:"
		 * + record.getRecordNumber());// ��ӡ�������� System.out.println("4:" +
		 * record.get(0));// ���������ض�Ӧֵ System.out.println("recordI:" + recordI);//
		 * ���������ض�Ӧֵ // System.out.println(record.get("id"));//�����Ʒ��ض�Ӧֵ recordI++; break;
		 * } }
		 */
		/*
		 * ����Ĳ��ֶ�ȡcsv�ļ��еķǱ�ͷ���ֵ�����
		 */
		/*
		 * Iterator<CSVRecord> iterator = records.iterator(); while (iterator.hasNext())
		 * { CSVRecord csvRecord = iterator.next();
		 * 
		 * System.out.println(csvRecord.get(0)); }
		 */
		// �ر�������
		in.close();
		return csvHeaderList;
	}
}
