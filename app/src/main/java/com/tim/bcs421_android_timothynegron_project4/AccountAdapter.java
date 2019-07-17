package com.tim.bcs421_android_timothynegron_project4;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class AccountAdapter extends RecyclerView.Adapter<AccountAdapter.AccountViewHolderClass>
{
    // Attributes
    private DataSingleton bankAccountList;
    private AccountAdapterListener listener;

    //**********************************************************************************************
    //Method: AccountAdapter(DataSingleton bankAccountList)
    //
    //Purpose: Constructs an account adapter and takes a DataSingleton obj as a parameter.
    //
    //**********************************************************************************************
    public AccountAdapter(DataSingleton bankAccountList)
    {
        this.bankAccountList = bankAccountList;
    }

    //**********************************************************************************************
    //interface: AccountAdapterListener
    //
    //Purpose: Custom listener interface.
    //
    //**********************************************************************************************
    public interface AccountAdapterListener
    {
        void onAccountClick(int position);
    }

    //**********************************************************************************************
    //Method: setOnAccountClickListener(AccountAdapterListener listener)
    //
    //Purpose: Sets the account adapter listener.
    //
    //**********************************************************************************************
    public void setOnAccountClickListener(AccountAdapterListener listener)
    {
        this.listener = listener;
    }

    //**********************************************************************************************
    //Method: onCreateViewHolder(@NonNull ViewGroup parent, int i)
    //
    //Purpose: To add the recycler view to the account list activity.
    //
    //**********************************************************************************************
    @NonNull
    @Override
    public AccountAdapter.AccountViewHolderClass onCreateViewHolder(@NonNull ViewGroup parent, int i)
    {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.account_recyclerview, parent, false);

        return new AccountViewHolderClass(itemView);
    }

    //**********************************************************************************************
    //Method: onBindViewHolder(@NonNull AccountAdapter.AccountViewHolderClass holder, int position)
    //
    //Purpose: To bind all the bank accounts in the bank account list to the recycler view.
    //
    //**********************************************************************************************
    @Override
    public void onBindViewHolder(@NonNull AccountAdapter.AccountViewHolderClass holder, int position)
    {

        // Get the bank account from the list
        BankAccount bankAccount = bankAccountList.getBankAccount(position);

        // Bind the bank account name to the text view in the recycler view
        holder.textViewForRecycler.setText(bankAccount.getName());
    }

    //**********************************************************************************************
    //Method: getItemCount()
    //
    //Purpose: Returns the number of accounts on the bank account list. Override method.
    //
    //**********************************************************************************************
    @Override
    public int getItemCount()
    {
        return bankAccountList.accountListSize();
    }

    //**********************************************************************************************
    //class: AccountViewHolderClass
    //
    //Purpose: Inner subclass ViewHolder.
    //
    //**********************************************************************************************
    public class AccountViewHolderClass extends RecyclerView.ViewHolder
    {
        // Attribute
        public TextView textViewForRecycler;

        //******************************************************************************************
        //Method: AccountViewHolderClass
        //
        //Purpose: Constructs a AccountViewHolderClass and takes in a View obj as a parameter.
        //
        //******************************************************************************************
        public AccountViewHolderClass(View view)
        {
            super(view);

            // Initialize the TextView variable to the TextView in the recycler view
            textViewForRecycler = view.findViewById(R.id.textViewForRecycler);

            // Set the TextView to have an on click listener
            textViewForRecycler.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    if (listener != null)
                    {
                        int position = getAdapterPosition();

                        // Make sure position is valid
                        if(position != RecyclerView.NO_POSITION)
                        {
                            // Call onItemClick on the listener
                            // This notifies the listener that an item was selected
                            listener.onAccountClick(position);
                        }
                    }
                }
            });
        }
    }
}
