package com.tim.bcs421_android_timothynegron_project4;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AppInfoFragment extends Fragment {

    //**********************************************************************************************
    //Method: onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
    //                             @Nullable Bundle savedInstanceState)
    //
    //Purpose: Part of Android OS Activity LifeCycle. Overriding method to return a view that will
    // set the app info fragment.
    //
    //**********************************************************************************************
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        // Add the app info fragment layout to a view object
        View view = inflater.inflate(R.layout.app_info_fragment, container, false);

        // Return the view to the app info activity layout fragment view
        return view;
    }
}
