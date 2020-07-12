package cn.segema.learn.spi.canla;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PluginManager {
	private final static Logger logger = LoggerFactory.getLogger(PluginManager.class);

	private URLClassLoader urlClassLoader;

	public PluginManager(List<Plugin> plugins) throws MalformedURLException {
		init(plugins);
	}

	// 将所有插件动态加载至JVM中
	private void init(List<Plugin> plugins) throws MalformedURLException {
		int size = plugins.size();
		URL[] urls = new URL[size];
		for (int i = 0; i < size; i++) {
			Plugin plugin = plugins.get(i);
			String filePath = plugin.getJar();
			urls[i] = new URL("file:" + filePath);
		}
		urlClassLoader = new URLClassLoader(urls);
	}

	public PluginServiceDemo getInstance(String className)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		// 插件实例化对象，得到每一个插件具体的对象
		Class<?> clazz = urlClassLoader.loadClass(className);
		Object instance = clazz.newInstance();
		return (PluginServiceDemo) instance;
	}
}
