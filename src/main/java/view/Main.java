/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import control.BookAuthorManagement;
import control.DataController;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Author;
import model.Book;
/**
 *
 * @author Ho Quoc Huy
 */
public class Main extends Menu{
    
    Scanner sc = new Scanner(System.in);
    int choice = 0;
        
    DataController controller = new DataController();
    BookAuthorManagement ultility = new BookAuthorManagement();
    
    public boolean end = false;
    //=========================================================================
    private void exit() {
        end = true;
    }
    //==========================================================================
    public void addBookToFile(){
        //String ISBN, String title, double price, int authorID
        String isbn ="", title = "", Price = "", id = "";
        double price = 0;
        int authorID = 0;
        Scanner sc = new Scanner(System.in);
        //ISBN
        do {            
            if(isbn.isEmpty()){
                System.out.println("Enter ISBN:...");
                isbn = sc.nextLine();
            }
        } while (isbn.isEmpty());
        if(ultility.searchByID(isbn) != null){
            System.out.println("The book has been existed!!!");
            return ;
        }
        //Title
        do {            
            if(title.isEmpty()){
                System.out.println("Enter Title:...");
                title = sc.nextLine();
            }
        } while (title.isEmpty());
        //Price
        do {            
            if(Price.isEmpty()){
                System.out.println("Enter Price:...");
                Price = sc.nextLine();
            }
                try {
                    price = Double.parseDouble(Price);
                    if(price < 0){
                        System.out.println("Invalid!!!");
                        Price = "";
                    }
                } catch (Exception e) {
                    System.out.println("Invalid!!!");
                    Price = "";
                }
            
        } while (Price.isEmpty());
        //author ID
        do {            
            if(id.isEmpty()){
                System.out.println("Enter Author ID:...");
                id = sc.nextLine();
            }
                try {
                    authorID = Integer.parseInt(id);
                    if(authorID < 0){
                        System.out.println("Invalid!!!");
                        id ="";
                    }
                } catch (Exception e) {
                    System.out.println("Invalid!!!");
                    id = "";
                }
            
        } while (id.isEmpty());
         if(ultility.searchByauthor(authorID) == null){
            System.out.println("The author has not been existed!!!");
            return ;
        }
        ultility.addBookToList(new Book(isbn, title, price, authorID));
        System.out.println("You have added successful!!!");
    }
    //==========================================================================
    public void show(){
        System.out.println("--------------------LIST BOOK----------------------");
        for(Book b : ultility.listBook){
            System.out.println(b);
        }
        System.out.println("---------------------------------------------------");
    }
    //==========================================================================
    public void showAuthor(){
        System.out.println("------------------LIST AUTHOR----------------------");
        for(Author a : ultility.listAuthor){
            System.out.println(a);
        }
        System.out.println("---------------------------------------------------");
    }
    //==========================================================================
    public void deleteBook(){
        //ISBN
        String isbn ="";
        do {            
            if(isbn.isEmpty()){
                System.out.println("Enter ISBN:...");
                isbn = sc.nextLine();
            }
        } while (isbn.isEmpty());
        Book b = ultility.searchByID(isbn) ;
        if(b == null){
            System.out.println("The book has not been existed!!!");
            return;
        }
        else ultility.deleteBookToList(b);
        System.out.println("Delete successful!!!");
    }
    //==========================================================================
    public void deleteAuthor(){
        //author ID
        String id ="";
        int authorID = 0;
        do {            
            if(id.isEmpty()){
                System.out.println("Enter Author ID:...");
                id = sc.nextLine();
            }
                try {
                    authorID = Integer.parseInt(id);
                    if(authorID < 0){
                        System.out.println("Invalid!!!");
                        id ="";
                    }
                } catch (Exception e) {
                    System.out.println("Invalid!!!");
                    id = "";
                }
            
        }while(id.isEmpty());
        Author a = ultility.searchByauthor(authorID);
        if(a == null){
            System.out.println("The author has not been existed!!!");
            return;
        }else ultility.deleteAuthorToList(a);
        System.out.println("Delete successful!!!");
    }
    //==========================================================================
    public void searchByBookTitle(){
        System.out.println("Enter your pattern:");
        String title = sc.nextLine();
        ultility.SearchByBookTitle(title);
    }
    //==========================================================================
    public void searchBookByAuthorName() throws Exception{
        System.out.println("Enter your pattern:");
        String aName = sc.nextLine();
        ArrayList<Book> res = new ArrayList<>();
        for(int i = 0; i < ultility.SeachByauthorNames(aName).size(); i++){
            for(int j = 0; j < ultility.listBook.size(); j++){
                if(ultility.listBook.get(j).getAuthorID() == 
                        ultility.SeachByauthorNames(aName).get(i)){
                    res.add(ultility.listBook.get(j));
                }
            }
        }
        if(res.size() == 0) System.out.println("Sorry,Can not find!!!");
        else{
            for(Book b : res){
                System.out.println(b);
            }
        }
    }
    //==========================================================================
    public Book GetUpdateBook()
    {
        String isbn;
        System.out.println("Enter the book ISBN which you want to update:");
        isbn = sc.nextLine().toUpperCase();
        for(Book b : ultility.listBook){
            if(b.getISBN().toUpperCase().equals(isbn)){            
                return b;
            }}
         return null;
    }
    
