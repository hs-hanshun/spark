package cn.hassan.spark

import org.apache.spark.{Partitioner, SparkConf, SparkContext}

class CustomerPartitioner(numParts:Int) extends Partitioner{

  override def numPartitions: Int = numParts

  override def getPartition(key: Any): Int = {
    val chkey:String = key.toString
    chkey.substring(chkey.length-1).toInt%numParts
  }
}

object CustomerPartitioner{
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("partition")
    val sc = new SparkContext(conf)
    val data = sc.parallelize(List("aa.2","bb.2","cc.3","dd.3","ee.5"))
    data.map((_,1)).partitionBy(new CustomerPartitioner(5)).keys.saveAsTextFile("hdfs://hadoop101:9000/warehouse/spark")
  }
}
