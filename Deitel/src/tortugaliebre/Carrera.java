/**
 * Deitel - tortugaliebre : Carrera.java
 * @author Iker Garcia Ramirez
 * @date 30/3/2015
 */
package tortugaliebre;

import java.util.Random;

//Comienza la clase Carrera
public class Carrera {
    //signo si los dos animales están en la misma posición
    private static final char SIGNO_IGUALES = 'O';
    private static final char SIGNO_TORTUGA = 'T'; //signo de la tortuga
    private static final char SIGNO_LIEBRE = 'L'; //signo de la liebre
    private char posiciones[]; //lista de las posiciones de la carrera
    //lista de movimientos de la tortuga
    private int movimientosTortuga[] = {3,3,3,3,3, -6, -6, 1, 1, 1};
    //lista de movimientos de la liebre
    private int movimientosLiebre[] = {0, 0, 9, 9, -12, 1, 1, 1, -2, -2};
    private int posicionTortuga; //posicion de la tortuga
    private int posicionLiebre; //posicion de la liebre
    
    /**
     * Constructor de la clase Carrera
     */
    public Carrera() {
	posiciones = new char[70]; //0 inicio, 69 meta
	posicionTortuga = 0; //la tortuga comienza en el inicio
	posicionLiebre = 0; //la liebre comienza en el inicio
    } //fin del constructor de la clase Carrera
    
    /**
     * Método : avanzar
     */
    public void avanzar() {
	Random rnd = new Random();
	posicionTortuga+=movimientosTortuga[rnd.nextInt(10)];
	posicionLiebre+=movimientosLiebre[rnd.nextInt(10)];
	
	
	//si alguna de las posiciones es menor a 0, la ponemos a 0
	//el animal vuelve al inicio
	if(posicionTortuga<0) posicionTortuga = 0;
	if(posicionLiebre<0) posicionLiebre = 0;
	
	//si alguna de las posiciones es mayor a 69, la ponemos a 69
	//el animal ha llegado a la meta
	if(posicionTortuga>69) posicionTortuga = 69;
	if(posicionLiebre>69) posicionLiebre = 69;
	
    } //fin del método avanzar
    
    /**
     * Método : descolocar
     */
    public void descolocar() {
	//asignamos el caracter vacio a la posicion de la tortuga y la liebre
	posiciones[posicionTortuga] = ' ';
	posiciones[posicionLiebre] = ' ';
	
    } //fin del método descolocar
    
    /**
     * Método : colocar
     */
    public void colocar() {
	//si las posiciones son iguales asignamos el signo de iguales
	if(posicionTortuga==posicionLiebre) {
	    posiciones[posicionTortuga] = SIGNO_IGUALES;
	} else { //si no el signo correspondiente
	    posiciones[posicionTortuga] = SIGNO_TORTUGA;
	    posiciones[posicionLiebre] = SIGNO_LIEBRE;
	} //fin if..else
	
    } //fin del método colocar
    
    
    /**
     * Método : verPosiciones
     */
    public void verPosiciones() {
	for (int i = 0; i < posiciones.length; i++) {
	    System.out.print(posiciones[i]);
	} //fin del for
	System.out.println();
	
    } //fin del método verPosiciones
    
    /**
     * Método : hayGanador
     * @return ganador
     */
    public int hayGanador() {
	int ganador = -1; //0 no hay ganador
	if(posicionTortuga>=69 && posicionLiebre>=69) ganador = 0; //empate
	else if(posicionTortuga>=69) ganador = 1; //gana la tortuga
	else if(posicionLiebre>=69) ganador = 2; //gana la liebre
	return ganador;
	
    } //fin del método hayGanador
    
    /**
     * Método : correr
     */
    public void correr() {
	//mientras no halla ganador
	while(hayGanador()<0) {
	    descolocar(); //primero descolocamos
	    avanzar(); //avanzamos
	    colocar(); //colocamos
	    verPosiciones(); //visualizamos las posiciones
	} //fin del while
	
	//visualizamos que animal a ganado o si ha sido un empate
	if(hayGanador()==0) System.out.println("Empate");
	else if(hayGanador()==1) System.out.println("Ha ganado la Tortuga");
	else System.out.println("Ha ganado la Liebre");
	
    } //fin del método correr
    
    /**
     * Método : main
     * @param args
     */
    public static void main(String[] args) {
	Carrera c = new Carrera();
	c.correr();
	
    } //fin del main
    
} //fin de la clase Carrera
