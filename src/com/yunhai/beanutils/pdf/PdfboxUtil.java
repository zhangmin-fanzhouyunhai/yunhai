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

		   String pdfPath="D:/Encyclopedia/学习/PDF数据处理";
		   String fileName="国网河北省电力公司生产设备大修原则";
		   String suffix=".pdf"; 

		  // readOnePDF(pdfPath, fileName, suffix );

		   // fileName="国网河北省电力公司生产技术改造原则";

		   //fileName="国家电网公司生产技术改造原则20150505";

		   //readOnePDF(pdfPath, fileName, suffix );
		   //pdfPath="F:\\课题\\2-河北-2020年9月 基于大数据的电网设备技改大修管理后评估及投资辅助决策\\第一、二、三批成本项目汇总（设备部）";

		   //fileName="迎峰度夏(冬)应对措施之主变重过载分析";
		  // fileName="变电检修班迎峰度冬工作方案";
		   //suffix=".pdf"; 

		   //readOnePDF(pdfPath, fileName, suffix );
		   pdfPath="D:/temp/pdf";

		   //fileName="迎峰度夏(冬)应对措施之主变重过载分析";
		   fileName="国家电网公司生产技术改造项目后评价管理规定-生产技术改造项目后评价管理规定-标注";
		   suffix=".pdf"; 

		   fileName="QGDW 10169-2016 油浸式变压器（电抗器）状态评价导则"; 
		   //readOnePDF(pdfPath, fileName, suffix ); 
		   String wordFileName="QGDW 10169-2016 油浸式变压器（电抗器）状态评价导则";
		   wordFileName="国家电网有限公司2021年碳达峰-碳中和工作方案和任务清单";
		   fileName="国家电网有限公司2021年碳达峰-碳中和工作方案和任务清单";
		   readOnePDF2Word(pdfPath, fileName,wordFileName, suffix );
		   
		   
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
	   public static void readOnePDF2Word(String pdfPath,String fileName,String wordFileName,String suffix ) {
		   
		      //String pdfPath = "D:/temp/成交单-PDF格式.pdf";
		     // String pdfPath = "D:/Encyclopedia/PDF数据处理/田有理.pdf";
		      String txtfilePath = "D:/temp/pdf/成交单-PDF格式-pdfbox.txt";
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
			// 这里是你要写入的文件
		   
			XWPFDocument xdoc = new XWPFDocument(is);
			// 创建一个段落
			XWPFParagraph xpara = xdoc.createParagraph();
	 
			// 一个XWPFRun代表具有相同属性的一个区域。
			XWPFRun run = xpara.createRun();
			run.setBold(true); // 加粗
			run.setText(pdfContent);
			run = xpara.createRun();
			run.setColor("FF0000");
			run.setFontSize(15);
			run.setText("插入内容。");
			OutputStream os = new FileOutputStream(wordFile);
			xdoc.write(os);
			os.close();

		   
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

	         // 1.8.8 版本的pdfbox中PDDocument通过下面的方式加载 pdf 文档 
	         //2020-12-08之前
	         //PDFParser parser = new PDFParser(input); 
	         //parser.parse(); 
	         //document = parser.getPDDocument();
	         

	         //2020-12-08修改
	         // 2.0.16版本的pdfbox中PDDocument通过正面的方式，即可以加载 pdf 文档 
	         document = PDDocument.load(new File(pdfPath));
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
	   
	   /*** 
	     * PDF文件转PNG图片 
	     * @param PdfFilePath pdf完整路径 
	     * @param imgFilePath 图片存放的文件夹 
	     * @param dpi dpi越大转换后越清晰，相对转换速度越慢 
	     * @param flag 页数 为0则转换全部页数
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
	                if(flag > 0) {//大于0则打印具体页数
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
