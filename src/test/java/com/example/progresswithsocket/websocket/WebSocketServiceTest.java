package com.example.progresswithsocket.websocket;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.example.progresswithsocket.websocket.dto.FileCountDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.messaging.simp.SimpMessagingTemplate;

class WebSocketServiceTest {

  @Mock
  private SimpMessagingTemplate messagingTemplate;

  private WebSocketService webSocketService;

  @BeforeEach
  void setup() {
    MockitoAnnotations.openMocks(this);
    webSocketService = new WebSocketService(messagingTemplate);
  }

  @Test
  void testSendMessageToQueue() {
    String userId = "userId";

    for (int i = 0; i < 10; i++) {

      FileCountDTO fileCountDTO = new FileCountDTO("fileId", 10, i);
      webSocketService.sendMessageToQueue(userId, fileCountDTO);
    }

    verify(messagingTemplate, times(10))
        .convertAndSendToUser(eq(userId), eq("/queue/file-progress"), any(FileCountDTO.class));
  }
}