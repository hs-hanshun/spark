package cn.hassan.base.akkas.t2

import akka.actor.{ActorRef, ActorSystem, Props}

object ActorGame {
  val actorFactory = ActorSystem("actorFactory")
  private val bActorRef: ActorRef = actorFactory.actorOf(Props[BActor],"bActor")
  private val aActorRef: ActorRef = actorFactory.actorOf(Props(new AActor(bActorRef)),"aActor")

  def main(args: Array[String]): Unit = {
    aActorRef!"start"
  }
}
