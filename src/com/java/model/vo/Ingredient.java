package com.java.model.vo;

public class Ingredient {

	private int indnum;
	private int recipe_num;
	private String indName;
	private String amount;
	private String recipename;
	private int recipenum;

	public Ingredient(String indName, String amount, int indnum, String recipename) {
		super();
		this.indName = indName;
		this.amount = amount;
		this.indnum=indnum;
		this.recipename =recipename;
	}

	public Ingredient(String indName, String amount, int indnum, String recipename, int recipenum) {
		super();
		this.indName = indName;
		this.amount = amount;
		this.indnum = indnum;
		this.recipename = recipename;
		this.recipenum = recipenum;
	}

	public Ingredient() {
		super();
	}

	public int getIndnum() {
		return indnum;
	}

	public void setIndnum(int indnum) {
		this.indnum = indnum;
	}

	public int getRecipe_num() {
		return recipe_num;
	}

	public void setRecipe_num(int recipe_num) {
		this.recipe_num = recipe_num;
	}

	public String getIndName() {
		return indName;
	}

	public void setIndName(String indName) {
		this.indName = indName;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getRecipename() {
		return recipename;
	}

	public void setRecipename(String recipename) {
		this.recipename = recipename;
	}

	public int getRecipenum() {
		return recipenum;
	}

	public void setRecipenum(int recipenum) {
		this.recipenum = recipenum;
	}

}
