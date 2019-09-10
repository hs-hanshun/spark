package cn.hassan.base.akkas.t1

import akka.actor.{ActorRef, ActorSystem, Props}

object SayHelloActorTest {

  //创建ActorSystem，专门用于管理Actor
  private val actorfactory = ActorSystem("actorfactory")
  //Props[SayHelloActor]通过反射创建了一个SayHelloActor的实例 "sayHelloActor" 是给Actor起名
  //sayHelloActorRef: ActorRef 就是Props[SayHelloActor]的ActorRef
  //actorfactory使用actorfactory.actorOf接管Actor
  private val sayHelloActorRef: ActorRef = actorfactory.actorOf(Props[SayHelloActor],"sayHelloActor")

  def main(args: Array[String]): Unit = {
    sayHelloActorRef!"hello"
    sayHelloActorRef!"ok"
    sayHelloActorRef!"ok~"
    sayHelloActorRef!"exit"
  }
}
