package com.chapslife.shakeshackandroid.models;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by kchapman on 11/7/13.
 */
public class ShackLocation {

    public String name;
    public String menuUrl;
    public LatLng location;
    public String mapUrl;

    public ShackLocation(String name, String menuUrl, LatLng location, String mapUrl){
        this.name = name;
        this.menuUrl = menuUrl;
        this.location = location;
        this.mapUrl = mapUrl;
    }
}
