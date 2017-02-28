package com.mo.bao.akka.study;

import akka.actor.UntypedActor;
import scala.Option;

/**
 * Created by hadoop on 2017/3/1.
 */
public class RestartActor extends UntypedActor {

    public enum Msg {
        DONE, RESTART
    }

    @Override
    public void preStart() throws Exception {

    }

    @Override
    public void postStop() throws Exception {

    }

    @Override
    public void preRestart(Throwable reason, Option<Object> message) throws Exception {
        super.preRestart(reason, message);
    }

    @Override
    public void postRestart(Throwable reason) throws Exception {
        super.postRestart(reason);
    }

    @Override
    public void onReceive(Object msg) throws Throwable {

    }

}
