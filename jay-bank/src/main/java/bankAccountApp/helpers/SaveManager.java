package bankAccountApp.helpers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

import bankAccountApp.Bank;
import bankAccountApp.BankAccount;
import bankAccountApp.Person;

public class SaveManager {
    FileInputStream fis;
    FileOutputStream fos;
    OutputStreamWriter osw;
	Scanner fileScanner;
    boolean ready; // Determines if the SaveManager can be used incase the app does not have Writing permissions.
    
    public static final String env_var = "BANKACCOUNTAPP_SAVELOCATION";


    public SaveManager() {
        ready = false;
        String path = System.getenv(env_var);
        if(path != null) {
            try {
                fis = new FileInputStream(path);
                fos = new FileOutputStream(path);
                ready = true;
            } catch (FileNotFoundException e) {
                try {
                    java.io.File file = new java.io.File(path);
                    java.io.File parent = file.getParentFile();
                    if (parent != null && !parent.exists()) parent.mkdirs();
                    if (!file.exists()) file.createNewFile();
                    fis = new FileInputStream(file);
                    fos = new FileOutputStream(file);
                    osw = new OutputStreamWriter(fos);
                    ready = true;
                } catch (java.io.IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
    }


    public Bank loadAccounts() {
		Bank accManager = new Bank();
        if(!ready) {
            System.out.println("Warning : Save data has not been found, so nothing was loaded.");
            return accManager;
        }
		fileScanner = new Scanner(fis);
		try {
			while (fileScanner.hasNextLine()) {
                int accountNumber = fileScanner.nextInt();
                double balance = fileScanner.nextDouble();
                double withdrawLimit = fileScanner.nextDouble();
                String dateCreated = fileScanner.next();

				String newName = fileScanner.next();
				char gender = fileScanner.next().charAt(0);
				int newAge = fileScanner.nextInt();
				float newWeight = fileScanner.nextFloat();
				float newHeight = fileScanner.nextFloat();
				String newHairColor = fileScanner.next();
				String newEyeColor = fileScanner.next();
				String newEmail = fileScanner.next();
				String accountHolder1 = newName + Person.DELIM + gender + Person.DELIM + newAge + Person.DELIM
						+ newHeight + Person.DELIM + newWeight + Person.DELIM + newHairColor + Person.DELIM
						+ newEyeColor + Person.DELIM + newEmail;
                BankAccount tmpAccount = new BankAccount(accountNumber, balance, withdrawLimit, dateCreated, accountHolder1);
				accManager.addAccount(tmpAccount, 1);
			}
			fis.close();

		} catch (Exception e) {
			System.out.println("Error reading file");
		}
		return accManager;
    }

    public void saveAccounts(Bank bank) {
        ArrayList<BankAccount> accounts = bank.getAccounts();
		try {
			for (int i = 0; i < accounts.size(); i++) {
				BankAccount tmp = accounts.get(i);
				osw.write(convertAccountToText(tmp));
			}
		} catch (IOException e) {
			System.out.println("Error writing to file");
		}
	}

	public static String convertBankToText(ArrayList<BankAccount> accounts) {
		String allAccountInfo = "";
		for (int i = 0; i < accounts.size(); i++) {
			BankAccount acc = accounts.get(i);
			String AccountsInfo = acc.getAccountNumber() + Person.DELIM + acc.getBalance() + Person.DELIM
					+ acc.getWithdrawLimit() + Person.DELIM + acc.getDateCreated() + Person.DELIM
					+ acc.getAccountHolder();
			allAccountInfo += AccountsInfo;
		}
		return allAccountInfo;
	}

	public static String convertAccountToText(BankAccount tmp) {
		String AccountsInfo =  tmp.getAccountNumber() + Person.DELIM + tmp.getBalance() + Person.DELIM
				+ tmp.getWithdrawLimit() + Person.DELIM + tmp.getDateCreated() + Person.DELIM + tmp.getAccountHolder();

		return AccountsInfo;
	}
}
