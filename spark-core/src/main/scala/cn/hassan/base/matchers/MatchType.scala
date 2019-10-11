package cn.hassan.base.matchers

object MatchType {
  def main(args: Array[String]): Unit = {
    val a = 8
    val obj = if (a ==1) 1
    else if (a == 2) "2"
    else if (a ==3) BigInt(3)
    else if (a ==4) Map("aa" -> 1)
    else if (a ==5) Map(1 -> "aa")
    else if (a == 6) Array(1,2,3)
    else if (a ==7) Array("aa",1)
    else if (a ==8) Array("aa")

    /**
      * 根据obj的类型来匹配返回值
      */
    val result = obj match {
      case a:Int => println("object ---> Int")
      case b:Map[String,Int] => println("object ---> Map[String,Int]")
      case c:Map[Int,String] =>println("object ---> Map[Int,String]")
      case d:Array[String] =>println("object ---> Array[String]")
      case e:Array[Int] =>println("object ---> Array[Int]")
      case f:BigInt =>println("object ---> BigInt")
      case _ =>println("object ---> not right")
    }
  }
}
