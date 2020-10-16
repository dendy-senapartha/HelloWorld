package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.helloworld.utils.BroadcastReciver;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = LoginActivity.class.getSimpleName();

    private EditText txtUsername;
    private EditText txtPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate: dipanggil");
        Log.i(TAG, "onCreate: percobaan");
        setContentView(R.layout.activity_main);
        txtUsername = findViewById(R.id.txtUsername);
        txtPassword = findViewById(R.id.txtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickBtnLogin();
//                onNotificationBtnClicked();
            }
        });
        BroadcastReciver broadcastReciver =  new BroadcastReciver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION);
        this.registerReceiver(broadcastReciver, intentFilter);
    }

    private void onClickBtnLogin() {
        Toast.makeText(getApplicationContext(), "button login di tekan", Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(), txtUsername.getText(), Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(), txtPassword.getText(), Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, HomeActivity.class);
        intent.putExtra("COBA_INTENT_EXTRA", "Percobaan ");
        startActivity(intent);
    }

    private void onNotificationBtnClicked() {
        String CHANNEL_ID = "MY_NOTIF_CHANNEL";

        //persiapakan channel
        NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID, "My channel", NotificationManager.IMPORTANCE_HIGH);
        //persiapkan notif manager
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        //dibuat channelnya
        notificationManager.createNotificationChannel(mChannel);
        //presiapkan notifikasinya
        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("My Notification")
                .setContentText("My Notification content")
                .build();

        int notificationID = 0;
        notificationManager.notify(notificationID, notification);
    }
}