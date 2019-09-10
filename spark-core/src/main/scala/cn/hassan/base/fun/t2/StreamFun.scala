package cn.hassan.base.fun.t2

object StreamFun {
  def main(args: Array[String]): Unit = {
    val stream = numsFormat(1)
    println(stream)
    println("head ---> " + stream.head)
    println("tail ---> " + stream.tail)
    println(stream)
  }

  def numsFormat(num:BigInt):Stream[BigInt] = num #:: numsFormat(num + 1)
}
