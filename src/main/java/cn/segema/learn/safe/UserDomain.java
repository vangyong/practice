 package cn.segema.learn.safe;

 /**
 * @description 一句话描述该类的功能
 * @author wangyong
 * @createDate 2020/08/21
 */
public class UserDomain {
    private String userName;
    private int age;
    private String born;
    
    public String getUserName() {
        System.out.println("userName getter called");
        return userName;
    }
    public void setUserName(String userName) {
        System.out.println("userName setter called");
        this.userName = userName;
    }
    public int getAge() {
        System.out.println("age getter called");
        return age;
    }
    public void setAge(int age) {
        System.out.println("age setter called");
        this.age = age;
    }
    public String getBorn() {
        return born;
    }
    public void setBorn(String born) {
        this.born = born;
    }
}
