package com.example.capitalscitiesmap.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Country implements Parcelable {

    @SerializedName("name")
    @Expose
    private CountryName name;
    @SerializedName("capital")
    @Expose
    private List<String> capital;
    @SerializedName("region")
    @Expose
    private String region;
    @SerializedName("languages")
    @Expose
    private CountryLanguages languages;
    @SerializedName("translations")
    @Expose
    private CountryTranslation translations;
    @SerializedName("latlng")
    @Expose
    private List<Float> latlng;
    @SerializedName("area")
    @Expose
    private float area;
    @SerializedName("population")
    @Expose
    private float population;
    @SerializedName("continents")
    @Expose
    private List<String> continents;
    @SerializedName("flags")
    @Expose
    private CountryFlag flags;
    @SerializedName("capitalInfo")
    @Expose
    private CapitalInfo capitalInfo;
    private boolean isFavorite = false;

    protected Country(Parcel in) {
        capital = in.createStringArrayList();
        region = in.readString();
        latlng = new ArrayList<>();
        in.readList(latlng, Float.class.getClassLoader());
        area = in.readFloat();
        population = in.readFloat();
        continents = in.createStringArrayList();
        in.readList(continents, String.class.getClassLoader());
        flags = in.readParcelable(CountryFlag.class.getClassLoader());
        capitalInfo = in.readParcelable(CapitalInfo.class.getClassLoader());
        isFavorite = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringList(capital);
        dest.writeString(region);
        dest.writeList(latlng);
        dest.writeFloat(area);
        dest.writeFloat(population);
        dest.writeStringList(continents);
        dest.writeByte((byte) (isFavorite ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Country> CREATOR = new Creator<Country>() {
        @Override
        public Country createFromParcel(Parcel in) {
            return new Country(in);
        }

        @Override
        public Country[] newArray(int size) {
            return new Country[size];
        }
    };

    public void setArea(float area) {
        this.area = area;
    }

    public void setPopulation(float population) {
        this.population = population;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public CountryName getName() {
        return name;
    }

    public void setName(CountryName name) {
        this.name = name;
    }

    public List<String> getCapital() {
        return capital;
    }

    public void setCapital(List<String> capital) {
        this.capital = capital;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public CountryLanguages getLanguages() {
        return languages;
    }

    public void setLanguages(CountryLanguages languages) {
        this.languages = languages;
    }

    public CountryTranslation getTranslations() {
        return translations;
    }

    public void setTranslations(CountryTranslation translations) {
        this.translations = translations;
    }

    public List<Float> getLatlng() {
        return latlng;
    }

    public void setLatlng(List<Float> latlng) {
        this.latlng = latlng;
    }

    public float getArea() {
        return area;
    }

    public float getPopulation() {
        return population;
    }

    public List<String> getContinents() {
        return continents;
    }

    public void setContinents(List<String> continents) {
        this.continents = continents;
    }

    public CountryFlag getFlags() {
        return flags;
    }

    public void setFlags(CountryFlag flags) {
        this.flags = flags;
    }

    public CapitalInfo getCapitalInfo() {
        return capitalInfo;
    }

    public void setCapitalInfo(CapitalInfo capitalInfo) {
        this.capitalInfo = capitalInfo;
    }
}
