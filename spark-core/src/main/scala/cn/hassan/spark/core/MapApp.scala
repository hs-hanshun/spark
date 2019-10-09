package cn.hassan.spark.core

import org.apache.spark.{SparkConf, SparkContext}

object MapApp {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("map").setMaster("local[*]")
    val sc = new SparkContext(conf)

    val rdd = sc.parallelize(List(1,2,3,4,5,6))

    val result = rdd.map(mapFun)
    val ints = result.collect()
    println("-----------------")
    ints.foreach(print(_))
    println("-----------------")
  }

  def mapFun(num:Int):Int={
    num + 1
  }
}
