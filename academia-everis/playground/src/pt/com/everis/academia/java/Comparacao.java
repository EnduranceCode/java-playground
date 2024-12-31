package pt.com.everis.academia.java;

public class Comparacao {
	
public static void main(String[] args) {
	
	Pai obj1 = new Pai();
	Filho obj2 = new Filho();
	
	System.out.println("obj1 instanceof Pai: " + (obj1 instanceof Pai));
	
	System.out.println("obj2 instanceof Filho: " + (obj2 instanceof Filho));
	
	System.out.println("obj1 instanceof Interface: " + (obj1 instanceof Interface));
	
	System.out.println("obj2 instance of Pai: " + (obj2 instanceof Pai));
	
	System.out.println("obj2 instance of Filho: " + (obj2 instanceof Filho));
	
	System.out.println("obj2 instance of Interface: " + (obj2 instanceof Interface));
}

}
