package com.mo.bao.akka.study;

import akka.actor.UntypedActor;
import scala.Option;

/**
 * Created by hadoop on 2017/2/22.
 */
public class MyWorker extends UntypedActor {

    @Override
    public void onReceive(Object message) throws Throwable {

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
    public void preStart() throws Exception {
        super.preStart();
    }

    @Override
    public void postStop() throws Exception {
        super.postStop();
    }
}
