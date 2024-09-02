package org.com.ms.message_producer.models.Dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class MessageDTO {

    private String message;
    private UUID uuid;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime localDateTime;


    public MessageDTO() {
        this.uuid = UUID.randomUUID();
        this.localDateTime = LocalDateTime.now();
    }
}
