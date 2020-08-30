package cn.segema.learn.interview.concurrent.producterconsumer;

import java.io.Serializable;

public class Student  implements Serializable{

	private static final long serialVersionUID = -8201425102589806235L;
	private String id;
	private String name;
	private int chinese;
	private int math;
	private int english;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getChinese() {
		return chinese;
	}
	public void setChinese(int chinese) {
		this.chinese = chinese;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getEnglish() {
		return english;
	}
	public void setEnglish(int english) {
		this.english = english;
	}
	
	
	

}
