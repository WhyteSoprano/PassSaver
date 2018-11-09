import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JSeparator;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.Font;

// Need to switch from index search to serach by site name.

public class Main {

	private int toggle = 0;
	
	private String index;
	private String site;
	private String user;
	private String passEnc;
	private String [] str;
	private boolean newSite;
	
	JLabel lblSiteDisplay;
	JLabel lblUserDisplay;
	JLabel lblPassDisplay;
	JComboBox comboBox;
	
	private JFrame frame;
	
	private Storage storage = new Storage ();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		newSite = false;
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBackground(new Color(0, 0, 51));
		frame.setBounds(100, 100, 450, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(20, 20));
		
		JPanel panelNorth = new JPanel();
		panelNorth.setBackground(Color.CYAN);
		frame.getContentPane().add(panelNorth, BorderLayout.NORTH);
		panelNorth.setLayout(new GridLayout(1, 3, 0, 0));
		
		JPanel panel_17 = new JPanel();
		panel_17.setBackground(new Color(0, 0, 0));
		panelNorth.add(panel_17);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Verdana", Font.PLAIN, 12));
		
		comboBox.setForeground(new Color(0, 0, 0));
		comboBox.setBackground(new Color(204, 255, 255));
		comboBox.setFocusable(false);
		panelNorth.add(comboBox);
		
		JPanel panel_18 = new JPanel();
		panel_18.setBackground(new Color(0, 0, 0));
		panelNorth.add(panel_18);
		
		JPanel panelSouth = new JPanel();
		panelSouth.setBackground(new Color(0, 0, 0));
		frame.getContentPane().add(panelSouth, BorderLayout.SOUTH);
		
		JButton btnNew = new JButton("<html>New Site");
		
		btnNew.setFont(new Font("Verdana", Font.BOLD, 12));
		btnNew.setFocusable(false);
		btnNew.setForeground(new Color(0, 0, 0));
		btnNew.setBackground(new Color(204, 255, 255));
		panelSouth.add(btnNew);
		
		JButton btnSave = new JButton("Save Site");

		btnSave.setFont(new Font("Verdana", Font.BOLD, 12));
		btnSave.setFocusable(false);
		btnSave.setForeground(new Color(0, 0, 0));
		btnSave.setBackground(new Color(204, 255, 255));
		panelSouth.add(btnSave);
		
		JToggleButton tglbtnShowHide = new JToggleButton("Hidding Passwords");
		tglbtnShowHide.setFont(new Font("Verdana", Font.BOLD, 12));
		tglbtnShowHide.setFocusable(false);
		tglbtnShowHide.setForeground(new Color(0, 0, 0));
		tglbtnShowHide.setBackground(new Color(204, 255, 255));
		
		panelSouth.add(tglbtnShowHide);
		
		JPanel panelCenter = new JPanel();
		panelCenter.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(new GridLayout(10, 2, 0, 0));
		
		JLabel lblSite = new JLabel("Site:");
		lblSite.setFont(new Font("Verdana", Font.BOLD, 18));
		lblSite.setForeground(new Color(0, 0, 0));
		lblSite.setVerticalAlignment(SwingConstants.BOTTOM);
		panelCenter.add(lblSite);
		
		JPanel panelFiller0 = new JPanel();
		panelFiller0.setBackground(new Color(255, 255, 255));
		panelCenter.add(panelFiller0);
		
		lblSiteDisplay = new JLabel("");
		lblSiteDisplay.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblSiteDisplay.setForeground(new Color(0, 0, 0));
		lblSiteDisplay.setHorizontalAlignment(SwingConstants.CENTER);
		panelCenter.add(lblSiteDisplay);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panelCenter.add(panel_2);
		
		JButton btnSite = new JButton("      Change Site      ");
		
