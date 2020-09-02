package com.rab3tech.vo;

import java.util.List;

public class FromToAccountsVO {

	private String fromAccount;
	private List<String> toAccounts;

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
