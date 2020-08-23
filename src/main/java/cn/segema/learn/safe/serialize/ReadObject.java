package cn.segema.learn.safe.serialize;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ReadObject implements Serializable {

	private void readObject(java.io.ObjectInputStream stream) throws IOException, ClassNotFoundException {
		System.out.println("read object in ReadObject");
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		byte[] serializeData = serialize(new ReadObject());
		deserialize(serializeData);
	}

	public static byte[] serialize(final Object obj) throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ObjectOutputStream objOut = new ObjectOutputStream(out);
		objOut.writeObject(obj);
		return out.toByteArray();
	}

	public static Object deserialize(final byte[] serialized) throws IOException, ClassNotFoundException {
		ByteArrayInputStream in = new ByteArrayInputStream(serialized);
		ObjectInputStream objIn = new ObjectInputStream(in);
		return objIn.readObject();
	}

}
