package testform;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.Color;
import java.awt.Font;
public class TestForm extends TestFormB {

	private JPanel contentPane;
	private JTextField user1;
	private JTextField pass1;

	/**
	 * Launch the application
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestFormB frame = new TestForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TestForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 422, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		user1 = new JTextField();
		user1.setBackground(Color.GRAY);
		user1.setBounds(142, 124, 231, 34);
		contentPane.add(user1);
		user1.setColumns(10);
		
		pass1 = new JTextField();
		pass1.setBackground(Color.GRAY);
		pass1.setColumns(10);
		pass1.setBounds(142, 226, 231, 34);
		contentPane.add(pass1);
		
		JLabel pass = new JLabel("Password:");
		pass.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pass.setForeground(Color.WHITE);
		pass.setHorizontalAlignment(SwingConstants.CENTER);
		pass.setBounds(10, 199, 122, 84);
		contentPane.add(pass);
		
		JLabel user = new JLabel("Username:");
		user.setFont(new Font("Tahoma", Font.PLAIN, 19));
		user.setHorizontalAlignment(SwingConstants.CENTER);
		user.setForeground(Color.WHITE);
		user.setBounds(10, 107, 122, 65);
		contentPane.add(user);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(0, 0, 417, 77);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblLoginForm = new JLabel("Login Form");
		lblLoginForm.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginForm.setForeground(Color.WHITE);
		lblLoginForm.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLoginForm.setBounds(10, 10, 122, 65);
		panel.add(lblLoginForm);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(0, 75, 417, 243);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
					PreparedStatement ps = conn.prepareStatement("insert into user(user_name,user_password) values(?,?)");
					
					ps.setString(1,user1.getText());
					ps.setString(2,pass1.getText());	
					int x = ps.executeUpdate();
					if(x>0) {
						System.out.println("Registration done sucessfully...");
					} else
					{
						System.out.println("Registration Failed...");	
					}
				}catch(Exception e1) {
					System.out.println(e1);
				}
			}
		});
		btnNewButton.setBounds(200, 212, 85, 21);
		panel_1.add(btnNewButton);
	}
}