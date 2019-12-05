package cn.segema.learn.interview.design.create.builder;

public abstract class MealBuilder {

	private Meal meal = null;

	public abstract void buildDrink();

	public abstract void buildFood();

	public Meal getMeal() {
		return meal;
	}

}
