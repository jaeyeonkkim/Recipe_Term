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

		String sql = "select i.ind_name, i.amount " 
						+ "from ingredient i, basket b " 
						+ "where b.usernum = ? "
						+ "and i.indnum = b.indnum";

		try {
			conn = DButil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, usernum);
			rs = stmt.executeQuery();
			while (rs.next()) {
				list.add(new Ingredient(rs.getString(1), rs.getString(2)));
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

}
