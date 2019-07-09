/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.gui.elements;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicScrollBarUI;

/**
 *
 * @author ADMIN
 */
public class GScrollBarUI extends BasicScrollBarUI {
    
    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle r) {
	Graphics2D g2 = (Graphics2D) g.create();
	g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	
	Color color = null;
	if(!c.isEnabled()) {
	    return;
	} else if(isDragging) {
	    color = new ColorSchemes(ColorSchemes.Themes.THEME1).secondaryVariantColor;
	} else if(isThumbRollover()) {
	    color = new ColorSchemes(ColorSchemes.Themes.THEME1).secondaryColor;
	} else {
	    color = new ColorSchemes(ColorSchemes.Themes.THEME1).primaryVariantColor;
	}
	
	
	g2.setPaint(new Color(color.getRed(), color.getGreen(), color.getBlue(), 120));
	//g2.drawRoundRect(r.x, r.y, r.width, r.height, 5, 5);
	g2.fillRoundRect(r.x, r.y, r.width, r.height, 5, 5);
	g2.dispose();
	
    }

    @Override
    protected void paintTrack(Graphics g, JComponent c, Rectangle r) {
	Graphics2D g2 = (Graphics2D) g.create();
	g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	
	Color color = new ColorSchemes(ColorSchemes.Themes.THEME1).primaryColor;
	
	g2.setPaint(new Color(color.getRed(), color.getGreen(), color.getBlue(), 120));
	//g2.drawRoundRect(r.x, r.y, r.width, r.height, 5, 5);
	g2.fillRoundRect(r.x, r.y, r.width, r.height, 5, 5);
	g2.dispose();
    }

    @Override
    protected JButton createIncreaseButton(int orientation) {
	return new JButton((javax.swing.Icon)null);
    }

    @Override
    protected JButton createDecreaseButton(int orientation) {
	return new JButton((javax.swing.Icon)null);
    }
    
    
    
}
