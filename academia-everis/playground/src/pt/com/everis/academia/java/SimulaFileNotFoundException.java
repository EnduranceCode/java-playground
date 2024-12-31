package pt.com.everis.academia.java;

import java.io.BufferedReader;
import java.io.FileReader;

public class SimulaFileNotFoundException {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
			
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader("/temp/arq.txt"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
