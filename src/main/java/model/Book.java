package model;

public class Book {

    private String isbn;
    private String title;
//    private String author ;
    private int price;
    private String info;
    private Author author;

    public Book(String isbn, String title, Author author, int price, String info) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.price = price;
        this.info = info;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }


    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Book() {}
}
