package cn.hassan.spark

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object ReduceApp extends App {
  val sparkConf = new SparkConf().setAppName("fun").setMaster("local[*]")
  val sparkContext = new SparkContext(sparkConf)
  private val rdd: RDD[(String, Int)] = sparkContext.parallelize(Array(("a",1),("a",3),("c",3),("d",5)))
  private val tuple: (String, Int) = rdd.reduce((x, y) => (x._1+y._1,x._2+y._2))
  println(tuple._1)
  println(tuple._2)
}
