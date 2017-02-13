package com.mo.bao.akka.study;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;

/**
 * Created by hadoop on 2017/2/14.
 * UntypedActorContext
 *
 */
public class HelloWorld extends UntypedActor {

    ActorRef greeter;

    @Override
    public void preStart() throws Exception {
        greeter = getContext().actorOf(Props.create(Greeter.class),"greeter");
        System.out.println("Greeter Actor Path:"+greeter.path());
        greeter.tell(Greeter.Msg.GREET,getSelf());
    }

    @Override
    public void onReceive(Object msg) throws Throwable {
        if (msg == Greeter.Msg.DONE) {
            greeter.tell(Greeter.Msg.GREET,getSelf());
            getContext().stop(getSelf());
        }else {
            unhandled(msg);
        }
    }

}
