package data;

import model.Book;
import model.Bookstore;
import service.EntityManager;
import utils.IOUtils;

import javax.ejb.*;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static javax.ejb.LockType.READ;

@Singleton
@Startup
@Remote(BookRepositoryRemote.class)
public class BookRepository implements BookRepositoryRemote {
    private static final String BOOKSTORE_PATH = "bookstore.xml";

    private List<Book> bookList;

    public List<Book> getAllBooks() {
        return IOUtils.getBookstore().getBookList();
    }

    @Lock
    public List<Book> getBookList() {
        return getAllBooks();
    }




}
