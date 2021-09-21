package com.example.piled_client;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
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


    // switches
    public void  onOff(@Nullable View view){
        if (sw_onoff.isChecked()){
            new power_on().execute();
        }
        else{
            new power_off().execute();
        }
    }


    // buttons
    public void  red(@Nullable View view){
        new red().execute();
    }

    public void  green(@Nullable View view){
        new green().execute();
    }

    public void  blue(@Nullable View view){
        new blue().execute();
    }

    public void  orange(@Nullable View view){
        new orange().execute();
    }

    public void  turquoise(@Nullable View view){
        new turquoise().execute();
    }

    public void purple(@Nullable View view){
        new orange().execute();
    }

    public void yellow(@Nullable View view){
        new yellow().execute();
    }

    public void black(@Nullable View view){
        new black().execute();
    }

    public void white(@Nullable View view){
        new white().execute();
    }
}