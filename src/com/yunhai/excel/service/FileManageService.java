package com.yunhai.excel.service;

import java.util.List;

import com.yunhai.excel.dao.FileManageDao;
import com.yunhai.excel.orm.ExcelFile;
import com.yunhai.excel.orm.ExcelSheet;
import com.yunhai.file.orm.StoragePath;

public class FileManageService {
	public List<StoragePath> queryAllStoragePathWithOwner(String owner) {
		List<StoragePath> list = new FileManageDao().queryAllStoragePathWithOwner(owner);
		return list;
	}

	public void fileInforSave(List fileList, String serverCode, String userName) {
		new FileManageDao().fileInforSave(fileList, serverCode, userName);
	}

	public List getAllExcelSheetAndSave(String fileName, String serverCode) {
		return new FileManageDao().getAllExcelSheetAndSave(fileName, serverCode);
	}

	public Boolean fileExistCheck(String fileName, String savePath, String serverCode) {
		return new FileManageDao().fileExistCheck(fileName, savePath, serverCode);
	}

	public List queryAllExcelFileFromDatabase(String serverCode) {
		return new FileManageDao().queryAllExcelFileFromDatabase(serverCode);
	}

	public List queryAllExcelSheetInDatabase(String fileName, String serverCode) {
		return new FileManageDao().queryAllExcelSheetInDatabase(fileName, serverCode);
	}

	public ExcelFile getExcelFileByFileId(String excelFileId, String serverCode) {
		// TODO Auto-generated method stub
		return new FileManageDao().getExcelFileByFileId(excelFileId, serverCode);
	}

	public List getAllExcelSheetColumnAndSave(String fileName, String sheetName, String serverCode) {
		// TODO Auto-generated method stub
		List excelSheetColumnList = new FileManageDao().getAllExcelSheetColumnAndSave(fileName, sheetName, serverCode);
		return excelSheetColumnList;
	}

	public List getColumnValueType(String serverCode) {
		// TODO Auto-generated method stub
		List columnValueTypeList=new FileManageDao().getColumnValueType(serverCode);
		return columnValueTypeList;
	}

	public ExcelSheet getExcelSheetBySheetId(String excelSheetId, String serverCode) {
		// TODO Auto-generated method stub
		ExcelSheet sheet=new FileManageDao().getExcelSheetBySheetId(excelSheetId, serverCode);
		return sheet;
	}

	public List getColumnListBySheetId(String excelSheetId, String serverCode) {
		// TODO Auto-generated method stub
		List columnList=new FileManageDao().getColumnListBySheetId(excelSheetId, serverCode);
		return columnList;
	}

	public ExcelFile queryExcelFileByFileName(String serverCode, String fileName) {
		// TODO Auto-generated method stub
		ExcelFile excelFile=new FileManageDao().queryExcelFileByFileName(serverCode,fileName);
		return excelFile;
	}

	public List queryColumnExistSheetList(String fileName, String serverCode) {
		// TODO Auto-generated method stub
		return null;
	}
}
