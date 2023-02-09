package com.yunhai.excel;
 
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import com.yunhai.db.util.DbUtil;
import com.yunhai.excel.orm.DvArea;
import com.yunhai.excel.orm.ReportTableFieldColumn;
 	

public class ReportOutput2 {
	private static final String EXCEL_XLS = "xls";
	private static final String EXCEL_XLSX = "xlsx";

	public static void main(String[] args) throws SQLException {

		// TODO Auto-generated method stub
		// String filePath = "D:/temp/hubei/test-20190620.xlsx";
		// String templateFileName = "电网实物资产分析评价数据收集表-2018";
		// String templateFileName = "电网实物资产分析评价数据收集表-2019-规模为全结构";
		// String templateFileName = "电网实物资产分析评价数据收集表-2019";
		// String templateFileName = "电网实物资产分析评价数据收集表-2020";
		String templateFileName = "电网实物资产分析评价数据收集表-2020-V1.0";
		templateFileName = "电网实物资产分析评价数据收集表-2020-V1.2";
		String dataVersion2="";
		//reportOutputTest(templateFileName);
		// 		
		String rootPath =System.getProperty("user.dir")+"\\WebRoot\\userFile\\excel";
		// reportOutputAll( templateFileName,rootPath);
		System.out.println("rootPath="+rootPath);
		//rootPath=ReportOutput.class.getResource(rootPath+"/WebRoot/userFile").getPath();
		System.out.println("rootPath="+rootPath); 
		System.out.println("rootPath="+Thread.currentThread().getContextClassLoader().getResource(""));
		String reportAssetemplateId="REPORT_ASSET_CLASS_TEMPLATE_001";
		String reportId="";
		String reportName = "A.1 规模结构";
		String sheetName="A.1 规模结构";
		String voltageRelationCode="10010";
		int startRowNumber = 0;
		int startColumnNumber = 0;
		//
		String dataVersion = "M_2019_8";// 20200613
		//String appointedColumn = "NET_VALUE";
		// 循环输出表格中的内容,首先循环取出行,再根据行循环取出列
		startRowNumber = 4;
		startColumnNumber = 1; 
		//reportOutputHealth( templateFileName,rootPath,sheetName,reportId,reportAssetemplateId, voltageRelationCode,dataVersion,startRowNumber,startColumnNumber);
		reportAssetemplateId="REPORT_ASSET_CLASS_TEMPLATE_003";
		sheetName="B.5.1 健康状态统计表2019";
		reportName = "B.5.1 健康状态统计表2019";
		voltageRelationCode="10016";
		// dataVersion ="M_2019_3";
		// dataVersion = "M_2019_4";
		//dataVersion = "M_2019_6";// 20210615
		//
		dataVersion = "M_2019_7";// 20210616
		//String appointedColumn = "NET_VALUE";
		// 循环输出表格中的内容,首先循环取出行,再根据行循环取出列 
		startRowNumber = 3;
		startColumnNumber = 2; 
		//reportOutputHealth( templateFileName,rootPath,sheetName,reportId,reportAssetemplateId, voltageRelationCode,dataVersion,startRowNumber,startColumnNumber);
		

		reportAssetemplateId="REPORT_ASSET_CLASS_TEMPLATE_004";
		sheetName="B.5.1 健康状态统计表2020";
		reportName = "A.1 资产结构-价值规模";
		voltageRelationCode="10015"; 
		//
		dataVersion = "M_2020_6";// 20200613
		//String appointedColumn = "NET_VALUE";
		// 循环输出表格中的内容,首先循环取出行,再根据行循环取出列 
		startRowNumber = 4;
		startColumnNumber = 2; 
		//reportOutputHealth( templateFileName,rootPath,sheetName,reportName,reportAssetemplateId, voltageRelationCode,dataVersion,startRowNumber,startColumnNumber);
		dataVersion = "M_2020_6";// 20210616
		startRowNumber = 3;
		startColumnNumber = 2; 
		//String appointedColumn = "NET_VALUE";
		// 循环输出表格中的内容,首先循环取出行,再根据行循环取出列 
		//String fileName="电网实物资产分析评价数据收集表-2020-V1.2-Fault-D.5.xls";
		//String fileName="电网实物资产分析评价数据收集表-2020-V1.2-Fault-D.4.xls";
		//String fileName="电网实物资产分析评价数据收集表-2019-V1.2-A.1.xls";
		templateFileName = "电网实物资产分析评价数据收集表-2019-V1.2-A.1";
		reportId="REPORT_01";
		sheetName="A.1规模结构";
		reportName = "A.1 资产结构-价值规模";
		reportId="REPORT_14";
		reportAssetemplateId="REPORT_ASSET_CLASS_TEMPLATE_001";
		String reportQuerySqlId="REPORT_QUERY_SQL_00005"; 
		dataVersion = "M_2019_10"; //MID_ASSET_VALUE
		voltageRelationCode="10010";
		startRowNumber = 4;
		startColumnNumber = 1;
		//reportOutputComment( templateFileName,rootPath,sheetName,reportId,reportQuerySqlId,reportAssetemplateId, voltageRelationCode,dataVersion,startRowNumber,startColumnNumber);
		
		templateFileName = "电网实物资产分析评价数据收集表-2020-V1.2-A.1";
		sheetName="A.1规模结构";
		reportName = "A.1 资产结构-价值规模";
		reportId="REPORT_01";
		reportAssetemplateId="REPORT_ASSET_CLASS_TEMPLATE_002";
		reportQuerySqlId="REPORT_QUERY_SQL_00005"; 
		dataVersion = "M_2020_6"; //MID_ASSET_VALUE
		voltageRelationCode="10015";
		startRowNumber = 4;
		startColumnNumber = 1;
		//reportOutputComment( templateFileName,rootPath,sheetName,reportId,reportQuerySqlId,reportAssetemplateId, voltageRelationCode,dataVersion,startRowNumber,startColumnNumber);
			
		templateFileName = "电网实物资产分析评价数据收集表-2019-V1.2-A.1-Qantity";
		sheetName="A.2 资产结构-数量规模";
		reportName = "A.2 资产结构-数量规模";
		reportId="REPORT_02";
		reportAssetemplateId="REPORT_ASSET_CLASS_TEMPLATE_001";
		reportQuerySqlId="REPORT_QUERY_SQL_00006"; 
		dataVersion = "M_2019_8"; //MID_ASSET_AMOUNT_PMS
		voltageRelationCode="10010";
		startRowNumber = 4;
		startColumnNumber = 1;
		//reportOutputComment( templateFileName,rootPath,sheetName,reportId,reportQuerySqlId,reportAssetemplateId, voltageRelationCode,dataVersion,startRowNumber,startColumnNumber);
		
		templateFileName = "电网实物资产分析评价数据收集表-2020-V1.2-A.1-Qantity";
		sheetName="A.2 资产结构-数量规模";
		reportName = "A.2 资产结构-数量规模";
		reportId="REPORT_02";
		reportAssetemplateId="REPORT_ASSET_CLASS_TEMPLATE_002";
		reportQuerySqlId="REPORT_QUERY_SQL_00006"; 
		dataVersion = "M_2020_8"; //MID_ASSET_AMOUNT_PMS
		voltageRelationCode="10015";
		startRowNumber = 4;
		startColumnNumber = 1;
		//reportOutputComment( templateFileName,rootPath,sheetName,reportId,reportQuerySqlId,reportAssetemplateId, voltageRelationCode,dataVersion,startRowNumber,startColumnNumber);
		
		templateFileName = "电网实物资产分析评价数据收集表-2019-V1.2-A.3.2-Qantity";
		sheetName="A.3.2资产结构-年龄结构（数量）";
		reportName = "A.3.2资产结构-年龄结构（数量）";
		reportId="REPORT_14";
		reportAssetemplateId="REPORT_ASSET_CLASS_TEMPLATE_001";
		reportQuerySqlId="REPORT_QUERY_SQL_00007"; 
		dataVersion = "M_2019_8"; //MID_ASSET_AMOUNT_PMS
		voltageRelationCode="10010";
		startRowNumber = 4;
		startColumnNumber = 2;
		//reportOutputComment( templateFileName,rootPath,sheetName,reportId,reportQuerySqlId,reportAssetemplateId, voltageRelationCode,dataVersion,startRowNumber,startColumnNumber);
		
		
		templateFileName = "电网实物资产分析评价数据收集表-2020-V1.2-A.3.2-Qantity";
		sheetName="A.3.2资产结构-年龄结构（数量）";
		reportName = "A.3.2资产结构-年龄结构（数量）";
		reportId="REPORT_14";
		reportAssetemplateId="REPORT_ASSET_CLASS_TEMPLATE_002";
		reportQuerySqlId="REPORT_QUERY_SQL_00007"; 
		dataVersion = "M_2020_8"; //MID_ASSET_AMOUNT_PMS
		voltageRelationCode="10015";
		startRowNumber = 4;
		startColumnNumber = 2;
		//reportOutputComment( templateFileName,rootPath,sheetName,reportId,reportQuerySqlId,reportAssetemplateId, voltageRelationCode,dataVersion,startRowNumber,startColumnNumber);
		

		templateFileName = "电网实物资产分析评价数据收集表-2019-V1.2-A.2.1";
		sheetName="A.2.1资产年龄结构（价值）";
		reportName = "A.2.1资产年龄结构（价值）";
		reportId="REPORT_15";
		reportAssetemplateId="REPORT_ASSET_CLASS_TEMPLATE_001";
		reportQuerySqlId="REPORT_QUERY_SQL_00008"; 
		dataVersion = "M_2019_10"; //MID_ASSET_VALUE
		voltageRelationCode="10010";
		startRowNumber = 4;
		startColumnNumber = 2;
		//reportOutputComment( templateFileName,rootPath,sheetName,reportId,reportQuerySqlId,reportAssetemplateId, voltageRelationCode,dataVersion,startRowNumber,startColumnNumber);
		
		
		templateFileName = "电网实物资产分析评价数据收集表-2020-V1.2-A.2.1";
		sheetName="A.2.1资产年龄结构（价值）";
		reportName = "A.2.1资产年龄结构（价值）";
		reportId="REPORT_15";
		reportAssetemplateId="REPORT_ASSET_CLASS_TEMPLATE_002";
		reportQuerySqlId="REPORT_QUERY_SQL_00008"; 
		dataVersion = "M_2020_6"; //MID_ASSET_VALUE
		voltageRelationCode="10015";
		startRowNumber = 4;
		startColumnNumber = 2;
		//reportOutputComment( templateFileName,rootPath,sheetName,reportId,reportQuerySqlId,reportAssetemplateId, voltageRelationCode,dataVersion,startRowNumber,startColumnNumber);
		 
		templateFileName = "电网实物资产分析评价数据收集表-2020-V1.2-F.3 利用效率-资产利用状态（数量）";
		sheetName="F.3 利用效率-资产利用状态";
		reportName = "F.3 利用效率-资产利用状态";
		reportId="REPORT_16";
		reportAssetemplateId="REPORT_ASSET_CLASS_TEMPLATE_002";
		reportQuerySqlId="REPORT_QUERY_SQL_00009"; 
		dataVersion = "M_2020_8"; //MID_ASSET_AMOUNT_PMS
		dataVersion2 = "M_2020_6"; //MID_ASSET_VALUE
		voltageRelationCode="10015";
		startRowNumber = 4;
		startColumnNumber = 2;
		//reportOutputComment( templateFileName,rootPath,sheetName,reportId,reportQuerySqlId,reportAssetemplateId, voltageRelationCode,dataVersion,dataVersion2,startRowNumber,startColumnNumber);

		templateFileName = "电网实物资产分析评价数据收集表-2020-V1.2-F.3 利用效率-资产利用状态（技术）";
		sheetName="F.3 利用效率-资产利用状态";
		reportName = "F.3 利用效率-资产利用状态";
		reportId="REPORT_16";
		reportAssetemplateId="REPORT_ASSET_CLASS_TEMPLATE_002";
		reportQuerySqlId="REPORT_QUERY_SQL_00010"; 
		dataVersion = "M_2020_8"; //MID_ASSET_AMOUNT_PMS
		dataVersion2 = "M_2020_6"; //MID_ASSET_VALUE
		voltageRelationCode="10015";
		startRowNumber = 4;
		startColumnNumber = 2;
		//reportOutputComment( templateFileName,rootPath,sheetName,reportId,reportQuerySqlId,reportAssetemplateId, voltageRelationCode,dataVersion,dataVersion2,startRowNumber,startColumnNumber);
		

		templateFileName = "电网实物资产分析评价数据收集表-2019-V1.2-F.3 利用效率-资产利用状态（数量）";
		sheetName="F.3 利用效率-资产利用状态";
		reportName = "F.3 利用效率-资产利用状态";
		reportId="REPORT_16";
		reportAssetemplateId="REPORT_ASSET_CLASS_TEMPLATE_001";
		reportQuerySqlId="REPORT_QUERY_SQL_00009"; 
		dataVersion = "M_2019_8"; //MID_ASSET_AMOUNT_PMS
		dataVersion2 = "M_2019_10"; //MID_ASSET_VALUE
		voltageRelationCode="10010";
		startRowNumber = 4;
		startColumnNumber = 2;
		//reportOutputComment( templateFileName,rootPath,sheetName,reportId,reportQuerySqlId,reportAssetemplateId, voltageRelationCode,dataVersion,dataVersion2,startRowNumber,startColumnNumber);

		templateFileName = "电网实物资产分析评价数据收集表-2019-V1.2-F.3 利用效率-资产利用状态（技术）";
		sheetName="F.3 利用效率-资产利用状态";
		reportName = "F.3 利用效率-资产利用状态";
		reportId="REPORT_16";
		reportAssetemplateId="REPORT_ASSET_CLASS_TEMPLATE_001";
		reportQuerySqlId="REPORT_QUERY_SQL_00010"; 
		dataVersion = "M_2019_8"; //MID_ASSET_AMOUNT_PMS
		dataVersion2 = "M_2019_10"; //MID_ASSET_VALUE
		voltageRelationCode="10010";
		startRowNumber = 4;
		startColumnNumber = 2;
		//reportOutputComment( templateFileName,rootPath,sheetName,reportId,reportQuerySqlId,reportAssetemplateId, voltageRelationCode,dataVersion,dataVersion2,startRowNumber,startColumnNumber);
		
		

		templateFileName = "电网实物资产分析评价数据收集表-2020-V1.2-F.4 利用效率-待报废退役资产年龄结构（数量）";
		sheetName="F.4 利用效率-待报废退役资产年龄结构（数量）";
		reportName = "F.4 利用效率-待报废退役资产年龄结构（数量）";
		reportId="REPORT_17";
		reportAssetemplateId="REPORT_ASSET_CLASS_TEMPLATE_002";//REPORT_ASSET_CLASS_TEMPLAT_REC
		reportQuerySqlId="REPORT_QUERY_SQL_00011"; //REPORT_QUERY_SQL
		dataVersion = "M_2020_2"; //MID_OBSOLES_RETIR_ASSET_AMOUNT
		voltageRelationCode="10015";
		startRowNumber = 4;
		startColumnNumber = 2;
		//reportOutputComment( templateFileName,rootPath,sheetName,reportId,reportQuerySqlId,reportAssetemplateId, voltageRelationCode,dataVersion,startRowNumber,startColumnNumber);
		
		templateFileName = "电网实物资产分析评价数据收集表-2019-V1.2-D.6 健康状态统计表";
		sheetName="D.6 健康状态统计表";
		reportName = "D.6 健康状态统计表";
		reportId="REPORT_18";
		reportAssetemplateId="REPORT_ASSET_CLASS_TEMPLATE_003";//REPORT_ASSET_CLASS_TEMPLAT_REC
		reportQuerySqlId="REPORT_QUERY_SQL_00012"; //REPORT_QUERY_SQL
		dataVersion = "M_2019_8"; //MID_ASSET_AMOUNT_PMS
		voltageRelationCode="10010";
		startRowNumber = 3;
		startColumnNumber = 2;
		//reportOutputComment( templateFileName,rootPath,sheetName,reportId,reportQuerySqlId,reportAssetemplateId, voltageRelationCode,dataVersion,startRowNumber,startColumnNumber);
		
		templateFileName = "电网实物资产分析评价数据收集表-2019-V1.2-D.6 健康状态统计表";
		sheetName="D.6 健康状态统计表";
		reportName = "D.6 健康状态统计表";
		reportId="REPORT_18";
		reportAssetemplateId="REPORT_ASSET_CLASS_TEMPLATE_004";//REPORT_ASSET_CLASS_TEMPLAT_REC
		reportQuerySqlId="REPORT_QUERY_SQL_00012"; //REPORT_QUERY_SQL
		dataVersion = "M_2020_8"; //MID_ASSET_AMOUNT_PMS
		voltageRelationCode="10015";
		startRowNumber = 3;
		startColumnNumber = 2;
		//reportOutputComment( templateFileName,rootPath,sheetName,reportId,reportQuerySqlId,reportAssetemplateId, voltageRelationCode,dataVersion,startRowNumber,startColumnNumber);
		 

		templateFileName = "电网实物资产分析评价数据收集表-2020-V1.1-逾龄（老旧）资产";
		sheetName="A.3逾龄资产";
		reportName = "A.3逾龄资产";
		reportId="REPORT_19";
		reportAssetemplateId="REPORT_ASSET_CLASS_TEMPLATE_002";
		reportQuerySqlId="REPORT_QUERY_SQL_00013"; 
		dataVersion = "M_2020_1"; //MID_ASSET_OVER_AGE
		dataVersion2 = "M_2020_8"; //MID_ASSET_AMOUNT_PMS
		voltageRelationCode="10015";
		startRowNumber = 4;
		startColumnNumber = 1;
		//reportOutputComment( templateFileName,rootPath,sheetName,reportId,reportQuerySqlId,reportAssetemplateId, voltageRelationCode,dataVersion,dataVersion2,startRowNumber,startColumnNumber);
		

		templateFileName = "电网实物资产分析评价数据收集表-2019-V1.1-逾龄（老旧）资产";
		sheetName="A.3逾龄资产";
		reportName = "A.3逾龄资产";
		reportId="REPORT_19";
		reportAssetemplateId="REPORT_ASSET_CLASS_TEMPLATE_001";
		reportQuerySqlId="REPORT_QUERY_SQL_00013"; 
		dataVersion = "M_2019_2"; //MID_ASSET_OVER_AGE
		dataVersion2 = "M_2019_8"; //MID_ASSET_AMOUNT_PMS
		voltageRelationCode="10010";
		startRowNumber = 4;
		startColumnNumber = 1;
		//reportOutputComment( templateFileName,rootPath,sheetName,reportId,reportQuerySqlId,reportAssetemplateId, voltageRelationCode,dataVersion,dataVersion2,startRowNumber,startColumnNumber);

	}

	/**
	 * Zhang Min 20200620 通过对DV_AREA表中地区的循环实现对各地市公司报表的批量生成，目前已经测试通过的均可在此函数中一次生批量生成。
	 * 
	 * @param templateFileName 报表导出时所用的excel模板
	 * @throws SQLException 
	 */
	public static void reportOutputComment(String templateFileName ,String path,String sheetName,String reportName,String reportQuerySqlId,
			String reportAssetemplateId,String voltageRelationCode,String dataVersion,int startRowNumber,int startColumnNumber) throws SQLException {

		// String filePath = "D:/temp/hubei/test-20190620.xlsx";
		// String templateFileName = "电网实物资产分析评价数据收集表-2018";
		// String templateFileName = "电网实物资产分析评价数据收集表-2019-规模为全结构";
		// String templateFileName = "电网实物资产分析评价数据收集表-2019";
		// String templateFileName = "电网实物资产分析评价数据收集表-2020";
		// String templateFileName = "电网实物资产分析评价数据收集表-2020-V1.0";
 
		String reportSQL = "";
		Date now = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HHmmss");
		String nowdate = df.format(now);
		System.out.println("nowdate=" + nowdate);
		nowdate = df.format(now);
		System.out.println("nowdate=" + nowdate);

		String areaName ="石家庄"; // "武汉";
		//
		List<DvArea> areaList = allAreaNameQuery();
		//
		reportSQL = querySqlByReportQuerySqlId(reportQuerySqlId);
		System.out.println("reportSQL="+reportSQL);
		/*
		 * List<DvArea> areaList= new ArrayList() ; DvArea dvArea=new DvArea();
		 * dvArea.setAreaName("其它"); areaList.add(dvArea );
		 */
		for (int areaI = 0; areaI < areaList.size(); areaI++) {
			areaName = areaList.get(areaI).getAreaName();
			if(areaName.contentEquals("湖北")||areaName.contentEquals("河北")) {
				continue;
			}
			// 以下将模板文件复制到用户文件目录下，然后再对用户目录下的文件进行数据写入。
			// templateFileName 模板文件存放目录及文件名
			// String templateFileName = "电网实物资产分析评价数据收集表-2018"; 
			//String voltageRelationCode = "10010";
			// Integer yearValue = 2018;
			//String sheetName = "A.3.2.1 资产结构-年龄结构（数量）"; 
			String templateFilePathAndName =path+ "/" + templateFileName + ".xls";
			String targetFileName = templateFileName +"-"+dataVersion+"-" + areaName + "-" + nowdate.replace(" ", "") + "1" + ".xls";
			String targetFilePathAndName = path+ "/" + targetFileName;

			File src = new File(templateFilePathAndName);
			File desc = new File(targetFilePathAndName);
			long start = System.currentTimeMillis();
			copyFile(src, desc);
			long end = System.currentTimeMillis();

			System.out.println(end - start);
			System.out.println("templateFileName=" + templateFileName);
			System.out.println("targetFileName=" + targetFileName);
			System.out.println("areaName=" + areaName);


			try {
				/**
				 * 以下的代码所用函数writeXLSXAppointedColumnAutomatic为更新指定的报表中的某一列的数据
				 */
				//new ReportOutput().writeXLSXAppointedColumnAutomatic(reportSQL, templateFilePathAndName,
				//		targetFilePathAndName, reportName, voltageRelationCode, dataVersion, areaName, sheetName,
				//		startRowNumber, startColumnNumber, appointedColumn,reportAssetemplateId);

				/**
				 * 以下的代码所用函数writeXLSXColumnAutomatic为所有查询到的报表中的每一列的数据
				 */
				new ReportOutput2().writeXLSXEachCityColumnAutomatic(reportSQL, templateFilePathAndName,
						targetFilePathAndName, reportName, voltageRelationCode, dataVersion, areaName, sheetName,
						startRowNumber, startColumnNumber, reportAssetemplateId);
				
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}}
		}

	/**
	 * Zhang Min 20200620 通过对DV_AREA表中地区的循环实现对各地市公司报表的批量生成，目前已经测试通过的均可在此函数中一次生批量生成。
	 * 
	 * @param templateFileName 报表导出时所用的excel模板
	 * @throws SQLException 
	 */
	public static void reportOutputComment(String templateFileName ,String path,String sheetName,String reportName,String reportQuerySqlId,
			String reportAssetemplateId,String voltageRelationCode,String dataVersion,String dataVersion2,int startRowNumber,int startColumnNumber) throws SQLException {

		// String filePath = "D:/temp/hubei/test-20190620.xlsx";
		// String templateFileName = "电网实物资产分析评价数据收集表-2018";
		// String templateFileName = "电网实物资产分析评价数据收集表-2019-规模为全结构";
		// String templateFileName = "电网实物资产分析评价数据收集表-2019";
		// String templateFileName = "电网实物资产分析评价数据收集表-2020";
		// String templateFileName = "电网实物资产分析评价数据收集表-2020-V1.0";
 
		String reportSQL = "";
		Date now = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HHmmss");
		String nowdate = df.format(now);
		System.out.println("nowdate=" + nowdate);
		nowdate = df.format(now);
		System.out.println("nowdate=" + nowdate);

		String areaName ="石家庄"; // "武汉";
		//
		List<DvArea> areaList = allAreaNameQuery();
		//
		reportSQL = querySqlByReportQuerySqlId(reportQuerySqlId);
		System.out.println("reportSQL="+reportSQL);
		/*
		 * List<DvArea> areaList= new ArrayList() ; DvArea dvArea=new DvArea();
		 * dvArea.setAreaName("其它"); areaList.add(dvArea );
		 */
		for (int areaI = 0; areaI < areaList.size(); areaI++) {
			areaName = areaList.get(areaI).getAreaName();
			if(areaName.contentEquals("湖北")||areaName.contentEquals("河北")) {
				continue;
			}
			// 以下将模板文件复制到用户文件目录下，然后再对用户目录下的文件进行数据写入。
			// templateFileName 模板文件存放目录及文件名
			// String templateFileName = "电网实物资产分析评价数据收集表-2018"; 
			//String voltageRelationCode = "10010";
			// Integer yearValue = 2018;
			//String sheetName = "A.3.2.1 资产结构-年龄结构（数量）"; 
			String templateFilePathAndName =path+ "/" + templateFileName + ".xls";
			String targetFileName = templateFileName +"-"+dataVersion+"-" + areaName + "-" + nowdate.replace(" ", "") + "1" + ".xls";
			String targetFilePathAndName = path+ "/" + targetFileName;

			File src = new File(templateFilePathAndName);
			File desc = new File(targetFilePathAndName);
			long start = System.currentTimeMillis();
			copyFile(src, desc);
			long end = System.currentTimeMillis();

			System.out.println(end - start);
			System.out.println("templateFileName=" + templateFileName);
			System.out.println("targetFileName=" + targetFileName);
			System.out.println("areaName=" + areaName);


			try {
				/**
				 * 以下的代码所用函数writeXLSXAppointedColumnAutomatic为更新指定的报表中的某一列的数据
				 */
				//new ReportOutput().writeXLSXAppointedColumnAutomatic(reportSQL, templateFilePathAndName,
				//		targetFilePathAndName, reportName, voltageRelationCode, dataVersion, areaName, sheetName,
				//		startRowNumber, startColumnNumber, appointedColumn,reportAssetemplateId);

				/**
				 * 以下的代码所用函数writeXLSXColumnAutomatic为所有查询到的报表中的每一列的数据
				 */
				new ReportOutput2().writeXLSXEachCityColumnAutomatic(reportSQL, templateFilePathAndName,
						targetFilePathAndName, reportName, voltageRelationCode, dataVersion,dataVersion2, areaName, sheetName,
						startRowNumber, startColumnNumber, reportAssetemplateId);
				
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}}
		}

	/**
	 * Zhang Min 20200620 通过对DV_AREA表中地区的循环实现对各地市公司报表的批量生成，目前已经测试通过的均可在此函数中一次生批量生成。
	 * 
	 * @param templateFileName 报表导出时所用的excel模板
	 * @throws SQLException 
	 */
	public static void reportOutputHealth(String templateFileName ,String path,String sheetName,String reportName,String reportAssetemplateId,String voltageRelationCode,String dataVersion,int startRowNumber,int startColumnNumber) throws SQLException {

		// String filePath = "D:/temp/hubei/test-20190620.xlsx";
		// String templateFileName = "电网实物资产分析评价数据收集表-2018";
		// String templateFileName = "电网实物资产分析评价数据收集表-2019-规模为全结构";
		// String templateFileName = "电网实物资产分析评价数据收集表-2019";
		// String templateFileName = "电网实物资产分析评价数据收集表-2020";
		// String templateFileName = "电网实物资产分析评价数据收集表-2020-V1.0";
 
		String reportSQL = "";
		Date now = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HHmmss");
		String nowdate = df.format(now);
		System.out.println("nowdate=" + nowdate);
		nowdate = df.format(now);
		System.out.println("nowdate=" + nowdate);

		String areaName ="石家庄"; // "武汉";
		//
		List<DvArea> areaList = allAreaNameQuery();
		//
		reportSQL = querySqlByReportTableName(sheetName);
		System.out.println("reportSQL="+reportSQL);
		/*
		 * List<DvArea> areaList= new ArrayList() ; DvArea dvArea=new DvArea();
		 * dvArea.setAreaName("其它"); areaList.add(dvArea );
		 */
		for (int areaI = 0; areaI < areaList.size(); areaI++) {
			areaName = areaList.get(areaI).getAreaName();
			if(areaName.contentEquals("湖北")||areaName.contentEquals("河北")) {
				continue;
			}
			// 以下将模板文件复制到用户文件目录下，然后再对用户目录下的文件进行数据写入。
			// templateFileName 模板文件存放目录及文件名
			// String templateFileName = "电网实物资产分析评价数据收集表-2018"; 
			//String voltageRelationCode = "10010";
			// Integer yearValue = 2018;
			//String sheetName = "A.3.2.1 资产结构-年龄结构（数量）"; 
			String templateFilePathAndName =path+ "/" + templateFileName + ".xls";
			String targetFileName = templateFileName +"-"+dataVersion+"-" + areaName + "-" + nowdate.replace(" ", "") + "1" + ".xls";
			String targetFilePathAndName = path+ "/" + targetFileName;

			File src = new File(templateFilePathAndName);
			File desc = new File(targetFilePathAndName);
			long start = System.currentTimeMillis();
			copyFile(src, desc);
			long end = System.currentTimeMillis();

			System.out.println(end - start);
			System.out.println("templateFileName=" + templateFileName);
			System.out.println("targetFileName=" + targetFileName);
			System.out.println("areaName=" + areaName);


			try {
				/**
				 * 以下的代码所用函数writeXLSXAppointedColumnAutomatic为更新指定的报表中的某一列的数据
				 */
				//new ReportOutput().writeXLSXAppointedColumnAutomatic(reportSQL, templateFilePathAndName,
				//		targetFilePathAndName, reportName, voltageRelationCode, dataVersion, areaName, sheetName,
				//		startRowNumber, startColumnNumber, appointedColumn,reportAssetemplateId);

				/**
				 * 以下的代码所用函数writeXLSXColumnAutomatic为所有查询到的报表中的每一列的数据
				 */
				new ReportOutput2().writeXLSXColumnAutomatic(reportSQL, templateFilePathAndName,
						targetFilePathAndName, reportName, voltageRelationCode, dataVersion, areaName, sheetName,
						startRowNumber, startColumnNumber, reportAssetemplateId);
				
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}}
		}
	/**
	 * Zhang Min 20200620 对还未实现的报表进行测试，完成后，移到reportOutputAll方法中
	 * 通过对DV_AREA表中地区的循环实现对各地市公司报表的批量生成，目前已经测试通过的均可在此函数中一次生批量生成。
	 * 
	 * @param templateFileName 报表导出时所用的excel模板
	 */
	public static void reportOutputTest(String templateFileName) {

		// String filePath = "D:/temp/hubei/test-20190620.xlsx";
		// String templateFileName = "电网实物资产分析评价数据收集表-2018";
		// String templateFileName = "电网实物资产分析评价数据收集表-2019-规模为全结构";
		// String templateFileName = "电网实物资产分析评价数据收集表-2019";
		// String templateFileName = "电网实物资产分析评价数据收集表-2020";
		// String templateFileName = "电网实物资产分析评价数据收集表-2020-V1.0";

		String dataVersion = "";
		String reportSQL = "";
		Date now = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HHmmss");
		String nowdate = df.format(now);
		System.out.println("nowdate=" + nowdate);
		nowdate = df.format(now);
		System.out.println("nowdate=" + nowdate);

		String areaName = "石家庄";// "石家庄";
		//
		List<DvArea> areaList = allAreaNameQuery();
		/*
		 * List<DvArea> areaList= new ArrayList() ; DvArea dvArea=new DvArea();
		 * dvArea.setAreaName("其它"); areaList.add(dvArea );
		 */
		for (int areaI = 0; areaI < areaList.size(); areaI++) {
			areaName = areaList.get(areaI).getAreaName();
			// 以下将模板文件复制到用户文件目录下，然后再对用户目录下的文件进行数据写入。
			// templateFileName 模板文件存放目录及文件名
			// String templateFileName = "电网实物资产分析评价数据收集表-2018";
			String tableName = "RS_ASSET_AMOUNT_WALL";
			String voltageRelationCode = "10010";
			// Integer yearValue = 2018;
			String reportName = "";
			String sheetName = "";
			String templateFilePathAndName = "src/main/resources/demoFile/" + templateFileName + ".xls";
			String targetFileName = templateFileName + "-" + areaName + "-" + nowdate.replace(" ", "") + "1" + ".xls";
			String targetFilePathAndName = "src/main/webapp/userFile/Excel/" + targetFileName;

			File src = new File(templateFilePathAndName);
			File desc = new File(targetFilePathAndName);
			long start = System.currentTimeMillis();
			copyFile(src, desc);
			long end = System.currentTimeMillis();

			System.out.println(end - start);
			System.out.println("templateFileName=" + templateFileName);
			System.out.println("targetFileName=" + targetFileName);
			System.out.println("areaName=" + areaName);

			int startRowNumber = 0;
			int startColumnNumber = 0;

			sheetName = "A.3.3 资产结构-资产平均年龄";
			reportName = "A.3.3 资产结构-资产平均年龄";
			// dataVersion ="M_2019_3";
			// dataVersion = "M_2019_4";
			//
			dataVersion = "M_2019_6";// 20200620 河北
			String appointedColumn = "NET_VALUE";
			// 循环输出表格中的内容,首先循环取出行,再根据行循环取出列
			startRowNumber = 5;
			startColumnNumber = 5;
			reportSQL = "WITH STRUCTRUE_TEMP_TAB AS (SELECT A.ASSET_CLASS_NAME,A.ASSET_CLASS_CODE,B.VOLTAGE_NAME,B.INDEXOF  "
					+ "FROM DV_ASSET_CLASS A LEFT JOIN (SELECT  C.VOLTAGE_NAME,B.DV_ASSET_CLASS_ID,B.INDEXOF FROM  "
					+ "DV_VOLTAGE_RELATION B  INNER JOIN DV_VOLTAGE_LEVEL C ON B.DV_VOLTAGE_LEVEL_ID=C.DV_VOLTAGE_LEVEL_ID  "
					+ "WHERE B.VOLTAGE_RELATION_CODE=? )B ON A.DV_ASSET_CLASS_ID=B.DV_ASSET_CLASS_ID  " //1
					+ "ORDER BY A.ASSET_CLASS_CODE ,B.INDEXOF ),SPAN_STRUCTURE_TAB AS (SELECT A.ASSET_CLASS_NAME, "
					+ "DECODE(A.VOLTAGE_NAME,NULL,A.ASSET_CLASS_CODE,DECODE(LENGTH(TO_CHAR(A.INDEXOF)),1,A.ASSET_CLASS_CODE||'10'||A.INDEXOF, "
					+ "2,A.ASSET_CLASS_CODE||'1'||A.INDEXOF)) STRUCTURE_CODE,A.ASSET_CLASS_CODE,VOLTAGE_NAME,INDEXOF "
					+ " FROM STRUCTRUE_TEMP_TAB A  ORDER BY STRUCTURE_CODE,INDEXOF ),STRUCT_TEMP_RESULT AS (SELECT A.ASSET_CLASS_NAME,  "
					+ "A.ASSET_CLASS_CODE,B.VOLTAGE_NAME,B.INDEXOF FROM DV_ASSET_CLASS A LEFT JOIN SPAN_STRUCTURE_TAB B  "
					+ "ON A.ASSET_CLASS_CODE=B.STRUCTURE_CODE UNION ALL SELECT B.ASSET_CLASS_NAME,B.STRUCTURE_CODE ASSET_CLASS_CODE, "
					+ "B.VOLTAGE_NAME,B.INDEXOF FROM SPAN_STRUCTURE_TAB B ORDER BY ASSET_CLASS_CODE,INDEXOF ),RESULT_TEMP_TAB AS ( "
					+ "SELECT A.ASSET_CLASS_NAME CATEGORY,A.ASSET_CLASS_CODE,A.VOLTAGE_NAME VOLTAGE_LEVEL, "
					+ "DECODE(B.ASSET_AMOUNT,NULL,0,B.ASSET_AMOUNT) ASSET_AMOUNT,DECODE(B.TOTAL_AGE,NULL,0,B.TOTAL_AGE)TOTAL_AGE, "
					+ "DECODE(B.AVERAGE_AGE,NULL,0,B.AVERAGE_AGE)AVERAGE_AGE,DECODE(B.MAX_AGE,NULL,0,B.MAX_AGE)MAX_AGE   "
					+ "FROM (SELECT  DISTINCT  * FROM STRUCT_TEMP_RESULT )A LEFT JOIN (SELECT EXTRACT(YEAR FROM A.DV_DATE_VALUE) CAL_YEAR, "
					+ "A. CATEGORY ,A.VOLTAGE_LEVEL,SUM(A.ASSET_AMOUNT) ASSET_AMOUNT,SUM(A.TOTAL_AGE) TOTAL_AGE, "
					+ "ROUND(DECODE(SUM(A.ASSET_AMOUNT),0,0,SUM(A.TOTAL_AGE)/SUM(A.ASSET_AMOUNT)),6) AVERAGE_AGE, "
					+ "MAX (A.MAX_AGE) MAX_AGE FROM (SELECT E.ORG_ALIAS_NAME,F.AREA_NAME FROM DV_ORG_ALIAS E INNER JOIN  "
					+ "DV_ORG F ON E.DV_ORG_ID=F.DV_ORG_ID AND F.AREA_NAME  IN  (SELECT A.AREA_NAME FROM DV_AREA A WHERE   "
					+ "EXISTS (SELECT 1 FROM DV_AREA B WHERE (DECODE( B.IS_LEAF,0, 1,0	)=1 AND B.AREA_NAME=?  "           //2
					+ "AND (SUBSTR(A.AREA_CODE,0,LENGTH(A.AREA_CODE)-3)=B.AREA_CODE OR (A.IS_LEAF=0 AND B.AREA_CODE=A.AREA_CODE ))) "
					+ "OR (DECODE( B.IS_LEAF,0, 1,0	)=0 AND B.AREA_NAME=? AND A.AREA_CODE=B.AREA_CODE )))) F "//3
					+ "INNER JOIN MID_ASSET_AMOUNT_PMS  A ON A.ORG_NAME=F.ORG_ALIAS_NAME WHERE DATA_VERSION=?  GROUP BY " //4
					+ "EXTRACT(YEAR FROM A.DV_DATE_VALUE),A. CATEGORY ,A.VOLTAGE_LEVEL) B ON (A.ASSET_CLASS_NAME=B. CATEGORY  "
					+ "AND DECODE(A.VOLTAGE_NAME,NULL,'BLANK',A.VOLTAGE_NAME)=DECODE(B.VOLTAGE_LEVEL,NULL,'BLANK',B.VOLTAGE_LEVEL) "
					+ ")ORDER BY ASSET_CLASS_CODE,INDEXOF ),LEVEL_TEMP_TAB AS (SELECT  A.CATEGORY,A.ASSET_CLASS_CODE, "
					+ "DECODE(LENGTH(A.ASSET_CLASS_CODE),3,NULL,SUBSTR(A.ASSET_CLASS_CODE,0,LENGTH(A.ASSET_CLASS_CODE)-3)) "
					+ "PARENT_CLASS_CODE,A.VOLTAGE_LEVEL,A.TOTAL_AGE,A.ASSET_AMOUNT,A.AVERAGE_AGE,A.MAX_AGE FROM RESULT_TEMP_TAB A) "
					+ "SELECT B.CATEGORY,B.ASSET_CLASS_CODE,B.VOLTAGE_LEVEL, MAX (A.MAX_AGE) MAX_AGE  "
					+ "FROM LEVEL_TEMP_TAB A , LEVEL_TEMP_TAB B WHERE A.ASSET_CLASS_CODE IN ( "
					+ "SELECT E.ASSET_CLASS_CODE FROM LEVEL_TEMP_TAB E START WITH E.ASSET_CLASS_CODE=B.ASSET_CLASS_CODE "
					+ "CONNECT BY E.PARENT_CLASS_CODE=PRIOR E.ASSET_CLASS_CODE )GROUP BY B.CATEGORY, "
					+ "B.ASSET_CLASS_CODE,B.VOLTAGE_LEVEL ORDER BY 2";

			try {
				new ReportOutput2().writeXLSXAppointedColumnAutomatic(reportSQL, templateFilePathAndName,
						targetFilePathAndName, reportName, voltageRelationCode, dataVersion, areaName, sheetName,
						startRowNumber, startColumnNumber, appointedColumn);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			sheetName = "A.5.1 报废资产规模结构"; // 占位
			reportName = "A.5.1 报废资产规模结构";
			System.out.println(sheetName + " Start!");
			// dataVersion ="M_2019_2";
			//
			dataVersion = "M_2019_3";// 20200612--河北
			// dataVersion = "M_2019_2";// 20200612--湖北
			// dataVersion = "M_2019_8";//20200613--ERP
			// 循环输出表格中的内容,首先循环取出行,再根据行循环取出列
			startRowNumber = 4;
			startColumnNumber = 1;
			reportSQL = "WITH STRUCTRUE_TEMP_TAB AS (SELECT A.ASSET_CLASS_NAME,A.ASSET_CLASS_CODE,B.VOLTAGE_NAME, "
					+ "B.INDEXOF  FROM DV_ASSET_CLASS A LEFT JOIN (SELECT  C.VOLTAGE_NAME,B.DV_ASSET_CLASS_ID, "
					+ "B.INDEXOF FROM DV_VOLTAGE_RELATION B  INNER JOIN DV_VOLTAGE_LEVEL C ON  "
					+ "B.DV_VOLTAGE_LEVEL_ID=C.DV_VOLTAGE_LEVEL_ID WHERE B.VOLTAGE_RELATION_CODE= ?  "
					+ ")B ON A.DV_ASSET_CLASS_ID=B.DV_ASSET_CLASS_ID ORDER BY A.ASSET_CLASS_CODE , "
					+ "B.INDEXOF ),SPAN_STRUCTURE_TAB AS (SELECT A.ASSET_CLASS_NAME, "
					+ "DECODE(A.VOLTAGE_NAME,NULL,A.ASSET_CLASS_CODE,DECODE(LENGTH(TO_CHAR(A.INDEXOF)),1,A.ASSET_CLASS_CODE||'10'||A.INDEXOF, "
					+ "2,A.ASSET_CLASS_CODE||'1'||A.INDEXOF)) STRUCTURE_CODE,A.ASSET_CLASS_CODE,VOLTAGE_NAME,INDEXOF "
					+ "FROM STRUCTRUE_TEMP_TAB A  ORDER BY STRUCTURE_CODE,INDEXOF ),STRUCT_TEMP_RESULT AS (  "
					+ "SELECT A.ASSET_CLASS_NAME, A.ASSET_CLASS_CODE,B.VOLTAGE_NAME,B.INDEXOF FROM DV_ASSET_CLASS A  "
					+ "LEFT JOIN SPAN_STRUCTURE_TAB B ON A.ASSET_CLASS_CODE=B.STRUCTURE_CODE UNION ALL  "
					+ "SELECT B.ASSET_CLASS_NAME,B.STRUCTURE_CODE ASSET_CLASS_CODE,B.VOLTAGE_NAME,B.INDEXOF FROM  "
					+ "SPAN_STRUCTURE_TAB B ORDER BY ASSET_CLASS_CODE,INDEXOF ),RESULT_TEMP_TAB AS ( "
					+ "SELECT A.ASSET_CLASS_NAME CATEGORY,A.ASSET_CLASS_CODE,A.VOLTAGE_NAME VOLTAGE_LEVEL, "
					+ "DECODE(B.DISCARD_YEAR1_ORIGIN_VAL,NULL,0,B.DISCARD_YEAR1_ORIGIN_VAL) DISCARD_YEAR1_ORIGIN_VAL, "
					+ "DECODE(B.DISCARD_YEAR1_NET_VAL,NULL,0,B.DISCARD_YEAR1_NET_VAL) DISCARD_YEAR1_NET_VAL, "
					+ "DECODE(B.DISCARD_YEAR1_AMOUNT,NULL,0,B.DISCARD_YEAR1_AMOUNT) DISCARD_YEAR1_AMOUNT, "
					+ "DECODE(B.DISCARD_YEAR1_CAPACITY,NULL,0,B.DISCARD_YEAR1_CAPACITY) DISCARD_YEAR1_CAPACITY   "
					+ "FROM (SELECT  DISTINCT  * FROM STRUCT_TEMP_RESULT )A LEFT JOIN  "
					+ "(SELECT EXTRACT(YEAR FROM A.DV_DATE_VALUE) CAL_YEAR,A. CATEGORY ,A.VOLTAGE_LEVEL,  "
					+ "SUM(A.DISCARD_YEAR1_ORIGIN_VAL) DISCARD_YEAR1_ORIGIN_VAL,  "
					+ "SUM(A.DISCARD_YEAR1_NET_VAL) DISCARD_YEAR1_NET_VAL,  "
					+ "SUM(A.DISCARD_YEAR1_AMOUNT) DISCARD_YEAR1_AMOUNT , "
					+ "SUM(A.DISCARD_YEAR1_CAPACITY) DISCARD_YEAR1_CAPACITY  "
					+ "FROM (SELECT E.ORG_ALIAS_NAME,F.AREA_NAME FROM DV_ORG_ALIAS E  "
					+ "INNER JOIN DV_ORG F ON E.DV_ORG_ID=F.DV_ORG_ID AND F.AREA_NAME   "
					+ "IN (SELECT A.AREA_NAME FROM DV_AREA A WHERE  EXISTS  "
					+ "(SELECT 1 FROM DV_AREA B WHERE (DECODE( B.IS_LEAF,0, 1,0	)=1 AND B.AREA_NAME= ? "
					+ "AND (SUBSTR(A.AREA_CODE,0,LENGTH(A.AREA_CODE)-3)=B.AREA_CODE "
					+ "OR (A.IS_LEAF=0 AND B.AREA_CODE=A.AREA_CODE )))OR  "
					+ "(DECODE( B.IS_LEAF,0, 1,0	)=0 AND B.AREA_NAME=? AND A.AREA_CODE=B.AREA_CODE "
					+ ")) )) F INNER JOIN MID_ASSET_DISCARD A ON A.ORG_NAME=F.ORG_ALIAS_NAME  "
					+ "WHERE  VERSION= ? GROUP BY EXTRACT(YEAR FROM A.DV_DATE_VALUE), "
					+ "A. CATEGORY ,A.VOLTAGE_LEVEL) B ON(A.ASSET_CLASS_NAME=B. CATEGORY  AND  "
					+ "DECODE(A.VOLTAGE_NAME,NULL,'BLANK',A.VOLTAGE_NAME)=DECODE(B.VOLTAGE_LEVEL,NULL,'BLANK',B.VOLTAGE_LEVEL) "
					+ ")ORDER BY ASSET_CLASS_CODE,INDEXOF ),LEVEL_TEMP_TAB AS ( "
					+ "SELECT  A.CATEGORY,A.ASSET_CLASS_CODE,DECODE(LENGTH(A.ASSET_CLASS_CODE), "
					+ "3,NULL,SUBSTR(A.ASSET_CLASS_CODE,0,LENGTH(A.ASSET_CLASS_CODE)-3))PARENT_CLASS_CODE, "
					+ "A.VOLTAGE_LEVEL,A.DISCARD_YEAR1_ORIGIN_VAL,A.DISCARD_YEAR1_NET_VAL,A.DISCARD_YEAR1_AMOUNT, "
					+ "A.DISCARD_YEAR1_CAPACITY FROM RESULT_TEMP_TAB A ) "
					+ "SELECT B.CATEGORY,B.ASSET_CLASS_CODE,B.VOLTAGE_LEVEL,  "
					+ "SUM(A.DISCARD_YEAR1_ORIGIN_VAL) DISCARD_YEAR1_ORIGIN_VAL, "
					+ "SUM(A.DISCARD_YEAR1_NET_VAL) DISCARD_YEAR1_NET_VAL, "
					+ "SUM(A.DISCARD_YEAR1_AMOUNT) DISCARD_YEAR1_AMOUNT, "
					+ "SUM(A.DISCARD_YEAR1_CAPACITY) DISCARD_YEAR1_CAPACITY "
					+ "FROM LEVEL_TEMP_TAB A , LEVEL_TEMP_TAB B WHERE A.ASSET_CLASS_CODE IN  "
					+ "(SELECT E.ASSET_CLASS_CODE FROM LEVEL_TEMP_TAB E  "
					+ "START WITH E.ASSET_CLASS_CODE=B.ASSET_CLASS_CODE "
					+ "CONNECT BY E.PARENT_CLASS_CODE=PRIOR E.ASSET_CLASS_CODE) "
					+ "GROUP BY B.CATEGORY,B.ASSET_CLASS_CODE,B.VOLTAGE_LEVEL ORDER BY 2";
/*
			try {
				new ReportOutput().writeXLSXAutoMatic(reportSQL, templateFilePathAndName, targetFilePathAndName,
						reportName, voltageRelationCode, dataVersion, areaName, sheetName, startRowNumber,
						startColumnNumber);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
*/
		}
	}
	/**
	 * Zhang Min 20200620 通过对DV_AREA表中地区的循环实现对各地市公司报表的批量生成，目前已经测试通过的均可在此函数中一次生批量生成。
	 * 
	 * @param templateFileName 报表导出时所用的excel模板
	 */
	public static void reportOutputAll(String templateFileName ,String path) {

		// String filePath = "D:/temp/hubei/test-20190620.xlsx";
		// String templateFileName = "电网实物资产分析评价数据收集表-2018";
		// String templateFileName = "电网实物资产分析评价数据收集表-2019-规模为全结构";
		// String templateFileName = "电网实物资产分析评价数据收集表-2019";
		// String templateFileName = "电网实物资产分析评价数据收集表-2020";
		// String templateFileName = "电网实物资产分析评价数据收集表-2020-V1.0";

		String dataVersion = "";
		String reportSQL = "";
		Date now = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HHmmss");
		String nowdate = df.format(now);
		System.out.println("nowdate=" + nowdate);
		nowdate = df.format(now);
		System.out.println("nowdate=" + nowdate);

		String areaName ="石家庄"; // "武汉";
		//
		List<DvArea> areaList = allAreaNameQuery();
		/*
		 * List<DvArea> areaList= new ArrayList() ; DvArea dvArea=new DvArea();
		 * dvArea.setAreaName("其它"); areaList.add(dvArea );
		 */
		for (int areaI = 0; areaI < areaList.size(); areaI++) {
			areaName = areaList.get(areaI).getAreaName();
			if(areaName.contentEquals("湖北")||areaName.contentEquals("河北")) {
				continue;
			}
			// 以下将模板文件复制到用户文件目录下，然后再对用户目录下的文件进行数据写入。
			// templateFileName 模板文件存放目录及文件名
			// String templateFileName = "电网实物资产分析评价数据收集表-2018";
			String tableName = "RS_ASSET_AMOUNT_WALL";
			String voltageRelationCode = "10010";
			// Integer yearValue = 2018;
			String reportName = "A.3.2.1 资产结构-年龄结构（数量）";
			String sheetName = "A.3.2.1 资产结构-年龄结构（数量）"; 
			String templateFilePathAndName =path+ "/" + templateFileName + ".xls";
			String targetFileName = templateFileName + "-" + areaName + "-" + nowdate.replace(" ", "") + "1" + ".xls";
			String targetFilePathAndName = path+ "/" + targetFileName;

			File src = new File(templateFilePathAndName);
			File desc = new File(targetFilePathAndName);
			long start = System.currentTimeMillis();
			copyFile(src, desc);
			long end = System.currentTimeMillis();

			System.out.println(end - start);
			System.out.println("templateFileName=" + templateFileName);
			System.out.println("targetFileName=" + targetFileName);
			System.out.println("areaName=" + areaName);

			int startRowNumber = 0;
			int startColumnNumber = 0;

			sheetName = "A.1 规模结构";
			reportName = "A.1 规模结构";
			// dataVersion ="M_2019_3";
			// dataVersion = "M_2019_4";
			//
			dataVersion = "M_2019_8";// 20200613
			String appointedColumn = "NET_VALUE";
			// 循环输出表格中的内容,首先循环取出行,再根据行循环取出列
			startRowNumber = 4;
			startColumnNumber = 1;
			reportSQL = "WITH STRUCTRUE_TEMP_TAB AS (SELECT A.ASSET_CLASS_NAME,A.ASSET_CLASS_CODE, "
					+ "B.VOLTAGE_NAME,B.INDEXOF FROM DV_ASSET_CLASS A LEFT JOIN ( "
					+ "SELECT  C.VOLTAGE_NAME,B.DV_ASSET_CLASS_ID,B.INDEXOF FROM DV_VOLTAGE_RELATION B   "
					+ "INNER JOIN DV_VOLTAGE_LEVEL C ON B.DV_VOLTAGE_LEVEL_ID=C.DV_VOLTAGE_LEVEL_ID  "
					+ "WHERE B.VOLTAGE_RELATION_CODE=?)B ON A.DV_ASSET_CLASS_ID=B.DV_ASSET_CLASS_ID  "// 1
					+ "ORDER BY A.ASSET_CLASS_CODE ,B.INDEXOF ),SPAN_STRUCTURE_TAB AS ( "
					+ "SELECT A.ASSET_CLASS_NAME,DECODE(A.VOLTAGE_NAME,NULL,A.ASSET_CLASS_CODE, "
					+ "DECODE(LENGTH(TO_CHAR(A.INDEXOF)),1,A.ASSET_CLASS_CODE||'10'||A.INDEXOF, "
					+ "2,A.ASSET_CLASS_CODE||'1'||A.INDEXOF)) STRUCTURE_CODE,A.ASSET_CLASS_CODE,VOLTAGE_NAME, "
					+ "INDEXOF FROM STRUCTRUE_TEMP_TAB A  ORDER BY STRUCTURE_CODE,INDEXOF ), "
					+ "STRUCT_TEMP_RESULT AS (SELECT A.ASSET_CLASS_NAME, A.ASSET_CLASS_CODE,B.VOLTAGE_NAME, "
					+ "B.INDEXOF FROM DV_ASSET_CLASS A LEFT JOIN SPAN_STRUCTURE_TAB B ON  "
					+ "A.ASSET_CLASS_CODE=B.STRUCTURE_CODE UNION ALL SELECT B.ASSET_CLASS_NAME, "
					+ "B.STRUCTURE_CODE ASSET_CLASS_CODE,B.VOLTAGE_NAME,B.INDEXOF FROM SPAN_STRUCTURE_TAB B  "
					+ "ORDER BY ASSET_CLASS_CODE,INDEXOF ),RESULT_TEMP_TAB AS (SELECT   "
					+ "A.ASSET_CLASS_NAME CATEGORY,A.ASSET_CLASS_CODE,A.VOLTAGE_NAME VOLTAGE_LEVEL, "
					+ "DECODE(B.ORIGIN_VALUE,NULL,0,B.ORIGIN_VALUE) ORIGIN_VALUE, "
					+ "DECODE(B.NET_VALUE,NULL,0,B.NET_VALUE) NET_VALUE  FROM"
					+ "(SELECT  DISTINCT  * FROM STRUCT_TEMP_RESULT )A LEFT JOIN "
					+ "(SELECT EXTRACT(YEAR FROM A.DV_DATE_VALUE) CAL_YEAR,A.CATEGORY,"
					+ "A.VOLTAGE_LEVEL,SUM(A.ZCYZ) ORIGIN_VALUE,SUM(A.ZCJZ) NET_VALUE "
					+ "FROM (SELECT E.ORG_ALIAS_NAME,F.AREA_NAME FROM DV_ORG_ALIAS E  "
					+ "INNER JOIN DV_ORG F ON E.DV_ORG_ID=F.DV_ORG_ID AND  "
					+ "F.AREA_NAME IN (SELECT A.AREA_NAME FROM DV_AREA A WHERE   "
					+ "EXISTS (SELECT 1 FROM DV_AREA B WHERE (DECODE( B.IS_LEAF,0, 1,0	)=1  "
					+ "AND B.AREA_NAME=? AND (SUBSTR(A.AREA_CODE,0,LENGTH(A.AREA_CODE)-3)=B.AREA_CODE OR  " + // 2
					"(A.IS_LEAF=0 AND B.AREA_CODE=A.AREA_CODE )))OR  (DECODE( B.IS_LEAF,0, 1,0	)=0 "
					+ "AND B.AREA_NAME= ? AND  A.AREA_CODE=B.AREA_CODE )))) F " + // 3
					"INNER JOIN MID_ASSET_VALUE A ON A.ORG_NAME=F.ORG_ALIAS_NAME  "
					+ "WHERE DATA_VERSION=?  GROUP BY EXTRACT(YEAR FROM A.DV_DATE_VALUE), " + // 4
					"A.CATEGORY,A.VOLTAGE_LEVEL) B ON (A.ASSET_CLASS_NAME=B.CATEGORY "
					+ "AND DECODE(A.VOLTAGE_NAME,NULL,'BLANK',A.VOLTAGE_NAME)= "
					+ "DECODE(B.VOLTAGE_LEVEL,NULL,'BLANK',B.VOLTAGE_LEVEL))ORDER BY ASSET_CLASS_CODE, "
					+ "INDEXOF ),LEVEL_TEMP_TAB AS (SELECT  A.CATEGORY,A.ASSET_CLASS_CODE, "
					+ "DECODE(LENGTH(A.ASSET_CLASS_CODE),3,NULL,SUBSTR(A.ASSET_CLASS_CODE,0,LENGTH(A.ASSET_CLASS_CODE)-3)) "
					+ "PARENT_CLASS_CODE,A.VOLTAGE_LEVEL,A.ORIGIN_VALUE,A.NET_VALUE FROM RESULT_TEMP_TAB A) "
					+ "SELECT B.CATEGORY,B.ASSET_CLASS_CODE,B.VOLTAGE_LEVEL,SUM(A.ORIGIN_VALUE)ORIGIN_VALUE, "
					+ "SUM(A.NET_VALUE)NET_VALUE FROM LEVEL_TEMP_TAB A , LEVEL_TEMP_TAB B WHERE  "
					+ "A.ASSET_CLASS_CODE IN (SELECT E.ASSET_CLASS_CODE FROM LEVEL_TEMP_TAB E  "
					+ "START WITH E.ASSET_CLASS_CODE=B.ASSET_CLASS_CODE CONNECT BY  "
					+ "E.PARENT_CLASS_CODE=PRIOR E.ASSET_CLASS_CODE )GROUP BY B.CATEGORY, "
					+ "B.ASSET_CLASS_CODE,B.VOLTAGE_LEVEL ORDER BY ASSET_CLASS_CODE ";

			try {
				new ReportOutput2().writeXLSXAppointedColumnAutomatic(reportSQL, templateFilePathAndName,
						targetFilePathAndName, reportName, voltageRelationCode, dataVersion, areaName, sheetName,
						startRowNumber, startColumnNumber, appointedColumn);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			sheetName = "A.1 资产结构-价值规模";
			reportName = "A.1 资产结构-价值规模";
			// dataVersion ="M_2019_3";
			// dataVersion = "M_2019_4";
			//
			dataVersion = "M_2019_8";// 20200613
			// 循环输出表格中的内容,首先循环取出行,再根据行循环取出列
			startRowNumber = 4;
			startColumnNumber = 1;
			reportSQL = "WITH STRUCTRUE_TEMP_TAB AS (SELECT A.ASSET_CLASS_NAME,A.ASSET_CLASS_CODE, "
					+ "B.VOLTAGE_NAME,B.INDEXOF FROM DV_ASSET_CLASS A LEFT JOIN ( "
					+ "SELECT  C.VOLTAGE_NAME,B.DV_ASSET_CLASS_ID,B.INDEXOF FROM DV_VOLTAGE_RELATION B   "
					+ "INNER JOIN DV_VOLTAGE_LEVEL C ON B.DV_VOLTAGE_LEVEL_ID=C.DV_VOLTAGE_LEVEL_ID  "
					+ "WHERE B.VOLTAGE_RELATION_CODE=?)B ON A.DV_ASSET_CLASS_ID=B.DV_ASSET_CLASS_ID  "// 1
					+ "ORDER BY A.ASSET_CLASS_CODE ,B.INDEXOF ),SPAN_STRUCTURE_TAB AS ( "
					+ "SELECT A.ASSET_CLASS_NAME,DECODE(A.VOLTAGE_NAME,NULL,A.ASSET_CLASS_CODE, "
					+ "DECODE(LENGTH(TO_CHAR(A.INDEXOF)),1,A.ASSET_CLASS_CODE||'10'||A.INDEXOF, "
					+ "2,A.ASSET_CLASS_CODE||'1'||A.INDEXOF)) STRUCTURE_CODE,A.ASSET_CLASS_CODE,VOLTAGE_NAME, "
					+ "INDEXOF FROM STRUCTRUE_TEMP_TAB A  ORDER BY STRUCTURE_CODE,INDEXOF ), "
					+ "STRUCT_TEMP_RESULT AS (SELECT A.ASSET_CLASS_NAME, A.ASSET_CLASS_CODE,B.VOLTAGE_NAME, "
					+ "B.INDEXOF FROM DV_ASSET_CLASS A LEFT JOIN SPAN_STRUCTURE_TAB B ON  "
					+ "A.ASSET_CLASS_CODE=B.STRUCTURE_CODE UNION ALL SELECT B.ASSET_CLASS_NAME, "
					+ "B.STRUCTURE_CODE ASSET_CLASS_CODE,B.VOLTAGE_NAME,B.INDEXOF FROM SPAN_STRUCTURE_TAB B  "
					+ "ORDER BY ASSET_CLASS_CODE,INDEXOF ),RESULT_TEMP_TAB AS (SELECT   "
					+ "A.ASSET_CLASS_NAME CATEGORY,A.ASSET_CLASS_CODE,A.VOLTAGE_NAME VOLTAGE_LEVEL, "
					+ "DECODE(B.ORIGIN_VALUE,NULL,0,B.ORIGIN_VALUE) ORIGIN_VALUE, "
					+ "DECODE(B.NET_VALUE,NULL,0,B.NET_VALUE) NET_VALUE FROM  "
					+ "(SELECT  DISTINCT  * FROM STRUCT_TEMP_RESULT )A LEFT JOIN  "
					+ "(SELECT EXTRACT(YEAR FROM A.DV_DATE_VALUE) CAL_YEAR,A.CATEGORY, "
					+ "A.VOLTAGE_LEVEL,SUM(A.ZCYZ) ORIGIN_VALUE,SUM(A.ZCJZ) NET_VALUE  "
					+ "FROM (SELECT E.ORG_ALIAS_NAME,F.AREA_NAME FROM DV_ORG_ALIAS E INNER JOIN  "
					+ "DV_ORG F ON E.DV_ORG_ID=F.DV_ORG_ID AND F.AREA_NAME= ? " + // 2
					") F INNER JOIN MID_ASSET_VALUE  A ON A.ORG_NAME=F.ORG_ALIAS_NAME  "
					+ "WHERE DATA_VERSION=?  GROUP BY EXTRACT(YEAR FROM A.DV_DATE_VALUE), " + // 3
					"A.CATEGORY,A.VOLTAGE_LEVEL) B ON (A.ASSET_CLASS_NAME=B.CATEGORY "
					+ "AND DECODE(A.VOLTAGE_NAME,NULL,'BLANK',A.VOLTAGE_NAME)= "
					+ "DECODE(B.VOLTAGE_LEVEL,NULL,'BLANK',B.VOLTAGE_LEVEL))ORDER BY ASSET_CLASS_CODE, "
					+ "INDEXOF ),LEVEL_TEMP_TAB AS (SELECT  A.CATEGORY,A.ASSET_CLASS_CODE, "
					+ "DECODE(LENGTH(A.ASSET_CLASS_CODE),3,NULL,SUBSTR(A.ASSET_CLASS_CODE,0,LENGTH(A.ASSET_CLASS_CODE)-3)) "
					+ "PARENT_CLASS_CODE,A.VOLTAGE_LEVEL,A.ORIGIN_VALUE,A.NET_VALUE FROM RESULT_TEMP_TAB A) "
					+ "SELECT B.CATEGORY,B.ASSET_CLASS_CODE,B.VOLTAGE_LEVEL,SUM(A.ORIGIN_VALUE)ORIGIN_VALUE, "
					+ "SUM(A.NET_VALUE)NET_VALUE FROM LEVEL_TEMP_TAB A , LEVEL_TEMP_TAB B WHERE  "
					+ "A.ASSET_CLASS_CODE IN (SELECT E.ASSET_CLASS_CODE FROM LEVEL_TEMP_TAB E  "
					+ "START WITH E.ASSET_CLASS_CODE=B.ASSET_CLASS_CODE CONNECT BY  "
					+ "E.PARENT_CLASS_CODE=PRIOR E.ASSET_CLASS_CODE )GROUP BY B.CATEGORY, "
					+ "B.ASSET_CLASS_CODE,B.VOLTAGE_LEVEL ORDER BY ASSET_CLASS_CODE ";

			/*
			 * try { new ReportOutput().writeXLSX(reportSQL, templateFilePathAndName,
			 * targetFilePathAndName, reportName, voltageRelationCode, dataVersion,
			 * areaName, sheetName, startRowNumber, startColumnNumber); } catch
			 * (SQLException e) { e.printStackTrace(); } catch (IOException e) {
			 * e.printStackTrace(); }
			 */

			sheetName = "A.2 资产结构-数量规模";
			reportName = "A.2 资产结构-数量规模";
			// dataVersion ="M_2019_2";
			dataVersion = "M_2019_6";// 20200612--PMS
			// dataVersion = "M_2019_8";//20200613--ERP
			// 循环输出表格中的内容,首先循环取出行,再根据行循环取出列
			startRowNumber = 4;
			startColumnNumber = 1;
			reportSQL = "WITH STRUCTRUE_TEMP_TAB AS (SELECT A.ASSET_CLASS_NAME,A.ASSET_CLASS_CODE, "
					+ "B.VOLTAGE_NAME,B.INDEXOF FROM DV_ASSET_CLASS A LEFT JOIN  "
					+ "(SELECT  C.VOLTAGE_NAME,B.DV_ASSET_CLASS_ID,B.INDEXOF FROM  "
					+ "DV_VOLTAGE_RELATION B  INNER JOIN DV_VOLTAGE_LEVEL C  "
					+ "ON B.DV_VOLTAGE_LEVEL_ID=C.DV_VOLTAGE_LEVEL_ID  " + "WHERE B.VOLTAGE_RELATION_CODE=?)B ON  " + // 1
					"A.DV_ASSET_CLASS_ID=B.DV_ASSET_CLASS_ID ORDER BY "
					+ "A.ASSET_CLASS_CODE ,B.INDEXOF ),SPAN_STRUCTURE_TAB AS ( "
					+ "SELECT A.ASSET_CLASS_NAME,DECODE(A.VOLTAGE_NAME,NULL,A.ASSET_CLASS_CODE, "
					+ "DECODE(LENGTH(TO_CHAR(A.INDEXOF)),1,A.ASSET_CLASS_CODE||'10'||A.INDEXOF, "
					+ "2,A.ASSET_CLASS_CODE||'1'||A.INDEXOF)) STRUCTURE_CODE,A.ASSET_CLASS_CODE, "
					+ "VOLTAGE_NAME,INDEXOF FROM STRUCTRUE_TEMP_TAB A  ORDER BY STRUCTURE_CODE, "
					+ "INDEXOF ),STRUCT_TEMP_RESULT AS (SELECT A.ASSET_CLASS_NAME, A.ASSET_CLASS_CODE, "
					+ "B.VOLTAGE_NAME,B.INDEXOF FROM DV_ASSET_CLASS A LEFT JOIN SPAN_STRUCTURE_TAB B  "
					+ "ON A.ASSET_CLASS_CODE=B.STRUCTURE_CODE UNION ALL SELECT B.ASSET_CLASS_NAME, "
					+ "B.STRUCTURE_CODE ASSET_CLASS_CODE,B.VOLTAGE_NAME,B.INDEXOF FROM  "
					+ "SPAN_STRUCTURE_TAB B ORDER BY ASSET_CLASS_CODE,INDEXOF ),RESULT_TEMP_TAB AS ( "
					+ "SELECT A.ASSET_CLASS_NAME CATEGORY,A.ASSET_CLASS_CODE,A.VOLTAGE_NAME VOLTAGE_LEVEL, "
					+ "DECODE(B.ASSET_CAPACITY,NULL,0,B.ASSET_CAPACITY) ASSET_CAPACITY, "
					+ "DECODE(B.ASSET_AMOUNT,NULL,0,B.ASSET_AMOUNT) ASSET_AMOUNT FROM  "
					+ "( SELECT  DISTINCT  * FROM STRUCT_TEMP_RESULT )A LEFT JOIN ( "
					+ "SELECT EXTRACT(YEAR FROM A.DV_DATE_VALUE) CAL_YEAR,A.CATEGORY, "
					+ "A.VOLTAGE_LEVEL,SUM(A.ASSET_AMOUNT) ASSET_AMOUNT,SUM(A.ASSET_CAPACITY) ASSET_CAPACITY   "
					+ "FROM (SELECT E.ORG_ALIAS_NAME,F.AREA_NAME FROM DV_ORG_ALIAS E INNER JOIN DV_ORG F  "
					+ "ON E.DV_ORG_ID=F.DV_ORG_ID AND F.AREA_NAME=?) F INNER JOIN  " + // 2
					"MID_ASSET_AMOUNT_PMS  A ON A.ORG_NAME=F.ORG_ALIAS_NAME WHERE  "
					+ "DATA_VERSION=? GROUP BY EXTRACT(YEAR FROM A.DV_DATE_VALUE), " + // 3
					"A.CATEGORY,A.VOLTAGE_LEVEL) B ON (A.ASSET_CLASS_NAME=B.CATEGORY "
					+ "AND DECODE(A.VOLTAGE_NAME,NULL,'BLANK',A.VOLTAGE_NAME)= "
					+ "DECODE(B.VOLTAGE_LEVEL,NULL,'BLANK',B.VOLTAGE_LEVEL))ORDER BY "
					+ "ASSET_CLASS_CODE,INDEXOF ),LEVEL_TEMP_TAB AS (SELECT  "
					+ " A.CATEGORY,A.ASSET_CLASS_CODE,DECODE(LENGTH(A.ASSET_CLASS_CODE), "
					+ "3,NULL,SUBSTR(A.ASSET_CLASS_CODE,0,LENGTH(A.ASSET_CLASS_CODE)-3)) "
					+ "PARENT_CLASS_CODE,A.VOLTAGE_LEVEL,A.ASSET_CAPACITY,A.ASSET_AMOUNT "
					+ "FROM RESULT_TEMP_TAB A )SELECT B.CATEGORY,B.ASSET_CLASS_CODE, "
					+ "B.VOLTAGE_LEVEL,SUM(A.ASSET_AMOUNT) ASSET_AMOUNT,SUM(A.ASSET_CAPACITY) ASSET_CAPACITY "
					+ "FROM LEVEL_TEMP_TAB A , LEVEL_TEMP_TAB B WHERE A.ASSET_CLASS_CODE IN  "
					+ "(SELECT E.ASSET_CLASS_CODE FROM LEVEL_TEMP_TAB E  "
					+ "START WITH E.ASSET_CLASS_CODE=B.ASSET_CLASS_CODE "
					+ "CONNECT BY E.PARENT_CLASS_CODE=PRIOR E.ASSET_CLASS_CODE) "
					+ "GROUP BY B.CATEGORY,B.ASSET_CLASS_CODE,B.VOLTAGE_LEVEL " + "ORDER BY ASSET_CLASS_CODE ";

			/*
			 * try { new ReportOutput().writeXLSX(reportSQL, templateFilePathAndName,
			 * targetFilePathAndName, reportName, voltageRelationCode, dataVersion,
			 * areaName, sheetName, startRowNumber, startColumnNumber); } catch
			 * (SQLException e) { e.printStackTrace(); } catch (IOException e) {
			 * e.printStackTrace(); }
			 */

			sheetName = "A.3.1 资产结构-年龄结构（价值）";
			reportName = "A.3.1 资产结构-年龄结构（价值）";
			// dataVersion = "M_2019_3";
			// dataVersion ="M_2019_4";
			// dataVersion = "M_2019_6";//20200612--PMS
			dataVersion = "M_2019_8";// 20200613--ERP
			// 循环输出表格中的内容,首先循环取出行,再根据行循环取出列
			startRowNumber = 5;
			startColumnNumber = 2;
			reportSQL = "WITH STRUCTRUE_TEMP_TAB AS (SELECT A.ASSET_CLASS_NAME,A.ASSET_CLASS_CODE, "
					+ "B.VOLTAGE_NAME,B.INDEXOF FROM DV_ASSET_CLASS A LEFT JOIN  "
					+ "(SELECT  C.VOLTAGE_NAME,B.DV_ASSET_CLASS_ID,B.INDEXOF FROM  "
					+ "DV_VOLTAGE_RELATION B  INNER JOIN DV_VOLTAGE_LEVEL C ON  "
					+ "B.DV_VOLTAGE_LEVEL_ID=C.DV_VOLTAGE_LEVEL_ID WHERE B.VOLTAGE_RELATION_CODE=? "
					// 1
					+ ")B ON A.DV_ASSET_CLASS_ID=B.DV_ASSET_CLASS_ID ORDER BY "
					+ "A.ASSET_CLASS_CODE ,B.INDEXOF ),SPAN_STRUCTURE_TAB AS ( "
					+ "SELECT A.ASSET_CLASS_NAME,DECODE(A.VOLTAGE_NAME,NULL,A.ASSET_CLASS_CODE, "
					+ "DECODE(LENGTH(TO_CHAR(A.INDEXOF)),1,A.ASSET_CLASS_CODE||'10'||A.INDEXOF, "
					+ "2,A.ASSET_CLASS_CODE||'1'||A.INDEXOF)) STRUCTURE_CODE,A.ASSET_CLASS_CODE, "
					+ "VOLTAGE_NAME,INDEXOF FROM STRUCTRUE_TEMP_TAB A  ORDER BY "
					+ "STRUCTURE_CODE,INDEXOF ),STRUCT_TEMP_RESULT AS (SELECT  "
					+ "A.ASSET_CLASS_NAME, A.ASSET_CLASS_CODE,B.VOLTAGE_NAME,B.INDEXOF  "
					+ "FROM DV_ASSET_CLASS A LEFT JOIN SPAN_STRUCTURE_TAB B  "
					+ "ON A.ASSET_CLASS_CODE=B.STRUCTURE_CODE UNION ALL SELECT  "
					+ "B.ASSET_CLASS_NAME,B.STRUCTURE_CODE ASSET_CLASS_CODE,B.VOLTAGE_NAME, "
					+ "B.INDEXOF FROM SPAN_STRUCTURE_TAB B ORDER BY ASSET_CLASS_CODE, "
					+ "INDEXOF ),RESULT_TEMP_TAB AS (SELECT A.ASSET_CLASS_NAME CATEGORY, "
					+ "A.ASSET_CLASS_CODE,A.VOLTAGE_NAME VOLTAGE_LEVEL, "
					+ "DECODE(B.RZNF1 ,NULL,0,B.RZNF1  ) RZNF1   ,DECODE(B.RZNF2 ,NULL,0,B.RZNF2  ) RZNF2   , "
					+ "DECODE(B.RZNF3 ,NULL,0,B.RZNF3  ) RZNF3   ,DECODE(B.RZNF4 ,NULL,0,B.RZNF4  ) RZNF4   , "
					+ "DECODE(B.RZNF5 ,NULL,0,B.RZNF5  ) RZNF5   ,DECODE(B.RZNF6 ,NULL,0,B.RZNF6  ) RZNF6   , "
					+ "DECODE(B.RZNF7 ,NULL,0,B.RZNF7  ) RZNF7   ,DECODE(B.RZNF8 ,NULL,0,B.RZNF8  ) RZNF8   , "
					+ "DECODE(B.RZNF9 ,NULL,0,B.RZNF9  ) RZNF9   ,DECODE(B.RZNF10,NULL,0,B.RZNF10 ) RZNF10  , "
					+ "DECODE(B.RZNF11,NULL,0,B.RZNF11 ) RZNF11  ,DECODE(B.RZNF12,NULL,0,B.RZNF12 ) RZNF12  , "
					+ "DECODE(B.RZNF13,NULL,0,B.RZNF13 ) RZNF13  ,DECODE(B.RZNF14,NULL,0,B.RZNF14 ) RZNF14  , "
					+ "DECODE(B.RZNF15,NULL,0,B.RZNF15 ) RZNF15  ,DECODE(B.RZNF16,NULL,0,B.RZNF16 ) RZNF16  , "
					+ "DECODE(B.RZNF17,NULL,0,B.RZNF17 ) RZNF17  ,DECODE(B.RZNF18,NULL,0,B.RZNF18 ) RZNF18  , "
					+ "DECODE(B.RZNF19,NULL,0,B.RZNF19 ) RZNF19  ,DECODE(B.RZNF20,NULL,0,B.RZNF20 ) RZNF20  , "
					+ "DECODE(B.RZNF21,NULL,0,B.RZNF21 ) RZNF21  ,DECODE(B.RZNF22,NULL,0,B.RZNF22 ) RZNF22  , "
					+ "DECODE(B.RZNF23,NULL,0,B.RZNF23 ) RZNF23  ,DECODE(B.RZNF24,NULL,0,B.RZNF24 ) RZNF24  , "
					+ "DECODE(B.RZNF25,NULL,0,B.RZNF25 ) RZNF25  ,DECODE(B.RZNF26,NULL,0,B.RZNF26 ) RZNF26  , "
					+ "DECODE(B.RZNF27,NULL,0,B.RZNF27 ) RZNF27  ,DECODE(B.RZNF28,NULL,0,B.RZNF28 ) RZNF28  , "
					+ "DECODE(B.RZNF29,NULL,0,B.RZNF29 ) RZNF29  ,DECODE(B.RZNF30,NULL,0,B.RZNF30 ) RZNF30  , "
					+ "DECODE(B.RZNF31,NULL,0,B.RZNF31 ) RZNF31  ,DECODE(B.RZNF32,NULL,0,B.RZNF32 ) RZNF32  , "
					+ "DECODE(B.RZNF33,NULL,0,B.RZNF33 ) RZNF33  ,DECODE(B.RZNF34,NULL,0,B.RZNF34 ) RZNF34  , "
					+ "DECODE(B.RZNF35,NULL,0,B.RZNF35 ) RZNF35 FROM ( "
					+ "SELECT  DISTINCT  * FROM STRUCT_TEMP_RESULT )A LEFT JOIN ( "
					+ "SELECT EXTRACT(YEAR FROM A.DV_DATE_VALUE) CAL_YEAR,A.CATEGORY, "
					+ "A.VOLTAGE_LEVEL,SUM(A.RZNF1  )RZNF1   , "
					+ "SUM(A.RZNF2  )RZNF2   ,SUM(A.RZNF3  )RZNF3   ,SUM(A.RZNF4  )RZNF4   ,SUM(A.RZNF5  )RZNF5   , "
					+ "SUM(A.RZNF6  )RZNF6   ,SUM(A.RZNF7  )RZNF7   ,SUM(A.RZNF8  )RZNF8   ,SUM(A.RZNF9  )RZNF9   , "
					+ "SUM(A.RZNF10 )RZNF10  ,SUM(A.RZNF11 )RZNF11  ,SUM(A.RZNF12 )RZNF12  ,SUM(A.RZNF13 )RZNF13  , "
					+ "SUM(A.RZNF14 )RZNF14  ,SUM(A.RZNF15 )RZNF15  ,SUM(A.RZNF16 )RZNF16  ,SUM(A.RZNF17 )RZNF17  , "
					+ "SUM(A.RZNF18 )RZNF18  ,SUM(A.RZNF19 )RZNF19  ,SUM(A.RZNF20 )RZNF20  ,SUM(A.RZNF21 )RZNF21  , "
					+ "SUM(A.RZNF22 )RZNF22  ,SUM(A.RZNF23 )RZNF23  ,SUM(A.RZNF24 )RZNF24  ,SUM(A.RZNF25 )RZNF25  , "
					+ "SUM(A.RZNF26 )RZNF26  ,SUM(A.RZNF27 )RZNF27  ,SUM(A.RZNF28 )RZNF28  ,SUM(A.RZNF29 )RZNF29  , "
					+ "SUM(A.RZNF30 )RZNF30  ,SUM(A.RZNF31 )RZNF31  ,SUM(A.RZNF32 )RZNF32  ,SUM(A.RZNF33 )RZNF33  , "
					+ "SUM(A.RZNF34 )RZNF34  ,SUM(A.RZNF35 )RZNF35   FROM (SELECT E.ORG_ALIAS_NAME, "
					+ "F.AREA_NAME FROM DV_ORG_ALIAS E INNER JOIN DV_ORG F ON E.DV_ORG_ID=F.DV_ORG_ID  "
					+ "AND F.AREA_NAME=? ) F INNER JOIN MID_ASSET_VALUE  A  " + // 2
					"ON A.ORG_NAME=F.ORG_ALIAS_NAME WHERE DATA_VERSION=? GROUP BY  " + // 3
					"EXTRACT(YEAR FROM A.DV_DATE_VALUE),A.CATEGORY,A.VOLTAGE_LEVEL) B "
					+ "ON(A.ASSET_CLASS_NAME=B.CATEGORY AND DECODE(A.VOLTAGE_NAME,NULL,'BLANK',A.VOLTAGE_NAME)= "
					+ "DECODE(B.VOLTAGE_LEVEL,NULL,'BLANK',B.VOLTAGE_LEVEL))ORDER BY ASSET_CLASS_CODE,INDEXOF  "
					+ "),LEVEL_TEMP_TAB AS (SELECT  A.CATEGORY,A.ASSET_CLASS_CODE,DECODE(LENGTH(A.ASSET_CLASS_CODE), "
					+ "3,NULL,SUBSTR(A.ASSET_CLASS_CODE,0,LENGTH(A.ASSET_CLASS_CODE)-3)) "
					+ "PARENT_CLASS_CODE,A.VOLTAGE_LEVEL, "
					+ "A.RZNF1   ,A.RZNF2   ,A.RZNF3   ,A.RZNF4   ,A.RZNF5   ,A.RZNF6   ,A.RZNF7   ,A.RZNF8   , "
					+ "A.RZNF9   ,A.RZNF10  ,A.RZNF11  ,A.RZNF12  ,A.RZNF13  ,A.RZNF14  ,A.RZNF15  ,A.RZNF16  , "
					+ "A.RZNF17  ,A.RZNF18  ,A.RZNF19  ,A.RZNF20  ,A.RZNF21  ,A.RZNF22  ,A.RZNF23  ,A.RZNF24  , "
					+ "A.RZNF25  ,A.RZNF26  ,A.RZNF27  ,A.RZNF28  ,A.RZNF29  ,A.RZNF30  ,A.RZNF31  ,A.RZNF32  , "
					+ "A.RZNF33  ,A.RZNF34  ,A.RZNF35 FROM RESULT_TEMP_TAB A ) "
					+ "SELECT B.CATEGORY,B.ASSET_CLASS_CODE,B.VOLTAGE_LEVEL, "
					+ "SUM(A.RZNF1  ) RZNF1   ,SUM(A.RZNF2  ) RZNF2   ,SUM(A.RZNF3  ) RZNF3   ,SUM(A.RZNF4  ) RZNF4   , "
					+ "SUM(A.RZNF5  ) RZNF5   ,SUM(A.RZNF6  ) RZNF6   ,SUM(A.RZNF7  ) RZNF7   ,SUM(A.RZNF8  ) RZNF8   , "
					+ "SUM(A.RZNF9  ) RZNF9   ,SUM(A.RZNF10 ) RZNF10  ,SUM(A.RZNF11 ) RZNF11  ,SUM(A.RZNF12 ) RZNF12  , "
					+ "SUM(A.RZNF13 ) RZNF13  ,SUM(A.RZNF14 ) RZNF14  ,SUM(A.RZNF15 ) RZNF15  ,SUM(A.RZNF16 ) RZNF16  , "
					+ "SUM(A.RZNF17 ) RZNF17  ,SUM(A.RZNF18 ) RZNF18  ,SUM(A.RZNF19 ) RZNF19  ,SUM(A.RZNF20 ) RZNF20  , "
					+ "SUM(A.RZNF21 ) RZNF21  ,SUM(A.RZNF22 ) RZNF22  ,SUM(A.RZNF23 ) RZNF23  ,SUM(A.RZNF24 ) RZNF24  , "
					+ "SUM(A.RZNF25 ) RZNF25  ,SUM(A.RZNF26 ) RZNF26  ,SUM(A.RZNF27 ) RZNF27  ,SUM(A.RZNF28 ) RZNF28  , "
					+ "SUM(A.RZNF29)RZNF29,SUM(A.RZNF30)RZNF30 ,SUM(A.RZNF31 +A.RZNF32 +A.RZNF33 +A.RZNF34 +A.RZNF35) RZNF31   "
					+ "FROM LEVEL_TEMP_TAB A , LEVEL_TEMP_TAB B WHERE A.ASSET_CLASS_CODE IN ( "
					+ "SELECT E.ASSET_CLASS_CODE FROM LEVEL_TEMP_TAB E START WITH E.ASSET_CLASS_CODE=B.ASSET_CLASS_CODE "
					+ "CONNECT BY E.PARENT_CLASS_CODE=PRIOR E.ASSET_CLASS_CODE ) "
					+ "GROUP BY B.CATEGORY,B.ASSET_CLASS_CODE,B.VOLTAGE_LEVEL ORDER BY ASSET_CLASS_CODE";

			try {
				new ReportOutput2().writeXLSX(reportSQL, templateFilePathAndName, targetFilePathAndName, reportName,
						voltageRelationCode, dataVersion, areaName, sheetName, startRowNumber, startColumnNumber);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			// sheetName = "A.3.2.1 资产结构-年龄结构（数量）";
			// reportName = "A.3.2.1 资产结构-年龄结构（数量）";

			sheetName = "A.3.2资产结构-年龄结构（数量）";
			reportName = "A.3.2资产结构-年龄结构（数量）";

			// dataVersion = "M_2019_2";
			dataVersion = "M_2019_6";// 20200612--PMS
			// dataVersion = "M_2019_8";//20200613--ERP // 循环输出表格中的内容,首先循环取出行,再根据行循环取出列
			startRowNumber = 5;
			startColumnNumber = 2;
			reportSQL = "WITH STRUCTRUE_TEMP_TAB AS ( SELECT A.ASSET_CLASS_NAME, "
					+ "A.ASSET_CLASS_CODE,B.VOLTAGE_NAME,B.INDEXOF FROM DV_ASSET_CLASS A "
					+ "LEFT JOIN (SELECT  C.VOLTAGE_NAME,B.DV_ASSET_CLASS_ID,B.INDEXOF   "
					+ "FROM DV_VOLTAGE_RELATION B  INNER JOIN DV_VOLTAGE_LEVEL C ON  "
					+ "B.DV_VOLTAGE_LEVEL_ID=C.DV_VOLTAGE_LEVEL_ID WHERE B.VOLTAGE_RELATION_CODE=? " + // 1
					")B ON A.DV_ASSET_CLASS_ID=B.DV_ASSET_CLASS_ID ORDER BY  " + "A.ASSET_CLASS_CODE ,B.INDEXOF ), "
					+ "SPAN_STRUCTURE_TAB AS (SELECT  "
					+ "A.ASSET_CLASS_NAME,DECODE(A.VOLTAGE_NAME,NULL,A.ASSET_CLASS_CODE, "
					+ "DECODE(LENGTH(TO_CHAR(A.INDEXOF)),1,A.ASSET_CLASS_CODE||'10'||A.INDEXOF, "
					+ "2,A.ASSET_CLASS_CODE||'1'||A.INDEXOF)) STRUCTURE_CODE, "
					+ "A.ASSET_CLASS_CODE,VOLTAGE_NAME,INDEXOF FROM STRUCTRUE_TEMP_TAB A   "
					+ "ORDER BY STRUCTURE_CODE,INDEXOF ),STRUCT_TEMP_RESULT AS ( "
					+ "SELECT A.ASSET_CLASS_NAME, A.ASSET_CLASS_CODE,B.VOLTAGE_NAME,B.INDEXOF   "
					+ "FROM DV_ASSET_CLASS A LEFT JOIN SPAN_STRUCTURE_TAB B  "
					+ "ON A.ASSET_CLASS_CODE=B.STRUCTURE_CODE UNION ALL SELECT  "
					+ "B.ASSET_CLASS_NAME,B.STRUCTURE_CODE ASSET_CLASS_CODE, "
					+ "B.VOLTAGE_NAME,B.INDEXOF FROM SPAN_STRUCTURE_TAB B  "
					+ "ORDER BY ASSET_CLASS_CODE,INDEXOF ),RESULT_TEMP_TAB AS ( "
					+ "SELECT A.ASSET_CLASS_NAME CATEGORY,A.ASSET_CLASS_CODE, " + "A.VOLTAGE_NAME VOLTAGE_LEVEL, "
					+ "DECODE(B.YEAR1_AMOUNT  ,NULL,0,B.YEAR1_AMOUNT  )YEAR1_AMOUNT     ,  "
					+ "DECODE(B.YEAR2_AMOUNT  ,NULL,0,B.YEAR2_AMOUNT  )YEAR2_AMOUNT     , "
					+ "DECODE(B.YEAR3_AMOUNT  ,NULL,0,B.YEAR3_AMOUNT  )YEAR3_AMOUNT     , "
					+ "DECODE(B.YEAR4_AMOUNT  ,NULL,0,B.YEAR4_AMOUNT  )YEAR4_AMOUNT     , "
					+ "DECODE(B.YEAR5_AMOUNT  ,NULL,0,B.YEAR5_AMOUNT  )YEAR5_AMOUNT     , "
					+ "DECODE(B.YEAR6_AMOUNT  ,NULL,0,B.YEAR6_AMOUNT  )YEAR6_AMOUNT     , "
					+ "DECODE(B.YEAR7_AMOUNT  ,NULL,0,B.YEAR7_AMOUNT  )YEAR7_AMOUNT     , "
					+ "DECODE(B.YEAR8_AMOUNT  ,NULL,0,B.YEAR8_AMOUNT  )YEAR8_AMOUNT     , "
					+ "DECODE(B.YEAR9_AMOUNT  ,NULL,0,B.YEAR9_AMOUNT  )YEAR9_AMOUNT     , "
					+ "DECODE(B.YEAR10_AMOUNT ,NULL,0,B.YEAR10_AMOUNT )YEAR10_AMOUNT    , "
					+ "DECODE(B.YEAR11_AMOUNT ,NULL,0,B.YEAR11_AMOUNT )YEAR11_AMOUNT    , "
					+ "DECODE(B.YEAR12_AMOUNT ,NULL,0,B.YEAR12_AMOUNT )YEAR12_AMOUNT    , "
					+ "DECODE(B.YEAR13_AMOUNT ,NULL,0,B.YEAR13_AMOUNT )YEAR13_AMOUNT    , "
					+ "DECODE(B.YEAR14_AMOUNT ,NULL,0,B.YEAR14_AMOUNT )YEAR14_AMOUNT    , "
					+ "DECODE(B.YEAR15_AMOUNT ,NULL,0,B.YEAR15_AMOUNT )YEAR15_AMOUNT    , "
					+ "DECODE(B.YEAR16_AMOUNT ,NULL,0,B.YEAR16_AMOUNT )YEAR16_AMOUNT    , "
					+ "DECODE(B.YEAR17_AMOUNT ,NULL,0,B.YEAR17_AMOUNT )YEAR17_AMOUNT    , "
					+ "DECODE(B.YEAR18_AMOUNT ,NULL,0,B.YEAR18_AMOUNT )YEAR18_AMOUNT    , "
					+ "DECODE(B.YEAR19_AMOUNT ,NULL,0,B.YEAR19_AMOUNT )YEAR19_AMOUNT    , "
					+ "DECODE(B.YEAR20_AMOUNT ,NULL,0,B.YEAR20_AMOUNT )YEAR20_AMOUNT    , "
					+ "DECODE(B.YEAR21_AMOUNT ,NULL,0,B.YEAR21_AMOUNT )YEAR21_AMOUNT    , "
					+ "DECODE(B.YEAR22_AMOUNT ,NULL,0,B.YEAR22_AMOUNT )YEAR22_AMOUNT    , "
					+ "DECODE(B.YEAR23_AMOUNT ,NULL,0,B.YEAR23_AMOUNT )YEAR23_AMOUNT    , "
					+ "DECODE(B.YEAR24_AMOUNT ,NULL,0,B.YEAR24_AMOUNT )YEAR24_AMOUNT    , "
					+ "DECODE(B.YEAR25_AMOUNT ,NULL,0,B.YEAR25_AMOUNT )YEAR25_AMOUNT    , "
					+ "DECODE(B.YEAR26_AMOUNT ,NULL,0,B.YEAR26_AMOUNT )YEAR26_AMOUNT    , "
					+ "DECODE(B.YEAR27_AMOUNT ,NULL,0,B.YEAR27_AMOUNT )YEAR27_AMOUNT    , "
					+ "DECODE(B.YEAR28_AMOUNT ,NULL,0,B.YEAR28_AMOUNT )YEAR28_AMOUNT    , "
					+ "DECODE(B.YEAR29_AMOUNT ,NULL,0,B.YEAR29_AMOUNT )YEAR29_AMOUNT    , "
					+ "DECODE(B.YEAR30_AMOUNT ,NULL,0,B.YEAR30_AMOUNT )YEAR30_AMOUNT    , "
					+ "DECODE(B.YEAR31_AMOUNT ,NULL,0,B.YEAR31_AMOUNT )YEAR31_AMOUNT      "
					+ "FROM (SELECT  DISTINCT  * FROM STRUCT_TEMP_RESULT )A LEFT JOIN  "
					+ "(SELECT EXTRACT(YEAR FROM A.DV_DATE_VALUE) CAL_YEAR, "
					+ "A.\"CATEGORY\",A.VOLTAGE_LEVEL,SUM(A.YEAR1_AMOUNT  )YEAR1_AMOUNT    ,  "
					+ "SUM(A.YEAR2_AMOUNT  )YEAR2_AMOUNT    ,SUM(A.YEAR3_AMOUNT  )YEAR3_AMOUNT    , "
					+ "SUM(A.YEAR4_AMOUNT  )YEAR4_AMOUNT    ,SUM(A.YEAR5_AMOUNT  )YEAR5_AMOUNT    , "
					+ "SUM(A.YEAR6_AMOUNT  )YEAR6_AMOUNT    ,SUM(A.YEAR7_AMOUNT  )YEAR7_AMOUNT    , "
					+ "SUM(A.YEAR8_AMOUNT  )YEAR8_AMOUNT    ,SUM(A.YEAR9_AMOUNT  )YEAR9_AMOUNT    , "
					+ "SUM(A.YEAR10_AMOUNT )YEAR10_AMOUNT   ,SUM(A.YEAR11_AMOUNT )YEAR11_AMOUNT   , "
					+ "SUM(A.YEAR12_AMOUNT )YEAR12_AMOUNT   ,SUM(A.YEAR13_AMOUNT )YEAR13_AMOUNT   , "
					+ "SUM(A.YEAR14_AMOUNT )YEAR14_AMOUNT   ,SUM(A.YEAR15_AMOUNT )YEAR15_AMOUNT   , "
					+ "SUM(A.YEAR16_AMOUNT )YEAR16_AMOUNT   ,SUM(A.YEAR17_AMOUNT )YEAR17_AMOUNT   , "
					+ "SUM(A.YEAR18_AMOUNT )YEAR18_AMOUNT   ,SUM(A.YEAR19_AMOUNT )YEAR19_AMOUNT   , "
					+ "SUM(A.YEAR20_AMOUNT )YEAR20_AMOUNT   ,SUM(A.YEAR21_AMOUNT )YEAR21_AMOUNT   , "
					+ "SUM(A.YEAR22_AMOUNT )YEAR22_AMOUNT   ,SUM(A.YEAR23_AMOUNT )YEAR23_AMOUNT   , "
					+ "SUM(A.YEAR24_AMOUNT )YEAR24_AMOUNT   ,SUM(A.YEAR25_AMOUNT )YEAR25_AMOUNT   , "
					+ "SUM(A.YEAR26_AMOUNT )YEAR26_AMOUNT   ,SUM(A.YEAR27_AMOUNT )YEAR27_AMOUNT   , "
					+ "SUM(A.YEAR28_AMOUNT )YEAR28_AMOUNT   ,SUM(A.YEAR29_AMOUNT )YEAR29_AMOUNT   , "
					+ "SUM(A.YEAR30_AMOUNT )YEAR30_AMOUNT   ,SUM(A.YEAR31_AMOUNT )YEAR31_AMOUNT    "
					+ " FROM (SELECT E.ORG_ALIAS_NAME,F.AREA_NAME FROM DV_ORG_ALIAS E  "
					+ "INNER JOIN DV_ORG F ON E.DV_ORG_ID=F.DV_ORG_ID AND F.AREA_NAME=? " + // 2
					") F INNER JOIN MID_ASSET_AMOUNT_PMS  A ON A.ORG_NAME=F.ORG_ALIAS_NAME  "
					+ "WHERE DATA_VERSION=?  GROUP BY EXTRACT(YEAR FROM A.DV_DATE_VALUE), " + // 3
					"A.CATEGORY,A.VOLTAGE_LEVEL ) B ON(A.ASSET_CLASS_NAME=B.CATEGORY "
					+ "AND DECODE(A.VOLTAGE_NAME,NULL,'BLANK',A.VOLTAGE_NAME)= "
					+ "DECODE(B.VOLTAGE_LEVEL,NULL,'BLANK',B.VOLTAGE_LEVEL)) "
					+ "ORDER BY ASSET_CLASS_CODE,INDEXOF ),LEVEL_TEMP_TAB AS ( "
					+ "SELECT  A.CATEGORY,A.ASSET_CLASS_CODE,DECODE(LENGTH(A.ASSET_CLASS_CODE), "
					+ "3,NULL,SUBSTR(A.ASSET_CLASS_CODE,0,LENGTH(A.ASSET_CLASS_CODE)-3)) "
					+ "PARENT_CLASS_CODE,A.VOLTAGE_LEVEL,A.YEAR1_AMOUNT  , A.YEAR2_AMOUNT  , "
					+ "A.YEAR3_AMOUNT  ,A.YEAR4_AMOUNT  ,A.YEAR5_AMOUNT  ,A.YEAR6_AMOUNT  , "
					+ "A.YEAR7_AMOUNT  ,A.YEAR8_AMOUNT  ,A.YEAR9_AMOUNT  ,A.YEAR10_AMOUNT , "
					+ "A.YEAR11_AMOUNT ,A.YEAR12_AMOUNT ,A.YEAR13_AMOUNT ,A.YEAR14_AMOUNT , "
					+ "A.YEAR15_AMOUNT ,A.YEAR16_AMOUNT ,A.YEAR17_AMOUNT ,A.YEAR18_AMOUNT , "
					+ "A.YEAR19_AMOUNT ,A.YEAR20_AMOUNT ,A.YEAR21_AMOUNT ,A.YEAR22_AMOUNT , "
					+ "A.YEAR23_AMOUNT ,A.YEAR24_AMOUNT ,A.YEAR25_AMOUNT ,A.YEAR26_AMOUNT , "
					+ "A.YEAR27_AMOUNT ,A.YEAR28_AMOUNT ,A.YEAR29_AMOUNT ,A.YEAR30_AMOUNT , "
					+ "A.YEAR31_AMOUNT  FROM RESULT_TEMP_TAB A ) "
					+ "SELECT B.CATEGORY,B.ASSET_CLASS_CODE,B.VOLTAGE_LEVEL, "
					+ "SUM(A.YEAR1_AMOUNT  )YEAR1_AMOUNT    , SUM(A.YEAR2_AMOUNT  )YEAR2_AMOUNT    , "
					+ "SUM(A.YEAR3_AMOUNT  )YEAR3_AMOUNT    ,SUM(A.YEAR4_AMOUNT  )YEAR4_AMOUNT    , "
					+ "SUM(A.YEAR5_AMOUNT  )YEAR5_AMOUNT    ,SUM(A.YEAR6_AMOUNT  )YEAR6_AMOUNT    , "
					+ "SUM(A.YEAR7_AMOUNT  )YEAR7_AMOUNT    ,SUM(A.YEAR8_AMOUNT  )YEAR8_AMOUNT    , "
					+ "SUM(A.YEAR9_AMOUNT  )YEAR9_AMOUNT    ,SUM(A.YEAR10_AMOUNT )YEAR10_AMOUNT   , "
					+ "SUM(A.YEAR11_AMOUNT )YEAR11_AMOUNT   ,SUM(A.YEAR12_AMOUNT )YEAR12_AMOUNT   , "
					+ "SUM(A.YEAR13_AMOUNT )YEAR13_AMOUNT   ,SUM(A.YEAR14_AMOUNT )YEAR14_AMOUNT   , "
					+ "SUM(A.YEAR15_AMOUNT )YEAR15_AMOUNT   ,SUM(A.YEAR16_AMOUNT )YEAR16_AMOUNT   , "
					+ "SUM(A.YEAR17_AMOUNT )YEAR17_AMOUNT   ,SUM(A.YEAR18_AMOUNT )YEAR18_AMOUNT   , "
					+ "SUM(A.YEAR19_AMOUNT )YEAR19_AMOUNT   ,SUM(A.YEAR20_AMOUNT )YEAR20_AMOUNT   , "
					+ "SUM(A.YEAR21_AMOUNT )YEAR21_AMOUNT   ,SUM(A.YEAR22_AMOUNT )YEAR22_AMOUNT   , "
					+ "SUM(A.YEAR23_AMOUNT )YEAR23_AMOUNT   ,SUM(A.YEAR24_AMOUNT )YEAR24_AMOUNT   , "
					+ "SUM(A.YEAR25_AMOUNT )YEAR25_AMOUNT   ,SUM(A.YEAR26_AMOUNT )YEAR26_AMOUNT   , "
					+ "SUM(A.YEAR27_AMOUNT )YEAR27_AMOUNT   ,SUM(A.YEAR28_AMOUNT )YEAR28_AMOUNT   , "
					+ "SUM(A.YEAR29_AMOUNT )YEAR29_AMOUNT   ,SUM(A.YEAR30_AMOUNT )YEAR30_AMOUNT   , "
					+ "SUM(A.YEAR31_AMOUNT )YEAR31_AMOUNT   FROM LEVEL_TEMP_TAB A , LEVEL_TEMP_TAB B   "
					+ "WHERE A.ASSET_CLASS_CODE IN (SELECT E.ASSET_CLASS_CODE  "
					+ "FROM LEVEL_TEMP_TAB E START WITH E.ASSET_CLASS_CODE=B.ASSET_CLASS_CODE "
					+ "CONNECT BY E.PARENT_CLASS_CODE=PRIOR E.ASSET_CLASS_CODE) "
					+ "GROUP BY B.CATEGORY,B.ASSET_CLASS_CODE,B.VOLTAGE_LEVEL  " + "ORDER BY ASSET_CLASS_CODE ";

			try {
				new ReportOutput2().writeXLSX(reportSQL, templateFilePathAndName, targetFilePathAndName, reportName,
						voltageRelationCode, dataVersion, areaName, sheetName, startRowNumber, startColumnNumber);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			// sheetName = "A.3.2.2 资产结构-年龄结构（规模）";
			// reportName = "A.3.2.2 资产结构-年龄结构（规模）";

			sheetName = "A.3.3 资产结构-年龄结构（规模）";
			reportName = "A.3.3 资产结构-年龄结构（规模）";
			// dataVersion = "M_2019_2";
			dataVersion = "M_2019_6";// 20200612--PMS
			// dataVersion = "M_2019_8"; //20200613--ERP
			// 循环输出表格中的内容,首先循环取出行,再根据行循环取出列
			startRowNumber = 5;
			startColumnNumber = 2;
			reportSQL = "WITH STRUCTRUE_TEMP_TAB AS (SELECT  " + "A.ASSET_CLASS_NAME,A.ASSET_CLASS_CODE, "
					+ "B.VOLTAGE_NAME,B.INDEXOF FROM DV_ASSET_CLASS A "
					+ "LEFT JOIN (SELECT  C.VOLTAGE_NAME,B.DV_ASSET_CLASS_ID, "
					+ "B.INDEXOF FROM DV_VOLTAGE_RELATION B  INNER JOIN  "
					+ "DV_VOLTAGE_LEVEL C ON B.DV_VOLTAGE_LEVEL_ID=C.DV_VOLTAGE_LEVEL_ID  "
					+ "WHERE B.VOLTAGE_RELATION_CODE=? )B ON A.DV_ASSET_CLASS_ID=B.DV_ASSET_CLASS_ID  " // 1
					+ " WHERE  A.IS_LINE IN (1,2,3) " // 通过设备是否含有容量对模板进行裁剪控制添加的WHERE子句
					+ "ORDER BY A.ASSET_CLASS_CODE , B.INDEXOF ), " + "SPAN_STRUCTURE_TAB AS ( SELECT  "
					+ "A.ASSET_CLASS_NAME,DECODE(A.VOLTAGE_NAME,NULL,A.ASSET_CLASS_CODE, "
					+ "DECODE(LENGTH(TO_CHAR(A.INDEXOF)),1,A.ASSET_CLASS_CODE||'10'||A.INDEXOF, "
					+ "2,A.ASSET_CLASS_CODE||'1'||A.INDEXOF)) STRUCTURE_CODE,A.ASSET_CLASS_CODE, "
					+ "VOLTAGE_NAME,INDEXOF FROM STRUCTRUE_TEMP_TAB A  ORDER BY STRUCTURE_CODE, "
					+ "INDEXOF ),STRUCT_TEMP_RESULT AS ( SELECT A.ASSET_CLASS_NAME,  "
					+ "A.ASSET_CLASS_CODE,B.VOLTAGE_NAME,B.INDEXOF FROM DV_ASSET_CLASS A  "
					+ "LEFT JOIN SPAN_STRUCTURE_TAB B ON A.ASSET_CLASS_CODE=B.STRUCTURE_CODE  "
					+ " WHERE  A.IS_LINE IN (1,2,3) "// 通过设备是否含有容量对模板进行裁剪控制添加的WHERE子句
					+ "UNION ALL SELECT B.ASSET_CLASS_NAME,B.STRUCTURE_CODE ASSET_CLASS_CODE, "
					+ "B.VOLTAGE_NAME,B.INDEXOF FROM SPAN_STRUCTURE_TAB B ORDER BY  "
					+ "ASSET_CLASS_CODE,INDEXOF ),RESULT_TEMP_TAB AS ( "
					+ "SELECT A.ASSET_CLASS_NAME CATEGORY,A.ASSET_CLASS_CODE, " + "A.VOLTAGE_NAME VOLTAGE_LEVEL, "
					+ "DECODE(B.YEAR1_CAPACITY  ,NULL,0,B.YEAR1_CAPACITY  )YEAR1_CAPACITY     ,  "
					+ "DECODE(B.YEAR2_CAPACITY  ,NULL,0,B.YEAR2_CAPACITY  )YEAR2_CAPACITY     , "
					+ "DECODE(B.YEAR3_CAPACITY  ,NULL,0,B.YEAR3_CAPACITY  )YEAR3_CAPACITY     , "
					+ "DECODE(B.YEAR4_CAPACITY  ,NULL,0,B.YEAR4_CAPACITY  )YEAR4_CAPACITY     , "
					+ "DECODE(B.YEAR5_CAPACITY  ,NULL,0,B.YEAR5_CAPACITY  )YEAR5_CAPACITY     , "
					+ "DECODE(B.YEAR6_CAPACITY  ,NULL,0,B.YEAR6_CAPACITY  )YEAR6_CAPACITY     , "
					+ "DECODE(B.YEAR7_CAPACITY  ,NULL,0,B.YEAR7_CAPACITY  )YEAR7_CAPACITY     , "
					+ "DECODE(B.YEAR8_CAPACITY  ,NULL,0,B.YEAR8_CAPACITY  )YEAR8_CAPACITY     , "
					+ "DECODE(B.YEAR9_CAPACITY  ,NULL,0,B.YEAR9_CAPACITY  )YEAR9_CAPACITY     , "
					+ "DECODE(B.YEAR10_CAPACITY ,NULL,0,B.YEAR10_CAPACITY )YEAR10_CAPACITY    , "
					+ "DECODE(B.YEAR11_CAPACITY ,NULL,0,B.YEAR11_CAPACITY )YEAR11_CAPACITY    , "
					+ "DECODE(B.YEAR12_CAPACITY ,NULL,0,B.YEAR12_CAPACITY )YEAR12_CAPACITY    , "
					+ "DECODE(B.YEAR13_CAPACITY ,NULL,0,B.YEAR13_CAPACITY )YEAR13_CAPACITY    , "
					+ "DECODE(B.YEAR14_CAPACITY ,NULL,0,B.YEAR14_CAPACITY )YEAR14_CAPACITY    , "
					+ "DECODE(B.YEAR15_CAPACITY ,NULL,0,B.YEAR15_CAPACITY )YEAR15_CAPACITY    , "
					+ "DECODE(B.YEAR16_CAPACITY ,NULL,0,B.YEAR16_CAPACITY )YEAR16_CAPACITY    , "
					+ "DECODE(B.YEAR17_CAPACITY ,NULL,0,B.YEAR17_CAPACITY )YEAR17_CAPACITY    , "
					+ "DECODE(B.YEAR18_CAPACITY ,NULL,0,B.YEAR18_CAPACITY )YEAR18_CAPACITY    , "
					+ "DECODE(B.YEAR19_CAPACITY ,NULL,0,B.YEAR19_CAPACITY )YEAR19_CAPACITY    , "
					+ "DECODE(B.YEAR20_CAPACITY ,NULL,0,B.YEAR20_CAPACITY )YEAR20_CAPACITY    , "
					+ "DECODE(B.YEAR21_CAPACITY ,NULL,0,B.YEAR21_CAPACITY )YEAR21_CAPACITY    , "
					+ "DECODE(B.YEAR22_CAPACITY ,NULL,0,B.YEAR22_CAPACITY )YEAR22_CAPACITY    , "
					+ "DECODE(B.YEAR23_CAPACITY ,NULL,0,B.YEAR23_CAPACITY )YEAR23_CAPACITY    , "
					+ "DECODE(B.YEAR24_CAPACITY ,NULL,0,B.YEAR24_CAPACITY )YEAR24_CAPACITY    , "
					+ "DECODE(B.YEAR25_CAPACITY ,NULL,0,B.YEAR25_CAPACITY )YEAR25_CAPACITY    , "
					+ "DECODE(B.YEAR26_CAPACITY ,NULL,0,B.YEAR26_CAPACITY )YEAR26_CAPACITY    , "
					+ "DECODE(B.YEAR27_CAPACITY ,NULL,0,B.YEAR27_CAPACITY )YEAR27_CAPACITY    , "
					+ "DECODE(B.YEAR28_CAPACITY ,NULL,0,B.YEAR28_CAPACITY )YEAR28_CAPACITY    , "
					+ "DECODE(B.YEAR29_CAPACITY ,NULL,0,B.YEAR29_CAPACITY )YEAR29_CAPACITY    , "
					+ "DECODE(B.YEAR30_CAPACITY ,NULL,0,B.YEAR30_CAPACITY )YEAR30_CAPACITY    , "
					+ "DECODE(B.YEAR31_CAPACITY ,NULL,0,B.YEAR31_CAPACITY )YEAR31_CAPACITY      "
					+ "FROM (SELECT  DISTINCT  * FROM STRUCT_TEMP_RESULT )A LEFT JOIN  ( "
					+ "SELECT EXTRACT(YEAR FROM A.DV_DATE_VALUE) CAL_YEAR,A.CATEGORY,A.VOLTAGE_LEVEL, "
					+ "SUM(A.YEAR1_CAPACITY  )YEAR1_CAPACITY    ,  " + "SUM(A.YEAR2_CAPACITY  )YEAR2_CAPACITY    , "
					+ "SUM(A.YEAR3_CAPACITY  )YEAR3_CAPACITY    , " + "SUM(A.YEAR4_CAPACITY  )YEAR4_CAPACITY    , "
					+ "SUM(A.YEAR5_CAPACITY  )YEAR5_CAPACITY    , " + "SUM(A.YEAR6_CAPACITY  )YEAR6_CAPACITY    , "
					+ "SUM(A.YEAR7_CAPACITY  )YEAR7_CAPACITY    , " + "SUM(A.YEAR8_CAPACITY  )YEAR8_CAPACITY    , "
					+ "SUM(A.YEAR9_CAPACITY  )YEAR9_CAPACITY    , " + "SUM(A.YEAR10_CAPACITY )YEAR10_CAPACITY   , "
					+ "SUM(A.YEAR11_CAPACITY )YEAR11_CAPACITY   , " + "SUM(A.YEAR12_CAPACITY )YEAR12_CAPACITY   , "
					+ "SUM(A.YEAR13_CAPACITY )YEAR13_CAPACITY   , " + "SUM(A.YEAR14_CAPACITY )YEAR14_CAPACITY   , "
					+ "SUM(A.YEAR15_CAPACITY )YEAR15_CAPACITY   , " + "SUM(A.YEAR16_CAPACITY )YEAR16_CAPACITY   , "
					+ "SUM(A.YEAR17_CAPACITY )YEAR17_CAPACITY   , " + "SUM(A.YEAR18_CAPACITY )YEAR18_CAPACITY   , "
					+ "SUM(A.YEAR19_CAPACITY )YEAR19_CAPACITY   , " + "SUM(A.YEAR20_CAPACITY )YEAR20_CAPACITY   , "
					+ "SUM(A.YEAR21_CAPACITY )YEAR21_CAPACITY   , " + "SUM(A.YEAR22_CAPACITY )YEAR22_CAPACITY   , "
					+ "SUM(A.YEAR23_CAPACITY )YEAR23_CAPACITY   , " + "SUM(A.YEAR24_CAPACITY )YEAR24_CAPACITY   , "
					+ "SUM(A.YEAR25_CAPACITY )YEAR25_CAPACITY   , " + "SUM(A.YEAR26_CAPACITY )YEAR26_CAPACITY   , "
					+ "SUM(A.YEAR27_CAPACITY )YEAR27_CAPACITY   , " + "SUM(A.YEAR28_CAPACITY )YEAR28_CAPACITY   , "
					+ "SUM(A.YEAR29_CAPACITY )YEAR29_CAPACITY   , " + "SUM(A.YEAR30_CAPACITY )YEAR30_CAPACITY   , "
					+ "SUM(A.YEAR31_CAPACITY )YEAR31_CAPACITY    FROM  "
					+ "(SELECT E.ORG_ALIAS_NAME,F.AREA_NAME FROM DV_ORG_ALIAS E  "
					+ "INNER JOIN DV_ORG F ON E.DV_ORG_ID=F.DV_ORG_ID  " + "AND F.AREA_NAME=? " + // 2
					") F INNER JOIN MID_ASSET_AMOUNT_PMS  A ON  " + "A.ORG_NAME=F.ORG_ALIAS_NAME WHERE DATA_VERSION=?  " + // 3
					"GROUP BY EXTRACT(YEAR FROM A.DV_DATE_VALUE), " + "A.CATEGORY,A.VOLTAGE_LEVEL) B ON( "
					+ "A.ASSET_CLASS_NAME=B.CATEGORY AND  "
					+ "DECODE(A.VOLTAGE_NAME,NULL,'BLANK',A.VOLTAGE_NAME)=DECODE(B.VOLTAGE_LEVEL,NULL,'BLANK',B.VOLTAGE_LEVEL) "
					+ ")ORDER BY ASSET_CLASS_CODE,INDEXOF ),LEVEL_TEMP_TAB AS ( "
					+ "SELECT  A.CATEGORY,A.ASSET_CLASS_CODE,DECODE(LENGTH(A.ASSET_CLASS_CODE), "
					+ "3,NULL,SUBSTR(A.ASSET_CLASS_CODE,0,LENGTH(A.ASSET_CLASS_CODE)-3)) "
					+ "PARENT_CLASS_CODE,A.VOLTAGE_LEVEL,A.YEAR1_CAPACITY  , A.YEAR2_CAPACITY  ,A.YEAR3_CAPACITY  , "
					+ "A.YEAR4_CAPACITY  ,A.YEAR5_CAPACITY  ,A.YEAR6_CAPACITY  ,A.YEAR7_CAPACITY  ,A.YEAR8_CAPACITY  , "
					+ "A.YEAR9_CAPACITY  ,A.YEAR10_CAPACITY ,A.YEAR11_CAPACITY ,A.YEAR12_CAPACITY ,A.YEAR13_CAPACITY , "
					+ "A.YEAR14_CAPACITY ,A.YEAR15_CAPACITY ,A.YEAR16_CAPACITY ,A.YEAR17_CAPACITY ,A.YEAR18_CAPACITY , "
					+ "A.YEAR19_CAPACITY ,A.YEAR20_CAPACITY ,A.YEAR21_CAPACITY ,A.YEAR22_CAPACITY ,A.YEAR23_CAPACITY , "
					+ "A.YEAR24_CAPACITY ,A.YEAR25_CAPACITY ,A.YEAR26_CAPACITY ,A.YEAR27_CAPACITY ,A.YEAR28_CAPACITY , "
					+ "A.YEAR29_CAPACITY ,A.YEAR30_CAPACITY ,A.YEAR31_CAPACITY  FROM RESULT_TEMP_TAB A ) "
					+ "SELECT B.CATEGORY,B.ASSET_CLASS_CODE,B.VOLTAGE_LEVEL,SUM(A.YEAR1_CAPACITY  )YEAR1_CAPACITY    ,  "
					+ "SUM(A.YEAR2_CAPACITY  )YEAR2_CAPACITY    ,SUM(A.YEAR3_CAPACITY  )YEAR3_CAPACITY    , "
					+ "SUM(A.YEAR4_CAPACITY  )YEAR4_CAPACITY    ,SUM(A.YEAR5_CAPACITY  )YEAR5_CAPACITY    , "
					+ "SUM(A.YEAR6_CAPACITY  )YEAR6_CAPACITY    ,SUM(A.YEAR7_CAPACITY  )YEAR7_CAPACITY    , "
					+ "SUM(A.YEAR8_CAPACITY  )YEAR8_CAPACITY    ,SUM(A.YEAR9_CAPACITY  )YEAR9_CAPACITY    , "
					+ "SUM(A.YEAR10_CAPACITY )YEAR10_CAPACITY   ,SUM(A.YEAR11_CAPACITY )YEAR11_CAPACITY   , "
					+ "SUM(A.YEAR12_CAPACITY )YEAR12_CAPACITY   ,SUM(A.YEAR13_CAPACITY )YEAR13_CAPACITY   , "
					+ "SUM(A.YEAR14_CAPACITY )YEAR14_CAPACITY   ,SUM(A.YEAR15_CAPACITY )YEAR15_CAPACITY   , "
					+ "SUM(A.YEAR16_CAPACITY )YEAR16_CAPACITY   ,SUM(A.YEAR17_CAPACITY )YEAR17_CAPACITY   , "
					+ "SUM(A.YEAR18_CAPACITY )YEAR18_CAPACITY   ,SUM(A.YEAR19_CAPACITY )YEAR19_CAPACITY   , "
					+ "SUM(A.YEAR20_CAPACITY )YEAR20_CAPACITY   ,SUM(A.YEAR21_CAPACITY )YEAR21_CAPACITY   , "
					+ "SUM(A.YEAR22_CAPACITY )YEAR22_CAPACITY   ,SUM(A.YEAR23_CAPACITY )YEAR23_CAPACITY   , "
					+ "SUM(A.YEAR24_CAPACITY )YEAR24_CAPACITY   ,SUM(A.YEAR25_CAPACITY )YEAR25_CAPACITY   , "
					+ "SUM(A.YEAR26_CAPACITY )YEAR26_CAPACITY   ,SUM(A.YEAR27_CAPACITY )YEAR27_CAPACITY   , "
					+ "SUM(A.YEAR28_CAPACITY )YEAR28_CAPACITY   ,SUM(A.YEAR29_CAPACITY )YEAR29_CAPACITY   , "
					+ "SUM(A.YEAR30_CAPACITY )YEAR30_CAPACITY   ,SUM(A.YEAR31_CAPACITY )YEAR31_CAPACITY    "
					+ "FROM LEVEL_TEMP_TAB A , LEVEL_TEMP_TAB B WHERE A.ASSET_CLASS_CODE IN ( "
					+ "SELECT E.ASSET_CLASS_CODE FROM LEVEL_TEMP_TAB E  "
					+ "START WITH E.ASSET_CLASS_CODE=B.ASSET_CLASS_CODE "
					+ "CONNECT BY E.PARENT_CLASS_CODE=PRIOR E.ASSET_CLASS_CODE "
					+ ")GROUP BY B.CATEGORY,B.ASSET_CLASS_CODE,B.VOLTAGE_LEVEL ORDER BY ASSET_CLASS_CODE";

			try {
				new ReportOutput2().writeXLSX(reportSQL, templateFilePathAndName, targetFilePathAndName, reportName,
						voltageRelationCode, dataVersion, areaName, sheetName, startRowNumber, startColumnNumber);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			sheetName = "A.2.1 新增资产";
			reportName = "A.2.1 新增资产";
			// dataVersion = "M_2019_2";
			// String pmsDataVersion = "M_2019_2";// 20200612--PMS--河北
			// String erpDataVersion = "M_2019_2";// 20200613--ERP--河北
			String pmsDataVersion = "M_2019_3";// 20200612--PMS--湖北
			String erpDataVersion = "M_2019_3";// 20200613--ERP--湖北
			// 循环输出表格中的内容,首先循环取出行,再根据行循环取出列
			startRowNumber = 4;
			startColumnNumber = 2;
			reportSQL = "WITH STRUCTRUE_TEMP_TAB AS (SELECT A.ASSET_CLASS_NAME,A.ASSET_CLASS_CODE,"
					+ "B.VOLTAGE_NAME,B.INDEXOF FROM DV_ASSET_CLASS A " + "LEFT JOIN  ( SELECT  C.VOLTAGE_NAME, "
					+ "B.DV_ASSET_CLASS_ID,B.INDEXOF FROM  " + "DV_VOLTAGE_RELATION B INNER JOIN DV_VOLTAGE_LEVEL C  "
					+ "ON B.DV_VOLTAGE_LEVEL_ID=C.DV_VOLTAGE_LEVEL_ID  " + "WHERE B.VOLTAGE_RELATION_CODE=? )B  " + // 1
					"ON A.DV_ASSET_CLASS_ID=B.DV_ASSET_CLASS_ID  " + "ORDER BY A.ASSET_CLASS_CODE ,B.INDEXOF ), "
					+ "SPAN_STRUCTURE_TAB AS (SELECT A.ASSET_CLASS_NAME, "
					+ "DECODE(A.VOLTAGE_NAME,NULL,A.ASSET_CLASS_CODE, "
					+ "DECODE(LENGTH(TO_CHAR(A.INDEXOF)),1,A.ASSET_CLASS_CODE||'10'||A.INDEXOF, "
					+ "2,A.ASSET_CLASS_CODE||'1'||A.INDEXOF)) "
					+ " STRUCTURE_CODE,A.ASSET_CLASS_CODE,VOLTAGE_NAME,INDEXOF "
					+ "FROM STRUCTRUE_TEMP_TAB A  ORDER BY STRUCTURE_CODE,INDEXOF ), "
					+ "STRUCT_TEMP_RESULT AS (SELECT A.ASSET_CLASS_NAME,  "
					+ "A.ASSET_CLASS_CODE,B.VOLTAGE_NAME,B.INDEXOF FROM  "
					+ "DV_ASSET_CLASS A LEFT JOIN SPAN_STRUCTURE_TAB B  "
					+ "ON A.ASSET_CLASS_CODE=B.STRUCTURE_CODE UNION ALL  "
					+ "SELECT B.ASSET_CLASS_NAME,B.STRUCTURE_CODE ASSET_CLASS_CODE, "
					+ "B.VOLTAGE_NAME,B.INDEXOF FROM  " + "SPAN_STRUCTURE_TAB B ORDER BY ASSET_CLASS_CODE, "
					+ "INDEXOF ),RESULT_TEMP_TAB AS (SELECT A.ASSET_CLASS_NAME CATEGORY, "
					+ "A.ASSET_CLASS_CODE,A.VOLTAGE_NAME VOLTAGE_LEVEL, "
					+ "DECODE(B.THIS_YEAR_CAPITALIZ_ORIG,NULL,0,B.THIS_YEAR_CAPITALIZ_ORIG) THIS_YEAR_CAPITALIZ_ORIG, "
					+ "DECODE(B.USER_HANDOVER_ORIG,NULL,0,B.USER_HANDOVER_ORIG) USER_HANDOVER_ORIG, "
					+ "DECODE(B.SPORADIC_PURCHASES_ORIG,NULL,0,B.SPORADIC_PURCHASES_ORIG) SPORADIC_PURCHASES_ORIG, "
					+ "DECODE(B.ALLOCATION_ORIG,NULL,0,B.ALLOCATION_ORIG) ALLOCATION_ORIG, "
					+ "DECODE(B.OTHERS_ORIG,NULL,0,B.OTHERS_ORIG) OTHERS_ORIG "
					+ "FROM (SELECT  DISTINCT  * FROM STRUCT_TEMP_RESULT )A  "
					+ "LEFT JOIN (SELECT EXTRACT(YEAR FROM A.DV_DATE_VALUE) CAL_YEAR, "
					+ "A.CATEGORY,A.VOLTAGE_LEVEL,SUM(A.THIS_YEAR_CAPITALIZ_ORIG) THIS_YEAR_CAPITALIZ_ORIG, "
					+ "SUM(A.USER_HANDOVER_ORIG) USER_HANDOVER_ORIG, "
					+ "SUM(A.SPORADIC_PURCHASES_ORIG) SPORADIC_PURCHASES_ORIG, "
					+ "SUM(A.ALLOCATION_ORIG) ALLOCATION_ORIG,SUM(A.OTHERS_ORIG) OTHERS_ORIG  "
					+ "FROM (SELECT E.ORG_ALIAS_NAME,F.AREA_NAME FROM DV_ORG_ALIAS E  "
					+ "INNER JOIN DV_ORG F ON E.DV_ORG_ID=F.DV_ORG_ID AND  "
					+ "F.AREA_NAME IN (SELECT A.AREA_NAME FROM DV_AREA A WHERE   "
					+ "EXISTS (SELECT 1 FROM DV_AREA B WHERE (DECODE( B.IS_LEAF,0, 1,0	)=1  "
					+ "AND B.AREA_NAME=? AND (SUBSTR(A.AREA_CODE,0,LENGTH(A.AREA_CODE)-3)=B.AREA_CODE OR  " + // 2
					"(A.IS_LEAF=0 AND B.AREA_CODE=A.AREA_CODE )))OR  "
					+ "(DECODE( B.IS_LEAF,0, 1,0	)=0 AND B.AREA_NAME= ? AND  " + // 3
					"A.AREA_CODE=B.AREA_CODE )))) F INNER JOIN MID_ASSET_INCREASED_ERP A  "
					+ "ON A.ORG_NAME=F.ORG_ALIAS_NAME WHERE DATA_VERSION=?  " + // 4
					"GROUP BY EXTRACT(YEAR FROM A.DV_DATE_VALUE),A.CATEGORY,A.VOLTAGE_LEVEL "
					+ ") B ON(A.ASSET_CLASS_NAME=B.CATEGORY AND  "
					+ "DECODE(A.VOLTAGE_NAME,NULL,'BLANK',A.VOLTAGE_NAME)=DECODE(B.VOLTAGE_LEVEL,NULL,'BLANK',B.VOLTAGE_LEVEL) "
					+ ")ORDER BY ASSET_CLASS_CODE,INDEXOF ),LEVEL_TEMP_TAB AS (  "
					+ "SELECT  A.CATEGORY,A.ASSET_CLASS_CODE,DECODE(LENGTH(A.ASSET_CLASS_CODE), "
					+ "3,NULL,SUBSTR(A.ASSET_CLASS_CODE,0,LENGTH(A.ASSET_CLASS_CODE)-3))PARENT_CLASS_CODE, "
					+ "A.VOLTAGE_LEVEL,A.THIS_YEAR_CAPITALIZ_ORIG,A.USER_HANDOVER_ORIG, "
					+ "A.SPORADIC_PURCHASES_ORIG,A.ALLOCATION_ORIG,A.OTHERS_ORIG FROM  "
					+ "RESULT_TEMP_TAB A),RESULT_TEMP_TAB_PMS AS (SELECT  "
					+ "A.ASSET_CLASS_NAME CATEGORY,A.ASSET_CLASS_CODE,A.VOLTAGE_NAME VOLTAGE_LEVEL, "
					+ "DECODE(B.THIS_YEAR_CAPITALIZ_QUANTITY,NULL,0,B.THIS_YEAR_CAPITALIZ_QUANTITY) THIS_YEAR_CAPITALIZ_QUANTITY, "
					+ "DECODE(B.USER_HANDOVER_QUANTITY,NULL,0,B.USER_HANDOVER_QUANTITY) USER_HANDOVER_QUANTITY, "
					+ "DECODE(B.SPORADIC_PURCHASES_QUANTITY,NULL,0,B.SPORADIC_PURCHASES_QUANTITY) SPORADIC_PURCHASES_QUANTITY, "
					+ "DECODE(B.ALLOCATION_QUANTITY,NULL,0,B.ALLOCATION_QUANTITY) ALLOCATION_QUANTITY, "
					+ "DECODE(B.OTHERS_QUANTITY,NULL,0,B.OTHERS_QUANTITY) OTHERS_QUANTITY, "
					+ "DECODE(B.THIS_YEAR_CAPITALIZ_CAPACITY,NULL,0,B.THIS_YEAR_CAPITALIZ_CAPACITY) THIS_YEAR_CAPITALIZ_CAPACITY, "
					+ "DECODE(B.USER_HANDOVER_CAPACITY,NULL,0,B.USER_HANDOVER_CAPACITY) USER_HANDOVER_CAPACITY, "
					+ "DECODE(B.SPORADIC_PURCHASES_CAPACITY,NULL,0,B.SPORADIC_PURCHASES_CAPACITY) SPORADIC_PURCHASES_CAPACITY, "
					+ "DECODE(B.ALLOCATION_CAPACITY,NULL,0,B.ALLOCATION_CAPACITY) ALLOCATION_CAPACITY, "
					+ "DECODE(B.OTHERS_CAPACITY,NULL,0,B.OTHERS_CAPACITY) OTHERS_CAPACITY FROM  "
					+ "(SELECT  DISTINCT  * FROM STRUCT_TEMP_RESULT )A LEFT JOIN  "
					+ "(SELECT EXTRACT(YEAR FROM A.DV_DATE_VALUE) CAL_YEAR, " + "A.CATEGORY,A.VOLTAGE_LEVEL, "
					+ "SUM(THIS_YEAR_CAPITALIZ_QUANTITY) THIS_YEAR_CAPITALIZ_QUANTITY, "
					+ "SUM(USER_HANDOVER_QUANTITY) USER_HANDOVER_QUANTITY, "
					+ "SUM(SPORADIC_PURCHASES_QUANTITY) SPORADIC_PURCHASES_QUANTITY, "
					+ "SUM(ALLOCATION_QUANTITY) ALLOCATION_QUANTITY, " + "SUM(OTHERS_QUANTITY) OTHERS_QUANTITY, "
					+ "SUM(THIS_YEAR_CAPITALIZ_CAPACITY) THIS_YEAR_CAPITALIZ_CAPACITY, "
					+ "SUM(USER_HANDOVER_CAPACITY) USER_HANDOVER_CAPACITY, "
					+ "SUM(SPORADIC_PURCHASES_CAPACITY) SPORADIC_PURCHASES_CAPACITY, "
					+ "SUM(ALLOCATION_CAPACITY) ALLOCATION_CAPACITY, " + "SUM(OTHERS_CAPACITY) OTHERS_CAPACITY  FROM  "
					+ "(SELECT E.ORG_ALIAS_NAME,F.AREA_NAME FROM DV_ORG_ALIAS E  "
					+ "INNER JOIN DV_ORG F ON E.DV_ORG_ID=F.DV_ORG_ID AND F.AREA_NAME IN  "
					+ "(SELECT A.AREA_NAME FROM DV_AREA A WHERE   " + "EXISTS (SELECT 1 FROM DV_AREA B WHERE  "
					+ "(DECODE( B.IS_LEAF,0, 1,0	)=1 AND B.AREA_NAME=?  " + // 5
					"AND (SUBSTR(A.AREA_CODE,0,LENGTH(A.AREA_CODE)-3)=B.AREA_CODE "
					+ "OR (A.IS_LEAF=0 AND B.AREA_CODE=A.AREA_CODE ))) " + "OR (DECODE( B.IS_LEAF,0, 1,0	)=0  "
					+ "AND B.AREA_NAME=?  AND A.AREA_CODE=B.AREA_CODE)))) F  " + // 6
					"INNER JOIN MID_ASSET_INCREASED_PMS A  " + "ON A.ORG_NAME=F.ORG_ALIAS_NAME WHERE DATA_VERSION=?   " + // 7
					"GROUP BY EXTRACT(YEAR FROM A.DV_DATE_VALUE),A.CATEGORY,A.VOLTAGE_LEVEL "
					+ ") B ON(A.ASSET_CLASS_NAME=B.CATEGORY AND  "
					+ "DECODE(A.VOLTAGE_NAME,NULL,'BLANK',A.VOLTAGE_NAME)= "
					+ "DECODE(B.VOLTAGE_LEVEL,NULL,'BLANK',B.VOLTAGE_LEVEL) " + ")ORDER BY ASSET_CLASS_CODE, "
					+ "INDEXOF ),LEVEL_TEMP_TAB_PMS AS (SELECT  "
					+ " A.CATEGORY,A.ASSET_CLASS_CODE,DECODE(LENGTH(A.ASSET_CLASS_CODE), "
					+ "3,NULL,SUBSTR(A.ASSET_CLASS_CODE,0,LENGTH(A.ASSET_CLASS_CODE)-3)) "
					+ "PARENT_CLASS_CODE,A.VOLTAGE_LEVEL,  "
					+ "A.THIS_YEAR_CAPITALIZ_QUANTITY,A.USER_HANDOVER_QUANTITY, "
					+ "A.SPORADIC_PURCHASES_QUANTITY,A.ALLOCATION_QUANTITY, "
					+ "A.OTHERS_QUANTITY,A.THIS_YEAR_CAPITALIZ_CAPACITY, "
					+ "A.USER_HANDOVER_CAPACITY,A.SPORADIC_PURCHASES_CAPACITY, "
					+ "A.ALLOCATION_CAPACITY,A.OTHERS_CAPACITY "
					+ "FROM RESULT_TEMP_TAB_PMS A), AMOUNT_TEMP AS ( SELECT  "
					+ "B.CATEGORY,B.ASSET_CLASS_CODE ASSET_CLASS_CODE,'002' INDICATE_DIMENSION,B.VOLTAGE_LEVEL,  "
					+ "SUM(A.THIS_YEAR_CAPITALIZ_QUANTITY) THIS_YEAR_CAPITALIZ_QUANTITY, "
					+ "SUM(A.USER_HANDOVER_QUANTITY) USER_HANDOVER_QUANTITY, "
					+ "SUM(A.SPORADIC_PURCHASES_QUANTITY) SPORADIC_PURCHASES_QUANTITY, "
					+ "SUM(A.ALLOCATION_QUANTITY) ALLOCATION_QUANTITY, "
					+ "SUM(A.OTHERS_QUANTITY) OTHERS_QUANTITY, SUM(A.THIS_YEAR_CAPITALIZ_QUANTITY+ "
					+ "A.USER_HANDOVER_QUANTITY+A.SPORADIC_PURCHASES_QUANTITY+ "
					+ "A.ALLOCATION_QUANTITY+A.OTHERS_QUANTITY) TOTAL_QUANTITY "
					+ "FROM LEVEL_TEMP_TAB_PMS A , LEVEL_TEMP_TAB_PMS B  " + "WHERE A.ASSET_CLASS_CODE IN  "
					+ "(SELECT E.ASSET_CLASS_CODE FROM LEVEL_TEMP_TAB_PMS E  "
					+ "START WITH E.ASSET_CLASS_CODE=B.ASSET_CLASS_CODE "
					+ "CONNECT BY E.PARENT_CLASS_CODE=PRIOR E.ASSET_CLASS_CODE) "
					+ "GROUP BY B.CATEGORY,B.ASSET_CLASS_CODE,B.VOLTAGE_LEVEL "
					+ "ORDER BY 2) , CAPACITY_TEMP AS ( SELECT  "
					+ "B.CATEGORY,B.ASSET_CLASS_CODE ASSET_CLASS_CODE,'003' INDICATE_DIMENSION,B.VOLTAGE_LEVEL,  "
					+ "SUM(A.THIS_YEAR_CAPITALIZ_CAPACITY) THIS_YEAR_CAPITALIZ_CAPACITY, "
					+ "SUM(A.USER_HANDOVER_CAPACITY) USER_HANDOVER_CAPACITY, "
					+ "SUM(A.SPORADIC_PURCHASES_CAPACITY) SPORADIC_PURCHASES_CAPACITY, "
					+ "SUM(A.ALLOCATION_CAPACITY) ALLOCATION_CAPACITY,SUM(A.OTHERS_CAPACITY) OTHERS_CAPACITY, "
					+ "SUM(A.THIS_YEAR_CAPITALIZ_CAPACITY+A.USER_HANDOVER_CAPACITY+ "
					+ "A.SPORADIC_PURCHASES_CAPACITY+A.ALLOCATION_CAPACITY+ " + "A.OTHERS_CAPACITY) TOTAL_CAPACITY "
					+ "FROM LEVEL_TEMP_TAB_PMS A , LEVEL_TEMP_TAB_PMS B  " + "WHERE A.ASSET_CLASS_CODE IN  "
					+ "(SELECT E.ASSET_CLASS_CODE FROM LEVEL_TEMP_TAB_PMS E  "
					+ "START WITH E.ASSET_CLASS_CODE=B.ASSET_CLASS_CODE "
					+ "CONNECT BY E.PARENT_CLASS_CODE=PRIOR E.ASSET_CLASS_CODE) "
					+ "GROUP BY B.CATEGORY,B.ASSET_CLASS_CODE, " + "B.VOLTAGE_LEVEL ORDER BY 2 ), ORIGINAL_TEMP AS (  "
					+ "SELECT B.CATEGORY,B.ASSET_CLASS_CODE ASSET_CLASS_CODE ,'001' INDICATE_DIMENSION,B.VOLTAGE_LEVEL,  "
					+ "SUM(A.THIS_YEAR_CAPITALIZ_ORIG) THIS_YEAR_CAPITALIZ_ORIG, "
					+ "SUM(A.USER_HANDOVER_ORIG) USER_HANDOVER_ORIG, "
					+ "SUM(A.SPORADIC_PURCHASES_ORIG) SPORADIC_PURCHASES_ORIG, "
					+ "SUM(A.ALLOCATION_ORIG) ALLOCATION_ORIG,SUM(A.OTHERS_ORIG) OTHERS_ORIG,  "
					+ "SUM(A.THIS_YEAR_CAPITALIZ_ORIG+A.USER_HANDOVER_ORIG+ "
					+ "A.SPORADIC_PURCHASES_ORIG+A.ALLOCATION_ORIG+A.OTHERS_ORIG) TOTAL_ORIG  "
					+ "FROM LEVEL_TEMP_TAB A , LEVEL_TEMP_TAB B  "
					+ "WHERE A.ASSET_CLASS_CODE IN ( SELECT E.ASSET_CLASS_CODE  "
					+ "FROM LEVEL_TEMP_TAB E START WITH E.ASSET_CLASS_CODE=B.ASSET_CLASS_CODE  "
					+ "CONNECT BY E.PARENT_CLASS_CODE=PRIOR E.ASSET_CLASS_CODE ) "
					+ "GROUP BY B.CATEGORY, B.ASSET_CLASS_CODE, B.VOLTAGE_LEVEL ORDER BY 2 )  "
					+ "SELECT  CATEGORY,ASSET_CLASS_CODE, INDICATE_DIMENSION,VOLTAGE_LEVEL, "
					+ "THIS_YEAR_CAPITALIZ_ORIG  THIS_YEAR_CAPITALIZ ,USER_HANDOVER_ORIG USER_HANDOVER , "
					+ "SPORADIC_PURCHASES_ORIG  SPORADIC_PURCHASES ,ALLOCATION_ORIG  ALLOCATION , "
					+ "OTHERS_ORIG  OTHERS ,  TOTAL_ORIG TOTAL_YEAR FROM ORIGINAL_TEMP  A " + "UNION ALL SELECT  "
					+ "CATEGORY,ASSET_CLASS_CODE, INDICATE_DIMENSION,VOLTAGE_LEVEL,THIS_YEAR_CAPITALIZ_QUANTITY  THIS_YEAR_CAPITALIZ , "
					+ "USER_HANDOVER_QUANTITY USER_HANDOVER ,SPORADIC_PURCHASES_QUANTITY  SPORADIC_PURCHASES , "
					+ "ALLOCATION_QUANTITY  ALLOCATION ,OTHERS_QUANTITY  OTHERS ,   "
					+ "TOTAL_QUANTITY TOTAL_YEAR  FROM AMOUNT_TEMP UNION ALL  "
					+ "SELECT CATEGORY,ASSET_CLASS_CODE, INDICATE_DIMENSION,VOLTAGE_LEVEL, "
					+ "THIS_YEAR_CAPITALIZ_CAPACITY  THIS_YEAR_CAPITALIZ , "
					+ "USER_HANDOVER_CAPACITY USER_HANDOVER ,SPORADIC_PURCHASES_CAPACITY  SPORADIC_PURCHASES , "
					+ "ALLOCATION_CAPACITY  ALLOCATION ,OTHERS_CAPACITY  OTHERS ,   "
					+ "TOTAL_CAPACITY  TOTAL_YEAR FROM CAPACITY_TEMP ORDER BY 2,3    ";

			try {
				new ReportOutput2().writeXLSXIncreased(reportSQL, templateFilePathAndName, targetFilePathAndName,
						reportName, voltageRelationCode, pmsDataVersion, erpDataVersion, areaName, sheetName,
						startRowNumber, startColumnNumber);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			sheetName = "A.2.2 新增资产来源";
			reportName = "A.2.2 新增资产来源";
			// dataVersion = "M_2019_2";
			// pmsDataVersion = "M_2019_2";// 20200612--PMS--河北
			// erpDataVersion = "M_2019_2";// 20200613--ERP--河北
			pmsDataVersion = "M_2019_3";// 20200612--PMS--湖北
			erpDataVersion = "M_2019_3";// 20200613--ERP--湖北
			// 循环输出表格中的内容,首先循环取出行,再根据行循环取出列
			startRowNumber = 4;
			startColumnNumber = 2;
			reportSQL = "WITH STRUCTRUE_TEMP_TAB AS (SELECT A.ASSET_CLASS_NAME,A.ASSET_CLASS_CODE,"
					+ "B.VOLTAGE_NAME,B.INDEXOF FROM DV_ASSET_CLASS A " + "LEFT JOIN  ( SELECT  C.VOLTAGE_NAME, "
					+ "B.DV_ASSET_CLASS_ID,B.INDEXOF FROM  " + "DV_VOLTAGE_RELATION B INNER JOIN DV_VOLTAGE_LEVEL C  "
					+ "ON B.DV_VOLTAGE_LEVEL_ID=C.DV_VOLTAGE_LEVEL_ID  " + "WHERE B.VOLTAGE_RELATION_CODE=? )B  " + // 1
					"ON A.DV_ASSET_CLASS_ID=B.DV_ASSET_CLASS_ID  " + "ORDER BY A.ASSET_CLASS_CODE ,B.INDEXOF ), "
					+ "SPAN_STRUCTURE_TAB AS (SELECT A.ASSET_CLASS_NAME, "
					+ "DECODE(A.VOLTAGE_NAME,NULL,A.ASSET_CLASS_CODE, "
					+ "DECODE(LENGTH(TO_CHAR(A.INDEXOF)),1,A.ASSET_CLASS_CODE||'10'||A.INDEXOF, "
					+ "2,A.ASSET_CLASS_CODE||'1'||A.INDEXOF)) "
					+ " STRUCTURE_CODE,A.ASSET_CLASS_CODE,VOLTAGE_NAME,INDEXOF "
					+ "FROM STRUCTRUE_TEMP_TAB A  ORDER BY STRUCTURE_CODE,INDEXOF ), "
					+ "STRUCT_TEMP_RESULT AS (SELECT A.ASSET_CLASS_NAME,  "
					+ "A.ASSET_CLASS_CODE,B.VOLTAGE_NAME,B.INDEXOF FROM  "
					+ "DV_ASSET_CLASS A LEFT JOIN SPAN_STRUCTURE_TAB B  "
					+ "ON A.ASSET_CLASS_CODE=B.STRUCTURE_CODE UNION ALL  "
					+ "SELECT B.ASSET_CLASS_NAME,B.STRUCTURE_CODE ASSET_CLASS_CODE, "
					+ "B.VOLTAGE_NAME,B.INDEXOF FROM  " + "SPAN_STRUCTURE_TAB B ORDER BY ASSET_CLASS_CODE, "
					+ "INDEXOF ),RESULT_TEMP_TAB AS (SELECT A.ASSET_CLASS_NAME CATEGORY, "
					+ "A.ASSET_CLASS_CODE,A.VOLTAGE_NAME VOLTAGE_LEVEL, "
					+ "DECODE(B.THIS_YEAR_CAPITALIZ_ORIG,NULL,0,B.THIS_YEAR_CAPITALIZ_ORIG) THIS_YEAR_CAPITALIZ_ORIG, "
					+ "DECODE(B.USER_HANDOVER_ORIG,NULL,0,B.USER_HANDOVER_ORIG) USER_HANDOVER_ORIG, "
					+ "DECODE(B.SPORADIC_PURCHASES_ORIG,NULL,0,B.SPORADIC_PURCHASES_ORIG) SPORADIC_PURCHASES_ORIG, "
					+ "DECODE(B.ALLOCATION_ORIG,NULL,0,B.ALLOCATION_ORIG) ALLOCATION_ORIG, "
					+ "DECODE(B.OTHERS_ORIG,NULL,0,B.OTHERS_ORIG) OTHERS_ORIG "
					+ "FROM (SELECT  DISTINCT  * FROM STRUCT_TEMP_RESULT )A  "
					+ "LEFT JOIN (SELECT EXTRACT(YEAR FROM A.DV_DATE_VALUE) CAL_YEAR, "
					+ "A.CATEGORY,A.VOLTAGE_LEVEL,SUM(A.THIS_YEAR_CAPITALIZ_ORIG) THIS_YEAR_CAPITALIZ_ORIG, "
					+ "SUM(A.USER_HANDOVER_ORIG) USER_HANDOVER_ORIG, "
					+ "SUM(A.SPORADIC_PURCHASES_ORIG) SPORADIC_PURCHASES_ORIG, "
					+ "SUM(A.ALLOCATION_ORIG) ALLOCATION_ORIG,SUM(A.OTHERS_ORIG) OTHERS_ORIG  "
					+ "FROM (SELECT E.ORG_ALIAS_NAME,F.AREA_NAME FROM DV_ORG_ALIAS E  "
					+ "INNER JOIN DV_ORG F ON E.DV_ORG_ID=F.DV_ORG_ID AND  "
					+ "F.AREA_NAME IN (SELECT A.AREA_NAME FROM DV_AREA A WHERE   "
					+ "EXISTS (SELECT 1 FROM DV_AREA B WHERE (DECODE( B.IS_LEAF,0, 1,0	)=1  "
					+ "AND B.AREA_NAME=? AND (SUBSTR(A.AREA_CODE,0,LENGTH(A.AREA_CODE)-3)=B.AREA_CODE OR  " + // 2
					"(A.IS_LEAF=0 AND B.AREA_CODE=A.AREA_CODE )))OR  "
					+ "(DECODE( B.IS_LEAF,0, 1,0	)=0 AND B.AREA_NAME= ? AND  " + // 3
					"A.AREA_CODE=B.AREA_CODE )))) F INNER JOIN MID_ASSET_INCREASED_ERP A  "
					+ "ON A.ORG_NAME=F.ORG_ALIAS_NAME WHERE DATA_VERSION=?  " + // 4
					"GROUP BY EXTRACT(YEAR FROM A.DV_DATE_VALUE),A.CATEGORY,A.VOLTAGE_LEVEL "
					+ ") B ON(A.ASSET_CLASS_NAME=B.CATEGORY AND  "
					+ "DECODE(A.VOLTAGE_NAME,NULL,'BLANK',A.VOLTAGE_NAME)=DECODE(B.VOLTAGE_LEVEL,NULL,'BLANK',B.VOLTAGE_LEVEL) "
					+ ")ORDER BY ASSET_CLASS_CODE,INDEXOF ),LEVEL_TEMP_TAB AS (  "
					+ "SELECT  A.CATEGORY,A.ASSET_CLASS_CODE,DECODE(LENGTH(A.ASSET_CLASS_CODE), "
					+ "3,NULL,SUBSTR(A.ASSET_CLASS_CODE,0,LENGTH(A.ASSET_CLASS_CODE)-3))PARENT_CLASS_CODE, "
					+ "A.VOLTAGE_LEVEL,A.THIS_YEAR_CAPITALIZ_ORIG,A.USER_HANDOVER_ORIG, "
					+ "A.SPORADIC_PURCHASES_ORIG,A.ALLOCATION_ORIG,A.OTHERS_ORIG FROM  "
					+ "RESULT_TEMP_TAB A),RESULT_TEMP_TAB_PMS AS (SELECT  "
					+ "A.ASSET_CLASS_NAME CATEGORY,A.ASSET_CLASS_CODE,A.VOLTAGE_NAME VOLTAGE_LEVEL, "
					+ "DECODE(B.THIS_YEAR_CAPITALIZ_QUANTITY,NULL,0,B.THIS_YEAR_CAPITALIZ_QUANTITY) THIS_YEAR_CAPITALIZ_QUANTITY, "
					+ "DECODE(B.USER_HANDOVER_QUANTITY,NULL,0,B.USER_HANDOVER_QUANTITY) USER_HANDOVER_QUANTITY, "
					+ "DECODE(B.SPORADIC_PURCHASES_QUANTITY,NULL,0,B.SPORADIC_PURCHASES_QUANTITY) SPORADIC_PURCHASES_QUANTITY, "
					+ "DECODE(B.ALLOCATION_QUANTITY,NULL,0,B.ALLOCATION_QUANTITY) ALLOCATION_QUANTITY, "
					+ "DECODE(B.OTHERS_QUANTITY,NULL,0,B.OTHERS_QUANTITY) OTHERS_QUANTITY, "
					+ "DECODE(B.THIS_YEAR_CAPITALIZ_CAPACITY,NULL,0,B.THIS_YEAR_CAPITALIZ_CAPACITY) THIS_YEAR_CAPITALIZ_CAPACITY, "
					+ "DECODE(B.USER_HANDOVER_CAPACITY,NULL,0,B.USER_HANDOVER_CAPACITY) USER_HANDOVER_CAPACITY, "
					+ "DECODE(B.SPORADIC_PURCHASES_CAPACITY,NULL,0,B.SPORADIC_PURCHASES_CAPACITY) SPORADIC_PURCHASES_CAPACITY, "
					+ "DECODE(B.ALLOCATION_CAPACITY,NULL,0,B.ALLOCATION_CAPACITY) ALLOCATION_CAPACITY, "
					+ "DECODE(B.OTHERS_CAPACITY,NULL,0,B.OTHERS_CAPACITY) OTHERS_CAPACITY FROM  "
					+ "(SELECT  DISTINCT  * FROM STRUCT_TEMP_RESULT )A LEFT JOIN  "
					+ "(SELECT EXTRACT(YEAR FROM A.DV_DATE_VALUE) CAL_YEAR, " + "A.CATEGORY,A.VOLTAGE_LEVEL, "
					+ "SUM(THIS_YEAR_CAPITALIZ_QUANTITY) THIS_YEAR_CAPITALIZ_QUANTITY, "
					+ "SUM(USER_HANDOVER_QUANTITY) USER_HANDOVER_QUANTITY, "
					+ "SUM(SPORADIC_PURCHASES_QUANTITY) SPORADIC_PURCHASES_QUANTITY, "
					+ "SUM(ALLOCATION_QUANTITY) ALLOCATION_QUANTITY, " + "SUM(OTHERS_QUANTITY) OTHERS_QUANTITY, "
					+ "SUM(THIS_YEAR_CAPITALIZ_CAPACITY) THIS_YEAR_CAPITALIZ_CAPACITY, "
					+ "SUM(USER_HANDOVER_CAPACITY) USER_HANDOVER_CAPACITY, "
					+ "SUM(SPORADIC_PURCHASES_CAPACITY) SPORADIC_PURCHASES_CAPACITY, "
					+ "SUM(ALLOCATION_CAPACITY) ALLOCATION_CAPACITY, " + "SUM(OTHERS_CAPACITY) OTHERS_CAPACITY  FROM  "
					+ "(SELECT E.ORG_ALIAS_NAME,F.AREA_NAME FROM DV_ORG_ALIAS E  "
					+ "INNER JOIN DV_ORG F ON E.DV_ORG_ID=F.DV_ORG_ID AND F.AREA_NAME IN  "
					+ "(SELECT A.AREA_NAME FROM DV_AREA A WHERE   " + "EXISTS (SELECT 1 FROM DV_AREA B WHERE  "
					+ "(DECODE( B.IS_LEAF,0, 1,0	)=1 AND B.AREA_NAME=?  " + // 5
					"AND (SUBSTR(A.AREA_CODE,0,LENGTH(A.AREA_CODE)-3)=B.AREA_CODE "
					+ "OR (A.IS_LEAF=0 AND B.AREA_CODE=A.AREA_CODE ))) " + "OR (DECODE( B.IS_LEAF,0, 1,0	)=0  "
					+ "AND B.AREA_NAME=?  AND A.AREA_CODE=B.AREA_CODE)))) F  " + // 6
					"INNER JOIN MID_ASSET_INCREASED_PMS A  " + "ON A.ORG_NAME=F.ORG_ALIAS_NAME WHERE DATA_VERSION=?   " + // 7
					"GROUP BY EXTRACT(YEAR FROM A.DV_DATE_VALUE),A.CATEGORY,A.VOLTAGE_LEVEL "
					+ ") B ON(A.ASSET_CLASS_NAME=B.CATEGORY AND  "
					+ "DECODE(A.VOLTAGE_NAME,NULL,'BLANK',A.VOLTAGE_NAME)= "
					+ "DECODE(B.VOLTAGE_LEVEL,NULL,'BLANK',B.VOLTAGE_LEVEL) " + ")ORDER BY ASSET_CLASS_CODE, "
					+ "INDEXOF ),LEVEL_TEMP_TAB_PMS AS (SELECT  "
					+ " A.CATEGORY,A.ASSET_CLASS_CODE,DECODE(LENGTH(A.ASSET_CLASS_CODE), "
					+ "3,NULL,SUBSTR(A.ASSET_CLASS_CODE,0,LENGTH(A.ASSET_CLASS_CODE)-3)) "
					+ "PARENT_CLASS_CODE,A.VOLTAGE_LEVEL,  "
					+ "A.THIS_YEAR_CAPITALIZ_QUANTITY,A.USER_HANDOVER_QUANTITY, "
					+ "A.SPORADIC_PURCHASES_QUANTITY,A.ALLOCATION_QUANTITY, "
					+ "A.OTHERS_QUANTITY,A.THIS_YEAR_CAPITALIZ_CAPACITY, "
					+ "A.USER_HANDOVER_CAPACITY,A.SPORADIC_PURCHASES_CAPACITY, "
					+ "A.ALLOCATION_CAPACITY,A.OTHERS_CAPACITY "
					+ "FROM RESULT_TEMP_TAB_PMS A), AMOUNT_TEMP AS ( SELECT  "
					+ "B.CATEGORY,B.ASSET_CLASS_CODE ASSET_CLASS_CODE,'002' INDICATE_DIMENSION,B.VOLTAGE_LEVEL,  "
					+ "SUM(A.THIS_YEAR_CAPITALIZ_QUANTITY) THIS_YEAR_CAPITALIZ_QUANTITY, "
					+ "SUM(A.USER_HANDOVER_QUANTITY) USER_HANDOVER_QUANTITY, "
					+ "SUM(A.SPORADIC_PURCHASES_QUANTITY) SPORADIC_PURCHASES_QUANTITY, "
					+ "SUM(A.ALLOCATION_QUANTITY) ALLOCATION_QUANTITY, "
					+ "SUM(A.OTHERS_QUANTITY) OTHERS_QUANTITY, SUM(A.THIS_YEAR_CAPITALIZ_QUANTITY+ "
					+ "A.USER_HANDOVER_QUANTITY+A.SPORADIC_PURCHASES_QUANTITY+ "
					+ "A.ALLOCATION_QUANTITY+A.OTHERS_QUANTITY) TOTAL_QUANTITY "
					+ "FROM LEVEL_TEMP_TAB_PMS A , LEVEL_TEMP_TAB_PMS B  " + "WHERE A.ASSET_CLASS_CODE IN  "
					+ "(SELECT E.ASSET_CLASS_CODE FROM LEVEL_TEMP_TAB_PMS E  "
					+ "START WITH E.ASSET_CLASS_CODE=B.ASSET_CLASS_CODE "
					+ "CONNECT BY E.PARENT_CLASS_CODE=PRIOR E.ASSET_CLASS_CODE) "
					+ "GROUP BY B.CATEGORY,B.ASSET_CLASS_CODE,B.VOLTAGE_LEVEL "
					+ "ORDER BY 2) , CAPACITY_TEMP AS ( SELECT  "
					+ "B.CATEGORY,B.ASSET_CLASS_CODE ASSET_CLASS_CODE,'003' INDICATE_DIMENSION,B.VOLTAGE_LEVEL,  "
					+ "SUM(A.THIS_YEAR_CAPITALIZ_CAPACITY) THIS_YEAR_CAPITALIZ_CAPACITY, "
					+ "SUM(A.USER_HANDOVER_CAPACITY) USER_HANDOVER_CAPACITY, "
					+ "SUM(A.SPORADIC_PURCHASES_CAPACITY) SPORADIC_PURCHASES_CAPACITY, "
					+ "SUM(A.ALLOCATION_CAPACITY) ALLOCATION_CAPACITY,SUM(A.OTHERS_CAPACITY) OTHERS_CAPACITY, "
					+ "SUM(A.THIS_YEAR_CAPITALIZ_CAPACITY+A.USER_HANDOVER_CAPACITY+ "
					+ "A.SPORADIC_PURCHASES_CAPACITY+A.ALLOCATION_CAPACITY+ " + "A.OTHERS_CAPACITY) TOTAL_CAPACITY "
					+ "FROM LEVEL_TEMP_TAB_PMS A , LEVEL_TEMP_TAB_PMS B  " + "WHERE A.ASSET_CLASS_CODE IN  "
					+ "(SELECT E.ASSET_CLASS_CODE FROM LEVEL_TEMP_TAB_PMS E  "
					+ "START WITH E.ASSET_CLASS_CODE=B.ASSET_CLASS_CODE "
					+ "CONNECT BY E.PARENT_CLASS_CODE=PRIOR E.ASSET_CLASS_CODE) "
					+ "GROUP BY B.CATEGORY,B.ASSET_CLASS_CODE, " + "B.VOLTAGE_LEVEL ORDER BY 2 ), ORIGINAL_TEMP AS (  "
					+ "SELECT B.CATEGORY,B.ASSET_CLASS_CODE ASSET_CLASS_CODE ,'001' INDICATE_DIMENSION,B.VOLTAGE_LEVEL,  "
					+ "SUM(A.THIS_YEAR_CAPITALIZ_ORIG) THIS_YEAR_CAPITALIZ_ORIG, "
					+ "SUM(A.USER_HANDOVER_ORIG) USER_HANDOVER_ORIG, "
					+ "SUM(A.SPORADIC_PURCHASES_ORIG) SPORADIC_PURCHASES_ORIG, "
					+ "SUM(A.ALLOCATION_ORIG) ALLOCATION_ORIG,SUM(A.OTHERS_ORIG) OTHERS_ORIG,  "
					+ "SUM(A.THIS_YEAR_CAPITALIZ_ORIG+A.USER_HANDOVER_ORIG+ "
					+ "A.SPORADIC_PURCHASES_ORIG+A.ALLOCATION_ORIG+A.OTHERS_ORIG) TOTAL_ORIG  "
					+ "FROM LEVEL_TEMP_TAB A , LEVEL_TEMP_TAB B  "
					+ "WHERE A.ASSET_CLASS_CODE IN ( SELECT E.ASSET_CLASS_CODE  "
					+ "FROM LEVEL_TEMP_TAB E START WITH E.ASSET_CLASS_CODE=B.ASSET_CLASS_CODE  "
					+ "CONNECT BY E.PARENT_CLASS_CODE=PRIOR E.ASSET_CLASS_CODE ) "
					+ "GROUP BY B.CATEGORY, B.ASSET_CLASS_CODE, B.VOLTAGE_LEVEL ORDER BY 2 )  "
					+ "SELECT  CATEGORY,ASSET_CLASS_CODE, INDICATE_DIMENSION,VOLTAGE_LEVEL, "
					+ "THIS_YEAR_CAPITALIZ_ORIG  THIS_YEAR_CAPITALIZ ,USER_HANDOVER_ORIG USER_HANDOVER , "
					+ "SPORADIC_PURCHASES_ORIG  SPORADIC_PURCHASES ,ALLOCATION_ORIG  ALLOCATION , "
					+ "OTHERS_ORIG  OTHERS FROM ORIGINAL_TEMP  A " + "UNION ALL SELECT  "
					+ "CATEGORY,ASSET_CLASS_CODE, INDICATE_DIMENSION,VOLTAGE_LEVEL,THIS_YEAR_CAPITALIZ_QUANTITY  THIS_YEAR_CAPITALIZ , "
					+ "USER_HANDOVER_QUANTITY USER_HANDOVER ,SPORADIC_PURCHASES_QUANTITY  SPORADIC_PURCHASES , "
					+ "ALLOCATION_QUANTITY  ALLOCATION ,OTHERS_QUANTITY  OTHERS  FROM AMOUNT_TEMP UNION ALL  "
					+ "SELECT CATEGORY,ASSET_CLASS_CODE, INDICATE_DIMENSION,VOLTAGE_LEVEL, "
					+ "THIS_YEAR_CAPITALIZ_CAPACITY  THIS_YEAR_CAPITALIZ , "
					+ "USER_HANDOVER_CAPACITY USER_HANDOVER ,SPORADIC_PURCHASES_CAPACITY  SPORADIC_PURCHASES , "
					+ "ALLOCATION_CAPACITY  ALLOCATION ,OTHERS_CAPACITY  OTHERS     "
					+ " FROM CAPACITY_TEMP ORDER BY 2,3    ";

			try {
				new ReportOutput2().writeXLSXIncreased(reportSQL, templateFilePathAndName, targetFilePathAndName,
						reportName, voltageRelationCode, pmsDataVersion, erpDataVersion, areaName, sheetName,
						startRowNumber, startColumnNumber);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			sheetName = "A.5.1 报废资产规模结构"; // 占位
			reportName = "A.5.1 报废资产规模结构";
			System.out.println(sheetName + " Start!");
			// dataVersion ="M_2019_2";
			//
			dataVersion = "M_2019_3";// 20200612--河北
			// dataVersion = "M_2019_2";// 20200612--湖北
			// dataVersion = "M_2019_8";//20200613--ERP
			// 循环输出表格中的内容,首先循环取出行,再根据行循环取出列
			startRowNumber = 4;
			startColumnNumber = 1;
			reportSQL = "WITH STRUCTRUE_TEMP_TAB AS (SELECT A.ASSET_CLASS_NAME,A.ASSET_CLASS_CODE,B.VOLTAGE_NAME, "
					+ "B.INDEXOF  FROM DV_ASSET_CLASS A LEFT JOIN (SELECT  C.VOLTAGE_NAME,B.DV_ASSET_CLASS_ID, "
					+ "B.INDEXOF FROM DV_VOLTAGE_RELATION B  INNER JOIN DV_VOLTAGE_LEVEL C ON  "
					+ "B.DV_VOLTAGE_LEVEL_ID=C.DV_VOLTAGE_LEVEL_ID WHERE B.VOLTAGE_RELATION_CODE= ?  "
					+ ")B ON A.DV_ASSET_CLASS_ID=B.DV_ASSET_CLASS_ID ORDER BY A.ASSET_CLASS_CODE , "
					+ "B.INDEXOF ),SPAN_STRUCTURE_TAB AS (SELECT A.ASSET_CLASS_NAME, "
					+ "DECODE(A.VOLTAGE_NAME,NULL,A.ASSET_CLASS_CODE,DECODE(LENGTH(TO_CHAR(A.INDEXOF)),1,A.ASSET_CLASS_CODE||'10'||A.INDEXOF, "
					+ "2,A.ASSET_CLASS_CODE||'1'||A.INDEXOF)) STRUCTURE_CODE,A.ASSET_CLASS_CODE,VOLTAGE_NAME,INDEXOF "
					+ "FROM STRUCTRUE_TEMP_TAB A  ORDER BY STRUCTURE_CODE,INDEXOF ),STRUCT_TEMP_RESULT AS (  "
					+ "SELECT A.ASSET_CLASS_NAME, A.ASSET_CLASS_CODE,B.VOLTAGE_NAME,B.INDEXOF FROM DV_ASSET_CLASS A  "
					+ "LEFT JOIN SPAN_STRUCTURE_TAB B ON A.ASSET_CLASS_CODE=B.STRUCTURE_CODE UNION ALL  "
					+ "SELECT B.ASSET_CLASS_NAME,B.STRUCTURE_CODE ASSET_CLASS_CODE,B.VOLTAGE_NAME,B.INDEXOF FROM  "
					+ "SPAN_STRUCTURE_TAB B ORDER BY ASSET_CLASS_CODE,INDEXOF ),RESULT_TEMP_TAB AS ( "
					+ "SELECT A.ASSET_CLASS_NAME CATEGORY,A.ASSET_CLASS_CODE,A.VOLTAGE_NAME VOLTAGE_LEVEL, "
					+ "DECODE(B.DISCARD_YEAR1_ORIGIN_VAL,NULL,0,B.DISCARD_YEAR1_ORIGIN_VAL) DISCARD_YEAR1_ORIGIN_VAL, "
					+ "DECODE(B.DISCARD_YEAR1_NET_VAL,NULL,0,B.DISCARD_YEAR1_NET_VAL) DISCARD_YEAR1_NET_VAL, "
					+ "DECODE(B.DISCARD_YEAR1_AMOUNT,NULL,0,B.DISCARD_YEAR1_AMOUNT) DISCARD_YEAR1_AMOUNT, "
					+ "DECODE(B.DISCARD_YEAR1_CAPACITY,NULL,0,B.DISCARD_YEAR1_CAPACITY) DISCARD_YEAR1_CAPACITY   "
					+ "FROM (SELECT  DISTINCT  * FROM STRUCT_TEMP_RESULT )A LEFT JOIN  "
					+ "(SELECT EXTRACT(YEAR FROM A.DV_DATE_VALUE) CAL_YEAR,A. CATEGORY ,A.VOLTAGE_LEVEL,  "
					+ "SUM(A.DISCARD_YEAR1_ORIGIN_VAL) DISCARD_YEAR1_ORIGIN_VAL,  "
					+ "SUM(A.DISCARD_YEAR1_NET_VAL) DISCARD_YEAR1_NET_VAL,  "
					+ "SUM(A.DISCARD_YEAR1_AMOUNT) DISCARD_YEAR1_AMOUNT , "
					+ "SUM(A.DISCARD_YEAR1_CAPACITY) DISCARD_YEAR1_CAPACITY  "
					+ "FROM (SELECT E.ORG_ALIAS_NAME,F.AREA_NAME FROM DV_ORG_ALIAS E  "
					+ "INNER JOIN DV_ORG F ON E.DV_ORG_ID=F.DV_ORG_ID AND F.AREA_NAME   "
					+ "IN (SELECT A.AREA_NAME FROM DV_AREA A WHERE  EXISTS  "
					+ "(SELECT 1 FROM DV_AREA B WHERE (DECODE( B.IS_LEAF,0, 1,0	)=1 AND B.AREA_NAME= ? "
					+ "AND (SUBSTR(A.AREA_CODE,0,LENGTH(A.AREA_CODE)-3)=B.AREA_CODE "
					+ "OR (A.IS_LEAF=0 AND B.AREA_CODE=A.AREA_CODE )))OR  "
					+ "(DECODE( B.IS_LEAF,0, 1,0	)=0 AND B.AREA_NAME=? AND A.AREA_CODE=B.AREA_CODE "
					+ ")) )) F INNER JOIN MID_ASSET_DISCARD A ON A.ORG_NAME=F.ORG_ALIAS_NAME  "
					+ "WHERE  VERSION= ? GROUP BY EXTRACT(YEAR FROM A.DV_DATE_VALUE), "
					+ "A. CATEGORY ,A.VOLTAGE_LEVEL) B ON(A.ASSET_CLASS_NAME=B. CATEGORY  AND  "
					+ "DECODE(A.VOLTAGE_NAME,NULL,'BLANK',A.VOLTAGE_NAME)=DECODE(B.VOLTAGE_LEVEL,NULL,'BLANK',B.VOLTAGE_LEVEL) "
					+ ")ORDER BY ASSET_CLASS_CODE,INDEXOF ),LEVEL_TEMP_TAB AS ( "
					+ "SELECT  A.CATEGORY,A.ASSET_CLASS_CODE,DECODE(LENGTH(A.ASSET_CLASS_CODE), "
					+ "3,NULL,SUBSTR(A.ASSET_CLASS_CODE,0,LENGTH(A.ASSET_CLASS_CODE)-3))PARENT_CLASS_CODE, "
					+ "A.VOLTAGE_LEVEL,A.DISCARD_YEAR1_ORIGIN_VAL,A.DISCARD_YEAR1_NET_VAL,A.DISCARD_YEAR1_AMOUNT, "
					+ "A.DISCARD_YEAR1_CAPACITY FROM RESULT_TEMP_TAB A ) "
					+ "SELECT B.CATEGORY,B.ASSET_CLASS_CODE,B.VOLTAGE_LEVEL,  "
					+ "SUM(A.DISCARD_YEAR1_ORIGIN_VAL) DISCARD_YEAR1_ORIGIN_VAL, "
					+ "SUM(A.DISCARD_YEAR1_NET_VAL) DISCARD_YEAR1_NET_VAL, "
					+ "SUM(A.DISCARD_YEAR1_AMOUNT) DISCARD_YEAR1_AMOUNT, "
					+ "SUM(A.DISCARD_YEAR1_CAPACITY) DISCARD_YEAR1_CAPACITY "
					+ "FROM LEVEL_TEMP_TAB A , LEVEL_TEMP_TAB B WHERE A.ASSET_CLASS_CODE IN  "
					+ "(SELECT E.ASSET_CLASS_CODE FROM LEVEL_TEMP_TAB E  "
					+ "START WITH E.ASSET_CLASS_CODE=B.ASSET_CLASS_CODE "
					+ "CONNECT BY E.PARENT_CLASS_CODE=PRIOR E.ASSET_CLASS_CODE) "
					+ "GROUP BY B.CATEGORY,B.ASSET_CLASS_CODE,B.VOLTAGE_LEVEL ORDER BY 2";

			try {
				new ReportOutput2().writeXLSXAutoMatic(reportSQL, templateFilePathAndName, targetFilePathAndName,
						reportName, voltageRelationCode, dataVersion, areaName, sheetName, startRowNumber,
						startColumnNumber);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			sheetName = "A.5.2 报废资产规模结构（成因）";
			reportName = "A.5.2 报废资产规模结构（成因）";
			System.out.println(sheetName + " Start!");
			// dataVersion = "M_2019_2";
			// dataVersion = "M_2019_3";// 20200612--河北
			dataVersion = "M_2019_2";// 20200612--湖北
			// 循环输出表格中的内容,首先循环取出行,再根据行循环取出列
			startRowNumber = 5;
			startColumnNumber = 2;
			reportSQL = "WITH STRUCTRUE_TEMP_TAB AS (SELECT A.ASSET_CLASS_NAME,A.ASSET_CLASS_CODE, "
					+ "B.VOLTAGE_NAME,B.INDEXOF FROM DV_ASSET_CLASS A LEFT JOIN  "
					+ "(SELECT  C.VOLTAGE_NAME,B.DV_ASSET_CLASS_ID,B.INDEXOF  "
					+ "FROM DV_VOLTAGE_RELATION B  INNER JOIN DV_VOLTAGE_LEVEL C ON  "
					+ "B.DV_VOLTAGE_LEVEL_ID=C.DV_VOLTAGE_LEVEL_ID WHERE B.VOLTAGE_RELATION_CODE=?)B ON  " + // 1
					"A.DV_ASSET_CLASS_ID=B.DV_ASSET_CLASS_ID ORDER BY A.ASSET_CLASS_CODE ,B.INDEXOF  "
					+ "),SPAN_STRUCTURE_TAB AS (SELECT A.ASSET_CLASS_NAME, "
					+ "DECODE(A.VOLTAGE_NAME,NULL,A.ASSET_CLASS_CODE,DECODE(LENGTH(TO_CHAR(A.INDEXOF)), "
					+ "1,A.ASSET_CLASS_CODE||'10'||A.INDEXOF,2,A.ASSET_CLASS_CODE||'1'||A.INDEXOF)) "
					+ " STRUCTURE_CODE,A.ASSET_CLASS_CODE,VOLTAGE_NAME,INDEXOF FROM  "
					+ "STRUCTRUE_TEMP_TAB A  ORDER BY STRUCTURE_CODE,INDEXOF ),STRUCT_TEMP_RESULT AS ( "
					+ "SELECT A.ASSET_CLASS_NAME, A.ASSET_CLASS_CODE,B.VOLTAGE_NAME, "
					+ "B.INDEXOF FROM DV_ASSET_CLASS A LEFT JOIN SPAN_STRUCTURE_TAB B  "
					+ "ON A.ASSET_CLASS_CODE=B.STRUCTURE_CODE UNION ALL SELECT  "
					+ "B.ASSET_CLASS_NAME,B.STRUCTURE_CODE ASSET_CLASS_CODE,B.VOLTAGE_NAME, "
					+ "B.INDEXOF FROM SPAN_STRUCTURE_TAB B ORDER BY ASSET_CLASS_CODE,INDEXOF  "
					+ "),RESULT_TEMP_TAB AS (SELECT A.ASSET_CLASS_NAME CATEGORY, "
					+ "A.ASSET_CLASS_CODE,A.VOLTAGE_NAME VOLTAGE_LEVEL, "
					+ "DECODE(B.DISCARD_REASON01_ORIGIN_VAL,NULL,0,B.DISCARD_REASON01_ORIGIN_VAL) DISCARD_REASON01_ORIGIN_VAL, "
					+ "DECODE(B.DISCARD_REASON02_ORIGIN_VAL,NULL,0,B.DISCARD_REASON02_ORIGIN_VAL) DISCARD_REASON02_ORIGIN_VAL, "
					+ "DECODE(B.DISCARD_REASON03_ORIGIN_VAL,NULL,0,B.DISCARD_REASON03_ORIGIN_VAL) DISCARD_REASON03_ORIGIN_VAL, "
					+ "DECODE(B.DISCARD_REASON04_ORIGIN_VAL,NULL,0,B.DISCARD_REASON04_ORIGIN_VAL) DISCARD_REASON04_ORIGIN_VAL, "
					+ "DECODE(B.DISCARD_REASON05_ORIGIN_VAL,NULL,0,B.DISCARD_REASON05_ORIGIN_VAL) DISCARD_REASON05_ORIGIN_VAL, "
					+ "DECODE(B.DISCARD_REASON06_ORIGIN_VAL,NULL,0,B.DISCARD_REASON06_ORIGIN_VAL) DISCARD_REASON06_ORIGIN_VAL, "
					+ "DECODE(B.DISCARD_REASON07_ORIGIN_VAL,NULL,0,B.DISCARD_REASON07_ORIGIN_VAL) DISCARD_REASON07_ORIGIN_VAL, "
					+ "DECODE(B.DISCARD_REASON08_ORIGIN_VAL,NULL,0,B.DISCARD_REASON08_ORIGIN_VAL) DISCARD_REASON08_ORIGIN_VAL, "
					+ "DECODE(B.DISCARD_REASON01_NET_VAL,NULL,0,B.DISCARD_REASON01_NET_VAL) DISCARD_REASON01_NET_VAL, "
					+ "DECODE(B.DISCARD_REASON02_NET_VAL,NULL,0,B.DISCARD_REASON02_NET_VAL) DISCARD_REASON02_NET_VAL, "
					+ "DECODE(B.DISCARD_REASON03_NET_VAL,NULL,0,B.DISCARD_REASON03_NET_VAL) DISCARD_REASON03_NET_VAL, "
					+ "DECODE(B.DISCARD_REASON04_NET_VAL,NULL,0,B.DISCARD_REASON04_NET_VAL) DISCARD_REASON04_NET_VAL, "
					+ "DECODE(B.DISCARD_REASON05_NET_VAL,NULL,0,B.DISCARD_REASON05_NET_VAL) DISCARD_REASON05_NET_VAL, "
					+ "DECODE(B.DISCARD_REASON06_NET_VAL,NULL,0,B.DISCARD_REASON06_NET_VAL) DISCARD_REASON06_NET_VAL, "
					+ "DECODE(B.DISCARD_REASON07_NET_VAL,NULL,0,B.DISCARD_REASON07_NET_VAL) DISCARD_REASON07_NET_VAL, "
					+ "DECODE(B.DISCARD_REASON08_NET_VAL,NULL,0,B.DISCARD_REASON08_NET_VAL) DISCARD_REASON08_NET_VAL, "
					+ "DECODE(B.DISCARD_REASON01_AMOUNT,NULL,0,B.DISCARD_REASON01_AMOUNT) DISCARD_REASON01_AMOUNT, "
					+ "DECODE(B.DISCARD_REASON02_AMOUNT,NULL,0,B.DISCARD_REASON02_AMOUNT) DISCARD_REASON02_AMOUNT, "
					+ "DECODE(B.DISCARD_REASON03_AMOUNT,NULL,0,B.DISCARD_REASON03_AMOUNT) DISCARD_REASON03_AMOUNT, "
					+ "DECODE(B.DISCARD_REASON04_AMOUNT,NULL,0,B.DISCARD_REASON04_AMOUNT) DISCARD_REASON04_AMOUNT, "
					+ "DECODE(B.DISCARD_REASON05_AMOUNT,NULL,0,B.DISCARD_REASON05_AMOUNT) DISCARD_REASON05_AMOUNT, "
					+ "DECODE(B.DISCARD_REASON06_AMOUNT,NULL,0,B.DISCARD_REASON06_AMOUNT) DISCARD_REASON06_AMOUNT, "
					+ "DECODE(B.DISCARD_REASON07_AMOUNT,NULL,0,B.DISCARD_REASON07_AMOUNT) DISCARD_REASON07_AMOUNT, "
					+ "DECODE(B.DISCARD_REASON08_AMOUNT,NULL,0,B.DISCARD_REASON08_AMOUNT) DISCARD_REASON08_AMOUNT  "
					+ "FROM (SELECT  DISTINCT  * FROM STRUCT_TEMP_RESULT )A LEFT JOIN (SELECT  "
					+ "EXTRACT(YEAR FROM A.DV_DATE_VALUE) CAL_YEAR,A.CATEGORY,A.VOLTAGE_LEVEL, "
					+ "SUM(A.DISCARD_REASON01_ORIGIN_VAL) DISCARD_REASON01_ORIGIN_VAL, "
					+ "SUM(A.DISCARD_REASON02_ORIGIN_VAL) DISCARD_REASON02_ORIGIN_VAL, "
					+ "SUM(A.DISCARD_REASON03_ORIGIN_VAL) DISCARD_REASON03_ORIGIN_VAL, "
					+ "SUM(A.DISCARD_REASON04_ORIGIN_VAL) DISCARD_REASON04_ORIGIN_VAL, "
					+ "SUM(A.DISCARD_REASON05_ORIGIN_VAL) DISCARD_REASON05_ORIGIN_VAL, "
					+ "SUM(A.DISCARD_REASON06_ORIGIN_VAL) DISCARD_REASON06_ORIGIN_VAL, "
					+ "SUM(A.DISCARD_REASON07_ORIGIN_VAL) DISCARD_REASON07_ORIGIN_VAL, "
					+ "SUM(A.DISCARD_REASON08_ORIGIN_VAL) DISCARD_REASON08_ORIGIN_VAL, "
					+ "SUM(A.DISCARD_REASON01_NET_VAL) DISCARD_REASON01_NET_VAL, "
					+ "SUM(A.DISCARD_REASON02_NET_VAL) DISCARD_REASON02_NET_VAL, "
					+ "SUM(A.DISCARD_REASON03_NET_VAL) DISCARD_REASON03_NET_VAL, "
					+ "SUM(A.DISCARD_REASON04_NET_VAL) DISCARD_REASON04_NET_VAL, "
					+ "SUM(A.DISCARD_REASON05_NET_VAL) DISCARD_REASON05_NET_VAL, "
					+ "SUM(A.DISCARD_REASON06_NET_VAL) DISCARD_REASON06_NET_VAL, "
					+ "SUM(A.DISCARD_REASON07_NET_VAL) DISCARD_REASON07_NET_VAL, "
					+ "SUM(A.DISCARD_REASON08_NET_VAL) DISCARD_REASON08_NET_VAL, "
					+ "SUM(A.DISCARD_REASON01_AMOUNT) DISCARD_REASON01_AMOUNT, "
					+ "SUM(A.DISCARD_REASON02_AMOUNT) DISCARD_REASON02_AMOUNT, "
					+ "SUM(A.DISCARD_REASON03_AMOUNT) DISCARD_REASON03_AMOUNT, "
					+ "SUM(A.DISCARD_REASON04_AMOUNT) DISCARD_REASON04_AMOUNT, "
					+ "SUM(A.DISCARD_REASON05_AMOUNT) DISCARD_REASON05_AMOUNT, "
					+ "SUM(A.DISCARD_REASON06_AMOUNT) DISCARD_REASON06_AMOUNT, "
					+ "SUM(A.DISCARD_REASON07_AMOUNT) DISCARD_REASON07_AMOUNT, "
					+ "SUM(A.DISCARD_REASON08_AMOUNT) DISCARD_REASON08_AMOUNT "
					+ "FROM (SELECT E.ORG_ALIAS_NAME,F.AREA_NAME  " + "FROM DV_ORG_ALIAS E INNER JOIN  "
					+ "DV_ORG F ON E.DV_ORG_ID=F.DV_ORG_ID AND F.AREA_NAME IN  "
					+ "(SELECT A.AREA_NAME FROM DV_AREA A WHERE   " + "EXISTS (SELECT 1 FROM DV_AREA B WHERE  "
					+ "(DECODE( B.IS_LEAF,0, 1,0  )=1 AND B.AREA_NAME=?  AND  " + // 2
					"(SUBSTR(A.AREA_CODE,0,LENGTH(A.AREA_CODE)-3)=B.AREA_CODE "
					+ "OR (A.IS_LEAF=0 AND B.AREA_CODE=A.AREA_CODE ))) "
					+ "OR (DECODE( B.IS_LEAF,0, 1,0  )=0 AND B.AREA_NAME=? AND  " + // 3
					"A.AREA_CODE=B.AREA_CODE)))) F INNER JOIN MID_ASSET_DISCARD A ON  "
					+ "A.ORG_NAME=F.ORG_ALIAS_NAME WHERE DATA_VERSION=? GROUP BY " + // 4
					"EXTRACT(YEAR FROM A.DV_DATE_VALUE),A. CATEGORY ,A.VOLTAGE_LEVEL "
					+ ") B ON(A.ASSET_CLASS_NAME=B. CATEGORY  AND  "
					+ "DECODE(A.VOLTAGE_NAME,NULL,'BLANK',A.VOLTAGE_NAME)= "
					+ "DECODE(B.VOLTAGE_LEVEL,NULL,'BLANK',B.VOLTAGE_LEVEL) " + ")ORDER BY ASSET_CLASS_CODE, "
					+ "INDEXOF ),LEVEL_TEMP_TAB AS (SELECT  A.CATEGORY, "
					+ "A.ASSET_CLASS_CODE,DECODE(LENGTH(A.ASSET_CLASS_CODE), "
					+ "3,NULL,SUBSTR(A.ASSET_CLASS_CODE,0,LENGTH(A.ASSET_CLASS_CODE)-3)) "
					+ "PARENT_CLASS_CODE,A.VOLTAGE_LEVEL,A.DISCARD_REASON01_ORIGIN_VAL, "
					+ "A.DISCARD_REASON02_ORIGIN_VAL,A.DISCARD_REASON03_ORIGIN_VAL, "
					+ "A.DISCARD_REASON04_ORIGIN_VAL,A.DISCARD_REASON05_ORIGIN_VAL, "
					+ "A.DISCARD_REASON06_ORIGIN_VAL,A.DISCARD_REASON07_ORIGIN_VAL, "
					+ "A.DISCARD_REASON08_ORIGIN_VAL,A.DISCARD_REASON01_NET_VAL, "
					+ "A.DISCARD_REASON02_NET_VAL,A.DISCARD_REASON03_NET_VAL, "
					+ "A.DISCARD_REASON04_NET_VAL,A.DISCARD_REASON05_NET_VAL, "
					+ "A.DISCARD_REASON06_NET_VAL,A.DISCARD_REASON07_NET_VAL, "
					+ "A.DISCARD_REASON08_NET_VAL,A.DISCARD_REASON01_AMOUNT, "
					+ "A.DISCARD_REASON02_AMOUNT,A.DISCARD_REASON03_AMOUNT,A.DISCARD_REASON04_AMOUNT, "
					+ "A.DISCARD_REASON05_AMOUNT,A.DISCARD_REASON06_AMOUNT, "
					+ "A.DISCARD_REASON07_AMOUNT,A.DISCARD_REASON08_AMOUNT    "
					+ "FROM RESULT_TEMP_TAB A), ORIGINAL_TEMP AS ( SELECT  "
					+ "B.CATEGORY,B.ASSET_CLASS_CODE ,'001' INDICATE_DIMENSION,B.VOLTAGE_LEVEL,   "
					+ "SUM(A.DISCARD_REASON01_ORIGIN_VAL) DISCARD_REASON01_ORIGIN_VAL, "
					+ "SUM(A.DISCARD_REASON02_ORIGIN_VAL) DISCARD_REASON02_ORIGIN_VAL, "
					+ "SUM(A.DISCARD_REASON03_ORIGIN_VAL) DISCARD_REASON03_ORIGIN_VAL, "
					+ "SUM(A.DISCARD_REASON04_ORIGIN_VAL) DISCARD_REASON04_ORIGIN_VAL, "
					+ "SUM(A.DISCARD_REASON05_ORIGIN_VAL) DISCARD_REASON05_ORIGIN_VAL, "
					+ "SUM(A.DISCARD_REASON06_ORIGIN_VAL) DISCARD_REASON06_ORIGIN_VAL, "
					+ "SUM(A.DISCARD_REASON07_ORIGIN_VAL) DISCARD_REASON07_ORIGIN_VAL, "
					+ "SUM(A.DISCARD_REASON08_ORIGIN_VAL) DISCARD_REASON08_ORIGIN_VAL  "
					+ "FROM LEVEL_TEMP_TAB A , LEVEL_TEMP_TAB B WHERE A.ASSET_CLASS_CODE IN  "
					+ "(SELECT E.ASSET_CLASS_CODE FROM LEVEL_TEMP_TAB E  "
					+ "START WITH E.ASSET_CLASS_CODE=B.ASSET_CLASS_CODE "
					+ "CONNECT BY E.PARENT_CLASS_CODE=PRIOR E.ASSET_CLASS_CODE "
					+ ")GROUP BY B.CATEGORY,B.ASSET_CLASS_CODE, "
					+ "B.VOLTAGE_LEVEL ORDER BY 2), NET_TEMP AS ( SELECT  "
					+ "B.CATEGORY,B.ASSET_CLASS_CODE ,'002' INDICATE_DIMENSION,B.VOLTAGE_LEVEL,   "
					+ "SUM(A.DISCARD_REASON01_NET_VAL) DISCARD_REASON01_NET_VAL, "
					+ "SUM(A.DISCARD_REASON02_NET_VAL) DISCARD_REASON02_NET_VAL, "
					+ "SUM(A.DISCARD_REASON03_NET_VAL) DISCARD_REASON03_NET_VAL, "
					+ "SUM(A.DISCARD_REASON04_NET_VAL) DISCARD_REASON04_NET_VAL, "
					+ "SUM(A.DISCARD_REASON05_NET_VAL) DISCARD_REASON05_NET_VAL, "
					+ "SUM(A.DISCARD_REASON06_NET_VAL) DISCARD_REASON06_NET_VAL, "
					+ "SUM(A.DISCARD_REASON07_NET_VAL) DISCARD_REASON07_NET_VAL, "
					+ "SUM(A.DISCARD_REASON08_NET_VAL) DISCARD_REASON08_NET_VAL  "
					+ "FROM LEVEL_TEMP_TAB A , LEVEL_TEMP_TAB B  "
					+ "WHERE A.ASSET_CLASS_CODE IN (SELECT E.ASSET_CLASS_CODE  "
					+ "FROM LEVEL_TEMP_TAB E START WITH E.ASSET_CLASS_CODE=B.ASSET_CLASS_CODE "
					+ "CONNECT BY E.PARENT_CLASS_CODE=PRIOR E.ASSET_CLASS_CODE "
					+ ")GROUP BY B.CATEGORY,B.ASSET_CLASS_CODE, "
					+ "B.VOLTAGE_LEVEL ORDER BY 2), AMOUNT_TEMP AS ( SELECT  "
					+ "B.CATEGORY,B.ASSET_CLASS_CODE,'003' INDICATE_DIMENSION,B.VOLTAGE_LEVEL,  "
					+ "SUM(A.DISCARD_REASON01_AMOUNT) DISCARD_REASON01_AMOUNT, "
					+ "SUM(A.DISCARD_REASON02_AMOUNT) DISCARD_REASON02_AMOUNT, "
					+ "SUM(A.DISCARD_REASON03_AMOUNT) DISCARD_REASON03_AMOUNT, "
					+ "SUM(A.DISCARD_REASON04_AMOUNT) DISCARD_REASON04_AMOUNT, "
					+ "SUM(A.DISCARD_REASON05_AMOUNT) DISCARD_REASON05_AMOUNT, "
					+ "SUM(A.DISCARD_REASON06_AMOUNT) DISCARD_REASON06_AMOUNT, "
					+ "SUM(A.DISCARD_REASON07_AMOUNT) DISCARD_REASON07_AMOUNT, "
					+ "SUM(A.DISCARD_REASON08_AMOUNT) DISCARD_REASON08_AMOUNT "
					+ "FROM LEVEL_TEMP_TAB A , LEVEL_TEMP_TAB B WHERE A.ASSET_CLASS_CODE IN ( "
					+ "SELECT E.ASSET_CLASS_CODE FROM LEVEL_TEMP_TAB E START WITH  "
					+ "E.ASSET_CLASS_CODE=B.ASSET_CLASS_CODE "
					+ "CONNECT BY E.PARENT_CLASS_CODE=PRIOR E.ASSET_CLASS_CODE)GROUP BY  "
					+ "B.CATEGORY,B.ASSET_CLASS_CODE,B.VOLTAGE_LEVEL ORDER BY 2)SELECT  "
					+ "CATEGORY,ASSET_CLASS_CODE,INDICATE_DIMENSION,VOLTAGE_LEVEL, "
					+ "A.DISCARD_REASON01_ORIGIN_VAL DISCARD_REASON01, "
					+ "A.DISCARD_REASON02_ORIGIN_VAL DISCARD_REASON02, "
					+ "A.DISCARD_REASON03_ORIGIN_VAL DISCARD_REASON03, "
					+ "A.DISCARD_REASON04_ORIGIN_VAL DISCARD_REASON04, "
					+ "A.DISCARD_REASON05_ORIGIN_VAL DISCARD_REASON05, "
					+ "A.DISCARD_REASON06_ORIGIN_VAL DISCARD_REASON06, "
					+ "A.DISCARD_REASON07_ORIGIN_VAL DISCARD_REASON07, "
					+ "A.DISCARD_REASON08_ORIGIN_VAL DISCARD_REASON08   " + "FROM ORIGINAL_TEMP A UNION ALL SELECT  "
					+ "CATEGORY,ASSET_CLASS_CODE,INDICATE_DIMENSION,VOLTAGE_LEVEL, "
					+ "A.DISCARD_REASON01_NET_VAL  DISCARD_REASON01 , "
					+ "A.DISCARD_REASON02_NET_VAL  DISCARD_REASON02 , "
					+ "A.DISCARD_REASON03_NET_VAL  DISCARD_REASON03 , "
					+ "A.DISCARD_REASON04_NET_VAL  DISCARD_REASON04 , "
					+ "A.DISCARD_REASON05_NET_VAL  DISCARD_REASON05 , "
					+ "A.DISCARD_REASON06_NET_VAL  DISCARD_REASON06 , "
					+ "A.DISCARD_REASON07_NET_VAL  DISCARD_REASON07 , "
					+ "A.DISCARD_REASON08_NET_VAL  DISCARD_REASON08   " + " FROM NET_TEMP A UNION ALL SELECT  "
					+ "CATEGORY,ASSET_CLASS_CODE,INDICATE_DIMENSION,VOLTAGE_LEVEL, "
					+ "A.DISCARD_REASON01_AMOUNT  DISCARD_REASON01, " + "A.DISCARD_REASON02_AMOUNT  DISCARD_REASON02, "
					+ "A.DISCARD_REASON03_AMOUNT  DISCARD_REASON03, " + "A.DISCARD_REASON04_AMOUNT  DISCARD_REASON04, "
					+ "A.DISCARD_REASON05_AMOUNT  DISCARD_REASON05, " + "A.DISCARD_REASON06_AMOUNT  DISCARD_REASON06, "
					+ "A.DISCARD_REASON07_AMOUNT  DISCARD_REASON07, " + "A.DISCARD_REASON08_AMOUNT  DISCARD_REASON08 "
					+ " FROM AMOUNT_TEMP A ORDER BY 2 ,3  ";

			try {
				new ReportOutput2().writeXLSXDiscard(reportSQL, templateFilePathAndName, targetFilePathAndName,
						reportName, voltageRelationCode, dataVersion, areaName, sheetName, startRowNumber,
						startColumnNumber);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			sheetName = "A.5.2 报废资产规模结构（成因）-规模";
			reportName = "A.5.2 报废资产规模结构（成因）-规模";
			System.out.println(sheetName + " Start!");
			// dataVersion = "M_2019_2";
			// dataVersion = "M_2019_3";// 20200612--河北
			dataVersion = "M_2019_2";// 20200612--湖北
			// 循环输出表格中的内容,首先循环取出行,再根据行循环取出列
			startRowNumber = 5;
			startColumnNumber = 2;
			reportSQL = "WITH STRUCTRUE_TEMP_TAB AS (SELECT A.ASSET_CLASS_NAME, "
					+ "A.ASSET_CLASS_CODE,B.VOLTAGE_NAME,B.INDEXOF FROM DV_ASSET_CLASS A "
					+ "LEFT JOIN (SELECT  C.VOLTAGE_NAME,B.DV_ASSET_CLASS_ID, "
					+ "B.INDEXOF FROM DV_VOLTAGE_RELATION B  INNER JOIN  "
					+ "DV_VOLTAGE_LEVEL C ON B.DV_VOLTAGE_LEVEL_ID=C.DV_VOLTAGE_LEVEL_ID  "
					+ "WHERE B.VOLTAGE_RELATION_CODE=?)B  " + // 1
					"ON A.DV_ASSET_CLASS_ID=B.DV_ASSET_CLASS_ID ORDER BY  "
					+ "A.ASSET_CLASS_CODE ,B.INDEXOF ),SPAN_STRUCTURE_TAB AS ( "
					+ "SELECT A.ASSET_CLASS_NAME,DECODE(A.VOLTAGE_NAME,NULL,A.ASSET_CLASS_CODE, "
					+ "DECODE(LENGTH(TO_CHAR(A.INDEXOF)),1,A.ASSET_CLASS_CODE||'10'||A.INDEXOF, "
					+ "2,A.ASSET_CLASS_CODE||'1'||A.INDEXOF)) STRUCTURE_CODE,A.ASSET_CLASS_CODE, "
					+ "VOLTAGE_NAME,INDEXOF  FROM STRUCTRUE_TEMP_TAB A  ORDER BY "
					+ "STRUCTURE_CODE,INDEXOF ),STRUCT_TEMP_RESULT AS (SELECT  "
					+ "A.ASSET_CLASS_NAME, A.ASSET_CLASS_CODE,B.VOLTAGE_NAME,B.INDEXOF  "
					+ "FROM DV_ASSET_CLASS A LEFT JOIN SPAN_STRUCTURE_TAB B ON A.ASSET_CLASS_CODE=B.STRUCTURE_CODE  "
					+ "UNION ALL SELECT B.ASSET_CLASS_NAME,B.STRUCTURE_CODE ASSET_CLASS_CODE,B.VOLTAGE_NAME, "
					+ "B.INDEXOF FROM SPAN_STRUCTURE_TAB B ORDER BY ASSET_CLASS_CODE,INDEXOF  "
					+ "),RESULT_TEMP_TAB AS (SELECT A.ASSET_CLASS_NAME CATEGORY,A.ASSET_CLASS_CODE,A.VOLTAGE_NAME VOLTAGE_LEVEL, "
					+ "DECODE(B.DISCARD_REASON01_ORIGIN_VAL,NULL,0,B.DISCARD_REASON01_ORIGIN_VAL) DISCARD_REASON01_ORIGIN_VAL, "
					+ "DECODE(B.DISCARD_REASON02_ORIGIN_VAL,NULL,0,B.DISCARD_REASON02_ORIGIN_VAL) DISCARD_REASON02_ORIGIN_VAL, "
					+ "DECODE(B.DISCARD_REASON03_ORIGIN_VAL,NULL,0,B.DISCARD_REASON03_ORIGIN_VAL) DISCARD_REASON03_ORIGIN_VAL, "
					+ "DECODE(B.DISCARD_REASON04_ORIGIN_VAL,NULL,0,B.DISCARD_REASON04_ORIGIN_VAL) DISCARD_REASON04_ORIGIN_VAL, "
					+ "DECODE(B.DISCARD_REASON05_ORIGIN_VAL,NULL,0,B.DISCARD_REASON05_ORIGIN_VAL) DISCARD_REASON05_ORIGIN_VAL, "
					+ "DECODE(B.DISCARD_REASON06_ORIGIN_VAL,NULL,0,B.DISCARD_REASON06_ORIGIN_VAL) DISCARD_REASON06_ORIGIN_VAL, "
					+ "DECODE(B.DISCARD_REASON07_ORIGIN_VAL,NULL,0,B.DISCARD_REASON07_ORIGIN_VAL) DISCARD_REASON07_ORIGIN_VAL, "
					+ "DECODE(B.DISCARD_REASON08_ORIGIN_VAL,NULL,0,B.DISCARD_REASON08_ORIGIN_VAL) DISCARD_REASON08_ORIGIN_VAL, "
					+ "DECODE(B.DISCARD_REASON01_NET_VAL,NULL,0,B.DISCARD_REASON01_NET_VAL) DISCARD_REASON01_NET_VAL, "
					+ "DECODE(B.DISCARD_REASON02_NET_VAL,NULL,0,B.DISCARD_REASON02_NET_VAL) DISCARD_REASON02_NET_VAL, "
					+ "DECODE(B.DISCARD_REASON03_NET_VAL,NULL,0,B.DISCARD_REASON03_NET_VAL) DISCARD_REASON03_NET_VAL, "
					+ "DECODE(B.DISCARD_REASON04_NET_VAL,NULL,0,B.DISCARD_REASON04_NET_VAL) DISCARD_REASON04_NET_VAL, "
					+ "DECODE(B.DISCARD_REASON05_NET_VAL,NULL,0,B.DISCARD_REASON05_NET_VAL) DISCARD_REASON05_NET_VAL, "
					+ "DECODE(B.DISCARD_REASON06_NET_VAL,NULL,0,B.DISCARD_REASON06_NET_VAL) DISCARD_REASON06_NET_VAL, "
					+ "DECODE(B.DISCARD_REASON07_NET_VAL,NULL,0,B.DISCARD_REASON07_NET_VAL) DISCARD_REASON07_NET_VAL, "
					+ "DECODE(B.DISCARD_REASON08_NET_VAL,NULL,0,B.DISCARD_REASON08_NET_VAL) DISCARD_REASON08_NET_VAL, "
					+ "DECODE(B.DISCARD_REASON01_CAPACITY,NULL,0,B.DISCARD_REASON01_CAPACITY) DISCARD_REASON01_CAPACITY, "
					+ "DECODE(B.DISCARD_REASON02_CAPACITY,NULL,0,B.DISCARD_REASON02_CAPACITY) DISCARD_REASON02_CAPACITY, "
					+ "DECODE(B.DISCARD_REASON03_CAPACITY,NULL,0,B.DISCARD_REASON03_CAPACITY) DISCARD_REASON03_CAPACITY, "
					+ "DECODE(B.DISCARD_REASON04_CAPACITY,NULL,0,B.DISCARD_REASON04_CAPACITY) DISCARD_REASON04_CAPACITY, "
					+ "DECODE(B.DISCARD_REASON05_CAPACITY,NULL,0,B.DISCARD_REASON05_CAPACITY) DISCARD_REASON05_CAPACITY, "
					+ "DECODE(B.DISCARD_REASON06_CAPACITY,NULL,0,B.DISCARD_REASON06_CAPACITY) DISCARD_REASON06_CAPACITY, "
					+ "DECODE(B.DISCARD_REASON07_CAPACITY,NULL,0,B.DISCARD_REASON07_CAPACITY) DISCARD_REASON07_CAPACITY, "
					+ "DECODE(B.DISCARD_REASON08_CAPACITY,NULL,0,B.DISCARD_REASON08_CAPACITY) DISCARD_REASON08_CAPACITY   "
					+ "FROM (SELECT  DISTINCT  * FROM STRUCT_TEMP_RESULT )A LEFT JOIN (SELECT  "
					+ "EXTRACT(YEAR FROM A.DV_DATE_VALUE) CAL_YEAR,A. CATEGORY ,A.VOLTAGE_LEVEL, "
					+ "SUM(A.DISCARD_REASON01_ORIGIN_VAL) DISCARD_REASON01_ORIGIN_VAL, "
					+ "SUM(A.DISCARD_REASON02_ORIGIN_VAL) DISCARD_REASON02_ORIGIN_VAL, "
					+ "SUM(A.DISCARD_REASON03_ORIGIN_VAL) DISCARD_REASON03_ORIGIN_VAL, "
					+ "SUM(A.DISCARD_REASON04_ORIGIN_VAL) DISCARD_REASON04_ORIGIN_VAL, "
					+ "SUM(A.DISCARD_REASON05_ORIGIN_VAL) DISCARD_REASON05_ORIGIN_VAL, "
					+ "SUM(A.DISCARD_REASON06_ORIGIN_VAL) DISCARD_REASON06_ORIGIN_VAL, "
					+ "SUM(A.DISCARD_REASON07_ORIGIN_VAL) DISCARD_REASON07_ORIGIN_VAL, "
					+ "SUM(A.DISCARD_REASON08_ORIGIN_VAL) DISCARD_REASON08_ORIGIN_VAL, "
					+ "SUM(A.DISCARD_REASON01_NET_VAL) DISCARD_REASON01_NET_VAL, "
					+ "SUM(A.DISCARD_REASON02_NET_VAL) DISCARD_REASON02_NET_VAL, "
					+ "SUM(A.DISCARD_REASON03_NET_VAL) DISCARD_REASON03_NET_VAL, "
					+ "SUM(A.DISCARD_REASON04_NET_VAL) DISCARD_REASON04_NET_VAL, "
					+ "SUM(A.DISCARD_REASON05_NET_VAL) DISCARD_REASON05_NET_VAL, "
					+ "SUM(A.DISCARD_REASON06_NET_VAL) DISCARD_REASON06_NET_VAL, "
					+ "SUM(A.DISCARD_REASON07_NET_VAL) DISCARD_REASON07_NET_VAL, "
					+ "SUM(A.DISCARD_REASON08_NET_VAL) DISCARD_REASON08_NET_VAL, "
					+ "SUM(A.DISCARD_REASON01_CAPACITY) DISCARD_REASON01_CAPACITY, "
					+ "SUM(A.DISCARD_REASON02_CAPACITY) DISCARD_REASON02_CAPACITY, "
					+ "SUM(A.DISCARD_REASON03_CAPACITY) DISCARD_REASON03_CAPACITY, "
					+ "SUM(A.DISCARD_REASON04_CAPACITY) DISCARD_REASON04_CAPACITY, "
					+ "SUM(A.DISCARD_REASON05_CAPACITY) DISCARD_REASON05_CAPACITY, "
					+ "SUM(A.DISCARD_REASON06_CAPACITY) DISCARD_REASON06_CAPACITY, "
					+ "SUM(A.DISCARD_REASON07_CAPACITY) DISCARD_REASON07_CAPACITY, "
					+ "SUM(A.DISCARD_REASON08_CAPACITY) DISCARD_REASON08_CAPACITY "
					+ "FROM (SELECT E.ORG_ALIAS_NAME,F.AREA_NAME FROM DV_ORG_ALIAS E INNER JOIN  "
					+ "DV_ORG F ON E.DV_ORG_ID=F.DV_ORG_ID AND F.AREA_NAME IN (  "
					+ "SELECT A.AREA_NAME FROM DV_AREA A WHERE  EXISTS (SELECT 1 FROM DV_AREA B WHERE  "
					+ "(DECODE( B.IS_LEAF,0, 1,0	)=1 AND B.AREA_NAME=? AND ( " + // 2
					"SUBSTR(A.AREA_CODE,0,LENGTH(A.AREA_CODE)-3)=B.AREA_CODE OR ( "
					+ "A.IS_LEAF=0 AND B.AREA_CODE=A.AREA_CODE )))OR (DECODE( B.IS_LEAF,0, 1,0	)=0  "
					+ "AND B.AREA_NAME= ?  AND A.AREA_CODE=B.AREA_CODE)) )) F  " + // 3
					"INNER JOIN MID_ASSET_DISCARD A ON A.ORG_NAME=F.ORG_ALIAS_NAME   "
					+ "WHERE VERSION= ? GROUP BY EXTRACT(YEAR FROM A.DV_DATE_VALUE), " + // 4
					"A. CATEGORY ,A.VOLTAGE_LEVEL) B ON(A.ASSET_CLASS_NAME=B. CATEGORY AND  "
					+ "DECODE(A.VOLTAGE_NAME,NULL,'BLANK',A.VOLTAGE_NAME)=DECODE(B.VOLTAGE_LEVEL,NULL,'BLANK',B.VOLTAGE_LEVEL) "
					+ ")ORDER BY ASSET_CLASS_CODE,INDEXOF ),LEVEL_TEMP_TAB AS (SELECT  A.CATEGORY, "
					+ "A.ASSET_CLASS_CODE,DECODE(LENGTH(A.ASSET_CLASS_CODE), "
					+ "3,NULL,SUBSTR(A.ASSET_CLASS_CODE,0,LENGTH(A.ASSET_CLASS_CODE)-3)) "
					+ "PARENT_CLASS_CODE,A.VOLTAGE_LEVEL,A.DISCARD_REASON01_ORIGIN_VAL, "
					+ "A.DISCARD_REASON02_ORIGIN_VAL,A.DISCARD_REASON03_ORIGIN_VAL, "
					+ "A.DISCARD_REASON04_ORIGIN_VAL,A.DISCARD_REASON05_ORIGIN_VAL, "
					+ "A.DISCARD_REASON06_ORIGIN_VAL,A.DISCARD_REASON07_ORIGIN_VAL, "
					+ "A.DISCARD_REASON08_ORIGIN_VAL,A.DISCARD_REASON01_NET_VAL, "
					+ "A.DISCARD_REASON02_NET_VAL,A.DISCARD_REASON03_NET_VAL, "
					+ "A.DISCARD_REASON04_NET_VAL,A.DISCARD_REASON05_NET_VAL, "
					+ "A.DISCARD_REASON06_NET_VAL,A.DISCARD_REASON07_NET_VAL, "
					+ "A.DISCARD_REASON08_NET_VAL,A.DISCARD_REASON01_CAPACITY, "
					+ "A.DISCARD_REASON02_CAPACITY,A.DISCARD_REASON03_CAPACITY, "
					+ "A.DISCARD_REASON04_CAPACITY,A.DISCARD_REASON05_CAPACITY, "
					+ "A.DISCARD_REASON06_CAPACITY,A.DISCARD_REASON07_CAPACITY, "
					+ "A.DISCARD_REASON08_CAPACITY   FROM RESULT_TEMP_TAB A), ORIGINAL_TEMP AS (  "
					+ "SELECT B.CATEGORY,B.ASSET_CLASS_CODE,'001' INDICATE_DIMENSION, "
					+ "B.VOLTAGE_LEVEL, SUM(A.DISCARD_REASON01_ORIGIN_VAL) DISCARD_REASON01_ORIGIN_VAL, "
					+ "SUM(A.DISCARD_REASON02_ORIGIN_VAL) DISCARD_REASON02_ORIGIN_VAL, "
					+ "SUM(A.DISCARD_REASON03_ORIGIN_VAL) DISCARD_REASON03_ORIGIN_VAL, "
					+ "SUM(A.DISCARD_REASON04_ORIGIN_VAL) DISCARD_REASON04_ORIGIN_VAL, "
					+ "SUM(A.DISCARD_REASON05_ORIGIN_VAL) DISCARD_REASON05_ORIGIN_VAL, "
					+ "SUM(A.DISCARD_REASON06_ORIGIN_VAL) DISCARD_REASON06_ORIGIN_VAL, "
					+ "SUM(A.DISCARD_REASON07_ORIGIN_VAL) DISCARD_REASON07_ORIGIN_VAL, "
					+ "SUM(A.DISCARD_REASON08_ORIGIN_VAL) DISCARD_REASON08_ORIGIN_VAL "
					+ "FROM LEVEL_TEMP_TAB A , LEVEL_TEMP_TAB B  "
					+ "WHERE A.ASSET_CLASS_CODE IN (SELECT E.ASSET_CLASS_CODE FROM LEVEL_TEMP_TAB E  "
					+ "START WITH E.ASSET_CLASS_CODE=B.ASSET_CLASS_CODE "
					+ "CONNECT BY E.PARENT_CLASS_CODE=PRIOR E.ASSET_CLASS_CODE)GROUP BY B.CATEGORY, "
					+ "B.ASSET_CLASS_CODE,B.VOLTAGE_LEVEL ORDER BY 2), NET_TEMP AS (  "
					+ "SELECT B.CATEGORY,B.ASSET_CLASS_CODE,'002' INDICATE_DIMENSION,B.VOLTAGE_LEVEL,  "
					+ "SUM(A.DISCARD_REASON01_NET_VAL) DISCARD_REASON01_NET_VAL, "
					+ "SUM(A.DISCARD_REASON02_NET_VAL) DISCARD_REASON02_NET_VAL, "
					+ "SUM(A.DISCARD_REASON03_NET_VAL) DISCARD_REASON03_NET_VAL, "
					+ "SUM(A.DISCARD_REASON04_NET_VAL) DISCARD_REASON04_NET_VAL, "
					+ "SUM(A.DISCARD_REASON05_NET_VAL) DISCARD_REASON05_NET_VAL, "
					+ "SUM(A.DISCARD_REASON06_NET_VAL) DISCARD_REASON06_NET_VAL, "
					+ "SUM(A.DISCARD_REASON07_NET_VAL) DISCARD_REASON07_NET_VAL, "
					+ "SUM(A.DISCARD_REASON08_NET_VAL) DISCARD_REASON08_NET_VAL  "
					+ "FROM LEVEL_TEMP_TAB A , LEVEL_TEMP_TAB B WHERE  "
					+ "A.ASSET_CLASS_CODE IN (SELECT E.ASSET_CLASS_CODE FROM LEVEL_TEMP_TAB E  "
					+ "START WITH E.ASSET_CLASS_CODE=B.ASSET_CLASS_CODE "
					+ "CONNECT BY E.PARENT_CLASS_CODE=PRIOR E.ASSET_CLASS_CODE "
					+ ")GROUP BY B.CATEGORY,B.ASSET_CLASS_CODE, "
					+ "B.VOLTAGE_LEVEL ORDER BY 2), AMOUNT_TEMP AS ( SELECT  "
					+ "B.CATEGORY,B.ASSET_CLASS_CODE,'003' INDICATE_DIMENSION,B.VOLTAGE_LEVEL,  "
					+ "SUM(A.DISCARD_REASON01_CAPACITY) DISCARD_REASON01_CAPACITY, "
					+ "SUM(A.DISCARD_REASON02_CAPACITY) DISCARD_REASON02_CAPACITY, "
					+ "SUM(A.DISCARD_REASON03_CAPACITY) DISCARD_REASON03_CAPACITY, "
					+ "SUM(A.DISCARD_REASON04_CAPACITY) DISCARD_REASON04_CAPACITY, "
					+ "SUM(A.DISCARD_REASON05_CAPACITY) DISCARD_REASON05_CAPACITY, "
					+ "SUM(A.DISCARD_REASON06_CAPACITY) DISCARD_REASON06_CAPACITY, "
					+ "SUM(A.DISCARD_REASON07_CAPACITY) DISCARD_REASON07_CAPACITY, "
					+ "SUM(A.DISCARD_REASON08_CAPACITY) DISCARD_REASON08_CAPACITY  "
					+ "FROM LEVEL_TEMP_TAB A , LEVEL_TEMP_TAB B  "
					+ "WHERE A.ASSET_CLASS_CODE IN (SELECT E.ASSET_CLASS_CODE  "
					+ "FROM LEVEL_TEMP_TAB E START WITH E.ASSET_CLASS_CODE=B.ASSET_CLASS_CODE "
					+ "CONNECT BY E.PARENT_CLASS_CODE=PRIOR E.ASSET_CLASS_CODE) "
					+ "GROUP BY B.CATEGORY,B.ASSET_CLASS_CODE,B.VOLTAGE_LEVEL ORDER BY 2) "
					+ "SELECT CATEGORY,ASSET_CLASS_CODE,INDICATE_DIMENSION,VOLTAGE_LEVEL, "
					+ "A.DISCARD_REASON01_ORIGIN_VAL DISCARD_REASON01, "
					+ "A.DISCARD_REASON02_ORIGIN_VAL DISCARD_REASON02, "
					+ "A.DISCARD_REASON03_ORIGIN_VAL DISCARD_REASON03, "
					+ "A.DISCARD_REASON04_ORIGIN_VAL DISCARD_REASON04, "
					+ "A.DISCARD_REASON05_ORIGIN_VAL DISCARD_REASON05, "
					+ "A.DISCARD_REASON06_ORIGIN_VAL DISCARD_REASON06, "
					+ "A.DISCARD_REASON07_ORIGIN_VAL DISCARD_REASON07, "
					+ "A.DISCARD_REASON08_ORIGIN_VAL DISCARD_REASON08   FROM ORIGINAL_TEMP A "
					+ "UNION ALL SELECT CATEGORY,ASSET_CLASS_CODE,INDICATE_DIMENSION,VOLTAGE_LEVEL, "
					+ "A.DISCARD_REASON01_NET_VAL  DISCARD_REASON01 , "
					+ "A.DISCARD_REASON02_NET_VAL  DISCARD_REASON02 , "
					+ "A.DISCARD_REASON03_NET_VAL  DISCARD_REASON03 , "
					+ "A.DISCARD_REASON04_NET_VAL  DISCARD_REASON04 , "
					+ "A.DISCARD_REASON05_NET_VAL  DISCARD_REASON05 , "
					+ "A.DISCARD_REASON06_NET_VAL  DISCARD_REASON06 , "
					+ "A.DISCARD_REASON07_NET_VAL  DISCARD_REASON07 , "
					+ "A.DISCARD_REASON08_NET_VAL  DISCARD_REASON08   FROM NET_TEMP A "
					+ "UNION ALL SELECT CATEGORY,ASSET_CLASS_CODE,INDICATE_DIMENSION,VOLTAGE_LEVEL, "
					+ "A.DISCARD_REASON01_CAPACITY  DISCARD_REASON01, "
					+ "A.DISCARD_REASON02_CAPACITY  DISCARD_REASON02, "
					+ "A.DISCARD_REASON03_CAPACITY  DISCARD_REASON03, "
					+ "A.DISCARD_REASON04_CAPACITY  DISCARD_REASON04, "
					+ "A.DISCARD_REASON05_CAPACITY  DISCARD_REASON05, "
					+ "A.DISCARD_REASON06_CAPACITY  DISCARD_REASON06, "
					+ "A.DISCARD_REASON07_CAPACITY  DISCARD_REASON07, "
					+ "A.DISCARD_REASON08_CAPACITY  DISCARD_REASON08 FROM AMOUNT_TEMP A ORDER BY 2 ,3 ";

			try {
				new ReportOutput2().writeXLSXDiscard(reportSQL, templateFilePathAndName, targetFilePathAndName,
						reportName, voltageRelationCode, dataVersion, areaName, sheetName, startRowNumber,
						startColumnNumber);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			sheetName = "A.5.3 报废资产规模结构（成因） (成新率5%以上资产)";
			reportName = "A.5.3 报废资产规模结构（成因） (成新率5%以上资产)";
			System.out.println(sheetName + " Start!");
			// dataVersion = "M_2019_2";
			//
			dataVersion = "M_2019_3";// 20200612--河北
			// dataVersion = "M_2019_2";// 20200612--湖北
			// 循环输出表格中的内容,首先循环取出行,再根据行循环取出列
			startRowNumber = 5;
			startColumnNumber = 2;
			reportSQL = "WITH STRUCTRUE_TEMP_TAB AS (SELECT A.ASSET_CLASS_NAME,A.ASSET_CLASS_CODE, "
					+ "B.VOLTAGE_NAME,B.INDEXOF FROM DV_ASSET_CLASS A LEFT JOIN  "
					+ "(SELECT  C.VOLTAGE_NAME,B.DV_ASSET_CLASS_ID,B.INDEXOF  "
					+ "FROM DV_VOLTAGE_RELATION B  INNER JOIN DV_VOLTAGE_LEVEL C  "
					+ "ON B.DV_VOLTAGE_LEVEL_ID=C.DV_VOLTAGE_LEVEL_ID  " + "WHERE B.VOLTAGE_RELATION_CODE=?)B  " + // 1
					"ON A.DV_ASSET_CLASS_ID=B.DV_ASSET_CLASS_ID  " + "ORDER BY A.ASSET_CLASS_CODE ,B.INDEXOF  "
					+ "),SPAN_STRUCTURE_TAB AS (SELECT A.ASSET_CLASS_NAME, "
					+ "DECODE(A.VOLTAGE_NAME,NULL,A.ASSET_CLASS_CODE,DECODE(LENGTH(TO_CHAR(A.INDEXOF)),"
					+ "1,A.ASSET_CLASS_CODE||'10'||A.INDEXOF, "
					+ "2,A.ASSET_CLASS_CODE||'1'||A.INDEXOF)) STRUCTURE_CODE,A.ASSET_CLASS_CODE,VOLTAGE_NAME, "
					+ "INDEXOF FROM STRUCTRUE_TEMP_TAB A  ORDER BY STRUCTURE_CODE, "
					+ "INDEXOF ),STRUCT_TEMP_RESULT AS (SELECT A.ASSET_CLASS_NAME,  "
					+ "A.ASSET_CLASS_CODE,B.VOLTAGE_NAME,B.INDEXOF FROM DV_ASSET_CLASS A  "
					+ "LEFT JOIN SPAN_STRUCTURE_TAB B ON A.ASSET_CLASS_CODE=B.STRUCTURE_CODE "
					+ "UNION ALL SELECT B.ASSET_CLASS_NAME,B.STRUCTURE_CODE ASSET_CLASS_CODE, "
					+ "B.VOLTAGE_NAME,B.INDEXOF FROM SPAN_STRUCTURE_TAB B ORDER BY "
					+ "ASSET_CLASS_CODE,INDEXOF ),RESULT_TEMP_TAB AS (SELECT A.ASSET_CLASS_NAME CATEGORY, "
					+ "A.ASSET_CLASS_CODE,A.VOLTAGE_NAME VOLTAGE_LEVEL, "
					+ "DECODE(B.DISCARD_REASON01_ORIGIN_VAL_5,NULL,0,B.DISCARD_REASON01_ORIGIN_VAL_5) DISCARD_REASON01_ORIGIN_VAL_5, "
					+ "DECODE(B.DISCARD_REASON02_ORIGIN_VAL_5,NULL,0,B.DISCARD_REASON02_ORIGIN_VAL_5) DISCARD_REASON02_ORIGIN_VAL_5, "
					+ "DECODE(B.DISCARD_REASON03_ORIGIN_VAL_5,NULL,0,B.DISCARD_REASON03_ORIGIN_VAL_5) DISCARD_REASON03_ORIGIN_VAL_5, "
					+ "DECODE(B.DISCARD_REASON04_ORIGIN_VAL_5,NULL,0,B.DISCARD_REASON04_ORIGIN_VAL_5) DISCARD_REASON04_ORIGIN_VAL_5, "
					+ "DECODE(B.DISCARD_REASON05_ORIGIN_VAL_5,NULL,0,B.DISCARD_REASON05_ORIGIN_VAL_5) DISCARD_REASON05_ORIGIN_VAL_5, "
					+ "DECODE(B.DISCARD_REASON06_ORIGIN_VAL_5,NULL,0,B.DISCARD_REASON06_ORIGIN_VAL_5) DISCARD_REASON06_ORIGIN_VAL_5, "
					+ "DECODE(B.DISCARD_REASON07_ORIGIN_VAL_5,NULL,0,B.DISCARD_REASON07_ORIGIN_VAL_5) DISCARD_REASON07_ORIGIN_VAL_5, "
					+ "DECODE(B.DISCARD_REASON08_ORIGIN_VAL_5,NULL,0,B.DISCARD_REASON08_ORIGIN_VAL_5) DISCARD_REASON08_ORIGIN_VAL_5, "
					+ "DECODE(B.DISCARD_REASON01_NET_VAL_5,NULL,0,B.DISCARD_REASON01_NET_VAL_5) DISCARD_REASON01_NET_VAL_5, "
					+ "DECODE(B.DISCARD_REASON02_NET_VAL_5,NULL,0,B.DISCARD_REASON02_NET_VAL_5) DISCARD_REASON02_NET_VAL_5, "
					+ "DECODE(B.DISCARD_REASON03_NET_VAL_5,NULL,0,B.DISCARD_REASON03_NET_VAL_5) DISCARD_REASON03_NET_VAL_5, "
					+ "DECODE(B.DISCARD_REASON04_NET_VAL_5,NULL,0,B.DISCARD_REASON04_NET_VAL_5) DISCARD_REASON04_NET_VAL_5, "
					+ "DECODE(B.DISCARD_REASON05_NET_VAL_5,NULL,0,B.DISCARD_REASON05_NET_VAL_5) DISCARD_REASON05_NET_VAL_5, "
					+ "DECODE(B.DISCARD_REASON06_NET_VAL_5,NULL,0,B.DISCARD_REASON06_NET_VAL_5) DISCARD_REASON06_NET_VAL_5, "
					+ "DECODE(B.DISCARD_REASON07_NET_VAL_5,NULL,0,B.DISCARD_REASON07_NET_VAL_5) DISCARD_REASON07_NET_VAL_5, "
					+ "DECODE(B.DISCARD_REASON08_NET_VAL_5,NULL,0,B.DISCARD_REASON08_NET_VAL_5) DISCARD_REASON08_NET_VAL_5, "
					+ "DECODE(B.DISCARD_REASON01_AMOUNT_5,NULL,0,B.DISCARD_REASON01_AMOUNT_5) DISCARD_REASON01_AMOUNT_5, "
					+ "DECODE(B.DISCARD_REASON02_AMOUNT_5,NULL,0,B.DISCARD_REASON02_AMOUNT_5) DISCARD_REASON02_AMOUNT_5, "
					+ "DECODE(B.DISCARD_REASON03_AMOUNT_5,NULL,0,B.DISCARD_REASON03_AMOUNT_5) DISCARD_REASON03_AMOUNT_5, "
					+ "DECODE(B.DISCARD_REASON04_AMOUNT_5,NULL,0,B.DISCARD_REASON04_AMOUNT_5) DISCARD_REASON04_AMOUNT_5, "
					+ "DECODE(B.DISCARD_REASON05_AMOUNT_5,NULL,0,B.DISCARD_REASON05_AMOUNT_5) DISCARD_REASON05_AMOUNT_5, "
					+ "DECODE(B.DISCARD_REASON06_AMOUNT_5,NULL,0,B.DISCARD_REASON06_AMOUNT_5) DISCARD_REASON06_AMOUNT_5, "
					+ "DECODE(B.DISCARD_REASON07_AMOUNT_5,NULL,0,B.DISCARD_REASON07_AMOUNT_5) DISCARD_REASON07_AMOUNT_5, "
					+ "DECODE(B.DISCARD_REASON08_AMOUNT_5,NULL,0,B.DISCARD_REASON08_AMOUNT_5) DISCARD_REASON08_AMOUNT_5  "
					+ "FROM (SELECT  DISTINCT  * FROM STRUCT_TEMP_RESULT )A LEFT JOIN (SELECT  "
					+ "EXTRACT(YEAR FROM A.DV_DATE_VALUE) CAL_YEAR,A. CATEGORY ,A.VOLTAGE_LEVEL, "
					+ "SUM(A.DISCARD_REASON01_ORIGIN_VAL_5) DISCARD_REASON01_ORIGIN_VAL_5, "
					+ "SUM(A.DISCARD_REASON02_ORIGIN_VAL_5) DISCARD_REASON02_ORIGIN_VAL_5, "
					+ "SUM(A.DISCARD_REASON03_ORIGIN_VAL_5) DISCARD_REASON03_ORIGIN_VAL_5, "
					+ "SUM(A.DISCARD_REASON04_ORIGIN_VAL_5) DISCARD_REASON04_ORIGIN_VAL_5, "
					+ "SUM(A.DISCARD_REASON05_ORIGIN_VAL_5) DISCARD_REASON05_ORIGIN_VAL_5, "
					+ "SUM(A.DISCARD_REASON06_ORIGIN_VAL_5) DISCARD_REASON06_ORIGIN_VAL_5, "
					+ "SUM(A.DISCARD_REASON07_ORIGIN_VAL_5) DISCARD_REASON07_ORIGIN_VAL_5, "
					+ "SUM(A.DISCARD_REASON08_ORIGIN_VAL_5) DISCARD_REASON08_ORIGIN_VAL_5, "
					+ "SUM(A.DISCARD_REASON01_NET_VAL_5) DISCARD_REASON01_NET_VAL_5, "
					+ "SUM(A.DISCARD_REASON02_NET_VAL_5) DISCARD_REASON02_NET_VAL_5, "
					+ "SUM(A.DISCARD_REASON03_NET_VAL_5) DISCARD_REASON03_NET_VAL_5, "
					+ "SUM(A.DISCARD_REASON04_NET_VAL_5) DISCARD_REASON04_NET_VAL_5, "
					+ "SUM(A.DISCARD_REASON05_NET_VAL_5) DISCARD_REASON05_NET_VAL_5, "
					+ "SUM(A.DISCARD_REASON06_NET_VAL_5) DISCARD_REASON06_NET_VAL_5, "
					+ "SUM(A.DISCARD_REASON07_NET_VAL_5) DISCARD_REASON07_NET_VAL_5, "
					+ "SUM(A.DISCARD_REASON08_NET_VAL_5) DISCARD_REASON08_NET_VAL_5, "
					+ "SUM(A.DISCARD_REASON01_AMOUNT_5) DISCARD_REASON01_AMOUNT_5, "
					+ "SUM(A.DISCARD_REASON02_AMOUNT_5) DISCARD_REASON02_AMOUNT_5, "
					+ "SUM(A.DISCARD_REASON03_AMOUNT_5) DISCARD_REASON03_AMOUNT_5, "
					+ "SUM(A.DISCARD_REASON04_AMOUNT_5) DISCARD_REASON04_AMOUNT_5, "
					+ "SUM(A.DISCARD_REASON05_AMOUNT_5) DISCARD_REASON05_AMOUNT_5, "
					+ "SUM(A.DISCARD_REASON06_AMOUNT_5) DISCARD_REASON06_AMOUNT_5, "
					+ "SUM(A.DISCARD_REASON07_AMOUNT_5) DISCARD_REASON07_AMOUNT_5, "
					+ "SUM(A.DISCARD_REASON08_AMOUNT_5) DISCARD_REASON08_AMOUNT_5 "
					+ "FROM (SELECT E.ORG_ALIAS_NAME,F.AREA_NAME FROM DV_ORG_ALIAS E INNER JOIN DV_ORG F  "
					+ "ON E.DV_ORG_ID=F.DV_ORG_ID AND F.AREA_NAME IN ( SELECT A.AREA_NAME FROM DV_AREA A WHERE   "
					+ "EXISTS (SELECT 1 FROM DV_AREA B WHERE (DECODE( B.IS_LEAF,0, 1,0  )=1 AND  "
					+ "B.AREA_NAME=?  AND (SUBSTR(A.AREA_CODE,0,LENGTH(A.AREA_CODE)-3)=B.AREA_CODE " + // 2
					"OR (A.IS_LEAF=0 AND B.AREA_CODE=A.AREA_CODE )))OR (DECODE( B.IS_LEAF,0, 1,0  )=0 AND  "
					+ "B.AREA_NAME=? AND A.AREA_CODE=B.AREA_CODE)) )) F INNER JOIN  " + // 3
					"MID_ASSET_DISCARD_EQU_5 A ON A.ORG_NAME=F.ORG_ALIAS_NAME  WHERE VERSION= ? " + // 4
					"GROUP BY EXTRACT(YEAR FROM A.DV_DATE_VALUE),A. CATEGORY ,A.VOLTAGE_LEVEL "
					+ ") B ON(A.ASSET_CLASS_NAME=B. CATEGORY  AND  "
					+ "DECODE(A.VOLTAGE_NAME,NULL,'BLANK',A.VOLTAGE_NAME)=DECODE(B.VOLTAGE_LEVEL,NULL,'BLANK',B.VOLTAGE_LEVEL) "
					+ ")ORDER BY ASSET_CLASS_CODE,INDEXOF  " + "),LEVEL_TEMP_TAB AS (SELECT  A.CATEGORY, "
					+ "A.ASSET_CLASS_CODE,DECODE(LENGTH(A.ASSET_CLASS_CODE), "
					+ "3,NULL,SUBSTR(A.ASSET_CLASS_CODE,0,LENGTH(A.ASSET_CLASS_CODE)-3)) "
					+ "PARENT_CLASS_CODE,A.VOLTAGE_LEVEL,A.DISCARD_REASON01_ORIGIN_VAL_5, "
					+ "A.DISCARD_REASON02_ORIGIN_VAL_5,A.DISCARD_REASON03_ORIGIN_VAL_5, "
					+ "A.DISCARD_REASON04_ORIGIN_VAL_5,A.DISCARD_REASON05_ORIGIN_VAL_5, "
					+ "A.DISCARD_REASON06_ORIGIN_VAL_5,A.DISCARD_REASON07_ORIGIN_VAL_5, "
					+ "A.DISCARD_REASON08_ORIGIN_VAL_5,A.DISCARD_REASON01_NET_VAL_5, "
					+ "A.DISCARD_REASON02_NET_VAL_5,A.DISCARD_REASON03_NET_VAL_5, "
					+ "A.DISCARD_REASON04_NET_VAL_5,A.DISCARD_REASON05_NET_VAL_5, "
					+ "A.DISCARD_REASON06_NET_VAL_5,A.DISCARD_REASON07_NET_VAL_5, "
					+ "A.DISCARD_REASON08_NET_VAL_5,A.DISCARD_REASON01_AMOUNT_5, "
					+ "A.DISCARD_REASON02_AMOUNT_5,A.DISCARD_REASON03_AMOUNT_5, "
					+ "A.DISCARD_REASON04_AMOUNT_5,A.DISCARD_REASON05_AMOUNT_5, "
					+ "A.DISCARD_REASON06_AMOUNT_5,A.DISCARD_REASON07_AMOUNT_5, "
					+ "A.DISCARD_REASON08_AMOUNT_5   FROM RESULT_TEMP_TAB A), ORIGIN_TEMP AS (SELECT  "
					+ "B.CATEGORY,B.ASSET_CLASS_CODE,'001' INDICATE_DIMENSION,B.VOLTAGE_LEVEL,  "
					+ "SUM(A.DISCARD_REASON01_ORIGIN_VAL_5) DISCARD_REASON01_ORIGIN_VAL_5, "
					+ "SUM(A.DISCARD_REASON02_ORIGIN_VAL_5) DISCARD_REASON02_ORIGIN_VAL_5, "
					+ "SUM(A.DISCARD_REASON03_ORIGIN_VAL_5) DISCARD_REASON03_ORIGIN_VAL_5, "
					+ "SUM(A.DISCARD_REASON04_ORIGIN_VAL_5) DISCARD_REASON04_ORIGIN_VAL_5, "
					+ "SUM(A.DISCARD_REASON05_ORIGIN_VAL_5) DISCARD_REASON05_ORIGIN_VAL_5, "
					+ "SUM(A.DISCARD_REASON06_ORIGIN_VAL_5) DISCARD_REASON06_ORIGIN_VAL_5, "
					+ "SUM(A.DISCARD_REASON07_ORIGIN_VAL_5) DISCARD_REASON07_ORIGIN_VAL_5, "
					+ "SUM(A.DISCARD_REASON08_ORIGIN_VAL_5) DISCARD_REASON08_ORIGIN_VAL_5  "
					+ "FROM LEVEL_TEMP_TAB A , LEVEL_TEMP_TAB B  "
					+ "WHERE A.ASSET_CLASS_CODE IN (SELECT E.ASSET_CLASS_CODE FROM LEVEL_TEMP_TAB E  "
					+ "START WITH E.ASSET_CLASS_CODE=B.ASSET_CLASS_CODE "
					+ "CONNECT BY E.PARENT_CLASS_CODE=PRIOR E.ASSET_CLASS_CODE)GROUP BY B.CATEGORY, "
					+ "B.ASSET_CLASS_CODE,B.VOLTAGE_LEVEL ORDER BY 2), NET_TEMP AS (SELECT  "
					+ "B.CATEGORY,B.ASSET_CLASS_CODE,'002' INDICATE_DIMENSION,B.VOLTAGE_LEVEL,   "
					+ "SUM(A.DISCARD_REASON01_NET_VAL_5) DISCARD_REASON01_NET_VAL_5, "
					+ "SUM(A.DISCARD_REASON02_NET_VAL_5) DISCARD_REASON02_NET_VAL_5, "
					+ "SUM(A.DISCARD_REASON03_NET_VAL_5) DISCARD_REASON03_NET_VAL_5, "
					+ "SUM(A.DISCARD_REASON04_NET_VAL_5) DISCARD_REASON04_NET_VAL_5, "
					+ "SUM(A.DISCARD_REASON05_NET_VAL_5) DISCARD_REASON05_NET_VAL_5, "
					+ "SUM(A.DISCARD_REASON06_NET_VAL_5) DISCARD_REASON06_NET_VAL_5, "
					+ "SUM(A.DISCARD_REASON07_NET_VAL_5) DISCARD_REASON07_NET_VAL_5, "
					+ "SUM(A.DISCARD_REASON08_NET_VAL_5) DISCARD_REASON08_NET_VAL_5  "
					+ "FROM LEVEL_TEMP_TAB A , LEVEL_TEMP_TAB B WHERE A.ASSET_CLASS_CODE IN  "
					+ "(SELECT E.ASSET_CLASS_CODE FROM LEVEL_TEMP_TAB E  "
					+ "START WITH E.ASSET_CLASS_CODE=B.ASSET_CLASS_CODE "
					+ "CONNECT BY E.PARENT_CLASS_CODE=PRIOR E.ASSET_CLASS_CODE " + ")GROUP BY B.CATEGORY, "
					+ "B.ASSET_CLASS_CODE,B.VOLTAGE_LEVEL ORDER BY 2), AMOUNT_TEMP AS (SELECT  "
					+ "B.CATEGORY,B.ASSET_CLASS_CODE,'003' INDICATE_DIMENSION,B.VOLTAGE_LEVEL,   "
					+ "SUM(A.DISCARD_REASON01_AMOUNT_5) DISCARD_REASON01_AMOUNT_5, "
					+ "SUM(A.DISCARD_REASON02_AMOUNT_5) DISCARD_REASON02_AMOUNT_5, "
					+ "SUM(A.DISCARD_REASON03_AMOUNT_5) DISCARD_REASON03_AMOUNT_5, "
					+ "SUM(A.DISCARD_REASON04_AMOUNT_5) DISCARD_REASON04_AMOUNT_5, "
					+ "SUM(A.DISCARD_REASON05_AMOUNT_5) DISCARD_REASON05_AMOUNT_5, "
					+ "SUM(A.DISCARD_REASON06_AMOUNT_5) DISCARD_REASON06_AMOUNT_5, "
					+ "SUM(A.DISCARD_REASON07_AMOUNT_5) DISCARD_REASON07_AMOUNT_5, "
					+ "SUM(A.DISCARD_REASON08_AMOUNT_5) DISCARD_REASON08_AMOUNT_5 "
					+ "FROM LEVEL_TEMP_TAB A , LEVEL_TEMP_TAB B  "
					+ "WHERE A.ASSET_CLASS_CODE IN (SELECT E.ASSET_CLASS_CODE  " + "FROM LEVEL_TEMP_TAB E  "
					+ "START WITH E.ASSET_CLASS_CODE=B.ASSET_CLASS_CODE "
					+ "CONNECT BY E.PARENT_CLASS_CODE=PRIOR E.ASSET_CLASS_CODE) "
					+ "GROUP BY B.CATEGORY,B.ASSET_CLASS_CODE,B.VOLTAGE_LEVEL ORDER BY 2)  "
					+ "SELECT CATEGORY,ASSET_CLASS_CODE,INDICATE_DIMENSION,VOLTAGE_LEVEL, "
					+ "A.DISCARD_REASON01_ORIGIN_VAL_5  DISCARD_REASON01, "
					+ "A.DISCARD_REASON02_ORIGIN_VAL_5  DISCARD_REASON02, "
					+ "A.DISCARD_REASON03_ORIGIN_VAL_5  DISCARD_REASON03, "
					+ "A.DISCARD_REASON04_ORIGIN_VAL_5  DISCARD_REASON04, "
					+ "A.DISCARD_REASON05_ORIGIN_VAL_5  DISCARD_REASON05, "
					+ "A.DISCARD_REASON06_ORIGIN_VAL_5  DISCARD_REASON06, "
					+ "A.DISCARD_REASON07_ORIGIN_VAL_5  DISCARD_REASON07, "
					+ "A.DISCARD_REASON08_ORIGIN_VAL_5  DISCARD_REASON08 " + " FROM ORIGIN_TEMP A UNION ALL SELECT  "
					+ "CATEGORY,ASSET_CLASS_CODE,INDICATE_DIMENSION,VOLTAGE_LEVEL, "
					+ "A.DISCARD_REASON01_NET_VAL_5  DISCARD_REASON01, "
					+ "A.DISCARD_REASON02_NET_VAL_5  DISCARD_REASON02, "
					+ "A.DISCARD_REASON03_NET_VAL_5  DISCARD_REASON03, "
					+ "A.DISCARD_REASON04_NET_VAL_5  DISCARD_REASON04, "
					+ "A.DISCARD_REASON05_NET_VAL_5  DISCARD_REASON05, "
					+ "A.DISCARD_REASON06_NET_VAL_5  DISCARD_REASON06, "
					+ "A.DISCARD_REASON07_NET_VAL_5  DISCARD_REASON07, "
					+ "A.DISCARD_REASON08_NET_VAL_5  DISCARD_REASON08 " + " FROM NET_TEMP A UNION ALL  SELECT  "
					+ "CATEGORY,ASSET_CLASS_CODE,INDICATE_DIMENSION,VOLTAGE_LEVEL, "
					+ "A.DISCARD_REASON01_AMOUNT_5 DISCARD_REASON01, "
					+ "A.DISCARD_REASON02_AMOUNT_5 DISCARD_REASON02, "
					+ "A.DISCARD_REASON03_AMOUNT_5 DISCARD_REASON03, "
					+ "A.DISCARD_REASON04_AMOUNT_5 DISCARD_REASON04, "
					+ "A.DISCARD_REASON05_AMOUNT_5 DISCARD_REASON05, "
					+ "A.DISCARD_REASON06_AMOUNT_5 DISCARD_REASON06, "
					+ "A.DISCARD_REASON07_AMOUNT_5 DISCARD_REASON07, " + "A.DISCARD_REASON08_AMOUNT_5 DISCARD_REASON08 "
					+ " FROM AMOUNT_TEMP A ORDER BY 2,3 ";

			try {
				new ReportOutput2().writeXLSXDiscard(reportSQL, templateFilePathAndName, targetFilePathAndName,
						reportName, voltageRelationCode, dataVersion, areaName, sheetName, startRowNumber,
						startColumnNumber);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			sheetName = "A.5.3 报废资产规模结构（成因） (成新率5%以上)规模";
			reportName = "A.5.3 报废资产规模结构（成因） (成新率5%以上)规模";
			System.out.println(sheetName + " Start!");
			// dataVersion = "M_2019_2";
			//
			dataVersion = "M_2019_3";// 20200618--河北
			// dataVersion = "M_2019_2";// 20200612--湖北
			// 循环输出表格中的内容,首先循环取出行,再根据行循环取出列
			startRowNumber = 5;
			startColumnNumber = 2;
			reportSQL = "WITH STRUCTRUE_TEMP_TAB AS (SELECT A.ASSET_CLASS_NAME,A.ASSET_CLASS_CODE, "
					+ "B.VOLTAGE_NAME,B.INDEXOF FROM DV_ASSET_CLASS A LEFT JOIN  "
					+ "(SELECT  C.VOLTAGE_NAME,B.DV_ASSET_CLASS_ID,B.INDEXOF  "
					+ "FROM DV_VOLTAGE_RELATION B  INNER JOIN DV_VOLTAGE_LEVEL C  "
					+ "ON B.DV_VOLTAGE_LEVEL_ID=C.DV_VOLTAGE_LEVEL_ID  " + "WHERE B.VOLTAGE_RELATION_CODE=?)B  " + // 1
					"ON A.DV_ASSET_CLASS_ID=B.DV_ASSET_CLASS_ID  " + "ORDER BY A.ASSET_CLASS_CODE ,B.INDEXOF  "
					+ "),SPAN_STRUCTURE_TAB AS (SELECT A.ASSET_CLASS_NAME, "
					+ "DECODE(A.VOLTAGE_NAME,NULL,A.ASSET_CLASS_CODE,DECODE(LENGTH(TO_CHAR(A.INDEXOF)),"
					+ "1,A.ASSET_CLASS_CODE||'10'||A.INDEXOF, "
					+ "2,A.ASSET_CLASS_CODE||'1'||A.INDEXOF)) STRUCTURE_CODE,A.ASSET_CLASS_CODE,VOLTAGE_NAME, "
					+ "INDEXOF FROM STRUCTRUE_TEMP_TAB A  ORDER BY STRUCTURE_CODE, "
					+ "INDEXOF ),STRUCT_TEMP_RESULT AS (SELECT A.ASSET_CLASS_NAME,  "
					+ "A.ASSET_CLASS_CODE,B.VOLTAGE_NAME,B.INDEXOF FROM DV_ASSET_CLASS A  "
					+ "LEFT JOIN SPAN_STRUCTURE_TAB B ON A.ASSET_CLASS_CODE=B.STRUCTURE_CODE "
					+ "UNION ALL SELECT B.ASSET_CLASS_NAME,B.STRUCTURE_CODE ASSET_CLASS_CODE, "
					+ "B.VOLTAGE_NAME,B.INDEXOF FROM SPAN_STRUCTURE_TAB B ORDER BY "
					+ "ASSET_CLASS_CODE,INDEXOF ),RESULT_TEMP_TAB AS (SELECT A.ASSET_CLASS_NAME CATEGORY, "
					+ "A.ASSET_CLASS_CODE,A.VOLTAGE_NAME VOLTAGE_LEVEL, "
					+ "DECODE(B.DISCARD_REASON01_ORIGIN_VAL_5,NULL,0,B.DISCARD_REASON01_ORIGIN_VAL_5) DISCARD_REASON01_ORIGIN_VAL_5, "
					+ "DECODE(B.DISCARD_REASON02_ORIGIN_VAL_5,NULL,0,B.DISCARD_REASON02_ORIGIN_VAL_5) DISCARD_REASON02_ORIGIN_VAL_5, "
					+ "DECODE(B.DISCARD_REASON03_ORIGIN_VAL_5,NULL,0,B.DISCARD_REASON03_ORIGIN_VAL_5) DISCARD_REASON03_ORIGIN_VAL_5, "
					+ "DECODE(B.DISCARD_REASON04_ORIGIN_VAL_5,NULL,0,B.DISCARD_REASON04_ORIGIN_VAL_5) DISCARD_REASON04_ORIGIN_VAL_5, "
					+ "DECODE(B.DISCARD_REASON05_ORIGIN_VAL_5,NULL,0,B.DISCARD_REASON05_ORIGIN_VAL_5) DISCARD_REASON05_ORIGIN_VAL_5, "
					+ "DECODE(B.DISCARD_REASON06_ORIGIN_VAL_5,NULL,0,B.DISCARD_REASON06_ORIGIN_VAL_5) DISCARD_REASON06_ORIGIN_VAL_5, "
					+ "DECODE(B.DISCARD_REASON07_ORIGIN_VAL_5,NULL,0,B.DISCARD_REASON07_ORIGIN_VAL_5) DISCARD_REASON07_ORIGIN_VAL_5, "
					+ "DECODE(B.DISCARD_REASON08_ORIGIN_VAL_5,NULL,0,B.DISCARD_REASON08_ORIGIN_VAL_5) DISCARD_REASON08_ORIGIN_VAL_5, "
					+ "DECODE(B.DISCARD_REASON01_NET_VAL_5,NULL,0,B.DISCARD_REASON01_NET_VAL_5) DISCARD_REASON01_NET_VAL_5, "
					+ "DECODE(B.DISCARD_REASON02_NET_VAL_5,NULL,0,B.DISCARD_REASON02_NET_VAL_5) DISCARD_REASON02_NET_VAL_5, "
					+ "DECODE(B.DISCARD_REASON03_NET_VAL_5,NULL,0,B.DISCARD_REASON03_NET_VAL_5) DISCARD_REASON03_NET_VAL_5, "
					+ "DECODE(B.DISCARD_REASON04_NET_VAL_5,NULL,0,B.DISCARD_REASON04_NET_VAL_5) DISCARD_REASON04_NET_VAL_5, "
					+ "DECODE(B.DISCARD_REASON05_NET_VAL_5,NULL,0,B.DISCARD_REASON05_NET_VAL_5) DISCARD_REASON05_NET_VAL_5, "
					+ "DECODE(B.DISCARD_REASON06_NET_VAL_5,NULL,0,B.DISCARD_REASON06_NET_VAL_5) DISCARD_REASON06_NET_VAL_5, "
					+ "DECODE(B.DISCARD_REASON07_NET_VAL_5,NULL,0,B.DISCARD_REASON07_NET_VAL_5) DISCARD_REASON07_NET_VAL_5, "
					+ "DECODE(B.DISCARD_REASON08_NET_VAL_5,NULL,0,B.DISCARD_REASON08_NET_VAL_5) DISCARD_REASON08_NET_VAL_5, "
					+ "DECODE(B.DISCARD_REASON01_CAPACITY_5,NULL,0,B.DISCARD_REASON01_CAPACITY_5) DISCARD_REASON01_CAPACITY_5, "
					+ "DECODE(B.DISCARD_REASON02_CAPACITY_5,NULL,0,B.DISCARD_REASON02_CAPACITY_5) DISCARD_REASON02_CAPACITY_5, "
					+ "DECODE(B.DISCARD_REASON03_CAPACITY_5,NULL,0,B.DISCARD_REASON03_CAPACITY_5) DISCARD_REASON03_CAPACITY_5, "
					+ "DECODE(B.DISCARD_REASON04_CAPACITY_5,NULL,0,B.DISCARD_REASON04_CAPACITY_5) DISCARD_REASON04_CAPACITY_5, "
					+ "DECODE(B.DISCARD_REASON05_CAPACITY_5,NULL,0,B.DISCARD_REASON05_CAPACITY_5) DISCARD_REASON05_CAPACITY_5, "
					+ "DECODE(B.DISCARD_REASON06_CAPACITY_5,NULL,0,B.DISCARD_REASON06_CAPACITY_5) DISCARD_REASON06_CAPACITY_5, "
					+ "DECODE(B.DISCARD_REASON07_CAPACITY_5,NULL,0,B.DISCARD_REASON07_CAPACITY_5) DISCARD_REASON07_CAPACITY_5, "
					+ "DECODE(B.DISCARD_REASON08_CAPACITY_5,NULL,0,B.DISCARD_REASON08_CAPACITY_5) DISCARD_REASON08_CAPACITY_5  "
					+ "FROM (SELECT  DISTINCT  * FROM STRUCT_TEMP_RESULT )A LEFT JOIN (SELECT  "
					+ "EXTRACT(YEAR FROM A.DV_DATE_VALUE) CAL_YEAR,A. CATEGORY ,A.VOLTAGE_LEVEL, "
					+ "SUM(A.DISCARD_REASON01_ORIGIN_VAL_5) DISCARD_REASON01_ORIGIN_VAL_5, "
					+ "SUM(A.DISCARD_REASON02_ORIGIN_VAL_5) DISCARD_REASON02_ORIGIN_VAL_5, "
					+ "SUM(A.DISCARD_REASON03_ORIGIN_VAL_5) DISCARD_REASON03_ORIGIN_VAL_5, "
					+ "SUM(A.DISCARD_REASON04_ORIGIN_VAL_5) DISCARD_REASON04_ORIGIN_VAL_5, "
					+ "SUM(A.DISCARD_REASON05_ORIGIN_VAL_5) DISCARD_REASON05_ORIGIN_VAL_5, "
					+ "SUM(A.DISCARD_REASON06_ORIGIN_VAL_5) DISCARD_REASON06_ORIGIN_VAL_5, "
					+ "SUM(A.DISCARD_REASON07_ORIGIN_VAL_5) DISCARD_REASON07_ORIGIN_VAL_5, "
					+ "SUM(A.DISCARD_REASON08_ORIGIN_VAL_5) DISCARD_REASON08_ORIGIN_VAL_5, "
					+ "SUM(A.DISCARD_REASON01_NET_VAL_5) DISCARD_REASON01_NET_VAL_5, "
					+ "SUM(A.DISCARD_REASON02_NET_VAL_5) DISCARD_REASON02_NET_VAL_5, "
					+ "SUM(A.DISCARD_REASON03_NET_VAL_5) DISCARD_REASON03_NET_VAL_5, "
					+ "SUM(A.DISCARD_REASON04_NET_VAL_5) DISCARD_REASON04_NET_VAL_5, "
					+ "SUM(A.DISCARD_REASON05_NET_VAL_5) DISCARD_REASON05_NET_VAL_5, "
					+ "SUM(A.DISCARD_REASON06_NET_VAL_5) DISCARD_REASON06_NET_VAL_5, "
					+ "SUM(A.DISCARD_REASON07_NET_VAL_5) DISCARD_REASON07_NET_VAL_5, "
					+ "SUM(A.DISCARD_REASON08_NET_VAL_5) DISCARD_REASON08_NET_VAL_5, "
					+ "SUM(A.DISCARD_REASON01_CAPACITY_5) DISCARD_REASON01_CAPACITY_5, "
					+ "SUM(A.DISCARD_REASON02_CAPACITY_5) DISCARD_REASON02_CAPACITY_5, "
					+ "SUM(A.DISCARD_REASON03_CAPACITY_5) DISCARD_REASON03_CAPACITY_5, "
					+ "SUM(A.DISCARD_REASON04_CAPACITY_5) DISCARD_REASON04_CAPACITY_5, "
					+ "SUM(A.DISCARD_REASON05_CAPACITY_5) DISCARD_REASON05_CAPACITY_5, "
					+ "SUM(A.DISCARD_REASON06_CAPACITY_5) DISCARD_REASON06_CAPACITY_5, "
					+ "SUM(A.DISCARD_REASON07_CAPACITY_5) DISCARD_REASON07_CAPACITY_5, "
					+ "SUM(A.DISCARD_REASON08_CAPACITY_5) DISCARD_REASON08_CAPACITY_5 "
					+ "FROM (SELECT E.ORG_ALIAS_NAME,F.AREA_NAME FROM DV_ORG_ALIAS E INNER JOIN DV_ORG F  "
					+ "ON E.DV_ORG_ID=F.DV_ORG_ID AND F.AREA_NAME IN ( SELECT A.AREA_NAME FROM DV_AREA A WHERE   "
					+ "EXISTS (SELECT 1 FROM DV_AREA B WHERE (DECODE( B.IS_LEAF,0, 1,0  )=1 AND  "
					+ "B.AREA_NAME=?  AND (SUBSTR(A.AREA_CODE,0,LENGTH(A.AREA_CODE)-3)=B.AREA_CODE " + // 2
					"OR (A.IS_LEAF=0 AND B.AREA_CODE=A.AREA_CODE )))OR (DECODE( B.IS_LEAF,0, 1,0  )=0 AND  "
					+ "B.AREA_NAME=? AND A.AREA_CODE=B.AREA_CODE)) )) F INNER JOIN  " + // 3
					"MID_ASSET_DISCARD_EQU_5 A ON A.ORG_NAME=F.ORG_ALIAS_NAME  WHERE VERSION= ? " + // 4
					"GROUP BY EXTRACT(YEAR FROM A.DV_DATE_VALUE),A. CATEGORY ,A.VOLTAGE_LEVEL "
					+ ") B ON(A.ASSET_CLASS_NAME=B. CATEGORY  AND  "
					+ "DECODE(A.VOLTAGE_NAME,NULL,'BLANK',A.VOLTAGE_NAME)=DECODE(B.VOLTAGE_LEVEL,NULL,'BLANK',B.VOLTAGE_LEVEL) "
					+ ")ORDER BY ASSET_CLASS_CODE,INDEXOF  " + "),LEVEL_TEMP_TAB AS (SELECT  A.CATEGORY, "
					+ "A.ASSET_CLASS_CODE,DECODE(LENGTH(A.ASSET_CLASS_CODE), "
					+ "3,NULL,SUBSTR(A.ASSET_CLASS_CODE,0,LENGTH(A.ASSET_CLASS_CODE)-3)) "
					+ "PARENT_CLASS_CODE,A.VOLTAGE_LEVEL,A.DISCARD_REASON01_ORIGIN_VAL_5, "
					+ "A.DISCARD_REASON02_ORIGIN_VAL_5,A.DISCARD_REASON03_ORIGIN_VAL_5, "
					+ "A.DISCARD_REASON04_ORIGIN_VAL_5,A.DISCARD_REASON05_ORIGIN_VAL_5, "
					+ "A.DISCARD_REASON06_ORIGIN_VAL_5,A.DISCARD_REASON07_ORIGIN_VAL_5, "
					+ "A.DISCARD_REASON08_ORIGIN_VAL_5,A.DISCARD_REASON01_NET_VAL_5, "
					+ "A.DISCARD_REASON02_NET_VAL_5,A.DISCARD_REASON03_NET_VAL_5, "
					+ "A.DISCARD_REASON04_NET_VAL_5,A.DISCARD_REASON05_NET_VAL_5, "
					+ "A.DISCARD_REASON06_NET_VAL_5,A.DISCARD_REASON07_NET_VAL_5, "
					+ "A.DISCARD_REASON08_NET_VAL_5,A.DISCARD_REASON01_CAPACITY_5, "
					+ "A.DISCARD_REASON02_CAPACITY_5,A.DISCARD_REASON03_CAPACITY_5, "
					+ "A.DISCARD_REASON04_CAPACITY_5,A.DISCARD_REASON05_CAPACITY_5, "
					+ "A.DISCARD_REASON06_CAPACITY_5,A.DISCARD_REASON07_CAPACITY_5, "
					+ "A.DISCARD_REASON08_CAPACITY_5   FROM RESULT_TEMP_TAB A), ORIGIN_TEMP AS (SELECT  "
					+ "B.CATEGORY,B.ASSET_CLASS_CODE,'001' INDICATE_DIMENSION,B.VOLTAGE_LEVEL,  "
					+ "SUM(A.DISCARD_REASON01_ORIGIN_VAL_5) DISCARD_REASON01_ORIGIN_VAL_5, "
					+ "SUM(A.DISCARD_REASON02_ORIGIN_VAL_5) DISCARD_REASON02_ORIGIN_VAL_5, "
					+ "SUM(A.DISCARD_REASON03_ORIGIN_VAL_5) DISCARD_REASON03_ORIGIN_VAL_5, "
					+ "SUM(A.DISCARD_REASON04_ORIGIN_VAL_5) DISCARD_REASON04_ORIGIN_VAL_5, "
					+ "SUM(A.DISCARD_REASON05_ORIGIN_VAL_5) DISCARD_REASON05_ORIGIN_VAL_5, "
					+ "SUM(A.DISCARD_REASON06_ORIGIN_VAL_5) DISCARD_REASON06_ORIGIN_VAL_5, "
					+ "SUM(A.DISCARD_REASON07_ORIGIN_VAL_5) DISCARD_REASON07_ORIGIN_VAL_5, "
					+ "SUM(A.DISCARD_REASON08_ORIGIN_VAL_5) DISCARD_REASON08_ORIGIN_VAL_5  "
					+ "FROM LEVEL_TEMP_TAB A , LEVEL_TEMP_TAB B  "
					+ "WHERE A.ASSET_CLASS_CODE IN (SELECT E.ASSET_CLASS_CODE FROM LEVEL_TEMP_TAB E  "
					+ "START WITH E.ASSET_CLASS_CODE=B.ASSET_CLASS_CODE "
					+ "CONNECT BY E.PARENT_CLASS_CODE=PRIOR E.ASSET_CLASS_CODE)GROUP BY B.CATEGORY, "
					+ "B.ASSET_CLASS_CODE,B.VOLTAGE_LEVEL ORDER BY 2), NET_TEMP AS (SELECT  "
					+ "B.CATEGORY,B.ASSET_CLASS_CODE,'002' INDICATE_DIMENSION,B.VOLTAGE_LEVEL,   "
					+ "SUM(A.DISCARD_REASON01_NET_VAL_5) DISCARD_REASON01_NET_VAL_5, "
					+ "SUM(A.DISCARD_REASON02_NET_VAL_5) DISCARD_REASON02_NET_VAL_5, "
					+ "SUM(A.DISCARD_REASON03_NET_VAL_5) DISCARD_REASON03_NET_VAL_5, "
					+ "SUM(A.DISCARD_REASON04_NET_VAL_5) DISCARD_REASON04_NET_VAL_5, "
					+ "SUM(A.DISCARD_REASON05_NET_VAL_5) DISCARD_REASON05_NET_VAL_5, "
					+ "SUM(A.DISCARD_REASON06_NET_VAL_5) DISCARD_REASON06_NET_VAL_5, "
					+ "SUM(A.DISCARD_REASON07_NET_VAL_5) DISCARD_REASON07_NET_VAL_5, "
					+ "SUM(A.DISCARD_REASON08_NET_VAL_5) DISCARD_REASON08_NET_VAL_5  "
					+ "FROM LEVEL_TEMP_TAB A , LEVEL_TEMP_TAB B WHERE A.ASSET_CLASS_CODE IN  "
					+ "(SELECT E.ASSET_CLASS_CODE FROM LEVEL_TEMP_TAB E  "
					+ "START WITH E.ASSET_CLASS_CODE=B.ASSET_CLASS_CODE "
					+ "CONNECT BY E.PARENT_CLASS_CODE=PRIOR E.ASSET_CLASS_CODE " + ")GROUP BY B.CATEGORY, "
					+ "B.ASSET_CLASS_CODE,B.VOLTAGE_LEVEL ORDER BY 2), AMOUNT_TEMP AS (SELECT  "
					+ "B.CATEGORY,B.ASSET_CLASS_CODE,'003' INDICATE_DIMENSION,B.VOLTAGE_LEVEL,   "
					+ "SUM(A.DISCARD_REASON01_CAPACITY_5) DISCARD_REASON01_CAPACITY_5, "
					+ "SUM(A.DISCARD_REASON02_CAPACITY_5) DISCARD_REASON02_CAPACITY_5, "
					+ "SUM(A.DISCARD_REASON03_CAPACITY_5) DISCARD_REASON03_CAPACITY_5, "
					+ "SUM(A.DISCARD_REASON04_CAPACITY_5) DISCARD_REASON04_CAPACITY_5, "
					+ "SUM(A.DISCARD_REASON05_CAPACITY_5) DISCARD_REASON05_CAPACITY_5, "
					+ "SUM(A.DISCARD_REASON06_CAPACITY_5) DISCARD_REASON06_CAPACITY_5, "
					+ "SUM(A.DISCARD_REASON07_CAPACITY_5) DISCARD_REASON07_CAPACITY_5, "
					+ "SUM(A.DISCARD_REASON08_CAPACITY_5) DISCARD_REASON08_CAPACITY_5 "
					+ "FROM LEVEL_TEMP_TAB A , LEVEL_TEMP_TAB B  "
					+ "WHERE A.ASSET_CLASS_CODE IN (SELECT E.ASSET_CLASS_CODE  " + "FROM LEVEL_TEMP_TAB E  "
					+ "START WITH E.ASSET_CLASS_CODE=B.ASSET_CLASS_CODE "
					+ "CONNECT BY E.PARENT_CLASS_CODE=PRIOR E.ASSET_CLASS_CODE) "
					+ "GROUP BY B.CATEGORY,B.ASSET_CLASS_CODE,B.VOLTAGE_LEVEL ORDER BY 2)  "
					+ "SELECT CATEGORY,ASSET_CLASS_CODE,INDICATE_DIMENSION,VOLTAGE_LEVEL, "
					+ "A.DISCARD_REASON01_ORIGIN_VAL_5  DISCARD_REASON01, "
					+ "A.DISCARD_REASON02_ORIGIN_VAL_5  DISCARD_REASON02, "
					+ "A.DISCARD_REASON03_ORIGIN_VAL_5  DISCARD_REASON03, "
					+ "A.DISCARD_REASON04_ORIGIN_VAL_5  DISCARD_REASON04, "
					+ "A.DISCARD_REASON05_ORIGIN_VAL_5  DISCARD_REASON05, "
					+ "A.DISCARD_REASON06_ORIGIN_VAL_5  DISCARD_REASON06, "
					+ "A.DISCARD_REASON07_ORIGIN_VAL_5  DISCARD_REASON07, "
					+ "A.DISCARD_REASON08_ORIGIN_VAL_5  DISCARD_REASON08 " + " FROM ORIGIN_TEMP A UNION ALL SELECT  "
					+ "CATEGORY,ASSET_CLASS_CODE,INDICATE_DIMENSION,VOLTAGE_LEVEL, "
					+ "A.DISCARD_REASON01_NET_VAL_5  DISCARD_REASON01, "
					+ "A.DISCARD_REASON02_NET_VAL_5  DISCARD_REASON02, "
					+ "A.DISCARD_REASON03_NET_VAL_5  DISCARD_REASON03, "
					+ "A.DISCARD_REASON04_NET_VAL_5  DISCARD_REASON04, "
					+ "A.DISCARD_REASON05_NET_VAL_5  DISCARD_REASON05, "
					+ "A.DISCARD_REASON06_NET_VAL_5  DISCARD_REASON06, "
					+ "A.DISCARD_REASON07_NET_VAL_5  DISCARD_REASON07, "
					+ "A.DISCARD_REASON08_NET_VAL_5  DISCARD_REASON08 " + " FROM NET_TEMP A UNION ALL  SELECT  "
					+ "CATEGORY,ASSET_CLASS_CODE,INDICATE_DIMENSION,VOLTAGE_LEVEL, "
					+ "A.DISCARD_REASON01_CAPACITY_5 DISCARD_REASON01, "
					+ "A.DISCARD_REASON02_CAPACITY_5 DISCARD_REASON02, "
					+ "A.DISCARD_REASON03_CAPACITY_5 DISCARD_REASON03, "
					+ "A.DISCARD_REASON04_CAPACITY_5 DISCARD_REASON04, "
					+ "A.DISCARD_REASON05_CAPACITY_5 DISCARD_REASON05, "
					+ "A.DISCARD_REASON06_CAPACITY_5 DISCARD_REASON06, "
					+ "A.DISCARD_REASON07_CAPACITY_5 DISCARD_REASON07, "
					+ "A.DISCARD_REASON08_CAPACITY_5 DISCARD_REASON08 " + " FROM AMOUNT_TEMP A ORDER BY 2,3 ";

			try {
				new ReportOutput2().writeXLSXDiscard(reportSQL, templateFilePathAndName, targetFilePathAndName,
						reportName, voltageRelationCode, dataVersion, areaName, sheetName, startRowNumber,
						startColumnNumber);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			sheetName = "A.5.4 报废资产规模结构（成因） (成新率20%以上资产)";
			reportName = "A.5.4 报废资产规模结构（成因） (成新率20%以上资产)";
			System.out.println(sheetName + " Start!");
			// dataVersion = "M_2019_2";
			//
			dataVersion = "M_2019_3";// 20200612--河北
			// dataVersion = "M_2019_2";// 20200612--湖北
			// 循环输出表格中的内容,首先循环取出行,再根据行循环取出列
			startRowNumber = 5;
			startColumnNumber = 2;
			reportSQL = "WITH STRUCTRUE_TEMP_TAB AS (SELECT A.ASSET_CLASS_NAME,A.ASSET_CLASS_CODE, "
					+ "B.VOLTAGE_NAME,B.INDEXOF FROM DV_ASSET_CLASS A LEFT JOIN  "
					+ "(SELECT  C.VOLTAGE_NAME,B.DV_ASSET_CLASS_ID,B.INDEXOF  "
					+ "FROM DV_VOLTAGE_RELATION B  INNER JOIN DV_VOLTAGE_LEVEL C  "
					+ "ON B.DV_VOLTAGE_LEVEL_ID=C.DV_VOLTAGE_LEVEL_ID  " + "WHERE B.VOLTAGE_RELATION_CODE=?)B  " + // 1
					"ON A.DV_ASSET_CLASS_ID=B.DV_ASSET_CLASS_ID  " + "ORDER BY A.ASSET_CLASS_CODE ,B.INDEXOF  "
					+ "),SPAN_STRUCTURE_TAB AS (SELECT A.ASSET_CLASS_NAME, "
					+ "DECODE(A.VOLTAGE_NAME,NULL,A.ASSET_CLASS_CODE,DECODE(LENGTH(TO_CHAR(A.INDEXOF)),"
					+ "1,A.ASSET_CLASS_CODE||'10'||A.INDEXOF, "
					+ "2,A.ASSET_CLASS_CODE||'1'||A.INDEXOF)) STRUCTURE_CODE,A.ASSET_CLASS_CODE,VOLTAGE_NAME, "
					+ "INDEXOF FROM STRUCTRUE_TEMP_TAB A  ORDER BY STRUCTURE_CODE, "
					+ "INDEXOF ),STRUCT_TEMP_RESULT AS (SELECT A.ASSET_CLASS_NAME,  "
					+ "A.ASSET_CLASS_CODE,B.VOLTAGE_NAME,B.INDEXOF FROM DV_ASSET_CLASS A  "
					+ "LEFT JOIN SPAN_STRUCTURE_TAB B ON A.ASSET_CLASS_CODE=B.STRUCTURE_CODE "
					+ "UNION ALL SELECT B.ASSET_CLASS_NAME,B.STRUCTURE_CODE ASSET_CLASS_CODE, "
					+ "B.VOLTAGE_NAME,B.INDEXOF FROM SPAN_STRUCTURE_TAB B ORDER BY "
					+ "ASSET_CLASS_CODE,INDEXOF ),RESULT_TEMP_TAB AS (SELECT A.ASSET_CLASS_NAME CATEGORY, "
					+ "A.ASSET_CLASS_CODE,A.VOLTAGE_NAME VOLTAGE_LEVEL, "
					+ "DECODE(B.DISCARD_REASON01_ORIGIN_VAL_20,NULL,0,B.DISCARD_REASON01_ORIGIN_VAL_20) DISCARD_REASON01_ORIGIN_VAL_20, "
					+ "DECODE(B.DISCARD_REASON02_ORIGIN_VAL_20,NULL,0,B.DISCARD_REASON02_ORIGIN_VAL_20) DISCARD_REASON02_ORIGIN_VAL_20, "
					+ "DECODE(B.DISCARD_REASON03_ORIGIN_VAL_20,NULL,0,B.DISCARD_REASON03_ORIGIN_VAL_20) DISCARD_REASON03_ORIGIN_VAL_20, "
					+ "DECODE(B.DISCARD_REASON04_ORIGIN_VAL_20,NULL,0,B.DISCARD_REASON04_ORIGIN_VAL_20) DISCARD_REASON04_ORIGIN_VAL_20, "
					+ "DECODE(B.DISCARD_REASON05_ORIGIN_VAL_20,NULL,0,B.DISCARD_REASON05_ORIGIN_VAL_20) DISCARD_REASON05_ORIGIN_VAL_20, "
					+ "DECODE(B.DISCARD_REASON06_ORIGIN_VAL_20,NULL,0,B.DISCARD_REASON06_ORIGIN_VAL_20) DISCARD_REASON06_ORIGIN_VAL_20, "
					+ "DECODE(B.DISCARD_REASON07_ORIGIN_VAL_20,NULL,0,B.DISCARD_REASON07_ORIGIN_VAL_20) DISCARD_REASON07_ORIGIN_VAL_20, "
					+ "DECODE(B.DISCARD_REASON08_ORIGIN_VAL_20,NULL,0,B.DISCARD_REASON08_ORIGIN_VAL_20) DISCARD_REASON08_ORIGIN_VAL_20, "
					+ "DECODE(B.DISCARD_REASON01_NET_VAL_20,NULL,0,B.DISCARD_REASON01_NET_VAL_20) DISCARD_REASON01_NET_VAL_20, "
					+ "DECODE(B.DISCARD_REASON02_NET_VAL_20,NULL,0,B.DISCARD_REASON02_NET_VAL_20) DISCARD_REASON02_NET_VAL_20, "
					+ "DECODE(B.DISCARD_REASON03_NET_VAL_20,NULL,0,B.DISCARD_REASON03_NET_VAL_20) DISCARD_REASON03_NET_VAL_20, "
					+ "DECODE(B.DISCARD_REASON04_NET_VAL_20,NULL,0,B.DISCARD_REASON04_NET_VAL_20) DISCARD_REASON04_NET_VAL_20, "
					+ "DECODE(B.DISCARD_REASON05_NET_VAL_20,NULL,0,B.DISCARD_REASON05_NET_VAL_20) DISCARD_REASON05_NET_VAL_20, "
					+ "DECODE(B.DISCARD_REASON06_NET_VAL_20,NULL,0,B.DISCARD_REASON06_NET_VAL_20) DISCARD_REASON06_NET_VAL_20, "
					+ "DECODE(B.DISCARD_REASON07_NET_VAL_20,NULL,0,B.DISCARD_REASON07_NET_VAL_20) DISCARD_REASON07_NET_VAL_20, "
					+ "DECODE(B.DISCARD_REASON08_NET_VAL_20,NULL,0,B.DISCARD_REASON08_NET_VAL_20) DISCARD_REASON08_NET_VAL_20, "
					+ "DECODE(B.DISCARD_REASON01_AMOUNT_20,NULL,0,B.DISCARD_REASON01_AMOUNT_20) DISCARD_REASON01_AMOUNT_20, "
					+ "DECODE(B.DISCARD_REASON02_AMOUNT_20,NULL,0,B.DISCARD_REASON02_AMOUNT_20) DISCARD_REASON02_AMOUNT_20, "
					+ "DECODE(B.DISCARD_REASON03_AMOUNT_20,NULL,0,B.DISCARD_REASON03_AMOUNT_20) DISCARD_REASON03_AMOUNT_20, "
					+ "DECODE(B.DISCARD_REASON04_AMOUNT_20,NULL,0,B.DISCARD_REASON04_AMOUNT_20) DISCARD_REASON04_AMOUNT_20, "
					+ "DECODE(B.DISCARD_REASON05_AMOUNT_20,NULL,0,B.DISCARD_REASON05_AMOUNT_20) DISCARD_REASON05_AMOUNT_20, "
					+ "DECODE(B.DISCARD_REASON06_AMOUNT_20,NULL,0,B.DISCARD_REASON06_AMOUNT_20) DISCARD_REASON06_AMOUNT_20, "
					+ "DECODE(B.DISCARD_REASON07_AMOUNT_20,NULL,0,B.DISCARD_REASON07_AMOUNT_20) DISCARD_REASON07_AMOUNT_20, "
					+ "DECODE(B.DISCARD_REASON08_AMOUNT_20,NULL,0,B.DISCARD_REASON08_AMOUNT_20) DISCARD_REASON08_AMOUNT_20  "
					+ "FROM (SELECT  DISTINCT  * FROM STRUCT_TEMP_RESULT )A LEFT JOIN (SELECT  "
					+ "EXTRACT(YEAR FROM A.DV_DATE_VALUE) CAL_YEAR,A. CATEGORY ,A.VOLTAGE_LEVEL, "
					+ "SUM(A.DISCARD_REASON01_ORIGIN_VAL_20) DISCARD_REASON01_ORIGIN_VAL_20, "
					+ "SUM(A.DISCARD_REASON02_ORIGIN_VAL_20) DISCARD_REASON02_ORIGIN_VAL_20, "
					+ "SUM(A.DISCARD_REASON03_ORIGIN_VAL_20) DISCARD_REASON03_ORIGIN_VAL_20, "
					+ "SUM(A.DISCARD_REASON04_ORIGIN_VAL_20) DISCARD_REASON04_ORIGIN_VAL_20, "
					+ "SUM(A.DISCARD_REASON05_ORIGIN_VAL_20) DISCARD_REASON05_ORIGIN_VAL_20, "
					+ "SUM(A.DISCARD_REASON06_ORIGIN_VAL_20) DISCARD_REASON06_ORIGIN_VAL_20, "
					+ "SUM(A.DISCARD_REASON07_ORIGIN_VAL_20) DISCARD_REASON07_ORIGIN_VAL_20, "
					+ "SUM(A.DISCARD_REASON08_ORIGIN_VAL_20) DISCARD_REASON08_ORIGIN_VAL_20, "
					+ "SUM(A.DISCARD_REASON01_NET_VAL_20) DISCARD_REASON01_NET_VAL_20, "
					+ "SUM(A.DISCARD_REASON02_NET_VAL_20) DISCARD_REASON02_NET_VAL_20, "
					+ "SUM(A.DISCARD_REASON03_NET_VAL_20) DISCARD_REASON03_NET_VAL_20, "
					+ "SUM(A.DISCARD_REASON04_NET_VAL_20) DISCARD_REASON04_NET_VAL_20, "
					+ "SUM(A.DISCARD_REASON05_NET_VAL_20) DISCARD_REASON05_NET_VAL_20, "
					+ "SUM(A.DISCARD_REASON06_NET_VAL_20) DISCARD_REASON06_NET_VAL_20, "
					+ "SUM(A.DISCARD_REASON07_NET_VAL_20) DISCARD_REASON07_NET_VAL_20, "
					+ "SUM(A.DISCARD_REASON08_NET_VAL_20) DISCARD_REASON08_NET_VAL_20, "
					+ "SUM(A.DISCARD_REASON01_AMOUNT_20) DISCARD_REASON01_AMOUNT_20, "
					+ "SUM(A.DISCARD_REASON02_AMOUNT_20) DISCARD_REASON02_AMOUNT_20, "
					+ "SUM(A.DISCARD_REASON03_AMOUNT_20) DISCARD_REASON03_AMOUNT_20, "
					+ "SUM(A.DISCARD_REASON04_AMOUNT_20) DISCARD_REASON04_AMOUNT_20, "
					+ "SUM(A.DISCARD_REASON05_AMOUNT_20) DISCARD_REASON05_AMOUNT_20, "
					+ "SUM(A.DISCARD_REASON06_AMOUNT_20) DISCARD_REASON06_AMOUNT_20, "
					+ "SUM(A.DISCARD_REASON07_AMOUNT_20) DISCARD_REASON07_AMOUNT_20, "
					+ "SUM(A.DISCARD_REASON08_AMOUNT_20) DISCARD_REASON08_AMOUNT_20 "
					+ "FROM (SELECT E.ORG_ALIAS_NAME,F.AREA_NAME FROM DV_ORG_ALIAS E INNER JOIN DV_ORG F  "
					+ "ON E.DV_ORG_ID=F.DV_ORG_ID AND F.AREA_NAME IN ( SELECT A.AREA_NAME FROM DV_AREA A WHERE   "
					+ "EXISTS (SELECT 1 FROM DV_AREA B WHERE (DECODE( B.IS_LEAF,0, 1,0  )=1 AND  "
					+ "B.AREA_NAME=?  AND (SUBSTR(A.AREA_CODE,0,LENGTH(A.AREA_CODE)-3)=B.AREA_CODE " + // 2
					"OR (A.IS_LEAF=0 AND B.AREA_CODE=A.AREA_CODE )))OR (DECODE( B.IS_LEAF,0, 1,0  )=0 AND  "
					+ "B.AREA_NAME=? AND A.AREA_CODE=B.AREA_CODE)) )) F INNER JOIN  " + // 3
					"MID_ASSET_DISCARD_EQU_20 A ON A.ORG_NAME=F.ORG_ALIAS_NAME  WHERE VERSION= ? " + // 4
					"GROUP BY EXTRACT(YEAR FROM A.DV_DATE_VALUE),A. CATEGORY ,A.VOLTAGE_LEVEL "
					+ ") B ON(A.ASSET_CLASS_NAME=B. CATEGORY  AND  "
					+ "DECODE(A.VOLTAGE_NAME,NULL,'BLANK',A.VOLTAGE_NAME)=DECODE(B.VOLTAGE_LEVEL,NULL,'BLANK',B.VOLTAGE_LEVEL) "
					+ ")ORDER BY ASSET_CLASS_CODE,INDEXOF  " + "),LEVEL_TEMP_TAB AS (SELECT  A.CATEGORY, "
					+ "A.ASSET_CLASS_CODE,DECODE(LENGTH(A.ASSET_CLASS_CODE), "
					+ "3,NULL,SUBSTR(A.ASSET_CLASS_CODE,0,LENGTH(A.ASSET_CLASS_CODE)-3)) "
					+ "PARENT_CLASS_CODE,A.VOLTAGE_LEVEL,A.DISCARD_REASON01_ORIGIN_VAL_20, "
					+ "A.DISCARD_REASON02_ORIGIN_VAL_20,A.DISCARD_REASON03_ORIGIN_VAL_20, "
					+ "A.DISCARD_REASON04_ORIGIN_VAL_20,A.DISCARD_REASON05_ORIGIN_VAL_20, "
					+ "A.DISCARD_REASON06_ORIGIN_VAL_20,A.DISCARD_REASON07_ORIGIN_VAL_20, "
					+ "A.DISCARD_REASON08_ORIGIN_VAL_20,A.DISCARD_REASON01_NET_VAL_20, "
					+ "A.DISCARD_REASON02_NET_VAL_20,A.DISCARD_REASON03_NET_VAL_20, "
					+ "A.DISCARD_REASON04_NET_VAL_20,A.DISCARD_REASON05_NET_VAL_20, "
					+ "A.DISCARD_REASON06_NET_VAL_20,A.DISCARD_REASON07_NET_VAL_20, "
					+ "A.DISCARD_REASON08_NET_VAL_20,A.DISCARD_REASON01_AMOUNT_20, "
					+ "A.DISCARD_REASON02_AMOUNT_20,A.DISCARD_REASON03_AMOUNT_20, "
					+ "A.DISCARD_REASON04_AMOUNT_20,A.DISCARD_REASON05_AMOUNT_20, "
					+ "A.DISCARD_REASON06_AMOUNT_20,A.DISCARD_REASON07_AMOUNT_20, "
					+ "A.DISCARD_REASON08_AMOUNT_20   FROM RESULT_TEMP_TAB A), ORIGIN_TEMP AS (SELECT  "
					+ "B.CATEGORY,B.ASSET_CLASS_CODE,'001' INDICATE_DIMENSION,B.VOLTAGE_LEVEL,  "
					+ "SUM(A.DISCARD_REASON01_ORIGIN_VAL_20) DISCARD_REASON01_ORIGIN_VAL_20, "
					+ "SUM(A.DISCARD_REASON02_ORIGIN_VAL_20) DISCARD_REASON02_ORIGIN_VAL_20, "
					+ "SUM(A.DISCARD_REASON03_ORIGIN_VAL_20) DISCARD_REASON03_ORIGIN_VAL_20, "
					+ "SUM(A.DISCARD_REASON04_ORIGIN_VAL_20) DISCARD_REASON04_ORIGIN_VAL_20, "
					+ "SUM(A.DISCARD_REASON05_ORIGIN_VAL_20) DISCARD_REASON05_ORIGIN_VAL_20, "
					+ "SUM(A.DISCARD_REASON06_ORIGIN_VAL_20) DISCARD_REASON06_ORIGIN_VAL_20, "
					+ "SUM(A.DISCARD_REASON07_ORIGIN_VAL_20) DISCARD_REASON07_ORIGIN_VAL_20, "
					+ "SUM(A.DISCARD_REASON08_ORIGIN_VAL_20) DISCARD_REASON08_ORIGIN_VAL_20  "
					+ "FROM LEVEL_TEMP_TAB A , LEVEL_TEMP_TAB B  "
					+ "WHERE A.ASSET_CLASS_CODE IN (SELECT E.ASSET_CLASS_CODE FROM LEVEL_TEMP_TAB E  "
					+ "START WITH E.ASSET_CLASS_CODE=B.ASSET_CLASS_CODE "
					+ "CONNECT BY E.PARENT_CLASS_CODE=PRIOR E.ASSET_CLASS_CODE)GROUP BY B.CATEGORY, "
					+ "B.ASSET_CLASS_CODE,B.VOLTAGE_LEVEL ORDER BY 2), NET_TEMP AS (SELECT  "
					+ "B.CATEGORY,B.ASSET_CLASS_CODE,'002' INDICATE_DIMENSION,B.VOLTAGE_LEVEL,   "
					+ "SUM(A.DISCARD_REASON01_NET_VAL_20) DISCARD_REASON01_NET_VAL_20, "
					+ "SUM(A.DISCARD_REASON02_NET_VAL_20) DISCARD_REASON02_NET_VAL_20, "
					+ "SUM(A.DISCARD_REASON03_NET_VAL_20) DISCARD_REASON03_NET_VAL_20, "
					+ "SUM(A.DISCARD_REASON04_NET_VAL_20) DISCARD_REASON04_NET_VAL_20, "
					+ "SUM(A.DISCARD_REASON05_NET_VAL_20) DISCARD_REASON05_NET_VAL_20, "
					+ "SUM(A.DISCARD_REASON06_NET_VAL_20) DISCARD_REASON06_NET_VAL_20, "
					+ "SUM(A.DISCARD_REASON07_NET_VAL_20) DISCARD_REASON07_NET_VAL_20, "
					+ "SUM(A.DISCARD_REASON08_NET_VAL_20) DISCARD_REASON08_NET_VAL_20  "
					+ "FROM LEVEL_TEMP_TAB A , LEVEL_TEMP_TAB B WHERE A.ASSET_CLASS_CODE IN  "
					+ "(SELECT E.ASSET_CLASS_CODE FROM LEVEL_TEMP_TAB E  "
					+ "START WITH E.ASSET_CLASS_CODE=B.ASSET_CLASS_CODE "
					+ "CONNECT BY E.PARENT_CLASS_CODE=PRIOR E.ASSET_CLASS_CODE " + ")GROUP BY B.CATEGORY, "
					+ "B.ASSET_CLASS_CODE,B.VOLTAGE_LEVEL ORDER BY 2), AMOUNT_TEMP AS (SELECT  "
					+ "B.CATEGORY,B.ASSET_CLASS_CODE,'003' INDICATE_DIMENSION,B.VOLTAGE_LEVEL,   "
					+ "SUM(A.DISCARD_REASON01_AMOUNT_20) DISCARD_REASON01_AMOUNT_20, "
					+ "SUM(A.DISCARD_REASON02_AMOUNT_20) DISCARD_REASON02_AMOUNT_20, "
					+ "SUM(A.DISCARD_REASON03_AMOUNT_20) DISCARD_REASON03_AMOUNT_20, "
					+ "SUM(A.DISCARD_REASON04_AMOUNT_20) DISCARD_REASON04_AMOUNT_20, "
					+ "SUM(A.DISCARD_REASON05_AMOUNT_20) DISCARD_REASON05_AMOUNT_20, "
					+ "SUM(A.DISCARD_REASON06_AMOUNT_20) DISCARD_REASON06_AMOUNT_20, "
					+ "SUM(A.DISCARD_REASON07_AMOUNT_20) DISCARD_REASON07_AMOUNT_20, "
					+ "SUM(A.DISCARD_REASON08_AMOUNT_20) DISCARD_REASON08_AMOUNT_20 "
					+ "FROM LEVEL_TEMP_TAB A , LEVEL_TEMP_TAB B  "
					+ "WHERE A.ASSET_CLASS_CODE IN (SELECT E.ASSET_CLASS_CODE  " + "FROM LEVEL_TEMP_TAB E  "
					+ "START WITH E.ASSET_CLASS_CODE=B.ASSET_CLASS_CODE "
					+ "CONNECT BY E.PARENT_CLASS_CODE=PRIOR E.ASSET_CLASS_CODE) "
					+ "GROUP BY B.CATEGORY,B.ASSET_CLASS_CODE,B.VOLTAGE_LEVEL ORDER BY 2)  "
					+ "SELECT CATEGORY,ASSET_CLASS_CODE,INDICATE_DIMENSION,VOLTAGE_LEVEL, "
					+ "A.DISCARD_REASON01_ORIGIN_VAL_20  DISCARD_REASON01, "
					+ "A.DISCARD_REASON02_ORIGIN_VAL_20  DISCARD_REASON02, "
					+ "A.DISCARD_REASON03_ORIGIN_VAL_20  DISCARD_REASON03, "
					+ "A.DISCARD_REASON04_ORIGIN_VAL_20  DISCARD_REASON04, "
					+ "A.DISCARD_REASON05_ORIGIN_VAL_20  DISCARD_REASON05, "
					+ "A.DISCARD_REASON06_ORIGIN_VAL_20  DISCARD_REASON06, "
					+ "A.DISCARD_REASON07_ORIGIN_VAL_20  DISCARD_REASON07, "
					+ "A.DISCARD_REASON08_ORIGIN_VAL_20  DISCARD_REASON08 " + " FROM ORIGIN_TEMP A UNION ALL SELECT  "
					+ "CATEGORY,ASSET_CLASS_CODE,INDICATE_DIMENSION,VOLTAGE_LEVEL, "
					+ "A.DISCARD_REASON01_NET_VAL_20  DISCARD_REASON01, "
					+ "A.DISCARD_REASON02_NET_VAL_20  DISCARD_REASON02, "
					+ "A.DISCARD_REASON03_NET_VAL_20  DISCARD_REASON03, "
					+ "A.DISCARD_REASON04_NET_VAL_20  DISCARD_REASON04, "
					+ "A.DISCARD_REASON05_NET_VAL_20  DISCARD_REASON05, "
					+ "A.DISCARD_REASON06_NET_VAL_20  DISCARD_REASON06, "
					+ "A.DISCARD_REASON07_NET_VAL_20  DISCARD_REASON07, "
					+ "A.DISCARD_REASON08_NET_VAL_20  DISCARD_REASON08 " + " FROM NET_TEMP A UNION ALL  SELECT  "
					+ "CATEGORY,ASSET_CLASS_CODE,INDICATE_DIMENSION,VOLTAGE_LEVEL, "
					+ "A.DISCARD_REASON01_AMOUNT_20 DISCARD_REASON01, "
					+ "A.DISCARD_REASON02_AMOUNT_20 DISCARD_REASON02, "
					+ "A.DISCARD_REASON03_AMOUNT_20 DISCARD_REASON03, "
					+ "A.DISCARD_REASON04_AMOUNT_20 DISCARD_REASON04, "
					+ "A.DISCARD_REASON05_AMOUNT_20 DISCARD_REASON05, "
					+ "A.DISCARD_REASON06_AMOUNT_20 DISCARD_REASON06, "
					+ "A.DISCARD_REASON07_AMOUNT_20 DISCARD_REASON07, "
					+ "A.DISCARD_REASON08_AMOUNT_20 DISCARD_REASON08 " + " FROM AMOUNT_TEMP A ORDER BY 2,3 ";

			try {
				new ReportOutput2().writeXLSXDiscard(reportSQL, templateFilePathAndName, targetFilePathAndName,
						reportName, voltageRelationCode, dataVersion, areaName, sheetName, startRowNumber,
						startColumnNumber);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			sheetName = "A.5.4 报废资产规模结构（成因） (成新率20%以上)规模";
			reportName = "A.5.4 报废资产规模结构（成因） (成新率20%以上)规模";
			System.out.println(sheetName + " Start!");
			// dataVersion = "M_2019_2";
			//
			dataVersion = "M_2019_3";// 20200618--河北
			// dataVersion = "M_2019_2";// 20200612--湖北
			// 循环输出表格中的内容,首先循环取出行,再根据行循环取出列
			startRowNumber = 5;
			startColumnNumber = 2;
			reportSQL = "WITH STRUCTRUE_TEMP_TAB AS (SELECT A.ASSET_CLASS_NAME,A.ASSET_CLASS_CODE, "
					+ "B.VOLTAGE_NAME,B.INDEXOF FROM DV_ASSET_CLASS A LEFT JOIN  "
					+ "(SELECT  C.VOLTAGE_NAME,B.DV_ASSET_CLASS_ID,B.INDEXOF  "
					+ "FROM DV_VOLTAGE_RELATION B  INNER JOIN DV_VOLTAGE_LEVEL C  "
					+ "ON B.DV_VOLTAGE_LEVEL_ID=C.DV_VOLTAGE_LEVEL_ID  " + "WHERE B.VOLTAGE_RELATION_CODE=?)B  " + // 1
					"ON A.DV_ASSET_CLASS_ID=B.DV_ASSET_CLASS_ID  " + "ORDER BY A.ASSET_CLASS_CODE ,B.INDEXOF  "
					+ "),SPAN_STRUCTURE_TAB AS (SELECT A.ASSET_CLASS_NAME, "
					+ "DECODE(A.VOLTAGE_NAME,NULL,A.ASSET_CLASS_CODE,DECODE(LENGTH(TO_CHAR(A.INDEXOF)),"
					+ "1,A.ASSET_CLASS_CODE||'10'||A.INDEXOF, "
					+ "2,A.ASSET_CLASS_CODE||'1'||A.INDEXOF)) STRUCTURE_CODE,A.ASSET_CLASS_CODE,VOLTAGE_NAME, "
					+ "INDEXOF FROM STRUCTRUE_TEMP_TAB A  ORDER BY STRUCTURE_CODE, "
					+ "INDEXOF ),STRUCT_TEMP_RESULT AS (SELECT A.ASSET_CLASS_NAME,  "
					+ "A.ASSET_CLASS_CODE,B.VOLTAGE_NAME,B.INDEXOF FROM DV_ASSET_CLASS A  "
					+ "LEFT JOIN SPAN_STRUCTURE_TAB B ON A.ASSET_CLASS_CODE=B.STRUCTURE_CODE "
					+ "UNION ALL SELECT B.ASSET_CLASS_NAME,B.STRUCTURE_CODE ASSET_CLASS_CODE, "
					+ "B.VOLTAGE_NAME,B.INDEXOF FROM SPAN_STRUCTURE_TAB B ORDER BY "
					+ "ASSET_CLASS_CODE,INDEXOF ),RESULT_TEMP_TAB AS (SELECT A.ASSET_CLASS_NAME CATEGORY, "
					+ "A.ASSET_CLASS_CODE,A.VOLTAGE_NAME VOLTAGE_LEVEL, "
					+ "DECODE(B.DISCARD_REASON01_ORIGIN_VAL_20,NULL,0,B.DISCARD_REASON01_ORIGIN_VAL_20) DISCARD_REASON01_ORIGIN_VAL_20, "
					+ "DECODE(B.DISCARD_REASON02_ORIGIN_VAL_20,NULL,0,B.DISCARD_REASON02_ORIGIN_VAL_20) DISCARD_REASON02_ORIGIN_VAL_20, "
					+ "DECODE(B.DISCARD_REASON03_ORIGIN_VAL_20,NULL,0,B.DISCARD_REASON03_ORIGIN_VAL_20) DISCARD_REASON03_ORIGIN_VAL_20, "
					+ "DECODE(B.DISCARD_REASON04_ORIGIN_VAL_20,NULL,0,B.DISCARD_REASON04_ORIGIN_VAL_20) DISCARD_REASON04_ORIGIN_VAL_20, "
					+ "DECODE(B.DISCARD_REASON05_ORIGIN_VAL_20,NULL,0,B.DISCARD_REASON05_ORIGIN_VAL_20) DISCARD_REASON05_ORIGIN_VAL_20, "
					+ "DECODE(B.DISCARD_REASON06_ORIGIN_VAL_20,NULL,0,B.DISCARD_REASON06_ORIGIN_VAL_20) DISCARD_REASON06_ORIGIN_VAL_20, "
					+ "DECODE(B.DISCARD_REASON07_ORIGIN_VAL_20,NULL,0,B.DISCARD_REASON07_ORIGIN_VAL_20) DISCARD_REASON07_ORIGIN_VAL_20, "
					+ "DECODE(B.DISCARD_REASON08_ORIGIN_VAL_20,NULL,0,B.DISCARD_REASON08_ORIGIN_VAL_20) DISCARD_REASON08_ORIGIN_VAL_20, "
					+ "DECODE(B.DISCARD_REASON01_NET_VAL_20,NULL,0,B.DISCARD_REASON01_NET_VAL_20) DISCARD_REASON01_NET_VAL_20, "
					+ "DECODE(B.DISCARD_REASON02_NET_VAL_20,NULL,0,B.DISCARD_REASON02_NET_VAL_20) DISCARD_REASON02_NET_VAL_20, "
					+ "DECODE(B.DISCARD_REASON03_NET_VAL_20,NULL,0,B.DISCARD_REASON03_NET_VAL_20) DISCARD_REASON03_NET_VAL_20, "
					+ "DECODE(B.DISCARD_REASON04_NET_VAL_20,NULL,0,B.DISCARD_REASON04_NET_VAL_20) DISCARD_REASON04_NET_VAL_20, "
					+ "DECODE(B.DISCARD_REASON05_NET_VAL_20,NULL,0,B.DISCARD_REASON05_NET_VAL_20) DISCARD_REASON05_NET_VAL_20, "
					+ "DECODE(B.DISCARD_REASON06_NET_VAL_20,NULL,0,B.DISCARD_REASON06_NET_VAL_20) DISCARD_REASON06_NET_VAL_20, "
					+ "DECODE(B.DISCARD_REASON07_NET_VAL_20,NULL,0,B.DISCARD_REASON07_NET_VAL_20) DISCARD_REASON07_NET_VAL_20, "
					+ "DECODE(B.DISCARD_REASON08_NET_VAL_20,NULL,0,B.DISCARD_REASON08_NET_VAL_20) DISCARD_REASON08_NET_VAL_20, "
					+ "DECODE(B.DISCARD_REASON01_CAPACITY_20,NULL,0,B.DISCARD_REASON01_CAPACITY_20) DISCARD_REASON01_CAPACITY_20, "
					+ "DECODE(B.DISCARD_REASON02_CAPACITY_20,NULL,0,B.DISCARD_REASON02_CAPACITY_20) DISCARD_REASON02_CAPACITY_20, "
					+ "DECODE(B.DISCARD_REASON03_CAPACITY_20,NULL,0,B.DISCARD_REASON03_CAPACITY_20) DISCARD_REASON03_CAPACITY_20, "
					+ "DECODE(B.DISCARD_REASON04_CAPACITY_20,NULL,0,B.DISCARD_REASON04_CAPACITY_20) DISCARD_REASON04_CAPACITY_20, "
					+ "DECODE(B.DISCARD_REASON05_CAPACITY_20,NULL,0,B.DISCARD_REASON05_CAPACITY_20) DISCARD_REASON05_CAPACITY_20, "
					+ "DECODE(B.DISCARD_REASON06_CAPACITY_20,NULL,0,B.DISCARD_REASON06_CAPACITY_20) DISCARD_REASON06_CAPACITY_20, "
					+ "DECODE(B.DISCARD_REASON07_CAPACITY_20,NULL,0,B.DISCARD_REASON07_CAPACITY_20) DISCARD_REASON07_CAPACITY_20, "
					+ "DECODE(B.DISCARD_REASON08_CAPACITY_20,NULL,0,B.DISCARD_REASON08_CAPACITY_20) DISCARD_REASON08_CAPACITY_20  "
					+ "FROM (SELECT  DISTINCT  * FROM STRUCT_TEMP_RESULT )A LEFT JOIN (SELECT  "
					+ "EXTRACT(YEAR FROM A.DV_DATE_VALUE) CAL_YEAR,A. CATEGORY ,A.VOLTAGE_LEVEL, "
					+ "SUM(A.DISCARD_REASON01_ORIGIN_VAL_20) DISCARD_REASON01_ORIGIN_VAL_20, "
					+ "SUM(A.DISCARD_REASON02_ORIGIN_VAL_20) DISCARD_REASON02_ORIGIN_VAL_20, "
					+ "SUM(A.DISCARD_REASON03_ORIGIN_VAL_20) DISCARD_REASON03_ORIGIN_VAL_20, "
					+ "SUM(A.DISCARD_REASON04_ORIGIN_VAL_20) DISCARD_REASON04_ORIGIN_VAL_20, "
					+ "SUM(A.DISCARD_REASON05_ORIGIN_VAL_20) DISCARD_REASON05_ORIGIN_VAL_20, "
					+ "SUM(A.DISCARD_REASON06_ORIGIN_VAL_20) DISCARD_REASON06_ORIGIN_VAL_20, "
					+ "SUM(A.DISCARD_REASON07_ORIGIN_VAL_20) DISCARD_REASON07_ORIGIN_VAL_20, "
					+ "SUM(A.DISCARD_REASON08_ORIGIN_VAL_20) DISCARD_REASON08_ORIGIN_VAL_20, "
					+ "SUM(A.DISCARD_REASON01_NET_VAL_20) DISCARD_REASON01_NET_VAL_20, "
					+ "SUM(A.DISCARD_REASON02_NET_VAL_20) DISCARD_REASON02_NET_VAL_20, "
					+ "SUM(A.DISCARD_REASON03_NET_VAL_20) DISCARD_REASON03_NET_VAL_20, "
					+ "SUM(A.DISCARD_REASON04_NET_VAL_20) DISCARD_REASON04_NET_VAL_20, "
					+ "SUM(A.DISCARD_REASON05_NET_VAL_20) DISCARD_REASON05_NET_VAL_20, "
					+ "SUM(A.DISCARD_REASON06_NET_VAL_20) DISCARD_REASON06_NET_VAL_20, "
					+ "SUM(A.DISCARD_REASON07_NET_VAL_20) DISCARD_REASON07_NET_VAL_20, "
					+ "SUM(A.DISCARD_REASON08_NET_VAL_20) DISCARD_REASON08_NET_VAL_20, "
					+ "SUM(A.DISCARD_REASON01_CAPACITY_20) DISCARD_REASON01_CAPACITY_20, "
					+ "SUM(A.DISCARD_REASON02_CAPACITY_20) DISCARD_REASON02_CAPACITY_20, "
					+ "SUM(A.DISCARD_REASON03_CAPACITY_20) DISCARD_REASON03_CAPACITY_20, "
					+ "SUM(A.DISCARD_REASON04_CAPACITY_20) DISCARD_REASON04_CAPACITY_20, "
					+ "SUM(A.DISCARD_REASON05_CAPACITY_20) DISCARD_REASON05_CAPACITY_20, "
					+ "SUM(A.DISCARD_REASON06_CAPACITY_20) DISCARD_REASON06_CAPACITY_20, "
					+ "SUM(A.DISCARD_REASON07_CAPACITY_20) DISCARD_REASON07_CAPACITY_20, "
					+ "SUM(A.DISCARD_REASON08_CAPACITY_20) DISCARD_REASON08_CAPACITY_20 "
					+ "FROM (SELECT E.ORG_ALIAS_NAME,F.AREA_NAME FROM DV_ORG_ALIAS E INNER JOIN DV_ORG F  "
					+ "ON E.DV_ORG_ID=F.DV_ORG_ID AND F.AREA_NAME IN ( SELECT A.AREA_NAME FROM DV_AREA A WHERE   "
					+ "EXISTS (SELECT 1 FROM DV_AREA B WHERE (DECODE( B.IS_LEAF,0, 1,0  )=1 AND  "
					+ "B.AREA_NAME=?  AND (SUBSTR(A.AREA_CODE,0,LENGTH(A.AREA_CODE)-3)=B.AREA_CODE " + // 2
					"OR (A.IS_LEAF=0 AND B.AREA_CODE=A.AREA_CODE )))OR (DECODE( B.IS_LEAF,0, 1,0  )=0 AND  "
					+ "B.AREA_NAME=? AND A.AREA_CODE=B.AREA_CODE)) )) F INNER JOIN  " + // 3
					"MID_ASSET_DISCARD_EQU_20 A ON A.ORG_NAME=F.ORG_ALIAS_NAME  WHERE VERSION= ? " + // 4
					"GROUP BY EXTRACT(YEAR FROM A.DV_DATE_VALUE),A. CATEGORY ,A.VOLTAGE_LEVEL "
					+ ") B ON(A.ASSET_CLASS_NAME=B. CATEGORY  AND  "
					+ "DECODE(A.VOLTAGE_NAME,NULL,'BLANK',A.VOLTAGE_NAME)=DECODE(B.VOLTAGE_LEVEL,NULL,'BLANK',B.VOLTAGE_LEVEL) "
					+ ")ORDER BY ASSET_CLASS_CODE,INDEXOF  " + "),LEVEL_TEMP_TAB AS (SELECT  A.CATEGORY, "
					+ "A.ASSET_CLASS_CODE,DECODE(LENGTH(A.ASSET_CLASS_CODE), "
					+ "3,NULL,SUBSTR(A.ASSET_CLASS_CODE,0,LENGTH(A.ASSET_CLASS_CODE)-3)) "
					+ "PARENT_CLASS_CODE,A.VOLTAGE_LEVEL,A.DISCARD_REASON01_ORIGIN_VAL_20, "
					+ "A.DISCARD_REASON02_ORIGIN_VAL_20,A.DISCARD_REASON03_ORIGIN_VAL_20, "
					+ "A.DISCARD_REASON04_ORIGIN_VAL_20,A.DISCARD_REASON05_ORIGIN_VAL_20, "
					+ "A.DISCARD_REASON06_ORIGIN_VAL_20,A.DISCARD_REASON07_ORIGIN_VAL_20, "
					+ "A.DISCARD_REASON08_ORIGIN_VAL_20,A.DISCARD_REASON01_NET_VAL_20, "
					+ "A.DISCARD_REASON02_NET_VAL_20,A.DISCARD_REASON03_NET_VAL_20, "
					+ "A.DISCARD_REASON04_NET_VAL_20,A.DISCARD_REASON05_NET_VAL_20, "
					+ "A.DISCARD_REASON06_NET_VAL_20,A.DISCARD_REASON07_NET_VAL_20, "
					+ "A.DISCARD_REASON08_NET_VAL_20,A.DISCARD_REASON01_CAPACITY_20, "
					+ "A.DISCARD_REASON02_CAPACITY_20,A.DISCARD_REASON03_CAPACITY_20, "
					+ "A.DISCARD_REASON04_CAPACITY_20,A.DISCARD_REASON05_CAPACITY_20, "
					+ "A.DISCARD_REASON06_CAPACITY_20,A.DISCARD_REASON07_CAPACITY_20, "
					+ "A.DISCARD_REASON08_CAPACITY_20   FROM RESULT_TEMP_TAB A), ORIGIN_TEMP AS (SELECT  "
					+ "B.CATEGORY,B.ASSET_CLASS_CODE,'001' INDICATE_DIMENSION,B.VOLTAGE_LEVEL,  "
					+ "SUM(A.DISCARD_REASON01_ORIGIN_VAL_20) DISCARD_REASON01_ORIGIN_VAL_20, "
					+ "SUM(A.DISCARD_REASON02_ORIGIN_VAL_20) DISCARD_REASON02_ORIGIN_VAL_20, "
					+ "SUM(A.DISCARD_REASON03_ORIGIN_VAL_20) DISCARD_REASON03_ORIGIN_VAL_20, "
					+ "SUM(A.DISCARD_REASON04_ORIGIN_VAL_20) DISCARD_REASON04_ORIGIN_VAL_20, "
					+ "SUM(A.DISCARD_REASON05_ORIGIN_VAL_20) DISCARD_REASON05_ORIGIN_VAL_20, "
					+ "SUM(A.DISCARD_REASON06_ORIGIN_VAL_20) DISCARD_REASON06_ORIGIN_VAL_20, "
					+ "SUM(A.DISCARD_REASON07_ORIGIN_VAL_20) DISCARD_REASON07_ORIGIN_VAL_20, "
					+ "SUM(A.DISCARD_REASON08_ORIGIN_VAL_20) DISCARD_REASON08_ORIGIN_VAL_20  "
					+ "FROM LEVEL_TEMP_TAB A , LEVEL_TEMP_TAB B  "
					+ "WHERE A.ASSET_CLASS_CODE IN (SELECT E.ASSET_CLASS_CODE FROM LEVEL_TEMP_TAB E  "
					+ "START WITH E.ASSET_CLASS_CODE=B.ASSET_CLASS_CODE "
					+ "CONNECT BY E.PARENT_CLASS_CODE=PRIOR E.ASSET_CLASS_CODE)GROUP BY B.CATEGORY, "
					+ "B.ASSET_CLASS_CODE,B.VOLTAGE_LEVEL ORDER BY 2), NET_TEMP AS (SELECT  "
					+ "B.CATEGORY,B.ASSET_CLASS_CODE,'002' INDICATE_DIMENSION,B.VOLTAGE_LEVEL,   "
					+ "SUM(A.DISCARD_REASON01_NET_VAL_20) DISCARD_REASON01_NET_VAL_20, "
					+ "SUM(A.DISCARD_REASON02_NET_VAL_20) DISCARD_REASON02_NET_VAL_20, "
					+ "SUM(A.DISCARD_REASON03_NET_VAL_20) DISCARD_REASON03_NET_VAL_20, "
					+ "SUM(A.DISCARD_REASON04_NET_VAL_20) DISCARD_REASON04_NET_VAL_20, "
					+ "SUM(A.DISCARD_REASON05_NET_VAL_20) DISCARD_REASON05_NET_VAL_20, "
					+ "SUM(A.DISCARD_REASON06_NET_VAL_20) DISCARD_REASON06_NET_VAL_20, "
					+ "SUM(A.DISCARD_REASON07_NET_VAL_20) DISCARD_REASON07_NET_VAL_20, "
					+ "SUM(A.DISCARD_REASON08_NET_VAL_20) DISCARD_REASON08_NET_VAL_20  "
					+ "FROM LEVEL_TEMP_TAB A , LEVEL_TEMP_TAB B WHERE A.ASSET_CLASS_CODE IN  "
					+ "(SELECT E.ASSET_CLASS_CODE FROM LEVEL_TEMP_TAB E  "
					+ "START WITH E.ASSET_CLASS_CODE=B.ASSET_CLASS_CODE "
					+ "CONNECT BY E.PARENT_CLASS_CODE=PRIOR E.ASSET_CLASS_CODE " + ")GROUP BY B.CATEGORY, "
					+ "B.ASSET_CLASS_CODE,B.VOLTAGE_LEVEL ORDER BY 2), AMOUNT_TEMP AS (SELECT  "
					+ "B.CATEGORY,B.ASSET_CLASS_CODE,'003' INDICATE_DIMENSION,B.VOLTAGE_LEVEL,   "
					+ "SUM(A.DISCARD_REASON01_CAPACITY_20) DISCARD_REASON01_CAPACITY_20, "
					+ "SUM(A.DISCARD_REASON02_CAPACITY_20) DISCARD_REASON02_CAPACITY_20, "
					+ "SUM(A.DISCARD_REASON03_CAPACITY_20) DISCARD_REASON03_CAPACITY_20, "
					+ "SUM(A.DISCARD_REASON04_CAPACITY_20) DISCARD_REASON04_CAPACITY_20, "
					+ "SUM(A.DISCARD_REASON05_CAPACITY_20) DISCARD_REASON05_CAPACITY_20, "
					+ "SUM(A.DISCARD_REASON06_CAPACITY_20) DISCARD_REASON06_CAPACITY_20, "
					+ "SUM(A.DISCARD_REASON07_CAPACITY_20) DISCARD_REASON07_CAPACITY_20, "
					+ "SUM(A.DISCARD_REASON08_CAPACITY_20) DISCARD_REASON08_CAPACITY_20 "
					+ "FROM LEVEL_TEMP_TAB A , LEVEL_TEMP_TAB B  "
					+ "WHERE A.ASSET_CLASS_CODE IN (SELECT E.ASSET_CLASS_CODE  " + "FROM LEVEL_TEMP_TAB E  "
					+ "START WITH E.ASSET_CLASS_CODE=B.ASSET_CLASS_CODE "
					+ "CONNECT BY E.PARENT_CLASS_CODE=PRIOR E.ASSET_CLASS_CODE) "
					+ "GROUP BY B.CATEGORY,B.ASSET_CLASS_CODE,B.VOLTAGE_LEVEL ORDER BY 2)  "
					+ "SELECT CATEGORY,ASSET_CLASS_CODE,INDICATE_DIMENSION,VOLTAGE_LEVEL, "
					+ "A.DISCARD_REASON01_ORIGIN_VAL_20  DISCARD_REASON01, "
					+ "A.DISCARD_REASON02_ORIGIN_VAL_20  DISCARD_REASON02, "
					+ "A.DISCARD_REASON03_ORIGIN_VAL_20  DISCARD_REASON03, "
					+ "A.DISCARD_REASON04_ORIGIN_VAL_20  DISCARD_REASON04, "
					+ "A.DISCARD_REASON05_ORIGIN_VAL_20  DISCARD_REASON05, "
					+ "A.DISCARD_REASON06_ORIGIN_VAL_20  DISCARD_REASON06, "
					+ "A.DISCARD_REASON07_ORIGIN_VAL_20  DISCARD_REASON07, "
					+ "A.DISCARD_REASON08_ORIGIN_VAL_20  DISCARD_REASON08 " + " FROM ORIGIN_TEMP A UNION ALL SELECT  "
					+ "CATEGORY,ASSET_CLASS_CODE,INDICATE_DIMENSION,VOLTAGE_LEVEL, "
					+ "A.DISCARD_REASON01_NET_VAL_20  DISCARD_REASON01, "
					+ "A.DISCARD_REASON02_NET_VAL_20  DISCARD_REASON02, "
					+ "A.DISCARD_REASON03_NET_VAL_20  DISCARD_REASON03, "
					+ "A.DISCARD_REASON04_NET_VAL_20  DISCARD_REASON04, "
					+ "A.DISCARD_REASON05_NET_VAL_20  DISCARD_REASON05, "
					+ "A.DISCARD_REASON06_NET_VAL_20  DISCARD_REASON06, "
					+ "A.DISCARD_REASON07_NET_VAL_20  DISCARD_REASON07, "
					+ "A.DISCARD_REASON08_NET_VAL_20  DISCARD_REASON08 " + " FROM NET_TEMP A UNION ALL  SELECT  "
					+ "CATEGORY,ASSET_CLASS_CODE,INDICATE_DIMENSION,VOLTAGE_LEVEL, "
					+ "A.DISCARD_REASON01_CAPACITY_20 DISCARD_REASON01, "
					+ "A.DISCARD_REASON02_CAPACITY_20 DISCARD_REASON02, "
					+ "A.DISCARD_REASON03_CAPACITY_20 DISCARD_REASON03, "
					+ "A.DISCARD_REASON04_CAPACITY_20 DISCARD_REASON04, "
					+ "A.DISCARD_REASON05_CAPACITY_20 DISCARD_REASON05, "
					+ "A.DISCARD_REASON06_CAPACITY_20 DISCARD_REASON06, "
					+ "A.DISCARD_REASON07_CAPACITY_20 DISCARD_REASON07, "
					+ "A.DISCARD_REASON08_CAPACITY_20 DISCARD_REASON08 " + "FROM AMOUNT_TEMP A ORDER BY 2,3";

			try {
				new ReportOutput2().writeXLSXDiscard(reportSQL, templateFilePathAndName, targetFilePathAndName,
						reportName, voltageRelationCode, dataVersion, areaName, sheetName, startRowNumber,
						startColumnNumber);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			sheetName = "A.5.5 报废资产规模结构（项目类型）-规模";
			reportName = "A.5.5 报废资产规模结构（项目类型）-规模";
			System.out.println(sheetName + " Start!");
			// dataVersion = "M_2019_2";
			//
			dataVersion = "M_2019_3";// 20200618--河北
			// dataVersion = "M_2019_2";// 20200612--湖北
			// 循环输出表格中的内容,首先循环取出行,再根据行循环取出列
			startRowNumber = 5;
			startColumnNumber = 2;
			reportSQL = "WITH STRUCTRUE_TEMP_TAB AS (SELECT A.ASSET_CLASS_NAME, "
					+ "A.ASSET_CLASS_CODE,B.VOLTAGE_NAME,B.INDEXOF FROM DV_ASSET_CLASS A "
					+ "LEFT JOIN (SELECT  C.VOLTAGE_NAME,B.DV_ASSET_CLASS_ID,B.INDEXOF  "
					+ "FROM DV_VOLTAGE_RELATION B  INNER JOIN DV_VOLTAGE_LEVEL C ON  "
					+ "B.DV_VOLTAGE_LEVEL_ID=C.DV_VOLTAGE_LEVEL_ID WHERE B.VOLTAGE_RELATION_CODE=? " + // 1
					")B ON A.DV_ASSET_CLASS_ID=B.DV_ASSET_CLASS_ID ORDER BY  "
					+ "A.ASSET_CLASS_CODE ,B.INDEXOF ),SPAN_STRUCTURE_TAB AS (SELECT A.ASSET_CLASS_NAME, "
					+ "DECODE(A.VOLTAGE_NAME,NULL,A.ASSET_CLASS_CODE,DECODE(LENGTH(TO_CHAR(A.INDEXOF)),1, "
					+ "A.ASSET_CLASS_CODE||'10'||A.INDEXOF,2,A.ASSET_CLASS_CODE||'1'||A.INDEXOF) "
					+ ") STRUCTURE_CODE,A.ASSET_CLASS_CODE,VOLTAGE_NAME,INDEXOF FROM  "
					+ "STRUCTRUE_TEMP_TAB A  ORDER BY STRUCTURE_CODE,INDEXOF ), "
					+ "STRUCT_TEMP_RESULT AS (SELECT A.ASSET_CLASS_NAME, A.ASSET_CLASS_CODE, "
					+ "B.VOLTAGE_NAME,B.INDEXOF FROM DV_ASSET_CLASS A LEFT JOIN  "
					+ "SPAN_STRUCTURE_TAB B ON A.ASSET_CLASS_CODE=B.STRUCTURE_CODE "
					+ "UNION ALL SELECT B.ASSET_CLASS_NAME,B.STRUCTURE_CODE ASSET_CLASS_CODE, "
					+ "B.VOLTAGE_NAME,B.INDEXOF FROM SPAN_STRUCTURE_TAB B ORDER BY "
					+ "ASSET_CLASS_CODE,INDEXOF ),RESULT_TEMP_TAB AS (SELECT A.ASSET_CLASS_NAME CATEGORY, "
					+ "A.ASSET_CLASS_CODE,A.VOLTAGE_NAME VOLTAGE_LEVEL, "
					+ "DECODE(B.DISCARD_PROJECT01_ORIGIN_VAL ,NULL,0, B.DISCARD_PROJECT01_ORIGIN_VAL )DISCARD_PROJECT01_ORIGIN_VAL  , "
					+ "DECODE(B.DISCARD_PROJECT02_ORIGIN_VAL ,NULL,0, B.DISCARD_PROJECT02_ORIGIN_VAL )DISCARD_PROJECT02_ORIGIN_VAL  , "
					+ "DECODE(B.DISCARD_PROJECT03_ORIGIN_VAL ,NULL,0, B.DISCARD_PROJECT03_ORIGIN_VAL )DISCARD_PROJECT03_ORIGIN_VAL  , "
					+ "DECODE(B.DISCARD_PROJECT04_ORIGIN_VAL ,NULL,0, B.DISCARD_PROJECT04_ORIGIN_VAL )DISCARD_PROJECT04_ORIGIN_VAL  , "
					+ "DECODE(B.DISCARD_PROJECT05_ORIGIN_VAL ,NULL,0, B.DISCARD_PROJECT05_ORIGIN_VAL )DISCARD_PROJECT05_ORIGIN_VAL  , "
					+ "DECODE(B.DISCARD_PROJECT01_NET_VAL    ,NULL,0, B.DISCARD_PROJECT01_NET_VAL    )DISCARD_PROJECT01_NET_VAL     , "
					+ "DECODE(B.DISCARD_PROJECT02_NET_VAL    ,NULL,0, B.DISCARD_PROJECT02_NET_VAL    )DISCARD_PROJECT02_NET_VAL     , "
					+ "DECODE(B.DISCARD_PROJECT03_NET_VAL    ,NULL,0, B.DISCARD_PROJECT03_NET_VAL    )DISCARD_PROJECT03_NET_VAL     , "
					+ "DECODE(B.DISCARD_PROJECT04_NET_VAL    ,NULL,0, B.DISCARD_PROJECT04_NET_VAL    )DISCARD_PROJECT04_NET_VAL     , "
					+ "DECODE(B.DISCARD_PROJECT05_NET_VAL    ,NULL,0, B.DISCARD_PROJECT05_NET_VAL    )DISCARD_PROJECT05_NET_VAL     , "
					+ "DECODE(B.DISCARD_PROJECT01_AMOUNT     ,NULL,0, B.DISCARD_PROJECT01_AMOUNT     )DISCARD_PROJECT01_AMOUNT      , "
					+ "DECODE(B.DISCARD_PROJECT02_AMOUNT     ,NULL,0, B.DISCARD_PROJECT02_AMOUNT     )DISCARD_PROJECT02_AMOUNT      , "
					+ "DECODE(B.DISCARD_PROJECT03_AMOUNT     ,NULL,0, B.DISCARD_PROJECT03_AMOUNT     )DISCARD_PROJECT03_AMOUNT      , "
					+ "DECODE(B.DISCARD_PROJECT04_AMOUNT     ,NULL,0, B.DISCARD_PROJECT04_AMOUNT     )DISCARD_PROJECT04_AMOUNT      , "
					+ "DECODE(B.DISCARD_PROJECT05_AMOUNT     ,NULL,0, B.DISCARD_PROJECT05_AMOUNT     )DISCARD_PROJECT05_AMOUNT      , "
					+ "DECODE(B.DISCARD_PROJECT01_CAPACITY   ,NULL,0, B.DISCARD_PROJECT01_CAPACITY   )DISCARD_PROJECT01_CAPACITY    , "
					+ "DECODE(B.DISCARD_PROJECT02_CAPACITY   ,NULL,0, B.DISCARD_PROJECT02_CAPACITY   )DISCARD_PROJECT02_CAPACITY    , "
					+ "DECODE(B.DISCARD_PROJECT03_CAPACITY   ,NULL,0, B.DISCARD_PROJECT03_CAPACITY   )DISCARD_PROJECT03_CAPACITY    , "
					+ "DECODE(B.DISCARD_PROJECT04_CAPACITY   ,NULL,0, B.DISCARD_PROJECT04_CAPACITY   )DISCARD_PROJECT04_CAPACITY    , "
					+ "DECODE(B.DISCARD_PROJECT05_CAPACITY   ,NULL,0, B.DISCARD_PROJECT05_CAPACITY   )DISCARD_PROJECT05_CAPACITY  "
					+ "FROM (SELECT  DISTINCT  * FROM STRUCT_TEMP_RESULT )A LEFT JOIN ( "
					+ "SELECT EXTRACT(YEAR FROM A.DV_DATE_VALUE) CAL_YEAR,A. CATEGORY ,A.VOLTAGE_LEVEL, "
					+ "SUM(DISCARD_PROJECT01_ORIGIN_VAL )DISCARD_PROJECT01_ORIGIN_VAL  , "
					+ "SUM(DISCARD_PROJECT02_ORIGIN_VAL )DISCARD_PROJECT02_ORIGIN_VAL  , "
					+ "SUM(DISCARD_PROJECT03_ORIGIN_VAL )DISCARD_PROJECT03_ORIGIN_VAL  , "
					+ "SUM(DISCARD_PROJECT04_ORIGIN_VAL )DISCARD_PROJECT04_ORIGIN_VAL  , "
					+ "SUM(DISCARD_PROJECT05_ORIGIN_VAL )DISCARD_PROJECT05_ORIGIN_VAL  , "
					+ "SUM(DISCARD_PROJECT01_NET_VAL    )DISCARD_PROJECT01_NET_VAL     , "
					+ "SUM(DISCARD_PROJECT02_NET_VAL    )DISCARD_PROJECT02_NET_VAL     , "
					+ "SUM(DISCARD_PROJECT03_NET_VAL    )DISCARD_PROJECT03_NET_VAL     , "
					+ "SUM(DISCARD_PROJECT04_NET_VAL    )DISCARD_PROJECT04_NET_VAL     , "
					+ "SUM(DISCARD_PROJECT05_NET_VAL    )DISCARD_PROJECT05_NET_VAL     , "
					+ "SUM(DISCARD_PROJECT01_AMOUNT     )DISCARD_PROJECT01_AMOUNT      , "
					+ "SUM(DISCARD_PROJECT02_AMOUNT     )DISCARD_PROJECT02_AMOUNT      , "
					+ "SUM(DISCARD_PROJECT03_AMOUNT     )DISCARD_PROJECT03_AMOUNT      , "
					+ "SUM(DISCARD_PROJECT04_AMOUNT     )DISCARD_PROJECT04_AMOUNT      , "
					+ "SUM(DISCARD_PROJECT05_AMOUNT     )DISCARD_PROJECT05_AMOUNT      , "
					+ "SUM(DISCARD_PROJECT01_CAPACITY   )DISCARD_PROJECT01_CAPACITY    , "
					+ "SUM(DISCARD_PROJECT02_CAPACITY   )DISCARD_PROJECT02_CAPACITY    , "
					+ "SUM(DISCARD_PROJECT03_CAPACITY   )DISCARD_PROJECT03_CAPACITY    , "
					+ "SUM(DISCARD_PROJECT04_CAPACITY   )DISCARD_PROJECT04_CAPACITY    , "
					+ "SUM(DISCARD_PROJECT05_CAPACITY   )DISCARD_PROJECT05_CAPACITY      "
					+ "FROM  (SELECT E.ORG_ALIAS_NAME,F.AREA_NAME FROM DV_ORG_ALIAS E  "
					+ "INNER JOIN DV_ORG F ON E.DV_ORG_ID=F.DV_ORG_ID AND  "
					+ "F.AREA_NAME IN ( SELECT A.AREA_NAME FROM DV_AREA A WHERE   "
					+ "EXISTS (SELECT 1 FROM DV_AREA B WHERE (DECODE( B.IS_LEAF,0, 1,0	)=1  "
					+ "AND B.AREA_NAME=? AND (SUBSTR(A.AREA_CODE,0,LENGTH(A.AREA_CODE)-3)=B.AREA_CODE " + // 2
					"OR (A.IS_LEAF=0 AND B.AREA_CODE=A.AREA_CODE )))OR (DECODE( B.IS_LEAF,0, 1,0	)=0  "
					+ "AND B.AREA_NAME=? AND A.AREA_CODE=B.AREA_CODE)) )) F INNER JOIN  " + // 3
					"MID_ASSET_DISCARD A   ON A.ORG_NAME=F.ORG_ALIAS_NAME  WHERE  "
					+ "VERSION= ? GROUP BY EXTRACT(YEAR FROM A.DV_DATE_VALUE), " + // 4
					"A. CATEGORY ,A.VOLTAGE_LEVEL) B ON (A.ASSET_CLASS_NAME=B. CATEGORY  AND  "
					+ "DECODE(A.VOLTAGE_NAME,NULL,'BLANK',A.VOLTAGE_NAME)=DECODE(B.VOLTAGE_LEVEL,NULL,'BLANK',B.VOLTAGE_LEVEL) "
					+ ")ORDER BY ASSET_CLASS_CODE,INDEXOF ),LEVEL_TEMP_TAB AS (SELECT  A.CATEGORY, "
					+ "A.ASSET_CLASS_CODE,DECODE(LENGTH(A.ASSET_CLASS_CODE), "
					+ "3,NULL,SUBSTR(A.ASSET_CLASS_CODE,0,LENGTH(A.ASSET_CLASS_CODE)-3)) "
					+ "PARENT_CLASS_CODE,A.VOLTAGE_LEVEL, "
					+ "A.DISCARD_PROJECT01_ORIGIN_VAL ,A.DISCARD_PROJECT02_ORIGIN_VAL , "
					+ "A.DISCARD_PROJECT03_ORIGIN_VAL ,A.DISCARD_PROJECT04_ORIGIN_VAL , "
					+ "A.DISCARD_PROJECT05_ORIGIN_VAL ,A.DISCARD_PROJECT01_NET_VAL    , "
					+ "A.DISCARD_PROJECT02_NET_VAL    ,A.DISCARD_PROJECT03_NET_VAL    , "
					+ "A.DISCARD_PROJECT04_NET_VAL    ,A.DISCARD_PROJECT05_NET_VAL    , "
					+ "A.DISCARD_PROJECT01_AMOUNT     ,A.DISCARD_PROJECT02_AMOUNT     , "
					+ "A.DISCARD_PROJECT03_AMOUNT     ,A.DISCARD_PROJECT04_AMOUNT     , "
					+ "A.DISCARD_PROJECT05_AMOUNT     ,A.DISCARD_PROJECT01_CAPACITY   , "
					+ "A.DISCARD_PROJECT02_CAPACITY   ,A.DISCARD_PROJECT03_CAPACITY   , "
					+ "A.DISCARD_PROJECT04_CAPACITY   ,A.DISCARD_PROJECT05_CAPACITY      "
					+ "FROM RESULT_TEMP_TAB A ),ORIG_TEMP AS(SELECT  "
					+ "B.CATEGORY,B.ASSET_CLASS_CODE  ,'001' INDICATE_DIMENSION,B.VOLTAGE_LEVEL,  "
					+ "SUM(A.DISCARD_PROJECT01_ORIGIN_VAL )DISCARD_PROJECT01_ORIGIN_VAL, "
					+ "SUM(A.DISCARD_PROJECT02_ORIGIN_VAL )DISCARD_PROJECT02_ORIGIN_VAL, "
					+ "SUM(A.DISCARD_PROJECT03_ORIGIN_VAL )DISCARD_PROJECT03_ORIGIN_VAL, "
					+ "SUM(A.DISCARD_PROJECT04_ORIGIN_VAL +A.DISCARD_PROJECT05_ORIGIN_VAL )DISCARD_PROJECT04_ORIGIN_VAL  "
					+ "FROM LEVEL_TEMP_TAB A , LEVEL_TEMP_TAB B WHERE A.ASSET_CLASS_CODE IN  "
					+ "(SELECT E.ASSET_CLASS_CODE FROM LEVEL_TEMP_TAB E  "
					+ "START WITH E.ASSET_CLASS_CODE=B.ASSET_CLASS_CODE "
					+ "CONNECT BY E.PARENT_CLASS_CODE=PRIOR E.ASSET_CLASS_CODE "
					+ ")GROUP BY B.CATEGORY,B.ASSET_CLASS_CODE, "
					+ "B.VOLTAGE_LEVEL ORDER BY 2),NET_VAL_TEMP AS(SELECT  "
					+ "B.CATEGORY,B.ASSET_CLASS_CODE ,'002' INDICATE_DIMENSION,B.VOLTAGE_LEVEL,   "
					+ "SUM(A.DISCARD_PROJECT01_NET_VAL    )DISCARD_PROJECT01_NET_VAL   , "
					+ "SUM(A.DISCARD_PROJECT02_NET_VAL    )DISCARD_PROJECT02_NET_VAL   , "
					+ "SUM(A.DISCARD_PROJECT03_NET_VAL    )DISCARD_PROJECT03_NET_VAL   , "
					+ "SUM(A.DISCARD_PROJECT04_NET_VAL    +A.DISCARD_PROJECT05_NET_VAL    )DISCARD_PROJECT04_NET_VAL    "
					+ "FROM LEVEL_TEMP_TAB A , LEVEL_TEMP_TAB B WHERE A.ASSET_CLASS_CODE IN  "
					+ "(SELECT E.ASSET_CLASS_CODE FROM LEVEL_TEMP_TAB E  "
					+ "START WITH E.ASSET_CLASS_CODE=B.ASSET_CLASS_CODE "
					+ "CONNECT BY E.PARENT_CLASS_CODE=PRIOR E.ASSET_CLASS_CODE "
					+ ")GROUP BY B.CATEGORY,B.ASSET_CLASS_CODE, " + "B.VOLTAGE_LEVEL ORDER BY 2),CAPACITY_VAL_TEMP AS( "
					+ "SELECT B.CATEGORY,B.ASSET_CLASS_CODE ,'003' INDICATE_DIMENSION, " + "B.VOLTAGE_LEVEL,   "
					+ "SUM(A.DISCARD_PROJECT01_CAPACITY      )DISCARD_PROJECT01_CAPACITY    , "
					+ "SUM(A.DISCARD_PROJECT02_CAPACITY      )DISCARD_PROJECT02_CAPACITY     , "
					+ "SUM(A.DISCARD_PROJECT03_CAPACITY      )DISCARD_PROJECT03_CAPACITY     , "
					+ "SUM(A.DISCARD_PROJECT04_CAPACITY      +A.DISCARD_PROJECT05_CAPACITY)DISCARD_PROJECT04_CAPACITY      "
					+ "FROM LEVEL_TEMP_TAB A , LEVEL_TEMP_TAB B WHERE A.ASSET_CLASS_CODE IN  "
					+ "(SELECT E.ASSET_CLASS_CODE FROM LEVEL_TEMP_TAB E  "
					+ "START WITH E.ASSET_CLASS_CODE=B.ASSET_CLASS_CODE "
					+ "CONNECT BY E.PARENT_CLASS_CODE=PRIOR E.ASSET_CLASS_CODE) "
					+ "GROUP BY B.CATEGORY,B.ASSET_CLASS_CODE,B.VOLTAGE_LEVEL ORDER BY 2) SELECT "
					+ "CATEGORY,ASSET_CLASS_CODE,INDICATE_DIMENSION,VOLTAGE_LEVEL, "
					+ "A.DISCARD_PROJECT01_ORIGIN_VAL  DISCARD_PROJECT01 , "
					+ "A.DISCARD_PROJECT02_ORIGIN_VAL  DISCARD_PROJECT02 , "
					+ "A.DISCARD_PROJECT03_ORIGIN_VAL  DISCARD_PROJECT03 , "
					+ "A.DISCARD_PROJECT04_ORIGIN_VAL  DISCARD_PROJECT04    " + "FROM ORIG_TEMP A UNION ALL SELECT  "
					+ "CATEGORY,ASSET_CLASS_CODE,INDICATE_DIMENSION,VOLTAGE_LEVEL, "
					+ "A.DISCARD_PROJECT01_NET_VAL   DISCARD_PROJECT01, "
					+ "A.DISCARD_PROJECT02_NET_VAL   DISCARD_PROJECT02, "
					+ "A.DISCARD_PROJECT03_NET_VAL   DISCARD_PROJECT03, "
					+ "A.DISCARD_PROJECT04_NET_VAL   DISCARD_PROJECT04  " + "FROM NET_VAL_TEMP A UNION ALL SELECT  "
					+ "CATEGORY,ASSET_CLASS_CODE,INDICATE_DIMENSION,VOLTAGE_LEVEL, "
					+ "A.DISCARD_PROJECT01_CAPACITY   DISCARD_PROJECT01, "
					+ "A.DISCARD_PROJECT02_CAPACITY   DISCARD_PROJECT02, "
					+ "A.DISCARD_PROJECT03_CAPACITY  DISCARD_PROJECT03, "
					+ "A.DISCARD_PROJECT04_CAPACITY   DISCARD_PROJECT04  " + "FROM CAPACITY_VAL_TEMP  A ORDER BY 2,3 ";

			try {
				new ReportOutput2().writeXLSXDiscard(reportSQL, templateFilePathAndName, targetFilePathAndName,
						reportName, voltageRelationCode, dataVersion, areaName, sheetName, startRowNumber,
						startColumnNumber);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			sheetName = "A.5.5 报废资产规模结构（项目类型）";
			reportName = "A.5.5 报废资产规模结构（项目类型）";
			System.out.println(sheetName + " Start!");
			// dataVersion = "M_2019_2";
			//
			dataVersion = "M_2019_3";// 20200618--河北
			// dataVersion = "M_2019_2";// 20200612--湖北
			// 循环输出表格中的内容,首先循环取出行,再根据行循环取出列
			startRowNumber = 5;
			startColumnNumber = 2;
			reportSQL = "WITH STRUCTRUE_TEMP_TAB AS (SELECT A.ASSET_CLASS_NAME, "
					+ "A.ASSET_CLASS_CODE,B.VOLTAGE_NAME,B.INDEXOF FROM DV_ASSET_CLASS A "
					+ "LEFT JOIN (SELECT  C.VOLTAGE_NAME,B.DV_ASSET_CLASS_ID,B.INDEXOF  "
					+ "FROM DV_VOLTAGE_RELATION B  INNER JOIN DV_VOLTAGE_LEVEL C ON  "
					+ "B.DV_VOLTAGE_LEVEL_ID=C.DV_VOLTAGE_LEVEL_ID WHERE B.VOLTAGE_RELATION_CODE=? " + // 1
					")B ON A.DV_ASSET_CLASS_ID=B.DV_ASSET_CLASS_ID ORDER BY  "
					+ "A.ASSET_CLASS_CODE ,B.INDEXOF ),SPAN_STRUCTURE_TAB AS (SELECT A.ASSET_CLASS_NAME, "
					+ "DECODE(A.VOLTAGE_NAME,NULL,A.ASSET_CLASS_CODE,DECODE(LENGTH(TO_CHAR(A.INDEXOF)),1, "
					+ "A.ASSET_CLASS_CODE||'10'||A.INDEXOF,2,A.ASSET_CLASS_CODE||'1'||A.INDEXOF) "
					+ ") STRUCTURE_CODE,A.ASSET_CLASS_CODE,VOLTAGE_NAME,INDEXOF FROM  "
					+ "STRUCTRUE_TEMP_TAB A  ORDER BY STRUCTURE_CODE,INDEXOF ), "
					+ "STRUCT_TEMP_RESULT AS (SELECT A.ASSET_CLASS_NAME, A.ASSET_CLASS_CODE, "
					+ "B.VOLTAGE_NAME,B.INDEXOF FROM DV_ASSET_CLASS A LEFT JOIN  "
					+ "SPAN_STRUCTURE_TAB B ON A.ASSET_CLASS_CODE=B.STRUCTURE_CODE "
					+ "UNION ALL SELECT B.ASSET_CLASS_NAME,B.STRUCTURE_CODE ASSET_CLASS_CODE, "
					+ "B.VOLTAGE_NAME,B.INDEXOF FROM SPAN_STRUCTURE_TAB B ORDER BY "
					+ "ASSET_CLASS_CODE,INDEXOF ),RESULT_TEMP_TAB AS (SELECT A.ASSET_CLASS_NAME CATEGORY, "
					+ "A.ASSET_CLASS_CODE,A.VOLTAGE_NAME VOLTAGE_LEVEL, "
					+ "DECODE(B.DISCARD_PROJECT01_ORIGIN_VAL ,NULL,0, B.DISCARD_PROJECT01_ORIGIN_VAL )DISCARD_PROJECT01_ORIGIN_VAL  , "
					+ "DECODE(B.DISCARD_PROJECT02_ORIGIN_VAL ,NULL,0, B.DISCARD_PROJECT02_ORIGIN_VAL )DISCARD_PROJECT02_ORIGIN_VAL  , "
					+ "DECODE(B.DISCARD_PROJECT03_ORIGIN_VAL ,NULL,0, B.DISCARD_PROJECT03_ORIGIN_VAL )DISCARD_PROJECT03_ORIGIN_VAL  , "
					+ "DECODE(B.DISCARD_PROJECT04_ORIGIN_VAL ,NULL,0, B.DISCARD_PROJECT04_ORIGIN_VAL )DISCARD_PROJECT04_ORIGIN_VAL  , "
					+ "DECODE(B.DISCARD_PROJECT05_ORIGIN_VAL ,NULL,0, B.DISCARD_PROJECT05_ORIGIN_VAL )DISCARD_PROJECT05_ORIGIN_VAL  , "
					+ "DECODE(B.DISCARD_PROJECT01_NET_VAL    ,NULL,0, B.DISCARD_PROJECT01_NET_VAL    )DISCARD_PROJECT01_NET_VAL     , "
					+ "DECODE(B.DISCARD_PROJECT02_NET_VAL    ,NULL,0, B.DISCARD_PROJECT02_NET_VAL    )DISCARD_PROJECT02_NET_VAL     , "
					+ "DECODE(B.DISCARD_PROJECT03_NET_VAL    ,NULL,0, B.DISCARD_PROJECT03_NET_VAL    )DISCARD_PROJECT03_NET_VAL     , "
					+ "DECODE(B.DISCARD_PROJECT04_NET_VAL    ,NULL,0, B.DISCARD_PROJECT04_NET_VAL    )DISCARD_PROJECT04_NET_VAL     , "
					+ "DECODE(B.DISCARD_PROJECT05_NET_VAL    ,NULL,0, B.DISCARD_PROJECT05_NET_VAL    )DISCARD_PROJECT05_NET_VAL     , "
					+ "DECODE(B.DISCARD_PROJECT01_AMOUNT     ,NULL,0, B.DISCARD_PROJECT01_AMOUNT     )DISCARD_PROJECT01_AMOUNT      , "
					+ "DECODE(B.DISCARD_PROJECT02_AMOUNT     ,NULL,0, B.DISCARD_PROJECT02_AMOUNT     )DISCARD_PROJECT02_AMOUNT      , "
					+ "DECODE(B.DISCARD_PROJECT03_AMOUNT     ,NULL,0, B.DISCARD_PROJECT03_AMOUNT     )DISCARD_PROJECT03_AMOUNT      , "
					+ "DECODE(B.DISCARD_PROJECT04_AMOUNT     ,NULL,0, B.DISCARD_PROJECT04_AMOUNT     )DISCARD_PROJECT04_AMOUNT      , "
					+ "DECODE(B.DISCARD_PROJECT05_AMOUNT     ,NULL,0, B.DISCARD_PROJECT05_AMOUNT     )DISCARD_PROJECT05_AMOUNT      , "
					+ "DECODE(B.DISCARD_PROJECT01_CAPACITY   ,NULL,0, B.DISCARD_PROJECT01_CAPACITY   )DISCARD_PROJECT01_CAPACITY    , "
					+ "DECODE(B.DISCARD_PROJECT02_CAPACITY   ,NULL,0, B.DISCARD_PROJECT02_CAPACITY   )DISCARD_PROJECT02_CAPACITY    , "
					+ "DECODE(B.DISCARD_PROJECT03_CAPACITY   ,NULL,0, B.DISCARD_PROJECT03_CAPACITY   )DISCARD_PROJECT03_CAPACITY    , "
					+ "DECODE(B.DISCARD_PROJECT04_CAPACITY   ,NULL,0, B.DISCARD_PROJECT04_CAPACITY   )DISCARD_PROJECT04_CAPACITY    , "
					+ "DECODE(B.DISCARD_PROJECT05_CAPACITY   ,NULL,0, B.DISCARD_PROJECT05_CAPACITY   )DISCARD_PROJECT05_CAPACITY  "
					+ "FROM (SELECT  DISTINCT  * FROM STRUCT_TEMP_RESULT )A LEFT JOIN ( "
					+ "SELECT EXTRACT(YEAR FROM A.DV_DATE_VALUE) CAL_YEAR,A. CATEGORY ,A.VOLTAGE_LEVEL, "
					+ "SUM(DISCARD_PROJECT01_ORIGIN_VAL )DISCARD_PROJECT01_ORIGIN_VAL  , "
					+ "SUM(DISCARD_PROJECT02_ORIGIN_VAL )DISCARD_PROJECT02_ORIGIN_VAL  , "
					+ "SUM(DISCARD_PROJECT03_ORIGIN_VAL )DISCARD_PROJECT03_ORIGIN_VAL  , "
					+ "SUM(DISCARD_PROJECT04_ORIGIN_VAL )DISCARD_PROJECT04_ORIGIN_VAL  , "
					+ "SUM(DISCARD_PROJECT05_ORIGIN_VAL )DISCARD_PROJECT05_ORIGIN_VAL  , "
					+ "SUM(DISCARD_PROJECT01_NET_VAL    )DISCARD_PROJECT01_NET_VAL     , "
					+ "SUM(DISCARD_PROJECT02_NET_VAL    )DISCARD_PROJECT02_NET_VAL     , "
					+ "SUM(DISCARD_PROJECT03_NET_VAL    )DISCARD_PROJECT03_NET_VAL     , "
					+ "SUM(DISCARD_PROJECT04_NET_VAL    )DISCARD_PROJECT04_NET_VAL     , "
					+ "SUM(DISCARD_PROJECT05_NET_VAL    )DISCARD_PROJECT05_NET_VAL     , "
					+ "SUM(DISCARD_PROJECT01_AMOUNT     )DISCARD_PROJECT01_AMOUNT      , "
					+ "SUM(DISCARD_PROJECT02_AMOUNT     )DISCARD_PROJECT02_AMOUNT      , "
					+ "SUM(DISCARD_PROJECT03_AMOUNT     )DISCARD_PROJECT03_AMOUNT      , "
					+ "SUM(DISCARD_PROJECT04_AMOUNT     )DISCARD_PROJECT04_AMOUNT      , "
					+ "SUM(DISCARD_PROJECT05_AMOUNT     )DISCARD_PROJECT05_AMOUNT      , "
					+ "SUM(DISCARD_PROJECT01_CAPACITY   )DISCARD_PROJECT01_CAPACITY    , "
					+ "SUM(DISCARD_PROJECT02_CAPACITY   )DISCARD_PROJECT02_CAPACITY    , "
					+ "SUM(DISCARD_PROJECT03_CAPACITY   )DISCARD_PROJECT03_CAPACITY    , "
					+ "SUM(DISCARD_PROJECT04_CAPACITY   )DISCARD_PROJECT04_CAPACITY    , "
					+ "SUM(DISCARD_PROJECT05_CAPACITY   )DISCARD_PROJECT05_CAPACITY      "
					+ "FROM  (SELECT E.ORG_ALIAS_NAME,F.AREA_NAME FROM DV_ORG_ALIAS E  "
					+ "INNER JOIN DV_ORG F ON E.DV_ORG_ID=F.DV_ORG_ID AND  "
					+ "F.AREA_NAME IN ( SELECT A.AREA_NAME FROM DV_AREA A WHERE   "
					+ "EXISTS (SELECT 1 FROM DV_AREA B WHERE (DECODE( B.IS_LEAF,0, 1,0	)=1  "
					+ "AND B.AREA_NAME=? AND (SUBSTR(A.AREA_CODE,0,LENGTH(A.AREA_CODE)-3)=B.AREA_CODE " + // 2
					"OR (A.IS_LEAF=0 AND B.AREA_CODE=A.AREA_CODE )))OR (DECODE( B.IS_LEAF,0, 1,0	)=0  "
					+ "AND B.AREA_NAME=? AND A.AREA_CODE=B.AREA_CODE)) )) F INNER JOIN  " + // 3
					"MID_ASSET_DISCARD A   ON A.ORG_NAME=F.ORG_ALIAS_NAME  WHERE  "
					+ "VERSION= ? GROUP BY EXTRACT(YEAR FROM A.DV_DATE_VALUE), " + // 4
					"A. CATEGORY ,A.VOLTAGE_LEVEL) B ON (A.ASSET_CLASS_NAME=B. CATEGORY  AND  "
					+ "DECODE(A.VOLTAGE_NAME,NULL,'BLANK',A.VOLTAGE_NAME)=DECODE(B.VOLTAGE_LEVEL,NULL,'BLANK',B.VOLTAGE_LEVEL) "
					+ ")ORDER BY ASSET_CLASS_CODE,INDEXOF ),LEVEL_TEMP_TAB AS (SELECT  A.CATEGORY, "
					+ "A.ASSET_CLASS_CODE,DECODE(LENGTH(A.ASSET_CLASS_CODE), "
					+ "3,NULL,SUBSTR(A.ASSET_CLASS_CODE,0,LENGTH(A.ASSET_CLASS_CODE)-3)) "
					+ "PARENT_CLASS_CODE,A.VOLTAGE_LEVEL, "
					+ "A.DISCARD_PROJECT01_ORIGIN_VAL ,A.DISCARD_PROJECT02_ORIGIN_VAL , "
					+ "A.DISCARD_PROJECT03_ORIGIN_VAL ,A.DISCARD_PROJECT04_ORIGIN_VAL , "
					+ "A.DISCARD_PROJECT05_ORIGIN_VAL ,A.DISCARD_PROJECT01_NET_VAL    , "
					+ "A.DISCARD_PROJECT02_NET_VAL    ,A.DISCARD_PROJECT03_NET_VAL    , "
					+ "A.DISCARD_PROJECT04_NET_VAL    ,A.DISCARD_PROJECT05_NET_VAL    , "
					+ "A.DISCARD_PROJECT01_AMOUNT     ,A.DISCARD_PROJECT02_AMOUNT     , "
					+ "A.DISCARD_PROJECT03_AMOUNT     ,A.DISCARD_PROJECT04_AMOUNT     , "
					+ "A.DISCARD_PROJECT05_AMOUNT     ,A.DISCARD_PROJECT01_CAPACITY   , "
					+ "A.DISCARD_PROJECT02_CAPACITY   ,A.DISCARD_PROJECT03_CAPACITY   , "
					+ "A.DISCARD_PROJECT04_CAPACITY   ,A.DISCARD_PROJECT05_CAPACITY      "
					+ "FROM RESULT_TEMP_TAB A ),ORIG_TEMP AS(SELECT  "
					+ "B.CATEGORY,B.ASSET_CLASS_CODE  ,'001' INDICATE_DIMENSION,B.VOLTAGE_LEVEL,  "
					+ "SUM(A.DISCARD_PROJECT01_ORIGIN_VAL )DISCARD_PROJECT01_ORIGIN_VAL, "
					+ "SUM(A.DISCARD_PROJECT02_ORIGIN_VAL )DISCARD_PROJECT02_ORIGIN_VAL, "
					+ "SUM(A.DISCARD_PROJECT03_ORIGIN_VAL )DISCARD_PROJECT03_ORIGIN_VAL, "
					+ "SUM(A.DISCARD_PROJECT04_ORIGIN_VAL +A.DISCARD_PROJECT05_ORIGIN_VAL )DISCARD_PROJECT04_ORIGIN_VAL  "
					+ "FROM LEVEL_TEMP_TAB A , LEVEL_TEMP_TAB B WHERE A.ASSET_CLASS_CODE IN  "
					+ "(SELECT E.ASSET_CLASS_CODE FROM LEVEL_TEMP_TAB E  "
					+ "START WITH E.ASSET_CLASS_CODE=B.ASSET_CLASS_CODE "
					+ "CONNECT BY E.PARENT_CLASS_CODE=PRIOR E.ASSET_CLASS_CODE "
					+ ")GROUP BY B.CATEGORY,B.ASSET_CLASS_CODE, "
					+ "B.VOLTAGE_LEVEL ORDER BY 2),NET_VAL_TEMP AS(SELECT  "
					+ "B.CATEGORY,B.ASSET_CLASS_CODE ,'002' INDICATE_DIMENSION,B.VOLTAGE_LEVEL,   "
					+ "SUM(A.DISCARD_PROJECT01_NET_VAL    )DISCARD_PROJECT01_NET_VAL   , "
					+ "SUM(A.DISCARD_PROJECT02_NET_VAL    )DISCARD_PROJECT02_NET_VAL   , "
					+ "SUM(A.DISCARD_PROJECT03_NET_VAL    )DISCARD_PROJECT03_NET_VAL   , "
					+ "SUM(A.DISCARD_PROJECT04_NET_VAL    +A.DISCARD_PROJECT05_NET_VAL    )DISCARD_PROJECT04_NET_VAL    "
					+ "FROM LEVEL_TEMP_TAB A , LEVEL_TEMP_TAB B WHERE A.ASSET_CLASS_CODE IN  "
					+ "(SELECT E.ASSET_CLASS_CODE FROM LEVEL_TEMP_TAB E  "
					+ "START WITH E.ASSET_CLASS_CODE=B.ASSET_CLASS_CODE "
					+ "CONNECT BY E.PARENT_CLASS_CODE=PRIOR E.ASSET_CLASS_CODE "
					+ ")GROUP BY B.CATEGORY,B.ASSET_CLASS_CODE, " + "B.VOLTAGE_LEVEL ORDER BY 2),CAPACITY_VAL_TEMP AS( "
					+ "SELECT B.CATEGORY,B.ASSET_CLASS_CODE ,'003' INDICATE_DIMENSION, " + "B.VOLTAGE_LEVEL,   "
					+ "SUM(A.DISCARD_PROJECT01_AMOUNT      )DISCARD_PROJECT01_AMOUNT    , "
					+ "SUM(A.DISCARD_PROJECT02_AMOUNT      )DISCARD_PROJECT02_AMOUNT     , "
					+ "SUM(A.DISCARD_PROJECT03_AMOUNT      )DISCARD_PROJECT03_AMOUNT     , "
					+ "SUM(A.DISCARD_PROJECT04_AMOUNT      +A.DISCARD_PROJECT05_AMOUNT)DISCARD_PROJECT04_AMOUNT  "
					+ "FROM LEVEL_TEMP_TAB A , LEVEL_TEMP_TAB B WHERE A.ASSET_CLASS_CODE IN  "
					+ "(SELECT E.ASSET_CLASS_CODE FROM LEVEL_TEMP_TAB E  "
					+ "START WITH E.ASSET_CLASS_CODE=B.ASSET_CLASS_CODE "
					+ "CONNECT BY E.PARENT_CLASS_CODE=PRIOR E.ASSET_CLASS_CODE) "
					+ "GROUP BY B.CATEGORY,B.ASSET_CLASS_CODE,B.VOLTAGE_LEVEL ORDER BY 2) SELECT "
					+ "CATEGORY,ASSET_CLASS_CODE,INDICATE_DIMENSION,VOLTAGE_LEVEL, "
					+ "A.DISCARD_PROJECT01_ORIGIN_VAL  DISCARD_PROJECT01 , "
					+ "A.DISCARD_PROJECT02_ORIGIN_VAL  DISCARD_PROJECT02 , "
					+ "A.DISCARD_PROJECT03_ORIGIN_VAL  DISCARD_PROJECT03 , "
					+ "A.DISCARD_PROJECT04_ORIGIN_VAL  DISCARD_PROJECT04    " + "FROM ORIG_TEMP A UNION ALL SELECT  "
					+ "CATEGORY,ASSET_CLASS_CODE,INDICATE_DIMENSION,VOLTAGE_LEVEL, "
					+ "A.DISCARD_PROJECT01_NET_VAL   DISCARD_PROJECT01, "
					+ "A.DISCARD_PROJECT02_NET_VAL   DISCARD_PROJECT02, "
					+ "A.DISCARD_PROJECT03_NET_VAL   DISCARD_PROJECT03, "
					+ "A.DISCARD_PROJECT04_NET_VAL   DISCARD_PROJECT04  " + "FROM NET_VAL_TEMP A UNION ALL SELECT  "
					+ "CATEGORY,ASSET_CLASS_CODE,INDICATE_DIMENSION,VOLTAGE_LEVEL, "
					+ "A.DISCARD_PROJECT01_AMOUNT   DISCARD_PROJECT01, "
					+ "A.DISCARD_PROJECT02_AMOUNT   DISCARD_PROJECT02, "
					+ "A.DISCARD_PROJECT03_AMOUNT  DISCARD_PROJECT03, "
					+ "A.DISCARD_PROJECT04_AMOUNT   DISCARD_PROJECT04  " + "FROM CAPACITY_VAL_TEMP  A ORDER BY 2,3 ";

			try {
				new ReportOutput2().writeXLSXDiscard(reportSQL, templateFilePathAndName, targetFilePathAndName,
						reportName, voltageRelationCode, dataVersion, areaName, sheetName, startRowNumber,
						startColumnNumber);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			sheetName = "A.5.6 报废资产年龄结构（数量）";
			reportName = "A.5.6 报废资产年龄结构（数量）";
			System.out.println(sheetName + " Start!");

			// dataVersion = "M_2019_2";
			dataVersion = "M_2019_3";// 20200612--PMS
			// dataVersion = "M_2019_8";//20200613--ERP // 循环输出表格中的内容,首先循环取出行,再根据行循环取出列
			startRowNumber = 5;
			startColumnNumber = 2;
			reportSQL = "WITH STRUCTRUE_TEMP_TAB AS ( SELECT A.ASSET_CLASS_NAME, "
					+ "A.ASSET_CLASS_CODE,B.VOLTAGE_NAME,B.INDEXOF FROM DV_ASSET_CLASS A "
					+ "LEFT JOIN (SELECT  C.VOLTAGE_NAME,B.DV_ASSET_CLASS_ID,B.INDEXOF   "
					+ "FROM DV_VOLTAGE_RELATION B  INNER JOIN DV_VOLTAGE_LEVEL C ON  "
					+ "B.DV_VOLTAGE_LEVEL_ID=C.DV_VOLTAGE_LEVEL_ID WHERE B.VOLTAGE_RELATION_CODE=? " + // 1
					")B ON A.DV_ASSET_CLASS_ID=B.DV_ASSET_CLASS_ID ORDER BY  " + "A.ASSET_CLASS_CODE ,B.INDEXOF ), "
					+ "SPAN_STRUCTURE_TAB AS (SELECT  "
					+ "A.ASSET_CLASS_NAME,DECODE(A.VOLTAGE_NAME,NULL,A.ASSET_CLASS_CODE, "
					+ "DECODE(LENGTH(TO_CHAR(A.INDEXOF)),1,A.ASSET_CLASS_CODE||'10'||A.INDEXOF, "
					+ "2,A.ASSET_CLASS_CODE||'1'||A.INDEXOF)) STRUCTURE_CODE, "
					+ "A.ASSET_CLASS_CODE,VOLTAGE_NAME,INDEXOF FROM STRUCTRUE_TEMP_TAB A   "
					+ "ORDER BY STRUCTURE_CODE,INDEXOF ),STRUCT_TEMP_RESULT AS ( "
					+ "SELECT A.ASSET_CLASS_NAME, A.ASSET_CLASS_CODE,B.VOLTAGE_NAME,B.INDEXOF   "
					+ "FROM DV_ASSET_CLASS A LEFT JOIN SPAN_STRUCTURE_TAB B  "
					+ "ON A.ASSET_CLASS_CODE=B.STRUCTURE_CODE UNION ALL SELECT  "
					+ "B.ASSET_CLASS_NAME,B.STRUCTURE_CODE ASSET_CLASS_CODE, "
					+ "B.VOLTAGE_NAME,B.INDEXOF FROM SPAN_STRUCTURE_TAB B  "
					+ "ORDER BY ASSET_CLASS_CODE,INDEXOF ),RESULT_TEMP_TAB AS ( "
					+ "SELECT A.ASSET_CLASS_NAME CATEGORY,A.ASSET_CLASS_CODE, " + "A.VOLTAGE_NAME VOLTAGE_LEVEL, "
					+ "DECODE(B.AGE1_AMOUNT_VAL  ,NULL,0,B.AGE1_AMOUNT_VAL  )AGE1_AMOUNT_VAL     ,  "
					+ "DECODE(B.AGE2_AMOUNT_VAL  ,NULL,0,B.AGE2_AMOUNT_VAL  )AGE2_AMOUNT_VAL     , "
					+ "DECODE(B.AGE3_AMOUNT_VAL  ,NULL,0,B.AGE3_AMOUNT_VAL  )AGE3_AMOUNT_VAL     , "
					+ "DECODE(B.AGE4_AMOUNT_VAL  ,NULL,0,B.AGE4_AMOUNT_VAL  )AGE4_AMOUNT_VAL     , "
					+ "DECODE(B.AGE5_AMOUNT_VAL  ,NULL,0,B.AGE5_AMOUNT_VAL  )AGE5_AMOUNT_VAL     , "
					+ "DECODE(B.AGE6_AMOUNT_VAL  ,NULL,0,B.AGE6_AMOUNT_VAL  )AGE6_AMOUNT_VAL     , "
					+ "DECODE(B.AGE7_AMOUNT_VAL  ,NULL,0,B.AGE7_AMOUNT_VAL  )AGE7_AMOUNT_VAL     , "
					+ "DECODE(B.AGE8_AMOUNT_VAL  ,NULL,0,B.AGE8_AMOUNT_VAL  )AGE8_AMOUNT_VAL     , "
					+ "DECODE(B.AGE9_AMOUNT_VAL  ,NULL,0,B.AGE9_AMOUNT_VAL  )AGE9_AMOUNT_VAL     , "
					+ "DECODE(B.AGE10_AMOUNT_VAL ,NULL,0,B.AGE10_AMOUNT_VAL )AGE10_AMOUNT_VAL    , "
					+ "DECODE(B.AGE11_AMOUNT_VAL ,NULL,0,B.AGE11_AMOUNT_VAL )AGE11_AMOUNT_VAL    , "
					+ "DECODE(B.AGE12_AMOUNT_VAL ,NULL,0,B.AGE12_AMOUNT_VAL )AGE12_AMOUNT_VAL    , "
					+ "DECODE(B.AGE13_AMOUNT_VAL ,NULL,0,B.AGE13_AMOUNT_VAL )AGE13_AMOUNT_VAL    , "
					+ "DECODE(B.AGE14_AMOUNT_VAL ,NULL,0,B.AGE14_AMOUNT_VAL )AGE14_AMOUNT_VAL    , "
					+ "DECODE(B.AGE15_AMOUNT_VAL ,NULL,0,B.AGE15_AMOUNT_VAL )AGE15_AMOUNT_VAL    , "
					+ "DECODE(B.AGE16_AMOUNT_VAL ,NULL,0,B.AGE16_AMOUNT_VAL )AGE16_AMOUNT_VAL    , "
					+ "DECODE(B.AGE17_AMOUNT_VAL ,NULL,0,B.AGE17_AMOUNT_VAL )AGE17_AMOUNT_VAL    , "
					+ "DECODE(B.AGE18_AMOUNT_VAL ,NULL,0,B.AGE18_AMOUNT_VAL )AGE18_AMOUNT_VAL    , "
					+ "DECODE(B.AGE19_AMOUNT_VAL ,NULL,0,B.AGE19_AMOUNT_VAL )AGE19_AMOUNT_VAL    , "
					+ "DECODE(B.AGE20_AMOUNT_VAL ,NULL,0,B.AGE20_AMOUNT_VAL )AGE20_AMOUNT_VAL    , "
					+ "DECODE(B.AGE21_AMOUNT_VAL ,NULL,0,B.AGE21_AMOUNT_VAL )AGE21_AMOUNT_VAL    , "
					+ "DECODE(B.AGE22_AMOUNT_VAL ,NULL,0,B.AGE22_AMOUNT_VAL )AGE22_AMOUNT_VAL    , "
					+ "DECODE(B.AGE23_AMOUNT_VAL ,NULL,0,B.AGE23_AMOUNT_VAL )AGE23_AMOUNT_VAL    , "
					+ "DECODE(B.AGE24_AMOUNT_VAL ,NULL,0,B.AGE24_AMOUNT_VAL )AGE24_AMOUNT_VAL    , "
					+ "DECODE(B.AGE25_AMOUNT_VAL ,NULL,0,B.AGE25_AMOUNT_VAL )AGE25_AMOUNT_VAL    , "
					+ "DECODE(B.AGE26_AMOUNT_VAL ,NULL,0,B.AGE26_AMOUNT_VAL )AGE26_AMOUNT_VAL    , "
					+ "DECODE(B.AGE27_AMOUNT_VAL ,NULL,0,B.AGE27_AMOUNT_VAL )AGE27_AMOUNT_VAL    , "
					+ "DECODE(B.AGE28_AMOUNT_VAL ,NULL,0,B.AGE28_AMOUNT_VAL )AGE28_AMOUNT_VAL    , "
					+ "DECODE(B.AGE29_AMOUNT_VAL ,NULL,0,B.AGE29_AMOUNT_VAL )AGE29_AMOUNT_VAL    , "
					+ "DECODE(B.AGE30_AMOUNT_VAL ,NULL,0,B.AGE30_AMOUNT_VAL )AGE30_AMOUNT_VAL    , "
					+ "DECODE(B.AGE31_AMOUNT_VAL ,NULL,0,B.AGE31_AMOUNT_VAL )AGE31_AMOUNT_VAL      "
					+ "FROM (SELECT  DISTINCT  * FROM STRUCT_TEMP_RESULT )A LEFT JOIN  "
					+ "(SELECT EXTRACT(YEAR FROM A.DV_DATE_VALUE) CAL_YEAR, "
					+ "A.CATEGORY,A.VOLTAGE_LEVEL,SUM(A.AGE1_AMOUNT_VAL  )AGE1_AMOUNT_VAL    ,  "
					+ "SUM(A.AGE2_AMOUNT_VAL  )AGE2_AMOUNT_VAL    ,SUM(A.AGE3_AMOUNT_VAL  )AGE3_AMOUNT_VAL    , "
					+ "SUM(A.AGE4_AMOUNT_VAL  )AGE4_AMOUNT_VAL    ,SUM(A.AGE5_AMOUNT_VAL  )AGE5_AMOUNT_VAL    , "
					+ "SUM(A.AGE6_AMOUNT_VAL  )AGE6_AMOUNT_VAL    ,SUM(A.AGE7_AMOUNT_VAL  )AGE7_AMOUNT_VAL    , "
					+ "SUM(A.AGE8_AMOUNT_VAL  )AGE8_AMOUNT_VAL    ,SUM(A.AGE9_AMOUNT_VAL  )AGE9_AMOUNT_VAL    , "
					+ "SUM(A.AGE10_AMOUNT_VAL )AGE10_AMOUNT_VAL   ,SUM(A.AGE11_AMOUNT_VAL )AGE11_AMOUNT_VAL   , "
					+ "SUM(A.AGE12_AMOUNT_VAL )AGE12_AMOUNT_VAL   ,SUM(A.AGE13_AMOUNT_VAL )AGE13_AMOUNT_VAL   , "
					+ "SUM(A.AGE14_AMOUNT_VAL )AGE14_AMOUNT_VAL   ,SUM(A.AGE15_AMOUNT_VAL )AGE15_AMOUNT_VAL   , "
					+ "SUM(A.AGE16_AMOUNT_VAL )AGE16_AMOUNT_VAL   ,SUM(A.AGE17_AMOUNT_VAL )AGE17_AMOUNT_VAL   , "
					+ "SUM(A.AGE18_AMOUNT_VAL )AGE18_AMOUNT_VAL   ,SUM(A.AGE19_AMOUNT_VAL )AGE19_AMOUNT_VAL   , "
					+ "SUM(A.AGE20_AMOUNT_VAL )AGE20_AMOUNT_VAL   ,SUM(A.AGE21_AMOUNT_VAL )AGE21_AMOUNT_VAL   , "
					+ "SUM(A.AGE22_AMOUNT_VAL )AGE22_AMOUNT_VAL   ,SUM(A.AGE23_AMOUNT_VAL )AGE23_AMOUNT_VAL   , "
					+ "SUM(A.AGE24_AMOUNT_VAL )AGE24_AMOUNT_VAL   ,SUM(A.AGE25_AMOUNT_VAL )AGE25_AMOUNT_VAL   , "
					+ "SUM(A.AGE26_AMOUNT_VAL )AGE26_AMOUNT_VAL   ,SUM(A.AGE27_AMOUNT_VAL )AGE27_AMOUNT_VAL   , "
					+ "SUM(A.AGE28_AMOUNT_VAL )AGE28_AMOUNT_VAL   ,SUM(A.AGE29_AMOUNT_VAL )AGE29_AMOUNT_VAL   , "
					+ "SUM(A.AGE30_AMOUNT_VAL )AGE30_AMOUNT_VAL   ,SUM(A.AGE31_AMOUNT_VAL )AGE31_AMOUNT_VAL    "
					+ "FROM  (SELECT E.ORG_ALIAS_NAME,F.AREA_NAME FROM DV_ORG_ALIAS E  "
					+ "INNER JOIN DV_ORG F ON E.DV_ORG_ID=F.DV_ORG_ID AND  "
					+ "F.AREA_NAME IN ( SELECT A.AREA_NAME FROM DV_AREA A WHERE   "
					+ "EXISTS (SELECT 1 FROM DV_AREA B WHERE (DECODE( B.IS_LEAF,0, 1,0	)=1  "
					+ "AND B.AREA_NAME=? AND (SUBSTR(A.AREA_CODE,0,LENGTH(A.AREA_CODE)-3)=B.AREA_CODE " + // 2
					"OR (A.IS_LEAF=0 AND B.AREA_CODE=A.AREA_CODE )))OR (DECODE( B.IS_LEAF,0, 1,0	)=0  "
					+ "AND B.AREA_NAME=? AND A.AREA_CODE=B.AREA_CODE)) )) F INNER JOIN  " + // 3
					" MID_ASSET_DISCARD  A ON A.ORG_NAME=F.ORG_ALIAS_NAME  "
					+ "WHERE DATA_VERSION=?  GROUP BY EXTRACT(YEAR FROM A.DV_DATE_VALUE), " + // 4
					"A.CATEGORY,A.VOLTAGE_LEVEL ) B ON(A.ASSET_CLASS_NAME=B.CATEGORY "
					+ "AND DECODE(A.VOLTAGE_NAME,NULL,'BLANK',A.VOLTAGE_NAME)= "
					+ "DECODE(B.VOLTAGE_LEVEL,NULL,'BLANK',B.VOLTAGE_LEVEL)) "
					+ "ORDER BY ASSET_CLASS_CODE,INDEXOF ),LEVEL_TEMP_TAB AS ( "
					+ "SELECT  A.CATEGORY,A.ASSET_CLASS_CODE,DECODE(LENGTH(A.ASSET_CLASS_CODE), "
					+ "3,NULL,SUBSTR(A.ASSET_CLASS_CODE,0,LENGTH(A.ASSET_CLASS_CODE)-3)) "
					+ "PARENT_CLASS_CODE,A.VOLTAGE_LEVEL,A.AGE1_AMOUNT_VAL  , A.AGE2_AMOUNT_VAL  , "
					+ "A.AGE3_AMOUNT_VAL  ,A.AGE4_AMOUNT_VAL  ,A.AGE5_AMOUNT_VAL  ,A.AGE6_AMOUNT_VAL  , "
					+ "A.AGE7_AMOUNT_VAL  ,A.AGE8_AMOUNT_VAL  ,A.AGE9_AMOUNT_VAL  ,A.AGE10_AMOUNT_VAL , "
					+ "A.AGE11_AMOUNT_VAL ,A.AGE12_AMOUNT_VAL ,A.AGE13_AMOUNT_VAL ,A.AGE14_AMOUNT_VAL , "
					+ "A.AGE15_AMOUNT_VAL ,A.AGE16_AMOUNT_VAL ,A.AGE17_AMOUNT_VAL ,A.AGE18_AMOUNT_VAL , "
					+ "A.AGE19_AMOUNT_VAL ,A.AGE20_AMOUNT_VAL ,A.AGE21_AMOUNT_VAL ,A.AGE22_AMOUNT_VAL , "
					+ "A.AGE23_AMOUNT_VAL ,A.AGE24_AMOUNT_VAL ,A.AGE25_AMOUNT_VAL ,A.AGE26_AMOUNT_VAL , "
					+ "A.AGE27_AMOUNT_VAL ,A.AGE28_AMOUNT_VAL ,A.AGE29_AMOUNT_VAL ,A.AGE30_AMOUNT_VAL , "
					+ "A.AGE31_AMOUNT_VAL  FROM RESULT_TEMP_TAB A ) "
					+ "SELECT B.CATEGORY,B.ASSET_CLASS_CODE,B.VOLTAGE_LEVEL, "
					+ "SUM(A.AGE1_AMOUNT_VAL  )AGE1_AMOUNT_VAL    , SUM(A.AGE2_AMOUNT_VAL  )AGE2_AMOUNT_VAL    , "
					+ "SUM(A.AGE3_AMOUNT_VAL  )AGE3_AMOUNT_VAL    ,SUM(A.AGE4_AMOUNT_VAL  )AGE4_AMOUNT_VAL    , "
					+ "SUM(A.AGE5_AMOUNT_VAL  )AGE5_AMOUNT_VAL    ,SUM(A.AGE6_AMOUNT_VAL  )AGE6_AMOUNT_VAL    , "
					+ "SUM(A.AGE7_AMOUNT_VAL  )AGE7_AMOUNT_VAL    ,SUM(A.AGE8_AMOUNT_VAL  )AGE8_AMOUNT_VAL    , "
					+ "SUM(A.AGE9_AMOUNT_VAL  )AGE9_AMOUNT_VAL    ,SUM(A.AGE10_AMOUNT_VAL )AGE10_AMOUNT_VAL   , "
					+ "SUM(A.AGE11_AMOUNT_VAL )AGE11_AMOUNT_VAL   ,SUM(A.AGE12_AMOUNT_VAL )AGE12_AMOUNT_VAL   , "
					+ "SUM(A.AGE13_AMOUNT_VAL )AGE13_AMOUNT_VAL   ,SUM(A.AGE14_AMOUNT_VAL )AGE14_AMOUNT_VAL   , "
					+ "SUM(A.AGE15_AMOUNT_VAL )AGE15_AMOUNT_VAL   ,SUM(A.AGE16_AMOUNT_VAL )AGE16_AMOUNT_VAL   , "
					+ "SUM(A.AGE17_AMOUNT_VAL )AGE17_AMOUNT_VAL   ,SUM(A.AGE18_AMOUNT_VAL )AGE18_AMOUNT_VAL   , "
					+ "SUM(A.AGE19_AMOUNT_VAL )AGE19_AMOUNT_VAL   ,SUM(A.AGE20_AMOUNT_VAL )AGE20_AMOUNT_VAL   , "
					+ "SUM(A.AGE21_AMOUNT_VAL )AGE21_AMOUNT_VAL   ,SUM(A.AGE22_AMOUNT_VAL )AGE22_AMOUNT_VAL   , "
					+ "SUM(A.AGE23_AMOUNT_VAL )AGE23_AMOUNT_VAL   ,SUM(A.AGE24_AMOUNT_VAL )AGE24_AMOUNT_VAL   , "
					+ "SUM(A.AGE25_AMOUNT_VAL )AGE25_AMOUNT_VAL   ,SUM(A.AGE26_AMOUNT_VAL )AGE26_AMOUNT_VAL   , "
					+ "SUM(A.AGE27_AMOUNT_VAL )AGE27_AMOUNT_VAL   ,SUM(A.AGE28_AMOUNT_VAL )AGE28_AMOUNT_VAL   , "
					+ "SUM(A.AGE29_AMOUNT_VAL )AGE29_AMOUNT_VAL   ,SUM(A.AGE30_AMOUNT_VAL )AGE30_AMOUNT_VAL   , "
					+ "SUM(A.AGE31_AMOUNT_VAL )AGE31_AMOUNT_VAL   FROM LEVEL_TEMP_TAB A , LEVEL_TEMP_TAB B   "
					+ "WHERE A.ASSET_CLASS_CODE IN (SELECT E.ASSET_CLASS_CODE  "
					+ "FROM LEVEL_TEMP_TAB E START WITH E.ASSET_CLASS_CODE=B.ASSET_CLASS_CODE "
					+ "CONNECT BY E.PARENT_CLASS_CODE=PRIOR E.ASSET_CLASS_CODE) "
					+ "GROUP BY B.CATEGORY,B.ASSET_CLASS_CODE,B.VOLTAGE_LEVEL  ORDER BY ASSET_CLASS_CODE ";

			try {
				new ReportOutput2().writeXLSXAutoMatic(reportSQL, templateFilePathAndName, targetFilePathAndName,
						reportName, voltageRelationCode, dataVersion, areaName, sheetName, startRowNumber,
						startColumnNumber);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			sheetName = "A.5.6 报废资产年龄结构（规模）";
			reportName = "A.5.6 报废资产年龄结构（规模） ";
			System.out.println(sheetName + " Start!");

			// dataVersion = "M_2019_2";
			dataVersion = "M_2019_3";// 20200612--PMS
			// dataVersion = "M_2019_8";//20200613--ERP // 循环输出表格中的内容,首先循环取出行,再根据行循环取出列
			startRowNumber = 5;
			startColumnNumber = 2;
			reportSQL = "WITH STRUCTRUE_TEMP_TAB AS ( SELECT A.ASSET_CLASS_NAME, "
					+ "A.ASSET_CLASS_CODE,B.VOLTAGE_NAME,B.INDEXOF FROM DV_ASSET_CLASS A "
					+ "LEFT JOIN (SELECT  C.VOLTAGE_NAME,B.DV_ASSET_CLASS_ID,B.INDEXOF   "
					+ "FROM DV_VOLTAGE_RELATION B  INNER JOIN DV_VOLTAGE_LEVEL C ON  "
					+ "B.DV_VOLTAGE_LEVEL_ID=C.DV_VOLTAGE_LEVEL_ID WHERE B.VOLTAGE_RELATION_CODE=? " + // 1
					")B ON A.DV_ASSET_CLASS_ID=B.DV_ASSET_CLASS_ID ORDER BY  " + "A.ASSET_CLASS_CODE ,B.INDEXOF ), "
					+ "SPAN_STRUCTURE_TAB AS (SELECT  "
					+ "A.ASSET_CLASS_NAME,DECODE(A.VOLTAGE_NAME,NULL,A.ASSET_CLASS_CODE, "
					+ "DECODE(LENGTH(TO_CHAR(A.INDEXOF)),1,A.ASSET_CLASS_CODE||'10'||A.INDEXOF, "
					+ "2,A.ASSET_CLASS_CODE||'1'||A.INDEXOF)) STRUCTURE_CODE, "
					+ "A.ASSET_CLASS_CODE,VOLTAGE_NAME,INDEXOF FROM STRUCTRUE_TEMP_TAB A   "
					+ "ORDER BY STRUCTURE_CODE,INDEXOF ),STRUCT_TEMP_RESULT AS ( "
					+ "SELECT A.ASSET_CLASS_NAME, A.ASSET_CLASS_CODE,B.VOLTAGE_NAME,B.INDEXOF   "
					+ "FROM DV_ASSET_CLASS A LEFT JOIN SPAN_STRUCTURE_TAB B  "
					+ "ON A.ASSET_CLASS_CODE=B.STRUCTURE_CODE UNION ALL SELECT  "
					+ "B.ASSET_CLASS_NAME,B.STRUCTURE_CODE ASSET_CLASS_CODE, "
					+ "B.VOLTAGE_NAME,B.INDEXOF FROM SPAN_STRUCTURE_TAB B  "
					+ "ORDER BY ASSET_CLASS_CODE,INDEXOF ),RESULT_TEMP_TAB AS ( "
					+ "SELECT A.ASSET_CLASS_NAME CATEGORY,A.ASSET_CLASS_CODE, " + "A.VOLTAGE_NAME VOLTAGE_LEVEL, "
					+ "DECODE(B.AGE1_CAPACITY_VAL  ,NULL,0,B.AGE1_CAPACITY_VAL  )AGE1_CAPACITY_VAL     ,  "
					+ "DECODE(B.AGE2_CAPACITY_VAL  ,NULL,0,B.AGE2_CAPACITY_VAL  )AGE2_CAPACITY_VAL     , "
					+ "DECODE(B.AGE3_CAPACITY_VAL  ,NULL,0,B.AGE3_CAPACITY_VAL  )AGE3_CAPACITY_VAL     , "
					+ "DECODE(B.AGE4_CAPACITY_VAL  ,NULL,0,B.AGE4_CAPACITY_VAL  )AGE4_CAPACITY_VAL     , "
					+ "DECODE(B.AGE5_CAPACITY_VAL  ,NULL,0,B.AGE5_CAPACITY_VAL  )AGE5_CAPACITY_VAL     , "
					+ "DECODE(B.AGE6_CAPACITY_VAL  ,NULL,0,B.AGE6_CAPACITY_VAL  )AGE6_CAPACITY_VAL     , "
					+ "DECODE(B.AGE7_CAPACITY_VAL  ,NULL,0,B.AGE7_CAPACITY_VAL  )AGE7_CAPACITY_VAL     , "
					+ "DECODE(B.AGE8_CAPACITY_VAL  ,NULL,0,B.AGE8_CAPACITY_VAL  )AGE8_CAPACITY_VAL     , "
					+ "DECODE(B.AGE9_CAPACITY_VAL  ,NULL,0,B.AGE9_CAPACITY_VAL  )AGE9_CAPACITY_VAL     , "
					+ "DECODE(B.AGE10_CAPACITY_VAL ,NULL,0,B.AGE10_CAPACITY_VAL )AGE10_CAPACITY_VAL    , "
					+ "DECODE(B.AGE11_CAPACITY_VAL ,NULL,0,B.AGE11_CAPACITY_VAL )AGE11_CAPACITY_VAL    , "
					+ "DECODE(B.AGE12_CAPACITY_VAL ,NULL,0,B.AGE12_CAPACITY_VAL )AGE12_CAPACITY_VAL    , "
					+ "DECODE(B.AGE13_CAPACITY_VAL ,NULL,0,B.AGE13_CAPACITY_VAL )AGE13_CAPACITY_VAL    , "
					+ "DECODE(B.AGE14_CAPACITY_VAL ,NULL,0,B.AGE14_CAPACITY_VAL )AGE14_CAPACITY_VAL    , "
					+ "DECODE(B.AGE15_CAPACITY_VAL ,NULL,0,B.AGE15_CAPACITY_VAL )AGE15_CAPACITY_VAL    , "
					+ "DECODE(B.AGE16_CAPACITY_VAL ,NULL,0,B.AGE16_CAPACITY_VAL )AGE16_CAPACITY_VAL    , "
					+ "DECODE(B.AGE17_CAPACITY_VAL ,NULL,0,B.AGE17_CAPACITY_VAL )AGE17_CAPACITY_VAL    , "
					+ "DECODE(B.AGE18_CAPACITY_VAL ,NULL,0,B.AGE18_CAPACITY_VAL )AGE18_CAPACITY_VAL    , "
					+ "DECODE(B.AGE19_CAPACITY_VAL ,NULL,0,B.AGE19_CAPACITY_VAL )AGE19_CAPACITY_VAL    , "
					+ "DECODE(B.AGE20_CAPACITY_VAL ,NULL,0,B.AGE20_CAPACITY_VAL )AGE20_CAPACITY_VAL    , "
					+ "DECODE(B.AGE21_CAPACITY_VAL ,NULL,0,B.AGE21_CAPACITY_VAL )AGE21_CAPACITY_VAL    , "
					+ "DECODE(B.AGE22_CAPACITY_VAL ,NULL,0,B.AGE22_CAPACITY_VAL )AGE22_CAPACITY_VAL    , "
					+ "DECODE(B.AGE23_CAPACITY_VAL ,NULL,0,B.AGE23_CAPACITY_VAL )AGE23_CAPACITY_VAL    , "
					+ "DECODE(B.AGE24_CAPACITY_VAL ,NULL,0,B.AGE24_CAPACITY_VAL )AGE24_CAPACITY_VAL    , "
					+ "DECODE(B.AGE25_CAPACITY_VAL ,NULL,0,B.AGE25_CAPACITY_VAL )AGE25_CAPACITY_VAL    , "
					+ "DECODE(B.AGE26_CAPACITY_VAL ,NULL,0,B.AGE26_CAPACITY_VAL )AGE26_CAPACITY_VAL    , "
					+ "DECODE(B.AGE27_CAPACITY_VAL ,NULL,0,B.AGE27_CAPACITY_VAL )AGE27_CAPACITY_VAL    , "
					+ "DECODE(B.AGE28_CAPACITY_VAL ,NULL,0,B.AGE28_CAPACITY_VAL )AGE28_CAPACITY_VAL    , "
					+ "DECODE(B.AGE29_CAPACITY_VAL ,NULL,0,B.AGE29_CAPACITY_VAL )AGE29_CAPACITY_VAL    , "
					+ "DECODE(B.AGE30_CAPACITY_VAL ,NULL,0,B.AGE30_CAPACITY_VAL )AGE30_CAPACITY_VAL    , "
					+ "DECODE(B.AGE31_CAPACITY_VAL ,NULL,0,B.AGE31_CAPACITY_VAL )AGE31_CAPACITY_VAL      "
					+ "FROM (SELECT  DISTINCT  * FROM STRUCT_TEMP_RESULT )A LEFT JOIN  "
					+ "(SELECT EXTRACT(YEAR FROM A.DV_DATE_VALUE) CAL_YEAR, "
					+ "A.CATEGORY,A.VOLTAGE_LEVEL,SUM(A.AGE1_CAPACITY_VAL  )AGE1_CAPACITY_VAL    ,  "
					+ "SUM(A.AGE2_CAPACITY_VAL  )AGE2_CAPACITY_VAL    ,SUM(A.AGE3_CAPACITY_VAL  )AGE3_CAPACITY_VAL    , "
					+ "SUM(A.AGE4_CAPACITY_VAL  )AGE4_CAPACITY_VAL    ,SUM(A.AGE5_CAPACITY_VAL  )AGE5_CAPACITY_VAL    , "
					+ "SUM(A.AGE6_CAPACITY_VAL  )AGE6_CAPACITY_VAL    ,SUM(A.AGE7_CAPACITY_VAL  )AGE7_CAPACITY_VAL    , "
					+ "SUM(A.AGE8_CAPACITY_VAL  )AGE8_CAPACITY_VAL    ,SUM(A.AGE9_CAPACITY_VAL  )AGE9_CAPACITY_VAL    , "
					+ "SUM(A.AGE10_CAPACITY_VAL )AGE10_CAPACITY_VAL   ,SUM(A.AGE11_CAPACITY_VAL )AGE11_CAPACITY_VAL   , "
					+ "SUM(A.AGE12_CAPACITY_VAL )AGE12_CAPACITY_VAL   ,SUM(A.AGE13_CAPACITY_VAL )AGE13_CAPACITY_VAL   , "
					+ "SUM(A.AGE14_CAPACITY_VAL )AGE14_CAPACITY_VAL   ,SUM(A.AGE15_CAPACITY_VAL )AGE15_CAPACITY_VAL   , "
					+ "SUM(A.AGE16_CAPACITY_VAL )AGE16_CAPACITY_VAL   ,SUM(A.AGE17_CAPACITY_VAL )AGE17_CAPACITY_VAL   , "
					+ "SUM(A.AGE18_CAPACITY_VAL )AGE18_CAPACITY_VAL   ,SUM(A.AGE19_CAPACITY_VAL )AGE19_CAPACITY_VAL   , "
					+ "SUM(A.AGE20_CAPACITY_VAL )AGE20_CAPACITY_VAL   ,SUM(A.AGE21_CAPACITY_VAL )AGE21_CAPACITY_VAL   , "
					+ "SUM(A.AGE22_CAPACITY_VAL )AGE22_CAPACITY_VAL   ,SUM(A.AGE23_CAPACITY_VAL )AGE23_CAPACITY_VAL   , "
					+ "SUM(A.AGE24_CAPACITY_VAL )AGE24_CAPACITY_VAL   ,SUM(A.AGE25_CAPACITY_VAL )AGE25_CAPACITY_VAL   , "
					+ "SUM(A.AGE26_CAPACITY_VAL )AGE26_CAPACITY_VAL   ,SUM(A.AGE27_CAPACITY_VAL )AGE27_CAPACITY_VAL   , "
					+ "SUM(A.AGE28_CAPACITY_VAL )AGE28_CAPACITY_VAL   ,SUM(A.AGE29_CAPACITY_VAL )AGE29_CAPACITY_VAL   , "
					+ "SUM(A.AGE30_CAPACITY_VAL )AGE30_CAPACITY_VAL   ,SUM(A.AGE31_CAPACITY_VAL )AGE31_CAPACITY_VAL    "
					+ "FROM  (SELECT E.ORG_ALIAS_NAME,F.AREA_NAME FROM DV_ORG_ALIAS E  "
					+ "INNER JOIN DV_ORG F ON E.DV_ORG_ID=F.DV_ORG_ID AND  "
					+ "F.AREA_NAME IN ( SELECT A.AREA_NAME FROM DV_AREA A WHERE   "
					+ "EXISTS (SELECT 1 FROM DV_AREA B WHERE (DECODE( B.IS_LEAF,0, 1,0	)=1  "
					+ "AND B.AREA_NAME=? AND (SUBSTR(A.AREA_CODE,0,LENGTH(A.AREA_CODE)-3)=B.AREA_CODE " + // 2
					"OR (A.IS_LEAF=0 AND B.AREA_CODE=A.AREA_CODE )))OR (DECODE( B.IS_LEAF,0, 1,0	)=0  "
					+ "AND B.AREA_NAME=? AND A.AREA_CODE=B.AREA_CODE)) )) F INNER JOIN  " + // 3
					" MID_ASSET_DISCARD  A ON A.ORG_NAME=F.ORG_ALIAS_NAME  "
					+ "WHERE DATA_VERSION=?  GROUP BY EXTRACT(YEAR FROM A.DV_DATE_VALUE), " + // 4
					"A.CATEGORY,A.VOLTAGE_LEVEL ) B ON(A.ASSET_CLASS_NAME=B.CATEGORY "
					+ "AND DECODE(A.VOLTAGE_NAME,NULL,'BLANK',A.VOLTAGE_NAME)= "
					+ "DECODE(B.VOLTAGE_LEVEL,NULL,'BLANK',B.VOLTAGE_LEVEL)) "
					+ "ORDER BY ASSET_CLASS_CODE,INDEXOF ),LEVEL_TEMP_TAB AS ( "
					+ "SELECT  A.CATEGORY,A.ASSET_CLASS_CODE,DECODE(LENGTH(A.ASSET_CLASS_CODE), "
					+ "3,NULL,SUBSTR(A.ASSET_CLASS_CODE,0,LENGTH(A.ASSET_CLASS_CODE)-3)) "
					+ "PARENT_CLASS_CODE,A.VOLTAGE_LEVEL,A.AGE1_CAPACITY_VAL  , A.AGE2_CAPACITY_VAL  , "
					+ "A.AGE3_CAPACITY_VAL  ,A.AGE4_CAPACITY_VAL  ,A.AGE5_CAPACITY_VAL  ,A.AGE6_CAPACITY_VAL  , "
					+ "A.AGE7_CAPACITY_VAL  ,A.AGE8_CAPACITY_VAL  ,A.AGE9_CAPACITY_VAL  ,A.AGE10_CAPACITY_VAL , "
					+ "A.AGE11_CAPACITY_VAL ,A.AGE12_CAPACITY_VAL ,A.AGE13_CAPACITY_VAL ,A.AGE14_CAPACITY_VAL , "
					+ "A.AGE15_CAPACITY_VAL ,A.AGE16_CAPACITY_VAL ,A.AGE17_CAPACITY_VAL ,A.AGE18_CAPACITY_VAL , "
					+ "A.AGE19_CAPACITY_VAL ,A.AGE20_CAPACITY_VAL ,A.AGE21_CAPACITY_VAL ,A.AGE22_CAPACITY_VAL , "
					+ "A.AGE23_CAPACITY_VAL ,A.AGE24_CAPACITY_VAL ,A.AGE25_CAPACITY_VAL ,A.AGE26_CAPACITY_VAL , "
					+ "A.AGE27_CAPACITY_VAL ,A.AGE28_CAPACITY_VAL ,A.AGE29_CAPACITY_VAL ,A.AGE30_CAPACITY_VAL , "
					+ "A.AGE31_CAPACITY_VAL  FROM RESULT_TEMP_TAB A ) "
					+ "SELECT B.CATEGORY,B.ASSET_CLASS_CODE,B.VOLTAGE_LEVEL, "
					+ "SUM(A.AGE1_CAPACITY_VAL  )AGE1_CAPACITY_VAL    , SUM(A.AGE2_CAPACITY_VAL  )AGE2_CAPACITY_VAL    , "
					+ "SUM(A.AGE3_CAPACITY_VAL  )AGE3_CAPACITY_VAL    ,SUM(A.AGE4_CAPACITY_VAL  )AGE4_CAPACITY_VAL    , "
					+ "SUM(A.AGE5_CAPACITY_VAL  )AGE5_CAPACITY_VAL    ,SUM(A.AGE6_CAPACITY_VAL  )AGE6_CAPACITY_VAL    , "
					+ "SUM(A.AGE7_CAPACITY_VAL  )AGE7_CAPACITY_VAL    ,SUM(A.AGE8_CAPACITY_VAL  )AGE8_CAPACITY_VAL    , "
					+ "SUM(A.AGE9_CAPACITY_VAL  )AGE9_CAPACITY_VAL    ,SUM(A.AGE10_CAPACITY_VAL )AGE10_CAPACITY_VAL   , "
					+ "SUM(A.AGE11_CAPACITY_VAL )AGE11_CAPACITY_VAL   ,SUM(A.AGE12_CAPACITY_VAL )AGE12_CAPACITY_VAL   , "
					+ "SUM(A.AGE13_CAPACITY_VAL )AGE13_CAPACITY_VAL   ,SUM(A.AGE14_CAPACITY_VAL )AGE14_CAPACITY_VAL   , "
					+ "SUM(A.AGE15_CAPACITY_VAL )AGE15_CAPACITY_VAL   ,SUM(A.AGE16_CAPACITY_VAL )AGE16_CAPACITY_VAL   , "
					+ "SUM(A.AGE17_CAPACITY_VAL )AGE17_CAPACITY_VAL   ,SUM(A.AGE18_CAPACITY_VAL )AGE18_CAPACITY_VAL   , "
					+ "SUM(A.AGE19_CAPACITY_VAL )AGE19_CAPACITY_VAL   ,SUM(A.AGE20_CAPACITY_VAL )AGE20_CAPACITY_VAL   , "
					+ "SUM(A.AGE21_CAPACITY_VAL )AGE21_CAPACITY_VAL   ,SUM(A.AGE22_CAPACITY_VAL )AGE22_CAPACITY_VAL   , "
					+ "SUM(A.AGE23_CAPACITY_VAL )AGE23_CAPACITY_VAL   ,SUM(A.AGE24_CAPACITY_VAL )AGE24_CAPACITY_VAL   , "
					+ "SUM(A.AGE25_CAPACITY_VAL )AGE25_CAPACITY_VAL   ,SUM(A.AGE26_CAPACITY_VAL )AGE26_CAPACITY_VAL   , "
					+ "SUM(A.AGE27_CAPACITY_VAL )AGE27_CAPACITY_VAL   ,SUM(A.AGE28_CAPACITY_VAL )AGE28_CAPACITY_VAL   , "
					+ "SUM(A.AGE29_CAPACITY_VAL )AGE29_CAPACITY_VAL   ,SUM(A.AGE30_CAPACITY_VAL )AGE30_CAPACITY_VAL   , "
					+ "SUM(A.AGE31_CAPACITY_VAL )AGE31_CAPACITY_VAL   FROM LEVEL_TEMP_TAB A , LEVEL_TEMP_TAB B   "
					+ "WHERE A.ASSET_CLASS_CODE IN (SELECT E.ASSET_CLASS_CODE  "
					+ "FROM LEVEL_TEMP_TAB E START WITH E.ASSET_CLASS_CODE=B.ASSET_CLASS_CODE "
					+ "CONNECT BY E.PARENT_CLASS_CODE=PRIOR E.ASSET_CLASS_CODE) "
					+ "GROUP BY B.CATEGORY,B.ASSET_CLASS_CODE,B.VOLTAGE_LEVEL  " + "ORDER BY ASSET_CLASS_CODE ";

			try {
				new ReportOutput2().writeXLSXAutoMatic(reportSQL, templateFilePathAndName, targetFilePathAndName,
						reportName, voltageRelationCode, dataVersion, areaName, sheetName, startRowNumber,
						startColumnNumber);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
	

	public static String querySqlByReportTableName(String reportName) throws SQLException {
		Connection conn = null;
		conn = DbUtil.getConnection();
		// 创建预编译语句对象，一般都是用这个而不用Statement
		PreparedStatement pre = null;
		// 创建一个结果集对象
		ResultSet result = null;
		String areaNameSql = "SELECT REPORT_QUERY_SQL FROM REPORT_QUERY_SQL WHERE REPORT_TABLE_NAME=? ";
		System.out.println("areaNameSql="+areaNameSql);
		try {
			pre = conn.prepareStatement(areaNameSql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 pre.setString(1, reportName);
		try {
			result = pre.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 执行查询，注意括号中不需要再加参数 
		if(result.next())
		return result.getString("REPORT_QUERY_SQL");
		else 
			return "";
	}

	public static String querySqlByReportQuerySqlId(String reportQuerySqlId) throws SQLException {
		Connection conn = null;
		conn = DbUtil.getConnection();
		// 创建预编译语句对象，一般都是用这个而不用Statement
		PreparedStatement pre = null;
		// 创建一个结果集对象
		ResultSet result = null;
		String areaNameSql = "SELECT REPORT_QUERY_SQL FROM REPORT_QUERY_SQL WHERE REPORT_QUERY_SQL_ID=? ";
		System.out.println("areaNameSql="+areaNameSql);
		try {
			pre = conn.prepareStatement(areaNameSql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 pre.setString(1, reportQuerySqlId);
		try {
			result = pre.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 执行查询，注意括号中不需要再加参数 
		if(result.next())
		return result.getString("REPORT_QUERY_SQL");
		else 
			return "";
	}
	public static List<DvArea> allAreaNameQuery() {
		Connection conn = null;
		conn = DbUtil.getConnection();
		// 创建预编译语句对象，一般都是用这个而不用Statement
		PreparedStatement pre = null;
		// 创建一个结果集对象
		ResultSet result = null;
		String areaNameSql = "SELECT * FROM DV_AREA ORDER BY AREA_CODE";

		try {
			pre = conn.prepareStatement(areaNameSql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// pre.setString(1, reportName);
		try {
			result = pre.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 执行查询，注意括号中不需要再加参数

		List<DvArea> areaList = new ArrayList<DvArea>();
		try {
			while (result.next()) {
				DvArea area = new DvArea();
				area.setDvAreaId(result.getString("DV_AREA_ID"));
				area.setAreaName(result.getString("AREA_NAME"));
				area.setAreaCode(result.getString("AREA_CODE"));
				area.setIndexof(result.getShort("INDEXOF"));
				area.setDescription(result.getString("DESCRIPTION"));
				area.setWhetherEvaluation(result.getInt("WHETHER_EVALUATION"));

				areaList.add(area);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return areaList;
	}

	/*
	 * 此函数通过地区的树状结构，自动化统计省公司等根节点的指标
	 * 
	 */
	@Autowired
	public void writeXLSXAutoMatic(String reportSQL, String templateFilePathAndName, String targetFilePathAndName,
			String reportName, String voltageRelationCode, String dataVersion, String areaName, String sheetName,
			int startRowNumber, int startColumnNumber) throws SQLException, IOException {
		// System.out.println("areaName=" + areaName);
		Connection conn = null;
		conn = DbUtil.getConnection();

		List<ReportRowNode> reportRowNodeLIst = new ArrayList<ReportRowNode>();
		List<String> treeStructure = new ArrayList<String>();
		OutputStream out = null;
		try {
			// System.out.println("System.getProperty(\"user.dir\"):" +
			// System.getProperty("user.dir"));
			// System.out.println("finalXlsxPath:=" + finalXlsxPath);
			// File finalXlsxFile = new File(finalXlsxPath);// +"/"+nowdate+".xlsx");
			// System.out.println("finalXlsxFile.getName():" + finalXlsxFile.getName());

			// sheet 对应一个工作页
			// Sheet sheet = workBook.getSheetAt(0);
			// 创建预编译语句对象，一般都是用这个而不用Statement
			PreparedStatement pre = null;
			// 创建一个结果集对象
			ResultSet result = null;
			String columnSql = "SELECT * FROM REPORT_TABLE_FIELD_COLUMN A WHERE A.REPORT_NAME=TRIM(?)  ORDER BY REPORT_TABLE_FIELD_COLUMN_ID ";

			pre = conn.prepareStatement(columnSql);
			pre.setString(1, reportName);
			result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数

			List<ReportTableFieldColumn> reportTableFieldColumnList = new <ReportTableFieldColumn>ArrayList();
			int reportTableFieldColumnListI = 0;
			int treeNodeLength = 1;
			int indQuantity = 1;
			while (result.next()) {

				ReportTableFieldColumn reportTableFieldColumn = new ReportTableFieldColumn();
				reportTableFieldColumn.setReportTableFieldColumnId(result.getString("REPORT_TABLE_FIELD_COLUMN_ID"));
				reportTableFieldColumn.setReportId(result.getString("REPORT_ID"));
				reportTableFieldColumn.setReportName(result.getString("REPORT_NAME"));
				reportTableFieldColumn.setTableName(result.getString("TABLE_NAME"));
				reportTableFieldColumn.setFieldName(result.getString("FIELD_NAME"));
				reportTableFieldColumn.setIndexof(result.getDouble("INDEXOF"));
				reportTableFieldColumn.setFieldTitle(result.getString("FIELD_TITLE"));
				reportTableFieldColumn.setDimensionOrIndicate(result.getString("DIMENSION_OR_INDICATE"));
				reportTableFieldColumn.setDimensionOrIndicateType(result.getString("DIMENSION_OR_INDICATE_TYPE"));
				reportTableFieldColumn.setDiscription(result.getString("DISCRIPTION"));
				reportTableFieldColumnList.add(reportTableFieldColumnListI, reportTableFieldColumn);
				if (result.getString("DIMENSION_OR_INDICATE").contentEquals("TREE")) {
					treeNodeLength = new Integer(result.getString("DIMENSION_OR_INDICATE_TYPE"));
				}
				if (result.getString("DIMENSION_OR_INDICATE").contentEquals("IND")) {
					indQuantity++;
				}

				reportTableFieldColumnListI++;
			}

			System.out.println("treeNodeLength=" + treeNodeLength);
			// 预编译语句

			try {
				pre = conn.prepareStatement(reportSQL);
				pre.setString(1, voltageRelationCode);
				pre.setString(2, areaName);
				pre.setString(3, areaName);
				pre.setString(4, dataVersion);
				result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // 实例化预编译语句
				// 查询数据库中所有的数据
			int ReportTableFieldColumnListSize = reportTableFieldColumnList.size();
			// System.out.println("reportTableFieldColumnList.size()="+reportTableFieldColumnList.size());
			int maxTreeStructureCodeLength = 1;
			while (result.next()) {
				ReportRowNode reportRowNode = new ReportRowNode();
				Dimension dim = new Dimension();
				Dimension dim2 = new Dimension();
				dim.setDimensionType("CATEGORY");
				//
				System.out.println("CATEGORY=" + result.getString("CATEGORY"));
				//
				System.out.println("VOLTAGE_LEVEL=" + result.getString("VOLTAGE_LEVEL"));
				if (result.getString("ASSET_CLASS_CODE").length() > maxTreeStructureCodeLength) {
					maxTreeStructureCodeLength = result.getString("ASSET_CLASS_CODE").length();
				}
				if (result.getString("VOLTAGE_LEVEL") == null) {
					dim.setDimensionCode(result.getString("ASSET_CLASS_CODE"));

				} else {
					dim.setDimensionCode(result.getString("ASSET_CLASS_CODE").substring(0,
							result.getString("ASSET_CLASS_CODE").length() - 3));
				}
				dim.setDimensionName("CATEGORY");
				dim.setDimensionValue(result.getString("CATEGORY"));
				dim2.setDimensionType("VOLTAGE_LEVEL");
				dim2.setDimensionName("VOLTAGE_LEVEL");
				dim2.setDimensionValue(result.getString("VOLTAGE_LEVEL"));

				List<Dimension> dimList = new ArrayList<Dimension>();
				dimList.add(dim);
				dimList.add(dim2);
				reportRowNode.setDimensionList(dimList);
				List<IndicateNode> indicateList = new ArrayList<IndicateNode>();
				for (int indI = 0; indI < ReportTableFieldColumnListSize; indI++) {

					if (reportTableFieldColumnList.get(indI).getDimensionOrIndicate().contentEquals("IND")) {
						IndicateNode indicate = new IndicateNode();

						indicate.setIndicateName(reportTableFieldColumnList.get(indI).getFieldName());

						indicate.setIndicateIndexof(reportTableFieldColumnList.get(indI).getIndexof());

						System.out.println(reportTableFieldColumnList.get(indI).getIndexof());
						System.out.println(reportTableFieldColumnList.get(indI).getFieldName());
						System.out.println(reportTableFieldColumnList.get(indI).getFieldName());
						System.out.println("indicateList size=" + indicateList.size());
						indicate.setIndicateValue(
								new BigDecimal(result.getString(reportTableFieldColumnList.get(indI).getFieldName())));
						indicateList.add(indicate.getIndicateIndexof().intValue(), indicate);
					} else
						continue;

				}
				reportRowNode.setIndicateLsit(indicateList);
				reportRowNode.setTreeStructureCode(result.getString("ASSET_CLASS_CODE"));
				reportRowNode.setLeaf(true);
				treeStructure.add(result.getString("ASSET_CLASS_CODE"));
				reportRowNodeLIst.add(reportRowNode);

				/*
				 * for (int indI = 0; indI < reportTableFieldColumnListSize; indI++) {
				 * 
				 * if
				 * (reportTableFieldColumnList.get(indI).getDimensionOrIndicate().contentEquals(
				 * "IND")) { IndicateNode indicate = new IndicateNode();
				 * 
				 * indicate.setIndicateName(reportTableFieldColumnList.get(indI).getFieldName())
				 * ;
				 * 
				 * indicate.setIndicateIndexof(reportTableFieldColumnList.get(indI).getIndexof()
				 * );
				 * 
				 * System.out.println(reportTableFieldColumnList.get(indI).getIndexof());
				 * System.out.println(reportTableFieldColumnList.get(indI).getFieldName());
				 * System.out.println(reportTableFieldColumnList.get(indI).getFieldName());
				 * indicate.setIndicateValue( new
				 * BigDecimal(result.getString(reportTableFieldColumnList.get(indI).getFieldName
				 * ()))); indicateList.add(indicate.getIndicateIndexof().intValue(), indicate);
				 * } else continue;
				 * 
				 * } reportRowNode.setIndicateLsit(indicateList);
				 * reportRowNode.setTreeStructureCode(result.getString("ASSET_CLASS_CODE"));
				 * reportRowNode.setLeaf(true); treeStructure.add(reportRowNode);
				 * reportRowNodeLIst.add(reportRowNode);
				 */

			}

			/**
			 * 以下模块进行叶子节点判断。 逻辑是： 1、对ReportRowNodeList中的元素进行遍历；
			 * 2、根据结构树的treeNodeLength长度，从每个节点的treeStructureCode中获取子字符串；
			 * 3、于treeStructure模板列表中的剩余元素的结构树treeStructureCode的相同长度的子字符串进行匹配；
			 * 4、只要出现一次，即判定当前元素为非叶子节点，更新reportRowNodeLIst中当前元素的leaf属性为false,否则为true；
			 */
			for (int reportRowNodeLIstI = 0; reportRowNodeLIstI < reportRowNodeLIst.size(); reportRowNodeLIstI++) {

				for (int levelI = 0; levelI < maxTreeStructureCodeLength / treeNodeLength; levelI++) {
					for (int treeI = reportRowNodeLIstI + 1; treeI < treeStructure.size(); treeI++) {

						/*
						 * treeStructure.get(treeI).substring(0, treeNodeLength * (levelI + 1) >
						 * treeStructure.get(treeI).length() ? treeStructure.get(treeI).length() :
						 * treeNodeLength * (levelI + 1));
						 */
						Map<String, Boolean> app = new HashMap<String, Boolean>();
						if (reportRowNodeLIst.get(reportRowNodeLIstI).getTreeStructureCode()
								.contentEquals(treeStructure.get(treeI).substring(0,
										treeNodeLength * (levelI + 1) > treeStructure.get(treeI).length()
												? treeStructure.get(treeI).length()
												: treeNodeLength * (levelI + 1)))) {
							System.out.println(treeStructure.get(treeI).substring(0,
									treeNodeLength * (levelI + 1) > treeStructure.get(treeI).length()
											? treeStructure.get(treeI).length()
											: treeNodeLength * (levelI + 1)));
							reportRowNodeLIst.get(reportRowNodeLIstI).setLeaf(false);
							break;
						}
					}
				}
				// System.out.println(reportRowNodeLIst.get(reportRowNodeLIstI).getIndicateLsit().size());
				System.out.println(
						reportRowNodeLIst.get(reportRowNodeLIstI).getDimensionList().get(0).getDimensionValue());
				System.out.println(
						reportRowNodeLIst.get(reportRowNodeLIstI).getDimensionList().get(1).getDimensionValue());
				System.out.println(reportRowNodeLIst.get(reportRowNodeLIstI).getIndicateLsit().get(0).getIndicateName()
						+ "=" + reportRowNodeLIst.get(reportRowNodeLIstI).getIndicateLsit().get(0).getIndicateValue());
				System.out.println(reportRowNodeLIst.get(reportRowNodeLIstI).getIndicateLsit().get(1).getIndicateName()
						+ "=" + reportRowNodeLIst.get(reportRowNodeLIstI).getIndicateLsit().get(1).getIndicateValue());
				System.out.println(reportRowNodeLIst.get(reportRowNodeLIstI).isLeaf());
			}
			/*
			 * reportRowNodeLIst 中每个元素中都有维度列表与指标列表
			 */

			// File src = new File(templateFilePathAndName);
			File desc = new File(targetFilePathAndName);

			// 电网实物资产分析评价数据收集表-20182020-05-13 1024551.xls

			Workbook reportWorkBook = getWorkbok(desc);

			// sheet 对应一个工作页
			Sheet reportSheet = reportWorkBook.getSheet(sheetName);
			// int errorI = reportSheet.getPhysicalNumberOfRows();

			try {

				out = new FileOutputStream(desc);
				// 构造 Workbook 对象，execelFile 是传入文件路径(获得Excel工作区)

				// 定义 row、cell

				Row row;

				String cell;

				// 总共有多少行,从0开始

				int totalRows = reportSheet.getLastRowNum();

				// 循环输出表格中的内容,首先循环取出行,再根据行循环取出列
				// int startRowNumber = 5;
				// int startColumnNumber = 2;
				for (int i = 0; i < reportRowNodeLIst.size(); i++) {

					row = reportSheet.getRow(i + startRowNumber);

					// 处理空行

					if (row == null) {

						continue;

					}

					// 总共有多少列,从0开始

					int totalCells = row.getLastCellNum();

					// for (int j = row.getFirstCellNum(); j < totalCells; j++)
					if (reportRowNodeLIst.get(i).isLeaf()) {
						for (int j = 0; j < indQuantity - 1; j++) {

							Cell reportCell = null;
							// 下面这个方法是把Excel文档中原有的Cell取到，然后进行了值的写入，不会改变原来的格式。
							reportCell = row.getCell(j + startColumnNumber);
							// 下面这个方法是创建了一个新的Cell，然后进行了值的写入，会覆盖原来的cell,原来的格式也会丢失。
							// reportCell = row.createCell(j + startColumnNumber);
							reportCell.setCellValue(
									reportRowNodeLIst.get(i).getIndicateLsit().get(j).getIndicateValue().doubleValue());

							// 处理空列

							if (row.getCell(j) == null) {

								continue;

							}

							// 通过 row.getCell(j).toString() 获取单元格内容

							cell = row.getCell(j).toString();

							System.out.print(cell + "\t");

						}
					}
					// 下面的命令是刷新Excel文件中所有Sheet表格预设的公式，使之计算出其结果。
					reportWorkBook.setForceFormulaRecalculation(true);

					// 下面的命令是向desc指向Excel输出所有的数据。
					out = new FileOutputStream(desc);
					reportWorkBook.write(out);

				}

			} catch (FileNotFoundException e) {

				e.printStackTrace();

			} catch (IOException e) {

				e.printStackTrace();

			}

		} finally {
			try {
				if (out != null) {
					out.flush();
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println("数据导出成功");
	}

	@Autowired
	public void writeXLSX(String reportSQL, String templateFilePathAndName, String targetFilePathAndName,
			String reportName, String voltageRelationCode, String dataVersion, String areaName, String sheetName,
			int startRowNumber, int startColumnNumber) throws SQLException, IOException {
		// System.out.println("areaName=" + areaName);
		Connection conn = null;
		conn = DbUtil.getConnection();

		List<ReportRowNode> reportRowNodeLIst = new ArrayList<ReportRowNode>();
		List<String> treeStructure = new ArrayList<String>();
		OutputStream out = null;
		try {
			// System.out.println("System.getProperty(\"user.dir\"):" +
			// System.getProperty("user.dir"));
			// System.out.println("finalXlsxPath:=" + finalXlsxPath);
			// File finalXlsxFile = new File(finalXlsxPath);// +"/"+nowdate+".xlsx");
			// System.out.println("finalXlsxFile.getName():" + finalXlsxFile.getName());

			// sheet 对应一个工作页
			// Sheet sheet = workBook.getSheetAt(0);
			// 创建预编译语句对象，一般都是用这个而不用Statement
			PreparedStatement pre = null;
			// 创建一个结果集对象
			ResultSet result = null;
			String columnSql = "SELECT * FROM REPORT_TABLE_FIELD_COLUMN A WHERE A.REPORT_NAME=TRIM(?)  ORDER BY REPORT_TABLE_FIELD_COLUMN_ID ";

			pre = conn.prepareStatement(columnSql);
			pre.setString(1, reportName);
			result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数

			List<ReportTableFieldColumn> reportTableFieldColumnList = new <ReportTableFieldColumn>ArrayList();
			int reportTableFieldColumnListI = 0;
			int treeNodeLength = 1;
			int indQuantity = 1;
			while (result.next()) {

				ReportTableFieldColumn reportTableFieldColumn = new ReportTableFieldColumn();
				reportTableFieldColumn.setReportTableFieldColumnId(result.getString("REPORT_TABLE_FIELD_COLUMN_ID"));
				reportTableFieldColumn.setReportId(result.getString("REPORT_ID"));
				reportTableFieldColumn.setReportName(result.getString("REPORT_NAME"));
				reportTableFieldColumn.setTableName(result.getString("TABLE_NAME"));
				reportTableFieldColumn.setFieldName(result.getString("FIELD_NAME"));
				reportTableFieldColumn.setIndexof(result.getDouble("INDEXOF"));
				reportTableFieldColumn.setFieldTitle(result.getString("FIELD_TITLE"));
				reportTableFieldColumn.setDimensionOrIndicate(result.getString("DIMENSION_OR_INDICATE"));
				reportTableFieldColumn.setDimensionOrIndicateType(result.getString("DIMENSION_OR_INDICATE_TYPE"));
				reportTableFieldColumn.setDiscription(result.getString("DISCRIPTION"));
				reportTableFieldColumnList.add(reportTableFieldColumnListI, reportTableFieldColumn);
				if (result.getString("DIMENSION_OR_INDICATE").contentEquals("TREE")) {
					treeNodeLength = new Integer(result.getString("DIMENSION_OR_INDICATE_TYPE"));
				}
				if (result.getString("DIMENSION_OR_INDICATE").contentEquals("IND")) {
					indQuantity++;
				}

				reportTableFieldColumnListI++;
			}

			System.out.println("treeNodeLength=" + treeNodeLength);
			// 预编译语句

			try {
				pre = conn.prepareStatement(reportSQL);
				pre.setString(1, voltageRelationCode);
				pre.setString(2, areaName);
				pre.setString(3, dataVersion);
				result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // 实例化预编译语句
				// 查询数据库中所有的数据
			int ReportTableFieldColumnListSize = reportTableFieldColumnList.size();
			int maxTreeStructureCodeLength = 1;
			while (result.next()) {
				ReportRowNode reportRowNode = new ReportRowNode();
				Dimension dim = new Dimension();
				Dimension dim2 = new Dimension();
				dim.setDimensionType("CATEGORY");
				//
				System.out.println("CATEGORY=" + result.getString("CATEGORY"));
				//
				System.out.println("VOLTAGE_LEVEL=" + result.getString("VOLTAGE_LEVEL"));
				if (result.getString("ASSET_CLASS_CODE").length() > maxTreeStructureCodeLength) {
					maxTreeStructureCodeLength = result.getString("ASSET_CLASS_CODE").length();
				}
				if (result.getString("VOLTAGE_LEVEL") == null) {
					dim.setDimensionCode(result.getString("ASSET_CLASS_CODE"));

				} else {
					dim.setDimensionCode(result.getString("ASSET_CLASS_CODE").substring(0,
							result.getString("ASSET_CLASS_CODE").length() - 3));
				}
				dim.setDimensionName("CATEGORY");
				dim.setDimensionValue(result.getString("CATEGORY"));
				dim2.setDimensionType("VOLTAGE_LEVEL");
				dim2.setDimensionName("VOLTAGE_LEVEL");
				dim2.setDimensionValue(result.getString("VOLTAGE_LEVEL"));

				List<Dimension> dimList = new ArrayList<Dimension>();
				dimList.add(dim);
				dimList.add(dim2);
				reportRowNode.setDimensionList(dimList);
				List<IndicateNode> indicateList = new ArrayList<IndicateNode>();
				for (int indI = 0; indI < ReportTableFieldColumnListSize; indI++) {
					/*
					 * IndicateNode indicate = new IndicateNode();
					 * indicate.setIndicateName(reportTableFieldColumnList.get(indI).getFieldName())
					 * ;
					 * 
					 * indicate.setIndicateIndexof(reportTableFieldColumnList.get(indI).getIndexof()
					 * ); indicate.setIndicateValue( new
					 * BigDecimal(result.getString(reportTableFieldColumnList.get(indI).getFieldName
					 * ()))); indicateList.add(indicate);
					 */

					if (reportTableFieldColumnList.get(indI).getDimensionOrIndicate().contentEquals("IND")) {
						IndicateNode indicate = new IndicateNode();

						indicate.setIndicateName(reportTableFieldColumnList.get(indI).getFieldName());

						indicate.setIndicateIndexof(reportTableFieldColumnList.get(indI).getIndexof());

						System.out.println(reportTableFieldColumnList.get(indI).getIndexof());
						System.out.println(reportTableFieldColumnList.get(indI).getFieldName());
						System.out.println(reportTableFieldColumnList.get(indI).getFieldName());
						System.out.println("indicateList size=" + indicateList.size());
						indicate.setIndicateValue(
								new BigDecimal(result.getString(reportTableFieldColumnList.get(indI).getFieldName())));
						indicateList.add(indicate.getIndicateIndexof().intValue(), indicate);
					} else
						continue;

				}
				reportRowNode.setIndicateLsit(indicateList);
				reportRowNode.setTreeStructureCode(result.getString("ASSET_CLASS_CODE"));
				reportRowNode.setLeaf(true);
				treeStructure.add(result.getString("ASSET_CLASS_CODE"));
				reportRowNodeLIst.add(reportRowNode);

				/*
				 * for (int indI = 0; indI < reportTableFieldColumnListSize; indI++) {
				 * 
				 * if
				 * (reportTableFieldColumnList.get(indI).getDimensionOrIndicate().contentEquals(
				 * "IND")) { IndicateNode indicate = new IndicateNode();
				 * 
				 * indicate.setIndicateName(reportTableFieldColumnList.get(indI).getFieldName())
				 * ;
				 * 
				 * indicate.setIndicateIndexof(reportTableFieldColumnList.get(indI).getIndexof()
				 * );
				 * 
				 * System.out.println(reportTableFieldColumnList.get(indI).getIndexof());
				 * System.out.println(reportTableFieldColumnList.get(indI).getFieldName());
				 * System.out.println(reportTableFieldColumnList.get(indI).getFieldName());
				 * indicate.setIndicateValue( new
				 * BigDecimal(result.getString(reportTableFieldColumnList.get(indI).getFieldName
				 * ()))); indicateList.add(indicate.getIndicateIndexof().intValue(), indicate);
				 * } else continue;
				 * 
				 * } reportRowNode.setIndicateLsit(indicateList);
				 * reportRowNode.setTreeStructureCode(result.getString("ASSET_CLASS_CODE"));
				 * reportRowNode.setLeaf(true); treeStructure.add(reportRowNode);
				 * reportRowNodeLIst.add(reportRowNode);
				 */

			}

			/**
			 * 以下模块进行叶子节点判断。 逻辑是： 1、对ReportRowNodeList中的元素进行遍历；
			 * 2、根据结构树的treeNodeLength长度，从每个节点的treeStructureCode中获取子字符串；
			 * 3、于treeStructure模板列表中的剩余元素的结构树treeStructureCode的相同长度的子字符串进行匹配；
			 * 4、只要出现一次，即判定当前元素为非叶子节点，更新reportRowNodeLIst中当前元素的leaf属性为false,否则为true；
			 */
			for (int reportRowNodeLIstI = 0; reportRowNodeLIstI < reportRowNodeLIst.size(); reportRowNodeLIstI++) {

				for (int levelI = 0; levelI < maxTreeStructureCodeLength / treeNodeLength; levelI++) {
					for (int treeI = reportRowNodeLIstI + 1; treeI < treeStructure.size(); treeI++) {

						/*
						 * treeStructure.get(treeI).substring(0, treeNodeLength * (levelI + 1) >
						 * treeStructure.get(treeI).length() ? treeStructure.get(treeI).length() :
						 * treeNodeLength * (levelI + 1));
						 */
						Map<String, Boolean> app = new HashMap<String, Boolean>();
						if (reportRowNodeLIst.get(reportRowNodeLIstI).getTreeStructureCode()
								.contentEquals(treeStructure.get(treeI).substring(0,
										treeNodeLength * (levelI + 1) > treeStructure.get(treeI).length()
												? treeStructure.get(treeI).length()
												: treeNodeLength * (levelI + 1)))) {
							System.out.println(treeStructure.get(treeI).substring(0,
									treeNodeLength * (levelI + 1) > treeStructure.get(treeI).length()
											? treeStructure.get(treeI).length()
											: treeNodeLength * (levelI + 1)));
							reportRowNodeLIst.get(reportRowNodeLIstI).setLeaf(false);
							break;
						}
					}
				}
				System.out.println(
						reportRowNodeLIst.get(reportRowNodeLIstI).getDimensionList().get(0).getDimensionValue());
				System.out.println(
						reportRowNodeLIst.get(reportRowNodeLIstI).getDimensionList().get(1).getDimensionValue());
				System.out.println(reportRowNodeLIst.get(reportRowNodeLIstI).getIndicateLsit().get(0).getIndicateName()
						+ "=" + reportRowNodeLIst.get(reportRowNodeLIstI).getIndicateLsit().get(0).getIndicateValue());
				System.out.println(reportRowNodeLIst.get(reportRowNodeLIstI).getIndicateLsit().get(1).getIndicateName()
						+ "=" + reportRowNodeLIst.get(reportRowNodeLIstI).getIndicateLsit().get(1).getIndicateValue());
				System.out.println(reportRowNodeLIst.get(reportRowNodeLIstI).isLeaf());
			}
			/*
			 * reportRowNodeLIst 中每个元素中都有维度列表与指标列表
			 */

			// File src = new File(templateFilePathAndName);
			File desc = new File(targetFilePathAndName);

			// 电网实物资产分析评价数据收集表-20182020-05-13 1024551.xls

			Workbook reportWorkBook = getWorkbok(desc);

			// sheet 对应一个工作页
			Sheet reportSheet = reportWorkBook.getSheet(sheetName);
			// int errorI = reportSheet.getPhysicalNumberOfRows();

			try {

				out = new FileOutputStream(desc);
				// 构造 Workbook 对象，execelFile 是传入文件路径(获得Excel工作区)

				// 定义 row、cell

				Row row;

				String cell;

				// 总共有多少行,从0开始

				int totalRows = reportSheet.getLastRowNum();

				// 循环输出表格中的内容,首先循环取出行,再根据行循环取出列
				// int startRowNumber = 5;
				// int startColumnNumber = 2;
				for (int i = 0; i < reportRowNodeLIst.size(); i++) {

					row = reportSheet.getRow(i + startRowNumber);

					// 处理空行

					if (row == null) {

						continue;

					}

					// 总共有多少列,从0开始

					int totalCells = row.getLastCellNum();

					// for (int j = row.getFirstCellNum(); j < totalCells; j++)
					if (reportRowNodeLIst.get(i).isLeaf()) {
						for (int j = 0; j < indQuantity - 1; j++) {

							Cell reportCell = null;
							// 下面这个方法是把Excel文档中原有的Cell取到，然后进行了值的写入，不会改变原来的格式。
							reportCell = row.getCell(j + startColumnNumber);
							// 下面这个方法是创建了一个新的Cell，然后进行了值的写入，会覆盖原来的cell,原来的格式也会丢失。
							// reportCell = row.createCell(j + startColumnNumber);
							reportCell.setCellValue(
									reportRowNodeLIst.get(i).getIndicateLsit().get(j).getIndicateValue().doubleValue());

							// 处理空列

							if (row.getCell(j) == null) {

								continue;

							}

							// 通过 row.getCell(j).toString() 获取单元格内容

							cell = row.getCell(j).toString();

							System.out.print(cell + "\t");

						}
					}
					// 下面的命令是刷新Excel文件中所有Sheet表格预设的公式，使之计算出其结果。
					reportWorkBook.setForceFormulaRecalculation(true);

					// 下面的命令是向desc指向Excel输出所有的数据。
					out = new FileOutputStream(desc);
					reportWorkBook.write(out);

				}

			} catch (FileNotFoundException e) {

				e.printStackTrace();

			} catch (IOException e) {

				e.printStackTrace();

			}

		} finally {
			try {
				if (out != null) {
					out.flush();
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println("数据导出成功");
	}

	@Autowired
	public void writeXLSXAppointedColumn(String reportSQL, String templateFilePathAndName, String targetFilePathAndName,
			String reportName, String voltageRelationCode, String dataVersion, String areaName, String sheetName,
			int startRowNumber, int startColumnNumber, String appointedColumn) throws SQLException, IOException {
		// System.out.println("areaName=" + areaName);
		Connection conn = null;
		conn = DbUtil.getConnection();

		List<ReportRowNode> reportRowNodeLIst = new ArrayList<ReportRowNode>();
		List<String> treeStructure = new ArrayList<String>();
		OutputStream out = null;
		try {
			// sheet 对应一个工作页
			// Sheet sheet = workBook.getSheetAt(0);
			// 创建预编译语句对象，一般都是用这个而不用Statement
			PreparedStatement pre = null;
			// 创建一个结果集对象
			ResultSet result = null;
			String columnSql = "SELECT * FROM REPORT_TABLE_FIELD_COLUMN A WHERE A.REPORT_NAME=TRIM(?)  ORDER BY REPORT_TABLE_FIELD_COLUMN_ID ";

			pre = conn.prepareStatement(columnSql);
			pre.setString(1, reportName);
			result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数

			List<ReportTableFieldColumn> reportTableFieldColumnList = new <ReportTableFieldColumn>ArrayList();
			int reportTableFieldColumnListI = 0;
			int treeNodeLength = 1;
			int indQuantity = 1;
			while (result.next()) {

				ReportTableFieldColumn reportTableFieldColumn = new ReportTableFieldColumn();
				reportTableFieldColumn.setReportTableFieldColumnId(result.getString("REPORT_TABLE_FIELD_COLUMN_ID"));
				reportTableFieldColumn.setReportId(result.getString("REPORT_ID"));
				reportTableFieldColumn.setReportName(result.getString("REPORT_NAME"));
				reportTableFieldColumn.setTableName(result.getString("TABLE_NAME"));
				reportTableFieldColumn.setFieldName(result.getString("FIELD_NAME"));
				reportTableFieldColumn.setIndexof(result.getDouble("INDEXOF"));
				reportTableFieldColumn.setFieldTitle(result.getString("FIELD_TITLE"));
				reportTableFieldColumn.setDimensionOrIndicate(result.getString("DIMENSION_OR_INDICATE"));
				reportTableFieldColumn.setDimensionOrIndicateType(result.getString("DIMENSION_OR_INDICATE_TYPE"));
				reportTableFieldColumn.setDiscription(result.getString("DISCRIPTION"));
				reportTableFieldColumnList.add(reportTableFieldColumnListI, reportTableFieldColumn);
				if (result.getString("DIMENSION_OR_INDICATE").contentEquals("TREE")) {
					treeNodeLength = new Integer(result.getString("DIMENSION_OR_INDICATE_TYPE"));
				}
				if (result.getString("DIMENSION_OR_INDICATE").contentEquals("IND")) {
					indQuantity++;
				}

				reportTableFieldColumnListI++;
			}

			System.out.println("treeNodeLength=" + treeNodeLength);
			// 预编译语句

			try {
				pre = conn.prepareStatement(reportSQL);
				pre.setString(1, voltageRelationCode);
				pre.setString(2, areaName);
				pre.setString(3, dataVersion);
				result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // 实例化预编译语句
				// 查询数据库中所有的数据
			int ReportTableFieldColumnListSize = reportTableFieldColumnList.size();
			int maxTreeStructureCodeLength = 1;
			while (result.next()) {
				ReportRowNode reportRowNode = new ReportRowNode();
				Dimension dim = new Dimension();
				Dimension dim2 = new Dimension();
				dim.setDimensionType("CATEGORY");
				//
				System.out.println("CATEGORY=" + result.getString("CATEGORY"));
				//
				System.out.println("VOLTAGE_LEVEL=" + result.getString("VOLTAGE_LEVEL"));
				if (result.getString("ASSET_CLASS_CODE").length() > maxTreeStructureCodeLength) {
					maxTreeStructureCodeLength = result.getString("ASSET_CLASS_CODE").length();
				}
				if (result.getString("VOLTAGE_LEVEL") == null) {
					dim.setDimensionCode(result.getString("ASSET_CLASS_CODE"));

				} else {
					dim.setDimensionCode(result.getString("ASSET_CLASS_CODE").substring(0,
							result.getString("ASSET_CLASS_CODE").length() - 3));
				}
				dim.setDimensionName("CATEGORY");
				dim.setDimensionValue(result.getString("CATEGORY"));
				dim2.setDimensionType("VOLTAGE_LEVEL");
				dim2.setDimensionName("VOLTAGE_LEVEL");
				dim2.setDimensionValue(result.getString("VOLTAGE_LEVEL"));

				List<Dimension> dimList = new ArrayList<Dimension>();
				dimList.add(dim);
				dimList.add(dim2);
				reportRowNode.setDimensionList(dimList);
				List<IndicateNode> indicateList = new ArrayList<IndicateNode>();
				for (int indI = 0; indI < ReportTableFieldColumnListSize; indI++) {
					/*
					 * IndicateNode indicate = new IndicateNode();
					 * indicate.setIndicateName(reportTableFieldColumnList.get(indI).getFieldName())
					 * ;
					 * 
					 * indicate.setIndicateIndexof(reportTableFieldColumnList.get(indI).getIndexof()
					 * ); indicate.setIndicateValue( new
					 * BigDecimal(result.getString(reportTableFieldColumnList.get(indI).getFieldName
					 * ()))); indicateList.add(indicate);
					 */

					if (reportTableFieldColumnList.get(indI).getDimensionOrIndicate().contentEquals("IND")) {
						IndicateNode indicate = new IndicateNode();

						indicate.setIndicateName(reportTableFieldColumnList.get(indI).getFieldName());

						indicate.setIndicateIndexof(reportTableFieldColumnList.get(indI).getIndexof());

						System.out.println(reportTableFieldColumnList.get(indI).getIndexof());
						System.out.println(reportTableFieldColumnList.get(indI).getFieldName());
						System.out.println(reportTableFieldColumnList.get(indI).getFieldName());
						System.out.println("indicateList size=" + indicateList.size());
						indicate.setIndicateValue(
								new BigDecimal(result.getString(reportTableFieldColumnList.get(indI).getFieldName())));
						indicateList.add(indicate.getIndicateIndexof().intValue(), indicate);
					} else
						continue;

				}
				reportRowNode.setIndicateLsit(indicateList);
				reportRowNode.setTreeStructureCode(result.getString("ASSET_CLASS_CODE"));
				reportRowNode.setLeaf(true);
				treeStructure.add(result.getString("ASSET_CLASS_CODE"));
				reportRowNodeLIst.add(reportRowNode);

			}

			/**
			 * 以下模块进行叶子节点判断。 逻辑是： 1、对ReportRowNodeList中的元素进行遍历；
			 * 2、根据结构树的treeNodeLength长度，从每个节点的treeStructureCode中获取子字符串；
			 * 3、于treeStructure模板列表中的剩余元素的结构树treeStructureCode的相同长度的子字符串进行匹配；
			 * 4、只要出现一次，即判定当前元素为非叶子节点，更新reportRowNodeLIst中当前元素的leaf属性为false,否则为true；
			 */
			for (int reportRowNodeLIstI = 0; reportRowNodeLIstI < reportRowNodeLIst.size(); reportRowNodeLIstI++) {

				for (int levelI = 0; levelI < maxTreeStructureCodeLength / treeNodeLength; levelI++) {
					for (int treeI = reportRowNodeLIstI + 1; treeI < treeStructure.size(); treeI++) {

						/*
						 * treeStructure.get(treeI).substring(0, treeNodeLength * (levelI + 1) >
						 * treeStructure.get(treeI).length() ? treeStructure.get(treeI).length() :
						 * treeNodeLength * (levelI + 1));
						 */
						Map<String, Boolean> app = new HashMap<String, Boolean>();
						if (reportRowNodeLIst.get(reportRowNodeLIstI).getTreeStructureCode()
								.contentEquals(treeStructure.get(treeI).substring(0,
										treeNodeLength * (levelI + 1) > treeStructure.get(treeI).length()
												? treeStructure.get(treeI).length()
												: treeNodeLength * (levelI + 1)))) {
							System.out.println(treeStructure.get(treeI).substring(0,
									treeNodeLength * (levelI + 1) > treeStructure.get(treeI).length()
											? treeStructure.get(treeI).length()
											: treeNodeLength * (levelI + 1)));
							reportRowNodeLIst.get(reportRowNodeLIstI).setLeaf(false);
							break;
						}
					}
				}
				System.out.println(
						reportRowNodeLIst.get(reportRowNodeLIstI).getDimensionList().get(0).getDimensionValue());
				System.out.println(
						reportRowNodeLIst.get(reportRowNodeLIstI).getDimensionList().get(1).getDimensionValue());
				System.out.println(reportRowNodeLIst.get(reportRowNodeLIstI).getIndicateLsit().get(0).getIndicateName()
						+ "=" + reportRowNodeLIst.get(reportRowNodeLIstI).getIndicateLsit().get(0).getIndicateValue());
				System.out.println(reportRowNodeLIst.get(reportRowNodeLIstI).getIndicateLsit().get(1).getIndicateName()
						+ "=" + reportRowNodeLIst.get(reportRowNodeLIstI).getIndicateLsit().get(1).getIndicateValue());
				System.out.println(reportRowNodeLIst.get(reportRowNodeLIstI).isLeaf());
			}
			/*
			 * reportRowNodeLIst 中每个元素中都有维度列表与指标列表
			 */

			// File src = new File(templateFilePathAndName);
			File desc = new File(targetFilePathAndName);

			// 电网实物资产分析评价数据收集表-20182020-05-13 1024551.xls

			Workbook reportWorkBook = getWorkbok(desc);

			// sheet 对应一个工作页
			Sheet reportSheet = reportWorkBook.getSheet(sheetName);
			// int errorI = reportSheet.getPhysicalNumberOfRows();

			try {

				out = new FileOutputStream(desc);
				// 构造 Workbook 对象，execelFile 是传入文件路径(获得Excel工作区)

				// 定义 row、cell

				Row row;

				String cell;

				// 总共有多少行,从0开始

				int totalRows = reportSheet.getLastRowNum();

				// 循环输出表格中的内容,首先循环取出行,再根据行循环取出列
				// int startRowNumber = 5;
				// int startColumnNumber = 2;
				for (int i = 0; i < reportRowNodeLIst.size(); i++) {

					row = reportSheet.getRow(i + startRowNumber);

					// 处理空行

					if (row == null) {

						continue;

					}

					// 总共有多少列,从0开始

					int totalCells = row.getLastCellNum();

					// for (int j = row.getFirstCellNum(); j < totalCells; j++)
					if (reportRowNodeLIst.get(i).isLeaf()) {
						for (int j = 0; j < indQuantity - 1; j++) {

							Cell reportCell = null;
							// 下面这个方法是把Excel文档中原有的Cell取到，然后进行了值的写入，不会改变原来的格式。
							if (reportRowNodeLIst.get(i).getIndicateLsit().get(j).getIndicateName()
									.contentEquals(appointedColumn)) {
								reportCell = row.getCell(j + startColumnNumber);
								// 下面这个方法是创建了一个新的Cell，然后进行了值的写入，会覆盖原来的cell,原来的格式也会丢失。
								// reportCell = row.createCell(j + startColumnNumber);
								reportCell.setCellValue(reportRowNodeLIst.get(i).getIndicateLsit().get(j)
										.getIndicateValue().doubleValue());
							}

							// 处理空列

							if (row.getCell(j) == null) {

								continue;

							}

							// 通过 row.getCell(j).toString() 获取单元格内容

							cell = row.getCell(j).toString();

							System.out.print(cell + "\t");

						}
					}
					// 下面的命令是刷新Excel文件中所有Sheet表格预设的公式，使之计算出其结果。
					reportWorkBook.setForceFormulaRecalculation(true);

					// 下面的命令是向desc指向Excel输出所有的数据。
					out = new FileOutputStream(desc);
					reportWorkBook.write(out);

				}

			} catch (FileNotFoundException e) {

				e.printStackTrace();

			} catch (IOException e) {

				e.printStackTrace();

			}

		} finally {
			try {
				if (out != null) {
					out.flush();
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println("数据导出成功");
	}
	/**
	 * 进行各地市报表的批量化导出，查询条件通过前端给定
	 * @param reportSQL
	 * @param templateFilePathAndName
	 * @param targetFilePathAndName
	 * @param reportId
	 * @param voltageRelationCode
	 * @param dataVersion
	 * @param areaName
	 * @param sheetName
	 * @param startRowNumber
	 * @param startColumnNumber
	 * @param reportAssetemplateId
	 * @throws SQLException
	 * @throws IOException
	 */
	@Autowired
	public void writeXLSXEachCityColumnAutomatic(String reportSQL, String templateFilePathAndName,
			String targetFilePathAndName, String reportId, String voltageRelationCode, String dataVersion,
			String areaName, String sheetName, int startRowNumber, int startColumnNumber,String reportAssetemplateId)
			throws SQLException, IOException {
		// System.out.println("areaName=" + areaName);
		Connection conn = null;
		conn = DbUtil.getConnection();

		List<ReportRowNode> reportRowNodeLIst = new ArrayList<ReportRowNode>();
		List<String> treeStructure = new ArrayList<String>();
		OutputStream out = null;
		try {
			// System.out.println("System.getProperty(\"user.dir\"):" +
			// System.getProperty("user.dir"));
			// System.out.println("finalXlsxPath:=" + finalXlsxPath);
			// File finalXlsxFile = new File(finalXlsxPath);// +"/"+nowdate+".xlsx");
			// System.out.println("finalXlsxFile.getName():" + finalXlsxFile.getName());

			// sheet 对应一个工作页
			// Sheet sheet = workBook.getSheetAt(0);
			// 创建预编译语句对象，一般都是用这个而不用Statement
			PreparedStatement pre = null;
			// 创建一个结果集对象
			ResultSet result = null;
			String columnSql = "SELECT * FROM REPORT_TABLE_FIELD_COLUMN A WHERE A.REPORT_ID=TRIM(?)  ORDER BY REPORT_TABLE_FIELD_COLUMN_ID ";

			pre = conn.prepareStatement(columnSql);
			pre.setString(1, reportId);
			result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数

			List<ReportTableFieldColumn> reportTableFieldColumnList = new <ReportTableFieldColumn>ArrayList();
			int reportTableFieldColumnListI = 0;
			int treeNodeLength = 3;
			int indQuantity = 0;
			while (result.next()) { 
				ReportTableFieldColumn reportTableFieldColumn = new ReportTableFieldColumn();
				reportTableFieldColumn.setReportTableFieldColumnId(result.getString("REPORT_TABLE_FIELD_COLUMN_ID"));
				reportTableFieldColumn.setReportId(result.getString("REPORT_ID"));
				reportTableFieldColumn.setReportName(result.getString("REPORT_NAME"));
				reportTableFieldColumn.setTableName(result.getString("TABLE_NAME"));
				reportTableFieldColumn.setFieldName(result.getString("FIELD_NAME"));
				reportTableFieldColumn.setIndexof(result.getDouble("INDEXOF"));
				reportTableFieldColumn.setFieldTitle(result.getString("FIELD_TITLE"));
				reportTableFieldColumn.setDimensionOrIndicate(result.getString("DIMENSION_OR_INDICATE"));
				reportTableFieldColumn.setDimensionOrIndicateType(result.getString("DIMENSION_OR_INDICATE_TYPE"));
				reportTableFieldColumn.setDiscription(result.getString("DISCRIPTION"));
				reportTableFieldColumnList.add(reportTableFieldColumnListI, reportTableFieldColumn);
				if (result.getString("DIMENSION_OR_INDICATE").contentEquals("TREE")) {
					treeNodeLength = new Integer(result.getString("DIMENSION_OR_INDICATE_TYPE"));
				}
				if (result.getString("DIMENSION_OR_INDICATE").contentEquals("IND")) {
					indQuantity++;
				}

				reportTableFieldColumnListI++;
			}

			System.out.println("treeNodeLength=" + treeNodeLength);
			// 预编译语句

			try {
				pre = conn.prepareStatement(reportSQL);
				pre.setString(1, areaName);
				pre.setString(2, areaName);
				pre.setString(3, reportAssetemplateId);
				pre.setString(4, voltageRelationCode);
				pre.setString(5, reportAssetemplateId);
				pre.setString(6, dataVersion);
				result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // 实例化预编译语句
				// 查询数据库中所有的数据
			int ReportTableFieldColumnListSize = reportTableFieldColumnList.size();
			int maxTreeStructureCodeLength = 1;
			while (result.next()) {
				ReportRowNode reportRowNode = new ReportRowNode();
				Dimension dim = new Dimension();
				Dimension dim2 = new Dimension();
				dim.setDimensionType("CATEGORY");
				//
				System.out.println("CATEGORY=" + result.getString("CATEGORY"));
				//
				System.out.println("VOLTAGE_LEVEL=" + result.getString("VOLTAGE_LEVEL"));
				if (result.getString("ASSET_CLASS_CODE").length() > maxTreeStructureCodeLength) {
					maxTreeStructureCodeLength = result.getString("ASSET_CLASS_CODE").length();
				}
				if (result.getString("VOLTAGE_LEVEL") == null) {
					dim.setDimensionCode(result.getString("ASSET_CLASS_CODE"));

				} else {
					dim.setDimensionCode(result.getString("ASSET_CLASS_CODE").substring(0,
							result.getString("ASSET_CLASS_CODE").length() - 3));
				}
				dim.setDimensionName("CATEGORY");
				dim.setDimensionValue(result.getString("CATEGORY"));
				dim2.setDimensionType("VOLTAGE_LEVEL");
				dim2.setDimensionName("VOLTAGE_LEVEL");
				dim2.setDimensionValue(result.getString("VOLTAGE_LEVEL"));

				List<Dimension> dimList = new ArrayList<Dimension>();
				dimList.add(dim);
				dimList.add(dim2);
				reportRowNode.setDimensionList(dimList);
				List<IndicateNode> indicateList = new ArrayList<IndicateNode>();
				for (int indI = 0; indI < ReportTableFieldColumnListSize; indI++) {
					/*
					 * IndicateNode indicate = new IndicateNode();
					 * indicate.setIndicateName(reportTableFieldColumnList.get(indI).getFieldName())
					 * ;
					 * 
					 * indicate.setIndicateIndexof(reportTableFieldColumnList.get(indI).getIndexof()
					 * ); indicate.setIndicateValue( new
					 * BigDecimal(result.getString(reportTableFieldColumnList.get(indI).getFieldName
					 * ()))); indicateList.add(indicate);
					 */

					if (reportTableFieldColumnList.get(indI).getDimensionOrIndicate().contentEquals("IND")) {
						IndicateNode indicate = new IndicateNode();

						indicate.setIndicateName(reportTableFieldColumnList.get(indI).getFieldName());

						indicate.setIndicateIndexof(reportTableFieldColumnList.get(indI).getIndexof());

						System.out.println(reportTableFieldColumnList.get(indI).getIndexof());
						System.out.println(reportTableFieldColumnList.get(indI).getFieldName());
						System.out.println(reportTableFieldColumnList.get(indI).getFieldName());
						System.out.println("indicateList size=" + indicateList.size());
						indicate.setIndicateValue(
								new BigDecimal(result.getString(reportTableFieldColumnList.get(indI).getFieldName())));
						indicateList.add(indicate.getIndicateIndexof().intValue(), indicate);
					} else
						continue;

				}
				reportRowNode.setIndicateLsit(indicateList);
				reportRowNode.setTreeStructureCode(result.getString("ASSET_CLASS_CODE"));
				reportRowNode.setLeaf(true);
				treeStructure.add(result.getString("ASSET_CLASS_CODE"));
				reportRowNodeLIst.add(reportRowNode);

			}

			/**
			 * 以下模块进行叶子节点判断。 逻辑是： 1、对ReportRowNodeList中的元素进行遍历；
			 * 2、根据结构树的treeNodeLength长度，从每个节点的treeStructureCode中获取子字符串；
			 * 3、于treeStructure模板列表中的剩余元素的结构树treeStructureCode的相同长度的子字符串进行匹配；
			 * 4、只要出现一次，即判定当前元素为非叶子节点，更新reportRowNodeLIst中当前元素的leaf属性为false,否则为true；
			 */
			for (int reportRowNodeLIstI = 0; reportRowNodeLIstI < reportRowNodeLIst.size(); reportRowNodeLIstI++) {

				for (int levelI = 0; levelI < maxTreeStructureCodeLength / treeNodeLength; levelI++) {
					for (int treeI = reportRowNodeLIstI + 1; treeI < treeStructure.size(); treeI++) {

						/*
						 * treeStructure.get(treeI).substring(0, treeNodeLength * (levelI + 1) >
						 * treeStructure.get(treeI).length() ? treeStructure.get(treeI).length() :
						 * treeNodeLength * (levelI + 1));
						 */
						Map<String, Boolean> app = new HashMap<String, Boolean>();
						/*if (reportRowNodeLIst.get(reportRowNodeLIstI).getTreeStructureCode()
								.contentEquals(treeStructure.get(treeI).substring(0,
										treeNodeLength * (levelI + 1) > treeStructure.get(treeI).length()
												? treeStructure.get(treeI).length()
												: treeNodeLength * (levelI + 1)))) */
							if (reportRowNodeLIst.get(reportRowNodeLIstI).getTreeStructureCode()
									.contentEquals(treeStructure.get(treeI).substring(0,
											 treeStructure.get(treeI).length()-treeNodeLength))){
							System.out.println(treeStructure.get(treeI).substring(0,
									treeNodeLength * (levelI + 1) > treeStructure.get(treeI).length()
											? treeStructure.get(treeI).length()
											: treeNodeLength * (levelI + 1)));
							System.out.println("替换逻辑判断："+reportRowNodeLIst.get(reportRowNodeLIstI).getTreeStructureCode()
									.contentEquals(treeStructure.get(treeI).substring(0,
											 treeStructure.get(treeI).length()-treeNodeLength))+",treeStructureSubstr:"+treeStructure.get(treeI).substring(0,
													 treeStructure.get(treeI).length()-treeNodeLength));
							reportRowNodeLIst.get(reportRowNodeLIstI).setLeaf(false);
							break;
						}
					}
				}
				System.out.println("here:"+
						reportRowNodeLIst.get(reportRowNodeLIstI).getDimensionList().get(0).getDimensionValue());
				System.out.println(
						reportRowNodeLIst.get(reportRowNodeLIstI).getDimensionList().get(1).getDimensionValue());
				//System.out.println(reportRowNodeLIst.get(reportRowNodeLIstI).getIndicateLsit().get(0).getIndicateName()
				//		+ "=" + reportRowNodeLIst.get(reportRowNodeLIstI).getIndicateLsit().get(0).getIndicateValue());
				//System.out.println(reportRowNodeLIst.get(reportRowNodeLIstI).getIndicateLsit().get(1).getIndicateName()
				//		+ "=" + reportRowNodeLIst.get(reportRowNodeLIstI).getIndicateLsit().get(1).getIndicateValue());
				System.out.println(reportRowNodeLIst.get(reportRowNodeLIstI).isLeaf());
			}
			/*
			 * reportRowNodeLIst 中每个元素中都有维度列表与指标列表
			 */

			// File src = new File(templateFilePathAndName);
			File desc = new File(targetFilePathAndName);

			// 电网实物资产分析评价数据收集表-20182020-05-13 1024551.xls

			Workbook reportWorkBook = getWorkbok(desc);

			// sheet 对应一个工作页
			Sheet reportSheet = reportWorkBook.getSheet(sheetName);
			// int errorI = reportSheet.getPhysicalNumberOfRows();

			try {

				out = new FileOutputStream(desc);
				// 构造 Workbook 对象，execelFile 是传入文件路径(获得Excel工作区)

				// 定义 row、cell

				Row row;

				String cell;

				// 总共有多少行,从0开始

				//int totalRows = reportSheet.getLastRowNum();

				// 循环输出表格中的内容,首先循环取出行,再根据行循环取出列
				// int startRowNumber = 5;
				// int startColumnNumber = 2;
				for (int i = 0; i < reportRowNodeLIst.size(); i++) {

					row = reportSheet.getRow(i + startRowNumber);

					// 处理空行

					if (row == null) {

						continue;

					}

					// 总共有多少列,从0开始

					int totalCells = row.getLastCellNum();

					// for (int j = row.getFirstCellNum(); j < totalCells; j++)
					if (reportRowNodeLIst.get(i).isLeaf()) {
						for (int j = 0; j < indQuantity; j++) {

							Cell reportCell = null;

							// 通过 row.getCell(j).toString() 获取单元格内容

							 cell = row.getCell(j + startColumnNumber).toString();
							 System.out.println("cell("+(j+1)+") value="+cell);
							// 处理空列 
							if (row.getCell(j) != null) {
							// 下面这个方法是把Excel文档中原有的Cell取到，然后进行了值的写入，不会改变原来的格式。
								reportCell = row.getCell(j + startColumnNumber);
								/**对于Excel单元格中如果进行了外值的引用，通过reportCell.setCellValue是无法进行有效赋值的，
								 * 只能先通过reportCell.setCellType(HSSFCell.CELL_TYPE_BLANK); 将单元格设置为空，
								 * 然后再进行赋值。
								 */ 
								reportCell.setCellType(HSSFCell.CELL_TYPE_BLANK);
								// 下面这个方法是创建了一个新的Cell，然后进行了值的写入，会覆盖原来的cell,原来的格式也会丢失。
								System.out.println("setCellVlue:"+reportRowNodeLIst.get(i).getIndicateLsit().get(j)
										.getIndicateValue().doubleValue());
								// reportCell = row.createCell(j + startColumnNumber);
								reportCell.setCellValue(reportRowNodeLIst.get(i).getIndicateLsit().get(j)
										.getIndicateValue().doubleValue());

								 cell = row.getCell(j + startColumnNumber).toString();
								 System.out.println("cell("+(j+1)+") value="+cell);


							}else
							 { 
									continue; 
								}

						}
					}
					// 下面的命令是刷新Excel文件中所有Sheet表格预设的公式，使之计算出其结果。
					reportWorkBook.setForceFormulaRecalculation(true);

					// 下面的命令是向desc指向Excel输出所有的数据。
					out = new FileOutputStream(desc);
					reportWorkBook.write(out);

				}

			} catch (FileNotFoundException e) {

				e.printStackTrace();

			} catch (IOException e) {

				e.printStackTrace();

			}

		} finally {
			try {
				if (out != null) {
					out.flush();
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println("数据导出成功");
	}

	/**
	 * 进行各地市报表的批量化导出，查询条件通过前端给定，此方法涉及到两个数据表，即有两个数据版本
	 * @param reportSQL
	 * @param templateFilePathAndName
	 * @param targetFilePathAndName
	 * @param reportId
	 * @param voltageRelationCode
	 * @param dataVersion 第一个表的数据版本
	 * @param dataVersion2 第二个表的数据版本
	 * @param areaName
	 * @param sheetName
	 * @param startRowNumber
	 * @param startColumnNumber
	 * @param reportAssetemplateId
	 * @throws SQLException
	 * @throws IOException
	 */
	@Autowired
	public void writeXLSXEachCityColumnAutomatic(String reportSQL, String templateFilePathAndName,
			String targetFilePathAndName, String reportId, String voltageRelationCode, String dataVersion,String dataVersion2,
			String areaName, String sheetName, int startRowNumber, int startColumnNumber,String reportAssetemplateId)
			throws SQLException, IOException {
		// System.out.println("areaName=" + areaName);
		Connection conn = null;
		conn = DbUtil.getConnection();

		List<ReportRowNode> reportRowNodeLIst = new ArrayList<ReportRowNode>();
		List<String> treeStructure = new ArrayList<String>();
		OutputStream out = null;
		try {
			// System.out.println("System.getProperty(\"user.dir\"):" +
			// System.getProperty("user.dir"));
			// System.out.println("finalXlsxPath:=" + finalXlsxPath);
			// File finalXlsxFile = new File(finalXlsxPath);// +"/"+nowdate+".xlsx");
			// System.out.println("finalXlsxFile.getName():" + finalXlsxFile.getName());

			// sheet 对应一个工作页
			// Sheet sheet = workBook.getSheetAt(0);
			// 创建预编译语句对象，一般都是用这个而不用Statement
			PreparedStatement pre = null;
			// 创建一个结果集对象
			ResultSet result = null;
			String columnSql = "SELECT * FROM REPORT_TABLE_FIELD_COLUMN A WHERE A.REPORT_ID=TRIM(?)  ORDER BY REPORT_TABLE_FIELD_COLUMN_ID ";

			pre = conn.prepareStatement(columnSql);
			pre.setString(1, reportId);
			result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数

			List<ReportTableFieldColumn> reportTableFieldColumnList = new <ReportTableFieldColumn>ArrayList();
			int reportTableFieldColumnListI = 0;
			int treeNodeLength = 3;
			int indQuantity = 0;
			while (result.next()) { 
				ReportTableFieldColumn reportTableFieldColumn = new ReportTableFieldColumn();
				reportTableFieldColumn.setReportTableFieldColumnId(result.getString("REPORT_TABLE_FIELD_COLUMN_ID"));
				reportTableFieldColumn.setReportId(result.getString("REPORT_ID"));
				reportTableFieldColumn.setReportName(result.getString("REPORT_NAME"));
				reportTableFieldColumn.setTableName(result.getString("TABLE_NAME"));
				reportTableFieldColumn.setFieldName(result.getString("FIELD_NAME"));
				reportTableFieldColumn.setIndexof(result.getDouble("INDEXOF"));
				reportTableFieldColumn.setFieldTitle(result.getString("FIELD_TITLE"));
				reportTableFieldColumn.setDimensionOrIndicate(result.getString("DIMENSION_OR_INDICATE"));
				reportTableFieldColumn.setDimensionOrIndicateType(result.getString("DIMENSION_OR_INDICATE_TYPE"));
				reportTableFieldColumn.setDiscription(result.getString("DISCRIPTION"));
				reportTableFieldColumnList.add(reportTableFieldColumnListI, reportTableFieldColumn);
				if (result.getString("DIMENSION_OR_INDICATE").contentEquals("TREE")) {
					treeNodeLength = new Integer(result.getString("DIMENSION_OR_INDICATE_TYPE"));
				}
				if (result.getString("DIMENSION_OR_INDICATE").contentEquals("IND")) {
					indQuantity++;
				}

				reportTableFieldColumnListI++;
			}

			System.out.println("treeNodeLength=" + treeNodeLength);
			// 预编译语句

			try {
				pre = conn.prepareStatement(reportSQL);
				pre.setString(1, areaName);
				pre.setString(2, areaName);
				pre.setString(3, reportAssetemplateId);
				pre.setString(4, voltageRelationCode);
				pre.setString(5, reportAssetemplateId);
				pre.setString(6, dataVersion);
				pre.setString(7, dataVersion2);
				result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // 实例化预编译语句
				// 查询数据库中所有的数据
			int ReportTableFieldColumnListSize = reportTableFieldColumnList.size();
			int maxTreeStructureCodeLength = 1;
			while (result.next()) {
				ReportRowNode reportRowNode = new ReportRowNode();
				Dimension dim = new Dimension();
				Dimension dim2 = new Dimension();
				dim.setDimensionType("CATEGORY");
				//
				System.out.println("CATEGORY=" + result.getString("CATEGORY"));
				//
				System.out.println("VOLTAGE_LEVEL=" + result.getString("VOLTAGE_LEVEL"));
				if (result.getString("ASSET_CLASS_CODE").length() > maxTreeStructureCodeLength) {
					maxTreeStructureCodeLength = result.getString("ASSET_CLASS_CODE").length();
				}
				if (result.getString("VOLTAGE_LEVEL") == null) {
					dim.setDimensionCode(result.getString("ASSET_CLASS_CODE"));

				} else {
					dim.setDimensionCode(result.getString("ASSET_CLASS_CODE").substring(0,
							result.getString("ASSET_CLASS_CODE").length() - 3));
				}
				dim.setDimensionName("CATEGORY");
				dim.setDimensionValue(result.getString("CATEGORY"));
				dim2.setDimensionType("VOLTAGE_LEVEL");
				dim2.setDimensionName("VOLTAGE_LEVEL");
				dim2.setDimensionValue(result.getString("VOLTAGE_LEVEL"));

				List<Dimension> dimList = new ArrayList<Dimension>();
				dimList.add(dim);
				dimList.add(dim2);
				reportRowNode.setDimensionList(dimList);
				List<IndicateNode> indicateList = new ArrayList<IndicateNode>();
				for (int indI = 0; indI < ReportTableFieldColumnListSize; indI++) {
					/*
					 * IndicateNode indicate = new IndicateNode();
					 * indicate.setIndicateName(reportTableFieldColumnList.get(indI).getFieldName())
					 * ;
					 * 
					 * indicate.setIndicateIndexof(reportTableFieldColumnList.get(indI).getIndexof()
					 * ); indicate.setIndicateValue( new
					 * BigDecimal(result.getString(reportTableFieldColumnList.get(indI).getFieldName
					 * ()))); indicateList.add(indicate);
					 */

					if (reportTableFieldColumnList.get(indI).getDimensionOrIndicate().contentEquals("IND")) {
						IndicateNode indicate = new IndicateNode();

						indicate.setIndicateName(reportTableFieldColumnList.get(indI).getFieldName());

						indicate.setIndicateIndexof(reportTableFieldColumnList.get(indI).getIndexof());

						System.out.println(reportTableFieldColumnList.get(indI).getIndexof());
						System.out.println(reportTableFieldColumnList.get(indI).getFieldName());
						System.out.println(reportTableFieldColumnList.get(indI).getFieldName());
						System.out.println("indicateList size=" + indicateList.size());
						indicate.setIndicateValue(
								new BigDecimal(result.getString(reportTableFieldColumnList.get(indI).getFieldName())));
						indicateList.add(indicate.getIndicateIndexof().intValue(), indicate);
					} else
						continue;

				}
				reportRowNode.setIndicateLsit(indicateList);
				reportRowNode.setTreeStructureCode(result.getString("ASSET_CLASS_CODE"));
				reportRowNode.setLeaf(true);
				treeStructure.add(result.getString("ASSET_CLASS_CODE"));
				reportRowNodeLIst.add(reportRowNode);

			}

			/**
			 * 以下模块进行叶子节点判断。 逻辑是： 1、对ReportRowNodeList中的元素进行遍历；
			 * 2、根据结构树的treeNodeLength长度，从每个节点的treeStructureCode中获取子字符串；
			 * 3、于treeStructure模板列表中的剩余元素的结构树treeStructureCode的相同长度的子字符串进行匹配；
			 * 逻辑判断有问题，在已经处理过的结构中，如果当前节点的treeStructureCode子字符串在其中出现一次即为非
			 * 4、只要出现一次，即判定当前元素为非叶子节点，更新reportRowNodeLIst中当前元素的leaf属性为false,否则为true；
			 */
			for (int reportRowNodeLIstI = 0; reportRowNodeLIstI < reportRowNodeLIst.size(); reportRowNodeLIstI++) {

				for (int levelI = 0; levelI < maxTreeStructureCodeLength / treeNodeLength; levelI++) {
					for (int treeI = reportRowNodeLIstI + 1; treeI < treeStructure.size(); treeI++) {

						/*
						 * treeStructure.get(treeI).substring(0, treeNodeLength * (levelI + 1) >
						 * treeStructure.get(treeI).length() ? treeStructure.get(treeI).length() :
						 * treeNodeLength * (levelI + 1));
						 */
						Map<String, Boolean> app = new HashMap<String, Boolean>();
						/*if (reportRowNodeLIst.get(reportRowNodeLIstI).getTreeStructureCode()
								.contentEquals(treeStructure.get(treeI).substring(0,
										treeNodeLength * (levelI + 1) > treeStructure.get(treeI).length()
												? treeStructure.get(treeI).length()
												: treeNodeLength * (levelI + 1)))) */
							if (reportRowNodeLIst.get(reportRowNodeLIstI).getTreeStructureCode()
									.contentEquals(treeStructure.get(treeI).substring(0,
											 treeStructure.get(treeI).length()-treeNodeLength))){
							
							reportRowNodeLIst.get(reportRowNodeLIstI).setLeaf(false);
							break;
						}
					}
				}
				
				 System.out.println(reportRowNodeLIst.get(reportRowNodeLIstI).isLeaf());
			}
			/*
			 * reportRowNodeLIst 中每个元素中都有维度列表与指标列表
			 */

			// File src = new File(templateFilePathAndName);
			File desc = new File(targetFilePathAndName);

			// 电网实物资产分析评价数据收集表-20182020-05-13 1024551.xls

			Workbook reportWorkBook = getWorkbok(desc);

			// sheet 对应一个工作页
			Sheet reportSheet = reportWorkBook.getSheet(sheetName);
			// int errorI = reportSheet.getPhysicalNumberOfRows();

			try {

				out = new FileOutputStream(desc);
				// 构造 Workbook 对象，execelFile 是传入文件路径(获得Excel工作区)

				// 定义 row、cell

				Row row;

				String cell;

				// 总共有多少行,从0开始

				//int totalRows = reportSheet.getLastRowNum();

				// 循环输出表格中的内容,首先循环取出行,再根据行循环取出列
				// int startRowNumber = 5;
				// int startColumnNumber = 2;
				for (int i = 0; i < reportRowNodeLIst.size(); i++) {

					row = reportSheet.getRow(i + startRowNumber);

					// 处理空行

					if (row == null) {
						System.out.println("row null");
						continue;
					}

					// 总共有多少列,从0开始

					int totalCells = row.getLastCellNum();

					// for (int j = row.getFirstCellNum(); j < totalCells; j++)
					System.out.println("rowNumber="+i+",isLeaf:"+reportRowNodeLIst.get(i).isLeaf());
					if (reportRowNodeLIst.get(i).isLeaf()) {
						for (int j = 0; j < indQuantity; j++) {

							Cell reportCell = null;

							// 通过 row.getCell(j).toString() 获取单元格内容

							 cell = row.getCell(j + startColumnNumber).toString();
							 System.out.println("cell("+(j+1)+") value="+cell);
							// 处理空列 
							if (row.getCell(j) != null) {
							// 下面这个方法是把Excel文档中原有的Cell取到，然后进行了值的写入，不会改变原来的格式。
								reportCell = row.getCell(j + startColumnNumber);
								/**对于Excel单元格中如果进行了外值的引用，通过reportCell.setCellValue是无法进行有效赋值的，
								 * 只能先通过reportCell.setCellType(HSSFCell.CELL_TYPE_BLANK); 将单元格设置为空，
								 * 然后再进行赋值。
								 */ 
								reportCell.setCellType(HSSFCell.CELL_TYPE_BLANK);
								// 下面这个方法是创建了一个新的Cell，然后进行了值的写入，会覆盖原来的cell,原来的格式也会丢失。
								System.out.println("setCellVlue:"+reportRowNodeLIst.get(i).getIndicateLsit().get(j)
										.getIndicateValue().doubleValue());
								// reportCell = row.createCell(j + startColumnNumber);
								reportCell.setCellValue(reportRowNodeLIst.get(i).getIndicateLsit().get(j)
										.getIndicateValue().doubleValue());

								 cell = row.getCell(j + startColumnNumber).toString();
								 System.out.println("cell("+(j+1)+") value="+cell);


							}else
							 { 
								System.out.println("ceil null");
									continue; 
								}

						}
					}
					// 下面的命令是刷新Excel文件中所有Sheet表格预设的公式，使之计算出其结果。
					reportWorkBook.setForceFormulaRecalculation(true);

					// 下面的命令是向desc指向Excel输出所有的数据。
					out = new FileOutputStream(desc);
					reportWorkBook.write(out);

				}

			} catch (FileNotFoundException e) {

				e.printStackTrace();

			} catch (IOException e) {

				e.printStackTrace();

			}

		} finally {
			try {
				if (out != null) {
					out.flush();
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println("数据导出成功");
	}
	@Autowired
	public void writeXLSXColumnAutomatic(String reportSQL, String templateFilePathAndName,
			String targetFilePathAndName, String reportName, String voltageRelationCode, String dataVersion,
			String areaName, String sheetName, int startRowNumber, int startColumnNumber,String reportAssetemplateId)
			throws SQLException, IOException {
		// System.out.println("areaName=" + areaName);
		Connection conn = null;
		conn = DbUtil.getConnection();

		List<ReportRowNode> reportRowNodeLIst = new ArrayList<ReportRowNode>();
		List<String> treeStructure = new ArrayList<String>();
		OutputStream out = null;
		try {
			// System.out.println("System.getProperty(\"user.dir\"):" +
			// System.getProperty("user.dir"));
			// System.out.println("finalXlsxPath:=" + finalXlsxPath);
			// File finalXlsxFile = new File(finalXlsxPath);// +"/"+nowdate+".xlsx");
			// System.out.println("finalXlsxFile.getName():" + finalXlsxFile.getName());

			// sheet 对应一个工作页
			// Sheet sheet = workBook.getSheetAt(0);
			// 创建预编译语句对象，一般都是用这个而不用Statement
			PreparedStatement pre = null;
			// 创建一个结果集对象
			ResultSet result = null;
			String columnSql = "SELECT * FROM REPORT_TABLE_FIELD_COLUMN A WHERE A.REPORT_NAME=TRIM(?)  ORDER BY REPORT_TABLE_FIELD_COLUMN_ID ";

			pre = conn.prepareStatement(columnSql);
			pre.setString(1, reportName);
			result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数

			List<ReportTableFieldColumn> reportTableFieldColumnList = new <ReportTableFieldColumn>ArrayList();
			int reportTableFieldColumnListI = 0;
			int treeNodeLength = 3;
			int indQuantity = 0;
			while (result.next()) {

				ReportTableFieldColumn reportTableFieldColumn = new ReportTableFieldColumn();
				reportTableFieldColumn.setReportTableFieldColumnId(result.getString("REPORT_TABLE_FIELD_COLUMN_ID"));
				reportTableFieldColumn.setReportId(result.getString("REPORT_ID"));
				reportTableFieldColumn.setReportName(result.getString("REPORT_NAME"));
				reportTableFieldColumn.setTableName(result.getString("TABLE_NAME"));
				reportTableFieldColumn.setFieldName(result.getString("FIELD_NAME"));
				reportTableFieldColumn.setIndexof(result.getDouble("INDEXOF"));
				reportTableFieldColumn.setFieldTitle(result.getString("FIELD_TITLE"));
				reportTableFieldColumn.setDimensionOrIndicate(result.getString("DIMENSION_OR_INDICATE"));
				reportTableFieldColumn.setDimensionOrIndicateType(result.getString("DIMENSION_OR_INDICATE_TYPE"));
				reportTableFieldColumn.setDiscription(result.getString("DISCRIPTION"));
				reportTableFieldColumnList.add(reportTableFieldColumnListI, reportTableFieldColumn);
				if (result.getString("DIMENSION_OR_INDICATE").contentEquals("TREE")) {
					treeNodeLength = new Integer(result.getString("DIMENSION_OR_INDICATE_TYPE"));
				}
				if (result.getString("DIMENSION_OR_INDICATE").contentEquals("IND")) {
					indQuantity++;
				}

				reportTableFieldColumnListI++;
			}

			System.out.println("treeNodeLength=" + treeNodeLength);
			// 预编译语句

			try {
				pre = conn.prepareStatement(reportSQL);
				pre.setString(1, reportAssetemplateId);
				pre.setString(2, voltageRelationCode);
				pre.setString(3, areaName);
				pre.setString(4, areaName);
				pre.setString(5, dataVersion);
				result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // 实例化预编译语句
				// 查询数据库中所有的数据
			int ReportTableFieldColumnListSize = reportTableFieldColumnList.size();
			int maxTreeStructureCodeLength = 1;
			while (result.next()) {
				ReportRowNode reportRowNode = new ReportRowNode();
				Dimension dim = new Dimension();
				Dimension dim2 = new Dimension();
				dim.setDimensionType("CATEGORY");
				//
				System.out.println("CATEGORY=" + result.getString("CATEGORY"));
				//
				System.out.println("VOLTAGE_LEVEL=" + result.getString("VOLTAGE_LEVEL"));
				if (result.getString("ASSET_CLASS_CODE").length() > maxTreeStructureCodeLength) {
					maxTreeStructureCodeLength = result.getString("ASSET_CLASS_CODE").length();
				}
				if (result.getString("VOLTAGE_LEVEL") == null) {
					dim.setDimensionCode(result.getString("ASSET_CLASS_CODE"));

				} else {
					dim.setDimensionCode(result.getString("ASSET_CLASS_CODE").substring(0,
							result.getString("ASSET_CLASS_CODE").length() - 3));
				}
				dim.setDimensionName("CATEGORY");
				dim.setDimensionValue(result.getString("CATEGORY"));
				dim2.setDimensionType("VOLTAGE_LEVEL");
				dim2.setDimensionName("VOLTAGE_LEVEL");
				dim2.setDimensionValue(result.getString("VOLTAGE_LEVEL"));

				List<Dimension> dimList = new ArrayList<Dimension>();
				dimList.add(dim);
				dimList.add(dim2);
				reportRowNode.setDimensionList(dimList);
				List<IndicateNode> indicateList = new ArrayList<IndicateNode>();
				for (int indI = 0; indI < ReportTableFieldColumnListSize; indI++) {
					/*
					 * IndicateNode indicate = new IndicateNode();
					 * indicate.setIndicateName(reportTableFieldColumnList.get(indI).getFieldName())
					 * ;
					 * 
					 * indicate.setIndicateIndexof(reportTableFieldColumnList.get(indI).getIndexof()
					 * ); indicate.setIndicateValue( new
					 * BigDecimal(result.getString(reportTableFieldColumnList.get(indI).getFieldName
					 * ()))); indicateList.add(indicate);
					 */

					if (reportTableFieldColumnList.get(indI).getDimensionOrIndicate().contentEquals("IND")) {
						IndicateNode indicate = new IndicateNode();

						indicate.setIndicateName(reportTableFieldColumnList.get(indI).getFieldName());

						indicate.setIndicateIndexof(reportTableFieldColumnList.get(indI).getIndexof());

						System.out.println(reportTableFieldColumnList.get(indI).getIndexof());
						System.out.println(reportTableFieldColumnList.get(indI).getFieldName());
						System.out.println(reportTableFieldColumnList.get(indI).getFieldName());
						System.out.println("indicateList size=" + indicateList.size());
						indicate.setIndicateValue(
								new BigDecimal(result.getString(reportTableFieldColumnList.get(indI).getFieldName())));
						indicateList.add(indicate.getIndicateIndexof().intValue(), indicate);
					} else
						continue;

				}
				reportRowNode.setIndicateLsit(indicateList);
				reportRowNode.setTreeStructureCode(result.getString("ASSET_CLASS_CODE"));
				reportRowNode.setLeaf(true);
				treeStructure.add(result.getString("ASSET_CLASS_CODE"));
				reportRowNodeLIst.add(reportRowNode);

			}

			/**
			 * 以下模块进行叶子节点判断。 逻辑是： 1、对ReportRowNodeList中的元素进行遍历；
			 * 2、根据结构树的treeNodeLength长度，从每个节点的treeStructureCode中获取子字符串；
			 * 3、于treeStructure模板列表中的剩余元素的结构树treeStructureCode的相同长度的子字符串进行匹配；
			 * 4、只要出现一次，即判定当前元素为非叶子节点，更新reportRowNodeLIst中当前元素的leaf属性为false,否则为true；
			 */
			for (int reportRowNodeLIstI = 0; reportRowNodeLIstI < reportRowNodeLIst.size(); reportRowNodeLIstI++) {

				for (int levelI = 0; levelI < maxTreeStructureCodeLength / treeNodeLength; levelI++) {
					for (int treeI = reportRowNodeLIstI + 1; treeI < treeStructure.size(); treeI++) {

						/*
						 * treeStructure.get(treeI).substring(0, treeNodeLength * (levelI + 1) >
						 * treeStructure.get(treeI).length() ? treeStructure.get(treeI).length() :
						 * treeNodeLength * (levelI + 1));
						 */
						Map<String, Boolean> app = new HashMap<String, Boolean>();
						if (reportRowNodeLIst.get(reportRowNodeLIstI).getTreeStructureCode()
								.contentEquals(treeStructure.get(treeI).substring(0,
										treeNodeLength * (levelI + 1) > treeStructure.get(treeI).length()
												? treeStructure.get(treeI).length()
												: treeNodeLength * (levelI + 1)))) {
							System.out.println(treeStructure.get(treeI).substring(0,
									treeNodeLength * (levelI + 1) > treeStructure.get(treeI).length()
											? treeStructure.get(treeI).length()
											: treeNodeLength * (levelI + 1)));
							reportRowNodeLIst.get(reportRowNodeLIstI).setLeaf(false);
							break;
						}
					}
				}
				System.out.println("here:"+
						reportRowNodeLIst.get(reportRowNodeLIstI).getDimensionList().get(0).getDimensionValue());
				System.out.println(
						reportRowNodeLIst.get(reportRowNodeLIstI).getDimensionList().get(1).getDimensionValue());
				//System.out.println(reportRowNodeLIst.get(reportRowNodeLIstI).getIndicateLsit().get(0).getIndicateName()
				//		+ "=" + reportRowNodeLIst.get(reportRowNodeLIstI).getIndicateLsit().get(0).getIndicateValue());
				//System.out.println(reportRowNodeLIst.get(reportRowNodeLIstI).getIndicateLsit().get(1).getIndicateName()
				//		+ "=" + reportRowNodeLIst.get(reportRowNodeLIstI).getIndicateLsit().get(1).getIndicateValue());
				System.out.println(reportRowNodeLIst.get(reportRowNodeLIstI).isLeaf());
			}
			/*
			 * reportRowNodeLIst 中每个元素中都有维度列表与指标列表
			 */

			// File src = new File(templateFilePathAndName);
			File desc = new File(targetFilePathAndName);

			// 电网实物资产分析评价数据收集表-20182020-05-13 1024551.xls

			Workbook reportWorkBook = getWorkbok(desc);

			// sheet 对应一个工作页
			Sheet reportSheet = reportWorkBook.getSheet(sheetName);
			// int errorI = reportSheet.getPhysicalNumberOfRows();

			try {

				out = new FileOutputStream(desc);
				// 构造 Workbook 对象，execelFile 是传入文件路径(获得Excel工作区)

				// 定义 row、cell

				Row row;

				String cell;

				// 总共有多少行,从0开始

				int totalRows = reportSheet.getLastRowNum();

				// 循环输出表格中的内容,首先循环取出行,再根据行循环取出列
				// int startRowNumber = 5;
				// int startColumnNumber = 2;
				for (int i = 0; i < reportRowNodeLIst.size(); i++) {

					row = reportSheet.getRow(i + startRowNumber);

					// 处理空行

					if (row == null) {

						continue;

					}

					// 总共有多少列,从0开始

					int totalCells = row.getLastCellNum();

					// for (int j = row.getFirstCellNum(); j < totalCells; j++)
					if (reportRowNodeLIst.get(i).isLeaf()) {
						for (int j = 0; j < indQuantity; j++) {

							Cell reportCell = null;

							// 通过 row.getCell(j).toString() 获取单元格内容

							 cell = row.getCell(j + startColumnNumber).toString();
							 System.out.println("cell("+(j+1)+") value="+cell);
							// 处理空列 
							if (row.getCell(j) != null) {
							// 下面这个方法是把Excel文档中原有的Cell取到，然后进行了值的写入，不会改变原来的格式。
								reportCell = row.getCell(j + startColumnNumber);
								/**对于Excel单元格中如果进行了外值的引用，通过reportCell.setCellValue是无法进行有效赋值的，
								 * 只能先通过reportCell.setCellType(HSSFCell.CELL_TYPE_BLANK); 将单元格设置为空，
								 * 然后再进行赋值。
								 */ 
								reportCell.setCellType(HSSFCell.CELL_TYPE_BLANK);
								// 下面这个方法是创建了一个新的Cell，然后进行了值的写入，会覆盖原来的cell,原来的格式也会丢失。
								System.out.println("setCellVlue:"+reportRowNodeLIst.get(i).getIndicateLsit().get(j)
										.getIndicateValue().doubleValue());
								// reportCell = row.createCell(j + startColumnNumber);
								reportCell.setCellValue(reportRowNodeLIst.get(i).getIndicateLsit().get(j)
										.getIndicateValue().doubleValue());

								 cell = row.getCell(j + startColumnNumber).toString();
								 System.out.println("cell("+(j+1)+") value="+cell);


							}else
							 { 
									continue; 
								}

						}
					}
					// 下面的命令是刷新Excel文件中所有Sheet表格预设的公式，使之计算出其结果。
					reportWorkBook.setForceFormulaRecalculation(true);

					// 下面的命令是向desc指向Excel输出所有的数据。
					out = new FileOutputStream(desc);
					reportWorkBook.write(out);

				}

			} catch (FileNotFoundException e) {

				e.printStackTrace();

			} catch (IOException e) {

				e.printStackTrace();

			}

		} finally {
			try {
				if (out != null) {
					out.flush();
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println("数据导出成功");
	}
	
	
	
	@Autowired
	public void writeXLSXAppointedColumnAutomatic(String reportSQL, String templateFilePathAndName,
			String targetFilePathAndName, String reportName, String voltageRelationCode, String dataVersion,
			String areaName, String sheetName, int startRowNumber, int startColumnNumber, String appointedColumn,String reportAssetemplateId)
			throws SQLException, IOException {
		// System.out.println("areaName=" + areaName);
		Connection conn = null;
		conn = DbUtil.getConnection();

		List<ReportRowNode> reportRowNodeLIst = new ArrayList<ReportRowNode>();
		List<String> treeStructure = new ArrayList<String>();
		OutputStream out = null;
		try {
			// System.out.println("System.getProperty(\"user.dir\"):" +
			// System.getProperty("user.dir"));
			// System.out.println("finalXlsxPath:=" + finalXlsxPath);
			// File finalXlsxFile = new File(finalXlsxPath);// +"/"+nowdate+".xlsx");
			// System.out.println("finalXlsxFile.getName():" + finalXlsxFile.getName());

			// sheet 对应一个工作页
			// Sheet sheet = workBook.getSheetAt(0);
			// 创建预编译语句对象，一般都是用这个而不用Statement
			PreparedStatement pre = null;
			// 创建一个结果集对象
			ResultSet result = null;
			String columnSql = "SELECT * FROM REPORT_TABLE_FIELD_COLUMN A WHERE A.REPORT_NAME=TRIM(?)  ORDER BY REPORT_TABLE_FIELD_COLUMN_ID ";

			pre = conn.prepareStatement(columnSql);
			pre.setString(1, reportName);
			result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数

			List<ReportTableFieldColumn> reportTableFieldColumnList = new <ReportTableFieldColumn>ArrayList();
			int reportTableFieldColumnListI = 0;
			int treeNodeLength = 3;
			int indQuantity = 1;
			while (result.next()) {

				ReportTableFieldColumn reportTableFieldColumn = new ReportTableFieldColumn();
				reportTableFieldColumn.setReportTableFieldColumnId(result.getString("REPORT_TABLE_FIELD_COLUMN_ID"));
				reportTableFieldColumn.setReportId(result.getString("REPORT_ID"));
				reportTableFieldColumn.setReportName(result.getString("REPORT_NAME"));
				reportTableFieldColumn.setTableName(result.getString("TABLE_NAME"));
				reportTableFieldColumn.setFieldName(result.getString("FIELD_NAME"));
				reportTableFieldColumn.setIndexof(result.getDouble("INDEXOF"));
				reportTableFieldColumn.setFieldTitle(result.getString("FIELD_TITLE"));
				reportTableFieldColumn.setDimensionOrIndicate(result.getString("DIMENSION_OR_INDICATE"));
				reportTableFieldColumn.setDimensionOrIndicateType(result.getString("DIMENSION_OR_INDICATE_TYPE"));
				reportTableFieldColumn.setDiscription(result.getString("DISCRIPTION"));
				reportTableFieldColumnList.add(reportTableFieldColumnListI, reportTableFieldColumn);
				if (result.getString("DIMENSION_OR_INDICATE").contentEquals("TREE")) {
					treeNodeLength = new Integer(result.getString("DIMENSION_OR_INDICATE_TYPE"));
				}
				if (result.getString("DIMENSION_OR_INDICATE").contentEquals("IND")) {
					indQuantity++;
				}

				reportTableFieldColumnListI++;
			}

			System.out.println("treeNodeLength=" + treeNodeLength);
			// 预编译语句

			try {
				pre = conn.prepareStatement(reportSQL);
				pre.setString(1, reportAssetemplateId);
				pre.setString(2, voltageRelationCode);
				pre.setString(3, areaName);
				pre.setString(4, areaName);
				pre.setString(5, dataVersion);
				result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // 实例化预编译语句
				// 查询数据库中所有的数据
			int ReportTableFieldColumnListSize = reportTableFieldColumnList.size();
			int maxTreeStructureCodeLength = 1;
			while (result.next()) {
				ReportRowNode reportRowNode = new ReportRowNode();
				Dimension dim = new Dimension();
				Dimension dim2 = new Dimension();
				dim.setDimensionType("CATEGORY");
				//
				System.out.println("CATEGORY=" + result.getString("CATEGORY"));
				//
				System.out.println("VOLTAGE_LEVEL=" + result.getString("VOLTAGE_LEVEL"));
				if (result.getString("ASSET_CLASS_CODE").length() > maxTreeStructureCodeLength) {
					maxTreeStructureCodeLength = result.getString("ASSET_CLASS_CODE").length();
				}
				if (result.getString("VOLTAGE_LEVEL") == null) {
					dim.setDimensionCode(result.getString("ASSET_CLASS_CODE"));

				} else {
					dim.setDimensionCode(result.getString("ASSET_CLASS_CODE").substring(0,
							result.getString("ASSET_CLASS_CODE").length() - 3));
				}
				dim.setDimensionName("CATEGORY");
				dim.setDimensionValue(result.getString("CATEGORY"));
				dim2.setDimensionType("VOLTAGE_LEVEL");
				dim2.setDimensionName("VOLTAGE_LEVEL");
				dim2.setDimensionValue(result.getString("VOLTAGE_LEVEL"));

				List<Dimension> dimList = new ArrayList<Dimension>();
				dimList.add(dim);
				dimList.add(dim2);
				reportRowNode.setDimensionList(dimList);
				List<IndicateNode> indicateList = new ArrayList<IndicateNode>();
				for (int indI = 0; indI < ReportTableFieldColumnListSize; indI++) {
					/*
					 * IndicateNode indicate = new IndicateNode();
					 * indicate.setIndicateName(reportTableFieldColumnList.get(indI).getFieldName())
					 * ;
					 * 
					 * indicate.setIndicateIndexof(reportTableFieldColumnList.get(indI).getIndexof()
					 * ); indicate.setIndicateValue( new
					 * BigDecimal(result.getString(reportTableFieldColumnList.get(indI).getFieldName
					 * ()))); indicateList.add(indicate);
					 */

					if (reportTableFieldColumnList.get(indI).getDimensionOrIndicate().contentEquals("IND")) {
						IndicateNode indicate = new IndicateNode();

						indicate.setIndicateName(reportTableFieldColumnList.get(indI).getFieldName());

						indicate.setIndicateIndexof(reportTableFieldColumnList.get(indI).getIndexof());

						System.out.println(reportTableFieldColumnList.get(indI).getIndexof());
						System.out.println(reportTableFieldColumnList.get(indI).getFieldName());
						System.out.println(reportTableFieldColumnList.get(indI).getFieldName());
						System.out.println("indicateList size=" + indicateList.size());
						indicate.setIndicateValue(
								new BigDecimal(result.getString(reportTableFieldColumnList.get(indI).getFieldName())));
						indicateList.add(indicate.getIndicateIndexof().intValue(), indicate);
					} else
						continue;

				}
				reportRowNode.setIndicateLsit(indicateList);
				reportRowNode.setTreeStructureCode(result.getString("ASSET_CLASS_CODE"));
				reportRowNode.setLeaf(true);
				treeStructure.add(result.getString("ASSET_CLASS_CODE"));
				reportRowNodeLIst.add(reportRowNode);

			}

			/**
			 * 以下模块进行叶子节点判断。 逻辑是： 1、对ReportRowNodeList中的元素进行遍历；
			 * 2、根据结构树的treeNodeLength长度，从每个节点的treeStructureCode中获取子字符串；
			 * 3、于treeStructure模板列表中的剩余元素的结构树treeStructureCode的相同长度的子字符串进行匹配；
			 * 4、只要出现一次，即判定当前元素为非叶子节点，更新reportRowNodeLIst中当前元素的leaf属性为false,否则为true；
			 */
			for (int reportRowNodeLIstI = 0; reportRowNodeLIstI < reportRowNodeLIst.size(); reportRowNodeLIstI++) {

				for (int levelI = 0; levelI < maxTreeStructureCodeLength / treeNodeLength; levelI++) {
					for (int treeI = reportRowNodeLIstI + 1; treeI < treeStructure.size(); treeI++) {

						/*
						 * treeStructure.get(treeI).substring(0, treeNodeLength * (levelI + 1) >
						 * treeStructure.get(treeI).length() ? treeStructure.get(treeI).length() :
						 * treeNodeLength * (levelI + 1));
						 */
						Map<String, Boolean> app = new HashMap<String, Boolean>();
						if (reportRowNodeLIst.get(reportRowNodeLIstI).getTreeStructureCode()
								.contentEquals(treeStructure.get(treeI).substring(0,
										treeNodeLength * (levelI + 1) > treeStructure.get(treeI).length()
												? treeStructure.get(treeI).length()
												: treeNodeLength * (levelI + 1)))) {
							System.out.println(treeStructure.get(treeI).substring(0,
									treeNodeLength * (levelI + 1) > treeStructure.get(treeI).length()
											? treeStructure.get(treeI).length()
											: treeNodeLength * (levelI + 1)));
							reportRowNodeLIst.get(reportRowNodeLIstI).setLeaf(false);
							break;
						}
					}
				}
				System.out.println("here"+
						reportRowNodeLIst.get(reportRowNodeLIstI).getDimensionList().get(0).getDimensionValue());
				System.out.println(
						reportRowNodeLIst.get(reportRowNodeLIstI).getDimensionList().get(1).getDimensionValue());
				//System.out.println(reportRowNodeLIst.get(reportRowNodeLIstI).getIndicateLsit().get(0).getIndicateName()
				//		+ "=" + reportRowNodeLIst.get(reportRowNodeLIstI).getIndicateLsit().get(0).getIndicateValue());
				//System.out.println(reportRowNodeLIst.get(reportRowNodeLIstI).getIndicateLsit().get(1).getIndicateName()
				//		+ "=" + reportRowNodeLIst.get(reportRowNodeLIstI).getIndicateLsit().get(1).getIndicateValue());
				System.out.println(reportRowNodeLIst.get(reportRowNodeLIstI).isLeaf());
			}
			/*
			 * reportRowNodeLIst 中每个元素中都有维度列表与指标列表
			 */

			// File src = new File(templateFilePathAndName);
			File desc = new File(targetFilePathAndName);

			// 电网实物资产分析评价数据收集表-20182020-05-13 1024551.xls

			Workbook reportWorkBook = getWorkbok(desc);

			// sheet 对应一个工作页
			Sheet reportSheet = reportWorkBook.getSheet(sheetName);
			// int errorI = reportSheet.getPhysicalNumberOfRows();

			try {

				out = new FileOutputStream(desc);
				// 构造 Workbook 对象，execelFile 是传入文件路径(获得Excel工作区)

				// 定义 row、cell

				Row row;

				String cell;

				// 总共有多少行,从0开始

				int totalRows = reportSheet.getLastRowNum();

				// 循环输出表格中的内容,首先循环取出行,再根据行循环取出列
				// int startRowNumber = 5;
				// int startColumnNumber = 2;
				for (int i = 0; i < reportRowNodeLIst.size(); i++) {

					row = reportSheet.getRow(i + startRowNumber);

					// 处理空行

					if (row == null) {

						continue;

					}

					// 总共有多少列,从0开始

					int totalCells = row.getLastCellNum();

					// for (int j = row.getFirstCellNum(); j < totalCells; j++)
					if (reportRowNodeLIst.get(i).isLeaf()) {
						for (int j = 0; j < indQuantity - 1; j++) {

							Cell reportCell = null;
							// 下面这个方法是把Excel文档中原有的Cell取到，然后进行了值的写入，不会改变原来的格式。
							if (reportRowNodeLIst.get(i).getIndicateLsit().get(j).getIndicateName()
									.contentEquals(appointedColumn)) {
								reportCell = row.getCell(j + startColumnNumber);
								// 下面这个方法是创建了一个新的Cell，然后进行了值的写入，会覆盖原来的cell,原来的格式也会丢失。
								System.out.println("setCellVlue"+reportRowNodeLIst.get(i).getIndicateLsit().get(j)
										.getIndicateValue().doubleValue());
								// reportCell = row.createCell(j + startColumnNumber);
								reportCell.setCellValue(reportRowNodeLIst.get(i).getIndicateLsit().get(j)
										.getIndicateValue().doubleValue());
							}

							// 处理空列

							if (row.getCell(j) == null) {

								continue;

							}

							// 通过 row.getCell(j).toString() 获取单元格内容

							cell = row.getCell(j).toString();

							System.out.println(cell );

						}
					}
					// 下面的命令是刷新Excel文件中所有Sheet表格预设的公式，使之计算出其结果。
					reportWorkBook.setForceFormulaRecalculation(true);

					// 下面的命令是向desc指向Excel输出所有的数据。
					out = new FileOutputStream(desc);
					reportWorkBook.write(out);

				}

			} catch (FileNotFoundException e) {

				e.printStackTrace();

			} catch (IOException e) {

				e.printStackTrace();

			}

		} finally {
			try {
				if (out != null) {
					out.flush();
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println("数据导出成功");
	}

	@Autowired
	public void writeXLSXAppointedColumnAutomatic(String reportSQL, String templateFilePathAndName,
			String targetFilePathAndName, String reportName, String voltageRelationCode, String dataVersion,
			String areaName, String sheetName, int startRowNumber, int startColumnNumber, String appointedColumn)
			throws SQLException, IOException {
		// System.out.println("areaName=" + areaName);
		Connection conn = null;
		conn = DbUtil.getConnection();

		List<ReportRowNode> reportRowNodeLIst = new ArrayList<ReportRowNode>();
		List<String> treeStructure = new ArrayList<String>();
		OutputStream out = null;
		try {
			// System.out.println("System.getProperty(\"user.dir\"):" +
			// System.getProperty("user.dir"));
			// System.out.println("finalXlsxPath:=" + finalXlsxPath);
			// File finalXlsxFile = new File(finalXlsxPath);// +"/"+nowdate+".xlsx");
			// System.out.println("finalXlsxFile.getName():" + finalXlsxFile.getName());

			// sheet 对应一个工作页
			// Sheet sheet = workBook.getSheetAt(0);
			// 创建预编译语句对象，一般都是用这个而不用Statement
			PreparedStatement pre = null;
			// 创建一个结果集对象
			ResultSet result = null;
			String columnSql = "SELECT * FROM REPORT_TABLE_FIELD_COLUMN A WHERE A.REPORT_NAME=TRIM(?)  ORDER BY REPORT_TABLE_FIELD_COLUMN_ID ";

			pre = conn.prepareStatement(columnSql);
			pre.setString(1, reportName);
			result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数

			List<ReportTableFieldColumn> reportTableFieldColumnList = new <ReportTableFieldColumn>ArrayList();
			int reportTableFieldColumnListI = 0;
			int treeNodeLength = 3;
			int indQuantity = 1;
			while (result.next()) {

				ReportTableFieldColumn reportTableFieldColumn = new ReportTableFieldColumn();
				reportTableFieldColumn.setReportTableFieldColumnId(result.getString("REPORT_TABLE_FIELD_COLUMN_ID"));
				reportTableFieldColumn.setReportId(result.getString("REPORT_ID"));
				reportTableFieldColumn.setReportName(result.getString("REPORT_NAME"));
				reportTableFieldColumn.setTableName(result.getString("TABLE_NAME"));
				reportTableFieldColumn.setFieldName(result.getString("FIELD_NAME"));
				reportTableFieldColumn.setIndexof(result.getDouble("INDEXOF"));
				reportTableFieldColumn.setFieldTitle(result.getString("FIELD_TITLE"));
				reportTableFieldColumn.setDimensionOrIndicate(result.getString("DIMENSION_OR_INDICATE"));
				reportTableFieldColumn.setDimensionOrIndicateType(result.getString("DIMENSION_OR_INDICATE_TYPE"));
				reportTableFieldColumn.setDiscription(result.getString("DISCRIPTION"));
				reportTableFieldColumnList.add(reportTableFieldColumnListI, reportTableFieldColumn);
				if (result.getString("DIMENSION_OR_INDICATE").contentEquals("TREE")) {
					treeNodeLength = new Integer(result.getString("DIMENSION_OR_INDICATE_TYPE"));
				}
				if (result.getString("DIMENSION_OR_INDICATE").contentEquals("IND")) {
					indQuantity++;
				}

				reportTableFieldColumnListI++;
			}

			System.out.println("treeNodeLength=" + treeNodeLength);
			// 预编译语句

			try {
				pre = conn.prepareStatement(reportSQL); 
				pre.setString(1, voltageRelationCode);
				pre.setString(2, areaName);
				pre.setString(3, areaName);
				pre.setString(4, dataVersion);
				result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // 实例化预编译语句
				// 查询数据库中所有的数据
			int ReportTableFieldColumnListSize = reportTableFieldColumnList.size();
			int maxTreeStructureCodeLength = 1;
			while (result.next()) {
				ReportRowNode reportRowNode = new ReportRowNode();
				Dimension dim = new Dimension();
				Dimension dim2 = new Dimension();
				dim.setDimensionType("CATEGORY");
				//
				System.out.println("CATEGORY=" + result.getString("CATEGORY"));
				//
				System.out.println("VOLTAGE_LEVEL=" + result.getString("VOLTAGE_LEVEL"));
				if (result.getString("ASSET_CLASS_CODE").length() > maxTreeStructureCodeLength) {
					maxTreeStructureCodeLength = result.getString("ASSET_CLASS_CODE").length();
				}
				if (result.getString("VOLTAGE_LEVEL") == null) {
					dim.setDimensionCode(result.getString("ASSET_CLASS_CODE"));

				} else {
					dim.setDimensionCode(result.getString("ASSET_CLASS_CODE").substring(0,
							result.getString("ASSET_CLASS_CODE").length() - 3));
				}
				dim.setDimensionName("CATEGORY");
				dim.setDimensionValue(result.getString("CATEGORY"));
				dim2.setDimensionType("VOLTAGE_LEVEL");
				dim2.setDimensionName("VOLTAGE_LEVEL");
				dim2.setDimensionValue(result.getString("VOLTAGE_LEVEL"));

				List<Dimension> dimList = new ArrayList<Dimension>();
				dimList.add(dim);
				dimList.add(dim2);
				reportRowNode.setDimensionList(dimList);
				List<IndicateNode> indicateList = new ArrayList<IndicateNode>();
				for (int indI = 0; indI < ReportTableFieldColumnListSize; indI++) {
					/*
					 * IndicateNode indicate = new IndicateNode();
					 * indicate.setIndicateName(reportTableFieldColumnList.get(indI).getFieldName())
					 * ;
					 * 
					 * indicate.setIndicateIndexof(reportTableFieldColumnList.get(indI).getIndexof()
					 * ); indicate.setIndicateValue( new
					 * BigDecimal(result.getString(reportTableFieldColumnList.get(indI).getFieldName
					 * ()))); indicateList.add(indicate);
					 */

					if (reportTableFieldColumnList.get(indI).getDimensionOrIndicate().contentEquals("IND")) {
						IndicateNode indicate = new IndicateNode();

						indicate.setIndicateName(reportTableFieldColumnList.get(indI).getFieldName());

						indicate.setIndicateIndexof(reportTableFieldColumnList.get(indI).getIndexof());

						System.out.println(reportTableFieldColumnList.get(indI).getIndexof());
						System.out.println(reportTableFieldColumnList.get(indI).getFieldName());
						System.out.println(reportTableFieldColumnList.get(indI).getFieldName());
						System.out.println("indicateList size=" + indicateList.size());
						indicate.setIndicateValue(
								new BigDecimal(result.getString(reportTableFieldColumnList.get(indI).getFieldName())));
						indicateList.add(indicate.getIndicateIndexof().intValue(), indicate);
					} else
						continue;

				}
				reportRowNode.setIndicateLsit(indicateList);
				reportRowNode.setTreeStructureCode(result.getString("ASSET_CLASS_CODE"));
				reportRowNode.setLeaf(true);
				treeStructure.add(result.getString("ASSET_CLASS_CODE"));
				reportRowNodeLIst.add(reportRowNode);

			}

			/**
			 * 以下模块进行叶子节点判断。 逻辑是： 1、对ReportRowNodeList中的元素进行遍历；
			 * 2、根据结构树的treeNodeLength长度，从每个节点的treeStructureCode中获取子字符串；
			 * 3、于treeStructure模板列表中的剩余元素的结构树treeStructureCode的相同长度的子字符串进行匹配；
			 * 4、只要出现一次，即判定当前元素为非叶子节点，更新reportRowNodeLIst中当前元素的leaf属性为false,否则为true；
			 */
			for (int reportRowNodeLIstI = 0; reportRowNodeLIstI < reportRowNodeLIst.size(); reportRowNodeLIstI++) {

				for (int levelI = 0; levelI < maxTreeStructureCodeLength / treeNodeLength; levelI++) {
					for (int treeI = reportRowNodeLIstI + 1; treeI < treeStructure.size(); treeI++) {

						/*
						 * treeStructure.get(treeI).substring(0, treeNodeLength * (levelI + 1) >
						 * treeStructure.get(treeI).length() ? treeStructure.get(treeI).length() :
						 * treeNodeLength * (levelI + 1));
						 */
						Map<String, Boolean> app = new HashMap<String, Boolean>();
						if (reportRowNodeLIst.get(reportRowNodeLIstI).getTreeStructureCode()
								.contentEquals(treeStructure.get(treeI).substring(0,
										treeNodeLength * (levelI + 1) > treeStructure.get(treeI).length()
												? treeStructure.get(treeI).length()
												: treeNodeLength * (levelI + 1)))) {
							System.out.println(treeStructure.get(treeI).substring(0,
									treeNodeLength * (levelI + 1) > treeStructure.get(treeI).length()
											? treeStructure.get(treeI).length()
											: treeNodeLength * (levelI + 1)));
							reportRowNodeLIst.get(reportRowNodeLIstI).setLeaf(false);
							break;
						}
					}
				}
				System.out.println("here"+
						reportRowNodeLIst.get(reportRowNodeLIstI).getDimensionList().get(0).getDimensionValue());
				System.out.println(
						reportRowNodeLIst.get(reportRowNodeLIstI).getDimensionList().get(1).getDimensionValue());
				//System.out.println(reportRowNodeLIst.get(reportRowNodeLIstI).getIndicateLsit().get(0).getIndicateName()
				//		+ "=" + reportRowNodeLIst.get(reportRowNodeLIstI).getIndicateLsit().get(0).getIndicateValue());
				//System.out.println(reportRowNodeLIst.get(reportRowNodeLIstI).getIndicateLsit().get(1).getIndicateName()
				//		+ "=" + reportRowNodeLIst.get(reportRowNodeLIstI).getIndicateLsit().get(1).getIndicateValue());
				System.out.println(reportRowNodeLIst.get(reportRowNodeLIstI).isLeaf());
			}
			/*
			 * reportRowNodeLIst 中每个元素中都有维度列表与指标列表
			 */

			// File src = new File(templateFilePathAndName);
			File desc = new File(targetFilePathAndName);

			// 电网实物资产分析评价数据收集表-20182020-05-13 1024551.xls

			Workbook reportWorkBook = getWorkbok(desc);

			// sheet 对应一个工作页
			Sheet reportSheet = reportWorkBook.getSheet(sheetName);
			// int errorI = reportSheet.getPhysicalNumberOfRows();

			try {

				out = new FileOutputStream(desc);
				// 构造 Workbook 对象，execelFile 是传入文件路径(获得Excel工作区)

				// 定义 row、cell

				Row row;

				String cell;

				// 总共有多少行,从0开始

				int totalRows = reportSheet.getLastRowNum();

				// 循环输出表格中的内容,首先循环取出行,再根据行循环取出列
				// int startRowNumber = 5;
				// int startColumnNumber = 2;
				for (int i = 0; i < reportRowNodeLIst.size(); i++) {

					row = reportSheet.getRow(i + startRowNumber);

					// 处理空行

					if (row == null) {

						continue;

					}

					// 总共有多少列,从0开始

					int totalCells = row.getLastCellNum();

					// for (int j = row.getFirstCellNum(); j < totalCells; j++)
					if (reportRowNodeLIst.get(i).isLeaf()) {
						for (int j = 0; j < indQuantity - 1; j++) {

							Cell reportCell = null;
							// 下面这个方法是把Excel文档中原有的Cell取到，然后进行了值的写入，不会改变原来的格式。
							if (reportRowNodeLIst.get(i).getIndicateLsit().get(j).getIndicateName()
									.contentEquals(appointedColumn)) {
								reportCell = row.getCell(j + startColumnNumber);
								// 下面这个方法是创建了一个新的Cell，然后进行了值的写入，会覆盖原来的cell,原来的格式也会丢失。
								System.out.println("setCellVlue"+reportRowNodeLIst.get(i).getIndicateLsit().get(j)
										.getIndicateValue().doubleValue());
								// reportCell = row.createCell(j + startColumnNumber);
								reportCell.setCellValue(reportRowNodeLIst.get(i).getIndicateLsit().get(j)
										.getIndicateValue().doubleValue());
							}

							// 处理空列

							if (row.getCell(j) == null) {

								continue;

							}

							// 通过 row.getCell(j).toString() 获取单元格内容

							cell = row.getCell(j).toString();

							System.out.println(cell );

						}
					}
					// 下面的命令是刷新Excel文件中所有Sheet表格预设的公式，使之计算出其结果。
					reportWorkBook.setForceFormulaRecalculation(true);

					// 下面的命令是向desc指向Excel输出所有的数据。
					out = new FileOutputStream(desc);
					reportWorkBook.write(out);

				}

			} catch (FileNotFoundException e) {

				e.printStackTrace();

			} catch (IOException e) {

				e.printStackTrace();

			}

		} finally {
			try {
				if (out != null) {
					out.flush();
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println("数据导出成功");
	}

	@Autowired
	public void writeXLSXIncreased(String reportSQL, String templateFilePathAndName, String targetFilePathAndName,
			String reportName, String voltageRelationCode, String pmsDataVersion, String erpDataVersion,
			String areaName, String sheetName, int startRowNumber, int startColumnNumber)
			throws SQLException, IOException {
		// System.out.println("areaName=" + areaName);

		// String pmsDataVersion = "M_2019_3";//20200612--PMS
		// String erpDataVersion = "M_2019_3";//20200613--ERP

		Connection conn = null;
		conn = DbUtil.getConnection();

		List<ReportRowNode> reportRowNodeLIst = new ArrayList<ReportRowNode>();
		List<ReportRowNode> treeStructure = new ArrayList<ReportRowNode>();
		OutputStream out = null;
		try {
			PreparedStatement pre = null;
			// 创建一个结果集对象
			ResultSet result = null;
			String columnSql = "SELECT * FROM REPORT_TABLE_FIELD_COLUMN A WHERE A.REPORT_NAME=TRIM(?)  ORDER BY REPORT_TABLE_FIELD_COLUMN_ID ";

			pre = conn.prepareStatement(columnSql);
			pre.setString(1, reportName);
			result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数

			List<ReportTableFieldColumn> reportTableFieldColumnList = new <ReportTableFieldColumn>ArrayList();
			int reportTableFieldColumnListI = 0;
			int treeNodeLength = 1;
			int indQuantity = 1;
			while (result.next()) {

				ReportTableFieldColumn reportTableFieldColumn = new ReportTableFieldColumn();
				reportTableFieldColumn.setReportTableFieldColumnId(result.getString("REPORT_TABLE_FIELD_COLUMN_ID"));
				reportTableFieldColumn.setReportId(result.getString("REPORT_ID"));
				reportTableFieldColumn.setReportName(result.getString("REPORT_NAME"));
				reportTableFieldColumn.setTableName(result.getString("TABLE_NAME"));
				reportTableFieldColumn.setFieldName(result.getString("FIELD_NAME"));
				reportTableFieldColumn.setIndexof(result.getDouble("INDEXOF"));
				reportTableFieldColumn.setFieldTitle(result.getString("FIELD_TITLE"));
				reportTableFieldColumn.setDimensionOrIndicate(result.getString("DIMENSION_OR_INDICATE"));
				reportTableFieldColumn.setDimensionOrIndicateType(result.getString("DIMENSION_OR_INDICATE_TYPE"));
				reportTableFieldColumn.setDiscription(result.getString("DISCRIPTION"));
				reportTableFieldColumnList.add(reportTableFieldColumnListI, reportTableFieldColumn);
				if (result.getString("DIMENSION_OR_INDICATE").contentEquals("TREE")) {
					treeNodeLength = new Integer(result.getString("DIMENSION_OR_INDICATE_TYPE"));
				}
				if (result.getString("DIMENSION_OR_INDICATE").contentEquals("IND")) {
					indQuantity++;
				}

				reportTableFieldColumnListI++;
			}

			System.out.println("treeNodeLength=" + treeNodeLength);
			// 预编译语句

			// String pmsDataVersion = "M_2019_3";//20200612--PMS
			// String erpDataVersion = "M_2019_3";//20200613--ERP
			try {
				pre = conn.prepareStatement(reportSQL);
				pre.setString(1, voltageRelationCode);
				pre.setString(2, areaName);
				pre.setString(3, areaName);
				pre.setString(4, erpDataVersion);
				pre.setString(5, areaName);
				pre.setString(6, areaName);
				pre.setString(7, pmsDataVersion);
				result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // 实例化预编译语句
				// 查询数据库中所有的数据
			int reportTableFieldColumnListSize = reportTableFieldColumnList.size();
			int maxTreeStructureCodeLength = 1;
			while (result.next()) {
				ReportRowNode reportRowNode = new ReportRowNode();
				Dimension dim = new Dimension();
				Dimension dim2 = new Dimension();
				Dimension dim3 = new Dimension();
				dim.setDimensionType("CATEGORY");
				//
				System.out.println("CATEGORY=" + result.getString("CATEGORY"));
				//
				System.out.println("VOLTAGE_LEVEL=" + result.getString("VOLTAGE_LEVEL"));
				if (result.getString("ASSET_CLASS_CODE").length() > maxTreeStructureCodeLength) {
					maxTreeStructureCodeLength = result.getString("ASSET_CLASS_CODE").length();
				}
				if (result.getString("VOLTAGE_LEVEL") == null) {
					dim.setDimensionCode(result.getString("ASSET_CLASS_CODE"));

				} else {
					dim.setDimensionCode(result.getString("ASSET_CLASS_CODE").substring(0,
							result.getString("ASSET_CLASS_CODE").length() - 3));
				}
				dim.setDimensionName("CATEGORY");
				dim.setDimensionValue(result.getString("CATEGORY"));
				dim2.setDimensionType("VOLTAGE_LEVEL");
				dim2.setDimensionName("VOLTAGE_LEVEL");
				dim2.setDimensionValue(result.getString("VOLTAGE_LEVEL"));
				dim3.setDimensionType("INDICATE_DIMENSION");
				dim3.setDimensionName("INDICATE_DIMENSION");
				dim3.setDimensionValue(result.getString("INDICATE_DIMENSION"));

				Map<String, Dimension> dimMap = new HashMap<String, Dimension>();
				dimMap.put("CATEGORY", dim);
				dimMap.put("VOLTAGE_LEVEL", dim2);
				dimMap.put("INDICATE_DIMENSION", dim3);
				List<Dimension> dimList = new ArrayList<Dimension>();
				dimList.add(dim);
				dimList.add(dim2);
				dimList.add(dim3);

				reportRowNode.setDimensionList(dimList);
				reportRowNode.setDimensionMap(dimMap);
				// 指标列表
				List<IndicateNode> indicateList = new ArrayList<IndicateNode>();

				for (int indI = 0; indI < reportTableFieldColumnListSize; indI++) {

					if (reportTableFieldColumnList.get(indI).getDimensionOrIndicate().contentEquals("IND")) {
						IndicateNode indicate = new IndicateNode();

						indicate.setIndicateName(reportTableFieldColumnList.get(indI).getFieldName());

						indicate.setIndicateIndexof(reportTableFieldColumnList.get(indI).getIndexof());

						System.out.println(reportTableFieldColumnList.get(indI).getIndexof());
						System.out.println(reportTableFieldColumnList.get(indI).getFieldName());
						System.out.println(reportTableFieldColumnList.get(indI).getFieldName());
						indicate.setIndicateValue(
								new BigDecimal(result.getString(reportTableFieldColumnList.get(indI).getFieldName())));
						indicateList.add(indicate.getIndicateIndexof().intValue(), indicate);
					} else
						continue;

				}
				reportRowNode.setIndicateLsit(indicateList);
				reportRowNode.setTreeStructureCode(result.getString("ASSET_CLASS_CODE"));
				reportRowNode.setLeaf(true);
				treeStructure.add(reportRowNode);
				reportRowNodeLIst.add(reportRowNode);
			}

			/**
			 * 以下模块进行叶子节点判断。 逻辑是： 1、对ReportRowNodeList中的元素进行遍历；
			 * 2、根据结构树的treeNodeLength长度，从每个节点的treeStructureCode中获取子字符串；
			 * 3、于treeStructure模板列表中的剩余元素的结构树treeStructureCode的相同长度的子字符串进行匹配；
			 * 4、只要出现一次，即判定当前元素为非叶子节点，更新reportRowNodeLIst中当前元素的leaf属性为false,否则为true；
			 */
			for (int reportRowNodeLIstI = 0; reportRowNodeLIstI < reportRowNodeLIst.size(); reportRowNodeLIstI++) {

				for (int levelI = 0; levelI < (maxTreeStructureCodeLength / treeNodeLength); levelI++) {
					for (int treeI = reportRowNodeLIstI + 1; treeI < treeStructure.size(); treeI++) {

						/*
						 * treeStructure.get(treeI).substring(0, treeNodeLength * (levelI + 1) >
						 * treeStructure.get(treeI).length() ? treeStructure.get(treeI).length() :
						 * treeNodeLength * (levelI + 1));
						 */
						/*
						 * reportRowNodeLIst.get(reportRowNodeLIstI).getDimensionMap().get(
						 * "INDICATE_DIMENSION") .getDimensionValue(); System.out.println("L=" +
						 * (reportRowNodeLIst.get(reportRowNodeLIstI).getTreeStructureCode() +
						 * reportRowNodeLIst.get(reportRowNodeLIstI).getDimensionMap().get(
						 * "INDICATE_DIMENSION") .getDimensionValue())); System.out.println("R=" +
						 * treeStructure.get(treeI).substring(0, treeNodeLength * (levelI + 1) >
						 * treeStructure.get(treeI).length() ? treeStructure.get(treeI).length() :
						 * treeNodeLength * (levelI + 1)) +
						 * reportRowNodeLIst.get(reportRowNodeLIstI).getDimensionMap().get(
						 * "INDICATE_DIMENSION") .getDimensionValue());
						 */
						// Map<String, Boolean> app = new HashMap<String, Boolean>();
						if ((reportRowNodeLIst.get(reportRowNodeLIstI).getTreeStructureCode()
								+ reportRowNodeLIst.get(reportRowNodeLIstI).getDimensionMap().get("INDICATE_DIMENSION")
										.getDimensionValue()).contentEquals(
												treeStructure.get(treeI).getTreeStructureCode().substring(0,
														treeNodeLength * (levelI + 1) > treeStructure.get(treeI)
																.getTreeStructureCode().length()
																		? treeStructure.get(treeI)
																				.getTreeStructureCode().length()
																		: treeNodeLength * (levelI + 1))
														+ treeStructure.get(treeI).getDimensionMap()
																.get("INDICATE_DIMENSION").getDimensionValue())) {
							System.out.println((reportRowNodeLIst.get(reportRowNodeLIstI).getTreeStructureCode()
									+ reportRowNodeLIst.get(reportRowNodeLIstI).getDimensionMap()
											.get("INDICATE_DIMENSION").getDimensionValue()));
							System.out.println(treeStructure.get(treeI).getTreeStructureCode().substring(0,
									treeNodeLength * (levelI + 1) > treeStructure.get(treeI).getTreeStructureCode()
											.length() ? treeStructure.get(treeI).getTreeStructureCode().length()
													: treeNodeLength * (levelI + 1))
									+ treeStructure.get(treeI).getDimensionMap().get("INDICATE_DIMENSION")
											.getDimensionValue());
							reportRowNodeLIst.get(reportRowNodeLIstI).setLeaf(false);
							break;
						}
					}
				}
				System.out.println(
						reportRowNodeLIst.get(reportRowNodeLIstI).getDimensionList().get(0).getDimensionValue());
				System.out.println(
						reportRowNodeLIst.get(reportRowNodeLIstI).getDimensionList().get(1).getDimensionValue());
				System.out.println(reportRowNodeLIst.get(reportRowNodeLIstI).getIndicateLsit().size());
				System.out.println(reportRowNodeLIst.get(reportRowNodeLIstI).getIndicateLsit().get(0).getIndicateName()
						+ "=" + reportRowNodeLIst.get(reportRowNodeLIstI).getIndicateLsit().get(0).getIndicateValue());
				System.out.println(reportRowNodeLIst.get(reportRowNodeLIstI).getIndicateLsit().get(1).getIndicateName()
						+ "=" + reportRowNodeLIst.get(reportRowNodeLIstI).getIndicateLsit().get(1).getIndicateValue());
				System.out.println(reportRowNodeLIst.get(reportRowNodeLIstI).isLeaf());
			}
			/*
			 * reportRowNodeLIst 中每个元素中都有维度列表与指标列表
			 */

			// File src = new File(templateFilePathAndName);
			File desc = new File(targetFilePathAndName);

			// 电网实物资产分析评价数据收集表-20182020-05-13 1024551.xls

			Workbook reportWorkBook = getWorkbok(desc);

			// sheet 对应一个工作页
			Sheet reportSheet = reportWorkBook.getSheet(sheetName);
			// int errorI = reportSheet.getPhysicalNumberOfRows();

			try {

				out = new FileOutputStream(desc);
				// 构造 Workbook 对象，execelFile 是传入文件路径(获得Excel工作区)

				// 定义 row、cell

				Row row;

				String cell;

				// 总共有多少行,从0开始

				int totalRows = reportSheet.getLastRowNum();

				// 循环输出表格中的内容,首先循环取出行,再根据行循环取出列
				// int startRowNumber = 5;
				// int startColumnNumber = 2;
				for (int i = 0; i < reportRowNodeLIst.size(); i++) {

					row = reportSheet.getRow(i + startRowNumber);

					// 处理空行

					if (row == null) {

						continue;

					}

					// 总共有多少列,从0开始

					int totalCells = row.getLastCellNum();

					// for (int j = row.getFirstCellNum(); j < totalCells; j++)
					if (reportRowNodeLIst.get(i).isLeaf()) {
						for (int j = 0; j < indQuantity - 1; j++) {

							Cell reportCell = null;
							// 下面这个方法是把Excel文档中原有的Cell取到，然后进行了值的写入，不会改变原来的格式。
							reportCell = row.getCell(j + startColumnNumber);
							// 下面这个方法是创建了一个新的Cell，然后进行了值的写入，会覆盖原来的cell,原来的格式也会丢失。
							// reportCell = row.createCell(j + startColumnNumber);
							reportCell.setCellValue(
									reportRowNodeLIst.get(i).getIndicateLsit().get(j).getIndicateValue().doubleValue());

							// 处理空列

							if (row.getCell(j) == null) {

								continue;

							}

							// 通过 row.getCell(j).toString() 获取单元格内容

							cell = row.getCell(j).toString();

							System.out.print(cell + "\t");

						}
					}
					// 下面的命令是刷新Excel文件中所有Sheet表格预设的公式，使之计算出其结果。
					reportWorkBook.setForceFormulaRecalculation(true);

					// 下面的命令是向desc指向Excel输出所有的数据。
					out = new FileOutputStream(desc);
					reportWorkBook.write(out);

				}

			} catch (FileNotFoundException e) {

				e.printStackTrace();

			} catch (IOException e) {

				e.printStackTrace();

			}

		} finally {
			try {
				if (out != null) {
					out.flush();
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println("数据导出成功");
	}

	@Autowired
	public void writeXLSXDiscard(String reportSQL, String templateFilePathAndName, String targetFilePathAndName,
			String reportName, String voltageRelationCode, String dataVersion, String areaName, String sheetName,
			int startRowNumber, int startColumnNumber) throws SQLException, IOException {
		// System.out.println("areaName=" + areaName);

		// String pmsDataVersion = "M_2019_3";//20200612--PMS
		// String erpDataVersion = "M_2019_3";//20200613--ERP

		Connection conn = null;
		conn = DbUtil.getConnection();

		List<ReportRowNode> reportRowNodeLIst = new ArrayList<ReportRowNode>();
		List<ReportRowNode> treeStructure = new ArrayList<ReportRowNode>();
		OutputStream out = null;
		try {
			PreparedStatement pre = null;
			// 创建一个结果集对象
			ResultSet result = null;
			String columnSql = "SELECT * FROM REPORT_TABLE_FIELD_COLUMN A WHERE A.REPORT_NAME=TRIM(?)  ORDER BY REPORT_TABLE_FIELD_COLUMN_ID ";

			pre = conn.prepareStatement(columnSql);
			pre.setString(1, reportName);
			result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数

			List<ReportTableFieldColumn> reportTableFieldColumnList = new <ReportTableFieldColumn>ArrayList();
			int reportTableFieldColumnListI = 0;
			int treeNodeLength = 1;
			int indQuantity = 1;
			while (result.next()) {

				ReportTableFieldColumn reportTableFieldColumn = new ReportTableFieldColumn();
				reportTableFieldColumn.setReportTableFieldColumnId(result.getString("REPORT_TABLE_FIELD_COLUMN_ID"));
				reportTableFieldColumn.setReportId(result.getString("REPORT_ID"));
				reportTableFieldColumn.setReportName(result.getString("REPORT_NAME"));
				reportTableFieldColumn.setTableName(result.getString("TABLE_NAME"));
				reportTableFieldColumn.setFieldName(result.getString("FIELD_NAME"));
				reportTableFieldColumn.setIndexof(result.getDouble("INDEXOF"));
				reportTableFieldColumn.setFieldTitle(result.getString("FIELD_TITLE"));
				reportTableFieldColumn.setDimensionOrIndicate(result.getString("DIMENSION_OR_INDICATE"));
				reportTableFieldColumn.setDimensionOrIndicateType(result.getString("DIMENSION_OR_INDICATE_TYPE"));
				reportTableFieldColumn.setDiscription(result.getString("DISCRIPTION"));
				reportTableFieldColumnList.add(reportTableFieldColumnListI, reportTableFieldColumn);
				if (result.getString("DIMENSION_OR_INDICATE").contentEquals("TREE")) {
					treeNodeLength = new Integer(result.getString("DIMENSION_OR_INDICATE_TYPE"));
				}
				if (result.getString("DIMENSION_OR_INDICATE").contentEquals("IND")) {
					indQuantity++;
				}

				reportTableFieldColumnListI++;
			}

			System.out.println("treeNodeLength=" + treeNodeLength);
			// 预编译语句

			// String pmsDataVersion = "M_2019_3";//20200612--PMS
			// String erpDataVersion = "M_2019_3";//20200613--ERP
			try {
				pre = conn.prepareStatement(reportSQL);
				pre.setString(1, voltageRelationCode);
				pre.setString(2, areaName);
				pre.setString(3, areaName);
				pre.setString(4, dataVersion);
				result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // 实例化预编译语句
				// 查询数据库中所有的数据
			int reportTableFieldColumnListSize = reportTableFieldColumnList.size();
			int maxTreeStructureCodeLength = 1;
			while (result.next()) {
				ReportRowNode reportRowNode = new ReportRowNode();
				Dimension dim = new Dimension();
				Dimension dim2 = new Dimension();
				Dimension dim3 = new Dimension();
				dim.setDimensionType("CATEGORY");
				//
				System.out.println("CATEGORY=" + result.getString("CATEGORY"));
				//
				System.out.println("VOLTAGE_LEVEL=" + result.getString("VOLTAGE_LEVEL"));
				if (result.getString("ASSET_CLASS_CODE").length() > maxTreeStructureCodeLength) {
					maxTreeStructureCodeLength = result.getString("ASSET_CLASS_CODE").length();
				}
				if (result.getString("VOLTAGE_LEVEL") == null) {
					dim.setDimensionCode(result.getString("ASSET_CLASS_CODE"));

				} else {
					dim.setDimensionCode(result.getString("ASSET_CLASS_CODE").substring(0,
							result.getString("ASSET_CLASS_CODE").length() - 3));
				}
				dim.setDimensionName("CATEGORY");
				dim.setDimensionValue(result.getString("CATEGORY"));
				dim2.setDimensionType("VOLTAGE_LEVEL");
				dim2.setDimensionName("VOLTAGE_LEVEL");
				dim2.setDimensionValue(result.getString("VOLTAGE_LEVEL"));
				dim3.setDimensionType("INDICATE_DIMENSION");
				dim3.setDimensionName("INDICATE_DIMENSION");
				dim3.setDimensionValue(result.getString("INDICATE_DIMENSION"));

				Map<String, Dimension> dimMap = new HashMap<String, Dimension>();
				dimMap.put("CATEGORY", dim);
				dimMap.put("VOLTAGE_LEVEL", dim2);
				dimMap.put("INDICATE_DIMENSION", dim3);
				List<Dimension> dimList = new ArrayList<Dimension>();
				dimList.add(dim);
				dimList.add(dim2);
				dimList.add(dim3);

				reportRowNode.setDimensionList(dimList);
				reportRowNode.setDimensionMap(dimMap);
				// 指标列表
				List<IndicateNode> indicateList = new ArrayList<IndicateNode>();

				for (int indI = 0; indI < reportTableFieldColumnListSize; indI++) {

					if (reportTableFieldColumnList.get(indI).getDimensionOrIndicate().contentEquals("IND")) {
						IndicateNode indicate = new IndicateNode();

						indicate.setIndicateName(reportTableFieldColumnList.get(indI).getFieldName());

						indicate.setIndicateIndexof(reportTableFieldColumnList.get(indI).getIndexof());

						System.out.println(reportTableFieldColumnList.get(indI).getIndexof());
						System.out.println(reportTableFieldColumnList.get(indI).getFieldName());
						System.out.println(reportTableFieldColumnList.get(indI).getFieldName());
						indicate.setIndicateValue(
								new BigDecimal(result.getString(reportTableFieldColumnList.get(indI).getFieldName())));
						System.out.println(
								"indicate.getIndicateIndexof().intValue()=" + indicate.getIndicateIndexof().intValue());

						indicateList.add(indicate.getIndicateIndexof().intValue(), indicate);
					} else
						continue;

				}
				reportRowNode.setIndicateLsit(indicateList);
				reportRowNode.setTreeStructureCode(result.getString("ASSET_CLASS_CODE"));
				reportRowNode.setLeaf(true);
				treeStructure.add(reportRowNode);
				reportRowNodeLIst.add(reportRowNode);
			}

			/**
			 * 以下模块进行叶子节点判断。 逻辑是： 1、对ReportRowNodeList中的元素进行遍历；
			 * 2、根据结构树的treeNodeLength长度，从每个节点的treeStructureCode中获取子字符串；
			 * 3、于treeStructure模板列表中的剩余元素的结构树treeStructureCode的相同长度的子字符串进行匹配；
			 * 4、只要出现一次，即判定当前元素为非叶子节点，更新reportRowNodeLIst中当前元素的leaf属性为false,否则为true；
			 */
			for (int reportRowNodeLIstI = 0; reportRowNodeLIstI < reportRowNodeLIst.size(); reportRowNodeLIstI++) {

				for (int levelI = 0; levelI < (maxTreeStructureCodeLength / treeNodeLength); levelI++) {
					for (int treeI = reportRowNodeLIstI + 1; treeI < treeStructure.size(); treeI++) {

						if ((reportRowNodeLIst.get(reportRowNodeLIstI).getTreeStructureCode()
								+ reportRowNodeLIst.get(reportRowNodeLIstI).getDimensionMap().get("INDICATE_DIMENSION")
										.getDimensionValue()).contentEquals(
												treeStructure.get(treeI).getTreeStructureCode().substring(0,
														treeNodeLength * (levelI + 1) > treeStructure.get(treeI)
																.getTreeStructureCode().length()
																		? treeStructure.get(treeI)
																				.getTreeStructureCode().length()
																		: treeNodeLength * (levelI + 1))
														+ treeStructure.get(treeI).getDimensionMap()
																.get("INDICATE_DIMENSION").getDimensionValue())) {
							System.out.println((reportRowNodeLIst.get(reportRowNodeLIstI).getTreeStructureCode()
									+ reportRowNodeLIst.get(reportRowNodeLIstI).getDimensionMap()
											.get("INDICATE_DIMENSION").getDimensionValue()));
							System.out.println(treeStructure.get(treeI).getTreeStructureCode().substring(0,
									treeNodeLength * (levelI + 1) > treeStructure.get(treeI).getTreeStructureCode()
											.length() ? treeStructure.get(treeI).getTreeStructureCode().length()
													: treeNodeLength * (levelI + 1))
									+ treeStructure.get(treeI).getDimensionMap().get("INDICATE_DIMENSION")
											.getDimensionValue());
							reportRowNodeLIst.get(reportRowNodeLIstI).setLeaf(false);
							break;
						}
					}
				}
				System.out.println(
						reportRowNodeLIst.get(reportRowNodeLIstI).getDimensionList().get(0).getDimensionValue());
				System.out.println(
						reportRowNodeLIst.get(reportRowNodeLIstI).getDimensionList().get(1).getDimensionValue());
				System.out.println(reportRowNodeLIst.get(reportRowNodeLIstI).getIndicateLsit().size());
				System.out.println(reportRowNodeLIst.get(reportRowNodeLIstI).getIndicateLsit().get(0).getIndicateName()
						+ "=" + reportRowNodeLIst.get(reportRowNodeLIstI).getIndicateLsit().get(0).getIndicateValue());
				System.out.println(reportRowNodeLIst.get(reportRowNodeLIstI).getIndicateLsit().get(1).getIndicateName()
						+ "=" + reportRowNodeLIst.get(reportRowNodeLIstI).getIndicateLsit().get(1).getIndicateValue());
				System.out.println(reportRowNodeLIst.get(reportRowNodeLIstI).isLeaf());
			}
			/*
			 * reportRowNodeLIst 中每个元素中都有维度列表与指标列表
			 */

			// File src = new File(templateFilePathAndName);
			File desc = new File(targetFilePathAndName);

			// 电网实物资产分析评价数据收集表-20182020-05-13 1024551.xls

			Workbook reportWorkBook = getWorkbok(desc);

			// sheet 对应一个工作页
			Sheet reportSheet = reportWorkBook.getSheet(sheetName);
			// int errorI = reportSheet.getPhysicalNumberOfRows();

			try {

				out = new FileOutputStream(desc);
				// 构造 Workbook 对象，execelFile 是传入文件路径(获得Excel工作区)

				// 定义 row、cell

				Row row;

				// String cell;

				// 总共有多少行,从0开始

				// int totalRows = reportSheet.getLastRowNum();

				// 循环输出表格中的内容,首先循环取出行,再根据行循环取出列
				// int startRowNumber = 5;
				// int startColumnNumber = 2;
				for (int i = 0; i < reportRowNodeLIst.size(); i++) {

					row = reportSheet.getRow(i + startRowNumber);

					// 处理空行

					if (row == null) {

						continue;

					}

					// 总共有多少列,从0开始

					int totalCells = row.getLastCellNum();

					// for (int j = row.getFirstCellNum(); j < totalCells; j++)
					if (reportRowNodeLIst.get(i).isLeaf()) {
						for (int j = 0; j < indQuantity - 1; j++) {

							Cell reportCell = null;
							// 下面这个方法是把Excel文档中原有的Cell取到，然后进行了值的写入，不会改变原来的格式。
							reportCell = row.getCell(j + startColumnNumber);
							// 下面这个方法是创建了一个新的Cell，然后进行了值的写入，会覆盖原来的cell,原来的格式也会丢失。
							// reportCell = row.createCell(j + startColumnNumber);
							reportCell.setCellValue(
									reportRowNodeLIst.get(i).getIndicateLsit().get(j).getIndicateValue().doubleValue());

							// 处理空列

							if (row.getCell(j) == null) {

								continue;

							}

							// 通过 row.getCell(j).toString() 获取单元格内容

							// cell = row.getCell(j).toString();

							// System.out.print(cell + "\t");

						}
					}
					// 下面的命令是刷新Excel文件中所有Sheet表格预设的公式，使之计算出其结果。
					reportWorkBook.setForceFormulaRecalculation(true);

					// 下面的命令是向desc指向Excel输出所有的数据。
					out = new FileOutputStream(desc);
					reportWorkBook.write(out);

				}

			} catch (FileNotFoundException e) {

				e.printStackTrace();

			} catch (IOException e) {

				e.printStackTrace();

			}

		} finally {
			try {
				if (out != null) {
					out.flush();
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println("数据导出成功");
	}

	public static void xlsxOriEquipmentRealAssetCodeAdd(String reportSQL, String templateFilePathAndName,
			String targetFilePathAndName, String reportName, String voltageRelationCode, String dataVersion,
			String areaName, String sheetName, int startRowNumber, int startColumnNumber)
			throws SQLException, IOException {
		Connection conn = null;
		conn = DbUtil.getConnection();

		List<ReportRowNode> reportRowNodeLIst = new ArrayList<ReportRowNode>();
		List<String> treeStructure = new ArrayList<String>();
		OutputStream out = null;
		try {

			PreparedStatement pre = null;
			// 创建一个结果集对象
			ResultSet result = null;
			String columnSql = "SELECT * FROM REPORT_TABLE_FIELD_COLUMN A WHERE A.REPORT_NAME=?";

			pre = conn.prepareStatement(columnSql);
			pre.setString(1, reportName);
			result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数

			List<ReportTableFieldColumn> reportTableFieldColumnList = new <ReportTableFieldColumn>ArrayList();
			int reportTableFieldColumnListI = 0;
			int treeNodeLength = 1;
			int indQuantity = 1;
			while (result.next()) {

				ReportTableFieldColumn reportTableFieldColumn = new ReportTableFieldColumn();
				reportTableFieldColumn.setReportTableFieldColumnId(result.getString("REPORT_TABLE_FIELD_COLUMN_ID"));
				reportTableFieldColumn.setReportId(result.getString("REPORT_ID"));
				reportTableFieldColumn.setReportName(result.getString("REPORT_NAME"));
				reportTableFieldColumn.setTableName(result.getString("TABLE_NAME"));
				reportTableFieldColumn.setFieldName(result.getString("FIELD_NAME"));
				reportTableFieldColumn.setIndexof(result.getDouble("INDEXOF"));
				reportTableFieldColumn.setFieldTitle(result.getString("FIELD_TITLE"));
				reportTableFieldColumn.setDimensionOrIndicate(result.getString("DIMENSION_OR_INDICATE"));
				reportTableFieldColumn.setDimensionOrIndicateType(result.getString("DIMENSION_OR_INDICATE_TYPE"));
				reportTableFieldColumn.setDiscription(result.getString("DISCRIPTION"));
				reportTableFieldColumnList.add(reportTableFieldColumnListI, reportTableFieldColumn);
				if (result.getString("DIMENSION_OR_INDICATE").contentEquals("TREE")) {
					treeNodeLength = new Integer(result.getString("DIMENSION_OR_INDICATE_TYPE"));
				}
				if (result.getString("DIMENSION_OR_INDICATE").contentEquals("IND")) {
					indQuantity++;
				}

				reportTableFieldColumnListI++;
			}

			System.out.println("treeNodeLength=" + treeNodeLength);
			// 预编译语句

			try {
				pre = conn.prepareStatement(reportSQL);
				pre.setString(1, voltageRelationCode);
				pre.setString(2, areaName);
				pre.setString(3, dataVersion);
				result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // 实例化预编译语句
				// 查询数据库中所有的数据
			int ReportTableFieldColumnListSize = reportTableFieldColumnList.size();
			int maxTreeStructureCodeLength = 1;
			while (result.next()) {
				ReportRowNode reportRowNode = new ReportRowNode();
				Dimension dim = new Dimension();
				Dimension dim2 = new Dimension();
				dim.setDimensionType("CATEGORY");
				//
				System.out.println("CATEGORY=" + result.getString("CATEGORY"));
				//
				System.out.println("VOLTAGE_LEVEL=" + result.getString("VOLTAGE_LEVEL"));
				if (result.getString("ASSET_CLASS_CODE").length() > maxTreeStructureCodeLength) {
					maxTreeStructureCodeLength = result.getString("ASSET_CLASS_CODE").length();
				}
				if (result.getString("VOLTAGE_LEVEL") == null) {
					dim.setDimensionCode(result.getString("ASSET_CLASS_CODE"));

				} else {
					dim.setDimensionCode(result.getString("ASSET_CLASS_CODE").substring(0,
							result.getString("ASSET_CLASS_CODE").length() - 3));
				}
				dim.setDimensionName("CATEGORY");
				dim.setDimensionValue(result.getString("CATEGORY"));
				dim2.setDimensionType("VOLTAGE_LEVEL");
				dim2.setDimensionName("VOLTAGE_LEVEL");
				dim2.setDimensionValue(result.getString("VOLTAGE_LEVEL"));

				List<Dimension> dimList = new ArrayList<Dimension>();
				dimList.add(dim);
				dimList.add(dim2);
				reportRowNode.setDimensionList(dimList);
				List<IndicateNode> indicateList = new ArrayList<IndicateNode>();
				for (int indI = 3; indI < ReportTableFieldColumnListSize; indI++) {
					IndicateNode indicate = new IndicateNode();
					indicate.setIndicateName(reportTableFieldColumnList.get(indI).getFieldName());

					indicate.setIndicateIndexof(reportTableFieldColumnList.get(indI).getIndexof());
					indicate.setIndicateValue(
							new BigDecimal(result.getString(reportTableFieldColumnList.get(indI).getFieldName())));
					indicateList.add(indicate);

				}
				reportRowNode.setIndicateLsit(indicateList);
				reportRowNode.setTreeStructureCode(result.getString("ASSET_CLASS_CODE"));
				reportRowNode.setLeaf(true);
				treeStructure.add(result.getString("ASSET_CLASS_CODE"));
				reportRowNodeLIst.add(reportRowNode);
			}

			/**
			 * 以下模块进行叶子节点判断。 逻辑是： 1、对ReportRowNodeList中的元素进行遍历；
			 * 2、根据结构树的treeNodeLength长度，从每个节点的treeStructureCode中获取子字符串；
			 * 3、于treeStructure模板列表中的剩余元素的结构树treeStructureCode的相同长度的子字符串进行匹配；
			 * 4、只要出现一次，即判定当前元素为非叶子节点，更新reportRowNodeLIst中当前元素的leaf属性为false,否则为true；
			 */
			for (int reportRowNodeLIstI = 0; reportRowNodeLIstI < reportRowNodeLIst.size(); reportRowNodeLIstI++) {

				for (int levelI = 0; levelI < maxTreeStructureCodeLength / treeNodeLength; levelI++) {
					for (int treeI = reportRowNodeLIstI + 1; treeI < treeStructure.size(); treeI++) {

						/*
						 * treeStructure.get(treeI).substring(0, treeNodeLength * (levelI + 1) >
						 * treeStructure.get(treeI).length() ? treeStructure.get(treeI).length() :
						 * treeNodeLength * (levelI + 1));
						 */
						Map<String, Boolean> app = new HashMap<String, Boolean>();
						if (reportRowNodeLIst.get(reportRowNodeLIstI).getTreeStructureCode()
								.contentEquals(treeStructure.get(treeI).substring(0,
										treeNodeLength * (levelI + 1) > treeStructure.get(treeI).length()
												? treeStructure.get(treeI).length()
												: treeNodeLength * (levelI + 1)))) {
							System.out.println(treeStructure.get(treeI).substring(0,
									treeNodeLength * (levelI + 1) > treeStructure.get(treeI).length()
											? treeStructure.get(treeI).length()
											: treeNodeLength * (levelI + 1)));
							reportRowNodeLIst.get(reportRowNodeLIstI).setLeaf(false);
							break;
						}
					}
				}
				System.out.println(
						reportRowNodeLIst.get(reportRowNodeLIstI).getDimensionList().get(0).getDimensionValue());
				System.out.println(
						reportRowNodeLIst.get(reportRowNodeLIstI).getDimensionList().get(1).getDimensionValue());
				System.out.println(reportRowNodeLIst.get(reportRowNodeLIstI).getIndicateLsit().get(0).getIndicateName()
						+ "=" + reportRowNodeLIst.get(reportRowNodeLIstI).getIndicateLsit().get(0).getIndicateValue());
				System.out.println(reportRowNodeLIst.get(reportRowNodeLIstI).getIndicateLsit().get(1).getIndicateName()
						+ "=" + reportRowNodeLIst.get(reportRowNodeLIstI).getIndicateLsit().get(1).getIndicateValue());
				System.out.println(reportRowNodeLIst.get(reportRowNodeLIstI).isLeaf());
			}
			/*
			 * reportRowNodeLIst 中每个元素中都有维度列表与指标列表
			 */

			// File src = new File(templateFilePathAndName);
			File desc = new File(targetFilePathAndName);

			// 电网实物资产分析评价数据收集表-20182020-05-13 1024551.xls

			Workbook reportWorkBook = getWorkbok(desc);

			// sheet 对应一个工作页
			Sheet reportSheet = reportWorkBook.getSheet(sheetName);
			// int errorI = reportSheet.getPhysicalNumberOfRows();

			try {

				out = new FileOutputStream(desc);
				// 构造 Workbook 对象，execelFile 是传入文件路径(获得Excel工作区)

				// 定义 row、cell

				Row row;

				String cell;

				// 总共有多少行,从0开始

				int totalRows = reportSheet.getLastRowNum();

				// 循环输出表格中的内容,首先循环取出行,再根据行循环取出列
				// int startRowNumber = 5;
				// int startColumnNumber = 2;
				for (int i = 0; i < reportRowNodeLIst.size(); i++) {

					row = reportSheet.getRow(i + startRowNumber);

					// 处理空行

					if (row == null) {

						continue;

					}

					// 总共有多少列,从0开始

					int totalCells = row.getLastCellNum();

					// for (int j = row.getFirstCellNum(); j < totalCells; j++)
					if (reportRowNodeLIst.get(i).isLeaf()) {
						for (int j = 0; j < indQuantity - 1; j++) {

							Cell reportCell = null;
							// 下面这个方法是把Excel文档中原有的Cell取到，然后进行了值的写入，不会改变原来的格式。
							reportCell = row.getCell(j + startColumnNumber);
							// 下面这个方法是创建了一个新的Cell，然后进行了值的写入，会覆盖原来的cell,原来的格式也会丢失。
							// reportCell = row.createCell(j + startColumnNumber);
							reportCell.setCellValue(
									reportRowNodeLIst.get(i).getIndicateLsit().get(j).getIndicateValue().doubleValue());

							// 处理空列

							if (row.getCell(j) == null) {

								continue;

							}

							// 通过 row.getCell(j).toString() 获取单元格内容

							cell = row.getCell(j).toString();

							System.out.print(cell + "\t");

						}
					}
					// 下面的命令是刷新Excel文件中所有Sheet表格预设的公式，使之计算出其结果。
					reportWorkBook.setForceFormulaRecalculation(true);

					// 下面的命令是向desc指向Excel输出所有的数据。
					out = new FileOutputStream(desc);
					reportWorkBook.write(out);

				}

			} catch (FileNotFoundException e) {

				e.printStackTrace();

			} catch (IOException e) {

				e.printStackTrace();

			}

		} finally {
			try {
				if (out != null) {
					out.flush();
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println("数据导出成功");
	}

	@Autowired
	public void createXLSX(String templateFilePathAndName, String targetFilePathAndName, String tableName,
			String voltageRelationCode, Integer yearValue, String areaName, String sheetName, int startRowNumber,
			int startColumnNumber) throws SQLException, IOException {
		// System.out.println("areaName=" + areaName);
		Connection conn = null;
		conn = DbUtil.getConnection();

		List<ReportRowNode> reportRowNodeLIst = new ArrayList<ReportRowNode>();
		List<String> treeStructure = new ArrayList<String>();
		OutputStream out = null;
		try {
			// System.out.println("System.getProperty(\"user.dir\"):" +
			// System.getProperty("user.dir"));
			// System.out.println("finalXlsxPath:=" + finalXlsxPath);
			// File finalXlsxFile = new File(finalXlsxPath);// +"/"+nowdate+".xlsx");
			// System.out.println("finalXlsxFile.getName():" + finalXlsxFile.getName());
			// Workbook workBook = getWorkbok(finalXlsxFile);

			// sheet 对应一个工作页
			// Sheet sheet = workBook.getSheetAt(0);
			// 创建预编译语句对象，一般都是用这个而不用Statement
			PreparedStatement pre = null;
			// 创建一个结果集对象
			ResultSet result = null;
			String columnSql = "SELECT * FROM REPORT_TABLE_FIELD_COLUMN A WHERE A.REPORT_NAME=?";

			pre = conn.prepareStatement(columnSql);
			pre.setString(1, tableName);
			result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数

			List<ReportTableFieldColumn> reportTableFieldColumnList = new <ReportTableFieldColumn>ArrayList();
			int reportTableFieldColumnListI = 0;
			int treeNodeLength = 1;
			int indQuantity = 1;
			while (result.next()) {

				ReportTableFieldColumn reportTableFieldColumn = new ReportTableFieldColumn();
				reportTableFieldColumn.setReportTableFieldColumnId(result.getString("REPORT_TABLE_FIELD_COLUMN_ID"));
				reportTableFieldColumn.setReportId(result.getString("REPORT_ID"));
				reportTableFieldColumn.setReportName(result.getString("REPORT_NAME"));
				reportTableFieldColumn.setTableName(result.getString("TABLE_NAME"));
				reportTableFieldColumn.setFieldName(result.getString("FIELD_NAME"));
				reportTableFieldColumn.setIndexof(result.getDouble("INDEXOF"));
				reportTableFieldColumn.setFieldTitle(result.getString("FIELD_TITLE"));
				reportTableFieldColumn.setDimensionOrIndicate(result.getString("DIMENSION_OR_INDICATE"));
				reportTableFieldColumn.setDimensionOrIndicateType(result.getString("DIMENSION_OR_INDICATE_TYPE"));
				reportTableFieldColumn.setDiscription(result.getString("DISCRIPTION"));
				reportTableFieldColumnList.add(reportTableFieldColumnListI, reportTableFieldColumn);
				if (result.getString("DIMENSION_OR_INDICATE").contentEquals("TREE")) {
					treeNodeLength = new Integer(result.getString("DIMENSION_OR_INDICATE_TYPE"));
				}
				if (result.getString("DIMENSION_OR_INDICATE").contentEquals("IND")) {
					indQuantity++;
				}

				reportTableFieldColumnListI++;
			}

			System.out.println("treeNodeLength=" + treeNodeLength);
			// 预编译语句
			String sql = "WITH STRUCTRUE_TEMP_TAB AS (  SELECT  "
					+ "A.ASSET_CLASS_NAME, A.ASSET_CLASS_CODE, B.VOLTAGE_NAME, "
					+ "B.INDEXOF FROM DV_ASSET_CLASS A LEFT JOIN  "
					+ "( SELECT   C.VOLTAGE_NAME, B.DV_ASSET_CLASS_ID, B.INDEXOF  "
					+ "FROM  DV_VOLTAGE_RELATION B  INNER JOIN  "
					+ "DV_VOLTAGE_LEVEL C  ON  B.DV_VOLTAGE_LEVEL_ID=C.DV_VOLTAGE_LEVEL_ID  "
					+ "WHERE B.VOLTAGE_RELATION_CODE=? )B  ON  " + "A.DV_ASSET_CLASS_ID=B.DV_ASSET_CLASS_ID  ORDER BY "
					+ "A.ASSET_CLASS_CODE , B.INDEXOF  ), " + "SPAN_STRUCTURE_TAB AS ( SELECT  A.ASSET_CLASS_NAME, "
					+ "DECODE(A.VOLTAGE_NAME,NULL,A.ASSET_CLASS_CODE,"
					+ "DECODE(LENGTH(TO_CHAR(A.INDEXOF)),1,A.ASSET_CLASS_CODE||'10'||A.INDEXOF, "
					+ "2,A.ASSET_CLASS_CODE||'1'||A.INDEXOF) )  STRUCTURE_CODE, "
					+ "A.ASSET_CLASS_CODE, VOLTAGE_NAME, INDEXOF FROM  "
					+ "STRUCTRUE_TEMP_TAB A   ORDER BY STRUCTURE_CODE, INDEXOF  "
					+ "), STRUCT_TEMP_RESULT AS ( SELECT  " + "A.ASSET_CLASS_NAME, A.ASSET_CLASS_CODE, B.VOLTAGE_NAME, "
					+ "B.INDEXOF  FROM  DV_ASSET_CLASS A  LEFT JOIN  SPAN_STRUCTURE_TAB B  "
					+ "ON A.ASSET_CLASS_CODE=B.STRUCTURE_CODE UNION ALL  "
					+ "SELECT  B.ASSET_CLASS_NAME, B.STRUCTURE_CODE ASSET_CLASS_CODE, "
					+ "B.VOLTAGE_NAME, B.INDEXOF FROM  SPAN_STRUCTURE_TAB B  " + "ORDER BY ASSET_CLASS_CODE, INDEXOF  "
					+ "),RESULT_TEMP_TAB AS ( SELECT  " + "A.ASSET_CLASS_NAME CATEGORY, A.ASSET_CLASS_CODE, "
					+ "A.VOLTAGE_NAME VOLTAGE_LEVEL, "
					+ "DECODE(B.YEAR1_AMOUNT  ,NULL,0,B.YEAR1_AMOUNT  )YEAR1_AMOUNT     ,  "
					+ "DECODE(B.YEAR2_AMOUNT  ,NULL,0,B.YEAR2_AMOUNT  )YEAR2_AMOUNT     , "
					+ "DECODE(B.YEAR3_AMOUNT  ,NULL,0,B.YEAR3_AMOUNT  )YEAR3_AMOUNT     , "
					+ "DECODE(B.YEAR4_AMOUNT  ,NULL,0,B.YEAR4_AMOUNT  )YEAR4_AMOUNT     , "
					+ "DECODE(B.YEAR5_AMOUNT  ,NULL,0,B.YEAR5_AMOUNT  )YEAR5_AMOUNT     , "
					+ "DECODE(B.YEAR6_AMOUNT  ,NULL,0,B.YEAR6_AMOUNT  )YEAR6_AMOUNT     , "
					+ "DECODE(B.YEAR7_AMOUNT  ,NULL,0,B.YEAR7_AMOUNT  )YEAR7_AMOUNT     , "
					+ "DECODE(B.YEAR8_AMOUNT  ,NULL,0,B.YEAR8_AMOUNT  )YEAR8_AMOUNT     , "
					+ "DECODE(B.YEAR9_AMOUNT  ,NULL,0,B.YEAR9_AMOUNT  )YEAR9_AMOUNT     , "
					+ "DECODE(B.YEAR10_AMOUNT ,NULL,0,B.YEAR10_AMOUNT )YEAR10_AMOUNT    , "
					+ "DECODE(B.YEAR11_AMOUNT ,NULL,0,B.YEAR11_AMOUNT )YEAR11_AMOUNT    , "
					+ "DECODE(B.YEAR12_AMOUNT ,NULL,0,B.YEAR12_AMOUNT )YEAR12_AMOUNT    , "
					+ "DECODE(B.YEAR13_AMOUNT ,NULL,0,B.YEAR13_AMOUNT )YEAR13_AMOUNT    , "
					+ "DECODE(B.YEAR14_AMOUNT ,NULL,0,B.YEAR14_AMOUNT )YEAR14_AMOUNT    , "
					+ "DECODE(B.YEAR15_AMOUNT ,NULL,0,B.YEAR15_AMOUNT )YEAR15_AMOUNT    , "
					+ "DECODE(B.YEAR16_AMOUNT ,NULL,0,B.YEAR16_AMOUNT )YEAR16_AMOUNT    , "
					+ "DECODE(B.YEAR17_AMOUNT ,NULL,0,B.YEAR17_AMOUNT )YEAR17_AMOUNT    , "
					+ "DECODE(B.YEAR18_AMOUNT ,NULL,0,B.YEAR18_AMOUNT )YEAR18_AMOUNT    , "
					+ "DECODE(B.YEAR19_AMOUNT ,NULL,0,B.YEAR19_AMOUNT )YEAR19_AMOUNT    , "
					+ "DECODE(B.YEAR20_AMOUNT ,NULL,0,B.YEAR20_AMOUNT )YEAR20_AMOUNT    , "
					+ "DECODE(B.YEAR21_AMOUNT ,NULL,0,B.YEAR21_AMOUNT )YEAR21_AMOUNT    , "
					+ "DECODE(B.YEAR22_AMOUNT ,NULL,0,B.YEAR22_AMOUNT )YEAR22_AMOUNT    , "
					+ "DECODE(B.YEAR23_AMOUNT ,NULL,0,B.YEAR23_AMOUNT )YEAR23_AMOUNT    , "
					+ "DECODE(B.YEAR24_AMOUNT ,NULL,0,B.YEAR24_AMOUNT )YEAR24_AMOUNT    , "
					+ "DECODE(B.YEAR25_AMOUNT ,NULL,0,B.YEAR25_AMOUNT )YEAR25_AMOUNT    , "
					+ "DECODE(B.YEAR26_AMOUNT ,NULL,0,B.YEAR26_AMOUNT )YEAR26_AMOUNT    , "
					+ "DECODE(B.YEAR27_AMOUNT ,NULL,0,B.YEAR27_AMOUNT )YEAR27_AMOUNT    , "
					+ "DECODE(B.YEAR28_AMOUNT ,NULL,0,B.YEAR28_AMOUNT )YEAR28_AMOUNT    , "
					+ "DECODE(B.YEAR29_AMOUNT ,NULL,0,B.YEAR29_AMOUNT )YEAR29_AMOUNT    , "
					+ "DECODE(B.YEAR30_AMOUNT ,NULL,0,B.YEAR30_AMOUNT )YEAR30_AMOUNT    , "
					+ "DECODE(B.YEAR31_AMOUNT ,NULL,0,B.YEAR31_AMOUNT )YEAR31_AMOUNT      "
					+ "FROM  ( SELECT  DISTINCT  * FROM STRUCT_TEMP_RESULT  )A  "
					+ "LEFT JOIN  ( SELECT  EXTRACT(YEAR FROM A.DV_DATE_VALUE) CAL_YEAR, "
					+ "A.CATEGORY, A.VOLTAGE_LEVEL, " + "SUM(A.YEAR1_AMOUNT  )YEAR1_AMOUNT    ,  "
					+ "SUM(A.YEAR2_AMOUNT  )YEAR2_AMOUNT    , " + "SUM(A.YEAR3_AMOUNT  )YEAR3_AMOUNT    , "
					+ "SUM(A.YEAR4_AMOUNT  )YEAR4_AMOUNT    , " + "SUM(A.YEAR5_AMOUNT  )YEAR5_AMOUNT    , "
					+ "SUM(A.YEAR6_AMOUNT  )YEAR6_AMOUNT    , " + "SUM(A.YEAR7_AMOUNT  )YEAR7_AMOUNT    , "
					+ "SUM(A.YEAR8_AMOUNT  )YEAR8_AMOUNT    , " + "SUM(A.YEAR9_AMOUNT  )YEAR9_AMOUNT    , "
					+ "SUM(A.YEAR10_AMOUNT )YEAR10_AMOUNT   , " + "SUM(A.YEAR11_AMOUNT )YEAR11_AMOUNT   , "
					+ "SUM(A.YEAR12_AMOUNT )YEAR12_AMOUNT   , " + "SUM(A.YEAR13_AMOUNT )YEAR13_AMOUNT   , "
					+ "SUM(A.YEAR14_AMOUNT )YEAR14_AMOUNT   , " + "SUM(A.YEAR15_AMOUNT )YEAR15_AMOUNT   , "
					+ "SUM(A.YEAR16_AMOUNT )YEAR16_AMOUNT   , " + "SUM(A.YEAR17_AMOUNT )YEAR17_AMOUNT   , "
					+ "SUM(A.YEAR18_AMOUNT )YEAR18_AMOUNT   , " + "SUM(A.YEAR19_AMOUNT )YEAR19_AMOUNT   , "
					+ "SUM(A.YEAR20_AMOUNT )YEAR20_AMOUNT   , " + "SUM(A.YEAR21_AMOUNT )YEAR21_AMOUNT   , "
					+ "SUM(A.YEAR22_AMOUNT )YEAR22_AMOUNT   , " + "SUM(A.YEAR23_AMOUNT )YEAR23_AMOUNT   , "
					+ "SUM(A.YEAR24_AMOUNT )YEAR24_AMOUNT   , " + "SUM(A.YEAR25_AMOUNT )YEAR25_AMOUNT   , "
					+ "SUM(A.YEAR26_AMOUNT )YEAR26_AMOUNT   , " + "SUM(A.YEAR27_AMOUNT )YEAR27_AMOUNT   , "
					+ "SUM(A.YEAR28_AMOUNT )YEAR28_AMOUNT   , " + "SUM(A.YEAR29_AMOUNT )YEAR29_AMOUNT   , "
					+ "SUM(A.YEAR30_AMOUNT )YEAR30_AMOUNT   , " + "SUM(A.YEAR31_AMOUNT )YEAR31_AMOUNT    "
					+ "FROM RS_ASSET_AMOUNT_AREA A  WHERE EXTRACT(YEAR FROM A.DV_DATE_VALUE)=? "
					+ "AND    AREA_NAME=? GROUP BY EXTRACT(YEAR FROM A.DV_DATE_VALUE), "
					+ "A.CATEGORY, A.VOLTAGE_LEVEL ) B ON ( " + "A.ASSET_CLASS_NAME=B.CATEGORY AND  "
					+ "DECODE(A.VOLTAGE_NAME,NULL,'BLANK',A.VOLTAGE_NAME)=DECODE(B.VOLTAGE_LEVEL,NULL,'BLANK',B.VOLTAGE_LEVEL) "
					+ ") ORDER BY ASSET_CLASS_CODE, INDEXOF  ),LEVEL_TEMP_TAB AS ( "
					+ "SELECT   A.CATEGORY, A.ASSET_CLASS_CODE, " + "DECODE(LENGTH(A.ASSET_CLASS_CODE), "
					+ "3,NULL,SUBSTR(A.ASSET_CLASS_CODE,0,LENGTH(A.ASSET_CLASS_CODE)-3)) "
					+ "PARENT_CLASS_CODE, A.VOLTAGE_LEVEL, " + "A.YEAR1_AMOUNT  ,  A.YEAR2_AMOUNT  , A.YEAR3_AMOUNT  , "
					+ "A.YEAR4_AMOUNT  , A.YEAR5_AMOUNT  , A.YEAR6_AMOUNT  , "
					+ "A.YEAR7_AMOUNT  , A.YEAR8_AMOUNT  , A.YEAR9_AMOUNT  , "
					+ "A.YEAR10_AMOUNT , A.YEAR11_AMOUNT , A.YEAR12_AMOUNT , "
					+ "A.YEAR13_AMOUNT , A.YEAR14_AMOUNT , A.YEAR15_AMOUNT , "
					+ "A.YEAR16_AMOUNT , A.YEAR17_AMOUNT , A.YEAR18_AMOUNT , "
					+ "A.YEAR19_AMOUNT , A.YEAR20_AMOUNT , A.YEAR21_AMOUNT , "
					+ "A.YEAR22_AMOUNT , A.YEAR23_AMOUNT , A.YEAR24_AMOUNT , "
					+ "A.YEAR25_AMOUNT , A.YEAR26_AMOUNT , A.YEAR27_AMOUNT , "
					+ "A.YEAR28_AMOUNT , A.YEAR29_AMOUNT , A.YEAR30_AMOUNT , "
					+ "A.YEAR31_AMOUNT   FROM  RESULT_TEMP_TAB A  ) "
					+ "SELECT  B.ASSET_CLASS_CODE,B.CATEGORY, B.VOLTAGE_LEVEL, "
					+ "SUM(A.YEAR1_AMOUNT  )YEAR1_AMOUNT    , " + "SUM(A.YEAR2_AMOUNT  )YEAR2_AMOUNT    , "
					+ "SUM(A.YEAR3_AMOUNT  )YEAR3_AMOUNT    , " + "SUM(A.YEAR4_AMOUNT  )YEAR4_AMOUNT    , "
					+ "SUM(A.YEAR5_AMOUNT  )YEAR5_AMOUNT    , " + "SUM(A.YEAR6_AMOUNT  )YEAR6_AMOUNT    , "
					+ "SUM(A.YEAR7_AMOUNT  )YEAR7_AMOUNT    , " + "SUM(A.YEAR8_AMOUNT  )YEAR8_AMOUNT    , "
					+ "SUM(A.YEAR9_AMOUNT  )YEAR9_AMOUNT    , " + "SUM(A.YEAR10_AMOUNT )YEAR10_AMOUNT   , "
					+ "SUM(A.YEAR11_AMOUNT )YEAR11_AMOUNT   , " + "SUM(A.YEAR12_AMOUNT )YEAR12_AMOUNT   , "
					+ "SUM(A.YEAR13_AMOUNT )YEAR13_AMOUNT   , " + "SUM(A.YEAR14_AMOUNT )YEAR14_AMOUNT   , "
					+ "SUM(A.YEAR15_AMOUNT )YEAR15_AMOUNT   , " + "SUM(A.YEAR16_AMOUNT )YEAR16_AMOUNT   , "
					+ "SUM(A.YEAR17_AMOUNT )YEAR17_AMOUNT   , " + "SUM(A.YEAR18_AMOUNT )YEAR18_AMOUNT   , "
					+ "SUM(A.YEAR19_AMOUNT )YEAR19_AMOUNT   , " + "SUM(A.YEAR20_AMOUNT )YEAR20_AMOUNT   , "
					+ "SUM(A.YEAR21_AMOUNT )YEAR21_AMOUNT   , " + "SUM(A.YEAR22_AMOUNT )YEAR22_AMOUNT   , "
					+ "SUM(A.YEAR23_AMOUNT )YEAR23_AMOUNT   , " + "SUM(A.YEAR24_AMOUNT )YEAR24_AMOUNT   , "
					+ "SUM(A.YEAR25_AMOUNT )YEAR25_AMOUNT   ," + "SUM(A.YEAR26_AMOUNT )YEAR26_AMOUNT   ,"
					+ "SUM(A.YEAR27_AMOUNT )YEAR27_AMOUNT   ," + "SUM(A.YEAR28_AMOUNT )YEAR28_AMOUNT   , "
					+ "SUM(A.YEAR29_AMOUNT )YEAR29_AMOUNT   , " + "SUM(A.YEAR30_AMOUNT )YEAR30_AMOUNT   , "
					+ "SUM(A.YEAR31_AMOUNT )YEAR31_AMOUNT    " + "FROM LEVEL_TEMP_TAB A , LEVEL_TEMP_TAB B  "
					+ "WHERE A.ASSET_CLASS_CODE IN " + "( SELECT E.ASSET_CLASS_CODE  FROM LEVEL_TEMP_TAB E  "
					+ "START WITH E.ASSET_CLASS_CODE=B.ASSET_CLASS_CODE "
					+ "CONNECT BY E.PARENT_CLASS_CODE=PRIOR E.ASSET_CLASS_CODE) "
					+ "GROUP BY B.CATEGORY, B.ASSET_CLASS_CODE,B.VOLTAGE_LEVEL ORDER BY B.ASSET_CLASS_CODE";

			try {
				pre = conn.prepareStatement(sql);
				pre.setString(1, voltageRelationCode);
				pre.setInt(2, yearValue);
				pre.setString(3, areaName);
				result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // 实例化预编译语句
				// 查询数据库中所有的数据
			int ReportTableFieldColumnListSize = reportTableFieldColumnList.size();
			int maxTreeStructureCodeLength = 1;
			while (result.next()) {
				ReportRowNode reportRowNode = new ReportRowNode();
				Dimension dim = new Dimension();
				Dimension dim2 = new Dimension();
				dim.setDimensionType("CATEGORY");
				//
				System.out.println("CATEGORY=" + result.getString("CATEGORY"));
				//
				System.out.println("VOLTAGE_LEVEL=" + result.getString("VOLTAGE_LEVEL"));
				if (result.getString("ASSET_CLASS_CODE").length() > maxTreeStructureCodeLength) {
					maxTreeStructureCodeLength = result.getString("ASSET_CLASS_CODE").length();
				}
				if (result.getString("VOLTAGE_LEVEL") == null) {
					dim.setDimensionCode(result.getString("ASSET_CLASS_CODE"));

				} else {
					dim.setDimensionCode(result.getString("ASSET_CLASS_CODE").substring(0,
							result.getString("ASSET_CLASS_CODE").length() - 3));
				}
				dim.setDimensionName("CATEGORY");
				dim.setDimensionValue(result.getString("CATEGORY"));
				dim2.setDimensionType("VOLTAGE_LEVEL");
				dim2.setDimensionName("VOLTAGE_LEVEL");
				dim2.setDimensionValue(result.getString("VOLTAGE_LEVEL"));

				List<Dimension> dimList = new ArrayList<Dimension>();
				dimList.add(dim);
				dimList.add(dim2);
				reportRowNode.setDimensionList(dimList);
				List<IndicateNode> indicateList = new ArrayList<IndicateNode>();
				for (int indI = 3; indI < ReportTableFieldColumnListSize; indI++) {
					IndicateNode indicate = new IndicateNode();
					indicate.setIndicateName(reportTableFieldColumnList.get(indI).getFieldName());

					indicate.setIndicateIndexof(reportTableFieldColumnList.get(indI).getIndexof());
					indicate.setIndicateValue(
							new BigDecimal(result.getString(reportTableFieldColumnList.get(indI).getFieldName())));
					indicateList.add(indicate);

					// System.out.println(reportTableFieldColumnList.get(indI).getFieldName()+
					// "=" + result.getString(reportTableFieldColumnList.get(indI).getFieldName()));
				}
				reportRowNode.setIndicateLsit(indicateList);
				reportRowNode.setTreeStructureCode(result.getString("ASSET_CLASS_CODE"));
				reportRowNode.setLeaf(true);
				treeStructure.add(result.getString("ASSET_CLASS_CODE"));
				reportRowNodeLIst.add(reportRowNode);
			}

			/**
			 * 以下模块进行叶子节点判断。 逻辑是： 1、对ReportRowNodeList中的元素进行遍历；
			 * 2、根据结构树的treeNodeLength长度，从每个节点的treeStructureCode中获取子字符串；
			 * 3、于treeStructure模板列表中的剩余元素的结构树treeStructureCode的相同长度的子字符串进行匹配；
			 * 4、只要出现一次，即判定当前元素为非叶子节点，更新reportRowNodeLIst中当前元素的leaf属性为false,否则为true；
			 */
			for (int reportRowNodeLIstI = 0; reportRowNodeLIstI < reportRowNodeLIst.size(); reportRowNodeLIstI++) {

				for (int levelI = 0; levelI < maxTreeStructureCodeLength / treeNodeLength; levelI++) {
					for (int treeI = reportRowNodeLIstI + 1; treeI < treeStructure.size(); treeI++) {

						/*
						 * treeStructure.get(treeI).substring(0, treeNodeLength * (levelI + 1) >
						 * treeStructure.get(treeI).length() ? treeStructure.get(treeI).length() :
						 * treeNodeLength * (levelI + 1));
						 */
						Map<String, Boolean> app = new HashMap<String, Boolean>();
						if (reportRowNodeLIst.get(reportRowNodeLIstI).getTreeStructureCode()
								.contentEquals(treeStructure.get(treeI).substring(0,
										treeNodeLength * (levelI + 1) > treeStructure.get(treeI).length()
												? treeStructure.get(treeI).length()
												: treeNodeLength * (levelI + 1)))) {
							System.out.println(treeStructure.get(treeI).substring(0,
									treeNodeLength * (levelI + 1) > treeStructure.get(treeI).length()
											? treeStructure.get(treeI).length()
											: treeNodeLength * (levelI + 1)));
							reportRowNodeLIst.get(reportRowNodeLIstI).setLeaf(false);
							break;
						}
					}
				}
				System.out.println(
						reportRowNodeLIst.get(reportRowNodeLIstI).getDimensionList().get(0).getDimensionValue());
				System.out.println(
						reportRowNodeLIst.get(reportRowNodeLIstI).getDimensionList().get(1).getDimensionValue());
				System.out.println(reportRowNodeLIst.get(reportRowNodeLIstI).getIndicateLsit().get(0).getIndicateName()
						+ "=" + reportRowNodeLIst.get(reportRowNodeLIstI).getIndicateLsit().get(0).getIndicateValue());
				System.out.println(reportRowNodeLIst.get(reportRowNodeLIstI).getIndicateLsit().get(1).getIndicateName()
						+ "=" + reportRowNodeLIst.get(reportRowNodeLIstI).getIndicateLsit().get(1).getIndicateValue());
				System.out.println(reportRowNodeLIst.get(reportRowNodeLIstI).isLeaf());
			}
			/*
			 * reportRowNodeLIst 中每个元素中都有维度列表与指标列表
			 */

			// now = new Date();

			// nowdate = df.format(now);
			// System.out.println("nowdate=" + nowdate);
			// 以下将模板文件复制到用户文件目录下，然后再对用户目录下的文件进行数据写入。
			// templateFileName 模板文件存放目录及文件名
			// String templateFileName = "电网实物资产分析评价数据收集表-2018";
			// String templateFilePathAndName = "src/main/resources/demoFile/" +
			// templateFileName + ".xls";
			// String targetFileName = templateFileName + "-" + areaName + "-" + nowdate +
			// "1" + ".xls";
			// String targetFilePathAndName = "src/main/webapp/userFile/Excel/" +
			// targetFileName;

			// System.out.println("templateFileName=" + templateFileName);
			// System.out.println("targetFileName=" + targetFileName);
			// System.out.println("areaName=" + areaName);
			File src = new File(templateFilePathAndName);
			File desc = new File(targetFilePathAndName);
			long start = System.currentTimeMillis();
			copyFile(src, desc);
			long end = System.currentTimeMillis();

			System.out.println(end - start);
			// 电网实物资产分析评价数据收集表-20182020-05-13 1024551.xls

			Workbook reportWorkBook = getWorkbok(desc);

			// String sheetName = "A.3.1 资产结构-年龄结构（价值）";
			// sheet 对应一个工作页
			Sheet reportSheet = reportWorkBook.getSheet(sheetName);
			// int errorI = reportSheet.getPhysicalNumberOfRows();

			try {

				out = new FileOutputStream(desc);
				// 构造 Workbook 对象，execelFile 是传入文件路径(获得Excel工作区)

				// 定义 row、cell

				Row row;

				String cell;

				// 总共有多少行,从0开始

				int totalRows = reportSheet.getLastRowNum();

				for (int i = 0; i < reportRowNodeLIst.size(); i++) {

					row = reportSheet.getRow(i + startRowNumber);

					// 处理空行

					if (row == null) {

						continue;

					}

					// 总共有多少列,从0开始

					int totalCells = row.getLastCellNum();

					// for (int j = row.getFirstCellNum(); j < totalCells; j++)
					if (reportRowNodeLIst.get(i).isLeaf()) {
						for (int j = 0; j < indQuantity - 1; j++) {

							Cell reportCell = null;
							// 下面这个方法是把Excel文档中原有的Cell取到，然后进行了值的写入，不会改变原来的格式。
							reportCell = row.getCell(j + startColumnNumber);
							// 下面这个方法是创建了一个新的Cell，然后进行了值的写入，会覆盖原来的cell,原来的格式也会丢失。
							// reportCell = row.createCell(j + startColumnNumber);
							reportCell.setCellValue(
									reportRowNodeLIst.get(i).getIndicateLsit().get(j).getIndicateValue().doubleValue());

							// 处理空列

							if (row.getCell(j) == null) {

								continue;

							}

							// 通过 row.getCell(j).toString() 获取单元格内容

							cell = row.getCell(j).toString();

							System.out.print(cell + "\t");

						}
					}
					// 下面的命令是刷新Excel文件中所有Sheet表格预设的公式，使之计算出其结果。
					reportWorkBook.setForceFormulaRecalculation(true);

					// 下面的命令是向desc指向Excel输出所有的数据。
					out = new FileOutputStream(desc);
					reportWorkBook.write(out);

				}

			} catch (FileNotFoundException e) {

				e.printStackTrace();

			} catch (IOException e) {

				e.printStackTrace();

			}

		} finally {
			try {
				if (out != null) {
					out.flush();
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println("数据导出成功");
	}

	/**
	 * 方法4：实现文件复制 1.字节流缓冲区读写字节数组 运行时间：137ms
	 */
	public static void copyFile(File src, File desc) {
		try {
			BufferedInputStream bufis = new BufferedInputStream(new FileInputStream(src));
			BufferedOutputStream bufos = new BufferedOutputStream(new FileOutputStream(desc));
			int len = 0;
			byte[] bt = new byte[1024];
			while ((len = bufis.read(bt)) != -1) {
				bufos.write(bt, 0, len);
			}
			bufis.close();
			bufos.close();
		} catch (IOException ex) {
			System.out.println(ex);
			throw new RuntimeException("文件写入失败");
		}
	}

	/**
	 * 判断Excel的版本,获取Workbook
	 * 
	 * @param in
	 * @param filename
	 * @return
	 * @throws IOException
	 */
	public static Workbook getWorkbok(File file) throws IOException {
		Workbook wb = null;
		FileInputStream in = new FileInputStream(file);
		if (file.getName().endsWith(EXCEL_XLS)) { // Excel&nbsp;2003
			wb = new HSSFWorkbook(in);
		} else if (file.getName().endsWith(EXCEL_XLSX)) { // Excel 2007/2010
			wb = new XSSFWorkbook(in);
		}
		return wb;
	}

}