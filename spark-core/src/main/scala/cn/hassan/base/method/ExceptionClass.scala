package cn.hassan.base.method

object ExceptionClass {
  def divider(x:Int,y:Int): Float = {
    if (y == 0)
      throw new Exception("除数不能为0!")
    else
      x/y
  }

  def main(args: Array[String]): Unit = {
    try{
      println(divider(10,0))
    }catch {
      case e:Exception => println("捕获了异常 ---> " + e.getMessage)
    }finally {}
  }
}
