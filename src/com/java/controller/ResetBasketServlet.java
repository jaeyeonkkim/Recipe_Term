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

@WebServlet("/ResetBasket.do")
public class ResetBasketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		int usernum = user.getUsernum();
		
		BasketDAO basketDao = new BasketDAO();
		basketDao.deleteBasket(usernum);
		
		ArrayList<Ingredient> ingredientList = basketDao.getIngredientList(usernum);
		request.setAttribute("ingredientList", ingredientList);
		RequestDispatcher rd = request.getRequestDispatcher("BasketList.jsp");
		rd.forward(request, response);
		return;
		
		
	}

}
