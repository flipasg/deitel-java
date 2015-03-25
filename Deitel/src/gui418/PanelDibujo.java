package gui418;

// Fig. 4.18: PanelDibujo.java
//  Uso de drawLine para conectar las esquinas de un panel.
import java.awt.Graphics; 
import javax.swing.JPanel;

public class PanelDibujo extends JPanel
{
   // dibuja una x desde las esquinas del panel
   public void paintComponent( Graphics g )
   {
      // llama a paintComponent para asegurar que el panel se muestre correctamente
      super.paintComponent( g );
      
      int anchura = getWidth(); // anchura total   
      int altura = getHeight(); // altura total

      // dibuja una línea de la esquina superior izquierda a la esquina inferior derecha
      g.drawLine( 0, 0, anchura, altura );
      
      // dibuja una línea de la esquina inferior izquierda a la esquina superior derecha
      g.drawLine( 0, altura, anchura, 0 );
   } // fin del método paintComponent
} // fin de la clase PanelDibujo


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