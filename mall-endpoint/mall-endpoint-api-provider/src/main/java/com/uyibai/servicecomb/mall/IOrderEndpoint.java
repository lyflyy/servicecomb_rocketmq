package com.uyibai.servicecomb.mall;

import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description: @TODO
 * @author: LiYang
 * @Email: lyflyyvip@163.com
 * @create: 2020-06-16 15:45
 **/
public interface IOrderEndpoint {
	
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
	Result<String> pay(@RequestParam Integer num);
}
