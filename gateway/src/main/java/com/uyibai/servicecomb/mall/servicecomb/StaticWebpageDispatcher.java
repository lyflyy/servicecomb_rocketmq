package com.uyibai.servicecomb.mall.servicecomb;

import com.netflix.config.DynamicPropertyFactory;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.StaticHandler;
import org.apache.servicecomb.transport.rest.vertx.VertxHttpDispatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description: @TODO
 * @author: LiYang
 * @Email: lyflyyvip@163.com
 * @create: 2020-06-11 10:26
 **/
public class StaticWebpageDispatcher implements VertxHttpDispatcher {
	private static final Logger LOGGER = LoggerFactory.getLogger(StaticWebpageDispatcher.class);
	
	private static final String WEB_ROOT = DynamicPropertyFactory.getInstance()
			.getStringProperty("gateway.webroot", "/var/static")
			.get();
	
	@Override
	public int getOrder() {
		return 1;
	}
	
	@Override
	public void init(Router router) {
		String regex = "/ui/(.*)";
		StaticHandler webpageHandler = StaticHandler.create();
		webpageHandler.setWebRoot(WEB_ROOT);
		LOGGER.info("server static web page for WEB_ROOT={}", WEB_ROOT);
		router.routeWithRegex(regex).failureHandler((context) -> {
			LOGGER.error("error---:", context.failure());
		}).handler(webpageHandler);
	}
	
}
