import java.awt.Color;
import java.awt.Image;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;
public class Login extends JFrame implements ActionListener{

	JLabel username,password,background;
	JTextField usernametext;
	JPasswordField passwordtext;
	JButton login;
	
	Login()
	{
		setLayout(null);
		setSize(600,300);
		setLocation(450,200);
		
		getContentPane().setBackground(Color.white);
		
		username=new JLabel("Username");
		username.setBounds(40,20,100,30);
		add(username);
		
		usernametext=new JTextField();
		usernametext.setBounds(150,20,150,30);
		add(usernametext);
		
		password=new JLabel("Password");
		password.setBounds(40,70,100,30);
		add(password);
		
		passwordtext=new JPasswordField();
		passwordtext.setBounds(150,70,150,30);
		add(passwordtext);
		
		login=new JButton("Login");
		login.setBounds(150,140,150,30);
		login.setBackground(Color.black);
		login.setForeground(Color.white);
		add(login);
		login.addActionListener(this);
		
		ImageIcon img=new ImageIcon("icon/second.jpg");
		Image i=img.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
		ImageIcon imgnew=new ImageIcon(i);
		
		background=new JLabel("",imgnew,JLabel.CENTER);
		background.setBounds(350,0,200,200);
		add(background);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String susername=usernametext.getText();
		String spassword=passwordtext.getText();
		
		try
		{
			Conn c=new Conn();
			String query="select * from login where username = '"+susername+"' and password = '"+spassword+"' ";
			ResultSet rs=c.s.executeQuery(query);
			if(rs.next())
			{
				JOptionPane.showMessageDialog(null,"Login Successfull");
				setVisible(false);
				new Home();
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Invalid username or password");
				setVisible(false);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Login();

	}

}
