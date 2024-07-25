package com.sharp.work;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author xiap0308
 * @version v1.0.0
 * @since 2024-06-04 18:53:22
 */
@Component
public class Consumer2 {

    /**
     * 消息监听方法
     * queuesToDeclare: 声明队列
     * durable: 是否为持久化队列
     */
    @RabbitListener(queuesToDeclare = @Queue(name = "work-queue", durable = "true"))
    public void handlerMessage(String msg) {
        System.out.println("=====消费者2: " + msg);
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //模拟消费失败，触发重试
//        int i = 1 / 0;
    }

}
