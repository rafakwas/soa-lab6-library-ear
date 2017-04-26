package model;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.List;


@XmlRootElement(name = "book")
@XmlType(propOrder = { "authorList", "titleList", "isbn", "reserved"})

public class Book implements Serializable {

    List<String> authorList;
    List<Pair> titleList;
    String isbn;
    boolean isReserved;

    @XmlElement(name = "author")
    public List<String> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<String> authorList) {
        this.authorList = authorList;
    }

    @XmlElement(name = "title")
    public List<Pair> getTitleList() {
        return titleList;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setTitleList(List<Pair> titleList) {
        this.titleList = titleList;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @XmlElement(name = "reserved")
    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    @Override
    public String toString() {
        return "Book{" +
                "authorList=" + authorList +
                ", titleList=" + titleList +
                ", isbn='" + isbn + '\'' +
                ", isReserved=" + isReserved +
                '}';
    }


}
