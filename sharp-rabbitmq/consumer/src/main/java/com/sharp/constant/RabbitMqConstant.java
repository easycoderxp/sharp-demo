package com.sharp.constant;

/**
 * @author xiap0308
 * @version v1.0.0
 * @since 2024-06-04 18:05:35
 */
public class RabbitMqConstant {
    public static final String TOPIC_ACK_ACK_QUEUE = "topicAck-ack-queue";

    public static final String TOPIC_ACK_EXCHANGE = "topicAck-exchange";

    public static final String DEAD_QUEUE = "dead-queue";

    public static final String DEAD_EXCHANGE = "dead-exchange";

    public static final String DIRECT_ALL_QUEUE = "direct-all-queue";

    public static final String DIRECT_ERROR_QUEUE = "direct-error-queue";

    public static final String DIRECT_INFO_QUEUE = "direct-info-queue";

    public static final String DIRECT_EXCHANGE = "direct-exchange";

    public static final String FANOUT_SMS_QUEUE = "fanout-sms-queue";

    public static final String FANOUT_WX_QUEUE = "fanout-weixin-queue";

    public static final String FANOUT_EXCHANGE = "fanout-exchange";

    public static final String TOPIC_EXCHANGE = "topic-exchange";

    public static final String TOPIC_INFO_QUEUE = "topic-info-queue";
    public static final String TOPIC_ERROR_QUEUE = "topic-error-queue";
    public static final String TOPIC_FULL_QUEUE = "topic-full-queue";
}
