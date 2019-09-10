package cn.hassan.base.ict.t2

/**
  * 隐式值也叫隐式变量，将某个形参变量标记为implicit，所以编译器会在方法省略隐式参数的情况下 去搜索作用域内的隐式值作为参数
  */
object ImplicitValue {
  def main(args: Array[String]): Unit = {
    implicit val str:String = "hassan"

    def hello(implicit name:String):Unit={
      println(name + " hello")
    }

    hello
  }
}
