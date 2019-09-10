package cn.hassan.base.matchers

object MatchTest {
  def main(args: Array[String]): Unit = {
    val oper = "+"
    val numOne = 20
    val numTwo = 30
    var result = 0

    oper match {
      case "+" => result = numOne + numTwo
      case "-" => result = numOne - numTwo
      case "*" => result = numOne * numTwo
      case "/" => result = numOne / numTwo
      case _ => println("没有找到匹配的结果")
    }

    println(result)
  }
}
