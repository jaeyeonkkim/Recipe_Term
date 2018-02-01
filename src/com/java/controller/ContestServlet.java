package com.java.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.model.dao.ContestDAO;
import com.java.model.vo.User;

@WebServlet("/count1.do")
public class ContestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// post�� ����
		request.setCharacterEncoding("utf-8");

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		if (user == null) {
			request.setAttribute("errorMessage1", "Error");
			request.getRequestDispatcher("contest.jsp").forward(request, response);
			return;
		}

		else {
			int usernum = user.getUsernum();
			ContestDAO contestDao = new ContestDAO(); // DAO�� ����� �� ��
			
			int cnt=contestDao.vote3(usernum);
			if(cnt>0){
				request.setAttribute("notduplicate", "�ߺ��ȵ�");
			}
			else{
				contestDao.vote1(usernum);
				request.setAttribute("successMessage1", "1����ǥ");
			}
			request.getRequestDispatcher("contest.jsp").forward(request, response);
			return;
		}

	}

}
