package cap7cartas;

// Fig. 7.11: PruebaPaqueteDeCartas.java
// Aplicaci�n para barajar y repartir cartas.

public class PruebaPaqueteDeCartas
{
   // ejecuta la aplicaci�n
   public static void main( String[] args )
   {
      PaqueteDeCartas miPaqueteDeCartas = new PaqueteDeCartas();
      miPaqueteDeCartas.barajar(); // coloca las Cartas en orden aleatorio
      
      // imprime las 52 Cartas en el orden en el que se reparten
      for ( int i = 1; i <= 52; i++ )
      {
         // reparte e imprime una Carta
         System.out.printf( "%-20s", miPaqueteDeCartas.repartirCarta() );

	 if ( i % 4 == 0 ) // imprime una nueva l�nea despu�s de cada cuatro cartas
		System.out.println();
      } // fin de for
   } // fin de main
} // fin de la clase PruebaPaqueteDeCartas


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
