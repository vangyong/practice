package cn.segema.learn.interview.designmode.structural.bridge;

/**@description 一句话描述该类的功能
* @author wangyong
* @createDate 2020/05/09
*/
public abstract class Shape {
    protected DrawAPI drawAPI;

    protected Shape(DrawAPI drawAPI) {
        this.drawAPI = drawAPI;
    }

    public abstract void draw();
}