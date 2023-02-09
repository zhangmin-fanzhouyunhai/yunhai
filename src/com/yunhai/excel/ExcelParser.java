package com.yunhai.excel;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.eventusermodel.ReadOnlySharedStringsTable;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler.SheetContentsHandler;
import org.apache.poi.xssf.model.StylesTable;
import org.apache.poi.xssf.usermodel.XSSFComment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 * ������������Excel������
 * 
 * @author ����
 *
 */
@Component
public class ExcelParser {
	private static final Logger logger = LoggerFactory.getLogger(ExcelParser.class);
	/**
	 * ���Ĭ�ϴ�����
	 */
	private ISheetContentHandler contentHandler = new DefaultSheetHandler();

	/**
	 * ��ȡ����
	 */
	private List<String[]> datas = new ArrayList<String[]>();

	/**
	 * ת�����Ĭ��Ϊת����һ�����
	 * 
	 * @param stream
	 * @return
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @throws ParseException
	 */
	public ExcelParser parse(InputStream stream) throws InvalidFormatException, IOException, ParseException {
		return parse(stream, 1);
	}

	/**
	 * 
	 * @param stream
	 * @param        sheetId:ΪҪ������sheet��������1��ʼ
	 * @return
	 * @throws IOException
	 * @throws InvalidFormatException
	 * @throws ParseException
	 * 
	 */
	public synchronized ExcelParser parse(InputStream stream, int sheetId)
			throws InvalidFormatException, IOException, ParseException {
		// ÿ��ת��ǰ���������
		datas.clear();
		// �򿪱���ļ�������
		OPCPackage pkg = OPCPackage.open(stream);
		try {

			// �������Ķ���
			XSSFReader reader = null;
			try {
				reader = new XSSFReader(pkg);
			} catch (OpenXML4JException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// ת��ָ����Ԫ��
			InputStream shellStream = reader.getSheet("rId" + sheetId);
			try {
				InputSource sheetSource = new InputSource(shellStream);
				StylesTable styles = reader.getStylesTable();
				ReadOnlySharedStringsTable strings = new ReadOnlySharedStringsTable(pkg);
				getContentHandler().init(datas);// ���ö�ȡ��������
				// ��ȡת����
				XMLReader parser = getSheetParser(styles, strings);
				parser.parse(sheetSource);
			} catch (SAXException e) {
				// TODO: handle exception
				logger.error("��ȡ������");
				throw new ParseException(e.fillInStackTrace());
			} finally {
				shellStream.close();
			}

		} finally {
			pkg.close();
		}

		return this;
	}

	/**
	 * ��ȡ����ȡ���ݣ���ȡ����ǰ����Ҫ��ת������<br>
	 * �˷��������ȡ��һ������
	 * 
	 * @return ����ȡ����
	 */
	public List<String[]> getDatas() {
		return getDatas(true);
	}

	/**
	 * ��ȡ����ȡ���ݣ���ȡ����ǰ����Ҫ��ת������
	 * 
	 * @param dropFirstRow ɾ����һ�б�ͷ��¼
	 * @return ����ȡ����
	 */
	public List<String[]> getDatas(boolean dropFirstRow) {
		if (dropFirstRow && datas.size() > 0) {
			datas.remove(0);// ɾ����ͷ
		}
		return datas;
	}

	/**
	 * ��ȡ��ȡ����ת����
	 * 
	 * @param styles
	 * @param strings
	 * @return ��ȡ����ת����
	 * @throws SAXException SAX����
	 */
	protected XMLReader getSheetParser(StylesTable styles, ReadOnlySharedStringsTable strings) throws SAXException {
		XMLReader parser = XMLReaderFactory.createXMLReader();
		parser.setContentHandler(new XSSFSheetXMLHandler(styles, strings, getContentHandler(), false));
		return parser;
	}

	public ISheetContentHandler getContentHandler() {
		return contentHandler;
	}

	public void setContentHandler(ISheetContentHandler contentHandler) {
		this.contentHandler = contentHandler;
	}

	/**
	 * ���ת������
	 */
	public class ParseException extends Exception {
		private static final long serialVersionUID = -2451526411018517607l;

		public ParseException(Throwable t) {
			super("���ת������", t);
		}
	}

	public interface ISheetContentHandler extends SheetContentsHandler {
		/**
		 * ����ת��������ݼ������ڴ��ת�����
		 * 
		 * @param datas ת�����
		 */
		void init(List<String[]> datas);
	}

	/**
	 * Ĭ�ϱ�����handler
	 * 
	 * @author Administrator
	 *
	 */
	class DefaultSheetHandler implements ISheetContentHandler {
		/**
		 * ��ȡ����
		 */
		private List<String[]> datas;
		private int columnsLength;
		// ��ȡ����Ϣ
		private String[] readRow;
		private ArrayList<String> firstRow = new ArrayList<String>();

		@Override
		public void init(List<String[]> datas) {
			this.datas = datas;
			// this.columnsLength=columnsLength;
		}

		@Override
		public void startRow(int rowNum) { 
			if (rowNum != 0) {
				readRow = new String[columnsLength];
			}
		}

		@Override
		public void endRow(int rowNum) {
			// ��Excel��һ�б�ͷ��������������ĳ��ȣ�Ҫ��֤�������е��������ܳ���������ȣ����Ǹ�Լ����
			if (rowNum == 0) {
				columnsLength = firstRow.size();
				readRow = firstRow.toArray(new String[firstRow.size()]);
			} else {
				readRow = firstRow.toArray(new String[columnsLength]);
			}
			datas.add(readRow.clone());
			readRow = null;
			firstRow.clear();
		}

		@Override
		public void cell(String cellReference, String formattedValue, XSSFComment comment) {
			int index = getCellIndex(cellReference);// ת��A1,B1,C1�ȱ��λ��Ϊ��ʵ����λ��
			try {
				firstRow.set(index, formattedValue);
			} catch (IndexOutOfBoundsException e) {
				int size = firstRow.size();
				for (int i = index - size + 1; i > 0; i--) {
					firstRow.add(null);
				}
				firstRow.set(index, formattedValue);
			}
		}

		@Override
		public void headerFooter(String text, boolean isHeader, String tagName) {

		}

		/**
		 * ת���������Ϊ�б��
		 * 
		 * @param cellReference ������
		 * @return �����λ�ã���0��ʼ��
		 */
		public int getCellIndex(String cellReference) {
			String ref = cellReference.replace("\\d+", "");
			int num = 0;
			int result = 0;
			for (int i = 0; i < ref.length(); i++) {
				char ch = cellReference.charAt(ref.length() - i - 1);
				num = (int) (ch - 'A' + 1);
				num *= Math.pow(26, i);
				result += num;
			}
			return result - 1;
		}

	}
}
