package com.uyibai.servicecomb.mall;

import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 * @Description: @TODO
 * @author: LiYang
 * @Email: lyflyyvip@163.com
 * @create: 2020-06-12 00:19
 **/
@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderProduce cartProduce;
	
	@Override
	public String pay(Integer num) {
		MessageBuilder builder = MessageBuilder.withPayload("pay success")
				.setHeader(RocketMQHeaders.TAGS, "cart-tag")
				.setHeader("TRANSACTION_FLAG", num)
				.setHeader(RocketMQHeaders.KEYS, "mall-cart-pay-key")
				.setHeader("DELAY", "1")
				;
		Message message = builder.build();
		cartProduce.sendCartMsg().send(message);
		return "pay success";
	}
}
