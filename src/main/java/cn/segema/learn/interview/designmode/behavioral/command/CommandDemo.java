package cn.segema.learn.interview.designmode.behavioral.command;

/**
 * @description 一句话描述该类的功能
 * @author wangyong
 * @createDate 2020/08/25
 */
public class CommandDemo {
    public static void main(String[] args) {
        Stock abcStock = new Stock();
        BuyStock buyStockOrder = new BuyStock(abcStock);
        SellStock sellStockOrder = new SellStock(abcStock);

        Broker broker = new Broker();
        broker.takeOrder(buyStockOrder);
        broker.takeOrder(sellStockOrder);

        broker.placeOrders();
    }
}
