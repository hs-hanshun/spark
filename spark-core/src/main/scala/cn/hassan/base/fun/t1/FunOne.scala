package cn.hassan.base.fun.t1

import scala.math.ceil

object FunOne {

  def main(args: Array[String]): Unit = {
    mulTest()
  }

  def mulTest():Unit ={
    val triple = mulBy(3)
    val half = mulBy(0.5)

    println(s"${triple(14)} ${half(14)}")
  }

  def mulBy(factor:Double) = (x : Double) => factor * x

  def startTest():Unit={
    (1 to 9).map("*" * _).foreach(println _)
  }

  def anoymousTest():Unit= {
    val  arr = Array(1, 2, 3)
    arr.map((x: Int) => 3 * x)
    for (i<- arr) {
      print(i)
    }
  }

  def ceilTest(): Unit ={
    val num = 3.14
    val fun = ceil _
    print(fun(num))
  }
}
