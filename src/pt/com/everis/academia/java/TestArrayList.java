package pt.com.everis.academia.java;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class TestArrayList {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(new Integer(1));
		list.add(2);

		System.out.println(list);
		
		List list2 = new ArrayList<>();
		list2.add(1);
		list2.add("A");
		list2.add("B");
		
		// Before Java 8
		list2.forEach(new Consumer<Object>() {
			
			@Override
			public void accept(Object n) {
				
				System.out.println(n);
			}
		});
		
		// After Java 8
		list.forEach((n) -> System.out.println(n));
		
		List list3 = new ArrayList<>();
		list3.add(1);
		list3.add("A");
		list3.add("B");
		list3.add('C');
		list.add(2);
		
		// Before Java 8
		list3.removeIf(new Predicate<Object>() {
			
			@Override
			public boolean test(Object n) {
				
				return n instanceof Integer;
			}
		});
		
		System.out.println(list3);
		
		// After Java 8
		list3.removeIf(n -> (n instanceof String));
		
		System.out.println(list);
		
	}
}
