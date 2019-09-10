package cn.hassan.base.clazz.t1

class Counter {
  private var value = 0

  def increment(): Unit ={
    value += 1
  }

  def current()= {
    value
  }
}
