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
//		chain.doFilter(request, response);  // �帧�� �Ѱ��ִ� ��. chain�� �� ���� ���� ������ �ȵ�
//		System.out.println("after filter");
		
		request.setCharacterEncoding("UTF-8");
		// ���� ������ �����ϱ� �� ���ڵ� ����
		
		chain.doFilter(request, response);
	}

}
