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
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.yunhai.excel.table.model.orm.TableColumnStructureElement;
import com.yunhai.excel.table.model.orm.TableRowStructureElement;

public class ReadExcel {

	private static final String EXCEL_XLS = "xls";
	private static final String EXCEL_XLSX = "xlsx";

	public static void main(String[] args) throws FileNotFoundException, IOException {
		readAllFile();
		// compareAllFile();
		String formulaOriginFile = "D:/temp/实物资产评价数据�?2019-1107-上报数据/电网实物资产分析评价数据收集�?-湖北上报�?20191031_V10.0 F-�?新模�?.xls";
		String copyTargeFilePath = "D:/temp/实物资产评价数据�?2019-1107-恢复公式/省公司资�?";
		//outputFormula(copyTargeFilePath);
		//

		// copyFormula(formulaOriginFile, copyTargeFilePath);
		// copyTargeFilePath = "D:/temp/实物资产评价数据�?2019-1107-恢复公式/分部资产";
		// copyFormula(formulaOriginFile, copyTargeFilePath);
		// copyTargeFilePath = "D:/temp/实物资产评价数据�?2019-1107-恢复公式/总部资产";
		// copyFormula(formulaOriginFile, copyTargeFilePath);

		//

		String compareFilePath = "D:/temp/实物资产评价数据�?2019-1107-恢复公式/分部资产";
		String comparedFilePath = "D:/temp/实物资产评价数据�?2019-1107-上报数据/分部资产";
		String errorFilePath = "D:/temp/实物资产评价数据�?2019-1107-上报数据/分部资产errorValue-20191107.xls";

		// batchFileCompare(comparedFilePath, compareFilePath, errorFilePath);

		compareFilePath = "D:/temp/实物资产评价数据�?2019-1107-恢复公式/省公司资�?";
		comparedFilePath = "D:/temp/实物资产评价数据�?2019-1107-上报数据/省公司资�?";

		errorFilePath = "D:/temp/实物资产评价数据�?2019-1107-上报数据/省公司资产errorValue-20191107.xls";

		//batchFileCompare(comparedFilePath, compareFilePath, errorFilePath);

		//compareFilePath = "D:/temp/实物资产评价数据�?2019-1107-恢复公式/总部资产";

		//comparedFilePath = "D:/temp/实物资产评价数据�?2019-1107-上报数据/总部资产";

		//errorFilePath = "D:/temp/实物资产评价数据�?2019-1107-上报数据/总部资产errorValue-20191107.xls";
		//batchFileCompare(comparedFilePath, compareFilePath, errorFilePath);

		// compareFilePath = "D:/temp/公式恢复/20191101 总部 网省数据校核 已校�?/分部资产";
		// comparedFilePath = "D:/temp/实物资产评价数据-1101-全部/分部资产";
		// errorFilePath = "D:/temp/实物资产评价数据-1101-全部/error/分部资产errorValue-20191101.xls";
		// batchFileCompare(comparedFilePath, compareFilePath, errorFilePath);
		// compareFilePath = "D:/temp/公式恢复/20191101 总部 网省数据校核 已校�?/省公�?";
		// comparedFilePath = "D:/temp/实物资产评价数据-1101-全部/省公司资�?";
		// errorFilePath =
		// "D:/temp/实物资产评价数据-1101-全部/error/省公司资产errorValue-20191101.xls";
		// batchFileCompare(comparedFilePath, compareFilePath, errorFilePath);
		// compareFilePath = "D:/temp/公式恢复/20191101 总部 网省数据校核 已校�?/总部";
		// comparedFilePath = "D:/temp/实物资产评价数据-1101-全部/总部资产";
		// errorFilePath = "D:/temp/实物资产评价数据-1101-全部/error/总部资产errorValue-20191101.xls";
		// 
		//batchFileCompare(comparedFilePath, compareFilePath, errorFilePath);

		// tableStructureTest();
			//
		String filename="D:\\temp\\test20210708-3.xls";
		String targetFileName="D:\\temp\\test20210708-2.xls";
		
		File file= new File(filename);
		//file.createNewFile(); 
		File targetFile= new File(targetFileName);
		if(targetFile!=null) {
			//targetFile= new File(targetFileName);
			//
		}
		copyFile(file,targetFile); 
		//file.createNewFile();
					HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(targetFileName));
			//��������excel��
			// HSSFSheet sheet = workbook.getSheet("JSP");
			//��ʽ��ȡexcel���������ù�������
			HSSFSheet sheet = workbook.getSheet("Sheet1");
			if(sheet==null)
				sheet=workbook.createSheet("Sheet1");
			HSSFRow row ;
			HSSFCell cell1;
			int rows=sheet.getLastRowNum();
			rows=8;
			for(int icount=1;icount<rows;icount++){
			row = sheet.getRow(icount);
			if(row==null)
					row=sheet.createRow(icount);
			//int line=row.getPhysicalNumberOfCells();
			int line=8;
			for(int j=1;j<line;j++){
			cell1= row.getCell(j);
			if(cell1==null)
			cell1=row.createCell(j);
			cell1.setCellValue(j);
			System.out.println(cell1+"--"+icount+"---"+j);
			}
			}
			//�½�����
			FileOutputStream fout = new FileOutputStream(targetFileName); //PS��filename ����·������д��ģ���ļ�
			//����
			workbook.write(fout);
			fout.flush();
			//�����ر�
			fout.close();
	}

	/**
	 * ����4��ʵ���ļ����� 1.�ֽ�����������д�ֽ����� ����ʱ�䣺137ms
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
			throw new RuntimeException("�ļ�д��ʧ��");
		}
	}
	public static void outputFormula(String compareFilePath) {

		DecimalFormat df = new DecimalFormat("#.0000");
		OutputStream out = null;
		try {
			boolean flag = false;
			// 创建�?要复制公式的目标EXCEL文件�?在路径文件对�?
			File copyTargePathFile = new File(compareFilePath);
			// 得到路径下所有文件的列表
			File[] copyTargeFileList = copyTargePathFile.listFiles();
			for (int k = 0; k < copyTargeFileList.length; k++) {
				String copyTargeFile = compareFilePath + "\\" + copyTargeFileList[k].getName();
				// System.out.println("copyTargeFileList["+k+"]="+
				// copyTargeFileList[k].getName());
				// System.out.println("copyTargeFileList"+copyTargeFilePath);
				// 创建�?要复制公式的目标EXCEL文件工作簿的引用
				HSSFWorkbook copyTargeFileWorkbook = new HSSFWorkbook(new FileInputStream(copyTargeFile));
				copyTargeFileWorkbook.getCellStyleAt(1);
				HSSFCellStyle copyTargeCellStyle = copyTargeFileWorkbook.createCellStyle();
				System.out.println("copyTargeCellStyle.getDataFormat()" + copyTargeCellStyle.getDataFormat());
				HSSFDataFormat hssfDataFormat;
				// copyTargeFileWorkbook.setForceFormulaRecalculation(true);
				// HSSFFormulaEvaluator.evaluateAllFormulaCells(copyTargeFileWorkbook);
				// 在Excel文档中，第一张工作表的缺省索引是0
				// 其语句为：HSSFSheet sheet = workbook.getSheetAt(0);
				// HSSFSheet sheet = workbook.getSheet("Sheet1");
				// 获取excel中Sheet的数�?
				int copyTargeFileSheetNumber = copyTargeFileWorkbook.getNumberOfSheets();
				HSSFSheet copyTargeFileSheet;
				HSSFSheet formulaOriginFileSheet;
				// System.out.println("sheet.getSheetName()="+sheet.getSheetName());
				// 获取打印Sheet的数�?
				// System.out.println("file_name["+k+"]="+ tempList[k].getName()+",The quantity
				// of sheets"+workbook.getNumberOfSheets());
				// 获取到Excel文件中的�?有行�?
				/* int rows = sheet.getPhysicalNumberOfRows(); */
				// 遍历输出�?有sheet表的名称
				for (int sheetI = 0; sheetI < copyTargeFileSheetNumber; sheetI++) {
					// 获取Sheet对象
					copyTargeFileSheet = copyTargeFileWorkbook.getSheetAt(sheetI);
					// 输出遍历到的sheet表的名称
					// System.out.println("file_name["+k+"]="+ tempList[k].getName()+",The name of
					// "+"the "+(sheetI+1)+"th sheets is "+sheet.getSheetName());
					// 获取至Sheet表中的行�?
					int copyTargeFileSheetRowNumber = copyTargeFileSheet.getPhysicalNumberOfRows();
					// int formulaOriginFileSheetRowNumber2 =
					// formulaOriginFileSheet.getPhysicalNumberOfRows();
					// 输出遍历到的sheet表中的数据行�?
					// System.out.println("file_name["+k+"]="+ tempList[k].getName()+",The name of
					// "+"the "
					// +(sheetI+1)+"th sheets is "+sheet.getSheetName()+",The rowNumber=
					// "+rowNumber+"�?");

					if (copyTargeFileSheet.getSheetName().contentEquals("E.1 单体设备经济寿命统计")) {
						continue;
					}
					/**
					 * 对sheet表中的行进行遍历
					 */
					for (int rowI = 0; rowI < copyTargeFileSheetRowNumber; rowI++) {
						HSSFRow copyTargeFileSheetRow = copyTargeFileSheet.getRow(rowI);
						// 获取到Sheet表中各行的列�?
						int colNumber = 0;
						// 如果当前行没有进行过编辑，则认为列无列数，会报异常，因此跳过此行。注意此处的编辑是包括给未写入数据的单元做的格式编辑�?
						try {
							colNumber = copyTargeFileSheetRow.getPhysicalNumberOfCells();
						} catch (Exception e) {
							if (rowI < copyTargeFileSheetRowNumber)
								colNumber = 0;
							continue;
						}
						// 输出遍历到的sheet表中的数据行�?
						// System.out.println("file_name[" + k + "]=" + tempList[k].getName() + ",The
						// name of " + "the "
						// + (sheetI + 1) + "th sheets is " + sheet.getSheetName() + ",rowNumber= "
						// + (rowNumber + 1) + ",the " + (rowI + 1) + "th row colNumbers=" + colNumber +
						// "�?");
						// 如果此行的列数为空，则跳过；否则尝试获取此行中各列的数据�?
						if (colNumber == 0) {
							continue;
						} else {
							for (int colI = 0; colI < colNumber; colI++) {
								String cellValue = "";
								String cellValue2 = "";
								// System.out.println("rowI="+(rowI+1));
								// System.out.println("row.getCell(colI).getCellType()="+row.getCell(colI).getCellType()+"
								// row.getCell(colI).CELL_TYPE_STRING="+ row.getCell(colI).CELL_TYPE_STRING);
								// 由于只要对单元格做了格式编辑，HSSFRow即认为是有效单元格�?�但是无数据的单元格是没有CellType的，因此会异常，此时要不做任何处理跳过�??
								try {
									copyTargeFileSheetRow.getCell(colI).getCellType();
								} catch (NullPointerException e) {
									continue;
								}

								// System.out.println(originalPath1 + "/" + tempList1[k].getName()+
								// sheet.getSheetName()+
								// "，row.getCell(colI).getCellType()=�?"+row.getCell(colI).getCellType()+ " �?
								// "+originalPath2 + "/" + tempList2[k].getName() + sheet2.getSheetName()+
								// "，row2.getCell(colI).getCellType()=�?"+row2.getCell(colI).getCellType()+
								// "不相等�?�在�?"+(rowI+1)+"�?,"+(colI+1)+"列）;");
								DataFormatter dft = new DataFormatter();
								FormulaEvaluator formulaEval = copyTargeFileWorkbook.getCreationHelper()
										.createFormulaEvaluator();

								// 对于EXCEL表格中的数据，此程序只识别读取String与Numeric（double）类型的数据，其它的默认为空，以空字符串替代�?
								/*
								 * if ((copyTargeFileSheetRow.getCell(colI) .getCellType() ==
								 * copyTargeFileSheetRow.getCell(colI).CELL_TYPE_FORMULA)) {
								 * System.out.println("CellFormula=" +
								 * copyTargeFileSheetRow.getCell(colI).getCellFormula() + "，NumericCellValue=" +
								 * copyTargeFileSheetRow.getCell(colI).getNumericCellValue() + ",eval=" +
								 * dft.formatCellValue(copyTargeFileSheetRow.getCell(colI), formulaEval)); ; }
								 */
								// 输出遍历到的sheet表中的每�?行的数据
								// System.out.println("file_name[" + k + "]=" + tempList1[k].getName() + ",The
								// name of "
								// + "the " + (sheetI + 1) + "th sheets is " + sheet.getSheetName()
								// + ",rowNumber= " + (rowNumber + 1) + ",the " + (rowI + 1) + "th row
								// colNumbers="
								// + colNumber + ",Value of the " + (colI + 1) + "th col is " + cellValue +
								// "�?");

							}
						}

					}
				}
				out = new FileOutputStream(copyTargeFile);
				copyTargeFileWorkbook.write(out);
			}

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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

	public static void copyFormula(String formulaOriginFile, String copyTargeFilePath) {

		DecimalFormat df = new DecimalFormat("#.0000");
		// 创建带有公式的Excel工作簿的引用
		HSSFWorkbook formulaOriginFileWorkbook;
		OutputStream out = null;
		try {
			formulaOriginFileWorkbook = new HSSFWorkbook(new FileInputStream(formulaOriginFile));
			ArrayList<String> fileNameList = new ArrayList<String>();
			boolean flag = false;
			// 创建�?要复制公式的目标EXCEL文件�?在路径文件对�?
			File copyTargePathFile = new File(copyTargeFilePath);
			// 得到路径下所有文件的列表
			File[] copyTargeFileList = copyTargePathFile.listFiles();
			for (int k = 0; k < copyTargeFileList.length; k++) {
				String copyTargeFile = copyTargeFilePath + "\\" + copyTargeFileList[k].getName();
				// System.out.println("copyTargeFileList["+k+"]="+
				// copyTargeFileList[k].getName());
				// System.out.println("copyTargeFileList"+copyTargeFilePath);
				// 创建�?要复制公式的目标EXCEL文件工作簿的引用
				HSSFWorkbook copyTargeFileWorkbook = new HSSFWorkbook(new FileInputStream(copyTargeFile));
				// 在Excel文档中，第一张工作表的缺省索引是0
				// 其语句为：HSSFSheet sheet = workbook.getSheetAt(0);
				// HSSFSheet sheet = workbook.getSheet("Sheet1");
				// 获取excel中Sheet的数�?
				int copyTargeFileSheetNumber = copyTargeFileWorkbook.getNumberOfSheets();
				HSSFSheet copyTargeFileSheet;
				HSSFSheet formulaOriginFileSheet;
				// System.out.println("sheet.getSheetName()="+sheet.getSheetName());
				// 获取打印Sheet的数�?
				// System.out.println("file_name["+k+"]="+ tempList[k].getName()+",The quantity
				// of sheets"+workbook.getNumberOfSheets());
				// 获取到Excel文件中的�?有行�?
				/* int rows = sheet.getPhysicalNumberOfRows(); */
				// 遍历输出�?有sheet表的名称
				for (int sheetI = 0; sheetI < copyTargeFileSheetNumber; sheetI++) {
					// 获取Sheet对象
					copyTargeFileSheet = copyTargeFileWorkbook.getSheetAt(sheetI);
					formulaOriginFileSheet = formulaOriginFileWorkbook.getSheetAt(sheetI);
					copyTargeFileSheet.setForceFormulaRecalculation(true);
					// 输出遍历到的sheet表的名称
					// System.out.println("file_name["+k+"]="+ tempList[k].getName()+",The name of
					// "+"the "+(sheetI+1)+"th sheets is "+sheet.getSheetName());
					// 获取至Sheet表中的行�?
					int copyTargeFileSheetRowNumber = copyTargeFileSheet.getPhysicalNumberOfRows();
					// int formulaOriginFileSheetRowNumber2 =
					// formulaOriginFileSheet.getPhysicalNumberOfRows();
					// 输出遍历到的sheet表中的数据行�?
					// System.out.println("file_name["+k+"]="+ tempList[k].getName()+",The name of
					// "+"the "
					// +(sheetI+1)+"th sheets is "+sheet.getSheetName()+",The rowNumber=
					// "+rowNumber+"�?");

					if (formulaOriginFileSheet.getSheetName().contentEquals("E.1 单体设备经济寿命统计")) {
						continue;
					}
					/**
					 * 对sheet表中的行进行遍历
					 */
					for (int rowI = 0; rowI < copyTargeFileSheetRowNumber; rowI++) {
						HSSFRow copyTargeFileSheetRow = copyTargeFileSheet.getRow(rowI);
						HSSFRow formulaOriginFileSheetRow = formulaOriginFileSheet.getRow(rowI);
						// 获取到Sheet表中各行的列�?
						int colNumber = 0;
						// 如果当前行没有进行过编辑，则认为列无列数，会报异常，因此跳过此行。注意此处的编辑是包括给未写入数据的单元做的格式编辑�?
						try {
							colNumber = copyTargeFileSheetRow.getPhysicalNumberOfCells();
						} catch (Exception e) {
							if (rowI < copyTargeFileSheetRowNumber)
								colNumber = 0;
							continue;
						}
						// 输出遍历到的sheet表中的数据行�?
						// System.out.println("file_name[" + k + "]=" + tempList[k].getName() + ",The
						// name of " + "the "
						// + (sheetI + 1) + "th sheets is " + sheet.getSheetName() + ",rowNumber= "
						// + (rowNumber + 1) + ",the " + (rowI + 1) + "th row colNumbers=" + colNumber +
						// "�?");
						// 如果此行的列数为空，则跳过；否则尝试获取此行中各列的数据�?
						if (colNumber == 0) {
							continue;
						} else {
							for (int colI = 0; colI < colNumber; colI++) {
								String cellValue = "";
								String cellValue2 = "";
								// System.out.println("rowI="+(rowI+1));
								// System.out.println("row.getCell(colI).getCellType()="+row.getCell(colI).getCellType()+"
								// row.getCell(colI).CELL_TYPE_STRING="+ row.getCell(colI).CELL_TYPE_STRING);
								// 由于只要对单元格做了格式编辑，HSSFRow即认为是有效单元格�?�但是无数据的单元格是没有CellType的，因此会异常，此时要不做任何处理跳过�??
								try {
									formulaOriginFileSheetRow.getCell(colI).getCellType();
								} catch (NullPointerException e) {
									continue;
								}

								// System.out.println(originalPath1 + "/" + tempList1[k].getName()+
								// sheet.getSheetName()+
								// "，row.getCell(colI).getCellType()=�?"+row.getCell(colI).getCellType()+ " �?
								// "+originalPath2 + "/" + tempList2[k].getName() + sheet2.getSheetName()+
								// "，row2.getCell(colI).getCellType()=�?"+row2.getCell(colI).getCellType()+
								// "不相等�?�在�?"+(rowI+1)+"�?,"+(colI+1)+"列）;");

								// 对于EXCEL表格中的数据，此程序只识别读取String与Numeric（double）类型的数据，其它的默认为空，以空字符串替代�?
								if ((formulaOriginFileSheetRow.getCell(colI)
										.getCellType() == formulaOriginFileSheetRow.getCell(colI).CELL_TYPE_FORMULA)) {

									Cell targetCell = copyTargeFileSheetRow.createCell(colI);
									targetCell.setCellFormula(formulaOriginFileSheetRow.getCell(colI).getCellFormula());
									// targetCell.setCellType(targetCell.CELL_TYPE_NUMERIC);
									// copyTargeFileSheetRow.getCell(colI).setCellStyle(formulaOriginFileSheetRow.getCell(colI).getCellStyle());
									// System.out.println("formulaOriginFileSheetRow.getCell(colI).getCellStyle()="+formulaOriginFileSheetRow.getCell(colI).getCellStyle().toString());
									// targetCell.getCellStyle().setFillForegroundColor(formulaOriginFileSheetRow.getCell(colI).getCellStyle().getFillForegroundColor());
									// targetCell.getCellStyle().setFillBackgroundColor(formulaOriginFileSheetRow.getCell(colI).getCellStyle().getFillBackgroundColor());
									// targetCell.getCellStyle().cloneStyleFrom(formulaOriginFileSheetRow.getCell(colI).getCellStyle());
								}
								// 输出遍历到的sheet表中的每�?行的数据
								// System.out.println("file_name[" + k + "]=" + tempList1[k].getName() + ",The
								// name of "
								// + "the " + (sheetI + 1) + "th sheets is " + sheet.getSheetName()
								// + ",rowNumber= " + (rowNumber + 1) + ",the " + (rowI + 1) + "th row
								// colNumbers="
								// + colNumber + ",Value of the " + (colI + 1) + "th col is " + cellValue +
								// "�?");

							}
						}

					}
				}
				// HSSFFormulaEvaluator.evaluateAllFormulaCells(copyTargeFileWorkbook);
				copyTargeFileWorkbook.setForceFormulaRecalculation(true);
				out = new FileOutputStream(copyTargeFile);
				copyTargeFileWorkbook.write(out);
			}

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
	 * 
	 * @param comparedFilePath 被比较文件的路径
	 * @param compareFilePath  用来比较文件的路�?
	 * @param errorFilePath    差异数据存放文件
	 *                         对指定的两个路径下，相同名称的EXCEL文件相同Sheet表中相同结构的数据进行比对，数据的对比精度为四位小数�?
	 */
	public static void batchFileCompare(String comparedFilePath, String compareFilePath, String errorFilePath) {

		// compareFilePath = "D:/temp/实物资产评价数据�?2019-1107-恢复公式/省公司资�?";
		// comparedFilePath = "D:/temp/实物资产评价数据�?2019-1107-上报数据/省公司资�?";
		// errorFilePath =
		// "D:/temp/实物资产评价数据�?2019-1107-上报数据/省公司资产errorValue-20191107.xls";
		// batchFileCompare(comparedFilePath, compareFilePath, errorFilePath);

		// String originalPath1 = "D:/temp/实物资产评价数据-1101-全部/省公司资�?";
		// String originalPath2 = "D:/temp/公式恢复/20191101 总部 网省数据校核 已校�?/省公�?";
		// String originalPath1 = "D:/temp/实物资产评价数据-1101-全部/总部资产";
		// String originalPath2 = "D:/temp/公式恢复/20191101 总部 网省数据校核 已校�?/总部";
		String originalPath1 = comparedFilePath;// "D:/temp/实物资产评价数据-1101-全部/分部资产";
		String originalPath2 = compareFilePath;// "D:/temp/公式恢复/20191101 总部 网省数据校核 已校�?/分部资产";
		// String originalPath = "F:/实物资产评价数据-1101-全部/湖北/";

		// DecimalFormat df = new DecimalFormat("#.0000");
		DecimalFormat df = new DecimalFormat("#,##0.0000");
		String dftStr = "";
		// String errorFilePath = "D:/temp/实物资产评价数据-1101-全部/errorValue.xls";
		OutputStream out = null;
		File errorFile = new File(errorFilePath);
		Workbook errorWorkBook;
		try {
			errorWorkBook = getWorkbok(errorFile);

			boolean flag = false;
			// 创建指定路径文件列对�?
			File file1 = new File(originalPath1);
			File file2 = new File(originalPath2);
			// 得到路径下所有文件的列表
			File[] tempList1 = file1.listFiles();
			File[] tempList2 = file2.listFiles();
			// sheet 对应�?个工作页
			Sheet errorSheet = errorWorkBook.getSheetAt(0);
			int errorI = 0;
			Double diff = 0.00;
			for (int k = 0; k < tempList1.length; k++) {
				String filePath1 = originalPath1 + "\\" + tempList1[k].getName();
				String filePath2 = originalPath2 + "\\" + tempList2[k].getName();
				// System.out.println("file_name["+k+"]="+ tempList[k].getName());
				// System.out.println("filePath"+filePath);
				// 创建对Excel工作簿文件的引用­
				HSSFWorkbook workbook;
				HSSFWorkbook workbook2;
				workbook = new HSSFWorkbook(new FileInputStream(filePath1));
				workbook2 = new HSSFWorkbook(new FileInputStream(filePath2));
				// 在Excel文档中，第一张工作表的缺省索引是0
				// 其语句为：HSSFSheet sheet = workbook.getSheetAt(0);
				// HSSFSheet sheet = workbook.getSheet("Sheet1");
				// 获取excel中Sheet的数�?
				int sheetNumber = workbook.getNumberOfSheets();
				HSSFSheet sheet;
				HSSFSheet sheet2;

				// System.out.println("sheet.getSheetName()="+sheet.getSheetName());
				// 获取打印Sheet的数�?
				// System.out.println("file_name["+k+"]="+ tempList[k].getName()+",The quantity
				// of sheets"+workbook.getNumberOfSheets());
				// 获取到Excel文件中的�?有行�?
				/* int rows = sheet.getPhysicalNumberOfRows(); */
				// 遍历输出�?有sheet表的名称
				for (int sheetI = 0; sheetI < sheetNumber; sheetI++) {
					// 获取Sheet对象
					sheet = workbook.getSheetAt(sheetI);
					sheet2 = workbook2.getSheetAt(sheetI);
					// 输出遍历到的sheet表的名称
					// System.out.println("file_name["+k+"]="+ tempList[k].getName()+",The name of
					// "+"the "+(sheetI+1)+"th sheets is "+sheet.getSheetName());
					// 获取至Sheet表中的行�?
					int rowNumber = sheet.getPhysicalNumberOfRows();
					int rowNumber2 = sheet2.getPhysicalNumberOfRows();
					// 输出遍历到的sheet表中的数据行�?
					// System.out.println("file_name["+k+"]="+ tempList1[k].getName()+",The name of
					// "+"the "
					// +(sheetI+1)+"th sheets is "+sheet.getSheetName()+",The
					// rowNumber="+rowNumber+"�?");

					/**
					 * 对sheet表中的行进行遍历
					 */
					for (int rowI = 0; rowI < rowNumber; rowI++) {
						//
						// System.out.println("errorI="+errorI);
						HSSFRow row = sheet.getRow(rowI);
						HSSFRow row2 = sheet2.getRow(rowI);
						// 获取到Sheet表中各行的列�?
						int colNumber = 0;
						// 如果当前行没有进行过编辑，则认为列无列数，会报异常，因此跳过此行。注意此处的编辑是包括给未写入数据的单元做的格式编辑�?
						try {
							colNumber = row.getPhysicalNumberOfCells();
						} catch (Exception e) {
							if (rowI < rowNumber)
								colNumber = 0;
							continue;
						}
						// 输出遍历到的sheet表中的数据行�?
						// System.out.println("file_name[" + k + "]=" + tempList[k].getName() + ",The
						// name of " + "the "
						// + (sheetI + 1) + "th sheets is " + sheet.getSheetName() + ",rowNumber= "
						// + (rowNumber + 1) + ",the " + (rowI + 1) + "th row colNumbers=" + colNumber +
						// "�?");
						// 如果此行的列数为空，则跳过；否则尝试获取此行中各列的数据�?
						if (colNumber == 0) {
							continue;
						} else {
							for (int colI = 0; colI < colNumber; colI++) {
								Double cellDoubleValue = 0.00;
								Double cellDoubleValue2 = 0.00;

								String cellValue = "";
								String cellValue2 = "";
								// System.out.println("rowI="+(rowI+1));
								// System.out.println("row.getCell(colI).getCellType()="+row.getCell(colI).getCellType()+"row.getCell(colI).CELL_TYPE_STRING="+
								// row.getCell(colI).CELL_TYPE_STRING);
								// 由于只要对单元格做了格式编辑，HSSFRow即认为是有效单元格�?�但是无数据的单元格是没有CellType的，因此会异常，此时要不做任何处理跳过�??
								String errorString = "";
								try {
									row.getCell(colI).getCellType();
									row2.getCell(colI).getCellType();
								} catch (NullPointerException e) {
									continue;
								}

								// System.out.println(originalPath1 + "/" + tempList1[k].getName()+
								// sheet.getSheetName()+
								// "，row.getCell(colI).getCellType()=�?"+row.getCell(colI).getCellType()+
								// " �? "+originalPath2 + "/" + tempList2[k].getName() + sheet2.getSheetName()+
								// "，row2.getCell(colI).getCellType()=�?"+row2.getCell(colI).getCellType()+
								// "不相等�?�在�?"+(rowI+1)+"�?,"+(colI+1)+"列）;");

								if (sheet.getSheetName().contentEquals("E.1 单体设备经济寿命统计")) {
									continue;
								}
								// 对于EXCEL表格中的数据，此程序只识别读取String与Numeric（double）类型的数据，其它的默认为空，以空字符串替代�?
								if (((row.getCell(colI).getCellType() == row.getCell(colI).CELL_TYPE_NUMERIC)
										&& (row2.getCell(colI).getCellType() == row2.getCell(colI).CELL_TYPE_STRING))
										|| ((row.getCell(colI).getCellType() == row.getCell(colI).CELL_TYPE_STRING)
												&& (row2.getCell(colI)
														.getCellType() == row2.getCell(colI).CELL_TYPE_FORMULA))
										|| ((row.getCell(colI).getCellType() == row.getCell(colI).CELL_TYPE_STRING)
												&& (row2.getCell(colI)
														.getCellType() == row2.getCell(colI).CELL_TYPE_NUMERIC))) {
									errorString = tempList1[k].getName() + "文件中表\"" + sheet.getSheetName() + "\"�?("
											+ (rowI + 1) + "�?," + (colI + 1) + "列）的上报�?�的数据类型" + " �? 恢复公式后的数据类型不一致）�?";

									Row errorRow = errorSheet.createRow(errorI + 1);
									Cell first = errorRow.createCell(0);
									Cell second = errorRow.createCell(1);
									Cell third = errorRow.createCell(2);
									Cell four = errorRow.createCell(3);
									Cell five = errorRow.createCell(4);
									Cell six = errorRow.createCell(5);
									Cell seven = errorRow.createCell(6);
									// first.setCellValue(errorString);
									first.setCellValue(tempList1[k].getName());
									second.setCellValue(sheet.getSheetName());
									third.setCellValue(tempList2[k].getName());
									four.setCellValue(sheet2.getSheetName());
									five.setCellValue(cellDoubleValue);
									six.setCellValue(cellDoubleValue2);
									seven.setCellValue(
											(rowI + 1) + "�?," + (colI + 1) + "列的上报值的数据类型" + " �? 恢复公式后的数据类型不一致）�?");
									errorI = errorI + 1;
									System.out.println(originalPath1 + "/" + tempList1[k].getName() + "文件中表\""
											+ sheet.getSheetName() + "\"�?(" + (rowI + 1) + "�?," + (colI + 1)
											+ "列）的上报�?�的数据类型" + " �? 恢复公式后的数据类型不一致）�?");
									cellValue = "";
									cellValue2 = "";
								} else if (row.getCell(colI).getCellType() == row.getCell(colI).CELL_TYPE_STRING) {
									try {
										cellValue = row.getCell(colI).getStringCellValue();
										cellValue2 = row2.getCell(colI).getStringCellValue();
									} catch (NullPointerException e) {
										continue;
									}
								} else if (row.getCell(colI).getCellType() == row.getCell(colI).CELL_TYPE_NUMERIC) {

									DataFormatter dft = new DataFormatter();
									FormulaEvaluator formulaEval = workbook2.getCreationHelper()
											.createFormulaEvaluator();
									HSSFFormulaEvaluator eval = new HSSFFormulaEvaluator(workbook2);
									try {
										cellValue = df.format(new Double(row.getCell(colI).getNumericCellValue()))
												.toString();
										try {
											cellDoubleValue = new DecimalFormat("#,##0.0000")
													.parse(df.format(
															new Double(row.getCell(colI).getNumericCellValue())))
													.doubleValue();
										} catch (ParseException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
										// cellValue2 = df.format(new Double(row2.getCell(colI).getNumericCellValue()))
										// .toString();
										// formulaEval.evaluateFormulaCell(row2.getCell(colI));
										// System.out.println(eval.evaluate(row2.getCell(colI)).getNumberValue());
										// cellValue2 =
										// df.format(eval.evaluate(row2.getCell(colI)).getNumberValue()).toString();
										// cellValue2 = df.format(new Double(row2.getCell(colI).getNumericCellValue()))
										// .toString();

										// cellValue2 =
										// df.format(formulaEval.evaluate(row2.getCell(colI)).getNumberValue())
										// .toString();

										// cellValue2 = df.format(Double.parseDouble((dft.formatCellValue
										// (row2.getCell(colI),formulaEval)))).toString();
										//
										if (row2.getCell(colI).getCellType() == row2.getCell(colI).CELL_TYPE_FORMULA) {
											try {
												// 下面的部分可能会因为EXCEL中公式的异常而报错，可以打开下面的输出语句确定是哪个文件的哪个地方的公式出现了错误，以进行修改�??
												// System.out.println(tempList1[k].getName() + "文件中表\"" +
												// sheet.getSheetName() + "\"�?("
												// + (rowI + 1) + "�?," + (colI + 1) + "列）,"+
												// "row2.getCell(colI).getCellType() ="+row2.getCell(colI).getCellType()
												// +
												// "，row2.getCell(colI)="+row2.getCell(colI));
												// cellValue2 = df.format(new DecimalFormat().parse(dft.formatCellValue
												// (row2.getCell(colI),formulaEval)).doubleValue()).toString();

												cellValue2 = df.format(new DecimalFormat("#,##0.0000")
														.parse(dft.formatCellValue(row2.getCell(colI), formulaEval))
														.doubleValue()).toString();
												;
												cellDoubleValue2 = new DecimalFormat("#,##0.0000")
														.parse(dft.formatCellValue(row2.getCell(colI), formulaEval))
														.doubleValue();
												dftStr = dft.formatCellValue(row2.getCell(colI), formulaEval);
												if (dftStr.contains("E")) {
													System.out.println(
															"dft.formatCellValue (row2.getCell(colI),formulaEval)="
																	+ Double.parseDouble(dft.formatCellValue(
																			row2.getCell(colI), formulaEval)));
													System.out.println(
															"dft.formatCellValue (row2.getCell(colI),formulaEval)="
																	+ new BigDecimal(
																			Double.parseDouble(dft.formatCellValue(
																					row2.getCell(colI), formulaEval))));
													cellDoubleValue2 = new BigDecimal(Double.parseDouble(
															dft.formatCellValue(row2.getCell(colI), formulaEval)))
																	.doubleValue();
													cellValue2 = (new BigDecimal(Double.parseDouble(
															dft.formatCellValue(row2.getCell(colI), formulaEval))))
																	.toString();
												}
												diff = Math.abs(cellDoubleValue - cellDoubleValue2);
												// if(diff>0.0002) {
												// System.out.println("小于0.0002");
												// }
											} catch (ParseException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
										} else {
											try {
												cellValue2 = df
														.format(new Double(row2.getCell(colI).getNumericCellValue()))
														.toString();
												cellDoubleValue2 = new DecimalFormat("#,##0.0000")
														.parse(df.format(
																new Double(row2.getCell(colI).getNumericCellValue())))
														.doubleValue();
												diff = Math.abs(cellDoubleValue - cellDoubleValue2);
											} catch (ParseException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}

										}
									} catch (NullPointerException e) {

										continue;
									} catch (java.lang.IllegalStateException e2) {
										errorString = tempList1[k].getName() + "文件中表\"" + sheet.getSheetName() + "\"�?("
												+ (rowI + 1) + "�?," + (colI + 1) + "列），恢复的公式现出异常。公式为�?"
												+ row2.getCell(colI).getCellFormula();

										Row errorRow = errorSheet.createRow(errorI + 1);
										Cell first = errorRow.createCell(0);
										Cell second = errorRow.createCell(1);
										Cell third = errorRow.createCell(2);
										Cell four = errorRow.createCell(3);
										Cell five = errorRow.createCell(4);
										Cell six = errorRow.createCell(5);
										Cell seven = errorRow.createCell(6);
										// first.setCellValue(errorString);
										first.setCellValue(tempList1[k].getName());
										second.setCellValue(sheet.getSheetName());
										third.setCellValue(tempList2[k].getName());
										four.setCellValue(sheet2.getSheetName());
										five.setCellValue(cellDoubleValue);
										six.setCellValue(cellDoubleValue2);
										seven.setCellValue((rowI + 1) + "�?," + (colI + 1) + "列，恢复的公式现出异常�?�公式为�?"
												+ row2.getCell(colI).getCellFormula());
										errorI = errorI + 1;
										System.out.println(originalPath1 + "/" + tempList1[k].getName() + "文件中表\""
												+ sheet.getSheetName() + "\"�?(" + (rowI + 1) + "�?," + (colI + 1)
												+ "列），恢复的公式现出异常。公式为�?" + row2.getCell(colI).getCellFormula());
										continue;
									}
								}
								// 输出遍历到的sheet表中的每�?行的数据
								// System.out.println("file_name[" + k + "]=" + tempList1[k].getName() + ",The
								// name of "
								// + "the " + (sheetI + 1) + "th sheets is " + sheet.getSheetName()
								// + ",rowNumber= " + (rowNumber + 1) + ",the " + (rowI + 1) + "th row
								// colNumbers="
								// + colNumber + ",Value of the " + (colI + 1) + "th col is " + cellValue +
								// "�?");
								if (!cellValue.contentEquals(cellValue2)) {
									if (dftStr.contains("E")) {
										if (diff > 1000000) {
											errorString = tempList1[k].getName() + "文件中表\"" + sheet.getSheetName()
													+ "\"�?(" + (rowI + 1) + "�?," + (colI + 1) + "列的上报�?" + cellValue
													+ " �? 恢复公式后的值（" + cellValue2 + "不一致）�?";
											Row errorRow = errorSheet.createRow(errorI + 1);
											Cell first = errorRow.createCell(0);
											Cell second = errorRow.createCell(1);
											Cell third = errorRow.createCell(2);
											Cell four = errorRow.createCell(3);
											Cell five = errorRow.createCell(4);
											Cell six = errorRow.createCell(5);
											Cell seven = errorRow.createCell(6);
											// first.setCellValue(errorString);
											first.setCellValue(tempList1[k].getName());
											second.setCellValue(sheet.getSheetName());
											third.setCellValue(tempList2[k].getName());
											four.setCellValue(sheet2.getSheetName());
											five.setCellValue(cellDoubleValue);
											six.setCellValue(cellDoubleValue2);
											seven.setCellValue((rowI + 1) + "�?," + (colI + 1) + "列的上报�?" + cellValue
													+ " �? 恢复公式后的�?" + cellValue2 + "不一致�??");
											errorI = errorI + 1;
											System.out.println(originalPath1 + "/" + tempList1[k].getName() + "文件中表\""
													+ sheet.getSheetName() + "\"�?(" + (rowI + 1) + "�?," + (colI + 1)
													+ "列）的上报�??" + cellValue + " �? 恢复公式后的值（" + cellValue2 + "不一致）�?");
										}
									} else if (Math.abs(cellDoubleValue2) > 1.0) {
										if (diff > 0.9) {
											errorString = tempList1[k].getName() + "文件中表\"" + sheet.getSheetName()
													+ "\"�?(" + (rowI + 1) + "�?," + (colI + 1) + "列的上报�?" + cellValue
													+ " �? 恢复公式后的值（" + cellValue2 + "不一致）�?";
											Row errorRow = errorSheet.createRow(errorI + 1);
											Cell first = errorRow.createCell(0);
											Cell second = errorRow.createCell(1);
											Cell third = errorRow.createCell(2);
											Cell four = errorRow.createCell(3);
											Cell five = errorRow.createCell(4);
											Cell six = errorRow.createCell(5);
											Cell seven = errorRow.createCell(6);
											// first.setCellValue(errorString);
											first.setCellValue(tempList1[k].getName());
											second.setCellValue(sheet.getSheetName());
											third.setCellValue(tempList2[k].getName());
											four.setCellValue(sheet2.getSheetName());
											five.setCellValue(cellDoubleValue);
											six.setCellValue(cellDoubleValue2);
											seven.setCellValue((rowI + 1) + "�?," + (colI + 1) + "列的上报�?" + cellValue
													+ " �? 恢复公式后的�?" + cellValue2 + "不一致�??");
											errorI = errorI + 1;
											System.out.println(originalPath1 + "/" + tempList1[k].getName() + "文件中表\""
													+ sheet.getSheetName() + "\"�?(" + (rowI + 1) + "�?," + (colI + 1)
													+ "列）的上报�??" + cellValue + " �? 恢复公式后的值（" + cellValue2 + "不一致）�?");
										}
									} else {
										if (diff > 0.0001) {
											errorString = tempList1[k].getName() + "文件中表\"" + sheet.getSheetName()
													+ "\"�?(" + (rowI + 1) + "�?," + (colI + 1) + "列的上报�?" + cellValue
													+ " �? 恢复公式后的值（" + cellValue2 + "不一致）�?";
											Row errorRow = errorSheet.createRow(errorI + 1);
											Cell first = errorRow.createCell(0);
											Cell second = errorRow.createCell(1);
											Cell third = errorRow.createCell(2);
											Cell four = errorRow.createCell(3);
											Cell five = errorRow.createCell(4);
											Cell six = errorRow.createCell(5);
											Cell seven = errorRow.createCell(6);
											// first.setCellValue(errorString);
											first.setCellValue(tempList1[k].getName());
											second.setCellValue(sheet.getSheetName());
											third.setCellValue(tempList2[k].getName());
											four.setCellValue(sheet2.getSheetName());
											five.setCellValue(cellDoubleValue);
											six.setCellValue(cellDoubleValue2);
											seven.setCellValue((rowI + 1) + "�?," + (colI + 1) + "列的上报�?" + cellValue
													+ " �? 恢复公式后的�?" + cellValue2 + "不一致�??");
											errorI = errorI + 1;
											System.out.println(originalPath1 + "/" + tempList1[k].getName() + "文件中表\""
													+ sheet.getSheetName() + "\"�?(" + (rowI + 1) + "�?," + (colI + 1)
													+ "列）的上报�??" + cellValue + " �? 恢复公式后的值（" + cellValue2 + "不一致）�?");
										}
									}
								}

							}
						}

					}
				}

			}

			out = new FileOutputStream(errorFilePath);
			errorWorkBook.write(out);

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
	 * 
	 * @param comparedFile 被比较文�?
	 * @param compareFile  用来比较文件
	 * @param errorFile    差异数据存放文件
	 *                     对指定的两个路径下，相同名称的EXCEL文件相同Sheet表中相同结构的数据进行比对，数据的对比精度为四位小数�?
	 */
	public static void fileCompare(String comparedFile, String compareFile, String errorFile) {

		String originalFileName = "writeExcel";
		// String originalPath1 = "D:/temp/实物资产评价数据-1101-全部/省公司资�?";
		// String originalPath2 = "D:/temp/公式恢复/20191101 总部 网省数据校核 已校�?/省公�?";
		// String originalPath1 = "D:/temp/实物资产评价数据-1101-全部/总部资产";
		// String originalPath2 = "D:/temp/公式恢复/20191101 总部 网省数据校核 已校�?/总部";
		String originalPath1 = "D:/temp/实物资产评价数据-1101-全部/分部资产";
		String originalPath2 = "D:/temp/公式恢复/20191101 总部 网省数据校核 已校�?/分部资产";

		DecimalFormat df = new DecimalFormat("#.0000");
		OutputStream out = null;
		File finalXlsxFile = new File(errorFile);
		Workbook errorWorkBook;
		try {
			errorWorkBook = getWorkbok(finalXlsxFile);

			ArrayList<String> fileNameList = new ArrayList<String>();
			boolean flag = false;
			// 创建指定路径文件列对�?
			File file1 = new File(originalPath1);
			File file2 = new File(originalPath2);
			// 得到路径下所有文件的列表
			File[] tempList1 = file1.listFiles();
			File[] tempList2 = file2.listFiles();
			// sheet 对应�?个工作页
			Sheet errorSheet = errorWorkBook.getSheetAt(0);
			int errorI = 0;
			for (int k = 0; k < tempList1.length; k++) {
				String filePath1 = originalPath1 + "\\" + tempList1[k].getName();
				String filePath2 = originalPath2 + "\\" + tempList2[k].getName();
				// System.out.println("file_name["+k+"]="+ tempList[k].getName());
				// System.out.println("filePath"+filePath);
				// 创建对Excel工作簿文件的引用­
				HSSFWorkbook workbook;
				HSSFWorkbook workbook2;
				workbook = new HSSFWorkbook(new FileInputStream(filePath1));
				workbook2 = new HSSFWorkbook(new FileInputStream(filePath2));
				// 在Excel文档中，第一张工作表的缺省索引是0
				// 其语句为：HSSFSheet sheet = workbook.getSheetAt(0);
				// HSSFSheet sheet = workbook.getSheet("Sheet1");
				// 获取excel中Sheet的数�?
				int sheetNumber = workbook.getNumberOfSheets();
				HSSFSheet sheet;
				HSSFSheet sheet2;

				// System.out.println("sheet.getSheetName()="+sheet.getSheetName());
				// 获取打印Sheet的数�?
				// System.out.println("file_name["+k+"]="+ tempList[k].getName()+",The quantity
				// of sheets"+workbook.getNumberOfSheets());
				// 获取到Excel文件中的�?有行�?
				/* int rows = sheet.getPhysicalNumberOfRows(); */
				// 遍历输出�?有sheet表的名称
				for (int sheetI = 0; sheetI < workbook.getNumberOfSheets(); sheetI++) {
					// 获取Sheet对象
					sheet = workbook.getSheetAt(sheetI);
					sheet2 = workbook2.getSheetAt(sheetI);
					// 输出遍历到的sheet表的名称
					// System.out.println("file_name["+k+"]="+ tempList[k].getName()+",The name of
					// "+"the "+(sheetI+1)+"th sheets is "+sheet.getSheetName());
					// 获取至Sheet表中的行�?
					int rowNumber = sheet.getPhysicalNumberOfRows();
					int rowNumber2 = sheet2.getPhysicalNumberOfRows();
					// 输出遍历到的sheet表中的数据行�?
					// System.out.println("file_name["+k+"]="+ tempList[k].getName()+",The name of
					// "+"the "
					// +(sheetI+1)+"th sheets is "+sheet.getSheetName()+",The rowNumber=
					// "+rowNumber+"�?");

					/**
					 * 对sheet表中的行进行遍历
					 */
					for (int rowI = 0; rowI < rowNumber; rowI++) {
						HSSFRow row = sheet.getRow(rowI);
						HSSFRow row2 = sheet2.getRow(rowI);
						// 获取到Sheet表中各行的列�?
						int colNumber = 0;
						// 如果当前行没有进行过编辑，则认为列无列数，会报异常，因此跳过此行。注意此处的编辑是包括给未写入数据的单元做的格式编辑�?
						try {
							colNumber = row.getPhysicalNumberOfCells();
						} catch (Exception e) {
							if (rowI < rowNumber)
								colNumber = 0;
							continue;
						}
						// 输出遍历到的sheet表中的数据行�?
						// System.out.println("file_name[" + k + "]=" + tempList[k].getName() + ",The
						// name of " + "the "
						// + (sheetI + 1) + "th sheets is " + sheet.getSheetName() + ",rowNumber= "
						// + (rowNumber + 1) + ",the " + (rowI + 1) + "th row colNumbers=" + colNumber +
						// "�?");
						// 如果此行的列数为空，则跳过；否则尝试获取此行中各列的数据�?
						if (colNumber == 0) {
							continue;
						} else {
							for (int colI = 0; colI < colNumber; colI++) {
								String cellValue = "";
								String cellValue2 = "";
								// System.out.println("rowI="+(rowI+1));
								// System.out.println("row.getCell(colI).getCellType()="+row.getCell(colI).getCellType()+"
								// row.getCell(colI).CELL_TYPE_STRING="+ row.getCell(colI).CELL_TYPE_STRING);
								// 由于只要对单元格做了格式编辑，HSSFRow即认为是有效单元格�?�但是无数据的单元格是没有CellType的，因此会异常，此时要不做任何处理跳过�??
								String errorString = "";
								try {
									row.getCell(colI).getCellType();
									row2.getCell(colI).getCellType();
								} catch (NullPointerException e) {
									continue;
								}

								// System.out.println(originalPath1 + "/" + tempList1[k].getName()+
								// sheet.getSheetName()+
								// "，row.getCell(colI).getCellType()=�?"+row.getCell(colI).getCellType()+ " �?
								// "+originalPath2 + "/" + tempList2[k].getName() + sheet2.getSheetName()+
								// "，row2.getCell(colI).getCellType()=�?"+row2.getCell(colI).getCellType()+
								// "不相等�?�在�?"+(rowI+1)+"�?,"+(colI+1)+"列）;");

								if (sheet.getSheetName().contentEquals("E.1 单体设备经济寿命统计")) {
									continue;
								}
								// 对于EXCEL表格中的数据，此程序只识别读取String与Numeric（double）类型的数据，其它的默认为空，以空字符串替代�?
								if (((row.getCell(colI).getCellType() == row.getCell(colI).CELL_TYPE_NUMERIC)
										&& (row2.getCell(colI).getCellType() == row2.getCell(colI).CELL_TYPE_STRING))
										|| ((row.getCell(colI).getCellType() == row.getCell(colI).CELL_TYPE_STRING)
												&& (row2.getCell(colI)
														.getCellType() == row2.getCell(colI).CELL_TYPE_FORMULA))
										|| ((row.getCell(colI).getCellType() == row.getCell(colI).CELL_TYPE_STRING)
												&& (row2.getCell(colI)
														.getCellType() == row2.getCell(colI).CELL_TYPE_NUMERIC))) {
									errorString = tempList1[k].getName() + "文件中表\"" + sheet.getSheetName() + "\"�?("
											+ (rowI + 1) + "�?," + (colI + 1) + "列）的上报�?�的数据类型" + " �? 恢复公式后的数据类型不一致）�?";

									Row errorRow = errorSheet.createRow(errorI + 1);
									Cell first = errorRow.createCell(0);
									Cell second = errorRow.createCell(1);
									Cell third = errorRow.createCell(2);
									Cell four = errorRow.createCell(3);
									Cell five = errorRow.createCell(4);
									// first.setCellValue(errorString);
									first.setCellValue(tempList1[k].getName());
									second.setCellValue(sheet.getSheetName());
									third.setCellValue(tempList2[k].getName());
									four.setCellValue(sheet2.getSheetName());
									five.setCellValue(
											(rowI + 1) + "�?," + (colI + 1) + "列的上报值的数据类型" + " �? 恢复公式后的数据类型不一致）�?");
									errorI = errorI + 1;
									// System.out.println(originalPath1 + "/" + tempList1[k].getName()+"文件中表\""+
									// sheet.getSheetName()+"\"�?("+(rowI+1)+"�?,"+(colI+1)+"列）的上报�?�的数据类型"+
									// " �? 恢复公式后的数据类型不一致）�?");
									cellValue = "";
									cellValue2 = "";
								} else if (row.getCell(colI).getCellType() == row.getCell(colI).CELL_TYPE_STRING) {
									try {
										cellValue = row.getCell(colI).getStringCellValue();
										cellValue2 = row2.getCell(colI).getStringCellValue();
									} catch (NullPointerException e) {
										continue;
									}
								} else if (row.getCell(colI).getCellType() == row.getCell(colI).CELL_TYPE_NUMERIC) {
									try {
										cellValue = df.format(new Double(row.getCell(colI).getNumericCellValue()))
												.toString();
										cellValue2 = df.format(new Double(row2.getCell(colI).getNumericCellValue()))
												.toString();
									} catch (NullPointerException e) {

										continue;
									} catch (java.lang.IllegalStateException e2) {
										errorString = tempList1[k].getName() + "文件中表\"" + sheet.getSheetName() + "\"�?("
												+ (rowI + 1) + "�?," + (colI + 1) + "列），恢复的公式现出异常。公式为�?"
												+ row2.getCell(colI).getCellFormula();

										Row errorRow = errorSheet.createRow(errorI + 1);
										Cell first = errorRow.createCell(0);
										Cell second = errorRow.createCell(1);
										Cell third = errorRow.createCell(2);
										Cell four = errorRow.createCell(3);
										Cell five = errorRow.createCell(4);
										// first.setCellValue(errorString);
										first.setCellValue(tempList1[k].getName());
										second.setCellValue(sheet.getSheetName());
										third.setCellValue(tempList2[k].getName());
										four.setCellValue(sheet2.getSheetName());
										five.setCellValue((rowI + 1) + "�?," + (colI + 1) + "列，恢复的公式现出异常�?�公式为�?"
												+ row2.getCell(colI).getCellFormula());
										errorI = errorI + 1;
										// System.out.println(originalPath1 + "/" + tempList1[k].getName()+"文件中表\""+
										// sheet.getSheetName()+"\"�?("+(rowI+1)+"�?,"+(colI+1)+"列），恢复的公式现出异常。公式为�?"+row2.getCell(colI).getCellFormula());
										continue;
									}
								}
								// 输出遍历到的sheet表中的每�?行的数据
								// System.out.println("file_name[" + k + "]=" + tempList1[k].getName() + ",The
								// name of "
								// + "the " + (sheetI + 1) + "th sheets is " + sheet.getSheetName()
								// + ",rowNumber= " + (rowNumber + 1) + ",the " + (rowI + 1) + "th row
								// colNumbers="
								// + colNumber + ",Value of the " + (colI + 1) + "th col is " + cellValue +
								// "�?");
								if (!cellValue.contentEquals(cellValue2)) {
									errorString = tempList1[k].getName() + "文件中表\"" + sheet.getSheetName() + "\"�?("
											+ (rowI + 1) + "�?," + (colI + 1) + "列的上报�?" + cellValue + " �? 恢复公式后的值（"
											+ cellValue2 + "不一致）�?";
									Row errorRow = errorSheet.createRow(errorI + 1);
									Cell first = errorRow.createCell(0);
									Cell second = errorRow.createCell(1);
									Cell third = errorRow.createCell(2);
									Cell four = errorRow.createCell(3);
									Cell five = errorRow.createCell(4);
									// first.setCellValue(errorString);
									first.setCellValue(tempList1[k].getName());
									second.setCellValue(sheet.getSheetName());
									third.setCellValue(tempList2[k].getName());
									four.setCellValue(sheet2.getSheetName());
									five.setCellValue((rowI + 1) + "�?," + (colI + 1) + "列的上报�?" + cellValue
											+ " �? 恢复公式后的�?" + cellValue2 + "不一致�??");
									errorI = errorI + 1;
									// System.out.println(originalPath1 + "/" + tempList1[k].getName()+"文件中表\""+
									// sheet.getSheetName()+"\"�?("+(rowI+1)+"�?,"+(colI+1)+"列）的上报�??"+
									// cellValue+ " �? 恢复公式后的值（"+cellValue2+ "不一致）�?");
								}

							}
						}

					}
				}

			}

			out = new FileOutputStream(errorFile);
			errorWorkBook.write(out);

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
	 * 对相同结构的表文件中的数据进行比对，数据的对比精度为四位小数�?
	 */
	public static void compareAllFile() {

		String originalFileName = "writeExcel";
		// String originalPath1 = "D:/temp/实物资产评价数据�?2019-1107-恢复公式/省公司资�?";
		// String originalPath2 = "D:/temp/实物资产评价数据�?2019-1107-上报数据/省公司资�?";
		// String originalPath1 = "D:/temp/实物资产评价数据-1101-全部/总部资产";
		// String originalPath2 = "D:/temp/公式恢复/20191101 总部 网省数据校核 已校�?/总部";
		// String originalPath1 = "D:/temp/实物资产评价数据-1101-全部/分部资产";
		// String originalPath2 = "D:/temp/公式恢复/20191101 总部 网省数据校核 已校�?/分部资产";
		// String originalPath = "F:/实物资产评价数据-1101-全部/湖北/";

		//
		String originalPath1 = "D:/temp/实物资产评价数据�?2019-1107-上报数据/分部资产";
		// String originalPath1 = "D:/temp/实物资产评价数据�?2019-1107-上报数据/省公司资�?";
		// String originalPath1 = "D:/temp/实物资产评价数据�?2019-1107 已恢复公�?/总部资产";
		//
		String originalPath2 = "D:/temp/实物资产评价数据�?2019-1107 已恢复公�?/分部资产";
		// String originalPath2 = "D:/temp/实物资产评价数据�?2019-1107 已恢复公�?/省公司资�?";
		// String originalPath2 = "D:/temp/实物资产评价数据�?2019-1107-上报数据/总部资产";

		// String errorFilePath = "D:/temp/实物资产评价数据�?2019-1107-上报数据/errorValue.xls";
		//
		String errorFilePath = "D:/temp/实物资产评价数据�?2019-1107 已恢复公�?/分部资产errorValue-20191107.xls";
		// String errorFilePath = "D:/temp/实物资产评价数据�?2019-1107
		// 已恢复公�?/省公司资产errorValue-20191107.xls";
		// String errorFilePath = "D:/temp/实物资产评价数据�?2019-1107
		// 已恢复公�?/总部资产errorValue-20191107.xls";

		DecimalFormat df = new DecimalFormat("#.0000");
		OutputStream out = null;
		File finalXlsxFile = new File(errorFilePath);
		Workbook errorWorkBook;
		try {
			errorWorkBook = getWorkbok(finalXlsxFile);

			ArrayList<String> fileNameList = new ArrayList<String>();
			boolean flag = false;
			// 创建指定路径文件列对�?
			File file1 = new File(originalPath1);
			File file2 = new File(originalPath2);
			// 得到路径下所有文件的列表
			File[] tempList1 = file1.listFiles();
			File[] tempList2 = file2.listFiles();
			// sheet 对应�?个工作页
			Sheet errorSheet = errorWorkBook.getSheetAt(0);
			int errorI = 0;
			for (int k = 0; k < tempList1.length; k++) {
				String filePath1 = originalPath1 + "\\" + tempList1[k].getName();
				String filePath2 = originalPath2 + "\\" + tempList2[k].getName();
				// System.out.println("file_name["+k+"]="+ tempList[k].getName());
				// System.out.println("filePath"+filePath);
				// 创建对Excel工作簿文件的引用­
				HSSFWorkbook workbook;
				HSSFWorkbook workbook2;
				workbook = new HSSFWorkbook(new FileInputStream(filePath1));
				workbook2 = new HSSFWorkbook(new FileInputStream(filePath2));
				// 在Excel文档中，第一张工作表的缺省索引是0
				// 其语句为：HSSFSheet sheet = workbook.getSheetAt(0);
				// HSSFSheet sheet = workbook.getSheet("Sheet1");
				// 获取excel中Sheet的数�?
				int sheetNumber = workbook.getNumberOfSheets();
				HSSFSheet sheet;
				HSSFSheet sheet2;

				// System.out.println("sheet.getSheetName()="+sheet.getSheetName());
				// 获取打印Sheet的数�?
				// System.out.println("file_name["+k+"]="+ tempList[k].getName()+",The quantity
				// of sheets"+workbook.getNumberOfSheets());
				// 获取到Excel文件中的�?有行�?
				/* int rows = sheet.getPhysicalNumberOfRows(); */
				// 遍历输出�?有sheet表的名称
				for (int sheetI = 0; sheetI < workbook.getNumberOfSheets(); sheetI++) {
					// 获取Sheet对象
					sheet = workbook.getSheetAt(sheetI);
					sheet2 = workbook2.getSheetAt(sheetI);
					// 输出遍历到的sheet表的名称
					// System.out.println("file_name["+k+"]="+ tempList[k].getName()+",The name of
					// "+"the "+(sheetI+1)+"th sheets is "+sheet.getSheetName());
					// 获取至Sheet表中的行�?
					int rowNumber = sheet.getPhysicalNumberOfRows();
					int rowNumber2 = sheet2.getPhysicalNumberOfRows();
					// 输出遍历到的sheet表中的数据行�?
					// System.out.println("file_name["+k+"]="+ tempList[k].getName()+",The name of
					// "+"the "
					// +(sheetI+1)+"th sheets is "+sheet.getSheetName()+",The rowNumber=
					// "+rowNumber+"�?");

					for (int rowI = 0; rowI < rowNumber; rowI++) {
						HSSFRow row = sheet.getRow(rowI);
						HSSFRow row2 = sheet2.getRow(rowI);
						// 获取到Sheet表中各行的列�?
						int colNumber = 0;
						// 如果当前行没有进行过编辑，则认为列无列数，会报异常，因此跳过此行。注意此处的编辑是包括给未写入数据的单元做的格式编辑�?
						try {
							colNumber = row.getPhysicalNumberOfCells();
						} catch (Exception e) {
							if (rowI < rowNumber)
								colNumber = 0;
							continue;
						}
						// 输出遍历到的sheet表中的数据行�?
						// System.out.println("file_name[" + k + "]=" + tempList[k].getName() + ",The
						// name of " + "the "
						// + (sheetI + 1) + "th sheets is " + sheet.getSheetName() + ",rowNumber= "
						// + (rowNumber + 1) + ",the " + (rowI + 1) + "th row colNumbers=" + colNumber +
						// "�?");
						// 如果此行的列数为空，则跳过；否则尝试获取此行中各列的数据�?
						if (colNumber == 0) {
							continue;
						} else {
							for (int colI = 0; colI < colNumber; colI++) {
								String cellValue = "";
								String cellValue2 = "";
								// System.out.println("rowI="+(rowI+1));
								// System.out.println("row.getCell(colI).getCellType()="+row.getCell(colI).getCellType()+"
								// row.getCell(colI).CELL_TYPE_STRING="+ row.getCell(colI).CELL_TYPE_STRING);
								// 由于只要对单元格做了格式编辑，HSSFRow即认为是有效单元格�?�但是无数据的单元格是没有CellType的，因此会异常，此时要不做任何处理跳过�??
								String errorString = "";
								try {
									row.getCell(colI).getCellType();
									row2.getCell(colI).getCellType();
								} catch (NullPointerException e) {
									continue;
								}

								// System.out.println(originalPath1 + "/" + tempList1[k].getName()+
								// sheet.getSheetName()+
								// "，row.getCell(colI).getCellType()=�?"+row.getCell(colI).getCellType()+ " �?
								// "+originalPath2 + "/" + tempList2[k].getName() + sheet2.getSheetName()+
								// "，row2.getCell(colI).getCellType()=�?"+row2.getCell(colI).getCellType()+
								// "不相等�?�在�?"+(rowI+1)+"�?,"+(colI+1)+"列）;");

								if (sheet.getSheetName().contentEquals("E.1 单体设备经济寿命统计")) {
									continue;
								}
								// 对于EXCEL表格中的数据，此程序只识别读取String与Numeric（double）类型的数据，其它的默认为空，以空字符串替代�?
								if (((row.getCell(colI).getCellType() == row.getCell(colI).CELL_TYPE_NUMERIC)
										&& (row2.getCell(colI).getCellType() == row2.getCell(colI).CELL_TYPE_STRING))
										|| ((row.getCell(colI).getCellType() == row.getCell(colI).CELL_TYPE_STRING)
												&& (row2.getCell(colI)
														.getCellType() == row2.getCell(colI).CELL_TYPE_FORMULA))
										|| ((row.getCell(colI).getCellType() == row.getCell(colI).CELL_TYPE_STRING)
												&& (row2.getCell(colI)
														.getCellType() == row2.getCell(colI).CELL_TYPE_NUMERIC))) {
									errorString = tempList1[k].getName() + "文件中表\"" + sheet.getSheetName() + "\"�?("
											+ (rowI + 1) + "�?," + (colI + 1) + "列）的上报�?�的数据类型" + " �? 恢复公式后的数据类型不一致）�?";

									Row errorRow = errorSheet.createRow(errorI + 1);
									Cell first = errorRow.createCell(0);
									Cell second = errorRow.createCell(1);
									Cell third = errorRow.createCell(2);
									Cell four = errorRow.createCell(3);
									Cell five = errorRow.createCell(6);
									// first.setCellValue(errorString);
									first.setCellValue(tempList1[k].getName());
									second.setCellValue(sheet.getSheetName());
									third.setCellValue(tempList2[k].getName());
									four.setCellValue(sheet2.getSheetName());
									five.setCellValue(
											(rowI + 1) + "�?," + (colI + 1) + "列的上报值的数据类型" + " �? 恢复公式后的数据类型不一致�??");
									errorI = errorI + 1;
									//
									System.out.println(originalPath1 + "/" + tempList1[k].getName() + "文件中表\"" +
									//
											sheet.getSheetName() + "\"�?(" + (rowI + 1) + "�?," + (colI + 1)
											+ "列）的上报�?�的数据类型" +
											//
											" �? 恢复公式后的数据类型不一致）�?");
									cellValue = "";
									cellValue2 = "";
								} else if (row.getCell(colI).getCellType() == row.getCell(colI).CELL_TYPE_STRING) {
									try {
										cellValue = row.getCell(colI).getStringCellValue();
										cellValue2 = row2.getCell(colI).getStringCellValue();
									} catch (NullPointerException e) {
										continue;
									}
								} else if (row.getCell(colI).getCellType() == row.getCell(colI).CELL_TYPE_NUMERIC) {
									try {
										cellValue = df.format(new Double(row.getCell(colI).getNumericCellValue()))
												.toString();
										cellValue2 = df.format(new Double(row2.getCell(colI).getNumericCellValue()))
												.toString();
									} catch (NullPointerException e) {

										continue;
									} catch (java.lang.IllegalStateException e2) {
										errorString = tempList1[k].getName() + "文件中表\"" + sheet.getSheetName() + "\"�?("
												+ (rowI + 1) + "�?," + (colI + 1) + "列），恢复的公式现出异常。公式为�?"
												+ row2.getCell(colI).getCellFormula();

										Row errorRow = errorSheet.createRow(errorI + 1);
										Cell first = errorRow.createCell(0);
										Cell second = errorRow.createCell(1);
										Cell third = errorRow.createCell(2);
										Cell four = errorRow.createCell(3);
										Cell five = errorRow.createCell(6);
										// first.setCellValue(errorString);
										first.setCellValue(tempList1[k].getName());
										second.setCellValue(sheet.getSheetName());
										third.setCellValue(tempList2[k].getName());
										four.setCellValue(sheet2.getSheetName());
										five.setCellValue((rowI + 1) + "�?," + (colI + 1) + "列，恢复的公式现出异常�?�公式为�?"
												+ row2.getCell(colI).getCellFormula());
										errorI = errorI + 1;
										// System.out.println(originalPath1 + "/" + tempList1[k].getName()+"文件中表\""+
										// sheet.getSheetName()+"\"�?("+(rowI+1)+"�?,"+(colI+1)+"列），恢复的公式现出异常。公式为�?"+row2.getCell(colI).getCellFormula());
										continue;
									}
								}
								// 输出遍历到的sheet表中的每�?行的数据
								// System.out.println("file_name[" + k + "]=" + tempList1[k].getName() + ",The
								// name of "
								// + "the " + (sheetI + 1) + "th sheets is " + sheet.getSheetName()
								// + ",rowNumber= " + (rowNumber + 1) + ",the " + (rowI + 1) + "th row
								// colNumbers="
								// + colNumber + ",Value of the " + (colI + 1) + "th col is " + cellValue +
								// "�?");
								if (!cellValue.contentEquals(cellValue2)) {
									errorString = tempList1[k].getName() + "文件中表\"" + sheet.getSheetName() + "\"�?("
											+ (rowI + 1) + "�?," + (colI + 1) + "列的上报�?" + cellValue + " �? 恢复公式后的值（"
											+ cellValue2 + "不一致）�?";
									Row errorRow = errorSheet.createRow(errorI + 1);
									Cell first = errorRow.createCell(0);
									Cell second = errorRow.createCell(1);
									Cell third = errorRow.createCell(2);
									Cell four = errorRow.createCell(3);
									Cell five = errorRow.createCell(4);
									Cell six = errorRow.createCell(5);
									Cell seven = errorRow.createCell(6);
									// first.setCellValue(errorString);
									first.setCellValue(tempList1[k].getName());
									second.setCellValue(sheet.getSheetName());
									third.setCellValue(tempList2[k].getName());
									four.setCellValue(sheet2.getSheetName());
									five.setCellValue(cellValue);
									six.setCellValue(cellValue2);
									seven.setCellValue((rowI + 1) + "�?," + (colI + 1) + "列的上报�?" + cellValue
											+ " �? 恢复公式后的�?" + cellValue2 + "不一致�??");
									errorI = errorI + 1;
									// System.out.println(originalPath1 + "/" + tempList1[k].getName()+"文件中表\""+
									// sheet.getSheetName()+"\"�?("+(rowI+1)+"�?,"+(colI+1)+"列）的上报�??"+
									// cellValue+ " �? 恢复公式后的值（"+cellValue2+ "不一致）�?");
								}

							}
						}

					}
				}

			}

			out = new FileOutputStream(errorFilePath);
			errorWorkBook.write(out);

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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

	public static void tableStructureTest() {

		List firstList = new ArrayList<String>();
		firstList.add("�?、输电线�?");
		firstList.add("1.架空输电线路");
		firstList.add("1000kV");
		firstList.add("750kV");
		firstList.add("500kV");
		firstList.add("330kV");
		firstList.add("220kV");
		firstList.add("110kV");
		firstList.add("66kV");
		firstList.add("35kV");
		firstList.add("10kV");
		firstList.add("±1100kV");
		firstList.add("±800kV");
		firstList.add("±660kV");
		firstList.add("±500kV");
		firstList.add("±400kV");
		firstList.add("±320kV及以�?");
		firstList.add("2、电缆输电线�?");
		firstList.add("500kV");
		firstList.add("330kV");
		firstList.add("220kV");
		firstList.add("110kV");
		firstList.add("66kV");
		firstList.add("35kV");
		firstList.add("10kV");
		firstList.add("二�?�变电设备（小计�?");
		firstList.add("1、变压器");
		firstList.add("主变压器");
		firstList.add("1000kV");
		firstList.add("750kV");
		firstList.add("500kV");
		firstList.add("330kV");
		firstList.add("220kV");
		firstList.add("110kV");
		firstList.add("66kV");
		firstList.add("35kV");
		firstList.add("�?用变压器/柜（含接地变压器�?");
		/*
		 * firstList.add(""); firstList.add(""); firstList.add(""); firstList.add("");
		 * firstList.add(""); firstList.add("");
		 */

		List columnStructure = new ArrayList<TableColumnStructureElement>();
		Map<Integer, String> colStructureEleMap2 = new HashMap<Integer, String>();
		colStructureEleMap2.put(0, "资产原�??");
		colStructureEleMap2.put(1, "资产�?�?");
		for (int firstListI = 0; firstListI < firstList.size(); firstListI++) {
			List colStructureEleList = new ArrayList<HashMap<Integer, String>>();
			Map<Integer, String> colStructureEleMap = new HashMap<Integer, String>();
			colStructureEleMap.put(0, (String) firstList.get(firstListI));
			colStructureEleList.add(colStructureEleMap);
			colStructureEleList.add(colStructureEleMap2);
			TableColumnStructureElement tableColumnStructureElement = new TableColumnStructureElement(firstListI);
			tableColumnStructureElement.setColumnMapList(colStructureEleList);
			columnStructure.add(tableColumnStructureElement);
		}

		for (int firstListI = 0; firstListI < firstList.size(); firstListI++) {
			TableColumnStructureElement tableColumnStructureElement = (TableColumnStructureElement) columnStructure
					.get(firstListI);
			int indexValue = tableColumnStructureElement.getIndexValue();
			int columnMapListSize = tableColumnStructureElement.getColumnMapList().size();
			for (int columnMapListI = 0; columnMapListI < columnMapListSize; columnMapListI++) {
				Map<Integer, String> colStructureEleMap = (HashMap<Integer, String>) tableColumnStructureElement
						.getColumnMapList().get(columnMapListI);
				for (int colStructureEleMapI = 0; colStructureEleMapI < colStructureEleMap
						.size(); colStructureEleMapI++) {
					System.out.println("indexValue=" + indexValue + ",tableColumnStructureElement["
							+ colStructureEleMapI + "]=" + colStructureEleMap.get(colStructureEleMapI));
				}
			}

		}

		List headStructure = new ArrayList<TableColumnStructureElement>();
		List headList = new ArrayList<String>();
		headList.add("2013");
		headList.add("2014");
		headList.add("2015");
		headList.add("2016");
		headList.add("2017");
		headList.add("2018");

		List tableHeadStructure = new ArrayList<TableColumnStructureElement>();
		Map<Integer, String> rowStructureEleMap2 = new HashMap<Integer, String>();
		rowStructureEleMap2.put(0, "在运状�??");
		rowStructureEleMap2.put(1, "备用状�??");
		rowStructureEleMap2.put(2, "报废状�??");
		for (int headListI = 0; headListI < headList.size(); headListI++) {
			List rowStructureEleList = new ArrayList<HashMap<Integer, String>>();
			Map<Integer, String> rowStructureEleMap = new HashMap<Integer, String>();
			rowStructureEleMap.put(0, (String) headList.get(headListI));
			rowStructureEleList.add(rowStructureEleMap);
			rowStructureEleList.add(rowStructureEleMap2);
			TableRowStructureElement tableRowStructureElement = new TableRowStructureElement(headListI);
			tableRowStructureElement.setRowMapList(rowStructureEleList);
			headStructure.add(tableRowStructureElement);
		}

		for (int headListI = 0; headListI < headList.size(); headListI++) {
			TableRowStructureElement tableRowStructureElement = (TableRowStructureElement) headStructure.get(headListI);
			int indexValue = tableRowStructureElement.getIndexValue();
			int rowMapListSize = tableRowStructureElement.getRowMapList().size();
			for (int rowMapListI = 0; rowMapListI < rowMapListSize; rowMapListI++) {
				Map<Integer, String> rowStructureEleMap = (HashMap<Integer, String>) tableRowStructureElement
						.getRowMapList().get(rowMapListI);
				for (int headStructureEleMapI = 0; headStructureEleMapI < rowStructureEleMap
						.size(); headStructureEleMapI++) {
					System.out.println("HeadIndexValue=" + indexValue + ",tableHeadStructureElement["
							+ headStructureEleMapI + "]=" + rowStructureEleMap.get(headStructureEleMapI));
				}
			}

		}

		List headStructure1 = new ArrayList<TableColumnStructureElement>();
		List headList1 = new ArrayList<String>();
		headList1.add("3年以�?");
		headList1.add("3年以�?");
		rowStructureEleMap2.put(0, "�?/�?/�?");
		rowStructureEleMap2.put(1, "公里/MVA");
		rowStructureEleMap2.remove(2);
		for (int headListI = 0; headListI < headList1.size(); headListI++) {
			List rowStructureEleList = new ArrayList<HashMap<Integer, String>>();
			Map<Integer, String> rowStructureEleMap = new HashMap<Integer, String>();
			rowStructureEleMap.put(0, (String) headList1.get(headListI));
			rowStructureEleList.add(rowStructureEleMap);
			rowStructureEleList.add(rowStructureEleMap2);
			TableRowStructureElement tableRowStructureElement = new TableRowStructureElement(headListI);
			tableRowStructureElement.setRowMapList(rowStructureEleList);
			headStructure1.add(tableRowStructureElement);
		}

		for (int headListI = 0; headListI < headList1.size(); headListI++) {
			TableRowStructureElement tableRowStructureElement = (TableRowStructureElement) headStructure1
					.get(headListI);
			int indexValue = tableRowStructureElement.getIndexValue();
			int rowMapListSize = tableRowStructureElement.getRowMapList().size();
			for (int rowMapListI = 0; rowMapListI < rowMapListSize; rowMapListI++) {
				Map<Integer, String> rowStructureEleMap = (HashMap<Integer, String>) tableRowStructureElement
						.getRowMapList().get(rowMapListI);
				for (int headStructureEleMapI = 0; headStructureEleMapI < rowStructureEleMap
						.size(); headStructureEleMapI++) {
					System.out.println("HeadIndexValue=" + indexValue + ",tableHeadStructureElement["
							+ headStructureEleMapI + "]=" + rowStructureEleMap.get(headStructureEleMapI));
				}
			}

		}

		List headStructure2 = new ArrayList<TableColumnStructureElement>();
		List headList3 = new ArrayList<String>();
		Map<Integer, String> rowStructureEleMap4 = new HashMap<Integer, String>();
		Map<Integer, String> rowStructureEleMap5 = new HashMap<Integer, String>();
		Map<Integer, String> rowStructureEleMap6 = new HashMap<Integer, String>();
		Map<Integer, String> rowStructureEleMap7 = new HashMap<Integer, String>();
		Map<Integer, String> rowStructureEleMap8 = new HashMap<Integer, String>();
		Map<Integer, String> rowStructureEleMap9 = new HashMap<Integer, String>();
		Map<Integer, String> rowStructureEleMap10 = new HashMap<Integer, String>();
		rowStructureEleMap4.put(0, "再利用设备数量规�?-省内");
		rowStructureEleMap5.put(0, "再利用设备数量规�?-省间");
		rowStructureEleMap6.put(0, "当年省内再利用设备数�?");
		rowStructureEleMap7.put(0, "截止当年省内可再利用设备数量");
		rowStructureEleMap8.put(0, "当年省间再利用设备数�?");
		rowStructureEleMap9.put(0, "截止当年省间可再利用设备数量");
		rowStructureEleMap10.put(0, "�?/�?/�?");
		rowStructureEleMap10.put(1, "公里/MVA");

		TableRowStructureElement tableRowStructureElement1 = new TableRowStructureElement(0);
		TableRowStructureElement tableRowStructureElement2 = new TableRowStructureElement(1);
		TableRowStructureElement tableRowStructureElement3 = new TableRowStructureElement(2);
		TableRowStructureElement tableRowStructureElement4 = new TableRowStructureElement(3);
		TableRowStructureElement tableRowStructureElement5 = new TableRowStructureElement(4);
		List rowStructureEleList1 = new ArrayList<HashMap<Integer, String>>();
		List rowStructureEleList2 = new ArrayList<HashMap<Integer, String>>();
		List rowStructureEleList3 = new ArrayList<HashMap<Integer, String>>();
		List rowStructureEleList4 = new ArrayList<HashMap<Integer, String>>();
		List rowStructureEleList5 = new ArrayList<HashMap<Integer, String>>();

		rowStructureEleList1.add(rowStructureEleMap4);
		rowStructureEleList1.add(rowStructureEleMap6);
		rowStructureEleList1.add(rowStructureEleMap10);

		rowStructureEleList2.add(rowStructureEleMap4);
		rowStructureEleList2.add(rowStructureEleMap7);
		rowStructureEleList2.add(rowStructureEleMap10);

		rowStructureEleList3.add(rowStructureEleMap5);
		rowStructureEleList3.add(rowStructureEleMap8);
		rowStructureEleList3.add(rowStructureEleMap10);

		rowStructureEleList4.add(rowStructureEleMap5);
		rowStructureEleList4.add(rowStructureEleMap9);
		rowStructureEleList4.add(rowStructureEleMap10);

		rowStructureEleList5.add(rowStructureEleMap5);
		rowStructureEleList5.add(rowStructureEleMap10);

		tableRowStructureElement1.setRowMapList(rowStructureEleList1);
		tableRowStructureElement2.setRowMapList(rowStructureEleList2);
		tableRowStructureElement3.setRowMapList(rowStructureEleList3);
		tableRowStructureElement4.setRowMapList(rowStructureEleList4);
		tableRowStructureElement5.setRowMapList(rowStructureEleList5);

		headStructure2.add(tableRowStructureElement1);
		headStructure2.add(tableRowStructureElement2);
		headStructure2.add(tableRowStructureElement3);
		headStructure2.add(tableRowStructureElement4);
		headStructure2.add(tableRowStructureElement5);
		/**
		 * 对表行结构中元素的进行遍历，表中先结构其实是�?个链表�??
		 */
		for (int tableRowStructureElementI = 0; tableRowStructureElementI < headStructure2
				.size(); tableRowStructureElementI++) {
			TableRowStructureElement tableRowStructureElement = (TableRowStructureElement) headStructure2
					.get(tableRowStructureElementI);
			int indexValue = tableRowStructureElement.getIndexValue();
			int rowMapListSize = tableRowStructureElement.getRowMapList().size();
			for (int rowMapListI = 0; rowMapListI < rowMapListSize; rowMapListI++) {
				Map<Integer, String> rowStructureEleMap = (HashMap<Integer, String>) tableRowStructureElement
						.getRowMapList().get(rowMapListI);
				for (int headStructureEleMapI = 0; headStructureEleMapI < rowStructureEleMap
						.size(); headStructureEleMapI++) {
					System.out.println("HeadIndexValue=" + indexValue + ",tableHeadStructureElement["
							+ headStructureEleMapI + "]=" + rowStructureEleMap.get(headStructureEleMapI));
				}
			}

		}

	}

	public static void readAllFile() {
		String originalFileName = "writeExcel";
		String originalPath = "F:/实物资产评价数据-1101-全部/省公司资�?/";

		ArrayList<String> fileNameList = new ArrayList<String>();
		boolean flag = false;
		File file = new File(originalPath);
		File[] tempList = file.listFiles();
		for (int k = 0; k < tempList.length; k++) {
			String filePath = originalPath + "\\" + tempList[k].getName();
			// System.out.println("file_name["+k+"]="+ tempList[k].getName());
			// System.out.println("filePath"+filePath);
			HSSFWorkbook workbook;
			try {
				workbook = new HSSFWorkbook(new FileInputStream(filePath));
				String dateStr = tempList[k].getName().substring(13, 23);
				String areaNameValue = tempList[k].getName().substring(11, 13);
				// Obtain sheet object
				// HSSFSheet sheet = workbook.getSheetAt(0);
				// HSSFSheet sheet = workbook.getSheet("Sheet1");
				// Obtain the number of sheet
				int sheetNumber = workbook.getNumberOfSheets();
				// HSSFSheet sheet = workbook.getSheetAt(0);
				HSSFSheet sheet;// = workbook.getSheetAt(0);
				// System.out.println("sheet.getSheetName()="+sheet.getSheetName());
				// 获取打印Sheet的数�?
				// System.out.println("file_name["+k+"]="+ tempList[k].getName()+",The quantity
				// of sheets"+workbook.getNumberOfSheets());
				// 获取到Excel文件中的�?有行�?
				/* int rows = sheet.getPhysicalNumberOfRows(); */
				// 遍历输出�?有sheet表的名称
				for (int sheetI = 0; sheetI < workbook.getNumberOfSheets(); sheetI++) {
					// 获取Sheet对象
					sheet = workbook.getSheetAt(sheetI);
					// 输出遍历到的sheet表的名称
					// System.out.println("file_name["+k+"]="+ tempList[k].getName()+",The name of
					// "+"the "+(sheetI+1)+"th sheets is "+sheet.getSheetName());
					// 获取至Sheet表中的行�?
					int rowNumber = sheet.getPhysicalNumberOfRows();
					// 输出遍历到的sheet表中的数据行�?
					// System.out.println("file_name["+k+"]="+ tempList[k].getName()+",The name of
					// "+"the "
					// +(sheetI+1)+"th sheets is "+sheet.getSheetName()+",The rowNumber=
					// "+rowNumber+"�?");

					for (int rowI = 0; rowI < rowNumber; rowI++) {
						HSSFRow row = sheet.getRow(rowI);
						// Obtain the number row of the sheet
						int colNumber = 0;
						try {
							colNumber = row.getPhysicalNumberOfCells();
						} catch (Exception e) {
							if (rowI < rowNumber)
								colNumber = 0;
							continue;
						}
						
						if (colNumber == 0) {
							continue;
						} else {
							for (int colI = 0; colI < colNumber; colI++) {
								String cellValue = "";
								// System.out.println("rowI="+(rowI+1));
								// System.out.println("row.getCell(colI).getCellType()="+row.getCell(colI).getCellType()+"
								// row.getCell(colI).CELL_TYPE_STRING="+ row.getCell(colI).CELL_TYPE_STRING);
								// 由于只要对单元格做了格式编辑，HSSFRow即认为是有效单元格�?�但是无数据的单元格是没有CellType的，因此会异常，此时要不做任何处理跳过�??
								try {
									row.getCell(colI).getCellType();
								} catch (NullPointerException e) {
									continue;
								}
								// 对于EXCEL表格中的数据，此程序只识别读取String与Numeric（double）类型的数据，其它的默认为空，以空字符串替代�?
								if (row.getCell(colI).getCellType() == row.getCell(colI).CELL_TYPE_STRING) {
									try {
										cellValue = row.getCell(colI).getStringCellValue();
									} catch (NullPointerException e) {
										continue;
									}
								} else if (row.getCell(colI).getCellType() == row.getCell(colI).CELL_TYPE_NUMERIC) {
									try {
										cellValue = new Double(row.getCell(colI).getNumericCellValue()).toString();
									} catch (NullPointerException e) {
										continue;
									}
								}
								// 输出遍历到的sheet表中的每�?行的数据
								System.out.println("file_name[" + k + "]=" + tempList[k].getName() + ",The name of "
										+ "the " + (sheetI + 1) + "th sheets is " + sheet.getSheetName()
										+ ",rowNumber= " + (rowNumber + 1) + ",the " + (rowI + 1) + "th row colNumbers="
										+ colNumber + ",Value of the " + (colI + 1) + "th col is " + cellValue + "�?");
							}
						}

					}
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void readExcel(List<Map> dataList, int cloumnCount, String finalXlsxPath) {
		OutputStream out = null;
		try {
			// 获取总列�?
			int columnNumCount = cloumnCount;
			// 读取Excel文档
			System.out.println("System.getProperty(\"user.dir\"):" + System.getProperty("user.dir"));
			System.out.println("finalXlsxPath:=" + finalXlsxPath);
			File finalXlsxFile = new File(finalXlsxPath);
			System.out.println("finalXlsxFile.getName():" + finalXlsxFile.getName());
			Workbook workBook = getWorkbok(finalXlsxFile);
			// sheet 对应�?个工作页
			Sheet sheet = workBook.getSheetAt(0);
			// workBook.getNumberOfSheets();
			/**
			 * 删除原有数据，除了属性列
			 */
			// int rowNumber = sheet.getLastRowNum(); // 第一行从0�?始算
			// System.out.println("原始数据总行数，除属性列�?" + rowNumber);
			// for (int i = 1; i <= rowNumber; i++) {
			// Row row = sheet.getRow(i);
			// sheet.removeRow(row);
			// }
			// 创建文件输出流，输出电子表格：这个必须有，否则你在sheet上做的任何操作都不会有效
			// out = new FileOutputStream(finalXlsxPath);
			// workBook.write(out);
			/**
			 * �?Excel中写新数�?
			 */
			System.out.println("dataList.size():" + dataList.size());
			for (int j = 0; j < dataList.size() + 2; j++) {
				// 创建�?行：从第二行�?始，跳过属�?�列
				Row row = sheet.createRow(j + 1);
				// 得到要插入的每一条记�?
				Map dataMap = dataList.get(0);
				String name = dataMap.get("BankName").toString() + j;
				String address = dataMap.get("Addr").toString() + j;
				String phone = dataMap.get("Phone").toString() + j;
				System.out.println("columnNumCount:" + columnNumCount);
				for (int k = 0; k <= columnNumCount; k++) {
					// 在一行内循环
					Cell first = row.createCell(0);
					first.setCellValue(name);

					Cell second = row.createCell(1);
					second.setCellValue(address);

					Cell third = row.createCell(2);
					third.setCellValue(phone);
				}
				out = new FileOutputStream(finalXlsxPath);
				workBook.write(out);
			}
			// 创建文件输出流，准备输出电子表格：这个必须有，否则你在sheet上做的任何操作都不会有效

		} catch (Exception e) {
			e.printStackTrace();
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

	public static void writeExcel(List<Map> dataList, int cloumnCount, String finalXlsxPath) {
		OutputStream out = null;
		try {
			// 获取总列�?
			int columnNumCount = cloumnCount;
			// 读取Excel文档
			System.out.println("System.getProperty(\"user.dir\"):" + System.getProperty("user.dir"));
			System.out.println("finalXlsxPath:=" + finalXlsxPath);
			File finalXlsxFile = new File(finalXlsxPath);
			System.out.println("finalXlsxFile.getName():" + finalXlsxFile.getName());
			Workbook workBook = getWorkbok(finalXlsxFile);
			// sheet 对应�?个工作页
			Sheet sheet = workBook.getSheetAt(0);
			// workBook.getNumberOfSheets();
			/**
			 * 删除原有数据，除了属性列
			 */
			// int rowNumber = sheet.getLastRowNum(); // 第一行从0�?始算
			// System.out.println("原始数据总行数，除属性列�?" + rowNumber);
			// for (int i = 1; i <= rowNumber; i++) {
			// Row row = sheet.getRow(i);
			// sheet.removeRow(row);
			// }
			// 创建文件输出流，输出电子表格：这个必须有，否则你在sheet上做的任何操作都不会有效
			// out = new FileOutputStream(finalXlsxPath);
			// workBook.write(out);
			/**
			 * �?Excel中写新数�?
			 */
			System.out.println("dataList.size():" + dataList.size());
			for (int j = 0; j < dataList.size() + 2; j++) {
				// 创建�?行：从第二行�?始，跳过属�?�列
				Row row = sheet.createRow(j + 1);
				// 得到要插入的每一条记�?
				Map dataMap = dataList.get(0);
				String name = dataMap.get("BankName").toString() + j;
				String address = dataMap.get("Addr").toString() + j;
				String phone = dataMap.get("Phone").toString() + j;
				System.out.println("columnNumCount:" + columnNumCount);
				for (int k = 0; k <= columnNumCount; k++) {
					// 在一行内循环
					Cell first = row.createCell(0);
					first.setCellValue(name);

					Cell second = row.createCell(1);
					second.setCellValue(address);

					Cell third = row.createCell(2);
					third.setCellValue(phone);
				}
				out = new FileOutputStream(finalXlsxPath);
				workBook.write(out);
			}
			// 创建文件输出流，准备输出电子表格：这个必须有，否则你在sheet上做的任何操作都不会有效

		} catch (Exception e) {
			e.printStackTrace();
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
	 * 判断Excel的版�?,获取Workbook
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

	public static void copyFile(String originalFileName, String originalPath, String targetFileName, String targetPath)
			throws IOException {
		// 被复制文�?
		File originalFile = new File(originalPath + originalFileName + "." + EXCEL_XLS);
		System.out.println(originalPath + originalFileName + "." + EXCEL_XLS);
		// 创建指定文件�?
		File targetFolder = new File(targetPath);
		// 判断文件夹是否存在，不存在需要创建，否则无法正常创建文件夹下的文�?
		if (!targetFolder.exists()) {
			System.out.println("targetFolder not exists " + targetPath);
			targetFolder.mkdirs();
		}
		// 复制后文件的路径与命�?
		String targetFilePath = targetPath + "/" + targetFileName + "." + EXCEL_XLS;
		System.out.println("targetFilePath:" + targetFilePath);
		File targetFile = new File(targetFilePath);
		if (!targetFile.exists()) {
			System.out.println("targetFile not exists " + targetPath + "/");
			targetFile.createNewFile();
		}
		System.out.println(targetFilePath);
		// 复制内容到指定文件中
		copyFileContent(originalFile, targetFile);

	}

	/**
	 * 将文�? originalFile 的内容复制到 targetFile 文件�? 复制的可以是 Excel 等多种格�?
	 * 
	 * @param originalFile
	 * @param targetFile
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static void copyFileContent(File originalFile, File targetFile) throws IOException, FileNotFoundException {
		FileInputStream ins = new FileInputStream(originalFile);
		FileOutputStream out = new FileOutputStream(targetFile);
		byte[] b = new byte[1024];
		int n = 0;
		while ((n = ins.read(b)) != -1) {
			out.write(b, 0, n);
		}
		ins.close();
		out.close();
	}

}
