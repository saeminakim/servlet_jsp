package com.newlecture.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class CharacterEncodingFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

//		System.out.println("before filter");
//		chain.doFilter(request, response);  // 흐름을 넘겨주는 것. chain을 안 쓰면 서블릿 실행이 안됨
//		System.out.println("after filter");
		
		request.setCharacterEncoding("UTF-8");
		// 다음 서블릿을 실행하기 전 인코딩 설정
		
		chain.doFilter(request, response);
	}

}
