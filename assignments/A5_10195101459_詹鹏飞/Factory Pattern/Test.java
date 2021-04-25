package com.example.a002;
//工厂模式
public class Test {
    public static void main(String[] args) {
        peopleFactory test_factory=new peopleFactory();
        People test1=test_factory.setPeople("Manager");
        test1.set();
        People test2=test_factory.setPeople("Teacher");
        test2.set();
        People test3=test_factory.setPeople("Student");
        test3.set();
    }
}
