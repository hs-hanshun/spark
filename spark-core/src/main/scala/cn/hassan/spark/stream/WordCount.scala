package cn.hassan.spark.stream

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

object WordCount {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName("sparkStream").setMaster("local[*]")
    val ssc = new StreamingContext(sparkConf,Seconds(1))
    val line = ssc.textFileStream("/Users/hassan/develop/filedir/test")
    val words = line.flatMap(_.split(" "))

    val wordCount = words.map(x => (x,1)).reduceByKey(_+_)
    wordCount.print()
    ssc.start()
  }
}
