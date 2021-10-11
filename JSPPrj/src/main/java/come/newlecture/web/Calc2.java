package come.newlecture.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calc2")  
public class Calc2 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext application = req.getServletContext();
		// ServletContext를 받아서 application 변수에 저장		
		
		// session을 이용
		HttpSession session = req.getSession();
		
		// cookie를 이용
		Cookie[] cookies = req.getCookies();
		
		resp.setCharacterEncoding("UTF-8"); 
		resp.setContentType("text/html; charset=UTF-8"); 

		String v_ = req.getParameter("v");
		String op = req.getParameter("operator");

		int v = 0;

		if(!v_.equals("")) {
			v = Integer.parseInt(v_);
		}

		// 계산
		if(op.equals("=")) {
//			int x = (Integer)application.getAttribute("value");
//			int x = (Integer)session.getAttribute("value");
			
			int x = 0;
			for(Cookie c : cookies) {
				if(c.getName().equals("value")) {
					x = Integer.parseInt(c.getValue());
					break;
				}
			}
			
			int y = v;
//			String operator = (String)application.getAttribute("op");
//			String operator = (String)session.getAttribute("op");
			String operator = "";
			
			for(Cookie c : cookies) {
				if(c.getName().equals("op")) {
					operator = c.getValue();
					break;
				}
			}
			
			int result = 0; 

			if(operator.equals("+")) {
				result = x + y;
			} else {
				result = x - y;
			}
			
			resp.getWriter().printf("result is %d\n", result);
		} 
		// 값을 저장
		else {

//			application.setAttribute("value", v);
//			application.setAttribute("op", op);
			// Map에 필요한 값들을 저장
			
//			session.setAttribute("value", v);
//			session.setAttribute("op", op);
			
			Cookie valueCookie = new Cookie("value", String.valueOf(v));
			Cookie opCookie = new Cookie("op", op);
			
			valueCookie.setPath("/calc2");
			valueCookie.setMaxAge(24 * 60 * 60);  
			// 초 단위로 설정. 24 * 60 * 60 이렇게 하면 24시간
			// 브라우저가 닫혀도 설정한 시간만큼 쿠키가 살아있게 됨
			
			opCookie.setPath("/calc2");
			
			// response header에 심어져서 전달
			resp.addCookie(valueCookie);
			resp.addCookie(opCookie);
			
		}

	}
}
