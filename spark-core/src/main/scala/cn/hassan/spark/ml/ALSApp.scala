package cn.hassan.spark.ml

import org.apache.spark.mllib.recommendation.{ALS, MatrixFactorizationModel, Rating}
import org.apache.spark.{SparkConf, SparkContext}

object ALSApp {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("ALSApp").setMaster("local[*]")
    val sc = new SparkContext(conf)

    val path = Thread.currentThread().getContextClassLoader.getResource("data.txt").getPath

    val ratings = sc.textFile(path).map(_.split(",") match { case Array(user, item, rate) =>
      Rating(user.toInt, item.toInt, rate.toDouble)
    })
    val rank = 10
    val numIterations = 10
    val model = ALS.train(ratings,rank,numIterations,0.01)

    //准备用户数据
    val userProducts = ratings.map{case Rating(user,product,rate) =>
      (user,product)
    }

    //生成推荐结果
    val predicts = model.predict(userProducts).map{case Rating(user,product,rate) =>
      ((user,product),rate)
    }

    //对比结果
    val ratesAndPreds = ratings.map { case Rating(user, product, rate) =>
      ((user, product), rate)
    }.join(predicts)

    //生成均方误差
    val mse = ratesAndPreds.map{case ((user,product),(r1,r2)) =>
      println(s"[用户]: ${user}  [物品]: ${product}  [真实值]: ${r1}  [预测值]: ${r2}")
      val err = (r1 -r2)
      err*err
    }.mean()
    println("预测的均方误差为：" + mse)

    //保存模型
    //model.save(sc,"hdfs:/warehousr/alsmodel")
    //加载模型
    //val saveMoel = MatrixFactorizationModel.load(sc,"hdfs:/warehousr/alsmodel")

    sc.stop()
  }
}
