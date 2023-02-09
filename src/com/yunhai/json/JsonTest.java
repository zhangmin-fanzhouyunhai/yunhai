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
	 * 1、Java转换成JSON对象
	 */
	public static void java2JsonObject() {
		Student stu = new Student("公众号BiggerBoy", 2, "m");
		// Java对象转化为JSON对象
		JSONObject jsonObject = (JSONObject) JSONObject.toJSON(stu);
		System.out.println("1:Java对象转化为JSON对象\n" + jsonObject);
		// {"name":"公众号BiggerBoy","age":2,"sex":"m"}
	}

	/**
	 * 2、Java转换成JSON字符串
	 */
	public static void java2JsonString() {
		Student stu = new Student("公众号BiggerBoy", 2, "m");
		// Java对象转化为JSON对象
		String jsonString = JSONObject.toJSONString(stu);
		System.out.println("2:Java对象转化成JSON字符串\n" + jsonString);
		// {"name":"公众号BiggerBoy","age":2,"sex":"m"}
	}

	/**
	 * 3、JSON对象转换成JSON字符串
	 */
	public static void jsonObject2JsonString() {
		Student stu = new Student("公众号BiggerBoy", 2, "m");
		// 先转成JSON对象
		JSONObject jsonObject = (JSONObject) JSONObject.toJSON(stu);
		// JSON对象转换为JSON字符串
		String jsonString = jsonObject.toJSONString();
		System.out.println("3:JSON对象转化成JSON字符串\n" + jsonString);
		// {"name":"公众号BiggerBoy","age":2,"sex":"m"}
	}

	/**
	 * 4、JSON对象转换成Java对象
	 */
	public static void jsonObject2JavaObject() {
		Student stu = new Student("公众号BiggerBoy", 2, "m");
		// 先转成JSON对象
		JSONObject jsonObject = (JSONObject) JSONObject.toJSON(stu);
		// JSON对象转换成Java对象
		Student student = JSONObject.toJavaObject(jsonObject, Student.class);
		System.out.println("4:JSON对象转化成Java对象\n" + student);
		// Student{name="公众号BiggerBoy",age=2,sex="m"}
	}

	/**
	 * 5、JSON字符串转换成JSON对象
	 */
	public static void jsonString2JSONObject() {
		String stuString = "{\"age\":2,\"name\":\"公众号BiggerBoy\",\"sex\":\"m\"}";
		// JSON字符串转换成JSON对象
		JSONObject jsonObject = JSONObject.parseObject(stuString);
		System.out.println("5:JSON字符串转换成JSON对象\n" + jsonObject);
		// Student{name="公众号BiggerBoy",age=2,sex="m"}
	}

	/**
	 * 6. 如果student对象内有一个对象集合hobbies,相应的，JSON字符串转Map时如果不做处理，
	 * hobbies内的字段顺序可能会和原始hobbies字段值不一样。
	 * 如下，第一次打印hobbies中的hobbyType跑到hobbyName前了，而原始JSON串中恰好与之相反，
	 * 对于接口加解密生成签名时，字符串顺序尤为重要，若要保证原始顺序，可以加一个参数Feature.OrderedField
	 * 第二次打印的hobbies字段内的字符串顺序和原始字符串中一致。
	 */
	public static void jsonStringWithList2JSONString() {
		String str1 = "{\"age\":2,\"hobbies\":[{\"hobbyName\":\"篮球\",\"hobbyType\":1},{\"hobbyName\":\"跳绳\",\"hobbyType\":2}],\"name\":\"公众号BiggerBoy\",\"sex\":\"m\"}";

		System.out.println("6:JSON String:\n"+str1);
		Map map = JSONObject.parseObject(str1, Map.class);
		System.out.println("6:JSON转换成JSON Object\n"+JSONObject.toJSONString(map));
		// {"hobbies":[{"hobbyType":1,"hobbyName":"篮球"},{"hobbyType":2,"hobbyName":"跳绳"}],"sex":"m","name":"公众号BiggerBoy","age":2}

		Map map1 = JSONObject.parseObject(str1, Map.class, Feature.OrderedField);
		System.out.println("7:JSON转换成JSON Object\n"+JSONObject.toJSONString(map1));
		// {"hobbies":[{"hobbyName":"篮球","hobbyType":1},{"hobbyName":"跳绳","hobbyType":2}],"sex":"m","name":"公众号BiggerBoy","age":2}
	}

	public static void jsonList2JavaList() {
		String stuString = "[{\"age\":2,\"name\":\"公众号\",\"sex\":\"m\"},{\"age\":18,\"name\":\"BiggerBoy\",\"sex\":\"m\"}]";

		// JSON字符串转换成Java对象
		List<Student> studentList = JSONObject.parseArray(stuString, Student.class);
		System.out.println("8:JSON字符串转换成Java对象list\n" + studentList);
	}

}
