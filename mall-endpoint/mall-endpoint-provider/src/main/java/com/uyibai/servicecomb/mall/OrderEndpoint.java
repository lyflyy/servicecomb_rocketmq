package com.uyibai.servicecomb.mall;

import org.apache.servicecomb.provider.pojo.Invoker;
import org.apache.servicecomb.provider.pojo.RpcSchema;
import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

/**
 * @Description: @TODO
 * @author: LiYang
 * @Email: lyflyyvip@163.com
 * @create: 2020-06-12 00:21
 **/
@RpcSchema(schemaId = "cart-provider")
@RequestMapping(path = "/")
public class OrderEndpoint extends AbstractBaseController implements IOrderEndpoint{
	
	@Autowired
	private OrderService orderService;
	
	
	
	/**
	 * 付款（RocketMQ 分布式事务控制）
	 * 1。付款成功（provider 处理付款成功）
	 * 2。将商品从购物车中移除（consumer 处理清除购物车操作）
	 *
	 * 查询consumer的购物车中商品的数量，超过四件 调用rollback，否则支付成功
	 * 四件商品支付的时候会失败
	 * 四件一下商品支付会成功
	 * @return
	 */
	@Override
	@GetMapping(path = "pay", produces = MediaType.APPLICATION_JSON_VALUE)
	public Result<String> pay(@RequestParam Integer num) {
		return ok(orderService.pay(num));
	}
	
}
