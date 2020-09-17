package cn.segema.learn.interview.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description stream遍历容器
 * @author wangyong
 * @createDate 2020/09/03
 */
public class StreamDemo {

    public static void main(String[] args) throws InterruptedException {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        filtered.stream().forEach((e) -> System.out.println(e));
        System.out.println("finished");
    }

}
