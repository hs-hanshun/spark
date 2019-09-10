package cn.hassan.base.clazz.abs.t2

/**
  * 具体实现类需要实现抽象类的抽象属性和抽象方法
  */
class Dog extends Animal {
  override var name: String = _
  override var age: Int = _

  override def voice(): Unit = {
    println("wang wang wang")
  }
}
