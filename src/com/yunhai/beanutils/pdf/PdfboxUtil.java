package com.yunhai.beanutils.pdf;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
 

public class PdfboxUtil {


	 

	   /**

	    * @param args

	    */

	   public static void main(String[] args) {
		   //readOnePDF();

		   String pdfPath="D:/Encyclopedia/ѧϰ/PDF���ݴ���";
		   String fileName="�����ӱ�ʡ������˾�����豸����ԭ��";
		   String suffix=".pdf"; 

		  // readOnePDF(pdfPath, fileName, suffix );

		   // fileName="�����ӱ�ʡ������˾������������ԭ��";

		   //fileName="���ҵ�����˾������������ԭ��20150505";

		   //readOnePDF(pdfPath, fileName, suffix );
		   //pdfPath="F:\\����\\2-�ӱ�-2020��9�� ���ڴ����ݵĵ����豸���Ĵ��޹����������Ͷ�ʸ�������\\��һ�����������ɱ���Ŀ���ܣ��豸����";

		   //fileName="ӭ�����(��)Ӧ�Դ�ʩ֮�����ع��ط���";
		  // fileName="�����ް�ӭ��ȶ���������";
		   //suffix=".pdf"; 

		   //readOnePDF(pdfPath, fileName, suffix );
		   pdfPath="D:/temp/pdf";

		   //fileName="ӭ�����(��)Ӧ�Դ�ʩ֮�����ع��ط���";
		   fileName="���ҵ�����˾��������������Ŀ�����۹���涨-��������������Ŀ�����۹���涨-��ע";
		   suffix=".pdf"; 

		   fileName="QGDW 10169-2016 �ͽ�ʽ��ѹ�����翹����״̬���۵���"; 
		   //readOnePDF(pdfPath, fileName, suffix ); 
		   String wordFileName="QGDW 10169-2016 �ͽ�ʽ��ѹ�����翹����״̬���۵���";
		   wordFileName="���ҵ������޹�˾2021��̼���-̼�к͹��������������嵥";
		   fileName="���ҵ������޹�˾2021��̼���-̼�к͹��������������嵥";
		   readOnePDF2Word(pdfPath, fileName,wordFileName, suffix );
		   
		   
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
	   public static void readOnePDF2Word(String pdfPath,String fileName,String wordFileName,String suffix ) {
		   
		      //String pdfPath = "D:/temp/�ɽ���-PDF��ʽ.pdf";
		     // String pdfPath = "D:/Encyclopedia/PDF���ݴ���/������.pdf";
		      String txtfilePath = "D:/temp/pdf/�ɽ���-PDF��ʽ-pdfbox.txt";
		   	String pdfFile=pdfPath+"/"+fileName+suffix;
		      String wordFile = pdfPath+"/"+wordFileName+".docx";

		      PdfboxUtil pdfutil = new PdfboxUtil();

		      try { 
		         String content = pdfutil.getTextFromPdf(pdfFile); 
		         //pdfutil.toWordFile(content, wordFile); 
		         pdfutil.toTextFile(content, txtfilePath);
		         
		         System.out.println("Finished !");     
		      } catch (Exception e) { 
		         e.printStackTrace(); 
		      } 
		      
		      
		      
		      
	   }
	   public void toWordFile(String pdfContent,String wordFile) throws IOException
	   {
		// TODO Auto-generated method stub
		   InputStream is = new FileInputStream(wordFile);
			// ��������Ҫд����ļ�
		   
			XWPFDocument xdoc = new XWPFDocument(is);
			// ����һ������
			XWPFParagraph xpara = xdoc.createParagraph();
	 
			// һ��XWPFRun���������ͬ���Ե�һ������
			XWPFRun run = xpara.createRun();
			run.setBold(true); // �Ӵ�
			run.setText(pdfContent);
			run = xpara.createRun();
			run.setColor("FF0000");
			run.setFontSize(15);
			run.setText("�������ݡ�");
			OutputStream os = new FileOutputStream(wordFile);
			xdoc.write(os);
			os.close();

		   
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

	         // 1.8.8 �汾��pdfbox��PDDocumentͨ������ķ�ʽ���� pdf �ĵ� 
	         //2020-12-08֮ǰ
	         //PDFParser parser = new PDFParser(input); 
	         //parser.parse(); 
	         //document = parser.getPDDocument();
	         

	         //2020-12-08�޸�
	         // 2.0.16�汾��pdfbox��PDDocumentͨ������ķ�ʽ�������Լ��� pdf �ĵ� 
	         document = PDDocument.load(new File(pdfPath));
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
	   
	   /*** 
	     * PDF�ļ�תPNGͼƬ 
	     * @param PdfFilePath pdf����·�� 
	     * @param imgFilePath ͼƬ��ŵ��ļ��� 
	     * @param dpi dpiԽ��ת����Խ���������ת���ٶ�Խ�� 
	     * @param flag ҳ�� Ϊ0��ת��ȫ��ҳ��
	     * @return 
	     */  
	    /*public static void pdf2Image(String PdfFilePath, String dstImgFolder, int dpi,int flag) {  
	        File file = new File(PdfFilePath);   
	        PDDocument pdDocument;   
	        try {  
	            String imgPDFPath = file.getParent();  
	            int dot = file.getName().lastIndexOf('.');  
	            String imagePDFName = file.getName().substring(0, dot); 
	            String imgFolderPath = null;  
	            if (dstImgFolder.equals("")) {  
	                imgFolderPath = imgPDFPath ;
	            } else {  
	                imgFolderPath = dstImgFolder;  
	            }  
	  
	            if (createDirectory(imgFolderPath)) {  
	                pdDocument = PDDocument.load(file);
					
	                PDFRenderer renderer = new PDFRenderer(pdDocument); 
	                int pages = pdDocument.getNumberOfPages();
	                if(flag > 0) {//����0���ӡ����ҳ��
	                    if(flag<pages) {
	                    	pages = flag;
	                    }
	                }
	               
	                StringBuffer imgFilePath = null;  
	                for (int i = 0; i < pages; i++) {  
	                    String imgFilePathPrefix = imgFolderPath+File.separator + imagePDFName;  
	                    imgFilePath = new StringBuffer();  
	                    imgFilePath.append(imgFilePathPrefix);  
	                    imgFilePath.append("-");  
	                    imgFilePath.append(String.valueOf(i + 1));  
	                    imgFilePath.append(".png");  
	                    File dstFile = new File(imgFilePath.toString());  
	                    BufferedImage image = renderer.renderImageWithDPI(i, dpi);  
	                    ImageIO.write(image, "png", dstFile);  
	                }
	                System.out.println("success");  
	            } else {  
	                System.out.println("error:" + "creat" + imgFolderPath + "wrong");  
	            }  
	  
	        } catch (Exception e) { 
		    System.out.println("Exception");		
	            e.printStackTrace();  
	        }  
	    }  */
	  
	    private static boolean createDirectory(String folder) {  
	        File dir = new File(folder);  
	        if (dir.exists()) {  
	            return true;  
	        } else {  
	            return dir.mkdirs();  
	        }  
	    } 

	   
	   
	   
}
