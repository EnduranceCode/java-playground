package pt.com.everis.academia.java;

import java.util.TreeSet;

public class TestTreeSet {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		
		TreeSet set1 = new TreeSet<>();
		set1.add(100);
		set1.add(200);
		set1.add(300);
		set1.add(400);
		set1.add(500);
		set1.add(600);
		
		System.out.println(set1.headSet(300));
		
		TreeSet set2 = new TreeSet<>();
		set2.add(100);
		set2.add(200);
		set2.add(300);
		set2.add(400);
		set2.add(500);
		set2.add(600);
		
		System.out.println(set2.tailSet(300));
		
		TreeSet set3 = new TreeSet<>();
		set3.add(100);
		set3.add(200);
		set3.add(300);
		set3.add(400);
		set3.add(500);
		set3.add(600);
		
		System.out.println(set3.subSet(100, 450));
	}
}
