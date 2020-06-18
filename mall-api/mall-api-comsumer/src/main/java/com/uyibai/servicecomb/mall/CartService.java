package com.uyibai.servicecomb.mall;

import java.util.List;

/**
 * @Description: 购物车
 * @author: LiYang
 * @Email: lyflyyvip@163.com
 * @create: 2020-06-12 00:17
 **/
public interface CartService {
	
	
	/**
	 * 购物车中添加商品，返回当前购物车中所有商品
	 * @param obj
	 * @return
	 */
	List<Cart> add(String obj);
	
	
	/**
	 * 查询购物车
	 * @return
	 */
	List<Cart> list();
	
	
	/**
	 * 支付成功清空购物车
	 * @return
	 */
	List<Cart> clear();
	
}
