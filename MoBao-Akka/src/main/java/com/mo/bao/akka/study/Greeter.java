package com.mo.bao.akka.study;

import akka.actor.UntypedActor;

/**
 * Created by hadoop on 2017/2/14.
 * ActorRef
 */
public class Greeter extends UntypedActor {

    public static enum Msg {
        GREET, DONE;
    }

    @Override
    public void onReceive(Object msg) throws Throwable {
        if (msg == Msg.GREET) {
            System.out.println("Hello World");
            getSender().tell(Msg.DONE, getSelf());
        } else {
            unhandled(msg);
        }
    }

}
