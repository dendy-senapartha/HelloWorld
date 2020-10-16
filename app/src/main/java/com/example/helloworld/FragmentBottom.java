package com.example.helloworld;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;

/**
 * Project: HelloWorld
 * Package: com.example.helloworld
 * <p>
 * User: dendy
 * Date: 09/10/2020
 * Time: 8:00
 * <p>
 * Description : FragmentBottom
 */
public class FragmentBottom extends Fragment {
    private static final String TAG = FragmentBottom.class.getSimpleName();
    Button btnNotifTrigger;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.e(TAG, "onCreateView: FragmentTop");
        View view = inflater.inflate(R.layout.fragment_bottom, container, false);
//        btnNotifTrigger = view.findViewById(R.id.btnLogin);
//        btnNotifTrigger.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onNotificationBtnClicked();
//            }
//        });
        return view;
    }

    private void onNotificationBtnClicked() {
        String CHANNEL_ID = "MY_NOTIF_CHANNEL";
        NotificationCompat.Builder builder = new NotificationCompat.Builder(requireContext(), CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("My Notification")
                .setContentText("My Notification content")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(requireContext());
        int notificationID = 1;
        notificationManager.notify(notificationID, builder.build());
    }
}
