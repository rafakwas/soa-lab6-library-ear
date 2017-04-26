package service;

import model.Book;
import utils.IOUtils;

import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Remote(EntityManager.class)
public class BookManager implements EntityManager {
    private static final String BOOKSTORE_PATH = "bookstore.xml";

    @Override
    public void rent(Book book) {

    }

    @Override
    public void reserve(Book book) {

    }

    @Override
    public void returning(Book book) {

    }

    @Override
    public void persist(Book book) {
        IOUtils.addBook(book);
    }
}
