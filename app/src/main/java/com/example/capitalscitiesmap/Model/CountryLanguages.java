package com.example.capitalscitiesmap.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CountryLanguages {

    @SerializedName("spa")
    @Expose
    private String spa;

    public String getSpa() {
        return spa;
    }

    public void setSpa(String spa) {
        this.spa = spa;
    }

}