package cn.hassan.base.method

object TupleTest extends App {
  val tuple = (1, 2, 3, "hassan", 56.9)
  println(tuple)

  for (item <- tuple.productIterator){
    println(item)
  }
}
