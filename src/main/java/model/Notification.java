package model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Notification implements Serializable {
    private static final long serialVersionUID = 1L;
    private String message;
    private int recipientUserId;
    private LocalDateTime timestamp;
    private NotificationTypes type;

    public Notification(String message, int recipientUserId, LocalDateTime timestamp, NotificationTypes type) {
        this.message = message;
        this.recipientUserId = recipientUserId;
        this.timestamp = timestamp;
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public int getRecipientUserId() {
        return recipientUserId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public NotificationTypes getType() {
        return type;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public void setType(NotificationTypes type) {
        this.type = type;
    }

}
