package com.rab3tech.vo;

import java.sql.Timestamp;

import lombok.Data;


@Data
public class PayeeInfoVO {

	private int id;
	private String payeeAccountNo;
	private String payeeName;
	private String payeeNickName;
	private String customerId;
	private Timestamp doe;
	private Timestamp dom;
	private String remarks;
	private String payeeStatus;
	private int urn;
}
