package cn.segema.learn.interview.base;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Constructor;
import java.util.LinkedList;

public class AppMain{
    public static void main(String[] args) {

//        Map<String, String> map = new HashMap<String, String>();
//        Map map2 = new ConcurrentHashMap();
//        Hashtable hashtable = new Hashtable();
//        Collections.synchronizedMap(map);
//
//        String s0 ="MDFG";
//        String s1 ="MD"+"FG";
//        String s2 = new String("MDFG");
//
//        System.out.println(s0==s1);
//        System.out.println(s0==s2);
//        System.out.println(s1==s2);
//
//        s1 = s1.intern();
//        s2 = s2.intern();
//
//        System.out.println(s0==s1);
//        System.out.println(s0==s2);
//        System.out.println(s1==s2);
    	
//        
//    	 Thread t = new Thread() {
//             public void run() {
//                 pong();
//             }
//         };
//         //t.run();
//         t.start();
//         System.out.print("ping");
    	
//    	FileInputStream in = null;
//		try {
//			in = new FileInputStream("/Users/wangyong/Downloads/a.txt");
//			in.skip(9);
//			int c=in.read();
//			System.out.println(c);
//			
//			RandomAccessFile in2= new RandomAccessFile("/Users/wangyong/Downloads/a.txt","rw");
//			in2.skipBytes(9); 
//			byte c2=in2.readByte();
//			System.out.println(c2);
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		} 
    	
    		new Child("mike");
		
		
    }
    
//    static void pong() {
//        System.out.print("pong");
//    }


    
   
}
