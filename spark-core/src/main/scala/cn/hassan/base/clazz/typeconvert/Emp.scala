package cn.hassan.base.clazz.typeconvert

class Emp extends Person {
  override def printName(): Unit = {
    super.printName()
    sayHi()
  }

  def sayHello(): Unit = {
    println("sayHello")
  }
}
