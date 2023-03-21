package com.example.capitalscitiesmap.Manager;

import com.example.capitalscitiesmap.Service.CountriesService;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class CountryAPIManager {
    private static CountryAPIManager instance;
    private CountriesService countriesService=null;
    private final String BASE_URL =  "https://restcountries.com/v3.1/";

   private CountryAPIManager(){
       OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
       httpClient.addInterceptor(new Interceptor() {
           @Override
           public Response intercept(Chain chain) throws IOException {
               Request original = chain.request();
               Request request = original.newBuilder()
                       .method(original.method(), original.body())
                       .build();
               return chain.proceed(request);
           }
       });
      Retrofit  retrofit = new Retrofit.Builder()
               .baseUrl(BASE_URL)
               .addConverterFactory(GsonConverterFactory.create())
               .build();
       countriesService =retrofit.create(CountriesService.class);


   }

    public CountriesService getCountriesService() {
        return countriesService;
    }

    public void setCountriesService(CountriesService countriesService) {
        this.countriesService = countriesService;
    }

    public static CountryAPIManager getInstance(){
        if(instance == null){
           instance= new CountryAPIManager();
        }
        return instance;

    }


}
