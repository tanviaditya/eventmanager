package eventManager;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.TextArea;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTable;

public class ManagerFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerFrame frame = new ManagerFrame();
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
	public ManagerFrame() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));

		setContentPane(contentPane);

		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setVgap(10);
		panel.add(panel_1, BorderLayout.NORTH);
		
		JLabel lblAttendeePortal = new JLabel("MANAGER PORTAL");
		lblAttendeePortal.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		panel_1.add(lblAttendeePortal);
		lblAttendeePortal.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_10 = new JPanel();
		panel_2.add(panel_10, BorderLayout.SOUTH);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_11 = new JPanel();
		panel_2.add(panel_11, BorderLayout.NORTH);
		
		JLabel lblOutput = new JLabel("OCULUS");
		panel_11.add(lblOutput);
		
		JPanel panel_12 = new JPanel();
		panel_2.add(panel_12, BorderLayout.SOUTH);
		panel_12.setLayout(new BorderLayout(0, 0));
		
		String arr[];
		FileReader filereader= new FileReader("eventsfile.txt");
		BufferedReader reader = new BufferedReader(filereader);
		String line = reader.readLine();
		String values[][] = new String[50][6];

		for(int i=0; line!=null; i++) {
			arr=line.split(" ");
			for(int j=0; j<6; j++) {
				values[i][j] = arr[j];
			}
		line = reader.readLine();
		}

		reader.close();
		filereader.close();
		
		table = new JTable( values , new String[]{"Event Name", "Event ID", "Cost", "Location ID", "Starts At", "Ends At"});
		JScrollPane sp = new JScrollPane(table);  
		panel_2.add(sp, BorderLayout.CENTER);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.EAST);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4, BorderLayout.NORTH);
		
		JButton btnBookEvent = new JButton("ADD EVENT");
		btnBookEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AddEventFrame f;
				try {
					f = new AddEventFrame();
					f.pack();
					//f.pack();
					f.setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel_4.add(btnBookEvent);
		
		JPanel panel_7 = new JPanel();
		panel_3.add(panel_7, BorderLayout.CENTER);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_8 = new JPanel();
		panel_7.add(panel_8, BorderLayout.NORTH);
		panel_8.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnCreateManager = new JButton("CREATE ATTENDEE");
		panel_8.add(btnCreateManager);
		
		JPanel panel_5 = new JPanel();
		panel_7.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_5.add(panel_6, BorderLayout.NORTH);
		
		JButton btnCreateManager_1 = new JButton("CREATE MANAGER");
		btnCreateManager_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				CreateManagerFrame f;
				try {
					f = new CreateManagerFrame();
					f.setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel_6.add(btnCreateManager_1);
		
		JPanel panel_9 = new JPanel();
		panel_5.add(panel_9, BorderLayout.SOUTH);
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				LoginFrame lf = new LoginFrame();
				lf.setVisible(true);
			}
		});
		panel_9.add(btnLogout);
		btnCreateManager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				CreateAttendeeFrame f;
				try {
					f = new CreateAttendeeFrame();
					f.setVisible(true);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	
	
	
}
