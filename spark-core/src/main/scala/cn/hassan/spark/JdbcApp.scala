package cn.hassan.spark

import org.apache.spark.rdd.JdbcRDD
import org.apache.spark.{SparkConf, SparkContext}

object JdbcApp {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("jdbcApp")
    val sc = new SparkContext(sparkConf)

    val rdd = new JdbcRDD(
      sc,
      () => {
      Class.forName("com.mysql.jdbc.Driver").newInstance()
      java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","123")
    },
      "select * from book where b_id >= ? and b_id <= ?;",
      1,
      2,
      1,
      r => (r.getInt(1), r.getString(2))//查询结果集
    )

    println(rdd.count())
    rdd.foreach(println(_))
    sc.stop()
  }

  def insertIntoDB(iterable: Iterable[String]):Unit={
    Class.forName("com.mysql.jdbc.Driver").newInstance()
    val connection = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","123")
    for (elem <- iterable) {
      val statement = connection.prepareStatement("insert into book(name) values(?);")
      statement.setString(1,elem)
      statement.executeUpdate()
    }
  }
}
