package com.tim.bcs421_android_timothynegron_project4;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class AccountListFragment extends Fragment
{
    private Button buttonAddAccount;
    private RecyclerView recyclerView;
    private AccountAdapter accountAdapter;
    private Intent intent;

    //**********************************************************************************************
    // Note: When AccountListFragment obj is constructed for the first time, this is where the
    // DataSingleton obj gets constructed for the first time.
    //**********************************************************************************************
    private DataSingleton bankAccountList = DataSingleton.getINSTANCE();

    // AccountListFragment keeps reference to activity implementing the callback interface
    private AccountSelectionCallback callback;

    //**********************************************************************************************
    //Method: onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
    //                             @Nullable Bundle savedInstanceState)
    //
    //Purpose: Part of Android OS Activity LifeCycle. Overriding method to return a view that will
    // set the account list fragment. Also add functionality to the add account button.
    //
    //**********************************************************************************************
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        // Add the account list fragment layout to a view object
        View view = inflater.inflate(R.layout.account_list_fragment, container, false);

        // Set the fragment's add account button
        setAddAccountButton(view);

        // Construct Account Adapter obj
        initializeAdapter();

        // Set RecyclerView
        setRecyclerView(view);

        // Set the RecyclerView Click listener
        setRecyclerViewClickListener();

        // Keep the recycler view updated when the view gets created again
        updateRecyclerViewData();

        // Return the view object to the Account List Activity
        return view;
    }

    //**********************************************************************************************
    //Method: setAddAccountButton(View view)
    //
    //Purpose: To set the add account button functionality. Creates an intent object that adds the
    // new activity to start and then passes the intent to startActivity().
    //
    //**********************************************************************************************
    private void setAddAccountButton(View view)
    {
        // Initialize the button obj variable to the button obj in the account list activity
        buttonAddAccount = view.findViewById(R.id.buttonAddAccount);

        // Set the button to have an on click listener to help start the add account activity
        buttonAddAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Pass add account activity class as a parameter
                intent = new Intent(getActivity(), AddAccountActivity.class);

                // Start add account activity
                startActivity(intent);
            }
        });
    }

    //**********************************************************************************************
    //Method: initializeAdapter()
    //
    //Purpose: To construct an account adapter obj. Passes the bank account list obj as a parameter.
    //
    //**********************************************************************************************
    public void initializeAdapter()
    {
        accountAdapter = new AccountAdapter(bankAccountList);
    }

    //**********************************************************************************************
    //Method: setRecyclerView(View view)
    //
    //Purpose: To add the item animator, layout manager, and adapter to the recycler view.
    //
    //**********************************************************************************************
    private void setRecyclerView(View view)
    {
        // Initialize the recyclerView variable to the recycler view obj in the account list layout
        recyclerView = view.findViewById(R.id.accountRecyclerView);

        // Must set the item animator, using default item animator
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        // Add the account list activity to recycler view layout manager
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);

        // Add the adapter to the recycler view.
        recyclerView.setAdapter(accountAdapter);
    }

    //**********************************************************************************************
    //Method: setRecyclerView(View view)
    //
    //Purpose: To listen for a click in the recycler view.
    //
    //**********************************************************************************************
    private void setRecyclerViewClickListener()
    {
        accountAdapter.setOnAccountClickListener(new AccountAdapter.AccountAdapterListener()
        {
            //**********************************************************************************************
            //Method: onAccountClick(int position)
            //
            //Purpose: When a account is clicked in the recycler view, onAccountClick will be called
            // and will pass the index of the account that was picked in the recycler view.
            //
            //**********************************************************************************************
            @Override
            public void onAccountClick(int position)
            {
                // Get the current orientation of the device
                int orientation = getResources().getConfiguration().orientation;

                // Check the orientation
                if(orientation == Configuration.ORIENTATION_LANDSCAPE)
                {
                    // In landscape mode

                    // Call account selected and pass the bank account that was selected as a parameter
                    callback.accountSelected(bankAccountList.getBankAccount(position));
                }
                else {
                    // In portrait mode

                    // Get the name of the account that was selected
                    String selectedAccount = bankAccountList.getBankAccount(position).getName();

                    // Create the intent object and pass the activity to start
                    intent = new Intent(getActivity(), AccountDetailActivity.class);

                    // Put data in the intent, put the account name in the intent
                    intent.putExtra("AccountName", selectedAccount);

                    // Start the new activity that the intent was constructed with
                    startActivity(intent);
                }
            }
        });
    }

    //**********************************************************************************************
    //Method: updateRecyclerViewData()
    //
    //Purpose: Notify recycler view of any changes in the account list. Stat method inherited from
    // parent class.
    //
    //**********************************************************************************************
    private void updateRecyclerViewData()
    {
        accountAdapter.notifyDataSetChanged(); // Update the recycler view
    }

    //**********************************************************************************************
    //Interface: AccountSelectionCallback
    //
    //Purpose: To define a callback interface. Helps to communicate with AccountDetailFragment.
    //
    //**********************************************************************************************
    public interface AccountSelectionCallback
    {
        void accountSelected(BankAccount b); // Defined in AccountListActivity
    }

    //**********************************************************************************************
    //Method: onAttach(Context context)
    //
    //Purpose: To set the callback reference.
    //
    //**********************************************************************************************
    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);

        // Must set callback reference in onAttach method
        callback = (AccountSelectionCallback) context;

    }
}
