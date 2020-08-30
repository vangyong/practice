package cn.segema.learn.util;

import java.time.LocalDate;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

/**
 * @description jackson功能
 * @author wangyong
 * @createDate 2020/08/30
 */
public class JacksonUtilDemo {

	public static void main(String[] args) throws Exception {
//		// 1、简单映射
//		ObjectMapper mapper = new ObjectMapper();
//		FriendDomain friend = new FriendDomain("yitian", 25);
//		// 写为字符串
//		String text = mapper.writeValueAsString(friend);
//		// 写为文件
//		mapper.writeValue(new File("friend.json"), friend);
//		// 写为字节流
//		byte[] bytes = mapper.writeValueAsBytes(friend);
//		System.out.println(text);
//		// 从字符串中读取
//		FriendDomain newFriend = mapper.readValue(text, FriendDomain.class);
//		// 从字节流中读取
//		newFriend = mapper.readValue(bytes, FriendDomain.class);
//		// 从文件中读取
//		newFriend = mapper.readValue(new File("friend.json"), FriendDomain.class);
//		System.out.println(newFriend);

//		// 2、集合映射
//		ObjectMapper mapper2 = new ObjectMapper();
//		Map<String, Object> map = new HashMap<>();
//		map.put("age", 25);
//		map.put("name", "yitian");
//		map.put("interests", new String[] { "pc games", "music" });
//		String text2 = mapper2.writeValueAsString(map);
//		System.out.println(text2);
//
//		Map<String, Object> map2 = mapper2.readValue(text2, new TypeReference<Map<String, Object>>() {
//		});
//		System.out.println(map2);
//		JsonNode root = mapper2.readTree(text2);
//		String name = root.get("name").asText();
//		int age = root.get("age").asInt();
//		System.out.println("name:" + name + " age:" + age);

//		// 3、Java8日期时间类支持
//		Person p1 = new Person("yitian", "易天", 25, "10000", LocalDate.of(1994, 1, 1));
//		ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
//		// mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
//		String text = mapper.writeValueAsString(p1);
//		System.out.println(text);
//
//		Person p2 = mapper.readValue(text, Person.class);
//		System.out.println(p2);
		
		// 4、处理xml映射
		Person p1 = new Person("yitian", "易天", 25, "10000", LocalDate.of(1994, 1, 1));
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.findAndRegisterModules();
        xmlMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
        String text = xmlMapper.writeValueAsString(p1);
        System.out.println(text);

        Person p2 = xmlMapper.readValue(text, Person.class);
        System.out.println(p2);
		
	}

}
