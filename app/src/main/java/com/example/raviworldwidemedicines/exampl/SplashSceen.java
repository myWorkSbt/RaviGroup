package com.example.raviworldwidemedicines.exampl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.raviworldwidemedicines.R;

public class SplashSceen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_sceen);

        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent=new Intent(SplashSceen.this,MainActivity.class);
                startActivity(intent);
                finish();

            }
        },2000);


    }
}