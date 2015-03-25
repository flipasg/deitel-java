/**
 * Deitel - gui526 : PruebDibujo.java
 * @author ikk
 * @date 22/3/2015 2015
 */
package gui528;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

//Comienza la clase PruebDibujo
public class PruebDibujo {
    
    /**
     * Método : main
     * @param args
     */
    public static void main(String[] args) {
	Dibujo d = new Dibujo();
	
	JFrame app = new JFrame();
	
	app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	app.add(d);
	app.setSize(300, 300);
	app.setVisible(true);
    } // fin del método main
} // fin de la clase PruebDibujo
