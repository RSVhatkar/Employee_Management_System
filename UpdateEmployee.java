import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class UpdateEmployee extends JFrame implements ActionListener{
	
	JLabel heading,name,namelabel,fathersname,dob,doblabel,salary,address,phone,email,highesteducation,designation,adharno,adharnolabel,empid,empidtext;
	JTextField fathersnametext,salarytext,addresstext,phonetext,emailtext,designationtext,adharnotext,highesteducationtext;
	JButton update,back;
	String empid1;
	
	UpdateEmployee(String empid1)
	{
		this.empid1=empid1;
		setSize(900,700);
		setLocation(300,50);
		setLayout(null);
		
		getContentPane().setBackground(Color.white);
		
		heading=new JLabel("Update Employee Detail");
		heading.setBounds(320,30,500,50);
		heading.setFont(new Font("SAN_SERIF",Font.BOLD,25));
		add(heading);
		
		name=new JLabel("Name");
		name.setBounds(50,150,150,30);
		name.setFont(new Font("Serif",Font.PLAIN,20));
		add(name);
		
		namelabel=new JLabel();
		namelabel.setBounds(200,150,150,30);
		add(namelabel);
		
		fathersname=new JLabel("Father's Name");
		fathersname.setBounds(400,150,150,30);
		fathersname.setFont(new Font("Serif",Font.PLAIN,20));
		add(fathersname);
		
		fathersnametext=new JTextField();
		fathersnametext.setBounds(600,150,150,30);
		add(fathersnametext);
		
		dob=new JLabel("Date of Birth");
		dob.setBounds(50,200,150,30);
		dob.setFont(new Font("Serif",Font.PLAIN,20));
		add(dob);
		
		doblabel=new JLabel();
		doblabel.setBounds(200,200,150,30);
		add(doblabel);
		
		salary=new JLabel("Salary");
		salary.setBounds(400,200,150,30);
		salary.setFont(new Font("Serif",Font.PLAIN,20));
		add(salary);
		
		salarytext=new JTextField();
		salarytext.setBounds(600,200,150,30);
		add(salarytext);
		
		address=new JLabel("Address");
		address.setBounds(50,250,150,30);
		address.setFont(new Font("Serif",Font.PLAIN,20));
		add(address);
		
		addresstext=new JTextField();
		addresstext.setBounds(200,250,150,30);
		add(addresstext);
		
		phone=new JLabel("Phone");
		phone.setBounds(400,250,150,30);
		phone.setFont(new Font("Serif",Font.PLAIN,20));
		add(phone);
		
		phonetext=new JTextField();
		phonetext.setBounds(600,250,150,30);
		add(phonetext);
		
		email=new JLabel("Email");
		email.setBounds(50,300,150,30);
		email.setFont(new Font("Serif",Font.PLAIN,20));
		add(email);
		
		emailtext=new JTextField();
		emailtext.setBounds(200,300,150,30);
		add(emailtext);
		
		highesteducation=new JLabel("Hightest Education");
		highesteducation.setBounds(400,300,150,30);
		highesteducation.setFont(new Font("Serif",Font.PLAIN,20));
		add(highesteducation);
		
		highesteducationtext=new JTextField();
		highesteducationtext.setBounds(600,300,150,30);
		add(highesteducationtext);
		
		designation=new JLabel("Designation");
		designation.setBounds(50,350,150,30);
		designation.setFont(new Font("Serif",Font.PLAIN,20));
		add(designation);
		
		designationtext=new JTextField();
		designationtext.setBounds(200,350,150,30);
		add(designationtext);
		
		adharnolabel=new JLabel("Adhar No");
		adharnolabel.setBounds(400,350,150,30);
		adharnolabel.setFont(new Font("Serif",Font.PLAIN,20));
		add(adharnolabel);
		
		adharnotext=new JTextField();
		adharnotext.setBounds(600,350,150,30);
		add(adharnotext);
		
		empid=new JLabel("Employee ID");
		empid.setBounds(50,400,150,30);
		empid.setFont(new Font("Serif",Font.PLAIN,20));
		add(empid);
		
		empidtext=new JLabel();
		empidtext.setBounds(200,400,150,30);
		empidtext.setFont(new Font("Serif",Font.PLAIN,20));
		add(empidtext);
		
		//to fetch data of selected id
		try
		{
			Conn c=new Conn();
			String query="select * from employee where empid = '"+empid1+"' ";
			ResultSet rs=c.s.executeQuery(query);
			while(rs.next())
			{
				namelabel.setText(rs.getString("name"));
				fathersnametext.setText(rs.getString("fname"));
				doblabel.setText(rs.getString("dob"));
				salarytext.setText(rs.getString("salary"));
				addresstext.setText(rs.getString("address"));
				phonetext.setText(rs.getString("phone"));
				emailtext.setText(rs.getString("email"));
				highesteducationtext.setText(rs.getString("education"));
				designationtext.setText(rs.getString("designation"));
				adharnotext.setText(rs.getString("adharno"));
				empidtext.setText(rs.getString("empid"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		update=new JButton("Update");
		update.setBounds(250,550,150,40);
		update.setBackground(Color.black);
		update.setForeground(Color.white);
		add(update);
		update.addActionListener(this);
		
		back=new JButton("Back");
		back.setBounds(450,550,150,40);
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		add(back);
		back.addActionListener(this);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==update)
		{
			String sfathersname=fathersnametext.getText();
			String ssalary=salarytext.getText();
			String saddress=addresstext.getText();
			String sphone=phonetext.getText();
			String semail=emailtext.getText();
			String shighesteducation=highesteducationtext.getText();
			String sdesignation=designationtext.getText();
			String sadharno=adharnotext.getText();
			String seid=empidtext.getText();
			
			try
			{
				Conn c=new Conn();
				String query="update employee set fname = '"+sfathersname+"', salary = '"+ssalary+"', address= '"+saddress+"', phone = '"+sphone+"',email = '"+semail+"', education = '"+shighesteducation+"', designation = '"+sdesignation+"',  adharno = '"+sadharno+"' where empid = '"+seid+"' ";
				c.s.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null, "Employee Details Updated Successfully");
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
		new UpdateEmployee("");

	}

}
