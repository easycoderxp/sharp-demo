package com.sharp.fanout;

import com.sharp.constant.RabbitMqConstant;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Fanout/subscribe发布订阅模式-生产者通过交换机,同时向多个消费者发送消息: 交换机模式采用(type=fanout)
 * 所有消费者都能收到消息
 *
 * @author xiap0308
 * @version v1.0.0
 * @since 2024-06-04 18:36:54
 */
@Component
public class SmsConsumer {

    /**
     * 消息监听方法
     * bindings: 完成队列与交换机的绑定
     * Queue: 队列属性
     * exchange：交换机属性
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = RabbitMqConstant.FANOUT_SMS_QUEUE, durable = "true"),
            exchange = @Exchange(name = RabbitMqConstant.FANOUT_EXCHANGE, type = ExchangeTypes.FANOUT)))
    public void handlerMessage(String msg) {
        System.out.println("发布订阅模式：fanout Sms接收到的消息是: " + msg);
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
