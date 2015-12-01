package com.byteshaft.studentservice.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.byteshaft.studentservice.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class TrackFragment extends Fragment {

    private View mBaseView;
    SupportMapFragment myMapFragment;
    FragmentManager fm;
    GoogleMap mMap;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBaseView = inflater.inflate(R.layout.activity_maps, null);
        fm=getChildFragmentManager();
        myMapFragment=(SupportMapFragment) fm.findFragmentById(R.id.map);
        myMapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                mMap = googleMap;
                LatLng location1 = new LatLng(48.856612, 2.289777);
                LatLng location2 = new LatLng(48.851522, 2.304782);
                mMap.addMarker(new MarkerOptions().position(location1).title("Marker in this! ===>>"));
                mMap.addMarker(new MarkerOptions().position(location2).title("Teacher Location"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(location1));
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(48.856612, 2.289777), 12.0f));
            }
        });
        return mBaseView;
    }
}
