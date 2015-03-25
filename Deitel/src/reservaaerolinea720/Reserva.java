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
    private static final int SEPARADOR_CLASES = 5; //5 asiento por clase
    private boolean asientos[]; //lista de asientos ocupados
    private int economicosOcupados; //asientos economicos ocupados
    private int primeraOcupados; //asientos de primera ocupados
    
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
	
	int asiento = -1; //distinto a 1 o 2
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	    do {
		System.out.println("Dígame el asiento que desea\n"
		    	+ "1 para economica\n"
		    	+ "2 para primera clase");
		asiento = Integer.parseInt(bf.readLine());
	    } while (asiento!=1 && asiento!=2); //fin do..while
	return asiento;
    } // fin del método pedirAsiento
    
    /**
     * Método : asientoLibre
     * @param asiento
     * @return
     */
    public boolean asientoLibre(int asiento) {
	if(asiento==1) return asientoEconomicoLibre();
	return asientoPrimeraLibre();
    } //fin del método asientoLibre
    
    /**
     * Método : asientoEconomicoLibre
     * @return si/no asiento encomomico libre
     */
    public boolean asientoEconomicoLibre() {
	if(asientos[SEPARADOR_CLASES-1]) return false;
	return true;
    } // fin del método asientoEconomicoLibre
    
    /**
     * Método : asientoPrimeraLibre
     * @return
     */
    public boolean asientoPrimeraLibre() {
	if(asientos[asientos.length-1]) return false;
	return true;
    } // fin del método asientoPrimeraLibre
    
    /**
     * Método : asignarAsiento
     * @param asiento
     */
    public void asignarAsiento(int asiento) {
	if(asiento==1) { //si es económico
	    asientos[economicosOcupados] = true; //asignamos el asiento
	    economicosOcupados++; //incrementamos los asientos ocupados
	} else { //si es de primera
	    asientos[primeraOcupados] = true;
	    primeraOcupados++;
	} //fin del if..else
    } //fin del método asignarAsiento
    
    /**
     * Método : alternativa
     * @return boolean
     * @throws IOException
     */
    public boolean alternativa() throws IOException {
	//método para preguntar si el cliente desea la alternativa
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	
	System.out.print("La clase esta completa");
	System.out.println("¿Desea cambiar de clase?");
	
	String respuesta = bf.readLine();
	if(respuesta.toLowerCase().startsWith("s")) return true;
	return false;
    } //fin del método alternativa
    
    /**
     * Método : reservar
     * @return
     * @throws NumberFormatException
     * @throws IOException
     */
    public boolean reservar() throws NumberFormatException, IOException {
	int asiento = pedirAsiento(); //pedimos el tipo de asiento
	if(asientoLibre(asiento)) { //si hay asiento libre
	    asignarAsiento(asiento); //asignamos el asiento 
	    return true; //ha sido posible asignarlo
	} else { //si no
	    if(alternativa()) { //si alternativa
		
		//cambiamos la clase
		if(asiento==1) asiento++; //si es de economica incrementamos
		else asiento--; //si no decrementamos
		
		if(asientoLibre(asiento)) { //si hay asiento libre
		    asignarAsiento(asiento); //asignamos el asiento
		    return true; //ha sido posible asignarlo
		} //fin asignacion alternativa
	    } //fin alternativa
	} //fin primera asignacion
	
	return false;
    } //fin del método reservar
    
    /**
     * Método : mostrarAsientos
     */
    public void mostrarAsientos() {
	for (int i = 0; i < asientos.length; i++) {
	    if(i<SEPARADOR_CLASES) {
		System.out.println("E " + asientos[i]);
	    } else {
		System.out.println("P " + asientos[i]);
	    }
	} //fin del for
    } //fin del método mostrarAsientos
    
    /**
     * Método : main
     * @param args
     * @throws NumberFormatException
     * @throws IOException
     */
    public static void main(String[] args) throws NumberFormatException, IOException {
	Reserva r = new Reserva();
	for (int i = 0; i < 12; i++) {
	    if(r.reservar()) System.out.println("Reserva hecha con exito");
	    else System.out.println("El proximo vuelo sale en 3 horas");
	    r.mostrarAsientos();
	} //fin del for
	
    } //fin del main
    
} //fin de la clase Reserva
