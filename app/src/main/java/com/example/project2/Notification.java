package com.example.project2;

import androidx.core.app.NotificationCompat;

public class Notification {

    private User recipient;
    private Event event;
    private String message;
    private NotificationHandler notificationHandler;
    private String[] typeToMessage = { "A new participant has joined your event, ",
            " is scheduled for ", "Changes have been made to the event you joined, ",
            "A participant has withdrawn from your event, " };

    public Notification(Event event, User recipient, int type, NotificationHandler notificationHandler) {
        this.recipient = recipient;
        this.event = event;
        if (type == 1) {
//            this.message = event.getEventName() + typeToMessage[type] + event.getFinalTime();
        }
        else {
            this.message = typeToMessage[type] + event.getEventName();
        }
    }

    public void send() {

    }

}
