package com.example.gta58.project_main;

/**
 * Created by gta58 on 2018-05-09.
 */

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

public class intro extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        Intro();
        loading();
        Handler handler = new Handler();
        LinearLayout layout1 = (LinearLayout) findViewById(R.id.layout1);
        final int[] a = {0};

        layout1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                a[0] = 1;
                Intent intent = new Intent(intro.this, MainActivity.class);

                startActivity(intent);
                finish();
                return false;
            }
        });


    if(a[0] == 0){
        handler.postDelayed(new Runnable() {
                @SuppressLint("ClickableViewAccessibility")
                public void run() {
                    if(a[0] == 0) {
                        Intent intent = new Intent(intro.this, MainActivity.class);

                        startActivity(intent);
                        finish();
                    }
                }
            }, 4000);
        }
    }

    void Intro() {
        ImageView intro_sun = (ImageView) findViewById(R.id.intro_sun);
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.sun);
        intro_sun.startAnimation(anim);
    }

    void loading(){
        final ImageView loading1 = (ImageView)findViewById(R.id.loading1);
        final TextView loading2 = (TextView) findViewById(R.id.loading2);

        Handler handler = new Handler();

        GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(loading1);
        Glide.with(this).load(R.drawable.loading).into(gifImage);

        handler.postDelayed(new Runnable() {
            public void run() {
                loading1.setVisibility(View.VISIBLE);
                loading2.setVisibility(View.VISIBLE);
            }
        }, 2000);
    }
}
