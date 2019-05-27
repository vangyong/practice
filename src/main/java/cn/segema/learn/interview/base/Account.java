package cn.segema.learn.interview.base;

public class Account{

	private String accountID;
	private String name;
	private double balance;
	private static double minorBalance = 10.0;

	public Account(String accountID, String name, double balance) {
		this.accountID = accountID;
		this.name = name;
		this.balance = balance;

	}

	// 取款
	public void withdraw(double cash) {
		if (balance - cash >= minorBalance) {
			System.out.println("原有余额" + balance + ",取出" + cash + "，现有余额" + (balance - cash));
			balance = balance - cash;
		} else
			System.out.println("Sorry,your saving isn't enough!");
	}

	// 存款
	public void deposit(double cash) {
		System.out.println("原有余额" + balance + ",存入" + cash + "，现有余额" + (balance + cash));
		balance = balance + cash;
	}

	// 查询
	public void query() {
		System.out.print("账号:" + accountID);
		System.out.print("，姓名:" + name);
		System.out.println("，余额:" + balance);
	}

	// 转账
	public void transfer(Account a2, Account a1, double cash) {
		if (a2.balance - cash >= minorBalance) {
			a2.balance -= cash;
			a1.balance += cash;
			System.out.println("转账成功!转账后" + a2.name + "先生你的余额为：" + a2.balance + a1.name + "的账户余额：" + a1.balance);
		} else {
			System.out.println("你的余额不足！");

		}
	}

	public String getAccountID() {
		return accountID;
	}

	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public static double getMinorBalance() {
		return minorBalance;
	}

	public static void setMinorBalance(double minorBalance) {
		Account.minorBalance = minorBalance;
	}

	
	
}
