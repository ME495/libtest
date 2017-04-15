package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.UserManager;
import common.Book;
import common.BookManager;
import common.User;

/**
 * Servlet implementation class Borrow
 */
@WebServlet("/Borrow")
public class Borrow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Borrow() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String account = request.getParameter("userid");
		String password = request.getParameter("password");
		String book_id = request.getParameter("bkid");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>\n" +
				"<html><head>\n" +"<meta charset = utf-8/>"+
				"<title>提示信息</title></head>\n" +
				"<body><h1>\n");
		UserManager userManager = new UserManager();
		User user = userManager.getUser(account);
		if(user==null) {
			out.println("用户名不存在！\n");
		} else if(user.getPassword().equals(password)) {
			out.println("密码错误！\n");
		} else {
			BookManager bookManager = new BookManager();
			Book book = bookManager.query(book_id);
			if(book==null) {
				out.println("图书不存在！\n");
			} else if(bookManager.isBorrowed(book.getId())) {
				out.println("图书已被借！\n");
			} else {
				bookManager.borrow(account, book);
				out.println("借书成功！\n");
				
			}
		}
		out.println("</h1></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
