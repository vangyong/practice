package cn.segema.learn.safe.fastjson;

/**
* @description 一句话描述该类的功能
* @author wangyong
* @createDate 2020/08/21
*/
public class UserDomain {
    private String name;
    private String age;
    private String born;

    public String getName() {
        System.out.println("name getter called");
        return name;
    }

    public void setName(String name) {
        System.out.println("name setter called");
        this.name = name;
    }

    public String getAge() {
        System.out.println("age getter called");
        return age;
    }

    public void setAge(String age) {
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
