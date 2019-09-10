package cn.hassan.base.senior

object ParamterFun {
  def main(args: Array[String]): Unit = {
    def plus(x:Int) = x+3

    val result = Array(1,2,3,4,5).map(plus(_))
    println(result.mkString(","))
  }
}
