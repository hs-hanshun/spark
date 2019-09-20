package cn.hassan.spark.core

import org.apache.spark.{SparkConf, SparkContext}

object AccumulatorApp {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName("partition").setMaster("local[*]")
    val sc = new SparkContext(sparkConf)
    val word = sc.textFile("F:\\webupload\\word.txt")

    val total = sc.accumulator(0)

    val unit = word.flatMap(line => {
      if (line == "") {
        total += 1
      }
      line.split(" ")
    })

    println(unit.count())
    println(total.value)
  }
}
