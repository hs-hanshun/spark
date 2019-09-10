package cn.hassan.base.method

object FunctionLiteral {
  def main(args: Array[String]): Unit = {
    placeholder()
  }

  def placeholder():Unit= {
    val list = List(3, 8, 5, 10, 23)
    //val ints = list.filter(x => x > 10)
    val ints = list.filter(_ > 10)
    println(ints)
  }

  def literalTest():Unit={
    var increase = (x:Int) => x + 1
    println(increase(2))
  }
}
