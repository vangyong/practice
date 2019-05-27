package cn.segema.learn.interview.serialize;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeDemo {

	public static void main(String[] args) throws Exception {
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("result.obj"));
		Test test = new Test();
		out.writeObject(test);
		out.flush();
		out.writeObject(test);
		out.close();
		ObjectInputStream oin = new ObjectInputStream(new FileInputStream("result.obj"));
		Test t1 = (Test) oin.readObject();
		Test t2 = (Test) oin.readObject();
		
	}

}
