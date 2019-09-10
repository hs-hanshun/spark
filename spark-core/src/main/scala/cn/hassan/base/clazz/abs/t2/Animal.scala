package cn.hassan.base.clazz.abs.t2

abstract class Animal {

  //抽象字段
  var name:String
  //抽象字段
  var age:Int
  //普通字段
  var color:String="black"
  //抽象方法不需要abstract 只需要不下方法体即可
  def voice()
  //普通方法
  def sayHello(): Unit ={
    println("animal name is ---> " + name)
  }
}
