/**
 * Deitel - gui38 : DialogoNombre.java
 * @author ikk
 * @date 22/3/2015 2015
 */
package gui38;

import javax.swing.JOptionPane;

//Comienza la clase DialogoNombre
public class DialogoNombre {

    /**
     * Método : main
     * @param args
     */
    public static void main(String[] args) {
	//pide al usuario que escriba su nombre
	String nombre = JOptionPane.showInputDialog("Cual es su nombre?");
	
	//crea el mensaje
	String mensaje = String.format("Bienvenido, %s, a la programación en Java!", nombre);
	
	//muestra el nebsaje para dar la bienvenida al usuario
	JOptionPane.showMessageDialog(null, mensaje);
    } //fin del método main

} //fin de la clase DialogoNombre
