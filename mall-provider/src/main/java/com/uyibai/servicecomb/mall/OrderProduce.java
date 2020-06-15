package com.uyibai.servicecomb.mall;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @Description: @TODO
 * @author: LiYang
 * @Email: lyflyyvip@163.com
 * @create: 2020-06-15 14:54
 **/
public interface OrderProduce {
	
	@Output("mall-cart-group")
	MessageChannel sendCartMsg();
	
}
