package pt.com.everis.academia.java;

import java.util.Arrays;
import java.util.HashMap;

public class TestHashMap {

	public static void main(String[] args) {

		HashMap<String, Object> map1 = new HashMap<>();
		map1.put("A", "1");
		map1.put("B", Arrays.asList("1","2"));
		
		System.out.println(map1);
		
		map1.clear();
		
		System.out.println(map1);
		
		HashMap<String, Object> map2 = new HashMap<>();
		map2.put("A", "1");
		map2.put("B", Arrays.asList("1","2"));
		
		System.out.println("A -> " + map2.get("A"));
		System.out.println("B -> " + map2.get("B"));
		
		HashMap<String, Object> map3 = new HashMap<>();
		map3.put("A", "1");
		map3.put("B", Arrays.asList("1","2"));
		
		System.out.println(map3);
	}
}
