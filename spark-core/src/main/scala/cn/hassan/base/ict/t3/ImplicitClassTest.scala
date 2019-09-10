package cn.hassan.base.ict.t3

object ImplicitClassTest {
  def main(args: Array[String]): Unit = {
    implicit class DBOne(val mySql: MySql){
      def addSuffix():String={
        mySql + "scala"
      }
    }

    val mySql = new MySql
    mySql.sayHello()
    val str = mySql.addSuffix()
    println(str)
  }
}
