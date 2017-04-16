package test;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;

@WebServlet(name = "delete",urlPatterns = {"/delete.do"})
public class DeleteBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String index = request.getParameter("id");
		request.setAttribute("deleteBook",index);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/delete.jsp");
		rd.forward(request, response);
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		response.sendRedirect("/libtest/jsp/delete.jsp");
	}
}
