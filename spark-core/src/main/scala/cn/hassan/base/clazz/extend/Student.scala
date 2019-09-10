package cn.hassan.base.clazz.extend

class Student extends Person {
  var sNo = 0

  override def toString: String = "name: " + name + " , age: " + age + " , sNo: " + sNo
}
