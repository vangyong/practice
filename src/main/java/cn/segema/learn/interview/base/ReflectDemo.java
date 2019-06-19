package cn.segema.learn.interview.base;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectDemo {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		
		AccountDomain account = new AccountDomain(null, null, 0);
		AccountDomain a  = (AccountDomain) Class.forName("cn.segema.learn.interview.base.Account").newInstance();
		Constructor<AccountDomain> b  =  (Constructor<AccountDomain>) Class.forName("cn.segema.learn.interview.base.Account").getConstructor();
		b.newInstance(null,null,0);
	}

}
