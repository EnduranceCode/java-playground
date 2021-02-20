package pt.com.everis.academia.java;

import java.util.Stack;

public class TestStack {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		
		Stack list1 = new Stack();
		list1.push(1);
		list1.push("A");
		list1.push("B");
		
		System.out.println(list1);
		

		Stack list2 = new Stack();
		list2.push(1);
		list2.push("A");
		list2.push("B");
		
		System.out.println(list2.peek());
		
		Stack list3 = new Stack();
		list3.push(1);
		list3.push("A");
		list3.push("B");
		
		System.out.println(list3.pop());
		
		System.out.println(list3);
	}

}
