package org.com.ms.message_producer.Controllers;

import org.com.ms.message_producer.Services.MessageService;
import org.com.ms.message_producer.Services.RabbitMQService;
import org.com.ms.message_producer.models.Dtos.MessageDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MessageController {

    MessageService messageService;
    RabbitMQService rabbitMQService;

    @PostMapping("/send-message")
    public ResponseEntity<MessageDTO> sendMessage(@RequestBody MessageDTO messageDTO){

        rabbitMQService.publishMessage(messageDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(messageService.sendAMessage(messageDTO));
    }


}
