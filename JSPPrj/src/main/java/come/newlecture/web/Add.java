package come.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add")  
public class Add extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setCharacterEncoding("UTF-8"); 
		resp.setContentType("text/html; charset=UTF-8"); 

//		PrintWriter out = resp.getWriter();

		String xStr = req.getParameter("x");
		String yStr = req.getParameter("y");
		
		
		int x = 0;
		int y = 0;
		
		if(!xStr.equals("")) {
			x = Integer.parseInt(xStr);
		}
		
		if(!yStr.equals("")) {
			y = Integer.parseInt(yStr);
		}
		
		resp.getWriter().printf("result is %d\n", x+y);
//		out.println("덧셈 결과 : " + (x+y));
		
	}
}
