package com.example.capitalscitiesmap.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.example.capitalscitiesmap.Manager.ICountriesDataManagerCallback;
import com.example.capitalscitiesmap.Manager.CountryListActivityController;
import com.example.capitalscitiesmap.Model.Country;
import com.example.capitalscitiesmap.R;


import java.util.ArrayList;
import java.util.List;


public class CountryListActivity extends AppCompatActivity {

    private final CountryListActivityController countryListActivityController = new CountryListActivityController();
    List<Country> countries = new ArrayList<>();
    private RecyclerView.LayoutManager layoutManager;
    private CountryAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_country_list);
        RecyclerView rvCountries =(RecyclerView) findViewById(R.id.recycler_country);

        adapter = new CountryAdapter(countries);
        rvCountries.setAdapter(adapter);

        layoutManager = new LinearLayoutManager(this);
        rvCountries.setLayoutManager(layoutManager);
        getCountries(); // Call to API to retrieve the sets of data
    }

    private void getCountries(){
        countryListActivityController.getCountries(new ICountriesDataManagerCallback() {
            @Override
            public void getCountryResponseSuccess(List<Country> listResponse) {
                countries.addAll(listResponse);
                adapter.notifyDataSetChanged();


            }

            @Override
            public void getCountryResponseError(String response) {
                Log.e("CountryApp",response);
            }
        });
    }
}