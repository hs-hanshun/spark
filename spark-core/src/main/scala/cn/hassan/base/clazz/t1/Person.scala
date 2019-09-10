package cn.hassan.base.clazz.t1

import scala.beans.BeanProperty

class Person {
  var age = 0
  @BeanProperty var name: String = _
  override def toString: String ="name " + name + " age " + age
}
