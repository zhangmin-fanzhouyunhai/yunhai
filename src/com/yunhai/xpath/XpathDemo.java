package com.yunhai.xpath;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XpathDemo {

	public static void main(String[] args) throws DocumentException {
		// TODO Auto-generated method stub
		//�������Ķ���
		SAXReader reader=new SAXReader();
		//����dom��
		Document doc=reader.read("F:\\Workspace\\workspace\\Day29\\WebRoot\\xml\\web2.xml");
		//��ȡ���ڵ�
		List<Element> list=doc.selectNodes("/web-app/servlet/servlet-name");
		System.out.println(list.size());
		//Element ele=list.get(1);
		//System.out.println(ele.getText());
		Element ele=(Element) doc.selectSingleNode("//servlet/servlet-name");
		System.out.println(ele.getText());
		
	}

}
