package com.yunhai.excel;

import java.awt.List;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class GetAllFiles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//路径	这里写一个路径进去
		String path="F:\\百科";
		//调用方法
		//getFiles(path);
		//path="D:\\百科";
		//path="F:\\百科";
		path="I:\\实物资产分析评价管理";
		String fileName="个人资料清单";
		path="F:\\百科";
		//searchFile(path,fileName);
		//searchResultOutput();
		path="D:\\";
		//path="I:\\百科";
		//path="I:\\百科\\0-学习\\数学\\数学教材\\英语原版图书";
		getFiles(path);
	}
	

	public static void searchResultOutput() {
		String path="F:\\管理工作";
		String yearStr="2022";
		//SearchFileByTime(path,yearStr);
		String suffixStr="xlsx";
		ArrayList<Map<String,String>> list=SearchFileByTimeAndSuffix(path,yearStr,suffixStr);
		System.out.println("Size of list is :"+list.size());
		for(int i=0;i<list.size();i++) {
			System.out.println("path="+list.get(i).get("path"));
			System.out.println("fileName="+list.get(i).get("fileName"));
			System.out.println("createTime="+list.get(i).get("createTime"));
		}
		
	}
	
	/**
	 * 从path路径下查找包含fileName所含字符串的文件
	 * @param path
	 * @param fileName
	 */
	public static void searchFile(String path,String fileName) {
		File file =new File(path);
		//如果这个路径是文件夹
		if(file.isDirectory()) {
			//获取路径下的所有文件
			File[] files=file.listFiles();
			for(int i=0;i<files.length;i++) {
				//如果还是文件夹，递归获取里面的文件 文件夹
				if(files[i].isDirectory()) {
					//System.out.println("目录："+files[i].getPath());
					searchFile(files[i].getPath(),fileName);
				}else {
					if(files[i].getName().contains(fileName)) {
						System.out.println("文件："+files[i].getPath());
					}
				}
			}
		}else {
			if(file.getName().contains(fileName)) {
				System.out.println("文件："+file.getPath());
			}
		}
	}
	/**
	 * 
	 */
	
	public static void getFiles(String path) {
		File file =new File(path);
		Calendar cal=Calendar.getInstance();
		//如果这个路径是文件夹
		if(file.isDirectory()) {
			//获取路径下的所有文件
			File[] files=file.listFiles();
			for(int i=0;i<files.length;i++) {
				if(withoutRightFileCheck(files[i].getPath())) {
					continue;
				}else {
					//如果还是文件夹，递归获取里面的文件 文件夹
					if(files[i].isDirectory()) {
						System.out.println("目录："+files[i].getPath());
						getFiles(files[i].getPath());
					}else {
						System.out.println("文件："+files[i].getName());
						cal.setTimeInMillis(files[i].lastModified());
						System.out.println("文件创建时间："+files[i].lastModified());
						System.out.println("文件创建时间："+cal.getTime().toLocaleString());
						if(cal.getTime().toLocaleString().substring(1,4).contentEquals("2022")) {
							System.out.println("2022__________________--------------------");
						}
					}
				}
			}
		}else {
			System.out.println("文件："+file.getName());
		}
	}
	public static boolean withoutRightFileCheck(String path) {
		ArrayList<String> strList=new ArrayList<String>();
		strList.add("$");
		strList.add("Config.Msi");
		strList.add("System Volume Information");
		int count=0;
		for(int i=0;i<strList.size();i++) {
			if(path.contains(strList.get(i))) {
				count++;
			}
		}
		if(count==0) {
			return false;
		}else {
			return true;
		}
		
	}
	/**
	 * 对文件路径path下的文件按创建时间为yearStr的文件输出到文件中
	 * @param path
	 * @param yearStr
	 */
	public static ArrayList<Map<String,String>> SearchFileByTime(String path,String yearStr) {

		ArrayList<Map<String,String>> list=new ArrayList<Map<String,String>>();
		File file =new File(path);
		Calendar cal=Calendar.getInstance();
		//如果这个路径是文件夹
		if(file.isDirectory()) {
			//获取路径下的所有文件
			File[] files=file.listFiles();
			for(int i=0;i<files.length;i++) {
				//如果还是文件夹，递归获取里面的文件 文件夹
				if(files[i].isDirectory()) {
					//System.out.println("目录："+files[i].getPath());
					ArrayList<Map<String,String>> returnList=SearchFileByTime(files[i].getPath(),yearStr);
					for(int resultI=0;resultI<returnList.size();resultI++) {
						list.add(returnList.get(resultI));
					}
				}else {
					cal.setTimeInMillis(files[i].lastModified());
					//System.out.println("文件创建时间："+cal.getTime().toLocaleString().substring(0,4));
					if(cal.getTime().toLocaleString().substring(0,4).contentEquals(yearStr)) {
						System.out.println("目录："+files[i].getPath());
						System.out.println("文件："+files[i].getName());
						System.out.println("文件创建时间："+files[i].lastModified());
						System.out.println("文件创建时间："+cal.getTime().toLocaleString());
						Map<String,String> map=new HashMap<String,String>();
						map.put("path",files[i].getPath());
						map.put("fileName",files[i].getName());
						map.put("createTime",cal.getTime().toLocaleString());
						list.add(map);
					}
				}
			}
		}else { 
			cal.setTimeInMillis(file.lastModified());
			if(cal.getTime().toLocaleString().substring(0,4).contentEquals(yearStr)) {
				System.out.println("文件："+file.getName());
				System.out.println("目录："+file.getPath());
				cal.setTimeInMillis(file.lastModified());
				System.out.println("文件创建时间："+cal.getTime().toLocaleString());
				Map<String,String> map=new HashMap<String,String>();
				map.put("path",file.getPath());
				map.put("fileName",file.getName());
				map.put("createTime",cal.getTime().toLocaleString());
				list.add(map);
			}
		}
		return list;
	}

	/**
	 * 对文件路径path下的文件按创建时间为yearStr，后缀为suffixStr的文件输出到文件中
	 * @param path
	 * @param yearStr
	 * @param suffixStr
	 */
	public static ArrayList<Map<String,String>> SearchFileByTimeAndSuffix(String path,String yearStr,String suffixStr) {
		ArrayList<Map<String,String>> list=new ArrayList<Map<String,String>>();
		File file =new File(path);
		Calendar cal=Calendar.getInstance();
		String FileSuffixStr="";
		//如果这个路径是文件夹
		if(file.isDirectory()) {
			//获取路径下的所有文件
			File[] files=file.listFiles();
			for(int i=0;i<files.length;i++) {
				//如果还是文件夹，递归获取里面的文件 文件夹
				if(files[i].isDirectory()) {
					//System.out.println("目录："+files[i].getPath());
					ArrayList<Map<String,String>> returnList=SearchFileByTimeAndSuffix(files[i].getPath(),yearStr,suffixStr);
					for(int resultI=0;resultI<returnList.size();resultI++) {
						list.add(returnList.get(resultI));
					}
				}else {
					cal.setTimeInMillis(files[i].lastModified());
					//System.out.println("文件创建时间："+cal.getTime().toLocaleString().substring(0,4));
					if(files[i].getName().lastIndexOf(".")!=-1) {
						FileSuffixStr=files[i].getName().substring(files[i].getName().lastIndexOf(".")+1);
					}else
					{
						FileSuffixStr="";
					}
					//System.out.println("文件："+files[i].getName()+",index="+files[i].getName().lastIndexOf(".")+",FileSuffixStr="+FileSuffixStr);
					if(cal.getTime().toLocaleString().substring(0,4).contentEquals(yearStr)&&FileSuffixStr.contentEquals(suffixStr)) {
						System.out.println("目录："+files[i].getPath());
						System.out.println("文件："+files[i].getName());
						//System.out.println("文件创建时间："+files[i].lastModified());
						System.out.println("文件创建时间："+cal.getTime().toLocaleString());
						Map<String,String> map=new HashMap<String,String>();
						map.put("path",files[i].getPath());
						map.put("fileName",files[i].getName());
						map.put("createTime",cal.getTime().toLocaleString());
						list.add(map);
					}
				}
			}
		}else { 
			cal.setTimeInMillis(file.lastModified());
			if(file.getName().lastIndexOf(".")!=-1) {
				FileSuffixStr=file.getName().substring(file.getName().lastIndexOf(".")+1);
			}else
			{
				FileSuffixStr="";
			}
			if(cal.getTime().toLocaleString().substring(0,4).contentEquals(yearStr)&&FileSuffixStr.contentEquals(suffixStr)) {
				System.out.println("文件："+file.getName());
				System.out.println("目录："+file.getPath());
				System.out.println("文件创建时间："+cal.getTime().toLocaleString());
				Map<String,String> map=new HashMap<String,String>();
				map.put("path",file.getPath());
				map.put("fileName",file.getName());
				map.put("createTime",cal.getTime().toLocaleString());
				list.add(map);
			}
		}
		return list;
	}

}
