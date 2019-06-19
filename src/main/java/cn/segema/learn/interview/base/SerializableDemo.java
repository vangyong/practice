package cn.segema.learn.interview.base;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializableDemo {

	public static void main(String[] args) throws Exception {
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("result.obj"));
		SerializableDomain test = new SerializableDomain();
		out.writeObject(test);
		out.flush();
		out.writeObject(test);
		out.close();
		ObjectInputStream oin = new ObjectInputStream(new FileInputStream("result.obj"));
		SerializableDomain t1 = (SerializableDomain) oin.readObject();
		SerializableDomain t2 = (SerializableDomain) oin.readObject();
		
	}

}
