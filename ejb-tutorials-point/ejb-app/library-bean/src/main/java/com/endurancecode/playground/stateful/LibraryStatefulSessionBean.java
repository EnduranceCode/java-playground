package com.endurancecode.playground.stateful;

import jakarta.ejb.Stateful;
import java.util.ArrayList;
import java.util.List;

@Stateful
public class LibraryStatefulSessionBean implements LibraryStatefulSessionBeanRemote {

    List<String> bookShelf;

    public LibraryStatefulSessionBean() {
        this.bookShelf = new ArrayList<>();
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
