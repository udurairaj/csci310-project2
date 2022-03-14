package com.example.project2;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;

public class NotificationHandler {

    private NotificationChannel channel = null;
    private NotificationManager manager = null;

    public NotificationHandler(Context context) {
        channel = new NotificationChannel(NotificationChannel.DEFAULT_CHANNEL_ID,
                "notifications", NotificationManager.IMPORTANCE_DEFAULT);
        manager = (NotificationManager) context.getSystemService(NotificationManager.class);
    }

    public NotificationChannel getChannel() { return channel; }

    public void notify(Event event, int type) {
        if (type == 0) {
            Notification n = new Notification(event, event.getOwner(), 0, this);
            n.send();
        }
        else if (type == 1) {
            Notification n = new Notification(event, event.getOwner(), 1, this);
            n.send();
            for (User u : event.getParticipants()) {
                Notification notif = new Notification(event, u, 1, this);
                notif.send();
            }
        }
        else if (type == 2) {
            for (User u : event.getParticipants()) {
                Notification notif = new Notification(event, u, 2, this);
                notif.send();
            }
        }
        else if (type == 3) {
            Notification n = new Notification(event, event.getOwner(), 3, this);
            n.send();
        }
    }

}
