package cn.segema.learn.interview.designmode.creational.builder;

public class SubMealBuilderA extends MealBuilder {

	@Override
	public void buildDrink() {
		System.out.println("SubMealBuilderA buildDrink");
	}

	@Override
	public void buildFood() {
		System.out.println("SubMealBuilderA buildFood");
	}

}
