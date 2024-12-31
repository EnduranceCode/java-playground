package pt.com.everis.academia.java;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class TestVector {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {

		List list1 = new Vector<>();
		list1.add(1);
		list1.add("A");
		list1.add("B");
		
		list1.clear();
		
		System.out.println(list1);
		
		List list2 = new Vector<>();
		list2.add(1);
		list2.add("A");
		list2.add("B");
		
		System.out.println(list2.isEmpty());
		
		List list3 = new Vector<>();
		list3.add(1);
		list3.add("A");
		list3.add("B");
		
		Object[] array = list3.toArray();
		
		System.out.println(Arrays.toString(array));
	}
}
