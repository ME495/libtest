package test;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "hehe", urlPatterns = { "/login.do" })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("account");
		String pas = request.getParameter("password");
		//若账号和密码都正确，则维持登陆信息，重定向到主页面
		if (name != null && name.equals("admin") && pas.equals("admin")) {
			ServletContext sc = getServletContext();
			if(sc.getAttribute("error")!=null){
				sc.removeAttribute("error");
			}
			HttpSession session = request.getSession();
			session.setAttribute("account",name);
			response.sendRedirect("/libtest/jsp/main.jsp");
		} else {
			//否则，重定向到登陆界面
			ServletContext sc = getServletContext();
			sc.setAttribute("error",new Byte[1]);
			response.sendRedirect("/libtest/jsp/login.jsp");
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//重定向到登陆界面
		response.sendRedirect("/libtest/jsp/login.jsp");
	}
}
