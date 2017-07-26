package me.jeffrey.learn.crazyjava.chapter6;

/**
 * 测试一个不可变的Person类，因为引入可变的Name类，变成了可变类
 * Created by jeffreysun on 2017/7/24.
 */
class Name{
    private String firstName;
    private String lastName;

    public Name(){}

    public Name(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    Name(Name name){
        this.firstName = name.firstName;
        this.lastName = name.lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

public class Person {
    private final Name name;

    /**
     * 会被修改
     * @param name
     */
//    public Person(Name name) {
//        this.name = name;
//    }

    /**
     * 不会修改
     * @param name
     */
    public Person(Name name) {
        this.name = new Name(name);
    }

    public Name getName() {
        return name;
    }

    public static void main(String[] args) {
        Name n = new Name("悟空", "孙");
        Person p = new Person(n);

        System.out.println(p.getName().getFirstName());
        n.setFirstName("八戒");
        System.out.println(p.getName().getFirstName());
    }
}
