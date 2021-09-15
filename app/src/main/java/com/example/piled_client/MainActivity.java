package com.example.piled_client;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    Switch sw_onoff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sw_onoff = findViewById(R.id.sw_onoff);
    }

    public void  onOff(@Nullable View view){
        if (sw_onoff.isChecked()){
            new power_on().execute();
        }
        else{
            new power_off().execute();
        }
    }
}