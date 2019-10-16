package cn.hassan.spark.ml

import java.util.logging.{Level, Logger}

import org.apache.spark.mllib.fpm.FPGrowth
import org.apache.spark.{SparkConf, SparkContext}

object FPGrowthApp extends App {

  //Logger.getLogger("org.apache.spark").setLevel(Level)
  val conf = new SparkConf().setAppName("FPGrowth").setMaster("local[*]")
  val sc = new SparkContext(conf)

  val path = Thread.currentThread().getContextClassLoader.getResource("fpgrowth.txt").getPath

  val data = sc.textFile(path).map(_.split(" ")).cache()
  //最小支持度
  val minSupport = 0.4
  //计算并行度
  val numPartition = 2

  val model = new FPGrowth()
    .setMinSupport(minSupport)
    .setNumPartitions(numPartition)
    .run(data)

  //打印训练结果
  println(s"top item: ${model.freqItemsets.count()}")
  model.freqItemsets.collect().foreach{items =>
    println(items.items.mkString("[",",","]")+ ", " + items.freq)
  }
}
