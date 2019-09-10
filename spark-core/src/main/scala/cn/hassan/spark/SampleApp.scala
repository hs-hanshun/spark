package cn.hassan.spark

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object SampleApp extends App {
  val sparkConf = new SparkConf().setAppName("wordcount").setMaster("local[*]")
  val sparkContext = new SparkContext(sparkConf)
  Seq
  val value: RDD[Int] = sparkContext.parallelize(1 to 10)
  val ints: Array[Int] = value.collect()
  for (elem <- ints) {
    println(elem)
  }
}
