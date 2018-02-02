package com.java.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.model.dao.RecipeDAO;
import com.java.model.vo.RecipeWay;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/enrollRecipeway.do")
public class EnrollRecipewayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		MultipartRequest multi = null;
		int fileMaxSize = 10*1024*1024; // 파일 최대사이즈 10MB 지정
		String savePath = getServletContext().getRealPath("/upload");
				

	try{
		multi = new MultipartRequest(request, savePath, fileMaxSize, "UTF-8", new DefaultFileRenamePolicy());
		
		String recipenumm = multi.getParameter("recipenum");
		int recipenum = Integer.parseInt(recipenumm);
		int step = Integer.parseInt(multi.getParameter("step"));
		String recipeway = multi.getParameter("recipeway");
		String storyPicture = multi.getFilesystemName("storyPicture");
		
		RecipeDAO recipeDao = new RecipeDAO();
		recipeDao.inputRecipeway(new RecipeWay(recipenum, step, recipeway, storyPicture));
		
		request.setAttribute("recipenum", recipenum);
		request.setAttribute("step", step);
		RequestDispatcher rd = request.getRequestDispatcher("enrollRecipeway.jsp");
		rd.forward(request, response);
		
		return;
		
	} catch(Exception e){
		e.printStackTrace();
	}
		
	}

}
