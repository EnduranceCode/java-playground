package pt.com.everis.academia.java;

import java.util.Arrays;

public class Parent implements Comparable<Parent> {
	
	private Integer id;
	
	public Parent(Integer id) {
		super();
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
	public int compareTo(Parent otherParent) {
		return id.compareTo(otherParent.getId());
	}
	
	@Override
	public String toString() {
		return "Pai id=" + id + "]";
	}
	
	public static void main(String[] args) {
		
		Parent[] array = new Parent[5];
		
		array[0] = new Parent(1);
		array[1] = new Parent(3);
		array[2] = new Parent(5);
		array[3] = new Parent(2);
		array[4] = new Parent(4);
		
		Arrays.sort(array);
		
		System.out.println(Arrays.toString(array));
	}
}
