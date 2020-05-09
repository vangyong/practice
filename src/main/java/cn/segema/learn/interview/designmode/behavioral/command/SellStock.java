package cn.segema.learn.interview.designmode.behavioral.command;

/**
* @description 一句话描述该类的功能
* @author wangyong
* @createDate 2020/05/09
*/
public class SellStock implements Order {
    private Stock abcStock;

    public SellStock(Stock abcStock) {
        this.abcStock = abcStock;
    }

    public void execute() {
        abcStock.sell();
    }
}
