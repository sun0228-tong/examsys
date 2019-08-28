package com.qfedu.examsys.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue simpleQueue(){
        // 创建一个消息队列对象，参数表示队列名称
        return new Queue("q_simple");
    }
}
