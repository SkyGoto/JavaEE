package action;//package action;
//
//import com.opensymphony.xwork2.ActionContext;
//import model.Book;
//import sqlconnect.MysqlCon;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.HashMap;
//import java.util.Map;
//
//
//public class findBookAction {
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    private Book book;
//
//    public Book getBook() {
//        return book;
//    }
//
//    private String title;
//
//    public String find() {
//        MysqlCon mysqlCon = new MysqlCon();
//        ResultSet resultSet = mysqlCon.searchBook(title,"book");
//        Map<String, Integer> map  = new HashMap<String, Integer>() ;
//        try {
//            while (resultSet.next()) {
//                map.put(resultSet.getString(1) , resultSet.getInt(2));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            resultSet = null;
//        }
//        if (map.size() > 0) {
//            Map<String, Object> session = ActionContext.getContext().getSession();
//            session.put("book",map);
//            return "success";
//        }else {
//            return "error";
//        }
//
//    }
//}
