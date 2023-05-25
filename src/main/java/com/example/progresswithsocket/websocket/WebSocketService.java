package com.example.progresswithsocket.websocket;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class WebSocketService {

  private final SimpMessagingTemplate messagingTemplate;

  public WebSocketService(SimpMessagingTemplate messagingTemplate) {
    this.messagingTemplate = messagingTemplate;
  }

  public void sendMessageToQueue() {
    String message = "Hello from server!";
    messagingTemplate.convertAndSend("/queue/reply", message);
  }
}