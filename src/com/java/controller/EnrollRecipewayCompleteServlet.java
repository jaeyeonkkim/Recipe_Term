package com.java.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.model.dao.RecipeDAO;

@WebServlet("/enrollRecipewayComplete.do")
public class EnrollRecipewayCompleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		RecipeDAO recipeDao = new RecipeDAO();
		recipeDao.inputRecipewayComplete(1);
		recipeDao.inputRecipewayComplete(2);
		
		response.sendRedirect("main.jsp");
		return;
		
	}

}
