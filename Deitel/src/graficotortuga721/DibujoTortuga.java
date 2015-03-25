/**
 * Deitel - graficotortuga721 : DibujoTortuga.java
 * @author Iker Garcia Ramirez
 * @date 24/3/2015
 */
package graficotortuga721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//Comienza la clase DibujoTortuga
public class DibujoTortuga {
    private static final char AST = '*'; //caracter que dibuja la tortuga
    private int xMaxima; //ancho del tablero
    private int yMaxima; //alto del tablero
    private int pluma; //posicion de la pluma 1 arriba, 2 abajo
    private int x; //posicion x de la tortuga
    private int y; //posicion y de la tortuga
    private int posicion;//derecha-0 abajo-1 izquierda-2 arriba-3
    private char[][] tablero; //tablero
    
    /**
     * Constructor de la clase DibujoTortuga
     * @param xMaxima
     * @param yMaxima
     */
    public DibujoTortuga(int xMaxima, int yMaxima) {
	this.xMaxima = xMaxima;
	this.yMaxima = yMaxima;
	tablero = new char[yMaxima][xMaxima];
	
	//rellenamos el tablero con espacios
	for (int i = 0; i < tablero.length; i++) {
	    Arrays.fill(tablero[i], ' ');
	}
	
	posicion = 0; //posicion al inicio 0, mirando a la derecha
	x = 0; //tortuga en inicio x = 0
	y = 0; //tortuga en inicio y = 0
	pluma = 1; //pluma por defecto levantada
	
    } //fin del constructor de la clase DibujoTortuga
    
    /**
     * Método : pedirComando
     * @return comando
     * @throws NumberFormatException
     * @throws IOException
     */
    public int dibujar() throws NumberFormatException, IOException {
	int comando = 0; //comando a 0 (Fin)
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	mostrarComandos();
	    do {
		System.out.println("Dígame un comando");
		comando = Integer.parseInt(bf.readLine());
		procesarComando(comando);
	    } while (comando!=0 || comando>7); //fin del do..while
	return comando;
    } //fin del metodo pedirComando
    
    /**
     * Método : mostrarComandos
     */
    public void mostrarComandos() {
	System.out.println(
		"1 Pluma arriba\n"
		+ "2 Pluma abajo\n"
		+ "3 Girar derecha\n"
		+ "4 Girar izquierda\n"
		+ "5 Avanzar\n"
		+ "6 Mostrar tablero\n"
		+ "7 Mostrar comandos\n"
		+ "0 Terminar"
		);
    } //fin del método mostrarComandos
    
    /**
     * Método : procesarComando
     * @param n
     * @throws IOException 
     * @throws NumberFormatException 
     */
    public void procesarComando(int n) throws NumberFormatException, IOException {
	switch (n) {
	case 1:
	    pluma = 1;
	    System.out.println("Pluma arriba");
	    break;
	case 2:
	    pluma = 2;
	    System.out.println("Pluma abajo");
	    break;
	case 3: //girar derecha
	    posicion++;
	    System.out.println("Giro a la derecha");
	    //si la posición es mayor que las válidas hemos dado la vuelta entera
	    if(posicion>3) posicion = 0;
	    break;
	case 4: //girar izquierda
	    posicion--;
	    System.out.println("Giro a la izquierda");
	    //si la posición es negativa hemos dado la vuelta entera
	    if(posicion<0) posicion = 3;
	    break;
	case 5:
	    movimiento();
	    break;
	case 6:
	    mostrarTablero();
	    break;
	case 7:
	    mostrarComandos();
	    break;
	default: System.out.println("Fin");
	    break;
	} //fin del switch
    } //fin del método procesarComando
    
    /**
     * Método : mostrarTablero
     */
    public void mostrarTablero() {
	for (int i = 0; i < tablero.length; i++) {
	    for (int j = 0; j < tablero[1].length; j++) {
		System.out.print(tablero[i][j]);
	    } //fin del for para los elementos de la fila (columna)
	    System.out.println();
	} //fin del for de cada fila
    } //fin del método mostrarTablero
    
    /**
     * Método : pedirEspacios
     * @return espacios
     * @throws IOException 
     * @throws NumberFormatException 
     */
    public int pedirEspacios() throws NumberFormatException, IOException {
	int espacios = 0; //los espacios a 0
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	    do {
		System.out.println("Dígame un número de espacios");
		espacios = Integer.parseInt(bf.readLine());
	    } while (espacios<0); //fin del do..while
	return espacios;
    } //fin del método pedirEspacios
    
    /**
     * Método : movimiento
     * @throws NumberFormatException
     * @throws IOException
     */
    public void movimiento() throws NumberFormatException, IOException {
	int espacios = procesarEspacios(pedirEspacios());
	
	if(pluma==2) { //si la pluma esta hacia abajo dibujamos
	    dibujar(espacios);
	} else { //si no avanzamos
	    avanzar(espacios);
	}
    } //fin del método movimiento
    
    /**
     * Método : procesarEspacios
     * @param espacios
     * @return
     */
    private int procesarEspacios(int espacios) {
	int espaciosDisponibles = 0; //espacios disponibles 0
	
	if(posicion==0) espaciosDisponibles = xMaxima-x-1; //si nos movemos hacia la derecha 
	else if(posicion==1) espaciosDisponibles = yMaxima-y-1; //si nos movemos hacia abajo
	else if(posicion==2) espaciosDisponibles = x+1; //si nos movemos hacia la izquierda
	else espaciosDisponibles = y+1; //si nos movemos hacia arriba
	
	//si los espacios introducidos por el usuario superan los disponibles
	//solo movemos los disponibles
	if(espacios>espaciosDisponibles) return espaciosDisponibles;
	
	return espacios;
    } //fin del método procesarEspacios
    
    
    /**
     * Método : avanzar
     * @param espacios
     */
    private void avanzar(int espacios) {
	System.out.println("Se han avanzado " + espacios + " espacios");
	
	if(posicion==0) x+=(espacios-1); //hacia la derecha
	else if(posicion==1) y+=(espacios-1); //hacia abajo
	else if(posicion==2) x-=(espacios-1); //hacia la izquierda
	else y-=(espacios-1); //hacia arriba
	
    } //fin del método avanzar
    
    /**
     * Método : dibujar
     * @param espacios
     */
    private void dibujar(int espacios) {
	System.out.println("Se han dibujado " + espacios + " asteriscos");
	while(espacios>0) {
	    tablero[y][x] = AST;
	    if(espacios>1) { //en el último ciclo solo dibujamos, no incrementamos/decrementamos
		if(posicion==0) x++; //hacia la derecha
		else if(posicion==1) y++; //hacia abajo
		else if(posicion==2) x--; //hacia la izquierda
		else y--; //hacia arriba
	    }
	    espacios--;
	}
    } //fin del método dibujar
    

    
    /**
     * Método : main
     * @param args
     */
    public static void main(String[] args) {
	int xMaxima = 20;
	int yMaxima = 20;
	DibujoTortuga dt = new DibujoTortuga(xMaxima, yMaxima); //creamos el tablero de 20x20
	try {
	    dt.dibujar(); //dibujamos
	} catch (NumberFormatException e) {
	    System.err.println("Error de tipo de numero");
	    e.printStackTrace();
	} catch (IOException e) {
	    System.err.println("Error de entrada/salida");
	    e.printStackTrace();
	} //fin del try..catch
    } //fin del main
} //fin de la clase DibujaTortuga
