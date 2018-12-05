package model;

import java.util.HashSet;
import java.util.Set;

public class Author {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private  String name;
    private String tel;
    private String email;

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    private Set<Book> books = new HashSet<Book>();


    public Author() {
    }

    public Author(String name, String tel, String email) {
        this.name = name;
        this.tel = tel;
        this.email = email;
    }
}
