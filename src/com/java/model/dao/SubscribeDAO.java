package com.java.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.java.model.vo.User;
import com.java.util.DButil;

public class SubscribeDAO {

	public boolean subscribeDuplicationCheck(int usernum) {

		Connection conn = null;
		PreparedStatement stmt = null;
		
		String sql = "SELECT u.USERNUM " 
					+ "FROM USER_ u, SUBSCRIBER s "
					+ "where s.USERNUM=? "
					+ "and s.USERNUM=u.USERNUM";
		
		try {
			conn = DButil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, usernum);
			return stmt.executeUpdate()>0;
			

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DButil.close(stmt);
			DButil.close(conn);
		}
		return false;
	}
	
	public boolean subscribeUser(int usernum, int mynum) {

		Connection conn = null;
		PreparedStatement stmt = null;

		String sql = "INSERT INTO SUBSCRIBER " + "VALUES (?,?)";

		try {
			conn = DButil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, usernum);
			stmt.setInt(2, mynum);
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DButil.close(stmt);
			DButil.close(conn);
		}
		return false;

	}

	public ArrayList<User> getSubscriberList(int usernum) {

		ArrayList<User> list = new ArrayList<User>();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "select u.id " + "from user_ u, subscriber s " + "where s.usernum = ? "
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

	public ArrayList<User> getMyUserList(int usernum) {

		ArrayList<User> list = new ArrayList<User>();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "select u.usernum, u.id " 
						+ "from user_ u, subscriber s " 
						+ "where s.mynum = ? "
						+ "and u.usernum = s.USERNUM";


		try {
			conn = DButil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, usernum);
			
			rs = stmt.executeQuery();
			while (rs.next()) {
				list.add(new User(rs.getInt(1), rs.getString(2)));
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

	public boolean cancelMyUser(int usernum, int mynum) {

		Connection conn = null;
		PreparedStatement stmt = null;

		String sql = "DELETE FROM SUBSCRIBER " 
					+ "where usernum=? "
					+ "and mynum = ?";

		try {
			conn = DButil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, usernum);
			stmt.setInt(2, mynum);
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
