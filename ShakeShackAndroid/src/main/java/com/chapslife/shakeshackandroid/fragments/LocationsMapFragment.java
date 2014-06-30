package com.chapslife.shakeshackandroid.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
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
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
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
                        //.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_action_place_green))
                .snippet(Constants.URL_BKLYN)
                .title(Constants.BKLYN));
        googleMap.addMarker(new MarkerOptions()
                .position(Constants.LATLNG_BPC)
                        //.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_action_place_green))
                .snippet(Constants.URL_BPC)
                .title(Constants.BPC));
        googleMap.addMarker(new MarkerOptions()
                .position(Constants.LATLNG_GST)
                        //.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_action_place_green))
                .snippet(Constants.URL_GST)
                .title(Constants.GST));
        googleMap.addMarker(new MarkerOptions()
                .position(Constants.LATLNG_JFK_T4)
                        //.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_action_place_green))
                .snippet(Constants.URL_JFK_T4)
                .title(Constants.JFK_T4));
        googleMap.addMarker(new MarkerOptions()
                .position(Constants.LATLNG_MSP)
                        //.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_action_place_green))
                .snippet(Constants.URL_MSP)
                .title(Constants.MSP));
        googleMap.addMarker(new MarkerOptions()
                .position(Constants.LATLNG_SHITI_FIELD)
                        //.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_action_place_green))
                .snippet(Constants.URL_SHITI_FIELD)
                .title(Constants.SHITI_FIELD));
        googleMap.addMarker(new MarkerOptions()
                .position(Constants.LATLNG_SSNY)
                        //.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_action_place_green))
                .snippet(Constants.URL_SSNY)
                .title(Constants.SSNY));
        googleMap.addMarker(new MarkerOptions()
                .position(Constants.LATLNG_TD)
                        //.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_action_place_green))
                .snippet(Constants.URL_TD)
                .title(Constants.TD));
        googleMap.addMarker(new MarkerOptions()
                .position(Constants.LATLNG_UES)
                        //.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_action_place_green))
                .snippet(Constants.URL_UES)
                .title(Constants.UES));
        googleMap.addMarker(new MarkerOptions()
                .position(Constants.LATLNG_UWS)
                        //.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_action_place_green))
                .snippet(Constants.URL_UWS)
                .title(Constants.UWS));
        googleMap.addMarker(new MarkerOptions()
                .position(Constants.LATLNG_WBY)
                        //.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_action_place_green))
                .snippet(Constants.URL_WBY)
                .title(Constants.WBY));
        googleMap.addMarker(new MarkerOptions()
                .position(Constants.LATLNG_WESTPORT)
                        //.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_action_place_green))
                .snippet(Constants.URL_WESTPORT)
                .title(Constants.WESTPORT));
        googleMap.addMarker(new MarkerOptions()
                .position(Constants.LATLNG_NEW_HAVEN)
                        //.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_action_place_green))
                .snippet(Constants.URL_NEW_HAVEN)
                .title(Constants.NEW_HAVEN));
        googleMap.addMarker(new MarkerOptions()
                .position(Constants.LATLNG_S_BEACH)
                        //.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_action_place_green))
                .snippet(Constants.URL_S_BEACH)
                .title(Constants.S_BEACH));
        googleMap.addMarker(new MarkerOptions()
                .position(Constants.LATLNG_CORAL_GABLES)
                        //.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_action_place_green))
                .snippet(Constants.URL_CORAL_GABLES)
                .title(Constants.CORAL_GABLES));
        googleMap.addMarker(new MarkerOptions()
                .position(Constants.LATLNG_BOCA)
                //.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_action_place_green))
                .snippet(Constants.URL_BOCA)
                .title(Constants.BOCA));
        googleMap.addMarker(new MarkerOptions()
                .position(Constants.LATLNG_CENTER_CITY)
                        //.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_action_place_green))
                .snippet(Constants.URL_CENTER_CITY)
                .title(Constants.CENTER_CITY));
        googleMap.addMarker(new MarkerOptions()
                .position(Constants.LATLNG_U_CITY)
                        //.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_action_place_green))
                .snippet(Constants.URL_U_CITY)
                .title(Constants.U_CITY));
        googleMap.addMarker(new MarkerOptions()
                .position(Constants.LATLNG_KOP)
                        //.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_action_place_green))
                .snippet(Constants.URL_KOP)
                .title(Constants.KOP));
        googleMap.addMarker(new MarkerOptions()
                .position(Constants.LATLNG_DUPONT_CIRCLE)
                        //.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_action_place_green))
                .snippet(Constants.URL_DUPONT_CIRCLE)
                .title(Constants.DUPONT_CIRCLE));
        googleMap.addMarker(new MarkerOptions()
                .position(Constants.LATLNG_NATS_PARK)
                        //.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_action_place_green))
                .snippet(Constants.URL_NATS_PARK)
                .title(Constants.NATS_PARK));
        googleMap.addMarker(new MarkerOptions()
                .position(Constants.LATLNG_F_STREET)
                        //.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_action_place_green))
                .title(Constants.F_STREET));
        googleMap.addMarker(new MarkerOptions()
                .position(Constants.LATLNG_CHESNUT_HILL)
                        //.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_action_place_green))
                .snippet(Constants.URL_CHESNUT_HILL)
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
        if(marker.getSnippet() != null && marker.getSnippet().length() > 0){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(marker.getSnippet()));
            startActivity(intent);
        }
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
