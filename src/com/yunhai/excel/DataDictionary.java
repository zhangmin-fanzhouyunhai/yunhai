package com.yunhai.excel;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFHyperlink;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.type.StringType;

public class DataDictionary {
	public static void main(String[] args) throws IOException {

		Date now = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HHmmss");
		String nowdate = df.format(now);
		//
		String rootPath = System.getProperty("user.dir") + "\\WebRoot\\userFile\\excel";

		String outputRootPath = System.getProperty("user.dir") + "\\WebRoot\\\\userFile\\\\outputFile";
		String fileName = rootPath + "\\blank.xls";
		String targetFileName = outputRootPath + "\\DataDictionary" + nowdate.replace(" ", "") + ".xls";
		File file = new File(fileName);
		// file.createNewFile();
		File targetFile = new File(targetFileName);
		if (targetFile != null) {
			// targetFile= new File(targetFileName);
			//
		}
		copyFile(file, targetFile);
		ArrayList arrayList;
		allUserTables();
		tableDictionary("DV_AREA");
		List<HashMap<Integer, String>> list = allUserTables();
		String sheetName = "";
		for (int tableI = 0; tableI < list.size(); tableI++) {
			// System.out.println("Element(1)="+list.get(tableI).get(1)+",
			// element(2)="+list.get(tableI).get(2));;
			sheetName = list.get(tableI).get(1);

			List<HashMap<Integer, String>> columnList = tableDictionary(sheetName);
			createDictionarySheet(targetFileName, sheetName, columnList);
		}
		createDictionarySheetSuperLinked(targetFileName, "Sheet1", list);
	}

	/**
	 * 
	 * @param fileName   数据次要存入的excel文件名称
	 * @param sheetName  数据次要写入的sheet名称
	 * @param columnList 次要写入的数据列表 ，如此做的可扩展必存在问题，还是应该用对象的方法来处理。2021-07-09
	 * @throws IOException
	 */
	public static void createDictionarySheetSuperLinked(String fileName, String sheetName,
			List<HashMap<Integer, String>> columnList) throws IOException {
		HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(fileName));
		// 按名引用excel工
		// HSSFSheet sheet = workbook.getSheet("JSP");
		// 用式获取excel工作表采用工作表索
		HSSFSheet sheet = workbook.getSheet(sheetName);

		CellStyle style = workbook.createCellStyle();
		
		//style.setBorderBottom(CellStyle.BORDER_THIN); 
		style.setBorderBottom(BorderStyle.THIN); 
		style.setBottomBorderColor(IndexedColors.BLACK.getIndex()); //IndexedColors颜色处理器，IndexedColors.BLACK.getIndex(),表示获取BLACK(黑色)的颜色编号。

		System.out.println("IndexedColors.BLACK.getIndex()="+IndexedColors.BLACK.getIndex());
		//style.setBorderLeft(CellStyle.BORDER_THIN); 
		style.setBorderLeft(BorderStyle.THIN); 

		style.setLeftBorderColor(IndexedColors.BLACK.getIndex());

		System.out.println("IndexedColors.GREEN.getIndex()="+IndexedColors.GREEN.getIndex()); //IndexedColors颜色处理器，IndexedColors.BLACK.getIndex(),表示获取GREEN(绿色)的颜色编号。
		//style.setBorderRight(CellStyle.BORDER_THIN);
		style.setBorderRight(BorderStyle.THIN);

		style.setRightBorderColor(IndexedColors.BLACK.getIndex());
		System.out.println("IndexedColors.BLUE.getIndex()="+IndexedColors.BLUE.getIndex()); //IndexedColors颜色处理器，IndexedColors.BLACK.getIndex(),表示获取BLUE(蓝色)的颜色编号。

		//style.setBorderTop(CellStyle.BORDER_THIN);
		style.setBorderTop(BorderStyle.THIN);//CellStyle.BORDER_MEDIUM_DASHED 虚线

