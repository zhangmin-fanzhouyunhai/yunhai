package com.yunhai.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import jxl.read.biff.BiffException;


public class ExcelManager {
	private static final String EXCEL_XLS = "xls";
	private static final String EXCEL_XLSX = "xlsx";

	public static void main(String[] args) {
		String pathStr = "F:/Workspace/0-国网总部/2020/数据支撑/0710全网汇总-总公司提供/导入时进行过问题处理的版本-全国/2019_年电网实物资产分析评价数据汇总表-_国网北京市电力公司.xls";
		pathStr = "D:/ProgramFiles/Workspaces/workspace/Day29/WebRoot/userFile/excel/冀北“选好”设备-35kV开关柜-反馈数据汇总-V4.7-20220824.xlsx";
		// envInfo();
		// test( pathStr);
		ArrayList sheetNameList=getAllSheets(pathStr);
		for(int i=0;i<sheetNameList.size();i++) {
			System.out.println(sheetNameList.get(i));
		}
	}

	public static void excelPares(String pathStrWithFileName) {
		OutputStream out = null;
		File errorFile = new File(pathStrWithFileName);

	}

	/**
	 * 鍒ゆ柇Excel鐨勭増鏈?,鑾峰彇Workbook
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

	public static void envInfo() {
		Map map = System.getenv();
		Collection mapValues = map.values();
		Set keySet = map.keySet();
		Iterator keyIt = keySet.iterator();
		int itemInd = 0;
		Iterator valueIt = mapValues.iterator();
		while (keyIt.hasNext()) {
			System.out.println("key[" + itemInd + "]=" + keyIt.next() + ",values[" + itemInd + "]=" + valueIt.next());
		}
	}

	public static void test(String pathStr) {
		ExcelManager excelManager = new ExcelManager();
		// ArrayList<String> sheetList=excelManager.getAllSheets(pathStr);
		// excelManager.sheetContentOutputJxl(pathStr,sheetList.get(2));
		try {
			excelManager.showAllSheet(pathStr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String path = "F:/国网调整后河北技改项目820项（资产性质省公司）.xls";
		String sheetName = "计划清单";
		try {
			excelManager.getRowQuantity(path, sheetName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static ArrayList<String> getAllSheets(String pathStr) {

		ArrayList<String> sheetList = new ArrayList();
		File file = new File(pathStr);

		// 创建新的Excel工作簿
		Workbook workbook = null; 
		try { 
				workbook = getWorkbok(file); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		Iterator<Sheet>sheetIt=workbook.sheetIterator();
		while(sheetIt.hasNext()) { 
			sheetList.add(sheetIt.next().getSheetName());
		} 

		return sheetList;
	}

	public ArrayList<String> sheetContentOutputJxl(String pathStr, String sheetName) {

		ArrayList<String> sheetList = new ArrayList();
		File file = new File(pathStr);

		// 创建新的Excel工作簿
		jxl.Workbook workbook = null;
		try {
			workbook = jxl.Workbook.getWorkbook(file);
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jxl.Sheet sheet = workbook.getSheet(sheetName);

		int columnNumber = sheet.getColumns();
		int rowNumber = sheet.getRows();
		for (int rowI = 0; rowI < columnNumber; rowI++) {
			jxl.Cell cells[] = sheet.getRow(rowI);
			if (cells.length < columnNumber) {
				System.out.println("cells.length=" + cells.length);
			} else {
				System.out.println("columnNumber=" + columnNumber);
			}
			for (int colJ = 0; colJ < columnNumber; colJ++) {
				jxl.Cell cell = sheet.getCell(rowI, colJ);

				System.out.println("cell.getContents()= |" + cell.getContents());
			}

		}

		return sheetList;
	}

	public void showAllSheet(String pathStr) throws Exception {
		HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(new File(pathStr)));
		HSSFSheet sheet = null;
		for (int i = 0; i < workbook.getNumberOfSheets(); i++) {// 获取每个Sheet表
			// workbook.getSheet(sheetName);
			sheet = workbook.getSheetAt(i);
			System.out.println("sheetName=" + sheet.getSheetName() + "\t");
			for (int j = 0; j < sheet.getPhysicalNumberOfRows(); j++) {// 获取每行
				HSSFRow row = sheet.getRow(j);
				for (int k = 0; k < row.getPhysicalNumberOfCells(); k++) {// 获取每个单元格
					System.out.print("rowNum=" + j + " colNum=" + k + " ");
					System.out.print("cellValue=" + row.getCell(k) + "\t");
				}
				System.out.println("---Sheet表" + i + "处理完毕---");
			}
		}
	}

	public void getXRowQuantity(String path, String sheetName) throws FileNotFoundException, IOException {

		XSSFWorkbook xWork = new XSSFWorkbook(new FileInputStream(new File(path)));
		XSSFSheet xSheet = xWork.getSheet(sheetName);
		int rowQuantity = xSheet.getPhysicalNumberOfRows();
		for (int rowI = 0; rowI < rowQuantity; rowI++) {
			XSSFRow xRow = xSheet.getRow(rowI);
			int colQuantity = xRow.getPhysicalNumberOfCells();
			for (int colI = 0; colI < colQuantity; colI++) {
				XSSFCell xCell = xRow.getCell(colI);
				xCell.getCellTypeEnum();
				/*
				 * xCell.CELL_TYPE_BLANK; xCell.CELL_TYPE_BOOLEAN; xCell.CELL_TYPE_ERROR;
				 * xCell.CELL_TYPE_FORMULA; xCell.CELL_TYPE_NUMERIC; xCell.CELL_TYPE_STRING;
				 */
				if (xCell.getCellTypeEnum().equals(xCell.CELL_TYPE_STRING)) {
					System.out.println("rowQua=" + rowI + ",colQua=" + colI + " is String,yes");
				}
			}
		}

	}

	public void getRowQuantity(String path, String sheetName) throws FileNotFoundException, IOException {

		HSSFWorkbook hWork = new HSSFWorkbook(new FileInputStream(new File(path)));
		HSSFSheet xSheet = hWork.getSheet(sheetName);
		int rowQuantity = xSheet.getPhysicalNumberOfRows();
		for (int rowI = 0; rowI < rowQuantity; rowI++) {
			HSSFRow xRow = xSheet.getRow(rowI);
			int colQuantity = xRow.getPhysicalNumberOfCells();
			for (int colI = 0; colI < colQuantity; colI++) {
				HSSFCell xCell = xRow.getCell(colI);
				xCell.getCellTypeEnum();
				/*
				 * xCell.CELL_TYPE_BLANK; xCell.CELL_TYPE_BOOLEAN; xCell.CELL_TYPE_ERROR;
				 * xCell.CELL_TYPE_FORMULA; xCell.CELL_TYPE_NUMERIC; xCell.CELL_TYPE_STRING;
				 */
				if (xCell.getCellTypeEnum().equals(xCell.CELL_TYPE_STRING)) {
					System.out.println("rowQua=" + rowI + ",colQua=" + colI + " is String,yes");
				}
			}
		}

	}
}
