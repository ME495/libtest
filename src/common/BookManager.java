package common;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import com.mysql.fabric.xmlrpc.base.Data;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class BookManager extends DAO{
	public BookManager(){
		super();
	}
	
	public Book query(String id) {
		String sql = "select * from book where id=?";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, id);
			ResultSet result = ps.executeQuery();
			Book book = new Book();
			while(result.next()) {
				book.setISBN(result.getString("ISBN"));
				book.setId(result.getString("id"));
				book.setName(result.getString("name"));
				book.setAuthor(result.getString("author"));
				book.setPress(result.getString("press"));
				book.setPrice(result.getDouble("price"));
				book.setLocation(result.getString("location"));
				book.setPublish_date(result.getTimestamp("publish_date"));
			}
			return book;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	
	public boolean addBook(Book b){
		String sql = "insert into book values(?,?,?,?,?,?,?,?)";
		String ISBN = b.getISBN();
		String id = b.getId();
		String name = b.getName();
		String author = b.getAuthor();
		String press = b.getPress();
		double price = b.getPrice();
		String location = b.getLocation();
		Timestamp publish_date = b.getPublish_date();
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, ISBN);
			ps.setString(2, id);
			ps.setString(3, name);
			ps.setString(4, author);
			ps.setString(5, press);
			ps.setDouble(6, price);
			ps.setString(7, location);
			ps.setTimestamp(8, publish_date);
			int flag = ps.executeUpdate();
			if(flag > 0){
				return true;
			}else{
				return false;
			}
		}catch (SQLException e) {
			return false;
		}
	}
	
	public boolean isBorrowed(String id) {
		String sql = "select * from book S,borrow T where S.id=? and S.id=T.id";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, id);
			ResultSet result = ps.executeQuery();
			if(result.next()) return false;
			else return false;
		}catch (SQLException e) {
			return false;
		}
	}
	
	public boolean borrow(String user,Book book){
		String sql = "insert into borrow values(?,?,?,?,?)";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, book.getISBN());
			ps.setString(3, book.getId());
			Timestamp timestamp = new Timestamp(new Date().getTime());
			ps.setTimestamp(4, timestamp);
			ps.setInt(5, 30);
			int flag = ps.executeUpdate();
			if(flag > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			return false;
		}
	}
	
	public boolean back(String bookID) {
		String sql = "delete from borrow where book_id = ?";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, bookID);
			int flag = ps.executeUpdate();
			if(flag > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			return false;
		}
	}
}
