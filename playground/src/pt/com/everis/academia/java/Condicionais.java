package pt.com.everis.academia.java;

public class Condicionais {
	
	public static void main(String[] args) {
		
		int value1 = 1;
		int value2 = 2;
		int result;
		boolean someCondition = true;
		
		if ((value1 == 1) && (value2 ==2)) {
			System.out.println("value1 is 1 and value2 is 2");
		}
		
		if ((value1 == 1) || (value2 == 2)) {
			System.out.println("value1 is 1 or value2 is 2");
		}
		
		result = someCondition ? value1 : value2;
				
		System.out.println(result);
	}
}
