package cn.hassan.base.fun.t2

object HighFunMap extends App {
  val list = List(1,2,3,4)
  val listThree = list :+ 5
  val listTwo = listThree.map(multiple)

  println(listTwo)

  def multiple(param:Int):Int={
    2*param
  }
}
