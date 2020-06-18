package com.uyibai.servicecomb.mall;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description: @TODO
 * @author: LiYang
 * @Email: lyflyyvip@163.com
 * @create: 2020-06-16 17:15
 **/
@Data
public class Result<T> implements Serializable {
	
	private T data;
	
	private String msg;
	
	private Integer code;
	
	public Result(){}
	
	public Result(T data, String msg, Integer code){
		this.data = data;
		this.msg = msg;
		this.code = code;
	}
	
	public Result(T data, Integer code){
		this.data = data;
		this.code = code;
	}
	
	public Result(T data){
		this.data = data;
		this.code = 200;
	}
	
	public static <T> Result ok(T obj){
		return new Result(obj);
	}
	
	public static <T> Result fail(T obj){
		return new Result(obj, 500);
	}
}
