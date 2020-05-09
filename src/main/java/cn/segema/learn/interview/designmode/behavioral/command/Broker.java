package cn.segema.learn.interview.designmode.behavioral.command;

import java.util.ArrayList;
import java.util.List;

/**
* @description 一句话描述该类的功能
* @author wangyong
* @createDate 2020/05/09
*/
public class Broker {
    private List<Order> orderList = new ArrayList<Order>();

    public void takeOrder(Order order) {
        orderList.add(order);
    }

    public void placeOrders() {
        for (Order order : orderList) {
            order.execute();
        }
        orderList.clear();
    }
}
