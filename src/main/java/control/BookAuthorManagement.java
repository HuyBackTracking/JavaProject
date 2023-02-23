/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.util.ArrayList;
import model.Author;
import model.Book;

/**
 *
 * @author Ho Quoc Huy
 */
public class BookAuthorManagement {
    public ArrayList<Book> listBook = new ArrayList<>();
    public ArrayList<Author> listAuthor = new ArrayList<>();
    DataController dc = new DataController();
    public String bookFileName = "book.dat";
    public String authorFileName = "author.dat";
    
    //==========================================================================
    public BookAuthorManagement() {
        listBook = dc.readBookFromFile(bookFileName);
        listAuthor = dc.readAuthorFromFile(authorFileName);
    }
    //==========================================================================
    public void addBookToList(Book book){
        listBook.add(book);
    }
    //==========================================================================
    public Book searchByID(String ISBN){
        for(Book b : listBook){
            if(b.getISBN().toUpperCase().equals(ISBN.toUpperCase())){
                return b;
            }
        }
        return null;
    }
    //==========================================================================
    public void SearchByBookTitle(String title) {
    ArrayList<Book> result = new ArrayList<>();
        for (Book b : listBook) {
            if(b.getTitle().contains(title)){
                result.add(b);
            }
        }
        if(result.size() == 0) System.out.println("Sorry,Can not find!!!");
        else{
            for(Book v : result){
                System.out.println(v);
            }
        }
    }
    //==========================================================================
    public ArrayList<Integer> SeachByauthorNames(String name){
        ArrayList<Integer> result = new ArrayList<>();
        for(Author a : listAuthor){
            if(a.getAuthorName().contains(name) 
            || a.getAuthorName().toUpperCase().contains(name.toUpperCase())){
                result.add(a.getAuthorID());
            }
        }
        if(result.size() == 0) return null;
        return result;
    }
    //==========================================================================
    public Author searchByauthor(int id){
        for(Author a : listAuthor){
            if(a.getAuthorID() == id){
                return a;
            }
        }
        return null;
    }
    //==========================================================================
    public void deleteBookToList(Book book){
        listBook.remove(book);
    }
    //==========================================================================
    public void deleteAuthorToList(Author author){
        listAuthor.remove(author);
    }
    //==========================================================================
}
