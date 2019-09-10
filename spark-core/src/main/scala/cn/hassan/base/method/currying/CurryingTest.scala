package cn.hassan.base.method.currying

object CurryingTest {
  def main(args: Array[String]): Unit = {

    println(twice(_ + 1,5))

  }

  def plainOldSum(x:Int,y:Int)= x+y

  def curryiedSum(x:Int)(y:Int) = x+y

  //柯里化的简单逻辑 就是调用两次函数
  def first(x:Int) = (y:Int) => x + y

  //双倍控制结构
  def twice(op:Double => Double,x:Double) = op(op(x))
}
