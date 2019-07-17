package com.tim.bcs421_android_timothynegron_project4;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class AccountListActivity extends AppCompatActivity implements AccountListFragment.AccountSelectionCallback {

    private AccountDetailFragment accountDetailFragment;

    //**********************************************************************************************
    //Method: onCreate(@Nullable Bundle savedInstanceState)
    //
    //Purpose: Part of Android OS Activity LifeCycle. Overriding method to display account list
    // activity layout.
    //
    //**********************************************************************************************
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_list_activity);
    }

    //**********************************************************************************************
    //Method: accountSelected(BankAccount b)
    //
    //Purpose: Helps communicate with AccountDetailFragment. Passes the bank account that was
    // selected in the recycler view to the method in the current account detail fragment object
    // instance. The ShowAccount() method will use the BankAccount obj to set the EditText views.
    // Only gets called when the phone is in landscape mode.
    //
    //**********************************************************************************************
    @Override
    public void accountSelected(BankAccount b)
    {
        // Make a copy of the current fragment, helps call the accountSelected() method
        accountDetailFragment = (AccountDetailFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragmentAccountDetailLand);

        // Call the accountSelected(BankAccount b) method in the AccountDetailActivity
        accountDetailFragment.accountSelected(b);
    }
}
