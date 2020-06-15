package eventManager;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.Font;

public class AttendeeFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AttendeeFrame frame = new AttendeeFrame();
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
	@SuppressWarnings("null")
	public AttendeeFrame() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(700,700);
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
		
		JLabel lblAttendeePortal = new JLabel("ATTENDEE PORTAL");
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
		
		JLabel lblOutput = new JLabel("ALL EVENTS");
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
		
		JButton btnBookEvent = new JButton("BOOK EVENT");
		btnBookEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookEventFrame f;
				try {
					f = new BookEventFrame();
					f.setSize(500,300);
					f.setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				setVisible(false);
			}
		});
		panel_4.add(btnBookEvent);
		
		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_5.add(panel_6, BorderLayout.CENTER);
		panel_6.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_7 = new JPanel();
		panel_5.add(panel_7, BorderLayout.SOUTH);
		
		JButton btnExit = new JButton("LOGOUT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				LoginFrame lf = new LoginFrame();
				lf.setVisible(true);
			}
		});
		panel_7.add(btnExit);
	}
}
