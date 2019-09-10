package cn.hassan.base.clazz.t1

object PersonTest {
  def main(args: Array[String]): Unit = {
    val person = new Person
    //print(person.age)
    person.age=25
    person.setName("hassan")
    person.name_=("sherry")
    person.name
    print(person)
  }
}
