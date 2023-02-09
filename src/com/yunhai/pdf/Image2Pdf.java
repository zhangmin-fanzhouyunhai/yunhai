package com.yunhai.pdf;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.LosslessFactory;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class Image2Pdf {
	public static void main(String[] args) {
		test();
	}

	public static void modifyFileName(String filePath) {

		// String path="E:/ProgramFiles/�ٿ�/0-ѧϰ/harmonyOS����/������̬Ӧ�ÿ�����Ƥ��";
		File storageFolder = new File(filePath);
		File[] fileList = storageFolder.listFiles();
		for (int i = 0; i < fileList.length; i++) {
			File dest = new File(filePath + "/" + "������̬Ӧ�ÿ�����Ƥ��" + i
					+ fileList[i].getName().substring(fileList[i].getName().lastIndexOf(".")));
			System.out.println("file[" + i + "] :" + fileList[i].getName().substring(50) + ",dest:" + dest.getName());
			fileList[i].renameTo(dest);
		}
	}

	public static void test() {

		String filePath = "E:/ProgramFiles/�ٿ�/0-ѧϰ/harmonyOS����/������̬Ӧ�ÿ�����Ƥ��";
		File storageFolder = new File(filePath);
		File[] fileList = storageFolder.listFiles();
		imageToPdf(fileList);
	}

	public static void imageToPdf(File[] fileList) {
		// "/imageFile/folder/img1.png"
		for (int i = 0; i < fileList.length; i++) {
			File imageFile = fileList[i];
			String outputFileName = fileList[i].getParentFile() + "/"
					+ fileList[i].getName().substring(0, fileList[i].getName().lastIndexOf(".")) + ".pdf";
			System.out.println("outputFileName:" + outputFileName + ",parentPath:" + fileList[i].getParentFile());
			File outFile = new File(outputFileName);
			try {
				BufferedImage image = ImageIO.read(imageFile);
				PDDocument outDocument = new PDDocument();
				PDPage pdPage = new PDPage(PDRectangle.A4);
				PDImageXObject imageXObject = LosslessFactory.createFromImage(outDocument, image);
				outDocument.addPage(pdPage);
				PDPageContentStream pageContentStream = new PDPageContentStream(outDocument, pdPage);
				/*
				 * Ҫ��ͼƬ��pdf�л��ƶ�ߣ�������ֱ��ʹ����pdfpage�Ŀ�ȣ�������������
				 * �����heightҲ��ʹ����pdfpage�ĸ߶ȡ�������ս������������pdfҳ��
				 */
				float height = pdPage.getMediaBox().getHeight();

				float y = pdPage.getMediaBox().getHeight() - height;// ����Ƚ����������������������½�Ϊԭ������ġ�
				pageContentStream.drawImage(imageXObject, 0, y, pdPage.getMediaBox().getWidth(), height);
				pageContentStream.close();

				if (!outFile.getParentFile().exists()) {
					outFile.getParentFile().mkdirs();
				}

				outDocument.save(outFile);
				outDocument.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void imageToPdf(String[] paths) {
		// "/imageFile/folder/img1.png"
		for (int i = 0; i < paths.length; i++) {
			File imageFile = new File(paths[i]);
			String outputFileName = paths[i].substring(0, paths[i].lastIndexOf(".") - 1) + ".pdf";
			File outFile = new File(outputFileName);
			try {
				BufferedImage image = ImageIO.read(imageFile);
				PDDocument outDocument = new PDDocument();
				PDPage pdPage = new PDPage(PDRectangle.A4);
				PDImageXObject imageXObject = LosslessFactory.createFromImage(outDocument, image);
				outDocument.addPage(pdPage);
				PDPageContentStream pageContentStream = new PDPageContentStream(outDocument, pdPage);
				/*
				 * Ҫ��ͼƬ��pdf�л��ƶ�ߣ�������ֱ��ʹ����pdfpage�Ŀ�ȣ�������������
				 * �����heightҲ��ʹ����pdfpage�ĸ߶ȡ�������ս������������pdfҳ��
				 */
				float height = pdPage.getMediaBox().getHeight();

				float y = pdPage.getMediaBox().getHeight() - height;// ����Ƚ����������������������½�Ϊԭ������ġ�
				pageContentStream.drawImage(imageXObject, 0, y, pdPage.getMediaBox().getWidth(), height);
				pageContentStream.close();

				if (!outFile.getParentFile().exists()) {
					outFile.getParentFile().mkdirs();
				}

				outDocument.save(outFile);
				outDocument.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
