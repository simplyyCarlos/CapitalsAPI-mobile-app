package com.example.capitalscitiesmap.Manager;
import android.util.Log;

import com.example.capitalscitiesmap.Model.Country;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivityController {
    private final CountryAPIManager apiManager;

    public MainActivityController(){
        apiManager = CountryAPIManager.getInstance();

    }

    public void getCountries(ICountriesDataManagerCallback callBack) {
        Call<List<Country>> countriesResponseCall = apiManager.getCountriesService().getCountries();

        countriesResponseCall.enqueue(new Callback<List<Country>>() {
            @Override
            public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {
                if (response.isSuccessful()) {
                    List<Country> countries = response.body();
                    callBack.getCountryResponseSuccess(countries);
                }else{
                    Log.e("IUT", "Erreur bg");
                }
            }

            @Override
            public void onFailure(Call<List<Country>> call, Throwable t) {
                Log.e("IUT",t.getMessage());
            }
        });



    }

}
