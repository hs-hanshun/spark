package cn.hassan.spark.graph

import org.apache.spark.graphx.{Edge, Graph, VertexId}
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object GraphApp extends App {
  val conf = new SparkConf().setAppName("graph").setMaster("local[*]")
  val sc = new SparkContext(conf)

  val vertexRDD:RDD[(VertexId,(String,String))] = sc.parallelize(Array((3L,("rxin","stu")),(5L,("franklin","prof")),(7L,("jgonzal","post.doc")),(2L,("istoica","prof"))))

  val edgeRDD:RDD[Edge[String]] = sc.parallelize(Array(Edge(5L,3L,"Advisor"),Edge(3L,7L,"Collab"),Edge(5L,7L,"PI"),Edge(2L,5L,"Colleague")))

  val graphx = Graph(vertexRDD,edgeRDD)

  //提取属性
  //graphx.vertices.filter{case (id,(x,y)) => y == "prof"}

  val result = graphx.triplets.collect()

  for (item <- result){
    println(item.srcId + ":" + item.srcAttr + " ---> " + item.attr + " ---> " + item.dstId + ":" + item.dstAttr)
  }
}
