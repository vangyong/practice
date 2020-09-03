package cn.segema.learn.interview.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description 一句话描述该类的功能
 * @author wangyong
 * @createDate 2020/09/03
 */
public class StreamDemo {

    public static void main(String[] args) throws InterruptedException {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println("finished");
    }

}
