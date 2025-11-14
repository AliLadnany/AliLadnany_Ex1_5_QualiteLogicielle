## Exercice 2
### 1.
Bank has **20** WMC

> Methods that contain non-trivial logic
- #### public void setWithdrawLimit(double withdrawLimit): **1**
- #### public void depositMoney(double depositAmount): **2**
- #### private void setBalance(double balance): **1**
- #### public boolean withdrawMoney(double withdrawAmount): **5**
- #### public int loadFromText(String text): **8**

> Other methods
- public void <init>(int accountNumber, double balance, double withdrawLimit, String dateCreated, String accountHolder): **1**        
- public String convertToText(bankAccountApp.BankAccount tmp): **1**
- public void setAccountHolder(bankAccountApp.Person accountHolder): **2**
- public double getBalance(): **1**
- public int getAccountNumber(): **1**
- public void <init>(double newInitMoneyAmount, double newWithdrawlimit, String newDateCreated, bankAccountApp.Person initHolder): **1**
- public String getDateCreated(): **1**
- public String toString(): **1**

- public double getInitMoneyAmount(): **1**
- public double getWithdrawLimit(): **1**
- private void setDateCreated(String dateCreated): **1**
- public double getAmountWithdrawn(): **1**
- public void <init>(): **1**
- public void setAccountNumber(int accNumber): **1**
- public bankAccountApp.Person getAccountHolder(): **1**

### Summary

| Method | CC |
| --- | --- |
|  `public void setWithdrawLimit(double withdrawLimit)` | 1 |
|  `public void depositMoney(double depositAmount)`| 2 | 
|  `private void setBalance(double balance)`| 1 | 
|  `public boolean withdrawMoney(double withdrawAmount)`| 5 | 
|  `public int loadFromText(String text)` |8|


### 2.

The contents of the method `loadFromText` seems worthy of being refactored as part of a utility class named something like `SaveManager`. The same class could also take `convertToText` since it's only being used in `loadFromText` and a unit test.

This class can also help simplify the `saveAccounts` in `Bank.java`.

### 3.

- `helpers/SaveManager.java` has been added
- `BankAccountApp.java` has been modified

- `Bank.saveAccounts` is no longer used
- `BankAccount.loadFromText` is no longer used
- `BankAccount.convertToText` is no longer used

### Remarks :

- `BankAccountApp.main`'s CC value changed from 40 -> 37
- `Bank.saveAccounts` has a CC value of 8. This method has been replaced by `SaveManager.saveAccounts` which has a CC value of 2.
- `BankAccount.loadFromText` has a CC value of 8. This method has been replaced by `SaveManager.loadAccounts` which has a CC value of 3.
