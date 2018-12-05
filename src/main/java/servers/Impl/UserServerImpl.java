package servers.Impl;

import dao.Impl.UserDaoImpl;
import dao.UserDao;
import model.User;
import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import servers.UserServer;

import javax.servlet.ServletContext;
import java.sql.SQLException;
import java.util.List;

public class UserServerImpl implements UserServer {

    private UserDao userDao ;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserServerImpl() {
        System.out.println("UserServerImpl 初始化");
    }

    @Override
    public User userExist(String name, String password) throws SQLException, ClassNotFoundException {
        System.out.println(userDao+"----------------------");
        return userDao.userExist(name, password);
    }

    @Override
    public User addUser(User user) throws SQLException {
//        ServletContext sc = ServletActionContext.getServletContext();
//        WebApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sc);
//        UserDao userDao = (UserDaoImpl) ac.getBean("daoUserImpl");
        System.out.println(userDao+"----------------------");
        return userDao.addUser(user);
    }

    @Override
    public List<User> listUser() throws SQLException {
        return userDao.listUser();
    }

    @Override
    public User searchUser(String name) {
        return userDao.searchUser(name);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void deleteUserByName(String delUser) {
        userDao.deleteUserByName(delUser);
    }

    @Override
    public List<User> searchUsers(String name) {
        return userDao.searchUsers(name);
    }
}
