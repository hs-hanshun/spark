package cn.hassan.base.clazz.t1

class InitParams(name:String) {

  private var paramOne:String = _
  private var paramTwo:Int = _
  private var paramThree:Boolean = _

  try {
    paramOne = name
    paramTwo = 26
    paramThree = true
  }
}

object InitParams {
  def main(args: Array[String]): Unit = {
    val person = new InitParams("hassan")
    println(person.paramOne)
    println(person.paramTwo)
    println(person.paramThree)
  }
}