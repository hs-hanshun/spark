package cn.hassan.base.interfaze

trait TimestampLogger extends Logger{

  override def log(msg: String): Unit = {
    println(msg)
  }

}
