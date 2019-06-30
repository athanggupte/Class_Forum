/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.gui.elements;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;
import javax.swing.JLabel;

/**
 *
 * @author ADMIN
 */
abstract public class GButton extends JPanel implements MouseListener {
    
    private Shape shape;
    
    private Color inactiveColor;
    private Color activeColor;
    private Color clickedColor;
    
    private JLabel gLabel;
    
    public GButton(String text, ColorSchemes colorScheme, ColorSchemes.Highlight colorId) {
	super();
	setOpaque(false);
	gLabel = new JLabel(text);
	gLabel.setVerticalTextPosition(JLabel.CENTER);
	
	if(colorId == ColorSchemes.Highlight.HL1) {
	    inactiveColor = colorScheme.highlightColor1;
	    activeColor = colorScheme.higlightColor1Focussed;
	    clickedColor = colorScheme.higlightColor1Active;
	} 
	else if (colorId == ColorSchemes.Highlight.HL2) {
	    inactiveColor = colorScheme.highlightColor2;
	    activeColor = colorScheme.higlightColor2Focussed;
	    clickedColor = colorScheme.higlightColor2Active;
	}
	
	setLayout(new GridBagLayout());
	add(gLabel);
	
	gLabel.setFont(getFont());
	
	setBackground(inactiveColor);
	addMouseListener(this);
    }

    @Override
    public void setFont(Font font) {
	super.setFont(font);
	if(gLabel != null)
	    gLabel.setFont(font);
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
	setBackground(clickedColor);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
	setBackground(activeColor);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
	setBackground(activeColor);
    }

    @Override
    public void mouseExited(MouseEvent e) {
	setBackground(inactiveColor);
    }
    
    @Override
    public boolean contains(int x, int y) {
	if(shape == null || !shape.getBounds().equals(getBounds()))
	    shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, getHeight()/2, getHeight()/2);
	
	return shape.contains(x, y);
    }

    @Override
    protected void paintBorder(Graphics g) {
	g.setColor(getBackground());
	g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, getHeight()/2, getHeight()/2);
    }

    @Override
    protected void paintComponent(Graphics g) {
	g.setColor(getBackground());
	g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, getHeight()/2, getHeight()/2);
	super.paintComponent(g);
    }
    
    
}
