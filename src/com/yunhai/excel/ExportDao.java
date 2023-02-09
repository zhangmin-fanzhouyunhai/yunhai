package com.yunhai.excel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.math.BigDecimal;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.transform.Transformers;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yunhai.db.orm.TableColumnProperty;
import com.yunhai.db.util.DbUtil;
import com.yunhai.excel.orm.BicAzfiSwzc;
import com.yunhai.excel.orm.MidErpItem;
import com.yunhai.excel.orm.MidErpItemAssetWall;
import com.yunhai.excel.orm.MidPmsItem;
import com.yunhai.excel.orm.PmsQuexian;
import com.yunhai.excel.orm.RsPolynRegressCoefficient;
import com.yunhai.excel.orm.YTableCell;
import com.yunhai.excel.orm.YTableCellString;
import com.yunhai.excel.orm.ZfiSwzc2019;

import jxl.Workbook;
import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ExportDao {
	public void midErpItemTest() throws ClassNotFoundException, SQLException, NoSuchFieldException, SecurityException,
	NoSuchMethodException, RowsExceededException, WriteException {
String tableName = "MID_ERP_ITEM";
int recordQuantity = 20000;
// int recordQuantity = 65534;
// int recordQuantity = 50000;
int columnNameOrComment = 1;
// List<MidErpItem> list = new ArrayList<MidErpItem>();
Connection conn = null;
conn = DbUtil.getConnection();
ExportDao exportDao = new ExportDao();
List<TableColumnProperty> headList = exportDao.getHeadList(conn, tableName, columnNameOrComment);

/*
for (int i = 0; i < headList.size(); i++) {
	System.out.println("headList(" + i + ")=" + headList.get(i).getColumnName());
}
*/
// 创建预编译语句对象，一般都是用这个而不用Statement
PreparedStatement pre = null;
// 创建一个结果集对象
ResultSet result = null;

String sql = "select * from " + tableName;// + " where rownum<1000";
pre = conn.prepareStatement(sql);// 实例化预编译语句
result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.s");
// json对象
JSONObject jsonObj = new JSONObject();
// 获取列数
ResultSetMetaData rsd = result.getMetaData();
int columnCount = rsd.getColumnCount();
System.out.println("Ready in loop!");
int i = 1;
Runtime run = Runtime.getRuntime();
Double maxMem = new Double(run.maxMemory() / 1024 / 1024);
Double freeMem = new Double(run.freeMemory() / 1024 / 1024);
Double totalMem = new Double(run.totalMemory() / 1024 / 1024);
int outj = 1;
// long usedMem = maxMem - freeMem;
// 遍历ResultSet中的每条数据
// long usedMem = maxMem - freeMem;
// 遍历ResultSet中的每条数据

List objList = new ArrayList<>();
List list = new ArrayList<JSONObject>();
while (result.next()) {
	run = Runtime.getRuntime();
	maxMem = new Double(run.maxMemory() / 1024 / 1024);
	freeMem = new Double(run.freeMemory() / 1024 / 1024);
	totalMem = new Double(run.totalMemory() / 1024 / 1024);
	if ((new Double(run.totalMemory()) / new Double(run.maxMemory()) > 0.60)
			&& (new Double(run.freeMemory()) / new Double(run.maxMemory()) < 0.30)) {
		System.out.println("output " + (outj++) + "times!");
		boolean BResult = false;
		BResult = writeIntoXls(headList, tableName, list, recordQuantity, columnNameOrComment);
		list.clear();
		list = null;
		list = new ArrayList<JSONObject>();
	}

	// 遍历每一列
	for (int colI = 1; colI <= columnCount; colI++) {
		String columnName = rsd.getColumnLabel(colI);

		String value = result.getString(columnName);
		//System.out.println("columnName=" + columnName + ",value=" + value);
		if (rsd.getColumnType(colI) == 93) {
			if (value == null) {
				jsonObj.put(columnName, "");
			} else {
				jsonObj.put(columnName, value);
			}
		} else if (rsd.getColumnType(colI) == 12) {
			if (value == null) {
				jsonObj.put(columnName, "");
			} else {
				jsonObj.put(columnName, result.getString(columnName));
			}
		} else if (rsd.getColumnType(colI) == -9) {
			if (value == null) {
				jsonObj.put(columnName, "");
			} else {
				jsonObj.put(columnName, result.getString(columnName));
			}
		} else if (rsd.getColumnType(colI) == 2) {
			if (value == null) {
				jsonObj.put(columnName, 0);
			} else {
				jsonObj.put(columnName, result.getDouble(columnName));
			}
		}
		// System.out.println("Value of "+columnName+" is :"+jsonObj.get(columnName));
	}
	// 遍历每一列
	/*
	for (int colI = 1; colI <= columnCount; colI++) {
		String columnName = rsd.getColumnLabel(colI);
		System.out.println("Value of " + columnName + " is :" + jsonObj.get(columnName));
	}*/
	System.out.println("i=" + (i++) + ",usedMemPercent=" + new Double(totalMem / maxMem) + ",freeMemPercent="
			+ new Double(freeMem / maxMem) + ",maxMem=" + (maxMem) + ",freeMem=" + (freeMem) + ",usedMem="
			+ (totalMem) + ",totalMem=" + (totalMem));
	//String classString = "com.yunhai.excel.orm.MidErpItem";
	//Class clazz = Class.forName(classString);
	//JSON.parseObject(JSON.toJSONStringWithDateFormat(jsonObj, "yyyy-MM-dd HH:mm:ss.s"), clazz);
	//objList.add(JSON.parseObject(JSON.toJSONStringWithDateFormat(jsonObj, "yyyy-MM-dd HH:mm:ss.s"), clazz));
	list.add(jsonObj);

	//System.out.println("objList.size()=" + objList.size());
	// System.out.println("objList.get(objList.size()-1)="+objList.get(objList.size()-1).getClass().getMethod("getOldPropertyCode").getName());

	jsonObj = new JSONObject();

}
if (list.size() != 0) {
	System.out.println("The last times output!");
	boolean BResult = false;
	try {
		// BResult = writeMidErpItemIntoXls(tableName, list,
		// recordQuantity);
		BResult = writeIntoXls(headList, tableName, list, recordQuantity, columnNameOrComment);
		list.clear();
	} catch (RowsExceededException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (WriteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

}

public boolean writeIntoXls(List<TableColumnProperty> headList, String tableName, List<JSONObject> list,
	int recordQuantity, int columnNameOrComment) throws RowsExceededException, WriteException
// throws RowsExceededException, WriteException
{

Date now = new Date();
SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-ddHHmmss");
String nowdate = df.format(now);
// 打开文件
WritableWorkbook book = null;

try {
	book = Workbook.createWorkbook(new File("D:/temp/" + tableName + "_" + nowdate + "_" + 0 + ".xls"));
} catch (IOException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
System.out.println(book);
System.out.println("D:/temp/" + tableName + nowdate + ".xls");
// 生成名为"第一页"的工作表，参数0表示这是第一
WritableSheet sheet = book.createSheet("Sheet1", 0);

// 设置字体为宋体,16号字,加粗,颜色为黑色
WritableFont font1 = new WritableFont(WritableFont.createFont("宋体"), 12, WritableFont.BOLD);
try {
	font1.setColour(Colour.BLACK);
} catch (WriteException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
WritableCellFormat format1 = new WritableCellFormat(font1);
try {
	format1.setAlignment(jxl.format.Alignment.CENTRE);
} catch (WriteException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
try {
	format1.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
} catch (WriteException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

for (int i = 0; i < headList.size(); i++) {
	Label label = null;
	if (columnNameOrComment == 1) {
		label = new Label(headList.get(i).getColumnId() - 1, 0, headList.get(i).getColumnName(), format1);
	} else {
		label = new Label(headList.get(i).getColumnId() - 1, 0, headList.get(i).getColumnComment(), format1);
	}
	try {
		sheet.addCell(label);
	} catch (RowsExceededException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (WriteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

// writeHead(conn, book, tableName, 1);
sheet = book.getSheet("Sheet1");
for (int i = 0; i < list.size(); i++) {
	int j = i / recordQuantity;

	// System.out.println("i=" + i);
	// System.out.println("(i % 65534) == 0 && i != 0)="+((i %
	// 65534) == 0 && i != 0));
	if ((i % recordQuantity) == 0 && i != 0) {
		// 写入数据并关闭文件
		// System.out.println("I'm Here!");
		try {
			book.write();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			book.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		df = new SimpleDateFormat("yyyy-MM-ddHHmmss");
		now = new Date();
		nowdate = df.format(now);
		// System.out.println("D:/temp/" + tableName + nowdate +j+
		// ".xls");
		try {
			book = Workbook.createWorkbook(new File("D:/temp/" + tableName + "_" + nowdate + "_" + j + ".xls"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println("D:/temp/" + tableName + nowdate +j+
		// ".xls");

		df = new SimpleDateFormat("yyyy-MM-dd");
		sheet = book.createSheet("Sheet1", 0);

		for (int headListi = 0; headListi < headList.size(); headListi++) {
			Label label = null;
			if (columnNameOrComment == 1) {
				label = new Label(headList.get(headListi).getColumnId() - 1, 0,
						headList.get(headListi).getColumnName(), format1);
			} else {
				label = new Label(headList.get(headListi).getColumnId() - 1, 0,
						headList.get(headListi).getColumnComment(), format1);
			}
			try {
				sheet.addCell(label);
			} catch (RowsExceededException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// writeHead(conn, book, tableName, 1);
		sheet = book.getSheet("Sheet1");
		df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// break;
	}
	// System.out.println("j=" + j);
	int recordQuantityTimes = j * recordQuantity;
	for (int labelI = 0; labelI < headList.size(); labelI++) {
		TableColumnProperty tableColumnProperty = (TableColumnProperty) headList.get(labelI);
		String columnName = tableColumnProperty.getColumnName();
		JSONObject JSONObj = (JSONObject) list.get(i);
		//System.out.println("JSONObj.get(" + columnName + ")=" + JSONObj.get(columnName)+
		//		",data type is "+
		//		tableColumnProperty.getDataType());
		String value="";
		//(String) JSONObj.get(columnName);
		//if(tableColumnProperty.getDataType()) {
			value=JSONObj.get(columnName).toString();
		//}
		sheet.addCell(new Label(labelI, i + 1 - recordQuantityTimes,value ));
	}

	System.out.println("i=" + (i + 1));
}
System.out.println(sheet.toString());
// }

// 写入数据并关闭文件
try {
	book.write();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
try {
	book.close();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
System.out.println("创建文件成功!");
now = new Date();
nowdate = df.format(now);
System.out.println("Now time is :" + nowdate);

return true;
}
	/**
	 * @return
	 */
	public static List<BicAzfiSwzc> getAllBicAzfiSwzc(Connection conn, String tableName) {
		List<BicAzfiSwzc> list = new ArrayList<BicAzfiSwzc>();
		try {
			// Connection conn = null;
			// conn = Dbutil.getConnection();
			// 创建预编译语句对象，一般都是用这个而不用Statement
			PreparedStatement pre = null;
			// 创建一个结果集对象
			ResultSet result = null;

			String sql = "select * from " + tableName;
			pre = conn.prepareStatement(sql);// 实例化预编译语句
			result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String bicAzfiSwzcId = null;
			String calyear = null;
			String compCode = null;
			String assetMain = null;
			String asset = null;
			String zioEqunr = null;
			String currency = null;
			Double zpmzcyz = null;
			Double zpmzcjz = null;
			String ztypbz1 = null;
			String ztypbz2 = null;
			String ztypbz3 = null;
			String zvolLev = null;
			Double zquantity = null;
			String unit = null;
			String zioZczt = null;
			String profitCtr = null;
			String zlrzx = null;
			String coArea = null;
			String zzcms = null;
			String zioZxmlx = null;
			String capitDate = null;
			String zdeakt = null;
			String assetClas = null;
			String zxlh = null;
			String zinvnr = null;
			String zi0Zzc1 = null;
			String zi0Zzc2 = null;
			String zioKostl = null;
			String zkostlv = null;
			String zioRaumn = null;
			String zzzph = null;
			String zzkostl = null;
			String zioZzc06 = null;
			String zioZzc07 = null;
			String zioOrd41 = null;
			String zord44 = null;
			String zgdlgrp = null;
			String zzcly = null;
			String zioUmwkz = null;
			String zsfdg = null;
			String zioHerst = null;
			String ztypbz = null;
			String zPosid = null;
			String zpost11 = null;
			String zfiamt = null;
			String zioStadt = null;
			String zfwcqzh = null;
			String zioEqktx = null;
			String zioTxt04 = null;
			String zioEqart = null;
			String zpmsqz = null;
			String zioInbdt = null;
			String zioZccrq = null;
			String zzzs = null;
			String zioHerld = null;
			String zioMapar = null;
			String ztxz012 = null;
			String zioSerge = null;
			String zioSwerk = null;
			String zioStort = null;
			String zioBeber = null;
			String zioAbckz = null;
			String zioEqfnr = null;
			String zioZzc02 = null;
			String zProjk = null;
			String zwbsnm = null;
			String zioIwerk = null;
			String zioIngrp = null;
			String zioVaplz = null;
			String zioTplnr = null;
			String zioHequi = null;
			String zioTidnr = null;
			String zioSb010 = null;
			String zioSb001 = null;
			String zioSb002 = null;
			String zioSb004 = null;
			String zioSb005 = null;
			String zioSb006 = null;
			String zioSb003 = null;
			String zioSb007 = null;
			Double zioSb008 = null;
			String zlenunt = null;
			Double zioSb009 = null;
			String zcapunt = null;
			String zioSb011 = null;
			String zioUmlgo = null;
			String zioGplab = null;
			String zioPosid = null;
			String zlyrkrq = null;
			String zlyckrq = null;
			String zpost1 = null;
			String zioCusre = null;
			String zbfyy = null;
			String zioZsb13 = null;
			String zioZsb12 = null;
			String recordmode = null;
			String dataVersion = null;

			System.out.println("Ready in loop!");
			int i = 1;
			Runtime run = Runtime.getRuntime();
			long maxMem = run.maxMemory() / 1024 / 1024;
			long freeMem = run.freeMemory() / 1024 / 1024;
			long totalMem = run.totalMemory();
			long usedMem = maxMem - freeMem;
			while (result.next()) {

				maxMem = run.maxMemory() / 1024 / 1024;
				freeMem = run.freeMemory() / 1024 / 1024;
				totalMem = run.totalMemory();
				usedMem = maxMem - freeMem;
				// System.out.println("Add!");
				System.out.println("i=" + (i++) + ",usedMemPercent=" + new Double(usedMem / maxMem) + ",maxMem="
						+ (maxMem) + ",freeMem=" + (freeMem) + ",usedMem=" + (usedMem) + ",totalMem=" + (totalMem));

				// Arrays.asList(s);
				// System.out.println("Add!");

				// try {
				// midPmsItemId = result.getString("MID_PMS_ITEM_ID");
				// } catch (SQLException e) {
				// try {
				// midPmsItemId = result.getString("MID_PMS_UNMATCHED_ITEM_ID");
				// } catch (SQLException e1) {
				// midPmsItemId = result.getString("MID_PMS_MATCHED_ITEM_ID");
				// }
				// }
				bicAzfiSwzcId = result.getString("BIC_AZFI_SWZC_ID");
				calyear = result.getString("CALYEAR");
				compCode = result.getString("COMP_CODE");
				assetMain = result.getString("ASSET_MAIN");
				asset = result.getString("ASSET");
				zioEqunr = result.getString("ZIO_EQUNR");
				currency = result.getString("CURRENCY");
				if (null == result.getString("ZPMZCYZ")) {
					zpmzcyz = Double.parseDouble("0");
				} else {
					zpmzcyz = Double.parseDouble(result.getString("ZPMZCYZ"));
				}
				// zpmzcyz= result.getString("ZPMZCYZ");
				if (null == result.getString("ZPMZCJZ")) {
					zpmzcjz = Double.parseDouble("0");
				} else {
					zpmzcjz = Double.parseDouble(result.getString("ZPMZCJZ"));
				}
				// zpmzcjz= result.getString("ZPMZCJZ");
				ztypbz1 = result.getString("ZTYPBZ1");
				ztypbz2 = result.getString("ZTYPBZ2");
				ztypbz3 = result.getString("ZTYPBZ3");
				zvolLev = result.getString("ZVOL_LEV");
				if (null == result.getString("ZQUANTITY")) {
					zquantity = Double.parseDouble("0");
				} else {
					zquantity = Double.parseDouble(result.getString("ZQUANTITY"));
				}
				// zquantity= result.getString("ZQUANTITY");
				unit = result.getString("UNIT");
				zioZczt = result.getString("ZIO_ZCZT");
				profitCtr = result.getString("PROFIT_CTR");
				zlrzx = result.getString("ZLRZX");
				coArea = result.getString("CO_AREA");
				zzcms = result.getString("ZZCMS");
				zioZxmlx = result.getString("ZIO_ZXMLX");
				capitDate = result.getString("CAPIT_DATE");
				zdeakt = result.getString("ZDEAKT");
				assetClas = result.getString("ASSET_CLAS");
				zxlh = result.getString("ZXLH");
				zinvnr = result.getString("ZINVNR");
				zi0Zzc1 = result.getString("ZI0_ZZC1");
				zi0Zzc2 = result.getString("ZI0_ZZC2");
				zioKostl = result.getString("ZIO_KOSTL");
				zkostlv = result.getString("ZKOSTLV");
				zioRaumn = result.getString("ZIO_RAUMN");
				zzzph = result.getString("ZZZPH");
				zzkostl = result.getString("ZZKOSTL");
				zioZzc06 = result.getString("ZIO_ZZC06");
				zioZzc07 = result.getString("ZIO_ZZC07");
				zioOrd41 = result.getString("ZIO_ORD41");
				zord44 = result.getString("ZORD44");
				zgdlgrp = result.getString("ZGDLGRP");
				zzcly = result.getString("ZZCLY");
				zioUmwkz = result.getString("ZIO_UMWKZ");
				zsfdg = result.getString("ZSFDG");
				zioHerst = result.getString("ZIO_HERST");
				ztypbz = result.getString("ZTYPBZ");
				zPosid = result.getString("Z_POSID");
				zpost11 = result.getString("ZPOST11");
				zfiamt = result.getString("ZFIAMT");
				zioStadt = result.getString("ZIO_STADT");
				zfwcqzh = result.getString("ZFWCQZH");
				zioEqktx = result.getString("ZIO_EQKTX");
				zioTxt04 = result.getString("ZIO_TXT04");
				zioEqart = result.getString("ZIO_EQART");
				zpmsqz = result.getString("ZPMSQZ");
				zioInbdt = result.getString("ZIO_INBDT");
				zioZccrq = result.getString("ZIO_ZCCRQ");
				zzzs = result.getString("ZZZS");
				zioHerld = result.getString("ZIO_HERLD");
				zioMapar = result.getString("ZIO_MAPAR");
				ztxz012 = result.getString("ZTXZ012");
				zioSerge = result.getString("ZIO_SERGE");
				zioSwerk = result.getString("ZIO_SWERK");
				zioStort = result.getString("ZIO_STORT");
				zioBeber = result.getString("ZIO_BEBER");
				zioAbckz = result.getString("ZIO_ABCKZ");
				zioEqfnr = result.getString("ZIO_EQFNR");
				zioZzc02 = result.getString("ZIO_ZZC02");
				zProjk = result.getString("Z_PROJK");
				zwbsnm = result.getString("ZWBSNM");
				zioIwerk = result.getString("ZIO_IWERK");
				zioIngrp = result.getString("ZIO_INGRP");
				zioVaplz = result.getString("ZIO_VAPLZ");
				zioTplnr = result.getString("ZIO_TPLNR");
				zioHequi = result.getString("ZIO_HEQUI");
				zioTidnr = result.getString("ZIO_TIDNR");
				zioSb010 = result.getString("ZIO_SB010");
				zioSb001 = result.getString("ZIO_SB001");
				zioSb002 = result.getString("ZIO_SB002");
				zioSb004 = result.getString("ZIO_SB004");
				zioSb005 = result.getString("ZIO_SB005");
				zioSb006 = result.getString("ZIO_SB006");
				zioSb003 = result.getString("ZIO_SB003");
				zioSb007 = result.getString("ZIO_SB007");
				if (null == result.getString("ZIO_SB008")) {
					zioSb008 = Double.parseDouble("0");
				} else {
					zioSb008 = Double.parseDouble(result.getString("ZIO_SB008"));
				}
				// zioSb008= result.getString("ZIO_SB008");
				zlenunt = result.getString("ZLENUNT");
				if (null == result.getString("ZIO_SB009")) {
					zioSb009 = Double.parseDouble("0");
				} else {
					zioSb009 = Double.parseDouble(result.getString("ZIO_SB009"));
				}
				// zioSb009= result.getString("ZIO_SB009");
				zcapunt = result.getString("ZCAPUNT");
				zioSb011 = result.getString("ZIO_SB011");
				zioUmlgo = result.getString("ZIO_UMLGO");
				zioGplab = result.getString("ZIO_GPLAB");
				zioPosid = result.getString("ZIO_POSID");
				zlyrkrq = result.getString("ZLYRKRQ");
				zlyckrq = result.getString("ZLYCKRQ");
				zpost1 = result.getString("ZPOST1");
				zioCusre = result.getString("ZIO_CUSRE");
				zbfyy = result.getString("ZBFYY");
				zioZsb13 = result.getString("ZIO_ZSB13");
				zioZsb12 = result.getString("ZIO_ZSB12");
				recordmode = result.getString("RECORDMODE");
				dataVersion = result.getString("DATA_VERSION");

				list.add(new BicAzfiSwzc(bicAzfiSwzcId, calyear, compCode, assetMain, asset, zioEqunr, currency,
						zpmzcyz, zpmzcjz, ztypbz1, ztypbz2, ztypbz3, zvolLev, zquantity, unit, zioZczt, profitCtr,
						zlrzx, coArea, zzcms, zioZxmlx, capitDate, zdeakt, assetClas, zxlh, zinvnr, zi0Zzc1, zi0Zzc2,
						zioKostl, zkostlv, zioRaumn, zzzph, zzkostl, zioZzc06, zioZzc07, zioOrd41, zord44, zgdlgrp,
						zzcly, zioUmwkz, zsfdg, zioHerst, ztypbz, zPosid, zpost11, zfiamt, zioStadt, zfwcqzh, zioEqktx,
						zioTxt04, zioEqart, zpmsqz, zioInbdt, zioZccrq, zzzs, zioHerld, zioMapar, ztxz012, zioSerge,
						zioSwerk, zioStort, zioBeber, zioAbckz, zioEqfnr, zioZzc02, zProjk, zwbsnm, zioIwerk, zioIngrp,
						zioVaplz, zioTplnr, zioHequi, zioTidnr, zioSb010, zioSb001, zioSb002, zioSb004, zioSb005,
						zioSb006, zioSb003, zioSb007, zioSb008, zlenunt, zioSb009, zcapunt, zioSb011, zioUmlgo,
						zioGplab, zioPosid, zlyrkrq, zlyckrq, zpost1, zioCusre, zbfyy, zioZsb13, zioZsb12, recordmode,
						dataVersion));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * @return
	 */
	public static List<MidPmsItem> getAllMidPmsItem(String tableName) {
		List<MidPmsItem> list = new ArrayList<MidPmsItem>();
		try {
			Connection conn = null;
			conn = DbUtil.getConnection();
			// 创建预编译语句对象，一般都是用这个而不用Statement
			PreparedStatement pre = null;
			// 创建一个结果集对象
			ResultSet result = null;

			String sql = "select * from " + tableName;
			pre = conn.prepareStatement(sql);// 实例化预编译语句
			result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String midPmsItemId = null;
			String version = null;
			String sbbm = null;
			String orgName = null;
			String dvPmsAssetClassId = null;
			String zcDl = null;
			String zcZl = null;
			String zcXl = null;
			String voltageLevel = null;
			Date calYear = null;
			String qfzd = null;
			String jkzt = null;
			String yxzt = null;
			String ywdw = null;
			String zckbm = null;
			Double zcyz = null;
			Date zjtyrq = null;
			String zcxz = null;
			Double sl = null;
			Double sl1 = null;
			Double sl2 = null;
			Double sl3 = null;
			String jldw = null;
			String zzsmc = null;
			String ssxlbdz = null;
			String sbxh = null;
			Integer tynf = null;
			String nnd = null;
			Date tyrq = null;
			Integer nn = null;
			Date ccrq = null;
			String isMatched = null;

			System.out.println("Ready in loop!");
			int i = 1;
			Runtime run = Runtime.getRuntime();
			long maxMem = run.maxMemory() / 1024 / 1024;
			long freeMem = run.freeMemory() / 1024 / 1024;
			long totalMem = run.totalMemory();
			long usedMem = maxMem - freeMem;
			while (result.next()) {

				maxMem = run.maxMemory() / 1024 / 1024;
				freeMem = run.freeMemory() / 1024 / 1024;
				totalMem = run.totalMemory();
				usedMem = maxMem - freeMem;
				// System.out.println("Add!");
				System.out.println("i=" + (i++) + ",usedMemPercent=" + new Double(usedMem / maxMem) + ",maxMem="
						+ (maxMem) + ",freeMem=" + (freeMem) + ",usedMem=" + (usedMem) + ",totalMem=" + (totalMem));

				try {
					midPmsItemId = result.getString("MID_PMS_ITEM_ID");
				} catch (SQLException e) {
					try {
						midPmsItemId = result.getString("MID_PMS_UNMATCHED_ITEM_ID");
					} catch (SQLException e1) {
						midPmsItemId = result.getString("MID_PMS_MATCHED_ITEM_ID");
					}
				}
				version = result.getString("VERSION");
				sbbm = result.getString("SBBM");
				orgName = result.getString("ORG_NAME");
				dvPmsAssetClassId = result.getString("DV_PMS_ASSET_CLASS_ID");
				zcDl = result.getString("ZC_DL");
				zcZl = result.getString("ZC_ZL");
				zcXl = result.getString("ZC_XL");
				voltageLevel = result.getString("VOLTAGE_LEVEL");
				if (null != result.getString("CAL_YEAR")) {
					try {
						calYear = simpleDateFormat.parse(result.getString("CAL_YEAR"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				qfzd = result.getString("QFZD");
				jkzt = result.getString("JKZT");
				yxzt = result.getString("YXZT");
				ywdw = result.getString("YWDW");
				zckbm = result.getString("ZCKBM");
				if (null == result.getString("ZCYZ")) {
					zcyz = Double.parseDouble("0");
				} else {
					zcyz = Double.parseDouble(result.getString("ZCYZ"));
				}
				if (null != result.getString("ZJTYRQ")) {
					try {
						zjtyrq = simpleDateFormat.parse(result.getString("ZJTYRQ"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				zcxz = result.getString("ZCXZ");
				if (null == result.getString("SL")) {
					sl = Double.parseDouble("0");
				} else {
					sl = Double.parseDouble(result.getString("SL"));
				}
				// System.out.println("result.getString('SL1')="+result.getString("SL1"));
				if (null == result.getString("SL1")) {
					sl1 = Double.parseDouble("0");
				} else {
					sl1 = Double.parseDouble(result.getString("SL1"));
				}
				if (null == result.getString("SL2")) {
					sl2 = Double.parseDouble("0");
				} else {
					sl2 = Double.parseDouble(result.getString("SL2"));
				}
				if (null == result.getString("SL3")) {
					sl3 = Double.parseDouble("0");
				} else {
					sl3 = Double.parseDouble(result.getString("SL3"));
				}
				// sl= result.getString("SL");
				// sl1= result.getString("SL1");
				// sl2= result.getString("SL2");
				// sl3= result.getString("SL3");
				jldw = result.getString("JLDW");
				zzsmc = result.getString("ZZSMC");
				ssxlbdz = result.getString("SSXLBDZ");
				sbxh = result.getString("SBXH");
				// System.out.println("result.getString('TYNF')="+result.getString("TYNF"));
				if (null == result.getString("TYNF")) {
					tynf = new Integer("0");
				} else {
					tynf = new Integer(result.getString("TYNF"));
				}
				// tynf= result.getString("TYNF");
				nnd = result.getString("NND");
				if (null != result.getString("TYRQ")) {
					try {
						tyrq = simpleDateFormat.parse(result.getString("TYRQ"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				// tyrq= result.getString("TYRQ");
				if (null == result.getString("NN")) {
					nn = new Integer("0");
				} else {
					nn = new Integer(result.getString("NN"));
				}
				// nn= result.getString("NN");
				if (null != result.getString("CCRQ")) {
					try {
						ccrq = simpleDateFormat.parse(result.getString("CCRQ"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				// ccrq= result.getString("CCRQ");
				isMatched = result.getString("IS_MATCHED");

				list.add(new MidPmsItem(midPmsItemId, version, sbbm, orgName, dvPmsAssetClassId, zcDl, zcZl, zcXl,
						voltageLevel, calYear, qfzd, jkzt, yxzt, ywdw, zckbm, zcyz, zjtyrq, zcxz, sl, sl1, sl2, sl3,
						jldw, zzsmc, ssxlbdz, sbxh, tynf, nnd, tyrq, nn, ccrq, isMatched));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 用于写入xls的表头
	 * 
	 * @param conn                数据库连接
	 * @param book                导出目标文件
	 * @param tableName           需要导出的表的名称
	 * @param columnNameOrComment 取值为1时写入字段名，不为1时写入字段的备注名
	 * @return
	 */
	public static boolean writeHead(Connection conn, WritableWorkbook book, String tableName, int columnNameOrComment) {
		// Date now = new Date();
		// SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-ddHHmmss");
		// String nowdate = df.format(now);
		// 打开文件
		// WritableWorkbook book = null;

		// try {
		// book = Workbook.createWorkbook(new File("D:/temp/" + tableName + "_"
		// + nowdate + "_" + 0 + ".xls"));
		// } catch (IOException e1) {
		// TODO Auto-generated catch block
		// e1.printStackTrace();
		// }
		System.out.println(book);
		// System.out.println("D:/temp/" + tableName + nowdate + ".xls");
		// 生成名为"第一页"的工作表，参数0表示这是第一
		WritableSheet sheet = book.createSheet("第一页", 0);

		// 设置字体为宋体,16号字,加粗,颜色为黑色
		WritableFont font1 = new WritableFont(WritableFont.createFont("宋体"), 12, WritableFont.BOLD);
		try {
			font1.setColour(Colour.BLACK);
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WritableCellFormat format1 = new WritableCellFormat(font1);
		try {
			format1.setAlignment(jxl.format.Alignment.CENTRE);
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			format1.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// Connection conn = null;
		// conn = Dbutil.getConnection();
		// 创建预编译语句对象，一般都是用这个而不用Statement
		PreparedStatement pre = null;
		// 创建一个结果集对象
		ResultSet result = null;

		String sql = "SELECT B.COLUMN_ID COLUMN_ID,B.COLUMN_NAME COLUMN_NAME,B.DATA_TYPE DATA_TYPE,"
				+ "B.DATA_LENGTH DATA_LENGTH,B.DATA_PRECISION DATA_PRECISION,B.DATA_SCALE DATA_SCALE,"
				+ "A.COMMENTS COLUMN_COMMENT  FROM USER_COL_COMMENTS A  INNER JOIN USER_TAB_COLUMNS B"
				+ " ON A.COLUMN_NAME=B.COLUMN_NAME WHERE B.TABLE_NAME= '" + tableName + "' ORDER BY B.COLUMN_ID";
		System.out.println("sqlStr=" + sql);
		try {
			pre = conn.prepareStatement(sql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} // 实例化预编译语句
		try {
			result = pre.executeQuery();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} // 执行查询，注意括号中不需要再加参数

		Integer columnId = null;
		String columnName = null;
		String dataType = null;
		Integer dataLength = null;
		Integer dataPrecision = null;
		Integer dataScale = null;
		String columnComment = null;
		List<TableColumnProperty> list = new ArrayList<TableColumnProperty>();
		try {
			while (result.next()) {
				if (null != result.getString("COLUMN_ID")) {
					columnId = new Integer(result.getString("COLUMN_ID"));
				}
				columnName = result.getString("COLUMN_NAME");
				dataType = result.getString("DATA_TYPE");
				if (null != result.getString("DATA_LENGTH")) {
					dataLength = new Integer(result.getString("DATA_LENGTH"));
				}
				if (null != result.getString("DATA_PRECISION")) {
					dataPrecision = new Integer(result.getString("DATA_PRECISION"));
				}
				if (null != result.getString("DATA_SCALE")) {
					dataScale = new Integer(result.getString("DATA_SCALE"));
				}
				columnComment = result.getString("COLUMN_COMMENT");

				list.add(new TableColumnProperty(columnId, columnName, dataType, dataLength, dataPrecision, dataScale,
						columnComment));
			}
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (int i = 0; i < list.size(); i++) {
			Label label = null;
			if (columnNameOrComment == 1) {
				label = new Label(list.get(i).getColumnId() - 1, 0, list.get(i).getColumnName(), format1);
			} else {
				label = new Label(list.get(i).getColumnId() - 1, 0, list.get(i).getColumnComment(), format1);
			}
			try {
				sheet.addCell(label);
			} catch (RowsExceededException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			book.write();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} /*
			 * try { book.close(); } catch (WriteException e) { // TODO Auto-generated catch
			 * block e.printStackTrace(); } catch (IOException e) { // TODO Auto-generated
			 * catch block e.printStackTrace(); }
			 */
		return true;
	}

	public static boolean writeZfiSwzcIntoXls(
			List<TableColumnProperty> headList, 
			String tableName,
			List<ZfiSwzc2019> list, 
			int recordQuantity, 
			int columnNameOrComment)
			throws RowsExceededException, WriteException {
		Date now = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-ddHHmmss");
		String nowdate = df.format(now);
		// 打开文件
		WritableWorkbook book = null;

		try {
			book = Workbook.createWorkbook(new File("D:/temp/" + tableName + "_" + nowdate + "_" + 0 + ".xls"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(book);
		System.out.println("D:/temp/" + tableName + nowdate + ".xls");
		// 生成名为"第一页"的工作表，参数0表示这是第一
		WritableSheet sheet = book.createSheet("Sheet1", 0);

		// 设置字体为宋体,16号字,加粗,颜色为黑色
		WritableFont font1 = new WritableFont(WritableFont.createFont("宋体"), 12, WritableFont.BOLD);
		try {
			font1.setColour(Colour.BLACK);
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WritableCellFormat format1 = new WritableCellFormat(font1);
		try {
			format1.setAlignment(jxl.format.Alignment.CENTRE);
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			format1.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i = 0; i < headList.size(); i++) {
			Label label = null;
			if (columnNameOrComment == 1) {
				label = new Label(headList.get(i).getColumnId() - 1, 0, headList.get(i).getColumnName(), format1);
			} else {
				label = new Label(headList.get(i).getColumnId() - 1, 0, headList.get(i).getColumnComment(), format1);
			}
			try {
				sheet.addCell(label);
			} catch (RowsExceededException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// writeHead(conn, book, tableName, 1);
		sheet = book.getSheet("Sheet1");
		for (int i = 0; i < list.size(); i++) {
			int j = i / recordQuantity;

			// System.out.println("i=" + i);
			// System.out.println("(i % 65534) == 0 && i != 0)="+((i %
			// 65534) == 0 && i != 0));
			if ((i % recordQuantity) == 0 && i != 0) {
				// 写入数据并关闭文件
				// System.out.println("I'm Here!");
				try {
					book.write();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					book.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				df = new SimpleDateFormat("yyyy-MM-ddHHmmss");
				now = new Date();
				nowdate = df.format(now);
				// System.out.println("D:/temp/" + tableName + nowdate +j+
				// ".xls");
				try {
					book = Workbook.createWorkbook(new File("D:/temp/" + tableName + "_" + nowdate + "_" + j + ".xls"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// System.out.println("D:/temp/" + tableName + nowdate +j+
				// ".xls");

				df = new SimpleDateFormat("yyyy-MM-dd");
				sheet = book.createSheet("Sheet1", 0);

				for (int headListi = 0; headListi < headList.size(); headListi++) {
					Label label = null;
					if (columnNameOrComment == 1) {
						label = new Label(headList.get(headListi).getColumnId() - 1, 0,
								headList.get(headListi).getColumnName(), format1);
					} else {
						label = new Label(headList.get(headListi).getColumnId() - 1, 0,
								headList.get(headListi).getColumnComment(), format1);
					}
					try {
						sheet.addCell(label);
					} catch (RowsExceededException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (WriteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				// writeHead(conn, book, tableName, 1);
				sheet = book.getSheet("Sheet1");
				df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				// break;
			}
			// System.out.println("j=" + j);
			int recordQuantityTimes = j * recordQuantity;

			Label labelV0 = new Label(0, i + 1 - recordQuantityTimes, list.get(i).getAreaName());
			Label labelV1 = new Label(1, i + 1 - recordQuantityTimes, list.get(i).getZfiSwzc2019Id());
			Label labelV2 = new Label(2, i + 1 - recordQuantityTimes, list.get(i).getVersion());
			Label labelV3 = new Label(3, i + 1 - recordQuantityTimes, df.format(list.get(i).getCalYear()).toString());
			Label labelV4 = new Label(4, i + 1 - recordQuantityTimes, list.get(i).getCalyear().toString());
			Label labelV5 = new Label(5, i + 1 - recordQuantityTimes, list.get(i).getCompCode());
			Label labelV6 = new Label(6, i + 1 - recordQuantityTimes, list.get(i).getAssetMain());
			Label labelV7 = new Label(7, i + 1 - recordQuantityTimes, list.get(i).getAsset());
			Label labelV8 = new Label(8, i + 1 - recordQuantityTimes, list.get(i).getEqunr());
			Label labelV9 = new Label(9, i + 1 - recordQuantityTimes, list.get(i).getCurrency());
			Label labelV10 = new Label(10, i + 1 - recordQuantityTimes, list.get(i).getZpmzcyz().toString());
			Label labelV11 = new Label(11, i + 1 - recordQuantityTimes, list.get(i).getZpmzcjz().toString());
			Label labelV12 = new Label(12, i + 1 - recordQuantityTimes, list.get(i).getZtypbz1());
			Label labelV13 = new Label(13, i + 1 - recordQuantityTimes, list.get(i).getZtypbz2());
			Label labelV14 = new Label(14, i + 1 - recordQuantityTimes, list.get(i).getZtypbz3());
			Label labelV15 = new Label(15, i + 1 - recordQuantityTimes, list.get(i).getZvolLev());
			Label labelV16 = new Label(16, i + 1 - recordQuantityTimes, list.get(i).getZquantity().toString());
			Label labelV17 = new Label(17, i + 1 - recordQuantityTimes, list.get(i).getUnit());
			Label labelV18 = new Label(18, i + 1 - recordQuantityTimes, list.get(i).getZioZczt());
			Label labelV19 = new Label(19, i + 1 - recordQuantityTimes, list.get(i).getProfitCtr());
			Label labelV20 = new Label(20, i + 1 - recordQuantityTimes, list.get(i).getZlrzx());
			Label labelV21 = new Label(21, i + 1 - recordQuantityTimes, list.get(i).getCoArea());
			Label labelV22 = new Label(22, i + 1 - recordQuantityTimes, list.get(i).getZzcms());
			Label labelV23 = new Label(23, i + 1 - recordQuantityTimes, list.get(i).getZioZxmlx());
			Label labelV24 = new Label(24, i + 1 - recordQuantityTimes, list.get(i).getAktiv());
			Label labelV25 = new Label(25, i + 1 - recordQuantityTimes, list.get(i).getDeakt());
			Label labelV26 = new Label(26, i + 1 - recordQuantityTimes, list.get(i).getAnlkl());
			Label labelV27 = new Label(27, i + 1 - recordQuantityTimes, list.get(i).getSernr());
			Label labelV28 = new Label(28, i + 1 - recordQuantityTimes, list.get(i).getInvnr());
			Label labelV29 = new Label(29, i + 1 - recordQuantityTimes, list.get(i).getZzc001());
			Label labelV30 = new Label(30, i + 1 - recordQuantityTimes, list.get(i).getZzc002());
			Label labelV31 = new Label(31, i + 1 - recordQuantityTimes, list.get(i).getKostl());
			Label labelV32 = new Label(32, i + 1 - recordQuantityTimes, list.get(i).getKostlv());
			Label labelV33 = new Label(33, i + 1 - recordQuantityTimes, list.get(i).getRaumn());
			Label labelV34 = new Label(34, i + 1 - recordQuantityTimes, list.get(i).getKfzkz());
			Label labelV35 = new Label(35, i + 1 - recordQuantityTimes, list.get(i).getZzas1());
			Label labelV36 = new Label(36, i + 1 - recordQuantityTimes, list.get(i).getZzc006());
			Label labelV37 = new Label(37, i + 1 - recordQuantityTimes, list.get(i).getZzc007());
			Label labelV38 = new Label(38, i + 1 - recordQuantityTimes, list.get(i).getOrd41());
			Label labelV39 = new Label(39, i + 1 - recordQuantityTimes, list.get(i).getOrd44());
			Label labelV41 = new Label(40, i + 1 - recordQuantityTimes, list.get(i).getGdlgrp());
			Label labelV40 = new Label(41, i + 1 - recordQuantityTimes, list.get(i).getIzwek());
			Label labelV42 = new Label(42, i + 1 - recordQuantityTimes, list.get(i).getUmwkz());
			Label labelV43 = new Label(43, i + 1 - recordQuantityTimes, list.get(i).getAnlue());
			Label labelV44 = new Label(44, i + 1 - recordQuantityTimes, list.get(i).getHerst());
			Label labelV45 = new Label(45, i + 1 - recordQuantityTimes, list.get(i).getTypbz());
			Label labelV46 = new Label(46, i + 1 - recordQuantityTimes, list.get(i).getZkpwbs());
			Label labelV47 = new Label(47, i + 1 - recordQuantityTimes, list.get(i).getZkpwbsms());
			Label labelV48 = new Label(48, i + 1 - recordQuantityTimes, list.get(i).getFiamt());
			Label labelV49 = new Label(49, i + 1 - recordQuantityTimes, list.get(i).getStadt());
			Label labelV50 = new Label(50, i + 1 - recordQuantityTimes, list.get(i).getZfwcqzh());
			Label labelV51 = new Label(51, i + 1 - recordQuantityTimes, list.get(i).getEqktx());
			Label labelV52 = new Label(52, i + 1 - recordQuantityTimes, list.get(i).getTxt04());
			Label labelV53 = new Label(53, i + 1 - recordQuantityTimes, list.get(i).getEqart());
			Label labelV54 = new Label(54, i + 1 - recordQuantityTimes, list.get(i).getBegru());
			Label labelV55 = new Label(55, i + 1 - recordQuantityTimes, list.get(i).getInbdt());
			Label labelV56 = new Label(56, i + 1 - recordQuantityTimes, list.get(i).getZccrq());
			Label labelV57 = new Label(57, i + 1 - recordQuantityTimes, list.get(i).getZherst());
			Label labelV58 = new Label(58, i + 1 - recordQuantityTimes, list.get(i).getHerld());
			Label labelV59 = new Label(59, i + 1 - recordQuantityTimes, list.get(i).getMapar());
			Label labelV60 = new Label(60, i + 1 - recordQuantityTimes, list.get(i).getZtypbz());
			Label labelV61 = new Label(61, i + 1 - recordQuantityTimes, list.get(i).getSerge());
			Label labelV62 = new Label(62, i + 1 - recordQuantityTimes, list.get(i).getSwerk());
			Label labelV63 = new Label(63, i + 1 - recordQuantityTimes, list.get(i).getStort());
			Label labelV64 = new Label(64, i + 1 - recordQuantityTimes, list.get(i).getBeber());
			Label labelV65 = new Label(65, i + 1 - recordQuantityTimes, list.get(i).getAbckz());
			Label labelV66 = new Label(66, i + 1 - recordQuantityTimes, list.get(i).getEqfnr());
			Label labelV67 = new Label(67, i + 1 - recordQuantityTimes, list.get(i).getZkostl());
			Label labelV68 = new Label(68, i + 1 - recordQuantityTimes, list.get(i).getZsbwbs());
			Label labelV69 = new Label(69, i + 1 - recordQuantityTimes, list.get(i).getZsbwbsms());
			Label labelV70 = new Label(70, i + 1 - recordQuantityTimes, list.get(i).getIwerk());
			Label labelV71 = new Label(71, i + 1 - recordQuantityTimes, list.get(i).getIngrp());
			Label labelV72 = new Label(72, i + 1 - recordQuantityTimes, list.get(i).getGewrk());
			Label labelV73 = new Label(73, i + 1 - recordQuantityTimes, list.get(i).getTplnr());
			Label labelV74 = new Label(74, i + 1 - recordQuantityTimes, list.get(i).getHequi());
			Label labelV75 = new Label(75, i + 1 - recordQuantityTimes, list.get(i).getTidnr());
			Label labelV76 = new Label(76, i + 1 - recordQuantityTimes, list.get(i).getZsb010());
			Label labelV77 = new Label(77, i + 1 - recordQuantityTimes, list.get(i).getZsb001());
			Label labelV78 = new Label(78, i + 1 - recordQuantityTimes, list.get(i).getZsb002());
			Label labelV79 = new Label(79, i + 1 - recordQuantityTimes, list.get(i).getZsb004());
			Label labelV80 = new Label(80, i + 1 - recordQuantityTimes, list.get(i).getZsb005());
			Label labelV81 = new Label(81, i + 1 - recordQuantityTimes, list.get(i).getZsb006());
			Label labelV82 = new Label(82, i + 1 - recordQuantityTimes, list.get(i).getZsb003());
			Label labelV83 = new Label(83, i + 1 - recordQuantityTimes, list.get(i).getZsb007());
			Label labelV84 = new Label(84, i + 1 - recordQuantityTimes, list.get(i).getZsb008());
			Label labelV85 = new Label(85, i + 1 - recordQuantityTimes, list.get(i).getZlenunt());
			Label labelV86 = new Label(86, i + 1 - recordQuantityTimes, list.get(i).getZsb009());
			Label labelV87 = new Label(87, i + 1 - recordQuantityTimes, list.get(i).getZcapunt());
			Label labelV88 = new Label(88, i + 1 - recordQuantityTimes, list.get(i).getZsb011());
			Label labelV89 = new Label(89, i + 1 - recordQuantityTimes, list.get(i).getZeq003());
			Label labelV90 = new Label(90, i + 1 - recordQuantityTimes, list.get(i).getZeq001());
			Label labelV91 = new Label(91, i + 1 - recordQuantityTimes, list.get(i).getZeq002());
			Label labelV92 = new Label(92, i + 1 - recordQuantityTimes, list.get(i).getZlyrkrq());
			Label labelV93 = new Label(93, i + 1 - recordQuantityTimes, list.get(i).getZlyckrq());
			Label labelV94 = new Label(94, i + 1 - recordQuantityTimes, list.get(i).getZbfjzrq());
			Label labelV95 = new Label(95, i + 1 - recordQuantityTimes, list.get(i).getZbfxmbm());
			Label labelV96 = new Label(96, i + 1 - recordQuantityTimes, list.get(i).getZbfxmms());
			Label labelV97 = new Label(97, i + 1 - recordQuantityTimes, list.get(i).getZbfyydm());
			Label labelV98 = new Label(98, i + 1 - recordQuantityTimes, list.get(i).getZbfyywb());
			Label labelV99 = new Label(99, i + 1 - recordQuantityTimes, list.get(i).getCdate());
			Label labelV100 = new Label(100, i + 1 - recordQuantityTimes, list.get(i).getCtime());
			Label labelV101 = new Label(101, i + 1 - recordQuantityTimes, list.get(i).getCname());
			Label labelV102 = new Label(102, i + 1 - recordQuantityTimes, list.get(i).getStext4());
			Label labelV103 = new Label(103, i + 1 - recordQuantityTimes, list.get(i).getZtypbz1t());
			Label labelV104 = new Label(104, i + 1 - recordQuantityTimes, list.get(i).getZtypbz2t());
			Label labelV105 = new Label(105, i + 1 - recordQuantityTimes, list.get(i).getZtypbz3t());
			Label labelV106 = new Label(106, i + 1 - recordQuantityTimes, list.get(i).getAssetProperty());
			Label labelV107 = new Label(107, i + 1 - recordQuantityTimes, list.get(i).getPropertyCode());
			Label labelV108 = new Label(108, i + 1 - recordQuantityTimes, list.get(i).getAssetId());
			Label labelV109 = new Label(109, i + 1 - recordQuantityTimes, list.get(i).getDataSourceFile());

			// System.out.println("list.get(i).getPropertyCode()=" +
			// list.get(i).getPropertyCode());
			// System.out.println("getLineStationName");
			// System.out.println("i=" + i);

			sheet.addCell(labelV0);
			sheet.addCell(labelV1);
			sheet.addCell(labelV2);
			sheet.addCell(labelV3);
			sheet.addCell(labelV4);
			sheet.addCell(labelV5);
			sheet.addCell(labelV6);
			sheet.addCell(labelV7);
			sheet.addCell(labelV8);
			sheet.addCell(labelV9);
			sheet.addCell(labelV10);
			sheet.addCell(labelV11);
			sheet.addCell(labelV12);
			sheet.addCell(labelV13);
			sheet.addCell(labelV14);
			sheet.addCell(labelV15);
			sheet.addCell(labelV16);
			sheet.addCell(labelV17);
			sheet.addCell(labelV18);
			sheet.addCell(labelV19);
			sheet.addCell(labelV20);
			sheet.addCell(labelV21);
			sheet.addCell(labelV22);
			sheet.addCell(labelV23);
			sheet.addCell(labelV24);
			sheet.addCell(labelV25);
			sheet.addCell(labelV26);
			sheet.addCell(labelV27);
			sheet.addCell(labelV28);
			sheet.addCell(labelV29);
			sheet.addCell(labelV30);
			sheet.addCell(labelV31);
			sheet.addCell(labelV32);
			sheet.addCell(labelV33);
			sheet.addCell(labelV34);
			sheet.addCell(labelV35);
			sheet.addCell(labelV36);
			sheet.addCell(labelV37);
			sheet.addCell(labelV38);
			sheet.addCell(labelV39);
			sheet.addCell(labelV40);
			sheet.addCell(labelV41);
			sheet.addCell(labelV42);
			sheet.addCell(labelV43);
			sheet.addCell(labelV44);
			sheet.addCell(labelV45);
			sheet.addCell(labelV46);
			sheet.addCell(labelV47);
			sheet.addCell(labelV48);
			sheet.addCell(labelV49);
			sheet.addCell(labelV50);
			sheet.addCell(labelV51);
			sheet.addCell(labelV52);
			sheet.addCell(labelV53);
			sheet.addCell(labelV54);
			sheet.addCell(labelV55);
			sheet.addCell(labelV56);
			sheet.addCell(labelV57);
			sheet.addCell(labelV58);
			sheet.addCell(labelV59);
			sheet.addCell(labelV60);
			sheet.addCell(labelV61);
			sheet.addCell(labelV62);
			sheet.addCell(labelV63);
			sheet.addCell(labelV64);
			sheet.addCell(labelV65);
			sheet.addCell(labelV66);
			sheet.addCell(labelV67);
			sheet.addCell(labelV68);
			sheet.addCell(labelV69);
			sheet.addCell(labelV70);
			sheet.addCell(labelV71);
			sheet.addCell(labelV72);
			sheet.addCell(labelV73);
			sheet.addCell(labelV74);
			sheet.addCell(labelV75);
			sheet.addCell(labelV76);
			sheet.addCell(labelV77);
			sheet.addCell(labelV78);
			sheet.addCell(labelV79);
			sheet.addCell(labelV80);
			sheet.addCell(labelV81);
			sheet.addCell(labelV82);
			sheet.addCell(labelV83);
			sheet.addCell(labelV84);
			sheet.addCell(labelV85);
			sheet.addCell(labelV86);
			sheet.addCell(labelV87);
			sheet.addCell(labelV88);
			sheet.addCell(labelV89);
			sheet.addCell(labelV90);
			sheet.addCell(labelV91);
			sheet.addCell(labelV92);
			sheet.addCell(labelV93);
			sheet.addCell(labelV94);
			sheet.addCell(labelV95);
			sheet.addCell(labelV96);
			sheet.addCell(labelV97);
			sheet.addCell(labelV98);
			sheet.addCell(labelV99);
			sheet.addCell(labelV100);
			sheet.addCell(labelV101);
			sheet.addCell(labelV102);
			sheet.addCell(labelV103);
			sheet.addCell(labelV104);
			sheet.addCell(labelV105);
			sheet.addCell(labelV106);
			sheet.addCell(labelV107);
			sheet.addCell(labelV108);
			sheet.addCell(labelV109);

			System.out.println("i=" + (i + 1));
		}
		System.out.println(sheet.toString());
		// }

		// 写入数据并关闭文件
		try {
			book.write();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			book.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("创建文件成功!");
		now = new Date();
		nowdate = df.format(now);
		System.out.println("Now time is :" + nowdate);

		return true;
	}

	public static boolean writeRsTransOverhaMargCost110POIXLSXString(List<TableColumnProperty> headList,
			String tableName, List<List<YTableCellString>> list, int recordQuantity, int columnNameOrComment)
			throws RowsExceededException, WriteException {
		Date now = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-ddHHmmss");
		String nowdate = df.format(now);
		// 打开文件
		WritableWorkbook book = null;

		System.out.println("D:/temp/" + tableName + nowdate + ".xlsx");

		XSSFWorkbook wb = new XSSFWorkbook();
		// 建立新的sheet对象（excel的表单）
		XSSFSheet sheet = wb.createSheet("sheet1");
		// 生成名为"第一页"的工作表，参数0表示这是第一
		// WritableSheet sheet = book.createSheet("Sheet1", 0);

		for (int i = 0; i < headList.size(); i++) {
			sheet.setColumnWidth((short) i, (short) 2000);
		}

		// 在sheet里创建第一行
		XSSFRow row0 = sheet.createRow(0);
		// 设置行高
		row0.setHeight((short) ((short) 36 * 20));

		for (int i = 0; i < headList.size(); i++) {
			// 创建单元格
			XSSFCell cellTitle = row0.createCell(i);
			// 设置单元格样式
			// HSSFCellStyle styleTitle = creatStyle(wb, "黑体", 20,
			// HSSFCellStyle.ALIGN_CENTER,false,true);
			// cellTitle.setCellStyle(styleTitle);
			// 设置单元格内容
			cellTitle.setCellValue(headList.get(i).getColumnName());
		}

		for (int i = 0; i < list.size(); i++) {
			int j = i / recordQuantity;

			if ((i % recordQuantity) == 0 && i != 0) {
				String filePath = "D:/temp/" + tableName + "_" + nowdate + "_" + 0 + ".xlsx";
				// 输出Excel文件
				FileOutputStream output;
				try {
					output = new FileOutputStream(filePath);
					wb.write(output);
					output.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				XSSFWorkbook newWork = new XSSFWorkbook();
				// 建立新的sheet对象（excel的表单）
				XSSFSheet newSheet = wb.createSheet("sheet1");
				// 生成名为"第一页"的工作表，参数0表示这是第一
				// WritableSheet sheet = book.createSheet("Sheet1", 0);

				for (int headi = 0; headi < headList.size(); headi++) {
					sheet.setColumnWidth((short) i, (short) 2400);
				}

				// 在sheet里创建第一行
				XSSFRow rowhead = sheet.createRow(0);
				// 设置行高
				row0.setHeight((short) ((short) 36 * 20));

				for (int headi = 0; headi < headList.size(); headi++) {
					// 创建单元格
					XSSFCell cellTitle = rowhead.createCell(i);
					// 设置单元格样式
					// HSSFCellStyle styleTitle = creatStyle(wb, "黑体", 20,
					// HSSFCellStyle.ALIGN_CENTER,false,true);
					// cellTitle.setCellStyle(styleTitle);
					// 设置单元格内容
					cellTitle.setCellValue(headList.get(i).getColumnName());
				}
				df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				// break;
			}
			// System.out.println("j=" + j);
			int recordQuantityTimes = j * recordQuantity;

			// System.out.println(" list.get(i).size()=" + list.get(i).size());
			// Label labelV6 = new Label(6, i + 1 - recordQuantityTimes,
			// list.get(i).getCurrency());

			// 在sheet里创建第一行
			XSSFRow xSSFRowI = sheet.createRow(i + 1);
			for (int cellI = 0; cellI < list.get(i).size(); cellI++) {

				for (int headI = 0; headI < headList.size(); headI++) {
					if ((list.get(i).get(cellI).getColumnName().trim())
							.equals((headList.get(headI).getColumnName()).trim())) {
						// 创建单元格
						XSSFCell cellElement = xSSFRowI.createCell(headI);
						// 设置单元格样式
						// HSSFCellStyle styleTitle = creatStyle(wb, "黑体", 20,
						// HSSFCellStyle.ALIGN_CENTER,false,true);
						// cellTitle.setCellStyle(styleTitle);
						// 设置单元格内容
						if (headList.get(headI).getDataType() == "Double") {
							cellElement.setCellValue(new Double(list.get(i).get(cellI).getCellValue()));
						} else if (headList.get(headI).getDataType().equals("NUMBER")) {
							cellElement.setCellValue(new Double(list.get(i).get(cellI).getCellValue()));
						} else if (headList.get(headI).getDataType().equals("NUMERIC")) {
							cellElement.setCellValue(new Double(list.get(i).get(cellI).getCellValue()));
							System.out
									.println("headList.get(headI).getDataType()=" + headList.get(headI).getDataType());
							System.out.println("cellElement.getStringCellValue()=" + cellElement.getStringCellValue()
									+ ",cellElement.getColumnIndex()=" + cellElement.getColumnIndex());
						} else {
							cellElement.setCellValue(list.get(i).get(cellI).getCellValue());
						}

						// if (list.get(i).get(cellI).getColumnName().matches("^XM[0-9]*XM[0-9]*")
						// || list.get(i).get(cellI).getColumnName().matches("^XT[0-9]*XT[0-9]*")) {
						// System.out.println("2I am here!");
						// System.out.println("list.get(i).size()=" + list.get(i).size() +
						// "list.size()=" + list.size()
						// + " cellI =" + cellI + ",i=" + i + ",recordQuantityTimes" +
						// recordQuantityTimes);
						// System.out.println("headList.get(headI).getColumnName()="
						// + headList.get(headI).getColumnName() + "
						// list.get(i).get(cellI).getColumnName()"
						// + list.get(i).get(cellI).getColumnName());
						// System.out.println(
						// "headList.get(headI).getColumnName()==list.get(i).get(cellI).getColumnName()="
						// + list.get(i).get(cellI).getColumnName()
						// .equals(headList.get(headI).getColumnName()));
						// System.out.println("cellElement.getStringCellValue()=" +
						// cellElement.getStringCellValue()
						// + ",cellElement.getColumnIndex()=" + cellElement.getColumnIndex() + ",headI="
						// + headI);
						// }

					}

				}
			}

			System.out.println("i=" + (i + 1));

		}

		String filePath = "D:/temp/" + tableName + "_" + nowdate + "_" + 0 + ".xlsx";
		// 输出Excel文件
		FileOutputStream output;
		try {
			output = new FileOutputStream(filePath);
			wb.write(output);
			output.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("创建文件成功!");
		now = new Date();
		nowdate = df.format(now);
		System.out.println("Now time is :" + nowdate);

		return true;
	}

	/**
	 * 创建excel表
	 */
	/*
	 * public static HSSFWorkbook CreateExcel(List<SchoolScore> list) throws
	 * IOException { //创建HSSFWorkbook对象(excel的文档对象)
	 * 
	 * HSSFWorkbook wb = new HSSFWorkbook();
	 * creatSheet(wb,Constant.EXCEL_SUBJECT_NAME_CHINESE,list); return wb; }
	 */

	public static boolean writeRsTransOverhaMargCost110POIXLSX(List<TableColumnProperty> headList, String tableName,
			List<List<YTableCell>> list, int recordQuantity, int columnNameOrComment)
			throws RowsExceededException, WriteException {
		Date now = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-ddHHmmss");
		String nowdate = df.format(now);
		// 打开文件
		WritableWorkbook book = null;

		System.out.println("D:/temp/" + tableName + nowdate + ".xlsx");

		XSSFWorkbook wb = new XSSFWorkbook();
		// 建立新的sheet对象（excel的表单）
		XSSFSheet sheet = wb.createSheet("sheet1");
		// 生成名为"第一页"的工作表，参数0表示这是第一
		// WritableSheet sheet = book.createSheet("Sheet1", 0);

		for (int i = 0; i < headList.size(); i++) {
			sheet.setColumnWidth((short) i, (short) 1000);
		}

		// 在sheet里创建第一行
		XSSFRow row0 = sheet.createRow(0);
		// 设置行高
		row0.setHeight((short) ((short) 36 * 20));

		for (int i = 0; i < headList.size(); i++) {
			// 创建单元格
			XSSFCell cellTitle = row0.createCell(i);
			// 设置单元格样式
			// HSSFCellStyle styleTitle = creatStyle(wb, "黑体", 20,
			// HSSFCellStyle.ALIGN_CENTER,false,true);
			// cellTitle.setCellStyle(styleTitle);
			// 设置单元格内容
			cellTitle.setCellValue(headList.get(i).getColumnName());
		}

		for (int i = 0; i < list.size(); i++) {
			int j = i / recordQuantity;

			if ((i % recordQuantity) == 0 && i != 0) {
				String filePath = "D:/temp/" + tableName + "_" + nowdate + "_" + 0 + ".xlsx";
				// 输出Excel文件
				FileOutputStream output;
				try {
					output = new FileOutputStream(filePath);
					wb.write(output);
					output.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				XSSFWorkbook newWork = new XSSFWorkbook();
				// 建立新的sheet对象（excel的表单）
				XSSFSheet newSheet = wb.createSheet("sheet1");
				// 生成名为"第一页"的工作表，参数0表示这是第一
				// WritableSheet sheet = book.createSheet("Sheet1", 0);

				for (int headi = 0; headi < headList.size(); headi++) {
					sheet.setColumnWidth((short) i, (short) 2400);
				}

				// 在sheet里创建第一行
				XSSFRow rowhead = sheet.createRow(0);
				// 设置行高
				row0.setHeight((short) ((short) 36 * 20));

				for (int headi = 0; headi < headList.size(); headi++) {
					// 创建单元格
					XSSFCell cellTitle = rowhead.createCell(i);
					// 设置单元格样式
					// HSSFCellStyle styleTitle = creatStyle(wb, "黑体", 20,
					// HSSFCellStyle.ALIGN_CENTER,false,true);
					// cellTitle.setCellStyle(styleTitle);
					// 设置单元格内容
					cellTitle.setCellValue(headList.get(i).getColumnName());
				}
				df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				// break;
			}
			// System.out.println("j=" + j);
			int recordQuantityTimes = j * recordQuantity;

			System.out.println(" list.get(i).size()=" + list.get(i).size());
			// Label labelV6 = new Label(6, i + 1 - recordQuantityTimes,
			// list.get(i).getCurrency());

			// 在sheet里创建第一行
			XSSFRow xSSFRowI = sheet.createRow(i + 1);
			for (int cellI = 0; cellI < list.get(i).size(); cellI++) {
				// for (int cellI = 0; cellI < 100; cellI++) {
				// for (int cellI = 0; cellI < headList.size()-4; cellI++) {

				for (int headI = 0; headI < headList.size(); headI++) {
					if (list.get(i).get(cellI).getColumnName().equals(headList.get(headI).getColumnName())) {
						// 创建单元格
						XSSFCell cellElement = xSSFRowI.createCell(headI);
						// 设置单元格样式
						// HSSFCellStyle styleTitle = creatStyle(wb, "黑体", 20,
						// HSSFCellStyle.ALIGN_CENTER,false,true);
						// cellTitle.setCellStyle(styleTitle);
						// 设置单元格内容
						cellElement.setCellValue(list.get(i).get(cellI).getCellValue());
						System.out.println("2I am here!");

						System.out.println("list.get(i).size()=" + list.get(i).size() + "list.size()=" + list.size()
								+ " cellI =" + cellI + ",i=" + i + ",recordQuantityTimes" + recordQuantityTimes);
						System.out.println("headList.get(headI).getColumnName()=" + headList.get(headI).getColumnName()
								+ " list.get(i).get(cellI).getColumnName()" + list.get(i).get(cellI).getColumnName());
						System.out.println(
								"headList.get(headI).getColumnName()==list.get(i).get(cellI).getColumnName()=" + list
										.get(i).get(cellI).getColumnName().equals(headList.get(headI).getColumnName()));
					}

				}
			}

			System.out.println("i=" + (i + 1));

		}

		String filePath = "D:/temp/" + tableName + "_" + nowdate + "_" + 0 + ".xlsx";
		// 输出Excel文件
		FileOutputStream output;
		try {
			output = new FileOutputStream(filePath);
			wb.write(output);
			output.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("创建文件成功!");
		now = new Date();
		nowdate = df.format(now);
		System.out.println("Now time is :" + nowdate);

		return true;
	}

	public static boolean writeRsTransOverhaMargCost110POIXLS(List<TableColumnProperty> headList, String tableName,
			List<List<YTableCell>> list, int recordQuantity, int columnNameOrComment)
			throws RowsExceededException, WriteException {
		Date now = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-ddHHmmss");
		String nowdate = df.format(now);
		// 打开文件
		WritableWorkbook book = null;

		System.out.println("D:/temp/" + tableName + nowdate + ".xls");

		HSSFWorkbook wb = new HSSFWorkbook();
		// 建立新的sheet对象（excel的表单）
		HSSFSheet sheet = wb.createSheet("sheet1");
		// 生成名为"第一页"的工作表，参数0表示这是第一
		// WritableSheet sheet = book.createSheet("Sheet1", 0);

		for (int i = 0; i < headList.size(); i++) {
			sheet.setColumnWidth((short) i, (short) 4800);
		}

		// 在sheet里创建第一行
		HSSFRow row0 = sheet.createRow(0);
		// 设置行高
		row0.setHeight((short) ((short) 36 * 20));

		for (int i = 0; i < headList.size(); i++) {
			// 创建单元格
			HSSFCell cellTitle = row0.createCell(i);
			// 设置单元格样式
			// HSSFCellStyle styleTitle = creatStyle(wb, "黑体", 20,
			// HSSFCellStyle.ALIGN_CENTER,false,true);
			// cellTitle.setCellStyle(styleTitle);
			// 设置单元格内容
			cellTitle.setCellValue(headList.get(i).getColumnName());
		}

		// writeHead(conn, book, tableName, 1);
		// sheet = book.getSheet("Sheet1");
		for (int i = 0; i < list.size(); i++) {
			int j = i / recordQuantity;

			// System.out.println("i=" + i);
			// System.out.println("(i % 65534) == 0 && i != 0)="+((i %
			// 65534) == 0 && i != 0));
			if ((i % recordQuantity) == 0 && i != 0) {
				String filePath = "D:/temp/" + tableName + "_" + nowdate + "_" + 0 + ".xls";
				// 输出Excel文件
				FileOutputStream output;
				try {
					output = new FileOutputStream(filePath);
					wb.write(output);
					output.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				HSSFWorkbook newWork = new HSSFWorkbook();
				// 建立新的sheet对象（excel的表单）
				HSSFSheet newSheet = wb.createSheet("sheet1");
				// 生成名为"第一页"的工作表，参数0表示这是第一
				// WritableSheet sheet = book.createSheet("Sheet1", 0);

				for (int headi = 0; headi < headList.size(); headi++) {
					sheet.setColumnWidth((short) i, (short) 4800);
				}

				// 在sheet里创建第一行
				HSSFRow rowhead = sheet.createRow(0);
				// 设置行高
				row0.setHeight((short) ((short) 36 * 20));

				for (int headi = 0; headi < headList.size(); headi++) {
					// 创建单元格
					HSSFCell cellTitle = rowhead.createCell(i);
					// 设置单元格样式
					// HSSFCellStyle styleTitle = creatStyle(wb, "黑体", 20,
					// HSSFCellStyle.ALIGN_CENTER,false,true);
					// cellTitle.setCellStyle(styleTitle);
					// 设置单元格内容
					cellTitle.setCellValue(headList.get(i).getColumnName());
				}
				df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				// break;
			}
			// System.out.println("j=" + j);
			int recordQuantityTimes = j * recordQuantity;

			System.out.println(" list.get(i).size()=" + list.get(i).size());
			// Label labelV6 = new Label(6, i + 1 - recordQuantityTimes,
			// list.get(i).getCurrency());

			// 在sheet里创建第一行
			HSSFRow rowI = sheet.createRow(i);
			for (int cellI = 0; cellI < list.get(i).size(); cellI++) {

				// 创建单元格
				HSSFCell cellElement = rowI.createCell(cellI);
				// 设置单元格样式
				// HSSFCellStyle styleTitle = creatStyle(wb, "黑体", 20,
				// HSSFCellStyle.ALIGN_CENTER,false,true);
				// cellTitle.setCellStyle(styleTitle);
				// 设置单元格内容
				cellElement.setCellValue(list.get(i).get(cellI).getCellValue());

				System.out.println("2I am here!");

				System.out.println("list.get(i).size()=" + list.get(i).size() + " cellI =" + cellI + ",i=" + i
						+ ",recordQuantityTimes" + recordQuantityTimes);
				/*
				 * Label label = null; label = new Label(cellI, i + 1 - recordQuantityTimes,
				 * list.get(i).get(cellI).toString()); try { sheet.addCell(label); } catch
				 * (RowsExceededException e) { // TODO Auto-generated catch block
				 * e.printStackTrace(); } catch (WriteException e) { // TODO Auto-generated
				 * catch block e.printStackTrace(); }
				 */
			}

			System.out.println("i=" + (i + 1));

		}

		String filePath = "D:/temp/" + tableName + "_" + nowdate + "_" + 0 + ".xls";
		// 输出Excel文件
		FileOutputStream output;
		try {
			output = new FileOutputStream(filePath);
			wb.write(output);
			output.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("创建文件成功!");
		now = new Date();
		nowdate = df.format(now);
		System.out.println("Now time is :" + nowdate);

		return true;
	}

	public static boolean writeRsTransOverhaMargCost110(List<TableColumnProperty> headList, String tableName,
			List<List<YTableCell>> list, int recordQuantity, int columnNameOrComment)
			throws RowsExceededException, WriteException {
		Date now = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-ddHHmmss");
		String nowdate = df.format(now);
		// 打开文件
		WritableWorkbook book = null;

		try {
			book = Workbook.createWorkbook(new File("D:/temp/" + tableName + "_" + nowdate + "_" + 0 + ".xls"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(book);
		System.out.println("D:/temp/" + tableName + nowdate + ".xls");
		// 生成名为"第一页"的工作表，参数0表示这是第一
		WritableSheet sheet = book.createSheet("Sheet1", 0);

		// 设置字体为宋体,16号字,加粗,颜色为黑色
		WritableFont font1 = new WritableFont(WritableFont.createFont("宋体"), 12, WritableFont.BOLD);
		try {
			font1.setColour(Colour.BLACK);
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WritableCellFormat format1 = new WritableCellFormat(font1);
		try {
			format1.setAlignment(jxl.format.Alignment.CENTRE);
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			format1.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i = 0; i < headList.size(); i++) {
			Label label = null;
			label = new Label(i, 0, headList.get(i).getColumnName(), format1);
			try {
				sheet.addCell(label);
			} catch (RowsExceededException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// writeHead(conn, book, tableName, 1);
		sheet = book.getSheet("Sheet1");
		for (int i = 0; i < list.size(); i++) {
			int j = i / recordQuantity;

			// System.out.println("i=" + i);
			// System.out.println("(i % 65534) == 0 && i != 0)="+((i %
			// 65534) == 0 && i != 0));
			if ((i % recordQuantity) == 0 && i != 0) {
				// 写入数据并关闭文件
				// System.out.println("I'm Here!");
				try {
					book.write();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					book.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				df = new SimpleDateFormat("yyyy-MM-ddHHmmss");
				now = new Date();
				nowdate = df.format(now);
				// System.out.println("D:/temp/" + tableName + nowdate +j+
				// ".xls");
				try {
					book = Workbook.createWorkbook(new File("D:/temp/" + tableName + "_" + nowdate + "_" + j + ".xls"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// System.out.println("D:/temp/" + tableName + nowdate +j+
				// ".xls");

				sheet = book.createSheet("Sheet1", 0);

				for (int headListi = 0; headListi < headList.size(); headListi++) {
					System.out.println("I am here!");
					Label label = null;
					label = new Label(headListi, 0, headList.get(headListi).getColumnName(), format1);
					try {
						sheet.addCell(label);
					} catch (RowsExceededException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (WriteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				// writeHead(conn, book, tableName, 1);
				sheet = book.getSheet("Sheet1");
				df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				// break;
			}
			// System.out.println("j=" + j);
			int recordQuantityTimes = j * recordQuantity;

			System.out.println(" list.get(i).size()=" + list.get(i).size());
			// Label labelV6 = new Label(6, i + 1 - recordQuantityTimes,
			// list.get(i).getCurrency());
			for (int cellI = 0; cellI < list.get(i).size(); cellI++) {

				System.out.println("2I am here!");

				System.out.println("list.get(i).size()=" + list.get(i).size() + " cellI =" + cellI + ",i=" + i
						+ ",recordQuantityTimes" + recordQuantityTimes);
				Label label = null;
				label = new Label(cellI, i + 1 - recordQuantityTimes, list.get(i).get(cellI).toString());
				try {
					sheet.addCell(label);
				} catch (RowsExceededException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (WriteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			System.out.println("i=" + (i + 1));

		}
		System.out.println(sheet.toString());
		// }

		// 写入数据并关闭文件
		try {
			book.write();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			book.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("创建文件成功!");
		now = new Date();
		nowdate = df.format(now);
		System.out.println("Now time is :" + nowdate);

		return true;
	}

	public static boolean writeMidPmsItemIntoXls(List<TableColumnProperty> headList, String tableName,
			List<MidPmsItem> list, int recordQuantity, int columnNameOrComment)
			throws RowsExceededException, WriteException {
		Date now = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-ddHHmmss");
		String nowdate = df.format(now);
		// 打开文件
		WritableWorkbook book = null;

		try {
			book = Workbook.createWorkbook(new File("D:/temp/" + tableName + "_" + nowdate + "_" + 0 + ".xls"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(book);
		System.out.println("D:/temp/" + tableName + nowdate + ".xls");
		// 生成名为"第一页"的工作表，参数0表示这是第一
		WritableSheet sheet = book.createSheet("Sheet1", 0);

		// 设置字体为宋体,16号字,加粗,颜色为黑色
		WritableFont font1 = new WritableFont(WritableFont.createFont("宋体"), 12, WritableFont.BOLD);
		try {
			font1.setColour(Colour.BLACK);
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WritableCellFormat format1 = new WritableCellFormat(font1);
		try {
			format1.setAlignment(jxl.format.Alignment.CENTRE);
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			format1.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i = 0; i < headList.size(); i++) {
			Label label = null;
			if (columnNameOrComment == 1) {
				label = new Label(headList.get(i).getColumnId() - 1, 0, headList.get(i).getColumnName(), format1);
			} else {
				label = new Label(headList.get(i).getColumnId() - 1, 0, headList.get(i).getColumnComment(), format1);
			}
			try {
				sheet.addCell(label);
			} catch (RowsExceededException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// writeHead(conn, book, tableName, 1);
		sheet = book.getSheet("Sheet1");
		for (int i = 0; i < list.size(); i++) {
			int j = i / recordQuantity;

			// System.out.println("i=" + i);
			// System.out.println("(i % 65534) == 0 && i != 0)="+((i %
			// 65534) == 0 && i != 0));
			if ((i % recordQuantity) == 0 && i != 0) {
				// 写入数据并关闭文件
				// System.out.println("I'm Here!");
				try {
					book.write();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					book.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				df = new SimpleDateFormat("yyyy-MM-ddHHmmss");
				now = new Date();
				nowdate = df.format(now);
				// System.out.println("D:/temp/" + tableName + nowdate +j+
				// ".xls");
				try {
					book = Workbook.createWorkbook(new File("D:/temp/" + tableName + "_" + nowdate + "_" + j + ".xls"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// System.out.println("D:/temp/" + tableName + nowdate +j+
				// ".xls");

				sheet = book.createSheet("Sheet1", 0);

				for (int headListi = 0; headListi < headList.size(); headListi++) {
					Label label = null;
					if (columnNameOrComment == 1) {
						label = new Label(headList.get(headListi).getColumnId() - 1, 0,
								headList.get(headListi).getColumnName(), format1);
					} else {
						label = new Label(headList.get(headListi).getColumnId() - 1, 0,
								headList.get(headListi).getColumnComment(), format1);
					}
					try {
						sheet.addCell(label);
					} catch (RowsExceededException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (WriteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				// writeHead(conn, book, tableName, 1);
				sheet = book.getSheet("Sheet1");
				df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				// break;
			}
			// System.out.println("j=" + j);
			int recordQuantityTimes = j * recordQuantity;
			Label labelV0 = new Label(0, i + 1 - recordQuantityTimes, list.get(i).getMidPmsItemId());
			Label labelV1 = new Label(1, i + 1 - recordQuantityTimes, list.get(i).getVersion());
			Label labelV2 = new Label(2, i + 1 - recordQuantityTimes, list.get(i).getSbbm());
			Label labelV3 = new Label(3, i + 1 - recordQuantityTimes, list.get(i).getOrgName());
			Label labelV4 = new Label(4, i + 1 - recordQuantityTimes, list.get(i).getDvPmsAssetClassId());
			Label labelV5 = new Label(5, i + 1 - recordQuantityTimes, list.get(i).getZcDl());
			Label labelV6 = new Label(6, i + 1 - recordQuantityTimes, list.get(i).getZcZl());
			Label labelV7 = new Label(7, i + 1 - recordQuantityTimes, list.get(i).getZcXl());
			Label labelV8 = new Label(8, i + 1 - recordQuantityTimes, list.get(i).getVoltageLevel());
			Label labelV9 = null;
			if (null != list.get(i).getCalYear()) {
				labelV9 = new Label(9, i + 1 - recordQuantityTimes, df.format(list.get(i).getCalYear()).toString());

			} else {
				labelV9 = new Label(9, i + 1 - recordQuantityTimes, new String(""));
			}

			Label labelV10 = new Label(10, i + 1 - recordQuantityTimes, list.get(i).getQfzd());
			Label labelV11 = new Label(11, i + 1 - recordQuantityTimes, list.get(i).getJkzt());
			Label labelV12 = new Label(12, i + 1 - recordQuantityTimes, list.get(i).getYxzt());
			Label labelV13 = new Label(13, i + 1 - recordQuantityTimes, list.get(i).getYwdw());
			Label labelV14 = new Label(14, i + 1 - recordQuantityTimes, list.get(i).getZckbm());
			Label labelV15 = null;
			if (null != list.get(i).getZcyz()) {
				labelV15 = new Label(15, i + 1 - recordQuantityTimes, list.get(i).getZcyz().toString());
			} else {
				labelV15 = new Label(15, i + 1 - recordQuantityTimes, new String(""));
			}
			Label labelV16 = null;
			if (null != list.get(i).getZjtyrq()) {
				labelV16 = new Label(16, i + 1 - recordQuantityTimes, df.format(list.get(i).getZjtyrq()).toString());

			} else {
				labelV16 = new Label(16, i + 1 - recordQuantityTimes, new String(""));
			}
			Label labelV17 = new Label(17, i + 1 - recordQuantityTimes, list.get(i).getZcxz());

			Label labelV18 = null;
			if (null != list.get(i).getSl()) {
				labelV18 = new Label(18, i + 1 - recordQuantityTimes, list.get(i).getSl().toString());
			} else {
				labelV18 = new Label(18, i + 1 - recordQuantityTimes, new String(""));
			}

			Label labelV19 = null;
			if (null != list.get(i).getSl1()) {
				labelV19 = new Label(19, i + 1 - recordQuantityTimes, list.get(i).getSl1().toString());
			} else {
				labelV19 = new Label(19, i + 1 - recordQuantityTimes, new String(""));
			}

			Label labelV20 = null;
			if (null != list.get(i).getSl2()) {
				labelV20 = new Label(20, i + 1 - recordQuantityTimes, list.get(i).getSl2().toString());
			} else {
				labelV20 = new Label(20, i + 1 - recordQuantityTimes, new String(""));
			}
			Label labelV21 = null;
			if (null != list.get(i).getSl3()) {
				labelV21 = new Label(21, i + 1 - recordQuantityTimes, list.get(i).getSl3().toString());
			} else {
				labelV21 = new Label(21, i + 1 - recordQuantityTimes, new String(""));
			}

			Label labelV22 = new Label(22, i + 1 - recordQuantityTimes, list.get(i).getJldw());
			Label labelV23 = new Label(23, i + 1 - recordQuantityTimes, list.get(i).getZzsmc());
			Label labelV24 = new Label(24, i + 1 - recordQuantityTimes, list.get(i).getSsxlbdz());
			Label labelV25 = new Label(25, i + 1 - recordQuantityTimes, list.get(i).getSbxh());

			Label labelV26 = null;
			if (null != list.get(i).getTynf()) {
				labelV26 = new Label(26, i + 1 - recordQuantityTimes, list.get(i).getTynf().toString());
			} else {
				labelV26 = new Label(26, i + 1 - recordQuantityTimes, new String(""));
			}

			Label labelV27 = new Label(27, i + 1 - recordQuantityTimes, list.get(i).getNnd());
			Label labelV28 = null;
			if (null != list.get(i).getTyrq()) {
				labelV28 = new Label(28, i + 1 - recordQuantityTimes, df.format(list.get(i).getTyrq()).toString());

			} else {
				labelV28 = new Label(28, i + 1 - recordQuantityTimes, new String(""));
			}
			Label labelV29 = new Label(29, i + 1 - recordQuantityTimes, list.get(i).getNn().toString());
			Label labelV30 = null;
			if (null != list.get(i).getCcrq()) {
				labelV30 = new Label(30, i + 1 - recordQuantityTimes, df.format(list.get(i).getCcrq()).toString());

			} else {
				labelV30 = new Label(30, i + 1 - recordQuantityTimes, new String(""));
			}

			Label labelV31 = new Label(31, i + 1 - recordQuantityTimes, list.get(i).getIsMatched());
			Label labelV32 = new Label(32, i + 1 - recordQuantityTimes, list.get(i).getEquipmentName());
			Label labelV33 = new Label(33, i + 1 - recordQuantityTimes, list.get(i).getAssetId());
			Label labelV34 = new Label(34, i + 1 - recordQuantityTimes, list.get(i).getEquipmentIncreaseMode());
			Label labelV35 = new Label(35, i + 1 - recordQuantityTimes, list.get(i).getLineProperty());
			Label labelV36 = new Label(36, i + 1 - recordQuantityTimes, list.get(i).getZcdl());
			Label labelV37 = new Label(37, i + 1 - recordQuantityTimes, list.get(i).getSblx());

			Label labelV38 = null;
			if (null != list.get(i).getDvDateValue()) {
				labelV38 = new Label(38, i + 1 - recordQuantityTimes,
						df.format(list.get(i).getDvDateValue()).toString());

			} else {
				labelV38 = new Label(38, i + 1 - recordQuantityTimes, new String(""));
			}

			// System.out.println("list.get(i).getPropertyCode()=" +
			// list.get(i).getPropertyCode());
			// System.out.println("getLineStationName");
			// System.out.println("i=" + i);

			sheet.addCell(labelV0);
			sheet.addCell(labelV1);
			sheet.addCell(labelV2);
			sheet.addCell(labelV3);
			sheet.addCell(labelV4);
			sheet.addCell(labelV5);
			sheet.addCell(labelV6);
			sheet.addCell(labelV7);
			sheet.addCell(labelV8);
			sheet.addCell(labelV9);
			sheet.addCell(labelV10);
			sheet.addCell(labelV11);
			sheet.addCell(labelV12);
			sheet.addCell(labelV13);
			sheet.addCell(labelV14);
			sheet.addCell(labelV15);
			sheet.addCell(labelV16);
			sheet.addCell(labelV17);
			sheet.addCell(labelV18);
			sheet.addCell(labelV19);
			sheet.addCell(labelV20);
			sheet.addCell(labelV21);
			sheet.addCell(labelV22);
			sheet.addCell(labelV23);
			sheet.addCell(labelV24);
			sheet.addCell(labelV25);
			sheet.addCell(labelV26);
			sheet.addCell(labelV27);
			sheet.addCell(labelV28);
			sheet.addCell(labelV29);
			sheet.addCell(labelV30);
			sheet.addCell(labelV31);
			sheet.addCell(labelV32);
			sheet.addCell(labelV33);
			sheet.addCell(labelV34);
			sheet.addCell(labelV35);
			sheet.addCell(labelV36);
			sheet.addCell(labelV37);
			sheet.addCell(labelV38);

			System.out.println("i=" + (i + 1));
		}
		System.out.println(sheet.toString());
		// }

		// 写入数据并关闭文件
		try {
			book.write();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			book.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("创建文件成功!");
		now = new Date();
		nowdate = df.format(now);
		System.out.println("Now time is :" + nowdate);

		return true;
	}

	public static boolean writeBicAzfiSwzcIntoXls(List<TableColumnProperty> headList, String tableName,
			List<BicAzfiSwzc> list, int recordQuantity, int columnNameOrComment)
			throws RowsExceededException, WriteException {
		Date now = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-ddHHmmss");
		String nowdate = df.format(now);
		// 打开文件
		WritableWorkbook book = null;

		try {
			book = Workbook.createWorkbook(new File("D:/temp/" + tableName + "_" + nowdate + "_" + 0 + ".xls"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(book);
		System.out.println("D:/temp/" + tableName + nowdate + ".xls");
		// 生成名为"第一页"的工作表，参数0表示这是第一
		WritableSheet sheet = book.createSheet("Sheet1", 0);

		// 设置字体为宋体,16号字,加粗,颜色为黑色
		WritableFont font1 = new WritableFont(WritableFont.createFont("宋体"), 12, WritableFont.BOLD);
		try {
			font1.setColour(Colour.BLACK);
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WritableCellFormat format1 = new WritableCellFormat(font1);
		try {
			format1.setAlignment(jxl.format.Alignment.CENTRE);
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			format1.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i = 0; i < headList.size(); i++) {
			Label label = null;
			if (columnNameOrComment == 1) {
				label = new Label(headList.get(i).getColumnId() - 1, 0, headList.get(i).getColumnName(), format1);
			} else {
				label = new Label(headList.get(i).getColumnId() - 1, 0, headList.get(i).getColumnComment(), format1);
			}
			try {
				sheet.addCell(label);
			} catch (RowsExceededException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// writeHead(conn, book, tableName, 1);
		sheet = book.getSheet("Sheet1");
		for (int i = 0; i < list.size(); i++) {
			int j = i / recordQuantity;

			// System.out.println("i=" + i);
			// System.out.println("(i % 65534) == 0 && i != 0)="+((i %
			// 65534) == 0 && i != 0));
			if ((i % recordQuantity) == 0 && i != 0) {
				// 写入数据并关闭文件
				// System.out.println("I'm Here!");
				try {
					book.write();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					book.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				df = new SimpleDateFormat("yyyy-MM-ddHHmmss");
				now = new Date();
				nowdate = df.format(now);
				// System.out.println("D:/temp/" + tableName + nowdate +j+
				// ".xls");
				try {
					book = Workbook.createWorkbook(new File("D:/temp/" + tableName + "_" + nowdate + "_" + j + ".xls"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// System.out.println("D:/temp/" + tableName + nowdate +j+
				// ".xls");

				sheet = book.createSheet("Sheet1", 0);

				for (int headListi = 0; headListi < headList.size(); headListi++) {
					Label label = null;
					if (columnNameOrComment == 1) {
						label = new Label(headList.get(headListi).getColumnId() - 1, 0,
								headList.get(headListi).getColumnName(), format1);
					} else {
						label = new Label(headList.get(headListi).getColumnId() - 1, 0,
								headList.get(headListi).getColumnComment(), format1);
					}
					try {
						sheet.addCell(label);
					} catch (RowsExceededException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (WriteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				// writeHead(conn, book, tableName, 1);
				sheet = book.getSheet("Sheet1");
				df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				// break;
			}
			// System.out.println("j=" + j);
			int recordQuantityTimes = j * recordQuantity;
			Label labelV0 = new Label(0, i + 1 - recordQuantityTimes, list.get(i).getBicAzfiSwzcId());
			Label labelV1 = new Label(1, i + 1 - recordQuantityTimes, list.get(i).getCalyear());
			Label labelV2 = new Label(2, i + 1 - recordQuantityTimes, list.get(i).getCompCode());
			Label labelV3 = new Label(3, i + 1 - recordQuantityTimes, list.get(i).getAssetMain());
			Label labelV4 = new Label(4, i + 1 - recordQuantityTimes, list.get(i).getAsset());
			Label labelV5 = new Label(5, i + 1 - recordQuantityTimes, list.get(i).getZioEqunr());
			Label labelV6 = new Label(6, i + 1 - recordQuantityTimes, list.get(i).getCurrency());
			Label labelV7 = null;
			if (null != list.get(i).getZpmzcyz()) {
				labelV7 = new Label(7, i + 1 - recordQuantityTimes, list.get(i).getZpmzcyz().toString());
			} else {
				labelV7 = new Label(7, i + 1 - recordQuantityTimes, new String(""));
			}
			Label labelV8 = null;
			if (null != list.get(i).getZpmzcjz()) {
				labelV8 = new Label(8, i + 1 - recordQuantityTimes, list.get(i).getZpmzcjz().toString());
			} else {
				labelV8 = new Label(8, i + 1 - recordQuantityTimes, new String(""));
			}
			Label labelV9 = new Label(9, i + 1 - recordQuantityTimes, list.get(i).getZtypbz1());
			Label labelV10 = new Label(10, i + 1 - recordQuantityTimes, list.get(i).getZtypbz2());
			Label labelV11 = new Label(11, i + 1 - recordQuantityTimes, list.get(i).getZtypbz3());
			Label labelV12 = new Label(12, i + 1 - recordQuantityTimes, list.get(i).getZvolLev());
			Label labelV13 = null;
			if (null != list.get(i).getZquantity()) {
				labelV13 = new Label(13, i + 1 - recordQuantityTimes, list.get(i).getZquantity().toString());
			} else {
				labelV13 = new Label(13, i + 1 - recordQuantityTimes, new String(""));
			}
			Label labelV14 = new Label(14, i + 1 - recordQuantityTimes, list.get(i).getUnit());
			Label labelV15 = new Label(15, i + 1 - recordQuantityTimes, list.get(i).getZioZczt());
			Label labelV16 = new Label(16, i + 1 - recordQuantityTimes, list.get(i).getProfitCtr());
			Label labelV17 = new Label(17, i + 1 - recordQuantityTimes, list.get(i).getZlrzx());
			Label labelV18 = new Label(18, i + 1 - recordQuantityTimes, list.get(i).getCoArea());
			Label labelV19 = new Label(19, i + 1 - recordQuantityTimes, list.get(i).getZzcms());
			Label labelV20 = new Label(20, i + 1 - recordQuantityTimes, list.get(i).getZioZxmlx());
			Label labelV21 = new Label(21, i + 1 - recordQuantityTimes, list.get(i).getCapitDate());
			Label labelV22 = new Label(22, i + 1 - recordQuantityTimes, list.get(i).getZdeakt());
			Label labelV23 = new Label(23, i + 1 - recordQuantityTimes, list.get(i).getAssetClas());
			Label labelV24 = new Label(24, i + 1 - recordQuantityTimes, list.get(i).getZxlh());
			Label labelV25 = new Label(25, i + 1 - recordQuantityTimes, list.get(i).getZinvnr());
			Label labelV26 = new Label(26, i + 1 - recordQuantityTimes, list.get(i).getZi0Zzc1());
			Label labelV27 = new Label(27, i + 1 - recordQuantityTimes, list.get(i).getZi0Zzc2());
			Label labelV28 = new Label(28, i + 1 - recordQuantityTimes, list.get(i).getZioKostl());
			Label labelV29 = new Label(29, i + 1 - recordQuantityTimes, list.get(i).getZkostlv());
			Label labelV30 = new Label(30, i + 1 - recordQuantityTimes, list.get(i).getZioRaumn());
			Label labelV31 = new Label(31, i + 1 - recordQuantityTimes, list.get(i).getZzzph());
			Label labelV32 = new Label(32, i + 1 - recordQuantityTimes, list.get(i).getZzkostl());
			Label labelV33 = new Label(33, i + 1 - recordQuantityTimes, list.get(i).getZioZzc06());
			Label labelV34 = new Label(34, i + 1 - recordQuantityTimes, list.get(i).getZioZzc07());
			Label labelV35 = new Label(35, i + 1 - recordQuantityTimes, list.get(i).getZioOrd41());
			Label labelV36 = new Label(36, i + 1 - recordQuantityTimes, list.get(i).getZord44());
			Label labelV37 = new Label(37, i + 1 - recordQuantityTimes, list.get(i).getZgdlgrp());
			Label labelV38 = new Label(38, i + 1 - recordQuantityTimes, list.get(i).getZzcly());
			Label labelV39 = new Label(39, i + 1 - recordQuantityTimes, list.get(i).getZioUmwkz());
			Label labelV40 = new Label(40, i + 1 - recordQuantityTimes, list.get(i).getZsfdg());
			Label labelV41 = new Label(41, i + 1 - recordQuantityTimes, list.get(i).getZioHerst());
			Label labelV42 = new Label(42, i + 1 - recordQuantityTimes, list.get(i).getZtypbz());
			Label labelV43 = new Label(43, i + 1 - recordQuantityTimes, list.get(i).getzPosid());
			Label labelV44 = new Label(44, i + 1 - recordQuantityTimes, list.get(i).getZpost11());
			Label labelV45 = new Label(45, i + 1 - recordQuantityTimes, list.get(i).getZfiamt());
			Label labelV46 = new Label(46, i + 1 - recordQuantityTimes, list.get(i).getZioStadt());
			Label labelV47 = new Label(47, i + 1 - recordQuantityTimes, list.get(i).getZfwcqzh());
			Label labelV48 = new Label(48, i + 1 - recordQuantityTimes, list.get(i).getZioEqktx());
			Label labelV49 = new Label(49, i + 1 - recordQuantityTimes, list.get(i).getZioTxt04());
			Label labelV50 = new Label(50, i + 1 - recordQuantityTimes, list.get(i).getZioEqart());
			Label labelV51 = new Label(51, i + 1 - recordQuantityTimes, list.get(i).getZpmsqz());
			Label labelV52 = new Label(52, i + 1 - recordQuantityTimes, list.get(i).getZioInbdt());
			Label labelV53 = new Label(53, i + 1 - recordQuantityTimes, list.get(i).getZioZccrq());
			Label labelV54 = new Label(54, i + 1 - recordQuantityTimes, list.get(i).getZzzs());
			Label labelV55 = new Label(55, i + 1 - recordQuantityTimes, list.get(i).getZioHerld());
			Label labelV56 = new Label(56, i + 1 - recordQuantityTimes, list.get(i).getZioMapar());
			Label labelV57 = new Label(57, i + 1 - recordQuantityTimes, list.get(i).getZtxz012());
			Label labelV58 = new Label(58, i + 1 - recordQuantityTimes, list.get(i).getZioSerge());
			Label labelV59 = new Label(59, i + 1 - recordQuantityTimes, list.get(i).getZioSwerk());
			Label labelV60 = new Label(60, i + 1 - recordQuantityTimes, list.get(i).getZioStort());
			Label labelV61 = new Label(61, i + 1 - recordQuantityTimes, list.get(i).getZioBeber());
			Label labelV62 = new Label(62, i + 1 - recordQuantityTimes, list.get(i).getZioAbckz());
			Label labelV63 = new Label(63, i + 1 - recordQuantityTimes, list.get(i).getZioEqfnr());
			Label labelV64 = new Label(64, i + 1 - recordQuantityTimes, list.get(i).getZioZzc02());
			Label labelV65 = new Label(65, i + 1 - recordQuantityTimes, list.get(i).getzProjk());
			Label labelV66 = new Label(66, i + 1 - recordQuantityTimes, list.get(i).getZwbsnm());
			Label labelV67 = new Label(67, i + 1 - recordQuantityTimes, list.get(i).getZioIwerk());
			Label labelV68 = new Label(68, i + 1 - recordQuantityTimes, list.get(i).getZioIngrp());
			Label labelV69 = new Label(69, i + 1 - recordQuantityTimes, list.get(i).getZioVaplz());
			Label labelV70 = new Label(70, i + 1 - recordQuantityTimes, list.get(i).getZioTplnr());
			Label labelV71 = new Label(71, i + 1 - recordQuantityTimes, list.get(i).getZioHequi());
			Label labelV72 = new Label(72, i + 1 - recordQuantityTimes, list.get(i).getZioTidnr());
			Label labelV73 = new Label(73, i + 1 - recordQuantityTimes, list.get(i).getZioSb010());
			Label labelV74 = new Label(74, i + 1 - recordQuantityTimes, list.get(i).getZioSb001());
			Label labelV75 = new Label(75, i + 1 - recordQuantityTimes, list.get(i).getZioSb002());
			Label labelV76 = new Label(76, i + 1 - recordQuantityTimes, list.get(i).getZioSb004());
			Label labelV77 = new Label(77, i + 1 - recordQuantityTimes, list.get(i).getZioSb005());
			Label labelV78 = new Label(78, i + 1 - recordQuantityTimes, list.get(i).getZioSb006());
			Label labelV79 = new Label(79, i + 1 - recordQuantityTimes, list.get(i).getZioSb003());
			Label labelV80 = new Label(80, i + 1 - recordQuantityTimes, list.get(i).getZioSb007());
			Label labelV81 = null;
			if (null != list.get(i).getZioSb008()) {
				labelV81 = new Label(81, i + 1 - recordQuantityTimes, list.get(i).getZioSb008().toString());
			} else {
				labelV81 = new Label(81, i + 1 - recordQuantityTimes, new String(""));
			}
			Label labelV82 = new Label(82, i + 1 - recordQuantityTimes, list.get(i).getZlenunt());
			Label labelV83 = null;
			if (null != list.get(i).getZioSb009()) {
				labelV83 = new Label(83, i + 1 - recordQuantityTimes, list.get(i).getZioSb009().toString());
			} else {
				labelV83 = new Label(83, i + 1 - recordQuantityTimes, new String(""));
			}
			Label labelV84 = new Label(84, i + 1 - recordQuantityTimes, list.get(i).getZcapunt());
			Label labelV85 = new Label(85, i + 1 - recordQuantityTimes, list.get(i).getZioSb011());
			Label labelV86 = new Label(86, i + 1 - recordQuantityTimes, list.get(i).getZioUmlgo());
			Label labelV87 = new Label(87, i + 1 - recordQuantityTimes, list.get(i).getZioGplab());
			Label labelV88 = new Label(88, i + 1 - recordQuantityTimes, list.get(i).getZioPosid());
			Label labelV89 = new Label(89, i + 1 - recordQuantityTimes, list.get(i).getZlyrkrq());
			Label labelV90 = new Label(90, i + 1 - recordQuantityTimes, list.get(i).getZlyckrq());
			Label labelV91 = new Label(91, i + 1 - recordQuantityTimes, list.get(i).getZpost1());
			Label labelV92 = new Label(92, i + 1 - recordQuantityTimes, list.get(i).getZioCusre());
			Label labelV93 = new Label(93, i + 1 - recordQuantityTimes, list.get(i).getZbfyy());
			Label labelV94 = new Label(94, i + 1 - recordQuantityTimes, list.get(i).getZioZsb13());
			Label labelV95 = new Label(95, i + 1 - recordQuantityTimes, list.get(i).getZioZsb12());
			Label labelV96 = new Label(96, i + 1 - recordQuantityTimes, list.get(i).getRecordmode());
			Label labelV97 = new Label(97, i + 1 - recordQuantityTimes, list.get(i).getDataVersion());

			// System.out.println("list.get(i).getPropertyCode()=" +
			// list.get(i).getPropertyCode());
			// System.out.println("getLineStationName");
			// System.out.println("i=" + i);

			sheet.addCell(labelV0);
			sheet.addCell(labelV1);
			sheet.addCell(labelV2);
			sheet.addCell(labelV3);
			sheet.addCell(labelV4);
			sheet.addCell(labelV5);
			sheet.addCell(labelV6);
			sheet.addCell(labelV7);
			sheet.addCell(labelV8);
			sheet.addCell(labelV9);
			sheet.addCell(labelV10);
			sheet.addCell(labelV11);
			sheet.addCell(labelV12);
			sheet.addCell(labelV13);
			sheet.addCell(labelV14);
			sheet.addCell(labelV15);
			sheet.addCell(labelV16);
			sheet.addCell(labelV17);
			sheet.addCell(labelV18);
			sheet.addCell(labelV19);
			sheet.addCell(labelV20);
			sheet.addCell(labelV21);
			sheet.addCell(labelV22);
			sheet.addCell(labelV23);
			sheet.addCell(labelV24);
			sheet.addCell(labelV25);
			sheet.addCell(labelV26);
			sheet.addCell(labelV27);
			sheet.addCell(labelV28);
			sheet.addCell(labelV29);
			sheet.addCell(labelV30);
			sheet.addCell(labelV31);
			sheet.addCell(labelV32);
			sheet.addCell(labelV33);
			sheet.addCell(labelV34);
			sheet.addCell(labelV35);
			sheet.addCell(labelV36);
			sheet.addCell(labelV37);
			sheet.addCell(labelV38);
			sheet.addCell(labelV39);
			sheet.addCell(labelV40);
			sheet.addCell(labelV41);
			sheet.addCell(labelV42);
			sheet.addCell(labelV43);
			sheet.addCell(labelV44);
			sheet.addCell(labelV45);
			sheet.addCell(labelV46);
			sheet.addCell(labelV47);
			sheet.addCell(labelV48);
			sheet.addCell(labelV49);
			sheet.addCell(labelV50);
			sheet.addCell(labelV51);
			sheet.addCell(labelV52);
			sheet.addCell(labelV53);
			sheet.addCell(labelV54);
			sheet.addCell(labelV55);
			sheet.addCell(labelV56);
			sheet.addCell(labelV57);
			sheet.addCell(labelV58);
			sheet.addCell(labelV59);
			sheet.addCell(labelV60);
			sheet.addCell(labelV61);
			sheet.addCell(labelV62);
			sheet.addCell(labelV63);
			sheet.addCell(labelV64);
			sheet.addCell(labelV65);
			sheet.addCell(labelV66);
			sheet.addCell(labelV67);
			sheet.addCell(labelV68);
			sheet.addCell(labelV69);
			sheet.addCell(labelV70);
			sheet.addCell(labelV71);
			sheet.addCell(labelV72);
			sheet.addCell(labelV73);
			sheet.addCell(labelV74);
			sheet.addCell(labelV75);
			sheet.addCell(labelV76);
			sheet.addCell(labelV77);
			sheet.addCell(labelV78);
			sheet.addCell(labelV79);
			sheet.addCell(labelV80);
			sheet.addCell(labelV81);
			sheet.addCell(labelV82);
			sheet.addCell(labelV83);
			sheet.addCell(labelV84);
			sheet.addCell(labelV85);
			sheet.addCell(labelV86);
			sheet.addCell(labelV87);
			sheet.addCell(labelV88);
			sheet.addCell(labelV89);
			sheet.addCell(labelV90);
			sheet.addCell(labelV91);
			sheet.addCell(labelV92);
			sheet.addCell(labelV93);
			sheet.addCell(labelV94);
			sheet.addCell(labelV95);
			sheet.addCell(labelV96);
			sheet.addCell(labelV97);

			System.out.println("i=" + (i + 1));
		}
		System.out.println(sheet.toString());
		// }

		// 写入数据并关闭文件
		try {
			book.write();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			book.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("创建文件成功!");
		now = new Date();
		nowdate = df.format(now);
		System.out.println("Now time is :" + nowdate);

		return true;
	}

	public static boolean writeMidErpItemAssetWallIntoXls(List<TableColumnProperty> headList, String tableName,
			List<MidErpItemAssetWall> list, int recordQuantity, int columnNameOrComment)
			throws RowsExceededException, WriteException {
		Date now = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-ddHHmmss");
		String nowdate = df.format(now);
		// 打开文件
		WritableWorkbook book = null;

		try {
			book = Workbook.createWorkbook(new File("D:/temp/" + tableName + "_" + nowdate + "_" + 0 + ".xls"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(book);
		System.out.println("D:/temp/" + tableName + nowdate + ".xls");
		// 生成名为"第一页"的工作表，参数0表示这是第一
		WritableSheet sheet = book.createSheet("Sheet1", 0);

		// 设置字体为宋体,16号字,加粗,颜色为黑色
		WritableFont font1 = new WritableFont(WritableFont.createFont("宋体"), 12, WritableFont.BOLD);
		try {
			font1.setColour(Colour.BLACK);
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WritableCellFormat format1 = new WritableCellFormat(font1);
		try {
			format1.setAlignment(jxl.format.Alignment.CENTRE);
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			format1.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i = 0; i < headList.size(); i++) {
			Label label = null;
			if (columnNameOrComment == 1) {
				label = new Label(headList.get(i).getColumnId() - 1, 0, headList.get(i).getColumnName(), format1);
			} else {
				label = new Label(headList.get(i).getColumnId() - 1, 0, headList.get(i).getColumnComment(), format1);
			}
			try {
				sheet.addCell(label);
			} catch (RowsExceededException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// writeHead(conn, book, tableName, 1);
		/*
		 * 创建名叫“Sheet1”的sheet表
		 */
		sheet = book.getSheet("Sheet1");
		for (int i = 0; i < list.size(); i++) {
			int j = i / recordQuantity;

			// System.out.println("i=" + i);
			// System.out.println("(i % 65534) == 0 && i != 0)="+((i %
			// 65534) == 0 && i != 0));
			if ((i % recordQuantity) == 0 && i != 0) {
				// 写入数据并关闭文件
				// System.out.println("I'm Here!");
				try {
					book.write();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					book.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				df = new SimpleDateFormat("yyyy-MM-ddHHmmss");
				now = new Date();
				nowdate = df.format(now);
				// System.out.println("D:/temp/" + tableName + nowdate +j+
				// ".xls");
				try {
					book = Workbook.createWorkbook(new File("D:/temp/" + tableName + "_" + nowdate + "_" + j + ".xls"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// System.out.println("D:/temp/" + tableName + nowdate +j+
				// ".xls");

				sheet = book.createSheet("Sheet1", 0);

				for (int headListi = 0; headListi < headList.size(); headListi++) {
					Label label = null;
					if (columnNameOrComment == 1) {
						label = new Label(headList.get(headListi).getColumnId() - 1, 0,
								headList.get(headListi).getColumnName(), format1);
					} else {
						label = new Label(headList.get(headListi).getColumnId() - 1, 0,
								headList.get(headListi).getColumnComment(), format1);
					}
					try {
						sheet.addCell(label);
					} catch (RowsExceededException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (WriteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				// writeHead(conn, book, tableName, 1);
				sheet = book.getSheet("Sheet1");
				df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				// break;
			}
			// System.out.println("j=" + j);
			int recordQuantityTimes = j * recordQuantity;
			Label labelV0 = new Label(0, i + 1 - recordQuantityTimes, list.get(i).getMidErpItemId());
			// System.out.println("list.get(i).getVersion()" +
			// list.get(i).getVersion());

			Label labelV1 = new Label(1, i + 1 - recordQuantityTimes, list.get(i).getSbbm());
			Label labelV2 = new Label(2, i + 1 - recordQuantityTimes, list.get(i).getGsdm());
			Label labelV3 = new Label(3, i + 1 - recordQuantityTimes, list.get(i).getSsds());
			Label labelV4 = new Label(4, i + 1 - recordQuantityTimes, list.get(i).getXgsdm());
			Label labelV5 = new Label(5, i + 1 - recordQuantityTimes, list.get(i).getSsxj());
			Label labelV6 = new Label(6, i + 1 - recordQuantityTimes, list.get(i).getSbmc());
			Label labelV7 = new Label(7, i + 1 - recordQuantityTimes, list.get(i).getZyflbm());
			Label labelV8 = new Label(8, i + 1 - recordQuantityTimes, list.get(i).getZyfl());
			Label labelV9 = new Label(9, i + 1 - recordQuantityTimes, list.get(i).getTypbz());
			Label labelV10 = new Label(10, i + 1 - recordQuantityTimes, list.get(i).getTypbzCode());
			Label labelV11 = new Label(11, i + 1 - recordQuantityTimes, list.get(i).getSccj());
			Label labelV12 = new Label(12, i + 1 - recordQuantityTimes, list.get(i).getSbxh());
			Label labelV13 = new Label(13, i + 1 - recordQuantityTimes, list.get(i).getDydj());
			Label labelV14 = null;
			if (null != list.get(i).getYz()) {
				labelV14 = new Label(14, i + 1 - recordQuantityTimes, list.get(i).getYz().toString());
			} else {
				labelV14 = new Label(14, i + 1 - recordQuantityTimes, new String(""));
			}
			Label labelV15 = null;
			if (null != list.get(i).getYz()) {
				labelV15 = new Label(15, i + 1 - recordQuantityTimes, list.get(i).getJz().toString());
			} else {
				labelV15 = new Label(15, i + 1 - recordQuantityTimes, new String(""));
			}
			Label labelV16 = null;
			labelV16 = new Label(16, i + 1 - recordQuantityTimes, list.get(i).getXlcd());
			Label labelV17 = new Label(17, i + 1 - recordQuantityTimes, list.get(i).getByqrl());

			Label labelV18 = null;
			if (null != list.get(i).getTysj()) {
				labelV18 = new Label(18, i + 1 - recordQuantityTimes, df.format(list.get(i).getTysj()).toString());
			} else {
				labelV18 = new Label(18, i + 1 - recordQuantityTimes, new String(""));
			}

			Label labelV19 = new Label(19, i + 1 - recordQuantityTimes, list.get(i).getSbzt());
			Label labelV20 = null;
			if (null != list.get(i).getSfylzc()) {
				labelV20 = new Label(20, i + 1 - recordQuantityTimes, list.get(i).getSfylzc().toString());
			} else {
				labelV20 = new Label(20, i + 1 - recordQuantityTimes, new String(""));
			}
			Label labelV21 = new Label(21, i + 1 - recordQuantityTimes, list.get(i).getSwid());
			Label labelV22 = null;
			if (null != list.get(i).getZylzc()) {
				labelV22 = new Label(22, i + 1 - recordQuantityTimes, list.get(i).getZylzc().toString());
			} else {
				labelV22 = new Label(22, i + 1 - recordQuantityTimes, new String(""));
			}
			Label labelV23 = null;
			if (null != list.get(i).getCxl()) {
				labelV23 = new Label(23, i + 1 - recordQuantityTimes, list.get(i).getCxl().toString());
			} else {
				labelV23 = new Label(23, i + 1 - recordQuantityTimes, new String(""));
			}
			Label labelV24 = null;
			if (null != list.get(i).getXzzc()) {
				labelV24 = new Label(24, i + 1 - recordQuantityTimes, list.get(i).getXzzc().toString());
			} else {
				labelV24 = new Label(24, i + 1 - recordQuantityTimes, new String(""));
			}
			Label labelV25 = null;
			if (null != list.get(i).getZlybz()) {
				labelV25 = new Label(25, i + 1 - recordQuantityTimes, list.get(i).getZlybz().toString());
			} else {
				labelV25 = new Label(25, i + 1 - recordQuantityTimes, new String(""));
			}
			Label labelV26 = new Label(26, i + 1 - recordQuantityTimes, list.get(i).getEqart());
			// System.out.println("list.get(i).getPropertyCode()=" +
			// list.get(i).getPropertyCode());
			// System.out.println("getLineStationName");
			// System.out.println("i=" + i);

			sheet.addCell(labelV0);
			sheet.addCell(labelV1);
			sheet.addCell(labelV2);
			sheet.addCell(labelV3);
			sheet.addCell(labelV4);
			sheet.addCell(labelV5);
			sheet.addCell(labelV6);
			sheet.addCell(labelV7);
			sheet.addCell(labelV8);
			sheet.addCell(labelV9);
			sheet.addCell(labelV10);
			sheet.addCell(labelV11);
			sheet.addCell(labelV12);
			sheet.addCell(labelV13);
			sheet.addCell(labelV14);
			sheet.addCell(labelV15);
			sheet.addCell(labelV16);
			sheet.addCell(labelV17);
			sheet.addCell(labelV18);
			sheet.addCell(labelV19);
			sheet.addCell(labelV20);
			sheet.addCell(labelV21);
			sheet.addCell(labelV22);
			sheet.addCell(labelV23);
			sheet.addCell(labelV24);
			sheet.addCell(labelV25);
			sheet.addCell(labelV26);

			System.out.println("i=" + (i + 1));
		}
		System.out.println(sheet.toString());
		// }

		// 写入数据并关闭文件
		try {
			book.write();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			book.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("创建文件成功!");
		now = new Date();
		nowdate = df.format(now);
		System.out.println("Now time is :" + nowdate);

		return true;
	}

	public static boolean writeMidErpItemIntoXls(List<TableColumnProperty> headList, String tableName,
			List<MidErpItem> list, int recordQuantity, int columnNameOrComment)
			throws RowsExceededException, WriteException {
		Date now = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-ddHHmmss");
		String nowdate = df.format(now);
		// 打开文件
		WritableWorkbook book = null;

		try {
			book = Workbook.createWorkbook(new File("D:/temp/" + tableName + "_" + nowdate + "_" + 0 + ".xls"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(book);
		System.out.println("D:/temp/" + tableName + nowdate + ".xls");
		// 生成名为"第一页"的工作表，参数0表示这是第一
		WritableSheet sheet = book.createSheet("Sheet1", 0);

		// 设置字体为宋体,16号字,加粗,颜色为黑色
		WritableFont font1 = new WritableFont(WritableFont.createFont("宋体"), 12, WritableFont.BOLD);
		try {
			font1.setColour(Colour.BLACK);
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WritableCellFormat format1 = new WritableCellFormat(font1);
		try {
			format1.setAlignment(jxl.format.Alignment.CENTRE);
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			format1.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i = 0; i < headList.size(); i++) {
			Label label = null;
			if (columnNameOrComment == 1) {
				label = new Label(headList.get(i).getColumnId() - 1, 0, headList.get(i).getColumnName(), format1);
			} else {
				label = new Label(headList.get(i).getColumnId() - 1, 0, headList.get(i).getColumnComment(), format1);
			}
			try {
				sheet.addCell(label);
			} catch (RowsExceededException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// writeHead(conn, book, tableName, 1);
		/*
		 * 创建名叫“Sheet1”的sheet表
		 */
		sheet = book.getSheet("Sheet1");
		for (int i = 0; i < list.size(); i++) {
			int j = i / recordQuantity;

			// System.out.println("i=" + i);
			// System.out.println("(i % 65534) == 0 && i != 0)="+((i %
			// 65534) == 0 && i != 0));
			if ((i % recordQuantity) == 0 && i != 0) {
				// 写入数据并关闭文件
				// System.out.println("I'm Here!");
				try {
					book.write();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					book.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				df = new SimpleDateFormat("yyyy-MM-ddHHmmss");
				now = new Date();
				nowdate = df.format(now);
				// System.out.println("D:/temp/" + tableName + nowdate +j+
				// ".xls");
				try {
					book = Workbook.createWorkbook(new File("D:/temp/" + tableName + "_" + nowdate + "_" + j + ".xls"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// System.out.println("D:/temp/" + tableName + nowdate +j+
				// ".xls");

				sheet = book.createSheet("Sheet1", 0);

				for (int headListi = 0; headListi < headList.size(); headListi++) {
					Label label = null;
					if (columnNameOrComment == 1) {
						label = new Label(headList.get(headListi).getColumnId() - 1, 0,
								headList.get(headListi).getColumnName(), format1);
					} else {
						label = new Label(headList.get(headListi).getColumnId() - 1, 0,
								headList.get(headListi).getColumnComment(), format1);
					}
					try {
						sheet.addCell(label);
					} catch (RowsExceededException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (WriteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				// writeHead(conn, book, tableName, 1);
				sheet = book.getSheet("Sheet1");
				df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				// break;
			}
			// System.out.println("j=" + j);
			int recordQuantityTimes = j * recordQuantity;
			Label labelV0 = new Label(0, i + 1 - recordQuantityTimes, list.get(i).getMidErpItemId());
			Label labelV1 = new Label(1, i + 1 - recordQuantityTimes, list.get(i).getVersion());
			// System.out.println("list.get(i).getVersion()" +
			// list.get(i).getVersion());
			Label labelV2 = null;
			if (null != list.get(i).getCalYear()) {
				labelV2 = new Label(2, i + 1 - recordQuantityTimes, df.format(list.get(i).getCalYear()).toString());
			} else {
				labelV2 = new Label(2, i + 1 - recordQuantityTimes, df.format(list.get(i).getCalYear()).toString());
			}
			Label labelV3 = null;
			if (null != list.get(i).getCalyear()) {
				labelV3 = new Label(3, i + 1 - recordQuantityTimes, list.get(i).getCalyear().toString());
			} else {
				labelV3 = new Label(3, i + 1 - recordQuantityTimes, new String(""));
			}
			Label labelV4 = new Label(4, i + 1 - recordQuantityTimes, list.get(i).getOrgName());
			Label labelV5 = new Label(5, i + 1 - recordQuantityTimes, list.get(i).getCompCode());
			Label labelV6 = new Label(6, i + 1 - recordQuantityTimes, list.get(i).getAssetMainNumber());
			Label labelV7 = new Label(7, i + 1 - recordQuantityTimes, list.get(i).getAssetSubnumber());
			Label labelV8 = new Label(8, i + 1 - recordQuantityTimes, list.get(i).getEquipementNumber());
			Label labelV9 = new Label(9, i + 1 - recordQuantityTimes, list.get(i).getCurrency());
			Label labelV10 = new Label(10, i + 1 - recordQuantityTimes, list.get(i).getLargeClass());
			Label labelV11 = new Label(11, i + 1 - recordQuantityTimes, list.get(i).getMediumClass());
			Label labelV12 = new Label(12, i + 1 - recordQuantityTimes, list.get(i).getSmallClass());
			Label labelV13 = new Label(13, i + 1 - recordQuantityTimes, list.get(i).getVoltageLevel());
			Label labelV14 = null;
			if (null != list.get(i).getQuantity()) {
				labelV14 = new Label(14, i + 1 - recordQuantityTimes, list.get(i).getQuantity().toString());
			} else {
				labelV14 = new Label(14, i + 1 - recordQuantityTimes, new String(""));
			}
			Label labelV15 = new Label(15, i + 1 - recordQuantityTimes, list.get(i).getUnit());
			Label labelV16 = null;
			if (null != list.get(i).getOriginalValue()) {
				labelV16 = new Label(16, i + 1 - recordQuantityTimes, list.get(i).getOriginalValue().toString());
			} else {
				labelV16 = new Label(16, i + 1 - recordQuantityTimes, new String(""));
			}
			Label labelV17 = null;
			if (null != list.get(i).getNetValue()) {
				labelV17 = new Label(17, i + 1 - recordQuantityTimes, list.get(i).getNetValue().toString());
			} else {
				labelV17 = new Label(17, i + 1 - recordQuantityTimes, new String(""));
			}
			Label labelV18 = new Label(18, i + 1 - recordQuantityTimes, list.get(i).getAssetStatus());
			Label labelV19 = new Label(19, i + 1 - recordQuantityTimes, list.get(i).getProfitEnterSecLevelUnit());
			Label labelV20 = new Label(20, i + 1 - recordQuantityTimes, list.get(i).getCostControlArea());
			Label labelV21 = new Label(21, i + 1 - recordQuantityTimes, list.get(i).getAssetDescription());
			Label labelV22 = new Label(22, i + 1 - recordQuantityTimes, list.get(i).getProjectType());
			Label labelV23 = null;
			if (null != list.get(i).getCapitalizationDate()) {
				labelV23 = new Label(23, i + 1 - recordQuantityTimes,
						df.format(list.get(i).getCapitalizationDate()).toString());
			} else {
				labelV23 = new Label(23, i + 1 - recordQuantityTimes, new String(""));
			}
			Label labelV24 = null;
			if (null != list.get(i).getDeliveryDate()) {
				labelV24 = new Label(24, i + 1 - recordQuantityTimes,
						df.format(list.get(i).getDeliveryDate()).toString());
			} else {
				labelV24 = new Label(24, i + 1 - recordQuantityTimes, new String(""));
			}
			Label labelV25 = null;
			if (null != list.get(i).getManufactureDate()) {
				labelV25 = new Label(25, i + 1 - recordQuantityTimes,
						df.format(list.get(i).getManufactureDate()).toString());
			} else {
				labelV25 = new Label(25, i + 1 - recordQuantityTimes, new String(""));
			}
			Label labelV26 = null;
			if (null != list.get(i).getLineLength()) {
				labelV26 = new Label(26, i + 1 - recordQuantityTimes, list.get(i).getLineLength().toString());
			} else {
				labelV26 = new Label(26, i + 1 - recordQuantityTimes, new String(""));
			}
			Label labelV27 = new Label(27, i + 1 - recordQuantityTimes, list.get(i).getLengthUnit());
			Label labelV28 = null;
			if (null != list.get(i).getTransformerCapacity()) {
				labelV28 = new Label(28, i + 1 - recordQuantityTimes, list.get(i).getTransformerCapacity().toString());
			} else {
				labelV28 = new Label(28, i + 1 - recordQuantityTimes, new String(""));
			}
			Label labelV29 = new Label(29, i + 1 - recordQuantityTimes, list.get(i).getCapacityUnit());
			Label labelV30 = new Label(30, i + 1 - recordQuantityTimes, list.get(i).getWarehouseAddress());
			Label labelV31 = new Label(31, i + 1 - recordQuantityTimes, list.get(i).getSparePartMark());
			Label labelV32 = new Label(32, i + 1 - recordQuantityTimes, list.get(i).getReusingDeviceMark());
			Label labelV33 = null;
			if (null != list.get(i).getReusingEntryDate()) {
				labelV33 = new Label(33, i + 1 - recordQuantityTimes,
						df.format(list.get(i).getReusingEntryDate()).toString());
			} else {
				labelV33 = new Label(33, i + 1 - recordQuantityTimes, new String(""));
			}
			Label labelV34 = null;
			if (null != list.get(i).getReusingOutDate()) {
				labelV34 = new Label(34, i + 1 - recordQuantityTimes,
						df.format(list.get(i).getReusingOutDate()).toString());
			} else {
				labelV34 = new Label(34, i + 1 - recordQuantityTimes, new String(""));
			}
			Label labelV35 = new Label(35, i + 1 - recordQuantityTimes, list.get(i).getDiscardProjectResourceCode());
			Label labelV36 = new Label(36, i + 1 - recordQuantityTimes, list.get(i).getDiscardReasonCode());
			Label labelV37 = null;
			if (null != list.get(i).getDiscardAccountingDate()) {
				labelV37 = new Label(37, i + 1 - recordQuantityTimes,
						df.format(list.get(i).getDiscardAccountingDate()).toString());
			} else {
				labelV37 = new Label(37, i + 1 - recordQuantityTimes, new String(""));
			}
			Label labelV38 = new Label(38, i + 1 - recordQuantityTimes, list.get(i).getEquipmentStatus());
			Label labelV39 = new Label(39, i + 1 - recordQuantityTimes, list.get(i).getEquipmentVoltageLevel());
			Label labelV40 = new Label(40, i + 1 - recordQuantityTimes, list.get(i).getIsCustody());
			Label labelV41 = new Label(41, i + 1 - recordQuantityTimes, list.get(i).getManufacturerCard());
			Label labelV42 = new Label(42, i + 1 - recordQuantityTimes, list.get(i).getManufacturerEquipement());
			Label labelV43 = new Label(43, i + 1 - recordQuantityTimes, list.get(i).getManufactureState());
			Label labelV44 = new Label(44, i + 1 - recordQuantityTimes, list.get(i).getManufacturePartNumber());
			Label labelV45 = new Label(45, i + 1 - recordQuantityTimes, list.get(i).getInactivityDate());
			Label labelV46 = new Label(46, i + 1 - recordQuantityTimes, list.get(i).getAssetCategory());
			Label labelV47 = new Label(47, i + 1 - recordQuantityTimes, list.get(i).getCardSerialNumber());
			Label labelV48 = new Label(48, i + 1 - recordQuantityTimes, list.get(i).getCardInventoryNumber());
			Label labelV49 = new Label(49, i + 1 - recordQuantityTimes, list.get(i).getCardAssetUnit());
			Label labelV50 = new Label(50, i + 1 - recordQuantityTimes, list.get(i).getCardStorageUnit());
			Label labelV51 = new Label(51, i + 1 - recordQuantityTimes, list.get(i).getCardCostCenter());
			Label labelV52 = new Label(52, i + 1 - recordQuantityTimes, list.get(i).getCardAssetManageDepart());
			Label labelV53 = new Label(53, i + 1 - recordQuantityTimes, list.get(i).getCardUsingCustodian());
			Label labelV54 = new Label(54, i + 1 - recordQuantityTimes, list.get(i).getCardCarLicense());
			Label labelV55 = new Label(55, i + 1 - recordQuantityTimes, list.get(i).getCostCenterAuxilAccounting());
			Label labelV56 = new Label(56, i + 1 - recordQuantityTimes, list.get(i).getDonationType());
			Label labelV57 = new Label(57, i + 1 - recordQuantityTimes, list.get(i).getSuperviseSign());
			Label labelV58 = new Label(58, i + 1 - recordQuantityTimes, list.get(i).getAssetUsingInformation());
			Label labelV59 = new Label(59, i + 1 - recordQuantityTimes, list.get(i).getAssetIncreaseMethod());
			Label labelV60 = new Label(60, i + 1 - recordQuantityTimes, list.get(i).getAssetChangeMode());
			Label labelV61 = new Label(61, i + 1 - recordQuantityTimes, list.get(i).getAssetOrigin());
			Label labelV62 = new Label(62, i + 1 - recordQuantityTimes, list.get(i).getEngineeringProperty());
			Label labelV63 = new Label(63, i + 1 - recordQuantityTimes, list.get(i).getFixedAssetClass());
			Label labelV64 = new Label(64, i + 1 - recordQuantityTimes, list.get(i).getCardWbsElement());
			Label labelV65 = new Label(65, i + 1 - recordQuantityTimes, list.get(i).getCardWbsElementDesc());
			Label labelV66 = new Label(66, i + 1 - recordQuantityTimes, list.get(i).getAssetStorageAddress());
			Label labelV67 = new Label(67, i + 1 - recordQuantityTimes, list.get(i).getLineStationName());
			Label labelV68 = new Label(68, i + 1 - recordQuantityTimes, list.get(i).getHousePropCertifiNum());
			Label labelV69 = new Label(69, i + 1 - recordQuantityTimes, list.get(i).getEquipementName());
			Label labelV70 = new Label(70, i + 1 - recordQuantityTimes, list.get(i).getTechnicalObjectType());
			Label labelV71 = new Label(71, i + 1 - recordQuantityTimes, list.get(i).getAuthorizationGroup());
			Label labelV72 = new Label(72, i + 1 - recordQuantityTimes, list.get(i).getEquipSpecificationModel());
			Label labelV73 = new Label(73, i + 1 - recordQuantityTimes, list.get(i).getEquipNameplateNumber());
			Label labelV74 = new Label(74, i + 1 - recordQuantityTimes, list.get(i).getMaintenanceFactory());
			Label labelV75 = new Label(75, i + 1 - recordQuantityTimes, list.get(i).getEquipAssetChangeMode());
			Label labelV76 = new Label(76, i + 1 - recordQuantityTimes, list.get(i).getFactoryArea());
			Label labelV77 = new Label(77, i + 1 - recordQuantityTimes, list.get(i).getAbcIdentification());
			Label labelV78 = new Label(78, i + 1 - recordQuantityTimes, list.get(i).getClassifiedField());
			Label labelV79 = new Label(79, i + 1 - recordQuantityTimes, list.get(i).getEquipmentCostCenter());
			Label labelV80 = new Label(80, i + 1 - recordQuantityTimes, list.get(i).getEquipmentWbsElement());
			Label labelV81 = new Label(81, i + 1 - recordQuantityTimes, list.get(i).getEquipWbsElementDesc());
			Label labelV82 = new Label(82, i + 1 - recordQuantityTimes, list.get(i).getPlanFactory());
			Label labelV83 = new Label(83, i + 1 - recordQuantityTimes, list.get(i).getPlanGroup());
			Label labelV84 = new Label(84, i + 1 - recordQuantityTimes, list.get(i).getMainWorkCenter());
			Label labelV85 = new Label(85, i + 1 - recordQuantityTimes, list.get(i).getFunctionalPosition());
			Label labelV86 = new Label(86, i + 1 - recordQuantityTimes, list.get(i).getAdvancedEquipment());
			Label labelV87 = new Label(87, i + 1 - recordQuantityTimes, list.get(i).getTechIdentificationNumber());
			Label labelV88 = new Label(88, i + 1 - recordQuantityTimes, list.get(i).getEquipUseCustodian());
			Label labelV89 = new Label(89, i + 1 - recordQuantityTimes, list.get(i).getEquipStorageDepartment());
			Label labelV90 = new Label(90, i + 1 - recordQuantityTimes, list.get(i).getEquipObjectManageDeparment());
			Label labelV91 = new Label(91, i + 1 - recordQuantityTimes, list.get(i).getEpqipmentIncreaseMethod());
			Label labelV92 = new Label(92, i + 1 - recordQuantityTimes, list.get(i).getEquipmentSotrageAddress());
			Label labelV93 = new Label(93, i + 1 - recordQuantityTimes, list.get(i).getEquipCarLicense());
			Label labelV94 = new Label(94, i + 1 - recordQuantityTimes, list.get(i).getEquipHousePropCertifiNum());
			// System.out.println("list.get(i).getLineStationLogo()=" +
			// list.get(i).getLineStationLogo());
			Label labelV95 = new Label(95, i + 1 - recordQuantityTimes, list.get(i).getLineStationLogo());
			Label labelV96 = new Label(96, i + 1 - recordQuantityTimes, list.get(i).getDiscardOriginProjectDesc());
			Label labelV97 = new Label(97, i + 1 - recordQuantityTimes, list.get(i).getDiscardReasonContent());
			// System.out.println("list.get(i).getDiscardReasonContent()=" +
			// list.get(i).getDiscardReasonContent());
			Label labelV98 = null;
			if (null != list.get(i).getDataExtractDate()) {
				labelV98 = new Label(98, i + 1 - recordQuantityTimes,
						df.format(list.get(i).getDataExtractDate()).toString());
			} else {
				labelV98 = new Label(98, i + 1 - recordQuantityTimes, new String(""));
			}
			Label labelV99 = null;
			if (null != list.get(i).getDataExtractTime()) {
				labelV99 = new Label(99, i + 1 - recordQuantityTimes,
						df.format(list.get(i).getDataExtractTime()).toString());
			} else {
				labelV99 = new Label(99, i + 1 - recordQuantityTimes, new String(""));
			}
			Label labelV100 = new Label(100, i + 1 - recordQuantityTimes, list.get(i).getDataExtractPerson());
			Label labelV101 = new Label(101, i + 1 - recordQuantityTimes, list.get(i).getAssetProperty());
			Label labelV102 = new Label(102, i + 1 - recordQuantityTimes, list.get(i).getPropertyCode());
			// System.out.println("list.get(i).getPropertyCode()=" +
			// list.get(i).getPropertyCode());
			// System.out.println("getLineStationName");
			// System.out.println("i=" + i);

			sheet.addCell(labelV0);
			sheet.addCell(labelV1);
			sheet.addCell(labelV2);
			sheet.addCell(labelV3);
			sheet.addCell(labelV4);
			sheet.addCell(labelV5);
			sheet.addCell(labelV6);
			sheet.addCell(labelV7);
			sheet.addCell(labelV8);
			sheet.addCell(labelV9);
			sheet.addCell(labelV10);
			sheet.addCell(labelV11);
			sheet.addCell(labelV12);
			sheet.addCell(labelV13);
			sheet.addCell(labelV14);
			sheet.addCell(labelV15);
			sheet.addCell(labelV16);
			sheet.addCell(labelV17);
			sheet.addCell(labelV18);
			sheet.addCell(labelV19);
			sheet.addCell(labelV20);
			sheet.addCell(labelV21);
			sheet.addCell(labelV22);
			sheet.addCell(labelV23);
			sheet.addCell(labelV24);
			sheet.addCell(labelV25);
			sheet.addCell(labelV26);
			sheet.addCell(labelV27);
			sheet.addCell(labelV28);
			sheet.addCell(labelV29);
			sheet.addCell(labelV30);
			sheet.addCell(labelV31);
			sheet.addCell(labelV32);
			sheet.addCell(labelV33);
			sheet.addCell(labelV34);
			sheet.addCell(labelV35);
			sheet.addCell(labelV36);
			sheet.addCell(labelV37);
			sheet.addCell(labelV38);
			sheet.addCell(labelV39);
			sheet.addCell(labelV40);
			sheet.addCell(labelV41);
			sheet.addCell(labelV42);
			sheet.addCell(labelV43);
			sheet.addCell(labelV44);
			sheet.addCell(labelV45);
			sheet.addCell(labelV46);
			sheet.addCell(labelV47);
			sheet.addCell(labelV48);
			sheet.addCell(labelV49);
			sheet.addCell(labelV50);
			sheet.addCell(labelV51);
			sheet.addCell(labelV52);
			sheet.addCell(labelV53);
			sheet.addCell(labelV54);
			sheet.addCell(labelV55);
			sheet.addCell(labelV56);
			sheet.addCell(labelV57);
			sheet.addCell(labelV58);
			sheet.addCell(labelV59);
			sheet.addCell(labelV60);
			sheet.addCell(labelV61);
			sheet.addCell(labelV62);
			sheet.addCell(labelV63);
			sheet.addCell(labelV64);
			sheet.addCell(labelV65);
			sheet.addCell(labelV66);
			sheet.addCell(labelV67);
			sheet.addCell(labelV68);
			sheet.addCell(labelV69);
			sheet.addCell(labelV70);
			sheet.addCell(labelV71);
			sheet.addCell(labelV72);
			sheet.addCell(labelV73);
			sheet.addCell(labelV74);
			sheet.addCell(labelV75);
			sheet.addCell(labelV76);
			sheet.addCell(labelV77);
			sheet.addCell(labelV78);
			sheet.addCell(labelV79);
			sheet.addCell(labelV80);
			sheet.addCell(labelV81);
			sheet.addCell(labelV82);
			sheet.addCell(labelV83);
			sheet.addCell(labelV84);
			sheet.addCell(labelV85);
			sheet.addCell(labelV86);
			sheet.addCell(labelV87);
			sheet.addCell(labelV88);
			sheet.addCell(labelV89);
			sheet.addCell(labelV90);
			sheet.addCell(labelV91);
			sheet.addCell(labelV92);
			sheet.addCell(labelV93);
			sheet.addCell(labelV94);
			sheet.addCell(labelV95);
			sheet.addCell(labelV96);
			sheet.addCell(labelV97);
			sheet.addCell(labelV98);
			sheet.addCell(labelV99);
			sheet.addCell(labelV100);
			sheet.addCell(labelV101);
			sheet.addCell(labelV102);

			System.out.println("i=" + (i + 1));
		}
		System.out.println(sheet.toString());
		// }

		// 写入数据并关闭文件
		try {
			book.write();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			book.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("创建文件成功!");
		now = new Date();
		nowdate = df.format(now);
		System.out.println("Now time is :" + nowdate);

		return true;
	}

	public static boolean writeMidErpItemIntoXls(String tableName, List<MidErpItem> list, int recordQuantity)
			throws RowsExceededException, WriteException {
		Date now = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-ddHHmmss");
		String nowdate = df.format(now);
		// 打开文件
		WritableWorkbook book = null;

		try {
			book = Workbook.createWorkbook(new File("D:/temp/" + tableName + "_" + nowdate + "_" + 0 + ".xls"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(book);
		System.out.println("D:/temp/" + tableName + nowdate + ".xls");
		// 生成名为"第一页"的工作表，参数0表示这是第一
		WritableSheet sheet = book.createSheet("第一页", 0);

		// 设置字体为宋体,16号字,加粗,颜色为黑色
		WritableFont font1 = new WritableFont(WritableFont.createFont("宋体"), 12, WritableFont.BOLD);
		try {
			font1.setColour(Colour.BLACK);
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WritableCellFormat format1 = new WritableCellFormat(font1);
		try {
			format1.setAlignment(jxl.format.Alignment.CENTRE);
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			format1.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Label label0 = new Label(0, 0, "ERP实物资产单体中间表记录ID", format1);
		Label label1 = new Label(1, 0, "数据版本", format1);
		Label label2 = new Label(2, 0, "统计年", format1);
		Label label3 = new Label(3, 0, "日历年", format1);
		Label label4 = new Label(4, 0, "利润中心名称", format1);
		Label label5 = new Label(5, 0, "单位（公司代码）", format1);
		Label label6 = new Label(6, 0, "主资产编号", format1);
		Label label7 = new Label(7, 0, "资产子编号", format1);
		Label label8 = new Label(8, 0, "设备编号", format1);
		Label label9 = new Label(9, 0, "货币", format1);
		Label label10 = new Label(10, 0, "资产大类", format1);
		Label label11 = new Label(11, 0, "资产中类", format1);
		Label label12 = new Label(12, 0, "资产小类", format1);
		Label label13 = new Label(13, 0, "电压等级（卡片）", format1);
		Label label14 = new Label(14, 0, "数量（卡片）", format1);
		Label label15 = new Label(15, 0, "计量的单位（卡片）", format1);
		Label label16 = new Label(16, 0, "资产原值", format1);
		Label label17 = new Label(17, 0, "资产净值", format1);
		Label label18 = new Label(18, 0, "资产状态", format1);
		Label label19 = new Label(19, 0, "二级单位（利润中心）", format1);
		Label label20 = new Label(20, 0, "成本控制范围", format1);
		Label label21 = new Label(21, 0, "资产描述", format1);
		Label label22 = new Label(22, 0, "项目类型", format1);
		Label label23 = new Label(23, 0, "资本化日期", format1);
		Label label24 = new Label(24, 0, "投运日期", format1);
		Label label25 = new Label(25, 0, "出厂日期", format1);
		Label label26 = new Label(26, 0, "线路长度", format1);
		Label label27 = new Label(27, 0, "长度单位", format1);
		Label label28 = new Label(28, 0, "变电容量", format1);
		Label label29 = new Label(29, 0, "容量单位", format1);
		Label label30 = new Label(30, 0, "库存地点（设备）", format1);
		Label label31 = new Label(31, 0, "备品备件标识", format1);
		Label label32 = new Label(32, 0, "再利用设备标识", format1);
		Label label33 = new Label(33, 0, "入再利用库日期", format1);
		Label label34 = new Label(34, 0, "出再利用库日期", format1);
		Label label35 = new Label(35, 0, "报废来源项目编号", format1);
		Label label36 = new Label(36, 0, "报废原因代码", format1);
		Label label37 = new Label(37, 0, "报废记账日期", format1);
		Label label38 = new Label(38, 0, "设备状态", format1);
		Label label39 = new Label(39, 0, "电压等级（设备）", format1);
		Label label40 = new Label(40, 0, "是否代管", format1);
		Label label41 = new Label(41, 0, "制造厂商（卡片）", format1);
		Label label42 = new Label(42, 0, "制造厂商（设备）", format1);
		Label label43 = new Label(43, 0, "制造商国家", format1);
		Label label44 = new Label(44, 0, "制造商零件号", format1);
		Label label45 = new Label(45, 0, "不活动日期", format1);
		Label label46 = new Label(46, 0, "资产分类", format1);
		Label label47 = new Label(47, 0, "序列号（卡片）", format1);
		Label label48 = new Label(48, 0, "存货号（卡片）", format1);
		Label label49 = new Label(49, 0, "资产所属单位（卡片）", format1);
		Label label50 = new Label(50, 0, "使用保管单位（卡片）", format1);
		Label label51 = new Label(51, 0, "成本中心（卡片）", format1);
		Label label52 = new Label(52, 0, "实物管理部门（卡片）", format1);
		Label label53 = new Label(53, 0, "使用保管人（卡片）", format1);
		Label label54 = new Label(54, 0, "车牌号（卡片）", format1);
		Label label55 = new Label(55, 0, "成本中心辅助核算", format1);
		Label label56 = new Label(56, 0, "捐赠类型", format1);
		Label label57 = new Label(57, 0, "监管标识", format1);
		Label label58 = new Label(58, 0, "资产使用情况", format1);
		Label label59 = new Label(59, 0, "资产增加方式", format1);
		Label label60 = new Label(60, 0, "资产变动方式", format1);
		Label label61 = new Label(61, 0, "资产来源", format1);
		Label label62 = new Label(62, 0, "工程性质", format1);
		Label label63 = new Label(63, 0, "固定资产细类", format1);
		Label label64 = new Label(64, 0, "WBS元素（卡片）", format1);
		Label label65 = new Label(65, 0, "WBS元素描述（卡片）", format1);
		Label label66 = new Label(66, 0, "资产存放地点", format1);
		Label label67 = new Label(67, 0, "所属线站名称", format1);
		Label label68 = new Label(68, 0, "房屋产权证号", format1);
		Label label69 = new Label(69, 0, "设备名称", format1);
		Label label70 = new Label(70, 0, "技术对象类型", format1);
		Label label71 = new Label(71, 0, "授权组", format1);
		Label label72 = new Label(72, 0, "规格型号（设备）", format1);
		Label label73 = new Label(73, 0, "设备铭牌号（设备）", format1);
		Label label74 = new Label(74, 0, "维护工厂", format1);
		Label label75 = new Label(75, 0, "设备资产变动方式（设备）", format1);
		Label label76 = new Label(76, 0, "工厂区域", format1);
		Label label77 = new Label(77, 0, "ABC标识", format1);
		Label label78 = new Label(78, 0, "分类字段", format1);
		Label label79 = new Label(79, 0, "成本中心（设备）", format1);
		Label label80 = new Label(80, 0, "WBS元素（设备）", format1);
		Label label81 = new Label(81, 0, "WBS元素描述（设备）", format1);
		Label label82 = new Label(82, 0, "计划工厂", format1);
		Label label83 = new Label(83, 0, "计划员组", format1);
		Label label84 = new Label(84, 0, "主工作中心", format1);
		Label label85 = new Label(85, 0, "功能位置", format1);
		Label label86 = new Label(86, 0, "高级设备", format1);
		Label label87 = new Label(87, 0, "技术标识号", format1);
		Label label88 = new Label(88, 0, "使用保管人（设备）", format1);
		Label label89 = new Label(89, 0, "使用保管部门（设备）", format1);
		Label label90 = new Label(90, 0, "实物管理部门（设备）", format1);
		Label label91 = new Label(91, 0, "设备增加方式（设备）", format1);
		Label label92 = new Label(92, 0, "设备存放地点（设备）", format1);
		Label label93 = new Label(93, 0, "车牌号（设备）", format1);
		Label label94 = new Label(94, 0, "房屋产权证号（设备）", format1);
		Label label95 = new Label(95, 0, "线站标识", format1);
		Label label96 = new Label(96, 0, "报废来源项目描述", format1);
		Label label97 = new Label(97, 0, "报废原因文本", format1);
		Label label98 = new Label(98, 0, "数据抽取日期", format1);
		Label label99 = new Label(99, 0, "数据抽取时间", format1);
		Label label100 = new Label(100, 0, "数据抽取人", format1);
		Label label101 = new Label(101, 0, "资产性质名称", format1);
		Label label102 = new Label(102, 0, "资产性质编码", format1);

		// 将定义好的单元格添加到工作表中
		sheet.addCell(label0);
		sheet.addCell(label1);
		sheet.addCell(label2);
		sheet.addCell(label3);
		sheet.addCell(label4);
		sheet.addCell(label5);
		sheet.addCell(label6);
		sheet.addCell(label7);
		sheet.addCell(label8);
		sheet.addCell(label9);
		sheet.addCell(label10);
		sheet.addCell(label11);
		sheet.addCell(label12);
		sheet.addCell(label13);
		sheet.addCell(label14);
		sheet.addCell(label15);
		sheet.addCell(label16);
		sheet.addCell(label17);
		sheet.addCell(label18);
		sheet.addCell(label19);
		sheet.addCell(label20);
		sheet.addCell(label21);
		sheet.addCell(label22);
		sheet.addCell(label23);
		sheet.addCell(label24);
		sheet.addCell(label25);
		sheet.addCell(label26);
		sheet.addCell(label27);
		sheet.addCell(label28);
		sheet.addCell(label29);
		sheet.addCell(label30);
		sheet.addCell(label31);
		sheet.addCell(label32);
		sheet.addCell(label33);
		sheet.addCell(label34);
		sheet.addCell(label35);
		sheet.addCell(label36);
		sheet.addCell(label37);
		sheet.addCell(label38);
		sheet.addCell(label39);
		sheet.addCell(label40);
		sheet.addCell(label41);
		sheet.addCell(label42);
		sheet.addCell(label43);
		sheet.addCell(label44);
		sheet.addCell(label45);
		sheet.addCell(label46);
		sheet.addCell(label47);
		sheet.addCell(label48);
		sheet.addCell(label49);
		sheet.addCell(label50);
		sheet.addCell(label51);
		sheet.addCell(label52);
		sheet.addCell(label53);
		sheet.addCell(label54);
		sheet.addCell(label55);
		sheet.addCell(label56);
		sheet.addCell(label57);
		sheet.addCell(label58);
		sheet.addCell(label59);
		sheet.addCell(label60);
		sheet.addCell(label61);
		sheet.addCell(label62);
		sheet.addCell(label63);
		sheet.addCell(label64);
		sheet.addCell(label65);
		sheet.addCell(label66);
		sheet.addCell(label67);
		sheet.addCell(label68);
		sheet.addCell(label69);
		sheet.addCell(label70);
		sheet.addCell(label71);
		sheet.addCell(label72);
		sheet.addCell(label73);
		sheet.addCell(label74);
		sheet.addCell(label75);
		sheet.addCell(label76);
		sheet.addCell(label77);
		sheet.addCell(label78);
		sheet.addCell(label79);
		sheet.addCell(label80);
		sheet.addCell(label81);
		sheet.addCell(label82);
		sheet.addCell(label83);
		sheet.addCell(label84);
		sheet.addCell(label85);
		sheet.addCell(label86);
		sheet.addCell(label87);
		sheet.addCell(label88);
		sheet.addCell(label89);
		sheet.addCell(label90);
		sheet.addCell(label91);
		sheet.addCell(label92);
		sheet.addCell(label93);
		sheet.addCell(label94);
		sheet.addCell(label95);
		sheet.addCell(label96);
		sheet.addCell(label97);
		sheet.addCell(label98);
		sheet.addCell(label99);
		sheet.addCell(label100);
		sheet.addCell(label101);
		sheet.addCell(label102);
		for (int i = 0; i < list.size(); i++) {
			int j = i / recordQuantity;

			// System.out.println("i=" + i);
			// System.out.println("(i % 65534) == 0 && i != 0)="+((i %
			// 65534) == 0 && i != 0));
			if ((i % recordQuantity) == 0 && i != 0) {
				// 写入数据并关闭文件
				// System.out.println("I'm Here!");
				try {
					book.write();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					book.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				df = new SimpleDateFormat("yyyy-MM-ddHHmmss");
				now = new Date();
				nowdate = df.format(now);
				// System.out.println("D:/temp/" + tableName + nowdate +j+
				// ".xls");
				try {
					book = Workbook.createWorkbook(new File("D:/temp/" + tableName + "_" + nowdate + "_" + j + ".xls"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// System.out.println("D:/temp/" + tableName + nowdate +j+
				// ".xls");

				sheet = book.createSheet("第一页", 0);
				label0 = new Label(0, 0, "ERP实物资产单体中间表记录ID", format1);
				label1 = new Label(1, 0, "数据版本", format1);
				label2 = new Label(2, 0, "统计年", format1);
				label3 = new Label(3, 0, "日历年", format1);
				label4 = new Label(4, 0, "利润中心名称", format1);
				label5 = new Label(5, 0, "单位（公司代码）", format1);
				label6 = new Label(6, 0, "主资产编号", format1);
				label7 = new Label(7, 0, "资产子编号", format1);
				label8 = new Label(8, 0, "设备编号", format1);
				label9 = new Label(9, 0, "货币", format1);
				label10 = new Label(10, 0, "资产大类", format1);
				label11 = new Label(11, 0, "资产中类", format1);
				label12 = new Label(12, 0, "资产小类", format1);
				label13 = new Label(13, 0, "电压等级（卡片）", format1);
				label14 = new Label(14, 0, "数量（卡片）", format1);
				label15 = new Label(15, 0, "计量的单位（卡片）", format1);
				label16 = new Label(16, 0, "资产原值", format1);
				label17 = new Label(17, 0, "资产净值", format1);
				label18 = new Label(18, 0, "资产状态", format1);
				label19 = new Label(19, 0, "二级单位（利润中心）", format1);
				label20 = new Label(20, 0, "成本控制范围", format1);
				label21 = new Label(21, 0, "资产描述", format1);
				label22 = new Label(22, 0, "项目类型", format1);
				label23 = new Label(23, 0, "资本化日期", format1);
				label24 = new Label(24, 0, "投运日期", format1);
				label25 = new Label(25, 0, "出厂日期", format1);
				label26 = new Label(26, 0, "线路长度", format1);
				label27 = new Label(27, 0, "长度单位", format1);
				label28 = new Label(28, 0, "变电容量", format1);
				label29 = new Label(29, 0, "容量单位", format1);
				label30 = new Label(30, 0, "库存地点（设备）", format1);
				label31 = new Label(31, 0, "备品备件标识", format1);
				label32 = new Label(32, 0, "再利用设备标识", format1);
				label33 = new Label(33, 0, "入再利用库日期", format1);
				label34 = new Label(34, 0, "出再利用库日期", format1);
				label35 = new Label(35, 0, "报废来源项目编号", format1);
				label36 = new Label(36, 0, "报废原因代码", format1);
				label37 = new Label(37, 0, "报废记账日期", format1);
				label38 = new Label(38, 0, "设备状态", format1);
				label39 = new Label(39, 0, "电压等级（设备）", format1);
				label40 = new Label(40, 0, "是否代管", format1);
				label41 = new Label(41, 0, "制造厂商（卡片）", format1);
				label42 = new Label(42, 0, "制造厂商（设备）", format1);
				label43 = new Label(43, 0, "制造商国家", format1);
				label44 = new Label(44, 0, "制造商零件号", format1);
				label45 = new Label(45, 0, "不活动日期", format1);
				label46 = new Label(46, 0, "资产分类", format1);
				label47 = new Label(47, 0, "序列号（卡片）", format1);
				label48 = new Label(48, 0, "存货号（卡片）", format1);
				label49 = new Label(49, 0, "资产所属单位（卡片）", format1);
				label50 = new Label(50, 0, "使用保管单位（卡片）", format1);
				label51 = new Label(51, 0, "成本中心（卡片）", format1);
				label52 = new Label(52, 0, "实物管理部门（卡片）", format1);
				label53 = new Label(53, 0, "使用保管人（卡片）", format1);
				label54 = new Label(54, 0, "车牌号（卡片）", format1);
				label55 = new Label(55, 0, "成本中心辅助核算", format1);
				label56 = new Label(56, 0, "捐赠类型", format1);
				label57 = new Label(57, 0, "监管标识", format1);
				label58 = new Label(58, 0, "资产使用情况", format1);
				label59 = new Label(59, 0, "资产增加方式", format1);
				label60 = new Label(60, 0, "资产变动方式", format1);
				label61 = new Label(61, 0, "资产来源", format1);
				label62 = new Label(62, 0, "工程性质", format1);
				label63 = new Label(63, 0, "固定资产细类", format1);
				label64 = new Label(64, 0, "WBS元素（卡片）", format1);
				label65 = new Label(65, 0, "WBS元素描述（卡片）", format1);
				label66 = new Label(66, 0, "资产存放地点", format1);
				label67 = new Label(67, 0, "所属线站名称", format1);
				label68 = new Label(68, 0, "房屋产权证号", format1);
				label69 = new Label(69, 0, "设备名称", format1);
				label70 = new Label(70, 0, "技术对象类型", format1);
				label71 = new Label(71, 0, "授权组", format1);
				label72 = new Label(72, 0, "规格型号（设备）", format1);
				label73 = new Label(73, 0, "设备铭牌号（设备）", format1);
				label74 = new Label(74, 0, "维护工厂", format1);
				label75 = new Label(75, 0, "设备资产变动方式（设备）", format1);
				label76 = new Label(76, 0, "工厂区域", format1);
				label77 = new Label(77, 0, "ABC标识", format1);
				label78 = new Label(78, 0, "分类字段", format1);
				label79 = new Label(79, 0, "成本中心（设备）", format1);
				label80 = new Label(80, 0, "WBS元素（设备）", format1);
				label81 = new Label(81, 0, "WBS元素描述（设备）", format1);
				label82 = new Label(82, 0, "计划工厂", format1);
				label83 = new Label(83, 0, "计划员组", format1);
				label84 = new Label(84, 0, "主工作中心", format1);
				label85 = new Label(85, 0, "功能位置", format1);
				label86 = new Label(86, 0, "高级设备", format1);
				label87 = new Label(87, 0, "技术标识号", format1);
				label88 = new Label(88, 0, "使用保管人（设备）", format1);
				label89 = new Label(89, 0, "使用保管部门（设备）", format1);
				label90 = new Label(90, 0, "实物管理部门（设备）", format1);
				label91 = new Label(91, 0, "设备增加方式（设备）", format1);
				label92 = new Label(92, 0, "设备存放地点（设备）", format1);
				label93 = new Label(93, 0, "车牌号（设备）", format1);
				label94 = new Label(94, 0, "房屋产权证号（设备）", format1);
				label95 = new Label(95, 0, "线站标识", format1);
				label96 = new Label(96, 0, "报废来源项目描述", format1);
				label97 = new Label(97, 0, "报废原因文本", format1);
				label98 = new Label(98, 0, "数据抽取日期", format1);
				label99 = new Label(99, 0, "数据抽取时间", format1);
				label100 = new Label(100, 0, "数据抽取人", format1);
				label101 = new Label(101, 0, "资产性质名称", format1);
				label102 = new Label(102, 0, "资产性质编码", format1);

				// 将定义好的单元格添加到工作表中
				sheet.addCell(label0);
				sheet.addCell(label1);
				sheet.addCell(label2);
				sheet.addCell(label3);
				sheet.addCell(label4);
				sheet.addCell(label5);
				sheet.addCell(label6);
				sheet.addCell(label7);
				sheet.addCell(label8);
				sheet.addCell(label9);
				sheet.addCell(label10);
				sheet.addCell(label11);
				sheet.addCell(label12);
				sheet.addCell(label13);
				sheet.addCell(label14);
				sheet.addCell(label15);
				sheet.addCell(label16);
				sheet.addCell(label17);
				sheet.addCell(label18);
				sheet.addCell(label19);
				sheet.addCell(label20);
				sheet.addCell(label21);
				sheet.addCell(label22);
				sheet.addCell(label23);
				sheet.addCell(label24);
				sheet.addCell(label25);
				sheet.addCell(label26);
				sheet.addCell(label27);
				sheet.addCell(label28);
				sheet.addCell(label29);
				sheet.addCell(label30);
				sheet.addCell(label31);
				sheet.addCell(label32);
				sheet.addCell(label33);
				sheet.addCell(label34);
				sheet.addCell(label35);
				sheet.addCell(label36);
				sheet.addCell(label37);
				sheet.addCell(label38);
				sheet.addCell(label39);
				sheet.addCell(label40);
				sheet.addCell(label41);
				sheet.addCell(label42);
				sheet.addCell(label43);
				sheet.addCell(label44);
				sheet.addCell(label45);
				sheet.addCell(label46);
				sheet.addCell(label47);
				sheet.addCell(label48);
				sheet.addCell(label49);
				sheet.addCell(label50);
				sheet.addCell(label51);
				sheet.addCell(label52);
				sheet.addCell(label53);
				sheet.addCell(label54);
				sheet.addCell(label55);
				sheet.addCell(label56);
				sheet.addCell(label57);
				sheet.addCell(label58);
				sheet.addCell(label59);
				sheet.addCell(label60);
				sheet.addCell(label61);
				sheet.addCell(label62);
				sheet.addCell(label63);
				sheet.addCell(label64);
				sheet.addCell(label65);
				sheet.addCell(label66);
				sheet.addCell(label67);
				sheet.addCell(label68);
				sheet.addCell(label69);
				sheet.addCell(label70);
				sheet.addCell(label71);
				sheet.addCell(label72);
				sheet.addCell(label73);
				sheet.addCell(label74);
				sheet.addCell(label75);
				sheet.addCell(label76);
				sheet.addCell(label77);
				sheet.addCell(label78);
				sheet.addCell(label79);
				sheet.addCell(label80);
				sheet.addCell(label81);
				sheet.addCell(label82);
				sheet.addCell(label83);
				sheet.addCell(label84);
				sheet.addCell(label85);
				sheet.addCell(label86);
				sheet.addCell(label87);
				sheet.addCell(label88);
				sheet.addCell(label89);
				sheet.addCell(label90);
				sheet.addCell(label91);
				sheet.addCell(label92);
				sheet.addCell(label93);
				sheet.addCell(label94);
				sheet.addCell(label95);
				sheet.addCell(label96);
				sheet.addCell(label97);
				sheet.addCell(label98);
				sheet.addCell(label99);
				sheet.addCell(label100);
				sheet.addCell(label101);
				sheet.addCell(label102);
				df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				// break;
			}
			// System.out.println("j=" + j);
			int recordQuantityTimes = j * recordQuantity;
			Label labelV0 = new Label(0, i + 1 - recordQuantityTimes, list.get(i).getMidErpItemId());
			Label labelV1 = new Label(1, i + 1 - recordQuantityTimes, list.get(i).getVersion());
			// System.out.println("list.get(i).getVersion()" +
			// list.get(i).getVersion());
			Label labelV2 = null;
			if (null != list.get(i).getCalYear()) {
				labelV2 = new Label(2, i + 1 - recordQuantityTimes, df.format(list.get(i).getCalYear()).toString());
			} else {
				labelV2 = new Label(2, i + 1 - recordQuantityTimes, df.format(list.get(i).getCalYear()).toString());
			}
			Label labelV3 = null;
			if (null != list.get(i).getCalyear()) {
				labelV3 = new Label(3, i + 1 - recordQuantityTimes, list.get(i).getCalyear().toString());
			} else {
				labelV3 = new Label(3, i + 1 - recordQuantityTimes, new String(""));
			}
			Label labelV4 = new Label(4, i + 1 - recordQuantityTimes, list.get(i).getOrgName());
			Label labelV5 = new Label(5, i + 1 - recordQuantityTimes, list.get(i).getCompCode());
			Label labelV6 = new Label(6, i + 1 - recordQuantityTimes, list.get(i).getAssetMainNumber());
			Label labelV7 = new Label(7, i + 1 - recordQuantityTimes, list.get(i).getAssetSubnumber());
			Label labelV8 = new Label(8, i + 1 - recordQuantityTimes, list.get(i).getEquipementNumber());
			Label labelV9 = new Label(9, i + 1 - recordQuantityTimes, list.get(i).getCurrency());
			Label labelV10 = new Label(10, i + 1 - recordQuantityTimes, list.get(i).getLargeClass());
			Label labelV11 = new Label(11, i + 1 - recordQuantityTimes, list.get(i).getMediumClass());
			Label labelV12 = new Label(12, i + 1 - recordQuantityTimes, list.get(i).getSmallClass());
			Label labelV13 = new Label(13, i + 1 - recordQuantityTimes, list.get(i).getVoltageLevel());
			Label labelV14 = null;
			if (null != list.get(i).getQuantity()) {
				labelV14 = new Label(14, i + 1 - recordQuantityTimes, list.get(i).getQuantity().toString());
			} else {
				labelV14 = new Label(14, i + 1 - recordQuantityTimes, new String(""));
			}
			Label labelV15 = new Label(15, i + 1 - recordQuantityTimes, list.get(i).getUnit());
			Label labelV16 = null;
			if (null != list.get(i).getOriginalValue()) {
				labelV16 = new Label(16, i + 1 - recordQuantityTimes, list.get(i).getOriginalValue().toString());
			} else {
				labelV16 = new Label(16, i + 1 - recordQuantityTimes, new String(""));
			}
			Label labelV17 = null;
			if (null != list.get(i).getNetValue()) {
				labelV17 = new Label(17, i + 1 - recordQuantityTimes, list.get(i).getNetValue().toString());
			} else {
				labelV17 = new Label(17, i + 1 - recordQuantityTimes, new String(""));
			}
			Label labelV18 = new Label(18, i + 1 - recordQuantityTimes, list.get(i).getAssetStatus());
			Label labelV19 = new Label(19, i + 1 - recordQuantityTimes, list.get(i).getProfitEnterSecLevelUnit());
			Label labelV20 = new Label(20, i + 1 - recordQuantityTimes, list.get(i).getCostControlArea());
			Label labelV21 = new Label(21, i + 1 - recordQuantityTimes, list.get(i).getAssetDescription());
			Label labelV22 = new Label(22, i + 1 - recordQuantityTimes, list.get(i).getProjectType());
			Label labelV23 = null;
			if (null != list.get(i).getCapitalizationDate()) {
				labelV23 = new Label(23, i + 1 - recordQuantityTimes,
						df.format(list.get(i).getCapitalizationDate()).toString());
			} else {
				labelV23 = new Label(23, i + 1 - recordQuantityTimes, new String(""));
			}
			Label labelV24 = null;
			if (null != list.get(i).getDeliveryDate()) {
				labelV24 = new Label(24, i + 1 - recordQuantityTimes,
						df.format(list.get(i).getDeliveryDate()).toString());
			} else {
				labelV24 = new Label(24, i + 1 - recordQuantityTimes, new String(""));
			}
			Label labelV25 = null;
			if (null != list.get(i).getManufactureDate()) {
				labelV25 = new Label(25, i + 1 - recordQuantityTimes,
						df.format(list.get(i).getManufactureDate()).toString());
			} else {
				labelV25 = new Label(25, i + 1 - recordQuantityTimes, new String(""));
			}
			Label labelV26 = null;
			if (null != list.get(i).getLineLength()) {
				labelV26 = new Label(26, i + 1 - recordQuantityTimes, list.get(i).getLineLength().toString());
			} else {
				labelV26 = new Label(26, i + 1 - recordQuantityTimes, new String(""));
			}
			Label labelV27 = new Label(27, i + 1 - recordQuantityTimes, list.get(i).getLengthUnit());
			Label labelV28 = null;
			if (null != list.get(i).getTransformerCapacity()) {
				labelV28 = new Label(28, i + 1 - recordQuantityTimes, list.get(i).getTransformerCapacity().toString());
			} else {
				labelV28 = new Label(28, i + 1 - recordQuantityTimes, new String(""));
			}
			Label labelV29 = new Label(29, i + 1 - recordQuantityTimes, list.get(i).getCapacityUnit());
			Label labelV30 = new Label(30, i + 1 - recordQuantityTimes, list.get(i).getWarehouseAddress());
			Label labelV31 = new Label(31, i + 1 - recordQuantityTimes, list.get(i).getSparePartMark());
			Label labelV32 = new Label(32, i + 1 - recordQuantityTimes, list.get(i).getReusingDeviceMark());
			Label labelV33 = null;
			if (null != list.get(i).getReusingEntryDate()) {
				labelV33 = new Label(33, i + 1 - recordQuantityTimes,
						df.format(list.get(i).getReusingEntryDate()).toString());
			} else {
				labelV33 = new Label(33, i + 1 - recordQuantityTimes, new String(""));
			}
			Label labelV34 = null;
			if (null != list.get(i).getReusingOutDate()) {
				labelV34 = new Label(34, i + 1 - recordQuantityTimes,
						df.format(list.get(i).getReusingOutDate()).toString());
			} else {
				labelV34 = new Label(34, i + 1 - recordQuantityTimes, new String(""));
			}
			Label labelV35 = new Label(35, i + 1 - recordQuantityTimes, list.get(i).getDiscardProjectResourceCode());
			Label labelV36 = new Label(36, i + 1 - recordQuantityTimes, list.get(i).getDiscardReasonCode());
			Label labelV37 = null;
			if (null != list.get(i).getDiscardAccountingDate()) {
				labelV37 = new Label(37, i + 1 - recordQuantityTimes,
						df.format(list.get(i).getDiscardAccountingDate()).toString());
			} else {
				labelV37 = new Label(37, i + 1 - recordQuantityTimes, new String(""));
			}
			Label labelV38 = new Label(38, i + 1 - recordQuantityTimes, list.get(i).getEquipmentStatus());
			Label labelV39 = new Label(39, i + 1 - recordQuantityTimes, list.get(i).getEquipmentVoltageLevel());
			Label labelV40 = new Label(40, i + 1 - recordQuantityTimes, list.get(i).getIsCustody());
			Label labelV41 = new Label(41, i + 1 - recordQuantityTimes, list.get(i).getManufacturerCard());
			Label labelV42 = new Label(42, i + 1 - recordQuantityTimes, list.get(i).getManufacturerEquipement());
			Label labelV43 = new Label(43, i + 1 - recordQuantityTimes, list.get(i).getManufactureState());
			Label labelV44 = new Label(44, i + 1 - recordQuantityTimes, list.get(i).getManufacturePartNumber());
			Label labelV45 = new Label(45, i + 1 - recordQuantityTimes, list.get(i).getInactivityDate());
			Label labelV46 = new Label(46, i + 1 - recordQuantityTimes, list.get(i).getAssetCategory());
			Label labelV47 = new Label(47, i + 1 - recordQuantityTimes, list.get(i).getCardSerialNumber());
			Label labelV48 = new Label(48, i + 1 - recordQuantityTimes, list.get(i).getCardInventoryNumber());
			Label labelV49 = new Label(49, i + 1 - recordQuantityTimes, list.get(i).getCardAssetUnit());
			Label labelV50 = new Label(50, i + 1 - recordQuantityTimes, list.get(i).getCardStorageUnit());
			Label labelV51 = new Label(51, i + 1 - recordQuantityTimes, list.get(i).getCardCostCenter());
			Label labelV52 = new Label(52, i + 1 - recordQuantityTimes, list.get(i).getCardAssetManageDepart());
			Label labelV53 = new Label(53, i + 1 - recordQuantityTimes, list.get(i).getCardUsingCustodian());
			Label labelV54 = new Label(54, i + 1 - recordQuantityTimes, list.get(i).getCardCarLicense());
			Label labelV55 = new Label(55, i + 1 - recordQuantityTimes, list.get(i).getCostCenterAuxilAccounting());
			Label labelV56 = new Label(56, i + 1 - recordQuantityTimes, list.get(i).getDonationType());
			Label labelV57 = new Label(57, i + 1 - recordQuantityTimes, list.get(i).getSuperviseSign());
			Label labelV58 = new Label(58, i + 1 - recordQuantityTimes, list.get(i).getAssetUsingInformation());
			Label labelV59 = new Label(59, i + 1 - recordQuantityTimes, list.get(i).getAssetIncreaseMethod());
			Label labelV60 = new Label(60, i + 1 - recordQuantityTimes, list.get(i).getAssetChangeMode());
			Label labelV61 = new Label(61, i + 1 - recordQuantityTimes, list.get(i).getAssetOrigin());
			Label labelV62 = new Label(62, i + 1 - recordQuantityTimes, list.get(i).getEngineeringProperty());
			Label labelV63 = new Label(63, i + 1 - recordQuantityTimes, list.get(i).getFixedAssetClass());
			Label labelV64 = new Label(64, i + 1 - recordQuantityTimes, list.get(i).getCardWbsElement());
			Label labelV65 = new Label(65, i + 1 - recordQuantityTimes, list.get(i).getCardWbsElementDesc());
			Label labelV66 = new Label(66, i + 1 - recordQuantityTimes, list.get(i).getAssetStorageAddress());
			Label labelV67 = new Label(67, i + 1 - recordQuantityTimes, list.get(i).getLineStationName());
			Label labelV68 = new Label(68, i + 1 - recordQuantityTimes, list.get(i).getHousePropCertifiNum());
			Label labelV69 = new Label(69, i + 1 - recordQuantityTimes, list.get(i).getEquipementName());
			Label labelV70 = new Label(70, i + 1 - recordQuantityTimes, list.get(i).getTechnicalObjectType());
			Label labelV71 = new Label(71, i + 1 - recordQuantityTimes, list.get(i).getAuthorizationGroup());
			Label labelV72 = new Label(72, i + 1 - recordQuantityTimes, list.get(i).getEquipSpecificationModel());
			Label labelV73 = new Label(73, i + 1 - recordQuantityTimes, list.get(i).getEquipNameplateNumber());
			Label labelV74 = new Label(74, i + 1 - recordQuantityTimes, list.get(i).getMaintenanceFactory());
			Label labelV75 = new Label(75, i + 1 - recordQuantityTimes, list.get(i).getEquipAssetChangeMode());
			Label labelV76 = new Label(76, i + 1 - recordQuantityTimes, list.get(i).getFactoryArea());
			Label labelV77 = new Label(77, i + 1 - recordQuantityTimes, list.get(i).getAbcIdentification());
			Label labelV78 = new Label(78, i + 1 - recordQuantityTimes, list.get(i).getClassifiedField());
			Label labelV79 = new Label(79, i + 1 - recordQuantityTimes, list.get(i).getEquipmentCostCenter());
			Label labelV80 = new Label(80, i + 1 - recordQuantityTimes, list.get(i).getEquipmentWbsElement());
			Label labelV81 = new Label(81, i + 1 - recordQuantityTimes, list.get(i).getEquipWbsElementDesc());
			Label labelV82 = new Label(82, i + 1 - recordQuantityTimes, list.get(i).getPlanFactory());
			Label labelV83 = new Label(83, i + 1 - recordQuantityTimes, list.get(i).getPlanGroup());
			Label labelV84 = new Label(84, i + 1 - recordQuantityTimes, list.get(i).getMainWorkCenter());
			Label labelV85 = new Label(85, i + 1 - recordQuantityTimes, list.get(i).getFunctionalPosition());
			Label labelV86 = new Label(86, i + 1 - recordQuantityTimes, list.get(i).getAdvancedEquipment());
			Label labelV87 = new Label(87, i + 1 - recordQuantityTimes, list.get(i).getTechIdentificationNumber());
			Label labelV88 = new Label(88, i + 1 - recordQuantityTimes, list.get(i).getEquipUseCustodian());
			Label labelV89 = new Label(89, i + 1 - recordQuantityTimes, list.get(i).getEquipStorageDepartment());
			Label labelV90 = new Label(90, i + 1 - recordQuantityTimes, list.get(i).getEquipObjectManageDeparment());
			Label labelV91 = new Label(91, i + 1 - recordQuantityTimes, list.get(i).getEpqipmentIncreaseMethod());
			Label labelV92 = new Label(92, i + 1 - recordQuantityTimes, list.get(i).getEquipmentSotrageAddress());
			Label labelV93 = new Label(93, i + 1 - recordQuantityTimes, list.get(i).getEquipCarLicense());
			Label labelV94 = new Label(94, i + 1 - recordQuantityTimes, list.get(i).getEquipHousePropCertifiNum());
			// System.out.println("list.get(i).getLineStationLogo()=" +
			// list.get(i).getLineStationLogo());
			Label labelV95 = new Label(95, i + 1 - recordQuantityTimes, list.get(i).getLineStationLogo());
			Label labelV96 = new Label(96, i + 1 - recordQuantityTimes, list.get(i).getDiscardOriginProjectDesc());
			Label labelV97 = new Label(97, i + 1 - recordQuantityTimes, list.get(i).getDiscardReasonContent());
			// System.out.println("list.get(i).getDiscardReasonContent()=" +
			// list.get(i).getDiscardReasonContent());
			Label labelV98 = null;
			if (null != list.get(i).getDataExtractDate()) {
				labelV98 = new Label(98, i + 1 - recordQuantityTimes,
						df.format(list.get(i).getDataExtractDate()).toString());
			} else {
				labelV98 = new Label(98, i + 1 - recordQuantityTimes, new String(""));
			}
			Label labelV99 = null;
			if (null != list.get(i).getDataExtractTime()) {
				labelV99 = new Label(99, i + 1 - recordQuantityTimes,
						df.format(list.get(i).getDataExtractTime()).toString());
			} else {
				labelV99 = new Label(99, i + 1 - recordQuantityTimes, new String(""));
			}
			Label labelV100 = new Label(100, i + 1 - recordQuantityTimes, list.get(i).getDataExtractPerson());
			Label labelV101 = new Label(101, i + 1 - recordQuantityTimes, list.get(i).getAssetProperty());
			Label labelV102 = new Label(102, i + 1 - recordQuantityTimes, list.get(i).getPropertyCode());
			// System.out.println("list.get(i).getPropertyCode()=" +
			// list.get(i).getPropertyCode());
			// System.out.println("getLineStationName");
			// System.out.println("i=" + i);

			sheet.addCell(labelV0);
			sheet.addCell(labelV1);
			sheet.addCell(labelV2);
			sheet.addCell(labelV3);
			sheet.addCell(labelV4);
			sheet.addCell(labelV5);
			sheet.addCell(labelV6);
			sheet.addCell(labelV7);
			sheet.addCell(labelV8);
			sheet.addCell(labelV9);
			sheet.addCell(labelV10);
			sheet.addCell(labelV11);
			sheet.addCell(labelV12);
			sheet.addCell(labelV13);
			sheet.addCell(labelV14);
			sheet.addCell(labelV15);
			sheet.addCell(labelV16);
			sheet.addCell(labelV17);
			sheet.addCell(labelV18);
			sheet.addCell(labelV19);
			sheet.addCell(labelV20);
			sheet.addCell(labelV21);
			sheet.addCell(labelV22);
			sheet.addCell(labelV23);
			sheet.addCell(labelV24);
			sheet.addCell(labelV25);
			sheet.addCell(labelV26);
			sheet.addCell(labelV27);
			sheet.addCell(labelV28);
			sheet.addCell(labelV29);
			sheet.addCell(labelV30);
			sheet.addCell(labelV31);
			sheet.addCell(labelV32);
			sheet.addCell(labelV33);
			sheet.addCell(labelV34);
			sheet.addCell(labelV35);
			sheet.addCell(labelV36);
			sheet.addCell(labelV37);
			sheet.addCell(labelV38);
			sheet.addCell(labelV39);
			sheet.addCell(labelV40);
			sheet.addCell(labelV41);
			sheet.addCell(labelV42);
			sheet.addCell(labelV43);
			sheet.addCell(labelV44);
			sheet.addCell(labelV45);
			sheet.addCell(labelV46);
			sheet.addCell(labelV47);
			sheet.addCell(labelV48);
			sheet.addCell(labelV49);
			sheet.addCell(labelV50);
			sheet.addCell(labelV51);
			sheet.addCell(labelV52);
			sheet.addCell(labelV53);
			sheet.addCell(labelV54);
			sheet.addCell(labelV55);
			sheet.addCell(labelV56);
			sheet.addCell(labelV57);
			sheet.addCell(labelV58);
			sheet.addCell(labelV59);
			sheet.addCell(labelV60);
			sheet.addCell(labelV61);
			sheet.addCell(labelV62);
			sheet.addCell(labelV63);
			sheet.addCell(labelV64);
			sheet.addCell(labelV65);
			sheet.addCell(labelV66);
			sheet.addCell(labelV67);
			sheet.addCell(labelV68);
			sheet.addCell(labelV69);
			sheet.addCell(labelV70);
			sheet.addCell(labelV71);
			sheet.addCell(labelV72);
			sheet.addCell(labelV73);
			sheet.addCell(labelV74);
			sheet.addCell(labelV75);
			sheet.addCell(labelV76);
			sheet.addCell(labelV77);
			sheet.addCell(labelV78);
			sheet.addCell(labelV79);
			sheet.addCell(labelV80);
			sheet.addCell(labelV81);
			sheet.addCell(labelV82);
			sheet.addCell(labelV83);
			sheet.addCell(labelV84);
			sheet.addCell(labelV85);
			sheet.addCell(labelV86);
			sheet.addCell(labelV87);
			sheet.addCell(labelV88);
			sheet.addCell(labelV89);
			sheet.addCell(labelV90);
			sheet.addCell(labelV91);
			sheet.addCell(labelV92);
			sheet.addCell(labelV93);
			sheet.addCell(labelV94);
			sheet.addCell(labelV95);
			sheet.addCell(labelV96);
			sheet.addCell(labelV97);
			sheet.addCell(labelV98);
			sheet.addCell(labelV99);
			sheet.addCell(labelV100);
			sheet.addCell(labelV101);
			sheet.addCell(labelV102);

			System.out.println("i=" + (i + 1));
		}
		System.out.println(sheet.toString());
		// }

		// 写入数据并关闭文件
		try {
			book.write();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			book.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("创建文件成功!");
		now = new Date();
		nowdate = df.format(now);
		System.out.println("Now time is :" + nowdate);

		return true;
	}

	public static List<TableColumnProperty> getHeadList(Connection conn, String tableName, int columnNameOrComment) {

		// String tableName = "MID_ERP_ITEM_2018_1";
		// int columnNameOrComment = 1;
		// Connection conn = null;
		// conn = Dbutil.getConnection();
		// 创建预编译语句对象，一般都是用这个而不用Statement
		PreparedStatement pre = null;
		// 创建一个结果集对象
		ResultSet result = null;
		String sql = "SELECT B.COLUMN_ID COLUMN_ID,B.COLUMN_NAME COLUMN_NAME,B.DATA_TYPE DATA_TYPE,"
				+ "B.DATA_LENGTH DATA_LENGTH,B.DATA_PRECISION DATA_PRECISION,B.DATA_SCALE DATA_SCALE,"
				+ "A.COMMENTS COLUMN_COMMENT  FROM USER_COL_COMMENTS A  INNER JOIN USER_TAB_COLUMNS B"
				+ " ON A.COLUMN_NAME=B.COLUMN_NAME   AND A.TABLE_NAME=B.TABLE_NAME" + " WHERE B.TABLE_NAME= '"
				+ tableName + "' ORDER BY B.COLUMN_ID";
		System.out.println("sqlStr=" + sql);
		try {
			pre = conn.prepareStatement(sql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} // 实例化预编译语句
		try {
			result = pre.executeQuery();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} // 执行查询，注意括号中不需要再加参数

		Integer columnId = null;
		String columnName = null;
		String dataType = null;
		Integer dataLength = null;
		Integer dataPrecision = null;
		Integer dataScale = null;
		String columnComment = null;
		List<TableColumnProperty> tableColumnList = new ArrayList<TableColumnProperty>();
		try {
			while (result.next()) {
				if (null != result.getString("COLUMN_ID")) {
					columnId = new Integer(result.getString("COLUMN_ID"));
				}
				columnName = result.getString("COLUMN_NAME");
				dataType = result.getString("DATA_TYPE");
				if (null != result.getString("DATA_LENGTH")) {
					dataLength = new Integer(result.getString("DATA_LENGTH"));
				}
				if (null != result.getString("DATA_PRECISION")) {
					dataPrecision = new Integer(result.getString("DATA_PRECISION"));
				}
				if (null != result.getString("DATA_SCALE")) {
					dataScale = new Integer(result.getString("DATA_SCALE"));
				}
				columnComment = result.getString("COLUMN_COMMENT");

				tableColumnList.add(new TableColumnProperty(columnId, columnName, dataType, dataLength, dataPrecision,
						dataScale, columnComment));
			}
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			result.close();
			pre.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tableColumnList;
	}

	/**
	 * 
	 * @param targetTable
	 * @param dataVersion 通过targetTable与dataVersion联合起来检查新确定导入的数据的版本值在版本管理表D_VERSION中是否存在，如存在返回
	 */
	public static boolean dataVersionCheck(String targetTable, String dataVersion) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		String sqlString = "SELECT TARGET_TABLE,COUNT(*) QUANTITY FROM D_VERSION "
				+ "WHERE TARGET_TABLE=? AND VERSION_VALUE=? " + "GROUP BY TARGET_TABLE";
		SQLQuery sqlQuery = session.createSQLQuery(sqlString);
		sqlQuery.setString(0, targetTable);
		sqlQuery.setString(1, dataVersion);

		System.out.println("sqlString:" + sqlString);
		// 下面的方法将查询的结果所有记录转换成以查询语句中字段名对应的数组对象，可以将结果转换成以字段为key的map
		List list = sqlQuery.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		for (int i = 0; i < list.size(); i++) {
			Map map = (Map) list.get(i);
			System.out.println("QUANTITY=" + map.get("QUANTITY"));
			System.out.println("dataVersion=" + dataVersion);
			System.out.println("TARGET_TABLE=" + map.get("TARGET_TABLE"));
		}
		System.out.println("list.size()=" + list.size());
		return sqlQuery.list().size() > 0;
	}

	/**
	 * @return
	 */
	public static boolean exportZfiSwzc(String tableName) {
		// int recordQuantity = 30000;
		int recordQuantity = 10000;
		// int recordQuantity = 35000;
		// int recordQuantity = 65534;
		// int recordQuantity = 50000;
		int columnNameOrComment = 1;
		List<ZfiSwzc2019> list = new ArrayList<ZfiSwzc2019>();
		try {
			Connection conn = null;
			conn = DbUtil.getConnection();
			List<TableColumnProperty> headList = getHeadList(conn, tableName, columnNameOrComment);
			// 创建预编译语句对象，一般都是用这个而不用Statement
			PreparedStatement pre = null;
			// 创建一个结果集对象
			ResultSet result = null;

			String sql = "select * from " + tableName;
			pre = conn.prepareStatement(sql);// 实例化预编译语句
			result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String areaName = null;
			String zfiSwzcId = null;
			String version = null;
			Date calYear = null;
			Double calyear = null;
			String compCode = null;
			String assetMain = null;
			String asset = null;
			String equnr = null;
			String currency = null;
			Double zpmzcyz = null;
			Double zpmzcjz = null;
			String ztypbz1 = null;
			String ztypbz2 = null;
			String ztypbz3 = null;
			String zvolLev = null;
			Double zquantity = null;
			String unit = null;
			String zioZczt = null;
			String profitCtr = null;
			String zlrzx = null;
			String coArea = null;
			String zzcms = null;
			String zioZxmlx = null;
			String aktiv = null;
			String deakt = null;
			String anlkl = null;
			String sernr = null;
			String invnr = null;
			String zzc001 = null;
			String zzc002 = null;
			String kostl = null;
			String kostlv = null;
			String raumn = null;
			String kfzkz = null;
			String zzas1 = null;
			String zzc006 = null;
			String zzc007 = null;
			String ord41 = null;
			String ord44 = null;
			String gdlgrp = null;
			String izwek = null;
			String umwkz = null;
			String anlue = null;
			String herst = null;
			String typbz = null;
			String zkpwbs = null;
			String zkpwbsms = null;
			String fiamt = null;
			String stadt = null;
			String zfwcqzh = null;
			String eqktx = null;
			String txt04 = null;
			String eqart = null;
			String begru = null;
			String inbdt = null;
			String zccrq = null;
			String zherst = null;
			String herld = null;
			String mapar = null;
			String ztypbz = null;
			String serge = null;
			String swerk = null;
			String stort = null;
			String beber = null;
			String abckz = null;
			String eqfnr = null;
			String zkostl = null;
			String zsbwbs = null;
			String zsbwbsms = null;
			String iwerk = null;
			String ingrp = null;
			String gewrk = null;
			String tplnr = null;
			String hequi = null;
			String tidnr = null;
			String zsb010 = null;
			String zsb001 = null;
			String zsb002 = null;
			String zsb004 = null;
			String zsb005 = null;
			String zsb006 = null;
			String zsb003 = null;
			String zsb007 = null;
			String zsb008 = null;
			String zlenunt = null;
			String zsb009 = null;
			String zcapunt = null;
			String zsb011 = null;
			String zeq003 = null;
			String zeq001 = null;
			String zeq002 = null;
			String zlyrkrq = null;
			String zlyckrq = null;
			String zbfjzrq = null;
			String zbfxmbm = null;
			String zbfxmms = null;
			String zbfyydm = null;
			String zbfyywb = null;
			String cdate = null;
			String ctime = null;
			String cname = null;
			String stext4 = null;
			String ztypbz1t = null;
			String ztypbz2t = null;
			String ztypbz3t = null;
			String assetProperty = null;
			String propertyCode = null;
			String assetId = null;
			String dataSourceFile = null;

			System.out.println("Ready in loop!");
			int i = 1;
			Runtime run = Runtime.getRuntime();
			Double maxMem = new Double(run.maxMemory() / 1024 / 1024);
			Double freeMem = new Double(run.freeMemory() / 1024 / 1024);
			Double totalMem = new Double(run.totalMemory() / 1024 / 1024);
			int outj = 1;
			// long usedMem = maxMem - freeMem;
			while (result.next()) {
				run = Runtime.getRuntime();
				maxMem = new Double(run.maxMemory() / 1024 / 1024);
				freeMem = new Double(run.freeMemory() / 1024 / 1024);
				totalMem = new Double(run.totalMemory() / 1024 / 1024);
				if ((new Double(run.totalMemory()) / new Double(run.maxMemory()) > 0.60)
						&& (new Double(run.freeMemory()) / new Double(run.maxMemory()) < 0.30)) {
					System.out.println("output " + (outj++) + "times!");
					boolean BResult = false;
					try {
						// BResult = writeMidErpItemIntoXls(tableName, list,
						// recordQuantity);
						BResult = writeZfiSwzcIntoXls(headList, tableName, list, recordQuantity, columnNameOrComment);
						list.clear();
						list = null;
						list = new ArrayList<ZfiSwzc2019>();
					} catch (RowsExceededException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (WriteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				// usedMem = maxMem - freeMem;
				// System.out.println("Add!");
				System.out.println("i=" + (i++) + ",usedMemPercent=" + new Double(totalMem / maxMem)
						+ ",freeMemPercent=" + new Double(freeMem / maxMem) + ",maxMem=" + (maxMem) + ",freeMem="
						+ (freeMem) + ",usedMem=" + (totalMem) + ",totalMem=" + (totalMem));
				zfiSwzcId = result.getString("ZFI_SWZC_ID");
				version = result.getString("VERSION");
				areaName = result.getString("AREA_NAME");
				if (null != result.getString("CAL_YEAR")) {
					try {
						calYear = simpleDateFormat.parse(result.getString("CAL_YEAR"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				try {
					calyear = new DecimalFormat().parse(result.getString("CALYEAR")).doubleValue();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				compCode = result.getString("COMP_CODE");
				assetMain = result.getString("ASSET_MAIN");
				asset = result.getString("ASSET");
				equnr = result.getString("EQUNR");
				currency = result.getString("CURRENCY");
				try {
					zpmzcyz = new DecimalFormat().parse(result.getString("ZPMZCYZ")).doubleValue();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					zpmzcjz = new DecimalFormat().parse(result.getString("ZPMZCJZ")).doubleValue();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ztypbz1 = result.getString("ZTYPBZ1");
				ztypbz2 = result.getString("ZTYPBZ2");
				ztypbz3 = result.getString("ZTYPBZ3");
				zvolLev = result.getString("ZVOL_LEV");
				try {
					zquantity = new DecimalFormat().parse(result.getString("ZQUANTITY")).doubleValue();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				unit = result.getString("UNIT");
				zioZczt = result.getString("ZIO_ZCZT");
				profitCtr = result.getString("PROFIT_CTR");
				zlrzx = result.getString("ZLRZX");
				coArea = result.getString("CO_AREA");
				zzcms = result.getString("ZZCMS");
				zioZxmlx = result.getString("ZIO_ZXMLX");
				aktiv = result.getString("AKTIV");
				deakt = result.getString("DEAKT");
				anlkl = result.getString("ANLKL");
				sernr = result.getString("SERNR");
				invnr = result.getString("INVNR");
				zzc001 = result.getString("ZZC001");
				zzc002 = result.getString("ZZC002");
				kostl = result.getString("KOSTL");
				kostlv = result.getString("KOSTLV");
				raumn = result.getString("RAUMN");
				kfzkz = result.getString("KFZKZ");
				zzas1 = result.getString("ZZAS1");
				zzc006 = result.getString("ZZC006");
				zzc007 = result.getString("ZZC007");
				ord41 = result.getString("ORD41");
				ord44 = result.getString("ORD44");
				gdlgrp = result.getString("GDLGRP");
				izwek = result.getString("IZWEK");
				umwkz = result.getString("UMWKZ");
				anlue = result.getString("ANLUE");
				herst = result.getString("HERST");
				typbz = result.getString("TYPBZ");
				zkpwbs = result.getString("ZKPWBS");
				zkpwbsms = result.getString("ZKPWBSMS");
				fiamt = result.getString("FIAMT");
				stadt = result.getString("STADT");
				zfwcqzh = result.getString("ZFWCQZH");
				eqktx = result.getString("EQKTX");
				txt04 = result.getString("TXT04");
				eqart = result.getString("EQART");
				begru = result.getString("BEGRU");
				inbdt = result.getString("INBDT");
				zccrq = result.getString("ZCCRQ");
				zherst = result.getString("ZHERST");
				herld = result.getString("HERLD");
				mapar = result.getString("MAPAR");
				ztypbz = result.getString("ZTYPBZ");
				serge = result.getString("SERGE");
				swerk = result.getString("SWERK");
				stort = result.getString("STORT");
				beber = result.getString("BEBER");
				abckz = result.getString("ABCKZ");
				eqfnr = result.getString("EQFNR");
				zkostl = result.getString("ZKOSTL");
				zsbwbs = result.getString("ZSBWBS");
				zsbwbsms = result.getString("ZSBWBSMS");
				iwerk = result.getString("IWERK");
				ingrp = result.getString("INGRP");
				gewrk = result.getString("GEWRK");
				tplnr = result.getString("TPLNR");
				hequi = result.getString("HEQUI");
				tidnr = result.getString("TIDNR");
				zsb010 = result.getString("ZSB010");
				zsb001 = result.getString("ZSB001");
				zsb002 = result.getString("ZSB002");
				zsb004 = result.getString("ZSB004");
				zsb005 = result.getString("ZSB005");
				zsb006 = result.getString("ZSB006");
				zsb003 = result.getString("ZSB003");
				zsb007 = result.getString("ZSB007");
				zsb008 = result.getString("ZSB008");
				zlenunt = result.getString("ZLENUNT");
				zsb009 = result.getString("ZSB009");
				zcapunt = result.getString("ZCAPUNT");
				zsb011 = result.getString("ZSB011");
				zeq003 = result.getString("ZEQ003");
				zeq001 = result.getString("ZEQ001");
				zeq002 = result.getString("ZEQ002");
				zlyrkrq = result.getString("ZLYRKRQ");
				zlyckrq = result.getString("ZLYCKRQ");
				zbfjzrq = result.getString("ZBFJZRQ");
				zbfxmbm = result.getString("ZBFXMBM");
				zbfxmms = result.getString("ZBFXMMS");
				zbfyydm = result.getString("ZBFYYDM");
				zbfyywb = result.getString("ZBFYYWB");
				cdate = result.getString("CDATE");
				ctime = result.getString("CTIME");
				cname = result.getString("CNAME");
				// stext4 = result.getString("STEXT4");
				/*
				 * ztypbz1t = result.getString("ZTYPBZ1T"); ztypbz2t =
				 * result.getString("ZTYPBZ2T"); ztypbz3t = result.getString("ZTYPBZ3T");
				 */
				assetProperty = result.getString("ASSET_PROPERTY");
				propertyCode = result.getString("PROPERTY_CODE");
				assetId = result.getString("ASSET_ID");
				dataSourceFile = result.getString("DATA_SOURCE_FILE");
				list.add(new ZfiSwzc2019(zfiSwzcId, calYear, calyear, compCode, assetMain, asset, equnr, currency,
						zpmzcyz, zpmzcjz, ztypbz1, ztypbz2, ztypbz3, zvolLev, zquantity, unit, zioZczt, profitCtr,
						zlrzx, coArea, zzcms, zioZxmlx, aktiv, deakt, anlkl, sernr, invnr, zzc001, zzc002, kostl,
						kostlv, raumn, kfzkz, zzas1, zzc006, zzc007, ord41, ord44, gdlgrp, izwek, umwkz, anlue, herst,
						typbz, zkpwbs, zkpwbsms, fiamt, stadt, zfwcqzh, eqktx, txt04, eqart, begru, inbdt, zccrq,
						zherst, herld, mapar, ztypbz, serge, swerk, stort, beber, abckz, eqfnr, zkostl, zsbwbs,
						zsbwbsms, iwerk, ingrp, gewrk, tplnr, hequi, tidnr, zsb010, zsb001, zsb002, zsb004, zsb005,
						zsb006, zsb003, zsb007, zsb008, zlenunt, zsb009, zcapunt, zsb011, zeq003, zeq001, zeq002,
						zlyrkrq, zlyckrq, zbfjzrq, zbfxmbm, zbfxmms, zbfyydm, zbfyywb, cdate, ctime, cname, stext4,
						ztypbz1t, ztypbz2t, ztypbz3t, assetProperty, propertyCode, assetId, dataSourceFile, areaName));
			}

			if (list.size() != 0) {
				System.out.println("The last times output!");
				boolean BResult = false;
				try {
					// BResult = writeMidErpItemIntoXls(tableName, list,
					// recordQuantity);
					BResult = writeZfiSwzcIntoXls(headList, tableName, list, recordQuantity, columnNameOrComment);
					list.clear();
				} catch (RowsExceededException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (WriteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * 
	 * @param targetTable
	 * @param dataVersion 通过targetTable与dataVersion对应年限的最大数据版本编号，形成新的数据版本值并返回
	 */
	public static String getMaxDataVersion(String targetTable, String dataVersion) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		String maxVersion = "";
		String sqlString = "SELECT DATA_TYPE,TARGET_TABLE,YEAR_VALUE,MAX(SUB_VERSION) SUB_VERSION FROM D_VERSION "
				+ "WHERE TARGET_TABLE=? AND YEAR_VALUE=? GROUP BY DATA_TYPE,TARGET_TABLE,YEAR_VALUE";
		SQLQuery sqlQuery = session.createSQLQuery(sqlString);
		sqlQuery.setString(0, targetTable);
		sqlQuery.setString(1, dataVersion.substring(dataVersion.indexOf("_") + 1, dataVersion.indexOf("_") + 5));

		// System.out.println("sqlString:"+sqlString);
		/**
		 * 下面的方法将查询的结果所有转换成以查询语句 中字段名对应的数组对象，可以将结果转换成以字段为key的map
		 * 通过setResultTransformer将查询语句执行后得到的结果链表记录 每一行中的字段转换成Map来取出值
		 */
		List list = sqlQuery.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();

		// System.out.println("list.size()="+list.size());
		if (list.size() > 1) {
			System.out.println("返回值多余一条，请核查......");
		} else if (list.size() == 0) {
			maxVersion = dataVersion;
		} else {
			Map map = (Map) list.get(0);
			// System.out.println("DATA_TYPE="+map.get("DATA_TYPE"));
			// System.out.println("SUB_VERSION="+map.get("SUB_VERSION"));
			maxVersion = map.get("DATA_TYPE") + "_" + map.get("YEAR_VALUE") + "_"
					+ (((BigDecimal) map.get("SUB_VERSION")).intValue() + 1);
		}
		return maxVersion;
	}

	/**
	 * 
	 * @param tableName
	 * @param coefficientTableName
	 * @param coefficientType
	 * @param versionValue
	 * @return
	 * 
	 * 		在原来polynomialRegressionCaculation(...)的基础上添加了数值型变量的二阶项计算，即错位相乘项的构建。
	 * 
	 */
	public static boolean standardMarginalCostAndRevenue(String tableName, String coefficientTableName,
			String coefficientType, String versionValue, String valueType) {

		int recordQuantity = 600;
		int columnNameOrComment = 1;
		List<List<YTableCellString>> rsTransOverhaMargCost110List = new ArrayList<List<YTableCellString>>();

		try {
			Connection conn = null;
			conn = DbUtil.getConnection();
			List<TableColumnProperty> headList = getHeadList(conn, tableName, columnNameOrComment);
			List<TableColumnProperty> headList2 = getHeadList(conn, tableName, columnNameOrComment);

			// 创建预编译语句对象，一般都是用这个而不用Statement
			PreparedStatement pre = null;
			// 创建一个结果集对象
			ResultSet coeffResult = null;

			String coefficientSql = "select * from " + coefficientTableName + " where action_type='" + coefficientType
					+ "' and version_value='" + versionValue + "' order by indexof";
			System.out.println("coefficientSql=" + coefficientSql);
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

			pre = conn.prepareStatement(coefficientSql);// 实例化预编译语句
			coeffResult = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
			List<RsPolynRegressCoefficient> rsPolynRegressCoefficientList = new ArrayList<RsPolynRegressCoefficient>();
			while (coeffResult.next()) {
				RsPolynRegressCoefficient rsPolynRegressCoefficient = new RsPolynRegressCoefficient();
				rsPolynRegressCoefficient.setRsPolynRegressCoeffId(coeffResult.getString("RS_POLYN_REGRESS_COEFF_ID"));
				rsPolynRegressCoefficient.setVariableRelationId(coeffResult.getString("VARIABLE_RELATION_ID"));
				rsPolynRegressCoefficient.setVersionValue(coeffResult.getString("VERSION_VALUE"));
				if (!(coeffResult.getString("CAL_YEAR").trim().isEmpty())) {
					try {
						rsPolynRegressCoefficient.setCalYear(simpleDateFormat.parse(coeffResult.getString("CAL_YEAR")));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				rsPolynRegressCoefficient.setActionType(coeffResult.getString("ACTION_TYPE"));
				if (coeffResult.getInt("INDEXOF") == 0) {
					rsPolynRegressCoefficient.setIndexof(0);
				} else {
					rsPolynRegressCoefficient.setIndexof(coeffResult.getInt("INDEXOF"));
				}
				rsPolynRegressCoefficient.setVariableName(coeffResult.getString("VARIABLE_NAME"));
				rsPolynRegressCoefficient.setCoefficientName(coeffResult.getString("COEFFICIENT_NAME"));
				rsPolynRegressCoefficient.setCoefficientValue(coeffResult.getDouble("COEFFICIENT_VALUE"));
				rsPolynRegressCoefficient.setBintLeftValue(coeffResult.getString("BINT_LEFT_VALUE"));
				rsPolynRegressCoefficient.setBintRightValue(coeffResult.getString("BINT_RIGHT_VALUE"));
				rsPolynRegressCoefficient.setRValue(coeffResult.getString("R_VALUE"));
				rsPolynRegressCoefficient.setRintLeftValue(coeffResult.getString("RINT_LEFT_VALUE"));
				rsPolynRegressCoefficient.setRintRightValue(coeffResult.getString("RINT_RIGHT_VALUE"));
				rsPolynRegressCoefficient.setStatsValue(coeffResult.getString("STATS_VALUE"));

				rsPolynRegressCoefficientList.add(rsPolynRegressCoefficient);

			}

			// 创建一个结果集对象
			ResultSet result = null;

			String sql = "select * from " + tableName + " a where a.xa<=20";
			pre = conn.prepareStatement(sql);// 实例化预编译语句
			result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
			Double rsTransOverhaMargCostId = null;
			String manufacturerName = null;
			String sbxh = null;
			Double y1 = null;

			System.out.println("Ready in loop!");
			int i = 1;
			Runtime run = Runtime.getRuntime();
			Double maxMem = new Double(run.maxMemory() / 1024 / 1024);
			Double freeMem = new Double(run.freeMemory() / 1024 / 1024);
			Double totalMem = new Double(run.totalMemory() / 1024 / 1024);
			int outj = 1;
			// long usedMem = maxMem - freeMem;
			int limitQuantityI = 1;
			while (result.next()) {
				run = Runtime.getRuntime();
				maxMem = new Double(run.maxMemory() / 1024 / 1024);
				freeMem = new Double(run.freeMemory() / 1024 / 1024);
				totalMem = new Double(run.totalMemory() / 1024 / 1024);

				// usedMem = maxMem - freeMem;
				System.out.println("i=" + (i++) + ",usedMemPercent=" + new Double(totalMem / maxMem)
						+ ",freeMemPercent=" + new Double(freeMem / maxMem) + ",maxMem=" + (maxMem) + ",freeMem="
						+ (freeMem) + ",usedMem=" + (totalMem) + ",totalMem=" + (totalMem));

				if (null == result.getString("RS_TRANS_OVERHA_MARG_COST_ID")) {
					rsTransOverhaMargCostId = 0.0;
				} else {
					rsTransOverhaMargCostId = new Double(result.getString("RS_TRANS_OVERHA_MARG_COST_ID"));
				}
				manufacturerName = result.getString("MANUFACTURER_NAME");
				sbxh = result.getString("SBXH");

				List<YTableCellString> alllRowArrayList = new ArrayList<YTableCellString>();
				List<YTableCellString> mTableCellList = new ArrayList<YTableCellString>();
				List<YTableCellString> tTableCellList = new ArrayList<YTableCellString>();
				List<YTableCellString> aTableCellList = new ArrayList<YTableCellString>();
				System.out.println();
				for (int headI = 1; headI < headList.size(); headI++) {

					if (headList.get(headI).getColumnName().contains("XM")) {
						YTableCellString mTableCell = new YTableCellString(headList.get(headI).getColumnId(),
								headList.get(headI).getColumnName(),
								result.getString(headList.get(headI).getColumnName()));

						mTableCellList.add(mTableCell);
						alllRowArrayList.add(mTableCell);
						// System.out.println(headList.get(headI).getColumnName() + "="
						// + (new Double(result.getString(headList.get(headI).getColumnName()))));
					} else if (headList.get(headI).getColumnName().contains("XT")) {
						YTableCellString tTableCell = new YTableCellString(headList.get(headI).getColumnId(),
								headList.get(headI).getColumnName(),
								result.getString(headList.get(headI).getColumnName()));

						tTableCellList.add(tTableCell);
						alllRowArrayList.add(tTableCell);
						// System.out.println(headList.get(headI).getColumnName() + "="
						// + (new Double(result.getString(headList.get(headI).getColumnName()))));
					} else if (headList.get(headI).getColumnName().contains("XA")) {
						YTableCellString aTableCell = new YTableCellString(headList.get(headI).getColumnId(),
								headList.get(headI).getColumnName(),
								result.getString(headList.get(headI).getColumnName()));

						aTableCellList.add(aTableCell);
						alllRowArrayList.add(aTableCell);
						// System.out.println(headList.get(headI).getColumnName() + "="
						// + (result.getString(headList.get(headI).getColumnName())));
					} else {
						YTableCellString tTableCell = new YTableCellString(headList.get(headI).getColumnId(),
								headList.get(headI).getColumnName(),
								result.getString(headList.get(headI).getColumnName()));
						alllRowArrayList.add(tTableCell);
						// System.out.println(headList.get(headI).getColumnName() + "="
						// + (result.getString(headList.get(headI).getColumnName())));
					}
				}
				int sizeLimit = 0;
				int headListSizeI = headList.size();
				int headListSize = headList.size();
				int alllRowArrayListI = alllRowArrayList.size();
				int mTableCellListSize = mTableCellList.size();
				int tTableCellListSize = tTableCellList.size();
				int aTableCellListSize = aTableCellList.size();
				System.out.println("mTableCellListSize*tTableCellListSize=" + mTableCellListSize * tTableCellListSize);
				/* 此部分为XM*XM的构造部分 */
				for (int mI = 0; mI < mTableCellListSize; mI++) {
					if (headList2.size() < headListSize + mTableCellListSize + 1) {
						/**
						 * 此处使用if语句是需要在第一次循环时完成表头的数据生成，即只会运行一次， if之后的则为生成的数据的存储过程。
						 */
						headList2.add(new TableColumnProperty(headListSizeI + 1,
								mTableCellList.get(mI).getColumnName() + mTableCellList.get(mI).getColumnName(),
								"Double", 100, 100, 100, ""));
						headListSizeI++;
					}
					/**
					 * 以下部分完成第一类字符型变量的二阶值计算
					 */
					alllRowArrayList.add(new YTableCellString(alllRowArrayListI + 1,
							mTableCellList.get(mI).getColumnName() + mTableCellList.get(mI).getColumnName(),
							(new Double(mTableCellList.get(mI).getCellValue())
									* (new Double(mTableCellList.get(mI).getCellValue()))) + ""));
					alllRowArrayListI++;

				}

				/* 此部分为Xt*Xt的构造部分 */
				for (int tI = 0; tI < tTableCellListSize; tI++) {
					if (headList2.size() < headListSize + mTableCellListSize + tTableCellListSize + 1) {
						/**
						 * 此处使用if语句是需要在第一次循环时完成表头的数据生成，即只会运行一次， if之后的则为生成的数据的存储过程。
						 */
						headList2.add(new TableColumnProperty(headListSizeI + 1,
								tTableCellList.get(tI).getColumnName() + tTableCellList.get(tI).getColumnName(),
								"Double", 100, 100, 100, ""));
						headListSizeI++;
					}
					/**
					 * 以下部分完成第二类字符型变量的二阶值计算
					 */
					alllRowArrayList.add(new YTableCellString(alllRowArrayListI + 1,
							tTableCellList.get(tI).getColumnName() + tTableCellList.get(tI).getColumnName(),
							(new Double(tTableCellList.get(tI).getCellValue())
									* (new Double(tTableCellList.get(tI).getCellValue()))) + ""));
					alllRowArrayListI++;

				}
				/* 此部分为Xa*Xa的构造部分 */
				for (int aI = 0; aI < aTableCellListSize; aI++) {
					if (headList2.size() < headListSize + mTableCellListSize + tTableCellListSize + aTableCellListSize
							+ 1) {
						/**
						 * 此处使用if语句是需要在第一次循环时完成表头的数据生成，即只会运行一次， if之后的则为生成的数据的存储过程。
						 */
						headList2.add(new TableColumnProperty(headListSizeI + 1,
								aTableCellList.get(aI).getColumnName() + aTableCellList.get(aI).getColumnName(),
								"Double", 100, 100, 100, ""));
						headListSizeI++;
					}
					/**
					 * 以下部分完成数值型变量的二阶值计算
					 */
					alllRowArrayList.add(new YTableCellString(alllRowArrayListI + 1,
							aTableCellList.get(aI).getColumnName() + aTableCellList.get(aI).getColumnName(),
							(new Double(aTableCellList.get(aI).getCellValue())
									* (new Double(aTableCellList.get(aI).getCellValue()))) + ""));
					alllRowArrayListI++;

				}
				/* 此部分为Xm*Xt的构造部分 */
				for (int tI = 0; tI < tTableCellListSize; tI++) {
					for (int mI = 0; mI < mTableCellListSize; mI++) {
						if (headList2.size() < headListSize + mTableCellListSize + tTableCellListSize
								+ aTableCellListSize + mTableCellListSize * tTableCellListSize + 1) {
							/**
							 * 此处使用if语句是需要在第一次循环时完成表头的数据生成，即只会运行一次， if之后的则为生成的数据的存储过程。
							 */
							headList2.add(new TableColumnProperty(headListSizeI + 1,
									mTableCellList.get(mI).getColumnName() + tTableCellList.get(tI).getColumnName(),
									"Double", 100, 100, 100, ""));
							headListSizeI++;
						}
						/**
						 * 以下部分完成第一个类型字符型变量与第二个类型字符型变量的错位相乘
						 */
						alllRowArrayList.add(new YTableCellString(alllRowArrayListI + 1,
								mTableCellList.get(mI).getColumnName() + tTableCellList.get(tI).getColumnName(),
								(new Double(mTableCellList.get(mI).getCellValue())
										* (new Double(tTableCellList.get(tI).getCellValue()))) + ""));
						alllRowArrayListI++;
					}

				}
				/* 此部分为Xm*Xa的构造部分 */
				for (int aI = 0; aI < aTableCellListSize; aI++) {
					for (int mI = 0; mI < mTableCellListSize; mI++) {
						if (headList2.size() < headListSize + mTableCellListSize + tTableCellListSize
								+ aTableCellListSize + mTableCellListSize * tTableCellListSize
								+ mTableCellListSize * aTableCellListSize + 1) {
							/**
							 * 此处使用if语句是需要在第一次循环时完成表头的数据生成，即只会运行一次， if之后的则为生成的数据的存储过程。
							 */
							headList2.add(new TableColumnProperty(headListSizeI + 1,
									mTableCellList.get(mI).getColumnName() + aTableCellList.get(aI).getColumnName(),
									"Double", 100, 100, 100, ""));
							headListSizeI++;
						}
						/**
						 * 以下部分完成第一个类型字符型变量与数值型变量的错位相乘
						 */
						alllRowArrayList.add(new YTableCellString(alllRowArrayListI + 1,
								mTableCellList.get(mI).getColumnName() + aTableCellList.get(aI).getColumnName(),
								(new Double(mTableCellList.get(mI).getCellValue())
										* (new Double(aTableCellList.get(aI).getCellValue()))) + ""));
						alllRowArrayListI++;
					}

				}
				/* 此部分为Xt*Xa的构造部分 */
				for (int aI = 0; aI < aTableCellListSize; aI++) {
					for (int tI = 0; tI < tTableCellListSize; tI++) {
						if (headList2.size() < headListSize + mTableCellListSize + tTableCellListSize
								+ aTableCellListSize + mTableCellListSize * tTableCellListSize
								+ mTableCellListSize * aTableCellListSize + tTableCellListSize * aTableCellListSize
								+ 1) {
							/**
							 * 此处使用if语句是需要在第一次循环时完成表头的数据生成，即只会运行一次， if之后的则为生成的数据的存储过程。
							 */
							headList2.add(new TableColumnProperty(headListSizeI + 1,
									tTableCellList.get(tI).getColumnName() + aTableCellList.get(aI).getColumnName(),
									"Double", 100, 100, 100, ""));
							headListSizeI++;
						}
						/**
						 * 以下部分完成第二个类型字符型变量与数值型变量的错位相乘
						 */
						alllRowArrayList.add(new YTableCellString(alllRowArrayListI + 1,
								tTableCellList.get(tI).getColumnName() + aTableCellList.get(aI).getColumnName(),
								(new Double(tTableCellList.get(tI).getCellValue())
										* (new Double(aTableCellList.get(aI).getCellValue()))) + ""));
						alllRowArrayListI++;
					}

				}
				/* 此部分为Xa*Xa错位相乘部分的构造 */
				int aTableSize = aTableCellListSize;
				sizeLimit = headListSize + mTableCellListSize + tTableCellListSize + aTableCellListSize
						+ mTableCellListSize * tTableCellListSize + mTableCellListSize * aTableCellListSize
						+ tTableCellListSize * aTableCellListSize + 1;
				for (int aI = 0; aI < aTableCellListSize; aI++) {
					/**
					 * 数值型变量，每一个元素需要与其它元素只相乘一次； 因此向后移动一次表头的长度限制即相应增加 aTableCellListSize -aI-1个长度。
					 */
					sizeLimit = sizeLimit + aTableSize - aI - 1;
					for (int aJ = aI + 1; aJ < aTableCellListSize; aJ++) {
						/**
						 * 此处使用if语句是需要在第一次循环时完成表头的数据生成，即只会运行一次， if之后的则为生成的数据的存储过程。
						 */
						if (headList2.size() < sizeLimit) {
							headList2.add(new TableColumnProperty(headListSizeI + 1,
									aTableCellList.get(aJ).getColumnName() + aTableCellList.get(aI).getColumnName(),
									"Double", 100, 100, 100, ""));
							headListSizeI++;
						}

						/**
						 * 以下部分实现错误相乘数据的生成
						 */
						alllRowArrayList.add(new YTableCellString(alllRowArrayListI + 1,
								aTableCellList.get(aJ).getColumnName() + aTableCellList.get(aI).getColumnName(),
								(new Double(aTableCellList.get(aJ).getCellValue())
										* (new Double(aTableCellList.get(aI).getCellValue()))) + ""));
						alllRowArrayListI++;

					}

				}
				rsTransOverhaMargCost110List.add(alllRowArrayList);
				limitQuantityI++;
			}

			// pre.close();
			// Connection conn2 = null;
			// conn2 = Dbutil.getConnection();

			// PreparedStatement pre2 = null;
			String y1CostValueUpdateSql = "update " + tableName
					+ " a set a.y1=? where a.MANUFACTURER_NAME=? and a.sbxh =? and a.xa=?";
			String y1RavenuValueUpdateSql = "update " + tableName
					+ " a set a.Y1_REVENUE=? where a.MANUFACTURER_NAME=? and a.sbxh =? and a.xa=?";
			if (valueType.contentEquals("COST")) {
				pre = conn.prepareStatement(y1CostValueUpdateSql);
				System.out.println("y1CostValueUpdateSql=" + y1CostValueUpdateSql);
			} else {
				pre = conn.prepareStatement(y1RavenuValueUpdateSql);
				System.out.println("y1RavenuValueUpdateSql=" + y1RavenuValueUpdateSql);
			}
			for (int rsTransI = 0; rsTransI < rsTransOverhaMargCost110List.size(); rsTransI++) {
				Double y1Value = rsPolynRegressCoefficientList.get(0).getCoefficientValue();

				List<YTableCellString> rowElementList = rsTransOverhaMargCost110List.get(rsTransI);
				String manufactName = null;
				String equipmentModel = null;
				Double equipmentAge = 0.0;
				// .matches("^XM[0-9]*XM[0-9]*")
				for (int elemI = 0; elemI < rowElementList.size(); elemI++) {

					if (rowElementList.get(elemI).getColumnName().equals("MANUFACTURER_NAME")) {
						manufactName = rowElementList.get(elemI).getCellValue();
					}
					if (rowElementList.get(elemI).getColumnName().equals("SBXH")) {
						equipmentModel = rowElementList.get(elemI).getCellValue();
					}
					if (rowElementList.get(elemI).getColumnName().equals("XA")) {
						equipmentAge = new Double(rowElementList.get(elemI).getCellValue());
					}

					if (rowElementList.get(elemI).getColumnName().matches("^X.*")
							&& (new Double(rowElementList.get(elemI).getCellValue())) != 0) {
						for (int rsPolyI = 0; rsPolyI < rsPolynRegressCoefficientList.size(); rsPolyI++) {
							if (rsPolynRegressCoefficientList.get(rsPolyI).getVariableName().matches("^X.*")
									&& rsPolynRegressCoefficientList.get(rsPolyI).getVariableName()
											.equals(rowElementList.get(elemI).getColumnName())
									&& rsPolynRegressCoefficientList.get(rsPolyI).getCoefficientValue() != 0) {
								// System.out.println("rowElementList.get(elemI).getColumnName()="+rowElementList.get(elemI).getColumnName()+"rsPolynRegressCoefficientList.get(rsPolyI).getVariableName()="+rsPolynRegressCoefficientList.get(rsPolyI).getVariableName());
								// System.out.println("rsPolynRegressCoefficientList.get(rsPolyI).getCoefficientValue()="+rsPolynRegressCoefficientList.get(rsPolyI).getCoefficientValue()
								// +",rowElementList.get(elemI).getCellValue()="+rowElementList.get(elemI).getCellValue());

								y1Value = y1Value + rsPolynRegressCoefficientList.get(rsPolyI).getCoefficientValue()
										* (new Double(rowElementList.get(elemI).getCellValue()));
							}
						}
					}

				}
				// String y1ValueUpdateSql="update "+tableName+" a set a.y1="+y1Value+" where
				// a.MANUFACTURER_NAME='"+manufactName+"' and a.sbxh ='"
				// +equipmentModel+"' and a.xa="+equipmentAge+"";

				pre.setDouble(1, y1Value);
				pre.setString(2, manufactName);
				pre.setString(3, equipmentModel);
				pre.setDouble(4, equipmentAge);
				pre.addBatch();
				pre.executeBatch();
				// pre2 = conn.prepareStatement(y1ValueUpdateSql);// 实例化预编译语句
				// pre2.execute();// 执行查询，注意括号中不需要再加参数
				System.out.println("y1Value=" + y1Value);
				// 更新表

			}
			// pre.close();

			/*
			 * if (rsTransOverhaMargCost110List.size() != 0) {
			 * System.out.println("The last times output!"); boolean BResult = false; try {
			 * BResult = writeRsTransOverhaMargCost110POIXLSXString(headList2, tableName,
			 * rsTransOverhaMargCost110List, recordQuantity, columnNameOrComment);
			 * rsTransOverhaMargCost110List.clear(); headList2.clear(); } catch
			 * (RowsExceededException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); } catch (WriteException e) { // TODO Auto-generated
			 * catch block e.printStackTrace(); } }
			 */

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * 
	 * @param tableName
	 * @param coefficientTableName
	 * @param coefficientType
	 * @param versionValue
	 * @return
	 * 
	 * 
	 * 
	 */
	public static boolean polynomialRegressionCaculation(String tableName, String coefficientTableName,
			String coefficientType, String versionValue, String valueType) {

		int recordQuantity = 600;
		int columnNameOrComment = 1;
		List<List<YTableCellString>> rsTransOverhaMargCost110List = new ArrayList<List<YTableCellString>>();

		try {
			Connection conn = null;
			conn = DbUtil.getConnection();
			List<TableColumnProperty> headList = getHeadList(conn, tableName, columnNameOrComment);
			List<TableColumnProperty> headList2 = getHeadList(conn, tableName, columnNameOrComment);

			// 创建预编译语句对象，一般都是用这个而不用Statement
			PreparedStatement pre = null;
			// 创建一个结果集对象
			ResultSet coeffResult = null;

			String coefficientSql = "select * from " + coefficientTableName + " where action_type='" + coefficientType
					+ "' and version_value='" + versionValue + "' order by indexof";
			System.out.println("coefficientSql=" + coefficientSql);
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

			pre = conn.prepareStatement(coefficientSql);// 实例化预编译语句
			coeffResult = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
			List<RsPolynRegressCoefficient> rsPolynRegressCoefficientList = new ArrayList<RsPolynRegressCoefficient>();
			while (coeffResult.next()) {
				RsPolynRegressCoefficient rsPolynRegressCoefficient = new RsPolynRegressCoefficient();
				rsPolynRegressCoefficient.setRsPolynRegressCoeffId(coeffResult.getString("RS_POLYN_REGRESS_COEFF_ID"));
				rsPolynRegressCoefficient.setVariableRelationId(coeffResult.getString("VARIABLE_RELATION_ID"));
				rsPolynRegressCoefficient.setVersionValue(coeffResult.getString("VERSION_VALUE"));
				if (!(coeffResult.getString("CAL_YEAR").trim().isEmpty())) {
					try {
						rsPolynRegressCoefficient.setCalYear(simpleDateFormat.parse(coeffResult.getString("CAL_YEAR")));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				rsPolynRegressCoefficient.setActionType(coeffResult.getString("ACTION_TYPE"));
				if (coeffResult.getInt("INDEXOF") == 0) {
					rsPolynRegressCoefficient.setIndexof(0);
				} else {
					rsPolynRegressCoefficient.setIndexof(coeffResult.getInt("INDEXOF"));
				}
				rsPolynRegressCoefficient.setVariableName(coeffResult.getString("VARIABLE_NAME"));
				rsPolynRegressCoefficient.setCoefficientName(coeffResult.getString("COEFFICIENT_NAME"));
				rsPolynRegressCoefficient.setCoefficientValue(coeffResult.getDouble("COEFFICIENT_VALUE"));
				rsPolynRegressCoefficient.setBintLeftValue(coeffResult.getString("BINT_LEFT_VALUE"));
				rsPolynRegressCoefficient.setBintRightValue(coeffResult.getString("BINT_RIGHT_VALUE"));
				rsPolynRegressCoefficient.setRValue(coeffResult.getString("R_VALUE"));
				rsPolynRegressCoefficient.setRintLeftValue(coeffResult.getString("RINT_LEFT_VALUE"));
				rsPolynRegressCoefficient.setRintRightValue(coeffResult.getString("RINT_RIGHT_VALUE"));
				rsPolynRegressCoefficient.setStatsValue(coeffResult.getString("STATS_VALUE"));

				rsPolynRegressCoefficientList.add(rsPolynRegressCoefficient);

			}

			// 创建一个结果集对象
			ResultSet result = null;

			String sql = "select * from " + tableName + " a where a.xa>20";
			pre = conn.prepareStatement(sql);// 实例化预编译语句
			result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
			Double rsTransOverhaMargCostId = null;
			String manufacturerName = null;
			String sbxh = null;
			Double y1 = null;

			System.out.println("Ready in loop!");
			int i = 1;
			Runtime run = Runtime.getRuntime();
			Double maxMem = new Double(run.maxMemory() / 1024 / 1024);
			Double freeMem = new Double(run.freeMemory() / 1024 / 1024);
			Double totalMem = new Double(run.totalMemory() / 1024 / 1024);
			int outj = 1;
			// long usedMem = maxMem - freeMem;
			int limitQuantityI = 1;
			while (result.next()) {
				run = Runtime.getRuntime();
				maxMem = new Double(run.maxMemory() / 1024 / 1024);
				freeMem = new Double(run.freeMemory() / 1024 / 1024);
				totalMem = new Double(run.totalMemory() / 1024 / 1024);

				// usedMem = maxMem - freeMem;
				System.out.println("i=" + (i++) + ",usedMemPercent=" + new Double(totalMem / maxMem)
						+ ",freeMemPercent=" + new Double(freeMem / maxMem) + ",maxMem=" + (maxMem) + ",freeMem="
						+ (freeMem) + ",usedMem=" + (totalMem) + ",totalMem=" + (totalMem));

				if (null == result.getString("RS_TRANS_OVERHA_MARG_COST_ID")) {
					rsTransOverhaMargCostId = 0.0;
				} else {
					rsTransOverhaMargCostId = new Double(result.getString("RS_TRANS_OVERHA_MARG_COST_ID"));
				}
				manufacturerName = result.getString("MANUFACTURER_NAME");
				sbxh = result.getString("SBXH");

				List<YTableCellString> alllRowArrayList = new ArrayList<YTableCellString>();
				List<YTableCellString> mTableCellList = new ArrayList<YTableCellString>();
				List<YTableCellString> tTableCellList = new ArrayList<YTableCellString>();
				List<YTableCellString> aTableCellList = new ArrayList<YTableCellString>();
				System.out.println();
				for (int headI = 1; headI < headList.size(); headI++) {

					if (headList.get(headI).getColumnName().contains("XM")) {
						YTableCellString mTableCell = new YTableCellString(headList.get(headI).getColumnId(),
								headList.get(headI).getColumnName(),
								result.getString(headList.get(headI).getColumnName()));

						mTableCellList.add(mTableCell);
						alllRowArrayList.add(mTableCell);
						// System.out.println(headList.get(headI).getColumnName() + "="
						// + (new Double(result.getString(headList.get(headI).getColumnName()))));
					} else if (headList.get(headI).getColumnName().contains("XT")) {
						YTableCellString tTableCell = new YTableCellString(headList.get(headI).getColumnId(),
								headList.get(headI).getColumnName(),
								result.getString(headList.get(headI).getColumnName()));

						tTableCellList.add(tTableCell);
						alllRowArrayList.add(tTableCell);
						// System.out.println(headList.get(headI).getColumnName() + "="
						// + (new Double(result.getString(headList.get(headI).getColumnName()))));
					} else if (headList.get(headI).getColumnName().contains("XA")) {
						YTableCellString aTableCell = new YTableCellString(headList.get(headI).getColumnId(),
								headList.get(headI).getColumnName(),
								result.getString(headList.get(headI).getColumnName()));

						aTableCellList.add(aTableCell);
						alllRowArrayList.add(aTableCell);
						// System.out.println(headList.get(headI).getColumnName() + "="
						// + (result.getString(headList.get(headI).getColumnName())));
					} else {
						YTableCellString tTableCell = new YTableCellString(headList.get(headI).getColumnId(),
								headList.get(headI).getColumnName(),
								result.getString(headList.get(headI).getColumnName()));
						alllRowArrayList.add(tTableCell);
						// System.out.println(headList.get(headI).getColumnName() + "="
						// + (result.getString(headList.get(headI).getColumnName())));
					}
				}
				int headListSizeI = headList.size();
				int headListSize = headList.size();
				int alllRowArrayListI = alllRowArrayList.size();
				int mTableCellListSize = mTableCellList.size();
				int tTableCellListSize = tTableCellList.size();
				int aTableCellListSize = aTableCellList.size();
				System.out.println("mTableCellListSize*tTableCellListSize=" + mTableCellListSize * tTableCellListSize);
				/* 此部分为XM*XM的构造部分 */
				for (int mI = 0; mI < mTableCellListSize; mI++) {
					if (headList2.size() < headListSize + mTableCellListSize + 1) {
						/**
						 * 此处使用if语句是需要在第一次循环时完成表头的数据生成，即只会运行一次， if之后的则为生成的数据的存储过程。
						 */
						headList2.add(new TableColumnProperty(headListSizeI + 1,
								mTableCellList.get(mI).getColumnName() + mTableCellList.get(mI).getColumnName(),
								"Double", 100, 100, 100, ""));
						headListSizeI++;
					}
					/**
					 * 以下部分完成第一类字符型变量的二阶值计算
					 */
					alllRowArrayList.add(new YTableCellString(alllRowArrayListI + 1,
							mTableCellList.get(mI).getColumnName() + mTableCellList.get(mI).getColumnName(),
							(new Double(mTableCellList.get(mI).getCellValue())
									* (new Double(mTableCellList.get(mI).getCellValue()))) + ""));
					alllRowArrayListI++;

				}

				/* 此部分为Xt*Xt的构造部分 */
				for (int tI = 0; tI < tTableCellListSize; tI++) {
					if (headList2.size() < headListSize + mTableCellListSize + tTableCellListSize + 1) {
						/**
						 * 此处使用if语句是需要在第一次循环时完成表头的数据生成，即只会运行一次， if之后的则为生成的数据的存储过程。
						 */
						headList2.add(new TableColumnProperty(headListSizeI + 1,
								tTableCellList.get(tI).getColumnName() + tTableCellList.get(tI).getColumnName(),
								"Double", 100, 100, 100, ""));
						headListSizeI++;
					}
					/**
					 * 以下部分完成第二类字符型变量的二阶值计算
					 */
					alllRowArrayList.add(new YTableCellString(alllRowArrayListI + 1,
							tTableCellList.get(tI).getColumnName() + tTableCellList.get(tI).getColumnName(),
							(new Double(tTableCellList.get(tI).getCellValue())
									* (new Double(tTableCellList.get(tI).getCellValue()))) + ""));
					alllRowArrayListI++;

				}
				/* 此部分为Xa*Xa的构造部分 */
				for (int aI = 0; aI < aTableCellListSize; aI++) {
					if (headList2.size() < headListSize + mTableCellListSize + tTableCellListSize + aTableCellListSize
							+ 1) {
						/**
						 * 此处使用if语句是需要在第一次循环时完成表头的数据生成，即只会运行一次， if之后的则为生成的数据的存储过程。
						 */
						headList2.add(new TableColumnProperty(headListSizeI + 1,
								aTableCellList.get(aI).getColumnName() + aTableCellList.get(aI).getColumnName(),
								"Double", 100, 100, 100, ""));
						headListSizeI++;
					}
					/**
					 * 以下部分完成数值型变量的二阶值计算
					 */
					alllRowArrayList.add(new YTableCellString(alllRowArrayListI + 1,
							aTableCellList.get(aI).getColumnName() + aTableCellList.get(aI).getColumnName(),
							(new Double(aTableCellList.get(aI).getCellValue())
									* (new Double(aTableCellList.get(aI).getCellValue()))) + ""));
					alllRowArrayListI++;

				}
				/* 此部分为Xm*Xt的构造部分 */
				for (int tI = 0; tI < tTableCellListSize; tI++) {
					for (int mI = 0; mI < mTableCellListSize; mI++) {
						if (headList2.size() < headListSize + mTableCellListSize + tTableCellListSize
								+ aTableCellListSize + mTableCellListSize * tTableCellListSize + 1) {
							/**
							 * 此处使用if语句是需要在第一次循环时完成表头的数据生成，即只会运行一次， if之后的则为生成的数据的存储过程。
							 */
							headList2.add(new TableColumnProperty(headListSizeI + 1,
									mTableCellList.get(mI).getColumnName() + tTableCellList.get(tI).getColumnName(),
									"Double", 100, 100, 100, ""));
							headListSizeI++;
						}
						/**
						 * 以下部分完成第一个类型字符型变量与第二个类型字符型变量的错位相乘
						 */
						alllRowArrayList.add(new YTableCellString(alllRowArrayListI + 1,
								mTableCellList.get(mI).getColumnName() + tTableCellList.get(tI).getColumnName(),
								(new Double(mTableCellList.get(mI).getCellValue())
										* (new Double(tTableCellList.get(tI).getCellValue()))) + ""));
						alllRowArrayListI++;
					}

				}
				/* 此部分为Xm*Xa的构造部分 */
				for (int aI = 0; aI < aTableCellListSize; aI++) {
					for (int mI = 0; mI < mTableCellListSize; mI++) {
						if (headList2.size() < headListSize + mTableCellListSize + tTableCellListSize
								+ aTableCellListSize + mTableCellListSize * tTableCellListSize
								+ mTableCellListSize * aTableCellListSize + 1) {
							/**
							 * 此处使用if语句是需要在第一次循环时完成表头的数据生成，即只会运行一次， if之后的则为生成的数据的存储过程。
							 */
							headList2.add(new TableColumnProperty(headListSizeI + 1,
									mTableCellList.get(mI).getColumnName() + aTableCellList.get(aI).getColumnName(),
									"Double", 100, 100, 100, ""));
							headListSizeI++;
						}
						/**
						 * 以下部分完成第一个类型字符型变量与数值型变量的错位相乘
						 */
						alllRowArrayList.add(new YTableCellString(alllRowArrayListI + 1,
								mTableCellList.get(mI).getColumnName() + aTableCellList.get(aI).getColumnName(),
								(new Double(mTableCellList.get(mI).getCellValue())
										* (new Double(aTableCellList.get(aI).getCellValue()))) + ""));
						alllRowArrayListI++;
					}

				}
				/* 此部分为Xt*Xa的构造部分 */
				for (int aI = 0; aI < aTableCellListSize; aI++) {
					for (int tI = 0; tI < tTableCellListSize; tI++) {
						if (headList2.size() < headListSize + mTableCellListSize + tTableCellListSize
								+ aTableCellListSize + mTableCellListSize * tTableCellListSize
								+ mTableCellListSize * aTableCellListSize + tTableCellListSize * aTableCellListSize
								+ 1) {
							/**
							 * 此处使用if语句是需要在第一次循环时完成表头的数据生成，即只会运行一次， if之后的则为生成的数据的存储过程。
							 */
							headList2.add(new TableColumnProperty(headListSizeI + 1,
									tTableCellList.get(tI).getColumnName() + aTableCellList.get(aI).getColumnName(),
									"Double", 100, 100, 100, ""));
							headListSizeI++;
						}
						/**
						 * 以下部分完成第二个类型字符型变量与数值型变量的错位相乘
						 */
						alllRowArrayList.add(new YTableCellString(alllRowArrayListI + 1,
								tTableCellList.get(tI).getColumnName() + aTableCellList.get(aI).getColumnName(),
								(new Double(tTableCellList.get(tI).getCellValue())
										* (new Double(aTableCellList.get(aI).getCellValue()))) + ""));
						alllRowArrayListI++;
					}

				}

				rsTransOverhaMargCost110List.add(alllRowArrayList);
				limitQuantityI++;
			}

			// pre.close();
			// Connection conn2 = null;
			// conn2 = Dbutil.getConnection();

			// PreparedStatement pre2 = null;
			String y1CostValueUpdateSql = "update " + tableName
					+ " a set a.y1=? where a.MANUFACTURER_NAME=? and a.sbxh =? and a.xa=?";
			String y1RavenuValueUpdateSql = "update " + tableName
					+ " a set a.Y1_REVENUE=? where a.MANUFACTURER_NAME=? and a.sbxh =? and a.xa=?";
			if (valueType.contentEquals("COST")) {
				pre = conn.prepareStatement(y1CostValueUpdateSql);
				System.out.println("y1CostValueUpdateSql=" + y1CostValueUpdateSql);
			} else {
				pre = conn.prepareStatement(y1RavenuValueUpdateSql);
				System.out.println("y1RavenuValueUpdateSql=" + y1RavenuValueUpdateSql);
			}
			for (int rsTransI = 0; rsTransI < rsTransOverhaMargCost110List.size(); rsTransI++) {
				Double y1Value = rsPolynRegressCoefficientList.get(0).getCoefficientValue();

				List<YTableCellString> rowElementList = rsTransOverhaMargCost110List.get(rsTransI);
				String manufactName = null;
				String equipmentModel = null;
				Double equipmentAge = 0.0;
				// .matches("^XM[0-9]*XM[0-9]*")
				for (int elemI = 0; elemI < rowElementList.size(); elemI++) {

					if (rowElementList.get(elemI).getColumnName().equals("MANUFACTURER_NAME")) {
						manufactName = rowElementList.get(elemI).getCellValue();
					}
					if (rowElementList.get(elemI).getColumnName().equals("SBXH")) {
						equipmentModel = rowElementList.get(elemI).getCellValue();
					}
					if (rowElementList.get(elemI).getColumnName().equals("XA")) {
						equipmentAge = new Double(rowElementList.get(elemI).getCellValue());
					}

					if (rowElementList.get(elemI).getColumnName().matches("^X.*")
							&& (new Double(rowElementList.get(elemI).getCellValue())) != 0) {
						for (int rsPolyI = 0; rsPolyI < rsPolynRegressCoefficientList.size(); rsPolyI++) {
							if (rsPolynRegressCoefficientList.get(rsPolyI).getVariableName().matches("^X.*")
									&& rsPolynRegressCoefficientList.get(rsPolyI).getVariableName()
											.equals(rowElementList.get(elemI).getColumnName())
									&& rsPolynRegressCoefficientList.get(rsPolyI).getCoefficientValue() != 0) {
								// System.out.println("rowElementList.get(elemI).getColumnName()="+rowElementList.get(elemI).getColumnName()+"rsPolynRegressCoefficientList.get(rsPolyI).getVariableName()="+rsPolynRegressCoefficientList.get(rsPolyI).getVariableName());
								// System.out.println("rsPolynRegressCoefficientList.get(rsPolyI).getCoefficientValue()="+rsPolynRegressCoefficientList.get(rsPolyI).getCoefficientValue()
								// +",rowElementList.get(elemI).getCellValue()="+rowElementList.get(elemI).getCellValue());

								y1Value = y1Value + rsPolynRegressCoefficientList.get(rsPolyI).getCoefficientValue()
										* (new Double(rowElementList.get(elemI).getCellValue()));
							}
						}
					}

				}
				// String y1ValueUpdateSql="update "+tableName+" a set a.y1="+y1Value+" where
				// a.MANUFACTURER_NAME='"+manufactName+"' and a.sbxh ='"
				// +equipmentModel+"' and a.xa="+equipmentAge+"";

				pre.setDouble(1, y1Value);
				pre.setString(2, manufactName);
				pre.setString(3, equipmentModel);
				pre.setDouble(4, equipmentAge);
				pre.addBatch();
				pre.executeBatch();
				// pre2 = conn.prepareStatement(y1ValueUpdateSql);// 实例化预编译语句
				// pre2.execute();// 执行查询，注意括号中不需要再加参数
				System.out.println("y1Value=" + y1Value);
				// 更新表

			}
			// pre.close();

			/*
			 * if (rsTransOverhaMargCost110List.size() != 0) {
			 * System.out.println("The last times output!"); boolean BResult = false; try {
			 * BResult = writeRsTransOverhaMargCost110POIXLSXString(headList2, tableName,
			 * rsTransOverhaMargCost110List, recordQuantity, columnNameOrComment);
			 * rsTransOverhaMargCost110List.clear(); headList2.clear(); } catch
			 * (RowsExceededException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); } catch (WriteException e) { // TODO Auto-generated
			 * catch block e.printStackTrace(); } }
			 */

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * 
	 * @param tableName
	 * @param maxUsedMemoryPercent 最大已使用内存空间占比，与maxFreeMemoryPercent结合控制一次向XLSX表中存入的数据量，防止数据量过大超出JAVA虚拟机的内存。
	 * @param maxFreeMemoryPercent 最大可用内存空间占比，与maxUsedMemoryPercent结合控制一次向XLSX表中存入的数据量，防止数据量过大超出JAVA虚拟机的内存。
	 *                             以上两个变量目前没有使用，后面改进后再使用。主要原因是目前的控制只在从数据库读入数据时进行了控制，没有给向XLSX表文件中写数据预留空间，因此控制效果不理想。
	 *                             其实，在原来的向XLS中存入数据时已经达到一定效果。
	 * @param limitQuantity        数量限制，由于数据量过大会超出JAVA虚拟机的内存，目前使用一个数据记录上限进行控制。
	 * @return
	 * 
	 * 		1、在exportRsTransOverhaMargCost110QuantityLimitString(...) 方法基础上进行修改；
	 *         2、增加了一个数值型变量，实现对多个数值变量的支撑，因此在exportRsTransOverhaMargCost110QuantityLimitString做了一些修改。
	 *         3、目前只支持两类型字符型变量，晚上做修改，以支撑多类型字符型变量。
	 *         4、最终通过参数传递，实现数据输出的方法，是输出为txt文件、csv文件、xls文件还是xlsx文件。
	 * 
	 */
	public static boolean exportPolynomialRegressionTable(String tableName, Double maxUsedMemoryPercent,
			Double maxFreeMemoryPercent, int limitQuantity) {
		// int recordQuantity = 30000;
		//
		int recordQuantity = 35000;
		if (recordQuantity > limitQuantity) {
			recordQuantity = limitQuantity;
		}
		// int recordQuantity = 60000;
		// int recordQuantity = 65534;
		// int recordQuantity = 50000;
		// Double maxUsedMemoryPercent=0.60;
		// Double maxFreeMemoryPercent=0.30;
		int columnNameOrComment = 1;
		List<List<YTableCellString>> rsTransOverhaMargCost110List = new ArrayList<List<YTableCellString>>();

		try {
			Connection conn = null;
			conn = DbUtil.getConnection();
			List<TableColumnProperty> headList = getHeadList(conn, tableName, columnNameOrComment);
			List<TableColumnProperty> headList2 = getHeadList(conn, tableName, columnNameOrComment);

			// 创建预编译语句对象，一般都是用这个而不用Statement
			PreparedStatement pre = null;
			// 创建一个结果集对象
			ResultSet result = null;

			String sql = "select * from " + tableName;
			pre = conn.prepareStatement(sql);// 实例化预编译语句
			result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Double rsTransOverhaMargCostId = null;
			String manufacturerName = null;
			String sbxh = null;
			Double y1 = null;

			System.out.println("Ready in loop!");
			int i = 1;
			Runtime run = Runtime.getRuntime();
			Double maxMem = new Double(run.maxMemory() / 1024 / 1024);
			Double freeMem = new Double(run.freeMemory() / 1024 / 1024);
			Double totalMem = new Double(run.totalMemory() / 1024 / 1024);
			int outj = 1;
			// long usedMem = maxMem - freeMem;
			int limitQuantityI = 1;
			while (result.next()) {
				run = Runtime.getRuntime();
				maxMem = new Double(run.maxMemory() / 1024 / 1024);
				freeMem = new Double(run.freeMemory() / 1024 / 1024);
				totalMem = new Double(run.totalMemory() / 1024 / 1024);
				if (limitQuantityI % limitQuantity == 0) {
					limitQuantityI++;
					System.out.println("limitQuantityI=" + limitQuantityI);
					System.out.println("output " + (outj++) + "times!");
					boolean BResult = false;
					try {
						BResult = writeRsTransOverhaMargCost110POIXLSXString(headList2, tableName,
								rsTransOverhaMargCost110List, recordQuantity, columnNameOrComment);
						rsTransOverhaMargCost110List.clear();
						rsTransOverhaMargCost110List = null;
						rsTransOverhaMargCost110List = new ArrayList<List<YTableCellString>>();
						headList2.clear();
						headList2 = null;
						headList2 = getHeadList(conn, tableName, columnNameOrComment);
					} catch (RowsExceededException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (WriteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				// usedMem = maxMem - freeMem;
				System.out.println("i=" + (i++) + ",usedMemPercent=" + new Double(totalMem / maxMem)
						+ ",freeMemPercent=" + new Double(freeMem / maxMem) + ",maxMem=" + (maxMem) + ",freeMem="
						+ (freeMem) + ",usedMem=" + (totalMem) + ",totalMem=" + (totalMem));

				if (null == result.getString("RS_TRANS_OVERHA_MARG_COST_ID")) {
					rsTransOverhaMargCostId = 0.0;
				} else {
					rsTransOverhaMargCostId = new Double(result.getString("RS_TRANS_OVERHA_MARG_COST_ID"));
				}
				manufacturerName = result.getString("MANUFACTURER_NAME");
				sbxh = result.getString("SBXH");

				List<YTableCellString> alllRowArrayList = new ArrayList<YTableCellString>();
				List<YTableCellString> mTableCellList = new ArrayList<YTableCellString>();
				List<YTableCellString> tTableCellList = new ArrayList<YTableCellString>();
				List<YTableCellString> aTableCellList = new ArrayList<YTableCellString>();
				System.out.println();
				for (int headI = 1; headI < headList.size(); headI++) {

					if (headList.get(headI).getColumnName().contains("XM")) {
						YTableCellString mTableCell = new YTableCellString(headList.get(headI).getColumnId(),
								headList.get(headI).getColumnName(),
								result.getString(headList.get(headI).getColumnName()));

						mTableCellList.add(mTableCell);
						alllRowArrayList.add(mTableCell);
						// System.out.println(headList.get(headI).getColumnName() + "="
						// + (new Double(result.getString(headList.get(headI).getColumnName()))));
					} else if (headList.get(headI).getColumnName().contains("XT")) {
						YTableCellString tTableCell = new YTableCellString(headList.get(headI).getColumnId(),
								headList.get(headI).getColumnName(),
								result.getString(headList.get(headI).getColumnName()));

						tTableCellList.add(tTableCell);
						alllRowArrayList.add(tTableCell);
						// System.out.println(headList.get(headI).getColumnName() + "="
						// + (new Double(result.getString(headList.get(headI).getColumnName()))));
					} else if (headList.get(headI).getColumnName().contains("XA")) {
						YTableCellString aTableCell = new YTableCellString(headList.get(headI).getColumnId(),
								headList.get(headI).getColumnName(),
								result.getString(headList.get(headI).getColumnName()));

						aTableCellList.add(aTableCell);
						alllRowArrayList.add(aTableCell);
						// System.out.println(headList.get(headI).getColumnName() + "="
						// + (result.getString(headList.get(headI).getColumnName())));
					} else {
						YTableCellString tTableCell = new YTableCellString(headList.get(headI).getColumnId(),
								headList.get(headI).getColumnName(),
								result.getString(headList.get(headI).getColumnName()));
						alllRowArrayList.add(tTableCell);
						// System.out.println(headList.get(headI).getColumnName() + "="
						// + (result.getString(headList.get(headI).getColumnName())));
					}
				}

				int sizeLimit = 0;
				int headListSizeI = headList.size();
				int headListSize = headList.size();
				int alllRowArrayListI = alllRowArrayList.size();
				int mTableCellListSize = mTableCellList.size();
				int tTableCellListSize = tTableCellList.size();
				int aTableCellListSize = aTableCellList.size();
				System.out.println("mTableCellListSize*tTableCellListSize=" + mTableCellListSize * tTableCellListSize);
				/* 此部分为XM*XM的构造部分 */
				sizeLimit = headListSize + mTableCellListSize + 1;
				for (int mI = 0; mI < mTableCellListSize; mI++) {
					if (headList2.size() < sizeLimit) {
						/**
						 * 此处使用if语句是需要在第一次循环时完成表头的数据生成，即只会运行一次， if之后的则为生成的数据的存储过程。
						 */
						headList2.add(new TableColumnProperty(headListSizeI + 1,
								mTableCellList.get(mI).getColumnName() + mTableCellList.get(mI).getColumnName(),
								"Double", 100, 100, 100, ""));
						headListSizeI++;
					}
					/**
					 * 以下部分完成第一类字符型变量的二阶值计算
					 */
					alllRowArrayList.add(new YTableCellString(alllRowArrayListI + 1,
							mTableCellList.get(mI).getColumnName() + mTableCellList.get(mI).getColumnName(),
							(new Double(mTableCellList.get(mI).getCellValue())
									* (new Double(mTableCellList.get(mI).getCellValue()))) + ""));
					alllRowArrayListI++;

				}

				/* 此部分为Xt*Xt的构造部分 */
				sizeLimit = headListSize + mTableCellListSize + tTableCellListSize + 1;
				for (int tI = 0; tI < tTableCellListSize; tI++) {
					if (headList2.size() < sizeLimit) {
						/**
						 * 此处使用if语句是需要在第一次循环时完成表头的数据生成，即只会运行一次， if之后的则为生成的数据的存储过程。
						 */
						headList2.add(new TableColumnProperty(headListSizeI + 1,
								tTableCellList.get(tI).getColumnName() + tTableCellList.get(tI).getColumnName(),
								"Double", 100, 100, 100, ""));
						headListSizeI++;
					}
					/**
					 * 以下部分完成第二类字符型变量的二阶值计算
					 */
					alllRowArrayList.add(new YTableCellString(alllRowArrayListI + 1,
							tTableCellList.get(tI).getColumnName() + tTableCellList.get(tI).getColumnName(),
							(new Double(tTableCellList.get(tI).getCellValue())
									* (new Double(tTableCellList.get(tI).getCellValue()))) + ""));
					alllRowArrayListI++;

				}
				/* 此部分为Xa*Xa的构造部分 */
				sizeLimit = headListSize + mTableCellListSize + tTableCellListSize + aTableCellListSize + 1;
				for (int aI = 0; aI < aTableCellListSize; aI++) {
					if (headList2.size() < sizeLimit) {
						/**
						 * 此处使用if语句是需要在第一次循环时完成表头的数据生成，即只会运行一次， if之后的则为生成的数据的存储过程。
						 */
						headList2.add(new TableColumnProperty(headListSizeI + 1,
								aTableCellList.get(aI).getColumnName() + aTableCellList.get(aI).getColumnName(),
								"Double", 100, 100, 100, ""));
						headListSizeI++;
					}
					/**
					 * 以下部分完成数值型变量的二阶值计算
					 */
					alllRowArrayList.add(new YTableCellString(alllRowArrayListI + 1,
							aTableCellList.get(aI).getColumnName() + aTableCellList.get(aI).getColumnName(),
							(new Double(aTableCellList.get(aI).getCellValue())
									* (new Double(aTableCellList.get(aI).getCellValue()))) + ""));
					alllRowArrayListI++;

				}
				/* 此部分为Xm*Xt的构造部分 */
				sizeLimit = headListSize + mTableCellListSize + tTableCellListSize + aTableCellListSize + 1;
				sizeLimit = sizeLimit + mTableCellListSize * tTableCellListSize;
				for (int tI = 0; tI < tTableCellListSize; tI++) {
					for (int mI = 0; mI < mTableCellListSize; mI++) {
						if (headList2.size() < sizeLimit) {
							/**
							 * 此处使用if语句是需要在第一次循环时完成表头的数据生成，即只会运行一次， if之后的则为生成的数据的存储过程。
							 */
							headList2.add(new TableColumnProperty(headListSizeI + 1,
									mTableCellList.get(mI).getColumnName() + tTableCellList.get(tI).getColumnName(),
									"Double", 100, 100, 100, ""));
							headListSizeI++;
						}
						/**
						 * 以下部分完成第一个类型字符型变量与第二个类型字符型变量的错位相乘
						 */
						alllRowArrayList.add(new YTableCellString(alllRowArrayListI + 1,
								mTableCellList.get(mI).getColumnName() + tTableCellList.get(tI).getColumnName(),
								(new Double(mTableCellList.get(mI).getCellValue())
										* (new Double(tTableCellList.get(tI).getCellValue()))) + ""));
						alllRowArrayListI++;
					}

				}
				/* 此部分为Xm*Xa的构造部分 */
				sizeLimit = headListSize + mTableCellListSize + tTableCellListSize + aTableCellListSize + 1;
				sizeLimit = sizeLimit + mTableCellListSize * tTableCellListSize
						+ mTableCellListSize * aTableCellListSize;
				for (int aI = 0; aI < aTableCellListSize; aI++) {
					for (int mI = 0; mI < mTableCellListSize; mI++) {
						if (headList2.size() < sizeLimit) {
							/**
							 * 此处使用if语句是需要在第一次循环时完成表头的数据生成，即只会运行一次， if之后的则为生成的数据的存储过程。
							 */
							headList2.add(new TableColumnProperty(headListSizeI + 1,
									mTableCellList.get(mI).getColumnName() + aTableCellList.get(aI).getColumnName(),
									"Double", 100, 100, 100, ""));
							headListSizeI++;
						}
						/**
						 * 以下部分完成第一个类型字符型变量与数值型变量的错位相乘
						 */
						alllRowArrayList.add(new YTableCellString(alllRowArrayListI + 1,
								mTableCellList.get(mI).getColumnName() + aTableCellList.get(aI).getColumnName(),
								(new Double(mTableCellList.get(mI).getCellValue())
										* (new Double(aTableCellList.get(aI).getCellValue()))) + ""));
						alllRowArrayListI++;
					}

				}
				/* 此部分为Xt*Xa的构造部分 */
				sizeLimit = headListSize + mTableCellListSize + tTableCellListSize + aTableCellListSize + 1;
				sizeLimit = sizeLimit + mTableCellListSize * tTableCellListSize
						+ mTableCellListSize * aTableCellListSize;
				sizeLimit = sizeLimit + tTableCellListSize * aTableCellListSize;
				for (int aI = 0; aI < aTableCellListSize; aI++) {
					for (int tI = 0; tI < tTableCellListSize; tI++) {
						if (headList2.size() < sizeLimit) {
							/**
							 * 此处使用if语句是需要在第一次循环时完成表头的数据生成，即只会运行一次， if之后的则为生成的数据的存储过程。
							 */
							headList2.add(new TableColumnProperty(headListSizeI + 1,
									tTableCellList.get(tI).getColumnName() + aTableCellList.get(aI).getColumnName(),
									"Double", 100, 100, 100, ""));
							headListSizeI++;
						}
						/**
						 * 以下部分完成第二个类型字符型变量与数值型变量的错位相乘
						 */
						alllRowArrayList.add(new YTableCellString(alllRowArrayListI + 1,
								tTableCellList.get(tI).getColumnName() + aTableCellList.get(aI).getColumnName(),
								(new Double(tTableCellList.get(tI).getCellValue())
										* (new Double(aTableCellList.get(aI).getCellValue()))) + ""));
						alllRowArrayListI++;
					}

				}

				/* 此部分为Xa*Xa错位相乘部分的构造 */
				int aTableSize = aTableCellListSize;
				sizeLimit = headListSize + mTableCellListSize + tTableCellListSize + aTableCellListSize
						+ mTableCellListSize * tTableCellListSize + mTableCellListSize * aTableCellListSize
						+ tTableCellListSize * aTableCellListSize + 1;
				for (int aI = 0; aI < aTableCellListSize; aI++) {
					/**
					 * 数值型变量，每一个元素需要与其它元素只相乘一次； 因此向后移动一次表头的长度限制即相应增加 aTableCellListSize -aI-1个长度。
					 */
					sizeLimit = sizeLimit + aTableSize - aI - 1;
					for (int aJ = aI + 1; aJ < aTableCellListSize; aJ++) {
						/**
						 * 此处使用if语句是需要在第一次循环时完成表头的数据生成，即只会运行一次， if之后的则为生成的数据的存储过程。
						 */
						if (headList2.size() < sizeLimit) {
							headList2.add(new TableColumnProperty(headListSizeI + 1,
									aTableCellList.get(aJ).getColumnName() + aTableCellList.get(aI).getColumnName(),
									"Double", 100, 100, 100, ""));
							headListSizeI++;
						}

						/**
						 * 以下部分实现错误相乘数据的生成
						 */
						alllRowArrayList.add(new YTableCellString(alllRowArrayListI + 1,
								aTableCellList.get(aJ).getColumnName() + aTableCellList.get(aI).getColumnName(),
								(new Double(aTableCellList.get(aJ).getCellValue())
										* (new Double(aTableCellList.get(aI).getCellValue()))) + ""));
						alllRowArrayListI++;

					}

				}

				rsTransOverhaMargCost110List.add(alllRowArrayList);
				limitQuantityI++;
			}

			if (rsTransOverhaMargCost110List.size() != 0) {
				System.out.println("The last times output!");
				boolean BResult = false;
				try {
					BResult = writeRsTransOverhaMargCost110POIXLSXString(headList2, tableName,
							rsTransOverhaMargCost110List, recordQuantity, columnNameOrComment);
					rsTransOverhaMargCost110List.clear();
					headList2.clear();
				} catch (RowsExceededException e) { // TODO Auto-generated catch block
					e.printStackTrace();
				} catch (WriteException e) { // TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * 
	 * @param tableName
	 * @param maxUsedMemoryPercent 最大已使用内存空间占比，与maxFreeMemoryPercent结合控制一次向XLSX表中存入的数据量，防止数据量过大超出JAVA虚拟机的内存。
	 * @param maxFreeMemoryPercent 最大可用内存空间占比，与maxUsedMemoryPercent结合控制一次向XLSX表中存入的数据量，防止数据量过大超出JAVA虚拟机的内存。
	 *                             以上两个变量目前没有使用，后面改进后再使用。主要原因是目前的控制只在从数据库读入数据时进行了控制，没有给向XLSX表文件中写数据预留空间，因此控制效果不理想。
	 *                             其实，在原来的向XLS中存入数据时已经达到一定效果。
	 * @param limitQuantity        数量限制，由于数据量过大会超出JAVA虚拟机的内存，目前使用一个数据记录上限进行控制。
	 * @return
	 */
	public static boolean exportRsTransOverhaMargCost110QuantityLimitString(String tableName,
			Double maxUsedMemoryPercent, Double maxFreeMemoryPercent, int limitQuantity) {
		// int recordQuantity = 30000;
		//
		int recordQuantity = 35000;
		if (recordQuantity > limitQuantity) {
			recordQuantity = limitQuantity;
		}
		// int recordQuantity = 60000;
		// int recordQuantity = 65534;
		// int recordQuantity = 50000;
		// Double maxUsedMemoryPercent=0.60;
		// Double maxFreeMemoryPercent=0.30;
		int columnNameOrComment = 1;
		List<List<YTableCellString>> rsTransOverhaMargCost110List = new ArrayList<List<YTableCellString>>();

		try {
			Connection conn = null;
			conn = DbUtil.getConnection();
			List<TableColumnProperty> headList = getHeadList(conn, tableName, columnNameOrComment);
			List<TableColumnProperty> headList2 = getHeadList(conn, tableName, columnNameOrComment);

			// 创建预编译语句对象，一般都是用这个而不用Statement
			PreparedStatement pre = null;
			// 创建一个结果集对象
			ResultSet result = null;

			String sql = "select * from " + tableName;
			pre = conn.prepareStatement(sql);// 实例化预编译语句
			result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Double rsTransOverhaMargCostId = null;
			String manufacturerName = null;
			String sbxh = null;
			Double y1 = null;

			System.out.println("Ready in loop!");
			int i = 1;
			Runtime run = Runtime.getRuntime();
			Double maxMem = new Double(run.maxMemory() / 1024 / 1024);
			Double freeMem = new Double(run.freeMemory() / 1024 / 1024);
			Double totalMem = new Double(run.totalMemory() / 1024 / 1024);
			int outj = 1;
			// long usedMem = maxMem - freeMem;
			int limitQuantityI = 1;
			while (result.next()) {
				run = Runtime.getRuntime();
				maxMem = new Double(run.maxMemory() / 1024 / 1024);
				freeMem = new Double(run.freeMemory() / 1024 / 1024);
				totalMem = new Double(run.totalMemory() / 1024 / 1024);
				if (limitQuantityI % limitQuantity == 0) {
					limitQuantityI++;
					System.out.println("limitQuantityI=" + limitQuantityI);
					System.out.println("output " + (outj++) + "times!");
					boolean BResult = false;
					try {
						BResult = writeRsTransOverhaMargCost110POIXLSXString(headList2, tableName,
								rsTransOverhaMargCost110List, recordQuantity, columnNameOrComment);
						rsTransOverhaMargCost110List.clear();
						rsTransOverhaMargCost110List = null;
						rsTransOverhaMargCost110List = new ArrayList<List<YTableCellString>>();
						headList2.clear();
						headList2 = null;
						headList2 = getHeadList(conn, tableName, columnNameOrComment);
					} catch (RowsExceededException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (WriteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				// usedMem = maxMem - freeMem;
				System.out.println("i=" + (i++) + ",usedMemPercent=" + new Double(totalMem / maxMem)
						+ ",freeMemPercent=" + new Double(freeMem / maxMem) + ",maxMem=" + (maxMem) + ",freeMem="
						+ (freeMem) + ",usedMem=" + (totalMem) + ",totalMem=" + (totalMem));

				if (null == result.getString("RS_TRANS_OVERHA_MARG_COST_ID")) {
					rsTransOverhaMargCostId = 0.0;
				} else {
					rsTransOverhaMargCostId = new Double(result.getString("RS_TRANS_OVERHA_MARG_COST_ID"));
				}
				manufacturerName = result.getString("MANUFACTURER_NAME");
				sbxh = result.getString("SBXH");

				List<YTableCellString> alllRowArrayList = new ArrayList<YTableCellString>();
				List<YTableCellString> mTableCellList = new ArrayList<YTableCellString>();
				List<YTableCellString> tTableCellList = new ArrayList<YTableCellString>();
				List<YTableCellString> aTableCellList = new ArrayList<YTableCellString>();
				System.out.println();
				for (int headI = 1; headI < headList.size(); headI++) {

					if (headList.get(headI).getColumnName().contains("XM")) {
						YTableCellString mTableCell = new YTableCellString(headList.get(headI).getColumnId(),
								headList.get(headI).getColumnName(),
								result.getString(headList.get(headI).getColumnName()));

						mTableCellList.add(mTableCell);
						alllRowArrayList.add(mTableCell);
						// System.out.println(headList.get(headI).getColumnName() + "="
						// + (new Double(result.getString(headList.get(headI).getColumnName()))));
					} else if (headList.get(headI).getColumnName().contains("XT")) {
						YTableCellString tTableCell = new YTableCellString(headList.get(headI).getColumnId(),
								headList.get(headI).getColumnName(),
								result.getString(headList.get(headI).getColumnName()));

						tTableCellList.add(tTableCell);
						alllRowArrayList.add(tTableCell);
						// System.out.println(headList.get(headI).getColumnName() + "="
						// + (new Double(result.getString(headList.get(headI).getColumnName()))));
					} else if (headList.get(headI).getColumnName().contains("XA")) {
						YTableCellString aTableCell = new YTableCellString(headList.get(headI).getColumnId(),
								headList.get(headI).getColumnName(),
								result.getString(headList.get(headI).getColumnName()));

						aTableCellList.add(aTableCell);
						alllRowArrayList.add(aTableCell);
						// System.out.println(headList.get(headI).getColumnName() + "="
						// + (result.getString(headList.get(headI).getColumnName())));
					} else {
						YTableCellString tTableCell = new YTableCellString(headList.get(headI).getColumnId(),
								headList.get(headI).getColumnName(),
								result.getString(headList.get(headI).getColumnName()));
						alllRowArrayList.add(tTableCell);
						// System.out.println(headList.get(headI).getColumnName() + "="
						// + (result.getString(headList.get(headI).getColumnName())));
					}
				}
				int headListSizeI = headList.size();
				int headListSize = headList.size();
				int alllRowArrayListI = alllRowArrayList.size();
				int mTableCellListSize = mTableCellList.size();
				int tTableCellListSize = tTableCellList.size();
				int aTableCellListSize = aTableCellList.size();
				System.out.println("mTableCellListSize*tTableCellListSize=" + mTableCellListSize * tTableCellListSize);
				/* 此部分为XM*XM的构造部分 */
				for (int mI = 0; mI < mTableCellListSize; mI++) {
					if (headList2.size() < headListSize + mTableCellListSize + 1) {
						headList2.add(new TableColumnProperty(headListSizeI + 1,
								mTableCellList.get(mI).getColumnName() + mTableCellList.get(mI).getColumnName(),
								"Double", 100, 100, 100, ""));
						headListSizeI++;
					}
					alllRowArrayList.add(new YTableCellString(alllRowArrayListI + 1,
							mTableCellList.get(mI).getColumnName() + mTableCellList.get(mI).getColumnName(),
							(new Double(mTableCellList.get(mI).getCellValue())
									* (new Double(mTableCellList.get(mI).getCellValue()))) + ""));
					alllRowArrayListI++;

				}

				/* 此部分为Xt*Xt的构造部分 */
				for (int tI = 0; tI < tTableCellListSize; tI++) {
					if (headList2.size() < headListSize + mTableCellListSize + tTableCellListSize + 1) {
						headList2.add(new TableColumnProperty(headListSizeI + 1,
								tTableCellList.get(tI).getColumnName() + tTableCellList.get(tI).getColumnName(),
								"Double", 100, 100, 100, ""));
						headListSizeI++;
					}
					alllRowArrayList.add(new YTableCellString(alllRowArrayListI + 1,
							tTableCellList.get(tI).getColumnName() + tTableCellList.get(tI).getColumnName(),
							(new Double(tTableCellList.get(tI).getCellValue())
									* (new Double(tTableCellList.get(tI).getCellValue()))) + ""));
					alllRowArrayListI++;

				}
				/* 此部分为Xa*Xa的构造部分 */
				for (int aI = 0; aI < aTableCellListSize; aI++) {
					if (headList2.size() < headListSize + mTableCellListSize + tTableCellListSize + aTableCellListSize
							+ 1) {
						headList2.add(new TableColumnProperty(headListSizeI + 1,
								aTableCellList.get(aI).getColumnName() + aTableCellList.get(aI).getColumnName(),
								"Double", 100, 100, 100, ""));
						headListSizeI++;
					}
					alllRowArrayList.add(new YTableCellString(alllRowArrayListI + 1,
							aTableCellList.get(aI).getColumnName() + aTableCellList.get(aI).getColumnName(),
							(new Double(aTableCellList.get(aI).getCellValue())
									* (new Double(aTableCellList.get(aI).getCellValue()))) + ""));
					alllRowArrayListI++;

				}
				/* 此部分为Xm*Xt的构造部分 */
				for (int tI = 0; tI < tTableCellListSize; tI++) {
					for (int mI = 0; mI < mTableCellListSize; mI++) {
						if (headList2.size() < headListSize + mTableCellListSize + tTableCellListSize
								+ aTableCellListSize + mTableCellListSize * tTableCellListSize + 1) {
							headList2.add(new TableColumnProperty(headListSizeI + 1,
									mTableCellList.get(mI).getColumnName() + tTableCellList.get(tI).getColumnName(),
									"Double", 100, 100, 100, ""));
							headListSizeI++;
						}
						alllRowArrayList.add(new YTableCellString(alllRowArrayListI + 1,
								mTableCellList.get(mI).getColumnName() + tTableCellList.get(tI).getColumnName(),
								(new Double(mTableCellList.get(mI).getCellValue())
										* (new Double(tTableCellList.get(tI).getCellValue()))) + ""));
						alllRowArrayListI++;
					}

				}
				/* 此部分为Xm*Xa的构造部分 */
				for (int aI = 0; aI < aTableCellListSize; aI++) {
					for (int mI = 0; mI < mTableCellListSize; mI++) {
						if (headList2.size() < headListSize + mTableCellListSize + tTableCellListSize
								+ aTableCellListSize + mTableCellListSize * tTableCellListSize
								+ mTableCellListSize * aTableCellListSize + 1) {
							headList2.add(new TableColumnProperty(headListSizeI + 1,
									mTableCellList.get(mI).getColumnName() + aTableCellList.get(aI).getColumnName(),
									"Double", 100, 100, 100, ""));
							headListSizeI++;
						}
						alllRowArrayList.add(new YTableCellString(alllRowArrayListI + 1,
								mTableCellList.get(mI).getColumnName() + aTableCellList.get(aI).getColumnName(),
								(new Double(mTableCellList.get(mI).getCellValue())
										* (new Double(aTableCellList.get(aI).getCellValue()))) + ""));
						alllRowArrayListI++;
					}

				}
				/* 此部分为Xt*Xa的构造部分 */
				for (int aI = 0; aI < aTableCellListSize; aI++) {
					for (int tI = 0; tI < tTableCellListSize; tI++) {
						if (headList2.size() < headListSize + mTableCellListSize + tTableCellListSize
								+ aTableCellListSize + mTableCellListSize * tTableCellListSize
								+ mTableCellListSize * aTableCellListSize + tTableCellListSize * aTableCellListSize
								+ 1) {
							headList2.add(new TableColumnProperty(headListSizeI + 1,
									tTableCellList.get(tI).getColumnName() + aTableCellList.get(aI).getColumnName(),
									"Double", 100, 100, 100, ""));
							headListSizeI++;
						}
						alllRowArrayList.add(new YTableCellString(alllRowArrayListI + 1,
								tTableCellList.get(tI).getColumnName() + aTableCellList.get(aI).getColumnName(),
								(new Double(tTableCellList.get(tI).getCellValue())
										* (new Double(aTableCellList.get(aI).getCellValue()))) + ""));
						alllRowArrayListI++;
					}

				}
				rsTransOverhaMargCost110List.add(alllRowArrayList);
				limitQuantityI++;
			}

			if (rsTransOverhaMargCost110List.size() != 0) {
				System.out.println("The last times output!");
				boolean BResult = false;
				try {
					BResult = writeRsTransOverhaMargCost110POIXLSXString(headList2, tableName,
							rsTransOverhaMargCost110List, recordQuantity, columnNameOrComment);
					rsTransOverhaMargCost110List.clear();
					headList2.clear();
				} catch (RowsExceededException e) { // TODO Auto-generated catch block
					e.printStackTrace();
				} catch (WriteException e) { // TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * @return
	 */
	public static boolean exportRsTransOverhaMargCost110QuantityLimit(String tableName, Double maxUsedMemoryPercent,
			Double maxFreeMemoryPercent, int limitQuantity) {
		// int recordQuantity = 30000;
		//
		int recordQuantity = 35000;
		// int recordQuantity = 60000;
		// int recordQuantity = 65534;
		// int recordQuantity = 50000;
		// Double maxUsedMemoryPercent=0.60;
		// Double maxFreeMemoryPercent=0.30;
		int columnNameOrComment = 1;
		List<List<YTableCell>> rsTransOverhaMargCost110List = new ArrayList<List<YTableCell>>();

		try {
			Connection conn = null;
			conn = DbUtil.getConnection();
			List<TableColumnProperty> headList = getHeadList(conn, tableName, columnNameOrComment);
			List<TableColumnProperty> headList2 = getHeadList(conn, tableName, columnNameOrComment);

			// 创建预编译语句对象，一般都是用这个而不用Statement
			PreparedStatement pre = null;
			// 创建一个结果集对象
			ResultSet result = null;

			String sql = "select * from " + tableName;
			pre = conn.prepareStatement(sql);// 实例化预编译语句
			result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Double rsTransOverhaMargCostId = null;
			String manufacturerName = null;
			String sbxh = null;
			Double y1 = null;

			System.out.println("Ready in loop!");
			int i = 1;
			Runtime run = Runtime.getRuntime();
			Double maxMem = new Double(run.maxMemory() / 1024 / 1024);
			Double freeMem = new Double(run.freeMemory() / 1024 / 1024);
			Double totalMem = new Double(run.totalMemory() / 1024 / 1024);
			int outj = 1;
			// long usedMem = maxMem - freeMem;
			int limitQuantityI = 1;
			while (result.next()) {
				run = Runtime.getRuntime();
				maxMem = new Double(run.maxMemory() / 1024 / 1024);
				freeMem = new Double(run.freeMemory() / 1024 / 1024);
				totalMem = new Double(run.totalMemory() / 1024 / 1024);
				// System.out.println("ii="+ii+"i%6==0="+(ii%6==0));
				// System.out.println("MEMORY="+((new Double(run.totalMemory()) / new
				// Double(run.maxMemory()) > maxUsedMemoryPercent)
				// && (new Double(run.freeMemory()) / new Double(run.maxMemory()) <
				// maxFreeMemoryPercent)));
				if (limitQuantityI % limitQuantity == 0) {
					limitQuantityI++;
					System.out.println("limitQuantityI=" + limitQuantityI);
					System.out.println("output " + (outj++) + "times!");
					boolean BResult = false;
					try {
						BResult = writeRsTransOverhaMargCost110POIXLSX(headList2, tableName,
								rsTransOverhaMargCost110List, recordQuantity, columnNameOrComment);
						rsTransOverhaMargCost110List.clear();
						rsTransOverhaMargCost110List = null;
						rsTransOverhaMargCost110List = new ArrayList<List<YTableCell>>();
						headList2.clear();
						headList2 = null;
						headList2 = getHeadList(conn, tableName, columnNameOrComment);
					} catch (RowsExceededException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (WriteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				// usedMem = maxMem - freeMem;
				// System.out.println("Add!");
				System.out.println("i=" + (i++) + ",usedMemPercent=" + new Double(totalMem / maxMem)
						+ ",freeMemPercent=" + new Double(freeMem / maxMem) + ",maxMem=" + (maxMem) + ",freeMem="
						+ (freeMem) + ",usedMem=" + (totalMem) + ",totalMem=" + (totalMem));

				if (null == result.getString("RS_TRANS_OVERHA_MARG_COST_ID")) {
					rsTransOverhaMargCostId = 0.0;
				} else {
					rsTransOverhaMargCostId = new Double(result.getString("RS_TRANS_OVERHA_MARG_COST_ID"));
				}
				manufacturerName = result.getString("MANUFACTURER_NAME");
				sbxh = result.getString("SBXH");

				List<YTableCell> alllRowArrayList = new ArrayList<YTableCell>();
				List<YTableCell> mTableCellList = new ArrayList<YTableCell>();
				List<YTableCell> tTableCellList = new ArrayList<YTableCell>();
				System.out.println();
				for (int headI = 1; headI < headList.size(); headI++) {

					// headList.add( new TableColumnProperty(columnId, columnName, dataType,
					// dataLength, dataPrecision,
					// dataScale, columnComment));

					if (headList.get(headI).getColumnName().contains("XM")) {
						System.out
								.println("headList.get(headI).getColumnName()=" + headList.get(headI).getColumnName());
						YTableCell mTableCell = new YTableCell(headList.get(headI).getColumnId(),
								headList.get(headI).getColumnName(),
								new Double(result.getString(headList.get(headI).getColumnName())));

						mTableCellList.add(mTableCell);
						alllRowArrayList.add(mTableCell);
						System.out.println(headList.get(headI).getColumnName() + "="
								+ (new Double(result.getString(headList.get(headI).getColumnName()))));
					} else if (headList.get(headI).getColumnName().contains("XT")) {
						YTableCell tTableCell = new YTableCell(headList.get(headI).getColumnId(),
								headList.get(headI).getColumnName(),
								new Double(result.getString(headList.get(headI).getColumnName())));

						tTableCellList.add(tTableCell);
						alllRowArrayList.add(tTableCell);
						System.out.println(headList.get(headI).getColumnName() + "="
								+ (new Double(result.getString(headList.get(headI).getColumnName()))));
					} else if (headList.get(headI).getColumnName().contains("XA")) {
						YTableCell tTableCell = new YTableCell(headList.get(headI).getColumnId(),
								headList.get(headI).getColumnName(),
								new Double(result.getString(headList.get(headI).getColumnName())));

						tTableCellList.add(tTableCell);
						alllRowArrayList.add(tTableCell);
						System.out.println(headList.get(headI).getColumnName() + "="
								+ (new Double(result.getString(headList.get(headI).getColumnName()))));
					}
				}
				int headListSizeI = headList.size();
				int headListSize = headList.size();
				int alllRowArrayListI = alllRowArrayList.size();
				int mTableCellListSize = mTableCellList.size();
				int tTableCellListSize = tTableCellList.size();
				System.out.println("mTableCellListSize*tTableCellListSize=" + mTableCellListSize * tTableCellListSize);
				for (int mI = 0; mI < mTableCellListSize; mI++) {
					if (headList2.size() < headListSize + mTableCellListSize + 1) {
						headList2.add(new TableColumnProperty(headListSizeI + 1,
								mTableCellList.get(mI).getColumnName() + mTableCellList.get(mI).getColumnName(),
								"Double", 100, 100, 100, ""));
						headListSizeI++;
						alllRowArrayList.add(new YTableCell(alllRowArrayListI + 1,
								mTableCellList.get(mI).getColumnName() + mTableCellList.get(mI).getColumnName(),
								mTableCellList.get(mI).getCellValue() * mTableCellList.get(mI).getCellValue()));
						alllRowArrayListI++;
						// System.out.println("Get In mTableCellListSize!");
					}

				}

				for (int tI = 0; tI < tTableCellListSize; tI++) {
					if (headList2.size() < headListSize + mTableCellListSize + tTableCellListSize + 1) {
						headList2.add(new TableColumnProperty(headListSizeI + 1,
								tTableCellList.get(tI).getColumnName() + tTableCellList.get(tI).getColumnName(),
								"Double", 100, 100, 100, ""));
						headListSizeI++;
					}
					alllRowArrayList.add(new YTableCell(alllRowArrayListI + 1,
							tTableCellList.get(tI).getColumnName() + tTableCellList.get(tI).getColumnName(),
							tTableCellList.get(tI).getCellValue() * tTableCellList.get(tI).getCellValue()));
					alllRowArrayListI++;

				}
				for (int mI = 0; mI < mTableCellListSize; mI++) {
					for (int tI = 0; tI < tTableCellListSize; tI++) {
						if (headList2.size() < headListSize + mTableCellListSize + tTableCellListSize
								+ mTableCellListSize * tTableCellListSize + 1) {
							headList2.add(new TableColumnProperty(headListSizeI + 1,
									mTableCellList.get(mI).getColumnName() + tTableCellList.get(tI).getColumnName(),
									"Double", 100, 100, 100, ""));
							headListSizeI++;
						}
						alllRowArrayList.add(new YTableCell(alllRowArrayListI + 1,
								mTableCellList.get(mI).getColumnName() + tTableCellList.get(tI).getColumnName(),
								mTableCellList.get(mI).getCellValue() * tTableCellList.get(tI).getCellValue()));
						alllRowArrayListI++;
					}

				}

				rsTransOverhaMargCost110List.add(alllRowArrayList);
				limitQuantityI++;
			}

			if (rsTransOverhaMargCost110List.size() != 0) {
				System.out.println("The last times output!");
				boolean BResult = false;
				try {
					BResult = writeRsTransOverhaMargCost110POIXLSX(headList2, tableName, rsTransOverhaMargCost110List,
							recordQuantity, columnNameOrComment);
					rsTransOverhaMargCost110List.clear();
					headList2.clear();
				} catch (RowsExceededException e) { // TODO Auto-generated catch block
					e.printStackTrace();
				} catch (WriteException e) { // TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * @return
	 */
	public static boolean exportRsTransOverhaMargCost110(String tableName, Double maxUsedMemoryPercent,
			Double maxFreeMemoryPercent) {
		// int recordQuantity = 30000;
		//
		int recordQuantity = 35000;
		// int recordQuantity = 60000;
		// int recordQuantity = 65534;
		// int recordQuantity = 50000;
		// Double maxUsedMemoryPercent=0.60;
		// Double maxFreeMemoryPercent=0.30;
		int columnNameOrComment = 1;
		List<List<YTableCell>> rsTransOverhaMargCost110List = new ArrayList<List<YTableCell>>();

		try {
			Connection conn = null;
			conn = DbUtil.getConnection();
			List<TableColumnProperty> headList = getHeadList(conn, tableName, columnNameOrComment);
			List<TableColumnProperty> headList2 = getHeadList(conn, tableName, columnNameOrComment);

			// 创建预编译语句对象，一般都是用这个而不用Statement
			PreparedStatement pre = null;
			// 创建一个结果集对象
			ResultSet result = null;

			String sql = "select * from " + tableName;
			pre = conn.prepareStatement(sql);// 实例化预编译语句
			result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Double rsTransOverhaMargCostId = null;
			String manufacturerName = null;
			String sbxh = null;
			Double y1 = null;

			System.out.println("Ready in loop!");
			int i = 1;
			Runtime run = Runtime.getRuntime();
			Double maxMem = new Double(run.maxMemory() / 1024 / 1024);
			Double freeMem = new Double(run.freeMemory() / 1024 / 1024);
			Double totalMem = new Double(run.totalMemory() / 1024 / 1024);
			int outj = 1;
			// long usedMem = maxMem - freeMem;
			int ii = 1;
			while (result.next()) {
				run = Runtime.getRuntime();
				maxMem = new Double(run.maxMemory() / 1024 / 1024);
				freeMem = new Double(run.freeMemory() / 1024 / 1024);
				totalMem = new Double(run.totalMemory() / 1024 / 1024);
				// System.out.println("ii="+ii+"i%6==0="+(ii%6==0));
				// System.out.println("MEMORY="+((new Double(run.totalMemory()) / new
				// Double(run.maxMemory()) > maxUsedMemoryPercent)
				// && (new Double(run.freeMemory()) / new Double(run.maxMemory()) <
				// maxFreeMemoryPercent)));
				// if (ii%800==0||((new Double(run.totalMemory()) / new Double(run.maxMemory())
				// > maxUsedMemoryPercent)
				if (((new Double(run.totalMemory()) / new Double(run.maxMemory()) > maxUsedMemoryPercent)
						&& (new Double(run.freeMemory()) / new Double(run.maxMemory()) < maxFreeMemoryPercent))) {
					ii++;
					System.out.println("ii=" + ii);
					System.out.println("output " + (outj++) + "times!");
					boolean BResult = false;
					try {
						// BResult = writeMidErpItemIntoXls(tableName, list,
						// recordQuantity);
						// BResult = writeRsTransOverhaMargCost110(headList2, tableName,
						// rsTransOverhaMargCost110List,
						// recordQuantity, columnNameOrComment);
						// BResult = writeRsTransOverhaMargCost110POIXLS(headList2, tableName,
						// rsTransOverhaMargCost110List,
						// recordQuantity, columnNameOrComment);

						BResult = writeRsTransOverhaMargCost110POIXLSX(headList2, tableName,
								rsTransOverhaMargCost110List, recordQuantity, columnNameOrComment);
						rsTransOverhaMargCost110List.clear();
						rsTransOverhaMargCost110List = null;
						rsTransOverhaMargCost110List = new ArrayList<List<YTableCell>>();
						headList2.clear();
						headList2 = null;
						headList2 = getHeadList(conn, tableName, columnNameOrComment);
					} catch (RowsExceededException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (WriteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				// usedMem = maxMem - freeMem;
				// System.out.println("Add!");
				System.out.println("i=" + (i++) + ",usedMemPercent=" + new Double(totalMem / maxMem)
						+ ",freeMemPercent=" + new Double(freeMem / maxMem) + ",maxMem=" + (maxMem) + ",freeMem="
						+ (freeMem) + ",usedMem=" + (totalMem) + ",totalMem=" + (totalMem));

				if (null == result.getString("RS_TRANS_OVERHA_MARG_COST_ID")) {
					rsTransOverhaMargCostId = 0.0;
				} else {
					rsTransOverhaMargCostId = new Double(result.getString("RS_TRANS_OVERHA_MARG_COST_ID"));
				}
				manufacturerName = result.getString("MANUFACTURER_NAME");
				sbxh = result.getString("SBXH");

				List<YTableCell> alllRowArrayList = new ArrayList<YTableCell>();
				List<YTableCell> mTableCellList = new ArrayList<YTableCell>();
				List<YTableCell> tTableCellList = new ArrayList<YTableCell>();
				System.out.println();
				for (int headI = 1; headI < headList.size(); headI++) {

					// headList.add( new TableColumnProperty(columnId, columnName, dataType,
					// dataLength, dataPrecision,
					// dataScale, columnComment));

					if (headList.get(headI).getColumnName().contains("XM")) {
						System.out
								.println("headList.get(headI).getColumnName()=" + headList.get(headI).getColumnName());
						YTableCell mTableCell = new YTableCell(headList.get(headI).getColumnId(),
								headList.get(headI).getColumnName(),
								new Double(result.getString(headList.get(headI).getColumnName())));

						mTableCellList.add(mTableCell);
						alllRowArrayList.add(mTableCell);
						System.out.println(headList.get(headI).getColumnName() + "="
								+ (new Double(result.getString(headList.get(headI).getColumnName()))));
					} else if (headList.get(headI).getColumnName().contains("XT")) {
						YTableCell tTableCell = new YTableCell(headList.get(headI).getColumnId(),
								headList.get(headI).getColumnName(),
								new Double(result.getString(headList.get(headI).getColumnName())));

						tTableCellList.add(tTableCell);
						alllRowArrayList.add(tTableCell);
						System.out.println(headList.get(headI).getColumnName() + "="
								+ (new Double(result.getString(headList.get(headI).getColumnName()))));
					} else if (headList.get(headI).getColumnName().contains("XA")) {
						YTableCell tTableCell = new YTableCell(headList.get(headI).getColumnId(),
								headList.get(headI).getColumnName(),
								new Double(result.getString(headList.get(headI).getColumnName())));

						tTableCellList.add(tTableCell);
						alllRowArrayList.add(tTableCell);
						System.out.println(headList.get(headI).getColumnName() + "="
								+ (new Double(result.getString(headList.get(headI).getColumnName()))));
					}
				}
				int headListSizeI = headList.size();
				int headListSize = headList.size();
				int alllRowArrayListI = alllRowArrayList.size();
				int mTableCellListSize = mTableCellList.size();
				int tTableCellListSize = tTableCellList.size();
				System.out.println("mTableCellListSize*tTableCellListSize=" + mTableCellListSize * tTableCellListSize);
				for (int mI = 0; mI < mTableCellListSize; mI++) {
					if (headList2.size() < headListSize + mTableCellListSize + 1) {
						headList2.add(new TableColumnProperty(headListSizeI + 1,
								mTableCellList.get(mI).getColumnName() + mTableCellList.get(mI).getColumnName(),
								"Double", 100, 100, 100, ""));
						headListSizeI++;
						alllRowArrayList.add(new YTableCell(alllRowArrayListI + 1,
								mTableCellList.get(mI).getColumnName() + mTableCellList.get(mI).getColumnName(),
								mTableCellList.get(mI).getCellValue() * mTableCellList.get(mI).getCellValue()));
						alllRowArrayListI++;
						// System.out.println("Get In mTableCellListSize!");
					}

				}

				for (int tI = 0; tI < tTableCellListSize; tI++) {
					if (headList2.size() < headListSize + mTableCellListSize + tTableCellListSize + 1) {
						headList2.add(new TableColumnProperty(headListSizeI + 1,
								tTableCellList.get(tI).getColumnName() + tTableCellList.get(tI).getColumnName(),
								"Double", 100, 100, 100, ""));
						headListSizeI++;
					}
					alllRowArrayList.add(new YTableCell(alllRowArrayListI + 1,
							tTableCellList.get(tI).getColumnName() + tTableCellList.get(tI).getColumnName(),
							tTableCellList.get(tI).getCellValue() * tTableCellList.get(tI).getCellValue()));
					alllRowArrayListI++;

				}
				for (int mI = 0; mI < mTableCellListSize; mI++) {
					for (int tI = 0; tI < tTableCellListSize; tI++) {
						if (headList2.size() < headListSize + mTableCellListSize + tTableCellListSize
								+ mTableCellListSize * tTableCellListSize + 1) {
							headList2.add(new TableColumnProperty(headListSizeI + 1,
									mTableCellList.get(mI).getColumnName() + tTableCellList.get(tI).getColumnName(),
									"Double", 100, 100, 100, ""));
							headListSizeI++;
						}
						alllRowArrayList.add(new YTableCell(alllRowArrayListI + 1,
								mTableCellList.get(mI).getColumnName() + tTableCellList.get(tI).getColumnName(),
								mTableCellList.get(mI).getCellValue() * tTableCellList.get(tI).getCellValue()));
						alllRowArrayListI++;
					}

				}

				rsTransOverhaMargCost110List.add(alllRowArrayList);
				ii++;
			}

			if (rsTransOverhaMargCost110List.size() != 0) {
				System.out.println("The last times output!");
				boolean BResult = false;
				try { // BResult = writeMidErpItemIntoXls(tableName, list,
						// recordQuantity);
						// BResult = writeRsTransOverhaMargCost110(headList2, tableName,
						// rsTransOverhaMargCost110List,
						// recordQuantity, columnNameOrComment);

					// BResult = writeRsTransOverhaMargCost110POIXLS(headList2, tableName,
					// rsTransOverhaMargCost110List,
					// recordQuantity, columnNameOrComment);
					BResult = writeRsTransOverhaMargCost110POIXLSX(headList2, tableName, rsTransOverhaMargCost110List,
							recordQuantity, columnNameOrComment);
					rsTransOverhaMargCost110List.clear();
					headList2.clear();
				} catch (RowsExceededException e) { // TODO Auto-generated catch block
					e.printStackTrace();
				} catch (WriteException e) { // TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * @return
	 */
	public static boolean exportBicAzfiSwzc(String tableName, Double maxUsedMemoryPercent,
			Double maxFreeMemoryPercent) {
		// int recordQuantity = 30000;
		//
		int recordQuantity = 35000;
		// int recordQuantity = 60000;
		// int recordQuantity = 65534;
		// int recordQuantity = 50000;
		// Double maxUsedMemoryPercent=0.60;
		// Double maxFreeMemoryPercent=0.30;
		int columnNameOrComment = 1;
		List<BicAzfiSwzc> list = new ArrayList<BicAzfiSwzc>();
		try {
			Connection conn = null;
			conn = DbUtil.getConnection();
			List<TableColumnProperty> headList = getHeadList(conn, tableName, columnNameOrComment);
			// 创建预编译语句对象，一般都是用这个而不用Statement
			PreparedStatement pre = null;
			// 创建一个结果集对象
			ResultSet result = null;

			String sql = "select * from " + tableName;
			pre = conn.prepareStatement(sql);// 实例化预编译语句
			result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String bicAzfiSwzcId = null;
			String dataVersion = null;
			Date calYear = null;
			String calyear = null;
			String compCode = null;
			String assetMain = null;
			String asset = null;
			String zioEqunr = null;
			String currency = null;
			Double zpmzcyz = null;
			Double zpmzcjz = null;
			String ztypbz1 = null;
			String ztypbz2 = null;
			String ztypbz3 = null;
			String zvolLev = null;
			Double zquantity = null;
			String unit = null;
			String zioZczt = null;
			String profitCtr = null;
			String zlrzx = null;
			String coArea = null;
			String zzcms = null;
			String zioZxmlx = null;
			String capitDate = null;
			String zdeakt = null;
			String assetClas = null;
			String zxlh = null;
			String zinvnr = null;
			String zi0Zzc1 = null;
			String zi0Zzc2 = null;
			String zioKostl = null;
			String zkostlv = null;
			String zioRaumn = null;
			String zzzph = null;
			String zzkostl = null;
			String zioZzc06 = null;
			String zioZzc07 = null;
			String zioOrd41 = null;
			String zord44 = null;
			String zgdlgrp = null;
			String zzcly = null;
			String zioUmwkz = null;
			String zsfdg = null;
			String zioHerst = null;
			String ztypbz = null;
			String zPosid = null;
			String zpost11 = null;
			String zfiamt = null;
			String zioStadt = null;
			String zfwcqzh = null;
			String zioEqktx = null;
			String zioTxt04 = null;
			String zioEqart = null;
			String zpmsqz = null;
			String zioInbdt = null;
			String zioZccrq = null;
			String zzzs = null;
			String zioHerld = null;
			String zioMapar = null;
			String ztxz012 = null;
			String zioSerge = null;
			String zioSwerk = null;
			String zioStort = null;
			String zioBeber = null;
			String zioAbckz = null;
			String zioEqfnr = null;
			String zioZzc02 = null;
			String zProjk = null;
			String zwbsnm = null;
			String zioIwerk = null;
			String zioIngrp = null;
			String zioVaplz = null;
			String zioTplnr = null;
			String zioHequi = null;
			String zioTidnr = null;
			String zioSb010 = null;
			String zioSb001 = null;
			String zioSb002 = null;
			String zioSb004 = null;
			String zioSb005 = null;
			String zioSb006 = null;
			String zioSb003 = null;
			String zioSb007 = null;
			Double zioSb008 = null;
			String zlenunt = null;
			Double zioSb009 = null;
			String zcapunt = null;
			String zioSb011 = null;
			String zioUmlgo = null;
			String zioGplab = null;
			String zioPosid = null;
			String zlyrkrq = null;
			String zlyckrq = null;
			String zpost1 = null;
			String zioCusre = null;
			String zbfyy = null;
			String zioZsb13 = null;
			String zioZsb12 = null;
			String recordmode = null;

			System.out.println("Ready in loop!");
			int i = 1;
			Runtime run = Runtime.getRuntime();
			Double maxMem = new Double(run.maxMemory() / 1024 / 1024);
			Double freeMem = new Double(run.freeMemory() / 1024 / 1024);
			Double totalMem = new Double(run.totalMemory() / 1024 / 1024);
			int outj = 1;
			// long usedMem = maxMem - freeMem;
			while (result.next()) {
				run = Runtime.getRuntime();
				maxMem = new Double(run.maxMemory() / 1024 / 1024);
				freeMem = new Double(run.freeMemory() / 1024 / 1024);
				totalMem = new Double(run.totalMemory() / 1024 / 1024);
				if ((new Double(run.totalMemory()) / new Double(run.maxMemory()) > maxUsedMemoryPercent)
						&& (new Double(run.freeMemory()) / new Double(run.maxMemory()) < maxFreeMemoryPercent)) {
					System.out.println("output " + (outj++) + "times!");
					boolean BResult = false;
					try {
						// BResult = writeMidErpItemIntoXls(tableName, list,
						// recordQuantity);
						BResult = writeBicAzfiSwzcIntoXls(headList, tableName, list, recordQuantity,
								columnNameOrComment);
						list.clear();
						list = null;
						list = new ArrayList<BicAzfiSwzc>();
					} catch (RowsExceededException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (WriteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				// usedMem = maxMem - freeMem;
				// System.out.println("Add!");
				System.out.println("i=" + (i++) + ",usedMemPercent=" + new Double(totalMem / maxMem)
						+ ",freeMemPercent=" + new Double(freeMem / maxMem) + ",maxMem=" + (maxMem) + ",freeMem="
						+ (freeMem) + ",usedMem=" + (totalMem) + ",totalMem=" + (totalMem));
				bicAzfiSwzcId = result.getString("BIC_AZFI_SWZC_ID");
				calyear = result.getString("CALYEAR");
				compCode = result.getString("COMP_CODE");
				assetMain = result.getString("ASSET_MAIN");
				asset = result.getString("ASSET");
				zioEqunr = result.getString("ZIO_EQUNR");
				currency = result.getString("CURRENCY");
				if (null == result.getString("ZPMZCYZ")) {
					zpmzcyz = 0.0;
				} else {

					zpmzcyz = new Double(result.getString("ZPMZCYZ"));
				}
				if (null == result.getString("ZPMZCJZ")) {
					zpmzcjz = 0.0;
				} else {

					zpmzcjz = new Double(result.getString("ZPMZCJZ"));
				}
				ztypbz1 = result.getString("ZTYPBZ1");
				ztypbz2 = result.getString("ZTYPBZ2");
				ztypbz3 = result.getString("ZTYPBZ3");
				zvolLev = result.getString("ZVOL_LEV");
				if (null == result.getString("ZQUANTITY")) {
					zquantity = 0.0;
				} else {

					zquantity = new Double(result.getString("ZQUANTITY"));
				}
				unit = result.getString("UNIT");
				zioZczt = result.getString("ZIO_ZCZT");
				profitCtr = result.getString("PROFIT_CTR");
				zlrzx = result.getString("ZLRZX");
				coArea = result.getString("CO_AREA");
				zzcms = result.getString("ZZCMS");
				zioZxmlx = result.getString("ZIO_ZXMLX");
				capitDate = result.getString("CAPIT_DATE");
				zdeakt = result.getString("ZDEAKT");
				assetClas = result.getString("ASSET_CLAS");
				zxlh = result.getString("ZXLH");
				zinvnr = result.getString("ZINVNR");
				zi0Zzc1 = result.getString("ZI0_ZZC1");
				zi0Zzc2 = result.getString("ZI0_ZZC2");
				zioKostl = result.getString("ZIO_KOSTL");
				zkostlv = result.getString("ZKOSTLV");
				zioRaumn = result.getString("ZIO_RAUMN");
				zzzph = result.getString("ZZZPH");
				zzkostl = result.getString("ZZKOSTL");
				zioZzc06 = result.getString("ZIO_ZZC06");
				zioZzc07 = result.getString("ZIO_ZZC07");
				zioOrd41 = result.getString("ZIO_ORD41");
				zord44 = result.getString("ZORD44");
				zgdlgrp = result.getString("ZGDLGRP");
				zzcly = result.getString("ZZCLY");
				zioUmwkz = result.getString("ZIO_UMWKZ");
				zsfdg = result.getString("ZSFDG");
				zioHerst = result.getString("ZIO_HERST");
				ztypbz = result.getString("ZTYPBZ");
				zPosid = result.getString("Z_POSID");
				zpost11 = result.getString("ZPOST11");
				zfiamt = result.getString("ZFIAMT");
				zioStadt = result.getString("ZIO_STADT");
				zfwcqzh = result.getString("ZFWCQZH");
				zioEqktx = result.getString("ZIO_EQKTX");
				zioTxt04 = result.getString("ZIO_TXT04");
				zioEqart = result.getString("ZIO_EQART");
				zpmsqz = result.getString("ZPMSQZ");
				zioInbdt = result.getString("ZIO_INBDT");
				zioZccrq = result.getString("ZIO_ZCCRQ");
				zzzs = result.getString("ZZZS");
				zioHerld = result.getString("ZIO_HERLD");
				zioMapar = result.getString("ZIO_MAPAR");
				ztxz012 = result.getString("ZTXZ012");
				zioSerge = result.getString("ZIO_SERGE");
				zioSwerk = result.getString("ZIO_SWERK");
				zioStort = result.getString("ZIO_STORT");
				zioBeber = result.getString("ZIO_BEBER");
				zioAbckz = result.getString("ZIO_ABCKZ");
				zioEqfnr = result.getString("ZIO_EQFNR");
				zioZzc02 = result.getString("ZIO_ZZC02");
				zProjk = result.getString("Z_PROJK");
				zwbsnm = result.getString("ZWBSNM");
				zioIwerk = result.getString("ZIO_IWERK");
				zioIngrp = result.getString("ZIO_INGRP");
				zioVaplz = result.getString("ZIO_VAPLZ");
				zioTplnr = result.getString("ZIO_TPLNR");
				zioHequi = result.getString("ZIO_HEQUI");
				zioTidnr = result.getString("ZIO_TIDNR");
				zioSb010 = result.getString("ZIO_SB010");
				zioSb001 = result.getString("ZIO_SB001");
				zioSb002 = result.getString("ZIO_SB002");
				zioSb004 = result.getString("ZIO_SB004");
				zioSb005 = result.getString("ZIO_SB005");
				zioSb006 = result.getString("ZIO_SB006");
				zioSb003 = result.getString("ZIO_SB003");
				zioSb007 = result.getString("ZIO_SB007");

				if (null == result.getString("ZIO_SB008")) {
					zioSb008 = 0.0;
				} else {

					zioSb008 = new Double(result.getString("ZIO_SB008"));
				}
				// zioSb008= result.getString("ZIO_SB008");
				zlenunt = result.getString("ZLENUNT");
				if (null == result.getString("ZIO_SB009")) {
					zioSb009 = 0.0;
				} else {

					zioSb009 = new Double(result.getString("ZIO_SB009"));
				}
				// zioSb009= result.getString("ZIO_SB009");
				zcapunt = result.getString("ZCAPUNT");
				zioSb011 = result.getString("ZIO_SB011");
				zioUmlgo = result.getString("ZIO_UMLGO");
				zioGplab = result.getString("ZIO_GPLAB");
				zioPosid = result.getString("ZIO_POSID");
				zlyrkrq = result.getString("ZLYRKRQ");
				zlyckrq = result.getString("ZLYCKRQ");
				zpost1 = result.getString("ZPOST1");
				zioCusre = result.getString("ZIO_CUSRE");
				zbfyy = result.getString("ZBFYY");
				zioZsb13 = result.getString("ZIO_ZSB13");
				zioZsb12 = result.getString("ZIO_ZSB12");
				recordmode = result.getString("RECORDMODE");
				dataVersion = result.getString("DATA_VERSION");

				list.add(new BicAzfiSwzc(bicAzfiSwzcId, calyear, compCode, assetMain, asset, zioEqunr, currency,
						zpmzcyz, zpmzcjz, ztypbz1, ztypbz2, ztypbz3, zvolLev, zquantity, unit, zioZczt, profitCtr,
						zlrzx, coArea, zzcms, zioZxmlx, capitDate, zdeakt, assetClas, zxlh, zinvnr, zi0Zzc1, zi0Zzc2,
						zioKostl, zkostlv, zioRaumn, zzzph, zzkostl, zioZzc06, zioZzc07, zioOrd41, zord44, zgdlgrp,
						zzcly, zioUmwkz, zsfdg, zioHerst, ztypbz, zPosid, zpost11, zfiamt, zioStadt, zfwcqzh, zioEqktx,
						zioTxt04, zioEqart, zpmsqz, zioInbdt, zioZccrq, zzzs, zioHerld, zioMapar, ztxz012, zioSerge,
						zioSwerk, zioStort, zioBeber, zioAbckz, zioEqfnr, zioZzc02, zProjk, zwbsnm, zioIwerk, zioIngrp,
						zioVaplz, zioTplnr, zioHequi, zioTidnr, zioSb010, zioSb001, zioSb002, zioSb004, zioSb005,
						zioSb006, zioSb003, zioSb007, zioSb008, zlenunt, zioSb009, zcapunt, zioSb011, zioUmlgo,
						zioGplab, zioPosid, zlyrkrq, zlyckrq, zpost1, zioCusre, zbfyy, zioZsb13, zioZsb12, recordmode,
						dataVersion));
			}

			if (list.size() != 0) {
				System.out.println("The last times output!");
				boolean BResult = false;
				try {
					// BResult = writeMidErpItemIntoXls(tableName, list,
					// recordQuantity);
					BResult = writeBicAzfiSwzcIntoXls(headList, tableName, list, recordQuantity, columnNameOrComment);
					list.clear();
				} catch (RowsExceededException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (WriteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * @return
	 */
	public static boolean exportMidPmsItem(String tableName, Double maxUsedMemoryPercent, Double maxFreeMemoryPercent) {
		// int recordQuantity = 30000;
		//
		int recordQuantity = 35000;
		// int recordQuantity = 60000;
		// int recordQuantity = 65534;
		// int recordQuantity = 50000;
		// Double maxUsedMemoryPercent=0.60;
		// Double maxFreeMemoryPercent=0.30;
		int columnNameOrComment = 1;
		List<MidPmsItem> list = new ArrayList<MidPmsItem>();
		try {
			Connection conn = null;
			conn = DbUtil.getConnection();
			List<TableColumnProperty> headList = getHeadList(conn, tableName, columnNameOrComment);
			// 创建预编译语句对象，一般都是用这个而不用Statement
			PreparedStatement pre = null;
			// 创建一个结果集对象
			ResultSet result = null;

			String sql = "select * from " + tableName;
			pre = conn.prepareStatement(sql);// 实例化预编译语句
			result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String midPmsItemId = null;
			String version = null;
			String sbbm = null;
			String orgName = null;
			String dvPmsAssetClassId = null;
			String zcDl = null;
			String zcZl = null;
			String zcXl = null;
			String voltageLevel = null;
			Date calYear = null;
			String qfzd = null;
			String jkzt = null;
			String yxzt = null;
			String ywdw = null;
			String zckbm = null;
			Double zcyz = null;
			Date zjtyrq = null;
			String zcxz = null;
			Double sl = null;
			Double sl1 = null;
			Double sl2 = null;
			Double sl3 = null;
			String jldw = null;
			String zzsmc = null;
			String ssxlbdz = null;
			String sbxh = null;
			Integer tynf = null;
			String nnd = null;
			Date tyrq = null;
			Integer nn = null;
			Date ccrq = null;
			String isMatched = null;
			String equipmentName = null;
			String assetId = null;
			String equipmentIncreaseMode = null;
			String lineProperty = null;
			String zcdl = null;
			String sblx = null;
			Date dvDateValue = null;

			System.out.println("Ready in loop!");
			int i = 1;
			Runtime run = Runtime.getRuntime();
			Double maxMem = new Double(run.maxMemory() / 1024 / 1024);
			Double freeMem = new Double(run.freeMemory() / 1024 / 1024);
			Double totalMem = new Double(run.totalMemory() / 1024 / 1024);
			int outj = 1;
			// long usedMem = maxMem - freeMem;
			while (result.next()) {
				run = Runtime.getRuntime();
				maxMem = new Double(run.maxMemory() / 1024 / 1024);
				freeMem = new Double(run.freeMemory() / 1024 / 1024);
				totalMem = new Double(run.totalMemory() / 1024 / 1024);
				if ((new Double(run.totalMemory()) / new Double(run.maxMemory()) > maxUsedMemoryPercent)
						&& (new Double(run.freeMemory()) / new Double(run.maxMemory()) < maxFreeMemoryPercent)) {
					System.out.println("output " + (outj++) + "times!");
					boolean BResult = false;
					try {
						// BResult = writeMidErpItemIntoXls(tableName, list,
						// recordQuantity);

						BResult = writeMidPmsItemIntoXls(headList, tableName, list, recordQuantity,
								columnNameOrComment);
						list.clear();
						list = null;
						list = new ArrayList<MidPmsItem>();
					} catch (RowsExceededException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (WriteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				// usedMem = maxMem - freeMem;
				// System.out.println("Add!");
				System.out.println("i=" + (i++) + ",usedMemPercent=" + new Double(totalMem / maxMem)
						+ ",freeMemPercent=" + new Double(freeMem / maxMem) + ",maxMem=" + (maxMem) + ",freeMem="
						+ (freeMem) + ",usedMem=" + (totalMem) + ",totalMem=" + (totalMem));
				midPmsItemId = result.getString("MID_PMS_ITEM_ID");
				version = result.getString("VERSION");
				sbbm = result.getString("SBBM");

				orgName = result.getString("ORG_NAME");
				dvPmsAssetClassId = result.getString("DV_PMS_ASSET_CLASS_ID");
				zcDl = result.getString("ZC_DL");
				zcZl = result.getString("ZC_ZL");
				zcXl = result.getString("ZC_XL");
				voltageLevel = result.getString("VOLTAGE_LEVEL");

				if (null != result.getString("CAL_YEAR")) {
					try {
						calYear = simpleDateFormat.parse(result.getString("CAL_YEAR"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				qfzd = result.getString("QFZD");
				jkzt = result.getString("JKZT");
				yxzt = result.getString("YXZT");
				ywdw = result.getString("YWDW");
				zckbm = result.getString("ZCKBM");
				if (null == result.getString("ZCYZ")) {
					zcyz = 0.0;
				} else {

					zcyz = new Double(result.getString("ZCYZ"));
				}

				if (null != result.getString("ZJTYRQ")) {
					try {
						zjtyrq = simpleDateFormat.parse(result.getString("ZJTYRQ"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				zcxz = result.getString("ZCXZ");
				if (null == result.getString("SL")) {
					sl = 0.0;
				} else {
					sl = new Double(result.getString("SL"));
				}
				if (null == result.getString("SL1")) {
					sl1 = 0.0;
				} else {

					sl1 = new Double(result.getString("SL1"));
				}
				if (null == result.getString("SL2")) {
					sl2 = 0.0;
				} else {

					sl2 = new Double(result.getString("SL2"));
				}
				if (null == result.getString("SL3")) {
					sl3 = 0.0;
				} else {

					sl3 = new Double(result.getString("SL3"));
				}
				jldw = result.getString("JLDW");
				zzsmc = result.getString("ZZSMC");
				ssxlbdz = result.getString("SSXLBDZ");
				sbxh = result.getString("SBXH");

				if (null == result.getString("TYNF")) {
					tynf = 0;
				} else {

					tynf = new Integer(result.getString("TYNF"));
				}
				nnd = result.getString("NND");

				if (null != result.getString("TYRQ")) {
					try {
						tyrq = simpleDateFormat.parse(result.getString("TYRQ"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				if (null == result.getString("NN")) {
					nn = 0;
				} else {

					nn = new Integer(result.getString("NN"));
				}

				if (null != result.getString("CCRQ")) {
					try {
						ccrq = simpleDateFormat.parse(result.getString("CCRQ"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				isMatched = result.getString("IS_MATCHED");
				equipmentName = result.getString("EQUIPMENT_NAME");
				assetId = result.getString("ASSET_ID");
				equipmentIncreaseMode = result.getString("EQUIPMENT_INCREASE_MODE");
				lineProperty = result.getString("LINE_PROPERTY");
				zcdl = result.getString("ZCDL");
				sblx = result.getString("SBLX");

				if (null != result.getString("DV_DATE_VALUE")) {
					try {
						dvDateValue = simpleDateFormat.parse(result.getString("DV_DATE_VALUE"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}

				list.add(new MidPmsItem(midPmsItemId, version, sbbm, orgName, dvPmsAssetClassId, zcDl, zcZl, zcXl,
						voltageLevel, calYear, qfzd, jkzt, yxzt, ywdw, zckbm, zcyz, zjtyrq, zcxz, sl, sl1, sl2, sl3,
						jldw, zzsmc, ssxlbdz, sbxh, tynf, nnd, tyrq, nn, ccrq, isMatched, equipmentName, assetId,
						equipmentIncreaseMode, lineProperty, zcdl, sblx, dvDateValue));
			}

			if (list.size() != 0) {
				System.out.println("The last times output!");
				boolean BResult = false;
				try {
					// BResult = writeMidErpItemIntoXls(tableName, list,
					// recordQuantity);
					BResult = writeMidPmsItemIntoXls(headList, tableName, list, recordQuantity, columnNameOrComment);
					list.clear();
				} catch (RowsExceededException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (WriteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * @return
	 */
	public static boolean exportBicAzfiSwzc(String tableName) {
		// int recordQuantity = 30000;
		//
		int recordQuantity = 35000;
		// int recordQuantity = 60000;
		// int recordQuantity = 65534;
		// int recordQuantity = 50000;
		Double maxUsedMemoryPercent = 0.60;
		Double maxFreeMemoryPercent = 0.30;
		int columnNameOrComment = 1;
		List<BicAzfiSwzc> list = new ArrayList<BicAzfiSwzc>();
		try {
			Connection conn = null;
			conn = DbUtil.getConnection();
			List<TableColumnProperty> headList = getHeadList(conn, tableName, columnNameOrComment);
			// 创建预编译语句对象，一般都是用这个而不用Statement
			PreparedStatement pre = null;
			// 创建一个结果集对象
			ResultSet result = null;

			String sql = "select * from " + tableName;
			pre = conn.prepareStatement(sql);// 实例化预编译语句
			result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String bicAzfiSwzcId = null;
			String dataVersion = null;
			Date calYear = null;
			String calyear = null;
			String compCode = null;
			String assetMain = null;
			String asset = null;
			String zioEqunr = null;
			String currency = null;
			Double zpmzcyz = null;
			Double zpmzcjz = null;
			String ztypbz1 = null;
			String ztypbz2 = null;
			String ztypbz3 = null;
			String zvolLev = null;
			Double zquantity = null;
			String unit = null;
			String zioZczt = null;
			String profitCtr = null;
			String zlrzx = null;
			String coArea = null;
			String zzcms = null;
			String zioZxmlx = null;
			String capitDate = null;
			String zdeakt = null;
			String assetClas = null;
			String zxlh = null;
			String zinvnr = null;
			String zi0Zzc1 = null;
			String zi0Zzc2 = null;
			String zioKostl = null;
			String zkostlv = null;
			String zioRaumn = null;
			String zzzph = null;
			String zzkostl = null;
			String zioZzc06 = null;
			String zioZzc07 = null;
			String zioOrd41 = null;
			String zord44 = null;
			String zgdlgrp = null;
			String zzcly = null;
			String zioUmwkz = null;
			String zsfdg = null;
			String zioHerst = null;
			String ztypbz = null;
			String zPosid = null;
			String zpost11 = null;
			String zfiamt = null;
			String zioStadt = null;
			String zfwcqzh = null;
			String zioEqktx = null;
			String zioTxt04 = null;
			String zioEqart = null;
			String zpmsqz = null;
			String zioInbdt = null;
			String zioZccrq = null;
			String zzzs = null;
			String zioHerld = null;
			String zioMapar = null;
			String ztxz012 = null;
			String zioSerge = null;
			String zioSwerk = null;
			String zioStort = null;
			String zioBeber = null;
			String zioAbckz = null;
			String zioEqfnr = null;
			String zioZzc02 = null;
			String zProjk = null;
			String zwbsnm = null;
			String zioIwerk = null;
			String zioIngrp = null;
			String zioVaplz = null;
			String zioTplnr = null;
			String zioHequi = null;
			String zioTidnr = null;
			String zioSb010 = null;
			String zioSb001 = null;
			String zioSb002 = null;
			String zioSb004 = null;
			String zioSb005 = null;
			String zioSb006 = null;
			String zioSb003 = null;
			String zioSb007 = null;
			Double zioSb008 = null;
			String zlenunt = null;
			Double zioSb009 = null;
			String zcapunt = null;
			String zioSb011 = null;
			String zioUmlgo = null;
			String zioGplab = null;
			String zioPosid = null;
			String zlyrkrq = null;
			String zlyckrq = null;
			String zpost1 = null;
			String zioCusre = null;
			String zbfyy = null;
			String zioZsb13 = null;
			String zioZsb12 = null;
			String recordmode = null;

			System.out.println("Ready in loop!");
			int i = 1;
			Runtime run = Runtime.getRuntime();
			Double maxMem = new Double(run.maxMemory() / 1024 / 1024);
			Double freeMem = new Double(run.freeMemory() / 1024 / 1024);
			Double totalMem = new Double(run.totalMemory() / 1024 / 1024);
			int outj = 1;
			// long usedMem = maxMem - freeMem;
			while (result.next()) {
				run = Runtime.getRuntime();
				maxMem = new Double(run.maxMemory() / 1024 / 1024);
				freeMem = new Double(run.freeMemory() / 1024 / 1024);
				totalMem = new Double(run.totalMemory() / 1024 / 1024);
				if ((new Double(run.totalMemory()) / new Double(run.maxMemory()) > maxUsedMemoryPercent)
						&& (new Double(run.freeMemory()) / new Double(run.maxMemory()) < maxFreeMemoryPercent)) {
					System.out.println("output " + (outj++) + "times!");
					boolean BResult = false;
					try {
						// BResult = writeMidErpItemIntoXls(tableName, list,
						// recordQuantity);
						BResult = writeBicAzfiSwzcIntoXls(headList, tableName, list, recordQuantity,
								columnNameOrComment);
						list.clear();
						list = null;
						list = new ArrayList<BicAzfiSwzc>();
					} catch (RowsExceededException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (WriteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				// usedMem = maxMem - freeMem;
				// System.out.println("Add!");
				System.out.println("i=" + (i++) + ",usedMemPercent=" + new Double(totalMem / maxMem)
						+ ",freeMemPercent=" + new Double(freeMem / maxMem) + ",maxMem=" + (maxMem) + ",freeMem="
						+ (freeMem) + ",usedMem=" + (totalMem) + ",totalMem=" + (totalMem));
				bicAzfiSwzcId = result.getString("BIC_AZFI_SWZC_ID");
				calyear = result.getString("CALYEAR");
				compCode = result.getString("COMP_CODE");
				assetMain = result.getString("ASSET_MAIN");
				asset = result.getString("ASSET");
				zioEqunr = result.getString("ZIO_EQUNR");
				currency = result.getString("CURRENCY");
				if (null == result.getString("ZPMZCYZ")) {
					zpmzcyz = 0.0;
				} else {

					zpmzcyz = new Double(result.getString("ZPMZCYZ"));
				}
				if (null == result.getString("ZPMZCJZ")) {
					zpmzcjz = 0.0;
				} else {

					zpmzcjz = new Double(result.getString("ZPMZCJZ"));
				}
				ztypbz1 = result.getString("ZTYPBZ1");
				ztypbz2 = result.getString("ZTYPBZ2");
				ztypbz3 = result.getString("ZTYPBZ3");
				zvolLev = result.getString("ZVOL_LEV");
				if (null == result.getString("ZQUANTITY")) {
					zquantity = 0.0;
				} else {

					zquantity = new Double(result.getString("ZQUANTITY"));
				}
				unit = result.getString("UNIT");
				zioZczt = result.getString("ZIO_ZCZT");
				profitCtr = result.getString("PROFIT_CTR");
				zlrzx = result.getString("ZLRZX");
				coArea = result.getString("CO_AREA");
				zzcms = result.getString("ZZCMS");
				zioZxmlx = result.getString("ZIO_ZXMLX");
				capitDate = result.getString("CAPIT_DATE");
				zdeakt = result.getString("ZDEAKT");
				assetClas = result.getString("ASSET_CLAS");
				zxlh = result.getString("ZXLH");
				zinvnr = result.getString("ZINVNR");
				zi0Zzc1 = result.getString("ZI0_ZZC1");
				zi0Zzc2 = result.getString("ZI0_ZZC2");
				zioKostl = result.getString("ZIO_KOSTL");
				zkostlv = result.getString("ZKOSTLV");
				zioRaumn = result.getString("ZIO_RAUMN");
				zzzph = result.getString("ZZZPH");
				zzkostl = result.getString("ZZKOSTL");
				zioZzc06 = result.getString("ZIO_ZZC06");
				zioZzc07 = result.getString("ZIO_ZZC07");
				zioOrd41 = result.getString("ZIO_ORD41");
				zord44 = result.getString("ZORD44");
				zgdlgrp = result.getString("ZGDLGRP");
				zzcly = result.getString("ZZCLY");
				zioUmwkz = result.getString("ZIO_UMWKZ");
				zsfdg = result.getString("ZSFDG");
				zioHerst = result.getString("ZIO_HERST");
				ztypbz = result.getString("ZTYPBZ");
				zPosid = result.getString("Z_POSID");
				zpost11 = result.getString("ZPOST11");
				zfiamt = result.getString("ZFIAMT");
				zioStadt = result.getString("ZIO_STADT");
				zfwcqzh = result.getString("ZFWCQZH");
				zioEqktx = result.getString("ZIO_EQKTX");
				zioTxt04 = result.getString("ZIO_TXT04");
				zioEqart = result.getString("ZIO_EQART");
				zpmsqz = result.getString("ZPMSQZ");
				zioInbdt = result.getString("ZIO_INBDT");
				zioZccrq = result.getString("ZIO_ZCCRQ");
				zzzs = result.getString("ZZZS");
				zioHerld = result.getString("ZIO_HERLD");
				zioMapar = result.getString("ZIO_MAPAR");
				ztxz012 = result.getString("ZTXZ012");
				zioSerge = result.getString("ZIO_SERGE");
				zioSwerk = result.getString("ZIO_SWERK");
				zioStort = result.getString("ZIO_STORT");
				zioBeber = result.getString("ZIO_BEBER");
				zioAbckz = result.getString("ZIO_ABCKZ");
				zioEqfnr = result.getString("ZIO_EQFNR");
				zioZzc02 = result.getString("ZIO_ZZC02");
				zProjk = result.getString("Z_PROJK");
				zwbsnm = result.getString("ZWBSNM");
				zioIwerk = result.getString("ZIO_IWERK");
				zioIngrp = result.getString("ZIO_INGRP");
				zioVaplz = result.getString("ZIO_VAPLZ");
				zioTplnr = result.getString("ZIO_TPLNR");
				zioHequi = result.getString("ZIO_HEQUI");
				zioTidnr = result.getString("ZIO_TIDNR");
				zioSb010 = result.getString("ZIO_SB010");
				zioSb001 = result.getString("ZIO_SB001");
				zioSb002 = result.getString("ZIO_SB002");
				zioSb004 = result.getString("ZIO_SB004");
				zioSb005 = result.getString("ZIO_SB005");
				zioSb006 = result.getString("ZIO_SB006");
				zioSb003 = result.getString("ZIO_SB003");
				zioSb007 = result.getString("ZIO_SB007");

				if (null == result.getString("ZIO_SB008")) {
					zioSb008 = 0.0;
				} else {

					zioSb008 = new Double(result.getString("ZIO_SB008"));
				}
				// zioSb008= result.getString("ZIO_SB008");
				zlenunt = result.getString("ZLENUNT");
				if (null == result.getString("ZIO_SB009")) {
					zioSb009 = 0.0;
				} else {

					zioSb009 = new Double(result.getString("ZIO_SB009"));
				}
				// zioSb009= result.getString("ZIO_SB009");
				zcapunt = result.getString("ZCAPUNT");
				zioSb011 = result.getString("ZIO_SB011");
				zioUmlgo = result.getString("ZIO_UMLGO");
				zioGplab = result.getString("ZIO_GPLAB");
				zioPosid = result.getString("ZIO_POSID");
				zlyrkrq = result.getString("ZLYRKRQ");
				zlyckrq = result.getString("ZLYCKRQ");
				zpost1 = result.getString("ZPOST1");
				zioCusre = result.getString("ZIO_CUSRE");
				zbfyy = result.getString("ZBFYY");
				zioZsb13 = result.getString("ZIO_ZSB13");
				zioZsb12 = result.getString("ZIO_ZSB12");
				recordmode = result.getString("RECORDMODE");
				dataVersion = result.getString("DATA_VERSION");

				list.add(new BicAzfiSwzc(bicAzfiSwzcId, calyear, compCode, assetMain, asset, zioEqunr, currency,
						zpmzcyz, zpmzcjz, ztypbz1, ztypbz2, ztypbz3, zvolLev, zquantity, unit, zioZczt, profitCtr,
						zlrzx, coArea, zzcms, zioZxmlx, capitDate, zdeakt, assetClas, zxlh, zinvnr, zi0Zzc1, zi0Zzc2,
						zioKostl, zkostlv, zioRaumn, zzzph, zzkostl, zioZzc06, zioZzc07, zioOrd41, zord44, zgdlgrp,
						zzcly, zioUmwkz, zsfdg, zioHerst, ztypbz, zPosid, zpost11, zfiamt, zioStadt, zfwcqzh, zioEqktx,
						zioTxt04, zioEqart, zpmsqz, zioInbdt, zioZccrq, zzzs, zioHerld, zioMapar, ztxz012, zioSerge,
						zioSwerk, zioStort, zioBeber, zioAbckz, zioEqfnr, zioZzc02, zProjk, zwbsnm, zioIwerk, zioIngrp,
						zioVaplz, zioTplnr, zioHequi, zioTidnr, zioSb010, zioSb001, zioSb002, zioSb004, zioSb005,
						zioSb006, zioSb003, zioSb007, zioSb008, zlenunt, zioSb009, zcapunt, zioSb011, zioUmlgo,
						zioGplab, zioPosid, zlyrkrq, zlyckrq, zpost1, zioCusre, zbfyy, zioZsb13, zioZsb12, recordmode,
						dataVersion));
			}

			if (list.size() != 0) {
				System.out.println("The last times output!");
				boolean BResult = false;
				try {
					// BResult = writeMidErpItemIntoXls(tableName, list,
					// recordQuantity);
					BResult = writeBicAzfiSwzcIntoXls(headList, tableName, list, recordQuantity, columnNameOrComment);
					list.clear();
				} catch (RowsExceededException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (WriteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * @return
	 * @throws SQLException
	 * @throws ParseException
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public static boolean exportMidErpItemAssetWallTest(String tableName) throws SQLException, ParseException,
			ClassNotFoundException, InstantiationException, IllegalAccessException {
		int recordQuantity = 50000;
		// int recordQuantity = 65534;
		// int recordQuantity = 50000;
		int columnNameOrComment = 1;
		List<MidErpItemAssetWall> list = new ArrayList<MidErpItemAssetWall>();
		Connection conn = null;
		conn = DbUtil.getConnection();

		List<TableColumnProperty> headList = getHeadList(conn, tableName, columnNameOrComment);

		for (int i = 0; i < headList.size(); i++) {
			System.out.println("headList(" + i + ")=" + headList.get(i).getColumnName());
		}
		// 创建预编译语句对象，一般都是用这个而不用Statement
		PreparedStatement pre = null;
		// 创建一个结果集对象
		ResultSet result = null;

		String sql = "select * from " + tableName;// + " where rownum<1000";
		pre = conn.prepareStatement(sql);// 实例化预编译语句
		result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.s");
		// json对象
		JSONObject jsonObj = new JSONObject();
		// 获取列数
		ResultSetMetaData rsd = result.getMetaData();

		int columnCount = rsd.getColumnCount();
		System.out.println("Ready in loop!");
		int i = 1;
		Runtime run = Runtime.getRuntime();
		Double maxMem = new Double(run.maxMemory() / 1024 / 1024);
		Double freeMem = new Double(run.freeMemory() / 1024 / 1024);
		Double totalMem = new Double(run.totalMemory() / 1024 / 1024);
		int outj = 1;
		// long usedMem = maxMem - freeMem;
		// 遍历ResultSet中的每条数据

		while (result.next()) {
			run = Runtime.getRuntime();
			maxMem = new Double(run.maxMemory() / 1024 / 1024);
			freeMem = new Double(run.freeMemory() / 1024 / 1024);
			totalMem = new Double(run.totalMemory() / 1024 / 1024);
			if ((new Double(run.totalMemory()) / new Double(run.maxMemory()) > 0.60)
					&& (new Double(run.freeMemory()) / new Double(run.maxMemory()) < 0.25)) {
				System.out.println("output " + (outj++) + "times!");
				boolean BResult = false;
				try {
					// BResult = writeMidErpItemIntoXls(tableName, list,
					// recordQuantity);
					BResult = writeMidErpItemAssetWallIntoXls(headList, tableName, list, recordQuantity,
							columnNameOrComment);
					list.clear();
					list = null;
					list = new ArrayList<MidErpItemAssetWall>();
				} catch (RowsExceededException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (WriteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			// 遍历每一列
			for (int colI = 1; colI <= columnCount; colI++) {
				String columnName = rsd.getColumnLabel(colI);

				String value = result.getString(columnName);

				if (rsd.getColumnType(colI) == 93) {
					if (value == null) {
						jsonObj.put(columnName, "");
					} else {
						jsonObj.put(columnName, value);
					}
				} else if (rsd.getColumnType(colI) == 12) {
					if (value == null) {
						jsonObj.put(columnName, "");
					} else {
						jsonObj.put(columnName, result.getString(columnName));
					}
				} else if (rsd.getColumnType(colI) == -9) {
					if (value == null) {
						jsonObj.put(columnName, "");
					} else {
						jsonObj.put(columnName, result.getString(columnName));
					}
				} else if (rsd.getColumnType(colI) == 2) {
					if (value == null) {
						jsonObj.put(columnName, 0);
					} else {
						jsonObj.put(columnName, result.getDouble(columnName));
					}
				}
			}
			/**
			 * jsonObj,实质是做了一个map的功能，通过字段与变量的映射，将值赋给对象的变量， 从而创建对象
			 */

			MidErpItemAssetWall midErpItemAssetWall = JSON.parseObject(
					JSON.toJSONStringWithDateFormat(jsonObj, "yyyy-MM-dd HH:mm:ss.s"), MidErpItemAssetWall.class);
			// System.out.println("JSON对象转换成Java对象midErpItem4\n"+midErpItem);

			// usedMem = maxMem - freeMem;
			// System.out.println("Add!");
			System.out.println("i=" + (i++) + ",usedMemPercent=" + new Double(totalMem / maxMem) + ",freeMemPercent="
					+ new Double(freeMem / maxMem) + ",maxMem=" + (maxMem) + ",freeMem=" + (freeMem) + ",usedMem="
					+ (totalMem) + ",totalMem=" + (totalMem));
			list.add(midErpItemAssetWall);
			jsonObj = new JSONObject();
		}

		if (list.size() != 0) {
			System.out.println("The last times output!");
			boolean BResult = false;
			try {
				// BResult = writeMidErpItemIntoXls(tableName, list,
				// recordQuantity);
				BResult = writeMidErpItemAssetWallIntoXls(headList, tableName, list, recordQuantity,
						columnNameOrComment);
				list.clear();
			} catch (RowsExceededException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return true;
		// System.out.println("result.next()="+result.next());
		// JSON.parse(result.next());
	}

	/**
	 * @return
	 * @throws SQLException
	 * @throws ParseException
	 */
	public static boolean exportMidErpItemTest(String tableName) throws SQLException, ParseException {
		int recordQuantity = 50000;
		// int recordQuantity = 65534;
		// int recordQuantity = 50000;
		int columnNameOrComment = 1;
		List<MidErpItem> list = new ArrayList<MidErpItem>();
		Connection conn = null;
		conn = DbUtil.getConnection();

		List<TableColumnProperty> headList = getHeadList(conn, tableName, columnNameOrComment);

		for (int i = 0; i < headList.size(); i++) {
			System.out.println("headList(" + i + ")=" + headList.get(i).getColumnName());
		}
		// 创建预编译语句对象，一般都是用这个而不用Statement
		PreparedStatement pre = null;
		// 创建一个结果集对象
		ResultSet result = null;

		String sql = "select * from " + tableName;// + " where rownum<1000";
		pre = conn.prepareStatement(sql);// 实例化预编译语句
		result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.s");
		// json对象
		JSONObject jsonObj = new JSONObject();
		// 获取列数
		ResultSetMetaData rsd = result.getMetaData();
		int columnCount = rsd.getColumnCount();
		System.out.println("Ready in loop!");
		int i = 1;
		Runtime run = Runtime.getRuntime();
		Double maxMem = new Double(run.maxMemory() / 1024 / 1024);
		Double freeMem = new Double(run.freeMemory() / 1024 / 1024);
		Double totalMem = new Double(run.totalMemory() / 1024 / 1024);
		int outj = 1;
		// long usedMem = maxMem - freeMem;
		// 遍历ResultSet中的每条数据

		while (result.next()) {
			run = Runtime.getRuntime();
			maxMem = new Double(run.maxMemory() / 1024 / 1024);
			freeMem = new Double(run.freeMemory() / 1024 / 1024);
			totalMem = new Double(run.totalMemory() / 1024 / 1024);
			if ((new Double(run.totalMemory()) / new Double(run.maxMemory()) > 0.60)
					&& (new Double(run.freeMemory()) / new Double(run.maxMemory()) < 0.25)) {
				System.out.println("output " + (outj++) + "times!");
				boolean BResult = false;
				try {
					// BResult = writeMidErpItemIntoXls(tableName, list,
					// recordQuantity);
					BResult = writeMidErpItemIntoXls(headList, tableName, list, recordQuantity, columnNameOrComment);
					list.clear();
					list = null;
					list = new ArrayList<MidErpItem>();
				} catch (RowsExceededException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (WriteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			// 遍历每一列
			for (int colI = 1; colI <= columnCount; colI++) {
				String columnName = rsd.getColumnLabel(colI);

				String value = result.getString(columnName);

				if (rsd.getColumnType(colI) == 93) {
					if (value == null) {
						jsonObj.put(columnName, "");
					} else {
						jsonObj.put(columnName, value);
					}
				} else if (rsd.getColumnType(colI) == 12) {
					if (value == null) {
						jsonObj.put(columnName, "");
					} else {
						jsonObj.put(columnName, result.getString(columnName));
					}
				} else if (rsd.getColumnType(colI) == -9) {
					if (value == null) {
						jsonObj.put(columnName, "");
					} else {
						jsonObj.put(columnName, result.getString(columnName));
					}
				} else if (rsd.getColumnType(colI) == 2) {
					if (value == null) {
						jsonObj.put(columnName, 0);
					} else {
						jsonObj.put(columnName, result.getDouble(columnName));
					}
				}
			}

			MidErpItem midErpItem = JSON.parseObject(JSON.toJSONStringWithDateFormat(jsonObj, "yyyy-MM-dd HH:mm:ss.s"),
					MidErpItem.class);
			// System.out.println("JSON对象转换成Java对象midErpItem4\n"+midErpItem);

			// usedMem = maxMem - freeMem;
			// System.out.println("Add!");
			System.out.println("i=" + (i++) + ",usedMemPercent=" + new Double(totalMem / maxMem) + ",freeMemPercent="
					+ new Double(freeMem / maxMem) + ",maxMem=" + (maxMem) + ",freeMem=" + (freeMem) + ",usedMem="
					+ (totalMem) + ",totalMem=" + (totalMem));
			list.add(midErpItem);
			jsonObj = new JSONObject();
		}

		if (list.size() != 0) {
			System.out.println("The last times output!");
			boolean BResult = false;
			try {
				// BResult = writeMidErpItemIntoXls(tableName, list,
				// recordQuantity);
				BResult = writeMidErpItemIntoXls(headList, tableName, list, recordQuantity, columnNameOrComment);
				list.clear();
			} catch (RowsExceededException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return true;
		// System.out.println("result.next()="+result.next());
		// JSON.parse(result.next());
	}

	/**
	 * @return
	 */
	public static boolean exportMidErpItem(String tableName) {
		int recordQuantity = 50000;
		// int recordQuantity = 65534;
		// int recordQuantity = 50000;
		int columnNameOrComment = 1;
		List<MidErpItem> list = new ArrayList<MidErpItem>();
		try {
			Connection conn = null;
			conn = DbUtil.getConnection();
			List<TableColumnProperty> headList = getHeadList(conn, tableName, columnNameOrComment);
			// 创建预编译语句对象，一般都是用这个而不用Statement
			PreparedStatement pre = null;
			// 创建一个结果集对象
			ResultSet result = null;

			String sql = "select * from " + tableName;
			pre = conn.prepareStatement(sql);// 实例化预编译语句
			result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String midErpItemId = null;
			String version = null;
			Date calYear = null;
			Short calyear = null;
			String orgName = null;
			String compCode = null;
			String assetMainNumber = null;
			String assetSubnumber = null;
			String equipementNumber = null;
			String currency = null;
			String largeClass = null;
			String mediumClass = null;
			String smallClass = null;
			String voltageLevel = null;
			Double quantity = null;
			String unit = null;
			Double originalValue = null;
			Double netValue = null;
			String assetStatus = null;
			String profitEnterSecLevelUnit = null;
			String costControlArea = null;
			String assetDescription = null;
			String projectType = null;
			Date capitalizationDate = null;
			Date deliveryDate = null;
			Date manufactureDate = null;
			Double lineLength = null;
			String lengthUnit = null;
			Double transformerCapacity = null;
			String capacityUnit = null;
			String warehouseAddress = null;
			String sparePartMark = null;
			String reusingDeviceMark = null;
			Date reusingEntryDate = null;
			Date reusingOutDate = null;
			String discardProjectResourceCode = null;
			String discardReasonCode = null;
			Date discardAccountingDate = null;
			String equipmentStatus = null;
			String equipmentVoltageLevel = null;
			String isCustody = null;
			String manufacturerCard = null;
			String manufacturerEquipement = null;
			String manufactureState = null;
			String manufacturePartNumber = null;
			String inactivityDate = null;
			String assetCategory = null;
			String cardSerialNumber = null;
			String cardInventoryNumber = null;
			String cardAssetUnit = null;
			String cardStorageUnit = null;
			String cardCostCenter = null;
			String cardAssetManageDepart = null;
			String cardUsingCustodian = null;
			String cardCarLicense = null;
			String costCenterAuxilAccounting = null;
			String donationType = null;
			String superviseSign = null;
			String assetUsingInformation = null;
			String assetIncreaseMethod = null;
			String assetChangeMode = null;
			String assetOrigin = null;
			String engineeringProperty = null;
			String fixedAssetClass = null;
			String cardWbsElement = null;
			String cardWbsElementDesc = null;
			String assetStorageAddress = null;
			String lineStationName = null;
			String housePropCertifiNum = null;
			String equipementName = null;
			String technicalObjectType = null;
			String authorizationGroup = null;
			String equipSpecificationModel = null;
			String equipNameplateNumber = null;
			String maintenanceFactory = null;
			String equipAssetChangeMode = null;
			String factoryArea = null;
			String abcIdentification = null;
			String classifiedField = null;
			String equipmentCostCenter = null;
			String equipmentWbsElement = null;
			String equipWbsElementDesc = null;
			String planFactory = null;
			String planGroup = null;
			String mainWorkCenter = null;
			String functionalPosition = null;
			String advancedEquipment = null;
			String techIdentificationNumber = null;
			String equipUseCustodian = null;
			String equipStorageDepartment = null;
			String equipObjectManageDeparment = null;
			String epqipmentIncreaseMethod = null;
			String equipmentSotrageAddress = null;
			String equipCarLicense = null;
			String equipHousePropCertifiNum = null;
			String lineStationLogo = null;
			String discardOriginProjectDesc = null;
			String discardReasonContent = null;
			Date dataExtractDate = null;
			Date dataExtractTime = null;
			String dataExtractPerson = null;
			String assetProperty = null;
			String propertyCode = null;
			String pmunr = null;
			String assetId = null;
			String assetVoltagelevel = null;

			System.out.println("Ready in loop!");
			int i = 1;
			Runtime run = Runtime.getRuntime();
			Double maxMem = new Double(run.maxMemory() / 1024 / 1024);
			Double freeMem = new Double(run.freeMemory() / 1024 / 1024);
			Double totalMem = new Double(run.totalMemory() / 1024 / 1024);
			int outj = 1;
			// long usedMem = maxMem - freeMem;
			while (result.next()) {
				run = Runtime.getRuntime();
				maxMem = new Double(run.maxMemory() / 1024 / 1024);
				freeMem = new Double(run.freeMemory() / 1024 / 1024);
				totalMem = new Double(run.totalMemory() / 1024 / 1024);
				if ((new Double(run.totalMemory()) / new Double(run.maxMemory()) > 0.60)
						&& (new Double(run.freeMemory()) / new Double(run.maxMemory()) < 0.25)) {
					System.out.println("output " + (outj++) + "times!");
					boolean BResult = false;
					try {
						// BResult = writeMidErpItemIntoXls(tableName, list,
						// recordQuantity);
						BResult = writeMidErpItemIntoXls(headList, tableName, list, recordQuantity,
								columnNameOrComment);
						list.clear();
						list = null;
						list = new ArrayList<MidErpItem>();
					} catch (RowsExceededException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (WriteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				// usedMem = maxMem - freeMem;
				// System.out.println("Add!");
				System.out.println("i=" + (i++) + ",usedMemPercent=" + new Double(totalMem / maxMem)
						+ ",freeMemPercent=" + new Double(freeMem / maxMem) + ",maxMem=" + (maxMem) + ",freeMem="
						+ (freeMem) + ",usedMem=" + (totalMem) + ",totalMem=" + (totalMem));
				try {
					midErpItemId = result.getString("MID_ERP_ITEM_ID");
				} catch (SQLException e) {
					try {
						midErpItemId = result.getString("MID_ERP_UNMATCHED_ITEM_ID");
					} catch (SQLException e1) {
						midErpItemId = result.getString("MID_ERP_MATCHED_ITEM_ID");
					}
				}
				midErpItemId = result.getString("MID_ERP_ITEM_ID");
				version = result.getString("DATA_VERSION");
				// calYear= result.getString("CAL_YEAR");
				if (null != result.getString("CAL_YEAR")) {
					try {
						calYear = simpleDateFormat.parse(result.getString("CAL_YEAR"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				// calyear= result.getString("CALYEAR");
				if (null == result.getString("CALYEAR")) {
					calyear = new Short((short) (0));
				} else {
					calyear = new Short(result.getString("CALYEAR"));
				}
				orgName = result.getString("ORG_NAME");
				compCode = result.getString("COMP_CODE");
				assetMainNumber = result.getString("ASSET_MAIN_NUMBER");
				assetSubnumber = result.getString("ASSET_SUBNUMBER");
				equipementNumber = result.getString("EQUIPEMENT_NUMBER");
				currency = result.getString("CURRENCY");
				largeClass = result.getString("LARGE_CLASS");
				mediumClass = result.getString("MEDIUM_CLASS");
				smallClass = result.getString("SMALL_CLASS");
				voltageLevel = result.getString("VOLTAGE_LEVEL");
				// quantity= result.getString("QUANTITY");
				if (null == result.getString("QUANTITY")) {
					quantity = Double.parseDouble("0");
				} else {
					quantity = Double.parseDouble(result.getString("QUANTITY"));
				}
				unit = result.getString("UNIT");
				// originalValue= result.getString("ORIGINAL_VALUE");
				if (null == result.getString("ORIGINAL_VALUE")) {
					originalValue = Double.parseDouble("0");
				} else {
					originalValue = Double.parseDouble(result.getString("ORIGINAL_VALUE"));
				}
				// netValue= result.getString("NET_VALUE");
				if (null == result.getString("NET_VALUE")) {
					netValue = Double.parseDouble("0");
				} else {
					netValue = Double.parseDouble(result.getString("NET_VALUE"));
				}
				assetStatus = result.getString("ASSET_STATUS");
				profitEnterSecLevelUnit = result.getString("PROFIT_ENTER_SEC_LEVEL_UNIT");
				costControlArea = result.getString("COST_CONTROL_AREA");
				assetDescription = result.getString("ASSET_DESCRIPTION");
				projectType = result.getString("PROJECT_TYPE");
				// capitalizationDate= result.getString("CAPITALIZATION_DATE");
				if (null != result.getString("CAPITALIZATION_DATE")) {
					try {
						capitalizationDate = simpleDateFormat.parse(result.getString("CAPITALIZATION_DATE"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				// deliveryDate= result.getString("DELIVERY_DATE");
				if (null != result.getString("DELIVERY_DATE")) {
					try {
						deliveryDate = simpleDateFormat.parse(result.getString("DELIVERY_DATE"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				// manufactureDate= result.getString("MANUFACTURE_DATE");
				if (null != result.getString("MANUFACTURE_DATE")) {
					try {
						manufactureDate = simpleDateFormat.parse(result.getString("MANUFACTURE_DATE"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				// lineLength= result.getString("LINE_LENGTH");
				if (null == result.getString("LINE_LENGTH")) {
					lineLength = Double.parseDouble("0");
				} else {
					lineLength = Double.parseDouble(result.getString("LINE_LENGTH"));
				}
				lengthUnit = result.getString("LENGTH_UNIT");
				// transformerCapacity=
				// result.getString("TRANSFORMER_CAPACITY");
				if (null == result.getString("TRANSFORMER_CAPACITY")) {
					transformerCapacity = Double.parseDouble("0");
				} else {
					transformerCapacity = Double.parseDouble(result.getString("TRANSFORMER_CAPACITY"));
				}
				capacityUnit = result.getString("CAPACITY_UNIT");
				warehouseAddress = result.getString("WAREHOUSE_ADDRESS");
				sparePartMark = result.getString("SPARE_PART_MARK");
				reusingDeviceMark = result.getString("REUSING_DEVICE_MARK");
				// reusingEntryDate= result.getString("REUSING_ENTRY_DATE");
				if (null != result.getString("REUSING_ENTRY_DATE")) {
					try {
						reusingEntryDate = simpleDateFormat.parse(result.getString("REUSING_ENTRY_DATE"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				// reusingOutDate= result.getString("REUSING_OUT_DATE");
				if (null != result.getString("REUSING_OUT_DATE")) {
					try {
						reusingOutDate = simpleDateFormat.parse(result.getString("REUSING_OUT_DATE"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				discardProjectResourceCode = result.getString("DISCARD_PROJECT_RESOURCE_CODE");
				discardReasonCode = result.getString("DISCARD_REASON_CODE");
				// discardAccountingDate=
				// result.getString("DISCARD_ACCOUNTING_DATE");

				if (null != result.getString("DISCARD_ACCOUNTING_DATE")) {
					try {
						discardAccountingDate = simpleDateFormat.parse(result.getString("DISCARD_ACCOUNTING_DATE"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}

				equipmentStatus = result.getString("EQUIPMENT_STATUS");
				equipmentVoltageLevel = result.getString("EQUIPMENT_VOLTAGE_LEVEL");
				isCustody = result.getString("IS_CUSTODY");
				manufacturerCard = result.getString("MANUFACTURER_CARD");
				manufacturerEquipement = result.getString("MANUFACTURER_EQUIPEMENT");
				manufactureState = result.getString("MANUFACTURE_STATE");
				manufacturePartNumber = result.getString("MANUFACTURE_PART_NUMBER");
				inactivityDate = result.getString("INACTIVITY_DATE");
				assetCategory = result.getString("ASSET_CATEGORY");
				cardSerialNumber = result.getString("CARD_SERIAL_NUMBER");
				cardInventoryNumber = result.getString("CARD_INVENTORY_NUMBER");
				cardAssetUnit = result.getString("CARD_ASSET_UNIT");
				cardStorageUnit = result.getString("CARD_STORAGE_UNIT");
				cardCostCenter = result.getString("CARD_COST_CENTER");
				cardAssetManageDepart = result.getString("CARD_ASSET_MANAGE_DEPART");
				cardUsingCustodian = result.getString("CARD_USING_CUSTODIAN");
				cardCarLicense = result.getString("CARD_CAR_LICENSE");
				costCenterAuxilAccounting = result.getString("COST_CENTER_AUXIL_ACCOUNTING");
				donationType = result.getString("DONATION_TYPE");
				superviseSign = result.getString("SUPERVISE_SIGN");
				assetUsingInformation = result.getString("ASSET_USING_INFORMATION");
				assetIncreaseMethod = result.getString("ASSET_INCREASE_METHOD");
				assetChangeMode = result.getString("ASSET_CHANGE_MODE");
				assetOrigin = result.getString("ASSET_ORIGIN");
				engineeringProperty = result.getString("ENGINEERING_PROPERTY");
				fixedAssetClass = result.getString("FIXED_ASSET_CLASS");
				cardWbsElement = result.getString("CARD_WBS_ELEMENT");
				cardWbsElementDesc = result.getString("CARD_WBS_ELEMENT_DESC");
				assetStorageAddress = result.getString("ASSET_STORAGE_ADDRESS");
				lineStationName = result.getString("LINE_STATION_NAME");
				housePropCertifiNum = result.getString("HOUSE_PROP_CERTIFI_NUM");
				equipementName = result.getString("EQUIPEMENT_NAME");
				technicalObjectType = result.getString("TECHNICAL_OBJECT_TYPE");
				authorizationGroup = result.getString("AUTHORIZATION_GROUP");
				equipSpecificationModel = result.getString("EQUIP_SPECIFICATION_MODEL");
				equipNameplateNumber = result.getString("EQUIP_NAMEPLATE_NUMBER");
				maintenanceFactory = result.getString("MAINTENANCE_FACTORY");
				equipAssetChangeMode = result.getString("EQUIP_ASSET_CHANGE_MODE");
				factoryArea = result.getString("FACTORY_AREA");
				abcIdentification = result.getString("ABC_IDENTIFICATION");
				classifiedField = result.getString("CLASSIFIED_FIELD");
				equipmentCostCenter = result.getString("EQUIPMENT_COST_CENTER");
				equipmentWbsElement = result.getString("EQUIPMENT_WBS_ELEMENT");
				equipWbsElementDesc = result.getString("EQUIP_WBS_ELEMENT_DESC");
				planFactory = result.getString("PLAN_FACTORY");
				planGroup = result.getString("PLAN_GROUP");
				mainWorkCenter = result.getString("MAIN_WORK_CENTER");
				functionalPosition = result.getString("FUNCTIONAL_POSITION");
				advancedEquipment = result.getString("ADVANCED_EQUIPMENT");
				techIdentificationNumber = result.getString("TECH_IDENTIFICATION_NUMBER");
				equipUseCustodian = result.getString("EQUIP_USE_CUSTODIAN");
				equipStorageDepartment = result.getString("EQUIP_STORAGE_DEPARTMENT");
				equipObjectManageDeparment = result.getString("EQUIP_OBJECT_MANAGE_DEPARMENT");
				epqipmentIncreaseMethod = result.getString("EQUIPMENT_INCREASE_METHOD");

				equipmentSotrageAddress = result.getString("EQUIPMENT_SOTRAGE_ADDRESS");
				equipCarLicense = result.getString("EQUIP_CAR_LICENSE");
				equipHousePropCertifiNum = result.getString("EQUIP_HOUSE_PROP_CERTIFI_NUM");
				lineStationLogo = result.getString("LINE_STATION_LOGO");
				discardOriginProjectDesc = result.getString("DISCARD_ORIGIN_PROJECT_DESC");
				discardReasonContent = result.getString("DISCARD_REASON_CONTENT");
				if (null != result.getString("DATA_EXTRACT_DATE")) {
					try {
						dataExtractDate = simpleDateFormat.parse(result.getString("DATA_EXTRACT_DATE"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				if (null != result.getString("DATA_EXTRACT_TIME")) {
					try {
						dataExtractTime = simpleDateFormat.parse(result.getString("DATA_EXTRACT_TIME"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				dataExtractPerson = result.getString("DATA_EXTRACT_PERSON");
				assetProperty = result.getString("ASSET_PROPERTY");
				propertyCode = result.getString("PROPERTY_CODE");

				pmunr = result.getString("PMUNR");
				assetId = result.getString("ASSET_ID");
				assetVoltagelevel = result.getString("ASSET_VOLTAGE_LEVEL");

				list.add(new MidErpItem(midErpItemId, version, calYear, calyear, orgName, compCode, assetMainNumber,
						assetSubnumber, equipementNumber, currency, largeClass, mediumClass, smallClass, voltageLevel,
						quantity, unit, originalValue, netValue, assetStatus, profitEnterSecLevelUnit, costControlArea,
						assetDescription, projectType, capitalizationDate, deliveryDate, manufactureDate, lineLength,
						lengthUnit, transformerCapacity, capacityUnit, warehouseAddress, sparePartMark,
						reusingDeviceMark, reusingEntryDate, reusingOutDate, discardProjectResourceCode,
						discardReasonCode, discardAccountingDate, equipmentStatus, equipmentVoltageLevel, isCustody,
						manufacturerCard, manufacturerEquipement, manufactureState, manufacturePartNumber,
						inactivityDate, assetCategory, cardSerialNumber, cardInventoryNumber, cardAssetUnit,
						cardStorageUnit, cardCostCenter, cardAssetManageDepart, cardUsingCustodian, cardCarLicense,
						costCenterAuxilAccounting, donationType, superviseSign, assetUsingInformation,
						assetIncreaseMethod, assetChangeMode, assetOrigin, engineeringProperty, fixedAssetClass,
						cardWbsElement, cardWbsElementDesc, assetStorageAddress, lineStationName, housePropCertifiNum,
						equipementName, technicalObjectType, authorizationGroup, equipSpecificationModel,
						equipNameplateNumber, maintenanceFactory, equipAssetChangeMode, factoryArea, abcIdentification,
						classifiedField, equipmentCostCenter, equipmentWbsElement, equipWbsElementDesc, planFactory,
						planGroup, mainWorkCenter, functionalPosition, advancedEquipment, techIdentificationNumber,
						equipUseCustodian, equipStorageDepartment, equipObjectManageDeparment, epqipmentIncreaseMethod,
						equipmentSotrageAddress, equipCarLicense, equipHousePropCertifiNum, lineStationLogo,
						discardOriginProjectDesc, discardReasonContent, dataExtractDate, dataExtractTime,
						dataExtractPerson, assetProperty, propertyCode, pmunr, assetId, assetVoltagelevel));
			}

			if (list.size() != 0) {
				System.out.println("The last times output!");
				boolean BResult = false;
				try {
					// BResult = writeMidErpItemIntoXls(tableName, list,
					// recordQuantity);
					BResult = writeMidErpItemIntoXls(headList, tableName, list, recordQuantity, columnNameOrComment);
					list.clear();
				} catch (RowsExceededException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (WriteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * @return
	 */
	public static List<MidErpItem> getAllMidErpItem(String tableName) {
		int recordQuantity = 65534;
		List<MidErpItem> list = new ArrayList<MidErpItem>();
		try {
			Connection conn = null;
			conn = DbUtil.getConnection();
			// 创建预编译语句对象，一般都是用这个而不用Statement
			PreparedStatement pre = null;
			// 创建一个结果集对象
			ResultSet result = null;

			String sql = "select * from " + tableName;
			pre = conn.prepareStatement(sql);// 实例化预编译语句
			result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String midErpItemId = null;
			String version = null;
			Date calYear = null;
			Short calyear = null;
			String orgName = null;
			String compCode = null;
			String assetMainNumber = null;
			String assetSubnumber = null;
			String equipementNumber = null;
			String currency = null;
			String largeClass = null;
			String mediumClass = null;
			String smallClass = null;
			String voltageLevel = null;
			Double quantity = null;
			String unit = null;
			Double originalValue = null;
			Double netValue = null;
			String assetStatus = null;
			String profitEnterSecLevelUnit = null;
			String costControlArea = null;
			String assetDescription = null;
			String projectType = null;
			Date capitalizationDate = null;
			Date deliveryDate = null;
			Date manufactureDate = null;
			Double lineLength = null;
			String lengthUnit = null;
			Double transformerCapacity = null;
			String capacityUnit = null;
			String warehouseAddress = null;
			String sparePartMark = null;
			String reusingDeviceMark = null;
			Date reusingEntryDate = null;
			Date reusingOutDate = null;
			String discardProjectResourceCode = null;
			String discardReasonCode = null;
			Date discardAccountingDate = null;
			String equipmentStatus = null;
			String equipmentVoltageLevel = null;
			String isCustody = null;
			String manufacturerCard = null;
			String manufacturerEquipement = null;
			String manufactureState = null;
			String manufacturePartNumber = null;
			String inactivityDate = null;
			String assetCategory = null;
			String cardSerialNumber = null;
			String cardInventoryNumber = null;
			String cardAssetUnit = null;
			String cardStorageUnit = null;
			String cardCostCenter = null;
			String cardAssetManageDepart = null;
			String cardUsingCustodian = null;
			String cardCarLicense = null;
			String costCenterAuxilAccounting = null;
			String donationType = null;
			String superviseSign = null;
			String assetUsingInformation = null;
			String assetIncreaseMethod = null;
			String assetChangeMode = null;
			String assetOrigin = null;
			String engineeringProperty = null;
			String fixedAssetClass = null;
			String cardWbsElement = null;
			String cardWbsElementDesc = null;
			String assetStorageAddress = null;
			String lineStationName = null;
			String housePropCertifiNum = null;
			String equipementName = null;
			String technicalObjectType = null;
			String authorizationGroup = null;
			String equipSpecificationModel = null;
			String equipNameplateNumber = null;
			String maintenanceFactory = null;
			String equipAssetChangeMode = null;
			String factoryArea = null;
			String abcIdentification = null;
			String classifiedField = null;
			String equipmentCostCenter = null;
			String equipmentWbsElement = null;
			String equipWbsElementDesc = null;
			String planFactory = null;
			String planGroup = null;
			String mainWorkCenter = null;
			String functionalPosition = null;
			String advancedEquipment = null;
			String techIdentificationNumber = null;
			String equipUseCustodian = null;
			String equipStorageDepartment = null;
			String equipObjectManageDeparment = null;
			String epqipmentIncreaseMethod = null;
			String equipmentSotrageAddress = null;
			String equipCarLicense = null;
			String equipHousePropCertifiNum = null;
			String lineStationLogo = null;
			String discardOriginProjectDesc = null;
			String discardReasonContent = null;
			Date dataExtractDate = null;
			Date dataExtractTime = null;
			String dataExtractPerson = null;
			String assetProperty = null;
			String propertyCode = null;

			System.out.println("Ready in loop!");
			int i = 1;
			Runtime run = Runtime.getRuntime();
			Double maxMem = new Double(run.maxMemory() / 1024 / 1024);
			Double freeMem = new Double(run.freeMemory() / 1024 / 1024);
			Double totalMem = new Double(run.totalMemory() / 1024 / 1024);
			int outj = 1;
			// long usedMem = maxMem - freeMem;
			while (result.next()) {

				maxMem = new Double(run.maxMemory() / 1024 / 1024);
				freeMem = new Double(run.freeMemory() / 1024 / 1024);
				totalMem = new Double(run.totalMemory() / 1024 / 1024);

				// usedMem = maxMem - freeMem;
				// System.out.println("Add!");
				System.out.println("i=" + (i++) + ",usedMemPercent=" + new Double(totalMem / maxMem) + ",maxMem="
						+ (maxMem) + ",freeMem=" + (freeMem) + ",usedMem=" + (totalMem) + ",totalMem=" + (totalMem));
				try {
					midErpItemId = result.getString("MID_ERP_ITEM_ID");
				} catch (SQLException e) {
					try {
						midErpItemId = result.getString("MID_ERP_UNMATCHED_ITEM_ID");
					} catch (SQLException e1) {
						midErpItemId = result.getString("MID_ERP_MATCHED_ITEM_ID");
					}
				}
				midErpItemId = result.getString("MID_ERP_ITEM_ID");
				version = result.getString("VERSION");
				// calYear= result.getString("CAL_YEAR");
				if (null != result.getString("CAL_YEAR")) {
					try {
						calYear = simpleDateFormat.parse(result.getString("CAL_YEAR"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				// calyear= result.getString("CALYEAR");
				if (null == result.getString("CALYEAR")) {
					calyear = new Short((short) (0));
				} else {
					calyear = new Short(result.getString("CALYEAR"));
				}
				orgName = result.getString("ORG_NAME");
				compCode = result.getString("COMP_CODE");
				assetMainNumber = result.getString("ASSET_MAIN_NUMBER");
				assetSubnumber = result.getString("ASSET_SUBNUMBER");
				equipementNumber = result.getString("EQUIPEMENT_NUMBER");
				currency = result.getString("CURRENCY");
				largeClass = result.getString("LARGE_CLASS");
				mediumClass = result.getString("MEDIUM_CLASS");
				smallClass = result.getString("SMALL_CLASS");
				voltageLevel = result.getString("VOLTAGE_LEVEL");
				// quantity= result.getString("QUANTITY");
				if (null == result.getString("QUANTITY")) {
					quantity = Double.parseDouble("0");
				} else {
					quantity = Double.parseDouble(result.getString("QUANTITY"));
				}
				unit = result.getString("UNIT");
				// originalValue= result.getString("ORIGINAL_VALUE");
				if (null == result.getString("ORIGINAL_VALUE")) {
					originalValue = Double.parseDouble("0");
				} else {
					originalValue = Double.parseDouble(result.getString("ORIGINAL_VALUE"));
				}
				// netValue= result.getString("NET_VALUE");
				if (null == result.getString("NET_VALUE")) {
					netValue = Double.parseDouble("0");
				} else {
					netValue = Double.parseDouble(result.getString("NET_VALUE"));
				}
				assetStatus = result.getString("ASSET_STATUS");
				profitEnterSecLevelUnit = result.getString("PROFIT_ENTER_SEC_LEVEL_UNIT");
				costControlArea = result.getString("COST_CONTROL_AREA");
				assetDescription = result.getString("ASSET_DESCRIPTION");
				projectType = result.getString("PROJECT_TYPE");
				// capitalizationDate= result.getString("CAPITALIZATION_DATE");
				if (null != result.getString("CAPITALIZATION_DATE")) {
					try {
						capitalizationDate = simpleDateFormat.parse(result.getString("CAPITALIZATION_DATE"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				// deliveryDate= result.getString("DELIVERY_DATE");
				if (null != result.getString("DELIVERY_DATE")) {
					try {
						deliveryDate = simpleDateFormat.parse(result.getString("DELIVERY_DATE"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				// manufactureDate= result.getString("MANUFACTURE_DATE");
				if (null != result.getString("MANUFACTURE_DATE")) {
					try {
						manufactureDate = simpleDateFormat.parse(result.getString("MANUFACTURE_DATE"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				// lineLength= result.getString("LINE_LENGTH");
				if (null == result.getString("LINE_LENGTH")) {
					lineLength = Double.parseDouble("0");
				} else {
					lineLength = Double.parseDouble(result.getString("LINE_LENGTH"));
				}
				lengthUnit = result.getString("LENGTH_UNIT");
				// transformerCapacity=
				// result.getString("TRANSFORMER_CAPACITY");
				if (null == result.getString("TRANSFORMER_CAPACITY")) {
					transformerCapacity = Double.parseDouble("0");
				} else {
					transformerCapacity = Double.parseDouble(result.getString("TRANSFORMER_CAPACITY"));
				}
				capacityUnit = result.getString("CAPACITY_UNIT");
				warehouseAddress = result.getString("WAREHOUSE_ADDRESS");
				sparePartMark = result.getString("SPARE_PART_MARK");
				reusingDeviceMark = result.getString("REUSING_DEVICE_MARK");
				// reusingEntryDate= result.getString("REUSING_ENTRY_DATE");
				if (null != result.getString("REUSING_ENTRY_DATE")) {
					try {
						reusingEntryDate = simpleDateFormat.parse(result.getString("REUSING_ENTRY_DATE"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				// reusingOutDate= result.getString("REUSING_OUT_DATE");
				if (null != result.getString("REUSING_OUT_DATE")) {
					try {
						reusingOutDate = simpleDateFormat.parse(result.getString("REUSING_OUT_DATE"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				discardProjectResourceCode = result.getString("DISCARD_PROJECT_RESOURCE_CODE");
				discardReasonCode = result.getString("DISCARD_REASON_CODE");
				// discardAccountingDate=
				// result.getString("DISCARD_ACCOUNTING_DATE");

				if (null != result.getString("DISCARD_ACCOUNTING_DATE")) {
					try {
						discardAccountingDate = simpleDateFormat.parse(result.getString("DISCARD_ACCOUNTING_DATE"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				equipmentStatus = result.getString("EQUIPMENT_STATUS");
				equipmentVoltageLevel = result.getString("EQUIPMENT_VOLTAGE_LEVEL");
				isCustody = result.getString("IS_CUSTODY");
				manufacturerCard = result.getString("MANUFACTURER_CARD");
				manufacturerEquipement = result.getString("MANUFACTURER_EQUIPEMENT");
				manufactureState = result.getString("MANUFACTURE_STATE");
				manufacturePartNumber = result.getString("MANUFACTURE_PART_NUMBER");
				inactivityDate = result.getString("INACTIVITY_DATE");
				assetCategory = result.getString("ASSET_CATEGORY");
				cardSerialNumber = result.getString("CARD_SERIAL_NUMBER");
				cardInventoryNumber = result.getString("CARD_INVENTORY_NUMBER");
				cardAssetUnit = result.getString("CARD_ASSET_UNIT");
				cardStorageUnit = result.getString("CARD_STORAGE_UNIT");
				cardCostCenter = result.getString("CARD_COST_CENTER");
				cardAssetManageDepart = result.getString("CARD_ASSET_MANAGE_DEPART");
				cardUsingCustodian = result.getString("CARD_USING_CUSTODIAN");
				cardCarLicense = result.getString("CARD_CAR_LICENSE");
				costCenterAuxilAccounting = result.getString("COST_CENTER_AUXIL_ACCOUNTING");
				donationType = result.getString("DONATION_TYPE");
				superviseSign = result.getString("SUPERVISE_SIGN");
				assetUsingInformation = result.getString("ASSET_USING_INFORMATION");
				assetIncreaseMethod = result.getString("ASSET_INCREASE_METHOD");
				assetChangeMode = result.getString("ASSET_CHANGE_MODE");
				assetOrigin = result.getString("ASSET_ORIGIN");
				engineeringProperty = result.getString("ENGINEERING_PROPERTY");
				fixedAssetClass = result.getString("FIXED_ASSET_CLASS");
				cardWbsElement = result.getString("CARD_WBS_ELEMENT");
				cardWbsElementDesc = result.getString("CARD_WBS_ELEMENT_DESC");
				assetStorageAddress = result.getString("ASSET_STORAGE_ADDRESS");
				lineStationName = result.getString("LINE_STATION_NAME");
				housePropCertifiNum = result.getString("HOUSE_PROP_CERTIFI_NUM");
				equipementName = result.getString("EQUIPEMENT_NAME");
				technicalObjectType = result.getString("TECHNICAL_OBJECT_TYPE");
				authorizationGroup = result.getString("AUTHORIZATION_GROUP");
				equipSpecificationModel = result.getString("EQUIP_SPECIFICATION_MODEL");
				equipNameplateNumber = result.getString("EQUIP_NAMEPLATE_NUMBER");
				maintenanceFactory = result.getString("MAINTENANCE_FACTORY");
				equipAssetChangeMode = result.getString("EQUIP_ASSET_CHANGE_MODE");
				factoryArea = result.getString("FACTORY_AREA");
				abcIdentification = result.getString("ABC_IDENTIFICATION");
				classifiedField = result.getString("CLASSIFIED_FIELD");
				equipmentCostCenter = result.getString("EQUIPMENT_COST_CENTER");
				equipmentWbsElement = result.getString("EQUIPMENT_WBS_ELEMENT");
				equipWbsElementDesc = result.getString("EQUIP_WBS_ELEMENT_DESC");
				planFactory = result.getString("PLAN_FACTORY");
				planGroup = result.getString("PLAN_GROUP");
				mainWorkCenter = result.getString("MAIN_WORK_CENTER");
				functionalPosition = result.getString("FUNCTIONAL_POSITION");
				advancedEquipment = result.getString("ADVANCED_EQUIPMENT");
				techIdentificationNumber = result.getString("TECH_IDENTIFICATION_NUMBER");
				equipUseCustodian = result.getString("EQUIP_USE_CUSTODIAN");
				equipStorageDepartment = result.getString("EQUIP_STORAGE_DEPARTMENT");
				equipObjectManageDeparment = result.getString("EQUIP_OBJECT_MANAGE_DEPARMENT");
				epqipmentIncreaseMethod = result.getString("EPQIPMENT_INCREASE_METHOD");
				equipmentSotrageAddress = result.getString("EQUIPMENT_SOTRAGE_ADDRESS");
				equipCarLicense = result.getString("EQUIP_CAR_LICENSE");
				equipHousePropCertifiNum = result.getString("EQUIP_HOUSE_PROP_CERTIFI_NUM");
				lineStationLogo = result.getString("LINE_STATION_LOGO");
				discardOriginProjectDesc = result.getString("DISCARD_ORIGIN_PROJECT_DESC");
				discardReasonContent = result.getString("DISCARD_REASON_CONTENT");
				if (null != result.getString("DATA_EXTRACT_DATE")) {
					try {
						dataExtractDate = simpleDateFormat.parse(result.getString("DATA_EXTRACT_DATE"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				if (null != result.getString("DATA_EXTRACT_TIME")) {
					try {
						dataExtractTime = simpleDateFormat.parse(result.getString("DATA_EXTRACT_TIME"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				dataExtractPerson = result.getString("DATA_EXTRACT_PERSON");
				assetProperty = result.getString("ASSET_PROPERTY");
				propertyCode = result.getString("PROPERTY_CODE");

				list.add(new MidErpItem(midErpItemId, version, calYear, calyear, orgName, compCode, assetMainNumber,
						assetSubnumber, equipementNumber, currency, largeClass, mediumClass, smallClass, voltageLevel,
						quantity, unit, originalValue, netValue, assetStatus, profitEnterSecLevelUnit, costControlArea,
						assetDescription, projectType, capitalizationDate, deliveryDate, manufactureDate, lineLength,
						lengthUnit, transformerCapacity, capacityUnit, warehouseAddress, sparePartMark,
						reusingDeviceMark, reusingEntryDate, reusingOutDate, discardProjectResourceCode,
						discardReasonCode, discardAccountingDate, equipmentStatus, equipmentVoltageLevel, isCustody,
						manufacturerCard, manufacturerEquipement, manufactureState, manufacturePartNumber,
						inactivityDate, assetCategory, cardSerialNumber, cardInventoryNumber, cardAssetUnit,
						cardStorageUnit, cardCostCenter, cardAssetManageDepart, cardUsingCustodian, cardCarLicense,
						costCenterAuxilAccounting, donationType, superviseSign, assetUsingInformation,
						assetIncreaseMethod, assetChangeMode, assetOrigin, engineeringProperty, fixedAssetClass,
						cardWbsElement, cardWbsElementDesc, assetStorageAddress, lineStationName, housePropCertifiNum,
						equipementName, technicalObjectType, authorizationGroup, equipSpecificationModel,
						equipNameplateNumber, maintenanceFactory, equipAssetChangeMode, factoryArea, abcIdentification,
						classifiedField, equipmentCostCenter, equipmentWbsElement, equipWbsElementDesc, planFactory,
						planGroup, mainWorkCenter, functionalPosition, advancedEquipment, techIdentificationNumber,
						equipUseCustodian, equipStorageDepartment, equipObjectManageDeparment, epqipmentIncreaseMethod,
						equipmentSotrageAddress, equipCarLicense, equipHousePropCertifiNum, lineStationLogo,
						discardOriginProjectDesc, discardReasonContent, dataExtractDate, dataExtractTime,
						dataExtractPerson, assetProperty, propertyCode));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * @return
	 */
	public static List<PmsQuexian> getAllByDb() {
		List<PmsQuexian> list = new ArrayList<PmsQuexian>();
		try {
			Connection conn = null;
			conn = DbUtil.getConnection();
			// 创建预编译语句对象，一般都是用这个而不用Statement
			PreparedStatement pre = null;
			// 创建一个结果集对象
			ResultSet result = null;

			String sql = "select * from PMS_QUEXIAN";
			pre = conn.prepareStatement(sql);// 实例化预编译语句
			result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String pmsQuexianId = null;
			Short calYear = null;
			String version = null;
			String sbbm = null;
			String dwmx = null;
			String qxbh = null;
			String zclxbm = null;
			String sblx = null;
			Short tynf = null;
			String dydj = null;
			String zzsmc = null;
			String sbxlmc = null;
			String qxms = null;
			String qxbw = null;
			String qxzryy = null;
			String sfxq = null;
			String sfjs = null;
			String zryybm = null;
			String qxjsyy = null;
			String jsyybm = null;
			String qxdj = null;
			Date fsrq = null;
			Date xqrq = null;
			String bz = null;
			Double xqsj = null;
			String jsyy = null;
			String zryy = null;
			String cwbm = null;
			String qfzd = null;
			Date ccrq = null;
			String zcxlms = null;
			String qxnr = null;
			String zclxbm2 = null;
			String equipementName = null;
			String lineStationName = null;
			String originalFile = null;

			System.out.println("Ready in loop!");
			int i = 1;
			Runtime run = Runtime.getRuntime();
			long maxMem = run.maxMemory() / 1024 / 1024;
			long freeMem = run.freeMemory() / 1024 / 1024;
			long totalMem = run.totalMemory();
			long usedMem = maxMem - freeMem;
			while (result.next()) {

				maxMem = run.maxMemory() / 1024 / 1024;
				freeMem = run.freeMemory() / 1024 / 1024;
				totalMem = run.totalMemory();
				usedMem = maxMem - freeMem;
				// System.out.println("Add!");
				System.out.println("i=" + (i++) + ",usedMemPercent=" + new Double(usedMem / maxMem) + ",maxMem="
						+ (maxMem) + ",freeMem=" + (freeMem) + ",usedMem=" + (usedMem) + ",totalMem=" + (totalMem));

				pmsQuexianId = result.getString("PMS_QUEXIAN_ID");
				if (null == result.getString("CAL_YEAR")) {
					calYear = new Short((short) (0));
				} else {
					calYear = new Short(result.getString("CAL_YEAR"));
				}
				version = result.getString("VERSION");
				// System.out.println("SBBM!");
				sbbm = result.getString("SBBM");
				dwmx = result.getString("DWMX");
				qxbh = result.getString("QXBH");
				// System.out.println("qxbh="+qxbh);
				zclxbm = result.getString("ZCLXBM");
				sblx = result.getString("SBLX");
				// System.out.println("TYNF!"+result.getString("TYNF")+",judge="+(null==result.getString("TYNF")));
				if (null == result.getString("TYNF")) {
					tynf = new Short((short) (0));
				} else {
					tynf = new Short(result.getString("TYNF"));
				}
				dydj = result.getString("DYDJ");
				// System.out.println("DYDJ!");
				zzsmc = result.getString("ZZSMC");
				sbxlmc = result.getString("SBXLMC");
				qxms = result.getString("QXMS");
				qxbw = result.getString("QXBW");
				qxzryy = result.getString("QXZRYY");
				sfxq = result.getString("SFXQ");
				sfjs = result.getString("SFJS");
				// System.out.println("ZRYYBM!");
				zryybm = result.getString("ZRYYBM");
				qxjsyy = result.getString("QXJSYY");
				jsyybm = result.getString("JSYYBM");
				qxdj = result.getString("QXDJ");

				// System.out.println("FSRQ!");
				if (null != result.getString("FSRQ")) {
					try {
						fsrq = simpleDateFormat.parse(result.getString("FSRQ"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				// System.out.println("XQRQ!");
				if (null != result.getString("XQRQ")) {
					try {
						xqrq = simpleDateFormat.parse(result.getString("XQRQ"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}

				bz = result.getString("BZ");
				// System.out.println("XQSJ!");
				if (null == result.getString("XQSJ")) {
					xqsj = Double.parseDouble("0.0");
				} else {
					xqsj = new Double(result.getString("XQSJ"));
				}
				jsyy = result.getString("JSYY");
				zryy = result.getString("ZRYY");
				cwbm = result.getString("CWBM");
				qfzd = result.getString("QFZD");

				// System.out.println("CCRQ!");
				if (null != result.getString("CCRQ")) {
					try {
						ccrq = simpleDateFormat.parse(result.getString("CCRQ"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}

				zcxlms = result.getString("ZCXLMS");
				qxnr = result.getString("QXNR");
				zclxbm2 = result.getString("ZCLXBM2");

				equipementName = result.getString("EQUIPEMENT_NAME");
				lineStationName = result.getString("LINE_STATION_NAME");
				originalFile = result.getString("ORIGINALFILE");

				list.add(new PmsQuexian(pmsQuexianId, calYear, version, sbbm, dwmx, qxbh, zclxbm, sblx, tynf, dydj,
						zzsmc, sbxlmc, qxms, qxbw, qxzryy, sfxq, sfjs, zryybm, qxjsyy, jsyybm, qxdj, fsrq, xqrq, bz,
						xqsj, jsyy, zryy, cwbm, qfzd, ccrq, zcxlms, qxnr, zclxbm2, equipementName, lineStationName,
						originalFile));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
