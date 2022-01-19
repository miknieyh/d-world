package com.hyein.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.hyein.service.BoardService;

@WebServlet("/writemy")
public class WriteMyCtrl extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		HttpSession mSession = request.getSession();
		request.setCharacterEncoding("utf-8");
		BoardService boardService = new BoardService();
		
		String contents = request.getParameter("content");
		int m_idx = Integer.parseInt(String.valueOf(mSession.getAttribute("idx")));
		
		ArrayList<String> photo = new ArrayList<String>();
		// 파일 여러개 받는 거 		
		Collection<Part> parts=	request.getParts(); 
		
		for (Part p : parts) {
			if(p.getName().equals("photo") && p.getSize() >0 ) {  //데이터가 photo이고 파일이 있을때만 ! 
				
				String path = request.getServletContext().getRealPath("/upload");   //파일 저장 경로
				String fileName = p.getSubmittedFileName(); //파일 이름 중복 해결
				
				photo.add(fileName);
				
				System.out.println("path: "+path);		
				
				InputStream is = p.getInputStream();
				File tempFile = new File(path);
				if(!tempFile.exists()) {
					tempFile.mkdirs(); //폴더가 없다면 폴더 만들어 달라는 뜻
				}
				FileOutputStream fos = new FileOutputStream(path +File.separator +fileName);
				
				int size = 0;
				byte[] buffer = new byte[1024];
				while((size= is.read(buffer)) != -1) {			
					fos.write(buffer, 0, size);
				}
				
				is.close();
				fos.close();
				
			}
		}
		
		int g_idx = Integer.parseInt(request.getParameter("g_idx"));
		int stat = 2;
		if (g_idx!=-1) {
			stat =3;
		}

		boardService.insertBoard(contents,stat,m_idx,g_idx);
		int d_idx = boardService.getDiaryIdx();
		System.out.println(d_idx);
		boardService.insertPhoto(photo, d_idx);
		
		response.sendRedirect("main");
	}
}
