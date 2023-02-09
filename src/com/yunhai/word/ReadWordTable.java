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
		String filePath="E:\\ʵ���ʲ�������������\\�ຣ2021�����ʵ���ʲ��������۱��� - V3.4-20210622.docx";
		//filePath="E:\\ʵ���ʲ�������������\\4-2021-����ʵ���ʲ��������۱���-�����ӱ�ʡ�������޹�˾-V4.5-0531.docx";
		//filePath="E:\\ʵ���ʲ�������������\\5-�������зֲ�2021�����ʵ���ʲ����۱���-20210531v1.doc";
		writeWordTableToExcel(filePath);
	}
	/**
	 * ��ȡ�ĵ��б��
	 * @param filePath
	 */
	public static void testWord(String filePath){
		try{
			FileInputStream in = new FileInputStream(filePath);//�����ĵ�
			// ����docx��ʽ ��office2007�Ժ�汾
			if(filePath.toLowerCase().endsWith("docx")){
				//word 2007 ͼƬ���ᱻ��ȡ�� ����е����ݻᱻ�����ַ��������   
				XWPFDocument xwpf = new XWPFDocument(in);//�õ�word�ĵ�����Ϣ
				Iterator<XWPFTable> it = xwpf.getTablesIterator();//�õ�word�еı��
				// ������Ҫ��ȡ�ı��  set��������Ҫ��ȡ�ĵڼ������total���ļ��б�������
				int set = 2, total = 4;
				int num = set;
				// ����ǰ�治��Ҫ�ı��
				/*
				 * for (int i = 0; i < set-1; i++) { it.hasNext(); it.next(); }
				 */
				num=1;
				while(it.hasNext()){
					XWPFTable table = it.next();  
					String tableText=table.getText()+",end";
					System.out.println("���ǵ�" + num + "���������,:");
					List<XWPFTableRow> rows = table.getRows(); 
					//��ȡÿһ������
					for (int i = 0; i < rows.size(); i++) {
						XWPFTableRow  row = rows.get(i);
						//��ȡÿһ������
						List<XWPFTableCell> cells = row.getTableCells(); 
						for (int j = 0; j < cells.size(); j++) {
							XWPFTableCell cell = cells.get(j);
							//�����ǰ�ĵ�Ԫ�������
							System.out.print(cell.getText() + "\t");
						}
						System.out.println();
					}
					num++;
					// ���˶���ı��
					/*
					 * while (num < total) { it.hasNext(); it.next(); num += 1; }
					 */
				}
			}else{
				// ����doc��ʽ ��office2003�汾
				POIFSFileSystem pfs = new POIFSFileSystem(in);   
				HWPFDocument hwpf = new HWPFDocument(pfs);   
				Range range = hwpf.getRange();//�õ��ĵ��Ķ�ȡ��Χ
				TableIterator it = new TableIterator(range);
				// �����ĵ��еı��
				// ����ж�����ֻ��ȡ��Ҫ��һ�� set��������Ҫ��ȡ�ĵڼ������total���ļ��б�������
				int set = 1, total = 4;
				int num = set;
				for (int i = 0; i < set-1; i++) {
					it.hasNext();
					it.next();
				}
				while (it.hasNext()) {   
					Table tb = (Table) it.next();   
					System.out.println("���ǵ�" + num + "���������");
					//�����У�Ĭ�ϴ�0��ʼ,����������Ҫ����i��ֵ,�ı���ʼ������Ҳ�����ö�ȡ�����У�ֻ���޸�ѭ�����ж���������
					for (int i = 0; i < tb.numRows(); i++) {   
						TableRow tr = tb.getRow(i);   
						//�����У�Ĭ�ϴ�0��ʼ
						for (int j = 0; j < tr.numCells(); j++) {   
							TableCell td = tr.getCell(j);//ȡ�õ�Ԫ��
							//ȡ�õ�Ԫ�������
							for(int k = 0; k < td.numParagraphs(); k++){   
								Paragraph para = td.getParagraph(k); 
								String s = para.text();
								//ȥ��������������
								if(null != s && !"".equals(s)){
									s = s.substring(0, s.length()-1);
								}
								System.out.print(s + "\t");
							}
						}
						System.out.println();
					} 
					// ���˶���ı��
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
	 * ��ȡ�ĵ��б��
	 * @param filePath
	 */
	public static void writeWordTableToExcel(String filePath){

		Date now = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-ddHHmmss");
		String nowdate = df.format(now);
		// ���ļ�
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
			FileInputStream in = new FileInputStream(filePath);//�����ĵ�
			// ����docx��ʽ ��office2007�Ժ�汾
			if(filePath.toLowerCase().endsWith("docx")){
				//word 2007 ͼƬ���ᱻ��ȡ�� ����е����ݻᱻ�����ַ��������   
				XWPFDocument xwpf = new XWPFDocument(in);//�õ�word�ĵ�����Ϣ
				Iterator<XWPFTable> it = xwpf.getTablesIterator();//�õ�word�еı�� 
				int num=1; 
				
				while(it.hasNext()){
					XWPFTable table = it.next();   
					System.out.println("���ǵ�" + num + "���������,:"); 
					// �����µ�sheet����excel�ı���
					sheetExcel = wb.createSheet("table-"+num);
					List<XWPFTableRow> rows = table.getRows(); 
					//��ȡÿһ������
					for (int i = 0; i < rows.size(); i++) {
						XWPFTableRow  row = rows.get(i); 
						// ��sheet�ﴴ����һ��
						XSSFRow rowExcel = sheetExcel.createRow(i);
						// �����и�
						//rowExcel.setHeight((short) ((short) 36 * 20));

						//��ȡÿһ������
						List<XWPFTableCell> cells = row.getTableCells(); 
						for (int j = 0; j < cells.size(); j++) {

							// ������Ԫ��
							XSSFCell cellExcel = rowExcel.createCell(j);
							XWPFTableCell cell = cells.get(j);
							cellExcel.setCellValue(cell.getText());
							cellExcel.setCellStyle(style);
							//�����ǰ�ĵ�Ԫ�������
							System.out.print(cell.getText() + "\t");
						}
						System.out.println();
					}
					num++;
					// ���˶���ı��
					/*
					 * while (num < total) { it.hasNext(); it.next(); num += 1; }
					 */
				}
			}else{
				// ����doc��ʽ ��office2003�汾
				POIFSFileSystem pfs = new POIFSFileSystem(in);   
				HWPFDocument hwpf = new HWPFDocument(pfs);   
				Range range = hwpf.getRange();//�õ��ĵ��Ķ�ȡ��Χ
				TableIterator it = new TableIterator(range);
				// �����ĵ��еı��
				// ����ж�����ֻ��ȡ��Ҫ��һ�� set��������Ҫ��ȡ�ĵڼ������total���ļ��б�������
				int num=1; 
				while (it.hasNext()) {  
					Table tb = (Table) it.next();   
					System.out.println("���ǵ�" + num + "���������");
					// �����µ�sheet����excel�ı���
					sheetExcel = wb.createSheet("table-"+num);
					//�����У�Ĭ�ϴ�0��ʼ,����������Ҫ����i��ֵ,�ı���ʼ������Ҳ�����ö�ȡ�����У�ֻ���޸�ѭ�����ж���������
					for (int i = 0; i < tb.numRows(); i++) {
						TableRow tr = tb.getRow(i);   
						// ��sheet�ﴴ����һ��
						XSSFRow rowExcel = sheetExcel.createRow(i);
						// �����и�
						//rowExcel.setHeight((short) ((short) 36 * 20));
						//�����У�Ĭ�ϴ�0��ʼ
						for (int j = 0; j < tr.numCells(); j++) {   
							TableCell td = tr.getCell(j);//ȡ�õ�Ԫ�� 
							//ȡ�õ�Ԫ�������
							for(int k = 0; k < td.numParagraphs(); k++){   
								Paragraph para = td.getParagraph(k); 
								String s = para.text();
								//ȥ��������������
								if(null != s && !"".equals(s)){
									s = s.substring(0, s.length()-1);
								}
								System.out.print(s + "\t");
								// ������Ԫ��
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
			// ���Excel�ļ�
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
