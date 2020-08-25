package cn.segema.learn.interview.sonparent;

/**
* @description 一句话描述该类的功能
* @author wangyong
* @createDate 2020/08/25
*/
public class Son extends Father implements SonFuctionListener {
    public Son() {
        setSonListener(this);
    }

    public void testSonMethod(String str) {
        System.out.println(str + ": this is testSonMethod");
    }

    public static void testSonMethod1(String str) {
        System.out.println(str + ": this is static testSonMethod");
    }

    @Override
    public void callTestMethod1() {
        testSonMethod("通过监听回调");
    }

}
