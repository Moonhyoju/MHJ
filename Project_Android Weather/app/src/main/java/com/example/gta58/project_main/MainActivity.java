package com.example.gta58.project_main;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.BaseMovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class MainActivity extends AppCompatActivity {

    String key = "GkFQO5S7NHYBqTB9SGpUgh%2FrRH5kOtdHoY62bXBHu101HDfVbi%2FPfbvad90yKJ%2BzohkF4QmiVEX78LSHALT0FA%3D%3D";
    //현재 년도, 월, 일
    Date day = new Date();
    SimpleDateFormat form1 = new SimpleDateFormat("yyyyMMdd");
    SimpleDateFormat form2 = new SimpleDateFormat("HHmm");

    String today = form1.format(day);
    String time = form2.format(day);

    GregorianCalendar today1 = new GregorianCalendar ( );


    int yoil = today1.get(today1.DAY_OF_MONTH) - 1;
    int yoil1 = today1.get(today1.DAY_OF_MONTH);
    TextView now1,now2,now3,now4,now5,now6;

    private String dust = "https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=%EC%95%88%EC%96%91%EC%8B%9C+%EB%AF%B8%EC%84%B8%EB%A8%BC%EC%A7%80+%EB%86%8D%EB%8F%84";
    private String todaytem1 = "http://newsky2.kma.go.kr/service/SecndSrtpdFrcstInfoService2/ForecastSpaceData?serviceKey="+key+"&base_date=201806"+yoil+"&base_time=2000&nx=59&ny=123&numOfRows=10&pageSize=10&pageNo=1&startPage=1&_type=xml";    //00시
    private String todaytem2 = "http://newsky2.kma.go.kr/service/SecndSrtpdFrcstInfoService2/ForecastSpaceData?serviceKey="+key+"&base_date=201806"+yoil+"&base_time=2000&nx=59&ny=123&numOfRows=10&pageSize=10&pageNo=2&startPage=1&_type=xml";    //03시
    private String todaytem3 = "http://newsky2.kma.go.kr/service/SecndSrtpdFrcstInfoService2/ForecastSpaceData?serviceKey="+key+"&base_date=201806"+yoil+"&base_time=2000&nx=59&ny=123&numOfRows=10&pageSize=10&pageNo=3&startPage=1&_type=xml";    //06시
    private String todaytem4 = "http://newsky2.kma.go.kr/service/SecndSrtpdFrcstInfoService2/ForecastSpaceData?serviceKey="+key+"&base_date=201806"+yoil+"&base_time=2000&nx=59&ny=123&numOfRows=10&pageSize=10&pageNo=4&startPage=1&_type=xml";    //09시
    private String todaytem5 = "http://newsky2.kma.go.kr/service/SecndSrtpdFrcstInfoService2/ForecastSpaceData?serviceKey="+key+"&base_date=201806"+yoil+"&base_time=2000&nx=59&ny=123&numOfRows=10&pageSize=10&pageNo=5&startPage=1&_type=xml";    //12시
    private String todaytem6 = "http://newsky2.kma.go.kr/service/SecndSrtpdFrcstInfoService2/ForecastSpaceData?serviceKey="+key+"&base_date=201806"+yoil+"&base_time=2000&nx=59&ny=123&numOfRows=10&pageSize=10&pageNo=6&startPage=1&_type=xml";    //15시
    private String todaytem7 = "http://newsky2.kma.go.kr/service/SecndSrtpdFrcstInfoService2/ForecastSpaceData?serviceKey="+key+"&base_date=201806"+yoil+"&base_time=2000&nx=59&ny=123&numOfRows=10&pageSize=10&pageNo=7&startPage=1&_type=xml";    //18시
    private String todaytem8 = "http://newsky2.kma.go.kr/service/SecndSrtpdFrcstInfoService2/ForecastSpaceData?serviceKey="+key+"&base_date=201806"+yoil+"&base_time=2000&nx=59&ny=123&numOfRows=10&pageSize=10&pageNo=8&startPage=1&_type=xml";    //21시
    private String tomorrow1 = "http://newsky2.kma.go.kr/service/SecndSrtpdFrcstInfoService2/ForecastSpaceData?serviceKey="+key+"&base_date=201806"+yoil1+"&base_time=0200&nx=59&ny=123&numOfRows=10&pageSize=10&pageNo=11&startPage=1&_type=xml";
    private String tomorrow2 = "http://newsky2.kma.go.kr/service/SecndSrtpdFrcstInfoService2/ForecastSpaceData?serviceKey="+key+"&base_date=201806"+yoil1+"&base_time=1400&nx=59&ny=123&numOfRows=10&pageSize=10&pageNo=15&startPage=1&_type=xml";

    private TextView  colortext1,colortext2,colortext3,colortext4,colortext5,colortext6,colortext7,colortext8,colortext9;
    private View    colorview1,colorview2,colorview3,colorview4,colorview5,colorview6,colorview7,colorview8,colorview9,colorview10,colorview11,colorview12,colorview13,colorview14,colorview15,colorview16,colorview17,colorview18,colorview19,colorview20;
    private LinearLayout background;
    private String future3456 = "http://www.weather.go.kr/weather/forecast/mid-term_02.jsp";    //  3, 4, 5, 6일 뒤 기온
    private String future12 = "http://www.weather.go.kr/weather/forecast/timeseries.jsp";       //  1일 2일 뒤 기온
    private String now = "http://newsky2.kma.go.kr/service/SecndSrtpdFrcstInfoService2/ForecastGrib?ServiceKey="+key+"&base_date="+today+"&base_time="+time+"&nx=59&ny=123&pageNo=1&numOfRows=10";  //현재 기온

    private TextView nowtext, futurerow1, futurehigh1,futurerow2, futurehigh2, futurerow3, futurehigh3,futurerow4, futurehigh4, futurerow5, futurehigh5,futurerow6, futurehigh6; //일주일 최저,최고기온
    private TextView todaytx1, todaytx2, todaytx3, todaytx4, todaytx5, todaytx6, todaytx7, todaytx8;    //오늘 기온 00시~ 21시 (3시간 단위)
    private String nowFormat;   //현재기온 포멧
    private String futurerow1Format, futurehigh1Format, futurerow2Format, futurehigh2Format, futurerow3Format, futurehigh3Format,futurerow4Format, futurehigh4Format, futurerow5Format, futurehigh5Format,futurerow6Format, futurehigh6Format; // 최저,최고 포멧
    private String todaytx1Format, todaytx2Format, todaytx3Format, todaytx4Format, todaytx5Format, todaytx6Format, todaytx7Format, todaytx8Format;
    private ImageView todayimg1,todayimg2,todayimg3,todayimg4,todayimg5,todayimg6,todayimg7,todayimg8;
    private ImageView futureimg1, futureimg2, futureimg3,futureimg4,futureimg5,futureimg6;
    private int timestate, daystate;
    private String nowptyFormat ,todaypty1,todaypty2,todaypty3,todaypty4,todaypty5,todaypty6,todaypty7,todaypty8,todaysky1,todaysky2,todaysky3,todaysky4,todaysky5,todaysky6,todaysky7,todaysky8;
    private String tompty1,tompty2,tompty3,tompty4,tompty5,tompty6,tomsky1,tomsky2;
    private String dust1, dust2, dust3;
    private int intdust;
    private  Button dust_face;
    private String yesthigh, yestlow, yest1,yest2,yest3,yest4,yest5,yest6,yest7,yest8;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {         //액션바 표시하기
        getMenuInflater().inflate(R.menu.menu1, menu) ;
        return true ;
    }

    public boolean onOptionsItemSelected(MenuItem item){    //액션바 이벤트 처리
        switch(item.getItemId()){
            case R.id.speech :          //액션바에서 음성모드를 선택하면

                Intent speech = new Intent(getApplicationContext(), speech1.class);
                //인텐트로 값 넘겨주기
                speech.putExtra("todayhigh",todaytx6Format);        //오늘 최고기온
                speech.putExtra("todaylow",todaytx2Format);         //오늘 최저기온
                speech.putExtra("todaynow",nowFormat);              //현재 기온
                speech.putExtra("tomhigh",futurehigh1Format);       //내일 최고기온
                speech.putExtra("tomlow",futurerow1Format);         //내일 최저기온
                speech.putExtra("dust1",dust1);                     //현재 통합대기 상태
                speech.putExtra("dust2",dust2);                     //현재 미세먼지 수치량
                speech.putExtra("dust3",dust3);                     //현재 초미세먼지 수치량
                speech.putExtra("tompty",tompty1);                  //내일 강수형태(없음(0), 비(1), 비/눈(2), 눈(3))
                speech.putExtra("tomsky",tomsky1);                  //내일 하늘상태(맑음(1), 구름조금(2), 구름많음(3), 흐림(4))
                // speech.putExtra("yesthigh",yesthigh);              //어제 최고기온
               // speech.putExtra(" yestlow", yestlow);               //어제 최저기온

                startActivity(speech);      //음성 모드 실행
                finish();                   //현재 액티비티 종료
                return true;

            case R.id.whether :         //액션바에서 날씨비교를 선택하면
                Intent chart = new Intent(getApplicationContext(), chart.class);

                chart.putExtra("todaytx1",todaytx1Format);  //chart.putExtra("yesy1",yest1);  //오늘, 어제 00시 온도
                chart.putExtra("todaytx2",todaytx2Format);  //chart.putExtra("yesy2",yest2);  //오늘, 어제 03시 온도
                chart.putExtra("todaytx3",todaytx3Format);  //chart.putExtra("yesy3",yest3);  //오늘, 어제 06시 온도
                chart.putExtra("todaytx4",todaytx4Format);  //chart.putExtra("yesy4",yest4);  //오늘, 어제 09시 온도
                chart.putExtra("todaytx5",todaytx5Format);  //chart.putExtra("yesy5",yest5);  //오늘, 어제 12시 온도
                chart.putExtra("todaytx6",todaytx6Format);  //chart.putExtra("yesy6",yest6);  //오늘, 어제 15시 온도
                chart.putExtra("todaytx7",todaytx7Format);  //chart.putExtra("yesy7",yest7);  //오늘, 어제 18시 온도
                chart.putExtra("todaytx8",todaytx8Format);  //chart.putExtra("yesy8",yest8);  //오늘, 어제 21시 온도
                chart.putExtra("tomhigh",futurehigh1Format);
                chart.putExtra("tomlow",futurerow1Format);
                startActivity(chart);       //날씨 비교 실행
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("일반 모드");
        doDayOfWeek();

        JsoupAsyncTask jsoupAsyncTask = new JsoupAsyncTask();
        jsoupAsyncTask.execute();

        Calendar cal = Calendar.getInstance();
        @SuppressLint("WrongConstant") int time1 = cal.get(Calendar.HOUR_OF_DAY);

        background = (LinearLayout) findViewById(R.id.background);

        //시간대가 밤이면
        if (time1<6 || time1>17){       //00시~06시   18시~24시
            background.setBackgroundResource(R.drawable.background_night);       //배경화면을 밤으로 설정
            timestate = 1;

            daystate = 1;
        }


        else{
            background.setBackgroundResource(R.drawable.background_sun);         //배경화면을 낮으로 설정
            timestate = 0;
            daystate = 0;
        }


        nowtext = (TextView)findViewById(R.id.now);
        nowtext.setMovementMethod(new BaseMovementMethod());

        futurerow1 = (TextView)findViewById(R.id.futurerow1);
        futurerow1.setMovementMethod(new BaseMovementMethod());

        futurehigh1 = (TextView)findViewById(R.id.futurehigh1);
        futurehigh1.setMovementMethod(new BaseMovementMethod());

        futurerow2 = (TextView)findViewById(R.id.futurerow2);
        futurerow2.setMovementMethod(new BaseMovementMethod());

        futurehigh2 = (TextView)findViewById(R.id.futurehigh2);
        futurehigh2.setMovementMethod(new BaseMovementMethod());

        futurerow3 = (TextView)findViewById(R.id.futurerow3);
        futurerow3.setMovementMethod(new BaseMovementMethod());

        futurehigh3 = (TextView)findViewById(R.id.futurehigh3);
        futurehigh3.setMovementMethod(new BaseMovementMethod());

        futurerow4 = (TextView)findViewById(R.id.futurerow4);
        futurerow4.setMovementMethod(new BaseMovementMethod());

        futurehigh4 = (TextView)findViewById(R.id.futurehigh4);
        futurehigh4.setMovementMethod(new BaseMovementMethod());

        futurerow5 = (TextView)findViewById(R.id.futurerow5);
        futurerow5.setMovementMethod(new BaseMovementMethod());

        futurehigh5 = (TextView)findViewById(R.id.futurehigh5);
        futurehigh5.setMovementMethod(new BaseMovementMethod());

        futurerow6 = (TextView)findViewById(R.id.futurerow6);
        futurerow6.setMovementMethod(new BaseMovementMethod());

        futurehigh6 = (TextView)findViewById(R.id.futurehigh6);
        futurehigh6.setMovementMethod(new BaseMovementMethod());

        todaytx1 = (TextView)findViewById(R.id.todaytx1);
        todaytx1.setMovementMethod(new BaseMovementMethod());

        todaytx2 = (TextView)findViewById(R.id.todaytx2);
        todaytx2.setMovementMethod(new BaseMovementMethod());

        todaytx3 = (TextView)findViewById(R.id.todaytx3);
        todaytx3.setMovementMethod(new BaseMovementMethod());

        todaytx4 = (TextView)findViewById(R.id.todaytx4);
        todaytx4.setMovementMethod(new BaseMovementMethod());

        todaytx5 = (TextView)findViewById(R.id.todaytx5);
        todaytx5.setMovementMethod(new BaseMovementMethod());

        todaytx6 = (TextView)findViewById(R.id.todaytx6);
        todaytx6.setMovementMethod(new BaseMovementMethod());

        todaytx7 = (TextView)findViewById(R.id.todaytx7);
        todaytx7.setMovementMethod(new BaseMovementMethod());

        todaytx8 = (TextView)findViewById(R.id.todaytx8);
        todaytx8.setMovementMethod(new BaseMovementMethod());

        dust_face = (Button) findViewById(R.id.dust_face);

        todayimg1 = (ImageView) findViewById(R.id.todayimg1);
        todayimg2 = (ImageView) findViewById(R.id.todayimg2);
        todayimg3 = (ImageView) findViewById(R.id.todayimg3);
        todayimg4 = (ImageView) findViewById(R.id.todayimg4);
        todayimg5 = (ImageView) findViewById(R.id.todayimg5);
        todayimg6 = (ImageView) findViewById(R.id.todayimg6);
        todayimg7 = (ImageView) findViewById(R.id.todayimg7);
        todayimg8 = (ImageView) findViewById(R.id.todayimg8);

        futureimg1 =(ImageView) findViewById(R.id.futureimg1);
        futureimg2 =(ImageView) findViewById(R.id.futureimg2);
        futureimg3 =(ImageView) findViewById(R.id.futureimg3);
        futureimg4 =(ImageView) findViewById(R.id.futureimg4);
        futureimg5 =(ImageView) findViewById(R.id.futureimg5);
        futureimg6 =(ImageView) findViewById(R.id.futureimg6);


        colortext1 = (TextView)findViewById(R.id.colortext1);
        colortext2 = (TextView)findViewById(R.id.colortext2);
        colortext3 = (TextView)findViewById(R.id.colortext3);
        colortext4 = (TextView)findViewById(R.id.colortext4);
        colortext5 = (TextView)findViewById(R.id.colortext5);
        colortext6 = (TextView)findViewById(R.id.colortext6);
        colortext7 = (TextView)findViewById(R.id.colortext7);
        colortext8 = (TextView)findViewById(R.id.colortext8);
        colortext9 = (TextView)findViewById(R.id.colortext9);

        colorview1 = (View)findViewById(R.id.colorview1);        colorview2 = (View)findViewById(R.id.colorview2);        colorview3 = (View)findViewById(R.id.colorview3);
        colorview4 = (View)findViewById(R.id.colorview4);        colorview5 = (View)findViewById(R.id.colorview5);        colorview6 = (View)findViewById(R.id.colorview6);
        colorview7 = (View)findViewById(R.id.colorview7);        colorview8 = (View)findViewById(R.id.colorview8);        colorview9 = (View)findViewById(R.id.colorview9);
        colorview10 = (View)findViewById(R.id.colorview10);        colorview11 = (View)findViewById(R.id.colorview11);        colorview12 = (View)findViewById(R.id.colorview12);
        colorview13 = (View)findViewById(R.id.colorview13);        colorview14 = (View)findViewById(R.id.colorview14);        colorview15 = (View)findViewById(R.id.colorview15);
        colorview16 = (View)findViewById(R.id.colorview16);        colorview17 = (View)findViewById(R.id.colorview17);        colorview18 = (View)findViewById(R.id.colorview18);
        colorview19 = (View)findViewById(R.id.colorview19);         colorview20 = (View)findViewById(R.id.colorview20);







        Button dust_face = (Button)findViewById(R.id.dust_face);


        dust_face.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent dust = new Intent(getApplicationContext(), dust.class);
                dust.putExtra("dust1",dust1);
                dust.putExtra("dust2",dust2);
                dust.putExtra("dust3",dust3);

                startActivity(dust);
            }
        });
    }

    private class JsoupAsyncTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            GregorianCalendar today1 = new GregorianCalendar ( );
            int time1 = today1.get(Calendar.HOUR_OF_DAY);
            int minute = today1.get(Calendar.MINUTE);

            if(minute < 30){
                time1 = time1 - 1;
                if(time1 < 10){
                    now = "http://newsky2.kma.go.kr/service/SecndSrtpdFrcstInfoService2/ForecastGrib?ServiceKey="+key+"&base_date="+today+"&base_time=0"+time1+"30&nx=59&ny=123&pageNo=1&numOfRows=10";  //현재 기온
                }
                else {
                    now = "http://newsky2.kma.go.kr/service/SecndSrtpdFrcstInfoService2/ForecastGrib?ServiceKey=" + key + "&base_date=" + today + "&base_time=" + time1 + "30&nx=59&ny=123&pageNo=1&numOfRows=10";  //현재 기온
                }
            }
            else{
                if(time1 < 10){
                    now = "http://newsky2.kma.go.kr/service/SecndSrtpdFrcstInfoService2/ForecastGrib?ServiceKey="+key+"&base_date="+today+"&base_time=0"+time1+"00&nx=59&ny=123&pageNo=1&numOfRows=10";  //현재 기온
                }
                else {
                    now = "http://newsky2.kma.go.kr/service/SecndSrtpdFrcstInfoService2/ForecastGrib?ServiceKey=" + key + "&base_date=" + today + "&base_time=" + time1 + "00&nx=59&ny=123&pageNo=1&numOfRows=10";  //현재 기온
                }
            }
            try {
                Document doc = Jsoup.connect(now).get();
                Elements links = doc.select("obsrValue");
                int i = 0;
                for (Element link : links) {
                    i++;
                    if(i==2){
                        nowptyFormat = link.text().intern();    //현재 강수 형태
                    }
                    else if(i==6){
                        nowFormat = (link.text().trim());           //현재 기온
                    }

                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                Document doc = Jsoup.connect(future12).get();
                Elements links = doc.select("span.low_deg");
                int i=0;
                for (Element link : links) {
                    i++;
                    if(i==2) {
                        futurerow1Format = (link.text().trim());
                    }
                    else if(i==3){
                        futurerow2Format = (link.text().trim());

                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                Document doc = Jsoup.connect(future12).get();
                Elements links = doc.select("span.high_deg");
                int i=0;
                for (Element link : links) {
                    i++;
                    if(i==2) {
                        futurehigh1Format = (link.text().trim());
                    }
                    else if(i==3){
                        futurehigh2Format = (link.text().trim());

                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                Document doc = Jsoup.connect(future3456).get();
                Elements links = doc.select("tr span.col_blue");
                int i=0;
                for (Element link : links) {
                    i++;
                    if(i==201) {
                        futurerow3Format = (link.text().trim()+"℃");
                    }
                    else if(i==202){
                        futurerow4Format = (link.text().trim()+"℃");
                    }
                    else if(i==203){
                        futurerow5Format = (link.text().trim()+"℃");
                    }
                    else if(i==204){
                        futurerow6Format = (link.text().trim()+"℃");
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                Document doc = Jsoup.connect(future3456).get();
                Elements links = doc.select("span.col_orange");
                int i=0;
                for (Element link : links) {
                    i++;
                    if(i==201) {
                        futurehigh3Format = (link.text().trim()+"℃");
                    }
                    else if(i==202){
                        futurehigh4Format = (link.text().trim()+"℃");
                    }
                    else if(i==203){
                        futurehigh5Format = (link.text().trim()+"℃");
                    }
                    else if(i==204){
                        futurehigh6Format = (link.text().trim()+"℃");
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@2
            try {
                Document doc = Jsoup.connect(future3456).get();
                Elements links = doc.select("td.bg_gray2 ul li" );
                int i=0;
                for (Element link : links) {
                    i++;
                    if(i==3) {
                        tompty3 = link.attr("title").intern();
                    }
                    else if(i==5){
                        tompty5 = link.attr("title").intern();
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                Document doc = Jsoup.connect(future3456).get();
                Elements links = doc.select("table.table_midterm [title]");
                int i=0;
                for (Element link : links) {
                    i++;
                    if(i==4) {
                        tompty4 = link.attr("title").intern();
                    }
                    else if(i==8){
                        tompty6 = link.attr("title").intern();
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@2

            try {
                Document doc = Jsoup.connect(dust).get();
                Elements links = doc.select("em.main_figure");
                for (Element link : links) {
                    dust1 = (link.text().intern()+"㎍/㎥");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                Document doc = Jsoup.connect(dust).get();
                Elements links = doc.select("span.state");
                int i = 0;
                for (Element link : links) {
                    i++;
                    if(i==3) {
                        dust2 = link.text().intern();
                    }
                    else if(i==8){
                        dust3 = link.text().intern();
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
/*
            try {
                Document doc = Jsoup.connect(dust).get();
                Elements links = doc.select("li span.state_info span.state");

                for (Element link : links) {
                        dust3 += link.text().intern();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
*/
            try {
                Document doc = Jsoup.connect(tomorrow1).get();
                Elements links = doc.select("fcstValue");
                int i=0;
                for (Element link : links) {
                    i++;
                    if(i==5) {
                        tompty1 = link.text().intern();
                    }
                    else if(i==9){
                        tomsky1 = link.text().intern();

                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                Document doc = Jsoup.connect(tomorrow2).get();
                Elements links = doc.select("fcstValue");
                int i=0;
                for (Element link : links) {
                    i++;
                    if(i==5) {
                        tompty2 = link.text().intern();
                    }
                    else if(i==9){
                        tomsky2 = link.text().intern();

                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                Document doc = Jsoup.connect(todaytem1).get();
                Elements links = doc.select("fcstValue");
                int i = 0;
                for (Element link : links) {
                    i++;
                    if(i==7){
                        todaytx1Format = (link.text().trim());
                    }
                    else if(i==2){
                        todaypty1 = link.text().intern();
                    }
                    else if(i==6){
                        todaysky1 = link.text().intern();
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                Document doc = Jsoup.connect(todaytem2).get();
                Elements links = doc.select("fcstValue");
                int i = 0;
                for (Element link : links) {
                    i++;
                    if(i==6){
                        todaytx2Format = (link.text().trim());
                    }
                    else if(i==3){
                        todaypty2 = link.text().intern();
                    }
                    else if(i==5){
                        todaysky2 = link.text().intern();
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                Document doc = Jsoup.connect(todaytem3).get();
                Elements links = doc.select("fcstValue");
                int i = 0;
                for (Element link : links) {
                    i++;
                    if(i==7){
                        todaytx3Format = (link.text().trim());
                    }
                    else if(i==2){
                        todaypty3 = link.text().intern();
                    }
                    else if(i==6){
                        todaysky3 = link.text().intern();
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                Document doc = Jsoup.connect(todaytem4).get();
                Elements links = doc.select("fcstValue");
                int i = 0;
                for (Element link : links) {
                    i++;
                    if(i==7){
                        todaytx4Format = (link.text().trim());
                    }
                    else if(i==4){
                        todaypty4 = link.text().intern();
                    }
                    else if(i==6){
                        todaysky4 = link.text().intern();
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                Document doc = Jsoup.connect(todaytem5).get();
                Elements links = doc.select("fcstValue");
                int i = 0;
                for (Element link : links) {
                    i++;
                    if(i==8){
                        todaytx5Format = (link.text().trim());
                    }
                    else if(i==3){
                        todaypty5 = link.text().intern();
                    }
                    else if(i==7){
                        todaysky5 = link.text().intern();
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                Document doc = Jsoup.connect(todaytem6).get();
                Elements links = doc.select("fcstValue");
                int i = 0;
                for (Element link : links) {
                    i++;
                    if(i==7){
                        todaytx6Format = (link.text().trim());
                    }
                    else if(i==4){
                        todaypty6 = link.text().intern();
                    }
                    else if(i==6){
                        todaysky6 = link.text().intern();
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                Document doc = Jsoup.connect(todaytem7).get();
                Elements links = doc.select("fcstValue");
                int i = 0;
                for (Element link : links) {
                    i++;
                    if(i==9){
                        todaytx7Format = (link.text().trim());
                    }
                    else if(i==4){
                        todaypty7 = link.text().intern();
                    }
                    else if(i==8){
                        todaysky7 = link.text().intern();
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                Document doc = Jsoup.connect(todaytem8).get();
                Elements links = doc.select("fcstValue");
                int i = 0;
                for (Element link : links) {
                    i++;
                    if(i==8){
                        todaytx8Format = (link.text().trim());
                    }
                    else if(i==5){
                        todaypty8 = link.text().intern();
                    }
                    else if(i==7){
                        todaysky8 = link.text().intern();
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            intdust = Integer.parseInt(dust3);
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {

            nowtext.setText(nowFormat+"℃");         //현재 온도

            todaytx1.setText(todaytx1Format+"℃");   //오늘 00시 온도
            todaytx2.setText(todaytx2Format+"℃");   //오늘 03시 온도
            todaytx3.setText(todaytx3Format+"℃");   //오늘 06시 온도
            todaytx4.setText(todaytx4Format+"℃");   //오늘 09시 온도
            todaytx5.setText(todaytx5Format+"℃");   //오늘 12시 온도
            todaytx6.setText(todaytx6Format+"℃");   //오늘 15시 온도
            todaytx7.setText(todaytx7Format+"℃");   //오늘 18시 온도
            todaytx8.setText(todaytx8Format+"℃");   //오늘 21시 온도

            futurerow1.setText(futurerow1Format+"℃");
            futurerow2.setText(futurerow2Format+"℃");
            futurehigh1.setText(futurehigh1Format+"℃");
            futurehigh2.setText(futurehigh2Format+"℃");
            futurerow3.setText(futurerow3Format);
            futurehigh3.setText(futurehigh3Format);
            futurerow4.setText(futurerow4Format);
            futurehigh4.setText(futurehigh4Format);
            futurerow5.setText(futurerow5Format);
            futurehigh5.setText(futurehigh5Format);
            futurerow6.setText(futurerow6Format);
            futurehigh6.setText(futurehigh6Format);

            now1 = (TextView) findViewById(R.id.now1);
            now2 = (TextView) findViewById(R.id.now2);
            now3 = (TextView) findViewById(R.id.now3);
            now4 = (TextView) findViewById(R.id.now4);
            now5 = (TextView) findViewById(R.id.now5);
            now6 = (TextView) findViewById(R.id.now6);


            if(nowptyFormat=="1" || nowptyFormat=="2"){                         //강수 형태가 비가 오면
                background.setBackgroundResource(R.drawable.background_rain);   //배경화면을 비로 설정
                daystate = 2;
                nowtext.setTextColor(Color.parseColor("#1F4E79"));
                todaytx1.setTextColor(Color.parseColor("#1F4E79"));
                todaytx2.setTextColor(Color.parseColor("#1F4E79"));
                todaytx3.setTextColor(Color.parseColor("#1F4E79"));
                todaytx4.setTextColor(Color.parseColor("#1F4E79"));
                todaytx5.setTextColor(Color.parseColor("#1F4E79"));
                todaytx6.setTextColor(Color.parseColor("#1F4E79"));
                todaytx7.setTextColor(Color.parseColor("#1F4E79"));
                todaytx8.setTextColor(Color.parseColor("#1F4E79"));
                futurerow1.setTextColor(Color.parseColor("#1F4E79"));             futurerow2.setTextColor(Color.parseColor("#1F4E79"));
                futurerow3.setTextColor(Color.parseColor("#1F4E79"));             futurerow4.setTextColor(Color.parseColor("#1F4E79"));
                futurerow5.setTextColor(Color.parseColor("#1F4E79"));             futurerow6.setTextColor(Color.parseColor("#1F4E79"));
                futurehigh1.setTextColor(Color.parseColor("#1F4E79"));             futurehigh2.setTextColor(Color.parseColor("#1F4E79"));
                futurehigh3.setTextColor(Color.parseColor("#1F4E79"));             futurehigh4.setTextColor(Color.parseColor("#1F4E79"));
                futurehigh5.setTextColor(Color.parseColor("#1F4E79"));             futurehigh6.setTextColor(Color.parseColor("#1F4E79"));
                colortext1.setTextColor(Color.parseColor("#1F4E79"));               colortext2.setTextColor(Color.parseColor("#1F4E79"));
                colortext3.setTextColor(Color.parseColor("#1F4E79"));               colortext4.setTextColor(Color.parseColor("#1F4E79"));
                colortext5.setTextColor(Color.parseColor("#1F4E79"));               colortext6.setTextColor(Color.parseColor("#1F4E79"));
                colortext7.setTextColor(Color.parseColor("#1F4E79"));               colortext8.setTextColor(Color.parseColor("#1F4E79"));       colortext9.setTextColor(Color.parseColor("#1F4E79"));
                now1.setTextColor(Color.parseColor("#1F4E79"));               now2.setTextColor(Color.parseColor("#1F4E79"));
                now3.setTextColor(Color.parseColor("#1F4E79"));               now4.setTextColor(Color.parseColor("#1F4E79"));
                now5.setTextColor(Color.parseColor("#1F4E79"));               now6.setTextColor(Color.parseColor("#1F4E79"));

            }
            else if(nowptyFormat=="3"){                                         //강수 형태가 눈이 오면
                background.setBackgroundResource(R.drawable.background_snow);   //배경화면을 눈으로 설정
                daystate = 3;
                nowtext.setTextColor(Color.parseColor("#203864"));
                todaytx1.setTextColor(Color.parseColor("#203864"));
                todaytx2.setTextColor(Color.parseColor("#203864"));
                todaytx3.setTextColor(Color.parseColor("#203864"));
                todaytx4.setTextColor(Color.parseColor("#203864"));
                todaytx5.setTextColor(Color.parseColor("#203864"));
                todaytx6.setTextColor(Color.parseColor("#203864"));
                todaytx7.setTextColor(Color.parseColor("#203864"));
                todaytx8.setTextColor(Color.parseColor("#203864"));
                futurerow1.setTextColor(Color.parseColor("#203864"));             futurerow2.setTextColor(Color.parseColor("#203864"));
                futurerow3.setTextColor(Color.parseColor("#203864"));             futurerow4.setTextColor(Color.parseColor("#203864"));
                futurerow5.setTextColor(Color.parseColor("#203864"));             futurerow6.setTextColor(Color.parseColor("#203864"));
                futurehigh1.setTextColor(Color.parseColor("#203864"));             futurehigh2.setTextColor(Color.parseColor("#203864"));
                futurehigh3.setTextColor(Color.parseColor("#203864"));             futurehigh4.setTextColor(Color.parseColor("#203864"));
                futurehigh5.setTextColor(Color.parseColor("#203864"));             futurehigh6.setTextColor(Color.parseColor("#203864"));
                colortext1.setTextColor(Color.parseColor("#203864"));               colortext2.setTextColor(Color.parseColor("#203864"));
                colortext3.setTextColor(Color.parseColor("#203864"));               colortext4.setTextColor(Color.parseColor("#203864"));
                colortext5.setTextColor(Color.parseColor("#203864"));               colortext6.setTextColor(Color.parseColor("#203864"));
                colortext7.setTextColor(Color.parseColor("#203864"));               colortext8.setTextColor(Color.parseColor("#203864"));       colortext9.setTextColor(Color.parseColor("#203864"));
                now1.setTextColor(Color.parseColor("#203864"));               now2.setTextColor(Color.parseColor("#203864"));
                now3.setTextColor(Color.parseColor("#203864"));               now4.setTextColor(Color.parseColor("#203864"));
                now5.setTextColor(Color.parseColor("#203864"));               now6.setTextColor(Color.parseColor("#203864"));

            }
            else{                       //그 외에는 배경화면 바꾸지 않음

                //밤이면 위젯 색 변경
                if(timestate==1){       //배경화면이 밤이면 위젯 색을 흰색으로 설정
                    nowtext.setTextColor(Color.parseColor("#FFFFFF"));  //현재 온도
                    todaytx1.setTextColor(Color.parseColor("#FFFFFF")); //오늘 00시 온도
                    todaytx2.setTextColor(Color.parseColor("#FFFFFF")); //오늘 03시 온도
                    todaytx3.setTextColor(Color.parseColor("#FFFFFF")); //오늘 06시 온도
                    todaytx4.setTextColor(Color.parseColor("#FFFFFF")); //오늘 09시 온도
                    todaytx5.setTextColor(Color.parseColor("#FFFFFF")); //오늘 12시 온도
                    todaytx6.setTextColor(Color.parseColor("#FFFFFF")); //오늘 15시 온도
                    todaytx7.setTextColor(Color.parseColor("#FFFFFF")); //오늘 18시 온도
                    todaytx8.setTextColor(Color.parseColor("#FFFFFF")); //오늘 21시 온도

                    futurerow1.setTextColor(Color.parseColor("#FFFFFF"));             futurerow2.setTextColor(Color.parseColor("#FFFFFF"));
                    futurerow3.setTextColor(Color.parseColor("#FFFFFF"));             futurerow4.setTextColor(Color.parseColor("#FFFFFF"));
                    futurerow5.setTextColor(Color.parseColor("#FFFFFF"));             futurerow6.setTextColor(Color.parseColor("#FFFFFF"));
                    futurehigh1.setTextColor(Color.parseColor("#FFFFFF"));             futurehigh2.setTextColor(Color.parseColor("#FFFFFF"));
                    futurehigh3.setTextColor(Color.parseColor("#FFFFFF"));             futurehigh4.setTextColor(Color.parseColor("#FFFFFF"));
                    futurehigh5.setTextColor(Color.parseColor("#FFFFFF"));             futurehigh6.setTextColor(Color.parseColor("#FFFFFF"));
                    colortext1.setTextColor(Color.parseColor("#FFFFFF"));               colortext2.setTextColor(Color.parseColor("#FFFFFF"));
                    colortext3.setTextColor(Color.parseColor("#FFFFFF"));               colortext4.setTextColor(Color.parseColor("#FFFFFF"));
                    colortext5.setTextColor(Color.parseColor("#FFFFFF"));               colortext6.setTextColor(Color.parseColor("#FFFFFF"));
                    colortext7.setTextColor(Color.parseColor("#FFFFFF"));               colortext8.setTextColor(Color.parseColor("#FFFFFF"));       colortext9.setTextColor(Color.parseColor("#FFFFFF"));
                    now1.setTextColor(Color.parseColor("#FFFFFF"));               now2.setTextColor(Color.parseColor("#FFFFFF"));
                    now3.setTextColor(Color.parseColor("#FFFFFF"));               now4.setTextColor(Color.parseColor("#FFFFFF"));
                    now5.setTextColor(Color.parseColor("#FFFFFF"));               now6.setTextColor(Color.parseColor("#FFFFFF"));
                    colorview1.setBackgroundColor(Color.parseColor("#FFFFFF"));     colorview2.setBackgroundColor(Color.parseColor("#FFFFFF"));     colorview3.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    colorview4.setBackgroundColor(Color.parseColor("#FFFFFF"));      colorview5.setBackgroundColor(Color.parseColor("#FFFFFF"));      colorview6.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    colorview7.setBackgroundColor(Color.parseColor("#FFFFFF"));      colorview8.setBackgroundColor(Color.parseColor("#FFFFFF"));      colorview9.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    colorview10.setBackgroundColor(Color.parseColor("#FFFFFF"));      colorview11.setBackgroundColor(Color.parseColor("#FFFFFF"));      colorview12.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    colorview13.setBackgroundColor(Color.parseColor("#FFFFFF"));      colorview14.setBackgroundColor(Color.parseColor("#FFFFFF"));      colorview15.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    colorview16.setBackgroundColor(Color.parseColor("#FFFFFF"));      colorview17.setBackgroundColor(Color.parseColor("#FFFFFF"));      colorview18.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    colorview19.setBackgroundColor(Color.parseColor("#FFFFFF"));      colorview20.setBackgroundColor(Color.parseColor("#FFFFFF"));

                }

            }
            intdust = Integer.parseInt(dust3);

           if(daystate == 0){  //낮이면
                 if(intdust <= 50){
                    dust_face.setBackgroundResource(R.drawable.sun_dust1);
                }
                else if((intdust <= 100)||(intdust > 50)){
                    dust_face.setBackgroundResource(R.drawable.sun_dust2);
                }
                else if((intdust <= 250)||(intdust > 100)){
                    dust_face.setBackgroundResource(R.drawable.sun_dust3);
                }
                else{
                    dust_face.setBackgroundResource(R.drawable.sun_dust4);
                }

                if(todaypty1 == "0"){
                    if(todaysky1=="1"){
                        todayimg1.setImageResource(R.drawable.sun_night);
                    }
                    else if((todaysky1=="2")||(todaysky1=="3")){
                        todayimg1.setImageResource(R.drawable.sun_cloud);
                    }
                    else if(todaysky1 =="4"){
                        todayimg1.setImageResource(R.drawable.sun_cloud);
                    }
                }
                else if((todaypty1 == "1")||(todaypty1 == "2")){
                    todayimg1.setImageResource(R.drawable.sun_rain);
                }
                else if(todaypty1 == "3"){
                    
                    todayimg1.setImageResource(R.drawable.sun_snow);
                }

                if(todaypty2 == "0"){
                    if(todaysky2=="1"){
                        todayimg2.setImageResource(R.drawable.sun_night);
                    }
                    else if((todaysky2=="2")||(todaysky2=="3")){
                        todayimg2.setImageResource(R.drawable.sun_cloud);
                    }
                    else if(todaysky2 =="4"){
                        todayimg2.setImageResource(R.drawable.sun_cloud);
                    }
                }
                else if((todaypty2 == "1")||(todaypty2 == "2")){
                    todayimg2.setImageResource(R.drawable.sun_rain);
                }
                else if(todaypty2 == "3"){
                    todayimg2.setImageResource(R.drawable.sun_snow);
                }

                if(todaypty3 == "0"){
                    if(todaysky3=="1"){
                        todayimg3.setImageResource(R.drawable.sun_sun);
                    }
                    else if((todaysky3=="2")||(todaysky3=="3")){
                        todayimg3.setImageResource(R.drawable.sun_1);
                    }
                    else if(todaysky3 =="4"){
                        todayimg3.setImageResource(R.drawable.sun_cloud);
                    }
                }
                else if((todaypty3 == "1")||(todaypty3 == "2")){
                    todayimg3.setImageResource(R.drawable.sun_rain);
                }
                else if(todaypty3 == "3"){
                    todayimg3.setImageResource(R.drawable.sun_snow);
                }

                if(todaypty4 == "0"){
                    if(todaysky4=="1"){
                        todayimg4.setImageResource(R.drawable.sun_sun);
                    }
                    else if((todaysky4=="2")||(todaysky4=="3")){
                        todayimg4.setImageResource(R.drawable.sun_1);
                    }
                    else if(todaysky4 =="4"){
                        todayimg4.setImageResource(R.drawable.sun_cloud);
                    }
                }
                else if((todaypty4 == "1")||(todaypty4 == "2")){
                    todayimg4.setImageResource(R.drawable.sun_rain);
                }
                else if(todaypty4 == "3"){
                    todayimg4.setImageResource(R.drawable.sun_snow);
                }

                if(todaypty5 == "0"){
                    if(todaysky5=="1"){
                        todayimg5.setImageResource(R.drawable.sun_sun);
                    }
                    else if((todaysky5=="2")||(todaysky5=="3")){
                        todayimg5.setImageResource(R.drawable.sun_1);
                    }
                    else if(todaysky5 =="4"){
                        todayimg5.setImageResource(R.drawable.sun_cloud);
                    }
                }
                else if((todaypty5 == "1")||(todaypty5 == "2")){
                    todayimg5.setImageResource(R.drawable.sun_rain);
                }
                else if(todaypty5 == "3"){
                    todayimg5.setImageResource(R.drawable.sun_snow);
                }

                if(todaypty6 == "0"){
                    if(todaysky6=="1"){
                        todayimg6.setImageResource(R.drawable.sun_sun);
                    }
                    else if((todaysky6=="2")||(todaysky6=="3")){
                        todayimg6.setImageResource(R.drawable.sun_1);
                    }
                    else if(todaysky6 =="4"){
                        todayimg6.setImageResource(R.drawable.sun_cloud);
                    }
                }
                else if((todaypty6 == "1")||(todaypty6 == "2")){
                    todayimg6.setImageResource(R.drawable.sun_rain);
                }
                else if(todaypty6 == "3"){
                    todayimg6.setImageResource(R.drawable.sun_snow);
                }

                if(todaypty7 == "0"){
                    if(todaysky7=="1"){
                        todayimg7.setImageResource(R.drawable.sun_sun);
                    }
                    else if((todaysky7=="2")||(todaysky7=="3")){
                        todayimg7.setImageResource(R.drawable.sun_1);
                    }
                    else if(todaysky7 =="4"){
                        todayimg7.setImageResource(R.drawable.sun_cloud);
                    }
                }
                else if((todaypty7 == "1")||(todaypty7 == "2")){
                    todayimg7.setImageResource(R.drawable.sun_rain);
                }
                else if(todaypty7 == "3"){
                    todayimg7.setImageResource(R.drawable.sun_snow);
                }

                if(todaypty8 == "0"){
                    if(todaysky8=="1"){
                        todayimg8.setImageResource(R.drawable.sun_night);
                    }
                    else if((todaysky8=="2")||(todaysky8=="3")){
                        todayimg8.setImageResource(R.drawable.sun_cloud);
                    }
                    else if(todaysky8 =="4"){
                        todayimg8.setImageResource(R.drawable.sun_cloud);
                    }
                }
                else if((todaypty8 == "1")||(todaypty8 == "2")){
                    todayimg8.setImageResource(R.drawable.sun_rain);
                }
                else if(todaypty8 == "3"){
                    todayimg8.setImageResource(R.drawable.sun_snow);
                }

                if(tompty1 == "0"){
                    if(tomsky1 == "1"){
                        futureimg1.setImageResource(R.drawable.sun_sun);
                    }
                    else if((tomsky1 == "2")||(tomsky1== "3")){
                        futureimg1.setImageResource((R.drawable.sun_1));
                    }
                    else if(tomsky1 == "4"){
                        futureimg1.setImageResource(R.drawable.sun_cloud);
                    }
                }
                else if(tompty1 == "1"||(tompty1== "2")){
                    futureimg1.setImageResource(R.drawable.sun_rain);
                }
                else if(tompty1 == "3"){
                    futureimg1.setImageResource(R.drawable.sun_snow);
                }

                
                if(tompty2 == "0"){
                    if(tomsky2 == "1"){
                        futureimg2.setImageResource(R.drawable.sun_sun);
                    }
                    else if((tomsky2 == "2")||(tomsky2== "3")){
                        futureimg1.setImageResource((R.drawable.sun_1));
                    }
                    else if(tomsky2 == "4"){
                        futureimg1.setImageResource(R.drawable.sun_cloud);
                    }
                }
                else if(tompty2 == "1"||(tompty2== "2")){
                    futureimg2.setImageResource(R.drawable.sun_rain);
                }
                else if(tompty2 == "3"){
                    futureimg2.setImageResource(R.drawable.sun_snow);
                }

                if(tompty3 == "맑음") {
                    futureimg3.setImageResource((R.drawable.sun_sun));
                }
                else if((tompty3 == "구름조금")||(tompty3 == "구름많음")){
                    futureimg3.setImageResource((R.drawable.sun_1));
                }
                else if(tompty3 == "흐림"){
                    futureimg3.setImageResource((R.drawable.sun_cloud));
                }
                else if(tompty3 == "비"){
                    futureimg3.setImageResource((R.drawable.sun_rain));
                }
                else if(tompty3 == "눈"){
                    futureimg3.setImageResource((R.drawable.sun_snow));
                }
                if(tompty4 == "맑음") {
                    futureimg4.setImageResource((R.drawable.sun_sun));
                }
                else if((tompty4 == "구름조금")||(tompty4 == "구름많음")){
                    futureimg4.setImageResource((R.drawable.sun_1));
                }
                else if(tompty4 == "흐림"){
                    futureimg4.setImageResource((R.drawable.sun_cloud));
                }
                else if(tompty4 == "비"){
                    futureimg4.setImageResource((R.drawable.sun_rain));
                }
                else if(tompty4 == "눈"){
                    futureimg4.setImageResource((R.drawable.sun_snow));
                }
                if(tompty5 == "맑음") {
                    futureimg5.setImageResource((R.drawable.sun_sun));
                }
                else if((tompty5 == "구름조금")||(tompty5 == "구름많음")){
                    futureimg5.setImageResource((R.drawable.sun_1));
                }
                else if(tompty5 == "흐림"){
                    futureimg5.setImageResource((R.drawable.sun_cloud));
                }
                else if(tompty5 == "비"){
                    futureimg5.setImageResource((R.drawable.sun_rain));
                }
                else if(tompty5 == "눈"){
                    futureimg5.setImageResource((R.drawable.sun_snow));
                }
                if(tompty6 == "맑음") {
                    futureimg6.setImageResource((R.drawable.sun_sun));
                }
                else if((tompty6 == "구름조금")||(tompty6 == "구름많음")){
                    futureimg6.setImageResource((R.drawable.sun_1));
                }
                else if(tompty6 == "흐림"){
                    futureimg6.setImageResource((R.drawable.sun_cloud));
                }
                else if(tompty6 == "비"){
                    futureimg6.setImageResource((R.drawable.sun_rain));
                }
                else if(tompty6 == "눈"){
                    futureimg6.setImageResource((R.drawable.sun_snow));
                }
            }


            else if(daystate == 1){  //밤이면
                if(intdust <= 50){
                    dust_face.setBackgroundResource(R.drawable.night_dust1);
                }
                else if((intdust <= 100)||(intdust > 50)){
                    dust_face.setBackgroundResource(R.drawable.night_dust2);
                }
                else if((intdust <= 250)||(intdust > 100)){
                    dust_face.setBackgroundResource(R.drawable.night_dust3);
                }
                else{
                    dust_face.setBackgroundResource(R.drawable.night_dust4);
                }

                if(todaypty1 == "0"){
                    if(todaysky1=="1"){
                        todayimg1.setImageResource(R.drawable.night_night);
                    }
                    else if((todaysky1=="2")||(todaysky1=="3")){
                        todayimg1.setImageResource(R.drawable.night_cloud);
                    }
                    else if(todaysky1 =="4"){
                        todayimg1.setImageResource(R.drawable.night_cloud);
                    }
                }
                else if((todaypty1 == "1")||(todaypty1 == "2")){
                    todayimg1.setImageResource(R.drawable.night_rain);
                }
                else if(todaypty1 == "3"){
                    todayimg1.setImageResource(R.drawable.night_snow);
                }

                if(todaypty2 == "0"){
                    if(todaysky2=="1"){
                        todayimg2.setImageResource(R.drawable.night_night);
                    }
                    else if((todaysky2=="2")||(todaysky2=="3")){
                        todayimg2.setImageResource(R.drawable.night_cloud);
                    }
                    else if(todaysky2 =="4"){
                        todayimg2.setImageResource(R.drawable.night_cloud);
                    }
                }
                else if((todaypty2 == "1")||(todaypty2 == "2")){
                    todayimg2.setImageResource(R.drawable.night_rain);
                }
                else if(todaypty2 == "3"){
                    todayimg2.setImageResource(R.drawable.night_snow);
                }

                if(todaypty3 == "0"){
                    if(todaysky3=="1"){
                        todayimg3.setImageResource(R.drawable.night_sun);
                    }
                    else if((todaysky3=="2")||(todaysky3=="3")){
                        todayimg3.setImageResource(R.drawable.night_1);
                    }
                    else if(todaysky3 =="4"){
                        todayimg3.setImageResource(R.drawable.night_cloud);
                    }
                }
                else if((todaypty3 == "1")||(todaypty3 == "2")){
                    todayimg3.setImageResource(R.drawable.night_rain);
                }
                else if(todaypty3 == "3"){
                    todayimg3.setImageResource(R.drawable.night_snow);
                }

                if(todaypty4 == "0"){
                    if(todaysky4=="1"){
                        todayimg4.setImageResource(R.drawable.night_sun);
                    }
                    else if((todaysky4=="2")||(todaysky4=="3")){
                        todayimg4.setImageResource(R.drawable.night_1);
                    }
                    else if(todaysky4 =="4"){
                        todayimg4.setImageResource(R.drawable.night_cloud);
                    }
                }
                else if((todaypty4 == "1")||(todaypty4 == "2")){
                    todayimg4.setImageResource(R.drawable.night_rain);
                }
                else if(todaypty4 == "3"){
                    todayimg4.setImageResource(R.drawable.night_snow);
                }

                if(todaypty5 == "0"){
                    if(todaysky5=="1"){
                        todayimg5.setImageResource(R.drawable.night_sun);
                    }
                    else if((todaysky5=="2")||(todaysky5=="3")){
                        todayimg5.setImageResource(R.drawable.night_1);
                    }
                    else if(todaysky5 =="4"){
                        todayimg5.setImageResource(R.drawable.night_cloud);
                    }
                }
                else if((todaypty5 == "1")||(todaypty5 == "2")){
                    todayimg5.setImageResource(R.drawable.night_rain);
                }
                else if(todaypty5 == "3"){
                    todayimg5.setImageResource(R.drawable.night_snow);
                }

                if(todaypty6 == "0"){
                    if(todaysky6=="1"){
                        todayimg6.setImageResource(R.drawable.night_sun);
                    }
                    else if((todaysky6=="2")||(todaysky6=="3")){
                        todayimg6.setImageResource(R.drawable.night_1);
                    }
                    else if(todaysky6 =="4"){
                        todayimg6.setImageResource(R.drawable.night_cloud);
                    }
                }
                else if((todaypty6 == "1")||(todaypty6 == "2")){
                    todayimg6.setImageResource(R.drawable.night_rain);
                }
                else if(todaypty6 == "3"){
                    todayimg6.setImageResource(R.drawable.night_snow);
                }

                if(todaypty7 == "0"){
                    if(todaysky7=="1"){
                        todayimg7.setImageResource(R.drawable.night_sun);
                    }
                    else if((todaysky7=="2")||(todaysky7=="3")){
                        todayimg7.setImageResource(R.drawable.night_1);
                    }
                    else if(todaysky7 =="4"){
                        todayimg7.setImageResource(R.drawable.night_cloud);
                    }
                }
                else if((todaypty7 == "1")||(todaypty7 == "2")){
                    todayimg7.setImageResource(R.drawable.night_rain);
                }
                else if(todaypty7 == "3"){
                    todayimg7.setImageResource(R.drawable.night_snow);
                }

                if(todaypty8 == "0"){
                    if(todaysky8=="1"){
                        todayimg8.setImageResource(R.drawable.night_night);
                    }
                    else if((todaysky8=="2")||(todaysky8=="3")){
                        todayimg8.setImageResource(R.drawable.night_cloud);
                    }
                    else if(todaysky8 =="4"){
                        todayimg8.setImageResource(R.drawable.night_cloud);
                    }
                }
                else if((todaypty8 == "1")||(todaypty8 == "2")){
                    todayimg8.setImageResource(R.drawable.night_rain);
                }
                else if(todaypty8 == "3"){
                    todayimg8.setImageResource(R.drawable.night_snow);
                }

                if(tompty1 == "0"){
                    if(tomsky1 == "1"){
                        futureimg1.setImageResource(R.drawable.night_sun);
                    }
                    else if((tomsky1 == "2")||(tomsky1== "3")){
                        futureimg1.setImageResource((R.drawable.night_1));
                    }
                    else if(tomsky1 == "3"){
                        futureimg1.setImageResource(R.drawable.night_cloud);
                    }
                }
                else if(tompty1 == "1"||(tompty1== "2")){
                    futureimg1.setImageResource(R.drawable.night_rain);
                }
                else if(tompty1 == "3"){
                    futureimg1.setImageResource(R.drawable.night_snow);
                }

                if(tompty2 == "0"){
                    if(tomsky2 == "1"){
                        futureimg2.setImageResource(R.drawable.night_sun);
                    }
                    else if((tomsky2 == "2")||(tomsky2== "3")){
                        futureimg2.setImageResource((R.drawable.night_1));
                    }
                    else if(tomsky2 == "3"){
                        futureimg2.setImageResource(R.drawable.night_cloud);
                    }
                }
                else if(tompty2 == "1"||(tompty2== "2")){
                    futureimg2.setImageResource(R.drawable.night_rain);
                }
                else if(tompty2 == "3"){
                    futureimg2.setImageResource(R.drawable.night_snow);
                }


                if(tompty3 == "맑음") {
                    futureimg3.setImageResource((R.drawable.night_sun));
                }
                else if((tompty3 == "구름조금")||(tompty3 == "구름많음")){
                    futureimg3.setImageResource((R.drawable.night_1));
                }
                else if(tompty3 == "흐림"){
                    futureimg3.setImageResource((R.drawable.night_cloud));
                }
                else if(tompty3 == "비"){
                    futureimg3.setImageResource((R.drawable.night_rain));
                }
                else if(tompty3 == "눈"){
                    futureimg3.setImageResource((R.drawable.night_snow));
                }
                if(tompty4 == "맑음") {
                    futureimg4.setImageResource((R.drawable.night_sun));
                }
                else if((tompty4 == "구름조금")||(tompty4 == "구름많음")){
                    futureimg4.setImageResource((R.drawable.night_1));
                }
                else if(tompty4 == "흐림"){
                    futureimg4.setImageResource((R.drawable.night_cloud));
                }
                else if(tompty4 == "비"){
                    futureimg4.setImageResource((R.drawable.night_rain));
                }
                else if(tompty4 == "눈"){
                    futureimg4.setImageResource((R.drawable.night_snow));
                }
                if(tompty5 == "맑음") {
                    futureimg5.setImageResource((R.drawable.night_sun));
                }
                else if((tompty5 == "구름조금")||(tompty5 == "구름많음")){
                    futureimg5.setImageResource((R.drawable.night_1));
                }
                else if(tompty5 == "흐림"){
                    futureimg5.setImageResource((R.drawable.night_cloud));
                }
                else if(tompty5 == "비"){
                    futureimg5.setImageResource((R.drawable.night_rain));
                }
                else if(tompty5 == "눈"){
                    futureimg5.setImageResource((R.drawable.night_snow));
                }
                if(tompty6 == "맑음") {
                    futureimg6.setImageResource((R.drawable.night_sun));
                }
                else if((tompty6 == "구름조금")||(tompty6 == "구름많음")){
                    futureimg6.setImageResource((R.drawable.night_1));
                }
                else if(tompty6 == "흐림"){
                    futureimg6.setImageResource((R.drawable.night_cloud));
                }
                else if(tompty6 == "비"){
                    futureimg6.setImageResource((R.drawable.night_rain));
                }
                else if(tompty6 == "눈"){
                    futureimg6.setImageResource((R.drawable.night_snow));
                }

            }

            else if(daystate == 2){  //비가오면
                if(intdust <= 50){
                    dust_face.setBackgroundResource(R.drawable.rain_dust1);
                }
                else if((intdust <= 100)||(intdust > 50)){
                    dust_face.setBackgroundResource(R.drawable.rain_dust2);
                }
                else if((intdust <= 250)||(intdust > 100)){
                    dust_face.setBackgroundResource(R.drawable.rain_dust3);
                }
                else{
                    dust_face.setBackgroundResource(R.drawable.rain_dust4);
                }

                if(todaypty1 == "0"){
                    if(todaysky1=="1"){
                        todayimg1.setImageResource(R.drawable.rain_night);
                    }
                    else if((todaysky1=="2")||(todaysky1=="3")){
                        todayimg1.setImageResource(R.drawable.rain_cloud);
                    }
                    else if(todaysky1 =="4"){
                        todayimg1.setImageResource(R.drawable.rain_cloud);
                    }
                }
                else if((todaypty1 == "1")||(todaypty1 == "2")){
                    todayimg1.setImageResource(R.drawable.rain_rain);
                }
                else if(todaypty1 == "3"){
                    todayimg1.setImageResource(R.drawable.rain_snow);
                }

                if(todaypty2 == "0"){
                    if(todaysky2=="1"){
                        todayimg2.setImageResource(R.drawable.rain_night);
                    }
                    else if((todaysky2=="2")||(todaysky2=="3")){
                        todayimg2.setImageResource(R.drawable.rain_cloud);
                    }
                    else if(todaysky2 =="4"){
                        todayimg2.setImageResource(R.drawable.rain_cloud);
                    }
                }
                else if((todaypty2 == "1")||(todaypty2 == "2")){
                    todayimg2.setImageResource(R.drawable.rain_rain);
                }
                else if(todaypty2 == "3"){
                    todayimg2.setImageResource(R.drawable.rain_snow);
                }

                if(todaypty3 == "0"){
                    if(todaysky3=="1"){
                        todayimg3.setImageResource(R.drawable.rain_sun);
                    }
                    else if((todaysky3=="2")||(todaysky3=="3")){
                        todayimg3.setImageResource(R.drawable.rain_1);
                    }
                    else if(todaysky3 =="4"){
                        todayimg3.setImageResource(R.drawable.rain_cloud);
                    }
                }
                else if((todaypty3 == "1")||(todaypty3 == "2")){
                    todayimg3.setImageResource(R.drawable.rain_rain);
                }
                else if(todaypty3 == "3"){
                    todayimg3.setImageResource(R.drawable.rain_snow);
                }

                if(todaypty4 == "0"){
                    if(todaysky4=="1"){
                        todayimg4.setImageResource(R.drawable.rain_sun);
                    }
                    else if((todaysky4=="2")||(todaysky4=="3")){
                        todayimg4.setImageResource(R.drawable.rain_1);
                    }
                    else if(todaysky4 =="4"){
                        todayimg4.setImageResource(R.drawable.rain_cloud);
                    }
                }
                else if((todaypty4 == "1")||(todaypty4 == "2")){
                    todayimg4.setImageResource(R.drawable.rain_rain);
                }
                else if(todaypty4 == "3"){
                    todayimg4.setImageResource(R.drawable.rain_snow);
                }

                if(todaypty5 == "0"){
                    if(todaysky5=="1"){
                        todayimg5.setImageResource(R.drawable.rain_sun);
                    }
                    else if((todaysky5=="2")||(todaysky5=="3")){
                        todayimg5.setImageResource(R.drawable.rain_1);
                    }
                    else if(todaysky5 =="4"){
                        todayimg5.setImageResource(R.drawable.rain_cloud);
                    }
                }
                else if((todaypty5 == "1")||(todaypty5 == "2")){
                    todayimg5.setImageResource(R.drawable.rain_rain);
                }
                else if(todaypty5 == "3"){
                    todayimg5.setImageResource(R.drawable.rain_snow);
                }

                if(todaypty6 == "0"){
                    if(todaysky6=="1"){
                        todayimg6.setImageResource(R.drawable.rain_sun);
                    }
                    else if((todaysky6=="2")||(todaysky6=="3")){
                        todayimg6.setImageResource(R.drawable.rain_1);
                    }
                    else if(todaysky6 =="4"){
                        todayimg6.setImageResource(R.drawable.rain_cloud);
                    }
                }
                else if((todaypty6 == "1")||(todaypty6 == "2")){
                    todayimg6.setImageResource(R.drawable.rain_rain);
                }
                else if(todaypty6 == "3"){
                    todayimg6.setImageResource(R.drawable.rain_snow);
                }

                if(todaypty7 == "0"){
                    if(todaysky7=="1"){
                        todayimg7.setImageResource(R.drawable.rain_sun);
                    }
                    else if((todaysky7=="2")||(todaysky7=="3")){
                        todayimg7.setImageResource(R.drawable.rain_1);
                    }
                    else if(todaysky7 =="4"){
                        todayimg7.setImageResource(R.drawable.rain_cloud);
                    }
                }
                else if((todaypty7 == "1")||(todaypty7 == "2")){
                    todayimg7.setImageResource(R.drawable.rain_rain);
                }
                else if(todaypty7 == "3"){
                    todayimg7.setImageResource(R.drawable.rain_snow);
                }

                if(todaypty8 == "0"){
                    if(todaysky8=="1"){
                        todayimg8.setImageResource(R.drawable.rain_night);
                    }
                    else if((todaysky8=="2")||(todaysky8=="3")){
                        todayimg8.setImageResource(R.drawable.rain_cloud);
                    }
                    else if(todaysky8 =="4"){
                        todayimg8.setImageResource(R.drawable.rain_cloud);
                    }
                }
                else if((todaypty8 == "1")||(todaypty8 == "2")){
                    todayimg8.setImageResource(R.drawable.rain_rain);
                }
                else if(todaypty8 == "3"){
                    todayimg8.setImageResource(R.drawable.rain_snow);
                }

                if(tompty1 == "0"){
                    if(tomsky1 == "1"){
                        futureimg1.setImageResource(R.drawable.rain_sun);
                    }
                    else if((tomsky1 == "2")||(tomsky1== "3")){
                        futureimg1.setImageResource((R.drawable.rain_1));
                    }
                    else if(tomsky1 == "3"){
                        futureimg1.setImageResource(R.drawable.rain_cloud);
                    }
                }
                else if(tompty1 == "1"||(tompty1== "2")){
                    futureimg1.setImageResource(R.drawable.rain_rain);
                }
                else if(tompty1 == "3"){
                    futureimg1.setImageResource(R.drawable.rain_snow);
                }

                if(tompty2 == "0"){
                    if(tomsky2 == "1"){
                        futureimg2.setImageResource(R.drawable.rain_sun);
                    }
                    else if((tomsky2 == "2")||(tomsky2== "3")){
                        futureimg1.setImageResource((R.drawable.rain_1));
                    }
                    else if(tomsky2 == "3"){
                        futureimg1.setImageResource(R.drawable.rain_cloud);
                    }
                }
                else if(tompty2 == "1"||(tompty2== "2")){
                    futureimg2.setImageResource(R.drawable.rain_rain);
                }
                else if(tompty2 == "3"){
                    futureimg2.setImageResource(R.drawable.rain_snow);
                }


                if(tompty3 == "맑음") {
                    futureimg3.setImageResource((R.drawable.rain_sun));
                }
                else if((tompty3 == "구름조금")||(tompty3 == "구름많음")){
                    futureimg3.setImageResource((R.drawable.rain_1));
                }
                else if(tompty3 == "흐림"){
                    futureimg3.setImageResource((R.drawable.rain_cloud));
                }
                else if(tompty3 == "비"){
                    futureimg3.setImageResource((R.drawable.rain_rain));
                }
                else if(tompty3 == "눈"){
                    futureimg3.setImageResource((R.drawable.rain_snow));
                }
                if(tompty4 == "맑음") {
                    futureimg4.setImageResource((R.drawable.rain_sun));
                }
                else if((tompty4 == "구름조금")||(tompty4 == "구름많음")){
                    futureimg4.setImageResource((R.drawable.rain_1));
                }
                else if(tompty4 == "흐림"){
                    futureimg4.setImageResource((R.drawable.rain_cloud));
                }
                else if(tompty4 == "비"){
                    futureimg4.setImageResource((R.drawable.rain_rain));
                }
                else if(tompty4 == "눈"){
                    futureimg4.setImageResource((R.drawable.rain_snow));
                }
                if(tompty5 == "맑음") {
                    futureimg5.setImageResource((R.drawable.rain_sun));
                }
                else if((tompty5 == "구름조금")||(tompty5 == "구름많음")){
                    futureimg5.setImageResource((R.drawable.rain_1));
                }
                else if(tompty5 == "흐림"){
                    futureimg5.setImageResource((R.drawable.rain_cloud));
                }
                else if(tompty5 == "비"){
                    futureimg5.setImageResource((R.drawable.rain_rain));
                }
                else if(tompty5 == "눈"){
                    futureimg5.setImageResource((R.drawable.rain_snow));
                }
                if(tompty6 == "맑음") {
                    futureimg6.setImageResource((R.drawable.rain_sun));
                }
                else if((tompty6 == "구름조금")||(tompty6 == "구름많음")){
                    futureimg6.setImageResource((R.drawable.rain_1));
                }
                else if(tompty6 == "흐림"){
                    futureimg6.setImageResource((R.drawable.rain_cloud));
                }
                else if(tompty6 == "비"){
                    futureimg6.setImageResource((R.drawable.rain_rain));
                }
                else if(tompty6 == "눈"){
                    futureimg6.setImageResource((R.drawable.rain_snow));
                }
            }

            if(daystate == 3){  //눈이오면
                if(intdust <= 50){
                    dust_face.setBackgroundResource(R.drawable.snow_dust1);
                }
                else if((intdust <= 100)||(intdust > 50)){
                    dust_face.setBackgroundResource(R.drawable.snow_dust2);
                }
                else if((intdust <= 250)||(intdust > 100)){
                    dust_face.setBackgroundResource(R.drawable.snow_dust3);
                }
                else{
                    dust_face.setBackgroundResource(R.drawable.snow_dust4);
                }

                if(todaypty1 == "0"){
                    if(todaysky1=="1"){
                        todayimg1.setImageResource(R.drawable.snow_night);
                    }
                    else if((todaysky1=="2")||(todaysky1=="3")){
                        todayimg1.setImageResource(R.drawable.snow_cloud);
                    }
                    else if(todaysky1 =="4"){
                        todayimg1.setImageResource(R.drawable.snow_cloud);
                    }
                }
                else if((todaypty1 == "1")||(todaypty1 == "2")){
                    todayimg1.setImageResource(R.drawable.snow_rain);
                }
                else if(todaypty1 == "3"){
                    todayimg1.setImageResource(R.drawable.snow_snow);
                }

                if(todaypty2 == "0"){
                    if(todaysky2=="1"){
                        todayimg2.setImageResource(R.drawable.snow_night);
                    }
                    else if((todaysky2=="2")||(todaysky2=="3")){
                        todayimg2.setImageResource(R.drawable.snow_cloud);
                    }
                    else if(todaysky2 =="4"){
                        todayimg2.setImageResource(R.drawable.snow_cloud);
                    }
                }
                else if((todaypty2 == "1")||(todaypty2 == "2")){
                    todayimg2.setImageResource(R.drawable.snow_rain);
                }
                else if(todaypty2 == "3"){
                    todayimg2.setImageResource(R.drawable.snow_snow);
                }

                if(todaypty3 == "0"){
                    if(todaysky3=="1"){
                        todayimg3.setImageResource(R.drawable.snow_sun);
                    }
                    else if((todaysky3=="2")||(todaysky3=="3")){
                        todayimg3.setImageResource(R.drawable.snow_1);
                    }
                    else if(todaysky3 =="4"){
                        todayimg3.setImageResource(R.drawable.snow_cloud);
                    }
                }
                else if((todaypty3 == "1")||(todaypty3 == "2")){
                    todayimg3.setImageResource(R.drawable.snow_rain);
                }
                else if(todaypty3 == "3"){
                    todayimg3.setImageResource(R.drawable.snow_snow);
                }

                if(todaypty4 == "0"){
                    if(todaysky4=="1"){
                        todayimg4.setImageResource(R.drawable.snow_sun);
                    }
                    else if((todaysky4=="2")||(todaysky4=="3")){
                        todayimg4.setImageResource(R.drawable.snow_1);
                    }
                    else if(todaysky4 =="4"){
                        todayimg4.setImageResource(R.drawable.snow_cloud);
                    }
                }
                else if((todaypty4 == "1")||(todaypty4 == "2")){
                    todayimg4.setImageResource(R.drawable.snow_rain);
                }
                else if(todaypty4 == "3"){
                    todayimg4.setImageResource(R.drawable.snow_snow);
                }

                if(todaypty5 == "0"){
                    if(todaysky5=="1"){
                        todayimg5.setImageResource(R.drawable.snow_sun);
                    }
                    else if((todaysky5=="2")||(todaysky5=="3")){
                        todayimg5.setImageResource(R.drawable.snow_1);
                    }
                    else if(todaysky5 =="4"){
                        todayimg5.setImageResource(R.drawable.snow_cloud);
                    }
                }
                else if((todaypty5 == "1")||(todaypty5 == "2")){
                    todayimg5.setImageResource(R.drawable.snow_rain);
                }
                else if(todaypty5 == "3"){
                    todayimg5.setImageResource(R.drawable.snow_snow);
                }

                if(todaypty6 == "0"){
                    if(todaysky6=="1"){
                        todayimg6.setImageResource(R.drawable.snow_sun);
                    }
                    else if((todaysky6=="2")||(todaysky6=="3")){
                        todayimg6.setImageResource(R.drawable.snow_1);
                    }
                    else if(todaysky6 =="4"){
                        todayimg6.setImageResource(R.drawable.snow_cloud);
                    }
                }
                else if((todaypty6 == "1")||(todaypty6 == "2")){
                    todayimg6.setImageResource(R.drawable.snow_rain);
                }
                else if(todaypty6 == "3"){
                    todayimg6.setImageResource(R.drawable.snow_snow);
                }

                if(todaypty7 == "0"){
                    if(todaysky7=="1"){
                        todayimg7.setImageResource(R.drawable.snow_sun);
                    }
                    else if((todaysky7=="2")||(todaysky7=="3")){
                        todayimg7.setImageResource(R.drawable.snow_1);
                    }
                    else if(todaysky7 =="4"){
                        todayimg7.setImageResource(R.drawable.snow_cloud);
                    }
                }
                else if((todaypty7 == "1")||(todaypty7 == "2")){
                    todayimg7.setImageResource(R.drawable.snow_rain);
                }
                else if(todaypty7 == "3"){
                    todayimg7.setImageResource(R.drawable.snow_snow);
                }

                if(todaypty8 == "0"){
                    if(todaysky8=="1"){
                        todayimg8.setImageResource(R.drawable.snow_night);
                    }
                    else if((todaysky8=="2")||(todaysky8=="3")){
                        todayimg8.setImageResource(R.drawable.snow_cloud);
                    }
                    else if(todaysky8 =="4"){
                        todayimg8.setImageResource(R.drawable.snow_cloud);
                    }
                }
                else if((todaypty8 == "1")||(todaypty8 == "2")){
                    todayimg8.setImageResource(R.drawable.snow_rain);
                }
                else if(todaypty8 == "3"){
                    todayimg8.setImageResource(R.drawable.snow_snow);
                }

                if(tompty1 == "0"){
                    if(tomsky1 == "1"){
                        futureimg1.setImageResource(R.drawable.snow_sun);
                    }
                    else if((tomsky1 == "2")||(tomsky1== "3")){
                        futureimg1.setImageResource((R.drawable.snow_1));
                    }
                    else if(tomsky1 == "3"){
                        futureimg1.setImageResource(R.drawable.snow_cloud);
                    }
                }
                else if(tompty1 == "1"||(tompty1== "2")){
                    futureimg1.setImageResource(R.drawable.snow_rain);
                }
                else if(tompty1 == "3"){
                    futureimg1.setImageResource(R.drawable.snow_snow);
                }

                if(tompty2 == "0"){
                    if(tomsky2 == "1"){
                        futureimg2.setImageResource(R.drawable.snow_sun);
                    }
                    else if((tomsky2 == "2")||(tomsky2== "3")){
                        futureimg1.setImageResource((R.drawable.snow_1));
                    }
                    else if(tomsky2 == "3"){
                        futureimg1.setImageResource(R.drawable.snow_cloud);
                    }
                }
                else if(tompty2 == "1"||(tompty2== "2")){
                    futureimg2.setImageResource(R.drawable.snow_rain);
                }
                else if(tompty2 == "3"){
                    futureimg2.setImageResource(R.drawable.snow_snow);
                }

                if(tompty3 == "맑음") {
                    futureimg3.setImageResource((R.drawable.snow_sun));
                }
                else if((tompty3 == "구름조금")||(tompty3 == "구름많음")){
                    futureimg3.setImageResource((R.drawable.snow_1));
                }
                else if(tompty3 == "흐림"){
                    futureimg3.setImageResource((R.drawable.snow_cloud));
                }
                else if(tompty3 == "비"){
                    futureimg3.setImageResource((R.drawable.snow_rain));
                }
                else if(tompty3 == "눈"){
                    futureimg3.setImageResource((R.drawable.snow_snow));
                }
                if(tompty4 == "맑음") {
                    futureimg4.setImageResource((R.drawable.snow_sun));
                }
                else if((tompty4 == "구름조금")||(tompty4 == "구름많음")){
                    futureimg4.setImageResource((R.drawable.snow_1));
                }
                else if(tompty4 == "흐림"){
                    futureimg4.setImageResource((R.drawable.snow_cloud));
                }
                else if(tompty4 == "비"){
                    futureimg4.setImageResource((R.drawable.snow_rain));
                }
                else if(tompty4 == "눈"){
                    futureimg4.setImageResource((R.drawable.snow_snow));
                }
                if(tompty5 == "맑음") {
                    futureimg5.setImageResource((R.drawable.snow_sun));
                }
                else if((tompty5 == "구름조금")||(tompty5 == "구름많음")){
                    futureimg5.setImageResource((R.drawable.snow_1));
                }
                else if(tompty5 == "흐림"){
                    futureimg5.setImageResource((R.drawable.snow_cloud));
                }
                else if(tompty5 == "비"){
                    futureimg5.setImageResource((R.drawable.snow_rain));
                }
                else if(tompty5 == "눈"){
                    futureimg5.setImageResource((R.drawable.snow_snow));
                }
                if(tompty6 == "맑음") {
                    futureimg6.setImageResource((R.drawable.snow_sun));
                }
                else if((tompty6 == "구름조금")||(tompty6 == "구름많음")){
                    futureimg6.setImageResource((R.drawable.snow_1));
                }
                else if(tompty6 == "흐림"){
                    futureimg6.setImageResource((R.drawable.snow_cloud));
                }
                else if(tompty6 == "비"){
                    futureimg6.setImageResource((R.drawable.snow_rain));
                }
                else if(tompty6 == "눈"){
                    futureimg6.setImageResource((R.drawable.snow_snow));
                }
            }


        }
    }

    private String doDayOfWeek() {


        Calendar cal = Calendar.getInstance();

        String day = null;


        int nWeek = cal.get(Calendar.DAY_OF_WEEK);
        now1 = (TextView) findViewById(R.id.now1);
        now2 = (TextView) findViewById(R.id.now2);
        now3 = (TextView) findViewById(R.id.now3);
        now4 = (TextView) findViewById(R.id.now4);
        now5 = (TextView) findViewById(R.id.now5);
        now6 = (TextView) findViewById(R.id.now6);


        if (nWeek==7) {


            day = "일요일";

            now1.setText(day);
            now2.setText("월요일");
            now3.setText("화요일");
            now4.setText("수요일");
            now5.setText("목요일");
            now6.setText("금요일");

        }

        if (nWeek==1) {

            day = "월요일";
            now1.setText(day);
            now2.setText("화요일");
            now3.setText("수요일");
            now4.setText("목요일");
            now5.setText("금요일");
            now6.setText("토요일");
        }

        if (nWeek==2) {

            day = "화요일";
            now1.setText(day);
            now2.setText("수요일");
            now3.setText("목요일");
            now4.setText("금요일");
            now5.setText("토요일");
            now6.setText("일요일");
        }

        if (nWeek==3) {

            day = "수요일";
            now1.setText(day);
            now2.setText("목요일");
            now3.setText("금요일");
            now4.setText("토요일");
            now5.setText("일요일");
            now6.setText("월요일");
        }

        if (nWeek==4) {

            day = "목요일";

            now1.setText(day);
            now2.setText("금요일");
            now3.setText("토요일");
            now4.setText("일요일");
            now5.setText("월요일");
            now6.setText("화요일");

        }
        if (nWeek==5) {

            day = "금요일";
            now1.setText(day);
            now2.setText("토요일");
            now3.setText("일요일");
            now4.setText("월요일");
            now5.setText("화요일");
            now6.setText("수요일");

        }

        if (nWeek==6) {

            day = "토요일";

            now1.setText(day);
            now2.setText("일요일");
            now3.setText("월요일");
            now4.setText("화요일");
            now5.setText("수요일");
            now6.setText("목요일");

        }






        return day;


    }

}
