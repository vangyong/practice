 package cn.segema.learn.interview.designmode.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**@description 一句话描述该类的功能
 * @author wangyong
 * @createDate 2020/05/09
 */
 public class Employee {
     private String name;
     private String dept;
     private int salary;
     private List<Employee> subordinates;
   
     //构造函数
     public Employee(String name,String dept, int sal) {
        this.name = name;
        this.dept = dept;
        this.salary = sal;
        subordinates = new ArrayList<Employee>();
     }
   
     public void add(Employee e) {
        subordinates.add(e);
     }
   
     public void remove(Employee e) {
        subordinates.remove(e);
     }
   
     public List<Employee> getSubordinates(){
       return subordinates;
     }
   
     public String toString(){
        return ("Employee :[ Name : "+ name 
        +", dept : "+ dept + ", salary :"
        + salary+" ]");
     }   
  }
