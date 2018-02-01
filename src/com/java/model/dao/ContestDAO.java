package com.java.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.java.model.vo.ContestResult;
import com.java.util.DButil;

public class ContestDAO {

	public boolean Vote(int contestnum, int recipenum, int usernum) {

		Connection conn = null;
		PreparedStatement stmt = null;

		String sql = "INSERT INTO CONTESTRESULT " 
					+ "VALUES (?,?,?)";

		try {
			conn = DButil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, contestnum);
			stmt.setInt(2, recipenum);
			stmt.setInt(3, usernum);
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DButil.close(stmt);
			DButil.close(conn);
		}
		return false;

	}



	
	public int voteDuplicationCheck(int usernum) {
		int cnt=0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select cr.usernum "
				+ "from contestresult cr "
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
						+ "from contestresult cr join  contest c on SYSDATE between c.startdate and c.enddate " 
						+ "where c.RECIPE_NUM=cr.recipe_num "
						+ "group by c.CANDIDATE_NUM";

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
