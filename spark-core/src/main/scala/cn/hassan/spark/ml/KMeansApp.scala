package cn.hassan.spark.ml

import org.apache.spark.mllib.clustering.KMeans
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.{SparkConf, SparkContext}

object KMeansApp extends App {

  val conf = new SparkConf().setAppName("KMeansApp").setMaster("local[*]")
  val sc = new SparkContext(conf)

  val path = Thread.currentThread().getContextClassLoader.getResource("kmeans.txt").getPath

  val pareData = sc.textFile(path).map(s => Vectors.dense(s.split(",").map(_.toDouble))).cache()

  //通过kmeans将数据分给两个阵营
  val numCluster = 2
  val numIteations = 20
  val cluster = KMeans.train(pareData,numCluster,numIteations)

  //输出当前的聚类中心
  cluster.clusterCenters.foreach(println)

  //预测新的点
  val index = cluster.predict(Vectors.dense(Array(8.9,7.2,9.0)))
  println(s"sVectors.[8.9,7.2,9.0] 属于聚簇索引为 ${index} 中心坐标为：${cluster.clusterCenters(index)} 的簇")

  //计算误差平方和
  val kmeans = cluster.computeCost(pareData)
  println("误差平方和：" + kmeans)

  sc.stop()
}
