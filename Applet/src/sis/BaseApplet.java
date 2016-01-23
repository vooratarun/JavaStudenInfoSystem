package sis;

import java.awt.*;
import java.util.Date;
import java.sql.*;
import java.awt.event.*;

import javax.swing.*;

public class BaseApplet extends Panel{
	Statement stmt;
	ResultSet rs;
	String sql;
	String courseName;
	Date date;
	int marksGained,totalMarks;
	Boolean[] status;
	boolean dummy;
	Button takeExam;
	Home hm;
	Button personalDetails,examRegistration,logout;

	public BaseApplet(final Home hm){
		this.hm = hm;
		setLayout(null);
		String[] t2 = {"CourseName","ExamDate","MarksGained","TotalMarks"};
		Object[][] t1 = null;
		CreateJDBCConnection jdbc = new CreateJDBCConnection();
		stmt = jdbc.getStatement();
		sql = "select a.CourseName,a.ExamDate,b.marks,a.TotalMarks,b.status from course_details a,course_registration b where b.iddno='"+hm.userId+"' and a.CourseName = b.course;";
		try {
			stmt.execute("use jana;");
			rs = stmt.executeQuery(sql);
			int i=0;
			dummy= rs.last();
			if(dummy){
				t1 = new Object[rs.getRow()][];
				status = new Boolean[rs.getRow()];
			}
			rs.beforeFirst();
			while(rs.next()){
				courseName = rs.getString("CourseName");
				date = rs.getDate("ExamDate");
				marksGained = rs.getInt("marks");
				totalMarks = rs.getInt("TotalMarks");
				status[i] = rs.getBoolean("status");
				Object[] o2= {courseName,date,marksGained,totalMarks};
				t1[i]=o2;
				i++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		final JTable sa = new JTable(t1,t2);
		sa.setEnabled(true);
		JScrollPane sp = new JScrollPane();
		sp.setViewportView(sa);
		takeExam = new Button("Take Exam");
		takeExam.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(sa.getSelectedRow()!=-1){
					if(!status[sa.getSelectedRow()]){
						int ch = JOptionPane.showConfirmDialog(null,"Ready For Exam" ,"Confirm" , JOptionPane.OK_CANCEL_OPTION);					
						if(ch==JOptionPane.OK_OPTION){
		    	   			 hm.removeAll();
		    	   			 hm.p2 = new Exam(hm,sa.getValueAt(sa.getSelectedRow(), 0).toString());
		    	   			 hm.p2.setBounds(0, 0, 600, 600);
		    	   			 hm.add(hm.p2);
		    	   			 hm.revalidate();
						}
						else{
							System.out.println("NO");
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "You have already finished Exam" ,"Alert", JOptionPane.OK_OPTION);
					}
				}
				else{
					JOptionPane.showMessageDialog(null,"Please Select any Row" ,"Alert" , JOptionPane.OK_OPTION);					
				}
			}
		});
		Label lb = new Label("Current Sem Detials");
		lb.setBounds(250,30,200,50);
		add(lb);

		if(dummy)
			add(sp);
		else{
			Label l = new Label("Please Register First");
			l.setBounds(250,100,200,50);
			add(l);
		}
		sp.setBounds(100, 80, 400, 90);
		add(takeExam);
		takeExam.setBounds(250, 200, 100, 30);
		hm.p1 = new Panel();
		hm.p1.setLayout(null);
		hm.p1.setBounds(0, 0, 600, 50);
		personalDetails = new Button("PersonalDetails");
		personalDetails.setBounds(300, 10, 90, 30);
		
		personalDetails.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				hm.removeAll();
				PersonalDetails p1 = new PersonalDetails(hm);
				p1.createTopPanel();
				p1.setTextFieldsToData();
				hm.p2 = p1;
				hm.p2.setBounds(0, 60, 500, 400);
				hm.add(hm.p2);
				hm.revalidate();
			}			
		});
		
		examRegistration = new Button("ExamRegistration");
		examRegistration.setBounds(400, 10, 100, 30);
		examRegistration.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				hm.removeAll();
				hm.p2 = new ExamRegistration(hm);
				hm.p2.setBounds(0, 50, 500, 400);
				hm.add(hm.p2);
				hm.revalidate();
			}			
		});

		logout = new Button("logout");
		logout.setBounds(510, 10, 90, 30);
		logout.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				hm.removeAll();
				hm.addPanel1();
				hm.addPanel2();
				hm.revalidate();				
			}
		});

		Label lb2 = new Label("Welcome "+hm.userId);
		lb2.setBounds(20, 10, 150, 30);
		hm.p1.add(lb2);
		hm.p1.add(personalDetails);
		hm.p1.add(examRegistration);
		hm.p1.add(logout);
		hm.p1.setBackground(Color.gray);
		hm.add(hm.p1);
	}
}
