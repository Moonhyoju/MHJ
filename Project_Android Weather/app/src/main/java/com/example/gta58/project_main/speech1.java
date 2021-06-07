package com.example.gta58.project_main;

import android.content.Intent;
import android.graphics.Color;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;
import java.util.Locale;

public class speech1 extends AppCompatActivity implements TextToSpeech.OnInitListener{
    private TextToSpeech tts;



    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speech1);

        //넘겨진 데이터 받기
        final Intent mainvalue = getIntent();

        final String todayhigh = mainvalue.getStringExtra("todayhigh"); //오늘 최고기온
        final String todaylow = mainvalue.getStringExtra("todaylow");   //오늘 최저기온
        final String todaynow = mainvalue.getStringExtra("todaynow");   //현지 기온

        int intdust, intpty, intsky;
        final String duststate;
        String tomorrowstate = "맑음";


        final String Adust = mainvalue.getStringExtra("dust1");
        final String Bdust = mainvalue.getStringExtra("dust2");
        final String Cdust = mainvalue.getStringExtra("dust3");

        final String tomhigh = mainvalue.getStringExtra("tomhigh");
        final String tomlow = mainvalue.getStringExtra("tomlow");
        final String tompty = mainvalue.getStringExtra("tompty");
        final String tomsky = mainvalue.getStringExtra("tomsky");


        intdust = Integer.parseInt(Cdust);


        intpty = Integer.parseInt(tompty);
        intsky = Integer.parseInt(tomsky);
        if(intpty == 0){
            if(intsky == 1){
                tomorrowstate = "맑음";
            }
            else if((intsky == 2)){
                tomorrowstate = "구름 조금";
            }
            else if(intsky == 3){
                tomorrowstate = "구름 많음";
            }
            else if(intsky == 4){
                tomorrowstate = "흐림";
            }
        }
        else if((intpty == 1)||(intpty== 2)){
            tomorrowstate = "비";
        }
        else if(intpty == 3){
            tomorrowstate = "눈";
        }


        if(intdust < 51){
            duststate = "좋음";
        }
        else if((intdust > 50)||(intdust < 101)){
            duststate = "보통";
        }
        else if((intdust > 100)||(intdust < 251)){
            duststate = "나쁨";
        }
        else{
            duststate = "매우 나쁨";
        }

        ArrayList<Entry> entry4;
        BarDataSet setXcomp5;
        BarDataSet setXcomp6;
        ArrayList<String> labels;


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setCurrentItem(2);


        tts = new TextToSpeech(getApplicationContext(), this);

        final String finalTomorrowstate = tomorrowstate;
        mViewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            public void onPageSelected(int position){
                switch (position){
                    case 0:
                        BarChart chart2;
                        ArrayList<IBarDataSet> barDataSets1;
                        BarData barData1;

                        int inttodayhigh, inttodaylow, inttomhigh, inttomlow;
                        int subhigh, sublow, abshigh, abslow;
                        String A,B;

                        inttodayhigh = Integer.parseInt(todayhigh);
                        inttodaylow = Integer.parseInt(todaylow);
                        inttomhigh = Integer.parseInt(tomhigh);
                        inttomlow = Integer.parseInt(tomlow);
                        inttomhigh =26;
                        inttomlow =17;

                        subhigh = inttodayhigh - inttomhigh;
                        if(subhigh < 0){
                            A = "낮";
                        }
                        else {
                            A = "높";
                        }
                        abshigh = Math.abs(subhigh);

                        sublow = inttodaylow - inttomlow;
                        if(sublow < 0){
                            B = "낮";
                        }
                        else {
                            B = "높";
                        }
                        abslow = Math.abs(sublow);

                        chart2 = (BarChart) findViewById(R.id.chart2);
                        ArrayList<BarEntry> entry4 = new ArrayList<>();
                        entry4.add(new BarEntry(inttomhigh, 0));
                        entry4.add(new BarEntry(inttomlow, 1));


// create BarEntry for Bar Group 1
                        ArrayList<BarEntry> entry5 = new ArrayList<>();
                        entry5.add(new BarEntry(inttodayhigh, 0));
                        entry5.add(new BarEntry(inttodaylow, 1));


// creating dataset for Bar Group1
                        BarDataSet setXcomp5 = new BarDataSet(entry4, "어제");

//barDataSet1.setColor(Color.rgb(0, 155, 0));

                        setXcomp5.setColor(Color.rgb(255, 222, 222));



// creating dataset for Bar Group 2
                        BarDataSet setXcomp6 = new BarDataSet(entry5, "오늘");
                        setXcomp6.setColor(Color.rgb(255, 239, 222));

                        ArrayList<String> labels = new ArrayList<String>();
                        labels.add("최고 기온");
                        labels.add("최저 기온");


                        barDataSets1 = new ArrayList<IBarDataSet>();

                        barDataSets1.add(setXcomp5);
                        barDataSets1.add(setXcomp6);

// initialize the Bardata with argument labels and dataSet
                        barData1 = new BarData(labels, barDataSets1);
                        chart2.setData(barData1);
                        chart2.animateXY(2000, 2000); //애니메이션 기능 활성화

                        tts.setPitch(0f);
                        tts.speak("오늘날씨는 어제보다 최고기온이 "+abshigh+"℃"+A+"고 최저기온은"+abslow+"℃"
                                +B+"겠습니다.", TextToSpeech.QUEUE_FLUSH, null);

                        return;
                    case 1:
                        TextView dustnow1,dustnow2,dustnow3;

                        dustnow1 = (TextView)findViewById(R.id.dustnow1);
                        dustnow2 = (TextView)findViewById(R.id.dustnow2);
                        dustnow3 = (TextView)findViewById(R.id.dustnow3);

                        dustnow1.setText(duststate);
                        dustnow2.setText("미세 먼지   :  "+Adust);
                        dustnow3.setText("초미세 먼지 :  "+Bdust);
                        tts.setPitch(0f);
                        tts.speak("현재 미세먼지 상태는 "+duststate+"이고, 미세먼지 수치량은 "+Adust+
                                ", 초미세먼지 수치량은 "+Bdust+"입니다.", TextToSpeech.QUEUE_FLUSH, null);
                        return;
                    case 2:
                        TextView nowA, nowhigh, nowlow;

                        nowA = (TextView)findViewById(R.id.nowA);       //현재기온 텍스트
                        nowhigh = (TextView)findViewById(R.id.nowhigh);//최고기온 텍스트
                        nowlow = (TextView)findViewById(R.id.nowlow);   //최저기온 텍스트
                        //텍스트 값 세팅
                        nowA.setText(todaynow+"℃");
                        nowhigh.setText("최고 기온 :  "+todayhigh+" ℃");
                        nowlow.setText("최저 기온 :  "+todaylow+" ℃");

                        tts.setSpeechRate(0f);
                        tts.setPitch(1.0f);
                        tts.speak("현재 온도는 "+todaynow+"℃ 이고 오늘의 최고 기온은 " +todayhigh+"℃ 이며, 최저 기온은"
                                + todaylow+"℃ 입니다.", TextToSpeech.QUEUE_FLUSH, null);
                        return;
                    case 3:
                        TextView tomA, tomhigh1, tomlow1;

                        tomA = (TextView)findViewById(R.id.tomA);
                        tomhigh1 = (TextView)findViewById(R.id.tomhigh1);
                        tomlow1 = (TextView)findViewById(R.id.tomlow1);

                        tomA.setText(finalTomorrowstate);
                        tomhigh1.setText("최고 기온 :  "+tomhigh+" ℃");
                        tomlow1.setText("최저 기온 :  "+tomlow+" ℃");
                        tts.setPitch(0.5f);
                        tts.speak("내일의 날씨는 "+ finalTomorrowstate +"이고 최고 기온은 "+tomhigh+"℃ 이며 최저 기온은"+tomlow+"℃ 입니다.",
                                TextToSpeech.QUEUE_FLUSH, null);
                        return;
                }
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_speech1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            Intent main = new Intent(getApplicationContext(), MainActivity.class);

            startActivity(main);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onInit(int status) {

        final Intent mainvalue = getIntent();

        final String todayhigh = mainvalue.getStringExtra("todayhigh");
        final String todaylow = mainvalue.getStringExtra("todaylow");
        final String todaynow = mainvalue.getStringExtra("todaynow");
        TextView nowA, nowhigh, nowlow;

        nowA = (TextView)findViewById(R.id.nowA);
        nowhigh = (TextView)findViewById(R.id.nowhigh);
        nowlow = (TextView)findViewById(R.id.nowlow);

        nowA.setText(todaynow+"℃");
        nowhigh.setText("최고 기온 :  "+todayhigh+" ℃");
        nowlow.setText("최저 기온 :  "+todaylow+" ℃");

        if (status == TextToSpeech.SUCCESS)
        {
            tts.speak("",TextToSpeech.QUEUE_FLUSH,null);
            int result = tts.setLanguage(Locale.KOREA);

            tts.setSpeechRate(0f);
            tts.setPitch(1.0f);
            tts.speak("현재 온도는 "+todaynow+"℃ 이고 오늘의 최고 기온은 " +todayhigh+"℃ 이며, 최저 기온은"
                    + todaylow+"℃ 입니다.", TextToSpeech.QUEUE_FLUSH, null);

                if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "Language is not supported");
            }
        } else {
            Log.e("TTS", "Initilization Failed");
        }

    }
