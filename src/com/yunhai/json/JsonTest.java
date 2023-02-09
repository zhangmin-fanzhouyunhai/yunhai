package com.yunhai.json;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;

public class JsonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java2JsonObject();
		java2JsonString();
		jsonObject2JsonString();
		jsonObject2JavaObject();
		jsonString2JSONObject();
		jsonStringWithList2JSONString();
		jsonList2JavaList();
	}

	/**
	 * 1��Javaת����JSON����
	 */
	public static void java2JsonObject() {
		Student stu = new Student("���ں�BiggerBoy", 2, "m");
		// Java����ת��ΪJSON����
		JSONObject jsonObject = (JSONObject) JSONObject.toJSON(stu);
		System.out.println("1:Java����ת��ΪJSON����\n" + jsonObject);
		// {"name":"���ں�BiggerBoy","age":2,"sex":"m"}
	}

	/**
	 * 2��Javaת����JSON�ַ���
	 */
	public static void java2JsonString() {
		Student stu = new Student("���ں�BiggerBoy", 2, "m");
		// Java����ת��ΪJSON����
		String jsonString = JSONObject.toJSONString(stu);
		System.out.println("2:Java����ת����JSON�ַ���\n" + jsonString);
		// {"name":"���ں�BiggerBoy","age":2,"sex":"m"}
	}

	/**
	 * 3��JSON����ת����JSON�ַ���
	 */
	public static void jsonObject2JsonString() {
		Student stu = new Student("���ں�BiggerBoy", 2, "m");
		// ��ת��JSON����
		JSONObject jsonObject = (JSONObject) JSONObject.toJSON(stu);
		// JSON����ת��ΪJSON�ַ���
		String jsonString = jsonObject.toJSONString();
		System.out.println("3:JSON����ת����JSON�ַ���\n" + jsonString);
		// {"name":"���ں�BiggerBoy","age":2,"sex":"m"}
	}

	/**
	 * 4��JSON����ת����Java����
	 */
	public static void jsonObject2JavaObject() {
		Student stu = new Student("���ں�BiggerBoy", 2, "m");
		// ��ת��JSON����
		JSONObject jsonObject = (JSONObject) JSONObject.toJSON(stu);
		// JSON����ת����Java����
		Student student = JSONObject.toJavaObject(jsonObject, Student.class);
		System.out.println("4:JSON����ת����Java����\n" + student);
		// Student{name="���ں�BiggerBoy",age=2,sex="m"}
	}

	/**
	 * 5��JSON�ַ���ת����JSON����
	 */
	public static void jsonString2JSONObject() {
		String stuString = "{\"age\":2,\"name\":\"���ں�BiggerBoy\",\"sex\":\"m\"}";
		// JSON�ַ���ת����JSON����
		JSONObject jsonObject = JSONObject.parseObject(stuString);
		System.out.println("5:JSON�ַ���ת����JSON����\n" + jsonObject);
		// Student{name="���ں�BiggerBoy",age=2,sex="m"}
	}

	/**
	 * 6. ���student��������һ�����󼯺�hobbies,��Ӧ�ģ�JSON�ַ���תMapʱ�����������
	 * hobbies�ڵ��ֶ�˳����ܻ��ԭʼhobbies�ֶ�ֵ��һ����
	 * ���£���һ�δ�ӡhobbies�е�hobbyType�ܵ�hobbyNameǰ�ˣ���ԭʼJSON����ǡ����֮�෴��
	 * ���ڽӿڼӽ�������ǩ��ʱ���ַ���˳����Ϊ��Ҫ����Ҫ��֤ԭʼ˳�򣬿��Լ�һ������Feature.OrderedField
	 * �ڶ��δ�ӡ��hobbies�ֶ��ڵ��ַ���˳���ԭʼ�ַ�����һ�¡�
	 */
	public static void jsonStringWithList2JSONString() {
		String str1 = "{\"age\":2,\"hobbies\":[{\"hobbyName\":\"����\",\"hobbyType\":1},{\"hobbyName\":\"����\",\"hobbyType\":2}],\"name\":\"���ں�BiggerBoy\",\"sex\":\"m\"}";

		System.out.println("6:JSON String:\n"+str1);
		Map map = JSONObject.parseObject(str1, Map.class);
		System.out.println("6:JSONת����JSON Object\n"+JSONObject.toJSONString(map));
		// {"hobbies":[{"hobbyType":1,"hobbyName":"����"},{"hobbyType":2,"hobbyName":"����"}],"sex":"m","name":"���ں�BiggerBoy","age":2}

		Map map1 = JSONObject.parseObject(str1, Map.class, Feature.OrderedField);
		System.out.println("7:JSONת����JSON Object\n"+JSONObject.toJSONString(map1));
		// {"hobbies":[{"hobbyName":"����","hobbyType":1},{"hobbyName":"����","hobbyType":2}],"sex":"m","name":"���ں�BiggerBoy","age":2}
	}

	public static void jsonList2JavaList() {
		String stuString = "[{\"age\":2,\"name\":\"���ں�\",\"sex\":\"m\"},{\"age\":18,\"name\":\"BiggerBoy\",\"sex\":\"m\"}]";

		// JSON�ַ���ת����Java����
		List<Student> studentList = JSONObject.parseArray(stuString, Student.class);
		System.out.println("8:JSON�ַ���ת����Java����list\n" + studentList);
	}

}
