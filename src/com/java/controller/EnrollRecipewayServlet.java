package com.java.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.model.dao.RecipeDAO;

@WebServlet("/enrollRecipeway.do")
public class EnrollRecipewayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String recipenumm = request.getParameter("recipenum");
		int recipenum = Integer.parseInt(recipenumm);
		String recipeway = request.getParameter("recipeway");
		
		RecipeDAO recipeDao = new RecipeDAO();
		recipeDao.inputRecipeway(recipenum, recipeway);
		
		int recipeNum = recipeDao.getRecipenum2(recipenum);
		request.setAttribute("recipeNum", recipeNum);
		RequestDispatcher rd = request.getRequestDispatcher("enrollRecipeway.jsp");
		rd.forward(request, response);
		
		return;
	}

}
