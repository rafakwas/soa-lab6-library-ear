package controller;

import data.BookRepository;
import data.BookRepositoryRemote;
import model.Book;
import model.Pair;
import service.EntityManager;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.inject.Model;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ManagedBean
@RequestScoped
@Named("bookcontroller")
public class BookController {

    @EJB
    EntityManager entityManager;

    @EJB
    BookRepositoryRemote bookRepositoryRemote;

    private Book book;
    private List<Book> books;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void addBook() {
        book = new Book();
        book.setTitleList(Arrays.asList(new Pair("polski", "rzeka"), new Pair("angielski", "river")));
        book.setAuthorList(Arrays.asList("Andrzej Kołodziejko", "Bisurman Tatrzański", "Hędycwoż Międzyrzecki"));
        book.setIsbn("123-456-789");
        book.setReserved(false);
        System.out.println("Książka dodana");
        System.out.println(book);
        entityManager.persist(book);
    }

    public List<Book> getBooks() {
        return bookRepositoryRemote.getAllBooks();
    }
}