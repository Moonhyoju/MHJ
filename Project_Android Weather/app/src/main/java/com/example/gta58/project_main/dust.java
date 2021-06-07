package com.example.gta58.project_main;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class dust extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dust);
        setTitle("미세먼지");
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        Button btninfo = (Button)findViewById(R.id.btninfo);
        Intent mainvalue = getIntent();
        final String dust1 = mainvalue.getStringExtra("dust1");
        final String dust2 = mainvalue.getStringExtra("dust2");
        final String dust3 = mainvalue.getStringExtra("dust3");
        int intdust;
        TextView dusta, dustb, dusttx;
        LinearLayout dustbg;
        ImageView dustimg;

        intdust = Integer.parseInt(dust3);

        dustbg = (LinearLayout)findViewById(R.id.dustbg);
        dusttx = (TextView)findViewById(R.id.dusttx);
        dustimg = (ImageView)findViewById(R.id.dustimg);

        dusta = (TextView)findViewById(R.id.dusta);
        dustb = (TextView)findViewById(R.id.dustb);

        if(intdust <= 50){
            dustbg.setBackgroundColor(Color.parseColor("#E0FFFF"));
            dusttx.setText("좋음");
            dustimg.setImageResource(R.drawable.mask1);
        }
        else if((intdust > 50)||(intdust <= 100)){
            dustbg.setBackgroundColor(Color.parseColor("#FFEFD5"));
            dusttx.setText("보통");
            dustimg.setImageResource(R.drawable.mask2);
        }
        else if((intdust > 100)||(intdust <= 250)){
            dustbg.setBackgroundColor(Color.parseColor("#FFB6C1"));
            dusttx.setText("나쁨");
            dustimg.setImageResource(R.drawable.mask3);
        }
        else{
            dustbg.setBackgroundColor(Color.parseColor("#F08080"));
            dusttx.setText("매우 나쁨");
            dustimg.setImageResource(R.drawable.mask4);
        }


        dusta.setText(dust1);
        dustb.setText(dust2);

        btninfo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent info = new Intent(getApplicationContext(), info.class);

                startActivity(info);
            }
        });
    }
}
