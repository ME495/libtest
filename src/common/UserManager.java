package common;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserManager extends DAO{

	public UserManager() {
		super();
	}
	
	public User getUser(String account) {
		String sql = "select password,user_name from user where account=?";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, account);
			ResultSet result = ps.executeQuery();
			User user = new User();
			if(result.next()) {
				user.setAccount(account);
				user.setPassword(result.getString("password"));
				user.setPassword(result.getString("user_name"));
				return user;
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
}
