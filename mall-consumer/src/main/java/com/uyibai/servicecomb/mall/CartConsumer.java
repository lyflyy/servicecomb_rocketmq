package com.uyibai.servicecomb.mall;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

/**
 * @Description: @TODO
 * @author: LiYang
 * @Email: lyflyyvip@163.com
 * @create: 2020-06-15 15:52
 **/
public interface CartConsumer {
	
	@Input("mall-cart-group")
	MessageChannel log();

}
