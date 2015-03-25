/**
 * Deitel - cap6 : AdivinarNumero.java
 * @author Iker Garcia Ramirez
 * @date 23/3/2015
 */
package cap6;

import java.util.Random;

//Comienza la clase AdivinarNumero
public class AdivinarNumero {
    private int incognita;
    private int inferior;
    private int superior;
    
    
    /**
     * Constructor de la clase AdivinarNumero
     * @param inferior
     * @param superior
     */
    public AdivinarNumero(int inferior, int superior) {
	this.inferior = inferior;
	this.superior = superior;
	
	Random rnd = new Random();
	incognita = rnd.nextInt(superior-inferior) + inferior;
    } // fin del constructor de la clase AdivinarNumero


    /**
     * Método : busquedaBinaria
     * @param numero
     * @return
     */
    public int busquedaBinaria(int numero) {
	if(numero==incognita) {
	    return 0;
	} else if(numero<incognita) {
	    inferior = numero;
	    return 1;
	} else {
	    superior = numero;
	    return -1;
	}
    }
    
    

} // fin de la clase AdivinarNumero
