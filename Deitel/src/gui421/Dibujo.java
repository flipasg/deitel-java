/**
 * Deitel - gui420 : Dibujo.java
 * @author ikk
 * @date 22/3/2015 2015
 */
package gui421;

import java.awt.Graphics;

import javax.swing.JPanel;

//Comienza la clase Dibujo
public class Dibujo extends JPanel {
    public void paintComponent( Graphics g )
    {
       // llama a paintComponent para asegurar que el panel se muestre correctamente
       super.paintComponent( g );
       
       int anchura = 0;
       int altura = getWidth();
       
       int pasoAltura = getHeight()/15;
       int pasoAnchura = getWidth()/15;
       
       int inicioAltura = 0;
       int inicioAnchura = 0;
	   
       for (int i = 0; i < 15; i++) {
	   anchura+=pasoAnchura;
	   g.drawLine( inicioAnchura, inicioAltura, anchura, altura);
	   inicioAltura+=pasoAltura;
	   inicioAnchura+=pasoAnchura;
	}
	   
       
       

       
       
    } // fin del método paintComponent
}
