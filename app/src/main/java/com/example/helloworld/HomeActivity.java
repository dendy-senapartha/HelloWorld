package com.example.helloworld;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.helloworld.utils.BroadcastReciver;

/**
 * Project: HelloWorld
 * Package: com.example.helloworld
 * <p>
 * User: dendy
 * Date: 09/10/2020
 * Time: 7:54
 * <p>
 * Description : HomeActivity
 */
public class HomeActivity extends AppCompatActivity {

    private static final String TAG = HomeActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        String getExtra = getIntent().getStringExtra("COBA_INTENT_EXTRA");
        Log.i(TAG, "onCreate: " + getExtra);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragmentTop, new FragmentTop());
        fragmentTransaction.replace(R.id.fragmentBotom, new FragmentBottom());
        fragmentTransaction.commit();
    }

    protected void onResume() {
        super.onResume();
        Display display = ((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
        int rotation = display.getRotation();
        if (rotation == Surface.ROTATION_90 || rotation == Surface.ROTATION_270) {
            Log.i(TAG, "onResume: Landscape");
        } else {
            Log.i(TAG, "onResume: Portrait");
        }

    }
}
