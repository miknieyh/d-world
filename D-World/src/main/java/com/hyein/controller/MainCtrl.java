package com.hyein.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hyein.data.BoardData;
import com.hyein.data.MemberData;
import com.hyein.service.BoardService;
import com.hyein.service.MemberService;

@WebServlet("/main")
public class MainCtrl extends HttpServlet {
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	RequestDispatcher dispatcher = null;
	HttpSession mSession = request.getSession();
	request.setCharacterEncoding("utf-8");
	MemberService memberService = new MemberService();
	BoardService boardService =new BoardService();
	int idx = Integer.parseInt(String.valueOf(mSession.getAttribute("idx")));
	
	MemberData m =  memberService.profile(idx);
	request.setAttribute("m",m);
	
	if(request.getParameter("flag")!=null) {
		if(request.getParameter("flag").equals("write_my")) {
			dispatcher= request.getRequestDispatcher("write_my.jsp");
		}else if(request.getParameter("flag").equals("write_group")) {
			ArrayList<MemberData> gArr = memberService.readGroups(idx);
			request.setAttribute("gArr",gArr);
			dispatcher= request.getRequestDispatcher("group_select.jsp");
		}else if(request.getParameter("flag").equals("group_make")){
			dispatcher= request.getRequestDispatcher("group_make.jsp");
		}else if(request.getParameter("flag").equals("write_gd")) {
			dispatcher= request.getRequestDispatcher("write_gd.jsp");
			
		}
	}else {
		ArrayList<BoardData> bArr = boardService.mainList(idx);
		request.setAttribute("bArr", bArr);
		dispatcher = request.getRequestDispatcher("main.jsp");
	}
	dispatcher.forward(request, response);
}
}
