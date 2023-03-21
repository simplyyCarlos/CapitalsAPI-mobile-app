package com.example.capitalscitiesmap.Manager;


import com.example.capitalscitiesmap.Model.Country;

import java.util.List;

public interface ICountriesDataManagerCallback {

    void getCountryResponseSuccess(List<Country> listResponse);
    void getCountryResponseError(String response);
}
