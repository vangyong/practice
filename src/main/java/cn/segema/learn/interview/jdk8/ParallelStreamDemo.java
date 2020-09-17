package cn.segema.learn.interview.jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @description ParallelStream并行处理
 * @author wangyong
 * @createDate 2020/09/17
 */
public class ParallelStreamDemo {

    public static void main(String[] args) throws InterruptedException {
        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8};
        List<Integer> listOfIntegers = new ArrayList<>(Arrays.asList(intArray));
        List<Integer> parallelStorage = new ArrayList<>();// Collections.synchronizedList(new ArrayList<>());
        listOfIntegers.parallelStream().map(e -> {
            parallelStorage.add(e);
            return e;
        }).forEachOrdered(e -> System.out.print(e + " "));//forEachOrdered 按顺序处理
        System.out.println();
        
        parallelStorage.stream().forEachOrdered(e -> System.out.print(e + " "));
        System.out.println();
        System.out.println("Sleep 5 sec");
        TimeUnit.SECONDS.sleep(5);
        parallelStorage.stream().forEachOrdered(e -> System.out.print(e + " "));
    }

}
