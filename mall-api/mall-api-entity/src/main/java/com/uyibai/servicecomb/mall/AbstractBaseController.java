package com.uyibai.servicecomb.mall;

import lombok.Data;

/**
 * @Description: @TODO
 * @author: LiYang
 * @Email: lyflyyvip@163.com
 * @create: 2020-06-16 17:15
 **/
public class AbstractBaseController<T> {
	
	protected  <T> Result ok(T obj){
		return new Result<T>(obj);
	}
	
	protected <T> Result fail(T obj){
		return new Result(obj, 500);
	}
}