    //==========================================================================
    public void update(Book b){
                
        if(b == null)
        {  System.out.println("Not found ISBN to update"); return;}
                String temp;
                //String ISBN, String title, double price, int authorID
                
                //change ISBN
                System.out.println("Enter a new ISBN:");
                temp = sc.nextLine().toUpperCase();
                if(temp == "" && temp.isBlank()) 
                    System.out.println("ISBN have not been changed!");
                else{
                    b.setISBN(temp);
                    }
                
                //change title
                System.out.println("Enter a new title:");
                temp = sc.nextLine();
                if(temp == "" && temp.isBlank()) 
                    System.out.println("Title have not been changed!");
                else{
                    b.setTitle(temp);
                    
                }
                //change price
                System.out.println("Enter a new price:");
                temp = sc.nextLine();
                double price = -1;
                do {            
                    if(temp == "" && temp.isBlank()) 
                    {System.out.println("Price have not been changed!"); break;}
                else{
                    do {     
                        try {
                            price = Double.parseDouble(temp);
                            if(price < 0){
                                System.out.println("Invalid!!!, Enter again");
                                temp = sc.nextLine();
                            }
                            else
                            {b.setPrice(price);break;}
                        } catch (Exception e) {
                            System.out.println("Invalid!!!, Enter again");
                            temp = sc.nextLine();
                }
                } while (true);}
                } while(temp.isEmpty());
                    
                
                //change authorID
                System.out.println("Enter a new author ID:");
                temp  = sc.nextLine();
                int auID= -1;
                do {            
                    if(temp == "" && temp.isBlank()) 
                    {System.out.println("Author ID have not been changed!"); break;}
                else{
                    do {     
                        try {
                            auID = Integer.parseInt(temp);
                            if(auID < 0){
                                System.out.println("Invalid!!!, Enter again");
                                temp = sc.nextLine();
                            }
                            else if(GetAuID(auID) == -1)
                            {
                                System.out.println("Not Found Author!!, Enter again  ");
                                temp = sc.nextLine();
                            }
                            else 
                            {b.setAuthorID(auID);break;}
                        } catch (Exception e) {
                            System.out.println("Invalid!!!, Enter again");
                            temp = sc.nextLine();
                }
                } while (true);}
                } while(temp.isEmpty());
                System.out.println("Update successfully");
                 
        
    }
    //==========================================================================
    public int GetAuID(int i)
    {
        for(Author a : ultility.listAuthor)
        {
            if(a.getAuthorID()== i) return a.getAuthorID();
        }
        
        return -1;
    }
    //==========================================================================
    public void search() throws Exception{
        Menu x = new Menu() {
            @Override
            public String[] choices() {
                return new String[]{
           "1. Searh by title:...",
           "2. Search by authorName:...",
           "0. Quit."
        };
            }

            @Override
            public void execute() throws FileNotFoundException, IOException {
                try {
                    Scanner sc = new Scanner(System.in);
                    int choice = 0;
                    choice = sc.nextInt();
                    sc.nextLine();
                    switch(choice){
                        case 1:
                            searchByBookTitle();
                            break;
                        case 2:
                            searchBookByAuthorName();
                            break;
                        case 0:
                            System.out.println("Back to main Menu!!!");
                            break;
                    }
                } catch (Exception ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        x.display();
        x.execute();
    }
    //==========================================================================
    @Override
    public String[] choices() {
        return new String[]{
           "1. Show the book list",
           "2. Add a new Book",
           "3. Update a book",
           "4. Delete a book",
           "5. Store data to file",
           "6. Search for a book",
           "7. Delete author",
           "8. Show the author list",
           "0. Quit."
        };
    }

    @Override
    public void execute() throws FileNotFoundException, IOException {
        choice = sc.nextInt();
        sc.nextLine();
        switch(choice){
            case 0:
                System.out.println("Thank you for using!!!");
                exit();
                break;
            case 1:
                show();
                break;
            case 2:
                addBookToFile();
                break;
            case 3:
                update(GetUpdateBook());
                break;
            case 4:
                deleteBook();
                break;
            case 5:
                for(int i = 0; i < ultility.listBook.size(); i++){
                    controller.writeBookToFile(ultility.listBook.get(i),
                            ultility.bookFileName);
                    }
                    System.out.println("You have saved list to file successful!");
                    break;
            case 6:
                try {
                    search();
                } catch (Exception ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case 7:
                deleteAuthor();
                break;
            case 8:
                showAuthor();
                break;
        }
    }

    //==============================================================================
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        while(main.end == false){
            main.display();
            main.execute();
        };
    }

}

