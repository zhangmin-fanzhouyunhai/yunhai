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
		// ��������Ҫд����ļ�
		XWPFDocument xdoc = new XWPFDocument(is);
		// ����һ������
		XWPFParagraph xpara = xdoc.createParagraph();

		// һ��XWPFRun���������ͬ���Ե�һ������
		XWPFRun run = xpara.createRun();
		run.setBold(true); // �Ӵ�
		run.setText("�Ӵֵ�����");
		run = xpara.createRun();
		run.setColor("FF0000");
		run.setFontSize(15);
		run.setText("��������;");
		run = xpara.createRun();
		run.setColor("FF00FF");
		run.setFontSize(15);
		run.setText("�쳣����������");
		run = xpara.createRun();
		run.setColor("FF0000");
		run.setFontSize(15);
		run.setText("188");

		// ����һ���µĶ���
		xpara = xdoc.createParagraph();
		// һ��XWPFRun���������ͬ���Ե�һ������
		run = xpara.createRun();
		run.setText("��ERP_ITEM_ALL");
		run = xpara.createRun();
		run.setColor("FF0000");
		run.setFontSize(15);
		run.setText("��������;");
		run = xpara.createRun();
		run.setColor("FF00FF");
		run.setFontSize(15);
		run.setText("�쳣����������");
		run = xpara.createRun();
		run.setColor("FF0000");
		run.setFontSize(15);
		run.setText("188");

		// ����һ���µĶ���
		xpara = xdoc.createParagraph();
		XmlCursor cursor = xpara.getCTP().newCursor();
		// ��ָ���α�λ�ò�����
		XWPFTable table = xdoc.insertNewTbl(cursor);
		CTTblPr tablePr = table.getCTTbl().getTblPr();
		CTTblWidth width = tablePr.addNewTblW();
		width.setW(BigInteger.valueOf(8500)); 
		insertTable(table);

		String imgPath = "E:\\Workspace\\Workspaces\\JavaTestFile\\���ݷָ�����ͼ.png";
		// ����һ���µĶ���
		// xpara = xdoc.createParagraph();
		// һ��XWPFRun���������ͬ���Ե�һ������
		run = xpara.createRun();
		writeImage(run, imgPath);

		// ����һ���µĶ���
		xpara = xdoc.createParagraph(); 
		run = xpara.createRun();
		run.setBold(true); // �Ӵ�
		run.setText("�Ӵֵ�����");
		run = xpara.createRun();
		run.setColor("FF0000");
		run.setFontSize(15);
		run.setText("��������;");
		run = xpara.createRun();
		run.setColor("FF00FF");
		run.setFontSize(15);
		run.setText("�쳣����������");
		run = xpara.createRun();
		run.setColor("FF0000");
		run.setFontSize(15);
		run.setText("188");

		OutputStream os = new FileOutputStream("E:\\Workspace\\Workspaces\\JavaTestFile\\output"
				+ new Date().toLocaleString().trim().replace(":", "��") + ".docx");
		xdoc.write(os);
		os.close();
	}

	/**
	 * @throws SQLException
	 * 
	 */
	public static List queryErrorRecordReport() throws SQLException {

		// ����Ԥ����������һ�㶼�������������Statement
		PreparedStatement pre = null;
		// ����һ�����������
		ResultSet result = null;
		Connection conn = null;
		conn = DbUtil.getConnection();
		String sql = "SELECT CAL_YEAR,VERSION,DWMX,COUNT (*) QUANTITY FROM PMS_ITEM_ALL A \r\n"
				+ "WHERE A .SBBM IS NULL GROUP BY CAL_YEAR,VERSION,DWMX\r\n" + "ORDER BY CAL_YEAR,VERSION,DWMX";
		pre = conn.prepareStatement(sql);// ʵ����Ԥ�������
		result = pre.executeQuery();// ִ�в�ѯ��ע�������в���Ҫ�ټӲ���
		List<String> fieldList = new ArrayList();
		// ��ȡ����
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
		//�Ը���������Чλ��ֵ
		int fractionDigits=2;
		//�Ը���������Чλ����ʽ���Ƹ�ʽ
		NumberFormat ddf1=NumberFormat.getNumberInstance();
		ddf1.setMaximumFractionDigits(fractionDigits);
		
		while (result.next()) {
			Map<String, String> fieldValueMap = new HashMap();
			for (int colI = 1; colI <= columnCount; colI++) {
				String columnName = rsd.getColumnLabel(colI);
				String value = result.getString(columnName);
				// System.out.println("columnName=" + columnName + ", value=" + value);
				if (rsd.getColumnType(colI) == 93) {// 93Ϊʱ������ DATE:93 is code of date(DATE)
					fieldValueMap.put(columnName, result.getDate(columnName).toLocaleString());
				} else if (rsd.getColumnType(colI) == 12) {// 12Ϊ�ַ������� VARCHAR2()
					fieldValueMap.put(columnName, result.getString(columnName));
				} else if (rsd.getColumnType(colI) == -9) {// -9Ϊ�ַ������� NVARCHAR2()
					fieldValueMap.put(columnName, result.getString(columnName));
				} else if (rsd.getColumnType(colI) == 2) {// 2Ϊ˫�������� NUMBER 
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
	 * ��Word�в���ͼƬ(��֧��png��ʽͼƬ, δ�����...)
	 * 
	 * @param run
	 * @param imagePath ͼƬ�ļ�·��
	 * @throws Exception
	 */
	public static void writeImage(XWPFRun run, String imagePath) throws Exception {
		BufferedImage image = getImgByFilePath(imagePath);
		int width = Units.toEMU(image.getWidth());
		int height = Units.toEMU(image.getHeight());
		run.addPicture(new FileInputStream(imagePath), XWPFDocument.PICTURE_TYPE_PNG, "test", width, height);
	}

	/**
	 * ����ͼƬ·����ȡͼƬ
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
	 * ��base64��ת���ֽ�����������
	 * 
	 * @param imgStr
	 * @return
	 */
	public static ByteArrayInputStream getImgByBase64Str(String imgStr) {// ���ֽ������ַ�������Base64���벢����ͼƬ
		if (imgStr == null) // ͼ������Ϊ��
			return null;
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			// Base64����
			byte[] bytes = decoder.decodeBuffer(imgStr);
			for (int i = 0; i < bytes.length; ++i) {
				if (bytes[i] < 0) {// �����쳣����
					bytes[i] += 256;
				}
			}
			return new ByteArrayInputStream(bytes);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * ����Ϣ������
	 * 
	 * @param table
	 * @param data
	 * @throws SQLException
	 */
	private static void insertTable(XWPFTable table) throws SQLException {

		List<Map<String, String>> fieldValueList = queryErrorRecordReport();
		Map<String, String> headMap = fieldValueList.get(0);
		//������ͷ
		XWPFTableRow row = table.getRow(0);
		XWPFTableCell cell = null;
		// Ĭ�ϻᴴ��һ�У����ӵ�2�п�ʼ
		for (int col = 1; col <headMap.size()-1; col++) {
			// ��һ�д����˶����У��������ӵ����Զ�������
			CTTcPr cPr = row.createCell().getCTTc().addNewTcPr();
			CTTblWidth width = cPr.addNewTcW();
			width.setW(BigInteger.valueOf(2000));
		}
		// Ĭ�ϻᴴ��һ�У����ӵ�2�п�ʼ
		// ��һ�д����˶����У��������ӵ����Զ�������
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
