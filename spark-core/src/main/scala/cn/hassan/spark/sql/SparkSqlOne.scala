package cn.hassan.spark.sql

import org.apache.spark.sql.SparkSession
import org.slf4j.LoggerFactory

object SparkSqlOne {

  val logger = LoggerFactory.getLogger(SparkSqlOne.getClass)

  def main(args: Array[String]) {
    //创建SparkConf()并设置App名称
    val spark = SparkSession
      .builder()
      .appName("Spark SQL basic example")
      .config("spark.some.config.option", "some-value")
      .master("local[*]")
      .getOrCreate()

    // For implicit conversions like converting RDDs to DataFrames
    import spark.implicits._

    val df = spark.read.json("F:\\webupload\\people.json")

    // Displays the content of the DataFrame to stdout
    df.show()

    df.filter($"age" > 21).show()

    df.createOrReplaceTempView("persons")

    spark.sql("SELECT * FROM persons where age > 21").show()

    spark.stop()
  }
}
