import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;
public class Splash extends JFrame implements ActionListener{

	JLabel heading,background;
	JButton clickhere;
	
	Splash()
	{
		setSize(1170,650);
		setLocation(200,50);
		setLayout(null);
		
		getContentPane().setBackground(Color.white);
		
		heading=new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
		heading.setBounds(80,30,1200,60);
		heading.setFont(new Font("Serif",Font.PLAIN,60));
		heading.setForeground(Color.red);
		add(heading);
		
		ImageIcon img=new ImageIcon("icon/front.jpg");
		Image i=img.getImage().getScaledInstance(1100,700,Image.SCALE_DEFAULT);
		ImageIcon imgnew=new ImageIcon(i);
		
		background=new JLabel("",imgnew,JLabel.CENTER);
		background.setBounds(50,100,1050,500);
		add(background);
		
		clickhere=new JButton("CLICK HERE TO CONTINUE");
		clickhere.setBounds(400,400,300,70);
		clickhere.setBackground(Color.black);
		clickhere.setForeground(Color.white);
		background.add(clickhere);
		clickhere.addActionListener(this);
		
		setVisible(true);
		
		//to make heading blink
		while(true)
		{
			heading.setVisible(false);
			try
			{
				Thread.sleep(500);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			heading.setVisible(true);
			try
			{
				Thread.sleep(500);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		setVisible(false);
		new Login();
	}
	
	public static void main(String[] args) {
		new Splash();

	}

}
