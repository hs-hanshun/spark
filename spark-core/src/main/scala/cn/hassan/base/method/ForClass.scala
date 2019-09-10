package cn.hassan.base.method

object ForClass {
  def main(args: Array[String]): Unit = {
    for (i <- 1 to 3;j <- 1 to 3){
      print(i*j+" ")
    }
    println()
    for (i <- 1 until 3;j <- 1 until 3) {
      print(i*j + " ")
    }
    println()

    for (i <- 1 to 3;if i!=2) {
      print(i+ " ")
    }
    println()

    val forFive = for(i <- 1 to 10) yield i
    println(forFive)

    var tuple1 = (1,2,3,"hassan")
    println(tuple1)
    println()

    for (e <- tuple1.productIterator){
      print(e)
    }
    println()

    val list = List(1,2)
    println(list)
  }
}
