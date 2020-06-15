package com.uyibai.servicecomb.mall;

import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

/**
 * @Description: @TODO
 * @author: LiYang
 * @Email: lyflyyvip@163.com
 * @create: 2020-06-12 00:21
 **/
@RestSchema(schemaId = "cart-provider")
@RequestMapping(path = "/")
public class CartEndpoint {
	
	@Autowired
	private OrderService orderService;
	
	
	/**
	 * 付款（rocketmq分布式事务控制）
	 * 1。付款成功（provider 处理付款成功）
	 * 2。将商品从购物车中移除（consumer 处理清除购物车操作）
	 * @return
	 */
	@GetMapping(path = "pay", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object pay() {
		return orderService.pay();
	}
	
}
