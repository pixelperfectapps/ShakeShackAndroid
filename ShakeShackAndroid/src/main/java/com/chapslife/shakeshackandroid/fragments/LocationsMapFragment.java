package com.chapslife.shakeshackandroid.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chapslife.shakeshackandroid.R;
import com.chapslife.shakeshackandroid.utils.Constants;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.location.LocationClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by lkchapman on 10/29/13.
 */
public class LocationsMapFragment extends MapFragment implements GooglePlayServicesClient.ConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener, GoogleMap.OnMarkerClickListener, GoogleMap.OnInfoWindowClickListener, GoogleMap.InfoWindowAdapter {

    private LocationClient mLocationClient;
    private GoogleMap googleMap;

    public LocationsMapFragment() {
        super();
    }

    public static LocationsMapFragment newInstance() {
        LocationsMapFragment fragment = new LocationsMapFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        mLocationClient = new LocationClient(getActivity(), this, this);
        return view;
    }

    @Override
    public void onResume(){
        // Connect the client.
        mLocationClient.connect();
        super.onResume();
    }

    @Override
    public void onPause(){
        mLocationClient.disconnect();
        super.onPause();
    }

    @Override
    public void onConnected(Bundle bundle) {
        googleMap = getMap();
        UiSettings settings = googleMap.getUiSettings();
        googleMap.setMyLocationEnabled(true);
        Location myLocation = mLocationClient.getLastLocation();
        double latitude = myLocation.getLatitude();
        double longitude = myLocation.getLongitude();
        LatLng latLng = new LatLng(latitude, longitude);
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(14));
        googleMap.setOnMarkerClickListener(this);
        googleMap.setOnInfoWindowClickListener(this);
        googleMap.setInfoWindowAdapter(this);
        googleMap.addMarker(new MarkerOptions()
                .position(Constants.LATLNG_WESTPORT)
                .title(Constants.WESTPORT));
        addMarkers();
    }

    private void addMarkers(){
        googleMap.addMarker(new MarkerOptions()
                .position(Constants.LATLNG_BKLYN)
                .title(Constants.BKLYN));
        googleMap.addMarker(new MarkerOptions()
                .position(Constants.LATLNG_BPC)
                .title(Constants.BPC));
        googleMap.addMarker(new MarkerOptions()
                .position(Constants.LATLNG_GST)
                .title(Constants.GST));
        googleMap.addMarker(new MarkerOptions()
                .position(Constants.LATLNG_JFK_T4)
                .title(Constants.JFK_T4));
        googleMap.addMarker(new MarkerOptions()
                .position(Constants.LATLNG_MSP)
                .title(Constants.MSP));
        googleMap.addMarker(new MarkerOptions()
                .position(Constants.LATLNG_SHITI_FIELD)
                .title(Constants.SHITI_FIELD));
        googleMap.addMarker(new MarkerOptions()
                .position(Constants.LATLNG_SSNY)
                .title(Constants.SSNY));
        googleMap.addMarker(new MarkerOptions()
                .position(Constants.LATLNG_TD)
                .title(Constants.TD));
        googleMap.addMarker(new MarkerOptions()
                .position(Constants.LATLNG_UES)
                .title(Constants.UES));
        googleMap.addMarker(new MarkerOptions()
                .position(Constants.LATLNG_UWS)
                .title(Constants.UWS));
        googleMap.addMarker(new MarkerOptions()
                .position(Constants.LATLNG_WBY)
                .title(Constants.WBY));
        googleMap.addMarker(new MarkerOptions()
                .position(Constants.LATLNG_WESTPORT)
                .title(Constants.WESTPORT));
        googleMap.addMarker(new MarkerOptions()
                .position(Constants.LATLNG_NEW_HAVEN)
                .title(Constants.NEW_HAVEN));
        googleMap.addMarker(new MarkerOptions()
                .position(Constants.LATLNG_S_BEACH)
                .title(Constants.S_BEACH));
        googleMap.addMarker(new MarkerOptions()
                .position(Constants.LATLNG_CORAL_GABLES)
                .title(Constants.CORAL_GABLES));
        googleMap.addMarker(new MarkerOptions()
                .position(Constants.LATLNG_BOCA)
                .title(Constants.BOCA));
        googleMap.addMarker(new MarkerOptions()
                .position(Constants.LATLNG_CENTER_CITY)
                .title(Constants.CENTER_CITY));
        googleMap.addMarker(new MarkerOptions()
                .position(Constants.LATLNG_U_CITY)
                .title(Constants.U_CITY));
        googleMap.addMarker(new MarkerOptions()
                .position(Constants.LATLNG_KOP)
                .title(Constants.KOP));
        googleMap.addMarker(new MarkerOptions()
                .position(Constants.LATLNG_DUPONT_CIRCLE)
                .title(Constants.DUPONT_CIRCLE));
        googleMap.addMarker(new MarkerOptions()
                .position(Constants.LATLNG_NATS_PARK)
                .title(Constants.NATS_PARK));
        googleMap.addMarker(new MarkerOptions()
                .position(Constants.LATLNG_F_STREET)
                .title(Constants.F_STREET));
        googleMap.addMarker(new MarkerOptions()
                .position(Constants.LATLNG_CHESNUT_HILL)
                .title(Constants.CHESNUT_HILL));
    }
    @Override
    public void onDisconnected() {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

    @Override
    public boolean onMarkerClick(Marker marker) {

        return false;
    }

    @Override
    public void onInfoWindowClick(Marker marker) {

    }

    @Override
    public View getInfoWindow(Marker marker) {
        View view = getActivity().getLayoutInflater().inflate(R.layout.item_info_adapter, null);
        TextView itemName = (TextView) view.findViewById(R.id.itemName);
        itemName.setText(marker.getTitle());
        return view;
    }

    @Override
    public View getInfoContents(Marker marker) {

        return null;
    }
}
