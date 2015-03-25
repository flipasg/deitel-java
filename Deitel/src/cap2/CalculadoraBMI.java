/**
 * Deitel - cap2 : CalculadoraBMI.java
 * @author ikk
 * @date 22/3/2015 2015
 */
package cap2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Comienza la clase CalculadoraBMI
public class CalculadoraBMI {
    private double altura; //en metros
    private int peso; //en kg
    
    
    /**
     * Constructor de la clase CalculadoraBMI
     * @param altura
     * @param peso
     */
    public CalculadoraBMI(double altura, int peso) {
	this.altura = altura;
	this.peso = peso;
    }
    
    public double resultado() {
	return peso/(Math.pow(altura, 2));
    }
    

    /**
     * Método : main
     * @param args
     */
    public static void main(String[] args) {
	BufferedReader bf = null;
	try {
	    bf = new BufferedReader(new InputStreamReader(System.in));
	    System.out.println("Dígame su altura en metros");
	    double altura = Double.parseDouble(bf.readLine());
	    System.out.println("Dígame su peso en kilogramos");
	    int peso = Integer.parseInt(bf.readLine());
	    
	    CalculadoraBMI calc = new CalculadoraBMI(altura, peso);
	    System.out.printf("Su resultado: %.2f\n", calc.resultado());
	    
	    System.out.println("VALORES BMI");
	    System.out.println("Bajo peso: menos de 18.5");
	    System.out.println("Normal: entre 18.5 y 24.9");
	    System.out.println("Sobrepeso: entre 25 y 29.9");
	    System.out.println("Obeso 30 o más");
	    
	} catch (IOException e) {
	    System.err.println("Error de entrada/salida");
	    e.printStackTrace();
	}
    }
}
