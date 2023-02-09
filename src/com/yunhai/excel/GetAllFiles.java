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
		//·��	����дһ��·����ȥ
		String path="F:\\�ٿ�";
		//���÷���
		//getFiles(path);
		//path="D:\\�ٿ�";
		//path="F:\\�ٿ�";
		path="I:\\ʵ���ʲ��������۹���";
		String fileName="���������嵥";
		path="F:\\�ٿ�";
		//searchFile(path,fileName);
		//searchResultOutput();
		path="D:\\";
		//path="I:\\�ٿ�";
		//path="I:\\�ٿ�\\0-ѧϰ\\��ѧ\\��ѧ�̲�\\Ӣ��ԭ��ͼ��";
		getFiles(path);
	}
	

	public static void searchResultOutput() {
		String path="F:\\������";
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
	 * ��path·���²��Ұ���fileName�����ַ������ļ�
	 * @param path
	 * @param fileName
	 */
	public static void searchFile(String path,String fileName) {
		File file =new File(path);
		//������·�����ļ���
		if(file.isDirectory()) {
			//��ȡ·���µ������ļ�
			File[] files=file.listFiles();
			for(int i=0;i<files.length;i++) {
				//��������ļ��У��ݹ��ȡ������ļ� �ļ���
				if(files[i].isDirectory()) {
					//System.out.println("Ŀ¼��"+files[i].getPath());
					searchFile(files[i].getPath(),fileName);
				}else {
					if(files[i].getName().contains(fileName)) {
						System.out.println("�ļ���"+files[i].getPath());
					}
				}
			}
		}else {
			if(file.getName().contains(fileName)) {
				System.out.println("�ļ���"+file.getPath());
			}
		}
	}
	/**
	 * 
	 */
	
	public static void getFiles(String path) {
		File file =new File(path);
		Calendar cal=Calendar.getInstance();
		//������·�����ļ���
		if(file.isDirectory()) {
			//��ȡ·���µ������ļ�
			File[] files=file.listFiles();
			for(int i=0;i<files.length;i++) {
				if(withoutRightFileCheck(files[i].getPath())) {
					continue;
				}else {
					//��������ļ��У��ݹ��ȡ������ļ� �ļ���
					if(files[i].isDirectory()) {
						System.out.println("Ŀ¼��"+files[i].getPath());
						getFiles(files[i].getPath());
					}else {
						System.out.println("�ļ���"+files[i].getName());
						cal.setTimeInMillis(files[i].lastModified());
						System.out.println("�ļ�����ʱ�䣺"+files[i].lastModified());
						System.out.println("�ļ�����ʱ�䣺"+cal.getTime().toLocaleString());
						if(cal.getTime().toLocaleString().substring(1,4).contentEquals("2022")) {
							System.out.println("2022__________________--------------------");
						}
					}
				}
			}
		}else {
			System.out.println("�ļ���"+file.getName());
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
	 * ���ļ�·��path�µ��ļ�������ʱ��ΪyearStr���ļ�������ļ���
	 * @param path
	 * @param yearStr
	 */
	public static ArrayList<Map<String,String>> SearchFileByTime(String path,String yearStr) {

		ArrayList<Map<String,String>> list=new ArrayList<Map<String,String>>();
		File file =new File(path);
		Calendar cal=Calendar.getInstance();
		//������·�����ļ���
		if(file.isDirectory()) {
			//��ȡ·���µ������ļ�
			File[] files=file.listFiles();
			for(int i=0;i<files.length;i++) {
				//��������ļ��У��ݹ��ȡ������ļ� �ļ���
				if(files[i].isDirectory()) {
					//System.out.println("Ŀ¼��"+files[i].getPath());
					ArrayList<Map<String,String>> returnList=SearchFileByTime(files[i].getPath(),yearStr);
					for(int resultI=0;resultI<returnList.size();resultI++) {
						list.add(returnList.get(resultI));
					}
				}else {
					cal.setTimeInMillis(files[i].lastModified());
					//System.out.println("�ļ�����ʱ�䣺"+cal.getTime().toLocaleString().substring(0,4));
					if(cal.getTime().toLocaleString().substring(0,4).contentEquals(yearStr)) {
						System.out.println("Ŀ¼��"+files[i].getPath());
						System.out.println("�ļ���"+files[i].getName());
						System.out.println("�ļ�����ʱ�䣺"+files[i].lastModified());
						System.out.println("�ļ�����ʱ�䣺"+cal.getTime().toLocaleString());
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
				System.out.println("�ļ���"+file.getName());
				System.out.println("Ŀ¼��"+file.getPath());
				cal.setTimeInMillis(file.lastModified());
				System.out.println("�ļ�����ʱ�䣺"+cal.getTime().toLocaleString());
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
	 * ���ļ�·��path�µ��ļ�������ʱ��ΪyearStr����׺ΪsuffixStr���ļ�������ļ���
	 * @param path
	 * @param yearStr
	 * @param suffixStr
	 */
	public static ArrayList<Map<String,String>> SearchFileByTimeAndSuffix(String path,String yearStr,String suffixStr) {
		ArrayList<Map<String,String>> list=new ArrayList<Map<String,String>>();
		File file =new File(path);
		Calendar cal=Calendar.getInstance();
		String FileSuffixStr="";
		//������·�����ļ���
		if(file.isDirectory()) {
			//��ȡ·���µ������ļ�
			File[] files=file.listFiles();
			for(int i=0;i<files.length;i++) {
				//��������ļ��У��ݹ��ȡ������ļ� �ļ���
				if(files[i].isDirectory()) {
					//System.out.println("Ŀ¼��"+files[i].getPath());
					ArrayList<Map<String,String>> returnList=SearchFileByTimeAndSuffix(files[i].getPath(),yearStr,suffixStr);
					for(int resultI=0;resultI<returnList.size();resultI++) {
						list.add(returnList.get(resultI));
					}
				}else {
					cal.setTimeInMillis(files[i].lastModified());
					//System.out.println("�ļ�����ʱ�䣺"+cal.getTime().toLocaleString().substring(0,4));
					if(files[i].getName().lastIndexOf(".")!=-1) {
						FileSuffixStr=files[i].getName().substring(files[i].getName().lastIndexOf(".")+1);
					}else
					{
						FileSuffixStr="";
					}
					//System.out.println("�ļ���"+files[i].getName()+",index="+files[i].getName().lastIndexOf(".")+",FileSuffixStr="+FileSuffixStr);
					if(cal.getTime().toLocaleString().substring(0,4).contentEquals(yearStr)&&FileSuffixStr.contentEquals(suffixStr)) {
						System.out.println("Ŀ¼��"+files[i].getPath());
						System.out.println("�ļ���"+files[i].getName());
						//System.out.println("�ļ�����ʱ�䣺"+files[i].lastModified());
						System.out.println("�ļ�����ʱ�䣺"+cal.getTime().toLocaleString());
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
				System.out.println("�ļ���"+file.getName());
				System.out.println("Ŀ¼��"+file.getPath());
				System.out.println("�ļ�����ʱ�䣺"+cal.getTime().toLocaleString());
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
