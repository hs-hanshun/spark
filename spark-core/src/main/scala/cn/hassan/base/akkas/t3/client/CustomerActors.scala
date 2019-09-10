package cn.hassan.base.akkas.t3.client

import akka.actor.{Actor, ActorRef, ActorSelection, ActorSystem, Props}
import akkas.t3.common.{ClientMessage, ServerMessage}
import com.typesafe.config.ConfigFactory

import scala.io.StdIn

class CustomerActors(serverHost:String,serverPort:Int) extends Actor{

  var serverActorRef:ActorSelection = _

  //在Actor中有一个方法PreStart方法，他会在actor运行前执行
  //在akka的开发中，通常将初始化的工作，放在preStart方法
  override def preStart(): Unit = {
    println("preStart() 执行")
    serverActorRef = context.actorSelection(s"akka.tcp://Server@${serverHost}:${serverPort}/user/customerServer")
    println("serverActorRef=" + serverActorRef)
  }

  override def receive: Receive = {
    case "start" => println("server is start,you can ask question")
    case msg:String => {
      serverActorRef!ClientMessage(msg)
    }
    case ServerMessage(msg) => {
      println(s"message from cutomerServer(server) : $msg")
    }
  }
}

object CustomerActors  extends App{
  val (clientHost, clientPort, serverHost, serverPort) = ("127.0.0.1", 9990, "127.0.0.1", 9999)
  val config = ConfigFactory.parseString(
    s"""
       |akka.actor.provider="akka.remote.RemoteActorRefProvider"
       |akka.remote.netty.tcp.hostname=$clientHost
       |akka.remote.netty.tcp.port=$clientPort
        """.stripMargin)

  //创建ActorSystem
  val clientActorSystem = ActorSystem("client", config)

  //创建CustomerActor的实例和引用
  val customerActorRef: ActorRef = clientActorSystem.actorOf(Props(new CustomerActors(serverHost, serverPort)), "CustomerActor")

  //启动customerRef/也可以理解启动Actor
  customerActorRef ! "start"

  //客户端可以发送消息给服务器
  while (true) {
    println("请输入要咨询的问题")
    val mes = StdIn.readLine()
    customerActorRef ! mes
  }
}