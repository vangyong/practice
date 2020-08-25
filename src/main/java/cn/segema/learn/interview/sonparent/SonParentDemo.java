package cn.segema.learn.interview.sonparent;

/**
* @description 一句话描述该类的功能
* @author wangyong
* @createDate 2020/08/25
*/
public class SonParentDemo {

    /**@description 一句话描述该功能
     * @param args
     */
    public static void main(String[] args) {
        Son son = new Son();
        // 在父类中直接new子类相关对象，然后调用其方法
        son.realizeWay1();
        // 在父类中调用子类的static方法
        son.realizeWay2();
        // 在父类中通过反射调用子类的相关方法
        son.realizeWay3();
        // 通过监听回调
        son.realizeWay4();

    }

}
