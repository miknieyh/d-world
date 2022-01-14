package com.hyein.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hyein.data.MemberData;
import com.hyein.service.MemberService;

@WebServlet("/main")
public class MainCtrl extends HttpServlet {
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	RequestDispatcher dispatcher = null;
	HttpSession mSession = request.getSession();
	request.setCharacterEncoding("utf-8");
	MemberService memberService = new MemberService();
	
	int idx = Integer.parseInt(String.valueOf(mSession.getAttribute("idx")));
	
	MemberData m =  memberService.profile(idx);
	request.setAttribute("m",m);
	dispatcher = request.getRequestDispatcher("main.jsp");
	dispatcher.forward(request, response);
}
}
