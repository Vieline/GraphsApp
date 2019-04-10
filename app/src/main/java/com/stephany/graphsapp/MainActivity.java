package com.stephany.graphsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    BarChart chart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chart = findViewById(R.id.sales_chart);

        ArrayList<BarEntry> entries=new ArrayList<>();
        entries.add(new BarEntry(0f,8f));
        entries.add(new BarEntry(1f,12f));
        entries.add(new BarEntry(2f,6f));
        entries.add(new BarEntry(3f,14f));
        entries.add(new BarEntry(4f,19f));
        entries.add(new BarEntry(5f,3f));
        entries.add(new BarEntry(6f,11f));

        BarDataSet dataSet= new BarDataSet(entries,"Sales Per Day");
        dataSet.setColors(ColorTemplate.MATERIAL_COLORS);

        final String[] days={"MON","TUE","WED","THUR","FRI","SAT","SUN"};
        ValueFormatter formatter= new ValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return days[(int)value];
            }
        };

        XAxis x = chart.getXAxis();
        x.setValueFormatter(formatter);

        BarData data=new BarData(dataSet);
        chart.setData(data);
        chart.animateXY(6000,6000);
        chart.invalidate();
    }
}
