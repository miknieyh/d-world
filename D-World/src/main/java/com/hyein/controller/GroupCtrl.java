package com.hyein.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hyein.service.MemberService;

@WebServlet("/groupmake")
public class GroupCtrl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		MemberService memberService = new MemberService();
		HttpSession mSession = request.getSession();
		String groupname = request.getParameter("groupname");
		int idx = Integer.parseInt(String.valueOf(mSession.getAttribute("idx")));
		
		memberService.groupMake(idx, groupname);
		
		response.sendRedirect("main/");
		
		
	}
}
