package cn.hassan.base.akkas.t3.server

import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import cn.hassan.base.akkas.t3.common.{ClientMessage, ServerMessage}
import com.typesafe.config.ConfigFactory

class CustomerServer extends Actor{

  override def receive: Receive = {
    case "start" => println("customer is start working")
    case ClientMessage(msg) => {
      //使用match --case 匹配(模糊)
      msg match {
        case "what's your name" => sender() ! ServerMessage("hassan")
        case "where are you from" => sender() ! ServerMessage("china")
        case "how are you" => sender() ! ServerMessage("fine thanks and you?")
        case _ => sender() ! ServerMessage("你说的啥子~")
      }
    }
  }
}

object CustomerServer extends App{
  val host = "127.0.0.1"
  val port = 9999
  val config = ConfigFactory.parseString(
    s"""
       |akka.actor.provider="akka.remote.RemoteActorRefProvider"
       |akka.remote.netty.tcp.hostname=$host
       |akka.remote.netty.tcp.port=$port
        """.stripMargin)
  private val serverActorSystem = ActorSystem("Server",config)
  private val customerServerRef: ActorRef = serverActorSystem.actorOf(Props[CustomerServer],"customerServer")
  customerServerRef!"start"
}
