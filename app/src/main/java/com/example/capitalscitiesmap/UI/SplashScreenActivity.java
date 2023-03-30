package com.example.capitalscitiesmap.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.example.capitalscitiesmap.Manager.CountryListActivityController;
import com.example.capitalscitiesmap.Manager.ICountriesDataManagerCallback;
import com.example.capitalscitiesmap.Model.Country;
import com.example.capitalscitiesmap.R;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("CustomSplashScreen")
public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(),CountryListActivity.class);
                startActivity(intent);
            }
        };
        new Handler().postDelayed(runnable,3000);

    }


}