package cn.segema.learn.interview.basic;

public class OuterInnerAccessDemo {
	// 怎么创建静态内部类和非静态内部类的实例
	public static void main(String args[]){
	    // 创建静态内部类的实例
	    OuterClassDomain.NestedStaticClass printer = new OuterClassDomain.NestedStaticClass();
	    // 创建静态内部类的非静态方法
	    printer.printMessage();  

	    // 为了创建非静态内部类，我们需要外部类的实例
	    OuterClassDomain outer = new OuterClassDomain();    
	    OuterClassDomain.InnerClass inner = outer.new InnerClass();//这样new出来的
	    // 调用非静态内部类的非静态方法
	    inner.display();
	    // 我们也可以结合以上步骤，一步创建的内部类实例
	    OuterClassDomain.InnerClass innerObject = new OuterClassDomain().new InnerClass();
	    // 同样我们现在可以调用内部类方法
	    innerObject.display();
	  }
}
