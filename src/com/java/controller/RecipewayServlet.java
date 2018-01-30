package com.java.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.model.dao.RecipeDAO;
import com.java.model.dao.RecipewayDAO;
import com.java.model.dao.SearchDAO;
import com.java.model.dao.UserDAO;
import com.java.model.vo.Recipe;
import com.java.model.vo.RecipeRecipeWay;
import com.java.model.vo.RecipewayAndInfo;
import com.java.model.vo.User;

@WebServlet("/Recipeway.do")
public class RecipewayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest 
			request, HttpServletResponse response) 
					throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		int usernum = user.getUsernum();
		
		String recipeway = request.getParameter("recipeway"); //조리방법
		String tmp_end = request.getParameter("end");
		String tmp_more = request.getParameter("more");
		
		System.out.println(tmp_end + "111111111111111111111111111");
		System.out.println(tmp_more + "22222222222222222222222222");
		
		String tmp;
		
		if(tmp_end != null){
			tmp = tmp_end;
		}
		else{
			tmp = tmp_more;
		}
		if(recipeway == null || recipeway.trim().length() == 0){
			
			System.out.println("유효성 검사 실패");
 			request.setAttribute("errorMessage", "유효성 검사 실패"); // 앞이 키, 뒤가 값.  한쌍.
 			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		
		RecipewayDAO recipeDao = new RecipewayDAO(); 
		
		try {
			recipeDao.recipewaysign(usernum, recipeway, tmp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(tmp_end != null){	
			response.sendRedirect("main.jsp");
		}
		if(tmp_more != null){
			System.out.println(usernum + "333333333333333333333");
			response.sendRedirect("recipeway.jsp");
		}
	}
}
