package com.sharp.topic;

import com.sharp.constant.RabbitMqConstant;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author xiap0308
 * @version v1.0.0
 * @since 2024-06-04 18:49:21
 */
@Component
public class FullLogConsumer {

    /**
     * 消息监听方法
     * bindings: 完成队列与交换机的绑定
     * Queue: 队列属性
     * exchange：交换机属性
     * key：路由key,通配符
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = RabbitMqConstant.TOPIC_FULL_QUEUE, durable = "true"),// 队列
            exchange = @Exchange(name = RabbitMqConstant.TOPIC_EXCHANGE, type = ExchangeTypes.TOPIC),// 交换机
            key = {"#"}// 路由key,通配符
    ))
    public void handlerMessage(String msg) {
        System.out.println("log.full--->接受到的消息是：" + msg);
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
