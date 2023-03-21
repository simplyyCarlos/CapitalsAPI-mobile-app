package com.example.capitalscitiesmap.Model;



import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class CapitalInfo {

    @SerializedName("latlng")
    @Expose
    private List<Float> latlng;

    public List<Float> getLatlng() {
        return latlng;
    }

    public void setLatlng(List<Float> latlng) {
        this.latlng = latlng;
    }

}