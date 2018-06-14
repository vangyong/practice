package cn.segema.learn.interview.reflect;

import java.io.Serializable;

public class Customer implements Cloneable, Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private void sayHello() {
		System.out.println("客户说话");
	}

	@Override
	public int hashCode() {

		return super.hashCode();
	}

	@Override
	protected Object clone() {

		Object obj = null;
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
