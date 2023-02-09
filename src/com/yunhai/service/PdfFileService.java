package com.yunhai.service;

import com.yunhai.dao.PdfFileDao;

public class PdfFileService {
	public void multiplePdfFileMerge(String mergeFileName,String[] paths) {
		new PdfFileDao().multiplePdfFileMerge(mergeFileName, paths);
	}
}
