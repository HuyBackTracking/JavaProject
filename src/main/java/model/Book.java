/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
/**
 *
 * @author Ho Quoc Huy
 */
public class Book {
    private String ISBN;
    private String title;
    private double price;
    private int authorID;

    public Book() {
    }

    public Book(String ISBN, String title, double price, int authorID) {
        this.ISBN = ISBN;
        this.title = title;
        this.price = price;
        this.authorID = authorID;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAuthorID() {
        return authorID;
    }

    public void setAuthorID(int authorID) {
        this.authorID = authorID;
    }

    @Override
    public String toString() {
        return "Book{" + "ISBN=" + ISBN + ", title=" + title + ", price=" + price + ", authorID=" + authorID + '}';
    }

    
    
}
