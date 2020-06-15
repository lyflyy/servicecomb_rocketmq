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
@RestSchema(schemaId = "cart-consumer")
@RequestMapping(path = "/")
public class CartEndpoint {
	
	@Autowired
	private CartService cartService;
	
	/**
	 * 查看购物车（查看consumer的购物车信息）
	 * @return
	 */
	@GetMapping(path = "list", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object list() {
		return cartService.list();
	}
	
	/**
	 * 商品添加至购物车（consumer将商品添加至购物车）
	 * @param name
	 * @return
	 */
	@GetMapping(path = "save", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object save(@RequestParam(name = "name") String name) {
		return cartService.add(name);
	}
	
}
