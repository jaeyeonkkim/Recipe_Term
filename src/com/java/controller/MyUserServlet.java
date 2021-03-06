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

import com.java.model.dao.SubscribeDAO;
import com.java.model.vo.User;

@WebServlet("/MyUser.do")
public class MyUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		int usernum = user.getUsernum();

		SubscribeDAO subscriberDAO = new SubscribeDAO();

		ArrayList<User> myUserList = subscriberDAO.getMyUserList(usernum);
		request.setAttribute("myUserList", myUserList);

		RequestDispatcher rd = request.getRequestDispatcher("myUserList.jsp");
		rd.forward(request, response);
		return;
		
		
	}

}
