package com.java.model.vo;

public class RecipeRecipeWay {
	
	private int recipenum;  //������ ������ȣ(PK)
	private String recipename; // ������ �̸�
	private String stroy;	//��������
	
	
	public RecipeRecipeWay(int recipenum, String recipename, String stroy) {
		super();
		this.recipenum = recipenum;
		this.recipename = recipename;
		this.stroy = stroy;
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
	public String getStroy() {
		return stroy;
	}
	public void setStroy(String stroy) {
		this.stroy = stroy;
	}
	@Override
	public String toString() {
		return "RecipeRecipeWay [recipenum=" + recipenum + ", recipename=" + recipename + ", stroy=" + stroy + "]";
	}
	
	
	
}
