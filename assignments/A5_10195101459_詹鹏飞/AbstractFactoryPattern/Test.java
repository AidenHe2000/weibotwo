package com.example.a003;
//抽象工厂模式
public class Test {
    public static void main(String[] args) {
        AbstractFactory PeopleFac=FactoryProducer.getFactory("People");
        AbstractFactory FingureFac=FactoryProducer.getFactory("Fingure");


        People peo1=PeopleFac.setpeople("Manager");
        peo1.set();
        People peo2=PeopleFac.setpeople("Teacher");
        peo2.set();
        People peo3=PeopleFac.setpeople("Student");
        peo3.set();

        PeopleFingure fin1=FingureFac.selectFingure("Fat");
        fin1.select();
        PeopleFingure fin2=FingureFac.selectFingure("Slim");
        fin2.select();
        PeopleFingure fin3=FingureFac.selectFingure("Trim");
        fin3.select();
    }
}
