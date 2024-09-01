package org.com.message_hook.DTOS;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

//Annotations
@Data
public class MessageDTO {

    private UUID uuid;
    private String message;
    private LocalDateTime dateTime;


    //Passando valores pelo construtor de forma automatica
    public MessageDTO() {
        this.uuid = UUID.randomUUID();
        this.dateTime = LocalDateTime.now();
    }
}
