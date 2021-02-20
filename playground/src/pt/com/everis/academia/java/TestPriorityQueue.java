package pt.com.everis.academia.java;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class TestPriorityQueue {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {

		Queue queue = new PriorityQueue<>(new Comparator<Pessoa>() {

			@Override
			public int compare(Pessoa o1, Pessoa o2) {
				
				return o2.getIdade().compareTo(o1.getIdade());
			}
		});
		
		queue.add(new Pessoa("António", 32));
		queue.add(new Pessoa("Fabio", 25));
		queue.add(new Pessoa("João", 16));
		queue.add(new Pessoa("José", 32));
		queue.add(new Pessoa("Maria", 10));

		System.out.println(queue.peek());
	}
}
