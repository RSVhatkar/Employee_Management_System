import java.awt.Choice;
import java.awt.Color;
import java.sql.ResultSet;
import java.awt.event.*;
import javax.swing.*;
import net.proteanit.sql.*;
public class ViewEmployee extends JFrame implements ActionListener{
	
	JTable table;
	JLabel searchbyid;
	Choice searchbyidchoice;
	JButton search,print,update,back;

	ViewEmployee()
	{
		setSize(1500,700);
		setLocation(300,100);
		setLayout(null);
		
		getContentPane().setBackground(Color.white);
		
		table=new JTable();
		
		searchbyid=new JLabel("Search by Employee ID");
		searchbyid.setBounds(20,20,150,20);
		add(searchbyid);
		
		searchbyidchoice=new Choice();
		searchbyidchoice.setBounds(180,20,150,20);
		add(searchbyidchoice);
		
		//fetch all emp id from employee table
		try
		{
			Conn c=new Conn();
			String query="select * from employee";
			ResultSet rs=c.s.executeQuery(query);
			while(rs.next())
			{
				searchbyidchoice.add(rs.getString("empid"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		//to fetch emp data from employee table
		try
		{
			Conn c=new Conn();
			String query="select * from employee";
			ResultSet rs=c.s.executeQuery(query);
			table.setModel(DbUtils.resultSetToTableModel(rs)); //to disp data in table
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		JScrollPane sp=new JScrollPane(table); //to get scroll bar for table
		sp.setBounds(0,100,1500,600);
		add(sp);
		
		search=new JButton("Search");
		search.setBounds(20,70,80,20);
		add(search);
		search.addActionListener(this);
		
		print=new JButton("Print");
		print.setBounds(120,70,80,20);
		add(print);
		print.addActionListener(this);
		
		update=new JButton("Update");
		update.setBounds(220,70,80,20);
		add(update);
		update.addActionListener(this);
		
		back=new JButton("Back");
		back.setBounds(320,70,80,20);
		add(back);
		back.addActionListener(this);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==search)
		{
			//to fetch record of particular employee
			try
			{
				Conn c=new Conn();
				String query="select * from employee where empid = '"+searchbyidchoice.getSelectedItem()+"' ";
				ResultSet rs=c.s.executeQuery(query);
				table.setModel(DbUtils.resultSetToTableModel(rs));
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else if(ae.getSource()==print)
		{
			try
			{
				table.print(); //want to print table 
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else if(ae.getSource()==update)
		{
			setVisible(false);
			new UpdateEmployee(searchbyidchoice.getSelectedItem());
		}
		else
		{
			setVisible(false);
			new Home();
		}
	}
	
	public static void main(String[] args) {
		new ViewEmployee();

	}

}
