package com.rab3tech.dao.entity;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="Fund_Transfer_tbl")
public class FundTransferEntity {

	@Id
	@GeneratedValue
    private long id;
	
	@OneToOne
	private CustomerAccountInfo fromAccount;
	
	@OneToOne
    private CustomerAccountInfo toAccount;
	
	private float amount;
	private String remarks;
	private int otp;
	private Date transactionDate;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public CustomerAccountInfo getFromAccount() {
        return fromAccount;
    }
    public void setFromAccount(CustomerAccountInfo fromAccount) {
        this.fromAccount = fromAccount;
    }
    public CustomerAccountInfo getToAccount() {
        return toAccount;
    }
    public void setToAccount(CustomerAccountInfo toAccount) {
        this.toAccount = toAccount;
    }
    public float getAmount() {
        return amount;
    }
    public void setAmount(float amount) {
        this.amount = amount;
    }
    public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    public int getOtp() {
        return otp;
    }
    public void setOtp(int otp) {
        this.otp = otp;
    }
    public Date getTransactionDate() {
        return transactionDate;
    }
    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }
    @Override
    public String toString() {
        return "FundTransferEntity [id=" + id + ", fromAccount=" + fromAccount + ", toAccount=" + toAccount
                + ", amount=" + amount + ", remarks=" + remarks + ", otp=" + otp + ", transactionDate="
                + transactionDate + "]";
    }
	
	
	
	
	
}
	

	

	
