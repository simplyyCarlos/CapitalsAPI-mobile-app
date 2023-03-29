package com.example.capitalscitiesmap.UI;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.capitalscitiesmap.Model.Country;
import com.example.capitalscitiesmap.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.capitalscitiesmap.databinding.ActivityCountryMapBinding;

public class CountryMapActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Country country;
    private ActivityCountryMapBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityCountryMapBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        country = getIntent().getParcelableExtra("country");

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng marker = new LatLng(country.getLatlng().get(0), country.getLatlng().get(1));

        float zoomLevel = Math.round(Math.log(8000000 / country.getArea()) / Math.log(3));
        mMap.addMarker(new MarkerOptions().position(marker).title("Marker 1"));
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(marker)
                .zoom(zoomLevel)
                .build();
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

    }
}