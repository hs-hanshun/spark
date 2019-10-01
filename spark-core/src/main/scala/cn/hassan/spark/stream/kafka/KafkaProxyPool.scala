package cn.hassan.spark.stream.kafka

import java.util.Properties

import org.apache.commons.pool2.impl.{DefaultPooledObject, GenericObjectPool, GenericObjectPoolConfig}
import org.apache.commons.pool2.{BasePooledObjectFactory, PooledObject}
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerConfig, ProducerRecord}

//创建一个kafka的代理类
class KafkaProxy(brokenList:String,topic:String){

  private val producer = {
    //创建配置属性
    val property = new Properties()
    property.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, brokenList)
    property.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer")
    property.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer")
    //创建一个kafka的连接，第一个string是key的类型 第二个string是value的类型
    new KafkaProducer[String, String](property)
  }

  //封装send消息方法

  def send(key:String,value:String): Unit ={
    producer.send(new ProducerRecord[String,String](topic,key,value))
  }
}

class KafkaProxyFactory(brokenList:String,topic:String) extends BasePooledObjectFactory[KafkaProxy]{
  override def create(): KafkaProxy = new KafkaProxy(brokenList,topic)

  override def wrap(t: KafkaProxy): PooledObject[KafkaProxy] = new DefaultPooledObject[KafkaProxy](t)
}

/**
 * 如果需要使用KafkaProxy，通过 kafkaProxy.borrowObject()来获取
 * 中间写使用KafkaProxy对象的逻辑
 * 如果使用完毕那么需要将KafkaProxy对象归还,通过kafkaProxy.returnObject(KafkaProxy)来实现
 */
object KafkaProxyPool {

  //具体的池对象
  private var kafkaProxy: GenericObjectPool[KafkaProxy] = null

  //获取池对象
  def apply(brokenList:String,topic:String): GenericObjectPool[KafkaProxy] = {
    if(kafkaProxy == null){
      KafkaProxyPool.synchronized{
        val config = new GenericObjectPoolConfig
        config.setMaxTotal(16)
        config.setMaxIdle(8)
        config.setMinIdle(4)

        val poolFactory = new KafkaProxyFactory(brokenList,topic)

        kafkaProxy = new GenericObjectPool[KafkaProxy](poolFactory,config)
      }
    }
    kafkaProxy
  }
}
