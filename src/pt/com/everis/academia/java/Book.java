package pt.com.everis.academia.java;

public class Book {
	
	private String isbn;
	
	public Book(String isbn) {
		
		this.isbn = isbn;
	}
	
	public String getISBN() {
		
		return isbn;
	}
	
	public void setISBN(String isbn) {
		
		this.isbn = isbn;
	}
	
	public static void main(String[] args) {
		
		Book book1 = new Book("62");
		Book book2 = new Book("62");
		
		System.out.println(book1.equals(book2));
	}
}
