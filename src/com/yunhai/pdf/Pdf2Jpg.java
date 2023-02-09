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
		// String pdfPath="D:/Encyclopedia/ѧϰ/PDF���ݴ���";
		String pdfPath = "D:/workspace/pdf";
		String fileName = "Measuring the efficiency of decision making units-CCR1978";
		fileName = "���е߰ٿ�ȫ��.�������İ�.2";
		String imageFormat="jpg";//����ϣ����pdfת���ɵ�ͼƬ��ʽ����
		imageFormat="png";//����ϣ����pdfת���ɵ�ͼƬ��ʽ����
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String figurePath=pdfPath+"/"+fileName+"_"+(sdf.format(new Date())).replace(" ", "_").replace("-", "_").replace(":", "_");
		System.out.println("figurePath��"+figurePath);
		//ת����ͼƬ��������������ֵԽ��������Խ��
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
			//��ȡpdf�ļ���page��
			//PDPageTree pages=doc.getDocumentCatalog().getPages();
			//Iterator<PDPage> pdpIter=pages.iterator();
			//for (PDPage pdPage : pages) {
				//����ͼƬ��
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
