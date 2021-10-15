package com.istiaq66.admissionform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;

public class intro extends AppCompatActivity {

    private  static int SPLASH_TIME_OUT = 8000;

    ImageView Logo,Splash;
    LottieAnimationView lottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);




        Logo = findViewById(R.id.imageView3);
        Splash = findViewById(R.id.lottie);



        Splash.animate().translationX(1600).setDuration(2000).setStartDelay(4000);
        Logo.animate().translationX( -1600).setDuration(2000).setStartDelay(4000);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(intro.this,MainActivity.class);
                startActivity(intent);
            }
        },SPLASH_TIME_OUT);

    }
}