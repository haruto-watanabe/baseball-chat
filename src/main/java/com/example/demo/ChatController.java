package com.example.demo;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    // 宛先を "/app/send/{gameId}" に変更
    @MessageMapping("/send/{gameId}")
    // 送り先も "/topic/messages/{gameId}" に変更
    @SendTo("/topic/messages/{gameId}")
    public String sendMessage(@DestinationVariable String gameId, String message) {
        // gameIdを受け取って、その試合の部屋にだけメッセージを流す
        return message;
    }
}
