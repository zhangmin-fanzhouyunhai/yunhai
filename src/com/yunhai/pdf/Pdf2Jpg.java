package com.yunhai.pdf;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

public class Pdf2Jpg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String suffix = ".pdf";
		// String pdfPath="D:/Encyclopedia/学习/PDF数据处理";
		String pdfPath = "D:/workspace/pdf";
		String fileName = "Measuring the efficiency of decision making units-CCR1978";
		fileName = "不列颠百科全书.国际中文版.2";
		String imageFormat="jpg";//最终希望将pdf转换成的图片格式类型
		imageFormat="png";//最终希望将pdf转换成的图片格式类型
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String figurePath=pdfPath+"/"+fileName+"_"+(sdf.format(new Date())).replace(" ", "_").replace("-", "_").replace(":", "_");
		System.out.println("figurePath："+figurePath);
		//转换成图片的像素数量，数值越大，清晰度越高
		float dpi=1024;//1024000;//819200;//512000;//102400;//10240;//1024;
		figurePath=figurePath+"_"+dpi;
		File newFilePath=new File(figurePath);
		if(!newFilePath.exists()) {
			newFilePath.mkdir();
		}
		String pdfPathWithFileName=pdfPath+"/"+fileName+suffix;
		File pdfFile=new File(pdfPathWithFileName);
		PDDocument doc=null;
		BufferedOutputStream outputStream=null;
		try {
			doc=PDDocument.load(pdfFile); 
			int pageCount = doc.getNumberOfPages();
			//获取pdf文件的page树
			//PDPageTree pages=doc.getDocumentCatalog().getPages();
			//Iterator<PDPage> pdpIter=pages.iterator();
			//for (PDPage pdPage : pages) {
				//生成图片，
				//BufferedImage image=pdPage.
			//} 
			PDFRenderer pdfRenderer= new PDFRenderer(doc);
			String imagePathWithName="";
			for(int i=0;i<pageCount;i++) {
				imagePathWithName=newFilePath+"/"+fileName+"-"+i+"."+imageFormat;
				System.out.println("imagePathWithName="+imagePathWithName);
				outputStream=new BufferedOutputStream(new FileOutputStream(imagePathWithName));
				BufferedImage image=pdfRenderer.renderImage(i);
				ImageIO.write(image,imageFormat,outputStream);
				outputStream.close();
				//log.info("")
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeSilently(outputStream);
			closeSilently(doc);
		}
		
	}
	public static void closeSilently(Closeable io) {
		if(io !=null) {
			try {
				io.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
