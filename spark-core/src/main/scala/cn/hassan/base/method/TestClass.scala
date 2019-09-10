package cn.hassan.base.method

import scala.collection.mutable

object TestClass {

  def main(args: Array[String]): Unit = {
    zipTest()
  }

  def zipTest():Unit = {
    val arr1 = Array("<", "-", ">")
    val arr2 = Array(1, 2, 3)
    val array = arr1.zip(arr2)
    for (e <- array) {
      print(e + " ")
    }
  }

  def mapTest(): Unit ={
    var source = mutable.Map("hassan"->25,"sherry"->18,"scala"->23)
    source += ("spark"->26)
    println(source("spark"))
  }

  def arrayTest(args:Array[Int]): Unit ={
    val result = for (e <- args) yield 2*e
    for (e <- result) {
      print(e + " ")
    }
  }

  def voidTest(str:String): Unit ={
    println(str)
  }

  /**
    * 定义函数 如果不是递归则不需要指定返回值类型
    * @param n
    * @return
    */
  def fac(n:Int) = {
    var r = 1
    for (i <- 1 to n){
      r = r*i
    }
    r
  }

  def guardTest():Unit={
    for (ch  <- "=-3!") {

      var sign  = 0
      var digit = 0

      ch match {
        case '+' => sign = 1
        case '-' => sign = -1
        case _ if ch.toString.equals("3") => digit = 3
        case _ => sign = 0
      }

      println(ch + " " + sign + " " + digit)
    }
  }

  def switchTest():Unit={
    var result = 0
    val op: Char = '-'

    op match {
      case '+' => result = 1
      case '-' => result = -1
      case _ => result = 0
    }

    println(result)
  }
}
