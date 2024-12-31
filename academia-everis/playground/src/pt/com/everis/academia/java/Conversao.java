package pt.com.everis.academia.java;

public class Conversao {
	
	public static void main(String[] args) {
		
		double valor = 3.14;
		/*
		 *  Compile error
		 *  int inteiro = valor;
		 */
		int inteiro = (int) valor; // Casting is the solution but information is lost, the store information is the integer part
		
		/* Compile error
		 * int pi = 3.14;
		 */
		
		double valorDois = 5;
		/*
		 * Compile error
		 * int i = valorDois; 
		 */
		int i = (int) valorDois; // Casting is the solution but information is lost, the store information is the integer part
		
		long x = 1000;
		/* Compile error
		 * int y = x; // Compile error
		 */
		int y = (int) x; // Casting is the solution but information might be lost
		
		int xx = 5;
		double yy = xx; 
		
	}
}
