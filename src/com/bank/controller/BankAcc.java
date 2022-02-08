package com.bank.controller;

import com.bankaccount.services.BankServices;
import com.handleexceptions.MinAccountBalance;

public class BankAcc{
	public static void main(String[] args) throws MinAccountBalance {
		
		BankServices bankservices = new BankServices();
		bankservices.displayMenu();
	}
}
