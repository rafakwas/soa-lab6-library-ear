package utils;

import model.Book;
import model.Bookstore;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class IOUtils {
    private static final String BOOKSTORE_PATH = "bookstore.xml";

    public static Bookstore getBookstore() {
        Bookstore bookstore = null;
        File file = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Bookstore.class);
            file = new File(BOOKSTORE_PATH);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            bookstore = (Bookstore) jaxbUnmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
            System.out.println("Błąd przy wczytywaniu biblioteki: " + e.getMessage());
        }
        return bookstore;
    }

    public static Bookstore addBook(Book book) {
        Bookstore bookstore = getBookstore();
        if (bookstore == null) {
            bookstore = new Bookstore();
            bookstore.setBookList(new ArrayList<Book>());
        }
        List<Book> bookList = bookstore.getBookList();
        bookList.add(book);
        bookstore.setBookList(bookList);
        write(BOOKSTORE_PATH,bookstore);

        return bookstore;
    }

    private static void write(final String BOOKSTORE_PATH,final Bookstore bookstore) {

        JAXBContext jc = null;
        File file = null;
        try {
            jc = JAXBContext.newInstance(Bookstore.class);
            file = new File(BOOKSTORE_PATH);
            Marshaller jaxbMarshaller = jc.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            jaxbMarshaller.marshal(bookstore,file);
            jaxbMarshaller.marshal(bookstore,System.out);
        }
        catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
