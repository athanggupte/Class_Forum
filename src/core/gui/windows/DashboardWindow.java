/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.gui.windows;

import core.communication.DatabaseConnection;
import core.data.User;
import core.gui.elements.ColorSchemes;
import core.gui.elements.GButton;
import core.gui.elements.GScrollBarUI;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
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
	
	colorScheme = new ColorSchemes(ColorSchemes.Themes.DEFAULT);
	
	initWorkArea();
        initSideBar();
        initTitleBar();
	
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        //groupLayout.setAutoCreateGaps(true);
        //groupLayout.setAutoCreateContainerGaps(true);
        
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jTitlePanel)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addComponent(jSideBarPanel, 120, 240, 260)
                                .addComponent(jWorkAreaPanel))
        );
        
        groupLayout.setVerticalGroup(
                groupLayout.createSequentialGroup()
                        .addComponent(jTitlePanel, 30, 30, 30)
                        .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addComponent(jSideBarPanel, 600, 600, 600)
                                .addComponent(jWorkAreaPanel, 600, 600, 600))
        );
        
        setLayout(groupLayout);
        
        setUndecorated(true);
	pack();
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(1024, 640);
	setLocationRelativeTo(null);
    }

    private void initWorkArea() {
	jWorkAreaPanel = new JPanel();
	jWorkAreaPanel.setLayout(new BoxLayout(jWorkAreaPanel, BoxLayout.Y_AXIS));
        
	JScrollPane scrollPane = new JScrollPane(jWorkAreaPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(
		(int)(scrollPane.getVerticalScrollBar().getPreferredSize().getWidth()/1.33d),
		(int)scrollPane.getVerticalScrollBar().getPreferredSize().getHeight()));
	scrollPane.getVerticalScrollBar().setUI(new GScrollBarUI());
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
	//getContentPane().add(scrollPane);
    }
    
    public void initSideBar() {
        jSideBarPanel = new JPanel();
        jSideBarPanel.setLayout(new BoxLayout(jSideBarPanel, BoxLayout.Y_AXIS));
        
        ArrayList<GButton> sideBarButtons = new ArrayList(5);
        
        for(int i=0; i<5; i++) {
            sideBarButtons.add(new GButton("Home", colorScheme, (i%2==0)?(ColorSchemes.Highlight.HL1):(ColorSchemes.Highlight.HL2)) {
                @Override
                public void mouseClicked(MouseEvent e) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            });
            jSideBarPanel.add(sideBarButtons.get(i));
        }
        
        jSideBarPanel.setBackground(colorScheme.secondaryColor);
    }
    
    public void initTitleBar() {
        jTitlePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        GButton closeButton = new GButton(" X ", colorScheme, ColorSchemes.Highlight.HL1) {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        };
        jTitlePanel.add(closeButton);
        
        jTitlePanel.setBackground(colorScheme.secondaryVariantColor);
    }
}
