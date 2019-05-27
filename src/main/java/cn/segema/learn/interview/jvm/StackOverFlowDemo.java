package cn.segema.learn.interview.jvm;

public class StackOverFlowDemo {
	private int i;
	public void plus() {
		i++;
		plus();
	}

	public static void main(String[] args) {
		StackOverFlowDemo stackOverFlow = new StackOverFlowDemo();
		try {
			stackOverFlow.plus();
		} catch (Exception e) {
			System.out.println("Exception:stack length:" + stackOverFlow.i);
			e.printStackTrace();
		} catch (Error e) {
			System.out.println("Error:stack length:" + stackOverFlow.i);
			e.printStackTrace();
		}
	}
	
}
