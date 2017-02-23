package com.mo.bao.akka.study;

import akka.actor.ActorRef;
import akka.actor.Terminated;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

/**
 * Created by hadoop on 2017/2/23.
 */
public class WatchActor extends UntypedActor {

    private final LoggingAdapter log = Logging.getLogger(getContext().system(), this);

    public WatchActor(ActorRef ref) {
        getContext().watch(ref);
    }

    @Override
    public void onReceive(Object msg) throws Throwable {
        if (msg instanceof Terminated) {
            System.out.println(String.format("%s has terminated, shutting down system",
                    ((Terminated) msg).getActor().path()));
          getContext().system().shutdown();
        } else {
            unhandled(msg);
        }
    }

}
