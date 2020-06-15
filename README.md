

# 消息队列保证分布式事务


### provider
> 负责生产消息， 下单支付成功，做一些事情，发短信、处理订单等

### consumer
> 负责消费消息， 下单支付成功后，清空购物车，


## 分别演示两个场景
* 下单 -> provider发送半消息 -> 下单流程执行成功 -> commit -> consumer消费消息
* 下单 -> provider发送半消息 -> 下单流程执行失败 -> rollback -> consumer不能消费消息


