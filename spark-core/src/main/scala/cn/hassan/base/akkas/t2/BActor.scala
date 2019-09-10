package cn.hassan.base.akkas.t2

import akka.actor.Actor

class BActor extends Actor{
  override def receive: Receive = {
    case "push" => {
      println("aswome xianglongshibazhang")
      Thread.sleep(1000)
      //通过sender() 方法可以得到发送消息的Actor的ActorRef，通过这个ActorRef，B actor也可以回复消息
      sender()!"push"
    }
  }
}
