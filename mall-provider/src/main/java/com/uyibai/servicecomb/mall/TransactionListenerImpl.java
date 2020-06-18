package com.uyibai.servicecomb.mall;

import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.apache.servicecomb.provider.pojo.Invoker;
import org.springframework.messaging.Message;

import java.util.List;


/**
 *
 */
@RocketMQTransactionListener(txProducerGroup = "mall-cart-group", corePoolSize = 5,
		maximumPoolSize = 10)
public class TransactionListenerImpl implements RocketMQLocalTransactionListener {
	
	ICartEndpoint cartEndpoint = Invoker.createProxy("mall-consumer", "cart-consumer", ICartEndpoint.class);

	@Override
	public RocketMQLocalTransactionState executeLocalTransaction(Message msg,
	                                                             Object arg) {
		// 与 OrderServiceImpl#pay 中定义的headerkey要相同
		
		Result<List<Cart>> list = cartEndpoint.list();
		System.out.println("提交半消息后，查询商品个数为：" + list.getData().size());
		
		if(list.getData().size() == 4){
			return RocketMQLocalTransactionState.UNKNOWN;
		}else if(list.getData().size() >= 5){
			return RocketMQLocalTransactionState.ROLLBACK;
		}else{
			return RocketMQLocalTransactionState.COMMIT;
		}
	}

	@Override
	public RocketMQLocalTransactionState checkLocalTransaction(Message msg) {
		System.out.println("check: " + msg.getPayload());
		System.out.println("在这可以根据msg的具体内容去查询数据库或者其他操作决定是回滚还是提交还是未知，一分钟后重新查询");
		return executeLocalTransaction(msg, null);
	}

}
