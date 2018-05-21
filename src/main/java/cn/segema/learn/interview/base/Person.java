package cn.segema.learn.interview.base;

public class Person {
	 private String name;

	    private String sex;

	    public Person(String x, String y) {
	        this.name = x;
	        this.sex = y;
	    }

	    // 重写toString()方法，方便输出
	    public String toString() {

	        return name + " " + sex;
	    }

	    // 交换对象引用
	    public static void swapObject(Person p1, Person p2) {
	        Person tmp = p1;
	        p1 = p2;
	        p2 = tmp;
	    }

	    // 交换基本类型
	    public static void swapInt(int a, int b) {
	        int tmp = a;
	        a = b;
	        b = tmp;
	    }

	    // 交换对象数组
	    public static void swapObjectArray(Person[] p1, Person[] p2) {
	        Person[] tmp = p1;
	        p1 = p2;
	        p2 = tmp;
	    }

	    // 交换基本类型数组
	    public static void swapIntArray(int[] x, int[] y) {
	        int[] tmp = x;
	        x = y;
	        y = tmp;
	    }

	    // 改变对象数组中的内容
	    public static void changeObjectArray(Person[] p1, Person[] p2) {
	        Person tmp = p1[1];
	        p1[1] = p2[1];
	        p2[1] = tmp;
	        
	        // 再将p1[1]修改
	        Person p = new Person("wjl", "male");
	        p1[1] = p;
	    }

	    // 改变基本类型数组中的内容
	    public static void changeIntArray(int[] x, int[] y) {
	        int tmp = x[1];
	        x[1] = y[1];
	        y[1] = tmp;

	        x[1] = 5;
	    }
}
