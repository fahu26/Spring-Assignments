package com.fahim;

import java.util.Map;

public class Question3 {
private int questionId;
private String question;
private Map<Integer,String> answers;
public int getQuestionId() {
	return questionId;
}
public void setQuestionId(int questionId) {
	this.questionId = questionId;
}
public String getQuestion() {
	return question;
}
public void setQuestion(String question) {
	this.question = question;
}
public Map<Integer,String> getAnswers() {
	return answers;
}
public void setAnswers(Map<Integer,String> answers) {
	this.answers = answers;
}
@Override
public String toString() {
	return "[questionId=" + questionId + ", question=" + question + ", answers=" + answers + "]";
}

public void displayDetails() {
	System.out.println("Question: "+getQuestion());
		System.out.println("Answers: "+getAnswers());
}

}
