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

@WebServlet("/CancelMyUser.do")
public class CancelMyUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		int mynum = user.getUsernum();
		
		String usernumm = request.getParameter("usernum");
		int usernum = Integer.parseInt(usernumm);
		
		
		SubscribeDAO subscriberDAO = new SubscribeDAO();
		subscriberDAO.cancelMyUser(usernum, mynum);
		
		ArrayList<User> myUserList = subscriberDAO.getMyUserList(mynum);
		request.setAttribute("myUserList", myUserList);
		RequestDispatcher rd = request.getRequestDispatcher("myUserList.jsp");
		rd.forward(request, response);
		return;
		
		
	}

}
