package sis;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class Exam extends Panel{
	Statement stmt;
	ResultSet rs;
	Home hm;
	String course;
	ArrayList<Question> questions = new ArrayList<Question>();
	ArrayList<CheckboxGroup> optsGroup = new ArrayList<CheckboxGroup>();
	Array a;
	public void str(String subject){
		CreateJDBCConnection jdbc = new CreateJDBCConnection();
		stmt = jdbc.getStatement();
		try {
			stmt.executeUpdate("use jana;");
			rs = stmt.executeQuery("select * from "+subject+";");
			int i = 1;
			while(rs.next()){
				String[] options = rs.getString("options").split("##");
				Question qsn = new Question("Q"+i+")"+rs.getString("questions"),options,rs.getString("answer"));
				questions.add(qsn);
				i++;
			}
		} catch (SQLException e){
			// TODO Auto-generated catch block
			System.out.println("Cannot get Exam....");
		}
	}
	public Exam(final Home hm,String cr){
		this.hm = hm;
		course = cr;
		str(course);
		int i = 0,j;
		Question qsn;
		setSize(200,200);
		setLayout(new BorderLayout());
		JScrollPane sp = new JScrollPane();
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(0,1));
		while(i < questions.size()){
			j = 0;
			qsn = questions.get(i);
			optsGroup.add(new CheckboxGroup());
			p.add(new Label(qsn.question));
			while(j < qsn.options.length){
				p.add(new Checkbox(qsn.options[j],optsGroup.get(i),false));
				j++;
			}
			i++;
		}
		JButton submit = new JButton("Submit");
		submit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "marks "+evaluateAnswers(),"Result", JOptionPane.OK_OPTION);
				hm.remove(hm.p2);
				hm.p2 = new BaseApplet(hm);
				hm.p2.setBounds(0, 50, 600, 550);
				hm.add(hm.p2);
				hm.revalidate();
			}
		});
		sp.setViewportView(p);
		add(sp,BorderLayout.CENTER);
		add(submit,BorderLayout.SOUTH);

//		submit.setBounds(250, 500, 100, 30);
	}
		
	public int evaluateAnswers(){
		int totalQuestions = questions.size(),notAttempted=0,marks = 0;
		CreateJDBCConnection jdbc = new CreateJDBCConnection();
		Statement stmt = jdbc.getStatement();
		for(int i=0;i<optsGroup.size();i++){
			try{
			if(optsGroup.get(i).getSelectedCheckbox().getLabel().equals(questions.get(i).answer)){
				marks++;
			}
			}catch(NullPointerException e){
				notAttempted++;
			}
		}
		try {
			stmt.execute("use jana;");
			String sql = "update course_registration set marks = "+marks+",status = 1 where iddno='"+hm.userId+"' and course ='"+course+"';";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return marks;
	}
}


