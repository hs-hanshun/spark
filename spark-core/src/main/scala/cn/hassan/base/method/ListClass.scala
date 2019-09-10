package cn.hassan.base.method

object ListClass {
  def main(args: Array[String]): Unit = {
    listTwo()
  }

  def listTwo():Unit ={
    val one = List(1, 2)
    val two = List(3, 4)
    val three = one ::: two

    println(three)
  }

  def listTest():Unit ={
    val list = List(1,2)
    println(list)

    println()

    for (e <- list.productIterator) {
      println(e)
    }
  }

}
