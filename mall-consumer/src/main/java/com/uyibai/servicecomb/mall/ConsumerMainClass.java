package com.uyibai.servicecomb.mall;


import org.apache.servicecomb.springboot2.starter.EnableServiceComb;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * @Description: @TODO
 * @author: LiYang
 * @Email: lyflyyvip@163.com
 * @create: 2020-06-11 10:59
 **/
@SpringBootApplication
@EnableServiceComb
@EnableBinding(CartConsumer.class)
@MapperScan(basePackages = "com.uyibai.servicecomb.mall.mapper")
public class ConsumerMainClass {
	public static void main(String[] args) throws Exception {
		try {
//			SpringApplication.run(ConsumerMainClass.class, args);
			new SpringApplicationBuilder().web(WebApplicationType.NONE).sources(ConsumerMainClass.class).run(args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
