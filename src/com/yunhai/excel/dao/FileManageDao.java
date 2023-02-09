package com.yunhai.excel.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.yunhai.excel.orm.ColumnValueType;
import com.yunhai.excel.orm.ExcelFile;
import com.yunhai.excel.orm.ExcelSheet;
import com.yunhai.excel.orm.ExcelSheetColumn;
import com.yunhai.file.orm.StoragePath;
import com.yunhai.orm.UploadFile;
import com.yunhai.util.CommenHibernateUtil;

public class FileManageDao {
	private static final String EXCEL_XLS = "xls";
	private static final String EXCEL_XLSX = "xlsx";

	public List<StoragePath> queryAllStoragePathWithOwner(String owner) {
		// SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// ��һ��Session
		// Session session = sf.openSession();
		Session session = CommenHibernateUtil.getSession("100000000");
		String sqlStr = "SELECT * FROM STORAGE_PATH WHERE CREATOR_NAME=?";
		SQLQuery query = session.createSQLQuery(sqlStr).addEntity(StoragePath.class);
		query.setParameter(0, owner);
		List<StoragePath> list = query.list();

		return list;
	}

	public String queryFileIdByFileName(String fileName, String serverCode) {
		// SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// ��һ��Session
		// Session session = sf.openSession();
		Session session = CommenHibernateUtil.getSession(serverCode);
		String sqlStr = "SELECT * FROM EXCEL_FILE WHERE EXCEL_FILE_NAME=?";
		SQLQuery query = session.createSQLQuery(sqlStr).addEntity(ExcelFile.class);
		query.setParameter(0, fileName);

		ExcelFile excelFile = (ExcelFile) query.uniqueResult();
		String excelFileId = excelFile.getExcelFileId();
		return excelFileId;
	}

