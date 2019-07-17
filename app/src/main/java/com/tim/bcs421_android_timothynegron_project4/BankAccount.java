package com.tim.bcs421_android_timothynegron_project4;

public class BankAccount
{
    // Attributes
    private String name;
    private double balance;

    //***************************************************************************
    //Method: BankAccount()
    //
    //Purpose: To construct class with default name and balance. Default
    // Constructor.
    //
    //***************************************************************************
    public BankAccount() {
        this.name = "No Name";
        this.balance = 0.0;
    }

    //***************************************************************************
    //Method: BankAccount(String name, double balance)
    //
    //Purpose: To construct class and set attributes with parameters passed into
    // method. Overload constructor.
    //
    //***************************************************************************
    public BankAccount(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    //***************************************************************************
    //Method: getName()
    //
    //Purpose: To return String name attribute.
    //
    //***************************************************************************
    public String getName() {
        return name;
    }

    //***************************************************************************
    //Method: setName(String name)
    //
    //Purpose: To set String name attribute.
    //
    //***************************************************************************
    public void setName(String name) {
        this.name = name;
    }

    //***************************************************************************
    //Method: getBalance()
    //
    //Purpose: To return balance attribute.
    //
    //***************************************************************************
    public double getBalance() {
        return balance;
    }

    //***************************************************************************
    //Method: setBalance(double balance)
    //
    //Purpose: To set double balance attribute.
    //
    //***************************************************************************
    public void setBalance(double balance) {
        this.balance = balance;
    }

    //***************************************************************************
    //Method: setBalance(double balance)
    //
    //Purpose: Override toString to return name attribute.
    //
    //***************************************************************************
    @Override
    public String toString() {
        return this.name;
    }
}
