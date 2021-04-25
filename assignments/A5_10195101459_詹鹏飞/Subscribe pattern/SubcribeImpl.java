package com.example.a001;

import com.example.a001.ISubcriber;
import com.example.a001.SubcribePublish;



public class SubcribeImpl implements ISubcriber {

    private String name;
    public SubcribeImpl(String name){
        this.name = name;
    }
    public void subcribe(SubcribePublish subcribePublish) {
        subcribePublish.subcribe(this);
    }

    public void unSubcribe(SubcribePublish subcribePublish) {
        subcribePublish.unSubcribe(this);
    }

    public void update(String publisher, Object message) {
        System.out.println(this.name +" \t收到 \t"+publisher+" \t发来的消息："+message.toString());
    }


}