package com.yunhai.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.pdfbox.multipdf.PDFMergerUtility;

public class PdfFileDao {
	public void multiplePdfFileMerge(String mergeFileName, String[] paths) {

		// instantiatE PDFMergerUtility class
		PDFMergerUtility pdfMerger = new PDFMergerUtility();
		// set destination file path
		pdfMerger.setDestinationFileName(mergeFileName);
		for (int i=0;i<paths.length;i++) {
			//System.out.println("paths["+i+"]="+paths[i]);
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
}
