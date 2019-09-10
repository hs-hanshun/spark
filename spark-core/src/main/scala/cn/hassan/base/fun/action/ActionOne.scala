package cn.hassan.base.fun.action

import scala.collection.mutable.ArrayBuffer

object ActionOne {
  def main(args: Array[String]): Unit = {
    val sentence = "AAAAAAAAAABBBBBBBBBCCCCDDDDDDD"
    val arrayBuffer = new ArrayBuffer[Char]()
    sentence.foldLeft(arrayBuffer)(putArray)
    println(arrayBuffer)
  }

  def putArray(array:ArrayBuffer[Char],char: Char):ArrayBuffer[Char]={
    array.append(char)
    array
  }
}
