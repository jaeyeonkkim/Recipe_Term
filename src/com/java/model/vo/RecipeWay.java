package com.java.model.vo;

/// �������
public class RecipeWay {
	private int recipe_num;  //������ ��ȣ
	private int sequence;	//������ȣ
	private String stroy;	//��������
	private String picture;	//����
	
	public RecipeWay() {
		super();
	}

		
	public RecipeWay(int recipe_num, int sequence, String stroy) {
		super();
		this.recipe_num = recipe_num;
		this.sequence = sequence;
		this.stroy = stroy;
	}

	public RecipeWay(int recipe_num, int sequence, String stroy, String picture) {
		super();
		this.recipe_num = recipe_num;
		this.sequence = sequence;
		this.stroy = stroy;
		this.picture = picture;
	}

	public RecipeWay(String stroy) {
		super();
		this.stroy = stroy;
	}

	public int getRecipe_num() {
		return recipe_num;
	}

	public void setRecipe_num(int recipe_num) {
		this.recipe_num = recipe_num;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public String getStroy() {
		return stroy;
	}

	public void setStroy(String stroy) {
		this.stroy = stroy;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	@Override
	public String toString() {
		return "RecipeWay [recipe_num=" + recipe_num + ", sequence=" + sequence + ", stroy=" + stroy + ", picture="
				+ picture + "]";
	}
	
	
}
