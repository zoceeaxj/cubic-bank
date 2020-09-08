package com.rab3tech.vo;

import java.util.List;

public class FromToAccountsVO {

	private String fromAccount;
	private List<String> toAccounts;
	private String currentBalance;
	
	

	public String getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(String currentBalance) {
        this.currentBalance = currentBalance;
    }

    public String getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(String fromAccount) {
		this.fromAccount = fromAccount;
	}

	public List<String> getToAccounts() {
		return toAccounts;
	}

	public void setToAccounts(List<String> toAccounts) {
		this.toAccounts = toAccounts;
	}

	@Override
	public String toString() {
		return "FromToAccountsVO [fromAccount=" + fromAccount + ", toAccounts=" + toAccounts + "]";
	}

}
