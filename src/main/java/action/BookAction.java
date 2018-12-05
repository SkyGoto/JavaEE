package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import model.Author;
import model.Book;
import model.Lend;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import servers.BookServer;
import servers.Impl.BookServerImpl;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class BookAction extends ActionSupport {
    private  static  String STATIC_PATH = "/home/misaki/IdeaProjects/webTest9/out/artifacts/Test4_war_exploded/upLoadFile";
    private BookServer bookServer ;
    private Book book ;
    private Author author;
    private String message;
    private File bookIntro ;
    private String bookIntroFileName;
    private String bookIntroContentType;
    private String bookIntroContent = "";
    private ArrayList<Book> books = new ArrayList<Book>();

    public BookAction() {}
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Book getBook() {
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
    }
    public Author getAuthor() {
        return author;
    }
    public void setAuthor(Author author) {
        this.author = author;
    }
    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }
    public ArrayList<Book> getBooks() {
        return books;
    }
    public File getBookIntro() {
        return bookIntro;
    }
    public void setBookIntro(File bookIntro) {
        this.bookIntro = bookIntro;
    }
    public String getBookIntroFileName() {
        return bookIntroFileName;
    }
    public void setBookIntroFileName(String bookIntroFileName) {
        this.bookIntroFileName = bookIntroFileName;
    }
    public String getBookIntroContentType() {
        return bookIntroContentType;
    }
    public void setBookIntroContentType(String bookIntroContentType) {
        this.bookIntroContentType = bookIntroContentType;
    }
    public String getBookIntroContent() {
        return bookIntroContent;
    }
    public void setBookIntroContent(String bookIntroContent) {
        this.bookIntroContent = bookIntroContent;
    }
    public void setBookServer(BookServer bookServer) {
        this.bookServer = bookServer;
    }

    public String add() {
//        ServletContext sc = ServletActionContext.getServletContext();
//        WebApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sc);
//        BookServer bookServer = (BookServer) ac.getBean("serverBookImpl");

        Map<String, Object> session = ActionContext.getContext().getSession();
        boolean flag = true;
        String type[] = bookIntroFileName.split("\\.");
        String reBookName = bookIntroFileName;
        try {
            if (!type[0].equals("_default")){
                reBookName = "_"+book.getIsbn()+"."+type[type.length-1];
                writeFile(bookIntro,reBookName);
            }
            book.setInfo(reBookName);
            bookServer.insertBook(book,author);
        } catch (SQLException | ClassNotFoundException e) {
            flag = false;
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        message="";
        if (flag) {
            System.out.println("-------------------");
            session.put("fbook",book);
            addActionMessage("成功添加书籍: 书名: "+ book.getTitle()+",作者: "+book.getAuthor().getName()+",价格: "+book.getPrice());
            return "success";
        }else {
            addActionMessage("添加书籍失败!");
            return "error";
        }
    }

    public String findAll(){

//        ServletContext sc = ServletActionContext.getServletContext();
//        WebApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sc);
//        BookServer bookServer = (BookServer) ac.getBean("serverUserImpl");

        List<Book> list = null;
        try {
            list= bookServer.searchAll();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        Map<String, Object> session = ActionContext.getContext().getSession();
        if (list.size() > 0) {
            System.out.println(list);
            session.put("book",list);
            return "success";
        }else {
            return "error";
        }
    }

    public String find() {

        ServletContext sc = ServletActionContext.getServletContext();
        WebApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sc);
        BookServer bookServer = (BookServer) ac.getBean("serverBookImpl");

        List<Book> list=null;
        try {
            list= bookServer.searchBooks(book.getTitle());
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(book.getTitle());
        Map<String, Object> session = ActionContext.getContext().getSession();
        if (list.size() > 0) {
            session.put("book",list);
            return "success";
        }else {
            session.put("book",list);
            addActionMessage("别看了,没有的");
            return "success";
        }

    }

    public String delete() {

        ServletContext sc = ServletActionContext.getServletContext();
        WebApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sc);
        BookServer bookServer = (BookServer) ac.getBean("serverBookImpl");

        String delbook = book.getIsbn();
        System.out.println(book.getIsbn());
        try {
            bookServer.deleteBookByisbn(delbook);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    public String update(){

        ServletContext sc = ServletActionContext.getServletContext();
        WebApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sc);
        BookServer bookServer = (BookServer) ac.getBean("serverBookImpl");

        System.out.println("update = "+book.getAuthor().getName());
        String type[] = bookIntroFileName.split("\\.");
        String reBookName = bookIntroFileName;
        message="";
        try {
            if (!type[0].equals("_default")){
                reBookName = "_"+book.getIsbn()+"."+type[type.length-1];
                writeFile(bookIntro,reBookName);
            }
            book.setInfo(reBookName);
            bookServer.updateBook(book);
        } catch (SQLException | ClassNotFoundException |IOException e) {
            e.printStackTrace();
            return ERROR;
        }
        addActionMessage("成功修改书籍!");
        return "success";
    }


    public String edit(){

        ServletContext sc = ServletActionContext.getServletContext();
        WebApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sc);
        BookServer bookServer = (BookServer) ac.getBean("serverBookImpl");

        String isbn = book.getIsbn();
        Book rebook=null;
        Author reauthor = null;
        try {
            rebook = bookServer.searchBook(isbn);
            reauthor = bookServer.searchAuthor(rebook.getAuthor().getName());
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        Map<String, Object> session = ActionContext.getContext().getSession();
        session.put("rebook",rebook);
        session.put("reauthor",reauthor);
        return "success";
    }

    private void writeFile(File file, String fileName) throws IOException {
        String realPath = STATIC_PATH;
        System.out.println("writefile = "+realPath);
        File tfile = new File(realPath);
        FileUtils.copyFile(file,new File(tfile, fileName));
    }

    private String readFile(String path) throws IOException {
//        String realPath = ServletActionContext.getServletContext().getRealPath("/upLoadFile/_")+path;
        System.out.println("readFile = "+STATIC_PATH+"/"+path);
        File file = new File(STATIC_PATH+"/"+path);
        Long filelength = file.length();
        byte[] filecontent = new byte[filelength.intValue()];
        FileInputStream in = new FileInputStream(file);
        in.read(filecontent);
        in.close();
        return new String(filecontent, "UTF-8");
    }

    public String readBookIntro(){

        ServletContext sc = ServletActionContext.getServletContext();
        WebApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sc);
        BookServer bookServer = (BookServer) ac.getBean("serverBookImpl");

        try {
            book = bookServer.searchBook(book.getIsbn());
            bookIntroContent = readFile(book.getInfo());
            System.out.println(bookIntroContent);
        } catch (IOException e) {
            e.printStackTrace();
            return ERROR;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    public String lendBook(){
        List<Book> list = null;
        list = bookServer.searchLendBook();
        Map<String, Object> session = ActionContext.getContext().getSession();
        if (list.size() > 0) {
            System.out.println(list);
            session.put("lendBook",list);
            return "success";
        }else {
            return "error";
        }
    }

    public String toLendBook() {
        Book book1 = bookServer.toLendBook(book.getIsbn());

        message = "借书成功!"+book1.getTitle();
        System.out.println(message);
        return SUCCESS;
    }

    public String seeLendBook(){
        List<Book> list = null;
        list= bookServer.seeLendBook();
        Map<String, Object> session = ActionContext.getContext().getSession();
        if (list.size() > 0) {
            System.out.println(list);
            session.put("lendedBook",list);
            return "success";
        }else {
            return "error";
        }
    }

    public String lendedBook(){
        Book book1 = bookServer.lendedBook(book.getIsbn());
        message = "还书成功!"+book1.getTitle();
        return SUCCESS;
    }

    protected void finalize() throws java.lang.Throwable {

        ServletContext sc = ServletActionContext.getServletContext();
        WebApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sc);
        BookServer bookServer = (BookServer) ac.getBean("serverBookImpl");

        super.finalize();
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        try {
            bookServer.GCDelete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }
}
