package cn.hassan.spark.core

import org.apache.spark.{SparkConf, SparkContext}

object MapPartitionsFun {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("mapPartitions").setMaster("local[*]")
    val sc = new SparkContext(conf)

    val rdd = sc.parallelize(List(("kpop","female"),("zorro","male"),("mobin","male"),("lucy","female")))

    val result = rdd.mapPartitions(partitionsFun)
  }

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
