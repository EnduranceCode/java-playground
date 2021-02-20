package pt.com.everis.academia.java;

import java.util.ArrayDeque;

public class TestArrayDeque {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {

		ArrayDeque queue1 = new ArrayDeque<>();
		queue1.addFirst(new Pessoa("António", 32));
		queue1.addFirst(new Pessoa("Fabio", 25));
		queue1.addFirst(new Pessoa("João", 16));
		queue1.addFirst(new Pessoa("José", 32));
		queue1.addFirst(new Pessoa("Maria", 10));
		
		System.out.println(queue1.peek());
		
		ArrayDeque queue2 = new ArrayDeque<>();
		queue2.addFirst(new Pessoa("António", 32));
		queue2.addFirst(new Pessoa("Fabio", 25));
		queue2.addFirst(new Pessoa("João", 16));
		queue2.addFirst(new Pessoa("José", 32));
		queue2.addLast(new Pessoa("Maria", 10));
		
		System.out.println(queue2.getLast());
		
		ArrayDeque queue3 = new ArrayDeque<>();
		queue3.addFirst(new Pessoa("António", 32));
		queue3.addFirst(new Pessoa("Fabio", 25));
		queue3.addFirst(new Pessoa("João", 16));
		queue3.addFirst(new Pessoa("José", 32));
		queue3.addLast(new Pessoa("Maria", 10));
		
		System.out.println(queue3.getFirst());
	}
}
