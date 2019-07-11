/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.gui.windows;

import core.communication.DatabaseConnection;
import core.data.User;
import core.gui.elements.ColorSchemes;
import core.gui.elements.GScrollBarUI;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author ADMIN
 */
public class DashboardWindow extends JFrame {
    User user;
	    
    private ColorSchemes colorScheme;
    
    private JPanel jTitlePanel;
    private JPanel jWorkAreaPanel;
    private JPanel jSideBarPanel;

    public DashboardWindow(User user) {
	super("Forum - " + user.getUserName());
	this.user = user;
	
	colorScheme = new ColorSchemes(ColorSchemes.Themes.THEME1);
	
	initWorkArea();
	
	pack();
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(1024, 640);
	setLocationRelativeTo(null);
    }

    private void initWorkArea() {
	jWorkAreaPanel = new JPanel();
	jWorkAreaPanel.setLayout(new BoxLayout(jWorkAreaPanel, BoxLayout.Y_AXIS));
	for(int i=0; i<40; i++)
	    jWorkAreaPanel.add(new JButton("Button " + i));
	
	JScrollPane scrollPane = new JScrollPane(jWorkAreaPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(
		(int)(scrollPane.getVerticalScrollBar().getPreferredSize().getWidth()/1.33d),
		(int)scrollPane.getVerticalScrollBar().getPreferredSize().getHeight()));
	scrollPane.getVerticalScrollBar().setUI(new GScrollBarUI());
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
	getContentPane().add(scrollPane);
    }
    
    
}
