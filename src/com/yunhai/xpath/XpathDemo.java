package com.yunhai.xpath;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XpathDemo {

	public static void main(String[] args) throws DocumentException {
		// TODO Auto-generated method stub
		//创建核心对象
		SAXReader reader=new SAXReader();
		//加载dom树
		Document doc=reader.read("F:\\Workspace\\workspace\\Day29\\WebRoot\\xml\\web2.xml");
		//获取根节点
		List<Element> list=doc.selectNodes("/web-app/servlet/servlet-name");
		System.out.println(list.size());
		//Element ele=list.get(1);
		//System.out.println(ele.getText());
		Element ele=(Element) doc.selectSingleNode("//servlet/servlet-name");
		System.out.println(ele.getText());
		
	}

}
