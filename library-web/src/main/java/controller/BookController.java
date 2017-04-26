package controller;

import data.BookRepositoryRemote;
import model.Book;
import model.Pair;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import java.util.Arrays;
import java.util.List;

@ManagedBean
@RequestScoped
@Named("bookcontroller")
public class BookController {

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
        bookRepositoryRemote.persist(book);
    }

    public List<Book> getBooks() {
        return bookRepositoryRemote.getAllBooks();
    }

    public void reserveBook(Book book) {
        bookRepositoryRemote.reserve(book);
    }
}