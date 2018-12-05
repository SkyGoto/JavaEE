package util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

public class SqlUtil {

    static ComboPooledDataSource dataSource = null;
    static {
        dataSource = new ComboPooledDataSource();
    }

    public static  DataSource getDataSource(){
        return dataSource;
    }
    /**
     * 获取连接对象
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    /**
     * 释放资源
     * @param conn
     * @param st
     * @param rs
     */
    public static void release(Connection conn , Statement st , ResultSet rs){
        closeRs(rs);
        closeSt(st);
        closeConn(conn);
    }

    public static void release(Connection conn , Statement st){
        closeSt(st);
        closeConn(conn);
    }

    private static void closeRs(ResultSet rs){
        close(rs);
//        try {
//            if(rs != null){
//                rs.close();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally{
//            rs = null;
//        }
    }

    private static void closeSt(Statement st){
        close(st);
//        try {
//            if(st != null){
//                st.close();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally{
//            st = null;
//        }
    }

    private static void closeConn(Connection conn){
        close(conn);
//        try {
//            if(conn != null){
//                conn.close();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally{
//            conn = null;
//        }
    }

    private static <T extends AutoCloseable>void close(T O){
        try {
            if(O != null){
                O.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            O = null;
        }
    }

    /*public static Connection getConnection() throws SQLException, ClassNotFoundException {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1:3306/test1";
        String user = "root";
        String password = "zum";
        Class.forName(driver);
        //连接数据库
        return  DriverManager.getConnection(url, user, password);
    }

    public static void  closeConnection(Connection connection) throws SQLException {
        connection.close();
    }*/
}
