package com.java.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.java.model.vo.Recipe;
import com.java.model.vo.RecipeRecipeWay;
import com.java.model.vo.RecipewayAndInfo;
import com.java.util.DButil;

public class RecipeDAO {
	static int MAX = 9;
	
	public ArrayList<RecipewayAndInfo> getRecipeWay(String recipename) {
		
		ArrayList<RecipewayAndInfo> list = new ArrayList<RecipewayAndInfo>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "select r.RECIPENAME, r.RTYPE, r.RLEVEL, r.RTIME, rw.SQEUENCE, rw.STORY " 
									+ "from recipe r, recipeway rw "
									+ "where r.recipename=? "
									+ "and rw.RECIPE_NUM=r.RECIPE_NUM";
		
		try {
			conn = DButil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, recipename);
			rs = stmt.executeQuery();
			while (rs.next()) {				
				list.add(new RecipewayAndInfo(rs.getString(1), rs.getString(2),
				rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6)));

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
	
	public ArrayList<Recipe> selectUserByrecipeName(String name) {
		
		ArrayList<Recipe> list = new ArrayList<Recipe>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "select recipename, rtype, rlevel, rlike, rtime, rclick, rscrap rcrap" + " from recipe " // table¸íÀº °ø¹éÀ¸·Î ¶ç¿öÁà¾ßÇÑ´Ù.
				+ "where recipename like '%'||?||'%' ";
		try {
			conn = DButil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			rs = stmt.executeQuery();
			while (rs.next()) {				
				list.add(new Recipe(rs.getString(1), rs.getString(2),
				rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6), rs.getInt(7)));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("¾È³ç");
			DButil.close(stmt);
			DButil.close(conn);
			DButil.close(rs);
		}
		return list;
	}
	
	
	public ArrayList<Recipe> selectrecipeName(String name) {
		
		ArrayList<Recipe> list = new ArrayList<Recipe>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "select recipename, rtype, rlevel, rlike, rtime, rclick, rscrap rcrap" + " from recipe " // table¸íÀº °ø¹éÀ¸·Î ¶ç¿öÁà¾ßÇÑ´Ù.
				+ "where recipename = ? ";
		try {
			conn = DButil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			rs = stmt.executeQuery();
			while (rs.next()) {				
				list.add(new Recipe(rs.getString(1), rs.getString(2),
				rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6), rs.getInt(7)));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("3333333¾È³ç");
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
		String sql ="select recipename, rtype, rlevel, rlike, rtime, rclick, rscrap rcrap" + " from recipe " // table¸íÀº °ø¹éÀ¸·Î ¶ç¿öÁà¾ßÇÑ´Ù.
				+ "where recipe_num = ? ";
		try {
			conn = DButil.getConnection();
			stmt = conn.prepareStatement(sql);
			int recipe_num = (int)(Math.random()*MAX+1);
			System.out.println("num   "+recipe_num);
			System.out.println("name   "+recipename);
			
			stmt.setInt(1, recipe_num);
			rs = stmt.executeQuery();
			while (rs.next()) {				
				list.add(new Recipe(rs.getString(1), rs.getString(2),
				rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6), rs.getInt(7)));

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
	
	
	public ArrayList<RecipeRecipeWay> selectUserByrecipeName1(String recipeway) {
		ArrayList<RecipeRecipeWay> list = new ArrayList<RecipeRecipeWay>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select R.recipe_num, R.recipename,"
				+ "W.story " 
				+ "from RECIPE R, RECIPEWAY W "
				+ "where recipename = ? "
				+ "and R.recipe_num = W.recipe_num ";
		try {
			conn = DButil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, recipeway);
			rs = stmt.executeQuery();
			while (rs.next()) {				
				list.add(new RecipeRecipeWay(rs.getInt(1), rs.getString(2),
						rs.getString(3)
			));
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
	
	public int findRecipeway(String recipeway) {
		
		int recipeNum = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select R.recipe_num, R.recipename,"
				+ "W.story " 
				+ "from RECIPE R, RECIPEWAY W "
				+ "where recipename = ? "
				+ "and R.recipe_num = W.recipe_num ";

		try {
			conn = DButil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, recipeway);
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

}

