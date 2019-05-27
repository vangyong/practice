package cn.segema.learn.interview.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import cn.segema.learn.interview.base.Account;

public class ReflectDemo {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		
		Account account = new Account(null, null, 0);
		Account a  = (Account) Class.forName("cn.segema.learn.interview.test.Account").newInstance();
		Constructor<Account> b  =  (Constructor<Account>) Class.forName("cn.segema.learn.interview.test.Account").getConstructor();
		b.newInstance(null,null,0);
	}

}
