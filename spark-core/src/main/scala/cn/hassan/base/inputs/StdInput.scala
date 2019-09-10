package cn.hassan.base.inputs

import scala.io.StdIn

object StdInput {
  def main(args: Array[String]): Unit = {
    println("enter name")
    val name = StdIn.readLine()
    println("your name is " + name)
  }
}
