package pt.com.everis.academia.java;

import java.util.PriorityQueue;
import java.util.Queue;

public class Pessoa implements Comparable<Pessoa> {

	private String nome;
	private Integer idade;
	
	public Pessoa(String nome, Integer idade) {
		
		this.nome = nome;
		this.idade = idade;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Integer getIdade() {
		return idade;
	}
	
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	
	@Override
	public int compareTo(Pessoa o) {
		return o.getIdade().compareTo(getIdade());
	}
	
	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", idade=" + idade + "]";
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {

		Queue queue = new PriorityQueue<>();
		queue.add(new Pessoa("António", 32));
		queue.add(new Pessoa("Fabio", 25));
		queue.add(new Pessoa("João", 16));
		queue.add(new Pessoa("José", 32));
		queue.add(new Pessoa("Maria", 10));
		
		System.out.println(queue.peek());
	}

}
