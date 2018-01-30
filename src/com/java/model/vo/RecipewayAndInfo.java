package com.java.model.vo;

public class RecipewayAndInfo {

	private String recipename;
	private String rtype;
	private String rlevel;
	private String rtime;
	private int sequence;
	private String story;

	public RecipewayAndInfo(String recipename, String rtype, String rlevel, String rtime, int sequence, String story) {
		super();
		this.recipename = recipename;
		this.rtype = rtype;
		this.rlevel = rlevel;
		this.rtime = rtime;
		this.sequence = sequence;
		this.story = story;
	}

	public String getRecipename() {
		return recipename;
	}

	public void setRecipename(String recipename) {
		this.recipename = recipename;
	}

	public String getRtype() {
		return rtype;
	}

	public void setRtype(String rtype) {
		this.rtype = rtype;
	}

	public String getRlevel() {
		return rlevel;
	}

	public void setRlevel(String rlevel) {
		this.rlevel = rlevel;
	}

	public String getRtime() {
		return rtime;
	}

	public void setRtime(String rtime) {
		this.rtime = rtime;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public String getStory() {
		return story;
	}

	public void setStory(String story) {
		this.story = story;
	}

}
