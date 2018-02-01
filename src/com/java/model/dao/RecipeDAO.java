package com.java.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.java.model.vo.Ingredient;
import com.java.model.vo.Recipe;
import com.java.model.vo.RecipewayAndInfo;
import com.java.util.DButil;

public class RecipeDAO {
	static int MAX = 30;

	
	public ArrayList<RecipewayAndInfo> getRecipeWay(String recipename) {
		
		ArrayList<RecipewayAndInfo> list = new ArrayList<RecipewayAndInfo>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "select r.RECIPENAME, r.RTYPE, r.RLEVEL, r.RTIME, rw.SQEUENCE, rw.STORY, r.recipe_num, r.USERNUM " 
									+ "from recipe r, recipeway rw "
									+ "where r.recipename=? "
									+ "and rw.RECIPE_NUM=r.RECIPE_NUM";
		
		try {
			conn = DButil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, recipename);
			rs = stmt.executeQuery();
			while (rs.next()) {				
				list.add(new RecipewayAndInfo(rs.getString(1), rs.getString(2),rs.getString(3), 
						rs.getString(4),rs.getInt(5), rs.getString(6), rs.getInt(7), rs.getInt(8)));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DButil.close(stmt);
			DButil.close(conn);
			DButil.close(rs);
		}
		return list;
	}
	
	public ArrayList<Ingredient> getRecipeIngredient(int recipenum) {
		
		ArrayList<Ingredient> list = new ArrayList<Ingredient>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "SELECT i.IND_NAME, i.AMOUNT, i.indnum, r.recipename, r.recipe_num " 
									+ "FROM INGREDIENT i, recipe r "
									+ "where i.RECIPE_NUM=? "
									+ "and i.RECIPE_NUM=r.RECIPE_NUM";
		
		try {
			conn = DButil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, recipenum);
			
			rs = stmt.executeQuery();
			while (rs.next()) {				
				list.add(new Ingredient(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DButil.close(stmt);
			DButil.close(conn);
			DButil.close(rs);
		}
		return list;
	}
	
	public ArrayList<Recipe> recommendRecipe(String recipename) {
		
		ArrayList<Recipe> list = new ArrayList<Recipe>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql ="select recipename, rlevel, purl, recipe_num"
				+ " from recipe "
				+ "where recipe_num = ? ";
		try {
			conn = DButil.getConnection();
			stmt = conn.prepareStatement(sql);
			int recipe_num = (int)(Math.random()*MAX+1);
			
			stmt.setInt(1, recipe_num);
			rs = stmt.executeQuery();
			while (rs.next()) {				
				list.add(new Recipe(rs.getString(1), rs.getString(2), rs.getString(3),rs.getInt(4)));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DButil.close(stmt);
			DButil.close(conn);
			DButil.close(rs);
		}
		return list;
	}
	
	public int getRecipenum(int usernum, String recipename) {

		int recipenum = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT r.RECIPE_NUM " 
				+ "FROM recipe r "
				+ "where r.USERNUM = ? "
				+ "and r.RECIPENAME= ?";

		try {
			conn = DButil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, usernum);
			stmt.setString(2, recipename);
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				recipenum = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DButil.close(stmt);
			DButil.close(conn);
			DButil.close(rs);
		}
		return recipenum;
	}
	
	public int getRecipenum2(int recipenum) {

		int recipeNum = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT r.RECIPE_NUM " 
				+ "FROM recipe r "
				+ "where r.RECIPE_NUM= ?";
		
		try {
			conn = DButil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, recipenum);
			
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				recipeNum = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DButil.close(stmt);
			DButil.close(conn);
			DButil.close(rs);
		}
		return recipeNum;
	}	
	
	public boolean inputRecipeway(int recipenum, String recipeway) {

		Connection conn = null;
		PreparedStatement stmt = null;

		String sql = "INSERT INTO RECIPEWAY " 
						+ "VALUES (?,recipeway_num11.nextval,?,0)";

		try {
			conn = DButil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, recipenum);
			stmt.setString(2, recipeway);
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DButil.close(stmt);
			DButil.close(conn);
		}
		return false;

	}

	public boolean inputRecipewayComplete(int a) {

		Connection conn = null;
		PreparedStatement stmt = null;

		String sql=null;
		if(a==1){
		sql = "DROP SEQUENCE recipeway_num11";
		}
		else{
		sql= "CREATE SEQUENCE recipeway_num11 "
						+ "START WITH 1 "
						+ "INCREMENT BY 1 "
						+ "MAXVALUE 100 "
						+ "CYCLE";
		}

		try {
			conn = DButil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.executeUpdate();


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DButil.close(stmt);
			DButil.close(conn);
		}
		return false;

	}
	


}
