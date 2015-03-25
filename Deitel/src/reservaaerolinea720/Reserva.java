/**
 * Deitel - reservaaerolinea720 : Reserva.java
 * @author Iker Garcia Ramirez
 * @date 24/3/2015
 */
package reservaaerolinea720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Comienza la clase Reserva
public class Reserva {
    private static final int SEPARADOR_CLASES = 5;
    private boolean asientos[];
    private int economicosOcupados;
    private int primeraOcupados;
    
    /**
     * Constructor de la clase Reserva
     */
    public Reserva() {
	asientos = new boolean[10];
	economicosOcupados = 0; //de 0 a 4
	primeraOcupados = 5; //de 5 a 9
    } // fin del constructor de la clase reserva
    
    /**
     * Método : pedirAsiento
     * @return el tipo de asiento 
     * @throws IOException 
     * @throws NumberFormatException 
     */
    public int pedirAsiento() throws NumberFormatException, IOException {
	
	int asiento = -1;
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	    do {
		System.out.println("Dígame el asiento que desea\n"
		    	+ "1 para economica\n"
		    	+ "2 para primera clase");
		asiento = Integer.parseInt(bf.readLine());
	    } while (asiento!=1 && asiento!=2);
	return asiento;
    } // fin del método pedirAsiento
    
    public boolean asientoLibre(int asiento) {
	if(asiento==1) return asientoEconomicoLibre();
	return asientoPrimeraLibre();
    }
    
    /**
     * Método : asientoEconomicoLibre
     * @return si/no asiento encomomico libre
     */
    public boolean asientoEconomicoLibre() {
	if(asientos[SEPARADOR_CLASES-1]) return false;
	return true;
    } // fin del método asientoEconomicoLibre
    
    public boolean asientoPrimeraLibre() {
	if(asientos[asientos.length-1]) return false;
	return true;
    } // fin del método asientoPrimeraLibre
    
    /**
     * Método : asignarAsiento
     * @param asiento
     */
    public void asignarAsiento(int asiento) {
	if(asiento==1) {
	    asientos[economicosOcupados] = true;
	    economicosOcupados++;
	} else {
	    asientos[primeraOcupados] = true;
	    primeraOcupados++;
	}
    }
    
    public boolean alternativa() throws IOException {
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	System.out.print("La clase esta completa");
	    
	System.out.println("¿Desea cambiar de clase?");
	String respuesta = bf.readLine();
	if(respuesta.toLowerCase().startsWith("s")) return true;
	
	return false;
    }
    public boolean reservar() throws NumberFormatException, IOException {
	int asiento = pedirAsiento();
	if(asientoLibre(asiento)) {
	    asignarAsiento(asiento);
	    return true;
	} else {
	    if(alternativa()) {
		if(asiento==1) asiento++;
		else asiento--;
		
		if(asientoLibre(asiento)) {
		    asignarAsiento(asiento);
		    return true;
		}
		
	    }
	}
	
	return false;
    }
    
    public void mostrarAsientos() {
	for (int i = 0; i < asientos.length; i++) {
	    if(i<SEPARADOR_CLASES) {
		System.out.println("E " + asientos[i]);
	    } else {
		System.out.println("P " + asientos[i]);
	    }
	}
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
	Reserva r = new Reserva();
	for (int i = 0; i < 12; i++) {
	    if(r.reservar()) System.out.println("Reserva hecha con exito");
	    else System.out.println("El proximo vuelo sale en 3 horas");
	    r.mostrarAsientos();
	}

	
	
    }
    
}
