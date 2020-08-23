package cn.segema.learn.safe.reflect;

public class ReflectDemo {
	public static void main(String[] args) throws Exception {
		Object runtime = Class.forName("java.lang.Runtime").getMethod("getRuntime", new Class[] {}).invoke(null);
		Class.forName("java.lang.Runtime").getMethod("exec", String.class).invoke(runtime, "calc.exe");
	}
}
