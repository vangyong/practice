package cn.segema.learn.interview.designmode.creational.builder;

public class BuilderDemo {

	public static void main(String[] args) {
//		SubMealBuilderA subMealBuilderA = new SubMealBuilderA();
//		KFCWaiter KFCWaiter1 = new KFCWaiter(subMealBuilderA);
//		KFCWaiter1.mealBuilder.buildDrink();
		
		SubMealBuilderB subMealBuilderB = new SubMealBuilderB();
		KFCWaiter KFCWaiter2 = new KFCWaiter(subMealBuilderB);
		KFCWaiter2.mealBuilder.buildDrink();
	}
}
