package com.java.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.java.util.DButil;

public class UserDAO {

	public int login(String userid, String password) {
		
		int userNum = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select usernum from USER_ " // table명은 공백으로 띄워줘야한다.
				+ "where id=? and password=?";

		try {
			conn = DButil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, userid);
			stmt.setString(2, password);
			rs = stmt.executeQuery();
			if (rs.next()) {
				userNum = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DButil.close(stmt);
			DButil.close(conn);
			DButil.close(rs);
		}
		return userNum;
	}

}

