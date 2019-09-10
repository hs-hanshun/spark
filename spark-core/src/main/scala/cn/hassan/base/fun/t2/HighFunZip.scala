package cn.hassan.base.fun.t2

object HighFunZip {
  def main(args: Array[String]): Unit = {
    val listOne = List(1,2,3)
    val listTwo = List(4,5,6)

    val listThree = listOne.zip(listTwo)
    println(listThree)
  }
}
