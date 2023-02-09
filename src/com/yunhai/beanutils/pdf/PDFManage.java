package com.yunhai.beanutils.pdf;

import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

public class PDFManage {
	public static void main(String[] args) {
		String pdfFilePath;
		String pdfFileName;
		pdfFilePath = "D:/temp/pdf/";
		pdfFileName = "createPDF.pdf";
		pdfFilePath = "F:/����/2-�ӱ�-2020��9�� ���ڴ����ݵĵ����豸���Ĵ��޹����������Ͷ�ʸ�������/����-20201209����ṩ/�ο�����/1.���Ĵ��޺�����/";
		pdfFileName = "������Ŀ�������о�����_Σ����.pdf";
		PDFManage pdfManage = new PDFManage();
		// pdfManage.createHelloPDF(pdfFilePath,pdfFileName);
		// pdfManage.readPDF(pdfFilePath, pdfFileName);

		pdfFilePath = "D:/temp/pdf/";
		pdfFileName = "QGDW 10169-2016 �ͽ�ʽ��ѹ�����翹����״̬���۵���.pdf";
		//pdfManage.fillTemplete(pdfFilePath, pdfFileName);
		String pdfPath= "D:/temp/pdf/";
		String fileName= "QGDW 10169-2016 �ͽ�ʽ��ѹ�����翹����״̬���۵���";
		String suffix = ".pdf";
		pdfPath= "D:/temp/pdf/";
		fileName= "���ҵ������޹�˾2021��̼���-̼�к͹��������������嵥";
		suffix = ".pdf";
		pdfManage.readOnePDF2Word(pdfPath, fileName, suffix);

	}

	// pdfģ�崦��
	private static void fillTemplete(String pdfFilePath, String pdfFileName) {
		// String templetePath = "D:\\201902yb_from_5_to_5_.pdf";
		String templetePath = pdfFilePath + pdfFileName;
		String data = "";
		try {
			PDDocument document = PDDocument.load(new File(templetePath));
			if (document.isEncrypted()) {
				try {
					// document.decrypt("");
				} catch (Exception e) {
				}
			}
			PDFTextStripperByArea stripper = new PDFTextStripperByArea();
			stripper.setSortByPosition(true);
			stripper.setWordSeparator("|");
//		      stripper.setLineSeparator("#");
			// ��������
			Rectangle rect = new Rectangle(0, 0, 10000, 10000);
			stripper.addRegion("area", rect);
			// List<PDPage> allPages = document.getDocumentCatalog().getAllPages();
			// List<PDPage> allPages = (List<PDPage>)
			// document.getDocumentCatalog().getPages();
			PDPageTree allPages = document.getDocumentCatalog().getPages();
			int i = 0;
			for (PDPage page : allPages) {
				stripper.extractRegions(page);

				i++;
				// ��ȡ�����text
				data = stripper.getTextForRegion("area");
//		         data = data.trim();
				String[] datas = data.split("\r\n");
				// ���ı����з��д���
				for (i = 0; i < datas.length; ++i) {
					String[] str = datas[i].split(" ");
					// System.out.println(JsonUtils.objToString(str));
					int strLength = str.length;
					for (int j = 0; j < strLength; j++) {
						System.out.print(str[j]);
					}
					System.out.println();
				}
			}
			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void readOnePDF2Word(String pdfPath,String fileName,String suffix ) {
		   
	      //String pdfPath = "D:/temp/�ɽ���-PDF��ʽ.pdf";
	     // String pdfPath = "D:/Encyclopedia/PDF���ݴ���/������.pdf";
	      //String txtfilePath = "D:/temp/�ɽ���-PDF��ʽ-pdfbox.txt";
	   	String pdfFile=pdfPath+"/"+fileName+suffix; 

	      PdfboxUtil pdfutil = new PdfboxUtil();

	      try { 
	         String content = pdfutil.getTextFromPdf(pdfFile); 
	         //content.split("\r\n"); 
	         content.replace("\r\n", "");
	         System.out.println(content);     
	      } catch (Exception e) { 
	         e.printStackTrace(); 
	      }
	}

	public void createHelloPDF(String pdfFilePath, String pdfFileName) {
		PDDocument doc = null;
		PDPage page = null;
		String pdfFile = pdfFilePath + "/" + pdfFileName;
		try {
			doc = new PDDocument();
			page = new PDPage();
			doc.addPage(page);
			PDFont font = PDType1Font.HELVETICA_BOLD;
			PDPageContentStream content = new PDPageContentStream(doc, page);
			content.beginText();
			content.setFont(font, 12);
			content.moveTextPositionByAmount(100, 700);
			content.drawString("hello");

			content.endText();
			content.close();
			doc.save(pdfFile);
			doc.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void readPDF(String pdfFilePath, String pdfFileName) {
		PDDocument helloDocument = null;
		String pdfFileString = pdfFilePath + pdfFileName;
		try {
			helloDocument = PDDocument.load(new File(pdfFileString));
			// helloDocument.getPages().

			PDFTextStripper textStripper = new PDFTextStripper();
			// textStripper.get
			// textStripper.("GBK")
			System.out.println(textStripper.getText(helloDocument));

			helloDocument.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}

