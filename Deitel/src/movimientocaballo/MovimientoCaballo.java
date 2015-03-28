/**
 * Deitel - movimientocaballo : MovimientoCaballo.java
 * @author Iker Garcia Ramirez
 * @date 28/3/2015
 */
package movimientocaballo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//Comienza la clase MovimientoCaballo
public class MovimientoCaballo {
    private int tablero[][]; //tablero de ajedrez
    private int horizontal[]; //movimientos horizontales del caballo
    private int vertical[]; //movimientos verticales del caballo
    private int columnaActual; //columna actual del caballo
    private int filaActual; //fila actual del caballo
    private int movimientosRealizados; //movimientos realizados de 1 a 64
    
    /**
     * Constructor de la clase MovimientoCaballo
     * @throws CaballoException 
     */
    public MovimientoCaballo(int columnaActual, int filaActual) throws CaballoException {
	if(columnaActual>7 || columnaActual<0) throw new CaballoException("Columna no válida");
	if(filaActual>7 || filaActual<0) throw new CaballoException("Fila no válida");
	
	this.columnaActual = columnaActual;
	this.filaActual = filaActual;
	
	movimientosRealizados = 1;
	
	//un tablero de ajedrez es un array bidimensional de 8x8
	tablero = new int[8][8];
	
	//marcamos la casilla de inicio con un 1
	tablero[filaActual][columnaActual] = movimientosRealizados;
	
	/*
	 * un movimiento de tipo 0, 
	 * consiste en mover dos posiciones en forma horizontal a la derecha 
	 * y una posición vertical hacia arriba.
	 * Un movimiento de tipo 2,
	 * consiste en mover una posición horizontalmente a la izquierda
	 * y dos posiciones verticales hacia arriba.
	 * Los movimientos
	 * horizontal a la izquierda y vertical hacia arriba 
	 * se indican con números negativos
	 */
	
	//movimientos horizontales
	horizontal = new int[8];
	horizontal[0] = 2;
	horizontal[1] = 1;
	horizontal[2] = -1;
	horizontal[3] = -2;
	horizontal[4] = -2;
	horizontal[5] = -1;
	horizontal[6] = 1;
	horizontal[7] = 2;
	
	//movimientos verticales
	vertical = new int[8];
	vertical[0] = -1;
	vertical[1] = -2;
	vertical[2] = -2;
	vertical[3] = -1;
	vertical[4] = 1;
	vertical[5] = 2;
	vertical[6] = 2;
	vertical[7] = 1;
    } //fin del constructor de la clase MovimientoCaballo
    
    /**
     * Método : evaluarMovimiento
     * @param movimiento
     * @return
     */
    public boolean evaluarMovimiento(int movimiento) {
	if((filaActual+vertical[movimiento])>7 
		|| (filaActual+vertical[movimiento])<0) return false;
	if((columnaActual+horizontal[movimiento])>7 
		|| (columnaActual+horizontal[movimiento])<0) return false;
	if(tablero[filaActual+vertical[movimiento]][columnaActual+horizontal[movimiento]]!=0) return false;
	return true;
    }
    
    /**
     * Método : moverCaballo
     * @throws NumberFormatException
     * @throws IOException
     */
    public void moverCaballo() throws NumberFormatException, IOException {
	verTablero();
	System.out.println();
	while(movimientosPosibles()!=0 && movimientosRealizados<65) {
	    System.out.println("Dígame un movimiento");
	    int movimiento = pedirNumero();
	    if(evaluarMovimiento(movimiento)) {
		realizarMovimiento(movimiento);
	    } else {
		System.out.println("Imposible realizar ese movimiento");
	    }
	}
    }
    
    /**
     * Método : realizarMovimiento
     * @param movimiento
     */
    public void realizarMovimiento(int movimiento) {
	filaActual+=vertical[movimiento];
	columnaActual+=horizontal[movimiento];
	movimientosRealizados++;
	tablero[filaActual][columnaActual] = movimientosRealizados;
	
	
    }
    
    /**
     * Método : verTablero
     * @param tablero
     */
    public void verTablero(int tablero[][]) {
	System.out.println(" | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 |");
	for (int i = 0; i < tablero.length; i++) {
	    System.out.print(i + "|");
	    for (int j = 0; j < tablero.length; j++) {
		System.out.print(" " + tablero[i][j] + " |");
	    }
	    System.out.println();
	}
    }
    
    /**
     * Método : verTablero
     */
    public void verTablero() {
	System.out.println(" | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 |");
	for (int i = 0; i < tablero.length; i++) {
	    System.out.print(i + "|");
	    for (int j = 0; j < tablero.length; j++) {
		System.out.print(" " + tablero[i][j] + " |");
	    }
	    System.out.println();
	}
    }
    
    /**
     * Método : movimientosPosibles
     * @return
     */
    public int movimientosPosibles() {
	int tableroClon[][] = new int[8][8];
	int movimientosPosibles = 0;
	for (int i = 0; i < tableroClon.length; i++) {
	    for (int j = 0; j < tableroClon.length; j++) {
		tableroClon[i][j] =  tablero[i][j];
	    }
	}
	for (int i = 0; i < 8; i++) {
	    if(evaluarMovimiento(i)) {
		if(tableroClon[filaActual+vertical[i]][columnaActual+horizontal[i]]==0)
		    tableroClon[filaActual+vertical[i]][columnaActual+horizontal[i]] = i+80;
		movimientosPosibles++;
	    }
	}
	verTablero(tableroClon);
	return movimientosPosibles;
    }
    
    /**
     * Método : pedirNumero
     * @return
     */
    public static int pedirNumero() {
	int numero = -1; //no existe el movimiento -1
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	    do {
		System.out.print("-");
		try {
		    numero = Integer.parseInt(bf.readLine());
		} catch (NumberFormatException | IOException e) {
		    System.err.println("Digame un numero valido");
		}
	    } while (numero<0 || numero>7); //fin del do..while
	return numero;
    }
    
    /**
     * Método : main
     * @param args
     */
    public static void main(String[] args) {
	    System.out.println("Dígame la columna");
	    int columna = pedirNumero();
	    System.out.println("Dígame la fila");
	    int fila = pedirNumero();
	    MovimientoCaballo mv = null;
	    try {
		mv = new MovimientoCaballo(fila, columna);
	    } catch (CaballoException e) {
		
		e.printStackTrace();
	    }
	    try {
		mv.moverCaballo();
	    } catch (NumberFormatException | IOException e) {
		
		e.printStackTrace();
	    }
    }
}
