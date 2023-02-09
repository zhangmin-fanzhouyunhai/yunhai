package com.yunhai.excel;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.ParseException;

public class FileCopyTest {

	// 获取Excel文档的路径�?
	public static void main(String[] args) throws ParseException, IOException {

		String path = "D:\\temp\\2020年潮�?";
		String importedFilePath="D:\\temp\\2020年潮�?-已经插入文件";
		String errorFilePath="D:\\temp\\2020年潮�?-行数异常文件";

		//获取第k个文�?
		String filePath = path + "\\变压器潮�?500kV2020-01-01.xls" ;// "D://excel.xls";
		String errorRowFilePath = errorFilePath + "\\变压器潮�?500kV2020-01-01.xls" ;// "D://excel.xls";
		
		
		File file1=new File(filePath); 
		File errorRowFile=new File(errorRowFilePath);  
		Files.copy(file1.toPath(), errorRowFile.toPath());

	}
	
}
