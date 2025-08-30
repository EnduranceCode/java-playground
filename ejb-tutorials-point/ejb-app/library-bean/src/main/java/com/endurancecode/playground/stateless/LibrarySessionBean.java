package com.endurancecode.playground.stateless;

import jakarta.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class LibrarySessionBean implements LibrarySessionBeanRemote {

    List<String> bookShelf;

    public LibrarySessionBean() {
        bookShelf = new ArrayList<String>();
    }

    @Override
    public void addBook(String bookName) {
        bookShelf.add(bookName);
    }

    @Override
    public List<String> getBooks() {
        return bookShelf;
    }
}
