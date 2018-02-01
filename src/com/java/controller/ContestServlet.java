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
import com.java.model.vo.User;

@WebServlet("/count.do")
public class ContestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// post만 가능
		request.setCharacterEncoding("utf-8");

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		String recipenumm = request.getParameter("recipenum");
		int recipenum = Integer.parseInt(recipenumm);
		String contestnumm = request.getParameter("contestnum");
		int contestnum = Integer.parseInt(contestnumm);

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
			int usernum = user.getUsernum();
			ContestDAO contestDao = new ContestDAO();

			int voteDuplicationCheck = contestDao.voteDuplicationCheck(usernum);
			if (voteDuplicationCheck > 0) {
				request.setAttribute("notduplicate", "중복안됨");

				RecipeDAO contestinfoDao = new RecipeDAO();
				ArrayList<ContestInfo> contestList = contestinfoDao.contestinfoRecipe();
				request.setAttribute("contestList", contestList);
				RequestDispatcher rd = request.getRequestDispatcher("contest.jsp");
				rd.forward(request, response);

				return;
			} else {
				contestDao.Vote(contestnum, recipenum, usernum);
				request.setAttribute("successMessage", "투표하셨습니다.");

				RecipeDAO contestinfoDao = new RecipeDAO();
				ArrayList<ContestInfo> contestList = contestinfoDao.contestinfoRecipe();
				request.setAttribute("contestList", contestList);
				RequestDispatcher rd = request.getRequestDispatcher("contest.jsp");
				rd.forward(request, response);

				return;
			}
		}

	}

}
