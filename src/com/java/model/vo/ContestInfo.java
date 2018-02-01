package com.java.model.vo;

public class ContestInfo {

	private String userid;
	private String recipename;
	private String purl;
	private int contestnum;
	private int recipenum;

	public ContestInfo(String userid, String recipename, String purl, int contestnum, int recipenum) {
		super();
		this.userid = userid;
		this.recipename = recipename;
		this.purl = purl;
		this.contestnum = contestnum;
		this.recipenum = recipenum;
	}

	public int getContestnum() {
		return contestnum;
	}

	public void setContestnum(int contestnum) {
		this.contestnum = contestnum;
	}

	public int getRecipenum() {
		return recipenum;
	}

	public void setRecipenum(int recipenum) {
		this.recipenum = recipenum;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getRecipename() {
		return recipename;
	}

	public void setRecipename(String recipename) {
		this.recipename = recipename;
	}

	public String getPurl() {
		return purl;
	}

	public void setPurl(String purl) {
		this.purl = purl;
	}

}
