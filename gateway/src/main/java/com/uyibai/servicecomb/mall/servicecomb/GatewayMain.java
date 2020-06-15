package com.uyibai.servicecomb.mall.servicecomb;

import org.apache.servicecomb.springboot2.starter.EnableServiceComb;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
@EnableServiceComb
public class GatewayMain {
	public static void main(String[] args) throws Exception {
		try {
			new SpringApplicationBuilder().web(WebApplicationType.NONE).sources(GatewayMain.class).run(args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
