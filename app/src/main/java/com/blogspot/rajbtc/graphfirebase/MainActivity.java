package com.blogspot.rajbtc.graphfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MainActivity extends AppCompatActivity {
    GraphView graphView;
    PriorityQueue<Double> queue = new PriorityQueue<Double>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        graphView = findViewById(R.id.idGraphView);

        for(int i=0;i<10;i++)
            queue.add(Double.parseDouble(i+""));







    }
    double p=1;

    public void btnClick(View view) {

        if(queue.size()>8)
            queue.remove();
        queue.add(p++);

        checkChange();
    }


    void checkChange(){


        Object[] arr=queue.toArray();

        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[]{
                new DataPoint(0, (Double) arr[0]),
                new DataPoint(1,  (Double) arr[1]),
                new DataPoint(2,  (Double) arr[2]),
                new DataPoint(3,  (Double) arr[3]),
                new DataPoint(4,  (Double) arr[4]),
                new DataPoint(5,  (Double) arr[5]),
                new DataPoint(6,  (Double) arr[6]),
                new DataPoint(7,  (Double) arr[7]),
                new DataPoint(8,  (Double) arr[8])
        });
        graphView.removeAllSeries();
        graphView.setTitle("My Graph View");
        graphView.setTitleColor(R.color.purple_200);
        graphView.setTitleTextSize(18);
        graphView.addSeries(series);
    }
}