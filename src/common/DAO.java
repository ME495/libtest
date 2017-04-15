package common;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import javax.naming.*;

public class DAO {
	public DataSource ds;
	public DAO(){
		try {
			Context context = new InitialContext();
			ds = (DataSource)context.lookup("java:comp/env/test/library");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() throws SQLException{
		return ds.getConnection();
	}
}
