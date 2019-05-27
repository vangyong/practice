package cn.segema.learn.interview.base;

public class AccountDemo {
	public static void main(String[] args) {
		Account a1 = new Account("001", "tom", 200.0);
		Account a2 = new Account("002", "Jim", 500.0);
		a1.withdraw(300);
		a1.withdraw(100);
		a2.deposit(300);
		a1.transfer(a1, a2, 600);// 验证转账失败，余额不足以支付转账
		a2.transfer(a2, a1, 600);
		a1.query();
		a2.query();
	}
}
