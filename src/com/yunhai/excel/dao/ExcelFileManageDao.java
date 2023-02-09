package com.yunhai.excel.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.yunhai.excel.orm.ExcelSheetColumn;
import com.yunhai.util.CommenHibernateUtil;

public class ExcelFileManageDao {
	private static final String EXCEL_XLS = "xls";
	private static final String EXCEL_XLSX = "xlsx";

	public void updateColumnDataTypeByColumnId(String excelSheetColumnId, String dataType, String serverCode) {
		Session session = CommenHibernateUtil.getSession(serverCode);
		String querySqlStr="SELECT COLUMN_VALUE_TYPE_NAME FROM COLUMN_VALUE_TYPE WHERE DATA_TYPE_CODE = ?";

		SQLQuery sqlQuery=session.createSQLQuery(querySqlStr);
		sqlQuery.setString(0, dataType);
		String dataTypeName=(String) sqlQuery.uniqueResult();
		
		String updateStr = "UPDATE EXCEL_SHEET_COLUMN SET DATA_TYPE= ?,DATA_TYPE_CODE = ? WHERE EXCEL_SHEET_COLUMN_ID = ?";
		Transaction tr=session.beginTransaction();
		SQLQuery updateSQLQuery=session.createSQLQuery(updateStr);
		updateSQLQuery.setString(0, dataTypeName);
		updateSQLQuery.setString(1, dataType);
		updateSQLQuery.setString(2, excelSheetColumnId);
		updateSQLQuery.executeUpdate();
		tr.commit();
	}

	public void batchUpdateColumnDataTypeByColumnId(List<String> excelSheetColumnIdList, String dataTypeCode, String serverCode) {
		// TODO Auto-generated method stub
		Session session = CommenHibernateUtil.getSession(serverCode);
		String querySqlStr="SELECT COLUMN_VALUE_TYPE_NAME FROM COLUMN_VALUE_TYPE WHERE DATA_TYPE_CODE = ?";
		
		String idStr=""+"\'"+excelSheetColumnIdList.get(0)+"\'";
		for(int i=1;i<excelSheetColumnIdList.size();i++) {
			idStr=idStr+",\'"+excelSheetColumnIdList.get(i)+"\'";
		}
			
		//System.out.println("idStr="+idStr);
		SQLQuery sqlQuery=session.createSQLQuery(querySqlStr);
		sqlQuery.setString(0, dataTypeCode);
		String dataTypeName=(String) sqlQuery.uniqueResult();
		
		Transaction tx=session.beginTransaction();
		String excelSheetColumnListSql="SELECT * FROM EXCEL_SHEET_COLUMN WHERE EXCEL_SHEET_COLUMN_ID IN ("+idStr+")";
		//System.out.println("excelSheetColumnListSql=\n"+excelSheetColumnListSql);
		SQLQuery updateSQLQuery=session.createSQLQuery(excelSheetColumnListSql).addEntity(ExcelSheetColumn.class);
		//updateSQLQuery.setString(0, idStr);
		List<ExcelSheetColumn> excelSheetColumnList=updateSQLQuery.list();
		for (ExcelSheetColumn obj : excelSheetColumnList) {
			//System.out.println("DataTypeName="+obj.getDataType()+"DataTypeCode="+obj.getDataTypeCode());
			obj.setDataType(dataTypeName);
			obj.setDataTypeCode(dataTypeCode);
			//System.out.println("DataTypeName="+obj.getDataType()+"DataTypeCode="+obj.getDataTypeCode());
			session.saveOrUpdate(obj);
		}
		//session.clear();
		tx.commit();
	}

	public void columnValueAnalysis(ExcelSheetColumn excelSheetColumn) {
		// TODO Auto-generated method stub
		
	}
}
