package com.bankaccount.dto;

public class BankAccount {
	
	private int balance;
	private int previousTransaction;
	private String customerName;
	private String customerID;
	
	public BankAccount(String customername, String customerid) {
		this.customerName = customername;
		this.customerID = customerid;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getPreviousTransaction() {
		return previousTransaction;
	}

	public void setPreviousTransaction(int previousTransaction) {
		this.previousTransaction = previousTransaction;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

}