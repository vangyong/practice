package cn.segema.learn.interview.designmode.behavioral.templatemethod;

/**
* @description 一句话描述该类的功能
* @author wangyong
* @createDate 2020/08/25
*/
public abstract class Father {
    // 基本方法
    protected abstract void doSomething();

    // 基本方法
    protected abstract void doAnything();

    // 模板方法
    public void templateMethod() {
        /*
         * 调用基本方法，完成相关的逻辑
         */
        this.doAnything();
        this.doSomething();
    }
}
