package com.mo.bao.akka.study;

import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import scala.Option;

/**
 * Created by hadoop on 2017/2/22.
 */
public class MyWorker extends UntypedActor {

    private final LoggingAdapter log = Logging.getLogger(getContext().system(), this);

    public static enum Msg {
        WORKING, DONE, CLOSE;
    }

    @Override
    public void onReceive(Object msg) throws Throwable {
        if (msg == Msg.WORKING) {
            System.out.println("I am working");
        } else if (msg == Msg.DONE) {
            System.out.println("Stop working");
        } else if (msg == Msg.CLOSE) {
            System.out.println("I Will shutdown");
            getSender().tell(Msg.CLOSE, getSelf());
            getContext().stop(getSelf());
        } else {
            unhandled(msg);
        }
    }

    //when restart actor，invoke preRestart.
    @Override
    public void preRestart(Throwable reason, Option<Object> message) throws Exception {
        System.out.println("MyWorker is preRestart");
    }

    //after restart actor,invoke postRestart.
    @Override
    public void postRestart(Throwable reason) throws Exception {
        System.out.println("MyWorker is postRestart");
    }

    @Override
    public void preStart() throws Exception {
        System.out.println("MyWorker is starting");
    }

    @Override
    public void postStop() throws Exception {
        System.out.println("MyWorker is stopping");
    }

}
