package gui418;

// Fig. 4.19: PruebaPanelDibujo.java
// Aplicación que muestra un PanelDibujo.
import javax.swing.JFrame;

public class PruebaPanelDibujo
{
   public static void main( String[] args )
   {
      // crea un panel que contiene nuestro dibujo
      PanelDibujo panel = new PanelDibujo();
      
      // crea un nuevo marco para contener el panel
      JFrame aplicacion = new JFrame();
      
      // establece el marco para salir cuando se cierre
      aplicacion.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

      aplicacion.add( panel ); // agrega el panel al marco      
      aplicacion.setSize( 250, 250 ); // establece el tamaño del marco
      aplicacion.setVisible( true ); // hace que el marco sea visible 
   } // fin de main
} // fin de la clase PruebaPanelDibujo


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