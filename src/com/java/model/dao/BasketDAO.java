package com.java.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.java.model.vo.Ingredient;
import com.java.util.DButil;

public class BasketDAO {

	public ArrayList<Ingredient> getIngredientList(int usernum) {

		ArrayList<Ingredient> list = new ArrayList<Ingredient>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "select i.ind_name, i.amount, i.indnum " 
							+ "from ingredient i, basket b " 
							+ "where b.usernum = ? "
							+ "and i.indnum = b.indnum ";

		try {
			conn = DButil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, usernum);
			rs = stmt.executeQuery();
			while (rs.next()) {
				list.add(new Ingredient(rs.getString(1), rs.getString(2), rs.getInt(3)));
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

	public boolean inputBasket(int usernum, int indnum) {

		Connection conn = null;
		PreparedStatement stmt = null;

		String sql = "INSERT INTO BASKET " + "VALUES (?,?)";

		try {
			conn = DButil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, usernum);
			stmt.setInt(2, indnum);
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DButil.close(stmt);
			DButil.close(conn);
		}
		return false;

	}

	public boolean deleteBasket(int usernum) {

		Connection conn = null;
		PreparedStatement stmt = null;

		String sql = "DELETE FROM BASKET " + "where usernum=?";

		try {
			conn = DButil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, usernum);
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DButil.close(stmt);
			DButil.close(conn);
		}
		return false;

	}

	public boolean cancelIngredient(int usernum, int indnum) {

		Connection conn = null;
		PreparedStatement stmt = null;

		String sql = "DELETE FROM BASKET " 
					+ "where usernum=? "
					+ "and INDNUM = ?";

		try {
			conn = DButil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, usernum);
			stmt.setInt(2, indnum);
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
