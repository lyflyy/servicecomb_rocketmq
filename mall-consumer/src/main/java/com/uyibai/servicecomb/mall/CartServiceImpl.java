package com.uyibai.servicecomb.mall;

import com.uyibai.servicecomb.mall.mapper.CartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: @TODO
 * @author: LiYang
 * @Email: lyflyyvip@163.com
 * @create: 2020-06-12 00:19
 **/
@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartMapper cartMapper;
	
	@Override
	public Cart add(String obj) {
		System.out.println("保存商品");
		Cart cart = new Cart();
		cart.setName(obj);
		cartMapper.insert(cart);
		return cart;
		
	}
	
	@Override
	public List<Cart> list() {
		return cartMapper.selectList(null);
	}
	
}
