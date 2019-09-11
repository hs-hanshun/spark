package cn.hassan.spark

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

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
