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
		   //String pdfPath="D:/Encyclopedia/学习/PDF数据处理";
		   String pdfPath="D:/workspace/pdf";
		   //String fileName="国网河北省电力公司生产设备大修原则"; 
		  // readOnePDF(pdfPath, fileName, suffix );
 
		   // fileName="国网河北省电力公司生产技术改造原则";

		   String fileName="Measuring the efficiency of decision making units-CCR1978";

		   readOnePDF(pdfPath, fileName, suffix );
		   
		   
		   //test();
		   
	   }
	   
	   public static void readOnePDF(String pdfPath,String fileName,String suffix ) {
		   
		      //String pdfPath = "D:/temp/成交单-PDF格式.pdf";
		     // String pdfPath = "D:/Encyclopedia/PDF数据处理/田有理.pdf";
		      //String txtfilePath = "D:/temp/成交单-PDF格式-pdfbox.txt";
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
 
		      //String pdfPath = "D:/temp/成交单-PDF格式.pdf";
		      //String pdfPath = "D:/Encyclopedia/PDF数据处理/田有理.pdf";
		      String pdfPath = "D:/Encyclopedia/学习/PDF数据处理/国网河北省电力公司生产设备大修原则.pdf";
		      //String txtfilePath = "D:/temp/成交单-PDF格式-pdfbox.txt";
		      //String txtfilePath = "D:/Encyclopedia/PDF数据处理/田有理-pdfbox.txt";
		      String txtfilePath = "D:/Encyclopedia/学习/PDF数据处理/国网河北省电力公司生产设备大修原则.txt";

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
		   
		      //String pdfPath = "D:/temp/成交单-PDF格式.pdf";
		     // String pdfPath = "D:/Encyclopedia/PDF数据处理/田有理.pdf";
		      //String txtfilePath = "D:/temp/成交单-PDF格式-pdfbox.txt";
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

		   String path = "D:/Encyclopedia/PDF数据处理/源文件";

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

	    * 读取PDF文件的文字内容

	    * @param pdfPath

	    * @throws Exception

	    */

	   public String getTextFromPdf(String pdfPath) throws Exception {

	      // 是否排序

	      boolean sort = false;

	      // 开始提取页数

	      int startPage = 1;

	      // 结束提取页数

	      int endPage = Integer.MAX_VALUE;    

	     

	      String content = null;

	      InputStream input = null;

	      File pdfFile = new File(pdfPath);

	      PDDocument document = null;

	      try {

	         input = new FileInputStream(pdfFile);
	         
	         //RandomAccessRead randomAccessRead=new RandomAccessRead();
	         // 加载 pdf 文档

	         PDFParser parser = new PDFParser(null);

	         parser.parse();

	         document = parser.getPDDocument();

	         // 获取内容信息

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

	    * 把PDF文件内容写入到txt文件中

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
