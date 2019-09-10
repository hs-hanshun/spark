package cn.hassan.base.clazz.t1

object CounterTest {

  def main(args: Array[String]): Unit = {
    val counter = new Counter
    counter.increment()
    print(counter.current())
  }

}
