package com.java.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String recipename = request.getParameter("recipename");
		RecipeDAO recipeDao = new RecipeDAO();
		RecipeDAO recipeDao1 = new RecipeDAO();
		RecipeDAO recipeDao2 = new RecipeDAO();

		ArrayList<Recipe> recipeList = recipeDao.recommendRecipe(recipename);
		ArrayList<Recipe> recipeList1 = recipeDao1.recommendRecipe(recipename);
		ArrayList<Recipe> recipeList2 = recipeDao2.recommendRecipe(recipename);

		while (true) {
			if (Objects.equals(recipeList.get(0).getRecipename(), recipeList1.get(0).getRecipename())) {
				recipeList = recipeDao.recommendRecipe(recipename);
			} else if (Objects.equals(recipeList1.get(0).getRecipename(), recipeList2.get(0).getRecipename())) {
				recipeList1 = recipeDao1.recommendRecipe(recipename);
			} else if (Objects.equals(recipeList.get(0).getRecipename(), recipeList2.get(0).getRecipename())) {
				recipeList2 = recipeDao2.recommendRecipe(recipename);
			} else {
				break;
			}
		}

		request.setAttribute("list", recipeList);
		request.setAttribute("list1", recipeList1);
		request.setAttribute("list2", recipeList2);

		RequestDispatcher rd = request.getRequestDispatcher("recommend.jsp");
		rd.forward(request, response);

		return;

	}

}
