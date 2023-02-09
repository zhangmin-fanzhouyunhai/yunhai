package jUnit.day13.domain.reflect;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yunhai.db.orm.TableColumnProperty;
import com.yunhai.db.util.DbUtil;
import com.yunhai.excel.ExportDao;
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

public class Demo {

	@Test
	public void midErpItemTest() throws ClassNotFoundException, SQLException, NoSuchFieldException, SecurityException,
			NoSuchMethodException, RowsExceededException, WriteException {
		String tableName = "MID_ERP_ITEM";
		int recordQuantity = 50000;
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
			String classString = "com.yunhai.excel.orm.MidErpItem";
			Class clazz = Class.forName(classString);
			JSON.parseObject(JSON.toJSONStringWithDateFormat(jsonObj, "yyyy-MM-dd HH:mm:ss.s"), clazz);
			objList.add(JSON.parseObject(JSON.toJSONStringWithDateFormat(jsonObj, "yyyy-MM-dd HH:mm:ss.s"), clazz));
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
			for (int labelI = 0; labelI < 10; labelI++) {
				TableColumnProperty tableColumnProperty = (TableColumnProperty) headList.get(labelI);
				String columnName = tableColumnProperty.getColumnName();
				JSONObject JSONObj = (JSONObject) list.get(i);
				System.out.println("JSONObj.get(" + columnName + ")=" + JSONObj.get(columnName));
				sheet.addCell(new Label(labelI, i + 1 - recordQuantityTimes, (String) JSONObj.get(columnName)));
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

}
