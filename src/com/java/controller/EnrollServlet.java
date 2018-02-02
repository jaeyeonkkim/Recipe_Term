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
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/Enroll.do")
public class EnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		int usernum = user.getUsernum();

		MultipartRequest multi = null;
		int fileMaxSize = 10 * 1024 * 1024; 
		String savePath = getServletContext().getRealPath("/upload");
		

		try {
			multi = new MultipartRequest(request, savePath, fileMaxSize, "UTF-8", new DefaultFileRenamePolicy());

			String recipename = multi.getParameter("recipename");
			String rtype = multi.getParameter("rtype");
			String rlevel = multi.getParameter("rlevel");
			String rtime = multi.getParameter("rtime");
			String recipePicture = multi.getFilesystemName("recipePicture");


			if (recipename == null || recipename.trim().length() == 0 || rtype == null || rtype.trim().length() == 0
					|| rlevel == null || rlevel.trim().length() == 0 || rtime == null || rtime.trim().length() == 0) {
				request.setAttribute("errorMessage", "유효성 검사 실패");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				return;
			}

			EnrollDAO rollDao = new EnrollDAO();
			rollDao.signeEnroll(recipename, rtype, rlevel, rtime, usernum, recipePicture);
			RecipeDAO recipeDao = new RecipeDAO();

			int recipenum = recipeDao.getRecipenum(usernum, recipename);
			
			request.setAttribute("recipeNum", recipenum);
			RequestDispatcher rd = request.getRequestDispatcher("enrollIngredientList.jsp");
			rd.forward(request, response);
			
			return;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
