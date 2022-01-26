package com.hyein.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hyein.data.MemberData;
import com.hyein.service.MemberService;

public class MyPageCtrl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		MemberService memberService = new MemberService();

		RequestDispatcher dispatcher = null;
		HttpSession mSession = request.getSession();
		request.setCharacterEncoding("utf-8");
		int idx = Integer.parseInt(String.valueOf(mSession.getAttribute("idx")));

		MemberData mydata = null ;

		request.setAttribute("my", mydata);
		dispatcher = request.getRequestDispatcher("mypage.jsp");

	}
}
