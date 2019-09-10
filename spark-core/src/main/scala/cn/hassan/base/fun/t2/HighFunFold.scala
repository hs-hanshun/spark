package cn.hassan.base.fun.t2

object HighFunFold {
  def main(args: Array[String]): Unit = {
    val list = List(1,2,3,4,5)
    println(list.foldLeft(5)(minus))

    printf("扫描的结果 ---> " + (1 to 5).scanLeft(5)(minus))
  }

  def minus(num1:Int,num2:Int):Int={
    num1 - num2
  }
}
