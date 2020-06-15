package com.uyibai.servicecomb.mall;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

/**
 * @Description: @TODO
 * @author: LiYang
 * @Email: lyflyyvip@163.com
 * @create: 2020-06-15 15:37
 **/
@Component
public class ConsumerReceive {
	
	@StreamListener("mall-cart-group")
	public void receiveConsumer(String receiveMsg) {
		System.out.println("mall-cart-group receive: " + receiveMsg);
	}
	
	
}
