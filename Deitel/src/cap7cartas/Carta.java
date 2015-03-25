package cap7cartas;

// Fig. 7.9: Carta.java
// La clase Carta representa una carta de juego.

public class Carta 
{
   private String cara; // cara de la carta ("As", "Dos", ...)
   private String palo; // palo de la carta ("Corazones", "Diamantes", ...)

   // el constructor de dos argumentos inicializa la cara y el palo de la carta
   public Carta( String caraCarta, String paloCarta )
   {
      cara = caraCarta; // inicializa la cara de la carta
      palo = paloCarta; // inicializa el palo de la carta
   } // fin del constructor de Carta con dos argumentos

   // devuelve representación String de Carta
   public String toString() 
   { 
      return cara + " de " + palo;
   } // fin del método toString
} // fin de la clase Carta


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
