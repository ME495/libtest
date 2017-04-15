package test;

import javax.servlet.http.*;

import java.io.IOException;

import javax.servlet.annotation.*;

@WebServlet(name = "cancel" , urlPatterns = {"/cancel.do"})
public class Cacellation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
		HttpSession session = request.getSession(false);
		//若已登陆，则取消登录状态，并重定向到主界面
		if(session != null){
			session.invalidate();
			response.sendRedirect("/libtest/jsp/main.jsp");
		}else{
		//否则，重定向到登陆界面
			response.sendRedirect("libtest/jsp/login.jsp");
		}
	}
}
