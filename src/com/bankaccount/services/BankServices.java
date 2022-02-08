package com.bankaccount.services;

import java.util.Scanner;

import com.bankaccount.dto.BankAccount;
import com.handleexceptions.MinAccountBalance;
public class BankServices {
	
	BankAccount accountDto = new BankAccount("Daya", "User-2");

	String customerName = accountDto.getCustomerName();
	String customerID = accountDto.getCustomerID();
	int balance = accountDto.getBalance();
	int previousTransaction = accountDto.getPreviousTransaction();

	int deposit(int amtdepo) throws MinAccountBalance {
		if (amtdepo != 0) {
			balance = balance + amtdepo;
			previousTransaction = amtdepo;
		}
		else {
			throw new MinAccountBalance("values cannot be zero");
		}
		return balance;
	}

	int withdraw(int amtWd) throws MinAccountBalance {
		if (amtWd != 0) {
			balance = balance - amtWd;
			previousTransaction = amtWd;
		}
		else {
			throw new MinAccountBalance("values cannot be zero");
		}
		return balance;
	}

	void getpreviousTransaction() {
		if (previousTransaction > 0) {
			System.out.println("Successfully deposited to your account: Rs." + previousTransaction);
		} else if (previousTransaction < 0) {
			System.out.println("Successfully withdrawn from your account: Rs." + previousTransaction);
		} else {
			System.out.println("No transaction occured");
		}
	}

	public void displayMenu() throws MinAccountBalance {
		char option = '\0';
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Welcome  " + customerName);
			System.out.println("Your ID is  " + customerID);
			System.out.println("\n");
			displayOptions();

			do {
				System.out.println("~~~~~~~~~~~~~~~~~");
				System.out.println("Enter an option:");
				System.out.println("~~~~~~~~~~~~~~~~~");
				option = scanner.next().charAt(0);
				System.out.println("\n");

				switch (option) {
				case 'A':
					System.out.println("Balance = Rs.:" + balance);
					System.out.println("\n");
					displayOptions();
					System.out.println("\n");
					break;

				case 'B':
					System.out.println("Enter an amount to deposit: Rs.");
					int amtdepo = scanner.nextInt();
					int updatedBalance = deposit(amtdepo);
					System.out.println("Amount deposited successfully: Rs." + amtdepo);
					System.out.println("Updated balance : Rs." + updatedBalance);
					System.out.println("\n");
					displayOptions();
					System.out.println("\n");
					break;

				case 'C':
					System.out.println("Enter an amount to Withdraw: Rs.");
					int amtWd = scanner.nextInt();
					int updatedBalance1 = withdraw(amtWd);
					System.out.println("Amount withdrawl successfully: Rs." + amtWd);
					System.out.println("Updated balance : Rs." + updatedBalance1);
					System.out.println("\n");
					displayOptions();
					System.out.println("\n");
					break;

				case 'D':
					getpreviousTransaction();
					System.out.println("\n");
					break;

				case 'E':
					System.out.println("Thank You.. Visit again");
					break;
				}
			} while (option != 'E');
		}	
	}

	public void displayOptions() {
		System.out.println("A = Check Balance");
		System.out.println("B = Deposit");
		System.out.println("C = Withdraw cash");
		System.out.println("D = Previous Trnasaction");
		System.out.println("E = Exit");
	}
}
