package com.java.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.model.dao.BasketDAO;
import com.java.model.dao.RecipeDAO;
import com.java.model.vo.Ingredient;
import com.java.model.vo.RecipewayAndInfo;
import com.java.model.vo.User;

@WebServlet("/InputBasket.do")
public class InputBasketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		int usernum = user.getUsernum();

		String recipename = request.getParameter("recipename");
		String recipenumm = request.getParameter("recipenum");
		int recipenum = Integer.parseInt(recipenumm);

		String indnumm = request.getParameter("indnum");
		int indnum = Integer.parseInt(indnumm);
		//////////////////////////////////////////////////////////////////////////////
		BasketDAO basketDao = new BasketDAO();
		boolean ingredientDuplicationCheck = basketDao.ingredientDuplicationCheck(indnum);

		RecipeDAO recipeDao = new RecipeDAO();

		if (ingredientDuplicationCheck) {
			ArrayList<RecipewayAndInfo> recipewayAndInfo = recipeDao.getRecipeWay(recipename);
			request.setAttribute("recipewayAndInfo", recipewayAndInfo);
			ArrayList<Ingredient> recipeIngredint = recipeDao.getRecipeIngredient(recipenum);
			request.setAttribute("recipeIngredient", recipeIngredint);
			RequestDispatcher rd = request.getRequestDispatcher("recipewayAndInfo.jsp");
			rd.forward(request, response);
			return;
		} else {
			basketDao.inputBasket(usernum, indnum);

			ArrayList<RecipewayAndInfo> recipewayAndInfo = recipeDao.getRecipeWay(recipename);
			request.setAttribute("recipewayAndInfo", recipewayAndInfo);
			ArrayList<Ingredient> recipeIngredint = recipeDao.getRecipeIngredient(recipenum);
			request.setAttribute("recipeIngredient", recipeIngredint);
			RequestDispatcher rd = request.getRequestDispatcher("recipewayAndInfo.jsp");
			rd.forward(request, response);
			return;
		}

	}

}
