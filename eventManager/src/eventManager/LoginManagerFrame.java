package eventManager;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class LoginManagerFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginManagerFrame frame = new LoginManagerFrame();
					frame.pack();
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
	public LoginManagerFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 450, 300);
		setTitle("MANAGER LOGIN");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
	
        
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		panel_1.setBackground(Color.PINK);
		panel.add(panel_1, BorderLayout.NORTH);

		JLabel lblLogin = new JLabel("MANAGER LOGIN");
		lblLogin.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		panel_1.add(lblLogin);
		
		JPanel img = new JPanel();
		FlowLayout flowLayout1 = (FlowLayout) img.getLayout();
		flowLayout1.setVgap(15);
        img.add(new JLabel(new ImageIcon("C:\\Users\\tanviaditya\\Desktop\\eventManager\\src\\eventManager\\manager.jpg")));
        panel_1.add(img);
        
        
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.CENTER);

		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5, BorderLayout.NORTH);
		panel_5.setBackground(Color.gray);
		JLabel lblId = new JLabel("MANAGER ID  :");
		lblId.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		lblId.setForeground(Color.WHITE);

		panel_5.add(lblId);
		
		textField = new JTextField();
		panel_5.add(textField);
		textField.setColumns(20);
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_2.add(panel_6, BorderLayout.CENTER);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.darkGray);

		panel_6.add(panel_7, BorderLayout.NORTH);
		JLabel lblPassword = new JLabel("PASSWORD :");
		lblPassword.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		lblPassword.setForeground(Color.WHITE);

		panel_7.add(lblPassword);
		
		textField_1 = new JTextField();
		panel_7.add(textField_1);
		textField_1.setColumns(20);
		
		JPanel panel_8 = new JPanel();
		panel_6.add(panel_8, BorderLayout.CENTER);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setPreferredSize(new Dimension(120, 50));

		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					authenticateUser();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel_8.add(btnLogin);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setPreferredSize(new Dimension(120, 50));

		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				LoginFrame lf = new LoginFrame();
				lf.setVisible(true);
			}
		});
		panel_8.add(btnBack);
	}
	
	void authenticateUser() throws IOException {
		MyModel m = new MyModel("Oculus");
		if(m.ManagerLogin(textField.getText(), textField_1.getText())) {
			JOptionPane.showMessageDialog(null, "Login Successfull", "Login", 1);
			setVisible(false);
			ManagerFrame f = new ManagerFrame();
			f.pack();
			f.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(null, "Login Failed", "Login", 1);
		}
	}

}
