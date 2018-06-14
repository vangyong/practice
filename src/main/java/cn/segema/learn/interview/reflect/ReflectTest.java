package cn.segema.learn.interview.reflect;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

public class ReflectTest {

	public static void main(String[] args) {
		try {
			//1
			Customer c0 = new Customer();
			c0.setName("c0");
			System.out.println(c0.getName());
			//2
			Class objClass = Class.forName("cn.segema.learn.interview.reflect.Customer");
			Customer c1 = (Customer) objClass.newInstance();
			c1.setName("c1");
			c1.setDescription("藐视");
			System.out.println(c1.getDescription());
			
			Constructor<Customer> constructor = Customer.class.getConstructor();
			Customer c2 = constructor.newInstance();
			c2.setName("c2");
			System.out.println(c2.getName());
			
			
			Customer c3 = (Customer) c2.clone();
			
			// Serialization
	        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data.obj"));
	        out.writeObject(c3);
	        out.close();
	        //Deserialization
	        ObjectInputStream in = new ObjectInputStream(new FileInputStream("data.obj"));
	        Customer c4 = (Customer) in.readObject();
	        in.close();
	        c4.setName("Akash");
	        System.out.println(c4 + ", hashcode : " + c4.hashCode());
	        
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
