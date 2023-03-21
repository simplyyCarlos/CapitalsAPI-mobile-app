package com.example.capitalscitiesmap.Service;


import com.example.capitalscitiesmap.Model.Country;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface CountriesService {
    @GET("all")
    Call<List<Country>> getCountries();
}
