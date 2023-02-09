package com.yunhai.word.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.commons.compress.utils.IOUtils;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.xmlbeans.XmlCursor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STVerticalJc;

import com.deepoove.poi.XWPFTemplate;
import com.yunhai.bean.Dimension;
import com.yunhai.db.util.DbUtil;

import sun.misc.BASE64Decoder;

public class WordOutTest {
	public static void main(String[] args) throws Exception {
		exceptionDataReportGeneration();
	}

	public WordOutTest() {
		// TODO Auto-generated constructor stub
	} 
	public static void exceptionDataReportGeneration() throws Exception {
		// TODO Auto-generated method stub
		InputStream is = new FileInputStream("E:\\Workspace\\Workspaces\\JavaTestFile\\template.docx");
		// 这里是你要写入的文件
		XWPFDocument xdoc = new XWPFDocument(is);
		// 创建一个段落
		XWPFParagraph xpara = xdoc.createParagraph();

		// 一个XWPFRun代表具有相同属性的一个区域。
		XWPFRun run = xpara.createRun();
		run.setBold(true); // 加粗
		run.setText("加粗的内容");
		run = xpara.createRun();
		run.setColor("FF0000");
		run.setFontSize(15);
		run.setText("插入内容;");
		run = xpara.createRun();
		run.setColor("FF00FF");
		run.setFontSize(15);
		run.setText("异常数据数量：");
		run = xpara.createRun();
		run.setColor("FF0000");
		run.setFontSize(15);
		run.setText("188");

		// 创建一个新的段落
		xpara = xdoc.createParagraph();
		// 一个XWPFRun代表具有相同属性的一个区域。
		run = xpara.createRun();
		run.setText("表ERP_ITEM_ALL");
		run = xpara.createRun();
		run.setColor("FF0000");
		run.setFontSize(15);
		run.setText("插入内容;");
		run = xpara.createRun();
		run.setColor("FF00FF");
		run.setFontSize(15);
		run.setText("异常数据数量：");
		run = xpara.createRun();
		run.setColor("FF0000");
		run.setFontSize(15);
		run.setText("188");

		// 创建一个新的段落
		xpara = xdoc.createParagraph();
		XmlCursor cursor = xpara.getCTP().newCursor();
		// 在指定游标位置插入表格
		XWPFTable table = xdoc.insertNewTbl(cursor);
		CTTblPr tablePr = table.getCTTbl().getTblPr();
		CTTblWidth width = tablePr.addNewTblW();
		width.setW(BigInteger.valueOf(8500)); 
		insertTable(table);

		String imgPath = "E:\\Workspace\\Workspaces\\JavaTestFile\\数据分割流程图.png";
		// 创建一个新的段落
		// xpara = xdoc.createParagraph();
		// 一个XWPFRun代表具有相同属性的一个区域。
		run = xpara.createRun();
		writeImage(run, imgPath);

		// 创建一个新的段落
		xpara = xdoc.createParagraph(); 
		run = xpara.createRun();
		run.setBold(true); // 加粗
		run.setText("加粗的内容");
		run = xpara.createRun();
		run.setColor("FF0000");
		run.setFontSize(15);
		run.setText("插入内容;");
		run = xpara.createRun();
		run.setColor("FF00FF");
		run.setFontSize(15);
		run.setText("异常数据数量：");
		run = xpara.createRun();
		run.setColor("FF0000");
		run.setFontSize(15);
		run.setText("188");

		OutputStream os = new FileOutputStream("E:\\Workspace\\Workspaces\\JavaTestFile\\output"
				+ new Date().toLocaleString().trim().replace(":", "：") + ".docx");
		xdoc.write(os);
		os.close();
	}

	/**
	 * @throws SQLException
	 * 
	 */
	public static List queryErrorRecordReport() throws SQLException {

		// 创建预编译语句对象，一般都是用这个而不用Statement
		PreparedStatement pre = null;
		// 创建一个结果集对象
		ResultSet result = null;
		Connection conn = null;
		conn = DbUtil.getConnection();
		String sql = "SELECT CAL_YEAR,VERSION,DWMX,COUNT (*) QUANTITY FROM PMS_ITEM_ALL A \r\n"
				+ "WHERE A .SBBM IS NULL GROUP BY CAL_YEAR,VERSION,DWMX\r\n" + "ORDER BY CAL_YEAR,VERSION,DWMX";
		pre = conn.prepareStatement(sql);// 实例化预编译语句
		result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
		List<String> fieldList = new ArrayList();
		// 获取列数
		ResultSetMetaData rsd = result.getMetaData();
		int columnCount = rsd.getColumnCount(); 
		List<Map<String, String>> fieldValueList = new ArrayList();

		Map<String, String> headMap = new HashMap();
		for (int colI = 1; colI <= columnCount; colI++) {
			String columnName = rsd.getColumnLabel(colI);
			// System.out.println("colI=" + (" " + colI) + ",columnName=" + columnName);
			headMap.put("" + colI, columnName);
		}
		fieldValueList.add(headMap);
		//对浮点数的有效位数值
		int fractionDigits=2;
		//对浮点数的有效位数格式控制格式
		NumberFormat ddf1=NumberFormat.getNumberInstance();
		ddf1.setMaximumFractionDigits(fractionDigits);
		
		while (result.next()) {
			Map<String, String> fieldValueMap = new HashMap();
			for (int colI = 1; colI <= columnCount; colI++) {
				String columnName = rsd.getColumnLabel(colI);
				String value = result.getString(columnName);
				// System.out.println("columnName=" + columnName + ", value=" + value);
				if (rsd.getColumnType(colI) == 93) {// 93为时间类型 DATE:93 is code of date(DATE)
					fieldValueMap.put(columnName, result.getDate(columnName).toLocaleString());
				} else if (rsd.getColumnType(colI) == 12) {// 12为字符串类型 VARCHAR2()
					fieldValueMap.put(columnName, result.getString(columnName));
				} else if (rsd.getColumnType(colI) == -9) {// -9为字符串类型 NVARCHAR2()
					fieldValueMap.put(columnName, result.getString(columnName));
				} else if (rsd.getColumnType(colI) == 2) {// 2为双精度类型 NUMBER 
					fieldValueMap.put(columnName, ddf1.format(result.getDouble(columnName)).replace(",", "") ); 
				} else {
					fieldValueMap.put(value, result.getString(value).toString());
				}
			}
			fieldValueList.add(fieldValueMap);
		}
		// System.out.println("Size=" + fieldValueList.size());
		return fieldValueList;
	}

