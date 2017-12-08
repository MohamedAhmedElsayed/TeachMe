package com.sw.model;
 
public class MCQ {

    public String a;
  public   String b;
  public  String c;
  public  String d;
    public String Question;
   public String answer;

    public MCQ() {
        this.a = "";
        this.b = "";
        this.c = "";
        this.d = "";
        this.Question = "";
        this.answer = "";

    }
    public MCQ(String Q, String Ans, String a, String b, String c, String d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.Question = Q;
        this.answer = Ans;

    }
    public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public String getB() {
		return b;
	}

	public void setB(String b) {
		this.b = b;
	}

	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c;
	}

	public String getD() {
		return d;
	}

	public void setD(String d) {
		this.d = d;
	}

	public String getQuestion() {
		return Question;
	}

	public void setQuestion(String question) {
		Question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	

}
 