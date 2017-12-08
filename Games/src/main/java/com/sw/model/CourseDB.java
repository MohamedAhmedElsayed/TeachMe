package com.sw.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.sw.model.course;

 
import com.sw.controller.ConnectionDB;
import com.sw.controller.User;

public class CourseDB {

	private Connection connect;
	Statement st;
    User user;


	public CourseDB() {

		try {
			ConnectionDB connectiondb = new ConnectionDB();
			connect = connectiondb.Connect();
			st = connect.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<String> ShowCourses() {
		ResultSet resultset = null;
		List<String> list = new ArrayList<String>();
		try {
			String g = "SELECT CourseName FROM courses WHERE GameName IS NULL;";

			resultset = st.executeQuery(g);
			System.out.println(g);
			while (resultset.next()) {
				// System.out.println(resultset.getString("CourseName") +
				// resultset.getString("GameName"));
				list.add( resultset.getString("CourseName"));
			}

		} catch (SQLException e) {
			return null;
		}

		return list;
	}
	public List<course> ShowUserCourses() {
		ResultSet resultset = null;
		List<course> list = new ArrayList<course>();
		try {
			String g = "SELECT * FROM courses WHERE user="+"'"+user.getAccount().getEmail()+"'";
			resultset = st.executeQuery(g);
			System.out.println(g);
			while (resultset.next()) {
				// System.out.println(resultset.getString("CourseName") +
				// resultset.getString("GameName"));
				list.add(new course(resultset.getString("CourseName"),resultset.getString("GameName")));
			}

		} catch (SQLException e) {
			System.out.println("Show courses exception:)");
			return null;
		}

		return list;
	}
	public List<String> showGamesInCourse(String c) {
		ResultSet resultset = null;
		List<String> list = new ArrayList<String>();

		try {
			c=c.substring(1,c.length());
			String g = "select GameName from courses where CourseName = " + "'" + c + "'";
			 
			System.out.println(c);
			resultset = st.executeQuery(g);
			while (resultset.next()) {
				System.out.println(resultset.getString("GameName"));
				list.add(resultset.getString("GameName"));
			}
		} catch (SQLException e) {
			System.out.println("Show Games Exception!!");
			return null;
		}

		return list;
	}

	public List<course> SelectAll() {

		ResultSet resultset = null;
		List<course> list = new ArrayList<course>();

		try {
			String g = "select * from courses WHERE GameName IS not NULL; ";
			resultset = st.executeQuery(g);
			while (resultset.next()) {
				// System.out.println(resultset.getString("GameName"));
				list.add(new course(resultset.getString("CourseName"), resultset.getString("GameName")));
			}
		} catch (SQLException e) {
			return null;
		}

		return list;

	}

	public boolean courseExists(String coursename) {
		ResultSet resultset = null;
		System.out.println("ch"+coursename);

		try {
			String g = "SELECT * FROM courses where CourseName=" + "'" + coursename + "'" ;
			resultset = st.executeQuery(g);
			while(resultset.next()){
			if (resultset.getString("CourseName").equals(coursename)) {
				return true;
			}
			}
			return false;
		} catch (SQLException e) {
			System.out.println("course exist function exception");
			return false;
		}

	}

	public boolean AddCourse(String coursename) {
		System.out.println(coursename);
		 coursename=coursename.substring(0,coursename.length()-1);
			System.out.println(coursename);

	//	System.out.println("exists"+courseExists(coursename));
		if (!courseExists(coursename)) {
			try {
				PreparedStatement ps = connect.prepareStatement("INSERT INTO courses(CourseName,user) VALUES (?,?)");
				ps.setString(1, coursename);
				ps.setString(2, user.getAccount().getEmail());
				//ps.setString(2, user);
				int j = ps.executeUpdate();
				String g = "create table "+coursename +"(Game_Name varchar(700),Question varchar(700),Answer varchar(700),A varchar(700),B varchar(700), C varchar(700),D varchar(700))";
				int i = st.executeUpdate(g);
				return true;
 			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		} else {
			System.out.println(" Course exists :))");
			return false;
		}
	}

	public void AddGameinCourse(String coursename, String gamename) {

		try {
			PreparedStatement ps = connect.prepareStatement("INSERT INTO courses(CourseName,GameName,user) VALUES (?,?,?)");
			ps.setString(1, coursename);
			ps.setString(2, gamename);
			ps.setString(3,user.getAccount().getEmail());
			int i = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
