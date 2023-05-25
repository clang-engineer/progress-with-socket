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

  public String getFileId() {
    return fileId;
  }

  public Integer getTotal() {
    return total;
  }

  public Integer getCurrent() {
    return current;
  }

  @Override
  public String toString() {
    return "FileCountDTO{" +
        "fileId='" + fileId + '\'' +
        ", total=" + total +
        ", current=" + current +
        '}';
  }
}
