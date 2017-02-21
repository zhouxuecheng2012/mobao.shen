package com.mo.bao.akka.study;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.typesafe.config.ConfigFactory;

/**
 * Created by hadoop on 2017/2/14.
 * ActorSystem
 * 当系统内有多个Actor存在时，Akka会自动在线程池中选择线程来执行我们的Actor,
 *
 */
public class HelloMainSimple {

    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("hello", ConfigFactory.load("samplehello.conf"));
        ActorRef a = system.actorOf(Props.create(HelloWorld.class), "helloWorld");
        System.out.println("HelloWorld Actor Path:" + a.path());
    }

}
