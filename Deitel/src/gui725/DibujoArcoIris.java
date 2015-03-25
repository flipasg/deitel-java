package gui725;

// Fig. 7.25: DibujoArcoIris.java
// Demuestra el uso de colores en un arreglo.
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class DibujoArcoIris extends JPanel
{
   // Define los colores índigo y violeta
   private final static Color VIOLETA = new Color( 128, 0, 128 );
   private final static Color INDIGO = new Color( 75, 0, 130 );
   
   // los colores a usar en el arco iris, empezando desde los más interiores
   // Las dos entradas de color blanco producen un arco vacío en el centro
   private Color[] colores =
      { Color.WHITE, Color.WHITE, VIOLETA, INDIGO, Color.BLUE,
        Color.GREEN, Color.YELLOW, Color.ORANGE, Color.RED };
        
   // constructor
   public DibujoArcoIris()
   {
      setBackground( Color.WHITE ); // establece el fondo al color blanco
   } // fin del constructor de DibujoArcoIris
        
   // dibuja un arco iris, usando círculos concéntricos
   public void paintComponent( Graphics g )
   {
      super.paintComponent( g );
      
      int radio = 20; // el radio de un arco
      
      // dibuja el arco iris cerca de la parte central inferior
      int centroX = getWidth() / 2;
      int centroY = getHeight() - 10;

      // dibuja arcos rellenos, empezando con el más exterior
      for ( int contador = colores.length; contador > 0; contador-- )
      {
         // establece el color para el arco actual
         g.setColor( colores[ contador - 1 ] );
         
         // rellena el arco desde 0 hasta 180 grados
         g.fillArc( centroX - contador * radio,
            centroY - contador * radio, 
            contador * radio * 2, contador * radio * 2, 0, 180 );
      } // fin de for
   } // fin del método paintComponent
} // fin de la clase DibujoArcoIris


/**************************************************************************
 * (C) Copyright 1992-2012 por Deitel & Associates, Inc. y                *
 * Pearson Education, Inc. Todos los derechos reservados.                 *
 *                                                                        *
 * RENUNCIA: Los autores y el editor de este libro han realizado su mejor *
 * esfuerzo para preparar este libro. Esto incluye el desarrollo, la      *
 * investigación y prueba de las teorías y programas para determinar su   *
 * efectividad. Los autores y el editor no hacen ninguna garantía de      *
 * ningún tipo, expresa o implícita, en relación con estos programas o    *
 * con la documentación contenida en estos libros. Los autores y el       *
 * editor no serán responsables en ningún caso por los daños consecuentes *
 * en conexión con, o que surjan de, el suministro, desempeño o uso de    *
 * estos programas.                                                       *
 *************************************************************************/

