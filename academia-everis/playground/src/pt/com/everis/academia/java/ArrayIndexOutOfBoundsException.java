package pt.com.everis.academia.java;


import java.util.ArrayList;
import java.util.List;

public class ArrayIndexOutOfBoundsException {

	public static void main(String[] args) {

		List<String> myArray = new ArrayList<>();
		myArray.add("Valor 001");
		myArray.add("Valor 002");
		myArray.add("Valor 003");
		myArray.add("Valor 004");
		myArray.add("Valor 005");
		
		myArray.get(-1);
	}
}
