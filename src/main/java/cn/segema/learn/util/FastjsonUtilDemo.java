package cn.segema.learn.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;

/**
 * @description fastjson功能
 * @author wangyong
 * @createDate 2020/08/30
 */
public class FastjsonUtilDemo {

	public static void main(String[] args) {

		PersonDomain p = new PersonDomain(10, "张三");
		Object obj = JSONArray.toJSON(p);
		String json = obj.toString();
		System.out.println("将Person对象转成json:" + json);

		// 1.2 将json字符串转成Person对象
		PersonDomain person = JSONArray.parseObject(json, PersonDomain.class);
		System.out.println("person.getName():" + person.getName());

		// 2. 将List<Person>与json之间的转换
		// 2.1 将List<Person>转成json
		List<PersonDomain> personList = new ArrayList<>();
		personList.add(new PersonDomain(10, "张三"));
		personList.add(new PersonDomain(10, "李四"));
		personList.add(new PersonDomain(10, "王五"));
		Object obj2 = JSONArray.toJSON(personList);
		String json2 = obj2.toString();
		System.out.println("将List<Person>转成json:" + json2);

		// 2.2. 将json字符串转成List<Person>对象
		List<PersonDomain> list = JSONArray.parseArray(json2, PersonDomain.class);
		System.out.println("list.size():" + list.size());

		// 3. 将Map对象与json之间的转换
		// 3.1 将Map转成json
		Map<String, PersonDomain> map = new HashMap<>();
		map.put("1", new PersonDomain(10, "张三"));
		map.put("2", new PersonDomain(10, "李四"));
		map.put("3", new PersonDomain(10, "王五"));
		Object obj3 = JSONArray.toJSON(map);
		String json3 = obj3.toString();
		System.out.println("将Map<String,Person>转成json:" + json3);

		// 3.2. 将json转成Map对象
		Map<String, Object> map2 = JSONArray.parseObject(json3);
		PersonDomain person2 = JSONArray.parseObject(map2.get("1").toString(), PersonDomain.class);
		System.out.println("person2.getName():" + person2.getName());

	}

}
