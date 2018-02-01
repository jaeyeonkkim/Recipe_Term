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

import com.java.model.dao.ContestDAO;
import com.java.model.dao.RecipeDAO;
import com.java.model.vo.ContestInfo;
import com.java.model.vo.ContestResult;
import com.java.model.vo.User;

@WebServlet("/ContestResult.do")
public class ContestResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		if (user == null) {
			request.setAttribute("errorMessage1", "Error");
			RecipeDAO contestinfoDao = new RecipeDAO();
			ArrayList<ContestInfo> contestList = contestinfoDao.contestinfoRecipe();
			request.setAttribute("contestList", contestList);
			RequestDispatcher rd = request.getRequestDispatcher("contest.jsp");
			rd.forward(request, response);
			return;
		}

		else {

			ContestDAO contestDao = new ContestDAO();
			ArrayList<ContestResult> resultList = contestDao.getContestResult();
			request.setAttribute("resultList", resultList);
			RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
			rd.forward(request, response);

			return;
		}

	}

}
