/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.gui.windows;

import core.gui.elements.ColorSchemes;
import java.awt.BorderLayout;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author ADMIN
 */
public class LoadingDialog extends JFrame {

    private int count;
    private String text;
    private JLabel loadingLabel;
    
    public LoadingDialog() throws HeadlessException {
	super("Forum - Loading...");
	
	count = 0;
	text = "Connecting to Database";
	loadingLabel = new JLabel(text);
	
	setUndecorated(true);
	pack();
	
	setBackground(new ColorSchemes(ColorSchemes.Themes.THEME1).primaryColor);
	setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	setSize(300, 200);
	setLayout(null);
	setLocationRelativeTo(null);
    }    
    
    public void updateText() {
	if(++count > 3){
	    text = "Connecting to Database";
	    count = 0;
	}
	text = text.concat(".");
	loadingLabel.setText(text);
    }
    
}
