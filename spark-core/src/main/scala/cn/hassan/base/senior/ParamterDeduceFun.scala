package cn.hassan.base.senior

/**
 * 1,参数类型可以推断时，可以省略参数类型
 * 2,当传入的函数，只有单个参数时,可以省去括号
 * 3,如果变量在=>右边只出现一次，可以用_代替
 */
object ParamterDeduceFun {
  def main(args: Array[String]): Unit = {
    val list = List(1,2,3,4)
    println(list.map((x:Int)=>x+1))
    println(list.map((x)=>x+1))
    println(list.map(x => x + 1))
    println(list.map(_+1))

  }
}
