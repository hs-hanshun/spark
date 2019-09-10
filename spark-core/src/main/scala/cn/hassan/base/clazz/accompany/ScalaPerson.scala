package cn.hassan.base.clazz.accompany

/**
  * 伴生类和对象
  */
class ScalaPerson {
  var name:String = _
}

object ScalaPerson {
  var sex:Boolean = true

  def sayHi():Unit ={
    println("boject ScalaPerson sayHi ...")
  }
}
