package com.example.googlemaps_marcadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

public class InfoWindowAdapter implements GoogleMap.InfoWindowAdapter {
    Context context;
    public InfoWindowAdapter(Context context) {
        this.context = context;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        View iwView = LayoutInflater.from(context).inflate(R.layout.infowindow, null);
        TextView title = iwView.findViewById(R.id.titletxt);
        TextView snipp = iwView.findViewById(R.id.snipptxt);
        title.setText(marker.getTitle());
        snipp.setText(marker.getSnippet());

        ImageView imv = (ImageView) iwView.findViewById(R.id.logoPic);

        if(title.toString() == "Facultad Ciencias de la Ingeniería"){
            imv.setImageResource(R.mipmap.fci);
            if(title.toString() == "Facultad Ciencias Ambientales"){
                imv.setImageResource(R.mipmap.fcamb);
            }if(title.toString() == "Facultad Ciencias Empresariales"){
                imv.setImageResource(R.mipmap.fce);
            }if(title.toString() ==  "Facultad Ciencias Agropecuarias"){
                imv.setImageResource(R.mipmap.fca);
            }
        }
        else {
             imv.setImageResource(R.mipmap.fcp);
        }
        return iwView;
    }

    @Override
    public View getInfoContents(Marker marker) {
        return null;
    }
}
