package com.uyibai.servicecomb.mall;


import org.apache.servicecomb.springboot2.starter.EnableServiceComb;
import org.springframework.boot.SpringApplication;
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
@EnableBinding({OrderProduce.class})
public class ProviderMainClass {
	public static void main(String[] args) throws Exception {
		try {
//			SpringApplication.run(ProviderMainClass.class, args);
			new SpringApplicationBuilder().web(WebApplicationType.NONE).sources(ProviderMainClass.class).run(args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