	/**
	 * 向Word中插入图片(仅支持png格式图片, 未完待续...)
	 * 
	 * @param run
	 * @param imagePath 图片文件路径
	 * @throws Exception
	 */
	public static void writeImage(XWPFRun run, String imagePath) throws Exception {
		BufferedImage image = getImgByFilePath(imagePath);
		int width = Units.toEMU(image.getWidth());
		int height = Units.toEMU(image.getHeight());
		run.addPicture(new FileInputStream(imagePath), XWPFDocument.PICTURE_TYPE_PNG, "test", width, height);
	}

	/**
	 * 根据图片路径获取图片
	 * 
	 * @param path
	 * @return
	 * @throws Exception
	 */
	public static BufferedImage getImgByFilePath(String path) throws Exception {
		FileInputStream fis = new FileInputStream(path);
		byte[] byteArray = IOUtils.toByteArray(fis);
		ByteArrayInputStream bais = new ByteArrayInputStream(byteArray);
		return ImageIO.read(bais);
	}

	/**
	 * 将base64码转成字节数组输入流
	 * 
	 * @param imgStr
	 * @return
	 */
	public static ByteArrayInputStream getImgByBase64Str(String imgStr) {// 对字节数组字符串进行Base64解码并生成图片
		if (imgStr == null) // 图像数据为空
			return null;
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			// Base64解码
			byte[] bytes = decoder.decodeBuffer(imgStr);
			for (int i = 0; i < bytes.length; ++i) {
				if (bytes[i] < 0) {// 调整异常数据
					bytes[i] += 256;
				}
			}
			return new ByteArrayInputStream(bytes);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 把信息插入表格
	 * 
	 * @param table
	 * @param data
	 * @throws SQLException
	 */
	private static void insertTable(XWPFTable table) throws SQLException {

		List<Map<String, String>> fieldValueList = queryErrorRecordReport();
		Map<String, String> headMap = fieldValueList.get(0);
		//创建表头
		XWPFTableRow row = table.getRow(0);
		XWPFTableCell cell = null;
		// 默认会创建一列，即从第2列开始
		for (int col = 1; col <headMap.size()-1; col++) {
			// 第一行创建了多少列，后续增加的行自动增加列
			CTTcPr cPr = row.createCell().getCTTc().addNewTcPr();
			CTTblWidth width = cPr.addNewTcW();
			width.setW(BigInteger.valueOf(2000));
		}
		// 默认会创建一列，即从第2列开始
		// 第一行创建了多少列，后续增加的行自动增加列
		CTTcPr cPr = row.createCell().getCTTc().addNewTcPr(); 
		for (int col = 1; col <=headMap.size(); col++) {
			XWPFTableCell cellItem = row.getCell(col-1);
			CTTc cttc = cellItem.getCTTc();
			CTTcPr ctPr = cttc.addNewTcPr();
			ctPr.addNewVAlign().setVal(STVerticalJc.CENTER);
			cttc.getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
			cellItem.setText(headMap.get("" + col));
		}

		for (int listI = 1; listI < fieldValueList.size(); listI++) {
			row = table.createRow();
			Map<String, String> listItem = fieldValueList.get(listI); 
			for (int mapI = 1; mapI <= headMap.size(); mapI++) {
				//System.out.println(headMap.get("" + mapI) + ":" + listItem.get(headMap.get("" + mapI)));
				cell = row.getCell(mapI-1);
				cell.getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(2000));
				CTTc cttc = cell.getCTTc();
				CTTcPr ctPr = cttc.addNewTcPr();
				ctPr.addNewVAlign().setVal(STVerticalJc.CENTER);
				cttc.getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
				cell.setText(listItem.get(headMap.get("" + mapI)));
			}
		} 
	}
}
