import java.awt.Choice;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Image;
import java.sql.ResultSet;

import javax.swing.*;
public class RemoveEmployee extends JFrame implements ActionListener{

	JLabel empid,name,namelabel,phone,phonelabel,email,emaillabel,background;
	Choice empidchoice;
	JButton delete,back;
	
	RemoveEmployee()
	{
		setSize(1000,400);
		setLocation(300,150);
		setLayout(null);
		
		getContentPane().setBackground(Color.white);
		
		empid=new JLabel("Employee ID");
		empid.setBounds(50,50,100,30);
		add(empid);
		
		empidchoice=new Choice();
		empidchoice.setBounds(200,50,150,30);
		add(empidchoice);
		
		//to fetch all emp id from employee table and add them in choice
		try
		{
			Conn c=new Conn();
			String query="select * from employee";
			ResultSet rs=c.s.executeQuery(query);
			while(rs.next())
			{
				empidchoice.add(rs.getString("empid"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		name=new JLabel("Name");
		name.setBounds(50,100,100,30);
		add(name);
		
		namelabel=new JLabel();
		namelabel.setBounds(200,100,200,30);
		add(namelabel);
		
		phone=new JLabel("Phone");
		phone.setBounds(50,150,100,30);
		add(phone);
		
		phonelabel=new JLabel();
		phonelabel.setBounds(200,150,200,30);
		add(phonelabel);
		
		email=new JLabel("Email");
		email.setBounds(50,200,100,30);
		add(email);
		
		emaillabel=new JLabel();
		emaillabel.setBounds(200,200,200,30);
		add(emaillabel);
		
		//to display data of selected empid
		empidchoice.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent ie)
			{
				try
				{
					Conn c=new Conn();
					String query="select * from employee where empid = '"+empidchoice.getSelectedItem()+"' ";
					ResultSet rs=c.s.executeQuery(query);
					while(rs.next())
					{
						namelabel.setText(rs.getString("name"));
						phonelabel.setText(rs.getString("phone"));
						emaillabel.setText(rs.getString("email"));
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		
		delete=new JButton("Delete");
		delete.setBounds(80,300,100,30);
		delete.setBackground(Color.black);
		delete.setForeground(Color.white);
		delete.addActionListener(this);
		add(delete);
		
		back=new JButton("Back");
		back.setBounds(220,300,100,30);
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.addActionListener(this);
		add(back);
		
		ImageIcon img=new ImageIcon("icon/delete.png");
		Image i=img.getImage().getScaledInstance(600,400,Image.SCALE_DEFAULT);
		ImageIcon imgnew=new ImageIcon(i);
		
		background=new JLabel(imgnew);
		background.setBounds(350,0,600,400);
		add(background);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==delete)
		{
			try
			{
				Conn c=new Conn();
				String query="delete from employee where empid = '"+empidchoice.getSelectedItem()+"' ";
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Employee Information Deleted Successfully");
				setVisible(false);
				new Home();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			setVisible(false);
			new Home();
		}
	}
	
	public static void main(String[] args) {
		new RemoveEmployee();

	}

}
