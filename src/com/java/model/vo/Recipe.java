package com.java.model.vo;

public class Recipe {

	private int recipenum;
	private String recipename; // 레시피 이름
	private String rlevel;// 난이도
	private int rlike;// 좋아요
	private String rtime;// 조리시간
	private int rclick;// 조회수
	private int rscrap;// 스크랩
	private String rtype; // 종류
	private String purl;

	public Recipe(String recipename, String rtype, String rlevel, String rtime) {
		super();
		this.recipename = recipename;
		this.rlevel = rlevel;
		this.rtime = rtime;
		this.rtype = rtype;
	}

	public Recipe(String recipename, String rlevel, String purl) {
		super();
		this.recipename = recipename;
		this.rlevel = rlevel;
		this.purl = purl;
	}

	public Recipe(String recipename, String rtype, String rlevel, int rlike, String rtime, int rclick, int rscrap) {
		super();
		this.recipename = recipename;
		this.rtype = rtype;
		this.rlevel = rlevel;
		this.rlike = rlike;
		this.rtime = rtime;
		this.rclick = rclick;
		this.rscrap = rscrap;
	}

	public Recipe(int recipenum, String recipename, String rtype, String rlevel, int rlike, String rtime, int rclick,
			int rscrap, String purl) {
		super();
		this.recipenum = recipenum;
		this.recipename = recipename;
		this.rlevel = rlevel;
		this.rlike = rlike;
		this.rtime = rtime;
		this.rclick = rclick;
		this.rscrap = rscrap;
		this.rtype = rtype;
		this.purl = purl;
	}

	public Recipe(String recipename, String rtype, String rlevel, String rtime, int recipenum) {
		super();
		this.recipenum = recipenum;
		this.recipename = recipename;
		this.rlevel = rlevel;
		this.rtime = rtime;
		this.rtype = rtype;
	}

	public Recipe(String recipename, String rlevel, String purl, int recipenum) {
		super();
		this.recipenum = recipenum;
		this.recipename = recipename;
		this.rlevel = rlevel;
		this.purl = purl;
	}

	public Recipe() {
		super();
	}

	public int getRecipenum() {
		return recipenum;
	}

	public void setRecipenum(int recipenum) {
		this.recipenum = recipenum;
	}

	public String getRecipename() {
		return recipename;
	}

	public void setRecipename(String recipename) {
		this.recipename = recipename;
	}

	public String getRlevel() {
		return rlevel;
	}

	public void setRlevel(String rlevel) {
		this.rlevel = rlevel;
	}

	public int getRlike() {
		return rlike;
	}

	public void setRlike(int rlike) {
		this.rlike = rlike;
	}

	public String getRtime() {
		return rtime;
	}

	public void setRtime(String rtime) {
		this.rtime = rtime;
	}

	public int getRclick() {
		return rclick;
	}

	public void setRclick(int rclick) {
		this.rclick = rclick;
	}

	public int getRscrap() {
		return rscrap;
	}

	public void setRscrap(int rscrap) {
		this.rscrap = rscrap;
	}

	public String getRtype() {
		return rtype;
	}

	public void setRtype(String rtype) {
		this.rtype = rtype;
	}

	public String getPurl() {
		return purl;
	}

	public void setPurl(String purl) {
		this.purl = purl;
	}

}