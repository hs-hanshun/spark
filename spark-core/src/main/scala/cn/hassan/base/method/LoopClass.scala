package cn.hassan.base.method

import scala.util.control.Breaks

object LoopClass {
  def main(args: Array[String]): Unit = {
    val loop = new Breaks
    var n = 0
    loop.breakable{
      while (n <= 20) {
        n+=1
        if (n == 18){
          loop.break()
        }
      }
    }

    println(n)
  }
}
