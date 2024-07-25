package com.sharp.direct;

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
 * @since 2024-06-04 18:27:19
 */
@Component
public class InfoConsumer {

    /**
     * 消息监听方法
     * bindings: 完成队列与交换机的绑定
     * Queue: 队列属性
     * exchange：交换机属性
     * key：路由key
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = RabbitMqConstant.DIRECT_INFO_QUEUE, durable = "true"), // 队列
            exchange = @Exchange(name = RabbitMqConstant.DIRECT_EXCHANGE, type = ExchangeTypes.DIRECT),// 交换机
            key = {"info"} // 路由key
    ))
    public void handlerMessage(String msg) {
        System.out.println("info--->接受到的消息是：" + msg);
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
