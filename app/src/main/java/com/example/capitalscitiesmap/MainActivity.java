package com.example.capitalscitiesmap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.capitalscitiesmap.Manager.ICountriesDataManagerCallback;
import com.example.capitalscitiesmap.Manager.MainActivityController;
import com.example.capitalscitiesmap.Model.Country;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private final MainActivityController mainActivityController = new MainActivityController();
    List<Country> countries = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getCountries();


    }

    private void getCountries(){
        mainActivityController.getCountries(new ICountriesDataManagerCallback() {
            @Override
            public void getCountryResponseSuccess(List<Country> listResponse) {
                countries = listResponse;
            }

            @Override
            public void getCountryResponseError(String response) {
                Log.e("CountryApp",response);
            }
        });
    }
}