/**
 * Deitel - cap6 : Monedas.java
 * @author Iker Garcia Ramirez
 * @date 23/3/2015
 */
package cap6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

//Comienza la clase Monedas
public class Monedas { 
    private enum moneda {CARA, CRUZ}; // enumeración con las opciones de la moneda
    
    /**
     * Método : tirarDado
     * @return Moneda.RESULTADO
     */
    public moneda tirarDado() {
	Random rnd = new Random();
	if(rnd.nextInt(2) == 1) return moneda.CARA;
	return moneda.CRUZ;
    } // fin del método tirar dado
    
    /**
     * Método : accionUsuario
     */
    public void accionUsuario() {
	BufferedReader bf = null;
	int contVeces = 0; // contar las veces que tira la moneda
	int contarCara = 0; // contar las veces que sale cara
	int contarCruz = 0; //contar las veces que sale cruz
	
	try {
	    bf = new BufferedReader(new InputStreamReader(System.in));
	    String respuesta = "";
	    do {
		
		// lanzamos el dado
		System.out.println("Lanzando dado...");
		moneda m = tirarDado();
		
		// contamos el lado que ha salido
		if(m == moneda.CARA) contarCara++;
		else contarCruz++;
		
		// incrementamos las veces
		contVeces++;
		
		System.out.println("Ha salido " + m);
		
		//preguntamos si quiere seguir lanzando la moneda
		System.out.println("¿Quieres seguir lanzando el dado? S/N");
		respuesta = bf.readLine();
	    } while (respuesta.toLowerCase().startsWith("s"));
	    
	    System.out.println("Has tirado " + contVeces);
	    System.out.println(contarCara + " han salido cara");
	    System.out.println(contarCruz + " han salido cruz");
	    
	} catch (IOException e) {
	   System.err.println("Error de entrada/salida");
	   e.printStackTrace();
	}
    } // fin del método accionUsuario
    
    /**
     * Método : main
     * @param args
     */
    public static void main(String[] args) {
	Monedas m = new Monedas();
	m.accionUsuario();
    } // fin del método main
    
} // fin de la clase Monedas
