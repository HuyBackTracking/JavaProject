/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import model.Author;
import model.Book;

/**
 *
 * @author Ho Quoc Huy
 */
public class DataController {
    private FileWriter fileWriter;
    private BufferedWriter bufferedWriter;
    private PrintWriter printWriter;
    private Scanner scanner;
//------------------------------------------------------------------------------
    public void openFileToWrite(String fileName){
        try {
            fileWriter = new FileWriter(fileName, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            printWriter = new PrintWriter(bufferedWriter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void closeFileAfterWrite(String fileName){
        try{
        printWriter.close();
        bufferedWriter.close();
        fileWriter.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
//------------------------------------------------------------------------------
    public void writeBookToFile(Book book, String fileName){
        //String ISBN, String title, double price, int authorID
        openFileToWrite(fileName);
        printWriter.println(book.getISBN() + "|" + book.getTitle() + "|" 
                + book.getPrice() + "|" + book.getAuthorID());
        closeFileAfterWrite(fileName);
    }
//------------------------------------------------------------------------------
    public void openFileToRead(String fileName){
        
        try {
            File file = new File(fileName);
            if(!file.exists()){
                file.createNewFile();
            }
            scanner = new Scanner(Paths.get(fileName), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void closeFileAterRead(String fileName){
        try {
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//------------------------------------------------------------------------------
    public Book createBookFromData(String data){
        //String ISBN, String title, double price, int authorID
        String[] Data = data.split("\\|");
        Book book = new Book(Data[0], Data[1], Double.parseDouble(Data[2]), 
            Integer.parseInt(Data[3]));
        return book;
    }
    public Author createAuthorFromData(String data){
        //int authorID, String authorName
        String[] Data = data.split("\\|");
        Author author = new Author(Integer.parseInt(Data[0]), Data[1]);
        return author;
    }
//------------------------------------------------------------------------------
    public ArrayList<Book> readBookFromFile(String fileName){
        openFileToRead(fileName);
        ArrayList<Book> books = new ArrayList<>();
        while(scanner.hasNextLine()){
            String data = scanner.nextLine();
            Book book = createBookFromData(data);
            books.add(book);
        }
        closeFileAterRead(fileName);
        return books;
    }
    
    public ArrayList<Author> readAuthorFromFile(String fileName){
        openFileToRead(fileName);
        ArrayList<Author> authors = new ArrayList<>();
        while(scanner.hasNextLine()){
            String data = scanner.nextLine();
            Author author = createAuthorFromData(data);
            authors.add(author);
        }
        closeFileAterRead(fileName);
        return authors;
    }   
}
