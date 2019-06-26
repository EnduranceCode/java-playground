package pt.com.everis.academia.java;

import java.util.Arrays;

public class ArrayTests {

	public static void main(String[] args) {

		int [] array = new int[5];
		array[0] = 1;
		array[1] = 2;
		array[2] = 3;
		array[3] = 4;
		array[4] = 5;
		
		System.out.println(array);
		
		System.out.println(Arrays.toString(array));
		

		int [] array2 = new int[5];
		array2[0] = 1;
		array2[1] = 3;
		array2[2] = 5;
		array2[3] = 2;
		array2[4] = 4;
		
		Arrays.sort(array2);
		
		System.out.println(Arrays.toString(array2));
	}
}
