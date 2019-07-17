package com.tim.bcs421_android_timothynegron_project4;

import java.util.ArrayList;

public class DataSingleton
{
    private static DataSingleton INSTANCE = null;
    private ArrayList<BankAccount> bankAccountList;

    //**********************************************************************************************
    //Method: DataSingleton()
    //
    //Purpose: Constructor for DataSingleton class. Intentionally made private
    // so that only the method getINSTANCE() can call this method. This prevents
    // the DataSingleton class from being created more than once. Adds three
    // bank accounts to the list.
    //
    //**********************************************************************************************
    private DataSingleton()
    {
        // Construct the ArrayList
        this.bankAccountList = new ArrayList<>();

        // Create bank accounts to add to the list
        BankAccount checking = new BankAccount("Checking", 895.86);
        BankAccount checkingTwo = new BankAccount("Checking Two", 2487.22);
        BankAccount savings = new BankAccount("Savings", 60800.01);

        // Add the bank accounts to the list
        this.bankAccountList.add(checking);
        this.bankAccountList.add(checkingTwo);
        this.bankAccountList.add(savings);
    }

    //**********************************************************************************************
    //Method: getINSTANCE()
    //
    //Purpose: To check if an instance of DataSingleton has been created. If an
    // instance has been created then return that instance. If an instance has
    // not been created then create the new instance. Calls the private
    // constructor when creating the new instance.
    //
    //**********************************************************************************************
    public static DataSingleton getINSTANCE()
    {
        if(INSTANCE == null)
        {
            // If a DataSingleton obj instance has not been created then call the constructor
            INSTANCE = new DataSingleton();
        }

        return INSTANCE;
    }

    //**********************************************************************************************
    //Method: getBankAccountByName(String name)
    //
    //Purpose: To find a Bank Account in the bankAccountList by name. Returns a
    // Bank Account if found. If not found returns null.
    //
    //**********************************************************************************************
    public BankAccount getBankAccountByName(String name)
    {
        // Search through the bank account list
        for(int i = 0; i < this.bankAccountList.size(); i++)
        {
            // Check if the name matches with the bank account's name in the given index
            if(this.bankAccountList.get(i).toString().equals(name))
            {
                // If the name is in the list, return the matching bank account
                return this.bankAccountList.get(i);
            }
        }

        return null;
    }

    //**********************************************************************************************
    //Method: getBankAccountList()
    //
    //Purpose: To return the bankAccountList.
    //
    //**********************************************************************************************
    public ArrayList<BankAccount> getBankAccountList()
    {
        return bankAccountList;
    }

    //**********************************************************************************************
    //Method: addAccount
    //
    //Purpose: To add a Bank Account to bankAccountList instance.
    //
    //**********************************************************************************************
    public void addAccount(BankAccount bankAccount)
    {
        bankAccountList.add(bankAccount);
    }

    //**********************************************************************************************
    //Method: accountListSize()
    //
    //Purpose: To return the size the of the current bankAccountList instance.
    //
    //**********************************************************************************************
    public int accountListSize()
    {
        return bankAccountList.size();
    }

    //**********************************************************************************************
    //Method: getBankAccount(int position)
    //
    //Purpose: Returns the bank account that is in the given index number. Index number is passed
    // into the variable. Uses ArrayList object method .get() to find the bank account.
    //
    //**********************************************************************************************
    public BankAccount getBankAccount(int position)
    {
       return bankAccountList.get(position);
    }

}
