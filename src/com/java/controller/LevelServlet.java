package com.java.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.model.dao.LevelDAO;
import com.java.model.vo.Recipe;

@WebServlet("/level.do")
public class LevelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String level = request.getParameter("level");

		LevelDAO levelDao = new LevelDAO();
		ArrayList<Recipe> searchList = levelDao.searchRecipeList(level);
		request.setAttribute("searchList", searchList);

		RequestDispatcher rd = request.getRequestDispatcher("level.jsp");
		rd.forward(request, response);
		return;

	}

}