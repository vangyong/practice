package cn.segema.learn.spi.canla;

import org.elasticsearch.plugins.PluginsService;

public class PluginService implements Plugin {

	@Override
	public String getJar() {
		System.out.println("PluginService working ! ");
		return PluginsService.class.getName();
	}

	@Override
	public String doBusiness(String param) {
		System.out.println("do business ");
		return "sucess";
	}

}
