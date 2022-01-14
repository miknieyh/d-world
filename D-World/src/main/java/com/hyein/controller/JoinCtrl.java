package com.hyein.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hyein.service.MemberService;

@WebServlet("/joinOk")
public class JoinCtrl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		MemberService memberService = new MemberService();
		
		String userid = request.getParameter("userid");
		String passwd = request.getParameter("passwd");
		String name = request.getParameter("name");
		String nickname = request.getParameter("nickname");
		String year = request.getParameter("birthyear").replace("년","");
		String month = request.getParameter("birthmonth").replace("월","");
		String day = request.getParameter("birthday").replace("일","");
		String phone = request.getParameter("phone");
		
		String from = year+"-"+month+"-"+day;

		java.sql.Date birth = java.sql.Date.valueOf(from);

		
		memberService.insertMember(userid, passwd, name, nickname, birth, phone);
		
		response.sendRedirect("index.jsp");
		
		
	}
}
