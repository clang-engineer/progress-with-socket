package com.example.progresswithsocket.websocket;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
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
    String message = "Hello from server!";
    webSocketService.sendMessageToQueue();
    Mockito.verify(messagingTemplate).convertAndSend("/queue/reply", message);
  }
}