package cn.hassan.spark.core

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object SubtractApp extends App {
  val sparkConf = new SparkConf().setAppName("wordcount").setMaster("local[*]")
  val sparkContext = new SparkContext(sparkConf)
  val rddOne: RDD[Int] = sparkContext.parallelize(3 to 8)
  val rddTwo: RDD[Int] = sparkContext.parallelize(1 to 5)
  private val value: RDD[Int] = rddOne.subtract(rddTwo)
  for (elem <- value){
    println(elem)
  }
}
