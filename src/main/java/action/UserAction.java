package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import model.User;
import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import servers.Impl.UserServerImpl;
import servers.UserServer;

import javax.servlet.ServletContext;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class UserAction extends ActionSupport {
    private User user ;
    private UserServer userServer ;
    public UserAction() {}
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public void setUserServer(UserServer userServer) {
        this.userServer = userServer;
    }
    public UserServer getUserServer() {
        return userServer;
    }


    public String login() throws Exception {
        System.out.println(userServer+"----------------------");
//        ServletContext sc = ServletActionContext.getServletContext();
//        WebApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sc);
//        UserServer userServer = (UserServer) ac.getBean("serverUserImpl");
        User user1 = userServer.userExist(user.getName(),user.getPassword());
        Map<String, Object> session = ActionContext.getContext().getSession();

        if (user1 == null) return ERROR;
        else{
            user = user1;
            session.put("nowUser",user);
            return "success";
        }
    }


    public void validateLogin(){
        System.out.println("validatelogin");
    }

    public void validate() {
//        if (user != null ) {
////            addFieldError("","退出");
//            if ((user.getName() == null && user.getPassword() == null) || ("".equals(user.getName()) && "".equals(user.getPassword()))) {
//                addFieldError("user.name","姓名不能为空");
//                addFieldError("user.password","密码不能为空");
//            }else if (user.getName() == null || "".equals(user.getName())) {
//                addFieldError("user.name","姓名不能为空");
//            }else if ("".equals(user.getPassword()) || (user.getPassword() == null )){
//                addFieldError("user.password","密码不能为空");
//            }else {
//                ;
//            }
//        }

    }

    public String home() {
        Map<String, Object> session = ActionContext.getContext().getSession();
        user = (User)session.get("nowUser");
        return SUCCESS;
    }

    public String logout() {
        System.out.println("34235234543");
        Map<String, Object> session = ActionContext.getContext().getSession();
        if (session.get("user") != null) {
            session.remove("user");
            return "success";
        } else  {
            return "error";
        }
    }

    public String addUser() {
        User user1=null;
        try {
            user1= userServer.addUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        user = user1==null?user:user1;
        addActionMessage("成功添加"+user.getName()+" "+user.getRole());
        return SUCCESS;


    }

    public String listUser(){
        List<User> list = null;
        try {
            list= userServer.listUser();
        } catch (SQLException  e) {
            e.printStackTrace();
        }
        Map<String, Object> session = ActionContext.getContext().getSession();
        if (list.size() > 0) {
            System.out.println(list);
            session.put("user",list);
            return "success";
        }else {
            return "error";
        }
    }

    public String editUser(){

//        ServletContext sc = ServletActionContext.getServletContext();
//        WebApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sc);
//        BookServer bookServer = (BookServer) ac.getBean("serverBookImpl");

        String name = user.getName();
        User reUser=null;
        reUser = userServer.searchUser(name);
        System.out.println("editUser = "+reUser);
        Map<String, Object> session = ActionContext.getContext().getSession();
        session.put("reUser",reUser);
        return SUCCESS;
    }

    public String updateUser(){
//        ServletContext sc = ServletActionContext.getServletContext();
//        WebApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sc);
//        BookServer bookServer = (BookServer) ac.getBean("serverBookImpl");
        userServer.updateUser(user);
        addActionMessage("成功修改书籍!");
        return "success";
    }

    public String deleteUser() {

//        ServletContext sc = ServletActionContext.getServletContext();
//        WebApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sc);
//        BookServer bookServer = (BookServer) ac.getBean("serverBookImpl");

        String delUser = user.getName();
        userServer.deleteUserByName(delUser);
        return "success";
    }

    public String findUser() {

//        ServletContext sc = ServletActionContext.getServletContext();
//        WebApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sc);
//        BookServer bookServer = (BookServer) ac.getBean("serverBookImpl");

        List<User> list=null;
        list= userServer.searchUsers(user.getName());
        Map<String, Object> session = ActionContext.getContext().getSession();
        if (list.size() > 0) {
            session.put("user",list);
            return "success";
        }else {
            session.put("user",list);
            addActionMessage("别看了,没有的");
            return "success";
        }

    }

}
