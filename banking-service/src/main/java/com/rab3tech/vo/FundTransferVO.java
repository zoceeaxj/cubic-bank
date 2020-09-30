package com.rab3tech.vo;

import java.util.Date;

public class FundTransferVO {
    
    private int id;
	private String fromAccount;
	private String toAccount;
	private String remarks;
	private float amount;
	private int otp;
	private Date transactionDate;
	
	

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public int getOtp() {
        return otp;
    }

    public void setOtp(int otp) {
        this.otp = otp;
    }

    public String getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(String fromAccount) {
		this.fromAccount = fromAccount;
	}

	public String getToAccount() {
		return toAccount;
	}

	public void setToAccount(String toAccount) {
		this.toAccount = toAccount;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }



    public FundTransferVO(int id, String fromAccount, String toAccount, String remarks, float amount, int otp,
            Date transactionDate) {
        super();
        this.id = id;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.remarks = remarks;
        this.amount = amount;
        this.otp = otp;
        this.transactionDate = transactionDate;
    }

    public FundTransferVO() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        return "FundTransferVO [id=" + id + ", fromAccount=" + fromAccount + ", toAccount=" + toAccount + ", remarks="
                + remarks + ", amount=" + amount + ", otp=" + otp + ", transactionDate=" + transactionDate + "]";
    }

  



	

}
