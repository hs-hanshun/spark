package cn.hassan.base.ict.t1

/**
  * 隐式函数 是以implicit关键字为声明的带有单个参数的的函数，这种函数将会自动应用，将值从一种类型转换到另一种类型
  */
object ImplicitTest {

  def main(args: Array[String]): Unit = {

    implicit def doubleToInt(d:Double):Int={
      d.toInt
    }

    implicit def floatToInt(param:Float): Int = {
      param.toInt
    }

    val num:Int=3.5
    println("num =" + num)

    val numTwo = 4.5f
    println(numTwo)
  }
}
