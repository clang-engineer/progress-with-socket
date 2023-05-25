package com.example.progresswithsocket.websocket;

import com.example.progresswithsocket.websocket.dto.FileCountDTO;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class WebSocketService {

  private final SimpMessagingTemplate messagingTemplate;

  public WebSocketService(SimpMessagingTemplate messagingTemplate) {
    this.messagingTemplate = messagingTemplate;
  }

  public void sendMessageToQueue(String userId, FileCountDTO fileCountDTO) {
    messagingTemplate.convertAndSendToUser(userId, "/queue/file-progress", fileCountDTO);
  }
}