package com.tim.bcs421_android_timothynegron_project4;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class AccountDetailFragment extends Fragment implements AccountListFragment.AccountSelectionCallback{

    private EditText editTextAccountName;
    private EditText editTextBalance;
    private BankAccount bankAccount;
    private Intent intent;
    private DataSingleton bankAccountList = DataSingleton.getINSTANCE();
    private int orientation;

    //**********************************************************************************************
    //Method: onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
    //                             @Nullable Bundle savedInstanceState)
    //
    //Purpose: Part of Android OS Activity LifeCycle. Overriding method to return a view that will
    // set the account detail fragment.
    //
    //**********************************************************************************************
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.account_detail_fragment, container, false);

        // Initialize the Edit Text views
        initializeEditText(view);

        // Set the EditText views if the phone is in Portrait Mode
        showAccountPortraitMode();

        // Return view to Account Detail Activity
        return view;
    }

    //**********************************************************************************************
    //Method: initializeEditText(View view)
    //
    //Purpose: To initialize the edit text member variables.
    //
    //**********************************************************************************************
    private void initializeEditText(View view)
    {
        editTextAccountName = view.findViewById(R.id.editTextAccountName);
        editTextBalance = view.findViewById(R.id.editTextBalance);
    }

    //**********************************************************************************************
    //Method: showAccountPortraitMode(BankAccount bankAccount)
    //
    //Purpose: To set the EditText view with string values based on details about the bank account
    // that was selected. Only sets the views if the phone is in portrait mode. If the phone is in
    // Landscape mode, showAccountLandscapeMode will be called.
    //
    //**********************************************************************************************
    private void showAccountPortraitMode()
    {
        // Get the screens current orientation
        orientation = getResources().getConfiguration().orientation;

        // Check if phone is in portrait mode
        if(orientation == Configuration.ORIENTATION_PORTRAIT)
        {
            // In portrait mode

            // Get the Intent obj from Account List Activity
            intent = getActivity().getIntent();

            // Get the account selected in the recycler view and set it to the bankAccount obj member variable
            bankAccount = bankAccountList.getBankAccountByName
                    (intent.getStringExtra("AccountName"));

            // Set the account name on the edit text view
            editTextAccountName.setText(bankAccount.getName());

            // Set the account balance on the edit text view
            editTextBalance.setText(Double.toString(bankAccount.getBalance()));
        }
    }

    //**********************************************************************************************
    //Method: showAccountLandscapeMode(BankAccount bankAccount)
    //
    //Purpose: To display the account name and balance. Only gets called when phone is in landscape
    // mode.
    //
    //**********************************************************************************************
    private void showAccountLandscapeMode(BankAccount b)
    {
        // Set the account name on the edit text view
        editTextAccountName.setText(b.getName());

        // Set the account balance on the edit text view
        editTextBalance.setText(Double.toString(b.getBalance()));
    }

    //**********************************************************************************************
    //Method: accountSelected(BankAccount b)
    //
    //Purpose: Helps communication between fragments. Only gets called when phone is in landscape
    // mode.
    //
    //**********************************************************************************************
    @Override
    public void accountSelected(BankAccount b)
    {
        showAccountLandscapeMode(b);
    }
}
