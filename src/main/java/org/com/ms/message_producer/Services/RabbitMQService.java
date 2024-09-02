package org.com.ms.message_producer.Services;

import lombok.Builder;
import org.com.ms.message_producer.models.Dtos.MessageDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQService {

//Classe service onde é realizado o envio da mensagem.


    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public RabbitMQService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value(value = "${broker.queue.message.name}")
    private String routingKey;

    //Método para converter e enviar a mensagem

    public void publishMessage(MessageDTO message){
        rabbitTemplate.convertAndSend("",routingKey,message);
    }

}
