package com.java.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.model.dao.EnrollDAO;
import com.java.model.dao.RecipeDAO;
import com.java.model.vo.User;

@WebServlet("/Enroll.do")
public class EnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		int usernum = user.getUsernum();

		String recipename = request.getParameter("recipename");
		String rtype = request.getParameter("rtype");
		String rlevel = request.getParameter("rlevel");
		String rtime = request.getParameter("rtime");
		
		String rlikee = request.getParameter("rlike");
		int rlike = Integer.parseInt(rlikee);
		String rclickk = request.getParameter("rclick");
		int rclick = Integer.parseInt(rclickk);
		String rscrapp = request.getParameter("rscrap");
		int rscrap = Integer.parseInt(rscrapp);
		String purl = request.getParameter("purl");

		if (recipename == null || recipename.trim().length() == 0 || rtype == null || rtype.trim().length() == 0
				|| rlevel == null || rlevel.trim().length() == 0 || rtime == null || rtime.trim().length() == 0) {
			request.setAttribute("errorMessage", "유효성 검사 실패");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}

		EnrollDAO rollDao = new EnrollDAO();
		rollDao.signeEnroll(recipename, rtype, rlevel, rlike, rtime, rclick, rscrap, usernum, purl);
		RecipeDAO recipeDao=new RecipeDAO();
		int recipenum = recipeDao.getRecipenum(usernum, recipename);
		request.setAttribute("recipeNum", recipenum);
		RequestDispatcher rd = request.getRequestDispatcher("enrollRecipeway.jsp");
		rd.forward(request, response);
		return;
	}
}
