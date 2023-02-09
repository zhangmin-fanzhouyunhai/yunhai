package com.yunhai.word.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.POIXMLProperties.CoreProperties;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.data.PictureRenderData;  

public class WriteWordUtil {

	public WriteWordUtil() {
		// TODO Auto-generated constructor stub
	}
	public void writeDocx(String path, Map<String, String> map) throws Exception {
		InputStream is = new FileInputStream(path);
		XWPFDocument doc = new XWPFDocument(is);
		// XWPFWordExtractor extractor = new XWPFWordExtractor(doc) ;
		// String text = extractor.getText();
		// System.out.println(text);
		// CoreProperties coreProps = extractor.getCoreProperties();
		// this.printCoreProperties(coreProps);
		// this.close(is);
	}
 
 
	/**
	 * �滻��������ı���
	 * 
	 * @param doc
	 *            Ҫ�滻���ĵ�
	 * @param params
	 *            ����
	 */
	private void replaceInPara(XWPFDocument doc, Map<String, Object> params) {
		Iterator<XWPFParagraph> iterator = doc.getParagraphsIterator();
		XWPFParagraph para;
		while (iterator.hasNext()) {
			para = iterator.next();
			this.replaceInPara(para, params);
		}
	}
 
	/**
	 * �滻��������ı���
	 * 
	 * @param para
	 *            Ҫ�滻�Ķ���
	 * @param params
	 *            ����
	 */
	private void replaceInPara(XWPFParagraph para, Map<String, Object> params) {
		List<XWPFRun> runs;
		Matcher matcher;
		if (this.matcher(para.getParagraphText()).find()) {
			runs = para.getRuns();
			for (int i = 0; i < runs.size(); i++) {
				XWPFRun run = runs.get(i);
				String runText = run.toString();
				matcher = this.matcher(runText);
				if (matcher.find()) {
					while ((matcher = this.matcher(runText)).find()) {
						runText = matcher.replaceFirst(String.valueOf(params.get(matcher.group(1))));
					}
					// ֱ�ӵ���XWPFRun��setText()���������ı�ʱ���ڵײ�����´���һ��XWPFRun�����ı������ڵ�ǰ�ı����棬
					// �������ǲ���ֱ����ֵ����Ҫ��ɾ����ǰrun,Ȼ�����Լ��ֶ�����һ���µ�run��
					para.removeRun(i);
					if(runText.equals("null")){
						runText="";
					}
					para.insertNewRun(i).setText(runText);
				}
			}
		}
	}
 
	/**
	 * �滻�������ı���
	 * 
	 * @param doc
	 *            Ҫ�滻���ĵ�
	 * @param params
	 *            ����
	 */
	private void replaceInTable(XWPFDocument doc, Map<String, Object> params) {
		Iterator<XWPFTable> iterator = doc.getTablesIterator();
		XWPFTable table;
		List<XWPFTableRow> rows;
		List<XWPFTableCell> cells;
		List<XWPFParagraph> paras;
		while (iterator.hasNext()) {
			table = iterator.next();
			rows = table.getRows();
			for (XWPFTableRow row : rows) {
				cells = row.getTableCells();
				for (XWPFTableCell cell : cells) {
					
					String cellTextString = cell.getText();
                    for (Entry<String, Object> e : params.entrySet()) {
                        if (cellTextString.contains("${"+e.getKey()+"}"))
                            cellTextString = cellTextString.replace("${"+e.getKey()+"}", e.getValue().toString());
                    }
                    cell.removeParagraph(0);
                    if(cellTextString.contains("${") && cellTextString.contains("}")){
                    	cellTextString = "";
                    }
                    cell.setText(cellTextString);
//                    paras = cell.getParagraphs();
//					for (XWPFParagraph para : paras) {
//						this.replaceInPara(para, params);
//					}
					
				}
			}
		}
	}
 
	/**
	 * ����ƥ���ַ���
	 * 
	 * @param str
	 * @return
	 */
	private Matcher matcher(String str) {
		Pattern pattern = Pattern.compile("\\$\\{(.+?)\\}", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(str);
		return matcher;
	}
 
	/**
	 * �ر�������
	 * 
	 * @param is
	 */
	private void close(InputStream is) {
		if (is != null) {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
 
	/**
	 * �ر������
	 * 
	 * @param os
	 */
	private void close(OutputStream os) {
		if (os != null) {
			try {
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
 
	/**
	 * ���CoreProperties��Ϣ
	 * 
	 * @param coreProps
	 */
	private void printCoreProperties(CoreProperties coreProps) {
		System.out.println(coreProps.getCategory()); // ����
		System.out.println(coreProps.getCreator()); // ������
		System.out.println(coreProps.getCreated()); // ����ʱ��
		System.out.println(coreProps.getTitle()); // ����
	}
	
	/**
	 * wordռλ��${object}��ȱ�ݲ������ͼƬ
	 * @param filePath
	 * @param params
	 * @throws Exception
	 */
	public static String templateWrite(String filePath, Map<String, Object> params,String outFilePath)throws Exception{
		InputStream is = new FileInputStream(filePath);
		WriteWordUtil writeWordUtil = new WriteWordUtil();
		XWPFDocument doc = new XWPFDocument(is);
		// �滻��������ı���
		writeWordUtil.replaceInPara(doc, params);
		// �滻�������ı���
		writeWordUtil.replaceInTable(doc, params);
		OutputStream os = new FileOutputStream(outFilePath);
		doc.write(os);
		writeWordUtil.close(os);
		writeWordUtil.close(is);
		os.flush();
		os.close();
		return "";
	}
	/**
	 * wordռλ��{{object}}�Ƚ������������ͼƬ
	 * @param filePath
	 * @param params
	 * @param outFilePath
	 * @return
	 * @throws Exception
	 */
	public static String templateWrite2(String filePath, Map<String, Object> params,String outFilePath)throws Exception{
		XWPFTemplate template = XWPFTemplate.compile(filePath).render(params);
 		FileOutputStream out = new FileOutputStream(outFilePath);
 		template.write(out);
 		out.flush();
 		out.close();
 		template.close();
		return "";
	}
      public static void main(String[] args) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("JSDWMC", "��Ŀ1\r\na");//  
		params.put("XMMC", "��Ŀ2\r\nb");//  
		params.put("1", "1");//
		params.put("2", "2");//
		params.put("object1", "o1");//  
		params.put("object2", "o2");//
                params.put("localPicture", new PictureRenderData(120, 120, "D:\\A.png"));
		templateWrite("D:\\template\\1.docx", params, "D:\\template\\5.docx");
		templateWrite2("D:\\2.docx", params, "D:\\template\\7.docx");
 
      }
}
