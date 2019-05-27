package cn.segema.learn.interview.classload;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MyClassLoader extends ClassLoader {

	public static final String drive = "/Users/wangyong/Downloads/";
	public static final String fileType = ".class";

	public static void main(String[] args) throws Exception {
		MyClassLoader loader = new MyClassLoader();
		Class<?> objClass = loader.loadClass("ClassLoaderDemo", true);
		Object obj = objClass.newInstance();
		System.out.println(objClass.getName());
		System.out.println(objClass.getClassLoader());
		System.out.println(obj.getClass().toString());
		ClassLoaderDemo ClassLoaderDemo= (cn.segema.learn.interview.classload.ClassLoaderDemo) objClass.newInstance();
		System.out.println(ClassLoaderDemo.getName());
	}

	public Class<?> findClass(String name) {
		byte[] data = loadClassData(name);
		return defineClass(name, data, 0, data.length);// 将一个 byte 数组转换为 Class// 类的实例
	}

	public byte[] loadClassData(String name) {
		FileInputStream fis = null;
		byte[] data = null;
		try {
			fis = new FileInputStream(new File(drive + name + fileType));
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int ch = 0;
			while ((ch = fis.read()) != -1) {
				baos.write(ch);
			}
			data = baos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}

}
