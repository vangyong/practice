package cn.segema.learn.interview.designmode.creational.simplefactory;

public class Factory {

    Product createProduct(String arg) {
        if (arg == "A") {
            return new ConcreteProductA();
        } else if (arg == "B") {
            return new ConcreteProductB();
        } else {
            return null;
        }

    }

}
