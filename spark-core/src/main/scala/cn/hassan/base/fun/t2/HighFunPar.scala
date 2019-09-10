package cn.hassan.base.fun.t2

object HighFunPar {
  def main(args: Array[String]): Unit = {
    //(1 to 5).foreach(println(_))
    //println()
    //(1 to 5).par.foreach(println(_))
    val distinct = (1 to 100).par.map{case _ => Thread.currentThread().getName}.distinct
    println(distinct)
  }
}
