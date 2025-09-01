package com.endurancecode.playground.bean.stateless;

import jakarta.ejb.Remote;
import java.util.List;

@Remote
public interface LibraryStatelessSessionBeanRemote {

    /**
     * Adds a book to the library.
     *
     * @param bookName The name of the book to add.
     */
    void addBook(String bookName);

    /**
     * Retrieves the list of books in the library.
     *
     * @return A list of book names.
     */
    List<String> getBooks();
}