	public Boolean fileExistInDatabaseCheck(String fileName, String serverCode) {
		// SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// ��һ��Session
		// Session session = sf.openSession();
		Session session = CommenHibernateUtil.getSession(serverCode);
		String sqlStr = "SELECT * FROM EXCEL_FILE WHERE EXCEL_FILE_NAME=?";
		SQLQuery query = session.createSQLQuery(sqlStr).addEntity(ExcelFile.class);
		query.setParameter(0, fileName);
		if (query.list().size() == 1) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	public List queryAllExcelFileFromDatabase(String serverCode) {
		Session session = CommenHibernateUtil.getSession(serverCode);
		String sqlStr = "SELECT * FROM EXCEL_FILE";
		SQLQuery query = session.createSQLQuery(sqlStr).addEntity(ExcelFile.class);
		return query.list();
	}

	public Boolean fileExistCheck(String fileName, String savePath, String serverCode) {
		// SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// ��һ��Session
		// Session session = sf.openSession();
		File file = new File(savePath);
		Boolean fileExists = Boolean.FALSE;
		if (file.exists()) {
			File[] fileList = file.listFiles();
			for (int i = 0; i < fileList.length; i++) {
				if (fileList[i].isFile() && fileList[i].getName().equals(fileName)) {
					fileExists = Boolean.TRUE;
				} else {
					continue;
				}
			}
		}
		Session session = CommenHibernateUtil.getSession(serverCode);
		String sqlStr = "SELECT * FROM EXCEL_FILE WHERE EXCEL_FILE_NAME=?";
		SQLQuery query = session.createSQLQuery(sqlStr).addEntity(ExcelFile.class);
		query.setParameter(0, fileName);
		if (query.list().size() == 1 && fileExists) {
			return Boolean.TRUE;
		} else {
			return Boolean.FALSE;
		}

	}

	public void fileInforSave(List fileList, String serverCode, String userName) {
		Session session = CommenHibernateUtil.getSession(serverCode);
		List existFileList = new ArrayList();
		// ��ʼһ������
		Transaction tx = session.beginTransaction();
		for (int i = 0; i < fileList.size(); i++) {
			ExcelFile excelFile = new ExcelFile();
			UploadFile file = (UploadFile) fileList.get(i);
			// �����ݿ��еļ�¼���м�飬������ڷ���TRUE�����򷵻�FALSE
			Boolean checkValue = fileExistInDatabaseCheck(file.getFileName(), serverCode);
			/*
			 * ����ļ������ݿ��д��ڣ�����Ҫ���룬�������������Ҫ�������ݲ���
			 */
			if (!checkValue) {
				excelFile.setExcelFileName(file.getFileName());
				excelFile.setUploadDate(new Date());
				excelFile.setUploadPersonName(userName);
				//System.out.println("file.getPath()="+file.getPath());
				excelFile.setStoryPath(file.getPath());
				session.save(excelFile);
			}
		}
		tx.commit();
	}

	public List excelSheetListFromFile(String FileName) {
		List fileList = null;

		return fileList;
	}

	public List excelSheetListFromDatabase(String FileName, String serverCode) {
		List fileList = null;

		return fileList;
	}

	/**
	 * �����ļ��ĺ�׺����Workbook
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

	/**
	 * ͨ��fileId��SheetName���sheet��Ĵ�����
	 * 
	 * @param fileId
	 * @param sheetName
	 * @param serverCode
	 * @return
	 */
	public Boolean sheetExistInDatabaseCheck(String fileId, String sheetName, String serverCode) {
		Session session = CommenHibernateUtil.getSession(serverCode);
		// ��ʼһ������
		String sql = "SELECT * FROM EXCEL_SHEET WHERE EXCEL_SHEET_NAME=? AND EXCEL_FILE_ID=?";
		SQLQuery query = session.createSQLQuery(sql).addEntity(ExcelSheet.class);
		query.setString(0, sheetName);
		query.setString(1, fileId);
		List list = query.list();
		if (list.size() == 1) {
			return Boolean.TRUE;
		} else {
			return Boolean.FALSE;
		}
	}

	/**
	 * ͨ��fileName��serverCodeָ�������ݿ�������в�ѯ����excel�ļ���sheet��
	 * 
	 * @param fileName
	 * @param serverCode
	 * @return
	 */
	public List getAllExcelSheetAndSave(String fileName, String serverCode) {
		Session session = CommenHibernateUtil.getSession(serverCode);
		// ��ʼһ������
		Transaction tx = session.beginTransaction();
		int lastSlashIndex = fileName.lastIndexOf("\\");
		String fileNameWithoutPath = fileName.substring(lastSlashIndex + 1, fileName.length());
		String excelFileID = queryFileIdByFileName(fileNameWithoutPath, serverCode);

		List fileList = new ArrayList<ExcelSheet>();
		File finalXlsxFile = new File(fileName);
		try {
			Workbook workBook = getWorkbok(finalXlsxFile);
			Iterator<Sheet> sheetIter = workBook.sheetIterator();
			double index = 0.0;
			while (sheetIter.hasNext()) {
				Sheet sheet = sheetIter.next();
				ExcelSheet excelSheet = new ExcelSheet();
				excelSheet.setExcelSheetName(sheet.getSheetName());
				excelSheet.setSortIndex(index);
				excelSheet.setExcelFileId(excelFileID);
				excelSheet.setCreateDate(new Date()); 
				/**
				 * �����EXCEL_SHEET_COLUMN���д��� ��¼����columnInserted�ֶ���Ҫ����Ϊ1����������Ϊ0.
				 */
				if(columnInsertCheck(excelFileID,sheet.getSheetName(), serverCode)) {
					//System.out.println("exist column!");
					excelSheet.setColumnInserted(1);
				}else {
					excelSheet.setColumnInserted(0);
				}
				fileList.add(excelSheet);
				/**
				 * ���sheet��������EXCELL_SHEET���в����ڣ�����б��棬���򲻱��档
				 */
				if (!sheetExistInDatabaseCheck(excelFileID, sheet.getSheetName(), serverCode)) {
					session.save(excelSheet);
				} else { 
					continue;
				} 
				index++;
			}
			tx.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return fileList;
	}
	public boolean columnInsertCheck(String excelFileID,String sheetName, String serverCode) {

		Session session = CommenHibernateUtil.getSession(serverCode);
		/*
		 * ��ѯEXCEL_SHEET_COLUMN���еļ�¼���������excelFileID��sheetName��Ӧ��sheet�����������EXCEL_SHEET_COLUMN�д��ڣ�����true��
		 * ���򣬷���false
		 */
		String sqlStr="SELECT COUNT(*) QUANTITY FROM EXCEL_SHEET_COLUMN WHERE EXCEL_SHEET_ID IN "
				+ "(SELECT EXCEL_SHEET_ID FROM EXCEL_SHEET WHERE EXCEL_FILE_ID=? AND EXCEL_SHEET_NAME=?)";
		SQLQuery sqlQuery=session.createSQLQuery(sqlStr);
		sqlQuery.setString(0, excelFileID);
		sqlQuery.setString(1, sheetName);
		BigInteger quantity=((BigInteger)sqlQuery.uniqueResult());
		//System.out.println("excelFileID="+excelFileID+",sheetName="+sheetName+",quantity="+quantity+",new BigInteger(\"0\")="+new BigInteger("0")+"equal 0 :"+quantity.equals(new BigInteger("0")));
		
		if(quantity.equals(new BigInteger("0"))) {
			return false;
		}else {
			return true;
		}
	}

	/**
	 * ����fileName�ļ�������serverCodeָ�������ݿ�������в�ѯ����sheet������
	 * 
	 * @param fileName
	 * @param serverCode
	 * @return
	 */
	public List queryAllExcelSheetInDatabase(String fileName, String serverCode) {
		Session session = CommenHibernateUtil.getSession(serverCode);
		String sqlStr = "SELECT * FROM EXCEL_SHEET WHERE EXCEL_FILE_ID=";
		sqlStr = sqlStr + "(SELECT EXCEL_FILE_ID FROM EXCEL_FILE WHERE EXCEL_FILE_NAME=?)";
		SQLQuery query = session.createSQLQuery(sqlStr).addEntity(ExcelSheet.class);
		query.setParameter(0, fileName);
		return query.list();
	}

	/**
	 * ����fileName(�����ļ�·��������ȡExcel���ļ�sheet���¼��
	 * ���fileName��servrCode��EXCEL_FILE�л�ȡ�õ�Excel�ļ���ID��¼
	 * 
	 * @param fileName
	 * @param serverCode
	 * @return fileList �����ļ��е�sheet��
	 */
	public List getAllExcelSheetFromFile(String fileName, String serverCode) {
		int lastSlashIndex = fileName.lastIndexOf("\\");
		String fileNameWithoutPath = fileName.substring(lastSlashIndex + 1, fileName.length());
		String excelFileID = queryFileIdByFileName(fileNameWithoutPath, serverCode);
		// System.out.println("lastSlashIndex=" + lastSlashIndex +
		// "fileNameWithoutPath=" + fileNameWithoutPath);
		List fileList = new ArrayList<ExcelSheet>();
		File finalXlsxFile = new File(fileName);
		try {
			Workbook workBook = getWorkbok(finalXlsxFile);
			Iterator<Sheet> sheetIter = workBook.sheetIterator();
			double index = 0.0;
			while (sheetIter.hasNext()) {
				Sheet sheet = sheetIter.next();
				ExcelSheet excelSheet = new ExcelSheet();
				excelSheet.setExcelSheetName(sheet.getSheetName());
				excelSheet.setSortIndex(index);
				excelSheet.setExcelFileId(excelFileID);
				fileList.add(excelSheet);
				index++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fileList;
	}

	/**
	 * ����excel�ļ���fileName����serverCodeָ�������ݿ��б���excel��sheet����Ϣ��
	 * 
	 * @param fileName
	 * @param serverCode
	 * @return
	 */
	public List excelSheetSave(String fileName, String serverCode) {
		Session session = CommenHibernateUtil.getSession(serverCode);
		// ��ʼһ������
		Transaction tx = session.beginTransaction();
		List fileList = new ArrayList<ExcelSheet>();
		File finalXlsxFile = new File(fileName);
		String excelFileId = queryFileIdByFileName(fileName, serverCode);
		try {
			Workbook workBook = getWorkbok(finalXlsxFile);
			Iterator<Sheet> sheetIter = workBook.sheetIterator();
			double index = 0.0;
			while (sheetIter.hasNext()) {
				Sheet sheet = sheetIter.next();
				ExcelSheet excelSheet = new ExcelSheet();
				excelSheet.setExcelSheetName(sheet.getSheetName());
				excelSheet.setSortIndex(index);
				excelSheet.setExcelFileId(excelFileId);
				fileList.add(excelSheet);
				session.save(excelSheet);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tx.commit();
		return fileList;
	}

	public ExcelFile getExcelFileByFileId(String excelFileId, String serverCode) {
		Session session = CommenHibernateUtil.getSession(serverCode);
		String sqlStr = "SELECT * FROM EXCEL_FILE WHERE EXCEL_FILE_ID=?";
		SQLQuery query = session.createSQLQuery(sqlStr).addEntity(ExcelFile.class);
		query.setParameter(0, excelFileId);
		return (ExcelFile) query.list().get(0);
	}

	public String getExcelSheetIdByFileNameAndSheetName(String fileName, String sheetName, String serverCode) {
		Session session = CommenHibernateUtil.getSession(serverCode);
		String sqlStr = "SELECT EXCEL_SHEET_ID FROM EXCEL_SHEET B WHERE B.EXCEL_SHEET_NAME=? \r\n"
				+ " AND B.EXCEL_FILE_ID=(SELECT EXCEL_FILE_ID FROM EXCEL_FILE A WHERE A.EXCEL_FILE_NAME=?) ";
		//System.out.println("fileName="+fileName+",sheetName="+sheetName);
		SQLQuery query = session.createSQLQuery(sqlStr);
		query.setString(0, sheetName);
		query.setString(1, fileName);
		List list = query.list();
		if (list.size() == 0) {
			return null;
		} else {
			return (String) query.list().get(0);
		}
	}

	public List getAllExcelSheetColumnAndSave(String fileName, String sheetName, String serverCode) {
		// TODO Auto-generated method stub
		Session session = CommenHibernateUtil.getSession(serverCode);
		//��ȡ����·�����ļ�����
		String fileNameWithOutPath = fileName.substring(fileName.lastIndexOf("\\")+1);
		//��ȡsheet��ļ�¼ID
		String excelSheetId = getExcelSheetIdByFileNameAndSheetName(fileNameWithOutPath, sheetName, serverCode);
		// ��ʼһ������
		Transaction tx = session.beginTransaction();
		List columnList = new ArrayList<ExcelSheetColumn>();
		
		File finalXlsxFile = new File(fileName);
		try {
			Workbook workBook = getWorkbok(finalXlsxFile);
			Sheet sheet = workBook.getSheet(sheetName);
			Row row = sheet.getRow(0);
			Iterator<Cell> cellIter = row.cellIterator();
			double index = 0.0;
			
			while (cellIter.hasNext()) {
				Cell cell = cellIter.next();
				ExcelSheetColumn excelSheetColumn = new ExcelSheetColumn();
				excelSheetColumn.setExcelSheetColumnName(cell.getStringCellValue());
				excelSheetColumn.setSortIndex(index);
				//System.out.println("index="+index);
				excelSheetColumn.setExcelSheetId(excelSheetId);
				excelSheetColumn.setDataType("�ַ�����");
				excelSheetColumn.setDataTypeCode("100");
				excelSheetColumn.setCreateDate(new Date());
				//System.out.println("excelSheetId="+excelSheetId);
				index = index+1.0;
				//fileList.add(excelSheetColumn);
				/**
				* ���sheet��������EXCELL_SHEET���в����ڣ�����б��棬���򲻱��档
				*/
				if (!columnNameExistInDatabaseCheck(excelSheetId, excelSheetColumn.getExcelSheetColumnName(),
						serverCode)) {
					//System.out.println(excelSheetColumn.getExcelSheetColumnName()+" not exists!");
					session.save(excelSheetColumn);
				} else {
					continue;
				}
			}
			tx.commit(); 
			/**
			 * ��������еĲ���֮�����EXCEL_SHEET���е�COLUMN_INSERTED�ֶν������ݸ��£�����Ϊ1.
			 * After the insert of column's attribute , we should to update the value 
			 * of field COLUMN_INSERTED of table EXCEL_SHEET  
			 */
			Transaction tx2= session.beginTransaction();
			String sqlStr="UPDATE EXCEL_SHEET SET COLUMN_INSERTED = 1 WHERE EXCEL_FILE_ID = ? AND EXCEL_SHEET_NAME = ?";
			SQLQuery sqlQuery= session.createSQLQuery(sqlStr);
			
			String fileId=queryFileIdByFileName(fileNameWithOutPath, serverCode);
			//System.out.println("fileId="+fileId+",sheetName="+sheetName);
			sqlQuery.setString(0, fileId);
			sqlQuery.setString(1, sheetName);
			sqlQuery.executeUpdate();
			tx2.commit(); 
			/**
			 * After the insert of column's attribute and the update of 
			 * table EXCEL_SHEET's field COLUMN_INSERTED , 
			 * we can query all column with EXCEL_SHEET_COLUMN_ID field value 
			 * which only after insert into database,
			 * and then return.
			 * ����ֶεĲ�����EXCEL_SHEET������Ӧ��¼COLUMN_INSERTED�ֶεĸ��º�
			 * ���ǿ��Դ�EXCEL_SHEET_COLUMN���в�ѯ����Ӧsheet�������column���Լ�¼��
			 * ����EXCEL_SHEET_COLUMN_ID�ֶ�ֵ(��ֻ������������ݿ�Ĳ��룬���������ݿ�����)�� 
			 */
			String querySqlStr="SELECT * FROM EXCEL_SHEET_COLUMN WHERE EXCEL_SHEET_ID= ? ";
			SQLQuery  colSqlQuery=session.createSQLQuery(querySqlStr).addEntity(ExcelSheetColumn.class);
			colSqlQuery.setString(0, excelSheetId);
			columnList=colSqlQuery.list();
			//System.out.println("The length of columnList is :"+columnList.size());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return columnList;
	}

	private boolean columnNameExistInDatabaseCheck(String excelSheetId, String excelSheetColumnName,
			String serverCode) {
		// TODO Auto-generated method stub

		Session session = CommenHibernateUtil.getSession(serverCode);
		// ��ʼһ������
		String sql = "SELECT * FROM EXCEL_SHEET_COLUMN WHERE EXCEL_SHEET_ID=? AND EXCEL_SHEET_COLUMN_NAME=?";
		SQLQuery query = session.createSQLQuery(sql);
		query.setString(0, excelSheetId);
		query.setString(1, excelSheetColumnName);
		List list = query.list(); 
		if (list.size() == 1) {
			return Boolean.TRUE;
		} else {
			return Boolean.FALSE;
		}
	}

	public List getColumnValueType(String serverCode) {
		// TODO Auto-generated method stub
		Session session = CommenHibernateUtil.getSession(serverCode);
		// ��ʼһ������
		String sql = "SELECT * FROM COLUMN_VALUE_TYPE ";
		SQLQuery query = session.createSQLQuery(sql).addEntity(ColumnValueType.class);
		List list=query.list();
		return list;
	}

	public ExcelSheet getExcelSheetBySheetId(String excelSheetId, String serverCode) {
		// TODO Auto-generated method stub
		Session session = CommenHibernateUtil.getSession(serverCode);
		// ��ʼһ������
		String sql = "SELECT * FROM EXCEL_SHEET WHERE EXCEL_SHEET_ID=? ";
		SQLQuery query = session.createSQLQuery(sql).addEntity(ExcelSheet.class);
		query.setString(0, excelSheetId); 
		List list=query.list();
		ExcelSheet sheet;
		if(null==list) {
			sheet=null;
		}else {
			sheet=(ExcelSheet) list.get(0);
		}
		return sheet;
	}

	public List getColumnListBySheetId(String excelSheetId, String serverCode) {
		// TODO Auto-generated method stub
		Session session = CommenHibernateUtil.getSession(serverCode);
		// ��ʼһ������
		String sql = "SELECT * FROM EXCEL_SHEET_COLUMN WHERE EXCEL_SHEET_ID=? ";
		SQLQuery query = session.createSQLQuery(sql).addEntity(ExcelSheetColumn.class);
		query.setString(0, excelSheetId); 
		List list=query.list(); 
		return list;
	}

	public ExcelFile queryExcelFileByFileName(String serverCode, String fileName) {
		// TODO Auto-generated method stub 
		Session session = CommenHibernateUtil.getSession(serverCode);
		String sqlStr = "SELECT * FROM EXCEL_FILE WHERE EXCEL_FILE_Name=?";
		SQLQuery query = session.createSQLQuery(sqlStr).addEntity(ExcelFile.class);
		query.setParameter(0, fileName);
		return (ExcelFile) query.list().get(0); 
	}

}
