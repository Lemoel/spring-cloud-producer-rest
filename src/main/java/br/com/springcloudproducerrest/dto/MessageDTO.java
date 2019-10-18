package br.com.springcloudproducerrest.dto;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.text.SimpleDateFormat;
import java.util.Date;


@FieldDefaults(level = AccessLevel.PRIVATE)
public class MessageDTO {

    String message;
    String timestamp;

    public MessageDTO() {
        this.message = "This is a custom message";
        this.timestamp = getActualTime();
    }

    public MessageDTO(String customMessage) {
        this.message = customMessage;
        this.timestamp = getActualTime();
    }

    private String getActualTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        return sdf.format(new Date(System.currentTimeMillis()));
    }

    public String getMessage() {
        return this.message;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public String getCompleteMessage() {
        return this.message + " sent at " + getActualTime();
    }
}
