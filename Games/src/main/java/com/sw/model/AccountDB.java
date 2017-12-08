package com.sw.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sw.controller.ConnectionDB;
import com.sw.controller.User;

public class AccountDB {
	private Connection connect;
	public Statement st;
	User user;

	public AccountDB() {
		try {
			ConnectionDB connectiondb = new ConnectionDB();
			connect = connectiondb.Connect();
			st = connect.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<Game> Retrivescores() {
		List<Game> list = new ArrayList<Game>();
		try {
			Account account;
			String g = "SELECT * FROM score ";//where ";//Email=" + "'" + user.getAccount().getEmail() + "'";
			ResultSet result = st.executeQuery(g);
			while (result.next()) {
				if (result.getString("Email").equals(user.getAccount().getEmail())) {
					System.out.println(result.getInt("Score")+" "+result.getString("Game"));
					// Game game = new Game(result.getInt("Score"),
					// result.getString("Game"));
					System.out.println("ddd");
					list.add(new Game(result.getInt("Score"), result.getString("Game")));
					System.out.println("123");
				}
			}
			return list;
		} catch (SQLException e) {
			System.out.println("score Exception!!");
			return null;
		}

	}

	public Account GetUserInfo() {
		try {
			Account account;
			String g = "SELECT * FROM users where Email=" + "'" + user.getAccount().getEmail() + "'";
			ResultSet result = st.executeQuery(g);
			while (result.next()) {
				if (result.getString("Email").equals(user.getAccount().getEmail())) {
					account = new Account(result.getString("Name"), result.getString("password"),
							result.getString("Email"), result.getString("Type"));
					return account;
				}
			}
		} catch (SQLException e) {
			System.out.println("Show User info exception:)");
			return null;
		}
		return null;
	}

	public boolean exists(String email) {
		try {

			String g = "SELECT Email FROM users ";
			// System.out.println(g);
			ResultSet result = st.executeQuery(g);
			while (result.next()) {
				if (result.getString("Email").equals(email)) {
					return true;
				}

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return true;
		}
		return false;
	}

	public String LoginDB(String email, String password) {
		try {

			String g = "SELECT * FROM users ";
			// System.out.println(g);
			ResultSet result = st.executeQuery(g);
			while (result.next()) {
				if (result.getString("Email").equals(email) && result.getString("password").equals(password)) {
					String str = result.getString("Type");
					return str;
				}

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return "index";
		}
		return "index";
	}

	public boolean CreateAccountDB(Account account) {

		try {
			PreparedStatement ps = connect
					.prepareStatement("INSERT INTO users(Email,Name, password, Type) VALUES (?,?,?,?)");
			ps.setString(1, account.Email);
			ps.setString(2, account.userName);
			ps.setString(3, account.Password);
			ps.setString(4, account.UserType);
			int j = ps.executeUpdate();
			// return true;
		} catch (SQLException e) {
			return false;
		}

		return true;
	}

	// try {
	// Class.forName("com.mysql.jdbc.Driver");
	// String url = "jdbc:mysql://localhost/scope";
	// String username = "root";
	// String password = "";
	// System.out.println("connected");
	// connect = DriverManager.getConnection(url, username, password);
	// System.out.println("OK");
	// st = connect.createStatement();
	// } catch (Exception e) {
	// System.out.println("cannt connect");
	// }
}