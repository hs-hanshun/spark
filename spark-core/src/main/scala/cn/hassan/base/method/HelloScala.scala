package cn.hassan.base.method

object HelloScala {
  def main(args: Array[String]): Unit = {
    val arr1 = new Array[Int](5)
    arr1(1)=2
    arr1.update(1, 3)
    println(arr1.mkString(","))

    val map = Map("hassan" -> 25, "sherry" -> 24)
    println(map.get("hassan"))

    var n = 1
    val while1 = while (n < 10) {
      n+=1
    }

    println(while1)
    println(n)
  }
}
