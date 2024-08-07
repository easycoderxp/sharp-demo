package com.sharp.topic;

import com.sharp.constant.RabbitMqConstant;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * topic  通配符/主题模式-交换机和队列进行绑定，并且通配符方式routing key，当发送消息到交换机后，交换机会根据routing key将消息发送到对应的队列
 * 符合路由（routing key，通配符）的消费者收到
 *
 * @author xiap0308
 * @version v1.0.0
 * @since 2024-06-04 18:44:33
 */
@Component
public class ErrorLogConsumer {

    /**
     * 消息监听方法
     * bindings: 完成队列与交换机的绑定
     * Queue: 队列属性
     * exchange：交换机属性
     * key：路由key,通配符
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = RabbitMqConstant.TOPIC_ERROR_QUEUE, durable = "true"),// 队列
            exchange = @Exchange(name = RabbitMqConstant.TOPIC_EXCHANGE, type = ExchangeTypes.TOPIC),// 交换机
            key = {"*.log.error"}// 路由key,通配符
    ))
    public void handlerMessage(String msg) {
        System.out.println("log.error--->接受到的消息是：" + msg);
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
