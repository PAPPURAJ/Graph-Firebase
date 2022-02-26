package com.blogspot.rajbtc.graphfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
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
    ArrayList<Double> arrayList = new ArrayList<>();
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        graphView = findViewById(R.id.idGraphView);


        firebaseDatabase.getReference("Biofloc").child("Temp").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                double val = snapshot.getValue(Double.class);

                arrayList.add(val);

                checkChange();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }


    void checkChange() {

        LineGraphSeries<DataPoint> series = new LineGraphSeries<>();

        for (int i = 0; i < arrayList.size(); i++) {
            DataPoint point = new DataPoint(i, arrayList.get(i));
            series.appendData(point, true, arrayList.size());

        }


        graphView.removeAllSeries();
        graphView.setTitle("My Graph View");
        graphView.setTitleColor(R.color.purple_200);
        graphView.setTitleTextSize(18);
        graphView.addSeries(series);
    }
}