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
import com.java.model.vo.Ingredient;
import com.java.model.vo.User;

@WebServlet("/CancelIngredient.do")
public class CancelIngredientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		int usernum = user.getUsernum();
		String list = request.getParameter("list");
		String indnumm = request.getParameter("indnum");
		int indnum = Integer.parseInt(indnumm);

		BasketDAO basketDao = new BasketDAO();
		basketDao.cancelIngredient(usernum, indnum);

		if (list.equals("top3")) {
			ArrayList<Ingredient> ingredientList = basketDao.getIngredientListTop3(usernum);
			request.setAttribute("ingredientList", ingredientList);
			RequestDispatcher rd = request.getRequestDispatcher("BasketListTop3.jsp");
			rd.forward(request, response);
			return;
		} else {

			ArrayList<Ingredient> ingredientList = basketDao.getIngredientList(usernum);
			request.setAttribute("ingredientList", ingredientList);
			RequestDispatcher rd = request.getRequestDispatcher("BasketList.jsp");
			rd.forward(request, response);
			return;
		}
	}
}
