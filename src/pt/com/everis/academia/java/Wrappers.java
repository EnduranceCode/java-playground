package pt.com.everis.academia.java;

public class Wrappers {
	
	/* Wrappers class can't be extended
	 * Compile error
	 * public class AcademiaFloat extends Float {}
	 */

	public static void main(String[] args) {
		Boolean boleanValue = new Boolean(true);
		System.out.println(boleanValue);
		
		Byte byteValue = new Byte((byte) 0);
		System.out.print(byteValue);
		
		Character charValue = new Character('a');
		System.out.println(charValue);
		
		Double doubleValue = new Double(3.14);
		System.out.println(doubleValue);
		
		Float floatValue = new Float(3.14f);
		System.out.println(floatValue);
		
		Integer intValue = new Integer(3);
		System.out.println(intValue);
		
		Long longValue = new Long(300);
		System.out.println(longValue);
		
		Short shortValue = new Short((short) 4);
		System.out.println(shortValue);
		
		System.out.println();
		
		System.out.println("Byte: Conversion methods output");
		System.out.println(byteValue.byteValue());
		System.out.println(byteValue.shortValue());
		System.out.println(byteValue.intValue());
		System.out.println(byteValue.longValue());
		System.out.println(byteValue.floatValue());
		System.out.println(byteValue.doubleValue());
		System.out.println();
		
		System.out.println("Short: Conversion methods output");
		System.out.println(shortValue.byteValue());
		System.out.println(shortValue.shortValue());
		System.out.println(shortValue.intValue());
		System.out.println(shortValue.longValue());
		System.out.println(shortValue.floatValue());
		System.out.println(shortValue.doubleValue());
		System.out.println();
		
		System.out.println("Integer: Conversion methods output");
		System.out.println(intValue.byteValue());
		System.out.println(intValue.shortValue());
		System.out.println(intValue.intValue());
		System.out.println(intValue.longValue());
		System.out.println(intValue.floatValue());
		System.out.println(intValue.doubleValue());
		System.out.println();
		
		System.out.println("Long: Conversion methods output");
		System.out.println(longValue.byteValue());
		System.out.println(longValue.shortValue());
		System.out.println(longValue.intValue());
		System.out.println(longValue.longValue());
		System.out.println(longValue.floatValue());
		System.out.println(longValue.doubleValue());
		System.out.println();
		
		System.out.println("Float: Conversion methods output");
		System.out.println(floatValue.byteValue());
		System.out.println(floatValue.shortValue());
		System.out.println(floatValue.intValue());
		System.out.println(floatValue.longValue());
		System.out.println(floatValue.floatValue());
		System.out.println(floatValue.doubleValue());
		System.out.println();
		
		System.out.println("Double: Conversion methods output");
		System.out.println(doubleValue.byteValue());
		System.out.println(doubleValue.shortValue());
		System.out.println(doubleValue.intValue());
		System.out.println(doubleValue.longValue());
		System.out.println(doubleValue.floatValue());
		System.out.println(doubleValue.doubleValue());
		System.out.println();
		
		System.out.println("valueOf() overload");
		System.out.println(Boolean.valueOf(true));
		System.out.println(Boolean.valueOf("true"));
	}
}
