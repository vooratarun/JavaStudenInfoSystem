package sis;

public class Question {
	public String question;
	public String[] options;
	public String answer;
	public Question(String qsn,String[] opts){
		question = qsn;
		options = opts;
	}
	public Question(String qsn,String[] opts,String ans){
		this(qsn,opts);
		answer = ans;
	}
}
