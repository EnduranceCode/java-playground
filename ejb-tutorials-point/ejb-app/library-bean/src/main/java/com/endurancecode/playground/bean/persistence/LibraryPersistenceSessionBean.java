package com.endurancecode.playground.bean.persistence;

import com.endurancecode.playground.entity.Book;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class LibraryPersistenceSessionBean implements LibraryPersistenceSessionBeanRemote {

    private static final String NAMED_QUERY_FIND_ALL_BOOKS_NAMES = "Book.findAllNames";

    @PersistenceContext(unitName = "LibraryPU")
    private EntityManager entityManager;

    @Override
    public void addBook(Book book) {
        entityManager.persist(book);
    }

    @Override
    public List<String> getBooks() {
        return entityManager.createNamedQuery(NAMED_QUERY_FIND_ALL_BOOKS_NAMES, String.class).getResultList();
    }
}
