package cn.segema.learn.spi.canla;

public class PluginServiceDemo implements Plugin {

	@Override
	public String getJar() {
		System.out.println("PluginService working ! ");
		return PluginServiceDemo.class.getName();
	}

	@Override
	public String doBusiness(String param) {
		System.out.println("do business "+param);
		return "sucess"+param;
	}

}
