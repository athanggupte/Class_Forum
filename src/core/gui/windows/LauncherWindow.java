/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.gui.windows;

import core.communication.DatabaseHandler;
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
    DatabaseHandler dbHandler;

    private ColorSchemes colorScheme;
    
    private CardLayout cardLayout;
    
    private JPanel jTitlePanel;
    private JPanel jLoginPanel;
    private JPanel jRegisterPanel;
    
    public LauncherWindow(DatabaseHandler dbHandler) {
	super("Forum");
	this.dbHandler = dbHandler;
	
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
	
	GRoundedTextField usernameField = new GRoundedTextField();
	GRoundedPasswordField passwordField = new GRoundedPasswordField();
	JLabel usernameLabel = new JLabel("Username");
	JLabel passwordLabel = new JLabel("Password");
	
	GButton loginButton = new GButton("Login", colorScheme, ColorSchemes.Highlight.HL2){
	    @Override
	    public void mouseClicked(MouseEvent e) {
		new Thread(new Runnable() {
		    @Override
		    public void run() {
			synchronized(dbHandler) {
			    dbHandler.searchRecord("");
			}
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
	
	usernameField.setBackground(colorScheme.primaryColor);
	usernameField.setForeground(colorScheme.secondaryVariantColor);
	usernameField.setBorderColor(colorScheme.primaryVariantColor);
	
	passwordField.setBackground(colorScheme.primaryColor);
	passwordField.setForeground(colorScheme.secondaryVariantColor);
	passwordField.setBorderColor(colorScheme.primaryVariantColor);
	
	usernameLabel.setForeground(colorScheme.secondaryColor);
	usernameLabel.setFont(new Font(usernameLabel.getFont().getName(), Font.BOLD, 15));
	
	passwordLabel.setForeground(colorScheme.secondaryColor);
	passwordLabel.setFont(new Font(usernameLabel.getFont().getName(), Font.BOLD, 15));
	
	groupLayout.setHorizontalGroup(
		groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addGroup(groupLayout.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
					.addComponent(usernameLabel)
					.addComponent(passwordLabel))
				.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
					.addComponent(usernameField)
					.addComponent(passwordField)))
			.addComponent(loginButton)
			.addComponent(signUpButton)
		);
	
	groupLayout.setVerticalGroup(
		groupLayout.createSequentialGroup()
			.addGap(0, 150, 170)
			.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				.addComponent(usernameLabel)
				.addComponent(usernameField, 40, 40, 40))
			.addGap(10)
			.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				.addComponent(passwordLabel)
				.addComponent(passwordField))
			.addGap(15)
			.addComponent(loginButton)
			.addGap(15)
			.addComponent(signUpButton, 40, 40, 40)
			.addGap(0, 120, 170)
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
	
	GRoundedTextField usernameField = new GRoundedTextField();
	GRoundedPasswordField passwordField = new GRoundedPasswordField();
	GRoundedTextField emailField = new GRoundedTextField();
	JLabel usernameLabel = new JLabel("Username");
	JLabel passwordLabel = new JLabel("Password");
	JLabel emailLabel = new JLabel("E-mail");
	
	GButton signUpButton = new GButton("Submit", colorScheme, ColorSchemes.Highlight.HL1){
	    @Override
	    public void mouseClicked(MouseEvent e) {
		cardLayout.previous(getContentPane());
	    }
	};
	signUpButton.setFont(new Font(signUpButton.getFont().getName(), Font.BOLD, 18));
	
	usernameField.setBackground(colorScheme.primaryColor);
	usernameField.setForeground(colorScheme.secondaryVariantColor);
	usernameField.setBorderColor(colorScheme.primaryVariantColor);
	
	passwordField.setBackground(colorScheme.primaryColor);
	passwordField.setForeground(colorScheme.secondaryVariantColor);
	passwordField.setBorderColor(colorScheme.primaryVariantColor);
	
	emailField.setBackground(colorScheme.primaryColor);
	emailField.setForeground(colorScheme.secondaryVariantColor);
	emailField.setBorderColor(colorScheme.primaryVariantColor);
	
	usernameLabel.setForeground(colorScheme.secondaryColor);
	usernameLabel.setFont(new Font(usernameLabel.getFont().getName(), Font.BOLD, 13));
	
	passwordLabel.setForeground(colorScheme.secondaryColor);
	passwordLabel.setFont(new Font(usernameLabel.getFont().getName(), Font.BOLD, 13));
	
	emailLabel.setForeground(colorScheme.secondaryColor);
	emailLabel.setFont(new Font(usernameLabel.getFont().getName(), Font.BOLD, 13));
	
	groupLayout.setHorizontalGroup(
		groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addGroup(groupLayout.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
					.addComponent(usernameLabel)
					.addComponent(passwordLabel)
					.addComponent(emailLabel))
				.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
					.addComponent(usernameField)
					.addComponent(passwordField)
					.addComponent(emailField)))
			.addComponent(signUpButton)
		);
	
	groupLayout.setVerticalGroup(
		groupLayout.createSequentialGroup()
			.addGap(0, 150, 170)
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
			.addGap(15)
			.addComponent(signUpButton, 40, 40, 40)
			.addGap(0, 120, 170)
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
