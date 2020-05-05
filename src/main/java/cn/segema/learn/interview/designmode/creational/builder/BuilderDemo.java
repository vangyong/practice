package cn.segema.learn.interview.designmode.creational.builder;

public class BuilderDemo {

	public static void main(String[] args) {
//		SubMealBuilderA subMealBuilderA = new SubMealBuilderA();
//		KFCWaiter KFCWaiter = new KFCWaiter(subMealBuilderA);
//		KFCWaiter.mealBuilder.buildDrink();
		
		SubMealBuilderB subMealBuilderB = new SubMealBuilderB();
		KFCWaiter KFCWaiter2 = new KFCWaiter(subMealBuilderB);
		KFCWaiter2.mealBuilder.buildDrink();
	}
}
