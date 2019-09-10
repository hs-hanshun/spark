package cn.hassan.base.clazz.extend

object ExtendTest {
  def main(args: Array[String]): Unit = {
    var student = new Student
    student.name = "scala"
    student.age = 8
    student.sNo = 1
    println(student.toString)
  }
}
