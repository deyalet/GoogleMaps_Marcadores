package com.example.googlemaps_marcadores;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.CameraUpdateFactory;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {


    private GoogleMap gMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
                mapFragment.getMapAsync(this);


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        gMap = googleMap;

        LatLng uteq = new LatLng(-1.0125584,-79.470437);
        gMap.addMarker(new MarkerOptions().position(uteq).title("Facultad Ciencias de la Ingeniería")
                .snippet("Decano: Ing. Washington Alberto Chiriboga Casanova, M.Sc. \n " +
                "Direccion: Av. Quito km. 1 1/2 vía a Santo Domingo de los Tsáchilas"));
        gMap.addMarker(new MarkerOptions().position(new LatLng(-1.012702, -79.471070)).title("Facultad Ciencias Ambientales")
                .snippet("Decana: Ing. Mercedes Susana Carranza Patiño, PhD \n" +
                "Direccion: Av. Quito km. 1 1/2 vía a Santo Domingo de los Tsáchilas"));
        gMap.addMarker(new MarkerOptions().position(new LatLng(-1.012291, -79.470152)).title("Facultad Ciencias Empresariales")
                .snippet("Decana: Ing. Mariela Susana Andrade Arias, PhD. \n " +
                "Dirección: Av. Quito km. 1 1/2 vía a Santo Domingo de los Tsáchilas"));
        gMap.addMarker(new MarkerOptions().position(new LatLng(-1.080762, -79.501744)).title("Facultad Ciencias Agropecuarias")
                .snippet("Ing. Leonardo Gonzalo Matute, M.Sc.\n " +
                "Dirección: Campus “La María”, km 7 vía Quevedo-El Empalme"));
        gMap.addMarker(new MarkerOptions().position(new LatLng(-1.081419, -79.502814)).title("Facultad de Ciencias Pecuarias")
                .snippet("Ing. Jenny Guiselli Torres Navarrete \n " +
                "Dirección: Campus “La María”, km 7 vía Quevedo-El Empalme"));

        gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(uteq, 13));
        gMap.getUiSettings().setZoomControlsEnabled(true);
        gMap.getUiSettings().setMyLocationButtonEnabled(true);

        gMap.setInfoWindowAdapter(new InfoWindowAdapter(MainActivity.this));

        gMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                marker.showInfoWindow();
                Toast.makeText(MainActivity.this, marker.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });

    }
}