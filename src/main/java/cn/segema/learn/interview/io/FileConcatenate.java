package cn.segema.learn.interview.io;

import java.io.BufferedReader;  
import java.io.BufferedWriter;  
import java.io.FileReader;  
import java.io.FileWriter;  
import java.io.IOException;  
import java.util.Iterator;  
   
public class FileConcatenate {  
   
  /** 
   * 包装类进行文件级联操作 
   */  
  public static void main(String[] args) {  
     // TODO自动生成的方法存根  
     try {  
    	 String[] paras = {"G:/test/1.txt","G:/test/2.txt","G:/test/3.txt"};
    	 
        concennateFile(paras);  
     } catch (IOException e) {  
        // TODO自动生成的 catch 块  
        e.printStackTrace();  
     }  
  }  
  public static void concennateFile(String...fileName) throws IOException{  
     String str;  
     //构建对该文件您的输入流  
     BufferedWriter writer=new BufferedWriter(new FileWriter("G:/test/copy2.txt"));  
     for(String name: fileName){  
        BufferedReader reader=new BufferedReader(new FileReader(name));  
         
        while ((str=reader.readLine())!=null) {  
           writer.write(str);  
           writer.newLine();  
        }  
     }  
  }  
}