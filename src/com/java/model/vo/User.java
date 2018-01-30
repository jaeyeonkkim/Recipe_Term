package com.java.model.vo;

public class User {

	private int usernum;
	private String userId;
	private String password;
	private String tel;
	private int col;
	private int winnum;

	public int getUsernum() {
		return usernum;
	}

	public void setUsernum(int usernum) {
		this.usernum = usernum;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public int getWinnum() {
		return winnum;
	}

	public void setWinnum(int winnum) {
		this.winnum = winnum;
	}

	public User() {
		super();
	}

	public User(String userId) {
		super();
		this.userId = userId;
	}

	public User(int usernum, String userId) {
		super();
		this.usernum = usernum;
		this.userId = userId;
	}

	public User(String userId, String password) {
		super();
		this.userId = userId;
		this.password = password;
	}

	public User(int usernum, String userId, String password, String tel, int cOL, int winnum) {
		super();
		this.usernum = usernum;
		this.userId = userId;
		this.password = password;
		this.tel = tel;
		this.col = cOL;
		this.winnum = winnum;
	}

	@Override
	public String toString() {
		return "User [usernum=" + usernum + ", userId=" + userId + ", password=" + password + ", tel=" + tel + ", col="
				+ col + ", winnum=" + winnum + "]";
	}

}
