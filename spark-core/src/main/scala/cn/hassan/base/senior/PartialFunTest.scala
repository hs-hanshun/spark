package cn.hassan.base.senior

object PartialFunTest {
  def main(args: Array[String]): Unit = {
    val list = List(1,2,3,4,"hello")



    /**
     * 表示接收的Any类型返回的是int类型
     */
    val partialFun = new PartialFunction[Any,Int] {

      /**
       * 如果返回true就去调用apply方法，如果是false就过滤掉
       * @param x
       * @return
       */
      override def isDefinedAt(x: Any): Boolean = {
        println("item --->",x)
        x.isInstanceOf[Int]
      }

      /**
       * 逻辑操作
       * @param v1
       * @return
       */
      override def apply(v1: Any): Int = {
        println("value ---> " + v1)
        v1.asInstanceOf[Int] + 1
      }
    }

    def partialFunTwo:PartialFunction[Any,Int] = {
      case i:Int => i+1
      case j:Double => (j*2).toInt
    }

    /**
     * 调用使用collect 需要放在偏函数后使用
     */
    val lists = list.collect(partialFun)
    println(lists)

    val listTwo = List(1,2.3,4,"hassan")
    val result = listTwo.collect(partialFunTwo)
    println(result)
  }
}
