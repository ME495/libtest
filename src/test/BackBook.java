package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.BookManager;

/**
 * Servlet implementation class BackBook
 */
@WebServlet("/BackBook")
public class BackBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BackBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookID = request.getParameter("bkid");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>\n" +
				"<head><title>提示信息</title></head>\n" +
				"<body>\n<h1>");
		BookManager bookManager = new BookManager();
		if(bookManager.isBorrowed(bookID)) {
			if(bookManager.back(bookID)) {
				out.println("还书成功！");
			} else {
				out.println("还书失败");
			}
		} else {
			out.println("本书没有借出，请检查图书ID是否输入正确！");
		}
		out.print("</h1>\n</body>\n</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
