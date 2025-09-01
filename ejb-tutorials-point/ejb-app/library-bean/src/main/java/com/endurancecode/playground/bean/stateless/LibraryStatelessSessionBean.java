package com.endurancecode.playground.bean.stateless;

import jakarta.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class LibraryStatelessSessionBean implements LibraryStatelessSessionBeanRemote {

    List<String> bookShelf;

    public LibraryStatelessSessionBean() {
        bookShelf = new ArrayList<>();
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
