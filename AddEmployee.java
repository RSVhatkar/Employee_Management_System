import java.awt.Color;
import java.awt.Font;
import com.toedter.*; //for calender
import com.toedter.calendar.JDateChooser; //for JDateChooser
import javax.swing.*;
import java.util.*; //for random class
import java.awt.event.*;
public class AddEmployee extends JFrame implements ActionListener{
	
	JLabel heading,name,fathersname,dob,salary,address,phone,email,highesteducation,designation,adharno,empid,empidtext;
	JTextField nametext,fathersnametext,salarytext,addresstext,phonetext,emailtext,designationtext,adharnotext;
	JDateChooser datechooser;
	JComboBox highesteducationchoice;
	JButton add,back;
	
	Random ran=new Random();
	int number=ran.nextInt(999999); //999999 taken to generate 6 digit eempid

	AddEmployee()
	{
		setSize(900,700);
		setLocation(300,50);
		setLayout(null);
		
		getContentPane().setBackground(Color.white);
		
		heading=new JLabel("Add Employee Detail");
		heading.setBounds(320,30,500,50);
		heading.setFont(new Font("SAN_SERIF",Font.BOLD,25));
		add(heading);
		
		name=new JLabel("Name");
		name.setBounds(50,150,150,30);
		name.setFont(new Font("Serif",Font.PLAIN,20));
		add(name);
		
		nametext=new JTextField();
		nametext.setBounds(200,150,150,30);
		add(nametext);
		
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
		
		datechooser=new JDateChooser();
		datechooser.setBounds(200,200,150,30);
		add(datechooser);
		
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
		
		String valhighesteducationchoice[]= {"BA","MA","BCS","MCS","BCA","MCA","BTech","MTech","BCom","MCom"};
		highesteducationchoice=new JComboBox(valhighesteducationchoice);
		highesteducationchoice.setBounds(600,300,150,30);
		highesteducationchoice.setBackground(Color.white);
		add(highesteducationchoice);
		
		designation=new JLabel("Designation");
		designation.setBounds(50,350,150,30);
		designation.setFont(new Font("Serif",Font.PLAIN,20));
		add(designation);
		
		designationtext=new JTextField();
		designationtext.setBounds(200,350,150,30);
		add(designationtext);
		
		adharno=new JLabel("Adhar No");
		adharno.setBounds(400,350,150,30);
		adharno.setFont(new Font("Serif",Font.PLAIN,20));
		add(adharno);
		
		adharnotext=new JTextField();
		adharnotext.setBounds(600,350,150,30);
		add(adharnotext);
		
		empid=new JLabel("Employee ID");
		empid.setBounds(50,400,150,30);
		empid.setFont(new Font("Serif",Font.PLAIN,20));
		add(empid);
		
		empidtext=new JLabel(""+number);
		empidtext.setBounds(200,400,150,30);
		empidtext.setFont(new Font("Serif",Font.PLAIN,20));
		add(empidtext);
		
		add=new JButton("Add");
		add.setBounds(250,550,150,40);
		add.setBackground(Color.black);
		add.setForeground(Color.white);
		add(add);
		add.addActionListener(this);
		
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
		if(ae.getSource()==add)
		{
			String sname=nametext.getText();
			String sfathersname=fathersnametext.getText();
			String sdob=((JTextField)datechooser.getDateEditor().getUiComponent()).getText();
			String ssalary=salarytext.getText();
			String saddress=addresstext.getText();
			String sphone=phonetext.getText();
			String semail=emailtext.getText();
			String shighesteducation=(String)highesteducationchoice.getSelectedItem();
			String sdesignation=designationtext.getText();
			String sadharno=adharno.getText();
			String seid=empidtext.getText();
			
			try
			{
				Conn c=new Conn();
				String query="insert into employee values('"+sname+"','"+sfathersname+"','"+sdob+"','"+ssalary+"','"+saddress+"','"+sphone+"','"+semail+"','"+shighesteducation+"','"+sdesignation+"','"+sadharno+"','"+seid+"')";
				c.s.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null, "Employee Details Added Successfully");
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
		new AddEmployee();

	}

}
