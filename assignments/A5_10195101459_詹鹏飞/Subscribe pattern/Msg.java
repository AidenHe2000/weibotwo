package com.example.a001;

public class Msg<M> {
    private String publisher;
    private M m;

    public Msg(String publisher,M m){
        this.publisher = publisher;
        this.m = m;
    }

    public String getPublisher(){
        return publisher;
    }

    public void setPublisher(String publisher){
        this.publisher = publisher;
    }

    public M getMsg(){
        return m;
    }
    public void setMsg(M m){
        this.m = m;
    }
}
