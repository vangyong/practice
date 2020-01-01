package cn.segema.learn.framework.springaop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

public class AopDemo {
	
	@Pointcut("execution(* controller..UserController.addUser(..))")
	private void controllerAOP() {
		System.out.println("执行controller的哪些方法时执行--");
	}

	@Pointcut("execution(* service.UserService.*(..))")
	private void serviceAOP() {
		System.out.println("执行service的哪些方法时执行--");
	}
	/*
	 * 前置通知 ，JoinPont是srpring提供的静态变量，
	 * 通过joinPoint参数可以获得目标方法的类名，方法参数，方法名等信息，这个参数可有可无。
	 */
	@Before("controllerAOP() || serviceAOP()")
	public void doBefore(JoinPoint joinPoint) {
		System.out.println("@Before:开始添加--order=3");
	}

	// 后置通知 ，如果result的类型与proceed执行的方法返回的参数类型不匹配那么就不会执行这个方法
	@AfterReturning(pointcut = "controllerAOP()  || serviceAOP()", returning = "result")
	public void doAfterReturning(String result) {
		System.out.println("@AfterReturning:后置通知--order=3");
		System.out.println("---" + result + "---");
	}

	// 例外通知
	@AfterThrowing(pointcut = "controllerAOP() || serviceAOP()", throwing = "e")
	public void doAfterThrowing(Exception e) {
		System.out.println("@AfterThrowing:例外通知--order=3");
		System.out.println(e.getMessage());
	}

	// 最终通知
	@After("controllerAOP() || serviceAOP()")
	public void doAfter() {
		System.out.println("@After:最终通知--order=3");
	}
	
	/*
	 * 环绕通知 参数必须是ProceedingJoinPoint，通过该对象的proceed()方法来执行目标函数，
	 * proceed()的返回值就是环绕通知的返回值，proceedingJoinPoint是个接口， implement
	 * JoinPoint,所以也可以获得目标函数的类名，方法名等参数。
	 */
	@Around("controllerAOP() || serviceAOP()")
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("@Around:进入方法---环绕通知--order=3");
		Object o = pjp.proceed();
		System.out.println("@Around:退出方法---环绕通知--order=3");
		return o;
	}
	
}
