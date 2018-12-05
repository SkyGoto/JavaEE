package servers.Impl;

import dao.BookDao;
import dao.Impl.BookDaoImpl;
import model.Author;
import model.Book;
import model.Lend;
import servers.BookServer;

import java.sql.SQLException;
import java.util.List;

public class BookServerImpl implements BookServer {
    private BookDao bookDao;

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }
    public BookServerImpl() {}

    @Override
    public void insertBook(Book book, Author author) throws SQLException, ClassNotFoundException {
        bookDao.insertBook(book,author);
    }

    @Override
    public List<Book> searchAll() throws SQLException, ClassNotFoundException {
        return bookDao.searchAll();
    }

    @Override
    public void updateBook(Book book) throws SQLException, ClassNotFoundException {
        bookDao.updateBook(book);
    }

    @Override
    public void deleteBookByisbn(String isbn) throws SQLException, ClassNotFoundException {
        bookDao.deleteBookByisbn(isbn);
    }

    @Override
    public List<Book> searchBooks(String title) throws SQLException, ClassNotFoundException {
        return bookDao.searchBooks(title);
    }

    @Override
    public Book searchBook(String isbn) throws SQLException, ClassNotFoundException {
        return bookDao.searchBook(isbn);
    }

    @Override
    public Author searchAuthor(String name) throws SQLException, ClassNotFoundException {
        return bookDao.searchAuthor(name);
    }

    @Override
    public void GCDelete() throws SQLException {
        bookDao.GCDelete();
    }

    @Override
    public List<Book> searchLendBook() {
        return bookDao.searchLendBook();
    }

    @Override
    public Book toLendBook(String isbn) {
        return bookDao.toLendBook(isbn);
    }

    @Override
    public Book lendedBook(String isbn) {
        return bookDao.lendedBook(isbn);
    }

    @Override
    public List<Book> seeLendBook() {
        return bookDao.seeLendBook();
    }


}
