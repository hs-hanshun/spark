package cn.hassan.base.akkas.t2

import akka.actor.{Actor, ActorRef}

class AActor(actorRef: ActorRef) extends Actor{
  val bactorRef:ActorRef = actorRef

  override def receive: Receive = {
    case "start" => {
      println("AActor start ok")
      self!"push"
    }
    case "push" => {
      println("aswome fushan wuyingjiao")
      Thread.sleep(1000)
      bactorRef!"push"
    }
  }
}
