package cn.hassan.base.clazz.elem

abstract class Element {
  def contents: Array[String]
  //返回contents的行数
  val height = contents.length
  //返回第一行的长度
  val width = if (height == 0) 0 else contents(0).length
}
