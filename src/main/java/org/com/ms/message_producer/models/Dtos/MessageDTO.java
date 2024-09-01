package org.com.ms.message_producer.models.Dtos;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class MessageDTO {

    private String message;
    private UUID uuid;
    private LocalDateTime localDateTime;


    public MessageDTO() {
        this.uuid = UUID.randomUUID();
        this.localDateTime = LocalDateTime.now();
    }
}
