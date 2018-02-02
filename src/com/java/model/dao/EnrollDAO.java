package com.java.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.java.util.DButil;

public class EnrollDAO {

	public boolean signeEnroll(String recipename, String rtype, String rlevel, 
			String rtime, int usernum, String recipePicture){
		Connection conn = null;
		PreparedStatement stmt = null;

		String sql = "insert into recipe "
					+ "values (count_num5.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			conn = DButil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, recipename);
			stmt.setString(2, rtype);
			stmt.setString(3, rlevel);
			stmt.setInt(4, 0);
			stmt.setString(5, rtime);
			stmt.setInt(6, 0);
			stmt.setInt(7, 0);
			stmt.setInt(8, usernum);
			stmt.setString(9, recipePicture);

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