package pt.com.everis.academia.java;

public class BoxingUnboxing {
	
	public static void main(String[] args) {
		
		Integer i = new Integer(125);
		Integer j = i;
		
		System.out.println("i=" + i);
		System.out.println("j=" + j);
		
		
		System.out.println(i == j); // Outputs "true", it's the same object
		
		i++;
		
		System.out.println("i = " + i);
		System.out.println("j = " + j);
		System.out.println(i == j); // Outputs "false", are no longer the same object;
	}

}
