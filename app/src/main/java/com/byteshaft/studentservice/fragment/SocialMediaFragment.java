package com.byteshaft.studentservice.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.byteshaft.studentservice.R;

public class SocialMediaFragment extends Fragment {

    private View mBaseView;
    FragmentManager fm;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBaseView = inflater.inflate(R.layout.social_media_fragment, null);
        fm=getChildFragmentManager();
        return mBaseView;
    }
}
