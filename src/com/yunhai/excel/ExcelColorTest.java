package com.yunhai.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelColorTest {
	public static void main(String[] args) throws IOException {
		changeCellFillColorXLSX("filePath", "fileName");
	}

	public static void colorTest(String filePath, String fileName) throws IOException {
		// Create Workbook and Worksheet
		/* Write changes to the workbook */
		FileOutputStream out = new FileOutputStream(new File("C:\\cell_fill_color.xls"));
		HSSFWorkbook my_workbook = new HSSFWorkbook();
		HSSFSheet my_sheet = my_workbook.createSheet("Cell Font");
		// Get access to HSSFCellStyle
		HSSFCellStyle my_style = my_workbook.createCellStyle();
		// We will now specify a background cell color
		//my_style.setFillPattern(HSSFCellStyle.FINE_DOTS);//旧版本方式
		my_style.setFillPattern(FillPatternType.FINE_DOTS);
		my_style.setFillForegroundColor(new HSSFColor.BLUE().getIndex());
		my_style.setFillBackgroundColor(new HSSFColor.RED().getIndex());

		// Create a row in the sheet
		Row row = my_sheet.createRow(0);
		// Create a cell
		Cell cell = row.createCell(0);
		cell.setCellValue("This text will be in bold red color");
		// Attach the style to the cell
		cell.setCellStyle(my_style);
		my_workbook.write(out);
        my_workbook.close();
		out.close();

	}
	
	public static void  changeCellFillColorXLSX(String filePath, String fileName) throws IOException {
		// Create Workbook and Worksheet XLSX Format */
        XSSFWorkbook my_workbook = new XSSFWorkbook();
        XSSFSheet my_sheet = my_workbook.createSheet("Cell Font");
        // Get access to XSSFCellStyle */
        XSSFCellStyle my_style = my_workbook.createCellStyle();
         
        // We will now specify a background cell color */
         //my_style.setFillPattern(XSSFCellStyle.FINE_DOTS );//旧版本方式
         my_style.setFillPattern(FillPatternType.FINE_DOTS );
         my_style.setFillForegroundColor(IndexedColors.BLUE.getIndex());
         my_style.setFillBackgroundColor(IndexedColors.RED.getIndex());

        // Create a row in the sheet */
        Row row = my_sheet.createRow(0);
        // Create a cell */
        Cell cell = row.createCell(0);
        cell.getCellStyle();
        cell.setCellValue("Cell Fill Color Test");
        // Attach the style to the cell */
        cell.setCellStyle(my_style);
        // Write changes to the workbook */
        FileOutputStream out = new FileOutputStream(new File("C:\\cell_fill_color.xlsx"));
        my_workbook.write(out);
        my_workbook.close();
        out.close();
	}
}
