package cn.hassan.spark

import org.apache.spark.{SparkConf, SparkContext}

object Application extends App {
  val sparkConf = new SparkConf().setAppName("wordcount").setMaster("local[*]")
  val sparkContext = new SparkContext(sparkConf)
  val textFile = sparkContext.textFile("hdfs:hadoop101:9000/warehouse/word.txt")
  val result = textFile.flatMap(_.split(" ")).map((_,1)).reduceByKey(_+_)
  result.saveAsTextFile("hdfs:hadoop101:9000/warehouse/word-result.txt")
  sparkContext.stop()
}
