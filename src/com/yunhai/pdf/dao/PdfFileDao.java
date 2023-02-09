package com.yunhai.pdf.dao;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.LosslessFactory;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class PdfFileDao {
	public void multiplePdfFileMerge(String mergeFileName, String[] paths) {

		// instantiatE PDFMergerUtility class
		PDFMergerUtility pdfMerger = new PDFMergerUtility();
		// set destination file path
		pdfMerger.setDestinationFileName(mergeFileName);
		for (int i = 0; i < paths.length; i++) {
			// System.out.println("paths["+i+"]="+paths[i]);
			File file = new File(paths[i]);
			// add all source files, to be merged, to pdfMerger
			try {
				pdfMerger.addSource(file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// merge documents
		try {
			pdfMerger.mergeDocuments(null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void imageToPdf(String[] paths) {
		//"/imageFile/folder/img1.png"
		for (int i = 0; i < paths.length; i++) {
			File imageFile = new File(paths[i]);
			String outputFileName=paths[i].substring(0, paths[i].lastIndexOf(".")-1)+".pdf";
			File outFile = new File(outputFileName);
			try {
				BufferedImage image = ImageIO.read(imageFile);
				PDDocument outDocument = new PDDocument();
				PDPage pdPage = new PDPage(PDRectangle.A4);
				PDImageXObject imageXObject = LosslessFactory.createFromImage(outDocument, image);
				outDocument.addPage(pdPage);
				PDPageContentStream pageContentStream = new PDPageContentStream(outDocument, pdPage);
				/* 要将图片在pdf中绘制多高，这里宽度直接使用了pdfpage的宽度，即横向铺满，
				 * 这里的height也是使用了pdfpage的高度。因此最终结果是铺满整个pdf页。*/
				float height = pdPage.getMediaBox().getHeight();

				float y = pdPage.getMediaBox().getHeight() - height;// 这里比较奇葩的是这个坐标是以左下角为原点坐标的。
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
