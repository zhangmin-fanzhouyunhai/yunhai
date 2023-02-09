package com.yunhai.excel;

import java.sql.SQLException;

import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ExcelOutputDemo {

	public static void main(String[] args) throws RowsExceededException, ClassNotFoundException, NoSuchFieldException, SecurityException, NoSuchMethodException, WriteException, SQLException {
		// TODO Auto-generated method stub
		new ExportDao().midErpItemTest();
	}

}
