package com.uyibai.servicecomb.mall;

import java.util.List;

/**
 * @Description: 购物车
 * @author: LiYang
 * @Email: lyflyyvip@163.com
 * @create: 2020-06-12 00:17
 **/
public interface CartService {
	
	Cart add(String obj);
	
	List<Cart> list();
	
}
