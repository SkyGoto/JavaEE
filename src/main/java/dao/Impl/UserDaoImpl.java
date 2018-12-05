package dao.Impl;

import dao.UserDao;
import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import util.HibernateUtil;
import util.SqlUtil;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.List;

public class UserDaoImpl implements UserDao {

    public UserDaoImpl() {}

    @Override
    public User userExist(String name, String password) throws SQLException, ClassNotFoundException {
//        Session session = HibernateUtil.openSession();
//        Transaction tx = session.beginTransaction();
//        User user = session.get(User.class,name);
//        String str = user.getPassword();
        //-----------------
//        String driver = "com.mysql.jdbc.Driver";
//        String url = "jdbc:mysql://127.0.0.1:3306/test1";
//        String user = "root";
//        String pwd = "zum";
//        try {
//            Class.forName(driver);
//            Connection conn = DriverManager.getConnection(url, user, pwd);
//            Statement statement = conn.createStatement();
//            String sql = "select * from user";
//            ResultSet rs = statement.executeQuery(sql);
//            rs.close();
//            conn.close();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//        return true;
        System.out.println("---------------ok---------------");
        Session session = HibernateUtil.openSession();
        Transaction tx = session.beginTransaction();

        User user = session.get(User.class,name);

        tx.commit();
        session.close();
        //--------------
//        connection = SqlUtil.getConnection();
//        String sql = "SELECT * FROM user WHERE name= ?";
//        PreparedStatement p = null;
//        p = connection.prepareStatement(sql);
//        p.setString(1,name);
//        ResultSet resultSet = p.executeQuery();
//        resultSet.next();
       return user;
//        resultSet.close();
//        SqlUtil.closeConnection(connection);
    }

    @Override
    public User addUser(User user) throws SQLException {
        Session session = HibernateUtil.getCurrentSession();
        Transaction tx = session.beginTransaction();
        User user1 = session.get(User.class,user.getName());
        if (user1 != null) return user1;
        session.save(user);
        tx.commit();
        return user;
    }

    @Override
    public List<User> listUser() throws SQLException {
        Session session = HibernateUtil.getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("FROM User ");
        List<User> list = query.list();
        tx.commit();
        return list ;
    }

    @Override
    public User searchUser(String name) {
        Session session = HibernateUtil.openSession();
        Transaction tx = session.beginTransaction();

        User user = session.get(User.class,name);

        tx.commit();
        session.close();
        return user;
    }

    @Override
    public void updateUser(User user) {
        Session session = HibernateUtil.getCurrentSession();
        Transaction tx = session.beginTransaction();
        User user1 = session.get(User.class,user.getName());
        user1.setPassword(user.getPassword());
        session.update(user1);
        tx.commit();
    }

    @Override
    public void deleteUserByName(String delUser) {
        Session session = HibernateUtil.getCurrentSession();
        Transaction tx = session.beginTransaction();
        User user = session.get(User.class, delUser);
        session.delete(user);
        tx.commit();
    }

    @Override
    public List<User> searchUsers(String name) {
        Session session = HibernateUtil.getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from User WHERE name LIKE :names");
        query.setParameter("names", "%"+name+"%");
        List<User> list = query.list();
        tx.commit();
        return list;
    }


}
