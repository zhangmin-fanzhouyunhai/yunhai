package com.yunhai.jpython;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.python.util.PythonInterpreter;

public class PythonInterpreterTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String webSiteName="ÀûÏ¢ÂÊ";
		String webSite="https://wiki.mbalib.com/wiki/%E5%88%A9%E6%81%AF%E7%8E%87";
		String relativePath="/html/encyclopediaThinkTank/";
		String storagePath="E:/ProgramFiles/workspace/Day29/WebRoot/html/encyclopediaThinkTank/";
		webDownload(webSiteName,webSite,relativePath,storagePath);
	}
	
	public static void webDownload(String webSiteName,String webSite,String relativePath,String storagePath) {
		String[] pythonCmds=new String[] {"python","E:\\mbaEncyclopediaThinkTankWebSave.py", String.valueOf(webSiteName),String.valueOf(webSite),String.valueOf(relativePath),String.valueOf(storagePath)};
		System.out.println("webSiteName:"+webSiteName);
		System.out.println("webSite:"+webSite);
		//System.out.println("storagePath:"+storagePath);
		try {
			Process proc=Runtime.getRuntime().exec(pythonCmds);
			//System.out.println("pythonCmds:"+pythonCmds);
			BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
		    String line = null;
		    while ((line = in.readLine()) != null) {
		        System.out.println(line);
		    }
		    in.close();
		    try {
				proc.waitFor();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void pythonTest() {
		PythonInterpreter interpreter = new PythonInterpreter();
		interpreter.exec("import pandas as pd");
		
        interpreter.exec("a=[5,4,3,2,1]");
        interpreter.exec("print(sorted(a))");
	}
}
