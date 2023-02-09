package com.yunhai.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.yunhai.excel.orm.MidPowerConsumption;

public class PowerConsumptionImport {

	// 记录类的输出信息­
	static Log log = LogFactory.getLog(PowerConsumptionImport.class);

	// 获取Excel文档的路径�?
	public static void main(String[] args) throws ParseException, IOException {
		// TODO Auto-generated method stub
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开�?个Session
		Session session = sf.openSession();
		// String path="F:\\temp\\2008-2017地区用电";
		String path = "D:\\temp\\2020年潮�?";
		String importedFilePath = "D:\\temp\\2020年潮�?-已经导入文件";
		String errorRowFilePath = "D:\\temp\\2020年潮�?-行数异常文件";

		String[] paths = { "F:\\temp\\2008-2017地区用电", "F:\\temp\\2018地区用电" };
		int standardRowNumber = 288;
		ArrayList<String> fileNameList = new ArrayList<String>();
		boolean flag = false;
		// 打开路径文件
		File file = new File(path);
		// 获取路径下的文件列表
		File[] tempList = file.listFiles();
		/**
		 * 循环获取路径下的文件
		 */
		for (int k = 0; k < tempList.length; k++) {
			// if(k==1) break;
			// 获取第k个文�?
			String fileName = tempList[k].getName();
			String filePath = path + "\\" + fileName;// "D://excel.xls";
			// System.out.println("filePath="+filePath+",tempList[k].getName().length="+tempList[k].getName().length());
			// System.out.println("DATE="+tempList[k].getName().substring(10,20));
			// System.out.println("tempList[k].getName()=" +
			// tempList[k].getName());
			String dvDate = tempList[k].getName().substring(10, 20);
			// String areaNameValue = tempList[k].getName().substring(11, 13);
			System.out.println("dateStr=" + dvDate);
			// filePath ="D://excel.xls";

			try {
				// 创建对Excel工作簿文件的引用­
				HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(filePath));
				// 在Excel文档中，第一张工作表的缺省索引是0
				// 其语句为：HSSFSheet sheet = workbook.getSheetAt(0);
				// HSSFSheet sheet = workbook.getSheet("Sheet1");
				HSSFSheet sheet = workbook.getSheetAt(0);
				// System.out.println("sheet.getSheetName()="+sheet.getSheetName());
				// 获取到Excel文件中的�?有行�?
				int rows = sheet.getPhysicalNumberOfRows();
				System.out.println("sheet.getPhysicalNumberOfRows()=" + sheet.getPhysicalNumberOfRows());
				// System.out.println("rows=" + rows);
				// ArrayList <String> valueArray=null;
				int rowNotNullQuantity = 0;
				ArrayList<ArrayList<String>> valueArray = new ArrayList<ArrayList<String>>();// 链表矩阵

				ArrayList<String> dispatchOrgName = new ArrayList<String>();// 变电站列�?
				// int dispatchOrgNamei = 1;
				HSSFRow row2 = sheet.getRow(1);
				int cells2 = row2.getPhysicalNumberOfCells();// 表头单元格数�?
				System.out.println("cells2=" + cells2);
				/**
				 * 将表头各 调度单位名称 读取出来，取值为空的用文件标注的时间+列号+X调度保存，方便追溯确认�??
				 */
				for (int i = 1; i < cells2;) {
					HSSFCell cell = row2.getCell(i);
					if (cell != null) {
						switch (cell.getCellType()) {
						case HSSFCell.CELL_TYPE_FORMULA:
							break;
						case HSSFCell.CELL_TYPE_NUMERIC:
							System.out.println(cell.getNumericCellValue());
							if (!"时刻".equals(cell.getNumericCellValue() + "")) {
								// System.out.println(cell.getStringCellValue());
								dispatchOrgName.add(cell.getStringCellValue() + "");
								// dispatchOrgNamei++;
							}
							break;
						case HSSFCell.CELL_TYPE_STRING:
							if (!"时刻".equals(cell.getStringCellValue())) {
								// System.out.println(cell.getStringCellValue());
								dispatchOrgName.add(cell.getStringCellValue());
								// dispatchOrgNamei++;
							}
							break;
						default:
							if (!"时刻".equals(cell.getStringCellValue())) {
								// System.out.println(dvDate + i + "X调度");
								dispatchOrgName.add("X调度");
								// dispatchOrgNamei++;
							}
							// System.out.println("i=" + i);
							break;
						}
					}
					i = i + 2;
				}
				/**
				 * 遍历行，将除表头之外的数据读取到数据阵列表中 从第3行开始，i=2 realRowNumber=1;
				 */
				// 设定实物数据行数
				int realRowNumber = 1;
				// 起始行设�?
				int startRowNumber = 3;
				for (int i = startRowNumber; i < rows; i++) {
					// 读取左上端单元格
					HSSFRow row = sheet.getRow(i);
					ArrayList<String> rowValue = new ArrayList<String>();
					// rowValue.add("element");
					// 行不为空
					if (row != null) {
						rowNotNullQuantity++;
						// 获取到Excel文件中的�?有的�?
						int cells = row.getPhysicalNumberOfCells();
						// System.out.println("cells="+cells);
						// String value = "";
						// 遍历�?
						for (int j = 0; j < cells; j++) {
							// String []valueRow= new Array[cells];
							// 获取到列的�??
							HSSFCell cell = row.getCell(j);

							if (cell != null) {
								switch (cell.getCellType()) {
								case HSSFCell.CELL_TYPE_FORMULA:
									break;
								case HSSFCell.CELL_TYPE_NUMERIC:
									// System.out.println(cell.getNumericCellValue()+"");
									rowValue.add(cell.getNumericCellValue() + "");
									break;
								case HSSFCell.CELL_TYPE_STRING:
									// System.out.println(cell.getStringCellValue()+"");
									if ("引发类型为�?�System.OutOfMemoryException”的异常�?".equals(cell.getStringCellValue())) {
										rowValue.add("0");
									} else {
										rowValue.add(cell.getStringCellValue());
									}
									break;
								default:
									rowValue.add("0");
									break;
								}
							}

							// System.out.println("value="+value);
						}
						valueArray.add(rowValue);
					}

					// System.out.println("rowValue.size()"+rowValue.size());
				}

				// 如果实际行数不等于standardRowNumber(288)，则将文件复制到“D:/2020年潮�?-异常文件/”路径下
				if (rowNotNullQuantity != standardRowNumber) {
					File copyfile = new File(filePath);
					File errorRowFile = new File(errorRowFilePath + "\\" + fileName);
					Files.copy(copyfile.toPath(), errorRowFile.toPath());
				}
				// System.out.println("valueArray.size()=" + valueArray.size() +
				// ",rowNotNullQuantity="
				// + rowNotNullQuantity + "valueArray.get(0).size()" +
				// valueArray.get(0).size());

				/*
				 * for (int i=0;i< valueArray.get(0).size(); i++){
				 * System.out.println("valueArray.get(0).get("+i+")"+valueArray.get(0).get(i));
				 * } for (int i=0;i< valueArray.get(1).size(); i++){
				 * System.out.println("valueArray.get(1).get("+i+")"+valueArray.get(1).get(i));
				 * }
				 */
				int transactionStatus = 0;
				// System.out.println("valueArray.get(0).size()"+valueArray.get(0).size()+"dispatchOrgName.size()"+dispatchOrgName.size());
				for (int j = 1; j < valueArray.get(0).size();) {
					ArrayList<ArrayList<String>> colValues = new ArrayList<ArrayList<String>>();
					ArrayList<String> dateCol = new ArrayList<String>();
					ArrayList<String> timeCol = new ArrayList<String>();
					ArrayList<String> dispatchOrgNameCol = new ArrayList<String>();
					ArrayList<String> powerConsumptionQuantityCol = new ArrayList<String>();
					ArrayList<String> qConsumptionQuantityCol = new ArrayList<String>();
					// System.out.println("valueArray.size()="+valueArray.size());

					for (int i = 0; i < valueArray.size(); i++) {
						// System.out.println("valueArray.size()="+valueArray.size()+",i="+i);
						ArrayList<String> rowValue = valueArray.get(i);
						// System.out.println("rowValue.size()"+rowValue.size());
						dateCol.add(dvDate);
						timeCol.add(rowValue.get(0));
						// 调度列表中的调度数量�? valueArray.size() 少一列，即时间那�?列，因此要保证数据与调度单位�?致，下标要减1
						dispatchOrgNameCol.add(dispatchOrgName.get((j - 1) / 2));// dispatchOrgName中元素数量只有valueArray.get(0).size()的一半�?�注意，因此�?�?-1�?2.

						powerConsumptionQuantityCol.add(rowValue.get(j));
						qConsumptionQuantityCol.add(rowValue.get(j + 1));
						// System.out.println(powerConsumptionQuantityCol.size());
					}
					colValues.add(dateCol);
					colValues.add(timeCol);
					colValues.add(dispatchOrgNameCol);
					colValues.add(powerConsumptionQuantityCol);
					colValues.add(qConsumptionQuantityCol);
					// System.out.println("dateCol.size()="+dateCol.size()+",powerConsumptionQuantityCol.size()="+powerConsumptionQuantityCol.size());
					// 如果excelMidTransformerFlow288pAdd 方法将数据向数据库插入时出现短时的延时断网，则返�? 1
					transactionStatus = excelMidPowerConsumptionAdd(colValues, session);
					// 如果 transactionStatus=1,则尝试着将当前循环重新进行一次，故将j设置�?1.
					// 前提是需要将dateCol当前日期的数据先删除,删除之后，将transactionStatus设置�?0�?
					/*
					 * if (transactionStatus == 1) { j = 1; session = sf.openSession();
					 * deleteByDate(dateCol.get(0).substring(1,10),session); transactionStatus=0; }
					 * if(transactionStatus==0){ j += 2; }
					 */

					j = j + 2;
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			File fileToDelete = new File(filePath);
			File importedFile = new File(importedFilePath + "\\" + fileName);
			Files.copy(fileToDelete.toPath(), importedFile.toPath());
			fileToDelete.delete();

		}

		sf.close();
	}

	/**
	 * 
	 * @param dateValue
	 * @param session
	 * 
	 */
	public static void deleteByDate(String dateValue, Session session) {
		String sqlStr = "DELETE FROM MID_POWER_CONSUMPTION A WHERE TO_CHAR(A.DV_DATE,'YYYY-MM-DD')=?";
		SQLQuery query = session.createSQLQuery(sqlStr);
		query.setString(0, dateValue);
		query.executeUpdate();
	}

	public static int excelMidPowerConsumptionAdd(ArrayList<ArrayList<String>> colValues, Session session)
			throws ParseException {
		int transactionStatus = 0;
		// �?始一个事�?
		Transaction tx = session.beginTransaction();

		ArrayList<String> dateCol = colValues.get(0);
		ArrayList<String> timeCol = colValues.get(1);
		ArrayList<String> dispatchOrgNameCol = colValues.get(2);
		ArrayList<String> powerConsumptionQuantityCol = colValues.get(3);
		ArrayList<String> qConsumptionQuantityCol = colValues.get(4);
		// System.out.println("dateCol.size()="+dateCol.size()+",pColValue.size()="+pColValue.size()+",qColValue.size()="+qColValue.size());

		for (int i = 0; i < dateCol.size(); i++) {
			MidPowerConsumption midPowerConsumption = new MidPowerConsumption();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			midPowerConsumption.setTimestampName(timeCol.get(i));
			midPowerConsumption.setDispatchOrgName(dispatchOrgNameCol.get(i)); 
			midPowerConsumption.setPowerConsumptionQuantity(
					new DecimalFormat().parse(powerConsumptionQuantityCol.get(i).trim()).doubleValue());

			midPowerConsumption.setqConsumptionQuantity(
					new DecimalFormat().parse(qConsumptionQuantityCol.get(i).trim()).doubleValue());
			//
			// System.out.println("powerConsumptionQuantityCol.get(" + i + ").trim()" +
			// powerConsumptionQuantityCol.get(i).trim() + "timeCol.get(i)"
			// + timeCol.get(i) + "dispatchOrgNameCol.get(i)" + dispatchOrgNameCol.get(i));
			try {
				midPowerConsumption.setDvDate(simpleDateFormat.parse(dateCol.get(i)));
			} catch (ParseException e) {
				e.printStackTrace();

			}
			session.save(midPowerConsumption);

			if (i % 200 == 0) {
				session.flush();
				session.clear();
				// tx.commit();
				try {
					tx.commit();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("延时报错了！");
					System.out.println("date" + dateCol.get(0).substring(1, 10));
					transactionStatus = 1;
					return transactionStatus;
					// e.printStackTrace();
				}
				tx = session.beginTransaction();
			}
		}
		try {
			tx.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("延时报错了！");
			System.out.println("date" + dateCol.get(0).substring(1, 10));
			transactionStatus = 1;
			return transactionStatus;
			// e.printStackTrace();
		}
		session.clear();
		return transactionStatus;
	}
}
