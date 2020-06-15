package com.uyibai.servicecomb.mall;


import org.apache.servicecomb.springboot2.starter.EnableServiceComb;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * @Description: @TODO
 * @author: LiYang
 * @Email: lyflyyvip@163.com
 * @create: 2020-06-11 10:59
 **/
@SpringBootApplication
@EnableServiceComb
@EnableBinding({OrderProduce.class})
public class MainClass {
	public static void main(String[] args) throws Exception {
		try {
			SpringApplication.run(MainClass.class, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
