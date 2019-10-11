package cn.hassan.spark.sql

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SparkSession

case class Person(name: String, age: Long)

object LoadProperties {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("loadProperties").setMaster("local[*]")
    val sc = new SparkContext(conf)
    val spark = SparkSession.builder().config(conf).getOrCreate()

    val path = Thread.currentThread().getContextClassLoader.getResource("people.txt").getPath

    val rdd = sc.textFile(path)
    import spark.implicits._
    val peopleDF = rdd.map(_.split(",")).map(param => Person(param(0),param(1).toInt)).toDF()

    peopleDF.createOrReplaceTempView("people")

    val choice = spark.sql("select * from people where age > 27")

    choice.map(param => "Name: " + param(0)).show()
  }
}
