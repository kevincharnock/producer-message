package org.com.message_hook.Controllers;

import org.com.message_hook.DTOS.MessageDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MessageHookController {


    @PostMapping("/message")
    public MessageDTO messageDTOS(@RequestBody MessageDTO message){
        return message;
    }



}
