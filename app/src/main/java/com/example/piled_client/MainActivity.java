package com.example.piled_client;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set switches
        Switch sw_onoff = findViewById(R.id.sw_onoff);
        Switch sw_sleep = findViewById(R.id.sw_sleep);
        Switch sw_officelight = findViewById(R.id.sw_officelight);

        // set buttons
        final Button red = findViewById(R.id.btn_red);
        final Button green = findViewById(R.id.btn_green);
        final Button blue = findViewById(R.id.btn_blue);
        final Button orange = findViewById(R.id.btn_orange);
        final Button turquoise = findViewById(R.id.btn_turquoise);
        final Button purple = findViewById(R.id.btn_purple);
        final Button yellow = findViewById(R.id.btn_yellow);
        final Button black = findViewById(R.id.btn_black);
        final Button white = findViewById(R.id.btn_white);

        // wire switches to networking classes
        sw_onoff.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (sw_onoff.isChecked()){
                new power_on().execute();
            }
            else{
                new power_off().execute();
            }
        });

        sw_sleep.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (sw_sleep.isChecked()){
                new power_on().execute();
            }
            else{
                new power_off().execute();
            }
        });

        sw_officelight.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (sw_officelight.isChecked()){
                new power_on().execute();
            }
            else{
                new power_off().execute();
            }
        });

        // wire buttons to networking classes
        red.setOnClickListener(v -> new red().execute());

        green.setOnClickListener(v -> new green().execute());

        blue.setOnClickListener(v -> new blue().execute());

        orange.setOnClickListener(v -> new orange().execute());

        turquoise.setOnClickListener(v -> new orange().execute());

        purple.setOnClickListener(v -> new purple().execute());

        yellow.setOnClickListener(v -> new yellow().execute());

        black.setOnClickListener(v -> new yellow().execute());

        white.setOnClickListener(v -> new white().execute());
    }
}