		style.setTopBorderColor(IndexedColors.BLACK.getIndex());
		if (sheet == null)
			sheet = workbook.createSheet(sheetName);
		HSSFRow row;
		HSSFCell cell1;
		int rows = sheet.getLastRowNum();
		rows = columnList.size();
		for (int icount = 0; icount < rows; icount++) {
			row = sheet.getRow(icount);
			if (row == null)
				row = sheet.createRow(icount);
			// int line=row.getPhysicalNumberOfCells();
			int line = columnList.get(icount).size();
			for (int j = 0; j < line; j++) {
				cell1 = row.getCell(j);
				if (cell1 == null) {
					cell1 = row.createCell(j);
				}
				else {
					
				}
				cell1.setCellValue(columnList.get(icount).get(j));
				cell1.setCellStyle(style);  
				 /* 连接跳转*/
		        CreationHelper createHelper = workbook.getCreationHelper();
		        
				HSSFHyperlink hyperlink = (HSSFHyperlink) createHelper.createHyperlink(HyperlinkType.DOCUMENT); 
				//HSSFHyperlink hyperlink = sheet.;//new HSSFHyperlink(HSSFHyperlink.LINK_FILE);  
	            // "#"表示本文档    "明细页面"表示sheet页名称  "A10"表示第几列第几行  
				hyperlink.setAddress(columnList.get(icount).get(j)+"!A10");  
				cell1.setHyperlink(hyperlink);
				// System.out.println(cell1+"--"+icount+"---"+j);
			}
		}
		// 新建输流
		FileOutputStream fout = new FileOutputStream(fileName); // PS：filename 另存路径处接写入模版文件
		// 存盘
		workbook.write(fout);
		fout.flush();
		// 结束关闭
		fout.close();
	}

	/**
	 * 
	 * @param fileName   数据次要存入的excel文件名称
	 * @param sheetName  数据次要写入的sheet名称
	 * @param columnList 次要写入的数据列表 ，如此做的可扩展必存在问题，还是应该用对象的方法来处理。2021-07-09
	 * @throws IOException
	 */
	public static void createDictionarySheet(String fileName, String sheetName,
			List<HashMap<Integer, String>> columnList) throws IOException {
		HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(fileName));
		// 按名引用excel工
		// HSSFSheet sheet = workbook.getSheet("JSP");
		// 用式获取excel工作表采用工作表索
		HSSFSheet sheet = workbook.getSheet(sheetName);

		CellStyle style = workbook.createCellStyle();
		//style.setBorderBottom(CellStyle.BORDER_THIN); 
		style.setBorderBottom(BorderStyle.THIN); 
		style.setBottomBorderColor(IndexedColors.BLACK.getIndex()); //IndexedColors颜色处理器，IndexedColors.BLACK.getIndex(),表示获取BLACK(黑色)的颜色编号。

		System.out.println("IndexedColors.BLACK.getIndex()="+IndexedColors.BLACK.getIndex());
		//style.setBorderLeft(CellStyle.BORDER_THIN); 
		style.setBorderLeft(BorderStyle.THIN); 

		style.setLeftBorderColor(IndexedColors.BLACK.getIndex());

		System.out.println("IndexedColors.GREEN.getIndex()="+IndexedColors.GREEN.getIndex()); //IndexedColors颜色处理器，IndexedColors.BLACK.getIndex(),表示获取GREEN(绿色)的颜色编号。
		//style.setBorderRight(CellStyle.BORDER_THIN);
		style.setBorderRight(BorderStyle.THIN);

		style.setRightBorderColor(IndexedColors.BLACK.getIndex());
		System.out.println("IndexedColors.BLUE.getIndex()="+IndexedColors.BLUE.getIndex()); //IndexedColors颜色处理器，IndexedColors.BLACK.getIndex(),表示获取BLUE(蓝色)的颜色编号。

		style.setBorderTop(BorderStyle.THIN);
		//style.setBorderTop(CellStyle.BORDER_THIN);//CellStyle.BORDER_MEDIUM_DASHED 虚线

		style.setTopBorderColor(IndexedColors.BLACK.getIndex());
		if (sheet == null)
			sheet = workbook.createSheet(sheetName);
		HSSFRow row;
		HSSFCell cell1;
		int rows = sheet.getLastRowNum();
		rows = columnList.size();
		for (int icount = 0; icount < rows; icount++) {
			row = sheet.getRow(icount);
			if (row == null)
				row = sheet.createRow(icount);
			// int line=row.getPhysicalNumberOfCells();
			int line = columnList.get(icount).size();
			for (int j = 0; j < line; j++) {
				cell1 = row.getCell(j);
				if (cell1 == null) {
					cell1 = row.createCell(j);
				}else {
					
				}
				cell1.setCellValue(columnList.get(icount).get(j));
				cell1.setCellStyle(style);
				// System.out.println(cell1+"--"+icount+"---"+j);
			}
		}
		// 新建输流
		FileOutputStream fout = new FileOutputStream(fileName); // PS：filename 另存路径处接写入模版文件
		// 存盘
		workbook.write(fout);
		fout.flush();
		// 结束关闭
		fout.close();
	}
	public static List allUserTables() {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();

		// 开始一个事务
		// Transaction tx = session.beginTransaction();
		String sqlString = "SELECT TABLE_NAME,TABLESPACE_NAME FROM USER_TABLES ORDER BY TABLE_NAME";

		// SQLQuery sqlQuery =

		/*
		 * List list = session.createSQLQuery(sqlString).addScalar("TABLE_NAME",
		 * StringType.INSTANCE) .addScalar("TABLESPACE_NAME",
		 * StringType.INSTANCE).list();
		 */
		SQLQuery sqlQuery = session.createSQLQuery(sqlString);
		sqlQuery.addScalar("TABLE_NAME", StringType.INSTANCE);
		sqlQuery.addScalar("TABLESPACE_NAME", StringType.INSTANCE);
		List list = sqlQuery.list();
		List<HashMap<Integer, String>> tableList = new ArrayList();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			//
			Object[] objects = (Object[]) iterator.next();
			System.out.println("TABLE_NAME=" + objects[0]);
			System.out.println("TABLESPACE_NAME=" + objects[1]);
			HashMap tableName = new HashMap<Integer, String>();
			tableName.put(1, objects[0]);
			tableName.put(2, objects[1]);
			tableList.add(tableName);
		}
		return tableList;
	}

	public static List tableDictionary(String tableName) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();

		// 开始一个事务
		// Transaction tx = session.beginTransaction();
		String mySQLSqlString = "SELECT  UPPER(C.ORDINAL_POSITION) AS ORDINAL_POSITION, "
				+ "UPPER(C.COLUMN_NAME) AS COLUMN_NAME , UPPER(C.COLUMN_COMMENT) AS COLUMN_COMMENT,\r\n"
				+ "UPPER(C.COLUMN_TYPE) AS COLUMN_TYPE,UPPER(C.IS_NULLABLE) AS IS_NULLABLE, \r\n"
				+ "    UPPER(C.COLUMN_KEY) AS IS_PRIMARY_KEY \r\n" + "FROM\r\n" + "    information_schema.COLUMNS C\r\n"
				+ "INNER JOIN information_schema.TABLES T ON C.TABLE_SCHEMA = T.TABLE_SCHEMA\r\n"
				+ "AND C.TABLE_NAME = T.TABLE_NAME WHERE T.TABLE_SCHEMA = 'HUBEI_DATA'  AND  "
				+ "T.TABLE_NAME='RS_FAULT_DUTY_REASON_AMOUNT'  ORDER BY  C.ORDINAL_POSITION";
		String oracleSqlString = "SELECT A.COLUMN_NAME,B.COMMENTS, "
				+ "DECODE(A.DATA_TYPE,'DATE',A.DATA_TYPE,'NUMBER',(A.DATA_TYPE||'('||A.DATA_PRECISION||','||A.DATA_SCALE||')'),"
				+ "'NVARCHAR2',(A.DATA_TYPE||'('||A.DATA_LENGTH/2||')'),(A.DATA_TYPE||'('||A.DATA_LENGTH||')')) DATA_TYPE,"
				+ "DECODE(NULLABLE,'N','NOT NULL','Y','NULL','NULL') NULLABLE,"
				+ "(SELECT DECODE(CON.CONSTRAINT_TYPE,'P','PRIMARY KEY','R','FOREIGN KEY') FROM USER_CONSTRAINTS CON ,"
				+ "USER_CONS_COLUMNS COL WHERE CON.CONSTRAINT_NAME=COL.CONSTRAINT_NAME"
				+ " AND (CON.CONSTRAINT_TYPE='P'OR CON.CONSTRAINT_TYPE='R' )AND "
				+ "COL.TABLE_NAME=A.TABLE_NAME AND  COL.COLUMN_NAME=A.COLUMN_NAME ) IS_PRIMARY_FOREIGN_KEY "
				+ "FROM USER_TAB_COLUMNS A  INNER JOIN USER_COL_COMMENTS B  ON ( "
				+ "A.TABLE_NAME=B.TABLE_NAME AND  A.COLUMN_NAME=B.COLUMN_NAME )  WHERE A.TABLE_NAME=B.TABLE_NAME AND  "
				+ "B.TABLE_NAME=? ORDER BY  A.COLUMN_ID";

		// SQLQuery sqlQuery =

		/*
		 * List list = session.createSQLQuery(sqlString).addScalar("TABLE_NAME",
		 * StringType.INSTANCE) .addScalar("TABLESPACE_NAME",
		 * StringType.INSTANCE).list();
		 */
		SQLQuery sqlQuery = session.createSQLQuery(oracleSqlString);
		sqlQuery.setString(0, tableName);
		sqlQuery.addScalar("COLUMN_NAME", StringType.INSTANCE);
		sqlQuery.addScalar("COMMENTS", StringType.INSTANCE);
		sqlQuery.addScalar("DATA_TYPE", StringType.INSTANCE);
		sqlQuery.addScalar("NULLABLE", StringType.INSTANCE);
		sqlQuery.addScalar("IS_PRIMARY_FOREIGN_KEY", StringType.INSTANCE);
		List<HashMap<Integer, String>> columnList = new ArrayList();
		List list = sqlQuery.list();

		HashMap tableLine = new HashMap<Integer, String>();

		tableLine.put(0, "");
		tableLine.put(1, "tableName（表名）");
		tableLine.put(2, tableName);
		tableLine.put(3, "");
		tableLine.put(4, "");
		tableLine.put(5, "");
		columnList.add(tableLine);
		HashMap tableHead = new HashMap<Integer, String>();
		tableHead.put(0, "SERIAL_NUMBER");
		tableHead.put(1, "FIELD_NAME");
		tableHead.put(2, "COLUMN_NAME");
		tableHead.put(3, "DATA_TYPE");
		tableHead.put(4, "NULLABLE");
		tableHead.put(5, "IS_PRIMARY_FOREIGN_KEY");
		columnList.add(tableHead);
		HashMap tableHead2 = new HashMap<Integer, String>();
		tableHead2.put(0, "序号");
		tableHead2.put(1, "字段");
		tableHead2.put(2, "字段名");
		tableHead2.put(3, "数据类型");
		tableHead2.put(4, "是否为空");
		tableHead2.put(5, "主/外键");
		columnList.add(tableHead2);
		int i = 1;
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			//
			Object[] objects = (Object[]) iterator.next();
			/*
			 * System.out.println("COLUMN_NAME="+objects[0]);
			 * System.out.println("COMMENTS="+objects[1]);
			 * System.out.println("DATA_TYPE="+objects[2]);
			 * System.out.println("NULLABLE="+objects[3]);
			 * System.out.println("IS_PRIMARY_FOREIGN_KEY="+objects[4]);
			 * System.out.println();
			 */
			HashMap columnProperty = new HashMap<Integer, String>();
			columnProperty.put(0, "" + (i++));
			columnProperty.put(1, objects[0]);
			columnProperty.put(2, objects[1]);
			columnProperty.put(3, objects[2]);
			columnProperty.put(4, objects[3]);
			columnProperty.put(5, objects[4]);
			columnList.add(columnProperty);
		}
		sf.close();
		return columnList;
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
}
