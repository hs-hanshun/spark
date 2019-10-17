package cn.hassan.spark.kafka.interceptor;

import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Map;

/**
 * Created with idea
 * Author: hss
 * Date: 2019/10/17 9:30
 * Description: 生产者拦截器
 */
public class ProducerPrefixInterceptor implements ProducerInterceptor {

	private volatile long sendSuccess = 0;
	private volatile long sendFailure = 0;

	public ProducerRecord onSend(ProducerRecord record) {
		String modifyValue = "prefix_" + record.value();
		return new ProducerRecord(record.topic(), record.partition(), record.timestamp(), record.key(), modifyValue, record.headers());
	}

	public void onAcknowledgement(RecordMetadata metadata, Exception exception) {
		if (exception == null) {
			sendSuccess++;
		}else {
			sendFailure++;
		}
	}

	public void close() {
		double successRat = (double) sendSuccess / (sendFailure + sendSuccess);
		System.out.println ("［ INFO ］发送成功率＝" + String.format ("%f" , successRat * 100));
	}

	public void configure(Map<String, ?> configs) {

	}
}
