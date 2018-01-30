package com.java.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.java.model.vo.Recipe;
import com.java.model.vo.RecipeWay;
import com.java.util.DButil;

public class RecipewayDAO {

	public void recipewaysign(int usernum, String recipeway, String tmp) 
			throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		RecipeDAO recipedao = new RecipeDAO();
		
		if(tmp == "end"){ // 끝이 아니라면
			String sql = "insert into recipeway (recipe_num, sqeuence, story) " 
					+ "values (count_num5.nextval, "
					+ "ALTER SEQUENCE recipeway_num3 INCREMENT BY 1, ?)";
			
			try { // 예외 발생 가능한 코드
				conn = DButil.getConnection();
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, recipeway);

				stmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else{  //끝이라면
			
			System.out.println("확인1!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			int tmp1 = recipedao.findRecipeway(recipeway);
			String sql = "insert into recipeway (recipe_num, sqeuence, story) " 
					+ "values (?, recipeway_num3.nextval, ?)";
			
			try { // 예외 발생 가능한 코드
				conn = DButil.getConnection();
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, tmp1);
				stmt.setString(2, recipeway);
				stmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
