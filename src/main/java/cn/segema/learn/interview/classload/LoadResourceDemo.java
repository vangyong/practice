package cn.segema.learn.interview.classload;

import java.net.URISyntaxException;

/**
* @description 加载资源文件
* @author wangyong
* @createDate 2020/08/25
*/
public class LoadResourceDemo {

    public static void main(String[] args) throws URISyntaxException {
        System.out.println(LoadResourceDemo.class.getResource("ehcache.xml"));
        System.out.println(LoadResourceDemo.class.getResource("/ehcache.xml"));
        System.out.println(LoadResourceDemo.class.getResource("/ehcache.xml").getPath());
        System.out.println(LoadResourceDemo.class.getResource("/ehcache.xml").toURI());
        System.out.println();
        System.out.println(LoadResourceDemo.class.getClassLoader().getResource("ehcache.xml"));
        System.out.println(LoadResourceDemo.class.getClassLoader().getResource("/ehcache.xml"));
    }

}
