/**
 * Deitel - gui420 : Dibujo.java
 * @author ikk
 * @date 22/3/2015 2015
 */
package gui420;

import java.awt.Graphics;

import javax.swing.JPanel;

//Comienza la clase Dibujo
public class Dibujo extends JPanel {
    public void paintComponent( Graphics g )
    {
       // llama a paintComponent para asegurar que el panel se muestre correctamente
       super.paintComponent( g );
       
       int anchura = 0;
       int altura = getHeight();
       
       int pasoAltura = altura/15;
       int pasoAnchura = getWidth()/15;
       
       //parte superior izquierda
       for (int i = 0; i < 15; i++) {
	   g.drawLine( 0, 0, anchura, altura);
	   anchura+=pasoAnchura;
	   altura-=pasoAltura;
       }
       
       anchura = getWidth();
       altura = getHeight();
       //parte superior derecha
       for (int i = 0; i < 15; i++) {
	   g.drawLine(getWidth(), 0, anchura, altura);
	   anchura-=pasoAnchura;
	   altura-=pasoAltura;
       }
       
       anchura = getWidth();
       altura = getHeight();
       //parte inferior izquierda
       for (int i = 0; i < 15; i++) {
	   g.drawLine(0 , getHeight(), anchura, altura);
	   anchura-=pasoAnchura;
	   altura-=pasoAltura;
       }
       
       anchura = 0;
       altura = getHeight();
       //parte inferior derecha
       for (int i = 0; i < 15; i++) {
	   g.drawLine(getWidth() , getHeight(), anchura, altura);
	   anchura+=pasoAnchura;
	   altura-=pasoAltura;
       }
       
       
    } // fin del método paintComponent
}
