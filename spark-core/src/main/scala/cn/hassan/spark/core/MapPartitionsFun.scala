package cn.hassan.spark.core

import org.apache.spark.{SparkConf, SparkContext}

object MapPartitionsFun {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("mapPartitions").setMaster("local[*]")
    val sc = new SparkContext(conf)

    val rdd = sc.parallelize(List(("kpop","female"),("zorro","male"),("mobin","male"),("lucy","female")))

    val result = rdd.mapPartitions(partitionsFun)
  }

  /**
    * x::list,其中x为加入到头部的元素，无论x是列表与否，它都只将成为新生成列表的第一个元素，也就是说新生成的列表长度为list的
    * 长度＋1(btw, x::list等价于list.::(x))
    *
    *  :+和+: 两者的区别在于:+方法用于在尾部追加元素，+:方法用于在头部追加元素，和::很类似，但是::可以用于pattern match ，
    *  而+:则不行. 关于+:和:+,只要记住冒号永远靠近集合类型就OK了。
    *
    * ++ 该方法用于连接两个集合，list1++list2
    *
    * ::: 该方法只能用于连接两个List类型的集合
    *
    * @param iter
    * @return
    */
  def partitionsFun(iter : Iterator[(String,String)]) : Iterator[String] = {
    var result = List[String]()
    while (iter.hasNext){
      val param = iter.next()
      param match {
        case (_,"female") => result = param._1::result
      }
    }
    result.iterator
  }
}
