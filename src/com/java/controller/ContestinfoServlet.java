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
import com.java.model.vo.ContestInfo;

@WebServlet("/contestinfo.do")
public class ContestinfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		RecipeDAO contestinfoDao = new RecipeDAO(); // DAO는 결과만 줄 뿐
		ArrayList<ContestInfo> contestList = contestinfoDao.contestinfoRecipe();
		request.setAttribute("contestList", contestList);
		RequestDispatcher rd = request.getRequestDispatcher("contest.jsp");
		rd.forward(request, response);

		return;

	}

}
