package com.example.helloworld;

import androidx.annotation.NonNull;
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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = LoginActivity.class.getSimpleName();

    private SharedPreferences mySharedPreferences;
    public static final String myPref = "MY_PREF";
    private EditText txtUsername;
    private EditText txtPassword;
    private Button btnLogin;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

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
//        testAddFirestore();
        testReadFirestore();
        mySharedPreferences = getSharedPreferences(myPref, Context.MODE_PRIVATE);
        Log.i(TAG, "onCreate: "+mySharedPreferences.getString(KEY_EMAIL, new String()));
    }


    private void onClickBtnLogin() {
        Toast.makeText(getApplicationContext(), "button login di tekan", Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(), txtUsername.getText(), Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(), txtPassword.getText(), Toast.LENGTH_LONG).show();
        SharedPreferences.Editor editor = mySharedPreferences.edit();
        editor.putString(KEY_EMAIL, txtUsername.getText().toString());
        editor.commit();

        startActivity(new Intent(this, HomeActivity.class));
    }

    private void testReadFirestore() {
        db.collection("users")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                            }
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });
    }

    private void testAddFirestore() {
       // Create a new user with a first and last name
        Map<String, Object> user = new HashMap<>();
        user.put("first", "Ada");
        user.put("last", "Lovelace");
        user.put("born", 1815);

        // Add a new document with a generated ID
        db.collection("users")
                .add(user)
                //input data secara async
                .addOnSuccessListener(
                        //implementasi callback
                        new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(
                        //callback apabila request gagal
                        new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });
    }
}