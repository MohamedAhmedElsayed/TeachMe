package com.sw.model;

import java.util.ArrayList;
import java.util.List;

public class Game {

	public List<MCQ> MCQ_Questions;
	public String course_name;
	public String Game_Name;
	public String user;
	public int score;

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	MCQ mcq;

	public void AddMCQ(MCQ mcq) {
		this.MCQ_Questions.add(mcq);
	}

	public List getMCQ_Questions() {
		return MCQ_Questions;
	}

	public void setMCQ_Questions(List mCQ_Questions) {
		MCQ_Questions = mCQ_Questions;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public String getGame_Name() {
		return Game_Name;
	}

	public void setGame_Name(String game_Name) {
		Game_Name = game_Name;
	}

	public Game(int score, String Gname) {
		this.score = score;
		this.Game_Name = Gname;
	}

	public Game() {
		MCQ_Questions = new ArrayList<MCQ>();
		course_name = "";
		Game_Name = "";
		user = "";
		score = 0;
	}

	public void add_game() {
	}

	public void play_game() {
	}
}
