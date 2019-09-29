package cn.hassan.spark.stream

import java.util.Properties

import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}

case class KafkaProductProxy(brokerList:String,productConfig:Properties = new Properties(),
                             defaultTopic:Option[String] = None,
                             producer:Option[KafkaProducer[String,String]] = None) {


  type Key = String
  type Val = String

  require(brokerList == null || !brokerList.isEmpty,"must set broker list")

  private val p = producer getOrElse {
    var props: Properties = new Properties()
    props.put("bootstrap.servers",brokerList)
    props.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer")
    props.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer")

    new KafkaProducer[String,String](props)
  }

  private def toMessage(value:Val,key: Option[Key] = None,topic: Option[String] = None):ProducerRecord[Key,Val] = {
    val t = topic.getOrElse(defaultTopic.getOrElse(throw new IllegalArgumentException("Must provide topic or default topic")))
    require(!t.isEmpty,"Topic must not be empty")
    key match {
      case Some(k) => new ProducerRecord(t,k,value)
      case _ => new ProducerRecord(t,value)
    }
  }

  def send(key: Key,value:Val,topic:Option[String] = None): Unit ={
    p.send(toMessage(value,Option(key),topic))
  }

  def send(value:Val,topic:Option[String]): Unit ={
    send(null,value,topic)
  }

  def send(value:Val,topic:String): Unit ={
    send(null,value,Option(topic))
  }

  def send(value:Val): Unit ={
    send(null,value,None)
  }

  def shutDown(): Unit = {
    p.close()
  }

  abstract class KafkaProducerFactory(brokerList: String,config:Properties,topic:Option[String] = None) extends Serializable {
    def newInstance() : KafkaProductProxy
  }

  class BaseKafkaProducerFactory(brokerList: String,config:Properties,topic:Option[String] = None)
    extends KafkaProducerFactory(brokerList,config,defaultTopic){
    override def newInstance() = new KafkaProductProxy(brokerList,config,defaultTopic)
  }
}
class KafkaConnectPool {
}
