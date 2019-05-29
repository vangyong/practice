package cn.segema.learn.interview.jdk8;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;

public class LambdaDemo {

	public static void main(String[] args) {
		// 1.入门测试
		// Java 8之前：
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				System.out.println("Before Java8, too much code for too little to do");
//			}
//		}).start();
//		// Java 8方式：
//		new Thread(() -> System.out.println("In Java8, Lambda expression rocks")).start();

		// 2.事件处理
//		// Java 8之前：
//		JButton show = new JButton("Show");
//		show.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("Event handling without lambda expression is boring");
//			}
//		});
//		// Java 8方式：
//		show.addActionListener((e) -> {
//		    System.out.println("Light, Camera, Action !! Lambda expressions Rocks");
//		});
		// 3.集合迭代
//		// Java 8之前：
//		List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
//		for (String feature : features) {
//		    System.out.println(feature);
//		}
//		
//		// Java 8之后：
//		List features2 = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
//		features2.forEach(n -> System.out.println(n));
//		features2.forEach(System.out::println);
		
		// 4.集合累加计数
		// Java 8之前：
		long count =0;
		List<String> strList = Arrays.asList("chengdu", "hangzhou", "beijing", "chengdu");
		for (String str : strList) {
		    if (str.equals("chengdu")) {
		        count++;
		    }
		}
		
		// Java 8之后：
		count = strList.stream().filter((str -> str.equals("chengdu"))).count();

	}

}
