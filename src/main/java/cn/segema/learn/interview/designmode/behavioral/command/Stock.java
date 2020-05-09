package cn.segema.learn.interview.designmode.behavioral.command;

/**
* @description 一句话描述该类的功能
* @author wangyong
* @createDate 2020/05/09
*/
public class Stock {

    private String name = "ABC";
    private int quantity = 10;

    public void buy(){
        System.out.println("Stock [ Name: "+name+", Quantity: " + quantity +" ] bought");
     }

    public void sell(){
        System.out.println("Stock [ Name: "+name+", Quantity: " + quantity +" ] sold");
     }
}
