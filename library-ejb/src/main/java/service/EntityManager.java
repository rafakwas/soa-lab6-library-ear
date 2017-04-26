package service;

import model.Book;

public interface EntityManager {
    void rent(Book book);
    void reserve(Book book);
    void returning(Book book);
    void persist(Book book);
}
