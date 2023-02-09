package com.yunhai.pdf;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;

import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PdfboxUtil {
	   /**
	    * @param args
	    */

	   public static void main(String[] args) {
		   //readOnePDF();

		   String suffix=".pdf"; 
		   //String pdfPath="D:/Encyclopedia/ѧϰ/PDF���ݴ���";
		   String pdfPath="D:/workspace/pdf";
		   //String fileName="�����ӱ�ʡ������˾�����豸����ԭ��"; 
		  // readOnePDF(pdfPath, fileName, suffix );
 
		   // fileName="�����ӱ�ʡ������˾������������ԭ��";

		   String fileName="Measuring the efficiency of decision making units-CCR1978";

		   readOnePDF(pdfPath, fileName, suffix );
		   
		   
		   //test();
		   
	   }
	   
	   public static void readOnePDF(String pdfPath,String fileName,String suffix ) {
		   
		      //String pdfPath = "D:/temp/�ɽ���-PDF��ʽ.pdf";
		     // String pdfPath = "D:/Encyclopedia/PDF���ݴ���/������.pdf";
		      //String txtfilePath = "D:/temp/�ɽ���-PDF��ʽ-pdfbox.txt";
		   	String pdfFile=pdfPath+"/"+fileName+suffix;
		      String txtfilePath = pdfPath+"/"+fileName+".txt";

		      PdfboxUtil pdfutil = new PdfboxUtil();

		      try { 
		         String content = pdfutil.getTextFromPdf(pdfFile); 
		         pdfutil.toTextFile(content, txtfilePath); 
		         System.out.println("Finished !");     
		      } catch (Exception e) { 
		         e.printStackTrace(); 
		      } 
	   }
	   public static void readOnePDF() {
 
		      //String pdfPath = "D:/temp/�ɽ���-PDF��ʽ.pdf";
		      //String pdfPath = "D:/Encyclopedia/PDF���ݴ���/������.pdf";
		      String pdfPath = "D:/Encyclopedia/ѧϰ/PDF���ݴ���/�����ӱ�ʡ������˾�����豸����ԭ��.pdf";
		      //String txtfilePath = "D:/temp/�ɽ���-PDF��ʽ-pdfbox.txt";
		      //String txtfilePath = "D:/Encyclopedia/PDF���ݴ���/������-pdfbox.txt";
		      String txtfilePath = "D:/Encyclopedia/ѧϰ/PDF���ݴ���/�����ӱ�ʡ������˾�����豸����ԭ��.txt";

		      PdfboxUtil pdfutil = new PdfboxUtil();

		      try {

		         String content = pdfutil.getTextFromPdf(pdfPath);

		         pdfutil.toTextFile(content, txtfilePath);

		         System.out.println("Finished !");      

		      } catch (Exception e) {

		         e.printStackTrace();

		      } 
	   }
	   public static void readOnePDF(String pdfPath ) {
		   
		      //String pdfPath = "D:/temp/�ɽ���-PDF��ʽ.pdf";
		     // String pdfPath = "D:/Encyclopedia/PDF���ݴ���/������.pdf";
		      //String txtfilePath = "D:/temp/�ɽ���-PDF��ʽ-pdfbox.txt";
		      String txtfilePath = pdfPath.substring(0,pdfPath.length()-4)+"pdfbox.txt";

		      PdfboxUtil pdfutil = new PdfboxUtil();

		      try { 
		         String content = pdfutil.getTextFromPdf(pdfPath); 
		         pdfutil.toTextFile(content, txtfilePath); 
		         System.out.println("Finished !");     
		      } catch (Exception e) { 
		         e.printStackTrace(); 
		      } 
	   }
	   public static void test() {

		   String path = "D:/Encyclopedia/PDF���ݴ���/Դ�ļ�";

			File file = new File(path);
			File[] tempList = file.listFiles();
			for (int k = 0; k < tempList.length; k++) {
				// if(k==1) break;
				String filePath = path + "\\" + tempList[k].getName();// "D://excel.xls";
				System.out.println("filePath="+filePath+",tempList[k].getName().length="+tempList[k].getName().length());
				// System.out.println("DATE="+tempList[k].getName().substring(10,20));
				//System.out.println("tempList[k].getName()=" + tempList[k].getName());
				String dateStr = tempList[k].getName().substring(0,tempList[k].getName().length()-4); 
				//
				System.out.println("dateStr=" + dateStr );
				// filePath ="D://excel.xls";
				readOnePDF(filePath ) ;
			}
	   }
	  

	   /**

	    * ��ȡPDF�ļ�����������

	    * @param pdfPath

	    * @throws Exception

	    */

	   public String getTextFromPdf(String pdfPath) throws Exception {

	      // �Ƿ�����

	      boolean sort = false;

	      // ��ʼ��ȡҳ��

	      int startPage = 1;

	      // ������ȡҳ��

	      int endPage = Integer.MAX_VALUE;    

	     

	      String content = null;

	      InputStream input = null;

	      File pdfFile = new File(pdfPath);

	      PDDocument document = null;

	      try {

	         input = new FileInputStream(pdfFile);
	         
	         //RandomAccessRead randomAccessRead=new RandomAccessRead();
	         // ���� pdf �ĵ�

	         PDFParser parser = new PDFParser(null);

	         parser.parse();

	         document = parser.getPDDocument();

	         // ��ȡ������Ϣ

	         PDFTextStripper pts = new PDFTextStripper();

	         pts.setSortByPosition(sort);

	         endPage = document.getNumberOfPages();

	         System.out.println("Total Page: " + endPage);

	         pts.setStartPage(startPage);

	         pts.setEndPage(endPage);

	         try {

	            content = pts.getText(document);

	         } catch (Exception e) {

	            throw e;

	         }

	         System.out.println("Get PDF Content ...");

	      } catch (Exception e) {

	         throw e;

	      } finally {

	         if (null != input)

	            input.close();

	         if (null != document)

	            document.close();

	      }

	     

	      return content;

	   }

	 

	   /**

	    * ��PDF�ļ�����д�뵽txt�ļ���

	    * @param pdfContent

	    * @param filePath

	    */

	   public void toTextFile(String pdfContent,String filePath) {     

	      try {

	         File f = new File(filePath);

	         if (!f.exists()) {

	            f.createNewFile();

	         }

	         System.out.println("Write PDF Content to txt file ...");

	         BufferedWriter output = new BufferedWriter(new FileWriter(f));

	         output.write(pdfContent);

	         output.close();

	      } catch (Exception e) {

	         e.printStackTrace();

	      }

	   } 
}
