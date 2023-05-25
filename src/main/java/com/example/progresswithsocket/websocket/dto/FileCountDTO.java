package com.example.progresswithsocket.websocket.dto;

public class FileCountDTO {
  String fileId;
  Integer total;

  Integer current;

  public FileCountDTO(String fileId, Integer total, Integer current) {
    this.fileId = fileId;
    this.total = total;
    this.current = current;
  }
}
