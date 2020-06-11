package com.rab3tech.vo;

public class SecurityQuestionsVO {
	
	private int qid;
	private String questions;
		
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public String getQuestions() {
		return questions;
	}
	public void setQuestions(String questions) {
		this.questions = questions;
	}
	@Override
	public String toString() {
		return "SecurityQuestionsVO [qid=" + qid + ", questions=" + questions
				+ "]";
	}
		
}
