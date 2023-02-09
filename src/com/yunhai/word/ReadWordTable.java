package com.yunhai.word;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.hwpf.usermodel.Table;
import org.apache.poi.hwpf.usermodel.TableCell;
import org.apache.poi.hwpf.usermodel.TableIterator;
import org.apache.poi.hwpf.usermodel.TableRow;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import jxl.write.WritableWorkbook;

public class ReadWordTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filePath="E:\\实物资产分析评价评审\\青海2021年电网实物资产分析评价报告 - V3.4-20210622.docx";
		//filePath="E:\\实物资产分析评价评审\\4-2021-电网实物资产分析评价报告-国网河北省电力有限公司-V4.5-0531.docx";
		//filePath="E:\\实物资产分析评价评审\\5-国网华中分部2021年电网实物资产评价报告-20210531v1.doc";
		writeWordTableToExcel(filePath);
	}
	/**
	 * 读取文档中表格
	 * @param filePath
	 */
	public static void testWord(String filePath){
		try{
			FileInputStream in = new FileInputStream(filePath);//载入文档
			// 处理docx格式 即office2007以后版本
			if(filePath.toLowerCase().endsWith("docx")){
				//word 2007 图片不会被读取， 表格中的数据会被放在字符串的最后   
				XWPFDocument xwpf = new XWPFDocument(in);//得到word文档的信息
				Iterator<XWPFTable> it = xwpf.getTablesIterator();//得到word中的表格
				// 设置需要读取的表格  set是设置需要读取的第几个表格，total是文件中表格的总数
				int set = 2, total = 4;
				int num = set;
				// 过滤前面不需要的表格
				/*
				 * for (int i = 0; i < set-1; i++) { it.hasNext(); it.next(); }
				 */
				num=1;
				while(it.hasNext()){
					XWPFTable table = it.next();  
					String tableText=table.getText()+",end";
					System.out.println("这是第" + num + "个表的数据,:");
					List<XWPFTableRow> rows = table.getRows(); 
					//读取每一行数据
					for (int i = 0; i < rows.size(); i++) {
						XWPFTableRow  row = rows.get(i);
						//读取每一列数据
						List<XWPFTableCell> cells = row.getTableCells(); 
						for (int j = 0; j < cells.size(); j++) {
							XWPFTableCell cell = cells.get(j);
							//输出当前的单元格的数据
							System.out.print(cell.getText() + "\t");
						}
						System.out.println();
					}
					num++;
					// 过滤多余的表格
					/*
					 * while (num < total) { it.hasNext(); it.next(); num += 1; }
					 */
				}
			}else{
				// 处理doc格式 即office2003版本
				POIFSFileSystem pfs = new POIFSFileSystem(in);   
				HWPFDocument hwpf = new HWPFDocument(pfs);   
				Range range = hwpf.getRange();//得到文档的读取范围
				TableIterator it = new TableIterator(range);
				// 迭代文档中的表格
				// 如果有多个表格只读取需要的一个 set是设置需要读取的第几个表格，total是文件中表格的总数
				int set = 1, total = 4;
				int num = set;
				for (int i = 0; i < set-1; i++) {
					it.hasNext();
					it.next();
				}
				while (it.hasNext()) {   
					Table tb = (Table) it.next();   
					System.out.println("这是第" + num + "个表的数据");
					//迭代行，默认从0开始,可以依据需要设置i的值,改变起始行数，也可设置读取到那行，只需修改循环的判断条件即可
					for (int i = 0; i < tb.numRows(); i++) {   
						TableRow tr = tb.getRow(i);   
						//迭代列，默认从0开始
						for (int j = 0; j < tr.numCells(); j++) {   
							TableCell td = tr.getCell(j);//取得单元格
							//取得单元格的内容
							for(int k = 0; k < td.numParagraphs(); k++){   
								Paragraph para = td.getParagraph(k); 
								String s = para.text();
								//去除后面的特殊符号
								if(null != s && !"".equals(s)){
									s = s.substring(0, s.length()-1);
								}
								System.out.print(s + "\t");
							}
						}
						System.out.println();
					} 
					// 过滤多余的表格
					while (num < total) {
						it.hasNext();
						it.next();
						num += 1;
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * 读取文档中表格
	 * @param filePath
	 */
	public static void writeWordTableToExcel(String filePath){

		Date now = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-ddHHmmss");
		String nowdate = df.format(now);
		// 打开文件
		WritableWorkbook book = null;
		System.out.println("filePath="+filePath+";"+filePath.substring(filePath.lastIndexOf("\\")+1,filePath.lastIndexOf("."))+";"+filePath.lastIndexOf("\\"));
		XSSFWorkbook wb = new XSSFWorkbook();
		CellStyle style=wb.createCellStyle();
		style.setBorderBottom(BorderStyle.THIN);
		style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderLeft(BorderStyle.THIN);
		style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderRight(BorderStyle.THIN);
		style.setRightBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderTop(BorderStyle.THIN);
		style.setTopBorderColor(IndexedColors.BLACK.getIndex());
		String excelFilePath = "D:/temp/" + filePath.substring(filePath.lastIndexOf("\\")+1,filePath.lastIndexOf("."))+ "_" + nowdate + "_" + 0 + ".xlsx";
		System.out.println("excelFilePath="+excelFilePath);
		XSSFSheet sheetExcel=null;

		try{
			FileInputStream in = new FileInputStream(filePath);//载入文档
			// 处理docx格式 即office2007以后版本
			if(filePath.toLowerCase().endsWith("docx")){
				//word 2007 图片不会被读取， 表格中的数据会被放在字符串的最后   
				XWPFDocument xwpf = new XWPFDocument(in);//得到word文档的信息
				Iterator<XWPFTable> it = xwpf.getTablesIterator();//得到word中的表格 
				int num=1; 
				
				while(it.hasNext()){
					XWPFTable table = it.next();   
					System.out.println("这是第" + num + "个表的数据,:"); 
					// 建立新的sheet对象（excel的表单）
					sheetExcel = wb.createSheet("table-"+num);
					List<XWPFTableRow> rows = table.getRows(); 
					//读取每一行数据
					for (int i = 0; i < rows.size(); i++) {
						XWPFTableRow  row = rows.get(i); 
						// 在sheet里创建第一行
						XSSFRow rowExcel = sheetExcel.createRow(i);
						// 设置行高
						//rowExcel.setHeight((short) ((short) 36 * 20));

						//读取每一列数据
						List<XWPFTableCell> cells = row.getTableCells(); 
						for (int j = 0; j < cells.size(); j++) {

							// 创建单元格
							XSSFCell cellExcel = rowExcel.createCell(j);
							XWPFTableCell cell = cells.get(j);
							cellExcel.setCellValue(cell.getText());
							cellExcel.setCellStyle(style);
							//输出当前的单元格的数据
							System.out.print(cell.getText() + "\t");
						}
						System.out.println();
					}
					num++;
					// 过滤多余的表格
					/*
					 * while (num < total) { it.hasNext(); it.next(); num += 1; }
					 */
				}
			}else{
				// 处理doc格式 即office2003版本
				POIFSFileSystem pfs = new POIFSFileSystem(in);   
				HWPFDocument hwpf = new HWPFDocument(pfs);   
				Range range = hwpf.getRange();//得到文档的读取范围
				TableIterator it = new TableIterator(range);
				// 迭代文档中的表格
				// 如果有多个表格只读取需要的一个 set是设置需要读取的第几个表格，total是文件中表格的总数
				int num=1; 
				while (it.hasNext()) {  
					Table tb = (Table) it.next();   
					System.out.println("这是第" + num + "个表的数据");
					// 建立新的sheet对象（excel的表单）
					sheetExcel = wb.createSheet("table-"+num);
					//迭代行，默认从0开始,可以依据需要设置i的值,改变起始行数，也可设置读取到那行，只需修改循环的判断条件即可
					for (int i = 0; i < tb.numRows(); i++) {
						TableRow tr = tb.getRow(i);   
						// 在sheet里创建第一行
						XSSFRow rowExcel = sheetExcel.createRow(i);
						// 设置行高
						//rowExcel.setHeight((short) ((short) 36 * 20));
						//迭代列，默认从0开始
						for (int j = 0; j < tr.numCells(); j++) {   
							TableCell td = tr.getCell(j);//取得单元格 
							//取得单元格的内容
							for(int k = 0; k < td.numParagraphs(); k++){   
								Paragraph para = td.getParagraph(k); 
								String s = para.text();
								//去除后面的特殊符号
								if(null != s && !"".equals(s)){
									s = s.substring(0, s.length()-1);
								}
								System.out.print(s + "\t");
								// 创建单元格
								XSSFCell cellExcel = rowExcel.createCell(j); 
								cellExcel.setCellValue(s);
								cellExcel.setCellStyle(style);
							}
						}
						System.out.println();
					}  
					num++;
				}
			}
			// 输出Excel文件
			FileOutputStream output;
			try {
				output = new FileOutputStream(excelFilePath);
				wb.write(output);
				output.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	 
	
}
