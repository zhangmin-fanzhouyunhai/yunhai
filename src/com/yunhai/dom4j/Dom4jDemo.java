package com.yunhai.dom4j;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Dom4jDemo {

	public static void main(String[] args) throws DocumentException {
		// TODO Auto-generated method stub
		//�������Ķ���
		SAXReader reader=new SAXReader();
		//��ȡdom��
		Document doc=reader.read("F:\\Workspace\\workspace\\Day29\\WebRoot\\WEB-INF\\web.xml");
		//��ȡ���ڵ�
		Element root=doc.getRootElement();
		//��ȡ�����ڵ�
		List <Element> list=root.elements();
		//��������
		for (Element ele:list) {
			//��ȡservlet-name�ı�ǩ��
			String text=ele.elementText("servlet-name");
			//System.out.println(text);
			//��ȡurl-pattern��ǩ��
			System.out.println(ele.elementText("url-pattern"));
		}
		//��ȡroot��version����ֵ
		String value=root.attributeValue("version");
		System.out.println("value="+value);
		
	}

}
