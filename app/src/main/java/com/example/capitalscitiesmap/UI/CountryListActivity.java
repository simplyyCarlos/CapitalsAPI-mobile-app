package com.example.capitalscitiesmap.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

import com.example.capitalscitiesmap.Manager.ICountriesDataManagerCallback;
import com.example.capitalscitiesmap.Manager.CountryListActivityController;
import com.example.capitalscitiesmap.Model.Country;
import com.example.capitalscitiesmap.R;


import java.util.ArrayList;
import java.util.List;


public class CountryListActivity extends AppCompatActivity {

    private final CountryListActivityController countryListActivityController = new CountryListActivityController();

    private boolean isPushed = false;
    List<Country> countries = new ArrayList<>();
    private CountryAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_country_list);


        RecyclerView rvCountries =(RecyclerView) findViewById(R.id.recycler_country);
        getCountries();
        adapter = new CountryAdapter(countries,this);
        rvCountries.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvCountries.setLayoutManager(layoutManager);
         // Call to API to retrieve the sets of data

        ImageButton imageButton = (ImageButton) findViewById(R.id.button_fav);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Log.e("IUT","Clicked");
               isPushed = !isPushed;
               adapter.setShowFavoritesOnly(isPushed);
            }
        });
    }
    private void getCountries(){
        countryListActivityController.getCountries(new ICountriesDataManagerCallback() {
            @SuppressLint("NotifyDataSetChanged")
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