package com.first.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SignUpDaoImpl implements SignUpDao {
	public  String signUp(User user) throws SQLException {
		String firstName = user.getFirstName();
		String lastName = user.getLastName();
		String emailId = user.getEmailId();
		String userName = user.getUserName();
		String password = user.getPassword();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sys", "root", "root");
			
			PreparedStatement statement =  connection.prepareStatement("insert into table1(first_name,last_name,email_id,user_name,password) values (?,?,?,?,?)");
			statement.setString(1, firstName);
			statement.setString(2, lastName);
			statement.setString(3, emailId);
			statement.setString(4, userName);
			statement.setString(5, password);
			int i = statement.executeUpdate();
			if(i!=0){
				return "success";
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			
			e.printStackTrace();
			throw e;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "please try again";
	}


}
