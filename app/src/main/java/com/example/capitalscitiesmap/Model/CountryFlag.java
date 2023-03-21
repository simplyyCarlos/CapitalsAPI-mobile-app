package com.example.capitalscitiesmap.Model;




import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class CountryFlag {

    @SerializedName("png")
    @Expose
    private String png;
    @SerializedName("svg")
    @Expose
    private String svg;
    @SerializedName("alt")
    @Expose
    private String alt;

    public String getPng() {
        return png;
    }

    public void setPng(String png) {
        this.png = png;
    }

    public String getSvg() {
        return svg;
    }

    public void setSvg(String svg) {
        this.svg = svg;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

}