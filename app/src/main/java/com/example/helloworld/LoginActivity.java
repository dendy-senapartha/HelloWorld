package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = LoginActivity.class.getSimpleName();

    private SharedPreferences mySharedPreferences;
    public static final String myPref = "MY_PREF";
    private EditText txtUsername;
    private EditText txtPassword;
    private Button btnLogin;

    public static final String KEY_EMAIL = "KEY_EMAIL";

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
            }
        });
        mySharedPreferences = getSharedPreferences(myPref, Context.MODE_PRIVATE);
        Log.i(TAG, "onCreate: "+mySharedPreferences.getString(KEY_EMAIL, new String()));
    }

    private void onClickBtnLogin(){
        Toast.makeText(getApplicationContext(), "button login di tekan", Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(), txtUsername.getText(), Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(), txtPassword.getText(), Toast.LENGTH_LONG).show();
        SharedPreferences.Editor editor = mySharedPreferences.edit();
        editor.putString(KEY_EMAIL, txtUsername.getText().toString());
        editor.commit();

        startActivity(new Intent(this, HomeActivity.class));
    }
}