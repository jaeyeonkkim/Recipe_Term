package com.java.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.model.dao.SearchDAO;
import com.java.model.vo.Recipe;

@WebServlet("/search.do")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String keyField = request.getParameter("keyField");
		String search = request.getParameter("search");

		SearchDAO searchDao = new SearchDAO();
		ArrayList<Recipe> searchList = searchDao.searchRecipeList(keyField, search);
		request.setAttribute("searchList", searchList);

		RequestDispatcher rd = request.getRequestDispatcher("SearchList.jsp");
		rd.forward(request, response);
		return;

	}

}
