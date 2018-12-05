package servers;

import model.Author;
import model.Book;
import model.Lend;

import java.sql.SQLException;
import java.util.List;

public interface BookServer {
    void insertBook(Book book, Author author) throws SQLException, ClassNotFoundException;
    List<Book> searchAll() throws SQLException, ClassNotFoundException;
    void updateBook(Book book) throws SQLException, ClassNotFoundException;
    void deleteBookByisbn(String isbn) throws SQLException, ClassNotFoundException;
    List<Book> searchBooks(String title) throws SQLException, ClassNotFoundException;
    Book searchBook(String isbn)throws SQLException, ClassNotFoundException;
    Author searchAuthor(String name)throws SQLException, ClassNotFoundException;
    void GCDelete() throws SQLException;


    List<Book> searchLendBook();

    Book toLendBook(String isbn);

    Book lendedBook(String isbn);

    List<Book> seeLendBook();
}
