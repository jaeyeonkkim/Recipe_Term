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
import com.java.model.vo.Ingredient;
import com.java.model.vo.RecipewayAndInfo;

@WebServlet("/searchrecipe.do")
public class SearchrecipeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		String recipename = request.getParameter("recipename");
		String recipenumm = request.getParameter("recipenum");
		int recipenum= Integer.parseInt(recipenumm );
		
		RecipeDAO recipeDao = new RecipeDAO();
		
		ArrayList<RecipewayAndInfo> recipewayAndInfo = recipeDao.getRecipeWay(recipename);
		request.setAttribute("recipewayAndInfo", recipewayAndInfo);
		ArrayList<Ingredient> recipeIngredint = recipeDao.getRecipeIngredient(recipenum);
		request.setAttribute("recipeIngredient", recipeIngredint);
		RequestDispatcher rd = request.getRequestDispatcher("recipewayAndInfo.jsp");
		rd.forward(request, response);
		return;

	}
}
