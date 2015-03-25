/**
 * Deitel - gui526 : Dibujo.java
 * @author ikk
 * @date 22/3/2015 2015
 */
package gui528;

import java.awt.Graphics;

import javax.swing.JPanel;

//Comienza la clase Dibujo
public class Dibujo extends JPanel {
    
    public void paintComponent(Graphics g) {
	super.paintComponent(g);
	
	int x = getWidth()/2;
	int y = getHeight()/2;
	int incremento = 0;
	for (int i = 1; i <= 12; i++) {
	    incremento = i*10;
	    g.drawOval(x, y,  10+incremento, 10-incremento);;
	} // fin del for
    } // fin del método paintComponent    
} //fin de la clase Dibujo
