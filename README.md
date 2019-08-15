# Bank Accounts

An Android OS application that gives the user the ability to check the information on the bank accounts as well as 
add new bank accounts.

## What I Learned

* How to use a data singleton to store data
* How to use a recyclerview to display a list of names
* How to use only fragments to display all content
* How to update recyclerview when data is added
* How to set up a recyclerview click listener
* How to create an adapter class

# Description and Images
The *main activity* contains two image buttons. When the bank image is selected, the *account list activity (pre)* starts. Account list activity contains a add account button. When the add account button is selected, the *add account activity* starts. In this activity the application has the ability to add account information and save it. Upon saving, the activity will end and the *account list activity (post)* will be updated. Clicking a bank account in the recycler view will result in starting the account detail activity; *Checking Two, Test Account*. Finally, in the main activity the app information image button, below the bank image button, will start the *account info activity*. All content is stored in fragments.

## Images
#### Main Activity
![Image of Main Activity](https://negrt.github.io/cv/images/bkMainActivity.png)

#### Account List Activity (Pre: Before adding an account)
![Image of Account list Activity](https://negrt.github.io/cv/images/bkAccountListActivity.png)

#### Add Account Activity
![Image of Add Account Activity](https://negrt.github.io/cv/images/bkAddAccountActivity.png)

#### Add Account (Adding Information)
![Image of Add Account Activity](https://negrt.github.io/cv/images/bkAddAccountInformation.png)

#### Account List Activity (Post: After adding a test account)
![Image of Add Account Activity](https://negrt.github.io/cv/images/bkAccountListActivityPost.png)

#### Account Detail Activity (Checking two)
![Image of Add Account Activity](https://negrt.github.io/cv/images/bkAccountDetailActivityCheckingTwo.png)

#### Bank Account App Info Activity
![Image of Add Account Activity](https://negrt.github.io/cv/images/bkAccountInfoActivity.png)
