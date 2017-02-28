package com.mo.bao.akka.study;

import akka.actor.OneForOneStrategy;
import akka.actor.Props;
import akka.actor.SupervisorStrategy;
import akka.actor.SupervisorStrategy.Directive;
import akka.actor.UntypedActor;
import akka.japi.Function;
import scala.concurrent.duration.Duration;

import java.util.concurrent.TimeUnit;

/**
 * Created by hadoop on 2017/2/23.
 */
public class Supervisor extends UntypedActor {

    //1分钟内3次重试,超过则杀死Actor
    private static SupervisorStrategy strategy = new OneForOneStrategy(3, Duration.create(1, TimeUnit.MINUTES),
            new Function<Throwable, Directive>() {
                @Override
                public Directive apply(Throwable t) {
                    if (t instanceof ArithmeticException) {
                        System.out.println("meet ArithmeticException,just resume");
                        return SupervisorStrategy.resume();
                    } else if (t instanceof NullPointerException) {
                        System.out.println("meet NullPointerException,restart");
                        return SupervisorStrategy.restart();
                    } else if (t instanceof IllegalArgumentException) {
                        System.out.println("stop");
                        return SupervisorStrategy.stop();
                    } else {
                        //escalate逐步扩大
                        return SupervisorStrategy.escalate();
                    }
                }
            });

    @Override
    public SupervisorStrategy supervisorStrategy() {
        return strategy;
    }

    @Override
    public void onReceive(Object o) throws Throwable {
        if (o instanceof Props) {
            getContext().actorOf((Props) o,"restartActor");
        } else {
            unhandled(o);
        }
    }

}
