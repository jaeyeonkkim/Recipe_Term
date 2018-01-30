package com.java.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.model.dao.RecipeDAO;
import com.java.model.vo.Recipe;

@WebServlet("/Searchrecipe2.do")
public class SearchrecipeServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String recipename = request.getParameter("recipename");
		RecipeDAO recipeDao = new RecipeDAO();
	
		ArrayList<Recipe> recipeList = recipeDao.selectrecipeName(recipename);
		request.setAttribute("recipeList", recipeList);
		System.out.println("출력값은      "+recipename);
				
		RequestDispatcher rd = request.getRequestDispatcher("list1.jsp");
		rd.forward(request, response);
		return;
		
	}
}
