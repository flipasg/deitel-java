package gui725;

// Fig. 7.23: PruebaDibujoArcoiris.java
// Aplicaci�n de prueba para mostrar un arco iris.
import javax.swing.JFrame;

public class PruebaDibujoArcoIris
{
   public static void main( String[] args )
   {
      DibujoArcoIris panel = new DibujoArcoIris();      
      JFrame aplicacion = new JFrame();
      
      aplicacion.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      aplicacion.add( panel );
      aplicacion.setSize( 400, 250 );
      aplicacion.setVisible( true );
   } // fin de main
} // fin de la clase PruebaDibujoArcoIris


/**************************************************************************
 * (C) Copyright 1992-2012 por Deitel & Associates, Inc. y                *
 * Pearson Education, Inc. Todos los derechos reservados.                 *
 *                                                                        *
 * RENUNCIA: Los autores y el editor de este libro han realizado su mejor *
 * esfuerzo para preparar este libro. Esto incluye el desarrollo, la      *
 * investigaci�n y prueba de las teor�as y programas para determinar su   *
 * efectividad. Los autores y el editor no hacen ninguna garant�a de      *
 * ning�n tipo, expresa o impl�cita, en relaci�n con estos programas o    *
 * con la documentaci�n contenida en estos libros. Los autores y el       *
 * editor no ser�n responsables en ning�n caso por los da�os consecuentes *
 * en conexi�n con, o que surjan de, el suministro, desempe�o o uso de    *
 * estos programas.                                                       *
 *************************************************************************/
