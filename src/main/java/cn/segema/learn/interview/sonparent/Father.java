package cn.segema.learn.interview.sonparent;

/**
* @description 一句话描述该类的功能
* @author wangyong
* @createDate 2020/08/25
*/
public class Father {

    private SonFuctionListener mListenr;

    public Father() {

    }

    /**
     * 在父类中直接new子类相关对象，然后调用其方法
     */
    public void realizeWay1() {
        Son son = new Son();
        son.testSonMethod("在父类中直接new子类相关对象，然后调用其方法");
    }

    /**
     * 在父类中调用子类的static方法
     */
    public void realizeWay2() {
        Son.testSonMethod1("在父类中调用子类的static方法");
    }

    /**
     * 在父类中通过反射调用子类的相关方法
     */
    public void realizeWay3() {
        try {
            Class cls = Class.forName("test.Son");
            Son son = (Son)cls.newInstance();
            son.testSonMethod("在父类中通过反射调用子类的相关方法");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过监听回调
     * @param listener
     */
    public void setSonListener(SonFuctionListener listener) {
        mListenr = listener;
    }

    public void realizeWay4() {
        if (mListenr != null) {
            mListenr.callTestMethod1();
        }
    }

}
