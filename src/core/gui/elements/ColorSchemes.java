/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.gui.elements;

import java.awt.Color;
import org.eclipse.persistence.jpa.jpql.tools.model.query.AbsExpressionStateObject;

/**
 *
 * @author ADMIN
 */
public class ColorSchemes {
    
    public enum Highlight {
	HL1, HL2
    };
    
    public enum Themes {
	THEME1, DEFAULT
    } Themes theme;
    
    public Color primaryColor;
    public Color primaryVariantColor;
    public Color secondaryColor;
    public Color secondaryVariantColor;
    public Color highlightColor1;
    public Color higlightColor1Active;
    public Color higlightColor1Focussed;
    public Color highlightColor2;
    public Color higlightColor2Active;
    public Color higlightColor2Focussed;

    public ColorSchemes(Themes theme) {
	
	this.theme = theme;
	
	switch(theme) {
	    case THEME1:
		primaryColor = new Color(231, 236, 239);
		primaryVariantColor = new Color(212, 216, 219);
		secondaryColor = new Color(75,77,85);
		secondaryVariantColor = new Color(58, 60, 68);
		highlightColor1 = new Color(240, 93, 94);
		higlightColor1Focussed = new Color(241, 107, 108);
		higlightColor1Active = new Color(176, 78, 79);
		highlightColor2 = new Color(77, 204, 189);
		higlightColor2Focussed = new Color(107, 212, 200);
		higlightColor2Active = new Color(68, 152, 142);
		break;
	    default:
		primaryColor = new Color(244, 246, 254);
		primaryVariantColor = new Color(218, 220, 228);
		secondaryColor = new Color(75,77,85);
		secondaryVariantColor = new Color(58, 60, 68);
		highlightColor1 = new Color(240, 93, 127);
		higlightColor1Focussed = new Color(242, 122, 150);
		higlightColor2Active = new Color(175, 68, 93);
		highlightColor2 = new Color(112, 110, 239);
		higlightColor2Focussed = new Color(138, 136, 241);
		higlightColor2Active = new Color(82, 81, 174);
		break;
	}
	
    }
    
    
}
