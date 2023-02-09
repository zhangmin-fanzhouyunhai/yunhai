package com.itheima.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class URLFile {

	
	public static void main(String[] args) {
		List URLList=new<String> ArrayList();
		URLList.add("http://www.test.com/abc/de/fg.php?id=1&url=http://www.test.com/index.html");
		URLList.add("http://www.ceshi.com/hi.jsp");
		URLList.add("ftp://ftp.ceshi.com/hi.jsp");
		URLList.add("ftp://ftp.ceshi.com/");
		URLList.add("http://www.hello.com/cw/hi.jsp?k=8");
		URLList.add("http://www.hi.com/jk/i.html?id=1&s=a.html");
		URLList.add("http://www.rs.com/n.op/q/rs?id=1");
		URLList.add("http://www.abc.com/");
		URLList.add("http://www.rs.com/n.op/q/");

		List fileNameList=new<String> ArrayList();
		String substr="";
		for(int i=0;i<URLList.size();i++) {
			String UrlString=URLList.get(i).toString();
			if(UrlString.contains("?")) 
			{
				//System.out.println(UrlString.substring(0,UrlString.indexOf("?")));
				substr=UrlString.substring(0,UrlString.indexOf("?"));
			}
			else {
				substr=UrlString;
			}
				
			System.out.println(substr.substring(substr.lastIndexOf("/")+1,substr.length())); 
			if(substr.substring(substr.lastIndexOf("/")+1,substr.length())==null) {
				fileNameList.add("");
			}else {
				fileNameList.add(substr.substring(substr.lastIndexOf("/")+1,substr.length()));
			}
		}
		System.out.println();
		Map fileNameMap=new <String,Integer> HashMap();	
		
		for(int i=0;i<fileNameList.size();i++) {
			String fileName=fileNameList.get(i).toString();
			int quantity=1;
			if(fileNameMap.containsKey(fileName)){
				continue;
			}else
			{
				for(int j=i+1;j<fileNameList.size();j++) {
					if(fileNameList.get(j).toString().contentEquals(fileName))
						quantity++;
				}
				System.out.println(quantity);
				//fileNameMap.put(fileNameMap, quantity);

				if(!fileNameMap.containsKey(fileName))
					fileNameMap.put(fileName, quantity);
			}
		}

		System.out.println(fileNameMap.size());
		

	}
}
