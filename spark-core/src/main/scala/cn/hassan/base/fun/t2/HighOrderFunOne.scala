package cn.hassan.base.fun.t2

object HighOrderFunOne extends App {

  val result = test(sum,3.5)

  println(result)

  def test(f:Double => Double,param:Double)={
    f(param)
  }

  def sum(param:Double):Double={
    param+param
  }
}
