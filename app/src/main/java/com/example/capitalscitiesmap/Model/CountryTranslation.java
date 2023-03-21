package com.example.capitalscitiesmap.Model;




import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class CountryTranslation {

    @SerializedName("fra")
    @Expose
    private FrenchTranslation fra;

    public FrenchTranslation getFra() {
        return fra;
    }

    public void setFra(FrenchTranslation fra) {
        this.fra = fra;
    }

}