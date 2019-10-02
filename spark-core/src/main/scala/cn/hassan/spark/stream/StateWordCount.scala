package cn.hassan.spark.stream

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

object StateWordCount extends App {

  val sparkConf = new SparkConf().setAppName("state streaming").setMaster("local[*]")

  val ssc = new StreamingContext(sparkConf,Seconds(1))

  ssc.sparkContext.setCheckpointDir("hdfs://hadoop101/warehouse/statestreaming")

  val line = ssc.socketTextStream("hadoop101",9000)

  val words = line.flatMap(_.split(" "))

  val wordCount = words.map((_,1))

  val result = wordCount.reduceByKey(_ + _)

  val stateResult = result.updateStateByKey((items:Seq[Int],state:Option[Int]) => {
    Some(items.sum + state.getOrElse(0))
  })

  stateResult.print()

  ssc.stop()
  ssc.awaitTermination()
}