		btnSite.setFont(new Font("Verdana", Font.BOLD, 12));
		btnSite.setFocusable(false);
		btnSite.setForeground(new Color(0, 0, 0));
		btnSite.setBackground(new Color(204, 255, 255));
		panel_2.add(btnSite);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panelCenter.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		panel_3.add(panel_4);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(255, 255, 204));
		separator.setBackground(new Color(0, 0, 0));
		panel_3.add(separator);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 255));
		panelCenter.add(panel_5);
		panel_5.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(255, 255, 255));
		panel_5.add(panel_6);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(255, 255, 204));
		separator_1.setBackground(new Color(0, 0, 0));
		panel_5.add(separator_1);
		
		JLabel lblUser = new JLabel("Username:");
		lblUser.setFont(new Font("Verdana", Font.BOLD, 18));
		lblUser.setForeground(new Color(0, 0, 0));
		lblUser.setVerticalAlignment(SwingConstants.BOTTOM);
		panelCenter.add(lblUser);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panelCenter.add(panel);
		
		JButton btnUser = new JButton("Change Username  ");
		btnUser.setFont(new Font("Verdana", Font.BOLD, 12));
		btnUser.setFocusable(false);
		btnUser.setForeground(new Color(0, 0, 0));
		btnUser.setBackground(new Color(204, 255, 255));
		panel.add(btnUser);
		
		lblUserDisplay = new JLabel("");
		lblUserDisplay.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblUserDisplay.setForeground(new Color(0, 0, 0));
		lblUserDisplay.setHorizontalAlignment(SwingConstants.CENTER);
		panelCenter.add(lblUserDisplay);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panelCenter.add(panel_1);
		
		JButton btnCoppyUser = new JButton("Coppy to clippboard");
		btnCoppyUser.setFont(new Font("Verdana", Font.BOLD, 12));
		btnCoppyUser.setFocusable(false);
		btnCoppyUser.setForeground(new Color(0, 0, 0));
		btnCoppyUser.setBackground(new Color(204, 255, 255));
		panel_1.add(btnCoppyUser);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(255, 255, 255));
		panelCenter.add(panel_7);
		panel_7.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(255, 255, 255));
		panel_7.add(panel_8);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(new Color(255, 255, 204));
		separator_2.setBackground(new Color(0, 0, 0));
		panel_7.add(separator_2);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(255, 255, 255));
		panelCenter.add(panel_9);
		panel_9.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(255, 255, 255));
		panel_9.add(panel_10);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(new Color(255, 255, 204));
		separator_3.setBackground(new Color(0, 0, 0));
		panel_9.add(separator_3);
		
		JLabel lblPass = new JLabel("Password:");
		lblPass.setFont(new Font("Verdana", Font.BOLD, 18));
		lblPass.setForeground(new Color(0, 0, 0));
		lblPass.setVerticalAlignment(SwingConstants.BOTTOM);
		panelCenter.add(lblPass);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(new Color(255, 255, 255));
		panelCenter.add(panel_11);
		
		JButton btnPass = new JButton(" Change Password  ");
		btnPass.setFont(new Font("Verdana", Font.BOLD, 12));
		btnPass.setFocusable(false);
		btnPass.setForeground(new Color(0, 0, 0));
		btnPass.setBackground(new Color(204, 255, 255));
		panel_11.add(btnPass);
		
		lblPassDisplay = new JLabel("");
		lblPassDisplay.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblPassDisplay.setForeground(new Color(0, 0, 0));
		lblPassDisplay.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassDisplay.setVisible(false);
		panelCenter.add(lblPassDisplay);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBackground(new Color(255, 255, 255));
		panelCenter.add(panel_12);
		
		JButton btnCopyPass = new JButton("Coppy to clippboard");
		btnCopyPass.setFont(new Font("Verdana", Font.BOLD, 12));
		btnCopyPass.setFocusable(false);
		btnCopyPass.setForeground(new Color(0, 0, 0));
		btnCopyPass.setBackground(new Color(204, 255, 255));
		panel_12.add(btnCopyPass);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(new Color(255, 255, 255));
		panelCenter.add(panel_13);
		panel_13.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_16 = new JPanel();
		panel_16.setBackground(new Color(255, 255, 255));
		panel_13.add(panel_16);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setForeground(new Color(255, 255, 204));
		separator_4.setBackground(new Color(0, 0, 0));
		panel_13.add(separator_4);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBackground(new Color(255, 255, 255));
		panelCenter.add(panel_14);
		panel_14.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_15 = new JPanel();
		panel_15.setBackground(new Color(255, 255, 255));
		panel_14.add(panel_15);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setForeground(new Color(255, 255, 204));
		separator_5.setBackground(new Color(0, 0, 0));
		panel_14.add(separator_5);
		
		JLabel lblInfo = new JLabel("<html>* Save the changes before switching to another site or they will be lost.<html>");
		lblInfo.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblInfo.setForeground(new Color(0, 0, 0));
		panelCenter.add(lblInfo);
		
		JLabel lblAd = new JLabel("Powered by WhyteSoprano");
		lblAd.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblAd.setForeground(new Color(0, 0, 0));
		lblAd.setHorizontalAlignment(SwingConstants.RIGHT);
		panelCenter.add(lblAd);
		
		JPanel panelWest = new JPanel();
		panelWest.setBackground(new Color(0, 0, 0));
		frame.getContentPane().add(panelWest, BorderLayout.WEST);
		
		JPanel panelEast = new JPanel();
		panelEast.setBackground(new Color(0, 0, 0));
		frame.getContentPane().add(panelEast, BorderLayout.EAST);
		panelEast.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		updateComboBox();
		
		tglbtnShowHide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (toggle == 0) {
					
					toggle = 1;
					lblPassDisplay.setVisible(true);
					tglbtnShowHide.setText("Showing Passwords");
				}
				else {
					
					toggle = 0;
					lblPassDisplay.setVisible(false);
					tglbtnShowHide.setText("Hidding Passwords");
				}
			}
		});
		btnSite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				site = JOptionPane.showInputDialog("Enter the site's name");
				lblSiteDisplay.setText(site);
			}
		});
		btnUser.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent arg0) {
				
				user = JOptionPane.showInputDialog("Enter a username or a mail adress");
				lblUserDisplay.setText(user);
			}
		});
		btnPass.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent arg0) {
				
				String passAux = Encryption.encrypt_2(JOptionPane.showInputDialog("Enter the password"));
				
				if (Encryption.check(passAux)) {
					
					System.out.println("Password correct");
					passEnc = passAux;
				}
				else {
					
					JOptionPane.showMessageDialog(null, "Invalid password", "Exception", 0);
					passEnc = "";
				}
				
				passEnc = passAux;
				
				lblPassDisplay.setText(Encryption.decrypt_2(passEnc));
			}
		});
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (comboBox.getItemCount() != 0) {
					
					index = comboBox.getSelectedItem().toString();
				}
				else index = "";
				
				if (newSite) {
					
					newSite = false;
					storage.save(site, user, passEnc);
					comboBox.addItem(site);					
					comboBox.setSelectedItem(site);
				}
				else if (!index.equals(site)) {
					
					storage.editSite(index, site);
					System.out.println("edited");
					storage.save(site, user, passEnc);
					comboBox.addItem(site);
					comboBox.removeItem(comboBox.getSelectedItem());
					comboBox.setSelectedItem(site);
				}
				else storage.save(site, user, passEnc);
			}
		});
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				index = comboBox.getSelectedItem().toString();
				site = storage.getSite(index);
				user = storage.getUser(index);
				passEnc = storage.getPass(index);
				update();
				
				System.out.println("user: " + user);
			}
		});
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				newSite = true;
				site = "";
				user = "";
				passEnc = "";
				update();
			}
		});
	}
	
	private void update () {
		
		lblSiteDisplay.setText(site);
		lblUserDisplay.setText(user);
		
		System.out.println(passEnc);
		
		if (passEnc.length() != 0) {
			
			lblPassDisplay.setText(Encryption.decrypt_2(passEnc));
		}
		else {
			
			lblPassDisplay.setText("");
			System.out.println("Invalid password");
		}
	}
	private void updateComboBox () {
		
		if (!storage.isNew()) {
			
			str = storage.initialize();
			
			for (String s:str) {
				
				comboBox.addItem(s);
			}
			
			index = comboBox.getSelectedItem().toString();
			site = storage.getSite(index);
			user = storage.getUser(index);
			passEnc = storage.getPass(index);
			
			lblSiteDisplay.setText(site);
			lblUserDisplay.setText(user);
			lblPassDisplay.setText(Encryption.decrypt_2(passEnc));
		}
		else newSite = true;
	}

}
