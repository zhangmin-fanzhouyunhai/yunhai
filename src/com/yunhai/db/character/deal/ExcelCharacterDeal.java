package com.yunhai.db.character.deal;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.yunhai.util.ExcelUtil;

public class ExcelCharacterDeal {

	public ExcelCharacterDeal() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName="五笔词库表-张敏-V1.0-20210909.xlsx";
		String path="D:/Encyclopedia/极点五笔字库迁移";
		Workbook workbook=new ExcelUtil().getWorkBook(fileName, path);
		System.out.println("Number of sheet:"+workbook.getNumberOfSheets());
		System.out.println("Name of sheet:"+workbook.getSheetAt(1).getSheetName());
		
		Sheet wordTableSheet=workbook.getSheet("词表");
		System.out.println("Number of row:"+wordTableSheet.getLastRowNum());
		List<String> characterList=new ArrayList<String>();
		int rowNumber=wordTableSheet.getLastRowNum();
		for(int rowI=0;rowI<rowNumber;rowI++) {
			Row row=wordTableSheet.getRow(rowI);
			System.out.println("Number of row("+rowI+"):"+row.getLastCellNum());
			 System.out.println("Value of ceil(2):"+row.getCell(1));
			 String [] characterString=row.getCell(1).toString().split(" ");
			 for(int charI=0;charI<characterString.length;charI++) {
				 System.out.println("characterValue ("+charI+"):"+characterString[charI]);
			 }
		}
		
	}

}
