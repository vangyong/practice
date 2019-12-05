package cn.segema.learn.interview.design.create.builder;

public class KFCWaiter {

	public MealBuilder mealBuilder;

	public KFCWaiter(MealBuilder mealBuilder) {
		super();
		this.mealBuilder = mealBuilder;
	}

	public void setMealBuilder(MealBuilder mealBuilder) {
		this.mealBuilder = mealBuilder;
	}

}
