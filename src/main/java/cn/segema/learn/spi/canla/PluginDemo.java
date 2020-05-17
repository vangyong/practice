package cn.segema.learn.spi.canla;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.net.URLClassLoader;

public class PluginDemo {
	public static void main(String[] args) {
		try {
			// 第一种 配置成文件格式
			File file = new File("/Users/wangyong/Downloads/plugins/config.txt");
			BufferedReader in = new BufferedReader(new FileReader(file));
			String s = new String();
			while ((s = in.readLine()) != null) {
				URL url = new URL(s);
				s = null;
				URLClassLoader myClassLoader = new URLClassLoader(new URL[] { url },
						Thread.currentThread().getContextClassLoader());
				Class<?> myClass = (Class<?>) myClassLoader.loadClass("cn.segema.learn.spi.canla.PluginService");
				Plugin plugin = (Plugin) myClass.newInstance();
				String str = plugin.doBusiness("param");
				System.out.println(str);

				// 第二种
				URL url1 = new URL("file:/Users/wangyong/Downloads/plugins/pluginservice.jar");
				URLClassLoader myClassLoader1 = new URLClassLoader(new URL[] { url1 },
						Thread.currentThread().getContextClassLoader());
				Class<?> myClass1 = myClassLoader1.loadClass("cn.segema.learn.spi.canla.PluginService");
				Plugin plugin1 = (Plugin) myClass1.newInstance();
				String str1 = plugin1.doBusiness("param1");
				System.out.println(str1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
