package com.tim.bcs421_android_timothynegron_project4;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddAccountFragment extends Fragment {

    //**********************************************************************************************
    //Method: onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
    //                             @Nullable Bundle savedInstanceState)
    //
    //Purpose: Part of Android OS Activity LifeCycle. Overriding method to return a view that will
    // set the add account fragment.
    //
    //**********************************************************************************************
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        // Add the add account frag to a view and return it to display fragment on foreground to user
        View view = inflater.inflate(R.layout.add_account_fragment, container,
                false);

        // Get memory location of views and set to variables within current scope
        final EditText editTextAddAccountName = view.findViewById(R.id.editTextAddAccountName);
        final EditText editTextAddBalance = view.findViewById(R.id.editTextAddBalance);
        Button buttonSave = view.findViewById(R.id.buttonSave);

        // Set the functionality of the save button
        setSaveButton(editTextAddAccountName, editTextAddBalance, buttonSave);

        return view;
    }

    //**********************************************************************************************
    //Method: setSaveButton(View view)
    //
    //Purpose: To set the save button functionality. Saves the string from the Edit Text control
    // by creating a Bank Account object and adding it to the Bank Account List.
    //
    //**********************************************************************************************
    private void setSaveButton(final EditText editTextAddAccountName, final EditText
            editTextAddBalance, Button buttonSave)
    {
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a new Bank Account object with strings from Edit Text that user entered
                BankAccount bankAccount = new BankAccount(editTextAddAccountName.getText().toString(),
                        Double.parseDouble(editTextAddBalance.getText().toString()));

                // Get the Bank Account List
                DataSingleton bankAccountList = DataSingleton.getINSTANCE();

                // Add the new Bank Account to the Bank Account List
                bankAccountList.addAccount(bankAccount);

                // Display a toast message to notify the user that the account was successfully added
                Toast.makeText(getActivity(), "Bank Account Successfully Added.",
                        Toast.LENGTH_SHORT).show();

                // Go back to the Account List Activity
                getActivity().finish();
            }
        });
    }
}
