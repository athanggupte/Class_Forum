/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.gui.elements;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.BorderFactory;
import javax.swing.JPasswordField;

/**
 *
 * @author ADMIN
 */
public class GRoundedPasswordField extends JPasswordField {
    
    private Shape shape;
    private Color borderColor;

    public GRoundedPasswordField() {
	super();
	setOpaque(false);
	borderColor = getForeground();
	setBorder(BorderFactory.createCompoundBorder(
		getBorder(), BorderFactory.createEmptyBorder(1/*TOP*/, 7/*LEFT*/, 1/*BOTTOM*/, 7/*RIGHT*/)
	));
    }
    
    public void setBorderColor(Color color) {
	borderColor = color;
    }
    
    @Override
    public boolean contains(int x, int y) {
	if(shape == null || !shape.getBounds().equals(getBounds()))
	    shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 15, 15);
	
	return shape.contains(x, y);
    }

    @Override
    protected void paintBorder(Graphics g) {
	g.setColor(borderColor);
	g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
    }

    @Override
    protected void paintComponent(Graphics g) {
	g.setColor(getBackground());
	g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
	super.paintComponent(g);
    }
    
}
