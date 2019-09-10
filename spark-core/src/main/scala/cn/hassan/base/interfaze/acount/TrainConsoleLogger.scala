package cn.hassan.base.interfaze.acount

import interfaze.Logger

trait TrainConsoleLogger extends Logger {

  def log(msg: String): Unit = println(msg)

}
