package eventManager;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
public class BookEventFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tf_name;
	private JTextField tf_uid;
	private JTextField tf_bra;
	JComboBox comboBox;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookEventFrame frame = new BookEventFrame();
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
	 * @throws IOException 
	 */
	public BookEventFrame() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		
		panel_1.setBackground(Color.PINK);

		panel.add(panel_1, BorderLayout.NORTH);
		
		JLabel lblLogin = new JLabel("BOOK EVENT");
		lblLogin.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		panel_1.add(lblLogin);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5, BorderLayout.NORTH);
		
		JLabel lblId = new JLabel("ATTENDEE NAME  :");
		lblId.setFont(new Font("Lucida Grande", Font.PLAIN, 20));

		panel_5.add(lblId);
		
		tf_name = new JTextField();
		panel_5.add(tf_name);
		tf_name.setColumns(15);
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_2.add(panel_6, BorderLayout.CENTER);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_6.add(panel_7, BorderLayout.NORTH);
		
		JLabel lblPassword = new JLabel("ATTENDEE UID :");
		lblPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 20));

		
		panel_7.add(lblPassword);
		
		tf_uid = new JTextField();
		panel_7.add(tf_uid);
		tf_uid.setColumns(15);
		
		JPanel panel_8 = new JPanel();
		panel_6.add(panel_8, BorderLayout.CENTER);
		panel_8.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_9 = new JPanel();
		panel_8.add(panel_9, BorderLayout.SOUTH);
		
		JButton btn_login = new JButton("BOOK");
		btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookEvent();
			}
		});
		panel_9.add(btn_login);
		
		JButton btnBack = new JButton("BACK");
		panel_9.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AttendeeFrame lf;
				try {
					lf = new AttendeeFrame();
					lf.setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		JPanel panel_10 = new JPanel();
		panel_8.add(panel_10, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("ATTENDEE BRANCH  :");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));

		panel_10.add(lblNewLabel);
		
		tf_bra = new JTextField();
		panel_10.add(tf_bra);
		tf_bra.setColumns(10);
		
		JPanel panel_11 = new JPanel();
		panel_8.add(panel_11, BorderLayout.CENTER);
		
		JLabel lblEventName = new JLabel("EVENT NAME  : ");
		lblEventName.setFont(new Font("Lucida Grande", Font.PLAIN, 20));

		panel_11.add(lblEventName);
		
		comboBox = new JComboBox();
		FileReader filereader= new FileReader("eventsfile.txt");
		BufferedReader reader = new BufferedReader(filereader);
		String line = reader.readLine();
		ArrayList<String> list = new ArrayList<String>();
		String arr[];
		
		while(line != null) {
			arr = line.split(" ");
			list.add(arr[0]);
			line = reader.readLine();
		}
		reader.close();
		filereader.close();
		
		comboBox.setModel(new DefaultComboBoxModel(list.toArray()));
//		comboBox.setToolTipText("");
		comboBox.setName("");
		panel_11.add(comboBox);
	}
	
	void bookEvent() {
		MyModel m = new MyModel("Oculus");
		m.bookEvent(tf_name.getText(), tf_uid.getText(), tf_bra.getText(), comboBox.getSelectedItem().toString());
		tf_name.setText("");
		tf_uid.setText("");
		tf_bra.setText("");
	}

}
