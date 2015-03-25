package cap7cartas;

// Fig. 7.10: PaqueteDeCartas.java
// La clase PaqueteDeCartas representa un paquete de cartas de juego.
import java.util.Random;

public class PaqueteDeCartas
{
   private Carta[] paquete; // arreglo de objetos Carta
   private int cartaActual; // subíndice de la siguiente Carta a repartir
   private static final int NUMERO_DE_CARTAS = 52; // número constante de Cartas
   
   // generador de números aleatorios
   private static final Random numerosAleatorios = new Random(); 

   // el constructor llena el paquete de Cartas
   public PaqueteDeCartas()
   {
      String[] caras = { "As", "Dos", "Tres", "Cuatro", "Cinco", "Seis", 
         "Siete", "Ocho", "Nueve", "Diez", "Joto", "Quina", "Rey" };
      String[] palos = { "Corazones", "Diamantes", "Treboles", "Espadas" };

      paquete = new Carta[ NUMERO_DE_CARTAS ]; // crea arreglo de objetos Carta
      cartaActual = 0; // establece cartaActual para que la primera Carta repartida sea paquete[ 0 ]

      // llena el paquete con objetos Carta
      for ( int cuenta = 0; cuenta < paquete.length; cuenta++ ) 
         paquete[ cuenta ] = 
            new Carta( caras[ cuenta % 13 ], palos[ cuenta / 13 ] );
   } // fin del constructor de PaqueteDeCartas

   // baraja el paquete de Cartas con algoritmo de una pasada
   public void barajar()
   {
      // después de barajar, la repartición debe empezar en paquete[ 0 ] otra vez
      cartaActual = 0; // reinicializa cartaActual

      // para cada Carta, selecciona otra Carta aleatoria (0 a 51) y las intercambia
      for ( int primera = 0; primera < paquete.length; primera++ ) 
      {
         // selecciona un número aleatorio entre 0 y 51 
         int segunda =  numerosAleatorios.nextInt( NUMERO_DE_CARTAS );
         
         // intercambia Carta actual con la Carta seleccionada al azar
         Carta temp = paquete[ primera ];        
         paquete[ primera ] = paquete[ segunda ];   
         paquete[ segunda ] = temp;            
      } // fin de for
   } // fin de método barajar

   // reparte una Carta
   public Carta repartirCarta()
   {
      // determina si quedan Cartas por repartir
      if ( cartaActual < paquete.length )
         return paquete[ cartaActual++ ]; // devuelve la Carta actual en el arreglo
      else        
         return null; // devuelve null para indicar que se repartieron todas las Cartas
   } // fin del método repartirCarta
} // fin de la clase PaqueteDeCartas


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
