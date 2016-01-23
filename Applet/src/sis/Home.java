package sis;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends Applet{
	String userId = null;
	Panel p1,p2;
	Label title;
	Button home,login,register;
	public void init(){
		setSize(600,600);
		setLayout(null);
		addPanel1();
		addPanel2();
	}
	
	public Home getInstance(){
		return this;
	}
	
	public void addPanel1(){
		home = new Button("Home");
		home.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				remove(p2);
				p2 = new Panel();
				p2.setLayout(null);
				p2.add(title);
				p2.setBounds(0,40,600,560);
				add(p2);
				revalidate();
			}
		});
		
		login = new Button("Login");
		login.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				remove(p2);
				p2 = new LoginScreen(getInstance());
				p2.setBounds(0,40,600,560);
				add(p2);
				revalidate();
			}
		});
		
		register = new Button("Register");
		register.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				remove(p2);
				p2 = new Register(getInstance());
				p2.setBounds(30,50,500,400);
				add(p2);
				revalidate();
			}
		});

		home.setBounds(350, 5, 50, 30);
		login.setBounds(430, 5, 50, 30);
		register.setBounds(510, 5, 50, 30);

		p1 = new Panel();
		p1.setLayout(null);
		p1.setBackground(Color.cyan);
		p1.add(home);
		p1.add(login);
		p1.add(register);
		p1.setBounds(0, 0, 600, 40);
		add(p1);
	}
	public void addPanel2(){
		title = new Label("STUDENT INFORMATION SYSTEM");
		title.setBounds(200, 200, 300, 100);
		
		p2 = new Panel();
		p2.setBackground(Color.gray);
		p2.setLayout(null);
		p2.add(title);
		p2.setBounds(0,40,600,560);
		add(p2);		
	}
}
