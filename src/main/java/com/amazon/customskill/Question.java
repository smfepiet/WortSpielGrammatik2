package com.amazon.customskill;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Question {

	static String questionText = null;
	private int WhichWord;
	private String CorrectAnswer = null;
	private String AlexaCorrectAnswer = null;
	private int FrageNr;

	private static Connection con = null;
	private static Statement stmt = null;
	int rand = 0;  //

	public Question(int WhichWord) {
		this.WhichWord = WhichWord;
	}

	
	/*
	 selektiert den Inhalt der Zeile in Words Tabelle fuer das benoetigte Wort anhand des Niveus.
	 * */
	public String selectQuestion() {

		try {
			con = DBConnection.getConnection();
			stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery("SELECT * FROM Frage WHERE WhichWord=" + WhichWord + "");// Question based on the WordId 

			questionText = rs.getString("Frage");
			CorrectAnswer = rs.getString("CorrectAnswer");
			AlexaCorrectAnswer = rs.getString("AlexaCorrectAnswer");// was Alexa sagt 
			WhichWord = rs.getInt("WordID");
			//FrageNr = rs.getInt("FrageNr");

			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return questionText;
	}

	public static String getQuestionText() {
		return questionText;
	}

	public static void setQuestionText(String questionText) {
		Question.questionText = questionText;
	}

	public int getWhichWord() {
		return WhichWord;
	}

	public void setWhichWord(int whichWord) {
		WhichWord = whichWord;
	}


	public String getAlexaCorrectAnswer() {
		return AlexaCorrectAnswer;
	}

	public void setAlexaCorrectAnswer(String alexaCorrectAnswer) {
		AlexaCorrectAnswer = alexaCorrectAnswer;
	}

	public int getFrageNr() {
		return FrageNr;
	}

	public void setFrageNr(int FrageNr) {
		this.FrageNr = FrageNr;
	}

	public void setCorrectAnswer(String correctAnswer) {
		CorrectAnswer = correctAnswer;
	}

	public String getQuestion() {
		return questionText;
	}

	public String getCorrectAnswer() {
		return CorrectAnswer;
	}

}
