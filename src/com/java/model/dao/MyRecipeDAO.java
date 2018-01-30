package com.java.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.java.model.vo.Recipe;
import com.java.util.DButil;

public class MyRecipeDAO {
	
	public ArrayList<Recipe> getMyRecipeList(int usernum){
		
		ArrayList<Recipe> list = new ArrayList<Recipe>();
		
		Connection conn = null;
		PreparedStatement stmt= null;
		ResultSet rs = null;
		
		String sql = "select r.recipename, r.rtype, r.rlevel, r.rtime "
							+ "from recipe r, myrecipe mr " 
							+ "where mr.usernum = ? "
							+ "and r.recipe_num = mr.recipe_num";
		
		try {
			conn = DButil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, usernum);
			rs = stmt.executeQuery();
			while(rs.next()){
				list.add(new Recipe(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4)));
			}
			
			 	
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DButil.close(rs);
			DButil.close(stmt);
			DButil.close(conn);	
		}
		return list;
		
	}		
}
