package cn.segema.learn.interview.basic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializableDemo implements Serializable {

	public static void main(String[] args) throws Exception {
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("result.obj"));
		SerializableDemo test = new SerializableDemo();
		out.writeObject(test);
		out.flush();
		out.writeObject(test);
		out.close();
		ObjectInputStream oin = new ObjectInputStream(new FileInputStream("result.obj"));
		SerializableDemo t1 = (SerializableDemo) oin.readObject();
		SerializableDemo t2 = (SerializableDemo) oin.readObject();
		
	}

}
