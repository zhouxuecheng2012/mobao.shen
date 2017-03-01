package com.mo.bao.akka.study;

import akka.actor.ActorRef;
import akka.actor.ActorSelection;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.typesafe.config.ConfigFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadoop on 2017/3/2.
 */
public class MyWorkerMain {
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("select", ConfigFactory.load("samplehello.conf"));
        List<ActorRef> workers = new ArrayList<>();
        for(int i=0 ;i <10;i++){
            workers.add(system.actorOf(Props.create(MyWorker.class),"worker_"+i));
        }

        ActorSelection sel = system.actorSelection("/user/worker_*");

        sel.tell(5,ActorRef.noSender());

    }
}
