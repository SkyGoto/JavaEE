package dao.Impl;

import dao.BookDao;
import model.Author;
import model.Book;
import model.Lend;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;
import util.SqlUtil;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookDaoImpl implements BookDao {
    public BookDaoImpl() {}

    /**
     * 添加图书
     * @param book
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public void insertBook(Book book , Author author) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getCurrentSession();
        Transaction tx = session.beginTransaction();
        Author at = session.get(Author.class,author.getName());
        author  = at==null?author:at;
        book.setAuthor(author);
        author.getBooks().add(book);
//        session.save(author);
        session.save(book);  //可注释
        tx.commit();
//        c3p0连接方法
//        QueryRunner runner = new QueryRunner(SqlUtil.getDataSource());
//        runner.update("INSERT INTO book value(?,?,?,?,?)",book.getIsbn(),
//                book.getTitle(),book.getAuthor(),book.getPrice(),book.getInfo());
//        传统方法
//        String sql = "INSERT INTO book value(?,?,?,?,?)";
//        Connection connection = SqlUtil.getConnection();
//        String sql = "INSERT INTO book value(?,?,?,?,?)";
//        PreparedStatement p = connection.prepareStatement(sql);
//        p.setString(1, book.getIsbn());
//        p.setString(2,book.getTitle());
//        p.setString(3, book.getAuthor());
//        p.setInt(4,book.getPrice());
//        p.setString(5,book.getInfo());
//        p.executeUpdate();
//        SqlUtil.closeConnection(connection);
    }


    /**
     * 查询全部
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public List<Book> searchAll() throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("FROM Book");
        List<Book> list = query.list();
        tx.commit();
        System.out.println(list.get(0).getAuthor().getEmail());
        return list ;
//        System.out.println(list.get(1).getAuthor());
//        System.out.println("------------------------");
//        System.out.println(list.get(1).getAuthor().getEmail());
//        c3p0连接方法
//        QueryRunner runner = new QueryRunner(SqlUtil.getDataSource());
//        String sql = "SELECT * FROM book";
//        return runner.query(sql,new BeanListHandler<Book>(Book.class));
//        传统方法
//        List<Book> list = new ArrayList<Book>();
//        Connection connection = SqlUtil.getConnection();
//
//        PreparedStatement p = connection.prepareStatement(sql);
//        ResultSet resultSet = p.executeQuery();
//        getResult(list, resultSet);
//        resultSet.close();
//        SqlUtil.closeConnection(connection);
//        return list;

    }


    /**
     * 更新图书
     * @param book
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public void updateBook(Book book) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.openSession();
        Transaction tx = session.beginTransaction();
        Author author = session.get(Author.class,book.getAuthor().getName());
        author = author==null?book.getAuthor():author;
//        此处可以进行优化
        book.setAuthor(null);
        author.getBooks().add(book);
        book.setAuthor(author);
        session.update(book);
        tx.commit();
        session.close();
//        int query = session.createQuery("update Book  set Book.price = :prices WHERE Book.isbn = :isbns ").executeUpdate();
//        query.setParameter("prices",book.getPrice());
//        query.setParameter("isbns",book.getIsbn());

//        Book book1 = session.get(Book.class,book.getIsbn());
//        book1.setPrice(book.getPrice());
//        c3p0连接方法
//        QueryRunner runner = new QueryRunner(SqlUtil.getDataSource());
//        runner.update("UPDATE book SET title = ?,author = ? ,price = ? , info = ? WHERE isbn = ?",
//                book.getTitle(),book.getAuthor(),book.getPrice(),
//                book.getInfo(),book.getIsbn());

//        传统方法
//        String sql = "UPDATE book SET title = ?,author = ? ,price = ? , info = ? WHERE isbn = ?";
//        PreparedStatement p = connection.prepareStatement(sql);
//        p.setString(1,book.getTitle());
//        p.setString(2, book.getAuthor());
//        p.setInt(3,book.getPrice());
//        p.setString(4, book.getInfo());
//        p.setString(5, book.getIsbn());
//        System.out.println(book.getInfo());
//        p.executeUpdate();
//        SqlUtil.closeConnection(connection);
    }


    /**
     * 删除图书
     * @param isbn
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public void deleteBookByisbn(String isbn) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.openSession();
        Transaction tx = session.beginTransaction();
        Book book = session.get(Book.class, isbn);
        session.delete(book);
        tx.commit();
        session.close();

//        c3p0连接方法
//        QueryRunner runner = new QueryRunner(SqlUtil.getDataSource());
//        runner.update("DELETE FROM book WHERE isbn = ?",isbn);

//        传统方法
//        Connection connection = SqlUtil.getConnection();
//        String sql = "DELETE FROM book WHERE isbn = ?";
//        PreparedStatement p = connection.prepareStatement(sql);
//        p.setString(1, isbn);
//        p.executeUpdate();
    }


    /**
     * 模糊查询
     * @param title
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public List<Book> searchBooks(String title) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getCurrentSession();
        Transaction tx = session.beginTransaction();

        System.out.println("title = "+title);
        Query query = session.createQuery("from Book as Book WHERE Book.author.name LIKE :author OR Book.title LIKE :title OR CAST(Book.price as string ) LIKE :price OR Book.author.email LIKE :email OR Book.author.tel LIKE :tel");
        query.setParameter("author", "%"+title+"%");
        query.setParameter("title", "%"+title+"%");
        query.setParameter("price", "%"+title+"%");
        query.setParameter("email", "%"+title+"%");
        query.setParameter("tel", "%"+title+"%");
        List<Book> list = query.list();
//        session.createQuery("FROM Author ");
        System.out.println(list.get(0).getAuthor().getEmail());

        tx.commit();
        System.out.println("list = "+ list);
        return list;
//        c3p0连接方法
//        QueryRunner runner = new QueryRunner(SqlUtil.getDataSource());
//        return runner.query("SELECT * FROM book WHERE title like ? OR author LIKE ? OR price LIKE ?",
//                new BeanListHandler<Book>(Book.class),
//                "%"+title+"%","%"+title+"%","%"+title+"%");

//        传统方法
//        List<Book> list = new ArrayList<Book>();
//        Connection connection = SqlUtil.getConnection();
//        String sql = "SELECT * FROM book WHERE title like ? OR author LIKE ? OR price LIKE ?";
//        PreparedStatement p = connection.prepareStatement(sql);
//        p.setString(1, "%"+title+"%");
//        p.setString(2, "%"+title+"%");
//        p.setString(3, "%"+title+"%");
//        ResultSet resultSet = p.executeQuery();
//        getResult(list, resultSet);
//        resultSet.close();
//        return list;
    }


    /**
     * 精准查询书籍
     * @param isbn
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public Book searchBook(String isbn) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.openSession();
        Transaction tx = session.beginTransaction();

        Book book = session.get(Book.class, isbn);


        tx.commit();
        session.close();

        return book;

////                c3p0连接方法
////        QueryRunner runner = new QueryRunner(SqlUtil.getDataSource());
//        /*runner.query("SELECT * FROM book WHERE isbn=?", new ResultSetHandler<Book>() {
//
//            @Override
//            public Book handle(ResultSet resultSet) throws SQLException {
//                Book book = new Book();
//                while (resultSet.next()){
//                    book.setIsbn(resultSet.getString(1));
//                    book.setTitle(resultSet.getString(2));
//                    book.setAuthor(resultSet.getString(3));
//                    book.setPrice(resultSet.getInt(4));
//                    book.setInfo(resultSet.getString(5));
//                }
//                return book;
//            }
//        }, isbn);*/
//        return runner.query("SELECT * FROM book WHERE isbn=?",new BeanHandler<Book>(Book.class),isbn);

//        传统方法
//        Connection connection = SqlUtil.getConnection();
//        String sql = "SELECT * FROM book WHERE isbn=?";
//        PreparedStatement p = connection.prepareStatement(sql);
//        p.setString(1,isbn );
//        ResultSet resultSet = p.executeQuery();
//        resultSet.next();
//        Book book = new Book(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4),resultSet.getString(5));
//        resultSet.close();
//        return book;
    }

    /**
     * 精准查询作者
     * @param name
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public Author searchAuthor(String name) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.openSession();
        Transaction tx = session.beginTransaction();

        Author author = session.get(Author.class, name);


        tx.commit();
        session.close();

        return author;
    }

    /**
     * 清空无效的作者
     * @throws SQLException
     */
    @Override
    public void GCDelete() throws SQLException {
        String sql = "DELETE FROM Author WHERE name not in (SELECT author FROM book)";
        Session session = HibernateUtil.openSession();
        Transaction tx = session.beginTransaction();
        System.out.println(sql);
        Query query = session.createSQLQuery(sql);
        query.executeUpdate();
        tx.commit();
        session.close();

    }

    @Override
    public List<Book> searchLendBook() {
        Session session = HibernateUtil.openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("FROM Book as book WHERE book.isbn NOT IN (SELECT lend.isbn FROM Lend as lend)");
        List<Book> list = query.list();
        tx.commit();
        session.close();
        return list;
    }

    @Override
    public Book toLendBook(String isbn) {
        Session session = HibernateUtil.getCurrentSession();
        Transaction tx = session.beginTransaction();
        Book book = session.get(Book.class,isbn);
        Lend lend = new Lend(book.getIsbn(),book.getTitle(),book.getIsbn(),new Date());
        session.save(lend);
        tx.commit();
        return book;
    }

    @Override
    public Book lendedBook(String isbn) {
        Session session = HibernateUtil.getCurrentSession();
        Transaction tx = session.beginTransaction();
        Book book = session.get(Book.class,isbn);
        Lend lend = new Lend(book.getIsbn(),book.getTitle(),book.getIsbn(),new Date());
        session.delete(lend);
        tx.commit();
        return book;
    }

    @Override
    public List<Book> seeLendBook() {
        Session session = HibernateUtil.getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("FROM Book as book WHERE book.isbn IN (SELECT lend.isbn FROM Lend as lend)");
        List<Book> list = query.list();
        tx.commit();
        return list ;
    }


//    private void getResult(List<Book> list, ResultSet resultSet) throws SQLException {
//        while (resultSet.next()) {
//            list.add(new Book(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4),resultSet.getString(5)));
//        }
//    }
}
