package com.sw.model;

public class course {
	public String coursename;
	public String gamename;

	public course() {
		coursename = "";
		gamename = "";
	}

	public course(String cname, String gname) {
		coursename = cname;
		gamename = gname;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public String getGamename() {
		return gamename;
	}

	public void setGamename(String gamename) {
		this.gamename = gamename;
	}
}
