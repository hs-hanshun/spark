package cn.hassan.base.clazz.typeconvert

object TypeConvert {
  def main(args: Array[String]): Unit = {
    println(classOf[String])
    val s = "hassan"
    println(s.getClass.getName)

    var person = new Person()
    var emp = new Emp()

    person = emp

    var  emp2 = person.asInstanceOf[Emp]
    emp2.sayHello()
  }
}
