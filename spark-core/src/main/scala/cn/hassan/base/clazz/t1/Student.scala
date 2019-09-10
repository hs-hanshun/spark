package cn.hassan.base.clazz.t1

class Student{
  private var name = "" // _ 表示给name一个默认值 如果是string类型 默认是""
  private var age = 0 // _ 表示给age一个默认值 如果是int类型 默认是0

  def this (name:String){
    this()
    this.name = name
  }

  def this(name:String,age:Int){
    this(name)
    this.age = age
  }

  override def toString: String = "name: " + name + ", age: " + age
}
