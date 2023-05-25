package com.example.progresswithsocket.websocket;

import com.example.progresswithsocket.websocket.dto.FileCountDTO;
import org.slf4j.Logger;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class WebSocketService {

  private static final Integer TOTAL_COUNT = 100;
  private Integer currentCount = 0;

  private final Logger log = org.slf4j.LoggerFactory.getLogger(WebSocketService.class);

  private final SimpMessagingTemplate messagingTemplate;

  public WebSocketService(SimpMessagingTemplate messagingTemplate) {
    this.messagingTemplate = messagingTemplate;
  }

  public void sendMessageToQueue(String userId, FileCountDTO fileCountDTO) {
    log.info("Sending message to user: {}, message: {}", userId, fileCountDTO);
    messagingTemplate.convertAndSendToUser(userId, "/queue/file-progress", fileCountDTO);
  }

  @Scheduled(fixedRate = 1000)
  public void send() {
    if (currentCount > TOTAL_COUNT) {
      return;
    }
    String userId = "test";
    String fileId = "fileId";
    FileCountDTO fileCountDTO = new FileCountDTO(userId, fileId, TOTAL_COUNT, currentCount++);
    sendMessageToQueue(userId, fileCountDTO);
  }
}