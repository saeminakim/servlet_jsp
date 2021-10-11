package come.newlecture.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
			int x = (Integer)session.getAttribute("value");
			int y = v;
//			String operator = (String)application.getAttribute("op");
			String operator = (String)session.getAttribute("op");
			
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
			
			session.setAttribute("value", v);
			session.setAttribute("op", op);
			
		}

	}
}
