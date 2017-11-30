package com.fortuneforall.member.domain;

import java.util.Date;

public class Member {
	
	private String userID;
	private String userPassword;
	private String userEmail;
	private String userName;
	private String   userBirth;
	private int    userCalender;
	private String userBirth_time;
	private int userGender;
	private String userQuestion;
	private String userAnswer;
	
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserBirth() {
		return userBirth;
	}
	public void setUserBirth(String birth) {
		this.userBirth = birth;
	}
	public int getUserCalender() {
		return userCalender;
	}
	public void setUserCalender(int userCalender) {
		this.userCalender = userCalender;
	}
	public String getUserBirth_time() {
		return userBirth_time;
	}
	public void setUserBirth_time(String userBirth_time) {
		this.userBirth_time = userBirth_time;
	}
	public int getUserGender() {
		return userGender;
	}
	public void setUserGender(int userGender) {
		this.userGender = userGender;
	}
	public String getUserQuestion() {
		return userQuestion;
	}
	public void setUserQuestion(String userQuestion) {
		this.userQuestion = userQuestion;
	}
	public String getUserAnswer() {
		return userAnswer;
	}
	public void setUserAnswer(String userAnswer) {
		this.userAnswer = userAnswer;
	}
	
}
