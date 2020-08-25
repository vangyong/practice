package cn.segema.learn.interview.designmode.behavioral.templatemethod;

/**
* @description 一句话描述该类的功能
* @author wangyong
* @createDate 2020/08/25
*/
public class Son extends Father {
    @Override
    protected void doSomething() {
        System.out.println("Son doSomething");
    }

    @Override
    protected void doAnything() {
        System.out.println("Son doAnything");
    }

}
