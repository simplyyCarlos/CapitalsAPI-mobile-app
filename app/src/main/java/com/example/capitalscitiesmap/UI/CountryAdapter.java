package com.example.capitalscitiesmap.UI;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.capitalscitiesmap.Model.Country;
import com.example.capitalscitiesmap.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CountryAdapter extends
        RecyclerView.Adapter<CountryAdapter.ViewHolder> {


    private List<Country> countryList = null;

    public CountryAdapter(List<Country> countryList) {
        this.countryList = countryList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.list_item_country_list, parent, false);
        // Return a new holder instance
        return new ViewHolder(contactView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Country country = countryList.get(position);
        Log.e("IUT", Integer.toString(position));

        String name = country.getName().getCommon();
        String capitalCity = "No Capital city";
        if(country.getCapital() != null){
             capitalCity = country.getCapital().get(0);
        }
        String area = Float.toString(country.getArea());
        String population = Integer.toString((int) country.getPopulation());
        String flagURL = country.getFlags().getPng();
        String description = String.format("Capital City : %1$s\nPopulation : %2$s\nArea : %3$s km²\n",
                capitalCity, population, area);
        // Set item views based on your views and data model
        TextView countryTitle = holder.countryTitle;
        countryTitle.setText(name);
        TextView countryDescription = holder.countryDescription;
        countryDescription.setText(description);
        ImageView countryIv = holder.countryIv;
        Picasso.get().load(flagURL).into(countryIv);
    }
    @Override
    public int getItemCount() {
        return countryList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView countryTitle;
        public TextView countryDescription;
        public ImageView countryIv;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);
            countryTitle = (TextView) itemView.findViewById(R.id.item_title);
            countryDescription = (TextView) itemView.findViewById(R.id.item_description);
            countryIv = (ImageView) itemView.findViewById(R.id.item_image);

        }
    }
}
