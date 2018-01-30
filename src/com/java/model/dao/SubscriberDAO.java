package com.java.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.java.model.vo.User;
import com.java.util.DButil;

public class SubscriberDAO {


	public ArrayList<User> getSubscriberList(int usernum) {

		ArrayList<User> list = new ArrayList<User>();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "select u.id " 
							+ "from user_ u, subscriber s "
							+ "where s.usernum = ? " 
							+ "and u.usernum = s.mynum";
	 
		try {
			conn = DButil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, usernum);
			rs = stmt.executeQuery();
			while (rs.next()) {
				list.add(new User(rs.getString(1)));
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
