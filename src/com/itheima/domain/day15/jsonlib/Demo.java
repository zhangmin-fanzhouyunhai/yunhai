package com.itheima.domain.day15.jsonlib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.itheima.domain.day15.domain.Province;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Demo {
	@Test
	public void f1() {
		String[] arr= {"aaa","bb","cc"};
		JSONArray json=JSONArray.fromObject(arr);
		System.out.println(json);
	}

	@Test
	public void f2() {
		List<String> list=new ArrayList<>();
		list.add("11");
		list.add("22");
		list.add("33");
		list.add("44");
		
		JSONArray json=JSONArray.fromObject(list);
		System.out.println(json); 
	}

	@Test
	public void f3() {
		Province pro=new Province();
		pro.setName("����");
		pro.setProvinceID(1);
		
		JSONObject json=JSONObject.fromObject(pro);
		System.out.println(json); 
	}
	

	@Test
	public void f4() {
		Map<String, Object> map=new HashMap<>();
		map.put("username", "tom");
		map.put("age", 18);
		JSONObject json=JSONObject.fromObject(map);
		System.out.println(json); 
	}
	
	@Test
	public void f5() {
		List<Province> list=new ArrayList<>();
		list.add(new Province(1,"����"));
		list.add(new Province(2,"�Ϻ�"));
		list.add(new Province(3,"���"));
		list.add(new Province(4,"����"));
		
		JSONArray json=JSONArray.fromObject(list);
		System.out.println(json); 
	}
	
	
}
