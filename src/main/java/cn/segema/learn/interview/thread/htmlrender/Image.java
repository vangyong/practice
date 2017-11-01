package cn.segema.learn.interview.thread.htmlrender;

public class Image {
	private String info;

	public Image(String info) {
		this.info = info;
	}

	public void download() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException ignored) {
		}
	}
	
	
}
