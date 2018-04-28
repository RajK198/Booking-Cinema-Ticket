package com.code_revolution.yuknontoncinema;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import static android.view.animation.AnimationUtils.*;

public class SplashScreen extends AppCompatActivity {

    ImageView img;
    Animation fade_out, fade_in;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        img = (ImageView)findViewById(R.id.img);
        final LinearLayout test = (LinearLayout) findViewById(R.id.powered);

        fade_in = loadAnimation(getApplicationContext(),R.anim.fade_in);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                img.startAnimation(fade_in);
                img.setVisibility(View.VISIBLE);
                test.startAnimation(fade_in);
                test.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        },2000);
                    }
                },500);
            }
        },500);
    }
}
