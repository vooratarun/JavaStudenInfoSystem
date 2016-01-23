package sis;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class ExamRegistration extends Panel{
	
	ResultSet rs;
	Choice subject1 = new Choice();
	Choice subject2 = new Choice();
	Choice subject3 = new Choice();
	Choice subject4 = new Choice();
	String[] s = {"CN","OOPS","ITW","AI"};
	
	Button clr,submit,loginHome,personalDetails,logout;
	Label l;
	Home hm;

	public ExamRegistration(final Home hm){
		this.hm = hm;
		setLayout(null);
		subject1.addItem("CN");
		subject1.addItem("OOPS");
		subject1.addItem("ITW");
		subject1.addItem("AI");
		l = new Label("Subject 1 :");
		l.setBounds( 10 , 50 , 100, 30);
		add(l);
		subject1.setBounds(150, 50, 100, 30);
		add(subject1);
		subject2.addItem("CN");
		subject2.addItem("OOPS");
		subject2.addItem("ITW");
		subject2.addItem("AI");
		l = new Label("Subject 2 :");
		l.setBounds( 10 , 100 , 100, 30);
		add(l);
		subject2.setBounds(150, 100, 100, 30);
		add(subject2);
		subject3.addItem("CN");
		subject3.addItem("OOPS");
		subject3.addItem("ITW");
		subject3.addItem("AI");
		l = new Label("Subject 3 :");
		l.setBounds( 10 , 150 , 100, 30);
		add(l);
		subject3.setBounds(150, 150, 100, 30);
		add(subject3);
		subject4.addItem("CN");
		subject4.addItem("OOPS");
		subject4.addItem("ITW");
		subject4.addItem("AI");
		l = new Label("Subject 4 :");
		l.setBounds( 10 , 200 , 100, 30);
		add(l);
		subject4.setBounds(150, 200, 100, 30);
		add(subject4);

		submit = new Button("Submit");
		submit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(check()){
					if(doRegistration()){
						JOptionPane.showMessageDialog(null, "Registration Successful", "Message", JOptionPane.OK_OPTION);
					}
					else{
						JOptionPane.showMessageDialog(null, "Registration Unsucceful", "Message", JOptionPane.OK_OPTION);					
					}
				}
			}	
		});
		submit.setBounds(100, 250, 100, 30);
		add(submit);
		
		hm.p1 = new Panel();
		hm.p1.setLayout(null);
		hm.p1.setBounds(0, 0, 600, 50);
		loginHome = new Button("LoginHome");
		loginHome.setBounds(300, 10, 90, 30);
		
		loginHome.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				hm.removeAll();
				hm.p2 = new BaseApplet(hm);
				hm.p2.setBounds(0, 50, 500, 400);
				hm.add(hm.p2);
				hm.revalidate();
			}
			
		});
		
		personalDetails = new Button("PersonalDetails");
		personalDetails.setBounds(400, 10, 90, 30);
		personalDetails.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				hm.removeAll();
				PersonalDetails p1 = new PersonalDetails(hm);
				p1.createTopPanel();
				hm.p2 = p1;
				hm.p2.setBounds(0, 50, 500, 400);
				hm.add(hm.p2);
				hm.revalidate();				
			}
		});
		
		logout = new Button("logout");
		logout.setBounds(500, 10, 90, 30);
		logout.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				hm.removeAll();
				hm.addPanel1();
				hm.addPanel2();
			}
		});
		Label lb2 = new Label("Welcome "+hm.userId);
		lb2.setBounds(20, 10, 150, 30);
		hm.p1.add(lb2);

		hm.p1.add(loginHome);
		hm.p1.add(personalDetails);
		hm.p1.add(logout);
		hm.p1.setBackground(Color.gray);
		hm.add(hm.p1);
		
		
	}
	
	public boolean check(){
		
		if(subject1.getSelectedItem().equals(subject2.getSelectedItem()) || subject1.getSelectedItem().equals(subject3.getSelectedItem()) || subject1.getSelectedItem().equals(subject4.getSelectedItem()) || subject2.getSelectedItem().equals(subject3.getSelectedItem()) || subject2.getSelectedItem().equals(subject4.getSelectedItem())|| subject3.getSelectedItem().equals(subject4.getSelectedItem())){
			JOptionPane.showMessageDialog(null, "Please Select diff subjects", "Alert", JOptionPane.OK_OPTION);
			return false;
		}
		return true;
	}
	
	public boolean doRegistration(){
		CreateJDBCConnection jdbc = new CreateJDBCConnection();
		Statement stmt = jdbc.getStatement();
		try {
			stmt.execute("use jana;");
			stmt.executeUpdate("insert into course_registration values('"+hm.userId+"','"+subject1.getSelectedItem()+"',0,0);");
			stmt.executeUpdate("insert into course_registration values('"+hm.userId+"','"+subject2.getSelectedItem()+"',0,0);");
			stmt.executeUpdate("insert into course_registration values('"+hm.userId+"','"+subject3.getSelectedItem()+"',0,0);");
			stmt.executeUpdate("insert into course_registration values('"+hm.userId+"','"+subject4.getSelectedItem()+"',0,0);");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
	}	
}
