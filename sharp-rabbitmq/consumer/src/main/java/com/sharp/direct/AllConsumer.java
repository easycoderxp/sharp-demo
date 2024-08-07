package com.sharp.direct;

import com.alibaba.fastjson.JSONObject;
import com.sharp.constant.RabbitMqConstant;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Routing 路由模式-交换机和队列进行绑定，并且指定routing key，
 * 当发送消息到交换机后，交换机会根据routing key将消息发送到对应的队列
 * 符合路由（routing key，固定）的消费者收到
 *
 * @author xiap0308
 * @version v1.0.0
 * @since 2024-06-04 18:24:15
 */
@Component
public class AllConsumer {

    /**
     * 消息监听方法
     * bindings: 完成队列与交换机的绑定
     * Queue: 队列属性
     * exchange：交换机属性
     * key：路由key
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = RabbitMqConstant.DIRECT_ALL_QUEUE, durable = "true"), // 队列
            exchange = @Exchange(name = RabbitMqConstant.DIRECT_EXCHANGE, type = ExchangeTypes.DIRECT),// 交换机
            key = {"info", "error"} // 路由key
    ))
    public void handlerMessage(String msg) {
        Person person = JSONObject.parseObject(msg, Person.class);
        System.out.println("all--->接受到的消息是：" + person.toString());
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}