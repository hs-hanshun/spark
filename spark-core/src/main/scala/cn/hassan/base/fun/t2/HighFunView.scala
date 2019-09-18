package cn.hassan.base.fun.t2

object HighFunView {
  def main(args: Array[String]): Unit = {

    val nums = (1 to 100).view.filter(eq)
    printf(nums + "")
    for (item <- nums){
      println(item + "")
    }
  }

  def multiple(num:Int):Int={
    num
  }

  def eq(num:Int):Boolean={
    printf("eq 被调用了")
    num.toString.equals(num.toString.reverse)
  }

}
