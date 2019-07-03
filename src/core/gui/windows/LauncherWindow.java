/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.gui.windows;

import core.communication.DatabaseConnection;
import core.communication.DatabaseHandler;
import core.data.User;
import core.gui.elements.*;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import javax.swing.*;

/**
 *
 * @author ADMIN
 */
public class LauncherWindow extends JFrame{
    DatabaseConnection dbConnection;

    private ColorSchemes colorScheme;
    
    private CardLayout cardLayout;
    
    private JPanel jTitlePanel;
    private JPanel jLoginPanel;
    private JPanel jRegisterPanel;
    
    public LauncherWindow(DatabaseConnection dbConnection) {
	super("Forum");
	this.dbConnection = dbConnection;
	
	colorScheme = new ColorSchemes(ColorSchemes.Themes.THEME1);
	
	initLoginPanel();
	initRegisterPanel();
	
	cardLayout = new CardLayout();
	
	pack();
	
	setLayout(cardLayout);
	//setUndecorated(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(440, 600);
	setLocationRelativeTo(null);
    }
 
    private void initLoginPanel() {
	jLoginPanel = new JPanel();
	
	GroupLayout groupLayout = new GroupLayout(jLoginPanel);
	groupLayout.setAutoCreateGaps(true);
	groupLayout.setAutoCreateContainerGaps(true);
	
	JLabel paneTitleLabel = new JLabel("Sign In");
	GRoundedTextField usernameField = new GRoundedTextField();
	GRoundedPasswordField passwordField = new GRoundedPasswordField();
	JLabel usernameLabel = new JLabel("Username");
	JLabel passwordLabel = new JLabel("Password");
	JLabel notRegLabel = new JLabel("Not registered yet? Sign up now!");
	
	GButton loginButton = new GButton("Login", colorScheme, ColorSchemes.Highlight.HL2){
	    @Override
	    public void mouseClicked(MouseEvent e) {
		new Thread(new Runnable() {
		    @Override
		    public void run() {
			    DatabaseHandler.searchRecord(dbConnection.getConnection(), usernameField.getText(), String.valueOf(passwordField.getPassword()));
		    }
		}).start();
	    }
	};
	loginButton.setFont(new Font(loginButton.getFont().getName(), Font.BOLD, 18));
	
	GButton signUpButton = new GButton("Sign Up", colorScheme, ColorSchemes.Highlight.HL1){
	    @Override
	    public void mouseClicked(MouseEvent e) {
		cardLayout.next(getContentPane());
		jRegisterPanel.setVisible(true);
	    }
	};
	signUpButton.setFont(new Font(signUpButton.getFont().getName(), Font.BOLD, 18));
	
	paneTitleLabel.setForeground(colorScheme.secondaryColor);
	paneTitleLabel.setFont(new Font(paneTitleLabel.getFont().getName(), Font.BOLD, 24));
	paneTitleLabel.setAlignmentX(JLabel.CENTER);
	
	usernameField.setBackground(colorScheme.primaryColor);
	usernameField.setForeground(colorScheme.secondaryVariantColor);
	usernameField.setBorderColor(colorScheme.primaryVariantColor);
	
	passwordField.setBackground(colorScheme.primaryColor);
	passwordField.setForeground(colorScheme.secondaryVariantColor);
	passwordField.setBorderColor(colorScheme.primaryVariantColor);
	
	usernameLabel.setForeground(colorScheme.secondaryColor);
	usernameLabel.setFont(new Font(usernameLabel.getFont().getName(), Font.BOLD, 15));
	
	passwordLabel.setForeground(colorScheme.secondaryColor);
	passwordLabel.setFont(new Font(passwordLabel.getFont().getName(), Font.BOLD, 15));
	
	notRegLabel.setForeground(colorScheme.secondaryColor);
	notRegLabel.setFont(new Font(notRegLabel.getFont().getName(), Font.ITALIC, 13));
	
	groupLayout.setHorizontalGroup(
		groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addComponent(paneTitleLabel, GroupLayout.Alignment.CENTER)
			.addGroup(groupLayout.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
					.addComponent(usernameLabel)
					.addComponent(passwordLabel))
				.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
					.addComponent(usernameField)
					.addComponent(passwordField)))
			.addComponent(loginButton)
			.addComponent(notRegLabel, GroupLayout.Alignment.CENTER)
			.addComponent(signUpButton)
		);
	
	groupLayout.setVerticalGroup(
		groupLayout.createSequentialGroup()
			.addGap(0, 60, 70)
			.addComponent(paneTitleLabel)
			.addGap(0, 60, 70)
			.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				.addComponent(usernameLabel)
				.addComponent(usernameField, 40, 40, 40))
			.addGap(10)
			.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				.addComponent(passwordLabel)
				.addComponent(passwordField))
			.addGap(15)
			.addComponent(loginButton)
			.addGap(0, 80, 90)
			.addComponent(notRegLabel)
			.addGap(15)
			.addComponent(signUpButton, 40, 40, 40)
			.addGap(10, 10, 40)
	);
	
	groupLayout.linkSize(SwingConstants.VERTICAL, usernameField, passwordField);
	groupLayout.linkSize(SwingConstants.VERTICAL, loginButton, signUpButton);
	jLoginPanel.setLayout(groupLayout);
	
	jLoginPanel.setBackground(colorScheme.primaryVariantColor);
	
	getContentPane().add(jLoginPanel);
    }
    
    private void initRegisterPanel() {
	jRegisterPanel = new JPanel();
	
	GroupLayout groupLayout = new GroupLayout(jRegisterPanel);
	groupLayout.setAutoCreateGaps(true);
	groupLayout.setAutoCreateContainerGaps(true);
	
	GButton backButton = new GButton("Prev", colorScheme, ColorSchemes.Highlight.HL1){
	    @Override
	    public void mouseClicked(MouseEvent e) {
		cardLayout.previous(getContentPane());
	    }	    
	};
	
	JLabel paneTitleLabel = new JLabel("Register");
	GRoundedTextField usernameField = new GRoundedTextField();
	GRoundedPasswordField passwordField = new GRoundedPasswordField();
	GRoundedTextField emailField = new GRoundedTextField();
	JComboBox classComboBox = new JComboBox(new String[]{"FE", "SE", "TE", "BE"});
	JLabel usernameLabel = new JLabel("Username");
	JLabel passwordLabel = new JLabel("Password");
	JLabel emailLabel = new JLabel("E-mail");
	JLabel classLabel = new JLabel("Class");
	
	GButton signUpButton = new GButton("Submit", colorScheme, ColorSchemes.Highlight.HL1){
	    @Override
	    public void mouseClicked(MouseEvent e) {
		new Thread(new Runnable() {
		    @Override
		    public void run() {
			DatabaseHandler.insertRecord(dbConnection.getConnection(), new User(usernameField.getText(), emailField.getText()), String.valueOf(passwordField.getPassword()));
		    }
		}).start();
	    }
	};
	signUpButton.setFont(new Font(signUpButton.getFont().getName(), Font.BOLD, 18));
	
	paneTitleLabel.setForeground(colorScheme.secondaryColor);
	paneTitleLabel.setFont(new Font(paneTitleLabel.getFont().getName(), Font.BOLD, 24));
	paneTitleLabel.setAlignmentX(JLabel.CENTER);
	
	usernameField.setBackground(colorScheme.primaryColor);
	usernameField.setForeground(colorScheme.secondaryVariantColor);
	usernameField.setBorderColor(colorScheme.primaryVariantColor);
	usernameField.setFont(new Font(usernameField.getFont().getName(), Font.BOLD, 12));
	
	passwordField.setBackground(colorScheme.primaryColor);
	passwordField.setForeground(colorScheme.secondaryVariantColor);
	passwordField.setBorderColor(colorScheme.primaryVariantColor);
	passwordField.setFont(new Font(passwordField.getFont().getName(), Font.BOLD, 12));
	
	emailField.setBackground(colorScheme.primaryColor);
	emailField.setForeground(colorScheme.secondaryVariantColor);
	emailField.setBorderColor(colorScheme.primaryVariantColor);
	emailField.setFont(new Font(emailField.getFont().getName(), Font.BOLD, 12));
	
	classComboBox.setBackground(colorScheme.primaryColor);
	classComboBox.setForeground(colorScheme.secondaryVariantColor);
	
	usernameLabel.setForeground(colorScheme.secondaryColor);
	usernameLabel.setFont(new Font(usernameLabel.getFont().getName(), Font.BOLD, 13));
	
	passwordLabel.setForeground(colorScheme.secondaryColor);
	passwordLabel.setFont(new Font(usernameLabel.getFont().getName(), Font.BOLD, 13));
	
	emailLabel.setForeground(colorScheme.secondaryColor);
	emailLabel.setFont(new Font(usernameLabel.getFont().getName(), Font.BOLD, 13));
	
	classLabel.setFont(new Font(usernameLabel.getFont().getName(), Font.BOLD, 13));
	
	groupLayout.setHorizontalGroup(
		groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addGroup(groupLayout.createSequentialGroup()
				.addComponent(backButton, 32, 32, 32)
				.addGap(0, 150, 170))
			.addComponent(paneTitleLabel, GroupLayout.Alignment.CENTER)
			.addGroup(groupLayout.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
					.addComponent(usernameLabel)
					.addComponent(passwordLabel)
					.addComponent(emailLabel)
					.addComponent(classLabel))
				.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
					.addComponent(usernameField)
					.addComponent(passwordField)
					.addComponent(emailField)
					.addComponent(classComboBox)))
			.addComponent(signUpButton)
	);
	
	groupLayout.setVerticalGroup(
		groupLayout.createSequentialGroup()
			.addComponent(backButton, 23, 23, 23)
			.addGap(10, 30, 50)
			.addComponent(paneTitleLabel)
			.addGap(10, 30, 50)
			.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				.addComponent(usernameLabel)
				.addComponent(usernameField, 30, 30, 30))
			.addGap(10)
			.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				.addComponent(passwordLabel)
				.addComponent(passwordField))
			.addGap(10)
			.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				.addComponent(emailLabel)
				.addComponent(emailField))
			.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				.addComponent(classLabel)
				.addComponent(classComboBox))
			.addGap(15)
			.addComponent(signUpButton, 40, 40, 40)
			.addGap(10, 120, 170)
	);
	
	groupLayout.linkSize(SwingConstants.VERTICAL, usernameField, passwordField, emailField);
	jRegisterPanel.setLayout(groupLayout);
	jRegisterPanel.setBackground(colorScheme.primaryVariantColor);
	
	jRegisterPanel.setVisible(false);
	getContentPane().add(jRegisterPanel);
    }
    
    private void initTitlePanel() {
	//TODO
    }    
    
}
