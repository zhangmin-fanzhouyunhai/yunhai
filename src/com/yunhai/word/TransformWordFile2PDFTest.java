package com.yunhai.word;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

import fr.opensagres.poi.xwpf.converter.pdf.PdfConverter;
import fr.opensagres.poi.xwpf.converter.pdf.PdfOptions;

public class TransformWordFile2PDFTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1.获取docx文档，并生成XWPFDocument对象
	    InputStream is = new FileInputStream("/users/xxx/website/pdf.docx");
	    XWPFDocument docx = new XWPFDocument(is);
	    // 2.FileOutputStream
	    FileOutputStream fileOutputStream = new FileOutputStream("/users/xxx/website/pdf.pdf");
	    // 3. word => pdf
	    PdfOptions pdfOptions = PdfOptions.create();
	    PdfConverter.getInstance().convert(docx, fileOutputStream, pdfOptions);

	    is.close();
	    fileOutputStream.close();
	}

	public static void test1() {
		FileInputStream fileInputStream = null;
	    FileOutputStream fileOutputStream = null;
	    
	    try {
	    	
	        fileInputStream = new FileInputStream("D:\\download\\xxx.docx");
	        XWPFDocument xwpfDocument = new XWPFDocument(fileInputStream);
	        PdfOptions pdfOptions = PdfOptions.create();
	        fileOutputStream = new FileOutputStream("D:\\download\\xxx.pdf");
	        //PdfConverter.getInstance().convert(xwpfDocument,fileOutputStream,pdfOptions);
	        
	        PdfConverter.getInstance();
	        PdfConverter pdfConverter=new PdfConverter();
	        pdfConverter.getInstance();
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (null != fileInputStream) {
	                fileInputStream.close();
	            }
	            if (null != fileOutputStream) {
	                fileOutputStream.close();
	            } 
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}
	
	

}
