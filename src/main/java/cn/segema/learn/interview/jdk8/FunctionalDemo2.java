package cn.segema.learn.interview.jdk8;

import java.util.Arrays;
import java.util.List;

public class FunctionalDemo2 {

	public static void main(String[] args) {
		//取最大值
        List<Integer> list = Arrays.asList(1, 2, 4, 6);
        Integer max = list.get(0);
        for (Integer value : list.subList(1, list.size())) {
            if (value > max) {
                max = value;
            }
        }
        System.out.println(max);
        System.out.println("-----");
        
        int max1 = list.stream().reduce(0, Integer::max);
		System.out.println(max1);
	}

}
