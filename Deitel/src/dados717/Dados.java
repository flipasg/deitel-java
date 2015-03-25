/**
 * Deitel - dados717 : Dados.java
 * @author Iker Garcia Ramirez
 * @date 24/3/2015
 */
package dados717;

import java.io.ObjectInputStream.GetField;
import java.util.Random;

//Comienza la clase Dados
public class Dados {
    private int estadisticasTiro[] = new int[6];
    private int estadisticasSuma[] = new int[11];
    
    /**
     * Método : tirarDado
     * @return la cara del dado
     */
    public static int tirarDado() {
	Random rnd = new Random();
	
	return rnd.nextInt(6)+1;
    }
    
    /**
     * Método : sniffar
     * @param n
     */
    public void sniffar(int n) {
	estadisticasTiro[n-1]++;
    }
    
    /**
     * Método : sumar
     * @param n1
     * @param n2
     * @return la suma
     */
    public static int sumar(int n1, int n2) {
	return n1+n2;
    }
    
    /**
     * Método : sniffarSuma
     * @param n
     */
    public void sniffarSuma(int n) {
	estadisticasSuma[n-2]++;
    }
    
    /**
     * Método obtener : getEstadisticasTiro
     * @return el estadisticasTiro de la clase
     */
    public int[] getEstadisticasTiro() {
        return estadisticasTiro;
    }

    /**
     * Método obtener : getEstadisticasSuma
     * @return el estadisticasSuma de la clase
     */
    public int[] getEstadisticasSuma() {
        return estadisticasSuma;
    }

    /**
     * Método : main
     * @param args
     */
    public static void main(String[] args) {
	Dados d = new Dados();
	
	for (int i = 0; i < 36000000; i++) {
	    int d1 = tirarDado();
	    int d2 = tirarDado();
	    int suma = d1+d2;
	    d.sniffar(d1);
	    d.sniffar(d2);
	    d.sniffarSuma(suma);
	}
	
	for (int i = 0; i < d.getEstadisticasTiro().length; i++) {
	    System.out.println("El número " + (i+1) + " ha salido " + d.getEstadisticasTiro()[i] + " veces.");
	}
	
	System.out.println();
	
	for (int i = 0; i < d.getEstadisticasSuma().length; i++) {
	    System.out.println("La suma " + (i+2) + " ha salido " + d.getEstadisticasSuma()[i] + " veces.");
	}
    }
    
} // fin de cla clase dados
