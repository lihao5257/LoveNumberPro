package com.number.lover.configuration.rabbitmq.producer;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQBindingConfiguration {

    @Value("${routing.direct.1}")
    private String direct1RoutingKey;

    @Value("${routing.direct.2}")
    private String direct2RoutingKey;

    /*
     * @Value("${routing.topic.rabbitmq.#}") private String topicRabbitMQRoutingKey;
     * 
     * @Value("${routing.topic.rabbitmq.spring.#}") private String
     * topicRabbitMQSpringRoutingKey;
     */

    @Bean
    public Binding bindingDirectExchangeQueueADirect1(DirectExchange directExchange, Queue queueA) {
        System.out.println("binding a is created");
        return BindingBuilder.bind(queueA).to(directExchange).with(direct1RoutingKey);
    }

    @Bean
    public Binding bindingDirectExchangeQueueBDirect2(DirectExchange directExchange, Queue queueB) {
        return BindingBuilder.bind(queueB).to(directExchange).with(direct2RoutingKey);
    }

    /*
     * @Bean public Binding bindingTopicExchangeQueueCTopicRabbitMQ(TopicExchange
     * topicExchange, Queue queueC) { return
     * BindingBuilder.bind(queueC).to(topicExchange).with(topicRabbitMQRoutingKey);
     * }
     * 
     * @Bean public Binding
     * bindingTopicExchangeQueueDTopicRabbitMQSpring(TopicExchange topicExchange,
     * Queue queueD) { return BindingBuilder.bind(queueD).to(topicExchange).with(
     * topicRabbitMQSpringRoutingKey); }
     * 
     * @Bean public Binding bindingFanoutExchangeQueueEFanout(FanoutExchange
     * fanoutExchange, Queue queueE) { return
     * BindingBuilder.bind(queueE).to(fanoutExchange); }
     * 
     * @Bean public Binding bindingFanoutExchangeQueueFFanout(FanoutExchange
     * fanoutExchange, Queue queueF) { return
     * BindingBuilder.bind(queueF).to(fanoutExchange); }
     */

}
