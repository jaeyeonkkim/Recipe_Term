package com.java.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.java.model.vo.Recipe;
import com.java.util.DButil;

public class MyRecipeDAO {

	public ArrayList<Recipe> getMyRecipeList(int usernum) {

		ArrayList<Recipe> list = new ArrayList<Recipe>();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "select r.recipename, r.rtype, r.rlevel, r.rtime, r.recipe_num " 
							+ "from recipe r, myrecipe mr "
							+ "where mr.usernum = ? " 
							+ "and r.recipe_num = mr.recipe_num";

		try {
			conn = DButil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, usernum);
			rs = stmt.executeQuery();
			while (rs.next()) {
				list.add(new Recipe(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DButil.close(rs);
			DButil.close(stmt);
			DButil.close(conn);
		}
		return list;

	}

	public boolean scrapRecipe(int recipenum , int usernum) {

		Connection conn = null;
		PreparedStatement stmt = null;

		String sql = "INSERT INTO MYRECIPE " 
							+ "VALUES (?,?)";

		try {
			conn = DButil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, recipenum);
			stmt.setInt(2, usernum);
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DButil.close(stmt);
			DButil.close(conn);
		}
		return false;

	}

	public boolean cancelMyRecipe(int usernum, int recipenum) {

		Connection conn = null;
		PreparedStatement stmt = null;

		String sql = "DELETE FROM MYRECIPE " 
					+ "where usernum=? "
					+ "and recipe_num = ?";

		try {
			conn = DButil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, usernum);
			stmt.setInt(2, recipenum);
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
