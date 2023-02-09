package com.yunhai.dom4j;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Dom4jDemo {

	public static void main(String[] args) throws DocumentException {
		// TODO Auto-generated method stub
		//创建核心对象
		SAXReader reader=new SAXReader();
		//获取dom树
		Document doc=reader.read("F:\\Workspace\\workspace\\Day29\\WebRoot\\WEB-INF\\web.xml");
		//获取根节点
		Element root=doc.getRootElement();
		//获取其他节点
		List <Element> list=root.elements();
		//遍历集合
		for (Element ele:list) {
			//获取servlet-name的标签体
			String text=ele.elementText("servlet-name");
			//System.out.println(text);
			//获取url-pattern标签体
			System.out.println(ele.elementText("url-pattern"));
		}
		//获取root的version属性值
		String value=root.attributeValue("version");
		System.out.println("value="+value);
		
	}

}
