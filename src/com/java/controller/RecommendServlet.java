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


@WebServlet("/recommend.do")
public class RecommendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-----1");
		request.setCharacterEncoding("utf-8");
		String recipename = request.getParameter("recipename");
		//int num = Integer.parseInt(request.getParameter("recipe_num"));
		RecipeDAO recipeDao = new RecipeDAO();
		
		ArrayList<Recipe> recipeList = recipeDao.recommendRecipe(recipename);
		//System.out.println("dd"+recipeList.size());
		request.setAttribute("list", recipeList);
				
		RequestDispatcher rd = request.getRequestDispatcher("recommend.jsp");
		rd.forward(request, response);


		System.out.println("-------------------");
				
		return;
		
	}

}
