package cn.segema.learn.interview.designmode.creational.prototype;

/**
* @description 一句话描述该类的功能
* @author wangyong
* @createDate 2020/08/25
*/
public abstract class Shape implements Cloneable {

    private String id;

    protected String type;

    abstract void draw();

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}
