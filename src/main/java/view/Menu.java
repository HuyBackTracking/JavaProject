/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Ho Quoc Huy QE170253
 */
public abstract class Menu{
    public void display(){
        System.out.println("--------TPF MANAGEMENT--------\nMenu:\n"
                + "-----------------");
        for(String s : choices()){
            System.out.println(s);
        }
        System.out.println("-----------------\nYour choice is:");
    }
    
    public abstract String[] choices();
    
    public abstract void execute() throws FileNotFoundException, IOException;
}
