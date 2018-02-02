package com.java.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.model.dao.RecipeDAO;

@WebServlet("/EnrollIngredientList.do")
public class EnrollIngredientListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		
		request.setCharacterEncoding("utf-8");
		
		String recipenumm = request.getParameter("recipenum");
		int recipenum = Integer.parseInt(recipenumm);
		
		String indname = request.getParameter("indname");
		String amount = request.getParameter("amount");
		
		RecipeDAO recipeDao = new RecipeDAO();
		recipeDao.inputIngredient(indname, amount, recipenum);
		request.setAttribute("recipeNum", recipenum);
		RequestDispatcher rd = request.getRequestDispatcher("enrollIngredientList.jsp");
		rd.forward(request, response);
		
	}

}



