package cn.hassan.base.fun.t2

import scala.collection.mutable.ListBuffer

object HighFunFlatMap {
  def main(args: Array[String]): Unit = {
    var list = new ListBuffer[Int]
    list+=1
    list+=2
    list+=3
    println(list)

    val listTwo = List("hassan","sherry","mark")
    val value = listTwo.flatMap(upper)
    println(value)
  }

  def upper(param:String):String = {
    param.toUpperCase
  }
}
