package dao;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    /**
     * user login
     * @param name
     * @param password
     * @return
     * @throws SQLException
     */
    User userExist(String name, String password) throws SQLException, ClassNotFoundException;

    User addUser(User user)throws SQLException;

    List<User> listUser() throws SQLException;

    User searchUser(String name);

    void updateUser(User user);

    void deleteUserByName(String delUser);

    List<User> searchUsers(String name);
}
