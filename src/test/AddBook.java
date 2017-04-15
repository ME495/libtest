package test;

import common.Book;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

@WebServlet(name = "add",urlPatterns = {"/add.do"})
public class AddBook extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String name = request.getParameter("bkname");
		String author = request.getParameter("author");
		String pblsdate = request.getParameter("pblsdate");
		String publisher = request.getParameter("publisher");
		String isbn = request.getParameter("isbn");
		String price = request.getParameter("price");
		String location = request.getParameter("place");
		String id = request.getParameter("bkid");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = sdf.parse(pblsdate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Book book = new Book();
		book.setName(name);
		book.setAuthor(author);
		book.setPublish_date(new Timestamp(date.getTime()));
		book.setPress(publisher);
		book.setISBN(isbn);
		book.setPrice(Double.parseDouble(price));
		book.setLocation(location);
		book.setId(id);
		request.setAttribute("book", book);
		RequestDispatcher ds = request.getRequestDispatcher("/jsp/add.jsp");
		ds.forward(request, response);
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		doPost(request,response);
	}
}
