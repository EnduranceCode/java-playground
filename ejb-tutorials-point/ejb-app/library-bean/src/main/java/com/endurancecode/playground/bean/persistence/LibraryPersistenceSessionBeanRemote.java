package com.endurancecode.playground.bean.persistence;

import com.endurancecode.playground.entity.Book;
import jakarta.ejb.Remote;
import java.util.List;

@Remote
public interface LibraryPersistenceSessionBeanRemote {

    /**
     * Adds a book to the library.
     *
     * @param book The book entity to add.
     */
    void addBook(Book book);

    /**
     * Retrieves the list of books in the library.
     *
     * @return A list of book names.
     */
    List<String> getBooks();
}
