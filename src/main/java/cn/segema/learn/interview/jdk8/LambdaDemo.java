package cn.segema.learn.interview.jdk8;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;

/**
 * @description Lambda表达式
 * @author wangyong
 * @createDate 2020/09/17
 */
public class LambdaDemo {

	public static void main(String[] args) {
//		// 1.线程实例
//		// Java 8之前：
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				System.out.println("Before Java8, too much code for too little to do");
//			}
//		}).start();
//		// Java 8方式：
//		new Thread(() -> System.out.println("In Java8, Lambda expression rocks")).start();

//		// 2.事件监听
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
	    
//		// 3.集合迭代
//		// Java 8之前：
//		List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
//		for (String feature : features) {
//		    System.out.println(feature);
//		}
//		// Java 8之后：
//		List features2 = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
//		features2.forEach((n) -> System.out.println(n));
		
		// 4.集合累加计数
		// Java 8之前：
		long count1 =0;
		List<String> strList = Arrays.asList("chengdu", "hangzhou", "beijing", "chengdu");
		for (String str : strList) {
		    if (str.equals("chengdu")) {
		        count1++;
		    }
		}
		System.out.println(count1);
		// Java 8之后：
		long count2 = strList.stream().filter((str -> str.equals("chengdu"))).count();
		System.out.println(count2);

	}

}
