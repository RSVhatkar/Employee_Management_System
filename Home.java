import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;
public class Home extends JFrame implements ActionListener{

	JLabel background,heading;
	JButton add,view,update,remove;
	
	Home()
	{
		setLayout(null);
		setSize(1120,630);
		setLocation(250,100);
		
		ImageIcon img=new ImageIcon("icon/home.jpg");
		Image i=img.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
		ImageIcon imgnew=new ImageIcon(i);
		
		background=new JLabel("",imgnew,JLabel.CENTER);
		background.setBounds(0,0,1120,630);
		add(background);
		
		heading=new JLabel("Employee Management System");
		heading.setBounds(620,20,400,40);
		heading.setFont(new Font("Raleway",Font.BOLD,25));
		background.add(heading);
		
		add=new JButton("Add Employee");
		add.setBounds(650,80,150,40);
		background.add(add);
		add.addActionListener(this);
		
		view=new JButton("View Employees");
		view.setBounds(820,80,150,40);
		background.add(view);
		view.addActionListener(this);
		
		update=new JButton("Update Employee");
		update.setBounds(650,140,150,40);
		add(update);
		update.addActionListener(this);
		
		remove=new JButton("Remove Employee");
		remove.setBounds(820,140,150,40);
		add(remove);
		remove.addActionListener(this);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==add)
		{
			setVisible(false);
			new AddEmployee();
		}
		else if(ae.getSource()==view)
		{
			setVisible(false);
			new ViewEmployee();
		}
		else if(ae.getSource()==update)
		{
			setVisible(false);
			new ViewEmployee();
		}
		else
		{
			setVisible(false);
			new RemoveEmployee();
		}
	}
	
	public static void main(String[] args) {
		new Home();

	}

}
