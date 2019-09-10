package cn.hassan.base.fun.t2

object HighFunReduce {
  def main(args: Array[String]): Unit = {
    val list = List(1,2,3,4)
    val listName = list.reduceLeft(minus)
    printf("最终结果 ---> "+listName)
  }

  def sum(num1:Int,num2:Int):Int={
    num1+num2
  }

  def minus(num1:Int,num2:Int):Int={
    num1- num2
  }
}
