package com.tim.bcs421_android_timothynegron_project4;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class MainFragment extends Fragment
{
    //**********************************************************************************************
    //Method: onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
    //                             @Nullable Bundle savedInstanceState)
    //
    //Purpose: Part of Android OS Activity LifeCycle. Overriding method to return a view that will
    // set the main activity fragment, also sets the image button functionality.
    //
    //**********************************************************************************************
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        // Add the activity main list fragment layout to a view object
        View view = inflater.inflate(R.layout.activity_main_fragment, container, false);

        // The the image buttons functionality on the activity main list fragment
        setImageButtons(view);

        // Return the view to the main activity layout
        return view;
    }

    //**********************************************************************************************
    //Method: setImageButtons(View view)
    //
    //Purpose: To set the button functionality of the ImageButtons that will be
    // displayed in this fragment.
    //
    //**********************************************************************************************
    private void setImageButtons(View view)
    {
        // Set functionality of Bank Account Image Button
        ImageButton imageButtonBankAccount = view.findViewById(R.id.imageButtonBankAccount);

        imageButtonBankAccount.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(getActivity(), AccountListActivity.class);
                startActivity(i); // Starts AccountListActivity
            }
        });

        // Set functionality of App Info Image Button
        ImageButton imageButtonAppInfo = view.findViewById(R.id.imageButtonAppInfo);

        imageButtonAppInfo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(getActivity(), AppInfoActivity.class);
                startActivity(i); // Starts AppInfoActivity
            }
        });
    }
}
