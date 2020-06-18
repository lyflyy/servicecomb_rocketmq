package com.uyibai.servicecomb.mall;

import java.util.List;

/**
 * @Description: @TODO
 * @author: LiYang
 * @Email: lyflyyvip@163.com
 * @create: 2020-06-16 15:39
 **/
public interface ICartEndpoint {
	
	
	/**
	 * 查看购物车（查看consumer的购物车信息）
	 * @return
	 */
	Result<List<Cart>> list();
	
	/**
	 * 商品添加至购物车（consumer将商品添加至购物车）
	 * 四件商品支付的时候会失败
	 * 四件一下商品支付会成功
	 * @param name
	 * @return
	 */
	Result<List<Cart>> save(String name);
	
	
}
