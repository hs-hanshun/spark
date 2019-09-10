package cn.hassan.base.fun.t2

object HighFunFiter {
  def main(args: Array[String]): Unit = {
    val names = List("hassan","sherry","mark")
    val result = names.filter(check)
    println(result)
  }

  def check(str:String):Boolean={
    str.startsWith("s")
  }
}
