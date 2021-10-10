package come.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hi")  // annotation을 이용한 URL 매핑
public class Nana extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setCharacterEncoding("UTF-8"); // 인코팅 방법 지정. 요청 보낼 때
		resp.setContentType("text/html; charset=UTF-8"); // 받을 때 이렇게 받으라고 지정

		PrintWriter out = resp.getWriter();

		String tmp = req.getParameter("cnt");

		int cnt = 100;
		if(tmp != null && !tmp.equals("")) {
			cnt = Integer.parseInt(tmp);
		}

		for(int i = 0; i < cnt; i++) {			
			out.println((i+1) + " : 안녕 Servlet!! <br />");
		}
	}
}
