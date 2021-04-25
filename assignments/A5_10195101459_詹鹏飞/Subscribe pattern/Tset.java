package com.example.a001;

import com.example.a001.IPublisher;
import com.example.a001.ISubcriber;
import com.example.a001.SubcribePublish;
//发布者-订阅者模式


public class Tset {
    public static final void main(String[] args){
        SubcribePublish<String> subcribePublish  = new SubcribePublish<String>("订阅器");
        IPublisher<Object> publisher1 = new PublishImpl<Object>("发布者1");
        IPublisher<String> publisher2 = new PublishImpl<String>("发布者1");

        ISubcriber<String> subcriber1 = (ISubcriber<String>) new SubcribeImpl("订阅者1");
        ISubcriber<String> subcriber2 = (ISubcriber<String>) new SubcribeImpl("订阅者2");


        subcriber1.subcribe(subcribePublish);
        subcriber2.subcribe(subcribePublish);

        publisher1.publish(subcribePublish,"作者1发布文章啦",true);
        publisher1.publish(subcribePublish, "作者1又发布文章啦",true);
        publisher1.publish(subcribePublish, "作者1又又又发布文章了",false);


        publisher2.publish(subcribePublish,"作者2在专栏上发布文章了",true);
        publisher2.publish(subcribePublish, "作者2也在发布文章了",false);
        System.out.println("-------------------");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        subcribePublish.update();
    }
}
