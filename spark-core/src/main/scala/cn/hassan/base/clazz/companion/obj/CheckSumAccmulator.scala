package cn.hassan.base.clazz.companion.obj

import clazz.companion.CheckSumAccmulator

/**
  * object 定义的是单例对象 相当java中的静态方法工具类
  *
  * 类和单例对象之间的差别是，单例对象不带参数，而类可以，因为单例对象不是用new关键字实例化的，
  */
object CheckSumAccmulator {

  private var cache = Map[String, Int]()

  def calculate(string: String):Int={
    if (cache.contains(string)) {
      cache(string)
    }else{
      val acc = new CheckSumAccmulator
      for (c<-string) {
        acc.add(c.toByte)
      }
      val cs = acc.checkSum()
      cache += (string -> cs)
      cs
    }
  }
}
