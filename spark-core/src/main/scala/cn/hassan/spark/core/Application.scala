package cn.hassan.spark.core

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Application extends App {
  val sparkConf = new SparkConf().setAppName("wordcount").setMaster("local[*]")
  val sparkContext = new SparkContext(sparkConf)
//  val textFile = sparkContext.textFile("hdfs://hadoop101:9000/warehouse/word.txt")
//  val result = textFile.flatMap(_.split(" ")).map((_,1)).reduceByKey(_+_)
//  result.saveAsTextFile("hdfs://hadoop101:9000/warehouse/word-result")
  val value: RDD[Int] = sparkContext.parallelize(1 to 5)
  private val result: RDD[Int] = value.flatMap(1 to _)
  private val array: Array[Int] = result.collect()
  for (elem <- array) {
    println("输出结果：" + elem)
  }
  sparkContext.stop()
}
