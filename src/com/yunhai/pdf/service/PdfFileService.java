package com.yunhai.pdf.service;

import com.yunhai.pdf.dao.PdfFileDao;

public class PdfFileService {
	public void multiplePdfFileMerge(String mergeFileName,String[] paths) {
		new PdfFileDao().multiplePdfFileMerge(mergeFileName, paths);
	}
	public void imageToPdf(String[] paths) {
		new PdfFileDao().imageToPdf(paths);
	}

}
