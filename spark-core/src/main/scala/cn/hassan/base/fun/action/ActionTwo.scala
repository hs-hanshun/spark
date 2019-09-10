package cn.hassan.base.fun.action

object ActionTwo {
  def main(args: Array[String]): Unit = {
    val sentence = "AAAAAAAAAABBBBBBBBBCCCCDDDDDDD"
    val map = sentence.foldLeft(Map[Char,Int]())(charCount)
    println(map)
  }

  def charCount(map: Map[Char,Int],char: Char):Map[Char,Int]={
    map + (char ->(map.getOrElse(char,0) + 1))
  }
}
