package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.bank.model.User;

import com.bank.util.ConnectionUtil;

public class UserDaoDB implements UserDao {

	ConnectionUtil conUtil = ConnectionUtil.getConnectionUtil();
	
	public List<User> getAllUsers(){
		List<User> userList = new ArrayList<User>();
		
		try {
			Connection con = conUtil.getConnection();
			String sql = "SELECT * FROM users";
			
			//We need to create a statement with this sql
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				userList.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}
			return userList;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User getUserByUsername(String username) {
		User user = new User();
		
		try {
			Connection con = conUtil.getConnection();
			
			String sql = "SELECT * FROM users WHERE  users.username = '" + username + "'";
			
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				user.setId(rs.getInt(1));
				user.setFirstName(rs.getString(2));
				user.setLastName(rs.getString(3));
				user.setUserName(rs.getString(4));
				user.setPassword(rs.getString(5));
				
			}
			return user;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	//Prepared Statements
	@Override
	public void createUser(User u) {
		
		try {
			Connection con = conUtil.getConnection();
			String sql = "INSERT INTO users(first_name, last_name, username, password) values"
					+ "(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, u.getFirstName());
			ps.setString(2, u.getLastName());
			ps.setString(3, u.getUserName());
			ps.setString(4,  u.getPassword());
			
			ps.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateUser(User u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(User u) {
		// TODO Auto-generated method stub
		
	}
}
