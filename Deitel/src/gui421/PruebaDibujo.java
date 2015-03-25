/**
 * Deitel - gui420 : PruebaDibujo.java
 * @author ikk
 * @date 22/3/2015 2015
 */
package gui421;

import gui418.PanelDibujo;

import javax.swing.JFrame;

//Comienza la clase PruebaDibujo
public class PruebaDibujo {

    /**
     * Método : main
     * @param args
     */
    public static void main(String[] args) {
	// crea un panel que contiene nuestro dibujo
	Dibujo panel = new Dibujo();
	// crea un nuevo marco para contener el panel
	JFrame aplicacion = new JFrame();
	// establece el marco para salir cuando se cierre
	aplicacion.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	aplicacion.add( panel ); // agrega el panel al marco
	aplicacion.setSize( 250, 250 ); // establece el tamaño del marco
	aplicacion.setVisible( true ); // hace que el marco sea visible 
    }

}
