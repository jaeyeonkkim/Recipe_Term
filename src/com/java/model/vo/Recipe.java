package com.java.model.vo;

public class Recipe {

	private int recipe_num;  //������ ������ȣ(PK)
	private String recipename; // ������ �̸�
	private String rlevel;// ���̵�
	private int rlike;// ���ƿ�
	private String rtime;// �����ð�
	
	public Recipe(int recipe_num, String recipename, String rlevel, int rlike, String rtime, int rclick, int rscrap,
			String rtype, String purl) {
		super();
		this.recipe_num = recipe_num;
		this.recipename = recipename;
		this.rlevel = rlevel;
		this.rlike = rlike;
		this.rtime = rtime;
		this.rclick = rclick;
		this.rscrap = rscrap;
		this.rtype = rtype;
		this.purl = purl;
	}

	private int rclick;// ��ȸ��
	private int rscrap;// ��ũ��
	private String rtype; // ����
	private String purl;

	public Recipe(String recipename) {
		super();
		this.recipename = recipename;
	}

	public Recipe(String recipename, String rtype, String rlevel, int rlike, String rtime) {
		super();
		this.recipename = recipename;
		this.rtype = rtype;
		this.rlevel = rlevel;
		this.rlike = rlike;
		this.rtime = rtime;
	}

	public Recipe(String recipename, String rlevel, String rtime, String rtype) {
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

	public Recipe() {
		super();
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