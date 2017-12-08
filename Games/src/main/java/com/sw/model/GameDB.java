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

public class GameDB {
	private Connection connect;
	Statement st;
	User user;
	public GameDB() {

		ConnectionDB connectiondb = new ConnectionDB();
		connect = connectiondb.Connect();
	}
	public int oldscore(String email, String gname) {
		try {
			String g = "select Score from  score where Game =" + "'" + gname + "'" + "and Email=" + "'" + email + "'";
			st = connect.createStatement();
			ResultSet resultset = st.executeQuery(g);
			while (resultset.next()) {
				return resultset.getInt("Score");
			}
		} catch (SQLException e) {
 			return -1;
		}
		return -1;
	}

	public void saveScore(int score, String email, String Gname) {
		try {
			int x = oldscore(email, Gname);
			PreparedStatement ps;
			  if (x == -1) {
				  ps = connect.prepareStatement("INSERT INTO score(Email, Game, Score) VALUES (?,?,?)");
				ps.setString(1, email);
				ps.setString(2, Gname);
				ps.setInt(3, score);

				int j = ps.executeUpdate();

			}else if (x < score) {
				  ps = connect.prepareStatement("UPDATE Score SET Score = ? where Game =? and Email=?");
					ps.setInt(1, score);
					ps.setString(2, Gname);
					ps.setString(3, email);
					int j = ps.executeUpdate();
  			}
				
		} catch (SQLException e) {
 			e.printStackTrace();
		}

	}

	public List<MCQ> RetriveGame(String gamename, String coursename) {
		ResultSet resultset = null;
		System.out.println(gamename + " " + coursename);
		List<MCQ> list = new ArrayList<MCQ>();
		String g;
		// coursename="math";gamename="addition";
		try {
			g = "select * from " + coursename + " where Game_Name =" + "'" + gamename + "'";
			System.out.println(g);
			st = connect.createStatement();
			resultset = st.executeQuery(g);
			while (resultset.next()) {
				list.add(new MCQ(resultset.getString("Question"), resultset.getString("Answer"),
						resultset.getString("A"), resultset.getString("B"), resultset.getString("C"),
						resultset.getString("D")));
				System.out.println("asd" + resultset.getString("Question"));
			}
			return list;
		} catch (Exception e) {
			return list;
		}
	}

	public boolean AddGame(Game game) {
		try {

			//System.out.println("WWW" + game.course_name + "-" + game.MCQ_Questions.get(0).Question);
			for (int t = 0; t < game.MCQ_Questions.size(); t++) {
				PreparedStatement ps = connect.prepareStatement("INSERT INTO " + game.course_name
						+ "(Game_Name ,  Question ,  Answer ,  A ,  B ,  C ,  D ) VALUES (?,?,?,?,?,?,?)");
				ps.setString(1, game.Game_Name);
				ps.setString(2, game.MCQ_Questions.get(t).Question);
				ps.setString(3, game.MCQ_Questions.get(t).answer);
				ps.setString(4, game.MCQ_Questions.get(t).a);
				ps.setString(5, game.MCQ_Questions.get(t).b);
				ps.setString(6, game.MCQ_Questions.get(t).c);
				ps.setString(7, game.MCQ_Questions.get(t).d);
				// int i = st.executeUpdate(g);
				System.out
						.println("ADD" + game.MCQ_Questions.get(t).Question + ">>+" + game.MCQ_Questions.get(t).answer);
				int j = ps.executeUpdate();
			}
		} catch (Exception e) {
			System.out.println("exception :-)");
			return false;
		}
		return true;

	}

}
