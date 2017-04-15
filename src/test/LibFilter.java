package test;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "rf", 
	initParams = {
			@WebInitParam(name = "loginPage", value = "/libtest/jsp/login.jsp") },
	urlPatterns = { 
			"/jsp/add.jsp","/jsp/delete.jsp", "/html/borrow.html", "/html/return.html"})
public class LibFilter implements Filter {
	private FilterConfig config;

	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
//		System.out.println("hehe");
		String loginPage = config.getInitParameter("loginPage");
		HttpServletRequest hsp = (HttpServletRequest) request;
		HttpServletResponse hresponse = (HttpServletResponse) response;
		HttpSession ss = hsp.getSession(false);
//		if (ss != null) {
//			System.out.println(ss.getId());
//		}
		//若已登陆，则直接访问资源
		if (ss != null && ss.getAttribute("account") != null) {
			chain.doFilter(request, response);
		} else {
		//否则，重定向到登陆页面
			hresponse.sendRedirect(loginPage);
		}
	}
}
