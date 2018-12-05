package model;

import java.util.Date;

public class Lend {
    private  String bookid;
    private  String name;
    private  String isbn;
    private Date Itime;

    public Lend(String bookid, String name, String isbn, Date itime) {
        this.bookid = bookid;
        this.name = name;
        this.isbn = isbn;
        Itime = itime;
    }

    public Lend() {
    }

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Date getItime() {
        return Itime;
    }

    public void setItime(Date itime) {
        Itime = itime;
    }
}
