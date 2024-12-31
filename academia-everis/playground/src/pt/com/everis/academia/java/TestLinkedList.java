package pt.com.everis.academia.java;

import java.util.LinkedList;
import java.util.List;

public class TestLinkedList {
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		
		List list1 = new LinkedList<>();
		list1.add(1);
		list1.add("A");
		list1.add("B");
		
		System.out.println(list1.contains("A"));
		
		List list2 = new LinkedList<>();
		list2.add(1);
		list2.add("A");
		list2.add("B");
		
		list2.remove("A");
		
		System.out.println(list2);
		
		List list3 = new LinkedList<>();
		list3.add(1);
		list3.add("A");
		list3.add("B");
		
		System.out.println(list3.size());
	}
}
