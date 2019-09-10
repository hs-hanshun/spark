package cn.hassan.base.fun.t2

object HighFunIterator {
  def main(args: Array[String]): Unit = {
    val iterator = List(1,2,3,4).iterator
    while(iterator.hasNext){
      print(iterator.next())
    }
    for (item <- iterator){
      println(item)
    }
  }
}
