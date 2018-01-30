package com.java.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.java.model.vo.Recipe;
import com.java.model.vo.User;
import com.java.util.DButil;

public class UserDAO {


	public boolean insertUser(User user) {
		Connection conn = null;
		PreparedStatement stmt = null;

		String sql = "insert into USER_ " + "values(?,?,?,?,?,?)"; // 데이터가 들어올 수
																	// 있는 부분 ?

		try {
			conn = DButil.getConnection();
			stmt = conn.prepareStatement(sql); // 통로에 미리 정해놓음
			stmt.setInt(1, user.getUsernum());
			stmt.setString(2, user.getUserId());
			stmt.setString(3, user.getPassword());
			stmt.setString(4, user.getTel());
			stmt.setInt(5, user.getCol());
			stmt.setInt(6, user.getWinnum());
			return stmt.executeUpdate() > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DButil.close(stmt);
			DButil.close(conn);
		}
		return false;

	}


	public int login(String userid, String password) {
		
		int userNum = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select usernum from USER_ "
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
	
	
	public ArrayList<Recipe> recommendRecipe(String name) {
		ArrayList<Recipe> list = new ArrayList<Recipe>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from recipe "
					+ "where recipename ='김치찌개' ";
		
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
			DButil.close(stmt);
			DButil.close(conn);
			DButil.close(rs);
		}

		return list;
	}
	
	public ArrayList<Recipe> selectUserByName1(String recipename){
		
		ArrayList<Recipe> list = new ArrayList<Recipe>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from recipe " 
				   	 	+"where recipename like ? ";
		try {
			conn = DButil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,  recipename);
			rs = stmt.executeQuery();
			while (rs.next()) { // 결과를 찾아낼 수 있는 뭔가 포인팅 역활만을 한다.

				list.add(new Recipe(rs.getString(1), rs.getString(2),
						rs.getString(3), 0, rs.getString(5), 
						0, 0));
			}

		}
		 catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DButil.close(stmt);
				DButil.close(conn);
				DButil.close(rs);
			}
		return list;
	}
}

