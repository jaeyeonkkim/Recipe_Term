package com.java.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.java.model.vo.ContestResult;
import com.java.util.DButil;

public class ContestDAO {

	public boolean vote1(int usernum) {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "update contest " 
				+ "set candidate = 1 " + "where candidate is null " + "and usernum = ?";

		try {
			conn = DButil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, usernum);
			stmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DButil.close(stmt);
			DButil.close(conn);
		}
		return false;
	}

	public boolean vote2(int usernum) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		String sql = "update contest "
				+ "set candidate = 2 " + "where candidate is null " + "and usernum = ?";

		try {
			conn = DButil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, usernum);
			stmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DButil.close(stmt);
			DButil.close(conn);
		}
		return false;
	}
	
	public int vote3(int usernum) {
		int cnt=0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select candidate "
				+ "from contest "
				+ "where usernum = ?";
		
		try {
			conn = DButil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, usernum);
			rs = stmt.executeQuery();
			if (rs.next()) {
				cnt = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DButil.close(stmt);
			DButil.close(conn);
		}
		return cnt;
	}

	public ArrayList<ContestResult> getContestResult() {
		ArrayList<ContestResult> result = new ArrayList<ContestResult>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select count(*) " 
						+ "from contest c " 
							+ "where candidate is not null "
								+ "group by c.CANDIDATE";

		try {
			conn = DButil.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				result.add(new ContestResult(rs.getInt(1)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DButil.close(stmt);
			DButil.close(conn);
			DButil.close(rs);
		}
		return result;
	}

}
