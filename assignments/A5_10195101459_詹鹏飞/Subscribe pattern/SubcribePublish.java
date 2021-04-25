package com.example.a001;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class SubcribePublish<M> {
    private String name;
    final int QUEUE_CAPACITY = 20;

    private BlockingQueue<Msg> queue = new ArrayBlockingQueue<Msg>(QUEUE_CAPACITY);
    private List<ISubcriber> subcribers = new ArrayList<ISubcriber>();

    public SubcribePublish(String name){
        this.name = name;
    }

    public void publish(String publisher,M message,boolean isInstantMsg){
        if (isInstantMsg){
            update(publisher,message);
            return;
        }
        Msg<M> mMsg = new Msg<M>(publisher,message);
        if (!queue.offer(mMsg)){
            update();
        }
    }

    public void subcribe(ISubcriber subcriber){
        subcribers.add(subcriber);
    }

    public void unSubcribe(ISubcriber subcriber){
        subcribers.remove(subcriber);
    }



    public void update(){
        Msg m = null;
        while ((m = queue.poll())!= null){
            this.update(m.getPublisher(), (M) m.getMsg());
        }
    }


    private void update(String publisher,M msg){
        for (ISubcriber subcriber:subcribers){
            subcriber.update(publisher,msg);
        }
    }
}