/*
    private void speakCompare()
    {
        tts.setPitch(0f);
        tts.speak("오늘날씨는 어제보다 최고기온이 "+"2℃"+"높고 "+"최저기온은"+"4℃"
                +"낮"+"겠습니다.", TextToSpeech.QUEUE_FLUSH, null);
    }
    private void speakDust()
    {
        tts.setPitch(0f);
        tts.speak("현재 미세먼지 상태는 "+"매우나쁨"+"이고, 미세먼지 수치량은 "+"89"+
                ", 초미세먼지 수치량은 "+"151"+"입니다.", TextToSpeech.QUEUE_FLUSH, null);
    }
    private void speakToday()
    {
        tts.setSpeechRate(0f);
        tts.setPitch(1.0f);
        tts.speak("현재 온도는 "+"21도"+" 이고 오늘의 최고 기온은 " +"27도"+" 이며, 최저 기온은"
                + "18도"+" 입니다.", TextToSpeech.QUEUE_FLUSH, null);

    }
    private void speakTomorrow()
    {
        tts.setPitch(0.5f);
        tts.speak("내일의 최고 기온은 "+"30도"+" 이며 최저 기온은"+"11도"+" 입니다.",
                TextToSpeech.QUEUE_FLUSH, null);
    }
*/
    protected void onDestroy() {
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }

    /**
     * A placeholder fragment containing a simple view.
     */


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(android.support.v4.app.FragmentManager fm)
        {

            super(fm);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {

            switch (position) {
                case 0:
                    return new Fragment4();
                case 1:
                    return new Fragment3();
                case 2:
                    return new Fragment1();
                case 3:
                    return new Fragment2();

                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            // Show 4 total pages.
            return 4;
        }
    }
}