package com.java.model.vo;

public class Ingredient {

	private int indnum;
	private int recipe_num;
	private String indName;
	private String amount;

	public Ingredient(String indName, String amount) {
		super();
		this.indName = indName;
		this.amount = amount;
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

}
