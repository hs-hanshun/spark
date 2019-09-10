package cn.hassan.base.method

object MapClass {

  def main(args: Array[String]): Unit = {
    iterateMap()
  }

  def map(): Unit = {
    var map = scala.collection.mutable.Map("hassan" -> 25,"sherry" -> 24)
    println(map.get("hassan"))
    map("sherry")=18
    println(map("sherry"))
  }

  def iterateMap():Unit={
    var map = Map("hassan" -> 25,"sherry" -> 18)
    for ((k,v) <- map){
      println(k + "---" + v)
    }
  }
}
