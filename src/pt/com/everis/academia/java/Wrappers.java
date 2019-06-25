package pt.com.everis.academia.java;

public class Wrappers {

	public static void main(String[] args) {
		Boolean boleanValue = new Boolean(true);
		System.out.println(boleanValue);
		
		Byte byteValue = new Byte((byte) 0);
		System.out.print(byteValue);
		
		Character charValue = new Character('a');
		System.out.println(charValue);
		
		Double doubleValue = new Double(3.14);
		System.out.println(doubleValue);
		
		Float floatValues = new Float(3.14f);
		System.out.println(floatValues);
		
		Integer intValue = new Integer(3);
		System.out.println(intValue);
		
		Long longValue = new Long(300);
		System.out.println(longValue);
		
		Short shortValue = new Short((short) 4);
		System.out.println(shortValue);
	}
}
