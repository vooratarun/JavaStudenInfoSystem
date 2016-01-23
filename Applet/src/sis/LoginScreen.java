package sis;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class LoginScreen extends Panel{
	Statement stmt;
	Label name,pass;
	TextField nameText,passText;
	BaseApplet bp;
	Home hm;
	
	public LoginScreen(final Home hm){
		setSize(600,550);
		setLayout(null);
		this.hm = hm;
		name = new Label("Username : ");
		add(name);
		name.setBounds(150, 50, 100, 30);
		nameText = new TextField(6);
		add(nameText);
		nameText.setBounds(250, 50, 100, 30);
		pass = new Label("Password :");
		pass.setBounds(150, 100, 100, 30);
		add(pass);
		passText = new TextField(6);
		passText.setBounds(250, 100, 100, 30);
		passText.setEchoChar('*');
		add(passText);
		Button login = new Button("login");
		login.addActionListener(new ActionListener(){
	         public void actionPerformed(ActionEvent e) {
	    	   	 try{
	    	   		 if(isValidUser()){
	    	   			 hm.removeAll();
	    	   			 hm.userId = nameText.getText();
	    	   			 hm.p2 = new BaseApplet(hm);
	    	   			 hm.p2.setBounds(0, 50, 600, 550);
	    	   			 hm.add(hm.p2);
	    	   			 hm.revalidate();
	    	   		 }
	    	   		 else{
	 					JOptionPane.showMessageDialog(null,"Invalid Credentials" ,"Alert" , JOptionPane.OK_OPTION);	    	   			 
	    	   		 }
	    	   	 }catch(Exception e1){
	    			 System.out.println("Error");
	    		 }		
	         }
	      });
		login.setBounds(200, 150, 100, 30);
		add(login);
	}
	
	
	public boolean isValidUser() throws SQLException{
		 CreateJDBCConnection jdbc = new CreateJDBCConnection();
		 Statement stmt = jdbc.getStatement();
		 stmt.execute("use jana;");
		 String sqlQuery = "select password from user_details where idno = '"+nameText.getText()+"';";	        				 			 
		 ResultSet rs = stmt.executeQuery(sqlQuery);
		 while(rs.next()){
			 if(rs.getString("password").equals(passText.getText()))
				 return true;
		 }		
		return false;
	}
}
