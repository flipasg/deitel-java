/**
 * Deitel - gui526 : Dibujo.java
 * @author ikk
 * @date 22/3/2015 2015
 */
package gui526;

import java.awt.Graphics;

import javax.swing.JPanel;

//Comienza la clase Dibujo
public class Dibujo extends JPanel {
    private int opcion; //opcion de figura

    /**
     * Constructor de la clase Dibujo
     * @param opcion
     */
    public Dibujo(int opcion) {
	this.opcion = opcion;
    } // fin del constructor
    
    public void paintComponent(Graphics g) {
	super.paintComponent(g);
	
	for (int i = 0; i < 10; i++) {
	    switch (opcion) {
	    case 1:
		g.drawRect(10 + i * 10, 10 + i * 10, 50 + i * 10, 50 + i * 10);
		break;
	    case 2:
		g.drawOval(10 + i * 10, 10 + i * 10, 50 + i * 10, 50 + i * 10);
		break;
	    } // fin del switch
	} // fin del for
    } // fin del método paintComponent    
} //fin de la clase Dibujo
