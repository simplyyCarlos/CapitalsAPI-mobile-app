package com.example.capitalscitiesmap.UI;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.capitalscitiesmap.Model.Country;
import com.example.capitalscitiesmap.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CountryAdapter extends
        RecyclerView.Adapter<CountryAdapter.ViewHolder> {

    private List<Country> countryList;
    private List<Country> subList;
    private boolean showFavorite = false;
    private Context ctx;
    private SparseBooleanArray selectedItems = new SparseBooleanArray();

    public CountryAdapter(List<Country> countryList, Context context) {
        this.countryList = countryList;
        this.subList = new ArrayList<>();
        this.ctx = context;

    }

    @SuppressLint("NotifyDataSetChanged")
    public void setShowFavoritesOnly(boolean showFavoritesOnly) {
        if (showFavoritesOnly) {
            List<Country> favoriteList = new ArrayList<>();
            for (Country country : countryList) {
                if (country.isFavorite()) {
                    favoriteList.add(country);
                }
            }
            subList.addAll(countryList);
            countryList.clear();
            countryList.addAll(favoriteList);
            notifyDataSetChanged();
        } else {
            countryList.clear();
            countryList.addAll(subList);
            subList.clear();
            notifyDataSetChanged();
        }
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
        Country country = countryList.get(holder.getAdapterPosition());
        ImageView tmp = (ImageView) holder.itemView.findViewById(R.id.fav_icon);

            if (selectedItems.get(holder.getAdapterPosition(), false)) {
                tmp.setImageResource(R.drawable.filled_star);
                country.setFavorite(true);
            } else {
                tmp.setImageResource(0);
                country.setFavorite(false);
            }


        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                toggleSelection(countryList.indexOf(country));
                return true;
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the latitude and longitude of the clicked item

                // Launch the Maps activity
                Intent intent = new Intent(ctx, CountryMapActivity.class);
                intent.putExtra("country",country);
                view.getContext().startActivity(intent);
            }
        });




        String name = country.getName().getCommon();
        String capitalCity = "No Capital city";
        if(country.getCapital() != null){
             capitalCity = country.getCapital().get(0);
        }

        String area = Float.toString(country.getArea());
        String population = Integer.toString((int) country.getPopulation());
        String flagURL = country.getFlags().getPng();
        String description = String.format("Capital : %1$s\nPopulation : %2$s\nArea : %3$s km²\n",
                capitalCity, population, area);
        // Set item views based on your views and data model
        TextView countryTitle = holder.countryTitle;
        countryTitle.setText(name);
        TextView countryDescription = holder.countryDescription;
        countryDescription.setText(description);
        ImageView countryIv = holder.countryIv;
        Picasso.get()
                .load(flagURL)
                .resize(240,150)
                .centerCrop()
                .into(countryIv);
    }

    private void toggleSelection(int position) {
        selectedItems.put(position, !selectedItems.get(position, false));
        notifyItemChanged(position);
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
