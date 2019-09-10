package cn.hassan.base.fun.t1

object Currying {
  def main(args: Array[String]): Unit = {
    threadTest()
  }

  def threadTest():Unit={
    runInThread{println("Hi");Thread.sleep(1000);println("Byte")}
  }

  def runInThread(block:  => Unit): Unit = {
    new Thread{
      override def run(): Unit = {
        block
      }
    }.start()
  }

  def curryTest():Unit = {
    val mul = (x:Int,y:Int) => x * y
    val mulOneAtTime = (x: Int) => (y: Int) => x * y
    def mulOneAtTimeTwo(x:Int)(y:Int) = x * y
    println(mulOneAtTime(6)(7))
  }
}
