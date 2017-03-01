package com.mo.bao.akka.study;

import akka.actor.ActorRef;
import akka.actor.ActorSelection;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.typesafe.config.ConfigFactory;

/**
 * Created by hadoop on 2017/3/2.
 */
public class SupervisorMain {

    public static void main(String[] args) {

        ActorSystem system = ActorSystem.create("lifecycle", ConfigFactory.load("samplehello.conf"));

        customStrategy(system);
    }

    private static void customStrategy(ActorSystem system) {

        ActorRef a = system.actorOf(Props.create(Supervisor.class), "Supervisor");

        a.tell(Props.create(RestartActor.class), ActorRef.noSender());

        ActorSelection sel = system.actorSelection("akka://lifecycle/user/Supervisor/restartActor");

        for (int i = 0; i < 100; i++) {
            sel.tell(RestartActor.Msg.RESTART, ActorRef.noSender());
        }

    }

}
