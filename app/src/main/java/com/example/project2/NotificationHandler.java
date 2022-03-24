package com.example.project2;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;

import java.io.Serializable;

public class NotificationHandler implements Serializable {

    private NotificationChannel channel = null;
    private NotificationManager manager = null;
    private UserTable userTable = new UserTable();

    public NotificationHandler(Context context) {
        channel = new NotificationChannel(NotificationChannel.DEFAULT_CHANNEL_ID,
                "notifications", NotificationManager.IMPORTANCE_DEFAULT);
        manager = (NotificationManager) context.getSystemService(NotificationManager.class);
    }

    public NotificationChannel getChannel() { return channel; }

    public void notify(Event event, int type) {
        User u;
        if (type == 0) {
            Notification n = new Notification(event, event.getOwner(), 0, this);
            n.send();
        }
        else if (type == 1) {
            Notification n = new Notification(event, event.getOwner(), 1, this);
            n.send();
            for (String s : event.getParticipants()) {
                u = userTable.getUser(Integer.parseInt(s));
                Notification notif = new Notification(event, u, 1, this);
                notif.send();
            }
        }
        else if (type == 2) {
            for (String s : event.getParticipants()) {
                u = userTable.getUser(Integer.parseInt(s));
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
