package cn.hassan.base.method

/**
  * def 函数名(参数名:参数类型,参数名:参数类型): 返回类型 = {函数体}
  * 1,函数的形参列表可以是多个，如果函数没有形参，调用时可以不带()
  * 2,形参列表和返回值列表的数据类型可以是值类型和引用类型
  * 3,scala中的函数可以根据函数体最后一行代码自行推断函数返回值类型，在这种情况下 return关键字可以省略
  * 4,因为scala可以自行推断，所以在省略return关键字的场合，返回值类型也可以省略
  * 5,如果函数明确使用return关键字，那么函数返回就不能使用自行推断了，这时要明确写成 ：返回值类型=  如果不写返回的为()
  */
object FunctionClass {

  def main(args: Array[String]): Unit = {
    //shout("hassan")
    println(variableSum(1,2,3))
  }

  def shout(content:String): Unit = {
    println(content)
  }

  def sum(args:Int*): Int = {
    var result = 0
    for (arg <- args)
      result += arg
    result
  }

  def variableSum(arg:Int,args:Int*): Int = {
    var sum = arg
    println("sum --->" + sum)
    for (elem <- args) {
      sum += elem
    }
    return sum
  }
}
