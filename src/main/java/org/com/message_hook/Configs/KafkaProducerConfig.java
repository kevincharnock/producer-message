package org.com.message_hook.Configs;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

//Criada na inicialização  do spring
@Configuration
public class KafkaProducerConfig {

    @Autowired
    private KafkaProperties kafkaProperties;

    //Injetando local da variavel como nome de topico
    @Value("${spring.kafka.topics.messaging.request.topic}")
    private String messageRequestTopic;

    @Bean
    public ProducerFactory<String, String> producerFactory(){
        Map<String, Object> properties = new HashMap<>();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        return new DefaultKafkaProducerFactory<>(properties);
    }

    //recebe o producerfactory pra inicializar a classe
    @Bean
    public KafkaTemplate<String, String> kafkaTemplate (){
        return new KafkaTemplate<>(producerFactory());
    }

    //Criando topico através da aplicação.
    @Bean
    public NewTopic messageRequestTopicBuilder(){
        return TopicBuilder
                .name(messageRequestTopic)
                .partitions(1)
                .replicas(1)
                .build();
    }

}


