package cn.segema.learn.interview.basic;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectDemo {
	public static void main(String[] args){

		AccountDomain account = new AccountDomain(null, null, 0);
		System.out.println("******");
		try {
			AccountDomain a = (AccountDomain) Class.forName("cn.segema.learn.interview.basic.AccountDomain").newInstance();
			Constructor<AccountDomain> accountConstructor;
			try {
				accountConstructor = (Constructor<AccountDomain>) Class.forName("cn.segema.learn.interview.basic.AccountDomain").getConstructor();
				AccountDomain b = accountConstructor.newInstance();
				b.setName("构造器初始化");
				System.out.println(b.getName());
			} catch (NoSuchMethodException | SecurityException | InvocationTargetException e1) {
				e1.printStackTrace();
			}
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
