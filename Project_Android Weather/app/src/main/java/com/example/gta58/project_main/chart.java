package com.example.gta58.project_main;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.List;

public class chart extends AppCompatActivity {

    LineChart chart;
    HorizontalBarChart chart1;
    int X_RANGE = 8;
    int DATA_RANGE = 30;
    ArrayList<String> labels;
    ArrayList<String> labels1;

    ArrayList<Entry> entry1;
    ArrayList<Entry> entry2;
    ArrayList<Entry> entry3;
    LineDataSet setXcomp;
    LineDataSet setXcomp2;
    BarDataSet setXcomp3;
    BarDataSet setXcomp4;
    ArrayList<ILineDataSet> lineDataSets;
    ArrayList<IBarDataSet> barDataSets;
    LineData lineData;
    BarData barData;


    @Override

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent mainvalue = getIntent();
        final String todaytx1 = mainvalue.getStringExtra("todaytx1");
        final String todaytx2 = mainvalue.getStringExtra("todaytx2");
        final String todaytx3 = mainvalue.getStringExtra("todaytx3");
        final String todaytx4 = mainvalue.getStringExtra("todaytx4");
        final String todaytx5 = mainvalue.getStringExtra("todaytx5");
        final String todaytx6 = mainvalue.getStringExtra("todaytx6");
        final String todaytx7 = mainvalue.getStringExtra("todaytx7");
        final String todaytx8 = mainvalue.getStringExtra("todaytx8");

        final String tomhigh = mainvalue.getStringExtra("tomhigh");
        final String tomlow = mainvalue.getStringExtra("tomlow");

        int today1, today2, today3, today4, today5, today6, today7, today8;
        int tomday1,tomday2,tomday3,tomday4,tomday5,tomday6,tomday7,tomday8;

        // String형을 int형으로 변환
        today1 = Integer.parseInt(todaytx1);
        today2 = Integer.parseInt(todaytx2);
        today3 = Integer.parseInt(todaytx3);
        today4 = Integer.parseInt(todaytx4);
        today5 = Integer.parseInt(todaytx5);
        today6 = Integer.parseInt(todaytx6);
        today7 = Integer.parseInt(todaytx7);
        today8 = Integer.parseInt(todaytx8);

        tomday6 = Integer.parseInt(tomhigh);
        tomday3 = Integer.parseInt(tomlow);


        tomday1 = 19;
        tomday2 = 17;
        tomday3 = 18;
        tomday4 = 22;
        tomday5 = 26;
        tomday6 = 26;
        tomday7 = 25;
        tomday8 = 22;

        setContentView(R.layout.activity_chart);

        //////////////////////////////////////////////////////////
        chart = (LineChart) findViewById(R.id.chart);
        chart1 = (HorizontalBarChart) findViewById(R.id.chart1);
        //////////////////////////////////////////////////////////


        List<Entry> entry1 = new ArrayList<Entry>();        //어제
        List<Entry> entry2 = new ArrayList<Entry>();        //오늘


        entry1.add(new Entry(tomday1, 0));
        entry1.add(new Entry(tomday2, 1));
        entry1.add(new Entry(tomday3, 2));
        entry1.add(new Entry(tomday4, 3));
        entry1.add(new Entry(tomday5, 4));
        entry1.add(new Entry(tomday6, 5));
        entry1.add(new Entry(tomday7, 6));
        entry1.add(new Entry(tomday8, 7));

        //차트 구현
        entry2.add(new Entry(today1, 0));   //오늘 00시 온도
        entry2.add(new Entry(today2, 1));   //오늘 03시 온도
        entry2.add(new Entry(today3, 2));   //오늘 06시 온도
        entry2.add(new Entry(today4, 3));   //오늘 09시 온도
        entry2.add(new Entry(today5, 4));   //오늘 12시 온도
        entry2.add(new Entry(today6, 5));   //오늘 15시 온도
        entry2.add(new Entry(today7, 6));   //오늘 18시 온도
        entry2.add(new Entry(today8, 7));   //오늘 21시 온도

        LineDataSet setXcomp = new LineDataSet(entry1, "어제");

        setXcomp.setAxisDependency(YAxis.AxisDependency.LEFT);

        setXcomp.setColor(Color.rgb(255, 192, 203));


        LineDataSet setXcomp2 = new LineDataSet(entry2, "오늘");
        setXcomp2.setAxisDependency(YAxis.AxisDependency.LEFT);


        setXcomp2.setColor(Color.rgb(250, 128, 114));
        lineDataSets = new ArrayList<ILineDataSet>();
        lineDataSets.add(setXcomp);
        lineDataSets.add(setXcomp2);

        ArrayList<String> labels = new ArrayList<String>();
        labels.add("00");
        labels.add("03");
        labels.add("06");
        labels.add("09");
        labels.add("12");
        labels.add("15");
        labels.add("18");
        labels.add("21");

        lineData = new LineData(labels, lineDataSets);
        chart.setData(lineData);
        chart.invalidate();
        chart.animateXY(2000, 2000); //애니메이션 기능 활성화

        /////////////////////////////////////////


        ArrayList<BarEntry> entry3 = new ArrayList<>();
        entry3.add(new BarEntry(tomday6, 0));            //어제
        entry3.add(new BarEntry(tomday2, 1));


// create BarEntry for Bar Group 1
        ArrayList<BarEntry> entry4 = new ArrayList<>();         //오늘
        entry4.add(new BarEntry(today6, 0));
        entry4.add(new BarEntry(today2, 1));


// creating dataset for Bar Group1
        BarDataSet setXcomp3 = new BarDataSet(entry3, "어제");

//barDataSet1.setColor(Color.rgb(0, 155, 0));

        setXcomp3.setColor(Color.rgb(255, 222, 222));


// creating dataset for Bar Group 2
        BarDataSet setXcomp4 = new BarDataSet(entry4, "오늘");
        setXcomp4.setColor(Color.rgb(255, 239, 222));

        ArrayList<String> labels1 = new ArrayList<String>();
        labels1.add("최고 기온");
        labels1.add("최저 기온");


        barDataSets = new ArrayList<IBarDataSet>();

        barDataSets.add(setXcomp3);
        barDataSets.add(setXcomp4);

// initialize the Bardata with argument labels1 and dataSet
        barData = new BarData(labels1, barDataSets);
        chart1.setData(barData);
        chart1.animateXY(2000, 2000); //애니메이션 기능 활성화


    }


}