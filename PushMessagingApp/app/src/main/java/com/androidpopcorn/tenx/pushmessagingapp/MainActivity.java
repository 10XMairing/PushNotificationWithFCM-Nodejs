package com.androidpopcorn.tenx.pushmessagingapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{
            FirebaseMessaging.getInstance().subscribeToTopic("all").addOnCompleteListener(new OnCompleteListener<Void>() {
                 @Override
                    public void onComplete(@NonNull Task<Void> task) {
                    Toast.makeText(MainActivity.this, "Subscribed to topic 'all' ", Toast.LENGTH_SHORT).show();
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
