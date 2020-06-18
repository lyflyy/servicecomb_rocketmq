package com.uyibai.servicecomb.mall.servicecomb;

import io.vertx.core.http.Cookie;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import org.apache.servicecomb.edge.core.AbstractEdgeDispatcher;
import org.apache.servicecomb.edge.core.EdgeInvocation;

import java.util.Map;

/**
 * @Description: @TODO
 * @author: LiYang
 * @Email: lyflyyvip@163.com
 * @create: 2020-06-11 10:41
 **/
public class ApiDispatcher extends AbstractEdgeDispatcher {
	@Override
	public int getOrder() {
		return 10002;
	}
	
	@Override
	public void init(Router router) {
		String regex = "/api/([^\\/]+)/(.*)";
		router.routeWithRegex(regex).handler(createBodyHandler());
		router.routeWithRegex(regex).failureHandler(this::onFailure).handler(this::onRequest);
	}
	
	protected void onRequest(RoutingContext context) {
		Map<String, String> pathParams = context.pathParams();
		String microserviceName = pathParams.get("param0");
		String path = "/" + pathParams.get("param1");
		
		EdgeInvocation invoker = new EdgeInvocation() {
			// Authentication. Notice: adding context must after setContext or will override by network
			@Override
			protected void setContext() throws Exception {
				super.setContext();
				// get session id from header and cookie for debug reasons
				String sessionId = context.request().getHeader("session-id");
				if (sessionId != null) {
					this.invocation.addContext("session-id", sessionId);
				} else {
					Cookie sessionCookie = context.cookieMap().get("session-id");
					if (sessionCookie != null) {
						this.invocation.addContext("session-id", sessionCookie.getValue());
					}
				}
			}
		};
		invoker.init(microserviceName, context, path, httpServerFilters);
		invoker.edgeInvoke();
	}
}
