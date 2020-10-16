package com.example.helloworld.utils;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;

import com.example.helloworld.R;

import static android.content.Context.NOTIFICATION_SERVICE;

/**
 * Project: HelloWorld
 * Package: com.example.helloworld.utils
 * <p>
 * User: dendy
 * Date: 16/10/2020
 * Time: 8:02
 * <p>
 * Description : BroadcastReciver
 */
public class BroadcastReciver extends BroadcastReceiver {
    private static final String TAG = BroadcastReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        final String action = intent.getAction();
        if (action.equals(WifiManager.NETWORK_STATE_CHANGED_ACTION)) {
            NetworkInfo info = intent.getParcelableExtra(WifiManager.EXTRA_NETWORK_INFO);
            boolean connected = info.isConnected();
            Log.i(TAG, "onReceive: EXTRA_NETWORK_INFO");
            String CHANNEL_ID = "MY_NOTIF_CHANNEL";
            //persiapakan channel
            NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID, "My channel", NotificationManager.IMPORTANCE_HIGH);
            //persiapkan notif manager
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
            //dibuat channelnya
            notificationManager.createNotificationChannel(mChannel);
            //presiapkan notifikasinya
            Notification notification = new NotificationCompat.Builder(context, CHANNEL_ID)
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setContentTitle("My Notification")
                    .setContentText("My Notification content")
                    .build();

            int notificationID = 0;
            notificationManager.notify(notificationID, notification);

        }
    }
}
