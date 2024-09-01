package org.com.message_hook.Services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.com.message_hook.Configs.KafkaProducerConfig;
import org.com.message_hook.DTOS.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class MessagePublisherService {

    @Value("${spring.kafka.topics.messaging.request.topic}")
    private String messageRequestTopic;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    public String sendMessage(MessageDTO messageDTO) throws JsonProcessingException {
        String conteudo = objectMapper.writeValueAsString(messageDTO);
        kafkaTemplate.send(messageRequestTopic, conteudo);

        return "Mensagem enviada";

    }
}
