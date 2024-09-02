//package org.com.ms.message_producer.Services;
//
//
//import org.com.ms.message_producer.models.Dtos.MessageDTO;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@Service
//public class MessageService {
//
//    final RabbitMQService rabbitMQService;
//
//    public MessageService(RabbitMQService rabbitMQService) {
//        this.rabbitMQService = rabbitMQService;
//    }
//
//    @Transactional
//    public MessageDTO sendAMessage(MessageDTO messageDTO){
//        rabbitMQService.publishMessage(messageDTO);
//
//        return messageDTO;
//    }
//
//}
