package cn.hassan.spark.core

import org.apache.spark.{SparkConf, SparkContext}

object FlatMapApp {

  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName("flatMap").setMaster("local[*]")
    val sc = new SparkContext(sparkConf)

    val rdd = sc.parallelize(1 to 10)

    val result = rdd.flatMap(x => 1 to x)
    println("------------------")
    println(result.collect())
    println("------------------")
  }
}
