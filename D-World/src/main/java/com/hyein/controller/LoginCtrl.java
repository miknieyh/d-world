package com.hyein.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hyein.data.MemberData;
import com.hyein.service.MemberService;

@WebServlet("/loginOk")
public class LoginCtrl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession mSession = request.getSession();
		request.setCharacterEncoding("utf-8");
		MemberService memberService = new MemberService();

		String userid = request.getParameter("userid");
		String passwd = request.getParameter("passwd");

		MemberData memberdata = memberService.login(userid, passwd);

		int idx = memberdata.getIdx();
		int stat = memberdata.getStat();
		System.out.println("idx: "+idx);
		if (idx == -1) {
			System.out.println("로그인실패");
			response.sendRedirect("index.jsp");
		} else {// 로그인 성공시
			// 초대장으로 들어왔을 때
			int g_idx = request.getParameter("invite").equals("") ? -1 : Integer.parseInt(String.valueOf(request.getParameter("invite"))); // 그룹인덱스
			if (g_idx != -1) {
				memberService.groupInvite(idx, g_idx);
			}
			mSession.setAttribute("idx", idx);
			mSession.setAttribute("stat", stat);
			response.sendRedirect("main"); // 로그인 후 화면으로 이동
		}
		

	}
}
