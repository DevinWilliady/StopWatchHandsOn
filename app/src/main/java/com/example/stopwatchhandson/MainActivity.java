package com.example.stopwatchhandson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Chronometer chronometer;
    private long pauseOffset;
    private boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chronometer = findViewById(R.id.chronometer);
    }

    public void startChronometer(View v){
        if(!running){
            chronometer.setBase(SystemClock.elapsedRealtime()-pauseOffset);
            chronometer.start();
            running=true;
        }
    }

    public void pauseChronometer(View v){
        if(running){
            chronometer.stop();
            pauseOffset=SystemClock.elapsedRealtime()-chronometer.getBase();
            running=false;
        }
    }

    public void resetChronometer(View v){
        chronometer.setBase(SystemClock.elapsedRealtime());
        pauseOffset = 0;
    }
}