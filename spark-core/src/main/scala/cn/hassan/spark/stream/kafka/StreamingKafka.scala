package cn.hassan.spark.stream.kafka

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.spark.SparkConf
import org.apache.spark.streaming.kafka010.{ConsumerStrategies, HasOffsetRanges, KafkaUtils, LocationStrategies}
import org.apache.spark.streaming.{Seconds, StreamingContext}

object StreamingKafka extends App {

  val sparkConf = new SparkConf().setAppName("Kafka").setMaster("local[*]")

  val ssc = new StreamingContext(sparkConf,Seconds(1))

  //Kafka参数配置
  val topic = "log"
  val kafakParams = Map (
    ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG -> "47.99.217.209:9092",
    ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG -> classOf[StringDeserializer],
    ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG -> classOf[StringDeserializer],
    ConsumerConfig.GROUP_ID_CONFIG -> "kafka",
    //smallest 从头开始消费  latest从最新的地方开始消费
    ConsumerConfig.AUTO_OFFSET_RESET_CONFIG -> "latest",
    ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG -> (true: java.lang.Boolean)
  )

  val lines = KafkaUtils.createDirectStream(
    ssc,
    LocationStrategies.PreferConsistent,
    ConsumerStrategies.Subscribe[String,String](Iterable(topic),kafakParams)
  )

  lines.map(line => "*** : " + line).foreachRDD( rdd => {
    rdd.foreachPartition(items => {
      val pool = KafkaProxyPool("47.99.217.209:9092","log2")
      val kafkaProxy = pool.borrowObject()
      for (itme <- items){
        kafkaProxy.send("kafka",itme)
      }
      pool.returnObject(kafkaProxy)
    })
    //更新offset
    val offSetRanges = rdd.asInstanceOf[HasOffsetRanges].offsetRanges
  })

  ssc.start()
  ssc.awaitTermination()
}
