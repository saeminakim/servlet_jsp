package com.newlecture.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculator")
public class Calculator extends HttpServlet {
//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//		// 요청이 doGet(), doPost()를 호출하기 전에
//		// 공통적으로 처리해야 할 로직이 있다면 service()에서 처리한 후
//		// super.service() 호출하도록 할 수 있음
//		// 공통으로 처리할 로직이 있다면 service() 사용 안하면 됨
//		
//		if(req.getMethod().equals("GET")) {
//			System.out.println("GET 요청");
//		} 
//		else if(req.getMethod().equals("POST")) {
//			System.out.println("POST 요청");
//		}
//
//		super.service(req, resp);
//	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// service()에서 작성한 super.service() 메소드가
		// 요청이 get, post인지를 판단해서 각각 doGet(), doPost() 메소드 호출
		System.out.println("doPost 메소드 호출");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet 메소드 호출");
	}
}
