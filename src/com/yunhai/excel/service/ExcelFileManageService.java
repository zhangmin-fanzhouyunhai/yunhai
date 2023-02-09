package com.yunhai.excel.service;

import java.util.List;

import com.yunhai.excel.dao.ExcelFileManageDao;
import com.yunhai.excel.orm.ExcelSheetColumn;

public class ExcelFileManageService {

	public void updateColumnDataTypeByColumnId(String excelSheetColumnId, String dataType, String serverCode) {
		// TODO Auto-generated method stub
		new ExcelFileManageDao().updateColumnDataTypeByColumnId(excelSheetColumnId,dataType, serverCode);
	}

	public void batchUpdateColumnDataTypeByColumnId(List<String> excelSheetColumnIdList, String dataType, String serverCode) {
		// TODO Auto-generated method stub
		new ExcelFileManageDao().batchUpdateColumnDataTypeByColumnId(excelSheetColumnIdList,dataType, serverCode);
	}

	public void columnValueAnalysis(ExcelSheetColumn excelSheetColumn) {
		// TODO Auto-generated method stub
		new ExcelFileManageDao().columnValueAnalysis(excelSheetColumn);
	}

}
