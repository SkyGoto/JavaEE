package test;

import model.Author;
import model.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import servers.BookServer;
import servers.Impl.BookServerImpl;
import util.HibernateUtil;

import java.sql.SQLException;

public class jdbctest {
    @Test
    public void demo(){
        Session session = HibernateUtil.getCurrentSession();
        Transaction tx = session.beginTransaction();

        Author author1 = new Author();
        author1.setName("测试姓名1");
        Author author2 = new Author();
        author2.setName("测试姓名2");

        Book book1 = new Book();
        book1.setIsbn("Test_isbn1");
        Book book2 = new Book();
        book2.setIsbn("Test_isbn2");
        Book book3 = new Book();
        book3.setIsbn("Test_isbn3");

        book1.setAuthor(author1);
        book2.setAuthor(author1);
        book3.setAuthor(author2);
        author1.getBooks().add(book1);
        author1.getBooks().add(book2);
        author2.getBooks().add(book3);

        session.save(book1);
        session.save(book2);
        session.save(book3);
        session.save(author1);
        session.save(author2);


        tx.commit();
    }


    @Test
    public void demo1(){
        Session session = HibernateUtil.getCurrentSession();
        Transaction tx = session.beginTransaction();

        Author author1 = new Author();
        author1.setName("测试姓名4");

        Book book1 = new Book();
        book1.setIsbn("Test_isbn6");
        author1.getBooks().add(book1);
        book1.setAuthor(author1);

        session.save(book1);

        tx.commit();
    }
    @Test
    public  void Demo2(){
        String pattern = "\\b^['_a-z0-9-\\+]+(\\.['_a-z0-9-\\+]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*\\.([a-z]{2}|aero|arpa |asia|biz|com|coop|edu|gov|info|int|jobs|mil|mobi|museum|name|nato|net|org|pro|tel|travel|xxx)$\\b";
        String email="wangyi@sina.qq.com";

        boolean matches = email.matches(pattern);

        System.out.println(matches);
    }
    @Test
    public void Demo3(){
        Author author = new Author("w23wefq","weewqr","werqwe@qq.com");
        Session session = HibernateUtil.openSession();
        Transaction tx = session.beginTransaction();
        Book book = session.get(Book.class, "778w3234rw");
        session.delete(book);
        tx.commit();
        session.close();
    }

    @Test
    public void Demo4(){
        BookServer server = new BookServerImpl();
        try {
            server.GCDelete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
