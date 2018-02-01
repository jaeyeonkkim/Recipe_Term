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

import com.java.model.dao.MyRecipeDAO;
import com.java.model.vo.Recipe;
import com.java.model.vo.User;

@WebServlet("/CancelMyRecipe.do")
public class CancelMyRecipeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		int usernum = user.getUsernum();
		String list = request.getParameter("list");

		String recipenumm = request.getParameter("recipenum");
		int recipenum = Integer.parseInt(recipenumm);

		MyRecipeDAO myRecipeDAO = new MyRecipeDAO();

		myRecipeDAO.cancelMyRecipe(usernum, recipenum);
		if (list.equals("top3")) {
			ArrayList<Recipe> myRecipeList = myRecipeDAO.getMyRecipeListTop3(usernum);
			request.setAttribute("myRecipeList", myRecipeList);
			RequestDispatcher rd = request.getRequestDispatcher("MyRecipeListTop3.jsp");
			rd.forward(request, response);
			return;
		} else {

			ArrayList<Recipe> myRecipeList = myRecipeDAO.getMyRecipeList(usernum);
			request.setAttribute("myRecipeList", myRecipeList);
			RequestDispatcher rd = request.getRequestDispatcher("MyRecipeList.jsp");
			rd.forward(request, response);
			return;
		}
	}
}
