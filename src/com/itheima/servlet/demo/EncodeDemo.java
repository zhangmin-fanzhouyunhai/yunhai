package com.itheima.servlet.demo;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class EncodeDemo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String s="ºÚÂí";
		String s8=URLEncoder.encode(s,"utf-8");
		System.out.println("s8:"+s8);
		String so=URLDecoder.decode(s8,"iso-8859-1");
		System.out.println("so:"+so);
		
		byte[] b=so.getBytes("iso-8859-1");
		String s1=new String(b,"utf-8");
		System.out.println("s1:"+s1);
		
	}

}
