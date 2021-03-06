package cn.hassan.spark.kafka

import java.util.{Collections, Properties}

import cn.hassan.spark.kafka.interceptor.ProducerPrefixInterceptor
import org.apache.kafka.clients.consumer.{ConsumerConfig, KafkaConsumer}
import org.apache.kafka.clients.producer._
import org.apache.kafka.common.TopicPartition
import org.apache.kafka.common.serialization.{StringDeserializer, StringSerializer}

import scala.collection.JavaConversions._
import scala.util.control.Breaks._

object KafkaApp {
  def main(args: Array[String]): Unit = {
    //producer()
    //consumer()
    offSetFun()
  }

  /**
    * kafka 消费者
    */
  def consumer(): Unit ={
    val props = new Properties()
    props.put("bootstrap.servers","47.99.217.209:9092")
    props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
    props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
    props.put("group.id", "kafka-test")
    props.put("auto.offset.reset","earliest")
    props.put("enable.auto.commit", "true")//自动提交
    props.put("auto.commit.interval.ms", "1000")//每隔一秒 自动提交一次

    val consumer = new KafkaConsumer[String,String](props)
    consumer.subscribe(Collections.singletonList("kafka-test"))

    //val partitionInfoes = consumer.partitionsFor("kafka-test")

    while (true) {
      val records = consumer.poll(100)
      for (record <- records){
        println(record.offset() +"--" +record.key() +"--" +record.value())
      }
    }
    consumer.close()
  }

  /**
    * kafka生产者
    */
  def producer(): Unit ={
    val brokers_list = "47.99.217.209:9092"
    val topic = "kafka-test"
    val properties = new Properties()
    properties.put("group.id", "kafka-test")
    properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,brokers_list)
    properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, classOf[StringSerializer].getName) //key的序列化;
    properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, classOf[StringSerializer].getName)//value的序列化;
    properties.put(ProducerConfig.INTERCEPTOR_CLASSES_CONFIG,classOf[ProducerPrefixInterceptor].getName)//添加拦截器
    val producer = new KafkaProducer[String, String](properties)
    var num = 0
    for(i<- 1 to 5){
      producer.send(new ProducerRecord(topic,"topic"+i),new Callback(){
        override def onCompletion(metadata: RecordMetadata, exception: Exception): Unit = {
          if(exception != null){
            exception.printStackTrace()
          }else{
            println(metadata.topic() + ":" + metadata.partition() + ":" + metadata.hasOffset)
          }
        }
      })
    }
    producer.close()
  }

  /**
    * kafka offset 测试类
    */
  def offSetFun(): Unit ={
    val props = new Properties()
    props.put("bootstrap.servers","47.99.217.209:9092")
    props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
    props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
    props.put("group.id", "kafka-test")
    //props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,false)

    val consumer = new KafkaConsumer[String,String](props)

    val partition = new TopicPartition("kafka-test",0)
    consumer.assign(Collections.singleton(partition))

    var lastConsumerOffset = -1L

    breakable {
      while (true){
        val records = consumer.poll(1000)
        if (records.isEmpty){
          println("topic is null")
          break()
        }

        val partitionRecords = records.records(partition)

        for (record <- partitionRecords) {
          println(record.offset() +"--" +record.key() +"--" +record.value())
        }

        lastConsumerOffset = partitionRecords.get(partitionRecords.size() -1).offset()

        consumer.commitAsync()
      }
    }

    println("comsumed offset id " + lastConsumerOffset)
    val metadata = consumer.committed(partition)
    println("commint offset is " + metadata.offset())
    val position = consumer.position(partition)
    println("the offset of next record is " + position)
  }

  /**
    * kafka seek函数
    */
  def seekFun(): Unit ={
    val props = new Properties()
    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"47.99.217.209:9092")
    props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,classOf[StringDeserializer])
    props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,classOf[StringDeserializer])

    val consumer = new KafkaConsumer[String,String](props)
    consumer.subscribe(Collections.singletonList("kafka-test"))
    consumer.poll(1000)
    val assignment = consumer.assignment()

    for (partitin <- assignment){
      consumer.seek(partitin,10)
    }

    while (true) {
      val records = consumer.poll(1000)
    }


  }
}
