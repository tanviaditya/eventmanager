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
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(600,420);
		setTitle("WELCOME");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setVgap(15);
        panel_1.setBackground(Color.PINK);
		panel.add(panel_1, BorderLayout.NORTH);
		//==========
		JPanel img = new JPanel();
		FlowLayout flowLayout1 = (FlowLayout) img.getLayout();
		flowLayout1.setVgap(15);
        img.add(new JLabel(new ImageIcon("C:\\Users\\tanviaditya\\Desktop\\eventManager\\src\\eventManager\\login1.jpg")));
        panel_1.add(img);
		//============
        
		JPanel panel_3 = new JPanel();
		panel_3.setSize(50, 50);
		panel.add(panel_3);
		
		JLabel lblLogin = new JLabel("\nLOGIN\n");
		lblLogin.setFont(new Font("Lucida Grande",Font.BOLD, 30));
		panel_3.add(lblLogin);
		

		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
		flowLayout_1.setVgap(20);
		panel_2.setBackground(Color.magenta);
		panel.add(panel_2, BorderLayout.AFTER_LAST_LINE);
			
		
		
		JButton btnAttendee = new JButton("ATTENDEE");
		btnAttendee.setPreferredSize(new Dimension(150, 50));
		btnAttendee.setFont(new Font("Arial", Font.BOLD, 20));


		btnAttendee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginAttendeeFrame af;
				af = new LoginAttendeeFrame();
				setVisible(false);
				af.pack();
				af.setVisible(true);
			}
		});
		panel_2.add(btnAttendee);
		
		JButton btnNewButton = new JButton("MANAGER");
		btnNewButton.setPreferredSize(new Dimension(150, 50));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 20));

		panel_2.add(btnNewButton);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginManagerFrame mf = new LoginManagerFrame();
				setVisible(false);
				mf.pack();
				mf.setVisible(true);
			}
		});
	}

}
