package cn.segema.learn.interview.design.creational.builder;

public class SubMealBuilderB extends MealBuilder{

	@Override
	public void buildDrink() {
		System.out.println("SubMealBuilderB buildDrink");
	}

	@Override
	public void buildFood() {
		System.out.println("SubMealBuilderB buildFood");
	}
}
