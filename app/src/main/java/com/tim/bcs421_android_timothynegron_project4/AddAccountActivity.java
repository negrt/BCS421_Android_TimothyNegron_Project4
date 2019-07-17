package com.tim.bcs421_android_timothynegron_project4;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class AddAccountActivity extends AppCompatActivity {

    //**********************************************************************************************
    //Method: onCreate(@Nullable Bundle savedInstanceState)
    //
    //Purpose: Part of Android OS Activity LifeCycle. Overriding method to display the add account
    // activity.
    //
    //**********************************************************************************************
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_account_activity);
    }
}
