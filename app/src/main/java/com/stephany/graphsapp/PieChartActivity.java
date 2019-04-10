package com.stephany.graphsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class PieChartActivity extends AppCompatActivity {
    PieChart chart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);
        chart = findViewById(R.id.chart_phones);
        Description desc = new Description();
        desc.setText("Phone MarketShare in Kenya");
        chart.setDescription(desc);

        chart.setRotationEnabled(true);
        chart.setHoleRadius(25f);
        chart.setCenterText("Phones");

        ArrayList<PieEntry>yEntries = new ArrayList<>();
        yEntries.add(new PieEntry(0f,20f));
        yEntries.add(new PieEntry(1f,10f));
        yEntries.add(new PieEntry(2f,15f));
        yEntries.add(new PieEntry(3f,6f));
        yEntries.add(new PieEntry(4f,25f));
        yEntries.add(new PieEntry(5f,29f));

        ArrayList<String> xEntries=new ArrayList<>();
        xEntries.add("Iphone");
        xEntries.add("Samsung");
        xEntries.add("Nokia");
        xEntries.add("Huawei");
        xEntries.add("BlackBerry");
        xEntries.add("HTC");

        PieDataSet dataSet=new PieDataSet(yEntries,"Share By Phones");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        dataSet.setSliceSpace(2);
        dataSet.setValueTextSize(12);

        PieData data =new PieData(dataSet);

        chart.setData(data);
        chart.animateXY(3000,3000);
        chart.invalidate();


    }
}
