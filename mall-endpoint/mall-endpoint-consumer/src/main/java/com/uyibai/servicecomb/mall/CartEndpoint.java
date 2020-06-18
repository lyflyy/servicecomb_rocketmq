package com.uyibai.servicecomb.mall;

import org.apache.servicecomb.provider.pojo.RpcSchema;
import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * @Description: @TODO
 * @author: LiYang
 * @Email: lyflyyvip@163.com
 * @create: 2020-06-12 00:21
 **/
@RestSchema(schemaId = "cart-consumer")
@RequestMapping(path = "/")
public class CartEndpoint extends AbstractBaseController implements ICartEndpoint {
	
	@Autowired
	private CartService cartService;
	
	/**
	 * 查看购物车（查看consumer的购物车信息）
	 * @return
	 */
	@Override
	@GetMapping(path = "list", produces = MediaType.APPLICATION_JSON_VALUE)
	public Result<List<Cart>> list() {
		return ok(cartService.list());
	}
	
	/**
	 * 商品添加至购物车（consumer将商品添加至购物车）
	 * 四件商品支付的时候会失败
	 * 四件一下商品支付会成功
	 * @param name
	 * @return
	 */
	@Override
	@GetMapping(path = "save", produces = MediaType.APPLICATION_JSON_VALUE)
	public Result<List<Cart>> save(@RequestParam(name = "name") String name) {
		return ok(cartService.add(name));
	}
	
}
